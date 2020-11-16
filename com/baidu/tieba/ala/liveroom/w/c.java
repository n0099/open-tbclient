package com.baidu.tieba.ala.liveroom.w;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.d;
import com.baidu.live.data.aj;
import com.baidu.live.data.w;
import com.baidu.live.message.GetSuperCustomerInfoHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.k;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    private w aIK;
    private Dialog ben;
    private boolean bep;
    public aj bmB;
    private Context context;
    private AnimatorSet hiv;
    private View mContentView;
    private boolean hiw = false;
    private Handler handler = new Handler();
    private boolean hix = false;
    private boolean hiy = false;
    public boolean hsI = false;
    public boolean hsJ = false;
    private HttpMessageListener bst = new HttpMessageListener(1021186) { // from class: com.baidu.tieba.ala.liveroom.w.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021186 && (httpResponsedMessage instanceof GetSuperCustomerInfoHttpResponseMessage) && c.this.context != null) {
                if (httpResponsedMessage.getError() == 0) {
                    GetSuperCustomerInfoHttpResponseMessage getSuperCustomerInfoHttpResponseMessage = (GetSuperCustomerInfoHttpResponseMessage) httpResponsedMessage;
                    if (getSuperCustomerInfoHttpResponseMessage.NC() != null) {
                        c.this.bmB = getSuperCustomerInfoHttpResponseMessage.NC();
                        b.cgG().bmB = c.this.bmB;
                        c.this.Au();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "refreshInfo"));
                    }
                }
            }
        }
    };
    private CustomMessageListener biW = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.w.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage.getData() instanceof String) && c.this.context != null) {
                String str = (String) customResponsedMessage.getData();
                if ("consumeSuc".equals(str) && !c.this.hsJ) {
                    c.this.hsJ = true;
                    BdLog.d("consumeSuc");
                    c.this.a(c.this.aIK, c.this.aIK.aHG.userId);
                }
                if ("chargeSuc".equals(str) && !c.this.hsI) {
                    BdLog.d("chargeSuc");
                    c.this.hsI = true;
                    c.this.a(c.this.aIK, c.this.aIK.aHG.userId);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext) {
        this.context = tbPageContext.getPageActivity();
        this.bst.setTag(tbPageContext.getUniqueId());
        this.biW.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bst);
        MessageManager.getInstance().registerListener(this.biW);
    }

    public void bw(boolean z) {
        this.bep = z;
        if (z) {
            GM();
        }
    }

    public void a(w wVar, long j) {
        this.aIK = wVar;
        HttpMessage httpMessage = new HttpMessage(1021186);
        httpMessage.addParam("user_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
        BdLog.d("requestSuperCustomerInfoMessage user_id:" + j);
    }

    public void GM() {
        if (this.ben != null && this.ben.isShowing()) {
            Context context = this.ben.getContext();
            if (context != null) {
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    if (Build.VERSION.SDK_INT >= 17) {
                        if (activity.isDestroyed() || activity.isFinishing()) {
                            return;
                        }
                    } else if (activity.isFinishing()) {
                        return;
                    }
                }
                this.ben.dismiss();
            } else {
                return;
            }
        }
        this.ben = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Au() {
        JSONArray jSONArray;
        if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aIK != null && this.aIK.aHG != null && !this.bep) {
            if (this.aIK.mLiveInfo == null || this.aIK.mLiveInfo.screen_direction != 2) {
                BdLog.d("deal--isTiming:" + this.hiw);
                if (!this.hiw && TbadkCoreApplication.isLogin() && this.bmB != null && this.bmB.aIO != 1 && !TextUtils.isEmpty(this.bmB.aGz)) {
                    int i = this.bmB.limit;
                    String string = d.Aq().getString("super_constomer_show_trace_monthly", "");
                    BdLog.d("deal-- trace:" + string);
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            jSONArray = new JSONArray(string);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONArray jSONArray2 = jSONArray;
                        if (i == 0) {
                            final ArrayList<a> arrayList = new ArrayList();
                            if (jSONArray2 != null) {
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    arrayList.add(new a().dN(jSONArray2.optJSONObject(i2)));
                                }
                            }
                            for (a aVar : arrayList) {
                                if (aVar != null && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.uid)) {
                                    Date iy = k.iy(aVar.date);
                                    if (iy == null) {
                                        break;
                                    } else if (!k.d(iy)) {
                                        if (k.c(iy) && aVar.dFf >= i) {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                            int i3 = this.bmB.aIN;
                            if (i3 <= 0) {
                                i3 = 20;
                            }
                            BdLog.d("deal--postDelayed");
                            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.w.c.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    BdLog.d("deal--postDelayed run");
                                    if (c.this.context instanceof Activity) {
                                        Activity activity = (Activity) c.this.context;
                                        if (Build.VERSION.SDK_INT >= 17) {
                                            if (activity.isDestroyed() || activity.isFinishing()) {
                                                return;
                                            }
                                        } else if (activity.isFinishing()) {
                                            return;
                                        }
                                    }
                                    if (c.this.aIK != null && c.this.aIK.aHG != null) {
                                        c.this.a(c.this.context, c.this.bmB);
                                        c.this.a(arrayList, c.this.bmB);
                                    }
                                }
                            }, i3 * 1000);
                            this.hiw = true;
                            return;
                        }
                        return;
                    }
                    jSONArray = null;
                    JSONArray jSONArray22 = jSONArray;
                    if (i == 0) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final aj ajVar) {
        if (!this.bep) {
            GM();
            View inflate = LayoutInflater.from(context).inflate(a.g.dialog_super_customer, (ViewGroup) null);
            final Dialog dialog = new Dialog(context, a.i.FlowerGuideDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(false);
            this.mContentView = inflate;
            this.ben = dialog;
            inflate.findViewById(a.f.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.w.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    try {
                        c.this.GM();
                        if (c.this.aIK != null && c.this.aIK.mLiveInfo != null) {
                            String str2 = ajVar.aGz;
                            if (!TextUtils.isEmpty(str2)) {
                                if (str2.contains("?")) {
                                    str = str2 + "&live_id=" + c.this.aIK.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str2 + "?live_id=" + c.this.aIK.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(context, str)));
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "largebag_clk").setContentExt(null, "popup", null));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.w.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        c.this.GM();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.w.c.6
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    BdLog.d("dialog onShow 播放动画");
                    if (c.this.hiv != null) {
                        c.this.hiv.start();
                    }
                }
            });
            BdLog.d("dialog setOnDismissListener");
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.w.c.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    BdLog.d("dialog 停止动画");
                    if (c.this.hiv != null) {
                        c.this.hiv.cancel();
                    }
                    c.this.hiw = false;
                }
            });
            TbImageView tbImageView = (TbImageView) inflate.findViewById(a.f.super_bg);
            tbImageView.setDefaultBgResource(a.e.sdk_shape_transparent);
            tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.w.c.8
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onComplete(String str, boolean z) {
                    BdLog.d("dialog imageView onComplete");
                    try {
                        if (context instanceof Activity) {
                            BdLog.d("dialog imageView context instanceof Activity");
                            Activity activity = (Activity) context;
                            if (Build.VERSION.SDK_INT >= 17) {
                                if (activity.isDestroyed() || activity.isFinishing()) {
                                    return;
                                }
                            } else if (activity.isFinishing()) {
                                return;
                            }
                            if (c.this.aIK != null && dialog != null && !dialog.isShowing()) {
                                BdLog.d("dialog.show()");
                                dialog.show();
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "largebag_show").setContentExt(null, "popup", null));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            if (!TextUtils.isEmpty(ajVar.picUrl)) {
                BdLog.d("picUrl:" + ajVar.picUrl);
                tbImageView.startLoad(ajVar.picUrl, 10, false);
            }
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(a.f.super_entry);
            tbImageView2.setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TextUtils.isEmpty(ajVar.aIQ)) {
                tbImageView2.startLoad(ajVar.aIQ, 10, false);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
            ofFloat.setRepeatCount(-1);
            ofFloat2.setRepeatCount(-1);
            this.hiv = new AnimatorSet();
            this.hiv.play(ofFloat).with(ofFloat2);
            this.hiv.setInterpolator(new AccelerateDecelerateInterpolator());
            this.hiv.setDuration(2000L);
            this.hiv.setStartDelay(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<a> list, aj ajVar) {
        int i;
        boolean z;
        int i2;
        if (ajVar != null) {
            try {
                i = ajVar.limit;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        } else {
            i = 0;
        }
        if (i >= 0) {
            if (list == null) {
                list = new ArrayList<>();
            }
            Iterator<a> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                a next = it.next();
                if (next != null && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(next.uid)) {
                    if (k.c(k.iy(next.date))) {
                        i2 = next.dFf + 1;
                        next.dFf = i2;
                    } else {
                        i2 = 1;
                    }
                    next.dFf = i2;
                    next.date = k.b(new Date());
                    z = true;
                }
            }
            if (!z) {
                a aVar = new a();
                aVar.uid = TbadkCoreApplication.getCurrentAccount();
                aVar.date = k.b(new Date());
                aVar.dFf = 1;
                list.add(aVar);
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar2 : list) {
                jSONArray.put(new JSONObject(aVar2.toJsonString()));
            }
            d.Aq().putString("super_constomer_show_trace_monthly", jSONArray.toString());
        }
    }

    public void onResume() {
        if (this.hiy || !this.hix || this.context == null || this.aIK == null || this.aIK.aHG == null) {
        }
    }

    public void release() {
        this.hiw = false;
        this.aIK = null;
        this.hsI = false;
        this.hsJ = false;
        this.handler.removeCallbacksAndMessages(null);
        GM();
        this.bmB = null;
        b.cgG().bmB = null;
        if (this.hiv != null) {
            this.hiv.cancel();
            this.hiv = null;
        }
        this.context = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}

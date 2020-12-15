package com.baidu.tieba.ala.liveroom.v;

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
import com.baidu.live.data.ak;
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
    private w aLD;
    private Dialog biC;
    private boolean biE;
    public ak brJ;
    private Context context;
    private AnimatorSet hrY;
    private View mContentView;
    private boolean hrZ = false;
    private Handler handler = new Handler();
    private boolean hsa = false;
    private boolean hsb = false;
    public boolean hCo = false;
    public boolean hCp = false;
    private HttpMessageListener bxC = new HttpMessageListener(1021186) { // from class: com.baidu.tieba.ala.liveroom.v.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021186 && (httpResponsedMessage instanceof GetSuperCustomerInfoHttpResponseMessage) && c.this.context != null) {
                if (httpResponsedMessage.getError() == 0) {
                    GetSuperCustomerInfoHttpResponseMessage getSuperCustomerInfoHttpResponseMessage = (GetSuperCustomerInfoHttpResponseMessage) httpResponsedMessage;
                    if (getSuperCustomerInfoHttpResponseMessage.PV() != null) {
                        c.this.brJ = getSuperCustomerInfoHttpResponseMessage.PV();
                        b.ckB().brJ = c.this.brJ;
                        c.this.BQ();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "refreshInfo"));
                    }
                }
            }
        }
    };
    private CustomMessageListener bno = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.v.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage.getData() instanceof String) && c.this.context != null) {
                String str = (String) customResponsedMessage.getData();
                if ("consumeSuc".equals(str) && !c.this.hCp) {
                    c.this.hCp = true;
                    BdLog.d("consumeSuc");
                    c.this.a(c.this.aLD, c.this.aLD.aKr.userId);
                }
                if ("chargeSuc".equals(str) && !c.this.hCo) {
                    BdLog.d("chargeSuc");
                    c.this.hCo = true;
                    c.this.a(c.this.aLD, c.this.aLD.aKr.userId);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext) {
        this.context = tbPageContext.getPageActivity();
        this.bxC.setTag(tbPageContext.getUniqueId());
        this.bno.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bxC);
        MessageManager.getInstance().registerListener(this.bno);
    }

    public void bF(boolean z) {
        this.biE = z;
        if (z) {
            ID();
        }
    }

    public void a(w wVar, long j) {
        this.aLD = wVar;
        HttpMessage httpMessage = new HttpMessage(1021186);
        httpMessage.addParam("user_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
        BdLog.d("requestSuperCustomerInfoMessage user_id:" + j);
    }

    public void ID() {
        if (this.biC != null && this.biC.isShowing()) {
            Context context = this.biC.getContext();
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
                this.biC.dismiss();
            } else {
                return;
            }
        }
        this.biC = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void BQ() {
        JSONArray jSONArray;
        if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aLD != null && this.aLD.aKr != null && !this.biE) {
            if (this.aLD.mLiveInfo == null || this.aLD.mLiveInfo.screen_direction != 2) {
                BdLog.d("deal--isTiming:" + this.hrZ);
                if (!this.hrZ && TbadkCoreApplication.isLogin() && this.brJ != null && this.brJ.aLH != 1 && !TextUtils.isEmpty(this.brJ.aJj)) {
                    int i = this.brJ.limit;
                    String string = d.BM().getString("super_constomer_show_trace_monthly", "");
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
                                    arrayList.add(new a().dP(jSONArray2.optJSONObject(i2)));
                                }
                            }
                            for (a aVar : arrayList) {
                                if (aVar != null && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.uid)) {
                                    Date jc = k.jc(aVar.date);
                                    if (jc == null) {
                                        break;
                                    } else if (!k.d(jc)) {
                                        if (k.c(jc) && aVar.dMd >= i) {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                            int i3 = this.brJ.aLG;
                            if (i3 <= 0) {
                                i3 = 20;
                            }
                            BdLog.d("deal--postDelayed");
                            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.v.c.3
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
                                    if (c.this.aLD != null && c.this.aLD.aKr != null) {
                                        c.this.a(c.this.context, c.this.brJ);
                                        c.this.a(arrayList, c.this.brJ);
                                    }
                                }
                            }, i3 * 1000);
                            this.hrZ = true;
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
    public void a(final Context context, final ak akVar) {
        if (!this.biE) {
            ID();
            View inflate = LayoutInflater.from(context).inflate(a.g.dialog_super_customer, (ViewGroup) null);
            final Dialog dialog = new Dialog(context, a.i.FlowerGuideDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(false);
            this.mContentView = inflate;
            this.biC = dialog;
            inflate.findViewById(a.f.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.v.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    try {
                        c.this.ID();
                        if (c.this.aLD != null && c.this.aLD.mLiveInfo != null) {
                            String str2 = akVar.aJj;
                            if (!TextUtils.isEmpty(str2)) {
                                if (str2.contains("?")) {
                                    str = str2 + "&live_id=" + c.this.aLD.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str2 + "?live_id=" + c.this.aLD.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
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
            ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.v.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        c.this.ID();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.v.c.6
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    BdLog.d("dialog onShow 播放动画");
                    if (c.this.hrY != null) {
                        c.this.hrY.start();
                    }
                }
            });
            BdLog.d("dialog setOnDismissListener");
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.v.c.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    BdLog.d("dialog 停止动画");
                    if (c.this.hrY != null) {
                        c.this.hrY.cancel();
                    }
                    c.this.hrZ = false;
                }
            });
            TbImageView tbImageView = (TbImageView) inflate.findViewById(a.f.super_bg);
            tbImageView.setDefaultBgResource(a.e.sdk_shape_transparent);
            tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.v.c.8
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
                            if (c.this.aLD != null && dialog != null && !dialog.isShowing()) {
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
            if (!TextUtils.isEmpty(akVar.picUrl)) {
                BdLog.d("picUrl:" + akVar.picUrl);
                tbImageView.startLoad(akVar.picUrl, 10, false);
            }
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(a.f.super_entry);
            tbImageView2.setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TextUtils.isEmpty(akVar.aLJ)) {
                tbImageView2.startLoad(akVar.aLJ, 10, false);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
            ofFloat.setRepeatCount(-1);
            ofFloat2.setRepeatCount(-1);
            this.hrY = new AnimatorSet();
            this.hrY.play(ofFloat).with(ofFloat2);
            this.hrY.setInterpolator(new AccelerateDecelerateInterpolator());
            this.hrY.setDuration(2000L);
            this.hrY.setStartDelay(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<a> list, ak akVar) {
        int i;
        boolean z;
        int i2;
        if (akVar != null) {
            try {
                i = akVar.limit;
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
                    if (k.c(k.jc(next.date))) {
                        i2 = next.dMd + 1;
                        next.dMd = i2;
                    } else {
                        i2 = 1;
                    }
                    next.dMd = i2;
                    next.date = k.b(new Date());
                    z = true;
                }
            }
            if (!z) {
                a aVar = new a();
                aVar.uid = TbadkCoreApplication.getCurrentAccount();
                aVar.date = k.b(new Date());
                aVar.dMd = 1;
                list.add(aVar);
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar2 : list) {
                jSONArray.put(new JSONObject(aVar2.toJsonString()));
            }
            d.BM().putString("super_constomer_show_trace_monthly", jSONArray.toString());
        }
    }

    public void onResume() {
        if (this.hsb || !this.hsa || this.context == null || this.aLD == null || this.aLD.aKr == null) {
        }
    }

    public void release() {
        this.hrZ = false;
        this.aLD = null;
        this.hCo = false;
        this.hCp = false;
        this.handler.removeCallbacksAndMessages(null);
        ID();
        this.brJ = null;
        b.ckB().brJ = null;
        if (this.hrY != null) {
            this.hrY.cancel();
            this.hrY = null;
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

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
import com.baidu.live.data.af;
import com.baidu.live.data.u;
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
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    private u aFP;
    private Dialog aZV;
    private boolean aZX;
    public af bhH;
    private Context context;
    private AnimatorSet gCM;
    private View mContentView;
    private boolean gCN = false;
    private Handler handler = new Handler();
    private boolean gCO = false;
    private boolean gCP = false;
    public boolean gMq = false;
    public boolean gMr = false;
    private HttpMessageListener bnf = new HttpMessageListener(1021186) { // from class: com.baidu.tieba.ala.liveroom.w.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021186 && (httpResponsedMessage instanceof GetSuperCustomerInfoHttpResponseMessage) && c.this.context != null) {
                if (httpResponsedMessage.getError() == 0) {
                    GetSuperCustomerInfoHttpResponseMessage getSuperCustomerInfoHttpResponseMessage = (GetSuperCustomerInfoHttpResponseMessage) httpResponsedMessage;
                    if (getSuperCustomerInfoHttpResponseMessage.Mm() != null) {
                        c.this.bhH = getSuperCustomerInfoHttpResponseMessage.Mm();
                        b.bYg().bhH = c.this.bhH;
                        c.this.AV();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "refreshInfo"));
                    }
                }
            }
        }
    };
    private CustomMessageListener bee = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.w.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage.getData() instanceof String) && c.this.context != null) {
                String str = (String) customResponsedMessage.getData();
                if ("consumeSuc".equals(str) && !c.this.gMr) {
                    c.this.gMr = true;
                    BdLog.d("consumeSuc");
                    c.this.a(c.this.aFP, c.this.aFP.aFb.userId);
                }
                if ("chargeSuc".equals(str) && !c.this.gMq) {
                    BdLog.d("chargeSuc");
                    c.this.gMq = true;
                    c.this.a(c.this.aFP, c.this.aFP.aFb.userId);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext) {
        this.context = tbPageContext.getPageActivity();
        this.bnf.setTag(tbPageContext.getUniqueId());
        this.bee.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bnf);
        MessageManager.getInstance().registerListener(this.bee);
    }

    public void bn(boolean z) {
        this.aZX = z;
        if (z) {
            FD();
        }
    }

    public void a(u uVar, long j) {
        this.aFP = uVar;
        HttpMessage httpMessage = new HttpMessage(1021186);
        httpMessage.addParam("user_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
        BdLog.d("requestSuperCustomerInfoMessage user_id:" + j);
    }

    public void FD() {
        if (this.aZV != null && this.aZV.isShowing()) {
            Context context = this.aZV.getContext();
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
                this.aZV.dismiss();
            } else {
                return;
            }
        }
        this.aZV = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void AV() {
        JSONArray jSONArray;
        if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aFP != null && this.aFP.aFb != null && !this.aZX) {
            if (this.aFP.mLiveInfo == null || this.aFP.mLiveInfo.screen_direction != 2) {
                BdLog.d("deal--isTiming:" + this.gCN);
                if (!this.gCN && TbadkCoreApplication.isLogin() && this.bhH != null && this.bhH.aFT != 1 && !TextUtils.isEmpty(this.bhH.aEb)) {
                    int i = this.bhH.limit;
                    String string = com.baidu.live.c.AR().getString("super_constomer_show_trace_monthly", "");
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
                                    arrayList.add(new a().dD(jSONArray2.optJSONObject(i2)));
                                }
                            }
                            for (a aVar : arrayList) {
                                if (aVar != null && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.uid)) {
                                    Date hD = k.hD(aVar.date);
                                    if (hD == null) {
                                        break;
                                    } else if (!k.d(hD)) {
                                        if (k.c(hD) && aVar.dgo >= i) {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                            int i3 = this.bhH.aFS;
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
                                    if (c.this.aFP != null && c.this.aFP.aFb != null) {
                                        c.this.a(c.this.context, c.this.bhH);
                                        c.this.a(arrayList, c.this.bhH);
                                    }
                                }
                            }, i3 * 1000);
                            this.gCN = true;
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
    public void a(final Context context, final af afVar) {
        if (!this.aZX) {
            FD();
            View inflate = LayoutInflater.from(context).inflate(a.h.dialog_super_customer, (ViewGroup) null);
            final Dialog dialog = new Dialog(context, a.j.FlowerGuideDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(false);
            this.mContentView = inflate;
            this.aZV = dialog;
            inflate.findViewById(a.g.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.w.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    try {
                        c.this.FD();
                        if (c.this.aFP != null && c.this.aFP.mLiveInfo != null) {
                            String str2 = afVar.aEb;
                            if (!TextUtils.isEmpty(str2)) {
                                if (str2.contains("?")) {
                                    str = str2 + "&live_id=" + c.this.aFP.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str2 + "?live_id=" + c.this.aFP.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(context, str)));
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "largebag_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.w.c.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        c.this.FD();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.w.c.6
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    BdLog.d("dialog onShow 播放动画");
                    if (c.this.gCM != null) {
                        c.this.gCM.start();
                    }
                }
            });
            BdLog.d("dialog setOnDismissListener");
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.w.c.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    BdLog.d("dialog 停止动画");
                    if (c.this.gCM != null) {
                        c.this.gCM.cancel();
                    }
                    c.this.gCN = false;
                }
            });
            TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.super_bg);
            tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
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
                            if (c.this.aFP != null && dialog != null && !dialog.isShowing()) {
                                BdLog.d("dialog.show()");
                                dialog.show();
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "largebag_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
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
            if (!TextUtils.isEmpty(afVar.picUrl)) {
                BdLog.d("picUrl:" + afVar.picUrl);
                tbImageView.startLoad(afVar.picUrl, 10, false);
            }
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(a.g.super_entry);
            tbImageView2.setDefaultBgResource(a.f.sdk_shape_transparent);
            if (!TextUtils.isEmpty(afVar.aFV)) {
                tbImageView2.startLoad(afVar.aFV, 10, false);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
            ofFloat.setRepeatCount(-1);
            ofFloat2.setRepeatCount(-1);
            this.gCM = new AnimatorSet();
            this.gCM.play(ofFloat).with(ofFloat2);
            this.gCM.setInterpolator(new AccelerateDecelerateInterpolator());
            this.gCM.setDuration(2000L);
            this.gCM.setStartDelay(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<a> list, af afVar) {
        int i;
        boolean z;
        int i2;
        if (afVar != null) {
            try {
                i = afVar.limit;
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
                    if (k.c(k.hD(next.date))) {
                        i2 = next.dgo + 1;
                        next.dgo = i2;
                    } else {
                        i2 = 1;
                    }
                    next.dgo = i2;
                    next.date = k.b(new Date());
                    z = true;
                }
            }
            if (!z) {
                a aVar = new a();
                aVar.uid = TbadkCoreApplication.getCurrentAccount();
                aVar.date = k.b(new Date());
                aVar.dgo = 1;
                list.add(aVar);
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar2 : list) {
                jSONArray.put(new JSONObject(aVar2.toJsonString()));
            }
            com.baidu.live.c.AR().putString("super_constomer_show_trace_monthly", jSONArray.toString());
        }
    }

    public void onResume() {
        if (this.gCP || !this.gCO || this.context == null || this.aFP == null || this.aFP.aFb == null) {
        }
    }

    public void release() {
        this.gCN = false;
        this.aFP = null;
        this.gMq = false;
        this.gMr = false;
        this.handler.removeCallbacksAndMessages(null);
        FD();
        this.bhH = null;
        b.bYg().bhH = null;
        if (this.gCM != null) {
            this.gCM.cancel();
            this.gCM = null;
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

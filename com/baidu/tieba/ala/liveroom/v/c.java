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
import com.baidu.live.data.q;
import com.baidu.live.data.y;
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
import com.baidu.live.utils.j;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends BdBaseModel {
    private Dialog aSj;
    public y aZy;
    private q azr;
    private Context context;
    private AnimatorSet gmI;
    private View mContentView;
    private boolean gmJ = false;
    private Handler handler = new Handler();
    private boolean gmK = false;
    private boolean gmL = false;
    public boolean gwW = false;
    public boolean gwX = false;
    private HttpMessageListener bey = new HttpMessageListener(1021186) { // from class: com.baidu.tieba.ala.liveroom.v.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021186 && (httpResponsedMessage instanceof GetSuperCustomerInfoHttpResponseMessage) && c.this.context != null) {
                if (httpResponsedMessage.getError() == 0) {
                    GetSuperCustomerInfoHttpResponseMessage getSuperCustomerInfoHttpResponseMessage = (GetSuperCustomerInfoHttpResponseMessage) httpResponsedMessage;
                    if (getSuperCustomerInfoHttpResponseMessage.FX() != null) {
                        c.this.aZy = getSuperCustomerInfoHttpResponseMessage.FX();
                        b.bMA().aZy = c.this.aZy;
                        c.this.bMB();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "refreshInfo"));
                    }
                }
            }
        }
    };
    private CustomMessageListener aWo = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.v.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage.getData() instanceof String) && c.this.context != null) {
                String str = (String) customResponsedMessage.getData();
                if ("consumeSuc".equals(str) && !c.this.gwX) {
                    c.this.gwX = true;
                    BdLog.d("consumeSuc");
                    c.this.a(c.this.azr, c.this.azr.ayV.userId);
                }
                if ("chargeSuc".equals(str) && !c.this.gwW) {
                    BdLog.d("chargeSuc");
                    c.this.gwW = true;
                    c.this.a(c.this.azr, c.this.azr.ayV.userId);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext) {
        this.context = tbPageContext.getPageActivity();
        this.bey.setTag(tbPageContext.getUniqueId());
        this.aWo.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bey);
        MessageManager.getInstance().registerListener(this.aWo);
    }

    public void a(q qVar, long j) {
        this.azr = qVar;
        HttpMessage httpMessage = new HttpMessage(1021186);
        httpMessage.addParam("user_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
        BdLog.d("requestSuperCustomerInfoMessage user_id:" + j);
    }

    public void zA() {
        if (this.aSj != null && this.aSj.isShowing()) {
            Context context = this.aSj.getContext();
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
                this.aSj.dismiss();
            } else {
                return;
            }
        }
        this.aSj = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bMB() {
        JSONArray jSONArray;
        if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.azr != null && this.azr.ayV != null) {
            if (this.azr.mLiveInfo == null || this.azr.mLiveInfo.screen_direction != 2) {
                BdLog.d("deal--isTiming:" + this.gmJ);
                if (!this.gmJ && TbadkCoreApplication.isLogin() && this.aZy != null && this.aZy.azv != 1 && !TextUtils.isEmpty(this.aZy.aye)) {
                    int i = this.aZy.limit;
                    String string = com.baidu.live.c.vf().getString("super_constomer_show_trace_monthly", "");
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
                                    arrayList.add(new a().dn(jSONArray2.optJSONObject(i2)));
                                }
                            }
                            for (a aVar : arrayList) {
                                if (aVar != null && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.uid)) {
                                    Date fS = j.fS(aVar.date);
                                    if (fS == null) {
                                        break;
                                    } else if (!j.d(fS)) {
                                        if (j.c(fS) && aVar.cVg >= i) {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                            int i3 = this.aZy.azu;
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
                                    if (c.this.azr != null && c.this.azr.ayV != null) {
                                        c.this.a(c.this.context, c.this.aZy);
                                        c.this.a(arrayList, c.this.aZy);
                                    }
                                }
                            }, i3 * 1000);
                            this.gmJ = true;
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
    public void a(final Context context, final y yVar) {
        zA();
        View inflate = LayoutInflater.from(context).inflate(a.h.dialog_super_customer, (ViewGroup) null);
        final Dialog dialog = new Dialog(context, a.j.FlowerGuideDialogStyle);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        this.mContentView = inflate;
        this.aSj = dialog;
        inflate.findViewById(a.g.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.v.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                try {
                    c.this.zA();
                    if (c.this.azr != null && c.this.azr.mLiveInfo != null) {
                        String str2 = yVar.aye;
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.contains("?")) {
                                str = str2 + "&live_id=" + c.this.azr.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                            } else {
                                str = str2 + "?live_id=" + c.this.azr.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
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
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.v.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    c.this.zA();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.v.c.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                BdLog.d("dialog onShow 播放动画");
                if (c.this.gmI != null) {
                    c.this.gmI.start();
                }
            }
        });
        BdLog.d("dialog setOnDismissListener");
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.v.c.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                BdLog.d("dialog 停止动画");
                if (c.this.gmI != null) {
                    c.this.gmI.cancel();
                }
                c.this.gmJ = false;
            }
        });
        TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.super_bg);
        tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
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
                        if (c.this.azr != null && dialog != null && !dialog.isShowing()) {
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
        if (!TextUtils.isEmpty(yVar.picUrl)) {
            BdLog.d("picUrl:" + yVar.picUrl);
            tbImageView.startLoad(yVar.picUrl, 10, false);
        }
        TbImageView tbImageView2 = (TbImageView) inflate.findViewById(a.g.super_entry);
        tbImageView2.setDefaultBgResource(a.f.sdk_shape_transparent);
        if (!TextUtils.isEmpty(yVar.azx)) {
            tbImageView2.startLoad(yVar.azx, 10, false);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat2.setRepeatCount(-1);
        this.gmI = new AnimatorSet();
        this.gmI.play(ofFloat).with(ofFloat2);
        this.gmI.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gmI.setDuration(2000L);
        this.gmI.setStartDelay(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<a> list, y yVar) {
        int i;
        boolean z;
        int i2;
        if (yVar != null) {
            try {
                i = yVar.limit;
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
                    if (j.c(j.fS(next.date))) {
                        i2 = next.cVg + 1;
                        next.cVg = i2;
                    } else {
                        i2 = 1;
                    }
                    next.cVg = i2;
                    next.date = j.b(new Date());
                    z = true;
                }
            }
            if (!z) {
                a aVar = new a();
                aVar.uid = TbadkCoreApplication.getCurrentAccount();
                aVar.date = j.b(new Date());
                aVar.cVg = 1;
                list.add(aVar);
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar2 : list) {
                jSONArray.put(new JSONObject(aVar2.toJsonString()));
            }
            com.baidu.live.c.vf().putString("super_constomer_show_trace_monthly", jSONArray.toString());
        }
    }

    public void onResume() {
        if (this.gmL || !this.gmK || this.context == null || this.azr == null || this.azr.ayV == null) {
        }
    }

    public void release() {
        this.gmJ = false;
        this.azr = null;
        this.gwW = false;
        this.gwX = false;
        this.handler.removeCallbacksAndMessages(null);
        zA();
        this.aZy = null;
        b.bMA().aZy = null;
        if (this.gmI != null) {
            this.gmI.cancel();
            this.gmI = null;
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

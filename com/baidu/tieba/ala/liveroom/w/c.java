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
import com.baidu.live.data.aa;
import com.baidu.live.data.r;
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
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends BdBaseModel {
    private r aEC;
    private Dialog aXw;
    private boolean aXy;
    public aa beS;
    private Context context;
    private AnimatorSet gzx;
    private View mContentView;
    private boolean gzy = false;
    private Handler handler = new Handler();
    private boolean gzz = false;
    private boolean gzA = false;
    public boolean gIV = false;
    public boolean gIW = false;
    private HttpMessageListener bkj = new HttpMessageListener(1021186) { // from class: com.baidu.tieba.ala.liveroom.w.c.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021186 && (httpResponsedMessage instanceof GetSuperCustomerInfoHttpResponseMessage) && c.this.context != null) {
                if (httpResponsedMessage.getError() == 0) {
                    GetSuperCustomerInfoHttpResponseMessage getSuperCustomerInfoHttpResponseMessage = (GetSuperCustomerInfoHttpResponseMessage) httpResponsedMessage;
                    if (getSuperCustomerInfoHttpResponseMessage.LL() != null) {
                        c.this.beS = getSuperCustomerInfoHttpResponseMessage.LL();
                        b.bWx().beS = c.this.beS;
                        c.this.bWy();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "refreshInfo"));
                    }
                }
            }
        }
    };
    private CustomMessageListener bbD = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.w.c.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage.getData() instanceof String) && c.this.context != null) {
                String str = (String) customResponsedMessage.getData();
                if ("consumeSuc".equals(str) && !c.this.gIW) {
                    c.this.gIW = true;
                    BdLog.d("consumeSuc");
                    c.this.a(c.this.aEC, c.this.aEC.aEd.userId);
                }
                if ("chargeSuc".equals(str) && !c.this.gIV) {
                    BdLog.d("chargeSuc");
                    c.this.gIV = true;
                    c.this.a(c.this.aEC, c.this.aEC.aEd.userId);
                }
            }
        }
    };

    public c(TbPageContext tbPageContext) {
        this.context = tbPageContext.getPageActivity();
        this.bkj.setTag(tbPageContext.getUniqueId());
        this.bbD.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.bkj);
        MessageManager.getInstance().registerListener(this.bbD);
    }

    public void bm(boolean z) {
        this.aXy = z;
        if (z) {
            Fd();
        }
    }

    public void a(r rVar, long j) {
        this.aEC = rVar;
        HttpMessage httpMessage = new HttpMessage(1021186);
        httpMessage.addParam("user_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
        BdLog.d("requestSuperCustomerInfoMessage user_id:" + j);
    }

    public void Fd() {
        if (this.aXw != null && this.aXw.isShowing()) {
            Context context = this.aXw.getContext();
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
                this.aXw.dismiss();
            } else {
                return;
            }
        }
        this.aXw = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bWy() {
        JSONArray jSONArray;
        if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.aEC != null && this.aEC.aEd != null && !this.aXy) {
            if (this.aEC.mLiveInfo == null || this.aEC.mLiveInfo.screen_direction != 2) {
                BdLog.d("deal--isTiming:" + this.gzy);
                if (!this.gzy && TbadkCoreApplication.isLogin() && this.beS != null && this.beS.aEG != 1 && !TextUtils.isEmpty(this.beS.aDg)) {
                    int i = this.beS.limit;
                    String string = com.baidu.live.c.AD().getString("super_constomer_show_trace_monthly", "");
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
                                    arrayList.add(new a().dx(jSONArray2.optJSONObject(i2)));
                                }
                            }
                            for (a aVar : arrayList) {
                                if (aVar != null && TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(aVar.uid)) {
                                    Date hm = j.hm(aVar.date);
                                    if (hm == null) {
                                        break;
                                    } else if (!j.d(hm)) {
                                        if (j.c(hm) && aVar.dej >= i) {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                }
                            }
                            int i3 = this.beS.aEF;
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
                                    if (c.this.aEC != null && c.this.aEC.aEd != null) {
                                        c.this.a(c.this.context, c.this.beS);
                                        c.this.a(arrayList, c.this.beS);
                                    }
                                }
                            }, i3 * 1000);
                            this.gzy = true;
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
    public void a(final Context context, final aa aaVar) {
        if (!this.aXy) {
            Fd();
            View inflate = LayoutInflater.from(context).inflate(a.h.dialog_super_customer, (ViewGroup) null);
            final Dialog dialog = new Dialog(context, a.j.FlowerGuideDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(false);
            this.mContentView = inflate;
            this.aXw = dialog;
            inflate.findViewById(a.g.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.w.c.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str;
                    try {
                        c.this.Fd();
                        if (c.this.aEC != null && c.this.aEC.mLiveInfo != null) {
                            String str2 = aaVar.aDg;
                            if (!TextUtils.isEmpty(str2)) {
                                if (str2.contains("?")) {
                                    str = str2 + "&live_id=" + c.this.aEC.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                                } else {
                                    str = str2 + "?live_id=" + c.this.aEC.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
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
                        c.this.Fd();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.w.c.6
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    BdLog.d("dialog onShow 播放动画");
                    if (c.this.gzx != null) {
                        c.this.gzx.start();
                    }
                }
            });
            BdLog.d("dialog setOnDismissListener");
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.w.c.7
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    BdLog.d("dialog 停止动画");
                    if (c.this.gzx != null) {
                        c.this.gzx.cancel();
                    }
                    c.this.gzy = false;
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
                            if (c.this.aEC != null && dialog != null && !dialog.isShowing()) {
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
            if (!TextUtils.isEmpty(aaVar.picUrl)) {
                BdLog.d("picUrl:" + aaVar.picUrl);
                tbImageView.startLoad(aaVar.picUrl, 10, false);
            }
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(a.g.super_entry);
            tbImageView2.setDefaultBgResource(a.f.sdk_shape_transparent);
            if (!TextUtils.isEmpty(aaVar.aEH)) {
                tbImageView2.startLoad(aaVar.aEH, 10, false);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
            ofFloat.setRepeatCount(-1);
            ofFloat2.setRepeatCount(-1);
            this.gzx = new AnimatorSet();
            this.gzx.play(ofFloat).with(ofFloat2);
            this.gzx.setInterpolator(new AccelerateDecelerateInterpolator());
            this.gzx.setDuration(2000L);
            this.gzx.setStartDelay(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<a> list, aa aaVar) {
        int i;
        boolean z;
        int i2;
        if (aaVar != null) {
            try {
                i = aaVar.limit;
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
                    if (j.c(j.hm(next.date))) {
                        i2 = next.dej + 1;
                        next.dej = i2;
                    } else {
                        i2 = 1;
                    }
                    next.dej = i2;
                    next.date = j.b(new Date());
                    z = true;
                }
            }
            if (!z) {
                a aVar = new a();
                aVar.uid = TbadkCoreApplication.getCurrentAccount();
                aVar.date = j.b(new Date());
                aVar.dej = 1;
                list.add(aVar);
            }
            JSONArray jSONArray = new JSONArray();
            for (a aVar2 : list) {
                jSONArray.put(new JSONObject(aVar2.toJsonString()));
            }
            com.baidu.live.c.AD().putString("super_constomer_show_trace_monthly", jSONArray.toString());
        }
    }

    public void onResume() {
        if (this.gzA || !this.gzz || this.context == null || this.aEC == null || this.aEC.aEd == null) {
        }
    }

    public void release() {
        this.gzy = false;
        this.aEC = null;
        this.gIV = false;
        this.gIW = false;
        this.handler.removeCallbacksAndMessages(null);
        Fd();
        this.beS = null;
        b.bWx().beS = null;
        if (this.gzx != null) {
            this.gzx.cancel();
            this.gzx = null;
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

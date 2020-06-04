package com.baidu.tieba.ala.liveroom.t;

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
import com.baidu.live.c;
import com.baidu.live.data.q;
import com.baidu.live.data.x;
import com.baidu.live.message.GetSuperCustomerInfoHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.j;
import java.util.Date;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends BdBaseModel {
    private Dialog aOk;
    public x aWQ;
    private q avW;
    private Context context;
    private AnimatorSet fUM;
    private View mContentView;
    private boolean fUN = false;
    private Handler handler = new Handler();
    private boolean fUO = false;
    private boolean fUP = false;
    public boolean geE = false;
    public boolean geF = false;
    private HttpMessageListener aYY = new HttpMessageListener(1021186) { // from class: com.baidu.tieba.ala.liveroom.t.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021186 && (httpResponsedMessage instanceof GetSuperCustomerInfoHttpResponseMessage) && b.this.context != null) {
                if (httpResponsedMessage.getError() == 0) {
                    GetSuperCustomerInfoHttpResponseMessage getSuperCustomerInfoHttpResponseMessage = (GetSuperCustomerInfoHttpResponseMessage) httpResponsedMessage;
                    if (getSuperCustomerInfoHttpResponseMessage.Ft() != null) {
                        b.this.aWQ = getSuperCustomerInfoHttpResponseMessage.Ft();
                        a.bGm().aWQ = b.this.aWQ;
                        b.this.bGn();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913189, "refreshInfo"));
                    }
                }
            }
        }
    };
    private CustomMessageListener aSs = new CustomMessageListener(2913189) { // from class: com.baidu.tieba.ala.liveroom.t.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage.getData() instanceof String) && b.this.context != null) {
                String str = (String) customResponsedMessage.getData();
                if ("consumeSuc".equals(str) && !b.this.geF) {
                    b.this.geF = true;
                    BdLog.d("consumeSuc");
                    b.this.a(b.this.avW, b.this.avW.avC.userId);
                }
                if ("chargeSuc".equals(str) && !b.this.geE) {
                    BdLog.d("chargeSuc");
                    b.this.geE = true;
                    b.this.a(b.this.avW, b.this.avW.avC.userId);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext) {
        this.context = tbPageContext.getPageActivity();
        this.aYY.setTag(tbPageContext.getUniqueId());
        this.aSs.setTag(tbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.aYY);
        MessageManager.getInstance().registerListener(this.aSs);
    }

    public void a(q qVar, long j) {
        this.avW = qVar;
        HttpMessage httpMessage = new HttpMessage(1021186);
        httpMessage.addParam("user_id", j);
        MessageManager.getInstance().sendMessage(httpMessage);
        BdLog.d("requestSuperCustomerInfoMessage user_id:" + j);
    }

    public void yy() {
        if (this.aOk != null && this.aOk.isShowing()) {
            Context context = this.aOk.getContext();
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
                this.aOk.dismiss();
            } else {
                return;
            }
        }
        this.aOk = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bGn() {
        JSONArray jSONArray;
        if (!TbadkCoreApplication.getInst().isMobileBaidu() && this.avW != null && this.avW.avC != null) {
            if (this.avW.mLiveInfo == null || this.avW.mLiveInfo.screen_direction != 2) {
                BdLog.d("deal--isTiming:" + this.fUN);
                if (!this.fUN && TbadkCoreApplication.isLogin() && this.aWQ != null && this.aWQ.awa != 1 && !TextUtils.isEmpty(this.aWQ.auL)) {
                    int i = this.aWQ.limit;
                    final String b = j.b(new Date());
                    String string = c.uN().getString("super_constomer_show_trace", "");
                    BdLog.d("deal-- trace:" + string);
                    if (!TextUtils.isEmpty(string)) {
                        try {
                            jSONArray = new JSONArray(string);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        JSONArray jSONArray2 = jSONArray;
                        if (i == 0) {
                            if (jSONArray2 != null) {
                                HashSet hashSet = new HashSet();
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    JSONObject optJSONObject = jSONArray2.optJSONObject(i2);
                                    if (optJSONObject != null) {
                                        String optString = optJSONObject.optString("date");
                                        if (b.equals(optString)) {
                                            BdLog.d("deal-- 今天展示过就不展示了");
                                            return;
                                        }
                                        hashSet.add(optString);
                                    }
                                }
                                if (hashSet.size() >= i) {
                                    BdLog.d("deal-- 记录的天数超出了可显示的最多天数 limit:" + i);
                                    return;
                                }
                            }
                            int i3 = this.aWQ.avZ;
                            if (i3 <= 0) {
                                i3 = 20;
                            }
                            BdLog.d("deal--postDelayed");
                            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.t.b.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    BdLog.d("deal--postDelayed run");
                                    if (b.this.context instanceof Activity) {
                                        Activity activity = (Activity) b.this.context;
                                        if (Build.VERSION.SDK_INT >= 17) {
                                            if (activity.isDestroyed() || activity.isFinishing()) {
                                                return;
                                            }
                                        } else if (activity.isFinishing()) {
                                            return;
                                        }
                                    }
                                    if (b.this.avW != null && b.this.avW.avC != null) {
                                        b.this.a(b.this.context, b.this.aWQ);
                                        b.this.a(b, b.this.aWQ);
                                    }
                                }
                            }, i3 * 1000);
                            this.fUN = true;
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
    public void a(final Context context, final x xVar) {
        yy();
        View inflate = LayoutInflater.from(context).inflate(a.h.dialog_super_customer, (ViewGroup) null);
        final Dialog dialog = new Dialog(context, a.j.FlowerGuideDialogStyle);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        this.mContentView = inflate;
        this.aOk = dialog;
        inflate.findViewById(a.g.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.t.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                try {
                    b.this.yy();
                    if (b.this.avW != null && b.this.avW.mLiveInfo != null) {
                        String str2 = xVar.auL;
                        if (!TextUtils.isEmpty(str2)) {
                            if (str2.contains("?")) {
                                str = str2 + "&live_id=" + b.this.avW.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
                            } else {
                                str = str2 + "?live_id=" + b.this.avW.mLiveInfo.live_id + "&client_type=2&subapp_type=" + TbConfig.getSubappType();
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
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.t.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    b.this.yy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.t.b.6
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                BdLog.d("dialog onShow 播放动画");
                if (b.this.fUM != null) {
                    b.this.fUM.start();
                }
            }
        });
        BdLog.d("dialog setOnDismissListener");
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.t.b.7
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                BdLog.d("dialog 停止动画");
                if (b.this.fUM != null) {
                    b.this.fUM.cancel();
                }
                b.this.fUN = false;
            }
        });
        TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.super_bg);
        tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
        tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.t.b.8
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
                        if (b.this.avW != null && dialog != null && !dialog.isShowing()) {
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
        if (!TextUtils.isEmpty(xVar.picUrl)) {
            BdLog.d("picUrl:" + xVar.picUrl);
            tbImageView.startLoad(xVar.picUrl, 10, false);
        }
        TbImageView tbImageView2 = (TbImageView) inflate.findViewById(a.g.super_entry);
        tbImageView2.setDefaultBgResource(a.f.sdk_shape_transparent);
        if (!TextUtils.isEmpty(xVar.awc)) {
            tbImageView2.startLoad(xVar.awc, 10, false);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat2.setRepeatCount(-1);
        this.fUM = new AnimatorSet();
        this.fUM.play(ofFloat).with(ofFloat2);
        this.fUM.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fUM.setDuration(2000L);
        this.fUM.setStartDelay(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, x xVar) {
        JSONArray jSONArray;
        int i = 0;
        if (xVar != null) {
            try {
                i = xVar.limit;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        if (i >= 0) {
            String string = c.uN().getString("super_constomer_show_trace", "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            } else {
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("date", str);
            jSONArray.put(jSONObject);
            c.uN().putString("super_constomer_show_trace", jSONArray.toString());
        }
    }

    public void onResume() {
        if (this.fUP || !this.fUO || this.context == null || this.avW == null || this.avW.avC == null) {
        }
    }

    public void release() {
        this.fUN = false;
        this.avW = null;
        this.geE = false;
        this.geF = false;
        this.handler.removeCallbacksAndMessages(null);
        yy();
        this.aWQ = null;
        a.bGm().aWQ = null;
        if (this.fUM != null) {
            this.fUM.cancel();
            this.fUM = null;
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

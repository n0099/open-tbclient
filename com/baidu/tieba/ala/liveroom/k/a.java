package com.baidu.tieba.ala.liveroom.k;

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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.c;
import com.baidu.live.data.bc;
import com.baidu.live.data.bm;
import com.baidu.live.data.bn;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.j;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private bn aFk;
    private Dialog aSj;
    private q azr;
    private Context context;
    private AnimatorSet gmI;
    private View mContentView;
    private String otherParams;
    private boolean gmJ = false;
    private Handler handler = new Handler();
    private boolean gmK = false;
    private boolean gmL = false;
    private boolean gmM = false;

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

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(final Context context, q qVar, String str) {
        bc bcVar;
        bm bmVar;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        int i;
        int i2;
        int i3 = 0;
        this.context = context;
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.azr = qVar;
            this.otherParams = str;
            if (this.azr != null && this.azr.ayV != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("test_firstRecharge", false);
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                boolean booleanValue = process.containsKey("test_firstRecharge") ? ((Boolean) process.get("test_firstRecharge")).booleanValue() : false;
                if (booleanValue) {
                    this.azr.ayV.isNewUser = true;
                }
                this.gmK = this.azr.ayV.isNewUser;
                if (this.gmK && !this.gmJ && TbadkCoreApplication.isLogin() && (bcVar = com.baidu.live.v.a.Hs().beo) != null && bcVar.aEr != null && bcVar.aEr.aGg && (bmVar = bcVar.aEo) != null) {
                    this.aFk = bmVar.aFk;
                    if (this.aFk != null && !TextUtils.isEmpty(this.aFk.aFr)) {
                        int i4 = this.aFk.aFe;
                        int i5 = this.aFk.aFf;
                        final String b = j.b(new Date());
                        String string = c.vf().getString("first_recharge_show_trace", "");
                        if (!TextUtils.isEmpty(string)) {
                            try {
                                jSONArray = new JSONArray(string);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            jSONArray2 = booleanValue ? null : jSONArray;
                            if (i4 == 0 || i5 != 0) {
                                if ((i4 < 0 || i5 >= 0) && jSONArray2 != null) {
                                    HashSet hashSet = new HashSet();
                                    for (i = 0; i < jSONArray2.length(); i++) {
                                        JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                                        if (optJSONObject != null) {
                                            String optString = optJSONObject.optString("date");
                                            hashSet.add(optString);
                                            if (TextUtils.equals(optString, b)) {
                                                i3++;
                                            }
                                            if (i4 >= 0 && i3 >= i4) {
                                                return;
                                            }
                                        }
                                    }
                                    if (i5 >= 0) {
                                        if (hashSet.size() <= i5) {
                                            if (hashSet.size() == i5 && i3 == 0) {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                i2 = this.aFk.aFg;
                                if (i2 <= 0) {
                                    i2 = 20;
                                }
                                if (booleanValue) {
                                    i2 = 5;
                                }
                                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.k.a.1
                                    @Override // java.lang.Runnable
                                    public void run() {
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
                                        if (a.this.azr != null && a.this.azr.ayV != null && a.this.azr.ayV.isNewUser) {
                                            a.this.a(context, a.this.aFk);
                                            a.this.a(b, a.this.aFk);
                                        }
                                    }
                                }, i2 * 1000);
                                this.gmJ = true;
                            }
                            return;
                        }
                        jSONArray = null;
                        if (booleanValue) {
                        }
                        if (i4 == 0) {
                        }
                        if (i4 < 0) {
                        }
                        HashSet hashSet2 = new HashSet();
                        while (i < jSONArray2.length()) {
                        }
                        if (i5 >= 0) {
                        }
                        i2 = this.aFk.aFg;
                        if (i2 <= 0) {
                        }
                        if (booleanValue) {
                        }
                        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.k.a.1
                            @Override // java.lang.Runnable
                            public void run() {
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
                                if (a.this.azr != null && a.this.azr.ayV != null && a.this.azr.ayV.isNewUser) {
                                    a.this.a(context, a.this.aFk);
                                    a.this.a(b, a.this.aFk);
                                }
                            }
                        }, i2 * 1000);
                        this.gmJ = true;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final bn bnVar) {
        zA();
        View inflate = LayoutInflater.from(context).inflate(a.h.dialog_first_recharge, (ViewGroup) null);
        final Dialog dialog = new Dialog(context, a.j.FlowerGuideDialogStyle);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        this.mContentView = inflate;
        this.aSj = dialog;
        bHQ();
        inflate.findViewById(a.g.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    a.this.zA();
                    if (a.this.azr != null && a.this.azr.mLiveInfo != null) {
                        String str = bnVar.aFr;
                        if (!TextUtils.isEmpty(str)) {
                            BrowserHelper.startInternalWebActivity(context, str.contains("?") ? str + "&liveId=" + a.this.azr.mLiveInfo.live_id : str + "?liveId=" + a.this.azr.mLiveInfo.live_id);
                            if (a.this.azr != null) {
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupLog(a.this.azr.mLiveInfo.live_id + "", a.this.azr.mLiveInfo.room_id + "", a.this.azr.mLiveInfo.feed_id, a.this.otherParams);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "firstcharg_clk").setContentExt(null, "popup", null));
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    a.this.zA();
                    if (a.this.azr != null) {
                        LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupCloseLog(a.this.azr.mLiveInfo.live_id + "", a.this.azr.mLiveInfo.room_id + "", a.this.azr.mLiveInfo.feed_id, a.this.otherParams);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        TbImageView tbImageView = (TbImageView) inflate.findViewById(a.g.rechargeBg_imageView);
        tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
        TbImageView tbImageView2 = (TbImageView) inflate.findViewById(a.g.recharge_imageView);
        tbImageView2.setDefaultBgResource(a.f.sdk_shape_transparent);
        if (!TextUtils.isEmpty(bnVar.aFq)) {
            tbImageView2.startLoad(bnVar.aFq, 10, false);
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
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.gmI != null) {
                    a.this.gmI.start();
                }
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.gmI != null) {
                    a.this.gmI.cancel();
                }
                a.this.gmJ = false;
            }
        });
        tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.k.a.6
            @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
            public void onComplete(String str, boolean z) {
                try {
                    if (context instanceof Activity) {
                        Activity activity = (Activity) context;
                        if (Build.VERSION.SDK_INT >= 17) {
                            if (activity.isDestroyed() || activity.isFinishing()) {
                                return;
                            }
                        } else if (activity.isFinishing()) {
                            return;
                        }
                        if (a.this.azr != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "firstRechargeDialog"));
                            if (dialog != null && !dialog.isShowing()) {
                                dialog.show();
                                if (a.this.azr != null) {
                                    LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePopupLog(a.this.azr.mLiveInfo.live_id + "", a.this.azr.mLiveInfo.room_id + "", a.this.azr.mLiveInfo.feed_id, a.this.otherParams);
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "firstcharg_show").setContentExt(null, "popup", null));
                                }
                            }
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
        if (!TextUtils.isEmpty(bnVar.aFp)) {
            tbImageView.startLoad(bnVar.aFp, 10, false);
        }
    }

    public void a(String str, bn bnVar) {
        int i;
        JSONArray jSONArray;
        int i2 = 0;
        if (bnVar != null) {
            try {
                i = bnVar.aFe;
                i2 = bnVar.aFf;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        } else {
            i = 0;
        }
        if (i >= 0 || i2 >= 0) {
            String string = c.vf().getString("first_recharge_show_trace", "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            } else {
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("date", str);
            jSONArray.put(jSONObject);
            c.vf().putString("first_recharge_show_trace", jSONArray.toString());
        }
    }

    public void onResume() {
        if (!this.gmL && this.gmK && this.context != null && this.azr != null && this.azr.ayV != null && !this.azr.ayV.isNewUser) {
            zA();
            if (this.gmK && this.aFk != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913098, this.aFk.azw));
            }
            this.gmL = true;
            bHP();
        }
    }

    public void t(q qVar) {
        if (!this.gmM && this.gmK && qVar != null && qVar.ayV != null) {
            boolean z = qVar.ayV.isNewUser;
            this.azr = qVar;
            if (!z && this.gmK) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913115));
                this.gmM = true;
                bHP();
            }
        }
    }

    private void bHP() {
        if (this.gmL && this.gmM) {
            this.gmK = false;
        }
    }

    public void release() {
        this.gmJ = false;
        this.azr = null;
        this.handler.removeCallbacksAndMessages(null);
        zA();
        if (this.gmI != null) {
            this.gmI.cancel();
            this.gmI = null;
        }
    }

    public void zc() {
        if (this.aSj != null && this.aSj.isShowing() && this.mContentView != null) {
            this.aSj.show();
            bHQ();
        }
    }

    private void bHQ() {
        TbImageView tbImageView = (TbImageView) this.mContentView.findViewById(a.g.rechargeBg_imageView);
        tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
        TbImageView tbImageView2 = (TbImageView) this.mContentView.findViewById(a.g.recharge_imageView);
        tbImageView2.setDefaultBgResource(a.f.sdk_shape_transparent);
        int dimension = (int) (this.context.getResources().getDimension(a.e.sdk_ds400) * 2.0f);
        int dimension2 = (int) this.context.getResources().getDimension(a.e.sdk_ds720);
        int dimension3 = (int) this.context.getResources().getDimension(a.e.sdk_ds176);
        int dimension4 = (int) this.context.getResources().getDimension(a.e.sdk_ds474);
        if (UtilHelper.getRealScreenOrientation(this.aSj.getContext()) == 2) {
            int dimension5 = (int) (BdUtilHelper.getScreenDimensions(this.context)[1] - this.context.getResources().getDimension(a.e.sdk_ds120));
            tbImageView.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension) / (dimension + dimension3));
            tbImageView.getLayoutParams().width = (int) (((tbImageView.getLayoutParams().height * dimension2) * 1.0f) / dimension);
            tbImageView2.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension3) / (dimension + dimension3));
            tbImageView2.getLayoutParams().width = (int) (((tbImageView2.getLayoutParams().height * dimension4) * 1.0f) / dimension3);
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.aSj.getWindow(), true, false);
            return;
        }
        tbImageView.getLayoutParams().height = dimension;
        tbImageView.getLayoutParams().width = dimension2;
        tbImageView2.getLayoutParams().height = dimension3;
        tbImageView2.getLayoutParams().width = dimension4;
        UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.aSj.getWindow(), true, false);
    }
}

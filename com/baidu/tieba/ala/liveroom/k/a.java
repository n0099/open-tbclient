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
import com.baidu.live.data.bj;
import com.baidu.live.data.bw;
import com.baidu.live.data.bx;
import com.baidu.live.data.u;
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
import com.baidu.live.utils.k;
import com.baidu.platform.comapi.map.MapController;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private u aFP;
    private bx aMb;
    private Dialog aZV;
    private boolean aZX;
    private Context context;
    private AnimatorSet gCM;
    private View mContentView;
    private String otherParams;
    private boolean gCN = false;
    private Handler handler = new Handler();
    private boolean gCO = false;
    private boolean gCP = false;
    private boolean gCQ = false;

    public void bn(boolean z) {
        this.aZX = z;
        if (this.aZX) {
            FD();
        }
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

    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(final Context context, u uVar, String str) {
        bj bjVar;
        bw bwVar;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        int i;
        int i2;
        int i3 = 0;
        this.context = context;
        if (!TbadkCoreApplication.getInst().isMobileBaidu() && !this.aZX) {
            this.aFP = uVar;
            this.otherParams = str;
            if (this.aFP != null && this.aFP.aFb != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("test_firstRecharge", false);
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                boolean booleanValue = process.containsKey("test_firstRecharge") ? ((Boolean) process.get("test_firstRecharge")).booleanValue() : false;
                if (booleanValue) {
                    this.aFP.aFb.isNewUser = true;
                }
                this.gCO = this.aFP.aFb.isNewUser;
                if (this.gCO && !this.gCN && TbadkCoreApplication.isLogin() && (bjVar = com.baidu.live.x.a.NN().bmW) != null && bjVar.aKT != null && bjVar.aKT.aNa && (bwVar = bjVar.aKQ) != null) {
                    this.aMb = bwVar.aMb;
                    if (this.aMb != null && !TextUtils.isEmpty(this.aMb.aMi)) {
                        int i4 = this.aMb.aLW;
                        int i5 = this.aMb.aLX;
                        final String b = k.b(new Date());
                        String string = c.AR().getString("first_recharge_show_trace", "");
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
                                i2 = this.aMb.aLu;
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
                                        if (a.this.aFP != null && a.this.aFP.aFb != null && a.this.aFP.aFb.isNewUser) {
                                            a.this.a(context, a.this.aMb);
                                            a.this.a(b, a.this.aMb);
                                        }
                                    }
                                }, i2 * 1000);
                                this.gCN = true;
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
                        i2 = this.aMb.aLu;
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
                                if (a.this.aFP != null && a.this.aFP.aFb != null && a.this.aFP.aFb.isNewUser) {
                                    a.this.a(context, a.this.aMb);
                                    a.this.a(b, a.this.aMb);
                                }
                            }
                        }, i2 * 1000);
                        this.gCN = true;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final bx bxVar) {
        if (!this.aZX) {
            FD();
            View inflate = LayoutInflater.from(context).inflate(a.h.dialog_first_recharge, (ViewGroup) null);
            final Dialog dialog = new Dialog(context, a.j.FlowerGuideDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(false);
            this.mContentView = inflate;
            this.aZV = dialog;
            bTm();
            inflate.findViewById(a.g.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        a.this.FD();
                        if (a.this.aFP != null && a.this.aFP.mLiveInfo != null) {
                            String str = bxVar.aMi;
                            if (!TextUtils.isEmpty(str)) {
                                BrowserHelper.startInternalWebActivity(context, str.contains("?") ? str + "&liveId=" + a.this.aFP.mLiveInfo.live_id : str + "?liveId=" + a.this.aFP.mLiveInfo.live_id);
                                if (a.this.aFP != null) {
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupLog(a.this.aFP.mLiveInfo.live_id + "", a.this.aFP.mLiveInfo.room_id + "", a.this.aFP.mLiveInfo.feed_id, a.this.otherParams);
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "firstcharg_clk").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
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
                        a.this.FD();
                        if (a.this.aFP != null) {
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupCloseLog(a.this.aFP.mLiveInfo.live_id + "", a.this.aFP.mLiveInfo.room_id + "", a.this.aFP.mLiveInfo.feed_id, a.this.otherParams);
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
            if (!TextUtils.isEmpty(bxVar.aMh)) {
                tbImageView2.startLoad(bxVar.aMh, 10, false);
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
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    if (a.this.gCM != null) {
                        a.this.gCM.start();
                    }
                }
            });
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.gCM != null) {
                        a.this.gCM.cancel();
                    }
                    a.this.gCN = false;
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
                            if (a.this.aFP != null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "firstRechargeDialog"));
                                if (dialog != null && !dialog.isShowing()) {
                                    dialog.show();
                                    if (a.this.aFP != null) {
                                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePopupLog(a.this.aFP.mLiveInfo.live_id + "", a.this.aFP.mLiveInfo.room_id + "", a.this.aFP.mLiveInfo.feed_id, a.this.otherParams);
                                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "firstcharg_show").setContentExt(null, MapController.POPUP_LAYER_TAG, null));
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
            if (!TextUtils.isEmpty(bxVar.aMg)) {
                tbImageView.startLoad(bxVar.aMg, 10, false);
            }
        }
    }

    public void a(String str, bx bxVar) {
        int i;
        JSONArray jSONArray;
        int i2 = 0;
        if (bxVar != null) {
            try {
                i = bxVar.aLW;
                i2 = bxVar.aLX;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        } else {
            i = 0;
        }
        if (i >= 0 || i2 >= 0) {
            String string = c.AR().getString("first_recharge_show_trace", "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            } else {
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("date", str);
            jSONArray.put(jSONObject);
            c.AR().putString("first_recharge_show_trace", jSONArray.toString());
        }
    }

    public void onResume() {
        if (!this.gCP && this.gCO && this.context != null && this.aFP != null && this.aFP.aFb != null && !this.aFP.aFb.isNewUser) {
            FD();
            if (this.gCO && this.aMb != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913098, this.aMb.aEQ));
            }
            this.gCP = true;
            bTl();
        }
    }

    public void p(u uVar) {
        if (!this.gCQ && this.gCO && uVar != null && uVar.aFb != null) {
            boolean z = uVar.aFb.isNewUser;
            this.aFP = uVar;
            if (!z && this.gCO) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913115));
                this.gCQ = true;
                bTl();
            }
        }
    }

    private void bTl() {
        if (this.gCP && this.gCQ) {
            this.gCO = false;
        }
    }

    public void release() {
        this.gCN = false;
        this.aFP = null;
        this.handler.removeCallbacksAndMessages(null);
        FD();
        if (this.gCM != null) {
            this.gCM.cancel();
            this.gCM = null;
        }
    }

    public void EW() {
        if (this.aZV != null && this.aZV.isShowing() && this.mContentView != null) {
            this.aZV.show();
            bTm();
        }
    }

    private void bTm() {
        TbImageView tbImageView = (TbImageView) this.mContentView.findViewById(a.g.rechargeBg_imageView);
        tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
        TbImageView tbImageView2 = (TbImageView) this.mContentView.findViewById(a.g.recharge_imageView);
        tbImageView2.setDefaultBgResource(a.f.sdk_shape_transparent);
        int dimension = (int) (this.context.getResources().getDimension(a.e.sdk_ds400) * 2.0f);
        int dimension2 = (int) this.context.getResources().getDimension(a.e.sdk_ds720);
        int dimension3 = (int) this.context.getResources().getDimension(a.e.sdk_ds176);
        int dimension4 = (int) this.context.getResources().getDimension(a.e.sdk_ds474);
        if (UtilHelper.getRealScreenOrientation(this.aZV.getContext()) == 2) {
            int dimension5 = (int) (BdUtilHelper.getScreenDimensions(this.context)[1] - this.context.getResources().getDimension(a.e.sdk_ds120));
            tbImageView.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension) / (dimension + dimension3));
            tbImageView.getLayoutParams().width = (int) (((tbImageView.getLayoutParams().height * dimension2) * 1.0f) / dimension);
            tbImageView2.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension3) / (dimension + dimension3));
            tbImageView2.getLayoutParams().width = (int) (((tbImageView2.getLayoutParams().height * dimension4) * 1.0f) / dimension3);
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.aZV.getWindow(), true, false);
            return;
        }
        tbImageView.getLayoutParams().height = dimension;
        tbImageView.getLayoutParams().width = dimension2;
        tbImageView2.getLayoutParams().height = dimension3;
        tbImageView2.getLayoutParams().width = dimension4;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.aZV.getWindow(), true, false);
        } else {
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.aZV.getWindow(), false, false);
        }
    }
}

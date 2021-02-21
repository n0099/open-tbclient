package com.baidu.tieba.ala.liveroom.j;

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
import com.baidu.live.d;
import com.baidu.live.data.ab;
import com.baidu.live.data.bv;
import com.baidu.live.data.co;
import com.baidu.live.data.cp;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.k;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private ab aJZ;
    private cp aRu;
    private Dialog biA;
    private boolean biC;
    private Context context;
    private AnimatorSet hDM;
    private View mContentView;
    private String otherParams;
    private boolean hDN = false;
    private Handler handler = new Handler();
    private boolean hDO = false;
    private boolean hDP = false;
    private boolean hDQ = false;

    public void bE(boolean z) {
        this.biC = z;
        if (this.biC) {
            FA();
        }
    }

    public void FA() {
        if (this.biA != null && this.biA.isShowing()) {
            Context context = this.biA.getContext();
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
                this.biA.dismiss();
            } else {
                return;
            }
        }
        this.biA = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0104 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(final Context context, ab abVar, String str) {
        bv bvVar;
        co coVar;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        int i;
        int i2;
        int i3 = 0;
        this.context = context;
        if (!TbadkCoreApplication.getInst().isMobileBaidu() && !this.biC) {
            this.aJZ = abVar;
            this.otherParams = str;
            if (this.aJZ != null && this.aJZ.aIz != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("test_firstRecharge", false);
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                boolean booleanValue = process.containsKey("test_firstRecharge") ? ((Boolean) process.get("test_firstRecharge")).booleanValue() : false;
                if (booleanValue) {
                    this.aJZ.aIz.isNewUser = true;
                }
                this.hDO = this.aJZ.aIz.isNewUser;
                if (this.hDO && !this.hDN && TbadkCoreApplication.isLogin() && (bvVar = com.baidu.live.ae.a.Qj().bAS) != null && bvVar.aPP != null && bvVar.aPP.aSv && (coVar = bvVar.aPM) != null) {
                    this.aRu = coVar.aRu;
                    if (this.aRu != null && !TextUtils.isEmpty(this.aRu.aRD)) {
                        int i4 = this.aRu.aRp;
                        int i5 = this.aRu.aRq;
                        final String b2 = k.b(new Date());
                        String string = d.xc().getString("first_recharge_show_trace", "");
                        if (!TextUtils.isEmpty(string)) {
                            try {
                                jSONArray = new JSONArray(string);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            jSONArray2 = !booleanValue ? null : jSONArray;
                            if (i4 == 0 || i5 != 0) {
                                if ((i4 < 0 || i5 >= 0) && jSONArray2 != null) {
                                    HashSet hashSet = new HashSet();
                                    i = 0;
                                    while (true) {
                                        int i6 = i3;
                                        if (i >= jSONArray2.length()) {
                                            JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                                            if (optJSONObject != null) {
                                                String optString = optJSONObject.optString("date");
                                                hashSet.add(optString);
                                                i3 = TextUtils.equals(optString, b2) ? i6 + 1 : i6;
                                                if (i4 >= 0 && i3 >= i4) {
                                                    return;
                                                }
                                            } else {
                                                i3 = i6;
                                            }
                                            i++;
                                        } else if (i5 >= 0) {
                                            if (hashSet.size() <= i5) {
                                                if (hashSet.size() == i5 && i6 == 0) {
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                }
                                i2 = this.aRu.aQt;
                                if (i2 <= 0) {
                                    i2 = 20;
                                }
                                if (booleanValue) {
                                    i2 = 5;
                                }
                                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.a.1
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
                                        if (a.this.aJZ != null && a.this.aJZ.aIz != null && a.this.aJZ.aIz.isNewUser) {
                                            a.this.a(context, a.this.aRu);
                                            a.this.a(b2, a.this.aRu);
                                        }
                                    }
                                }, i2 * 1000);
                                this.hDN = true;
                            }
                            return;
                        }
                        jSONArray = null;
                        if (!booleanValue) {
                        }
                        if (i4 == 0) {
                        }
                        if (i4 < 0) {
                        }
                        HashSet hashSet2 = new HashSet();
                        i = 0;
                        while (true) {
                            int i62 = i3;
                            if (i >= jSONArray2.length()) {
                            }
                            i++;
                        }
                        i2 = this.aRu.aQt;
                        if (i2 <= 0) {
                        }
                        if (booleanValue) {
                        }
                        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.a.1
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
                                if (a.this.aJZ != null && a.this.aJZ.aIz != null && a.this.aJZ.aIz.isNewUser) {
                                    a.this.a(context, a.this.aRu);
                                    a.this.a(b2, a.this.aRu);
                                }
                            }
                        }, i2 * 1000);
                        this.hDN = true;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final cp cpVar) {
        if (!this.biC) {
            FA();
            View inflate = LayoutInflater.from(context).inflate(a.g.dialog_first_recharge, (ViewGroup) null);
            final Dialog dialog = new Dialog(context, a.i.FlowerGuideDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(false);
            this.mContentView = inflate;
            this.biA = dialog;
            cfu();
            inflate.findViewById(a.f.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        a.this.FA();
                        if (a.this.aJZ != null && a.this.aJZ.mLiveInfo != null) {
                            String str = cpVar.aRD;
                            if (!TextUtils.isEmpty(str)) {
                                BrowserHelper.startInternalWebActivity(context, str.contains("?") ? str + "&liveId=" + a.this.aJZ.mLiveInfo.live_id : str + "?liveId=" + a.this.aJZ.mLiveInfo.live_id);
                                if (a.this.aJZ != null) {
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupLog(a.this.aJZ.mLiveInfo.live_id + "", a.this.aJZ.mLiveInfo.room_id + "", a.this.aJZ.mLiveInfo.feed_id, a.this.otherParams);
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "firstcharg_clk").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        a.this.FA();
                        if (a.this.aJZ != null) {
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupCloseLog(a.this.aJZ.mLiveInfo.live_id + "", a.this.aJZ.mLiveInfo.room_id + "", a.this.aJZ.mLiveInfo.feed_id, a.this.otherParams);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            TbImageView tbImageView = (TbImageView) inflate.findViewById(a.f.rechargeBg_imageView);
            tbImageView.setDefaultBgResource(a.e.sdk_shape_transparent);
            TbImageView tbImageView2 = (TbImageView) inflate.findViewById(a.f.recharge_imageView);
            tbImageView2.setDefaultBgResource(a.e.sdk_shape_transparent);
            if (!TextUtils.isEmpty(cpVar.aRC)) {
                tbImageView2.startLoad(cpVar.aRC, 10, false);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
            ofFloat.setRepeatCount(-1);
            ofFloat2.setRepeatCount(-1);
            this.hDM = new AnimatorSet();
            this.hDM.play(ofFloat).with(ofFloat2);
            this.hDM.setInterpolator(new AccelerateDecelerateInterpolator());
            this.hDM.setDuration(2000L);
            this.hDM.setStartDelay(0L);
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.j.a.4
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    if (a.this.hDM != null) {
                        a.this.hDM.start();
                    }
                }
            });
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.j.a.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.hDM != null) {
                        a.this.hDM.cancel();
                    }
                    a.this.hDN = false;
                }
            });
            tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.j.a.6
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
                            if (a.this.aJZ != null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "firstRechargeDialog"));
                                if (dialog != null && !dialog.isShowing()) {
                                    dialog.show();
                                    if (a.this.aJZ != null) {
                                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePopupLog(a.this.aJZ.mLiveInfo.live_id + "", a.this.aJZ.mLiveInfo.room_id + "", a.this.aJZ.mLiveInfo.feed_id, a.this.otherParams);
                                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "firstcharg_show").setContentExt(null, UbcStatConstant.SubPage.POPUP, null));
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
            if (!TextUtils.isEmpty(cpVar.aRB)) {
                tbImageView.startLoad(cpVar.aRB, 10, false);
            }
        }
    }

    public void a(String str, cp cpVar) {
        int i;
        int i2;
        JSONArray jSONArray;
        if (cpVar != null) {
            try {
                int i3 = cpVar.aRp;
                i = cpVar.aRq;
                i2 = i3;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        } else {
            i = 0;
            i2 = 0;
        }
        if (i2 >= 0 || i >= 0) {
            String string = d.xc().getString("first_recharge_show_trace", "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            } else {
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("date", str);
            jSONArray.put(jSONObject);
            d.xc().putString("first_recharge_show_trace", jSONArray.toString());
        }
    }

    public void onResume() {
        if (!this.hDP && this.hDO && this.context != null && this.aJZ != null && this.aJZ.aIz != null && !this.aJZ.aIz.isNewUser) {
            FA();
            if (this.hDO && this.aRu != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913098, this.aRu.aIu));
            }
            this.hDP = true;
            cft();
        }
    }

    public void o(ab abVar) {
        if (!this.hDQ && this.hDO && abVar != null && abVar.aIz != null) {
            boolean z = abVar.aIz.isNewUser;
            this.aJZ = abVar;
            if (!z && this.hDO) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913115));
                this.hDQ = true;
                cft();
            }
        }
    }

    private void cft() {
        if (this.hDP && this.hDQ) {
            this.hDO = false;
        }
    }

    public void release() {
        this.hDN = false;
        this.aJZ = null;
        this.handler.removeCallbacksAndMessages(null);
        FA();
        if (this.hDM != null) {
            this.hDM.cancel();
            this.hDM = null;
        }
    }

    public void EK() {
        if (this.biA != null && this.biA.isShowing() && this.mContentView != null) {
            this.biA.show();
            cfu();
        }
    }

    private void cfu() {
        TbImageView tbImageView = (TbImageView) this.mContentView.findViewById(a.f.rechargeBg_imageView);
        tbImageView.setDefaultBgResource(a.e.sdk_shape_transparent);
        TbImageView tbImageView2 = (TbImageView) this.mContentView.findViewById(a.f.recharge_imageView);
        tbImageView2.setDefaultBgResource(a.e.sdk_shape_transparent);
        int dimension = (int) (this.context.getResources().getDimension(a.d.sdk_ds400) * 2.0f);
        int dimension2 = (int) this.context.getResources().getDimension(a.d.sdk_ds720);
        int dimension3 = (int) this.context.getResources().getDimension(a.d.sdk_ds176);
        int dimension4 = (int) this.context.getResources().getDimension(a.d.sdk_ds474);
        if (UtilHelper.getRealScreenOrientation(this.biA.getContext()) == 2) {
            int dimension5 = (int) (BdUtilHelper.getScreenDimensions(this.context)[1] - this.context.getResources().getDimension(a.d.sdk_ds120));
            tbImageView.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension) / (dimension + dimension3));
            tbImageView.getLayoutParams().width = (int) (((tbImageView.getLayoutParams().height * dimension2) * 1.0f) / dimension);
            tbImageView2.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension3) / (dimension + dimension3));
            tbImageView2.getLayoutParams().width = (int) (((tbImageView2.getLayoutParams().height * dimension4) * 1.0f) / dimension3);
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.biA.getWindow(), true, false);
            return;
        }
        tbImageView.getLayoutParams().height = dimension;
        tbImageView.getLayoutParams().width = dimension2;
        tbImageView2.getLayoutParams().height = dimension3;
        tbImageView2.getLayoutParams().width = dimension4;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.biA.getWindow(), true, false);
        } else {
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.biA.getWindow(), false, false);
        }
    }
}

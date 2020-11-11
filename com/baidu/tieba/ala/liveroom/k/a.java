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
import com.baidu.live.d;
import com.baidu.live.data.bn;
import com.baidu.live.data.cd;
import com.baidu.live.data.ce;
import com.baidu.live.data.w;
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
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    private w aKv;
    private ce aQS;
    private Dialog bgb;
    private boolean bgd;
    private Context context;
    private AnimatorSet hiO;
    private View mContentView;
    private String otherParams;
    private boolean hiP = false;
    private Handler handler = new Handler();
    private boolean hiQ = false;
    private boolean hiR = false;
    private boolean hiS = false;

    public void bu(boolean z) {
        this.bgd = z;
        if (this.bgd) {
            Hv();
        }
    }

    public void Hv() {
        if (this.bgb != null && this.bgb.isShowing()) {
            Context context = this.bgb.getContext();
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
                this.bgb.dismiss();
            } else {
                return;
            }
        }
        this.bgb = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(final Context context, w wVar, String str) {
        bn bnVar;
        cd cdVar;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        int i;
        int i2;
        int i3 = 0;
        this.context = context;
        if (!TbadkCoreApplication.getInst().isMobileBaidu() && !this.bgd) {
            this.aKv = wVar;
            this.otherParams = str;
            if (this.aKv != null && this.aKv.aJr != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("test_firstRecharge", false);
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                boolean booleanValue = process.containsKey("test_firstRecharge") ? ((Boolean) process.get("test_firstRecharge")).booleanValue() : false;
                if (booleanValue) {
                    this.aKv.aJr.isNewUser = true;
                }
                this.hiQ = this.aKv.aJr.isNewUser;
                if (this.hiQ && !this.hiP && TbadkCoreApplication.isLogin() && (bnVar = com.baidu.live.aa.a.PQ().btT) != null && bnVar.aPA != null && bnVar.aPA.aRR && (cdVar = bnVar.aPx) != null) {
                    this.aQS = cdVar.aQS;
                    if (this.aQS != null && !TextUtils.isEmpty(this.aQS.aQZ)) {
                        int i4 = this.aQS.aQN;
                        int i5 = this.aQS.aQO;
                        final String b = k.b(new Date());
                        String string = d.AZ().getString("first_recharge_show_trace", "");
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
                                i2 = this.aQS.aQb;
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
                                        if (a.this.aKv != null && a.this.aKv.aJr != null && a.this.aKv.aJr.isNewUser) {
                                            a.this.a(context, a.this.aQS);
                                            a.this.a(b, a.this.aQS);
                                        }
                                    }
                                }, i2 * 1000);
                                this.hiP = true;
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
                        i2 = this.aQS.aQb;
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
                                if (a.this.aKv != null && a.this.aKv.aJr != null && a.this.aKv.aJr.isNewUser) {
                                    a.this.a(context, a.this.aQS);
                                    a.this.a(b, a.this.aQS);
                                }
                            }
                        }, i2 * 1000);
                        this.hiP = true;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final ce ceVar) {
        if (!this.bgd) {
            Hv();
            View inflate = LayoutInflater.from(context).inflate(a.g.dialog_first_recharge, (ViewGroup) null);
            final Dialog dialog = new Dialog(context, a.i.FlowerGuideDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(false);
            this.mContentView = inflate;
            this.bgb = dialog;
            ccg();
            inflate.findViewById(a.f.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        a.this.Hv();
                        if (a.this.aKv != null && a.this.aKv.mLiveInfo != null) {
                            String str = ceVar.aQZ;
                            if (!TextUtils.isEmpty(str)) {
                                BrowserHelper.startInternalWebActivity(context, str.contains("?") ? str + "&liveId=" + a.this.aKv.mLiveInfo.live_id : str + "?liveId=" + a.this.aKv.mLiveInfo.live_id);
                                if (a.this.aKv != null) {
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupLog(a.this.aKv.mLiveInfo.live_id + "", a.this.aKv.mLiveInfo.room_id + "", a.this.aKv.mLiveInfo.feed_id, a.this.otherParams);
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "firstcharg_clk").setContentExt(null, "popup", null));
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            ((ImageView) inflate.findViewById(a.f.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        a.this.Hv();
                        if (a.this.aKv != null) {
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupCloseLog(a.this.aKv.mLiveInfo.live_id + "", a.this.aKv.mLiveInfo.room_id + "", a.this.aKv.mLiveInfo.feed_id, a.this.otherParams);
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
            if (!TextUtils.isEmpty(ceVar.aQY)) {
                tbImageView2.startLoad(ceVar.aQY, 10, false);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
            ofFloat.setRepeatCount(-1);
            ofFloat2.setRepeatCount(-1);
            this.hiO = new AnimatorSet();
            this.hiO.play(ofFloat).with(ofFloat2);
            this.hiO.setInterpolator(new AccelerateDecelerateInterpolator());
            this.hiO.setDuration(2000L);
            this.hiO.setStartDelay(0L);
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    if (a.this.hiO != null) {
                        a.this.hiO.start();
                    }
                }
            });
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.hiO != null) {
                        a.this.hiO.cancel();
                    }
                    a.this.hiP = false;
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
                            if (a.this.aKv != null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "firstRechargeDialog"));
                                if (dialog != null && !dialog.isShowing()) {
                                    dialog.show();
                                    if (a.this.aKv != null) {
                                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePopupLog(a.this.aKv.mLiveInfo.live_id + "", a.this.aKv.mLiveInfo.room_id + "", a.this.aKv.mLiveInfo.feed_id, a.this.otherParams);
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
            if (!TextUtils.isEmpty(ceVar.aQX)) {
                tbImageView.startLoad(ceVar.aQX, 10, false);
            }
        }
    }

    public void a(String str, ce ceVar) {
        int i;
        JSONArray jSONArray;
        int i2 = 0;
        if (ceVar != null) {
            try {
                i = ceVar.aQN;
                i2 = ceVar.aQO;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        } else {
            i = 0;
        }
        if (i >= 0 || i2 >= 0) {
            String string = d.AZ().getString("first_recharge_show_trace", "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            } else {
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("date", str);
            jSONArray.put(jSONObject);
            d.AZ().putString("first_recharge_show_trace", jSONArray.toString());
        }
    }

    public void onResume() {
        if (!this.hiR && this.hiQ && this.context != null && this.aKv != null && this.aKv.aJr != null && !this.aKv.aJr.isNewUser) {
            Hv();
            if (this.hiQ && this.aQS != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913098, this.aQS.aJm));
            }
            this.hiR = true;
            ccf();
        }
    }

    public void n(w wVar) {
        if (!this.hiS && this.hiQ && wVar != null && wVar.aJr != null) {
            boolean z = wVar.aJr.isNewUser;
            this.aKv = wVar;
            if (!z && this.hiQ) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913115));
                this.hiS = true;
                ccf();
            }
        }
    }

    private void ccf() {
        if (this.hiR && this.hiS) {
            this.hiQ = false;
        }
    }

    public void release() {
        this.hiP = false;
        this.aKv = null;
        this.handler.removeCallbacksAndMessages(null);
        Hv();
        if (this.hiO != null) {
            this.hiO.cancel();
            this.hiO = null;
        }
    }

    public void GI() {
        if (this.bgb != null && this.bgb.isShowing() && this.mContentView != null) {
            this.bgb.show();
            ccg();
        }
    }

    private void ccg() {
        TbImageView tbImageView = (TbImageView) this.mContentView.findViewById(a.f.rechargeBg_imageView);
        tbImageView.setDefaultBgResource(a.e.sdk_shape_transparent);
        TbImageView tbImageView2 = (TbImageView) this.mContentView.findViewById(a.f.recharge_imageView);
        tbImageView2.setDefaultBgResource(a.e.sdk_shape_transparent);
        int dimension = (int) (this.context.getResources().getDimension(a.d.sdk_ds400) * 2.0f);
        int dimension2 = (int) this.context.getResources().getDimension(a.d.sdk_ds720);
        int dimension3 = (int) this.context.getResources().getDimension(a.d.sdk_ds176);
        int dimension4 = (int) this.context.getResources().getDimension(a.d.sdk_ds474);
        if (UtilHelper.getRealScreenOrientation(this.bgb.getContext()) == 2) {
            int dimension5 = (int) (BdUtilHelper.getScreenDimensions(this.context)[1] - this.context.getResources().getDimension(a.d.sdk_ds120));
            tbImageView.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension) / (dimension + dimension3));
            tbImageView.getLayoutParams().width = (int) (((tbImageView.getLayoutParams().height * dimension2) * 1.0f) / dimension);
            tbImageView2.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension3) / (dimension + dimension3));
            tbImageView2.getLayoutParams().width = (int) (((tbImageView2.getLayoutParams().height * dimension4) * 1.0f) / dimension3);
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.bgb.getWindow(), true, false);
            return;
        }
        tbImageView.getLayoutParams().height = dimension;
        tbImageView.getLayoutParams().width = dimension2;
        tbImageView2.getLayoutParams().height = dimension3;
        tbImageView2.getLayoutParams().width = dimension4;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.bgb.getWindow(), true, false);
        } else {
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.bgb.getWindow(), false, false);
        }
    }
}

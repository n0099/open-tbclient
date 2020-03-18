package com.baidu.tieba.ala.liveroom.i;

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
import com.baidu.live.data.ap;
import com.baidu.live.data.ay;
import com.baidu.live.data.az;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.utils.j;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private m YG;
    private az adZ;
    private Dialog apM;
    private Context context;
    private AnimatorSet fcs;
    private View mContentView;
    private String otherParams;
    private boolean fct = false;
    private Handler handler = new Handler();
    private boolean fcu = false;
    private boolean fcv = false;
    private boolean fcw = false;

    public void sS() {
        if (this.apM != null && this.apM.isShowing()) {
            Context context = this.apM.getContext();
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
                this.apM.dismiss();
            } else {
                return;
            }
        }
        this.apM = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(final Context context, m mVar, String str) {
        ap apVar;
        ay ayVar;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        int i;
        int i2;
        int i3 = 0;
        this.context = context;
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.YG = mVar;
            this.otherParams = str;
            if (this.YG != null && this.YG.Yo != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("test_firstRecharge", false);
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                boolean booleanValue = process.containsKey("test_firstRecharge") ? ((Boolean) process.get("test_firstRecharge")).booleanValue() : false;
                if (booleanValue) {
                    this.YG.Yo.isNewUser = true;
                }
                this.fcu = this.YG.Yo.isNewUser;
                if (this.fcu && !this.fct && TbadkCoreApplication.isLogin() && (apVar = com.baidu.live.v.a.zs().axR) != null && apVar.adg != null && apVar.adg.aeK && (ayVar = apVar.adc) != null) {
                    this.adZ = ayVar.adZ;
                    if (this.adZ != null && !TextUtils.isEmpty(this.adZ.aeg)) {
                        int i4 = this.adZ.adT;
                        int i5 = this.adZ.adU;
                        final String b = j.b(new Date());
                        String string = c.pw().getString("first_recharge_show_trace", "");
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
                                i2 = this.adZ.adV;
                                if (i2 <= 0) {
                                    i2 = 20;
                                }
                                if (booleanValue) {
                                    i2 = 5;
                                }
                                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.i.a.1
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
                                        if (a.this.YG != null && a.this.YG.Yo != null && a.this.YG.Yo.isNewUser) {
                                            a.this.a(context, a.this.adZ);
                                            a.this.a(b, a.this.adZ);
                                        }
                                    }
                                }, i2 * 1000);
                                this.fct = true;
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
                        i2 = this.adZ.adV;
                        if (i2 <= 0) {
                        }
                        if (booleanValue) {
                        }
                        this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.i.a.1
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
                                if (a.this.YG != null && a.this.YG.Yo != null && a.this.YG.Yo.isNewUser) {
                                    a.this.a(context, a.this.adZ);
                                    a.this.a(b, a.this.adZ);
                                }
                            }
                        }, i2 * 1000);
                        this.fct = true;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final az azVar) {
        sS();
        View inflate = LayoutInflater.from(context).inflate(a.h.dialog_first_recharge, (ViewGroup) null);
        final Dialog dialog = new Dialog(context, a.j.FlowerGuideDialogStyle);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        this.mContentView = inflate;
        this.apM = dialog;
        bmj();
        inflate.findViewById(a.g.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    a.this.sS();
                    if (a.this.YG != null && a.this.YG.mLiveInfo != null) {
                        String str = azVar.aeg;
                        if (!TextUtils.isEmpty(str)) {
                            BrowserHelper.startInternalWebActivity(context, str.contains("?") ? str + "&liveId=" + a.this.YG.mLiveInfo.live_id : str + "?liveId=" + a.this.YG.mLiveInfo.live_id);
                            if (a.this.YG != null) {
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupLog(a.this.YG.mLiveInfo.live_id + "", a.this.YG.mLiveInfo.room_id + "", a.this.YG.mLiveInfo.feed_id, a.this.otherParams);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.i.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    a.this.sS();
                    if (a.this.YG != null) {
                        LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupCloseLog(a.this.YG.mLiveInfo.live_id + "", a.this.YG.mLiveInfo.room_id + "", a.this.YG.mLiveInfo.feed_id, a.this.otherParams);
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
        if (!TextUtils.isEmpty(azVar.aef)) {
            tbImageView2.startLoad(azVar.aef, 10, false);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat2.setRepeatCount(-1);
        this.fcs = new AnimatorSet();
        this.fcs.play(ofFloat).with(ofFloat2);
        this.fcs.setInterpolator(new AccelerateDecelerateInterpolator());
        this.fcs.setDuration(2000L);
        this.fcs.setStartDelay(0L);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.i.a.4
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.fcs != null) {
                    a.this.fcs.start();
                }
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.i.a.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.fcs != null) {
                    a.this.fcs.cancel();
                }
                a.this.fct = false;
            }
        });
        tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.i.a.6
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
                        if (a.this.YG != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "firstRechargeDialog"));
                            if (dialog != null && !dialog.isShowing()) {
                                dialog.show();
                                if (a.this.YG != null) {
                                    LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePopupLog(a.this.YG.mLiveInfo.live_id + "", a.this.YG.mLiveInfo.room_id + "", a.this.YG.mLiveInfo.feed_id, a.this.otherParams);
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
        if (!TextUtils.isEmpty(azVar.aee)) {
            tbImageView.startLoad(azVar.aee, 10, false);
        }
    }

    public void a(String str, az azVar) {
        int i;
        JSONArray jSONArray;
        int i2 = 0;
        if (azVar != null) {
            try {
                i = azVar.adT;
                i2 = azVar.adU;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        } else {
            i = 0;
        }
        if (i >= 0 || i2 >= 0) {
            String string = c.pw().getString("first_recharge_show_trace", "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            } else {
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("date", str);
            jSONArray.put(jSONObject);
            c.pw().putString("first_recharge_show_trace", jSONArray.toString());
        }
    }

    public void onResume() {
        if (!this.fcv && this.fcu && this.context != null && this.YG != null && this.YG.Yo != null && !this.YG.Yo.isNewUser) {
            sS();
            if (this.fcu && this.adZ != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913098, this.adZ.aed));
            }
            this.fcv = true;
            bmi();
        }
    }

    public void s(m mVar) {
        if (!this.fcw && this.fcu && mVar != null && mVar.Yo != null) {
            boolean z = mVar.Yo.isNewUser;
            this.YG = mVar;
            if (!z && this.fcu) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913115));
                this.fcw = true;
                bmi();
            }
        }
    }

    private void bmi() {
        if (this.fcv && this.fcw) {
            this.fcu = false;
        }
    }

    public void release() {
        this.fct = false;
        this.YG = null;
        this.handler.removeCallbacksAndMessages(null);
        sS();
        if (this.fcs != null) {
            this.fcs.cancel();
            this.fcs = null;
        }
    }

    public void sr() {
        if (this.apM != null && this.apM.isShowing() && this.mContentView != null) {
            this.apM.show();
            bmj();
        }
    }

    private void bmj() {
        TbImageView tbImageView = (TbImageView) this.mContentView.findViewById(a.g.rechargeBg_imageView);
        tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
        TbImageView tbImageView2 = (TbImageView) this.mContentView.findViewById(a.g.recharge_imageView);
        tbImageView2.setDefaultBgResource(a.f.sdk_shape_transparent);
        int dimension = (int) (this.context.getResources().getDimension(a.e.sdk_ds400) * 2.0f);
        int dimension2 = (int) this.context.getResources().getDimension(a.e.sdk_ds720);
        int dimension3 = (int) this.context.getResources().getDimension(a.e.sdk_ds176);
        int dimension4 = (int) this.context.getResources().getDimension(a.e.sdk_ds474);
        if (UtilHelper.getRealScreenOrientation(this.apM.getContext()) == 2) {
            int dimension5 = (int) (BdUtilHelper.getScreenDimensions(this.context)[1] - this.context.getResources().getDimension(a.e.sdk_ds120));
            tbImageView.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension) / (dimension + dimension3));
            tbImageView.getLayoutParams().width = (int) (((tbImageView.getLayoutParams().height * dimension2) * 1.0f) / dimension);
            tbImageView2.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension3) / (dimension + dimension3));
            tbImageView2.getLayoutParams().width = (int) (((tbImageView2.getLayoutParams().height * dimension4) * 1.0f) / dimension3);
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.apM.getWindow(), true, false);
            return;
        }
        tbImageView.getLayoutParams().height = dimension;
        tbImageView.getLayoutParams().width = dimension2;
        tbImageView2.getLayoutParams().height = dimension3;
        tbImageView2.getLayoutParams().width = dimension4;
        UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.apM.getWindow(), true, false);
    }
}

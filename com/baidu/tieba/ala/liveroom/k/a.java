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
    private w aIK;
    private ce aPh;
    private Dialog ben;
    private boolean bep;
    private Context context;
    private AnimatorSet hiv;
    private View mContentView;
    private String otherParams;
    private boolean hiw = false;
    private Handler handler = new Handler();
    private boolean hix = false;
    private boolean hiy = false;
    private boolean hiz = false;

    public void bw(boolean z) {
        this.bep = z;
        if (this.bep) {
            GM();
        }
    }

    public void GM() {
        if (this.ben != null && this.ben.isShowing()) {
            Context context = this.ben.getContext();
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
                this.ben.dismiss();
            } else {
                return;
            }
        }
        this.ben = null;
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
        if (!TbadkCoreApplication.getInst().isMobileBaidu() && !this.bep) {
            this.aIK = wVar;
            this.otherParams = str;
            if (this.aIK != null && this.aIK.aHG != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("test_firstRecharge", false);
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                boolean booleanValue = process.containsKey("test_firstRecharge") ? ((Boolean) process.get("test_firstRecharge")).booleanValue() : false;
                if (booleanValue) {
                    this.aIK.aHG.isNewUser = true;
                }
                this.hix = this.aIK.aHG.isNewUser;
                if (this.hix && !this.hiw && TbadkCoreApplication.isLogin() && (bnVar = com.baidu.live.aa.a.Ph().bsh) != null && bnVar.aNP != null && bnVar.aNP.aQg && (cdVar = bnVar.aNM) != null) {
                    this.aPh = cdVar.aPh;
                    if (this.aPh != null && !TextUtils.isEmpty(this.aPh.aPo)) {
                        int i4 = this.aPh.aPc;
                        int i5 = this.aPh.aPd;
                        final String b = k.b(new Date());
                        String string = d.Aq().getString("first_recharge_show_trace", "");
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
                                i2 = this.aPh.aOq;
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
                                        if (a.this.aIK != null && a.this.aIK.aHG != null && a.this.aIK.aHG.isNewUser) {
                                            a.this.a(context, a.this.aPh);
                                            a.this.a(b, a.this.aPh);
                                        }
                                    }
                                }, i2 * 1000);
                                this.hiw = true;
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
                        i2 = this.aPh.aOq;
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
                                if (a.this.aIK != null && a.this.aIK.aHG != null && a.this.aIK.aHG.isNewUser) {
                                    a.this.a(context, a.this.aPh);
                                    a.this.a(b, a.this.aPh);
                                }
                            }
                        }, i2 * 1000);
                        this.hiw = true;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final ce ceVar) {
        if (!this.bep) {
            GM();
            View inflate = LayoutInflater.from(context).inflate(a.g.dialog_first_recharge, (ViewGroup) null);
            final Dialog dialog = new Dialog(context, a.i.FlowerGuideDialogStyle);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(true);
            dialog.setContentView(inflate);
            dialog.setCanceledOnTouchOutside(false);
            this.mContentView = inflate;
            this.ben = dialog;
            cbz();
            inflate.findViewById(a.f.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    try {
                        a.this.GM();
                        if (a.this.aIK != null && a.this.aIK.mLiveInfo != null) {
                            String str = ceVar.aPo;
                            if (!TextUtils.isEmpty(str)) {
                                BrowserHelper.startInternalWebActivity(context, str.contains("?") ? str + "&liveId=" + a.this.aIK.mLiveInfo.live_id : str + "?liveId=" + a.this.aIK.mLiveInfo.live_id);
                                if (a.this.aIK != null) {
                                    LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupLog(a.this.aIK.mLiveInfo.live_id + "", a.this.aIK.mLiveInfo.room_id + "", a.this.aIK.mLiveInfo.feed_id, a.this.otherParams);
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
                        a.this.GM();
                        if (a.this.aIK != null) {
                            LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupCloseLog(a.this.aIK.mLiveInfo.live_id + "", a.this.aIK.mLiveInfo.room_id + "", a.this.aIK.mLiveInfo.feed_id, a.this.otherParams);
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
            if (!TextUtils.isEmpty(ceVar.aPn)) {
                tbImageView2.startLoad(ceVar.aPn, 10, false);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
            ofFloat.setRepeatCount(-1);
            ofFloat2.setRepeatCount(-1);
            this.hiv = new AnimatorSet();
            this.hiv.play(ofFloat).with(ofFloat2);
            this.hiv.setInterpolator(new AccelerateDecelerateInterpolator());
            this.hiv.setDuration(2000L);
            this.hiv.setStartDelay(0L);
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.4
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    if (a.this.hiv != null) {
                        a.this.hiv.start();
                    }
                }
            });
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.k.a.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (a.this.hiv != null) {
                        a.this.hiv.cancel();
                    }
                    a.this.hiw = false;
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
                            if (a.this.aIK != null) {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "firstRechargeDialog"));
                                if (dialog != null && !dialog.isShowing()) {
                                    dialog.show();
                                    if (a.this.aIK != null) {
                                        LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePopupLog(a.this.aIK.mLiveInfo.live_id + "", a.this.aIK.mLiveInfo.room_id + "", a.this.aIK.mLiveInfo.feed_id, a.this.otherParams);
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
            if (!TextUtils.isEmpty(ceVar.aPm)) {
                tbImageView.startLoad(ceVar.aPm, 10, false);
            }
        }
    }

    public void a(String str, ce ceVar) {
        int i;
        JSONArray jSONArray;
        int i2 = 0;
        if (ceVar != null) {
            try {
                i = ceVar.aPc;
                i2 = ceVar.aPd;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        } else {
            i = 0;
        }
        if (i >= 0 || i2 >= 0) {
            String string = d.Aq().getString("first_recharge_show_trace", "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            } else {
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("date", str);
            jSONArray.put(jSONObject);
            d.Aq().putString("first_recharge_show_trace", jSONArray.toString());
        }
    }

    public void onResume() {
        if (!this.hiy && this.hix && this.context != null && this.aIK != null && this.aIK.aHG != null && !this.aIK.aHG.isNewUser) {
            GM();
            if (this.hix && this.aPh != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913098, this.aPh.aHB));
            }
            this.hiy = true;
            cby();
        }
    }

    public void n(w wVar) {
        if (!this.hiz && this.hix && wVar != null && wVar.aHG != null) {
            boolean z = wVar.aHG.isNewUser;
            this.aIK = wVar;
            if (!z && this.hix) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913115));
                this.hiz = true;
                cby();
            }
        }
    }

    private void cby() {
        if (this.hiy && this.hiz) {
            this.hix = false;
        }
    }

    public void release() {
        this.hiw = false;
        this.aIK = null;
        this.handler.removeCallbacksAndMessages(null);
        GM();
        if (this.hiv != null) {
            this.hiv.cancel();
            this.hiv = null;
        }
    }

    public void FZ() {
        if (this.ben != null && this.ben.isShowing() && this.mContentView != null) {
            this.ben.show();
            cbz();
        }
    }

    private void cbz() {
        TbImageView tbImageView = (TbImageView) this.mContentView.findViewById(a.f.rechargeBg_imageView);
        tbImageView.setDefaultBgResource(a.e.sdk_shape_transparent);
        TbImageView tbImageView2 = (TbImageView) this.mContentView.findViewById(a.f.recharge_imageView);
        tbImageView2.setDefaultBgResource(a.e.sdk_shape_transparent);
        int dimension = (int) (this.context.getResources().getDimension(a.d.sdk_ds400) * 2.0f);
        int dimension2 = (int) this.context.getResources().getDimension(a.d.sdk_ds720);
        int dimension3 = (int) this.context.getResources().getDimension(a.d.sdk_ds176);
        int dimension4 = (int) this.context.getResources().getDimension(a.d.sdk_ds474);
        if (UtilHelper.getRealScreenOrientation(this.ben.getContext()) == 2) {
            int dimension5 = (int) (BdUtilHelper.getScreenDimensions(this.context)[1] - this.context.getResources().getDimension(a.d.sdk_ds120));
            tbImageView.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension) / (dimension + dimension3));
            tbImageView.getLayoutParams().width = (int) (((tbImageView.getLayoutParams().height * dimension2) * 1.0f) / dimension);
            tbImageView2.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension3) / (dimension + dimension3));
            tbImageView2.getLayoutParams().width = (int) (((tbImageView2.getLayoutParams().height * dimension4) * 1.0f) / dimension3);
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.ben.getWindow(), true, false);
            return;
        }
        tbImageView.getLayoutParams().height = dimension;
        tbImageView.getLayoutParams().width = dimension2;
        tbImageView2.getLayoutParams().height = dimension3;
        tbImageView2.getLayoutParams().width = dimension4;
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.ben.getWindow(), true, false);
        } else {
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.ben.getWindow(), false, false);
        }
    }
}

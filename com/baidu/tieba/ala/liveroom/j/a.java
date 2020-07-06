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
import com.baidu.live.c;
import com.baidu.live.data.bb;
import com.baidu.live.data.bl;
import com.baidu.live.data.bm;
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
/* loaded from: classes3.dex */
public class a {
    private bm aDQ;
    private Dialog aQQ;
    private q aye;
    private Context context;
    private AnimatorSet ghI;
    private View mContentView;
    private String otherParams;
    private boolean ghJ = false;
    private Handler handler = new Handler();
    private boolean ghK = false;
    private boolean ghL = false;
    private boolean ghM = false;

    public void yY() {
        if (this.aQQ != null && this.aQQ.isShowing()) {
            Context context = this.aQQ.getContext();
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
                this.aQQ.dismiss();
            } else {
                return;
            }
        }
        this.aQQ = null;
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
        bb bbVar;
        bl blVar;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        int i;
        int i2;
        int i3 = 0;
        this.context = context;
        if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.aye = qVar;
            this.otherParams = str;
            if (this.aye != null && this.aye.axI != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("test_firstRecharge", false);
                Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
                boolean booleanValue = process.containsKey("test_firstRecharge") ? ((Boolean) process.get("test_firstRecharge")).booleanValue() : false;
                if (booleanValue) {
                    this.aye.axI.isNewUser = true;
                }
                this.ghK = this.aye.axI.isNewUser;
                if (this.ghK && !this.ghJ && TbadkCoreApplication.isLogin() && (bbVar = com.baidu.live.v.a.Hm().bdV) != null && bbVar.aCW != null && bbVar.aCW.aEM && (blVar = bbVar.aCT) != null) {
                    this.aDQ = blVar.aDQ;
                    if (this.aDQ != null && !TextUtils.isEmpty(this.aDQ.aDX)) {
                        int i4 = this.aDQ.aDK;
                        int i5 = this.aDQ.aDL;
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
                                i2 = this.aDQ.aDM;
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
                                        if (a.this.aye != null && a.this.aye.axI != null && a.this.aye.axI.isNewUser) {
                                            a.this.a(context, a.this.aDQ);
                                            a.this.a(b, a.this.aDQ);
                                        }
                                    }
                                }, i2 * 1000);
                                this.ghJ = true;
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
                        i2 = this.aDQ.aDM;
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
                                if (a.this.aye != null && a.this.aye.axI != null && a.this.aye.axI.isNewUser) {
                                    a.this.a(context, a.this.aDQ);
                                    a.this.a(b, a.this.aDQ);
                                }
                            }
                        }, i2 * 1000);
                        this.ghJ = true;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final bm bmVar) {
        yY();
        View inflate = LayoutInflater.from(context).inflate(a.h.dialog_first_recharge, (ViewGroup) null);
        final Dialog dialog = new Dialog(context, a.j.FlowerGuideDialogStyle);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        this.mContentView = inflate;
        this.aQQ = dialog;
        bEG();
        inflate.findViewById(a.g.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    a.this.yY();
                    if (a.this.aye != null && a.this.aye.mLiveInfo != null) {
                        String str = bmVar.aDX;
                        if (!TextUtils.isEmpty(str)) {
                            BrowserHelper.startInternalWebActivity(context, str.contains("?") ? str + "&liveId=" + a.this.aye.mLiveInfo.live_id : str + "?liveId=" + a.this.aye.mLiveInfo.live_id);
                            if (a.this.aye != null) {
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupLog(a.this.aye.mLiveInfo.live_id + "", a.this.aye.mLiveInfo.room_id + "", a.this.aye.mLiveInfo.feed_id, a.this.otherParams);
                                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "firstcharg_clk").setContentExt(null, "popup", null));
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    a.this.yY();
                    if (a.this.aye != null) {
                        LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupCloseLog(a.this.aye.mLiveInfo.live_id + "", a.this.aye.mLiveInfo.room_id + "", a.this.aye.mLiveInfo.feed_id, a.this.otherParams);
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
        if (!TextUtils.isEmpty(bmVar.aDW)) {
            tbImageView2.startLoad(bmVar.aDW, 10, false);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat2.setRepeatCount(-1);
        this.ghI = new AnimatorSet();
        this.ghI.play(ofFloat).with(ofFloat2);
        this.ghI.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ghI.setDuration(2000L);
        this.ghI.setStartDelay(0L);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.j.a.4
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.ghI != null) {
                    a.this.ghI.start();
                }
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.j.a.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.ghI != null) {
                    a.this.ghI.cancel();
                }
                a.this.ghJ = false;
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
                        if (a.this.aye != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "firstRechargeDialog"));
                            if (dialog != null && !dialog.isShowing()) {
                                dialog.show();
                                if (a.this.aye != null) {
                                    LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePopupLog(a.this.aye.mLiveInfo.live_id + "", a.this.aye.mLiveInfo.room_id + "", a.this.aye.mLiveInfo.feed_id, a.this.otherParams);
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
        if (!TextUtils.isEmpty(bmVar.aDV)) {
            tbImageView.startLoad(bmVar.aDV, 10, false);
        }
    }

    public void a(String str, bm bmVar) {
        int i;
        JSONArray jSONArray;
        int i2 = 0;
        if (bmVar != null) {
            try {
                i = bmVar.aDK;
                i2 = bmVar.aDL;
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
        if (!this.ghL && this.ghK && this.context != null && this.aye != null && this.aye.axI != null && !this.aye.axI.isNewUser) {
            yY();
            if (this.ghK && this.aDQ != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913098, this.aDQ.ayj));
            }
            this.ghL = true;
            bEF();
        }
    }

    public void t(q qVar) {
        if (!this.ghM && this.ghK && qVar != null && qVar.axI != null) {
            boolean z = qVar.axI.isNewUser;
            this.aye = qVar;
            if (!z && this.ghK) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913115));
                this.ghM = true;
                bEF();
            }
        }
    }

    private void bEF() {
        if (this.ghL && this.ghM) {
            this.ghK = false;
        }
    }

    public void release() {
        this.ghJ = false;
        this.aye = null;
        this.handler.removeCallbacksAndMessages(null);
        yY();
        if (this.ghI != null) {
            this.ghI.cancel();
            this.ghI = null;
        }
    }

    public void yA() {
        if (this.aQQ != null && this.aQQ.isShowing() && this.mContentView != null) {
            this.aQQ.show();
            bEG();
        }
    }

    private void bEG() {
        TbImageView tbImageView = (TbImageView) this.mContentView.findViewById(a.g.rechargeBg_imageView);
        tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
        TbImageView tbImageView2 = (TbImageView) this.mContentView.findViewById(a.g.recharge_imageView);
        tbImageView2.setDefaultBgResource(a.f.sdk_shape_transparent);
        int dimension = (int) (this.context.getResources().getDimension(a.e.sdk_ds400) * 2.0f);
        int dimension2 = (int) this.context.getResources().getDimension(a.e.sdk_ds720);
        int dimension3 = (int) this.context.getResources().getDimension(a.e.sdk_ds176);
        int dimension4 = (int) this.context.getResources().getDimension(a.e.sdk_ds474);
        if (UtilHelper.getRealScreenOrientation(this.aQQ.getContext()) == 2) {
            int dimension5 = (int) (BdUtilHelper.getScreenDimensions(this.context)[1] - this.context.getResources().getDimension(a.e.sdk_ds120));
            tbImageView.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension) / (dimension + dimension3));
            tbImageView.getLayoutParams().width = (int) (((tbImageView.getLayoutParams().height * dimension2) * 1.0f) / dimension);
            tbImageView2.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension3) / (dimension + dimension3));
            tbImageView2.getLayoutParams().width = (int) (((tbImageView2.getLayoutParams().height * dimension4) * 1.0f) / dimension3);
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.aQQ.getWindow(), true, false);
            return;
        }
        tbImageView.getLayoutParams().height = dimension;
        tbImageView.getLayoutParams().width = dimension2;
        tbImageView2.getLayoutParams().height = dimension3;
        tbImageView2.getLayoutParams().width = dimension4;
        UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.aQQ.getWindow(), true, false);
    }
}

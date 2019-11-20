package com.baidu.tieba.ala.liveroom.h;

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
import com.baidu.live.data.af;
import com.baidu.live.data.al;
import com.baidu.live.data.am;
import com.baidu.live.data.i;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private i Pv;
    private am Ur;
    private Context context;
    private Dialog efD;
    private AnimatorSet efE;
    private View mContentView;
    private String otherParams;
    private boolean efF = false;
    private Handler handler = new Handler();
    private boolean efG = false;
    private boolean efH = false;
    private boolean efI = false;

    public void aAk() {
        if (this.efD != null && this.efD.isShowing()) {
            Context context = this.efD.getContext();
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
                this.efD.dismiss();
            } else {
                return;
            }
        }
        this.efD = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(final Context context, i iVar, String str) {
        af afVar;
        al alVar;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        int i;
        int i2;
        int i3 = 0;
        this.context = context;
        this.Pv = iVar;
        this.otherParams = str;
        if (this.Pv != null && this.Pv.Pj != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("test_firstRecharge", false);
            Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
            boolean booleanValue = process.containsKey("test_firstRecharge") ? ((Boolean) process.get("test_firstRecharge")).booleanValue() : false;
            if (booleanValue) {
                this.Pv.Pj.isNewUser = true;
            }
            this.efG = this.Pv.Pj.isNewUser;
            if (this.efG && !this.efF && TbadkCoreApplication.isLogin() && (afVar = com.baidu.live.l.a.uB().aku) != null && afVar.TO != null && afVar.TO.UU && (alVar = afVar.TK) != null) {
                this.Ur = alVar.Ur;
                if (this.Ur != null && !TextUtils.isEmpty(this.Ur.Uw)) {
                    int i4 = this.Ur.Ul;
                    int i5 = this.Ur.Um;
                    final String b = com.baidu.live.utils.i.b(new Date());
                    String string = c.np().getString("first_recharge_show_trace", "");
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
                            i2 = this.Ur.Un;
                            if (i2 <= 0) {
                                i2 = 20;
                            }
                            if (booleanValue) {
                                i2 = 5;
                            }
                            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.a.1
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
                                    if (a.this.Pv != null && a.this.Pv.Pj != null && a.this.Pv.Pj.isNewUser) {
                                        a.this.a(context, a.this.Ur);
                                        a.this.a(b, a.this.Ur);
                                    }
                                }
                            }, i2 * 1000);
                            this.efF = true;
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
                    i2 = this.Ur.Un;
                    if (i2 <= 0) {
                    }
                    if (booleanValue) {
                    }
                    this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.h.a.1
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
                            if (a.this.Pv != null && a.this.Pv.Pj != null && a.this.Pv.Pj.isNewUser) {
                                a.this.a(context, a.this.Ur);
                                a.this.a(b, a.this.Ur);
                            }
                        }
                    }, i2 * 1000);
                    this.efF = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, final am amVar) {
        aAk();
        View inflate = LayoutInflater.from(context).inflate(a.h.dialog_first_recharge, (ViewGroup) null);
        final Dialog dialog = new Dialog(context, a.j.FlowerGuideDialogStyle);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        this.mContentView = inflate;
        this.efD = dialog;
        aRR();
        inflate.findViewById(a.g.main_layout).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    a.this.aAk();
                    if (a.this.Pv != null && a.this.Pv.mLiveInfo != null) {
                        String str = amVar.Uw;
                        if (!TextUtils.isEmpty(str)) {
                            BrowserHelper.startInternalWebActivity(context, str.contains("?") ? str + "&liveId=" + a.this.Pv.mLiveInfo.live_id : str + "?liveId=" + a.this.Pv.mLiveInfo.live_id);
                            if (a.this.Pv != null) {
                                LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupLog(a.this.Pv.mLiveInfo.live_id + "", a.this.Pv.mLiveInfo.room_id + "", a.this.Pv.mLiveInfo.feed_id, a.this.otherParams);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.h.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    a.this.aAk();
                    if (a.this.Pv != null) {
                        LogManager.getFirstChargeLogger().doClickLiveFirstChargePopupCloseLog(a.this.Pv.mLiveInfo.live_id + "", a.this.Pv.mLiveInfo.room_id + "", a.this.Pv.mLiveInfo.feed_id, a.this.otherParams);
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
        if (!TextUtils.isEmpty(amVar.Uv)) {
            tbImageView2.startLoad(amVar.Uv, 10, false);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(tbImageView2, "scaleX", 1.0f, 1.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(tbImageView2, "scaleY", 1.0f, 1.2f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat2.setRepeatCount(-1);
        this.efE = new AnimatorSet();
        this.efE.play(ofFloat).with(ofFloat2);
        this.efE.setInterpolator(new AccelerateDecelerateInterpolator());
        this.efE.setDuration(2000L);
        this.efE.setStartDelay(0L);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.baidu.tieba.ala.liveroom.h.a.4
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (a.this.efE != null) {
                    a.this.efE.start();
                }
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.h.a.5
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (a.this.efE != null) {
                    a.this.efE.cancel();
                }
                a.this.efF = false;
            }
        });
        tbImageView.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.liveroom.h.a.6
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
                        if (a.this.Pv != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "firstRechargeDialog"));
                            if (dialog != null && !dialog.isShowing()) {
                                dialog.show();
                                if (a.this.Pv != null) {
                                    LogManager.getFirstChargeLogger().doDisplayLiveFirstChargePopupLog(a.this.Pv.mLiveInfo.live_id + "", a.this.Pv.mLiveInfo.room_id + "", a.this.Pv.mLiveInfo.feed_id, a.this.otherParams);
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
        if (!TextUtils.isEmpty(amVar.Uu)) {
            tbImageView.startLoad(amVar.Uu, 10, false);
        }
    }

    public void a(String str, am amVar) {
        int i;
        JSONArray jSONArray;
        int i2 = 0;
        if (amVar != null) {
            try {
                i = amVar.Ul;
                i2 = amVar.Um;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        } else {
            i = 0;
        }
        if (i >= 0 || i2 >= 0) {
            String string = c.np().getString("first_recharge_show_trace", "");
            if (!TextUtils.isEmpty(string)) {
                jSONArray = new JSONArray(string);
            } else {
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("date", str);
            jSONArray.put(jSONObject);
            c.np().putString("first_recharge_show_trace", jSONArray.toString());
        }
    }

    public void onResume() {
        if (!this.efH && this.efG && this.context != null && this.Pv != null && this.Pv.Pj != null && !this.Pv.Pj.isNewUser) {
            aAk();
            if (this.efG && this.Ur != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913098, this.Ur.Ut));
            }
            this.efH = true;
            aRQ();
        }
    }

    public void j(i iVar) {
        if (!this.efI && this.efG && iVar != null && iVar.Pj != null) {
            boolean z = iVar.Pj.isNewUser;
            this.Pv = iVar;
            if (!z && this.efG) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913115));
                this.efI = true;
                aRQ();
            }
        }
    }

    private void aRQ() {
        if (this.efH && this.efI) {
            this.efG = false;
        }
    }

    public void release() {
        this.efF = false;
        this.Pv = null;
        this.handler.removeCallbacksAndMessages(null);
        aAk();
        if (this.efE != null) {
            this.efE.cancel();
            this.efE = null;
        }
    }

    public void pC() {
        if (this.efD != null && this.efD.isShowing() && this.mContentView != null) {
            this.efD.show();
            aRR();
        }
    }

    private void aRR() {
        TbImageView tbImageView = (TbImageView) this.mContentView.findViewById(a.g.rechargeBg_imageView);
        tbImageView.setDefaultBgResource(a.f.sdk_shape_transparent);
        TbImageView tbImageView2 = (TbImageView) this.mContentView.findViewById(a.g.recharge_imageView);
        tbImageView2.setDefaultBgResource(a.f.sdk_shape_transparent);
        int dimension = (int) (this.context.getResources().getDimension(a.e.sdk_ds400) * 2.0f);
        int dimension2 = (int) this.context.getResources().getDimension(a.e.sdk_ds720);
        int dimension3 = (int) this.context.getResources().getDimension(a.e.sdk_ds176);
        int dimension4 = (int) this.context.getResources().getDimension(a.e.sdk_ds474);
        if (UtilHelper.getRealScreenOrientation(this.efD.getContext()) == 2) {
            int dimension5 = (int) (BdUtilHelper.getScreenDimensions(this.context)[1] - this.context.getResources().getDimension(a.e.sdk_ds120));
            tbImageView.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension) / (dimension + dimension3));
            tbImageView.getLayoutParams().width = (int) (((tbImageView.getLayoutParams().height * dimension2) * 1.0f) / dimension);
            tbImageView2.getLayoutParams().height = (int) (((dimension5 * 1.0f) * dimension3) / (dimension + dimension3));
            tbImageView2.getLayoutParams().width = (int) (((tbImageView2.getLayoutParams().height * dimension4) * 1.0f) / dimension3);
            UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.efD.getWindow(), true, false);
            return;
        }
        tbImageView.getLayoutParams().height = dimension;
        tbImageView.getLayoutParams().width = dimension2;
        tbImageView2.getLayoutParams().height = dimension3;
        tbImageView2.getLayoutParams().width = dimension4;
        UtilHelper.useNavigationBarStyleImmersiveSticky_L(this.efD.getWindow(), true, false);
    }
}

package com.baidu.tieba.ala.liveroom.task;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.c.f;
import com.baidu.live.data.ax;
import com.baidu.live.data.bg;
import com.baidu.live.data.bi;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.u.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.x.c {
    private static volatile b geC = null;
    private Dialog aOk;
    private long currLiveId;
    private boolean geD = false;
    private boolean geE = false;
    private Handler handler = new Handler();
    private long startTime;

    public static b bGn() {
        if (geC == null) {
            synchronized (b.class) {
                if (geC == null) {
                    geC = new b();
                }
            }
        }
        return geC;
    }

    @Override // com.baidu.live.x.c
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

    @Override // com.baidu.live.x.c
    public void b(final Context context, final long j, long j2, String str, String str2) {
        if (TbConfig.FLOWER_GUIDE_STATUS != 2) {
            this.currLiveId = 0L;
            this.geD = false;
            this.geE = false;
            if (!isEnable(str2)) {
                if (TbConfig.FLOWER_GUIDE_STATUS != 2) {
                    TbConfig.FLOWER_GUIDE_STATUS = 0;
                    return;
                }
                return;
            }
            TbConfig.FLOWER_GUIDE_STATUS = 1;
            this.currLiveId = j;
            this.startTime = System.currentTimeMillis();
            this.geE = true;
            if (isDebug()) {
                this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.task.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a(context, j, new int[]{967, 1357});
                    }
                }, 5000L);
            }
        }
    }

    private boolean isDebug() {
        HashMap hashMap = new HashMap();
        hashMap.put("debug_flower_guide", false);
        Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
        if (process.containsKey("debug_flower_guide")) {
            return ((Boolean) process.get("debug_flower_guide")).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.live.x.c
    public void a(Context context, long j, int[] iArr) {
        boolean isDebug = isDebug();
        if (this.geE && this.startTime > 0 && this.currLiveId == j) {
            if ((!this.geD || TbadkCoreApplication.getInst().currentAccountFlowerNum <= 0 || isDebug) && TbadkCoreApplication.isLogin()) {
                long j2 = 60;
                if (isDebug) {
                    j2 = 3;
                }
                if (System.currentTimeMillis() - this.startTime >= j2 * 1000 && al(context)) {
                    a(context, iArr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, int[] iArr) {
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.01f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.01f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, (iArr[0] - iArr2[0]) - (view.getWidth() / 2));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, (iArr[1] - iArr2[1]) - (view.getHeight() / 2));
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(1000L);
        animatorSet.setStartDelay(0L);
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.task.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.yy();
            }
        });
    }

    private void a(final Context context, final int[] iArr) {
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
        if (this.aOk != null && this.aOk.isShowing()) {
            this.aOk.dismiss();
        }
        View inflate = LayoutInflater.from(context).inflate(a.h.dialog_flower_guide, (ViewGroup) null);
        final Dialog dialog = new Dialog(context, a.j.FlowerGuideDialogStyle);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setContentView(inflate);
        dialog.setCanceledOnTouchOutside(false);
        final View findViewById = inflate.findViewById(a.g.main_layout);
        final Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.task.b.3
            @Override // java.lang.Runnable
            public void run() {
                if (iArr != null && iArr.length >= 2 && (iArr[0] != 0 || iArr[1] != 0)) {
                    b.this.b(findViewById, iArr);
                } else {
                    b.this.yy();
                }
            }
        };
        this.handler.postDelayed(runnable, 5000L);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.task.b.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.handler.removeCallbacks(runnable);
                try {
                    Activity activity2 = (Activity) context;
                    if (Build.VERSION.SDK_INT >= 17) {
                        if (!activity2.isDestroyed() && !activity2.isFinishing()) {
                            dialog.dismiss();
                        }
                    } else if (!activity2.isFinishing()) {
                        dialog.dismiss();
                    }
                    b.this.ez(context);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ((ImageView) inflate.findViewById(a.g.close_imageView)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.task.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.handler.removeCallbacks(runnable);
                try {
                    dialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            dialog.show();
            this.aOk = dialog;
            this.geE = false;
            com.baidu.live.c.uN().putInt("showtimes_flower_task_dialog", com.baidu.live.c.uN().getInt("showtimes_flower_task_dialog", 0) + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ez(Context context) {
        f fVar = new f(context);
        fVar.aM(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, fVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0094, code lost:
        if (android.text.TextUtils.equals(r0, "kanzhibo-0-kanzhibo") == false) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isEnable(String str) {
        ax axVar;
        bg bgVar;
        bi biVar;
        boolean isDebug = isDebug();
        if ((!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin()) || !TbadkCoreApplication.isLogin() || (axVar = com.baidu.live.v.a.Ge().aYP) == null || (bgVar = axVar.aAI) == null || (biVar = bgVar.aBE) == null) {
            return false;
        }
        if (!(biVar.isShow == 1)) {
            TbConfig.FLOWER_GUIDE_STATUS = 2;
            return false;
        } else if (com.baidu.live.c.uN().getInt("showtimes_flower_task_dialog", 0) >= biVar.showNum && !isDebug) {
            TbConfig.FLOWER_GUIDE_STATUS = 2;
            return false;
        } else {
            boolean z = biVar.aBN == 1;
            long j = TbadkCoreApplication.getInst().currentAccountFlowerNum;
            if (z) {
                if (TbadkCoreApplication.getInst().isHaokan()) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            String optString = jSONObject.optString("tab");
                            String optString2 = jSONObject.optString("source");
                            if (TextUtils.equals(optString, "guide")) {
                            }
                            if (!isDebug) {
                                return false;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                    if (j > 0 && !isDebug) {
                        return false;
                    }
                    this.geD = true;
                }
            } else if (j > 0 && !isDebug) {
                return false;
            } else {
                this.geD = true;
            }
            return true;
        }
    }

    @Override // com.baidu.live.x.c
    public void release() {
        this.currLiveId = 0L;
        this.geD = false;
        this.geE = false;
        TbConfig.FLOWER_GUIDE_STATUS = 0;
        this.handler.removeCallbacksAndMessages(null);
        yy();
    }

    private boolean al(Context context) {
        return UtilHelper.getRealScreenOrientation(context) != 2;
    }
}

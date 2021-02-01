package com.baidu.tieba.ala.liveroom.task;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.live.d;
import com.baidu.live.data.bv;
import com.baidu.live.data.co;
import com.baidu.live.data.cq;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements com.baidu.live.ag.c {
    private static volatile b hOr = null;
    private Dialog biA;
    private long currLiveId;
    private boolean hOs = false;
    private boolean hOt = false;
    private Handler handler = new Handler();
    private long startTime;

    public static b ckz() {
        if (hOr == null) {
            synchronized (b.class) {
                if (hOr == null) {
                    hOr = new b();
                }
            }
        }
        return hOr;
    }

    @Override // com.baidu.live.ag.c
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

    @Override // com.baidu.live.ag.c
    public void b(final Context context, final long j, long j2, String str, String str2) {
        if (TbConfig.FLOWER_GUIDE_STATUS != 2) {
            this.currLiveId = 0L;
            this.hOs = false;
            this.hOt = false;
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
            this.hOt = true;
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

    @Override // com.baidu.live.ag.c
    public void a(Context context, long j, int[] iArr) {
        boolean isDebug = isDebug();
        if (this.hOt && this.startTime > 0 && this.currLiveId == j) {
            if ((!this.hOs || TbadkCoreApplication.getInst().currentAccountFlowerNum <= 0 || isDebug) && TbadkCoreApplication.isLogin()) {
                long j2 = 60;
                if (isDebug) {
                    j2 = 3;
                }
                if (System.currentTimeMillis() - this.startTime >= j2 * 1000 && aT(context)) {
                    a(context, iArr);
                }
            }
        }
    }

    private void a(Context context, int[] iArr) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x009e, code lost:
        if (android.text.TextUtils.equals(r0, "kanzhibo-0-kanzhibo") == false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean isEnable(String str) {
        bv bvVar;
        co coVar;
        cq cqVar;
        boolean isDebug = isDebug();
        if ((!TbadkCoreApplication.getInst().isHaokan() && !TbadkCoreApplication.getInst().isQuanmin() && !TbadkCoreApplication.getInst().isYinbo()) || !TbadkCoreApplication.isLogin() || (bvVar = com.baidu.live.ae.a.Qj().bAS) == null || (coVar = bvVar.aPM) == null || (cqVar = coVar.aRt) == null) {
            return false;
        }
        if (!(cqVar.isShow == 1)) {
            TbConfig.FLOWER_GUIDE_STATUS = 2;
            return false;
        } else if (d.xc().getInt("showtimes_flower_task_dialog", 0) >= cqVar.showNum && !isDebug) {
            TbConfig.FLOWER_GUIDE_STATUS = 2;
            return false;
        } else {
            boolean z = cqVar.aRG == 1;
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
                } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    if (j > 0 && !isDebug) {
                        return false;
                    }
                    this.hOs = true;
                }
            } else if (j > 0 && !isDebug) {
                return false;
            } else {
                this.hOs = true;
            }
            return true;
        }
    }

    @Override // com.baidu.live.ag.c
    public void release() {
        this.currLiveId = 0L;
        this.hOs = false;
        this.hOt = false;
        TbConfig.FLOWER_GUIDE_STATUS = 0;
        this.handler.removeCallbacksAndMessages(null);
        FA();
    }

    private boolean aT(Context context) {
        return UtilHelper.getRealScreenOrientation(context) != 2;
    }
}

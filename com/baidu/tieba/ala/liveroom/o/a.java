package com.baidu.tieba.ala.liveroom.o;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ab;
import com.baidu.live.data.ar;
import com.baidu.live.entereffect.b.d;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.facebook.imagepipeline.c.j;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a {
    private Context context;
    private long hLa;
    private long hLb;
    private long hLc;
    private int hLd;
    private int hLe;
    private int hLf;
    private int hLg;
    private int hLh;
    private int hLi;
    private int hLj;
    public boolean hKZ = false;
    private Handler handler = new Handler();
    private boolean isDebug = false;
    private boolean hLk = false;
    private List<ab> hLl = new ArrayList();
    Runnable hLm = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
        @Override // java.lang.Runnable
        public void run() {
            ar arVar = com.baidu.live.ae.a.Qj().buX;
            if (arVar != null) {
                a.this.cjO();
                int i = arVar.aNz;
                if (i <= 0) {
                    i = 15;
                }
                a.this.handler.postDelayed(a.this.hLm, i * 1000);
                if (a.this.isDebug) {
                    for (int i2 = 0; i2 < 2000; i2++) {
                        a.this.hLl.add(new ab());
                    }
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
    }

    public long cjL() {
        long j = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long j2 = j - freeMemory;
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @getUsedMemory totalMemory=" + j + ", freeMemory=" + freeMemory + ", usedMemory=" + j2);
        return j2;
    }

    public void cjM() {
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @startMemoryMonitor");
        ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar != null) {
            Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @startMemoryMonitor memoryTest = " + arVar.aNy + ", timeInterval = " + arVar.aNz + ", warnText = " + arVar.aNA + ", availableAlarmThreshold=" + arVar.aNB + ", availableResumeThreshold=" + arVar.aNC + ", queueLimitRatio=" + arVar.aND);
            if (this.isDebug) {
                arVar.aNy = 1;
                arVar.aNA = "内存清理提示文案";
                arVar.aNz = 5;
            }
            boolean z = arVar.aNy == 1;
            if (z) {
                this.hKZ = true;
                int i = arVar.aNz;
                if (i <= 0) {
                    i = 15;
                }
                Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @startMemoryMonitor isMonitor=" + z);
                cjN();
                this.handler.postDelayed(this.hLm, i * 1000);
                Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @startMemoryMonitor end");
            }
        }
    }

    private void cjN() {
        this.hLa = cjL();
        long maxMemory = Runtime.getRuntime().maxMemory();
        long j = maxMemory - this.hLa;
        ar arVar = com.baidu.live.ae.a.Qj().buX;
        float f = arVar.aNB;
        float f2 = arVar.aNC;
        this.hLb = maxMemory - (f * ((float) j));
        if (this.hLb < this.hLa) {
            this.hLb = maxMemory;
        }
        this.hLc = maxMemory - (f2 * ((float) j));
        if (this.isDebug) {
            this.hLb = this.hLa * 2;
            this.hLc = (long) (this.hLb * 0.8d);
        }
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @recordStartLive usedMemory=" + this.hLa + ", maxMemory=" + maxMemory + ", sub=" + j + ", alarmThreshold=" + this.hLb + ", resumeThreshold=" + this.hLc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjO() {
        long cjL = cjL();
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @checkUsedMemory usedMemory=" + cjL + ", alarmThreshold=" + this.hLb + ", resumeThreshold=" + this.hLc);
        if (cjL >= this.hLb) {
            this.hLk = true;
            Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @checkUsedMemory doCleanMemory");
            String str = com.baidu.live.ae.a.Qj().buX.aNA;
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.context, str);
            }
            cjP();
            float f = com.baidu.live.ae.a.Qj().buX.aND;
            if (f >= 1.0f) {
                f = 0.7f;
            } else if (f <= 0.0f) {
                f = 0.1f;
            }
            aC(f);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("used_memory", cjL);
                jSONObject.put("alarm_threshold", this.hLb);
                jSONObject.put("type", NotificationCompat.CATEGORY_ALARM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MEMORY, "memory", "liveroom", "memory_limit").setContentExt(null, null, jSONObject));
        } else if (this.hLk && cjL <= this.hLc) {
            Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @checkUsedMemory doResume");
            this.hLk = false;
            cjQ();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("used_memory", cjL);
                jSONObject2.put("resume_threshold", this.hLc);
                jSONObject2.put("type", "resume");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MEMORY, "memory", "liveroom", "memory_limit").setContentExt(null, null, jSONObject2));
        }
    }

    private void cjP() {
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @cleanMemory");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913300, ""));
        d.Df().release();
        j.ext().ety().ewG();
    }

    private void aC(float f) {
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @updateTempQueueLimit originalQueueLimitImMax=" + this.hLd);
        if (this.hLd <= 0) {
            this.hLd = com.baidu.live.ae.a.Qj().buX.aMQ;
            this.hLe = com.baidu.live.ae.a.Qj().buX.aMR;
            this.hLf = com.baidu.live.ae.a.Qj().buX.aMS;
            this.hLg = com.baidu.live.ae.a.Qj().buX.aMT;
            this.hLh = com.baidu.live.ae.a.Qj().buX.aMU;
            this.hLi = com.baidu.live.ae.a.Qj().buX.aMW;
            this.hLj = com.baidu.live.ae.a.Qj().buX.aMX;
            Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @updateTempQueueLimit originalQueueLimitImMax=" + this.hLd + ", originalQueueLimitBarrageMax=" + this.hLe + ", originalQueueLimitPayBarrageMax=" + this.hLf + ", originalQueueLimitEnterEffectMax=" + this.hLg + ", originalQueueLimitGiftBigMax=" + this.hLh + ", originalQueueLimitGiftSmallMax=" + this.hLi + ", originalQueueLimitGiftGraffitiMax=" + this.hLj);
        }
        int i = (int) (this.hLd * f);
        if (i <= 0) {
            i = 5;
        }
        com.baidu.live.ae.a.Qj().buX.aMQ = i;
        int i2 = (int) (this.hLe * f);
        if (i2 <= 0) {
            i2 = 1;
        }
        com.baidu.live.ae.a.Qj().buX.aMR = i2;
        int i3 = (int) (this.hLf * f);
        if (i3 <= 0) {
            i3 = 1;
        }
        com.baidu.live.ae.a.Qj().buX.aMS = i3;
        int i4 = (int) (this.hLg * f);
        if (i4 <= 0) {
            i4 = 1;
        }
        com.baidu.live.ae.a.Qj().buX.aMT = i4;
        int i5 = (int) (this.hLh * f);
        if (i5 <= 0) {
            i5 = 1;
        }
        com.baidu.live.ae.a.Qj().buX.aMU = i5;
        int i6 = (int) (this.hLi * f);
        if (i6 <= 0) {
            i6 = 1;
        }
        com.baidu.live.ae.a.Qj().buX.aMW = i6;
        int i7 = (int) (this.hLj * f);
        int i8 = i7 > 0 ? i7 : 1;
        com.baidu.live.ae.a.Qj().buX.aMX = i8;
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @updateTempQueueLimit queueLimitImMax=" + i + ", queueLimitBarrageMax=" + i2 + ", queueLimitPayBarrageMax=" + i3 + ", queueLimitEnterEffectMax=" + i4 + ", queueLimitGiftBigMax=" + i5 + ", queueLimitGiftSmallMax=" + i6 + ", queueLimitGiftGraffitiMax=" + i8);
    }

    private void cjQ() {
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @resumeQueueLimit originalQueueLimitImMax=" + this.hLd);
        if (this.hLd > 0) {
            com.baidu.live.ae.a.Qj().buX.aMQ = this.hLd;
            com.baidu.live.ae.a.Qj().buX.aMR = this.hLe;
            com.baidu.live.ae.a.Qj().buX.aMS = this.hLf;
            com.baidu.live.ae.a.Qj().buX.aMT = this.hLg;
            com.baidu.live.ae.a.Qj().buX.aMU = this.hLh;
            com.baidu.live.ae.a.Qj().buX.aMW = this.hLi;
            com.baidu.live.ae.a.Qj().buX.aMX = this.hLj;
            this.hLd = 0;
        }
    }

    public void aCV() {
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @stopMonitor");
        this.handler.removeCallbacksAndMessages(null);
        this.hKZ = false;
        this.hLd = 0;
        this.hLe = 0;
        this.hLf = 0;
        this.hLg = 0;
        this.hLh = 0;
        this.hLi = 0;
        this.hLj = 0;
    }
}

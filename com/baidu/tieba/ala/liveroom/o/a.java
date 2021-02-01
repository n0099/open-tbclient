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
    private long hKM;
    private long hKN;
    private long hKO;
    private int hKP;
    private int hKQ;
    private int hKR;
    private int hKS;
    private int hKT;
    private int hKU;
    private int hKV;
    public boolean hKL = false;
    private Handler handler = new Handler();
    private boolean isDebug = false;
    private boolean hKW = false;
    private List<ab> hKX = new ArrayList();
    Runnable hKY = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
        @Override // java.lang.Runnable
        public void run() {
            ar arVar = com.baidu.live.ae.a.Qj().buX;
            if (arVar != null) {
                a.this.cjH();
                int i = arVar.aNz;
                if (i <= 0) {
                    i = 15;
                }
                a.this.handler.postDelayed(a.this.hKY, i * 1000);
                if (a.this.isDebug) {
                    for (int i2 = 0; i2 < 2000; i2++) {
                        a.this.hKX.add(new ab());
                    }
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
    }

    public long cjE() {
        long j = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long j2 = j - freeMemory;
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @getUsedMemory totalMemory=" + j + ", freeMemory=" + freeMemory + ", usedMemory=" + j2);
        return j2;
    }

    public void cjF() {
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
                this.hKL = true;
                int i = arVar.aNz;
                if (i <= 0) {
                    i = 15;
                }
                Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @startMemoryMonitor isMonitor=" + z);
                cjG();
                this.handler.postDelayed(this.hKY, i * 1000);
                Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @startMemoryMonitor end");
            }
        }
    }

    private void cjG() {
        this.hKM = cjE();
        long maxMemory = Runtime.getRuntime().maxMemory();
        long j = maxMemory - this.hKM;
        ar arVar = com.baidu.live.ae.a.Qj().buX;
        float f = arVar.aNB;
        float f2 = arVar.aNC;
        this.hKN = maxMemory - (f * ((float) j));
        if (this.hKN < this.hKM) {
            this.hKN = maxMemory;
        }
        this.hKO = maxMemory - (f2 * ((float) j));
        if (this.isDebug) {
            this.hKN = this.hKM * 2;
            this.hKO = (long) (this.hKN * 0.8d);
        }
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @recordStartLive usedMemory=" + this.hKM + ", maxMemory=" + maxMemory + ", sub=" + j + ", alarmThreshold=" + this.hKN + ", resumeThreshold=" + this.hKO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjH() {
        long cjE = cjE();
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @checkUsedMemory usedMemory=" + cjE + ", alarmThreshold=" + this.hKN + ", resumeThreshold=" + this.hKO);
        if (cjE >= this.hKN) {
            this.hKW = true;
            Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @checkUsedMemory doCleanMemory");
            String str = com.baidu.live.ae.a.Qj().buX.aNA;
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.context, str);
            }
            cjI();
            float f = com.baidu.live.ae.a.Qj().buX.aND;
            if (f >= 1.0f) {
                f = 0.7f;
            } else if (f <= 0.0f) {
                f = 0.1f;
            }
            aC(f);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("used_memory", cjE);
                jSONObject.put("alarm_threshold", this.hKN);
                jSONObject.put("type", NotificationCompat.CATEGORY_ALARM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MEMORY, "memory", "liveroom", "memory_limit").setContentExt(null, null, jSONObject));
        } else if (this.hKW && cjE <= this.hKO) {
            Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @checkUsedMemory doResume");
            this.hKW = false;
            cjJ();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("used_memory", cjE);
                jSONObject2.put("resume_threshold", this.hKO);
                jSONObject2.put("type", "resume");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MEMORY, "memory", "liveroom", "memory_limit").setContentExt(null, null, jSONObject2));
        }
    }

    private void cjI() {
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @cleanMemory");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913300, ""));
        d.Df().release();
        j.exl().etq().ewy();
    }

    private void aC(float f) {
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @updateTempQueueLimit originalQueueLimitImMax=" + this.hKP);
        if (this.hKP <= 0) {
            this.hKP = com.baidu.live.ae.a.Qj().buX.aMQ;
            this.hKQ = com.baidu.live.ae.a.Qj().buX.aMR;
            this.hKR = com.baidu.live.ae.a.Qj().buX.aMS;
            this.hKS = com.baidu.live.ae.a.Qj().buX.aMT;
            this.hKT = com.baidu.live.ae.a.Qj().buX.aMU;
            this.hKU = com.baidu.live.ae.a.Qj().buX.aMW;
            this.hKV = com.baidu.live.ae.a.Qj().buX.aMX;
            Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @updateTempQueueLimit originalQueueLimitImMax=" + this.hKP + ", originalQueueLimitBarrageMax=" + this.hKQ + ", originalQueueLimitPayBarrageMax=" + this.hKR + ", originalQueueLimitEnterEffectMax=" + this.hKS + ", originalQueueLimitGiftBigMax=" + this.hKT + ", originalQueueLimitGiftSmallMax=" + this.hKU + ", originalQueueLimitGiftGraffitiMax=" + this.hKV);
        }
        int i = (int) (this.hKP * f);
        if (i <= 0) {
            i = 5;
        }
        com.baidu.live.ae.a.Qj().buX.aMQ = i;
        int i2 = (int) (this.hKQ * f);
        if (i2 <= 0) {
            i2 = 1;
        }
        com.baidu.live.ae.a.Qj().buX.aMR = i2;
        int i3 = (int) (this.hKR * f);
        if (i3 <= 0) {
            i3 = 1;
        }
        com.baidu.live.ae.a.Qj().buX.aMS = i3;
        int i4 = (int) (this.hKS * f);
        if (i4 <= 0) {
            i4 = 1;
        }
        com.baidu.live.ae.a.Qj().buX.aMT = i4;
        int i5 = (int) (this.hKT * f);
        if (i5 <= 0) {
            i5 = 1;
        }
        com.baidu.live.ae.a.Qj().buX.aMU = i5;
        int i6 = (int) (this.hKU * f);
        if (i6 <= 0) {
            i6 = 1;
        }
        com.baidu.live.ae.a.Qj().buX.aMW = i6;
        int i7 = (int) (this.hKV * f);
        int i8 = i7 > 0 ? i7 : 1;
        com.baidu.live.ae.a.Qj().buX.aMX = i8;
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @updateTempQueueLimit queueLimitImMax=" + i + ", queueLimitBarrageMax=" + i2 + ", queueLimitPayBarrageMax=" + i3 + ", queueLimitEnterEffectMax=" + i4 + ", queueLimitGiftBigMax=" + i5 + ", queueLimitGiftSmallMax=" + i6 + ", queueLimitGiftGraffitiMax=" + i8);
    }

    private void cjJ() {
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @resumeQueueLimit originalQueueLimitImMax=" + this.hKP);
        if (this.hKP > 0) {
            com.baidu.live.ae.a.Qj().buX.aMQ = this.hKP;
            com.baidu.live.ae.a.Qj().buX.aMR = this.hKQ;
            com.baidu.live.ae.a.Qj().buX.aMS = this.hKR;
            com.baidu.live.ae.a.Qj().buX.aMT = this.hKS;
            com.baidu.live.ae.a.Qj().buX.aMU = this.hKT;
            com.baidu.live.ae.a.Qj().buX.aMW = this.hKU;
            com.baidu.live.ae.a.Qj().buX.aMX = this.hKV;
            this.hKP = 0;
        }
    }

    public void aCV() {
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @stopMonitor");
        this.handler.removeCallbacksAndMessages(null);
        this.hKL = false;
        this.hKP = 0;
        this.hKQ = 0;
        this.hKR = 0;
        this.hKS = 0;
        this.hKT = 0;
        this.hKU = 0;
        this.hKV = 0;
    }
}

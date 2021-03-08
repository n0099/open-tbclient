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
/* loaded from: classes10.dex */
public class a {
    private Context context;
    private long hMJ;
    private long hMK;
    private long hML;
    private int hMM;
    private int hMN;
    private int hMO;
    private int hMP;
    private int hMQ;
    private int hMR;
    private int hMS;
    public boolean hMI = false;
    private Handler handler = new Handler();
    private boolean isDebug = false;
    private boolean hMT = false;
    private List<ab> hMU = new ArrayList();
    Runnable hMV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
        @Override // java.lang.Runnable
        public void run() {
            ar arVar = com.baidu.live.ae.a.Qm().bwx;
            if (arVar != null) {
                a.this.cjU();
                int i = arVar.aOZ;
                if (i <= 0) {
                    i = 15;
                }
                a.this.handler.postDelayed(a.this.hMV, i * 1000);
                if (a.this.isDebug) {
                    for (int i2 = 0; i2 < 2000; i2++) {
                        a.this.hMU.add(new ab());
                    }
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
    }

    public long cjR() {
        long j = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        long j2 = j - freeMemory;
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @getUsedMemory totalMemory=" + j + ", freeMemory=" + freeMemory + ", usedMemory=" + j2);
        return j2;
    }

    public void cjS() {
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @startMemoryMonitor");
        ar arVar = com.baidu.live.ae.a.Qm().bwx;
        if (arVar != null) {
            Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @startMemoryMonitor memoryTest = " + arVar.aOY + ", timeInterval = " + arVar.aOZ + ", warnText = " + arVar.aPa + ", availableAlarmThreshold=" + arVar.aPb + ", availableResumeThreshold=" + arVar.aPc + ", queueLimitRatio=" + arVar.aPd);
            if (this.isDebug) {
                arVar.aOY = 1;
                arVar.aPa = "内存清理提示文案";
                arVar.aOZ = 5;
            }
            boolean z = arVar.aOY == 1;
            if (z) {
                this.hMI = true;
                int i = arVar.aOZ;
                if (i <= 0) {
                    i = 15;
                }
                Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @startMemoryMonitor isMonitor=" + z);
                cjT();
                this.handler.postDelayed(this.hMV, i * 1000);
                Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @startMemoryMonitor end");
            }
        }
    }

    private void cjT() {
        this.hMJ = cjR();
        long maxMemory = Runtime.getRuntime().maxMemory();
        long j = maxMemory - this.hMJ;
        ar arVar = com.baidu.live.ae.a.Qm().bwx;
        float f = arVar.aPb;
        float f2 = arVar.aPc;
        this.hMK = maxMemory - (f * ((float) j));
        if (this.hMK < this.hMJ) {
            this.hMK = maxMemory;
        }
        this.hML = maxMemory - (f2 * ((float) j));
        if (this.isDebug) {
            this.hMK = this.hMJ * 2;
            this.hML = (long) (this.hMK * 0.8d);
        }
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @recordStartLive usedMemory=" + this.hMJ + ", maxMemory=" + maxMemory + ", sub=" + j + ", alarmThreshold=" + this.hMK + ", resumeThreshold=" + this.hML);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjU() {
        long cjR = cjR();
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @checkUsedMemory usedMemory=" + cjR + ", alarmThreshold=" + this.hMK + ", resumeThreshold=" + this.hML);
        if (cjR >= this.hMK) {
            this.hMT = true;
            Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @checkUsedMemory doCleanMemory");
            String str = com.baidu.live.ae.a.Qm().bwx.aPa;
            if (!TextUtils.isEmpty(str)) {
                BdUtilHelper.showToast(this.context, str);
            }
            cjV();
            float f = com.baidu.live.ae.a.Qm().bwx.aPd;
            if (f >= 1.0f) {
                f = 0.7f;
            } else if (f <= 0.0f) {
                f = 0.1f;
            }
            aG(f);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("used_memory", cjR);
                jSONObject.put("alarm_threshold", this.hMK);
                jSONObject.put("type", NotificationCompat.CATEGORY_ALARM);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MEMORY, "memory", "liveroom", "memory_limit").setContentExt(null, null, jSONObject));
        } else if (this.hMT && cjR <= this.hML) {
            Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @checkUsedMemory doResume");
            this.hMT = false;
            cjW();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("used_memory", cjR);
                jSONObject2.put("resume_threshold", this.hML);
                jSONObject2.put("type", "resume");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_MEMORY, "memory", "liveroom", "memory_limit").setContentExt(null, null, jSONObject2));
        }
    }

    private void cjV() {
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @cleanMemory");
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913300, ""));
        d.Di().release();
        j.exC().etH().ewP();
    }

    private void aG(float f) {
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @updateTempQueueLimit originalQueueLimitImMax=" + this.hMM);
        if (this.hMM <= 0) {
            this.hMM = com.baidu.live.ae.a.Qm().bwx.aOq;
            this.hMN = com.baidu.live.ae.a.Qm().bwx.aOr;
            this.hMO = com.baidu.live.ae.a.Qm().bwx.aOs;
            this.hMP = com.baidu.live.ae.a.Qm().bwx.aOt;
            this.hMQ = com.baidu.live.ae.a.Qm().bwx.aOu;
            this.hMR = com.baidu.live.ae.a.Qm().bwx.aOw;
            this.hMS = com.baidu.live.ae.a.Qm().bwx.aOx;
            Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @updateTempQueueLimit originalQueueLimitImMax=" + this.hMM + ", originalQueueLimitBarrageMax=" + this.hMN + ", originalQueueLimitPayBarrageMax=" + this.hMO + ", originalQueueLimitEnterEffectMax=" + this.hMP + ", originalQueueLimitGiftBigMax=" + this.hMQ + ", originalQueueLimitGiftSmallMax=" + this.hMR + ", originalQueueLimitGiftGraffitiMax=" + this.hMS);
        }
        int i = (int) (this.hMM * f);
        if (i <= 0) {
            i = 5;
        }
        com.baidu.live.ae.a.Qm().bwx.aOq = i;
        int i2 = (int) (this.hMN * f);
        if (i2 <= 0) {
            i2 = 1;
        }
        com.baidu.live.ae.a.Qm().bwx.aOr = i2;
        int i3 = (int) (this.hMO * f);
        if (i3 <= 0) {
            i3 = 1;
        }
        com.baidu.live.ae.a.Qm().bwx.aOs = i3;
        int i4 = (int) (this.hMP * f);
        if (i4 <= 0) {
            i4 = 1;
        }
        com.baidu.live.ae.a.Qm().bwx.aOt = i4;
        int i5 = (int) (this.hMQ * f);
        if (i5 <= 0) {
            i5 = 1;
        }
        com.baidu.live.ae.a.Qm().bwx.aOu = i5;
        int i6 = (int) (this.hMR * f);
        if (i6 <= 0) {
            i6 = 1;
        }
        com.baidu.live.ae.a.Qm().bwx.aOw = i6;
        int i7 = (int) (this.hMS * f);
        int i8 = i7 > 0 ? i7 : 1;
        com.baidu.live.ae.a.Qm().bwx.aOx = i8;
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @updateTempQueueLimit queueLimitImMax=" + i + ", queueLimitBarrageMax=" + i2 + ", queueLimitPayBarrageMax=" + i3 + ", queueLimitEnterEffectMax=" + i4 + ", queueLimitGiftBigMax=" + i5 + ", queueLimitGiftSmallMax=" + i6 + ", queueLimitGiftGraffitiMax=" + i8);
    }

    private void cjW() {
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @resumeQueueLimit originalQueueLimitImMax=" + this.hMM);
        if (this.hMM > 0) {
            com.baidu.live.ae.a.Qm().bwx.aOq = this.hMM;
            com.baidu.live.ae.a.Qm().bwx.aOr = this.hMN;
            com.baidu.live.ae.a.Qm().bwx.aOs = this.hMO;
            com.baidu.live.ae.a.Qm().bwx.aOt = this.hMP;
            com.baidu.live.ae.a.Qm().bwx.aOu = this.hMQ;
            com.baidu.live.ae.a.Qm().bwx.aOw = this.hMR;
            com.baidu.live.ae.a.Qm().bwx.aOx = this.hMS;
            this.hMM = 0;
        }
    }

    public void aCY() {
        Log.i("memoryMonitor", "@@ memoryMonitor MemoryMonitorHelper @stopMonitor");
        this.handler.removeCallbacksAndMessages(null);
        this.hMI = false;
        this.hMM = 0;
        this.hMN = 0;
        this.hMO = 0;
        this.hMP = 0;
        this.hMQ = 0;
        this.hMR = 0;
        this.hMS = 0;
    }
}

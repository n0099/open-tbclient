package com.baidu.tieba.ala.liveroom.i;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
/* loaded from: classes4.dex */
public class a {
    private static volatile a gPA = null;
    private ActivityManager doT;
    private Long gPB;
    private Long gPC;
    private RandomAccessFile gPD;
    private RandomAccessFile gPE;
    private String mPackageName;

    private a() {
    }

    public static a bVU() {
        if (gPA == null) {
            synchronized (a.class) {
                if (gPA == null) {
                    gPA = new a();
                }
            }
        }
        return gPA;
    }

    public double bVV() {
        if (Build.VERSION.SDK_INT >= 26) {
            String Hi = Hi(this.mPackageName);
            if (TextUtils.isEmpty(Hi)) {
                return 0.0d;
            }
            try {
                return Double.valueOf(Hi).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0d;
            }
        }
        return bVW();
    }

    private String Hi(String str) {
        Process exec;
        BufferedReader bufferedReader;
        String[] split;
        try {
            exec = Runtime.getRuntime().exec(new String[]{IXAdRequestInfo.SCREEN_HEIGHT, "-c", "top -n 1"});
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        do {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                split = readLine.trim().split(" ");
            } else {
                try {
                    exec.waitFor();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                return "";
            }
        } while (!str.startsWith(split[split.length - 1].substring(0, split[split.length - 1].length() - 1)));
        return split[16];
    }

    private double bVW() {
        double d = 0.0d;
        try {
            if (this.gPD == null || this.gPE == null) {
                this.gPD = new RandomAccessFile("/proc/stat", "r");
                this.gPE = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                this.gPD.seek(0L);
                this.gPE.seek(0L);
            }
            String readLine = this.gPD.readLine();
            String readLine2 = this.gPE.readLine();
            String[] split = readLine.split(" ");
            String[] split2 = readLine2.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split2[14]) + Long.parseLong(split2[13]);
            if (this.gPB == null && this.gPC == null) {
                this.gPB = Long.valueOf(parseLong);
                this.gPC = Long.valueOf(parseLong2);
            } else {
                if (this.gPB != null && this.gPC != null) {
                    d = ((parseLong2 - this.gPC.longValue()) / (parseLong - this.gPB.longValue())) * 100.0d;
                }
                this.gPB = Long.valueOf(parseLong);
                this.gPC = Long.valueOf(parseLong2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public double bVX() {
        try {
            Debug.MemoryInfo[] processMemoryInfo = this.doT.getProcessMemoryInfo(new int[]{Process.myPid()});
            if (processMemoryInfo.length <= 0) {
                return 0.0d;
            }
            int totalPss = processMemoryInfo[0].getTotalPss();
            if (totalPss < 0) {
                return 0.0d;
            }
            return totalPss / 1024.0d;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0d;
        }
    }
}

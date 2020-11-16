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
    private static volatile a hgQ = null;
    private ActivityManager dBE;
    private Long hgR;
    private Long hgS;
    private RandomAccessFile hgT;
    private RandomAccessFile hgU;
    private String mPackageName;

    private a() {
    }

    public static a caO() {
        if (hgQ == null) {
            synchronized (a.class) {
                if (hgQ == null) {
                    hgQ = new a();
                }
            }
        }
        return hgQ;
    }

    public double caP() {
        if (Build.VERSION.SDK_INT >= 26) {
            String Hz = Hz(this.mPackageName);
            if (TextUtils.isEmpty(Hz)) {
                return 0.0d;
            }
            try {
                return Double.valueOf(Hz).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0d;
            }
        }
        return caQ();
    }

    private String Hz(String str) {
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

    private double caQ() {
        double d = 0.0d;
        try {
            if (this.hgT == null || this.hgU == null) {
                this.hgT = new RandomAccessFile("/proc/stat", "r");
                this.hgU = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                this.hgT.seek(0L);
                this.hgU.seek(0L);
            }
            String readLine = this.hgT.readLine();
            String readLine2 = this.hgU.readLine();
            String[] split = readLine.split(" ");
            String[] split2 = readLine2.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split2[14]) + Long.parseLong(split2[13]);
            if (this.hgR == null && this.hgS == null) {
                this.hgR = Long.valueOf(parseLong);
                this.hgS = Long.valueOf(parseLong2);
            } else {
                if (this.hgR != null && this.hgS != null) {
                    d = ((parseLong2 - this.hgS.longValue()) / (parseLong - this.hgR.longValue())) * 100.0d;
                }
                this.hgR = Long.valueOf(parseLong);
                this.hgS = Long.valueOf(parseLong2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public double caR() {
        try {
            Debug.MemoryInfo[] processMemoryInfo = this.dBE.getProcessMemoryInfo(new int[]{Process.myPid()});
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

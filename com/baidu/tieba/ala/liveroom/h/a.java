package com.baidu.tieba.ala.liveroom.h;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
/* loaded from: classes10.dex */
public class a {
    private static volatile a hDW = null;
    private Long cmM;
    private Long cmN;
    private RandomAccessFile cmO;
    private RandomAccessFile cmP;
    private ActivityManager dQa;
    private String mPackageName;

    private a() {
    }

    public static a ceR() {
        if (hDW == null) {
            synchronized (a.class) {
                if (hDW == null) {
                    hDW = new a();
                }
            }
        }
        return hDW;
    }

    public double acx() {
        if (Build.VERSION.SDK_INT >= 26) {
            String jo = jo(this.mPackageName);
            if (TextUtils.isEmpty(jo)) {
                return 0.0d;
            }
            try {
                return Double.valueOf(jo).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0d;
            }
        }
        return acz();
    }

    private String jo(String str) {
        Process exec;
        BufferedReader bufferedReader;
        String[] split;
        try {
            exec = Runtime.getRuntime().exec(new String[]{"sh", "-c", "top -n 1"});
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

    private double acz() {
        double d = 0.0d;
        try {
            if (this.cmO == null || this.cmP == null) {
                this.cmO = new RandomAccessFile("/proc/stat", "r");
                this.cmP = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                this.cmO.seek(0L);
                this.cmP.seek(0L);
            }
            String readLine = this.cmO.readLine();
            String readLine2 = this.cmP.readLine();
            String[] split = readLine.split(" ");
            String[] split2 = readLine2.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split2[14]) + Long.parseLong(split2[13]);
            if (this.cmM == null && this.cmN == null) {
                this.cmM = Long.valueOf(parseLong);
                this.cmN = Long.valueOf(parseLong2);
            } else {
                if (this.cmM != null && this.cmN != null) {
                    d = ((parseLong2 - this.cmN.longValue()) / (parseLong - this.cmM.longValue())) * 100.0d;
                }
                this.cmM = Long.valueOf(parseLong);
                this.cmN = Long.valueOf(parseLong2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public double ceS() {
        try {
            Debug.MemoryInfo[] processMemoryInfo = this.dQa.getProcessMemoryInfo(new int[]{Process.myPid()});
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

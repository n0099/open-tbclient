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
/* loaded from: classes11.dex */
public class a {
    private static volatile a hCn = null;
    private Long cll;
    private Long clm;
    private RandomAccessFile cln;
    private RandomAccessFile clo;
    private ActivityManager dOz;
    private String mPackageName;

    private a() {
    }

    public static a ceL() {
        if (hCn == null) {
            synchronized (a.class) {
                if (hCn == null) {
                    hCn = new a();
                }
            }
        }
        return hCn;
    }

    public double acu() {
        if (Build.VERSION.SDK_INT >= 26) {
            String ji = ji(this.mPackageName);
            if (TextUtils.isEmpty(ji)) {
                return 0.0d;
            }
            try {
                return Double.valueOf(ji).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0d;
            }
        }
        return acw();
    }

    private String ji(String str) {
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

    private double acw() {
        double d = 0.0d;
        try {
            if (this.cln == null || this.clo == null) {
                this.cln = new RandomAccessFile("/proc/stat", "r");
                this.clo = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                this.cln.seek(0L);
                this.clo.seek(0L);
            }
            String readLine = this.cln.readLine();
            String readLine2 = this.clo.readLine();
            String[] split = readLine.split(" ");
            String[] split2 = readLine2.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split2[14]) + Long.parseLong(split2[13]);
            if (this.cll == null && this.clm == null) {
                this.cll = Long.valueOf(parseLong);
                this.clm = Long.valueOf(parseLong2);
            } else {
                if (this.cll != null && this.clm != null) {
                    d = ((parseLong2 - this.clm.longValue()) / (parseLong - this.cll.longValue())) * 100.0d;
                }
                this.cll = Long.valueOf(parseLong);
                this.clm = Long.valueOf(parseLong2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public double ceM() {
        try {
            Debug.MemoryInfo[] processMemoryInfo = this.dOz.getProcessMemoryInfo(new int[]{Process.myPid()});
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

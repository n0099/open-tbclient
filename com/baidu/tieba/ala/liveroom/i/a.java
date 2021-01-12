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
/* loaded from: classes10.dex */
public class a {
    private static volatile a hxP = null;
    private Long cgZ;
    private Long cha;
    private RandomAccessFile chb;
    private RandomAccessFile chc;
    private ActivityManager dMv;
    private String mPackageName;

    private a() {
    }

    public static a cdJ() {
        if (hxP == null) {
            synchronized (a.class) {
                if (hxP == null) {
                    hxP = new a();
                }
            }
        }
        return hxP;
    }

    public double aaG() {
        if (Build.VERSION.SDK_INT >= 26) {
            String iC = iC(this.mPackageName);
            if (TextUtils.isEmpty(iC)) {
                return 0.0d;
            }
            try {
                return Double.valueOf(iC).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0d;
            }
        }
        return aaI();
    }

    private String iC(String str) {
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

    private double aaI() {
        double d = 0.0d;
        try {
            if (this.chb == null || this.chc == null) {
                this.chb = new RandomAccessFile("/proc/stat", "r");
                this.chc = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                this.chb.seek(0L);
                this.chc.seek(0L);
            }
            String readLine = this.chb.readLine();
            String readLine2 = this.chc.readLine();
            String[] split = readLine.split(" ");
            String[] split2 = readLine2.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split2[14]) + Long.parseLong(split2[13]);
            if (this.cgZ == null && this.cha == null) {
                this.cgZ = Long.valueOf(parseLong);
                this.cha = Long.valueOf(parseLong2);
            } else {
                if (this.cgZ != null && this.cha != null) {
                    d = ((parseLong2 - this.cha.longValue()) / (parseLong - this.cgZ.longValue())) * 100.0d;
                }
                this.cgZ = Long.valueOf(parseLong);
                this.cha = Long.valueOf(parseLong2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public double cdK() {
        try {
            Debug.MemoryInfo[] processMemoryInfo = this.dMv.getProcessMemoryInfo(new int[]{Process.myPid()});
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

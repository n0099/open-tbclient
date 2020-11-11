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
    private static volatile a hhj = null;
    private ActivityManager dDl;
    private Long hhk;
    private Long hhl;
    private RandomAccessFile hhm;
    private RandomAccessFile hhn;
    private String mPackageName;

    private a() {
    }

    public static a cbv() {
        if (hhj == null) {
            synchronized (a.class) {
                if (hhj == null) {
                    hhj = new a();
                }
            }
        }
        return hhj;
    }

    public double cbw() {
        if (Build.VERSION.SDK_INT >= 26) {
            String HY = HY(this.mPackageName);
            if (TextUtils.isEmpty(HY)) {
                return 0.0d;
            }
            try {
                return Double.valueOf(HY).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0d;
            }
        }
        return cbx();
    }

    private String HY(String str) {
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

    private double cbx() {
        double d = 0.0d;
        try {
            if (this.hhm == null || this.hhn == null) {
                this.hhm = new RandomAccessFile("/proc/stat", "r");
                this.hhn = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                this.hhm.seek(0L);
                this.hhn.seek(0L);
            }
            String readLine = this.hhm.readLine();
            String readLine2 = this.hhn.readLine();
            String[] split = readLine.split(" ");
            String[] split2 = readLine2.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split2[14]) + Long.parseLong(split2[13]);
            if (this.hhk == null && this.hhl == null) {
                this.hhk = Long.valueOf(parseLong);
                this.hhl = Long.valueOf(parseLong2);
            } else {
                if (this.hhk != null && this.hhl != null) {
                    d = ((parseLong2 - this.hhl.longValue()) / (parseLong - this.hhk.longValue())) * 100.0d;
                }
                this.hhk = Long.valueOf(parseLong);
                this.hhl = Long.valueOf(parseLong2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public double cby() {
        try {
            Debug.MemoryInfo[] processMemoryInfo = this.dDl.getProcessMemoryInfo(new int[]{Process.myPid()});
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

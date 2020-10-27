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
    private static volatile a hbo = null;
    private ActivityManager dxt;
    private Long hbp;
    private Long hbq;
    private RandomAccessFile hbr;
    private RandomAccessFile hbs;
    private String mPackageName;

    private a() {
    }

    public static a bYT() {
        if (hbo == null) {
            synchronized (a.class) {
                if (hbo == null) {
                    hbo = new a();
                }
            }
        }
        return hbo;
    }

    public double bYU() {
        if (Build.VERSION.SDK_INT >= 26) {
            String HH = HH(this.mPackageName);
            if (TextUtils.isEmpty(HH)) {
                return 0.0d;
            }
            try {
                return Double.valueOf(HH).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0d;
            }
        }
        return bYV();
    }

    private String HH(String str) {
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

    private double bYV() {
        double d = 0.0d;
        try {
            if (this.hbr == null || this.hbs == null) {
                this.hbr = new RandomAccessFile("/proc/stat", "r");
                this.hbs = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                this.hbr.seek(0L);
                this.hbs.seek(0L);
            }
            String readLine = this.hbr.readLine();
            String readLine2 = this.hbs.readLine();
            String[] split = readLine.split(" ");
            String[] split2 = readLine2.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split2[14]) + Long.parseLong(split2[13]);
            if (this.hbp == null && this.hbq == null) {
                this.hbp = Long.valueOf(parseLong);
                this.hbq = Long.valueOf(parseLong2);
            } else {
                if (this.hbp != null && this.hbq != null) {
                    d = ((parseLong2 - this.hbq.longValue()) / (parseLong - this.hbp.longValue())) * 100.0d;
                }
                this.hbp = Long.valueOf(parseLong);
                this.hbq = Long.valueOf(parseLong2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public double bYW() {
        try {
            Debug.MemoryInfo[] processMemoryInfo = this.dxt.getProcessMemoryInfo(new int[]{Process.myPid()});
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

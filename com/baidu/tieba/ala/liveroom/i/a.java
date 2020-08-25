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
/* loaded from: classes7.dex */
public class a {
    private static volatile a gxS = null;
    private ActivityManager daF;
    private Long gxT;
    private Long gxU;
    private RandomAccessFile gxV;
    private RandomAccessFile gxW;
    private String mPackageName;

    private a() {
    }

    public static a bRe() {
        if (gxS == null) {
            synchronized (a.class) {
                if (gxS == null) {
                    gxS = new a();
                }
            }
        }
        return gxS;
    }

    public double bRf() {
        if (Build.VERSION.SDK_INT >= 26) {
            String FX = FX(this.mPackageName);
            if (TextUtils.isEmpty(FX)) {
                return 0.0d;
            }
            try {
                return Double.valueOf(FX).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0d;
            }
        }
        return bRg();
    }

    private String FX(String str) {
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

    private double bRg() {
        double d = 0.0d;
        try {
            if (this.gxV == null || this.gxW == null) {
                this.gxV = new RandomAccessFile("/proc/stat", "r");
                this.gxW = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                this.gxV.seek(0L);
                this.gxW.seek(0L);
            }
            String readLine = this.gxV.readLine();
            String readLine2 = this.gxW.readLine();
            String[] split = readLine.split(" ");
            String[] split2 = readLine2.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split2[14]) + Long.parseLong(split2[13]);
            if (this.gxT == null && this.gxU == null) {
                this.gxT = Long.valueOf(parseLong);
                this.gxU = Long.valueOf(parseLong2);
            } else {
                if (this.gxT != null && this.gxU != null) {
                    d = ((parseLong2 - this.gxU.longValue()) / (parseLong - this.gxT.longValue())) * 100.0d;
                }
                this.gxT = Long.valueOf(parseLong);
                this.gxU = Long.valueOf(parseLong2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public double bRh() {
        try {
            Debug.MemoryInfo[] processMemoryInfo = this.daF.getProcessMemoryInfo(new int[]{Process.myPid()});
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

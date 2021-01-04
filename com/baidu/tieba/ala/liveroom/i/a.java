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
/* loaded from: classes11.dex */
public class a {
    private static volatile a hCv = null;
    private Long clM;
    private Long clN;
    private RandomAccessFile clO;
    private RandomAccessFile clP;
    private ActivityManager dRh;
    private String mPackageName;

    private a() {
    }

    public static a chA() {
        if (hCv == null) {
            synchronized (a.class) {
                if (hCv == null) {
                    hCv = new a();
                }
            }
        }
        return hCv;
    }

    public double aey() {
        if (Build.VERSION.SDK_INT >= 26) {
            String jN = jN(this.mPackageName);
            if (TextUtils.isEmpty(jN)) {
                return 0.0d;
            }
            try {
                return Double.valueOf(jN).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0d;
            }
        }
        return aeA();
    }

    private String jN(String str) {
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

    private double aeA() {
        double d = 0.0d;
        try {
            if (this.clO == null || this.clP == null) {
                this.clO = new RandomAccessFile("/proc/stat", "r");
                this.clP = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                this.clO.seek(0L);
                this.clP.seek(0L);
            }
            String readLine = this.clO.readLine();
            String readLine2 = this.clP.readLine();
            String[] split = readLine.split(" ");
            String[] split2 = readLine2.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split2[14]) + Long.parseLong(split2[13]);
            if (this.clM == null && this.clN == null) {
                this.clM = Long.valueOf(parseLong);
                this.clN = Long.valueOf(parseLong2);
            } else {
                if (this.clM != null && this.clN != null) {
                    d = ((parseLong2 - this.clN.longValue()) / (parseLong - this.clM.longValue())) * 100.0d;
                }
                this.clM = Long.valueOf(parseLong);
                this.clN = Long.valueOf(parseLong2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public double chB() {
        try {
            Debug.MemoryInfo[] processMemoryInfo = this.dRh.getProcessMemoryInfo(new int[]{Process.myPid()});
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

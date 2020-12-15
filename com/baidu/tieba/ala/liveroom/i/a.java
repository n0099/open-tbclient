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
    private static volatile a hqz = null;
    private Long ceP;
    private Long ceQ;
    private RandomAccessFile ceR;
    private RandomAccessFile ceS;
    private ActivityManager dIC;
    private String mPackageName;

    private a() {
    }

    public static a ceK() {
        if (hqz == null) {
            synchronized (a.class) {
                if (hqz == null) {
                    hqz = new a();
                }
            }
        }
        return hqz;
    }

    public double acF() {
        if (Build.VERSION.SDK_INT >= 26) {
            String jR = jR(this.mPackageName);
            if (TextUtils.isEmpty(jR)) {
                return 0.0d;
            }
            try {
                return Double.valueOf(jR).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0d;
            }
        }
        return acH();
    }

    private String jR(String str) {
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

    private double acH() {
        double d = 0.0d;
        try {
            if (this.ceR == null || this.ceS == null) {
                this.ceR = new RandomAccessFile("/proc/stat", "r");
                this.ceS = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                this.ceR.seek(0L);
                this.ceS.seek(0L);
            }
            String readLine = this.ceR.readLine();
            String readLine2 = this.ceS.readLine();
            String[] split = readLine.split(" ");
            String[] split2 = readLine2.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split2[14]) + Long.parseLong(split2[13]);
            if (this.ceP == null && this.ceQ == null) {
                this.ceP = Long.valueOf(parseLong);
                this.ceQ = Long.valueOf(parseLong2);
            } else {
                if (this.ceP != null && this.ceQ != null) {
                    d = ((parseLong2 - this.ceQ.longValue()) / (parseLong - this.ceP.longValue())) * 100.0d;
                }
                this.ceP = Long.valueOf(parseLong);
                this.ceQ = Long.valueOf(parseLong2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public double ceL() {
        try {
            Debug.MemoryInfo[] processMemoryInfo = this.dIC.getProcessMemoryInfo(new int[]{Process.myPid()});
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

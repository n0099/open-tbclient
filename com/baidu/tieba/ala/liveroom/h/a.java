package com.baidu.tieba.ala.liveroom.h;

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
/* loaded from: classes3.dex */
public class a {
    private static volatile a ggO = null;
    private ActivityManager cOh;
    private Long ggP;
    private Long ggQ;
    private RandomAccessFile ggR;
    private RandomAccessFile ggS;
    private String mPackageName;

    private a() {
    }

    public static a bEq() {
        if (ggO == null) {
            synchronized (a.class) {
                if (ggO == null) {
                    ggO = new a();
                }
            }
        }
        return ggO;
    }

    public double bEr() {
        if (Build.VERSION.SDK_INT >= 26) {
            String CO = CO(this.mPackageName);
            if (TextUtils.isEmpty(CO)) {
                return 0.0d;
            }
            try {
                return Double.valueOf(CO).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 0.0d;
            }
        }
        return bEs();
    }

    private String CO(String str) {
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

    private double bEs() {
        double d = 0.0d;
        try {
            if (this.ggR == null || this.ggS == null) {
                this.ggR = new RandomAccessFile("/proc/stat", "r");
                this.ggS = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                this.ggR.seek(0L);
                this.ggS.seek(0L);
            }
            String readLine = this.ggR.readLine();
            String readLine2 = this.ggS.readLine();
            String[] split = readLine.split(" ");
            String[] split2 = readLine2.split(" ");
            long parseLong = Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[5]) + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            long parseLong2 = Long.parseLong(split2[14]) + Long.parseLong(split2[13]);
            if (this.ggP == null && this.ggQ == null) {
                this.ggP = Long.valueOf(parseLong);
                this.ggQ = Long.valueOf(parseLong2);
            } else {
                if (this.ggP != null && this.ggQ != null) {
                    d = ((parseLong2 - this.ggQ.longValue()) / (parseLong - this.ggP.longValue())) * 100.0d;
                }
                this.ggP = Long.valueOf(parseLong);
                this.ggQ = Long.valueOf(parseLong2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public double bEt() {
        try {
            Debug.MemoryInfo[] processMemoryInfo = this.cOh.getProcessMemoryInfo(new int[]{Process.myPid()});
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

package com.baidu.tbadk.n;

import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.soloader.SoLoader;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.launch.utils.LaunchNativeUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public final class n {
    private long fMf = -1;
    private long fMg = -1;
    private long fMh = -1;
    private long fLW = -1;
    private long fMi = -1;

    public void bEs() {
        this.fMh = SystemClock.elapsedRealtime();
        this.fMg = Process.getElapsedCpuTime();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [133=4] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bEt() {
        BufferedReader bufferedReader;
        long j;
        long bEr = l.bEp().bEr();
        long j2 = -1;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/self/stat")), 1000);
                try {
                    String[] split = bufferedReader.readLine().split(" ");
                    if (split.length > 21 && split[0].equals(String.valueOf(Process.myPid()))) {
                        String str = split[21];
                        try {
                            SoLoader.load(AppRuntime.getAppContext(), "launch_native");
                            j = LaunchNativeUtils.getClkTck();
                        } catch (UnsatisfiedLinkError e) {
                            Log.e("ZygoteSpeedStats", "load so failed, UnsatisfiedLinkError", e);
                            j = 0;
                        }
                        Log.d("ZygoteSpeedStats", "_SC_CLK_TCK " + j);
                        if (j <= 0) {
                            j = 100;
                        }
                        j2 = (Long.parseLong(str) * 1000) / j;
                    }
                    Closeables.closeSafely(bufferedReader);
                } catch (FileNotFoundException e2) {
                    e = e2;
                    Log.e("ZygoteSpeedStats", "can't read process status file", e);
                    Closeables.closeSafely(bufferedReader);
                    if (j2 <= 0) {
                    }
                } catch (IOException e3) {
                    e = e3;
                    Log.e("ZygoteSpeedStats", "read process status failed", e);
                    Closeables.closeSafely(bufferedReader);
                    if (j2 <= 0) {
                    }
                } catch (NumberFormatException e4) {
                    e = e4;
                    Log.e("ZygoteSpeedStats", "parse status file failed", e);
                    Closeables.closeSafely(bufferedReader);
                    if (j2 <= 0) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                Closeables.closeSafely((Closeable) null);
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            bufferedReader = null;
        } catch (IOException e6) {
            e = e6;
            bufferedReader = null;
        } catch (NumberFormatException e7) {
            e = e7;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            Closeables.closeSafely((Closeable) null);
            throw th;
        }
        if (j2 <= 0) {
            this.fLW = this.fMh - j2;
            this.fMi = this.fLW - bEr;
        }
    }

    public long bEu() {
        if (this.fLW == -1) {
            bEt();
        }
        return this.fLW;
    }
}

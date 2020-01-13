package com.baidu.tbadk.n;

import android.os.Process;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class m {
    private static String dAb = "tb_perfor_samllflow_time";
    private static volatile m dAe;
    private long dAd;
    private boolean dzZ = false;
    private long dAc = 86400;
    private long dAa = com.baidu.tbadk.core.sharedPref.b.aDr().getLong(dAb, 0);

    public static m aOT() {
        if (dAe == null) {
            synchronized (m.class) {
                if (dAe == null) {
                    dAe = new m();
                }
            }
        }
        return dAe;
    }

    private m() {
        this.dAd = 0L;
        this.dAd = this.dAc;
    }

    public boolean aOU() {
        if (!this.dzZ || (System.currentTimeMillis() - this.dAa) / 1000 <= this.dAd) {
            return this.dzZ;
        }
        return false;
    }

    public void gN(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (0 == this.dAa || currentTimeMillis - this.dAa >= this.dAd) {
                this.dAa = currentTimeMillis;
                com.baidu.tbadk.core.sharedPref.b.aDr().putLong(dAb, this.dAa);
            }
        } else {
            this.dAa = 0L;
            com.baidu.tbadk.core.sharedPref.b.aDr().putLong(dAb, this.dAa);
        }
        this.dzZ = z;
        if (BdStatisticsManager.getInstance().isMainProcess()) {
            n.aOY().aOZ();
        }
    }

    public String getNetType() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            return "N";
        }
        if (com.baidu.adp.lib.util.j.isWifiNet()) {
            return "WIFI";
        }
        if (com.baidu.adp.lib.util.j.is4GNet()) {
            return "4G";
        }
        if (com.baidu.adp.lib.util.j.is3GNet()) {
            return "3G";
        }
        if (!com.baidu.adp.lib.util.j.is2GNet()) {
            return "N";
        }
        return "2G";
    }

    public static String mv(int i) {
        if (1 == i) {
            return "2G";
        }
        if (2 == i) {
            return "3G";
        }
        if (3 != i) {
            return "N";
        }
        return "WIFI";
    }

    public long aOV() {
        try {
            Runtime runtime = Runtime.getRuntime();
            return (runtime.totalMemory() - runtime.freeMemory()) / 1048576;
        } catch (Exception e) {
            BdLog.e(e);
            return -1L;
        }
    }

    public l mw(int i) {
        if (aOU()) {
            switch (i) {
                case 1000:
                    o oVar = new o();
                    oVar.subType = "frs";
                    return oVar;
                case 1001:
                    o oVar2 = new o();
                    oVar2.subType = "pb";
                    return oVar2;
                case 1002:
                    j jVar = new j();
                    jVar.subType = "im";
                    return jVar;
                case 1003:
                default:
                    return null;
                case 1004:
                    o oVar3 = new o();
                    oVar3.subType = "photo_live";
                    return oVar3;
                case 1005:
                    e eVar = new e();
                    eVar.subType = "home_page";
                    return eVar;
            }
        }
        return null;
    }

    public void bG(long j) {
        if (j > 0) {
            this.dAd = j;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        r0 = r6[2].trim();
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ad A[Catch: Exception -> 0x00b1, TRY_LEAVE, TryCatch #9 {Exception -> 0x00b1, blocks: (B:49:0x00a8, B:51:0x00ad), top: B:73:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getCpuUsageStatistic() {
        BufferedReader bufferedReader;
        Process process;
        Process process2;
        String str;
        String str2;
        BufferedReader bufferedReader2 = null;
        int myPid = Process.myPid();
        try {
            process = Runtime.getRuntime().exec("top -n 1");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                str2 = null;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (readLine.trim().startsWith(String.valueOf(myPid))) {
                            String[] split = readLine.split("\\s+");
                            if (split.length > 2 && split[2] != null && split[2].contains("%")) {
                                break;
                            }
                            int length = split.length;
                            int i = 0;
                            while (true) {
                                if (i < length) {
                                    String str3 = split[i];
                                    if (str3 == null || !str3.contains("%")) {
                                        i++;
                                    } else {
                                        str2 = str3.trim();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                        bufferedReader2 = bufferedReader;
                        process2 = process;
                        str = str2;
                        e = e;
                        try {
                            e.printStackTrace();
                            if (process2 != null) {
                                try {
                                    process2.destroy();
                                } catch (Exception e2) {
                                    str2 = str;
                                }
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            str2 = str;
                            if (str2 != null) {
                            }
                            return com.baidu.adp.lib.f.b.toInt(str2, -1);
                        } catch (Throwable th) {
                            th = th;
                            process = process2;
                            bufferedReader = bufferedReader2;
                            if (process != null) {
                                try {
                                    process.destroy();
                                } catch (Exception e3) {
                                    throw th;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (process != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                }
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Exception e4) {
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e5) {
                e = e5;
                process2 = process;
                str = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception e6) {
            e = e6;
            process2 = null;
            str = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            process = null;
        }
        if (str2 != null) {
            String[] split2 = str2.split("%");
            if (split2.length > 0) {
                str2 = split2[0];
            }
        }
        return com.baidu.adp.lib.f.b.toInt(str2, -1);
    }
}

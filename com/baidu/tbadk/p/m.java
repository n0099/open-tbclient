package com.baidu.tbadk.p;

import android.os.Process;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class m {
    private static String cLQ = "tb_perfor_samllflow_time";
    private static volatile m cLT;
    private long cLS;
    private boolean cLO = false;
    private long cLR = 86400;
    private long cLP = com.baidu.tbadk.core.sharedPref.b.alP().getLong(cLQ, 0);

    public static m awL() {
        if (cLT == null) {
            synchronized (m.class) {
                if (cLT == null) {
                    cLT = new m();
                }
            }
        }
        return cLT;
    }

    private m() {
        this.cLS = 0L;
        this.cLS = this.cLR;
    }

    public boolean awM() {
        if (!this.cLO || (System.currentTimeMillis() - this.cLP) / 1000 <= this.cLS) {
            return this.cLO;
        }
        return false;
    }

    public void fx(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (0 == this.cLP || currentTimeMillis - this.cLP >= this.cLS) {
                this.cLP = currentTimeMillis;
                com.baidu.tbadk.core.sharedPref.b.alP().putLong(cLQ, this.cLP);
            }
        } else {
            this.cLP = 0L;
            com.baidu.tbadk.core.sharedPref.b.alP().putLong(cLQ, this.cLP);
        }
        this.cLO = z;
        if (BdStatisticsManager.getInstance().isMainProcess()) {
            n.awQ().awR();
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

    public static String kg(int i) {
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

    public long awN() {
        try {
            Runtime runtime = Runtime.getRuntime();
            return (runtime.totalMemory() - runtime.freeMemory()) / 1048576;
        } catch (Exception e) {
            BdLog.e(e);
            return -1L;
        }
    }

    public l kh(int i) {
        if (awM()) {
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

    public void bb(long j) {
        if (j > 0) {
            this.cLS = j;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
        r0 = r6[2].trim();
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b3 A[Catch: Exception -> 0x00b7, TRY_LEAVE, TryCatch #1 {Exception -> 0x00b7, blocks: (B:52:0x00ae, B:54:0x00b3), top: B:72:0x00ae }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                        if (readLine != null) {
                            if (readLine.trim().startsWith(String.valueOf(myPid))) {
                                String[] split = readLine.split("\\s+");
                                if (split != null && split.length > 2 && split[2] != null && split[2].contains("%")) {
                                    break;
                                }
                                int i = 0;
                                while (true) {
                                    if (i < split.length) {
                                        if (split[i] == null || !split[i].contains("%")) {
                                            i++;
                                        } else {
                                            str2 = split[i].trim();
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                        } else {
                            break;
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
                            return com.baidu.adp.lib.g.b.toInt(str2, -1);
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
        return com.baidu.adp.lib.g.b.toInt(str2, -1);
    }
}

package com.baidu.tbadk.l;

import android.os.Debug;
import android.os.Process;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class r {
    private static String aKH = "tb_perfor_samllflow_time";
    private static volatile r aKK;
    private long aKJ;
    private boolean aKF = false;
    private long aKI = 86400;
    private long aKG = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(aKH, 0);

    public static r Gz() {
        if (aKK == null) {
            synchronized (r.class) {
                if (aKK == null) {
                    aKK = new r();
                }
            }
        }
        return aKK;
    }

    private r() {
        this.aKJ = 0L;
        this.aKJ = this.aKI;
    }

    public boolean GA() {
        if (!this.aKF || (System.currentTimeMillis() - this.aKG) / 1000 <= this.aKJ) {
            return this.aKF;
        }
        return false;
    }

    public void ca(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (0 == this.aKG || currentTimeMillis - this.aKG >= this.aKJ) {
                this.aKG = currentTimeMillis;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(aKH, this.aKG);
            }
        } else {
            this.aKG = 0L;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(aKH, this.aKG);
        }
        this.aKF = z;
        if (BdStatisticsManager.getInstance().isMainProcess()) {
            s.GF().GG();
        }
    }

    public String GB() {
        try {
            Runtime runtime = Runtime.getRuntime();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.valueOf(runtime.maxMemory() / 1048576));
            stringBuffer.append("/");
            stringBuffer.append(String.valueOf((runtime.totalMemory() - runtime.freeMemory()) / 1048576));
            return stringBuffer.toString();
        } catch (Exception e) {
            BdLog.e(e);
            return null;
        }
    }

    public final String GC() {
        try {
            String valueOf = String.valueOf(Debug.getNativeHeapSize() / IjkMediaMeta.AV_CH_SIDE_RIGHT);
            String valueOf2 = String.valueOf(Debug.getNativeHeapAllocatedSize() / IjkMediaMeta.AV_CH_SIDE_RIGHT);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(valueOf);
            stringBuffer.append("/");
            stringBuffer.append(valueOf2);
            return stringBuffer.toString();
        } catch (Exception e) {
            BdLog.e(e);
            return "";
        }
    }

    public String getNetType() {
        if (!com.baidu.adp.lib.util.i.hr()) {
            return "N";
        }
        if (com.baidu.adp.lib.util.i.hs()) {
            return "WIFI";
        }
        if (com.baidu.adp.lib.util.i.hu()) {
            return "4G";
        }
        if (com.baidu.adp.lib.util.i.hv()) {
            return "3G";
        }
        if (!com.baidu.adp.lib.util.i.hw()) {
            return "N";
        }
        return "2G";
    }

    public static String fj(int i) {
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

    public q fk(int i) {
        if (GA()) {
            switch (i) {
                case 1000:
                    t tVar = new t();
                    tVar.subType = "frs";
                    return tVar;
                case 1001:
                    t tVar2 = new t();
                    tVar2.subType = "pb";
                    return tVar2;
                case 1002:
                    n nVar = new n();
                    nVar.subType = "im";
                    return nVar;
                case 1003:
                    p pVar = new p();
                    pVar.subType = "native_live";
                    return pVar;
                case 1004:
                    t tVar3 = new t();
                    tVar3.subType = "photo_live";
                    return tVar3;
                case 1005:
                    h hVar = new h();
                    hVar.subType = "home_page";
                    return hVar;
                default:
                    return null;
            }
        }
        return null;
    }

    public void S(long j) {
        if (j > 0) {
            this.aKJ = j;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0047, code lost:
        r0 = r6[2].trim();
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a4 A[Catch: Exception -> 0x00a8, TRY_LEAVE, TryCatch #1 {Exception -> 0x00a8, blocks: (B:44:0x009f, B:46:0x00a4), top: B:64:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x009f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int GD() {
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
                            if (split[2].contains("%")) {
                                break;
                            }
                            int i = 0;
                            while (true) {
                                if (i >= split.length) {
                                    break;
                                } else if (!split[i].contains("%")) {
                                    i++;
                                } else {
                                    str2 = split[i].trim();
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
                            return com.baidu.adp.lib.g.b.g(str2, -1);
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
        return com.baidu.adp.lib.g.b.g(str2, -1);
    }
}

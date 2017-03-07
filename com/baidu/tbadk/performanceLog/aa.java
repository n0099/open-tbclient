package com.baidu.tbadk.performanceLog;

import android.os.Debug;
import android.os.Process;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes.dex */
public class aa {
    private static String aGO = "tb_perfor_samllflow_time";
    private static volatile aa aGR;
    private long aGQ;
    private boolean aGM = false;
    private long aGP = 86400;
    private long aGN = com.baidu.tbadk.core.sharedPref.b.uo().getLong(aGO, 0);

    public static aa Gi() {
        if (aGR == null) {
            synchronized (aa.class) {
                if (aGR == null) {
                    aGR = new aa();
                }
            }
        }
        return aGR;
    }

    private aa() {
        this.aGQ = 0L;
        this.aGQ = this.aGP;
    }

    public boolean Gj() {
        if (!this.aGM || (System.currentTimeMillis() - this.aGN) / 1000 <= this.aGQ) {
            return this.aGM;
        }
        return false;
    }

    public void bV(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (0 == this.aGN || currentTimeMillis - this.aGN >= this.aGQ) {
                this.aGN = currentTimeMillis;
                com.baidu.tbadk.core.sharedPref.b.uo().putLong(aGO, this.aGN);
            }
        } else {
            this.aGN = 0L;
            com.baidu.tbadk.core.sharedPref.b.uo().putLong(aGO, this.aGN);
        }
        this.aGM = z;
        if (BdStatisticsManager.getInstance().isMainProcess()) {
            ab.Go().Gp();
        }
    }

    public String Gk() {
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

    public final String Gl() {
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
        if (!com.baidu.adp.lib.util.i.he()) {
            return "N";
        }
        if (com.baidu.adp.lib.util.i.hf()) {
            return "WIFI";
        }
        if (com.baidu.adp.lib.util.i.hh()) {
            return "4G";
        }
        if (com.baidu.adp.lib.util.i.hi()) {
            return "3G";
        }
        if (!com.baidu.adp.lib.util.i.hj()) {
            return "N";
        }
        return "2G";
    }

    public static String fc(int i) {
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

    public z fd(int i) {
        if (Gj()) {
            switch (i) {
                case 1000:
                    ac acVar = new ac();
                    acVar.subType = "frs";
                    return acVar;
                case 1001:
                    ac acVar2 = new ac();
                    acVar2.subType = "pb";
                    return acVar2;
                case 1002:
                    w wVar = new w();
                    wVar.subType = "im";
                    return wVar;
                case 1003:
                    y yVar = new y();
                    yVar.subType = "native_live";
                    return yVar;
                case 1004:
                    ac acVar3 = new ac();
                    acVar3.subType = "photo_live";
                    return acVar3;
                case 1005:
                    o oVar = new o();
                    oVar.subType = "home_page";
                    return oVar;
                default:
                    return null;
            }
        }
        return null;
    }

    public void P(long j) {
        if (j > 0) {
            this.aGQ = j;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x001f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x001f */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
        r0 = r6[2].trim();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1 A[Catch: Exception -> 0x00a7, TRY_LEAVE, TryCatch #1 {Exception -> 0x00a7, blocks: (B:44:0x009c, B:46:0x00a1), top: B:63:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int Gm() {
        BufferedReader bufferedReader;
        Process process;
        String str;
        String str2;
        Process process2 = 0;
        int myPid = Process.myPid();
        try {
            process = Runtime.getRuntime().exec("top -n 1");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            str2 = process2;
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
                                    process2 = split[i].trim();
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        str = process2;
                        process2 = process;
                        try {
                            e.printStackTrace();
                            if (process2 != null) {
                                try {
                                    process2.destroy();
                                } catch (Exception e2) {
                                    str2 = str;
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                                str2 = str;
                            } else {
                                str2 = str;
                            }
                            if (str2 != null) {
                            }
                            return com.baidu.adp.lib.g.b.g(str2, -1);
                        } catch (Throwable th) {
                            th = th;
                            process = process2;
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
                bufferedReader = null;
                str = null;
                process2 = process;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
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

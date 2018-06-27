package com.baidu.tbadk.k;

import android.os.Process;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.baiduarsdk.ArBridge;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class m {
    private static String aUs = "tb_perfor_samllflow_time";
    private static volatile m aUv;
    private long aUu;
    private boolean aUq = false;
    private long aUt = 86400;
    private long aUr = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(aUs, 0);

    public static m KK() {
        if (aUv == null) {
            synchronized (m.class) {
                if (aUv == null) {
                    aUv = new m();
                }
            }
        }
        return aUv;
    }

    private m() {
        this.aUu = 0L;
        this.aUu = this.aUt;
    }

    public boolean KL() {
        if (!this.aUq || (System.currentTimeMillis() - this.aUr) / 1000 <= this.aUu) {
            return this.aUq;
        }
        return false;
    }

    public void ca(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (0 == this.aUr || currentTimeMillis - this.aUr >= this.aUu) {
                this.aUr = currentTimeMillis;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(aUs, this.aUr);
            }
        } else {
            this.aUr = 0L;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(aUs, this.aUr);
        }
        this.aUq = z;
        if (BdStatisticsManager.getInstance().isMainProcess()) {
            n.KP().KQ();
        }
    }

    public String getNetType() {
        if (!com.baidu.adp.lib.util.j.jD()) {
            return "N";
        }
        if (com.baidu.adp.lib.util.j.jE()) {
            return "WIFI";
        }
        if (com.baidu.adp.lib.util.j.jG()) {
            return "4G";
        }
        if (com.baidu.adp.lib.util.j.jH()) {
            return "3G";
        }
        if (!com.baidu.adp.lib.util.j.jI()) {
            return "N";
        }
        return "2G";
    }

    public static String fn(int i) {
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

    public long KM() {
        try {
            Runtime runtime = Runtime.getRuntime();
            return (runtime.totalMemory() - runtime.freeMemory()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        } catch (Exception e) {
            BdLog.e(e);
            return -1L;
        }
    }

    public l fo(int i) {
        if (KL()) {
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
                case ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC /* 1005 */:
                    e eVar = new e();
                    eVar.subType = "home_page";
                    return eVar;
            }
        }
        return null;
    }

    public void aa(long j) {
        if (j > 0) {
            this.aUu = j;
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
    public int KN() {
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

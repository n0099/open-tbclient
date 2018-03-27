package com.baidu.tbadk.k;

import android.os.Process;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class p {
    private static String bAY = "tb_perfor_samllflow_time";
    private static volatile p bBb;
    private long bBa;
    private boolean bAW = false;
    private long bAZ = 86400;
    private long bAX = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong(bAY, 0);

    public static p Ow() {
        if (bBb == null) {
            synchronized (p.class) {
                if (bBb == null) {
                    bBb = new p();
                }
            }
        }
        return bBb;
    }

    private p() {
        this.bBa = 0L;
        this.bBa = this.bAZ;
    }

    public boolean Ox() {
        if (!this.bAW || (System.currentTimeMillis() - this.bAX) / 1000 <= this.bBa) {
            return this.bAW;
        }
        return false;
    }

    public void cA(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (0 == this.bAX || currentTimeMillis - this.bAX >= this.bBa) {
                this.bAX = currentTimeMillis;
                com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(bAY, this.bAX);
            }
        } else {
            this.bAX = 0L;
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(bAY, this.bAX);
        }
        this.bAW = z;
        if (BdStatisticsManager.getInstance().isMainProcess()) {
            q.OB().OC();
        }
    }

    public String Oy() {
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

    public String getNetType() {
        if (!com.baidu.adp.lib.util.j.oJ()) {
            return "N";
        }
        if (com.baidu.adp.lib.util.j.oK()) {
            return "WIFI";
        }
        if (com.baidu.adp.lib.util.j.oM()) {
            return "4G";
        }
        if (com.baidu.adp.lib.util.j.oN()) {
            return "3G";
        }
        if (!com.baidu.adp.lib.util.j.oO()) {
            return "N";
        }
        return "2G";
    }

    public static String ik(int i) {
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

    public o il(int i) {
        if (Ox()) {
            switch (i) {
                case 1000:
                    r rVar = new r();
                    rVar.subType = "frs";
                    return rVar;
                case 1001:
                    r rVar2 = new r();
                    rVar2.subType = "pb";
                    return rVar2;
                case 1002:
                    m mVar = new m();
                    mVar.subType = "im";
                    return mVar;
                case 1003:
                default:
                    return null;
                case 1004:
                    r rVar3 = new r();
                    rVar3.subType = "photo_live";
                    return rVar3;
                case 1005:
                    h hVar = new h();
                    hVar.subType = "home_page";
                    return hVar;
            }
        }
        return null;
    }

    public void ad(long j) {
        if (j > 0) {
            this.bBa = j;
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
    public int Oz() {
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
                            return com.baidu.adp.lib.g.b.h(str2, -1);
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
        return com.baidu.adp.lib.g.b.h(str2, -1);
    }
}

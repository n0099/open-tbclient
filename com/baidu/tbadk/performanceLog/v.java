package com.baidu.tbadk.performanceLog;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class v {
    private static String ZB = "tb_perfor_samllflow_time";
    private static volatile v ZE;
    private long ZD;
    private boolean Zz = false;
    private long ZC = 86400;
    private long ZA = com.baidu.tbadk.core.sharedPref.b.lk().getLong(ZB, 0);

    public static v uP() {
        if (ZE == null) {
            synchronized (v.class) {
                if (ZE == null) {
                    ZE = new v();
                }
            }
        }
        return ZE;
    }

    private v() {
        this.ZD = 0L;
        this.ZD = this.ZC;
    }

    public boolean uQ() {
        if (!this.Zz || (System.currentTimeMillis() - this.ZA) / 1000 <= this.ZD) {
            return this.Zz;
        }
        return false;
    }

    public void aI(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (0 == this.ZA || currentTimeMillis - this.ZA >= this.ZD) {
                this.ZA = currentTimeMillis;
                com.baidu.tbadk.core.sharedPref.b.lk().putLong(ZB, this.ZA);
            }
        } else {
            this.ZA = 0L;
            com.baidu.tbadk.core.sharedPref.b.lk().putLong(ZB, this.ZA);
        }
        this.Zz = z;
    }

    public String uR() {
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
        if (!com.baidu.adp.lib.util.j.fh()) {
            return "N";
        }
        if (com.baidu.adp.lib.util.j.fi()) {
            return NetworkChangeReceiver.WIFI_STRING;
        }
        if (com.baidu.adp.lib.util.j.fl()) {
            return "3G";
        }
        if (!com.baidu.adp.lib.util.j.eb()) {
            return "N";
        }
        return "2G";
    }

    public static String dn(int i) {
        if (1 == i) {
            return "2G";
        }
        if (2 == i) {
            return "3G";
        }
        if (3 != i) {
            return "N";
        }
        return NetworkChangeReceiver.WIFI_STRING;
    }

    public u dp(int i) {
        if (uQ()) {
            switch (i) {
                case 1000:
                    x xVar = new x();
                    xVar.Zy = "frs";
                    return xVar;
                case 1001:
                    x xVar2 = new x();
                    xVar2.Zy = "pb";
                    return xVar2;
                case 1002:
                    q qVar = new q();
                    qVar.Zy = "im";
                    return qVar;
                default:
                    return null;
            }
        }
        return null;
    }

    public void s(long j) {
        if (j > 0) {
            this.ZD = j;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x0022 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x0022 */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        r0 = r6[2].trim();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009c A[Catch: Exception -> 0x00a2, TRY_LEAVE, TryCatch #8 {Exception -> 0x00a2, blocks: (B:44:0x0097, B:46:0x009c), top: B:69:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0097 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int uS() {
        BufferedReader bufferedReader;
        Process process;
        String str;
        String str2;
        Process process2 = 0;
        try {
            String packageName = TbadkApplication.m251getInst().getPackageName();
            process = Runtime.getRuntime().exec("top -n 1");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            str2 = process2;
                            break;
                        } else if (readLine.endsWith(packageName)) {
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
                            return com.baidu.adp.lib.g.c.f(str2, -1);
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
        return com.baidu.adp.lib.g.c.f(str2, -1);
    }
}

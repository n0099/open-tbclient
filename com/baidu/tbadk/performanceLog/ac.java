package com.baidu.tbadk.performanceLog;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class ac {
    private static String ahk = "tb_perfor_samllflow_time";
    private static volatile ac ahn;
    private long ahm;
    private boolean ahi = false;
    private long ahl = 86400;
    private long ahj = com.baidu.tbadk.core.sharedPref.b.oc().getLong(ahk, 0);

    public static ac zs() {
        if (ahn == null) {
            synchronized (ac.class) {
                if (ahn == null) {
                    ahn = new ac();
                }
            }
        }
        return ahn;
    }

    private ac() {
        this.ahm = 0L;
        this.ahm = this.ahl;
    }

    public boolean zt() {
        if (!this.ahi || (System.currentTimeMillis() - this.ahj) / 1000 <= this.ahm) {
            return this.ahi;
        }
        return false;
    }

    public void aY(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (0 == this.ahj || currentTimeMillis - this.ahj >= this.ahm) {
                this.ahj = currentTimeMillis;
                com.baidu.tbadk.core.sharedPref.b.oc().putLong(ahk, this.ahj);
            }
        } else {
            this.ahj = 0L;
            com.baidu.tbadk.core.sharedPref.b.oc().putLong(ahk, this.ahj);
        }
        this.ahi = z;
    }

    public String zu() {
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
        if (!com.baidu.adp.lib.util.i.ff()) {
            return "N";
        }
        if (com.baidu.adp.lib.util.i.fg()) {
            return NetworkChangeReceiver.WIFI_STRING;
        }
        if (com.baidu.adp.lib.util.i.fj()) {
            return "3G";
        }
        if (!com.baidu.adp.lib.util.i.dY()) {
            return "N";
        }
        return "2G";
    }

    public static String dY(int i) {
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

    public ab dZ(int i) {
        if (zt()) {
            switch (i) {
                case 1000:
                    ae aeVar = new ae();
                    aeVar.subType = "frs";
                    return aeVar;
                case 1001:
                    ae aeVar2 = new ae();
                    aeVar2.subType = "pb";
                    return aeVar2;
                case 1002:
                    x xVar = new x();
                    xVar.subType = "im";
                    return xVar;
                default:
                    return null;
            }
        }
        return null;
    }

    public void v(long j) {
        if (j > 0) {
            this.ahm = j;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x0026 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x0026 */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
        r0 = r6[2].trim();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a0 A[Catch: Exception -> 0x00a6, TRY_LEAVE, TryCatch #3 {Exception -> 0x00a6, blocks: (B:44:0x009b, B:46:0x00a0), top: B:63:0x009b }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int zv() {
        BufferedReader bufferedReader;
        Process process;
        String str;
        String str2;
        Process process2 = 0;
        try {
            String packageName = TbadkCoreApplication.m255getInst().getContext().getPackageName();
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
                            return com.baidu.adp.lib.g.c.toInt(str2, -1);
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
        return com.baidu.adp.lib.g.c.toInt(str2, -1);
    }
}

package com.baidu.tbadk.performanceLog;

import android.os.Debug;
import android.os.Process;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.core.service.NetworkChangeReceiver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class ah {
    private static String apO = "tb_perfor_samllflow_time";
    private static volatile ah apR;
    private long apQ;
    private boolean apM = false;
    private long apP = 86400;
    private long apN = com.baidu.tbadk.core.sharedPref.b.rB().getLong(apO, 0);

    public static ah CK() {
        if (apR == null) {
            synchronized (ah.class) {
                if (apR == null) {
                    apR = new ah();
                }
            }
        }
        return apR;
    }

    private ah() {
        this.apQ = 0L;
        this.apQ = this.apP;
    }

    public boolean CL() {
        if (!this.apM || (System.currentTimeMillis() - this.apN) / 1000 <= this.apQ) {
            return this.apM;
        }
        return false;
    }

    public void bd(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (0 == this.apN || currentTimeMillis - this.apN >= this.apQ) {
                this.apN = currentTimeMillis;
                com.baidu.tbadk.core.sharedPref.b.rB().putLong(apO, this.apN);
            }
        } else {
            this.apN = 0L;
            com.baidu.tbadk.core.sharedPref.b.rB().putLong(apO, this.apN);
        }
        this.apM = z;
    }

    public String CM() {
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

    public final String CN() {
        try {
            String valueOf = String.valueOf(Debug.getNativeHeapSize() / 1024);
            String valueOf2 = String.valueOf(Debug.getNativeHeapAllocatedSize() / 1024);
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
        if (!com.baidu.adp.lib.util.k.iH()) {
            return "N";
        }
        if (com.baidu.adp.lib.util.k.iI()) {
            return NetworkChangeReceiver.WIFI_STRING;
        }
        if (com.baidu.adp.lib.util.k.iL()) {
            return "3G";
        }
        if (!com.baidu.adp.lib.util.k.hx()) {
            return "N";
        }
        return "2G";
    }

    public static String ec(int i) {
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

    public ag ed(int i) {
        if (CL()) {
            switch (i) {
                case 1000:
                    aj ajVar = new aj();
                    ajVar.subType = "frs";
                    return ajVar;
                case BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES /* 1001 */:
                    aj ajVar2 = new aj();
                    ajVar2.subType = "pb";
                    return ajVar2;
                case BDLocationStatusCodes.GEOFENCE_SERVICE_NO_ALIVIABLE /* 1002 */:
                    ab abVar = new ab();
                    abVar.subType = "im";
                    return abVar;
                case 1003:
                    af afVar = new af();
                    afVar.subType = "native_live";
                    return afVar;
                default:
                    return null;
            }
        }
        return null;
    }

    public void v(long j) {
        if (j > 0) {
            this.apQ = j;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x001e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:82:0x001e */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
        r0 = r6[2].trim();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a0 A[Catch: Exception -> 0x00a6, TRY_LEAVE, TryCatch #3 {Exception -> 0x00a6, blocks: (B:44:0x009b, B:46:0x00a0), top: B:63:0x009b }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x009b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int CO() {
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

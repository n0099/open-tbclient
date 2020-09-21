package com.baidu.tbadk.n;

import android.os.Process;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class m {
    private static String eVm = "tb_perfor_samllflow_time";
    private static volatile m eVp;
    private long eVo;
    private boolean ayR = false;
    private long eVn = 86400;
    private long eVl = com.baidu.tbadk.core.sharedPref.b.bjf().getLong(eVm, 0);

    public static m bvs() {
        if (eVp == null) {
            synchronized (m.class) {
                if (eVp == null) {
                    eVp = new m();
                }
            }
        }
        return eVp;
    }

    private m() {
        this.eVo = 0L;
        this.eVo = this.eVn;
    }

    public boolean bvt() {
        if (!this.ayR || (System.currentTimeMillis() - this.eVl) / 1000 <= this.eVo) {
            return this.ayR;
        }
        return false;
    }

    public void jE(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (0 == this.eVl || currentTimeMillis - this.eVl >= this.eVo) {
                this.eVl = currentTimeMillis;
                com.baidu.tbadk.core.sharedPref.b.bjf().putLong(eVm, this.eVl);
            }
        } else {
            this.eVl = 0L;
            com.baidu.tbadk.core.sharedPref.b.bjf().putLong(eVm, this.eVl);
        }
        this.ayR = z;
        if (BdStatisticsManager.getInstance().isMainProcess()) {
            n.bvx().bvy();
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

    public static String qS(int i) {
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

    public long bvu() {
        try {
            Runtime runtime = Runtime.getRuntime();
            return (runtime.totalMemory() - runtime.freeMemory()) / 1048576;
        } catch (Exception e) {
            BdLog.e(e);
            return -1L;
        }
    }

    public l qT(int i) {
        if (bvt()) {
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
                case 1006:
                case 1007:
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
                case 1008:
                    o oVar4 = new o();
                    oVar4.subType = "user_center";
                    return oVar4;
                case 1009:
                    o oVar5 = new o();
                    oVar5.subType = "sign_all";
                    return oVar5;
                case 1010:
                    o oVar6 = new o();
                    oVar6.subType = "person_center";
                    return oVar6;
                case 1011:
                    o oVar7 = new o();
                    oVar7.subType = "person_center_home";
                    return oVar7;
                case 1012:
                    o oVar8 = new o();
                    oVar8.subType = "person_center_post";
                    return oVar8;
                case 1013:
                    o oVar9 = new o();
                    oVar9.subType = "person_center_dynamic";
                    return oVar9;
            }
        }
        return null;
    }

    public void db(long j) {
        if (j > 0) {
            this.eVo = j;
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

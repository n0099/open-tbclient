package com.baidu.tbadk.n;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class k {
    private static String fMp = "tb_perfor_samllflow_time";
    private static volatile k fMs;
    private long fMr;
    private boolean aze = false;
    private long fMq = 86400;
    private long fMo = com.baidu.tbadk.core.sharedPref.b.bvq().getLong(fMp, 0);

    public static k bHF() {
        if (fMs == null) {
            synchronized (k.class) {
                if (fMs == null) {
                    fMs = new k();
                }
            }
        }
        return fMs;
    }

    private k() {
        this.fMr = 0L;
        BdBaseApplication.getInst().setStartSmallFlowTime(this.fMo);
        this.fMr = this.fMq;
        BdBaseApplication.getInst().setSmallFlowInterval(this.fMr);
    }

    public boolean isSmallFlow() {
        if (!this.aze || (System.currentTimeMillis() - this.fMo) / 1000 <= this.fMr) {
            return this.aze;
        }
        return false;
    }

    public void lo(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            if (0 == this.fMo || currentTimeMillis - this.fMo >= this.fMr) {
                this.fMo = currentTimeMillis;
                BdBaseApplication.getInst().setStartSmallFlowTime(this.fMo);
                com.baidu.tbadk.core.sharedPref.b.bvq().putLong(fMp, this.fMo);
            }
        } else {
            this.fMo = 0L;
            BdBaseApplication.getInst().setStartSmallFlowTime(0L);
            com.baidu.tbadk.core.sharedPref.b.bvq().putLong(fMp, this.fMo);
        }
        this.aze = z;
        BdBaseApplication.getInst().setIsSmallFlow(z);
        if (BdStatisticsManager.getInstance().isMainProcess()) {
            l.bHK().bHL();
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

    public long bHG() {
        try {
            Runtime runtime = Runtime.getRuntime();
            return (runtime.totalMemory() - runtime.freeMemory()) / 1048576;
        } catch (Exception e) {
            BdLog.e(e);
            return -1L;
        }
    }

    public j sW(int i) {
        if (isSmallFlow()) {
            switch (i) {
                case 1000:
                    m mVar = new m();
                    mVar.subType = "frs";
                    return mVar;
                case 1001:
                    m mVar2 = new m();
                    mVar2.subType = "pb";
                    return mVar2;
                case 1002:
                    i iVar = new i();
                    iVar.subType = "im";
                    return iVar;
                case 1003:
                case 1006:
                case 1007:
                default:
                    return null;
                case 1004:
                    m mVar3 = new m();
                    mVar3.subType = "photo_live";
                    return mVar3;
                case 1005:
                    e eVar = new e();
                    eVar.subType = "home_page";
                    return eVar;
                case 1008:
                    m mVar4 = new m();
                    mVar4.subType = "user_center";
                    return mVar4;
                case 1009:
                    m mVar5 = new m();
                    mVar5.subType = "sign_all";
                    return mVar5;
                case 1010:
                    m mVar6 = new m();
                    mVar6.subType = "person_center";
                    return mVar6;
                case 1011:
                    m mVar7 = new m();
                    mVar7.subType = "person_center_home";
                    return mVar7;
                case 1012:
                    m mVar8 = new m();
                    mVar8.subType = "person_center_post";
                    return mVar8;
                case 1013:
                    m mVar9 = new m();
                    mVar9.subType = "person_center_dynamic";
                    return mVar9;
            }
        }
        return null;
    }

    public void setSmallFlowInterval(long j) {
        if (j > 0) {
            this.fMr = j;
            BdBaseApplication.getInst().setSmallFlowInterval(j);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        r5 = r3[2].trim();
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getCpuUsageStatistic() {
        BufferedReader bufferedReader;
        Process process;
        Exception e;
        BufferedReader bufferedReader2;
        String str;
        String str2;
        String str3;
        int myPid = Process.myPid();
        try {
            try {
                process = Runtime.getRuntime().exec("top -n 1");
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String str4 = null;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            str3 = str4;
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
                                    String str5 = split[i];
                                    if (str5 == null || !str5.contains("%")) {
                                        i++;
                                    } else {
                                        str4 = str5.trim();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = str4;
                        e.printStackTrace();
                        if (process != null) {
                            try {
                                process.destroy();
                            } catch (Exception e3) {
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
                    }
                }
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Exception e4) {
                        str2 = str3;
                    }
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                str2 = str3;
            } catch (Exception e5) {
                e = e5;
                bufferedReader2 = null;
                str = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (process != null) {
                    try {
                        process.destroy();
                    } catch (Exception e6) {
                        throw th;
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Exception e7) {
            e = e7;
            bufferedReader2 = null;
            process = null;
            str = null;
        } catch (Throwable th3) {
            th = th3;
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

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
        r0 = r4.replaceAll("\\s+", com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064 A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #2 {Exception -> 0x0068, blocks: (B:28:0x005f, B:30:0x0064), top: B:46:0x005f }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String bHH() {
        BufferedReader bufferedReader;
        Process process;
        String str = null;
        int myPid = Process.myPid();
        try {
            process = Runtime.getRuntime().exec("top -n 1");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while (true) {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                if (readLine.trim().contains(String.valueOf(myPid))) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            if (process != null) {
                                try {
                                    process.destroy();
                                } catch (Exception e2) {
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return str;
                        }
                    } catch (Throwable th) {
                        th = th;
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
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
                if (process != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            process = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            process = null;
        }
        return str;
    }
}

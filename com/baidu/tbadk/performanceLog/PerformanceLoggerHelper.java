package com.baidu.tbadk.performanceLog;

import android.os.Process;
import c.a.q0.r.j0.b;
import c.a.q0.r0.e;
import c.a.q0.r0.i;
import c.a.q0.r0.j;
import c.a.q0.r0.k;
import c.a.q0.r0.l;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes5.dex */
public class PerformanceLoggerHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NETWORK_CLASS_2G = 1;
    public static final int NETWORK_CLASS_3G = 2;
    public static final int NETWORK_CLASS_4G = 3;
    public static final int NETWORK_CLASS_5G = 4;
    public static final int NETWORK_CLASS_WIFI = 5;
    public static String TB_PERFOR_SMALLFLOW_TIME = "tb_perfor_samllflow_time";
    public static volatile PerformanceLoggerHelper mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSmallFlow;
    public long maxIntervalForOnce;
    public long smallFlowInterval;
    public long startSmallFlowTime;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-174643387, "Lcom/baidu/tbadk/performanceLog/PerformanceLoggerHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-174643387, "Lcom/baidu/tbadk/performanceLog/PerformanceLoggerHelper;");
        }
    }

    public PerformanceLoggerHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isSmallFlow = false;
        this.maxIntervalForOnce = 86400L;
        this.smallFlowInterval = 0L;
        this.startSmallFlowTime = b.k().m(TB_PERFOR_SMALLFLOW_TIME, 0L);
        BdBaseApplication.getInst().setStartSmallFlowTime(this.startSmallFlowTime);
        this.smallFlowInterval = this.maxIntervalForOnce;
        BdBaseApplication.getInst().setSmallFlowInterval(this.smallFlowInterval);
    }

    public static PerformanceLoggerHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mInstance == null) {
                synchronized (PerformanceLoggerHelper.class) {
                    if (mInstance == null) {
                        mInstance = new PerformanceLoggerHelper();
                    }
                }
            }
            return mInstance;
        }
        return (PerformanceLoggerHelper) invokeV.objValue;
    }

    public static String getNetStringWithType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? 1 == i2 ? "2G" : 2 == i2 ? "3G" : 3 == i2 ? "4G" : 4 == i2 ? "5G" : 5 == i2 ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : "N" : (String) invokeI.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x009b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x0024 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:84:0x006b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x0024 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x0024 */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        r3 = r6[2].trim();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b4 A[Catch: Exception -> 0x00b7, TRY_LEAVE, TryCatch #5 {Exception -> 0x00b7, blocks: (B:59:0x00af, B:61:0x00b4), top: B:71:0x00af }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getCpuUsageStatistic() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int myPid = Process.myPid();
            Process process = 0;
            try {
                Process exec = Runtime.getRuntime().exec("top -n 1");
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
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
                                int i2 = 0;
                                while (true) {
                                    if (i2 < length) {
                                        String str3 = split[i2];
                                        if (str3 != null && str3.contains("%")) {
                                            process = str3.trim();
                                            break;
                                        }
                                        i2++;
                                    } else {
                                        break;
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str = process;
                            process = exec;
                            try {
                                e.printStackTrace();
                                if (process != null) {
                                    try {
                                        process.destroy();
                                    } catch (Exception unused) {
                                        str2 = str;
                                        if (str2 != null) {
                                        }
                                        return c.a.d.f.m.b.e(str2, -1);
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                str2 = str;
                                if (str2 != null) {
                                }
                                return c.a.d.f.m.b.e(str2, -1);
                            } catch (Throwable th) {
                                th = th;
                                if (process != null) {
                                    try {
                                        process.destroy();
                                    } catch (Exception unused2) {
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
                            process = exec;
                            if (process != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            throw th;
                        }
                    }
                    if (exec != null) {
                        try {
                            exec.destroy();
                        } catch (Exception unused3) {
                            str2 = process;
                        }
                    }
                    bufferedReader.close();
                    str2 = process;
                } catch (Exception e3) {
                    e = e3;
                    bufferedReader = null;
                    process = exec;
                    str = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Exception e4) {
                e = e4;
                str = null;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
            if (str2 != null) {
                String[] split2 = str2.split("%");
                if (split2.length > 0) {
                    str2 = split2[0];
                }
            }
            return c.a.d.f.m.b.e(str2, -1);
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
        r1 = r4.replaceAll("\\s+", "_");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
        if (r3 != null) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a A[Catch: Exception -> 0x006d, TRY_LEAVE, TryCatch #2 {Exception -> 0x006d, blocks: (B:36:0x0065, B:38:0x006a), top: B:49:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getCpuUsageStatisticString() {
        InterceptResult invokeV;
        BufferedReader bufferedReader;
        Process process;
        BufferedReader bufferedReader2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int myPid = Process.myPid();
            String str = null;
            str = null;
            str = null;
            str = null;
            Process process2 = null;
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    process = Runtime.getRuntime().exec("top -n 1");
                    try {
                        bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine != null) {
                                    if (readLine.trim().contains(String.valueOf(myPid))) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                if (process != null) {
                                    process.destroy();
                                }
                            }
                        }
                        if (process != null) {
                            process.destroy();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        bufferedReader2 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                        process2 = process;
                        if (process2 != null) {
                            try {
                                process2.destroy();
                            } catch (Exception unused) {
                                throw th;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception e4) {
                e = e4;
                process = null;
                bufferedReader2 = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (process2 != null) {
                }
                if (bufferedReader != null) {
                }
                throw th;
            }
            bufferedReader2.close();
            return str;
        }
        return (String) invokeV.objValue;
    }

    public long getCurrentUsedMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                Runtime runtime = Runtime.getRuntime();
                return (runtime.totalMemory() - runtime.freeMemory()) / 1048576;
            } catch (Exception e2) {
                BdLog.e(e2);
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public j getLoggerWithType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (isSmallFlow()) {
                switch (i2) {
                    case 1000:
                        l lVar = new l();
                        lVar.a = "frs";
                        return lVar;
                    case 1001:
                        l lVar2 = new l();
                        lVar2.a = "pb";
                        return lVar2;
                    case 1002:
                        i iVar = new i();
                        iVar.a = "im";
                        return iVar;
                    case 1003:
                    case 1006:
                    case 1007:
                    default:
                        return null;
                    case 1004:
                        l lVar3 = new l();
                        lVar3.a = "photo_live";
                        return lVar3;
                    case 1005:
                        e eVar = new e();
                        eVar.a = "home_page";
                        return eVar;
                    case 1008:
                        l lVar4 = new l();
                        lVar4.a = "user_center";
                        return lVar4;
                    case 1009:
                        l lVar5 = new l();
                        lVar5.a = "sign_all";
                        return lVar5;
                    case 1010:
                        l lVar6 = new l();
                        lVar6.a = "person_center";
                        return lVar6;
                    case 1011:
                        l lVar7 = new l();
                        lVar7.a = "person_center_home";
                        return lVar7;
                    case 1012:
                        l lVar8 = new l();
                        lVar8.a = "person_center_post";
                        return lVar8;
                    case 1013:
                        l lVar9 = new l();
                        lVar9.a = "person_center_dynamic";
                        return lVar9;
                }
            }
            return null;
        }
        return (j) invokeI.objValue;
    }

    public String getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? !c.a.d.f.p.l.z() ? "N" : c.a.d.f.p.l.H() ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : c.a.d.f.p.l.v() ? "4G" : c.a.d.f.p.l.u() ? "3G" : c.a.d.f.p.l.t() ? "2G" : "N" : (String) invokeV.objValue;
    }

    public boolean isSmallFlow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!this.isSmallFlow || (System.currentTimeMillis() - this.startSmallFlowTime) / 1000 <= this.smallFlowInterval) {
                return this.isSmallFlow;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setSmallFlow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                long j2 = this.startSmallFlowTime;
                if (0 == j2 || currentTimeMillis - j2 >= this.smallFlowInterval) {
                    this.startSmallFlowTime = currentTimeMillis;
                    BdBaseApplication.getInst().setStartSmallFlowTime(this.startSmallFlowTime);
                    b.k().x(TB_PERFOR_SMALLFLOW_TIME, this.startSmallFlowTime);
                }
            } else {
                this.startSmallFlowTime = 0L;
                BdBaseApplication.getInst().setStartSmallFlowTime(0L);
                b.k().x(TB_PERFOR_SMALLFLOW_TIME, this.startSmallFlowTime);
            }
            this.isSmallFlow = z;
            BdBaseApplication.getInst().setIsSmallFlow(z);
            if (BdStatisticsManager.getInstance().isMainProcess()) {
                k.b().f();
            }
        }
    }

    public void setSmallFlowInterval(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) || j2 <= 0) {
            return;
        }
        this.smallFlowInterval = j2;
        BdBaseApplication.getInst().setSmallFlowInterval(j2);
    }
}

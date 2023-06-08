package com.baidu.tbadk.performanceLog;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ms5;
import com.baidu.tieba.n95;
import com.baidu.tieba.qs5;
import com.baidu.tieba.rs5;
import com.baidu.tieba.ss5;
import com.baidu.tieba.tg;
import com.baidu.tieba.ts5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes4.dex */
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

    public static String getNetStringWithType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? 1 == i ? "2G" : 2 == i ? "3G" : 3 == i ? "4G" : 4 == i ? "5G" : 5 == i ? "WIFI" : "N" : (String) invokeI.objValue;
    }

    public PerformanceLoggerHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isSmallFlow = false;
        this.maxIntervalForOnce = 86400L;
        this.smallFlowInterval = 0L;
        this.startSmallFlowTime = n95.m().o(TB_PERFOR_SMALLFLOW_TIME, 0L);
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

    public long getCurrentUsedMemory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                Runtime runtime = Runtime.getRuntime();
                return (runtime.totalMemory() - runtime.freeMemory()) / 1048576;
            } catch (Exception e) {
                BdLog.e(e);
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public boolean isSmallFlow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.isSmallFlow && (System.currentTimeMillis() - this.startSmallFlowTime) / 1000 > this.smallFlowInterval) {
                return false;
            }
            return this.isSmallFlow;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x009c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x0025 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:84:0x006c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x0025 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x0025 */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004f, code lost:
        r3 = r6[2].trim();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b5 A[Catch: Exception -> 0x00b8, TRY_LEAVE, TryCatch #3 {Exception -> 0x00b8, blocks: (B:59:0x00b0, B:61:0x00b5), top: B:71:0x00b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                                int i = 0;
                                while (true) {
                                    if (i < length) {
                                        String str3 = split[i];
                                        if (str3 != null && str3.contains("%")) {
                                            process = str3.trim();
                                            break;
                                        }
                                        i++;
                                    } else {
                                        break;
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e = e;
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
                                        return tg.e(str2, -1);
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                str2 = str;
                                if (str2 != null) {
                                }
                                return tg.e(str2, -1);
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
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = null;
                    process = exec;
                    str = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (Exception e3) {
                e = e3;
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
            return tg.e(str2, -1);
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
        r1 = r4.replaceAll("\\s+", "_");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
        if (r3 != null) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b A[Catch: Exception -> 0x006e, TRY_LEAVE, TryCatch #1 {Exception -> 0x006e, blocks: (B:36:0x0066, B:38:0x006b), top: B:46:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                try {
                    try {
                        process = Runtime.getRuntime().exec("top -n 1");
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e) {
                    e = e;
                    process = null;
                    bufferedReader2 = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
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
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    process2 = process;
                    if (process2 != null) {
                    }
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
                bufferedReader2.close();
            } catch (Exception unused2) {
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public rs5 getLoggerWithType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (!isSmallFlow()) {
                return null;
            }
            switch (i) {
                case 1000:
                    ts5 ts5Var = new ts5();
                    ts5Var.a = "frs";
                    return ts5Var;
                case 1001:
                    ts5 ts5Var2 = new ts5();
                    ts5Var2.a = "pb";
                    return ts5Var2;
                case 1002:
                    qs5 qs5Var = new qs5();
                    qs5Var.a = "im";
                    return qs5Var;
                case 1003:
                case 1006:
                case 1007:
                default:
                    return null;
                case 1004:
                    ts5 ts5Var3 = new ts5();
                    ts5Var3.a = "photo_live";
                    return ts5Var3;
                case 1005:
                    ms5 ms5Var = new ms5();
                    ms5Var.a = "home_page";
                    return ms5Var;
                case 1008:
                    ts5 ts5Var4 = new ts5();
                    ts5Var4.a = "user_center";
                    return ts5Var4;
                case 1009:
                    ts5 ts5Var5 = new ts5();
                    ts5Var5.a = "sign_all";
                    return ts5Var5;
                case 1010:
                    ts5 ts5Var6 = new ts5();
                    ts5Var6.a = "person_center";
                    return ts5Var6;
                case 1011:
                    ts5 ts5Var7 = new ts5();
                    ts5Var7.a = "person_center_home";
                    return ts5Var7;
                case 1012:
                    ts5 ts5Var8 = new ts5();
                    ts5Var8.a = "person_center_post";
                    return ts5Var8;
                case 1013:
                    ts5 ts5Var9 = new ts5();
                    ts5Var9.a = "person_center_dynamic";
                    return ts5Var9;
            }
        }
        return (rs5) invokeI.objValue;
    }

    public String getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                return "N";
            }
            if (BdNetTypeUtil.isWifiNet()) {
                return "WIFI";
            }
            if (BdNetTypeUtil.is4GNet()) {
                return "4G";
            }
            if (BdNetTypeUtil.is3GNet()) {
                return "3G";
            }
            if (!BdNetTypeUtil.is2GNet()) {
                return "N";
            }
            return "2G";
        }
        return (String) invokeV.objValue;
    }

    public void setSmallFlow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                long j = this.startSmallFlowTime;
                if (0 == j || currentTimeMillis - j >= this.smallFlowInterval) {
                    this.startSmallFlowTime = currentTimeMillis;
                    BdBaseApplication.getInst().setStartSmallFlowTime(this.startSmallFlowTime);
                    n95.m().A(TB_PERFOR_SMALLFLOW_TIME, this.startSmallFlowTime);
                }
            } else {
                this.startSmallFlowTime = 0L;
                BdBaseApplication.getInst().setStartSmallFlowTime(0L);
                n95.m().A(TB_PERFOR_SMALLFLOW_TIME, this.startSmallFlowTime);
            }
            this.isSmallFlow = z;
            BdBaseApplication.getInst().setIsSmallFlow(z);
            if (BdStatisticsManager.getInstance().isMainProcess()) {
                ss5.b().f();
            }
        }
    }

    public void setSmallFlowInterval(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048583, this, j) == null) && j > 0) {
            this.smallFlowInterval = j;
            BdBaseApplication.getInst().setSmallFlowInterval(j);
        }
    }
}

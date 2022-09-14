package com.baidu.tbadk.performanceLog;

import android.os.Process;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.bx4;
import com.baidu.tieba.dd5;
import com.baidu.tieba.dh;
import com.baidu.tieba.ed5;
import com.baidu.tieba.fd5;
import com.baidu.tieba.gd5;
import com.baidu.tieba.zc5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes3.dex */
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
        this.startSmallFlowTime = bx4.k().m(TB_PERFOR_SMALLFLOW_TIME, 0L);
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

    public static String getNetStringWithType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? 1 == i ? "2G" : 2 == i ? "3G" : 3 == i ? "4G" : 4 == i ? "5G" : 5 == i ? "WIFI" : "N" : (String) invokeI.objValue;
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
                                        return dh.e(str2, -1);
                                    }
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                str2 = str;
                                if (str2 != null) {
                                }
                                return dh.e(str2, -1);
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
            return dh.e(str2, -1);
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
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                if (process != null) {
                                    process.destroy();
                                }
                            }
                        }
                        if (process != null) {
                            process.destroy();
                        }
                    } catch (Exception e2) {
                        e = e2;
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
            } catch (Exception e3) {
                e = e3;
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
            } catch (Exception e) {
                BdLog.e(e);
                return -1L;
            }
        }
        return invokeV.longValue;
    }

    public ed5 getLoggerWithType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (isSmallFlow()) {
                switch (i) {
                    case 1000:
                        gd5 gd5Var = new gd5();
                        gd5Var.a = "frs";
                        return gd5Var;
                    case 1001:
                        gd5 gd5Var2 = new gd5();
                        gd5Var2.a = "pb";
                        return gd5Var2;
                    case 1002:
                        dd5 dd5Var = new dd5();
                        dd5Var.a = "im";
                        return dd5Var;
                    case 1003:
                    case 1006:
                    case 1007:
                    default:
                        return null;
                    case 1004:
                        gd5 gd5Var3 = new gd5();
                        gd5Var3.a = "photo_live";
                        return gd5Var3;
                    case 1005:
                        zc5 zc5Var = new zc5();
                        zc5Var.a = "home_page";
                        return zc5Var;
                    case 1008:
                        gd5 gd5Var4 = new gd5();
                        gd5Var4.a = "user_center";
                        return gd5Var4;
                    case 1009:
                        gd5 gd5Var5 = new gd5();
                        gd5Var5.a = "sign_all";
                        return gd5Var5;
                    case 1010:
                        gd5 gd5Var6 = new gd5();
                        gd5Var6.a = "person_center";
                        return gd5Var6;
                    case 1011:
                        gd5 gd5Var7 = new gd5();
                        gd5Var7.a = "person_center_home";
                        return gd5Var7;
                    case 1012:
                        gd5 gd5Var8 = new gd5();
                        gd5Var8.a = "person_center_post";
                        return gd5Var8;
                    case 1013:
                        gd5 gd5Var9 = new gd5();
                        gd5Var9.a = "person_center_dynamic";
                        return gd5Var9;
                }
            }
            return null;
        }
        return (ed5) invokeI.objValue;
    }

    public String getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? !BdNetTypeUtil.isNetWorkAvailable() ? "N" : BdNetTypeUtil.isWifiNet() ? "WIFI" : BdNetTypeUtil.is4GNet() ? "4G" : BdNetTypeUtil.is3GNet() ? "3G" : BdNetTypeUtil.is2GNet() ? "2G" : "N" : (String) invokeV.objValue;
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
                long j = this.startSmallFlowTime;
                if (0 == j || currentTimeMillis - j >= this.smallFlowInterval) {
                    this.startSmallFlowTime = currentTimeMillis;
                    BdBaseApplication.getInst().setStartSmallFlowTime(this.startSmallFlowTime);
                    bx4.k().x(TB_PERFOR_SMALLFLOW_TIME, this.startSmallFlowTime);
                }
            } else {
                this.startSmallFlowTime = 0L;
                BdBaseApplication.getInst().setStartSmallFlowTime(0L);
                bx4.k().x(TB_PERFOR_SMALLFLOW_TIME, this.startSmallFlowTime);
            }
            this.isSmallFlow = z;
            BdBaseApplication.getInst().setIsSmallFlow(z);
            if (BdStatisticsManager.getInstance().isMainProcess()) {
                fd5.b().f();
            }
        }
    }

    public void setSmallFlowInterval(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048583, this, j) == null) || j <= 0) {
            return;
        }
        this.smallFlowInterval = j;
        BdBaseApplication.getInst().setSmallFlowInterval(j);
    }
}

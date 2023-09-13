package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class bia {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, dia> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                bia.a(1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947647311, "Lcom/baidu/tieba/bia;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947647311, "Lcom/baidu/tieba/bia;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2001011));
        a = new HashMap<>();
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i) == null) {
            for (String str : a.keySet()) {
                b(a.get(str), i);
            }
        }
    }

    public static void b(dia diaVar, int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, diaVar, i) == null) {
            cia ciaVar = diaVar.d;
            cia ciaVar2 = diaVar.e;
            cia ciaVar3 = diaVar.f;
            if (ciaVar.b + ciaVar2.b + ciaVar3.b >= i) {
                BdStatsItem bdStatsItem = new BdStatsItem("dbg");
                bdStatsItem.append("act", diaVar.c);
                bdStatsItem.append("httpTimeCost", String.valueOf(ciaVar.a));
                bdStatsItem.append("httpNum", String.valueOf(ciaVar.b));
                bdStatsItem.append("httpFailnum", String.valueOf(ciaVar.c));
                bdStatsItem.append("httpSize", String.valueOf(ciaVar.d));
                bdStatsItem.append("socketTimeCost", String.valueOf(ciaVar2.a));
                bdStatsItem.append("socketNum", String.valueOf(ciaVar2.b));
                bdStatsItem.append("socketFailnum", String.valueOf(ciaVar2.c));
                bdStatsItem.append("socketSize", String.valueOf(ciaVar2.d));
                bdStatsItem.append("abortTimeCost", String.valueOf(ciaVar3.a));
                bdStatsItem.append("abortNum", String.valueOf(ciaVar3.b));
                bdStatsItem.append("netType", diaVar.b);
                if (diaVar.a) {
                    str = "1";
                } else {
                    str = "0";
                }
                bdStatsItem.append("isJson", str);
                BdStatisticsManager.getInstance().debug("frs", bdStatsItem);
                ciaVar.a();
                ciaVar2.a();
                ciaVar3.a();
            }
        }
    }

    public static void c(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, str, str2, z) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!a.containsKey(str3)) {
                a.put(str3, new dia(str, str2, z));
            }
        }
    }

    public static dia e(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, str2, z)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!a.containsKey(str3)) {
                a.put(str3, new dia(str, str2, z));
            }
            return a.get(str3);
        }
        return (dia) invokeLLZ.objValue;
    }
}

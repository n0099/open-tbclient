package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class gda {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, ida> a;
    public transient /* synthetic */ FieldHolder $fh;

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends CustomMessageListener {
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
                gda.a(1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947791461, "Lcom/baidu/tieba/gda;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947791461, "Lcom/baidu/tieba/gda;");
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

    public static void b(ida idaVar, int i) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, idaVar, i) == null) {
            hda hdaVar = idaVar.d;
            hda hdaVar2 = idaVar.e;
            hda hdaVar3 = idaVar.f;
            if (hdaVar.b + hdaVar2.b + hdaVar3.b >= i) {
                eh ehVar = new eh("dbg");
                ehVar.b("act", idaVar.c);
                ehVar.b("httpTimeCost", String.valueOf(hdaVar.a));
                ehVar.b("httpNum", String.valueOf(hdaVar.b));
                ehVar.b("httpFailnum", String.valueOf(hdaVar.c));
                ehVar.b("httpSize", String.valueOf(hdaVar.d));
                ehVar.b("socketTimeCost", String.valueOf(hdaVar2.a));
                ehVar.b("socketNum", String.valueOf(hdaVar2.b));
                ehVar.b("socketFailnum", String.valueOf(hdaVar2.c));
                ehVar.b("socketSize", String.valueOf(hdaVar2.d));
                ehVar.b("abortTimeCost", String.valueOf(hdaVar3.a));
                ehVar.b("abortNum", String.valueOf(hdaVar3.b));
                ehVar.b("netType", idaVar.b);
                if (idaVar.a) {
                    str = "1";
                } else {
                    str = "0";
                }
                ehVar.b("isJson", str);
                BdStatisticsManager.getInstance().debug("frs", ehVar);
                hdaVar.a();
                hdaVar2.a();
                hdaVar3.a();
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
                a.put(str3, new ida(str, str2, z));
            }
        }
    }

    public static ida e(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, str2, z)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!a.containsKey(str3)) {
                a.put(str3, new ida(str, str2, z));
            }
            return a.get(str3);
        }
        return (ida) invokeLLZ.objValue;
    }
}

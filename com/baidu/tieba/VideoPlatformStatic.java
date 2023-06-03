package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class VideoPlatformStatic {
    public static /* synthetic */ Interceptable $ic;
    public static CustomMessageListener a;
    public transient /* synthetic */ FieldHolder $fh;

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            if (i != -400) {
                if (i != -200) {
                    return i != -100 ? 3 : 2;
                }
                return 1;
            }
            return 4;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes4.dex */
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
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                v5a.h().o();
                s5a.d().k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable<tx8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<tx8> run(CustomMessage<tx8> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2921309, new ux8());
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-27162483, "Lcom/baidu/tieba/VideoPlatformStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-27162483, "Lcom/baidu/tieba/VideoPlatformStatic;");
                return;
            }
        }
        a = new a(2007015);
        f();
        MessageManager.getInstance().registerListener(a);
        e();
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (BdNetTypeUtil.isWifiNet()) {
                return "WIFI";
            }
            if (BdNetTypeUtil.is2GNet()) {
                return "2G";
            }
            if (BdNetTypeUtil.is3GNet()) {
                return "3G";
            }
            if (BdNetTypeUtil.is4GNet() || BdNetTypeUtil.isNetWorkAvailable()) {
                return "4G";
            }
            return HlsPlaylistParser.METHOD_NONE;
        }
        return (String) invokeV.objValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_MOOV_UPLOAD, TbConfig.SERVER_ADDRESS + TbConfig.URL_MOOV_REPORT);
            tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public VideoPlatformStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2921309, new b());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.equals(str, "1")) {
                return "index";
            }
            if (TextUtils.equals(str, "2")) {
                return "frs";
            }
            if (TextUtils.equals(str, "6")) {
                return "pb";
            }
            if (TextUtils.equals(str, "12")) {
                return "frs_bavideotab";
            }
            if (TextUtils.equals(str, "3")) {
                return "floor5";
            }
            if (TextUtils.equals(str, "10")) {
                return "floor10";
            }
            if (TextUtils.equals(str, "11")) {
                return "floor15";
            }
            if (TextUtils.equals(str, "13")) {
                return "auto_midpage";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appVer", TbConfig.getVersion());
                jSONObject.put("clientIp", CommonHelper.getIp());
                jSONObject.put("clientTimestamp", String.valueOf(System.currentTimeMillis()));
                jSONObject.put("deviceId", TbadkCoreApplication.getInst().getImei());
                jSONObject.put("network", d());
                jSONObject.put(HttpConstants.HTTP_OS_TYPE_OLD, "AND");
                jSONObject.put("osVer", xi.k());
                if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                    jSONObject.put("uid", TbadkCoreApplication.getCurrentAccount());
                } else {
                    jSONObject.put("uid", "");
                }
                jSONObject.put("cuid", TbadkCoreApplication.getInst().getCuid());
                if (UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                    jSONObject.put("location", new StringBuilder().toString());
                }
                jSONObject.put("brand", Build.BRAND);
                jSONObject.put("model", xi.g());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) {
            switch (i) {
                case 101:
                    return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10d9);
                case 102:
                    return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10d8);
                case 103:
                    return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10d5);
                case 104:
                    return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10d4);
                case 105:
                    return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10da);
                case 106:
                    return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10d6);
                case 107:
                    return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f10d7);
                default:
                    return TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f068c) + i;
            }
        }
        return (String) invokeI.objValue;
    }
}

package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.p0.r3.e;
import c.a.p0.y1.k;
import c.a.p0.y1.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class VideoPlatformStatic {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static CustomMessageListener f48852a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                e.h().o();
                c.a.p0.r3.b.d().k();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements CustomMessageTask.CustomRunnable<k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<k> run(CustomMessage<k> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2921309, new l()) : (CustomResponsedMessage) invokeL.objValue;
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
        f48852a = new a(2007015);
        f();
        MessageManager.getInstance().registerListener(f48852a);
        e();
    }

    public VideoPlatformStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? TextUtils.equals(str, "1") ? "index" : TextUtils.equals(str, "2") ? "frs" : TextUtils.equals(str, "6") ? "pb" : TextUtils.equals(str, "12") ? "frs_bavideotab" : TextUtils.equals(str, "3") ? "floor5" : TextUtils.equals(str, "10") ? "floor10" : TextUtils.equals(str, "11") ? "floor15" : TextUtils.equals(str, "13") ? "auto_midpage" : str : (String) invokeL.objValue;
    }

    public static int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if (i2 != -400) {
                if (i2 != -200) {
                    return i2 != -100 ? 3 : 2;
                }
                return 1;
            }
            return 4;
        }
        return invokeI.intValue;
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
                jSONObject.put("deviceId", UtilHelper.getDeviceId());
                jSONObject.put("network", d());
                jSONObject.put(HttpConstants.HTTP_OS_TYPE_OLD, "AND");
                jSONObject.put("osVer", Build.VERSION.RELEASE);
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
                jSONObject.put("model", Build.MODEL);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? j.H() ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : j.t() ? "2G" : j.u() ? "3G" : (j.v() || j.z()) ? "4G" : "NONE" : (String) invokeV.objValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_MOOV_UPLOAD, TbConfig.SERVER_ADDRESS + TbConfig.URL_MOOV_REPORT);
            tbHttpMessageTask.setResponsedClass(TbHttpResponsedMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            messageManager.registerTask(tbHttpMessageTask);
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

    public static String g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i2)) == null) {
            switch (i2) {
                case 101:
                    return TbadkCoreApplication.getInst().getString(R.string.post_error_compress_success);
                case 102:
                    return TbadkCoreApplication.getInst().getString(R.string.post_error_compress_not_do);
                case 103:
                    return TbadkCoreApplication.getInst().getString(R.string.post_error_compress_failed);
                case 104:
                    return TbadkCoreApplication.getInst().getString(R.string.post_error_compress_abort);
                case 105:
                    return TbadkCoreApplication.getInst().getString(R.string.post_error_compress_too_slow);
                case 106:
                    return TbadkCoreApplication.getInst().getString(R.string.post_error_compress_file_not_exists);
                case 107:
                    return TbadkCoreApplication.getInst().getString(R.string.post_error_compress_filename_not_exists);
                default:
                    return TbadkCoreApplication.getInst().getString(R.string.error_not_record) + i2;
            }
        }
        return (String) invokeI.objValue;
    }
}

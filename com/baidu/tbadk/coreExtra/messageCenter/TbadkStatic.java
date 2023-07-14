package com.baidu.tbadk.coreExtra.messageCenter;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SimpleVideoPlayActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.httpNet.ComplianceParmasHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.kw9;
import com.baidu.tieba.lw9;
import com.baidu.tieba.mf5;
import com.baidu.tieba.play.SimpleVideoPlayActivity;
import com.baidu.tieba.qf5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class TbadkStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<mf5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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
        public CustomResponsedMessage<mf5> run(CustomMessage<mf5> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                return new CustomResponsedMessage<>(2156675, new qf5());
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements CustomMessageTask.CustomRunnable {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    String obj = customMessage.getData().toString();
                    if ("isKeepOriginalLogic".equals(obj)) {
                        z = lw9.b();
                    } else if (ComplianceParmasHelper.isNeedChange(obj)) {
                        z = true;
                    }
                    return new CustomResponsedMessage<>(2000985, Boolean.valueOf(z));
                }
                z = false;
                return new CustomResponsedMessage<>(2000985, Boolean.valueOf(z));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements CustomMessageTask.CustomRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    String obj = customMessage.getData().toString();
                    if ("isKeepOriginalLogic".equals(obj)) {
                        z = kw9.b();
                    } else if (ComplianceParmasHelper.isNeedChange(obj)) {
                        z = true;
                    }
                    return new CustomResponsedMessage<>(2000983, Boolean.valueOf(z));
                }
                z = false;
                return new CustomResponsedMessage<>(2000983, Boolean.valueOf(z));
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements CustomMessageTask.CustomRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
            InterceptResult invokeL;
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof HashMap) && (hashMap = (HashMap) customMessage.getData()) != null) {
                    if (hashMap.containsKey("isKeepOriginalLogic")) {
                        hashMap.remove("isKeepOriginalLogic");
                        hashMap.put(ComplianceParmasHelper.getRenameKey(HttpRequest.ANDROID_ID), ComplianceParmasHelper.getBase64Value(TbadkCoreApplication.getInst().getAndroidId()));
                        hashMap.put(ComplianceParmasHelper.getRenameKey(HttpRequest.PHONE_IMEI), ComplianceParmasHelper.getBase64Value(TbadkCoreApplication.getInst().getImei()));
                    } else {
                        hashMap.put(HttpRequest.NEED_DECRYPT, lw9.c());
                        String g = lw9.g(HttpRequest.ANDROID_ID);
                        if (!TextUtils.isEmpty(g)) {
                            hashMap.put(g, lw9.d());
                        }
                        String g2 = lw9.g(HttpRequest.PHONE_IMEI);
                        if (!TextUtils.isEmpty(g2)) {
                            hashMap.put(g2, lw9.f());
                        }
                        String g3 = lw9.g("oaid");
                        if (!TextUtils.isEmpty(g3)) {
                            hashMap.put(g3, lw9.i());
                        }
                        String g4 = lw9.g("model");
                        if (!TextUtils.isEmpty(g4)) {
                            hashMap.put(g4, lw9.h());
                        }
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements CustomMessageTask.CustomRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage customMessage) {
            InterceptResult invokeL;
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof HashMap) && (hashMap = (HashMap) customMessage.getData()) != null) {
                    if (hashMap.containsKey("isKeepOriginalLogic")) {
                        hashMap.remove("isKeepOriginalLogic");
                        hashMap.put(ComplianceParmasHelper.getRenameKey("mac"), ComplianceParmasHelper.getBase64Value(PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst())));
                    } else {
                        hashMap.put("need_cam_decrypt", kw9.c());
                        String d = kw9.d("mac");
                        if (!TextUtils.isEmpty(d)) {
                            hashMap.put(d, kw9.e());
                        }
                    }
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-979588377, "Lcom/baidu/tbadk/coreExtra/messageCenter/TbadkStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-979588377, "Lcom/baidu/tbadk/coreExtra/messageCenter/TbadkStatic;");
                return;
            }
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2156675, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2000985, new b());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2000983, new c());
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2000984, new d());
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
        CustomMessageTask customMessageTask5 = new CustomMessageTask(2000982, new e());
        customMessageTask5.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask5);
        TbadkCoreApplication.getInst().RegisterIntent(SimpleVideoPlayActivityConfig.class, SimpleVideoPlayActivity.class);
    }

    public TbadkStatic() {
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
}

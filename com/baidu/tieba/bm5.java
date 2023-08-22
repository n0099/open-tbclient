package com.baidu.tieba;

import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.tbadk.BdToken.BdTokenController;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.growth.ActivityChangeSchemeModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bm5 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947649791, "Lcom/baidu/tieba/bm5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947649791, "Lcom/baidu/tieba/bm5;");
        }
    }

    /* loaded from: classes5.dex */
    public static class a extends bx5<Boolean> {
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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.bx5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return Boolean.valueOf(BdTokenController.E().G());
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements gw5<Boolean> {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.gw5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bool) == null) && bool != null && !bool.booleanValue()) {
                bm5.c();
            }
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65539, null) != null) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        ActivityChangeSchemeModel activityChangeSchemeModel = new ActivityChangeSchemeModel();
        cm5.a();
        activityChangeSchemeModel.request();
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && !a) {
            if (TbadkCoreApplication.getInst().isMIUIRom()) {
                fx5.b(new a(), new b());
            } else if (!BdTokenController.E().G()) {
                c();
            }
        }
    }
}

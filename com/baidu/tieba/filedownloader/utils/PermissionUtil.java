package com.baidu.tieba.filedownloader.utils;

import android.app.Activity;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.filedownloader.utils.PermissionUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/tieba/filedownloader/utils/PermissionUtil;", "", "()V", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PermissionUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public static final Lazy<PermissionJudgePolicy> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        public final PermissionJudgePolicy a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (PermissionJudgePolicy) PermissionUtil.b.getValue();
            }
            return (PermissionJudgePolicy) invokeV.objValue;
        }

        public static final void c(Function0 result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, result) == null) {
                Intrinsics.checkNotNullParameter(result, "$result");
                result.invoke();
            }
        }

        @JvmStatic
        public final void b(final Function0<Unit> result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                a().setOnPermissionsGrantedListener(new PermissionJudgePolicy.OnPermissionsGrantedListener() { // from class: com.baidu.tieba.yd7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.OnPermissionsGrantedListener
                    public final void onPermissionsGranted() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            PermissionUtil.a.c(Function0.this);
                        }
                    }
                });
                Activity curGlobalActivity = TbadkCoreApplication.getInst().getCurGlobalActivity();
                if (curGlobalActivity == null) {
                    curGlobalActivity = BdActivityStack.getInst().currentActivity();
                }
                if (curGlobalActivity != null) {
                    PermissionUtil.a.a().clearRequestPermissionList();
                    PermissionUtil.a.a().appendRequestPermission(curGlobalActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                    PermissionUtil.a.a().startRequestPermission(curGlobalActivity);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(495066972, "Lcom/baidu/tieba/filedownloader/utils/PermissionUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(495066972, "Lcom/baidu/tieba/filedownloader/utils/PermissionUtil;");
                return;
            }
        }
        a = new a(null);
        b = LazyKt__LazyJVMKt.lazy(PermissionUtil$Companion$mPermissionJudgePolicy$2.INSTANCE);
    }
}

package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class cu implements fs {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> a;
    public final gp b;

    public cu(gp gpVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gpVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = gpVar;
    }

    @Override // com.baidu.tieba.fs
    public void b(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) && !et.a(activity)) {
            this.a = new WeakReference<>(activity);
        }
    }

    @Override // com.baidu.tieba.fs
    public Activity a() {
        InterceptResult invokeV;
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WeakReference<Activity> weakReference = this.a;
            if (weakReference == null) {
                return null;
            }
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            if (et.a(activity)) {
                return null;
            }
            return activity;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fs
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b.t();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fs
    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Context context = this.b.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "bdTaskConfig.context");
            return context;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fs
    public String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String k = this.b.k();
            Intrinsics.checkExpressionValueIsNotNull(k, "bdTaskConfig.appVersion");
            return k;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fs
    public gs getEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            gs r = this.b.r();
            Intrinsics.checkExpressionValueIsNotNull(r, "bdTaskConfig.taskEnv");
            return r;
        }
        return (gs) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fs
    public String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            String q = this.b.q();
            Intrinsics.checkExpressionValueIsNotNull(q, "bdTaskConfig.sdkVersion");
            return q;
        }
        return (String) invokeV.objValue;
    }
}

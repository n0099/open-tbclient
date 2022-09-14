package com.baidu.tieba;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.thread.task.ElasticTask;
import com.baidu.searchbox.elasticthread.queue.QueueManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g11 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f11[] a;

    public g11() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new f11[4];
        if (u01.s.length != 4) {
            Log.e(QueueManager.TAG, "Elastic Queue size incompatible!");
        }
        for (int i3 = 0; i3 < 4; i3++) {
            this.a[i3] = new f11();
        }
    }

    public double a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c(0).d()) {
                double d = 0.0d;
                for (int i = 0; i < 4; i++) {
                    d += this.a[i].a() * u01.s[i];
                }
                return d / 1000.0d;
            }
            return 9999999.0d;
        }
        return invokeV.doubleValue;
    }

    public ElasticTask b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            for (int i = 0; i < 4; i++) {
                if (!this.a[i].d()) {
                    return this.a[i].b();
                }
            }
            return null;
        }
        return (ElasticTask) invokeV.objValue;
    }

    public f11 c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) != null) {
            return (f11) invokeI.objValue;
        }
        int i2 = 0;
        while (true) {
            int[] iArr = u01.a;
            if (i2 < iArr.length) {
                if (iArr[i2] == i) {
                    return this.a[i2];
                }
                i2++;
            } else {
                f11[] f11VarArr = this.a;
                return f11VarArr[f11VarArr.length - 1];
            }
        }
    }

    public void d(Runnable runnable, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, runnable, str, i) == null) {
            c(i).c(runnable, str, i);
        }
    }

    public void e(ElasticTask elasticTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, elasticTask) == null) {
            c(elasticTask.b()).e(elasticTask);
        }
    }
}

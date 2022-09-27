package com.baidu.tieba;

import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ei0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] a;
    public final int[] b;
    public int c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;

    public ei0() {
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
        this.a = new int[]{0, 0};
        this.b = new int[]{0, 0};
        this.c = 0;
        this.h = 0L;
    }

    public void a(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, motionEvent) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                long currentTimeMillis = System.currentTimeMillis();
                this.d = currentTimeMillis;
                if (this.h == 0) {
                    this.h = currentTimeMillis;
                }
                this.a[0] = (int) motionEvent.getRawX();
                this.a[1] = (int) motionEvent.getRawY();
            } else if (action != 1) {
                if (action != 2) {
                    return;
                }
                this.c++;
            } else {
                this.c = 0;
                this.e = System.currentTimeMillis();
                this.b[0] = (int) motionEvent.getRawX();
                this.b[1] = (int) motionEvent.getRawY();
                if (Math.max(Math.abs(this.b[0] - this.a[0]), Math.abs(this.b[1] - this.a[1])) > 10) {
                    this.g++;
                    this.f += Math.max(0L, this.e - this.d);
                }
            }
        }
    }

    public int[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int[] iArr = this.b;
            return new int[]{iArr[0], iArr[1]};
        }
        return (int[]) invokeV.objValue;
    }
}

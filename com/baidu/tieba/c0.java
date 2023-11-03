package com.baidu.tieba;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class c0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Uri a;
    public String b;
    public String c;
    public Bundle d;
    public String e;
    public String[] f;
    public ContentValues g;
    public CancellationSignal h;
    public b0 i;
    public long j;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Uri a;
        public String b;
        public String c;
        public Bundle d;
        public String e;
        public String[] f;
        public ContentValues g;
        public CancellationSignal h;
        public b0 i;
        public long j;

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

        public c0 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c0 c0Var = new c0();
                a(c0Var);
                return c0Var;
            }
            return (c0) invokeV.objValue;
        }

        public final void a(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, c0Var) == null) {
                c0Var.a = this.a;
                c0Var.b = this.b;
                c0Var.c = this.c;
                c0Var.d = this.d;
                c0Var.e = this.e;
                c0Var.f = this.f;
                c0Var.g = this.g;
                c0Var.h = this.h;
                c0Var.i = this.i;
                c0Var.j = this.j;
            }
        }

        public a c(CancellationSignal cancellationSignal) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cancellationSignal)) == null) {
                this.h = cancellationSignal;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(b0 b0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, b0Var)) == null) {
                this.i = b0Var;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, strArr)) == null) {
                this.f = strArr;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048582, this, j)) == null) {
                this.j = j;
                return this;
            }
            return (a) invokeJ.objValue;
        }

        public a h(Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, uri)) == null) {
                this.a = uri;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a i(ContentValues contentValues) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, contentValues)) == null) {
                this.g = contentValues;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
                this.e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public c0() {
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

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "RequestInfo{uri=" + this.a + ", fileOpenMode='" + this.b + "', mimeType='" + this.c + "', opts=" + this.d + ", where='" + this.e + "', selectionArgs=" + Arrays.toString(this.f) + ", values=" + this.g + ", cancellationSignal=" + this.h + ", requestCallback=" + this.i + ", timeStamp=" + this.j + '}';
        }
        return (String) invokeV.objValue;
    }
}

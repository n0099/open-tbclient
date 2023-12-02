package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
/* loaded from: classes6.dex */
public class ge0<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public T a;

    public ge0(T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = t;
    }

    public boolean d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            if (!(this.a instanceof File) || System.currentTimeMillis() - ((File) this.a).lastModified() <= j) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    public T a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (T) invokeV.objValue;
    }

    public Class<?> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a.getClass();
        }
        return (Class) invokeV.objValue;
    }

    public byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            T t = this.a;
            if (t instanceof Bitmap) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ((Bitmap) this.a).compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } else if (t instanceof File) {
                return b21.g((File) t);
            } else {
                if (t instanceof byte[]) {
                    return (byte[]) t;
                }
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        boolean delete;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            T t = this.a;
            if (t instanceof Bitmap) {
                if (!((Bitmap) t).isRecycled()) {
                    ((Bitmap) this.a).recycle();
                }
            } else if (t instanceof File) {
                delete = ((File) t).delete();
                this.a = null;
                return delete;
            }
            delete = true;
            this.a = null;
            return delete;
        }
        return invokeV.booleanValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            T t = this.a;
            if (t instanceof Bitmap) {
                return ((Bitmap) t).getByteCount();
            }
            if (t instanceof File) {
                return (int) ((File) t).length();
            }
            if (t instanceof byte[]) {
                return ((byte[]) t).length;
            }
            return 1;
        }
        return invokeV.intValue;
    }
}

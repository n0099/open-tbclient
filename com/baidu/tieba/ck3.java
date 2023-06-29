package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
/* loaded from: classes5.dex */
public abstract class ck3 implements gk3 {
    public static /* synthetic */ Interceptable $ic;
    public static final ReadWriteLock c;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public final long b;

    @NonNull
    public abstract String c();

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947677598, "Lcom/baidu/tieba/ck3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947677598, "Lcom/baidu/tieba/ck3;");
                return;
            }
        }
        c = new ReentrantReadWriteLock();
    }

    public ck3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = d();
        this.b = getMaxSize();
    }

    @Override // com.baidu.tieba.gk3
    public boolean a(long j) {
        InterceptResult invokeJ;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            c.readLock().lock();
            try {
                if (e() + j > this.b) {
                    z = true;
                } else {
                    z = false;
                }
                return z;
            } finally {
                c.readLock().unlock();
            }
        }
        return invokeJ.booleanValue;
    }

    @Override // com.baidu.tieba.gk3
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            c.writeLock().lock();
            try {
                try {
                    if (this.a == null) {
                        this.a = d();
                    }
                    File file = this.a;
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    gs4.O(String.valueOf(e() + j).getBytes(), file);
                } catch (Exception e) {
                    if (ms1.a) {
                        e.printStackTrace();
                    }
                }
            } finally {
                c.writeLock().unlock();
            }
        }
    }

    public final File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new File(c() + File.separator + "record.pro");
        }
        return (File) invokeV.objValue;
    }

    public final long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.a == null) {
                this.a = d();
            }
            File file = this.a;
            if (file.exists() && file.isFile()) {
                String E = gs4.E(file);
                try {
                    if (!TextUtils.isEmpty(E) && TextUtils.isDigitsOnly(E.trim())) {
                        return Long.parseLong(E.trim());
                    }
                } catch (Exception e) {
                    if (ms1.a) {
                        e.printStackTrace();
                    }
                }
            }
            return 0L;
        }
        return invokeV.longValue;
    }
}

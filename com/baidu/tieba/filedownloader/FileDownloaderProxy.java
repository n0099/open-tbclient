package com.baidu.tieba.filedownloader;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.rk6;
import com.baidu.tieba.sk6;
import com.baidu.tieba.tk6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0001H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/tieba/filedownloader/FileDownloaderProxy;", "Lcom/baidu/tieba/filedownloader/interfaces/IFileDownloader;", "()V", "downloaderMap", "Landroid/util/SparseArray;", "cancel", "", "data", "Lcom/baidu/tbadk/download/DownloadData;", "getDownloader", "getProgress", "", "getStatus", "pause", "resume", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tieba/filedownloader/interfaces/IStatusCallback;", "start", "", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class FileDownloaderProxy implements sk6 {
    public static /* synthetic */ Interceptable $ic;
    public static final a b;
    public static final Lazy<FileDownloaderProxy> c;
    @JvmField
    public static final ThreadLocal<Integer> d;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<sk6> a;

    public /* synthetic */ FileDownloaderProxy(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* loaded from: classes4.dex */
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

        public final FileDownloaderProxy a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (FileDownloaderProxy) FileDownloaderProxy.c.getValue();
            }
            return (FileDownloaderProxy) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-585898514, "Lcom/baidu/tieba/filedownloader/FileDownloaderProxy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-585898514, "Lcom/baidu/tieba/filedownloader/FileDownloaderProxy;");
                return;
            }
        }
        b = new a(null);
        c = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) FileDownloaderProxy$Companion$sInstance$2.INSTANCE);
        d = new ThreadLocal<>();
    }

    public final sk6 g() {
        InterceptResult invokeV;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Integer num = d.get();
            if (num == null) {
                intValue = 1;
            } else {
                intValue = num.intValue();
            }
            d.remove();
            sk6 sk6Var = this.a.get(intValue);
            if (sk6Var == null) {
                sk6 a2 = rk6.a.a(intValue);
                this.a.put(intValue, a2);
                return a2;
            }
            return sk6Var;
        }
        return (sk6) invokeV.objValue;
    }

    public FileDownloaderProxy() {
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
        this.a = new SparseArray<>();
    }

    @Override // com.baidu.tieba.sk6
    public boolean a(DownloadData data, tk6 callback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, data, callback)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(callback, "callback");
            return g().a(data, callback);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.sk6
    public void b(DownloadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            g().b(data);
        }
    }

    @Override // com.baidu.tieba.sk6
    public int c(DownloadData data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            return g().c(data);
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.sk6
    public void d(DownloadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            g().d(data);
        }
    }

    @Override // com.baidu.tieba.sk6
    public int e(DownloadData data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            return g().e(data);
        }
        return invokeL.intValue;
    }
}

package com.baidu.tieba.filedownloader;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.nia;
import com.baidu.tieba.oe7;
import com.baidu.tieba.pe7;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/filedownloader/TbFileDownloaderImpl;", "Lcom/baidu/tieba/filedownloader/interfaces/IFileDownloader;", "()V", "addGlobalCallback", "", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tieba/filedownloader/interfaces/IStatusCallback;", "cancel", "data", "Lcom/baidu/tbadk/download/DownloadData;", "getFilePath", "", "getProgress", "", "getStatus", DownloadStatisticConstants.UBC_TYPE_PAUSE, "removeGlobalCallback", DownloadStatisticConstants.UBC_TYPE_RESUME, "start", "", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TbFileDownloaderImpl implements oe7 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public static final Lazy<TbFileDownloaderImpl> b;
    public static final nia c;
    public transient /* synthetic */ FieldHolder $fh;

    public /* synthetic */ TbFileDownloaderImpl(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

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

        public final TbFileDownloaderImpl a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (TbFileDownloaderImpl) TbFileDownloaderImpl.b.getValue();
            }
            return (TbFileDownloaderImpl) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-475704756, "Lcom/baidu/tieba/filedownloader/TbFileDownloaderImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-475704756, "Lcom/baidu/tieba/filedownloader/TbFileDownloaderImpl;");
                return;
            }
        }
        a = new a(null);
        b = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) TbFileDownloaderImpl$Companion$sInstance$2.INSTANCE);
        nia o = nia.o();
        Intrinsics.checkNotNullExpressionValue(o, "getInstance()");
        c = o;
    }

    public TbFileDownloaderImpl() {
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

    @Override // com.baidu.tieba.oe7
    public void a(pe7 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            c.h(callback);
        }
    }

    @Override // com.baidu.tieba.oe7
    public void d(DownloadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            c.k(data);
        }
    }

    @Override // com.baidu.tieba.oe7
    public int e(DownloadData data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            return nia.q(data);
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.oe7
    public void f(DownloadData data) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            nia niaVar = c;
            String url = data.getUrl();
            String id = data.getId();
            ItemData itemData = data.getItemData();
            if (itemData != null) {
                str = itemData.pkgName;
            } else {
                str = null;
            }
            niaVar.i(url, id, str);
        }
    }

    @Override // com.baidu.tieba.oe7
    public int g(DownloadData data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            return c.l(data.getId(), data.getName());
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.oe7
    public void i(pe7 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            c.w(callback);
        }
    }

    @Override // com.baidu.tieba.oe7
    public void b(DownloadData data, pe7 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data, callback) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(callback, "callback");
            c.y(data, callback);
        }
    }

    @Override // com.baidu.tieba.oe7
    public boolean c(DownloadData data, pe7 callback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, data, callback)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(callback, "callback");
            return c.y(data, callback);
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.oe7
    public String h(DownloadData data) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            String id = data.getId();
            if (id != null && !StringsKt__StringsJVMKt.isBlank(id)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                String id2 = data.getId();
                Intrinsics.checkNotNullExpressionValue(id2, "data.id");
                sb.append(StringsKt__StringsJVMKt.replace$default(id2, ".", "_", false, 4, (Object) null));
                sb.append(Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                String m = nia.m(sb.toString());
                Intrinsics.checkNotNullExpressionValue(m, "getFilePath(fileName)");
                return m;
            }
            return "";
        }
        return (String) invokeL.objValue;
    }
}

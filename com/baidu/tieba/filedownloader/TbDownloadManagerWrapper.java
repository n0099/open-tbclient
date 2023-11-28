package com.baidu.tieba.filedownloader;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.ke7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\bR'\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/baidu/tieba/filedownloader/TbDownloadManagerWrapper;", "", "downloaderType", "", "(I)V", "mCallbackMap", "", "", "Lcom/baidu/tieba/filedownloader/interfaces/IStatusCallback;", "getMCallbackMap", "()Ljava/util/Map;", "mCallbackMap$delegate", "Lkotlin/Lazy;", "mDownloadManager", "Lcom/baidu/tieba/filedownloader/TbDownloadManager;", "getMDownloadManager", "()Lcom/baidu/tieba/filedownloader/TbDownloadManager;", "mDownloadManager$delegate", "cancel", "", "downloadData", "Lcom/baidu/tbadk/download/DownloadData;", "checkAndFillData", "getProgress", "getStatus", DownloadStatisticConstants.UBC_TYPE_PAUSE, DownloadStatisticConstants.UBC_TYPE_RESUME, WebChromeClient.KEY_ARG_CALLBACK, "start", "", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class TbDownloadManagerWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;

    public abstract void c(DownloadData downloadData);

    /* loaded from: classes5.dex */
    public static final class a implements ke7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbDownloadManagerWrapper a;

        public a(TbDownloadManagerWrapper tbDownloadManagerWrapper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbDownloadManagerWrapper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbDownloadManagerWrapper;
        }

        @Override // com.baidu.tieba.ke7
        public void a(DownloadData data) {
            boolean z;
            ke7 ke7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                String id = data.getId();
                if (id != null && !StringsKt__StringsJVMKt.isBlank(id)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z && (ke7Var = (ke7) this.a.d().get(data.getId())) != null) {
                    ke7Var.a(data);
                }
            }
        }

        @Override // com.baidu.tieba.ke7
        public void b(DownloadData data) {
            boolean z;
            ke7 ke7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                String id = data.getId();
                if (id != null && !StringsKt__StringsJVMKt.isBlank(id)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z && (ke7Var = (ke7) this.a.d().get(data.getId())) != null) {
                    ke7Var.b(data);
                }
            }
        }

        @Override // com.baidu.tieba.ke7
        public void c(DownloadData data) {
            boolean z;
            ke7 ke7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                String id = data.getId();
                if (id != null && !StringsKt__StringsJVMKt.isBlank(id)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z && (ke7Var = (ke7) this.a.d().get(data.getId())) != null) {
                    ke7Var.c(data);
                }
            }
        }

        @Override // com.baidu.tieba.ke7
        public void d(DownloadData data) {
            boolean z;
            ke7 ke7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                String id = data.getId();
                if (id != null && !StringsKt__StringsJVMKt.isBlank(id)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z && (ke7Var = (ke7) this.a.d().get(data.getId())) != null) {
                    ke7Var.d(data);
                }
            }
        }

        @Override // com.baidu.tieba.ke7
        public void e(DownloadData data) {
            boolean z;
            ke7 ke7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                String id = data.getId();
                if (id != null && !StringsKt__StringsJVMKt.isBlank(id)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z && (ke7Var = (ke7) this.a.d().get(data.getId())) != null) {
                    ke7Var.e(data);
                }
            }
        }

        @Override // com.baidu.tieba.ke7
        public void f(DownloadData data, int i) {
            boolean z;
            ke7 ke7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, data, i) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                String id = data.getId();
                if (id != null && !StringsKt__StringsJVMKt.isBlank(id)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z && (ke7Var = (ke7) this.a.d().get(data.getId())) != null) {
                    ke7Var.f(data, i);
                }
            }
        }
    }

    public TbDownloadManagerWrapper(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = LazyKt__LazyJVMKt.lazy(TbDownloadManagerWrapper$mDownloadManager$2.INSTANCE);
        this.b = LazyKt__LazyJVMKt.lazy(TbDownloadManagerWrapper$mCallbackMap$2.INSTANCE);
        e().w(i);
        e().g(new a(this));
    }

    public final void b(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadData) == null) {
            Intrinsics.checkNotNullParameter(downloadData, "downloadData");
            c(downloadData);
            e().h(downloadData);
        }
    }

    public final void f(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) {
            Intrinsics.checkNotNullParameter(downloadData, "downloadData");
            c(downloadData);
            e().s(downloadData);
        }
    }

    public final Map<String, ke7> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (Map) this.b.getValue();
        }
        return (Map) invokeV.objValue;
    }

    public final TbDownloadManager e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return (TbDownloadManager) this.a.getValue();
        }
        return (TbDownloadManager) invokeV.objValue;
    }

    public final boolean g(DownloadData downloadData, ke7 callback) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, downloadData, callback)) == null) {
            Intrinsics.checkNotNullParameter(downloadData, "downloadData");
            Intrinsics.checkNotNullParameter(callback, "callback");
            c(downloadData);
            String id = downloadData.getId();
            if (id != null && !StringsKt__StringsJVMKt.isBlank(id)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                d().remove(downloadData.getId());
                Map<String, ke7> d = d();
                String id2 = downloadData.getId();
                Intrinsics.checkNotNullExpressionValue(id2, "downloadData.id");
                d.put(id2, callback);
            }
            return e().y(downloadData);
        }
        return invokeLL.booleanValue;
    }
}

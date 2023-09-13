package com.baidu.tieba.filedownloader;

import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.flow.data.ApkDownloadInfoData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.R;
import com.baidu.tieba.bf7;
import com.baidu.tieba.by5;
import com.baidu.tieba.by6;
import com.baidu.tieba.df7;
import com.baidu.tieba.dz4;
import com.baidu.tieba.ef7;
import com.baidu.tieba.ff7;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.tieba.filedownloader.logs.DownloaderLog;
import com.baidu.tieba.filedownloader.utils.PermissionUtil;
import com.baidu.tieba.gf7;
import com.baidu.tieba.ii5;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.mi5;
import com.baidu.tieba.ok1;
import com.baidu.tieba.w75;
import com.baidu.tieba.xx5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u000245B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0010H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0010H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020$H\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010'\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010(\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010)\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010*\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010+\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u001cJ\u0010\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u000200H\u0002J\u000e\u00101\u001a\u0002002\u0006\u0010-\u001a\u00020\u001cJ\u000e\u00102\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u001cJ\u0010\u00103\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u00066"}, d2 = {"Lcom/baidu/tieba/filedownloader/TbDownloadManager;", "", "()V", "downloadMultiInfoDbManager", "Lcom/baidu/tieba/database/DownloadMultiInfoDbManager;", "getDownloadMultiInfoDbManager", "()Lcom/baidu/tieba/database/DownloadMultiInfoDbManager;", "downloadMultiInfoDbManager$delegate", "Lkotlin/Lazy;", "strategyConfig", "Lcom/baidu/tieba/filedownloader/strategy/StrategyConfig;", "getStrategyConfig", "()Lcom/baidu/tieba/filedownloader/strategy/StrategyConfig;", "setStrategyConfig", "(Lcom/baidu/tieba/filedownloader/strategy/StrategyConfig;)V", "value", "", "tbFileDownloaderType", "getTbFileDownloaderType", "()I", "setTbFileDownloaderType", "(I)V", "addGlobalCallback", "", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tieba/filedownloader/interfaces/IStatusCallback;", "cancel", "data", "Lcom/baidu/tbadk/download/DownloadData;", "cancelByDownloaderType", "type", "debugToast", "downloadOnStartCallback", "startDownloadType", "executeFinishedDownloadTask", "getDownloader", "Lcom/baidu/tieba/filedownloader/interfaces/IFileDownloader;", "getFilePath", "", "getProgress", "getStatus", DownloadStatisticConstants.UBC_TYPE_PAUSE, "recordDownloadData", "removeGlobalCallback", DownloadStatisticConstants.UBC_TYPE_RESUME, "downloadData", "showStartDownloadToast", "isDownloadResume", "", "start", "startWithPermission", "updateBackAlertCache", "Companion", "DownloadStatusCallback", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TbDownloadManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final Lazy b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(370485908, "Lcom/baidu/tieba/filedownloader/TbDownloadManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(370485908, "Lcom/baidu/tieba/filedownloader/TbDownloadManager;");
        }
    }

    /* loaded from: classes5.dex */
    public final class a implements gf7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbDownloadManager a;

        @Override // com.baidu.tieba.gf7
        public void e(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(TbDownloadManager tbDownloadManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbDownloadManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbDownloadManager;
        }

        @Override // com.baidu.tieba.gf7
        public void a(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                TbLog downloaderLog = DownloaderLog.getInstance();
                downloaderLog.i("TbDownloadManager", "下载器：函数 onFailed，下载器类型：" + this.a.r() + StringUtil.ARRAY_ELEMENT_SEPARATOR + data);
            }
        }

        @Override // com.baidu.tieba.gf7
        public void b(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                TbLog downloaderLog = DownloaderLog.getInstance();
                downloaderLog.i("TbDownloadManager", "下载器：函数 onComplete，下载器类型：" + this.a.r() + StringUtil.ARRAY_ELEMENT_SEPARATOR + data);
                this.a.l(data);
                dz4.b().a(TbadkCoreStatisticKey.FILE_DOWNLOAD_COMPLETION, String.valueOf(data.getSource()), data.getName(), data.getUrl(), this.a.r());
            }
        }

        @Override // com.baidu.tieba.gf7
        public void c(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                TbLog downloaderLog = DownloaderLog.getInstance();
                downloaderLog.i("TbDownloadManager", "下载器：函数 onPause，下载器类型：" + this.a.r() + StringUtil.ARRAY_ELEMENT_SEPARATOR + data);
                dz4.b().a(TbadkCoreStatisticKey.FILE_DOWNLOAD_PAUSE, String.valueOf(data.getSource()), data.getName(), data.getUrl(), this.a.r());
            }
        }

        @Override // com.baidu.tieba.gf7
        public void d(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                TbLog downloaderLog = DownloaderLog.getInstance();
                downloaderLog.i("TbDownloadManager", "下载器：函数 onCancel，下载器类型：" + this.a.r() + StringUtil.ARRAY_ELEMENT_SEPARATOR + data);
                dz4.b().a(TbadkCoreStatisticKey.FILE_DOWNLOAD_DELETE, String.valueOf(data.getSource()), data.getName(), data.getUrl(), this.a.r());
            }
        }

        @Override // com.baidu.tieba.gf7
        public void f(DownloadData data, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, data, i) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                TbLog downloaderLog = DownloaderLog.getInstance();
                downloaderLog.i("TbDownloadManager", "下载器：函数 onStart，下载器类型：" + this.a.r() + StringUtil.ARRAY_ELEMENT_SEPARATOR + data);
                this.a.t(data);
                this.a.k(data, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends xx5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbDownloadManager a;
        public final /* synthetic */ DownloadData b;

        public b(TbDownloadManager tbDownloadManager, DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbDownloadManager, downloadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbDownloadManager;
            this.b = downloadData;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int r = this.a.r();
                this.a.i(this.b, 1);
                this.a.i(this.b, 2);
                this.a.m().delete(this.b);
                this.a.w(r);
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.xx5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends BdAsyncTask<String, Integer, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;
        public final /* synthetic */ TbDownloadManager b;

        public c(DownloadData downloadData, TbDownloadManager tbDownloadManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadData, tbDownloadManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadData;
            this.b = tbDownloadManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Integer doInBackground(String... params) {
            InterceptResult invokeL;
            boolean z;
            ItemData itemData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, params)) == null) {
                Intrinsics.checkNotNullParameter(params, "params");
                String packNameFromFile = FileHelper.getPackNameFromFile(TbadkCoreApplication.getInst().getApplicationContext(), this.a.getPath());
                if (packNameFromFile != null && !StringsKt__StringsJVMKt.isBlank(packNameFromFile)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z && (itemData = this.a.getItemData()) != null) {
                    itemData.packageName = packNameFromFile;
                }
                int k = this.b.m().k(this.a);
                this.b.A(this.a);
                return Integer.valueOf(k);
            }
            return (Integer) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends BdAsyncTask<String, Integer, Long> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;
        public final /* synthetic */ TbDownloadManager b;

        public d(DownloadData downloadData, TbDownloadManager tbDownloadManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadData, tbDownloadManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadData;
            this.b = tbDownloadManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Long doInBackground(String... params) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, params)) == null) {
                Intrinsics.checkNotNullParameter(params, "params");
                ItemData itemData = this.a.getItemData();
                if (itemData != null) {
                    itemData.mTbFileDownloaderType = this.b.r();
                }
                return Long.valueOf(this.b.m().i(this.a));
            }
            return (Long) invokeL.objValue;
        }
    }

    public TbDownloadManager() {
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
        this.a = ef7.a.a();
        this.b = LazyKt__LazyJVMKt.lazy(TbDownloadManager$downloadMultiInfoDbManager$2.INSTANCE);
    }

    public final void i(DownloadData downloadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, downloadData, i) == null) {
            w(i);
            n().f(downloadData);
            n().d(downloadData);
            FileHelper.deleteFileOrDir(new File(n().h(downloadData)));
        }
    }

    public final void g(gf7 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            n().a(callback);
        }
    }

    public final void l(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, downloadData) == null) {
            c cVar = new c(downloadData, this);
            cVar.setPriority(3);
            cVar.execute(new String[0]);
        }
    }

    public final int p(DownloadData data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            return n().g(data);
        }
        return invokeL.intValue;
    }

    public final int q(DownloadData data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            return n().e(data);
        }
        return invokeL.intValue;
    }

    public final void t(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, downloadData) == null) {
            d dVar = new d(downloadData, this);
            dVar.setPriority(3);
            dVar.execute(new String[0]);
        }
    }

    public final void u(gf7 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            n().i(callback);
        }
    }

    public final void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.a = i;
        }
    }

    public final void A(DownloadData downloadData) {
        ii5 ii5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadData) == null) {
            ok1<ii5> a2 = new mi5().a();
            if (a2 != null) {
                ii5Var = a2.get();
            } else {
                ii5Var = null;
            }
            if (ii5Var == null) {
                return;
            }
            by6 m = m();
            String id = downloadData.getId();
            Intrinsics.checkNotNullExpressionValue(id, "data.id");
            ApkDownloadInfoData b2 = w75.a.b(m.h(id, ""));
            if (b2 == null) {
                return;
            }
            ii5Var.b(b2);
        }
    }

    public final void h(DownloadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            TbLog downloaderLog = DownloaderLog.getInstance();
            downloaderLog.i("TbDownloadManager", "下载器：函数 cancel，下载器类型：" + this.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + data);
            by5.b(new b(this, data), null);
        }
    }

    public final String o(DownloadData data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            TbLog downloaderLog = DownloaderLog.getInstance();
            downloaderLog.i("TbDownloadManager", "下载器：函数 getFilePath，下载器类型：" + this.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + data);
            return n().h(data);
        }
        return (String) invokeL.objValue;
    }

    public final void s(DownloadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            TbLog downloaderLog = DownloaderLog.getInstance();
            downloaderLog.i("TbDownloadManager", "下载器：函数 pause，下载器类型：" + this.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + data);
            n().f(data);
        }
    }

    public final void v(final DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, downloadData) == null) {
            Intrinsics.checkNotNullParameter(downloadData, "downloadData");
            TbLog downloaderLog = DownloaderLog.getInstance();
            downloaderLog.i("TbDownloadManager", "下载器：函数 resume，下载器类型：" + this.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + downloadData);
            j();
            PermissionUtil.a.b(new Function0<Unit>(this, downloadData) { // from class: com.baidu.tieba.filedownloader.TbDownloadManager$resume$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ DownloadData $downloadData;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TbDownloadManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, downloadData};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$downloadData = downloadData;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ff7 n;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    n = this.this$0.n();
                    n.b(this.$downloadData, new TbDownloadManager.a(this.this$0));
                }
            });
        }
    }

    public final void x(boolean z) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                string = TbadkCoreApplication.getInst().getString(R.string.resume_download_toast_content);
            } else {
                string = TbadkCoreApplication.getInst().getString(R.string.start_download_toast_content);
            }
            Intrinsics.checkNotNullExpressionValue(string, "if (isDownloadResume) {\n…_toast_content)\n        }");
            df7 df7Var = new df7();
            df7Var.c(string);
            df7Var.a();
        }
    }

    public final void z(final DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, downloadData) == null) {
            Intrinsics.checkNotNullParameter(downloadData, "downloadData");
            TbLog downloaderLog = DownloaderLog.getInstance();
            downloaderLog.i("TbDownloadManager", "下载器：函数 startWithPermission，下载器类型：" + this.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + downloadData);
            j();
            PermissionUtil.a.b(new Function0<Unit>(this, downloadData) { // from class: com.baidu.tieba.filedownloader.TbDownloadManager$startWithPermission$1
                public static /* synthetic */ Interceptable $ic;
                public final /* synthetic */ DownloadData $downloadData;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TbDownloadManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, downloadData};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.$downloadData = downloadData;
                }

                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ff7 n;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    n = this.this$0.n();
                    n.c(this.$downloadData, new TbDownloadManager.a(this.this$0));
                }
            });
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (TbadkCoreApplication.getInst().isDebugMode() || GlobalBuildConfig.isTiebaDebugTool()) {
                int i = this.a;
                if (i == 1) {
                    Toast.makeText(TbadkCoreApplication.getInst().getApplicationContext(), "贴吧下载器", 0).show();
                } else if (i == 2) {
                    Toast.makeText(TbadkCoreApplication.getInst().getApplicationContext(), "手百下载器", 0).show();
                } else {
                    Toast.makeText(TbadkCoreApplication.getInst().getApplicationContext(), "默认下载器", 0).show();
                }
            }
        }
    }

    public final void k(DownloadData downloadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, downloadData, i) == null) {
            boolean z = false;
            if (this.a != 1 ? i != 1 : n().e(downloadData) == 7) {
                z = true;
            }
            dz4.b().c(z, downloadData, this.a);
            x(z);
            bf7.d(downloadData);
        }
    }

    public final by6 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (by6) this.b.getValue();
        }
        return (by6) invokeV.objValue;
    }

    public final ff7 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return FileDownloaderProxy.b.a(this.a);
        }
        return (ff7) invokeV.objValue;
    }

    public final int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public final boolean y(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, downloadData)) == null) {
            Intrinsics.checkNotNullParameter(downloadData, "downloadData");
            TbLog downloaderLog = DownloaderLog.getInstance();
            downloaderLog.i("TbDownloadManager", "下载器：函数 start，下载器类型：" + this.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + downloadData);
            j();
            return n().c(downloadData, new a(this));
        }
        return invokeL.booleanValue;
    }
}

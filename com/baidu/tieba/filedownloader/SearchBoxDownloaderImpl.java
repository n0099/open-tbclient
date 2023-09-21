package com.baidu.tieba.filedownloader;

import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.model.StopStatus;
import com.baidu.searchbox.download.unified.DownloadInfoData;
import com.baidu.searchbox.download.unified.DownloadParams;
import com.baidu.searchbox.download.unified.DownloadUnifiedManager;
import com.baidu.searchbox.download.unified.EventCallback;
import com.baidu.searchbox.download.unified.EventControlInfoForResume;
import com.baidu.searchbox.download.unified.EventControlInfoForStart;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.cy5;
import com.baidu.tieba.filedownloader.logs.DownloaderLog;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pf7;
import com.baidu.tieba.qf7;
import com.baidu.tieba.sy6;
import com.baidu.tieba.ty6;
import com.baidu.tieba.util.AdApkInstallHelper;
import com.baidu.tieba.yx5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0003!\"#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/baidu/tieba/filedownloader/SearchBoxDownloaderImpl;", "Lcom/baidu/tieba/filedownloader/interfaces/IFileDownloader;", "()V", "mCallbackList", "", "Lcom/baidu/tieba/filedownloader/interfaces/IStatusCallback;", "addGlobalCallback", "", WebChromeClient.KEY_ARG_CALLBACK, "cancel", "data", "Lcom/baidu/tbadk/download/DownloadData;", "getConvertStatus", "", "originalStatus", "uri", "Landroid/net/Uri;", "getFilePath", "", "getProgress", "getStatus", "getUriById", "initDownloadParams", "Lcom/baidu/searchbox/download/unified/DownloadParams;", "download", "installApp", "path", "isSearchBoxContainTask", "", DownloadStatisticConstants.UBC_TYPE_PAUSE, "removeGlobalCallback", DownloadStatisticConstants.UBC_TYPE_RESUME, "start", "Companion", "DownloadEventCallback", "ListenerFacade", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchBoxDownloaderImpl implements pf7 {
    public static /* synthetic */ Interceptable $ic;
    public static final a b;
    public static final Lazy<SearchBoxDownloaderImpl> c;
    public static final sy6 d;
    public transient /* synthetic */ FieldHolder $fh;
    public List<qf7> a;

    public /* synthetic */ SearchBoxDownloaderImpl(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\u0011\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001a\u0010\u0015\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0010H\u0016J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/filedownloader/SearchBoxDownloaderImpl$ListenerFacade;", "Lcom/baidu/searchbox/download/callback/IDownloadListener;", "mData", "Lcom/baidu/tbadk/download/DownloadData;", "mCallback", "Lcom/baidu/tieba/filedownloader/interfaces/IStatusCallback;", "(Lcom/baidu/tieba/filedownloader/SearchBoxDownloaderImpl;Lcom/baidu/tbadk/download/DownloadData;Lcom/baidu/tieba/filedownloader/interfaces/IStatusCallback;)V", "getMCallback", "()Lcom/baidu/tieba/filedownloader/interfaces/IStatusCallback;", "setMCallback", "(Lcom/baidu/tieba/filedownloader/interfaces/IStatusCallback;)V", MissionEvent.MESSAGE_PAUSE, "", "uri", "Landroid/net/Uri;", "newProgress", "", "onProgress", CommonTbJsBridge.FILE_DOWNLOAD_CURRENT_SIZE, "", CommonTbJsBridge.FILE_DOWNLOAD_TOTAL_SIZE, "onProgressChanged", ZeusPerformanceTiming.KEY_BROWSER_STARTUP, "onStopped", "stopStatus", "Lcom/baidu/searchbox/download/model/StopStatus;", "onSuccess", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class ListenerFacade implements IDownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public qf7 mCallback;
        public final DownloadData mData;
        public final /* synthetic */ SearchBoxDownloaderImpl this$0;

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onProgressChanged(Uri uri, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, uri, i) == null) {
            }
        }

        public ListenerFacade(SearchBoxDownloaderImpl searchBoxDownloaderImpl, DownloadData mData, qf7 mCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchBoxDownloaderImpl, mData, mCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(mData, "mData");
            Intrinsics.checkNotNullParameter(mCallback, "mCallback");
            this.this$0 = searchBoxDownloaderImpl;
            this.mData = mData;
            this.mCallback = mCallback;
        }

        public final qf7 getMCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mCallback;
            }
            return (qf7) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onPause(Uri uri, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uri, i) == null) {
                this.mData.setStatus(4);
                this.mCallback.c(this.mData);
                for (qf7 qf7Var : this.this$0.a) {
                    qf7Var.c(this.mData);
                }
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onProgress(Uri uri, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{uri, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                this.mData.setLength(j);
                this.mData.setSize(j2);
                this.mCallback.e(this.mData);
                for (qf7 qf7Var : this.this$0.a) {
                    qf7Var.e(this.mData);
                }
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onStopped(StopStatus stopStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, stopStatus) == null) {
                TbLog downloaderLog = DownloaderLog.getInstance();
                downloaderLog.i("SearchBoxDownloaderImpl", "下载器：ListenerFacade, onStopped, stopStatus is: " + stopStatus + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.mData);
                this.mData.setStatus(2);
                this.mData.setStatusMsg((stopStatus == null || (r5 = stopStatus.name()) == null) ? "" : "");
                this.mCallback.a(this.mData);
                for (qf7 qf7Var : this.this$0.a) {
                    qf7Var.a(this.mData);
                }
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onSuccess(Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, uri) == null) {
                this.mData.setStatus(0);
                this.mCallback.b(this.mData);
                for (qf7 qf7Var : this.this$0.a) {
                    qf7Var.b(this.mData);
                }
                AdApkInstallHelper.a.c(this.this$0.h(this.mData), this.mData);
            }
        }

        public final void setMCallback(qf7 qf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, qf7Var) == null) {
                Intrinsics.checkNotNullParameter(qf7Var, "<set-?>");
                this.mCallback = qf7Var;
            }
        }
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

        public final sy6 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(1048576, this)) != null) {
                return (sy6) invokeV.objValue;
            }
            return SearchBoxDownloaderImpl.d;
        }

        public final SearchBoxDownloaderImpl b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (SearchBoxDownloaderImpl) SearchBoxDownloaderImpl.c.getValue();
            }
            return (SearchBoxDownloaderImpl) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public final class b implements EventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DownloadData a;
        public qf7 b;
        public final /* synthetic */ SearchBoxDownloaderImpl c;

        public b(SearchBoxDownloaderImpl searchBoxDownloaderImpl, DownloadData mData, qf7 mCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchBoxDownloaderImpl, mData, mCallback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(mData, "mData");
            Intrinsics.checkNotNullParameter(mCallback, "mCallback");
            this.c = searchBoxDownloaderImpl;
            this.a = mData;
            this.b = mCallback;
        }

        @Override // com.baidu.searchbox.download.unified.EventCallback
        public void callBack(int i, EventCallback.EventBackInfo eventBackInfo) {
            Integer num;
            Uri uri;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, eventBackInfo) == null) {
                TbLog downloaderLog = DownloaderLog.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append("下载器：DownloadEventCallback, callBack, type is: ");
                sb.append(i);
                sb.append(", info.detailInfoCode is: ");
                Uri uri2 = null;
                if (eventBackInfo != null) {
                    num = Integer.valueOf(eventBackInfo.detailInfoCode);
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(", info.uri is: ");
                if (eventBackInfo != null) {
                    uri2 = eventBackInfo.uri;
                }
                sb.append(uri2);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb.append(this.a);
                downloaderLog.i("SearchBoxDownloaderImpl", sb.toString());
                int i2 = 2;
                if (i != 1) {
                    if (i == 2) {
                        this.a.setStatus(2);
                        this.b.a(this.a);
                        for (qf7 qf7Var : this.c.a) {
                            qf7Var.a(this.a);
                        }
                        return;
                    }
                    return;
                }
                this.a.setStatus(1);
                if (eventBackInfo != null) {
                    i2 = 1;
                }
                this.b.f(this.a, i2);
                if (eventBackInfo != null && (uri = eventBackInfo.uri) != null) {
                    this.a.setUri(uri);
                }
                for (qf7 qf7Var2 : this.c.a) {
                    qf7Var2.f(this.a, i2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends yx5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchBoxDownloaderImpl a;
        public final /* synthetic */ DownloadData b;

        public c(SearchBoxDownloaderImpl searchBoxDownloaderImpl, DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchBoxDownloaderImpl, downloadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchBoxDownloaderImpl;
            this.b = downloadData;
        }

        public void a() {
            Uri q;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (q = this.a.q(this.b)) != null) {
                DownloadData downloadData = this.b;
                SearchBoxDownloaderImpl searchBoxDownloaderImpl = this.a;
                downloadData.setStatus(6);
                SearchBoxDownloaderImpl.b.a().a(q);
                for (qf7 qf7Var : searchBoxDownloaderImpl.a) {
                    qf7Var.d(downloadData);
                }
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yx5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends yx5<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchBoxDownloaderImpl a;
        public final /* synthetic */ DownloadData b;
        public final /* synthetic */ qf7 c;

        public d(SearchBoxDownloaderImpl searchBoxDownloaderImpl, DownloadData downloadData, qf7 qf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchBoxDownloaderImpl, downloadData, qf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchBoxDownloaderImpl;
            this.b = downloadData;
            this.c = qf7Var;
        }

        public void a() {
            Uri q;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ListenerFacade listenerFacade = new ListenerFacade(this.a, this.b, this.c);
                b bVar = new b(this.a, this.b, this.c);
                if (this.a.e(this.b) == 3 && (q = this.a.q(this.b)) != null) {
                    if (!new File(this.a.h(this.b)).exists()) {
                        SearchBoxDownloaderImpl.b.a().a(q);
                    } else {
                        listenerFacade.onSuccess(q);
                    }
                }
                if (this.a.s(this.b)) {
                    this.a.b(this.b, this.c);
                } else {
                    SearchBoxDownloaderImpl.b.a().f(TbadkCoreApplication.getInst(), String.valueOf(this.b.getSource()), this.a.r(this.b), listenerFacade, new EventControlInfoForStart(false, false, true), bVar);
                }
            }
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.yx5
        public /* bridge */ /* synthetic */ Unit doInBackground() {
            a();
            return Unit.INSTANCE;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-322818157, "Lcom/baidu/tieba/filedownloader/SearchBoxDownloaderImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-322818157, "Lcom/baidu/tieba/filedownloader/SearchBoxDownloaderImpl;");
                return;
            }
        }
        b = new a(null);
        c = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) SearchBoxDownloaderImpl$Companion$sInstance$2.INSTANCE);
        sy6 b2 = sy6.b();
        Intrinsics.checkNotNullExpressionValue(b2, "getInstance()");
        d = b2;
    }

    public SearchBoxDownloaderImpl() {
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
        this.a = new ArrayList();
    }

    @Override // com.baidu.tieba.pf7
    public void a(qf7 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.a.add(callback);
        }
    }

    @Override // com.baidu.tieba.pf7
    public void d(DownloadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            cy5.b(new c(this, data), null);
        }
    }

    @Override // com.baidu.tieba.pf7
    public int e(DownloadData data) {
        InterceptResult invokeL;
        DownloadInfoData d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Uri q = q(data);
            if (q == null || (d2 = d.d(q)) == null) {
                return 6;
            }
            return p(data, d2.getStatus(), q);
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.pf7
    public void f(DownloadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Uri q = q(data);
            if (q != null) {
                d.c(q);
            }
        }
    }

    @Override // com.baidu.tieba.pf7
    public String h(DownloadData data) {
        InterceptResult invokeL;
        DownloadInfoData d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Uri q = q(data);
            if (q == null || (d2 = d.d(q)) == null) {
                return "";
            }
            String filePath = d2.getFilePath();
            Intrinsics.checkNotNullExpressionValue(filePath, "it.filePath");
            return filePath;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pf7
    public void i(qf7 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.a.remove(callback);
        }
    }

    @Override // com.baidu.tieba.pf7
    public boolean c(DownloadData data, qf7 callback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, data, callback)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(callback, "callback");
            cy5.b(new d(this, data, callback), null);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.pf7
    public void b(DownloadData data, qf7 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data, callback) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(callback, "callback");
            EventControlInfoForResume eventControlInfoForResume = new EventControlInfoForResume(false, true);
            ListenerFacade listenerFacade = new ListenerFacade(this, data, callback);
            b bVar = new b(this, data, callback);
            Uri q = q(data);
            if (q != null) {
                d.e(TbadkCoreApplication.getInst(), String.valueOf(data.getSource()), q, listenerFacade, eventControlInfoForResume, bVar);
            }
        }
    }

    @Override // com.baidu.tieba.pf7
    public int g(DownloadData data) {
        InterceptResult invokeL;
        DownloadInfoData d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Uri q = q(data);
            if (q != null && (d2 = d.d(q)) != null) {
                long currentSize = d2.getCurrentSize();
                long totalSize = d2.getTotalSize();
                if (currentSize >= 0 && totalSize > 0) {
                    return (int) ((currentSize * 100) / totalSize);
                }
                return 0;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final Uri q(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, downloadData)) == null) {
            DownloadUnifiedManager downloadUnifiedManager = DownloadUnifiedManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(downloadUnifiedManager, "getInstance()");
            Context context = TbadkCoreApplication.getInst().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getInst().context");
            String id = downloadData.getId();
            Intrinsics.checkNotNullExpressionValue(id, "data.id");
            long a2 = ty6.a(downloadUnifiedManager, context, id);
            if (a2 > 0) {
                return ContentUris.withAppendedId(Downloads.Impl.CONTENT_URI, a2);
            }
            return null;
        }
        return (Uri) invokeL.objValue;
    }

    public final DownloadParams r(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, downloadData)) == null) {
            DownloadParams downloadParams = new DownloadParams();
            JSONObject jSONObject = new JSONObject();
            downloadData.getSource();
            downloadParams.setVisibleInNotification(1);
            downloadParams.setUrl(downloadData.getUrl());
            downloadParams.setExtraInfo(jSONObject.toString());
            if (StringUtils.isNotNull(downloadData.getId())) {
                downloadParams.setTitle(downloadData.getId());
            }
            return downloadParams;
        }
        return (DownloadParams) invokeL.objValue;
    }

    public final boolean s(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, downloadData)) == null) {
            DownloadUnifiedManager downloadUnifiedManager = DownloadUnifiedManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(downloadUnifiedManager, "getInstance()");
            Context context = TbadkCoreApplication.getInst().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getInst().context");
            String id = downloadData.getId();
            Intrinsics.checkNotNullExpressionValue(id, "data.id");
            if (ty6.a(downloadUnifiedManager, context, id) > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int p(DownloadData downloadData, int i, Uri uri) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048585, this, downloadData, i, uri)) == null) {
            boolean z = true;
            if (i != 1 && i != 2) {
                if (i != 4) {
                    if (i != 8) {
                        if (i != 16) {
                            return 6;
                        }
                        return 2;
                    }
                    String h = h(downloadData);
                    if (h.length() <= 0) {
                        z = false;
                    }
                    if (z && new File(h).exists()) {
                        return 3;
                    }
                    d.a(uri);
                    return 6;
                }
                return 7;
            }
            return 1;
        }
        return invokeLIL.intValue;
    }
}

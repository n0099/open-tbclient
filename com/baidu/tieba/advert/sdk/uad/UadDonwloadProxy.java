package com.baidu.tieba.advert.sdk.uad;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadAction;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.download.model.Downloads;
import com.baidu.searchbox.download.model.StopStatus;
import com.baidu.searchbox.download.unified.DownloadParams;
import com.baidu.searchbox.download.unified.EventCallback;
import com.baidu.searchbox.download.unified.EventControlInfoForResume;
import com.baidu.searchbox.download.unified.EventControlInfoForStart;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.tieba.ah0;
import com.baidu.tieba.bt6;
import com.baidu.tieba.eg0;
import com.baidu.tieba.fg0;
import com.baidu.tieba.mg0;
import com.baidu.tieba.pe0;
import com.baidu.tieba.qi0;
import com.baidu.tieba.rf0;
import com.baidu.tieba.s36;
import com.baidu.tieba.ux0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class UadDonwloadProxy implements IAdDownloader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void b(@NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eg0Var) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class ListenerFacade implements IDownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ah0 mListener;
        public eg0 model;
        public final /* synthetic */ UadDonwloadProxy this$0;

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onProgressChanged(Uri uri, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, uri, i) == null) {
            }
        }

        public ListenerFacade(UadDonwloadProxy uadDonwloadProxy, eg0 eg0Var, ah0 ah0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uadDonwloadProxy, eg0Var, ah0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = uadDonwloadProxy;
            this.model = eg0Var;
            this.mListener = ah0Var;
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onPause(Uri uri, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, uri, i) == null) {
                eg0 eg0Var = this.model;
                if (eg0Var.k != uri) {
                    return;
                }
                this.mListener.c(eg0Var.b, i);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onProgress(Uri uri, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{uri, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                eg0 eg0Var = this.model;
                if (eg0Var.k != uri || eg0Var.c == AdDownloadStatus.PAUSE) {
                    return;
                }
                if (j2 > 0) {
                    fg0 fg0Var = eg0Var.q;
                    if (fg0Var.e <= 0) {
                        fg0Var.e = j2;
                    }
                }
                this.mListener.a(this.model.b, j, j2);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onStopped(StopStatus stopStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, stopStatus) == null) {
                mg0 mg0Var = new mg0();
                mg0Var.b = stopStatus.name();
                if (stopStatus == StopStatus.DOWNLOAD_FAIL) {
                    mg0Var.c = true;
                }
                this.mListener.d(mg0Var);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onSuccess(Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, uri) == null) {
                eg0 eg0Var = this.model;
                if (eg0Var.k != uri) {
                    return;
                }
                eg0Var.h = s36.j(pe0.b(), this.model.k);
                this.mListener.onSuccess(this.model.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements EventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public eg0 a;
        public ah0 b;

        public a(UadDonwloadProxy uadDonwloadProxy, eg0 eg0Var, ah0 ah0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uadDonwloadProxy, eg0Var, ah0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eg0Var;
            this.b = ah0Var;
        }

        @Override // com.baidu.searchbox.download.unified.EventCallback
        public void callBack(int i, EventCallback.EventBackInfo eventBackInfo) {
            Uri uri;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, eventBackInfo) == null) {
                if (i != 1) {
                    if (i == 2) {
                        this.a.c = AdDownloadStatus.NONE;
                        rf0.c().g(AdDownloadAction.FAIL_PERMISSION_DENY, this.a);
                        return;
                    }
                    return;
                }
                if (eventBackInfo != null && (uri = eventBackInfo.uri) != null) {
                    this.a.k = uri;
                }
                if (eventBackInfo != null) {
                    eg0 eg0Var = this.a;
                    eg0Var.i = 0.0f;
                    eg0Var.j = 0.0f;
                    this.b.b(eg0Var.q.e, s36.j(pe0.b(), this.a.k));
                    return;
                }
                ah0 ah0Var = this.b;
                eg0 eg0Var2 = this.a;
                ah0Var.b(eg0Var2.q.e, eg0Var2.h);
            }
        }
    }

    public UadDonwloadProxy() {
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

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public int a(@NonNull eg0 eg0Var, @NonNull ah0 ah0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eg0Var, ah0Var)) == null) {
            if (TextUtils.isEmpty(eg0Var.g)) {
                mg0 mg0Var = new mg0();
                mg0Var.b = "download url is null";
                ah0Var.d(mg0Var);
                return -1;
            }
            bt6.b().f(pe0.b(), "ad", e(eg0Var), new ListenerFacade(this, eg0Var, ah0Var), new EventControlInfoForStart(false, false, true), new a(this, eg0Var, ah0Var));
            return eg0Var.g.hashCode();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(@NonNull eg0 eg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eg0Var) == null) {
            bt6.b().c(eg0Var.k);
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(@NonNull eg0 eg0Var, @NonNull ah0 ah0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, eg0Var, ah0Var) == null) {
            ListenerFacade listenerFacade = new ListenerFacade(this, eg0Var, ah0Var);
            a aVar = new a(this, eg0Var, ah0Var);
            bt6.b().e(pe0.b(), "ad", eg0Var.k, listenerFacade, new EventControlInfoForResume(false, true), aVar);
        }
    }

    public final DownloadParams e(@NonNull eg0 eg0Var) {
        InterceptResult invokeL;
        boolean z;
        int i;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eg0Var)) == null) {
            DownloadParams downloadParams = new DownloadParams();
            JSONObject jSONObject = new JSONObject();
            String str = eg0Var.q.c;
            if (TextUtils.isEmpty(str)) {
                str = "apk_yuansheng_unknown";
            }
            ux0.f(jSONObject, "source", str);
            if (!TextUtils.isEmpty(eg0Var.p.c)) {
                ux0.d(jSONObject, DownloadConstants.HIDE_INSTALL_COMPLETE, 1);
            }
            if (qi0.b().a().a("tb_uad_is_visible_notification", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            if (z) {
                if (!TextUtils.isEmpty(eg0Var.p.g)) {
                    ux0.f(jSONObject, "icon", eg0Var.p.g);
                }
                if (!TextUtils.isEmpty(eg0Var.p.i)) {
                    ux0.f(jSONObject, "versioncode", eg0Var.p.i);
                }
            }
            ux0.g(jSONObject, Downloads.Impl.COLUMN_EXTRA_INFO_CLOSE_AUTO_INSTALL, true);
            downloadParams.setVisibleInNotification(i);
            if (qi0.b().a().a("tb_uad_is_visible_in_download_center", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            downloadParams.setVisibleInDownloadsUI(z2);
            downloadParams.setUrl(eg0Var.g);
            downloadParams.setExtraInfo(jSONObject.toString());
            if (qi0.b().a().a("tb_uad_download_center_title_switch", 0) == 1 && !TextUtils.isEmpty(eg0Var.p.h)) {
                downloadParams.setTitle(eg0Var.p.h);
            }
            return downloadParams;
        }
        return (DownloadParams) invokeL.objValue;
    }
}

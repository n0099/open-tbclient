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
import com.baidu.tieba.eh0;
import com.baidu.tieba.gv6;
import com.baidu.tieba.hf0;
import com.baidu.tieba.ij0;
import com.baidu.tieba.jg0;
import com.baidu.tieba.oy0;
import com.baidu.tieba.sh0;
import com.baidu.tieba.wg0;
import com.baidu.tieba.xg0;
import com.baidu.tieba.z56;
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
    public void b(@NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wg0Var) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class ListenerFacade implements IDownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public sh0 mListener;
        public wg0 model;
        public final /* synthetic */ UadDonwloadProxy this$0;

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onProgressChanged(Uri uri, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, uri, i) == null) {
            }
        }

        public ListenerFacade(UadDonwloadProxy uadDonwloadProxy, wg0 wg0Var, sh0 sh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uadDonwloadProxy, wg0Var, sh0Var};
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
            this.model = wg0Var;
            this.mListener = sh0Var;
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onPause(Uri uri, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, uri, i) == null) {
                wg0 wg0Var = this.model;
                if (wg0Var.k != uri) {
                    return;
                }
                this.mListener.c(wg0Var.b, i);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onProgress(Uri uri, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{uri, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                wg0 wg0Var = this.model;
                if (wg0Var.k != uri || wg0Var.c == AdDownloadStatus.PAUSE) {
                    return;
                }
                if (j2 > 0) {
                    xg0 xg0Var = wg0Var.q;
                    if (xg0Var.e <= 0) {
                        xg0Var.e = j2;
                    }
                }
                this.mListener.a(this.model.b, j, j2);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onStopped(StopStatus stopStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, stopStatus) == null) {
                eh0 eh0Var = new eh0();
                eh0Var.b = stopStatus.name();
                if (stopStatus == StopStatus.DOWNLOAD_FAIL) {
                    eh0Var.c = true;
                }
                this.mListener.d(eh0Var);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onSuccess(Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, uri) == null) {
                wg0 wg0Var = this.model;
                if (wg0Var.k != uri) {
                    return;
                }
                wg0Var.h = z56.j(hf0.b(), this.model.k);
                this.mListener.onSuccess(this.model.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements EventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public wg0 a;
        public sh0 b;

        public a(UadDonwloadProxy uadDonwloadProxy, wg0 wg0Var, sh0 sh0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uadDonwloadProxy, wg0Var, sh0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wg0Var;
            this.b = sh0Var;
        }

        @Override // com.baidu.searchbox.download.unified.EventCallback
        public void callBack(int i, EventCallback.EventBackInfo eventBackInfo) {
            Uri uri;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, eventBackInfo) == null) {
                if (i != 1) {
                    if (i == 2) {
                        this.a.c = AdDownloadStatus.NONE;
                        jg0.c().g(AdDownloadAction.FAIL_PERMISSION_DENY, this.a);
                        return;
                    }
                    return;
                }
                if (eventBackInfo != null && (uri = eventBackInfo.uri) != null) {
                    this.a.k = uri;
                }
                if (eventBackInfo != null) {
                    wg0 wg0Var = this.a;
                    wg0Var.i = 0.0f;
                    wg0Var.j = 0.0f;
                    this.b.b(wg0Var.q.e, z56.j(hf0.b(), this.a.k));
                    return;
                }
                sh0 sh0Var = this.b;
                wg0 wg0Var2 = this.a;
                sh0Var.b(wg0Var2.q.e, wg0Var2.h);
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
    public int a(@NonNull wg0 wg0Var, @NonNull sh0 sh0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, wg0Var, sh0Var)) == null) {
            if (TextUtils.isEmpty(wg0Var.g)) {
                eh0 eh0Var = new eh0();
                eh0Var.b = "download url is null";
                sh0Var.d(eh0Var);
                return -1;
            }
            gv6.b().f(hf0.b(), "ad", e(wg0Var), new ListenerFacade(this, wg0Var, sh0Var), new EventControlInfoForStart(false, false, true), new a(this, wg0Var, sh0Var));
            return wg0Var.g.hashCode();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(@NonNull wg0 wg0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, wg0Var) == null) {
            gv6.b().c(wg0Var.k);
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(@NonNull wg0 wg0Var, @NonNull sh0 sh0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, wg0Var, sh0Var) == null) {
            ListenerFacade listenerFacade = new ListenerFacade(this, wg0Var, sh0Var);
            a aVar = new a(this, wg0Var, sh0Var);
            gv6.b().e(hf0.b(), "ad", wg0Var.k, listenerFacade, new EventControlInfoForResume(false, true), aVar);
        }
    }

    public final DownloadParams e(@NonNull wg0 wg0Var) {
        InterceptResult invokeL;
        boolean z;
        int i;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, wg0Var)) == null) {
            DownloadParams downloadParams = new DownloadParams();
            JSONObject jSONObject = new JSONObject();
            String str = wg0Var.q.c;
            if (TextUtils.isEmpty(str)) {
                str = "apk_yuansheng_unknown";
            }
            oy0.f(jSONObject, "source", str);
            if (!TextUtils.isEmpty(wg0Var.p.c)) {
                oy0.d(jSONObject, DownloadConstants.HIDE_INSTALL_COMPLETE, 1);
            }
            if (ij0.b().a().a("tb_uad_is_visible_notification", 0) == 1) {
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
                if (!TextUtils.isEmpty(wg0Var.p.g)) {
                    oy0.f(jSONObject, "icon", wg0Var.p.g);
                }
                if (!TextUtils.isEmpty(wg0Var.p.i)) {
                    oy0.f(jSONObject, "versioncode", wg0Var.p.i);
                }
            }
            oy0.g(jSONObject, Downloads.Impl.COLUMN_EXTRA_INFO_CLOSE_AUTO_INSTALL, true);
            downloadParams.setVisibleInNotification(i);
            if (ij0.b().a().a("tb_uad_is_visible_in_download_center", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            downloadParams.setVisibleInDownloadsUI(z2);
            downloadParams.setUrl(wg0Var.g);
            downloadParams.setExtraInfo(jSONObject.toString());
            if (ij0.b().a().a("tb_uad_download_center_title_switch", 0) == 1 && !TextUtils.isEmpty(wg0Var.p.h)) {
                downloadParams.setTitle(wg0Var.p.h);
            }
            return downloadParams;
        }
        return (DownloadParams) invokeL.objValue;
    }
}

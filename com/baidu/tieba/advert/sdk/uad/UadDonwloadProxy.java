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
import com.baidu.tieba.cn0;
import com.baidu.tieba.gm0;
import com.baidu.tieba.hm0;
import com.baidu.tieba.ny6;
import com.baidu.tieba.om0;
import com.baidu.tieba.rk0;
import com.baidu.tieba.so0;
import com.baidu.tieba.tl0;
import com.baidu.tieba.y31;
import com.baidu.tieba.y96;
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
    public void b(@NonNull gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gm0Var) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class ListenerFacade implements IDownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public cn0 mListener;
        public gm0 model;
        public final /* synthetic */ UadDonwloadProxy this$0;

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onProgressChanged(Uri uri, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, uri, i) == null) {
            }
        }

        public ListenerFacade(UadDonwloadProxy uadDonwloadProxy, gm0 gm0Var, cn0 cn0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uadDonwloadProxy, gm0Var, cn0Var};
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
            this.model = gm0Var;
            this.mListener = cn0Var;
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onPause(Uri uri, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, uri, i) == null) {
                gm0 gm0Var = this.model;
                if (gm0Var.k != uri) {
                    return;
                }
                this.mListener.c(gm0Var.b, i);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onProgress(Uri uri, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{uri, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                gm0 gm0Var = this.model;
                if (gm0Var.k != uri || gm0Var.c == AdDownloadStatus.PAUSE) {
                    return;
                }
                if (j2 > 0) {
                    hm0 hm0Var = gm0Var.q;
                    if (hm0Var.e <= 0) {
                        hm0Var.e = j2;
                    }
                }
                this.mListener.a(this.model.b, j, j2);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onStopped(StopStatus stopStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, stopStatus) == null) {
                om0 om0Var = new om0();
                om0Var.b = stopStatus.name();
                if (stopStatus == StopStatus.DOWNLOAD_FAIL) {
                    om0Var.c = true;
                }
                this.mListener.d(om0Var);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onSuccess(Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, uri) == null) {
                gm0 gm0Var = this.model;
                if (gm0Var.k != uri) {
                    return;
                }
                gm0Var.h = y96.j(rk0.b(), this.model.k);
                this.mListener.onSuccess(this.model.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements EventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gm0 a;
        public cn0 b;

        public a(UadDonwloadProxy uadDonwloadProxy, gm0 gm0Var, cn0 cn0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uadDonwloadProxy, gm0Var, cn0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gm0Var;
            this.b = cn0Var;
        }

        @Override // com.baidu.searchbox.download.unified.EventCallback
        public void callBack(int i, EventCallback.EventBackInfo eventBackInfo) {
            Uri uri;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, eventBackInfo) == null) {
                if (i != 1) {
                    if (i == 2) {
                        this.a.c = AdDownloadStatus.NONE;
                        tl0.c().g(AdDownloadAction.FAIL_PERMISSION_DENY, this.a);
                        return;
                    }
                    return;
                }
                if (eventBackInfo != null && (uri = eventBackInfo.uri) != null) {
                    this.a.k = uri;
                }
                if (eventBackInfo != null) {
                    gm0 gm0Var = this.a;
                    gm0Var.i = 0.0f;
                    gm0Var.j = 0.0f;
                    this.b.b(gm0Var.q.e, y96.j(rk0.b(), this.a.k));
                    return;
                }
                cn0 cn0Var = this.b;
                gm0 gm0Var2 = this.a;
                cn0Var.b(gm0Var2.q.e, gm0Var2.h);
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
    public int a(@NonNull gm0 gm0Var, @NonNull cn0 cn0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gm0Var, cn0Var)) == null) {
            if (TextUtils.isEmpty(gm0Var.g)) {
                om0 om0Var = new om0();
                om0Var.b = "download url is null";
                cn0Var.d(om0Var);
                return -1;
            }
            ny6.a().d(rk0.b(), "ad", e(gm0Var), new ListenerFacade(this, gm0Var, cn0Var), new EventControlInfoForStart(false, false, true), new a(this, gm0Var, cn0Var));
            return gm0Var.g.hashCode();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(@NonNull gm0 gm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gm0Var) == null) {
            ny6.a().b(gm0Var.k);
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(@NonNull gm0 gm0Var, @NonNull cn0 cn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, gm0Var, cn0Var) == null) {
            ListenerFacade listenerFacade = new ListenerFacade(this, gm0Var, cn0Var);
            a aVar = new a(this, gm0Var, cn0Var);
            ny6.a().c(rk0.b(), "ad", gm0Var.k, listenerFacade, new EventControlInfoForResume(false, true), aVar);
        }
    }

    public final DownloadParams e(@NonNull gm0 gm0Var) {
        InterceptResult invokeL;
        boolean z;
        int i;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gm0Var)) == null) {
            DownloadParams downloadParams = new DownloadParams();
            JSONObject jSONObject = new JSONObject();
            String str = gm0Var.q.c;
            if (TextUtils.isEmpty(str)) {
                str = "apk_yuansheng_unknown";
            }
            y31.f(jSONObject, "source", str);
            if (!TextUtils.isEmpty(gm0Var.p.c)) {
                y31.d(jSONObject, DownloadConstants.HIDE_INSTALL_COMPLETE, 1);
            }
            if (so0.b().a().a("tb_uad_is_visible_notification", 0) == 1) {
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
                if (!TextUtils.isEmpty(gm0Var.p.g)) {
                    y31.f(jSONObject, "icon", gm0Var.p.g);
                }
                if (!TextUtils.isEmpty(gm0Var.p.i)) {
                    y31.f(jSONObject, "versioncode", gm0Var.p.i);
                }
            }
            y31.g(jSONObject, Downloads.Impl.COLUMN_EXTRA_INFO_CLOSE_AUTO_INSTALL, true);
            downloadParams.setVisibleInNotification(i);
            if (so0.b().a().a("tb_uad_is_visible_in_download_center", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            downloadParams.setVisibleInDownloadsUI(z2);
            downloadParams.setUrl(gm0Var.g);
            downloadParams.setExtraInfo(jSONObject.toString());
            if (so0.b().a().a("tb_uad_download_center_title_switch", 0) == 1 && !TextUtils.isEmpty(gm0Var.p.h)) {
                downloadParams.setTitle(gm0Var.p.h);
            }
            return downloadParams;
        }
        return (DownloadParams) invokeL.objValue;
    }
}

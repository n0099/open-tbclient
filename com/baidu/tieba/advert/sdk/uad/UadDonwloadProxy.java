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
import com.baidu.tieba.em0;
import com.baidu.tieba.g96;
import com.baidu.tieba.i31;
import com.baidu.tieba.il0;
import com.baidu.tieba.jl0;
import com.baidu.tieba.my6;
import com.baidu.tieba.ql0;
import com.baidu.tieba.tj0;
import com.baidu.tieba.un0;
import com.baidu.tieba.vk0;
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
    public void b(@NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, il0Var) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class ListenerFacade implements IDownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public em0 mListener;
        public il0 model;
        public final /* synthetic */ UadDonwloadProxy this$0;

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onProgressChanged(Uri uri, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, uri, i) == null) {
            }
        }

        public ListenerFacade(UadDonwloadProxy uadDonwloadProxy, il0 il0Var, em0 em0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uadDonwloadProxy, il0Var, em0Var};
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
            this.model = il0Var;
            this.mListener = em0Var;
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onPause(Uri uri, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, uri, i) == null) {
                il0 il0Var = this.model;
                if (il0Var.k != uri) {
                    return;
                }
                this.mListener.c(il0Var.b, i);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onProgress(Uri uri, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{uri, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                il0 il0Var = this.model;
                if (il0Var.k != uri || il0Var.c == AdDownloadStatus.PAUSE) {
                    return;
                }
                if (j2 > 0) {
                    jl0 jl0Var = il0Var.q;
                    if (jl0Var.e <= 0) {
                        jl0Var.e = j2;
                    }
                }
                this.mListener.a(this.model.b, j, j2);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onStopped(StopStatus stopStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, stopStatus) == null) {
                ql0 ql0Var = new ql0();
                ql0Var.b = stopStatus.name();
                if (stopStatus == StopStatus.DOWNLOAD_FAIL) {
                    ql0Var.c = true;
                }
                this.mListener.d(ql0Var);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onSuccess(Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, uri) == null) {
                il0 il0Var = this.model;
                if (il0Var.k != uri) {
                    return;
                }
                il0Var.h = g96.j(tj0.b(), this.model.k);
                this.mListener.onSuccess(this.model.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements EventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public il0 a;
        public em0 b;

        public a(UadDonwloadProxy uadDonwloadProxy, il0 il0Var, em0 em0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uadDonwloadProxy, il0Var, em0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = il0Var;
            this.b = em0Var;
        }

        @Override // com.baidu.searchbox.download.unified.EventCallback
        public void callBack(int i, EventCallback.EventBackInfo eventBackInfo) {
            Uri uri;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, eventBackInfo) == null) {
                if (i != 1) {
                    if (i == 2) {
                        this.a.c = AdDownloadStatus.NONE;
                        vk0.c().g(AdDownloadAction.FAIL_PERMISSION_DENY, this.a);
                        return;
                    }
                    return;
                }
                if (eventBackInfo != null && (uri = eventBackInfo.uri) != null) {
                    this.a.k = uri;
                }
                if (eventBackInfo != null) {
                    il0 il0Var = this.a;
                    il0Var.i = 0.0f;
                    il0Var.j = 0.0f;
                    this.b.b(il0Var.q.e, g96.j(tj0.b(), this.a.k));
                    return;
                }
                em0 em0Var = this.b;
                il0 il0Var2 = this.a;
                em0Var.b(il0Var2.q.e, il0Var2.h);
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
    public int a(@NonNull il0 il0Var, @NonNull em0 em0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, il0Var, em0Var)) == null) {
            if (TextUtils.isEmpty(il0Var.g)) {
                ql0 ql0Var = new ql0();
                ql0Var.b = "download url is null";
                em0Var.d(ql0Var);
                return -1;
            }
            my6.b().f(tj0.b(), "ad", e(il0Var), new ListenerFacade(this, il0Var, em0Var), new EventControlInfoForStart(false, false, true), new a(this, il0Var, em0Var));
            return il0Var.g.hashCode();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(@NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, il0Var) == null) {
            my6.b().c(il0Var.k);
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(@NonNull il0 il0Var, @NonNull em0 em0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, il0Var, em0Var) == null) {
            ListenerFacade listenerFacade = new ListenerFacade(this, il0Var, em0Var);
            a aVar = new a(this, il0Var, em0Var);
            my6.b().e(tj0.b(), "ad", il0Var.k, listenerFacade, new EventControlInfoForResume(false, true), aVar);
        }
    }

    public final DownloadParams e(@NonNull il0 il0Var) {
        InterceptResult invokeL;
        boolean z;
        int i;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, il0Var)) == null) {
            DownloadParams downloadParams = new DownloadParams();
            JSONObject jSONObject = new JSONObject();
            String str = il0Var.q.c;
            if (TextUtils.isEmpty(str)) {
                str = "apk_yuansheng_unknown";
            }
            i31.f(jSONObject, "source", str);
            if (!TextUtils.isEmpty(il0Var.p.c)) {
                i31.d(jSONObject, DownloadConstants.HIDE_INSTALL_COMPLETE, 1);
            }
            if (un0.b().a().a("tb_uad_is_visible_notification", 0) == 1) {
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
                if (!TextUtils.isEmpty(il0Var.p.g)) {
                    i31.f(jSONObject, "icon", il0Var.p.g);
                }
                if (!TextUtils.isEmpty(il0Var.p.i)) {
                    i31.f(jSONObject, "versioncode", il0Var.p.i);
                }
            }
            i31.g(jSONObject, Downloads.Impl.COLUMN_EXTRA_INFO_CLOSE_AUTO_INSTALL, true);
            downloadParams.setVisibleInNotification(i);
            if (un0.b().a().a("tb_uad_is_visible_in_download_center", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            downloadParams.setVisibleInDownloadsUI(z2);
            downloadParams.setUrl(il0Var.g);
            downloadParams.setExtraInfo(jSONObject.toString());
            if (un0.b().a().a("tb_uad_download_center_title_switch", 0) == 1 && !TextUtils.isEmpty(il0Var.p.h)) {
                downloadParams.setTitle(il0Var.p.h);
            }
            return downloadParams;
        }
        return (DownloadParams) invokeL.objValue;
    }
}

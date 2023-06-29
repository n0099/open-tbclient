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
import com.baidu.tieba.c31;
import com.baidu.tieba.dm0;
import com.baidu.tieba.em0;
import com.baidu.tieba.ew6;
import com.baidu.tieba.io0;
import com.baidu.tieba.lm0;
import com.baidu.tieba.ok0;
import com.baidu.tieba.ql0;
import com.baidu.tieba.u86;
import com.baidu.tieba.zm0;
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
    public void b(@NonNull dm0 dm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dm0Var) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class ListenerFacade implements IDownloadListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public zm0 mListener;
        public dm0 model;
        public final /* synthetic */ UadDonwloadProxy this$0;

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onProgressChanged(Uri uri, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, uri, i) == null) {
            }
        }

        public ListenerFacade(UadDonwloadProxy uadDonwloadProxy, dm0 dm0Var, zm0 zm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uadDonwloadProxy, dm0Var, zm0Var};
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
            this.model = dm0Var;
            this.mListener = zm0Var;
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onPause(Uri uri, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, uri, i) == null) {
                dm0 dm0Var = this.model;
                if (dm0Var.k != uri) {
                    return;
                }
                this.mListener.c(dm0Var.b, i);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onProgress(Uri uri, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{uri, Long.valueOf(j), Long.valueOf(j2)}) == null) {
                dm0 dm0Var = this.model;
                if (dm0Var.k != uri || dm0Var.c == AdDownloadStatus.PAUSE) {
                    return;
                }
                if (j2 > 0) {
                    em0 em0Var = dm0Var.q;
                    if (em0Var.e <= 0) {
                        em0Var.e = j2;
                    }
                }
                this.mListener.a(this.model.b, j, j2);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onStopped(StopStatus stopStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, stopStatus) == null) {
                lm0 lm0Var = new lm0();
                lm0Var.b = stopStatus.name();
                if (stopStatus == StopStatus.DOWNLOAD_FAIL) {
                    lm0Var.c = true;
                }
                this.mListener.d(lm0Var);
            }
        }

        @Override // com.baidu.searchbox.download.callback.IDownloadListener
        public void onSuccess(Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, uri) == null) {
                dm0 dm0Var = this.model;
                if (dm0Var.k != uri) {
                    return;
                }
                dm0Var.h = u86.j(ok0.b(), this.model.k);
                this.mListener.onSuccess(this.model.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements EventCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public dm0 a;
        public zm0 b;

        public a(UadDonwloadProxy uadDonwloadProxy, dm0 dm0Var, zm0 zm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uadDonwloadProxy, dm0Var, zm0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dm0Var;
            this.b = zm0Var;
        }

        @Override // com.baidu.searchbox.download.unified.EventCallback
        public void callBack(int i, EventCallback.EventBackInfo eventBackInfo) {
            Uri uri;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, eventBackInfo) == null) {
                if (i != 1) {
                    if (i == 2) {
                        this.a.c = AdDownloadStatus.NONE;
                        ql0.b().f(AdDownloadAction.FAIL_PERMISSION_DENY, this.a);
                        return;
                    }
                    return;
                }
                if (eventBackInfo != null && (uri = eventBackInfo.uri) != null) {
                    this.a.k = uri;
                }
                if (eventBackInfo != null) {
                    dm0 dm0Var = this.a;
                    dm0Var.i = 0.0f;
                    dm0Var.j = 0.0f;
                    this.b.b(dm0Var.q.e, u86.j(ok0.b(), this.a.k));
                    return;
                }
                zm0 zm0Var = this.b;
                dm0 dm0Var2 = this.a;
                zm0Var.b(dm0Var2.q.e, dm0Var2.h);
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
    public int a(@NonNull dm0 dm0Var, @NonNull zm0 zm0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dm0Var, zm0Var)) == null) {
            if (TextUtils.isEmpty(dm0Var.g)) {
                lm0 lm0Var = new lm0();
                lm0Var.b = "download url is null";
                zm0Var.d(lm0Var);
                return -1;
            }
            ew6.a().d(ok0.b(), "ad", e(dm0Var), new ListenerFacade(this, dm0Var, zm0Var), new EventControlInfoForStart(false, false, true), new a(this, dm0Var, zm0Var));
            return dm0Var.g.hashCode();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(@NonNull dm0 dm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dm0Var) == null) {
            ew6.a().b(dm0Var.k);
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(@NonNull dm0 dm0Var, @NonNull zm0 zm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, dm0Var, zm0Var) == null) {
            ListenerFacade listenerFacade = new ListenerFacade(this, dm0Var, zm0Var);
            a aVar = new a(this, dm0Var, zm0Var);
            ew6.a().c(ok0.b(), "ad", dm0Var.k, listenerFacade, new EventControlInfoForResume(false, true), aVar);
        }
    }

    public final DownloadParams e(@NonNull dm0 dm0Var) {
        InterceptResult invokeL;
        boolean z;
        int i;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dm0Var)) == null) {
            DownloadParams downloadParams = new DownloadParams();
            JSONObject jSONObject = new JSONObject();
            String str = dm0Var.q.c;
            if (TextUtils.isEmpty(str)) {
                str = "apk_yuansheng_unknown";
            }
            c31.f(jSONObject, "source", str);
            if (!TextUtils.isEmpty(dm0Var.p.c)) {
                c31.d(jSONObject, DownloadConstants.HIDE_INSTALL_COMPLETE, 1);
            }
            if (io0.b().a().a("tb_uad_is_visible_notification", 0) == 1) {
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
                if (!TextUtils.isEmpty(dm0Var.p.g)) {
                    c31.f(jSONObject, "icon", dm0Var.p.g);
                }
                if (!TextUtils.isEmpty(dm0Var.p.i)) {
                    c31.f(jSONObject, "versioncode", dm0Var.p.i);
                }
            }
            c31.g(jSONObject, Downloads.Impl.COLUMN_EXTRA_INFO_CLOSE_AUTO_INSTALL, true);
            downloadParams.setVisibleInNotification(i);
            if (io0.b().a().a("tb_uad_is_visible_in_download_center", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            downloadParams.setVisibleInDownloadsUI(z2);
            downloadParams.setUrl(dm0Var.g);
            downloadParams.setExtraInfo(jSONObject.toString());
            if (io0.b().a().a("tb_uad_download_center_title_switch", 0) == 1 && !TextUtils.isEmpty(dm0Var.p.h)) {
                downloadParams.setTitle(dm0Var.p.h);
            }
            return downloadParams;
        }
        return (DownloadParams) invokeL.objValue;
    }
}

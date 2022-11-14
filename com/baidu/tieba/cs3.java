package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.tieba.ds3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class cs3 implements ds3.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService a;
    public final ks3 b;
    public final DownloadInfo c;
    public final a d;
    public long e;
    public volatile AtomicBoolean f;

    /* loaded from: classes3.dex */
    public interface a {
        void e(DownloadInfo downloadInfo);
    }

    public cs3(ExecutorService executorService, ks3 ks3Var, DownloadInfo downloadInfo, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService, ks3Var, downloadInfo, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = System.currentTimeMillis();
        this.f = new AtomicBoolean(false);
        this.a = executorService;
        this.b = ks3Var;
        this.c = downloadInfo;
        this.d = aVar;
    }

    @Override // com.baidu.tieba.ds3.a
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.getProgress() == this.c.getSize()) {
            this.c.setPackageName(xt3.d(AppRuntime.getAppContext(), this.c.getPath()));
            this.c.setStatus(DownloadState.DOWNLOADED.value());
            this.b.b(this.c);
            a aVar = this.d;
            if (aVar != null) {
                aVar.e(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.ds3.a
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.f.get()) {
            synchronized (this) {
                if (!this.f.get()) {
                    this.f.set(true);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.e > 1000) {
                        this.b.b(this.c);
                        this.e = currentTimeMillis;
                    }
                    this.f.set(false);
                }
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.submit(new ds3(this.b, this.c, this));
        }
    }
}

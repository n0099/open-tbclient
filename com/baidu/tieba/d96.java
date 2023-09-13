package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.download.proxy.IAdDownloader;
import com.baidu.searchbox.download.model.StopStatus;
import com.baidu.searchbox.download.util.ApkUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.filedownloader.TbDownloadManagerEcom;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ApkDetail;
/* loaded from: classes5.dex */
public class d96 implements IAdDownloader {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements gf7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final il0 a;
        @NonNull
        public final em0 b;

        public a(@NonNull d96 d96Var, @NonNull il0 il0Var, em0 em0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d96Var, il0Var, em0Var};
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

        @Override // com.baidu.tieba.gf7
        public void a(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadData) == null) {
                ql0 ql0Var = new ql0();
                ql0Var.b = downloadData.getStatusMsg();
                if (TextUtils.equals(downloadData.getStatusMsg(), StopStatus.DOWNLOAD_FAIL.name())) {
                    ql0Var.c = true;
                }
                this.b.d(ql0Var);
            }
        }

        @Override // com.baidu.tieba.gf7
        public void b(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                this.a.h = g96.j(tj0.b(), this.a.k);
                this.b.onSuccess(this.a.b);
            }
        }

        @Override // com.baidu.tieba.gf7
        public void c(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) {
                this.b.c(this.a.b, downloadData.getProcess());
            }
        }

        @Override // com.baidu.tieba.gf7
        public void d(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
                if (this.a.c == AdDownloadStatus.INSTALLED && ApkUtil.hasInstalled(tj0.b(), this.a.d)) {
                    return;
                }
                ql0 ql0Var = new ql0();
                ql0Var.b = "user_cancel";
                this.b.d(ql0Var);
            }
        }

        @Override // com.baidu.tieba.gf7
        public void e(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) {
                if (downloadData.getSize() > 0) {
                    jl0 jl0Var = this.a.q;
                    if (jl0Var.e <= 0) {
                        jl0Var.e = downloadData.getSize();
                    }
                }
                this.b.a(this.a.b, downloadData.getLength(), downloadData.getSize());
            }
        }

        @Override // com.baidu.tieba.gf7
        public void f(@NonNull DownloadData downloadData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, downloadData, i) == null) {
                Uri uri = downloadData.getUri();
                if (uri != null && !TextUtils.isEmpty(uri.toString())) {
                    il0 il0Var = this.a;
                    il0Var.k = uri;
                    il0Var.i = 0.0f;
                    il0Var.j = 0.0f;
                }
                this.b.b(this.a.q.e, g96.j(tj0.b(), this.a.k));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947659432, "Lcom/baidu/tieba/d96;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947659432, "Lcom/baidu/tieba/d96;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getString(R.string.item_download);
    }

    public d96() {
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
            TbDownloadManagerEcom.i().g(e(il0Var), new a(this, il0Var, em0Var));
            return il0Var.g.hashCode();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void b(@NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, il0Var) == null) {
            TbDownloadManagerEcom.i().b(e(il0Var));
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(@NonNull il0 il0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, il0Var) == null) {
            TbDownloadManagerEcom.i().f(e(il0Var));
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(@NonNull il0 il0Var, @NonNull em0 em0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, il0Var, em0Var) == null) {
            a aVar = new a(this, il0Var, em0Var);
            TbDownloadManagerEcom.i().g(e(il0Var), aVar);
        }
    }

    public final DownloadData e(il0 il0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, il0Var)) == null) {
            DownloadData downloadData = new DownloadData();
            downloadData.setUrl(il0Var.g);
            downloadData.setName(il0Var.p.h);
            downloadData.setSource(5);
            ItemData itemData = new ItemData();
            itemData.buttonLink = il0Var.g;
            itemData.buttonName = a;
            itemData.buttonLinkType = 1;
            ml0 ml0Var = il0Var.p;
            itemData.mTitle = ml0Var.h;
            itemData.pkgName = il0Var.d;
            itemData.mIconUrl = ml0Var.g;
            itemData.mIconSize = 1.0d;
            itemData.fileType = "app";
            itemData.apkDetail = new ApkDetail.Builder().build(true);
            downloadData.setItemData(itemData);
            return downloadData;
        }
        return (DownloadData) invokeL.objValue;
    }
}

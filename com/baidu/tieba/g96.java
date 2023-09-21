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
/* loaded from: classes6.dex */
public class g96 implements IAdDownloader {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements qf7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final hl0 a;
        @NonNull
        public final dm0 b;

        public a(@NonNull g96 g96Var, @NonNull hl0 hl0Var, dm0 dm0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g96Var, hl0Var, dm0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hl0Var;
            this.b = dm0Var;
        }

        @Override // com.baidu.tieba.qf7
        public void a(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, downloadData) == null) {
                pl0 pl0Var = new pl0();
                pl0Var.b = downloadData.getStatusMsg();
                if (TextUtils.equals(downloadData.getStatusMsg(), StopStatus.DOWNLOAD_FAIL.name())) {
                    pl0Var.c = true;
                }
                this.b.d(pl0Var);
            }
        }

        @Override // com.baidu.tieba.qf7
        public void b(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                this.a.h = j96.j(sj0.b(), this.a.k);
                this.b.onSuccess(this.a.b);
            }
        }

        @Override // com.baidu.tieba.qf7
        public void c(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) {
                this.b.c(this.a.b, downloadData.getProcess());
            }
        }

        @Override // com.baidu.tieba.qf7
        public void d(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) {
                if (this.a.c == AdDownloadStatus.INSTALLED && ApkUtil.hasInstalled(sj0.b(), this.a.d)) {
                    return;
                }
                pl0 pl0Var = new pl0();
                pl0Var.b = "user_cancel";
                this.b.d(pl0Var);
            }
        }

        @Override // com.baidu.tieba.qf7
        public void e(@NonNull DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, downloadData) == null) {
                if (downloadData.getSize() > 0) {
                    il0 il0Var = this.a.q;
                    if (il0Var.e <= 0) {
                        il0Var.e = downloadData.getSize();
                    }
                }
                this.b.a(this.a.b, downloadData.getLength(), downloadData.getSize());
            }
        }

        @Override // com.baidu.tieba.qf7
        public void f(@NonNull DownloadData downloadData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, downloadData, i) == null) {
                Uri uri = downloadData.getUri();
                if (uri != null && !TextUtils.isEmpty(uri.toString())) {
                    hl0 hl0Var = this.a;
                    hl0Var.k = uri;
                    hl0Var.i = 0.0f;
                    hl0Var.j = 0.0f;
                }
                this.b.b(this.a.q.e, j96.j(sj0.b(), this.a.k));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748805, "Lcom/baidu/tieba/g96;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748805, "Lcom/baidu/tieba/g96;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getResources().getString(R.string.item_download);
    }

    public g96() {
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
    public int a(@NonNull hl0 hl0Var, @NonNull dm0 dm0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hl0Var, dm0Var)) == null) {
            if (TextUtils.isEmpty(hl0Var.g)) {
                pl0 pl0Var = new pl0();
                pl0Var.b = "download url is null";
                dm0Var.d(pl0Var);
                return -1;
            }
            TbDownloadManagerEcom.i().g(e(hl0Var), new a(this, hl0Var, dm0Var));
            return hl0Var.g.hashCode();
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void b(@NonNull hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hl0Var) == null) {
            TbDownloadManagerEcom.i().b(e(hl0Var));
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void c(@NonNull hl0 hl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hl0Var) == null) {
            TbDownloadManagerEcom.i().f(e(hl0Var));
        }
    }

    @Override // com.baidu.nadcore.download.proxy.IAdDownloader
    public void d(@NonNull hl0 hl0Var, @NonNull dm0 dm0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, hl0Var, dm0Var) == null) {
            a aVar = new a(this, hl0Var, dm0Var);
            TbDownloadManagerEcom.i().g(e(hl0Var), aVar);
        }
    }

    public final DownloadData e(hl0 hl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, hl0Var)) == null) {
            DownloadData downloadData = new DownloadData();
            downloadData.setUrl(hl0Var.g);
            downloadData.setName(hl0Var.p.h);
            downloadData.setSource(5);
            ItemData itemData = new ItemData();
            itemData.buttonLink = hl0Var.g;
            itemData.buttonName = a;
            itemData.buttonLinkType = 1;
            ll0 ll0Var = hl0Var.p;
            itemData.mTitle = ll0Var.h;
            itemData.pkgName = hl0Var.d;
            itemData.mIconUrl = ll0Var.g;
            itemData.mIconSize = 1.0d;
            itemData.fileType = "app";
            itemData.apkDetail = new ApkDetail.Builder().build(true);
            downloadData.setItemData(itemData);
            return downloadData;
        }
        return (DownloadData) invokeL.objValue;
    }
}

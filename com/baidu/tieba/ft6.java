package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tieba.filedownloader.FileDownloaderProxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class ft6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static final class a implements it6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;

        @Override // com.baidu.tieba.it6
        public void a(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
            }
        }

        @Override // com.baidu.tieba.it6
        public void b(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
            }
        }

        @Override // com.baidu.tieba.it6
        public void f(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
            }
        }

        public a(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadData};
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
        }

        @Override // com.baidu.tieba.it6
        public void c(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                ku4.c().b(TbadkCoreStatisticKey.FILE_DOWNLOAD_COMPLETION, String.valueOf(this.a.getSource()), this.a.getName(), this.a.getUrl());
            }
        }

        @Override // com.baidu.tieba.it6
        public void d(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                ku4.c().b(TbadkCoreStatisticKey.FILE_DOWNLOAD_PAUSE, String.valueOf(this.a.getSource()), this.a.getName(), this.a.getUrl());
            }
        }

        @Override // com.baidu.tieba.it6
        public void e(DownloadData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                ku4.c().b(TbadkCoreStatisticKey.FILE_DOWNLOAD_DELETE, String.valueOf(this.a.getSource()), this.a.getName(), this.a.getUrl());
            }
        }
    }

    public ft6() {
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

    public final ht6 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return FileDownloaderProxy.b.a(1);
        }
        return (ht6) invokeV.objValue;
    }

    public final void a(it6 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            c().a(callback);
        }
    }

    public final void b(DownloadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            c().c(data);
        }
    }

    public final int d(DownloadData data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            return c().f(data);
        }
        return invokeL.intValue;
    }

    public final int e(DownloadData data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            return c().d(data);
        }
        return invokeL.intValue;
    }

    public final void f(DownloadData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            c().e(data);
        }
    }

    public final void g(it6 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            c().g(callback);
        }
    }

    public final boolean h(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, downloadData)) == null) {
            Intrinsics.checkNotNullParameter(downloadData, "downloadData");
            int d = c().d(downloadData);
            boolean b = c().b(downloadData, new a(downloadData));
            if (b) {
                if (d == 7) {
                    ku4.c().b(TbadkCoreStatisticKey.FILE_DOWNLOAD_RESUME, String.valueOf(downloadData.getSource()), downloadData.getName(), downloadData.getUrl());
                } else {
                    ku4.c().b(TbadkCoreStatisticKey.FILE_DOWNLOAD_START, String.valueOf(downloadData.getSource()), downloadData.getName(), downloadData.getUrl());
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }
}

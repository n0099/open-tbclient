package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f55 {
    public static /* synthetic */ Interceptable $ic;
    public static cf0 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public final class a implements cf0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.f55$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0230a implements g55 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ bf0 a;

            @Override // com.baidu.tieba.g55
            public boolean onFileDownloaded(DownloadData downloadData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }

            public C0230a(a aVar, bf0 bf0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bf0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bf0Var;
            }

            @Override // com.baidu.tieba.g55
            public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
                bf0 bf0Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) && (bf0Var = this.a) != null) {
                    bf0Var.onFailed(new Exception(str));
                }
            }

            @Override // com.baidu.tieba.g55
            public void onFileDownloadSucceed(DownloadData downloadData) {
                bf0 bf0Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) && (bf0Var = this.a) != null) {
                    bf0Var.b(downloadData.getPath());
                }
            }

            @Override // com.baidu.tieba.g55
            public void onFileUpdateProgress(DownloadData downloadData) {
                bf0 bf0Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) && (bf0Var = this.a) != null) {
                    bf0Var.a(0L, 100L, (int) (downloadData.getLength() / downloadData.getSize()));
                }
            }

            @Override // com.baidu.tieba.g55
            public boolean onPreDownload(DownloadData downloadData) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                    bf0 bf0Var = this.a;
                    if (bf0Var != null) {
                        bf0Var.onStarted();
                        return true;
                    }
                    return true;
                }
                return invokeL.booleanValue;
            }
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

        @Override // com.baidu.tieba.cf0
        public void a(String str, String str2, String str3, bf0 bf0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, bf0Var) == null) {
                DownloadData downloadData = new DownloadData();
                downloadData.setPath(str2 + "/" + str3);
                downloadData.setUrl(str);
                downloadData.setCallback(new C0230a(this, bf0Var));
                h55.k().l(downloadData);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947715139, "Lcom/baidu/tieba/f55;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947715139, "Lcom/baidu/tieba/f55;");
                return;
            }
        }
        a = new a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            ve0.q(a);
        }
    }
}

package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class ho8 {
    public static /* synthetic */ Interceptable $ic;
    public static ho8 b;
    public static List<c> c;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* loaded from: classes4.dex */
    public static class c extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public DownloadData a;
        public tk6 b;
        public boolean c;
        public NetWork d;
        public Handler e;

        /* loaded from: classes4.dex */
        public class a extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, Looper looper) {
                super(looper);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, looper};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Looper) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    super.handleMessage(message);
                    if (message.what == 900002 && message.arg2 > 0 && this.a.a != null) {
                        this.a.a.setLength(message.arg1);
                        this.a.a.setSize(message.arg2);
                        this.a.a.setStatus(1);
                        if (this.a.a.getCallback() != null) {
                            this.a.a.getCallback().onFileUpdateProgress(this.a.a);
                        }
                        if (this.a.b != null) {
                            this.a.b.f(this.a.a);
                        }
                    }
                }
            }
        }

        public c(DownloadData downloadData, tk6 tk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {downloadData, tk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = new NetWork();
            this.e = new a(this, Looper.getMainLooper());
            this.a = downloadData;
            this.b = tk6Var;
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                NetWork netWork = this.d;
                if (netWork != null) {
                    netWork.setCancel();
                }
                cancel(true);
            }
        }

        public DownloadData g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a;
            }
            return (DownloadData) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Integer doInBackground(DownloadData... downloadDataArr) {
            InterceptResult invokeL;
            FileInputStream fileInputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadDataArr)) == null) {
                FileInputStream fileInputStream2 = null;
                if (downloadDataArr[0] == null) {
                    return null;
                }
                if (downloadDataArr[0].getCallback() != null && !downloadDataArr[0].getCallback().onPreDownload(downloadDataArr[0])) {
                    return 0;
                }
                File file = new File(downloadDataArr[0].getPath());
                if (file.exists()) {
                    file.delete();
                }
                if (!file.exists()) {
                    this.d.setUrl(downloadDataArr[0].getUrl());
                    NetWork netWork = this.d;
                    if (netWork.downloadFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp", this.e, TbConfig.NET_MSG_GETLENTH, 3, 3000)) {
                        File GetFile = FileHelper.GetFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                        if (GetFile == null) {
                            GetFile = FileHelper.GetFileInCache(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp");
                        }
                        if (GetFile != null) {
                            try {
                                try {
                                    String parent = GetFile.getParent();
                                    String parent2 = file.getParent();
                                    if (parent.equals(parent2)) {
                                        GetFile.renameTo(new File(parent2, file.getName()));
                                    } else {
                                        ui.f(GetFile, file);
                                        ui.n(GetFile);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return 7;
                                }
                            } catch (IOException unused) {
                                ui.n(file);
                                ui.n(GetFile);
                                return 7;
                            }
                        } else {
                            return 1;
                        }
                    } else {
                        return 3;
                    }
                }
                try {
                    if (!yi.isEmpty(downloadDataArr[0].getCheck())) {
                        try {
                            fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                        } catch (FileNotFoundException e2) {
                            e = e2;
                        }
                        try {
                            if (!gj.b(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                                ui.n(new File(downloadDataArr[0].getPath()));
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                    BdLog.d(e3.getMessage());
                                }
                                return 4;
                            }
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                                BdLog.d(e4.getMessage());
                            }
                        } catch (FileNotFoundException e5) {
                            e = e5;
                            fileInputStream2 = fileInputStream;
                            BdLog.d(e.getMessage());
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e6) {
                                    BdLog.d(e6.getMessage());
                                }
                            }
                            return 6;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e7) {
                                    BdLog.d(e7.getMessage());
                                }
                            }
                            throw th;
                        }
                    }
                    if (downloadDataArr[0].getCallback() == null || downloadDataArr[0].getCallback().onFileDownloaded(downloadDataArr[0])) {
                        return 0;
                    }
                    return 2;
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                return (Integer) invokeL.objValue;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                super.onCancelled();
                this.d.setCancel();
                if (this.c) {
                    this.a.setStatus(6);
                } else {
                    this.a.setStatus(4);
                }
                this.a.setStatusMsg(null);
                if (this.a.getCallback() != null) {
                    this.a.getCallback().onFileUpdateProgress(this.a);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, num) == null) {
                super.onPostExecute((c) num);
                if (num == null) {
                    return;
                }
                if (num.intValue() == 0) {
                    this.a.setStatus(0);
                    if (this.a.getCallback() != null) {
                        this.a.getCallback().onFileUpdateProgress(this.a);
                    }
                    if (this.a.getCallback() != null) {
                        this.a.getCallback().onFileDownloadSucceed(this.a);
                    }
                    tk6 tk6Var = this.b;
                    if (tk6Var != null) {
                        tk6Var.c(this.a);
                    }
                } else {
                    String str = null;
                    int intValue = num.intValue();
                    if (intValue != 1) {
                        if (intValue != 2) {
                            if (intValue != 3) {
                                if (intValue != 4) {
                                    if (intValue != 6) {
                                        if (intValue == 7) {
                                            str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                                        }
                                    } else {
                                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                                    }
                                } else {
                                    str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                                }
                            } else {
                                str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                            }
                        } else {
                            str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                        }
                    } else {
                        str = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    }
                    this.a.setStatusMsg(str);
                    this.a.setErrorCode(num.intValue());
                    this.a.setStatus(2);
                    if (this.a.getCallback() != null) {
                        this.a.getCallback().onFileUpdateProgress(this.a);
                    }
                    if (this.a.getCallback() != null) {
                        this.a.getCallback().onFileDownloadFailed(this.a, num.intValue(), str);
                    }
                    tk6 tk6Var2 = this.b;
                    if (tk6Var2 != null) {
                        tk6Var2.b(this.a);
                    }
                }
                ho8.c.remove(this);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;
        public final /* synthetic */ tk6 b;
        public final /* synthetic */ ho8 c;

        public a(ho8 ho8Var, DownloadData downloadData, tk6 tk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ho8Var, downloadData, tk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ho8Var;
            this.a = downloadData;
            this.b = tk6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ho8.c.size() >= this.c.a) {
                    this.a.setStatus(2);
                    this.a.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                    if (this.a.getCallback() != null) {
                        this.a.getCallback().onFileUpdateProgress(this.a);
                    }
                    tk6 tk6Var = this.b;
                    if (tk6Var != null) {
                        tk6Var.b(this.a);
                        return;
                    }
                    return;
                }
                this.c.g(this.a, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        public b(ho8 ho8Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ho8Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Iterator it = ho8.c.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.g().getUrl().equals(this.a)) {
                        cVar.c = this.b;
                        cVar.g().setStatus(4);
                        if (this.b) {
                            cVar.g().setStatus(6);
                            if (cVar.b != null) {
                                cVar.b.e(cVar.g());
                            }
                        } else if (cVar.b != null) {
                            cVar.b.d(cVar.g());
                        }
                        if (cVar.g().getCallback() != null) {
                            cVar.g().getCallback().onFileUpdateProgress(cVar.g());
                        }
                        it.remove();
                        cVar.e();
                        return;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947830552, "Lcom/baidu/tieba/ho8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947830552, "Lcom/baidu/tieba/ho8;");
                return;
            }
        }
        b = new ho8();
        c = new LinkedList();
    }

    public ho8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 5;
    }

    public static ho8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return b;
        }
        return (ho8) invokeV.objValue;
    }

    public void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) {
            bh.a().post(new b(this, str, z));
        }
    }

    public void h(DownloadData downloadData, tk6 tk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, downloadData, tk6Var) == null) {
            bh.a().post(new a(this, downloadData, tk6Var));
        }
    }

    public List<DownloadData> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            LinkedList linkedList = new LinkedList();
            for (c cVar : c) {
                linkedList.add(cVar.g());
            }
            return linkedList;
        }
        return (List) invokeV.objValue;
    }

    public final void g(DownloadData downloadData, tk6 tk6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, downloadData, tk6Var) != null) || downloadData == null) {
            return;
        }
        if (!FileHelper.checkSD()) {
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
            downloadData.setStatus(2);
        }
        if (downloadData.getStatus() == 2) {
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
            }
            if (tk6Var != null) {
                tk6Var.b(downloadData);
                return;
            }
            return;
        }
        for (int i = 0; i < c.size(); i++) {
            DownloadData g = c.get(i).g();
            if (g != null && g.getUrl().equals(downloadData.getUrl()) && g.getId().equals(downloadData.getId())) {
                return;
            }
        }
        downloadData.setStatus(5);
        if (downloadData.getCallback() != null) {
            downloadData.getCallback().onFileUpdateProgress(downloadData);
        }
        if (tk6Var != null) {
            tk6Var.a(downloadData);
        }
        c cVar = new c(downloadData, tk6Var);
        c.add(cVar);
        cVar.execute(downloadData);
    }
}

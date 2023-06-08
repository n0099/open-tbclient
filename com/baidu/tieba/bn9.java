package com.baidu.tieba;

import android.annotation.SuppressLint;
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
/* loaded from: classes5.dex */
public class bn9 {
    public static /* synthetic */ Interceptable $ic;
    public static bn9 c;
    public static DownloadData d;
    public static List<DownloadData> e;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    @SuppressLint({"HandlerLeak"})
    public Handler b;

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(bn9 bn9Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bn9Var, looper};
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
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 900002 && message.arg2 > 0 && bn9.d != null) {
                    bn9.d.setLength(message.arg1);
                    bn9.d.setSize(message.arg2);
                    bn9.d.setStatus(1);
                    if (bn9.d.getCallback() != null) {
                        bn9.d.getCallback().onFileUpdateProgress(bn9.d);
                    }
                }
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<DownloadData, DownloadData, Integer> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;
        public final /* synthetic */ bn9 b;

        public b(bn9 bn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bn9Var;
            this.a = new NetWork();
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.setCancel();
                }
                cancel(true);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public Integer doInBackground(DownloadData... downloadDataArr) {
            InterceptResult invokeL;
            FileInputStream fileInputStream;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadDataArr)) == null) {
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
                    this.a.setUrl(downloadDataArr[0].getUrl());
                    NetWork netWork = this.a;
                    if (Boolean.valueOf(netWork.downloadFile(downloadDataArr[0].getId() + "_" + downloadDataArr[0].getName() + ".tmp", this.b.b, TbConfig.NET_MSG_GETLENTH, 3, 3000)).booleanValue()) {
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
                                        qi.f(GetFile, file);
                                        qi.n(GetFile);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return 7;
                                }
                            } catch (IOException unused) {
                                qi.n(file);
                                qi.n(GetFile);
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
                    if (!ui.isEmpty(downloadDataArr[0].getCheck())) {
                        try {
                            fileInputStream = new FileInputStream(downloadDataArr[0].getPath());
                        } catch (FileNotFoundException e2) {
                            e = e2;
                        }
                        try {
                            if (!cj.b(fileInputStream).equalsIgnoreCase(downloadDataArr[0].getCheck())) {
                                qi.n(new File(downloadDataArr[0].getPath()));
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
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onCancelled();
                this.a.setCancel();
                bn9.d.setStatus(4);
                bn9.d.setStatusMsg(null);
                if (bn9.d.getCallback() != null) {
                    bn9.d.getCallback().onFileUpdateProgress(bn9.d);
                }
                if (!bn9.e.isEmpty()) {
                    bn9.e.remove(0);
                }
                DownloadData unused = bn9.d = null;
                this.b.m();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Integer num) {
            String string;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, num) == null) {
                super.onPostExecute((b) num);
                if (num == null) {
                    return;
                }
                if (num.intValue() == 0) {
                    bn9.d.setStatus(0);
                    if (bn9.d.getCallback() != null) {
                        bn9.d.getCallback().onFileUpdateProgress(bn9.d);
                    }
                    if (bn9.d.getCallback() != null) {
                        bn9.d.getCallback().onFileDownloadSucceed(bn9.d);
                    }
                } else {
                    int intValue = num.intValue();
                    if (intValue != 1) {
                        if (intValue != 2) {
                            if (intValue != 3) {
                                if (intValue != 4) {
                                    if (intValue != 6) {
                                        if (intValue != 7) {
                                            string = null;
                                        } else {
                                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                                        }
                                    } else {
                                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                                    }
                                } else {
                                    string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                                }
                            } else {
                                string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_net);
                            }
                        } else {
                            string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                        }
                    } else {
                        string = TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail);
                    }
                    bn9.d.setStatusMsg(string);
                    bn9.d.setErrorCode(num.intValue());
                    bn9.d.setStatus(2);
                    if (bn9.d.getCallback() != null) {
                        bn9.d.getCallback().onFileUpdateProgress(bn9.d);
                    }
                    if (bn9.d.getCallback() != null) {
                        bn9.d.getCallback().onFileDownloadFailed(bn9.d, num.intValue(), string);
                    }
                }
                DownloadData unused = bn9.d = null;
                if (!bn9.e.isEmpty()) {
                    bn9.e.remove(0);
                    this.b.m();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947650876, "Lcom/baidu/tieba/bn9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947650876, "Lcom/baidu/tieba/bn9;");
                return;
            }
        }
        c = new bn9();
        d = null;
        e = new LinkedList();
    }

    public bn9() {
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
        this.a = null;
        this.b = new a(this, Looper.getMainLooper());
    }

    public static bn9 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return c;
        }
        return (bn9) invokeV.objValue;
    }

    public List<DownloadData> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return e;
        }
        return (List) invokeV.objValue;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            g(str, false);
        }
    }

    public void g(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
            DownloadData downloadData = d;
            if (downloadData != null && downloadData.getUrl().equals(str)) {
                if (z) {
                    this.a.b();
                    return;
                } else {
                    this.a.cancel(true);
                    return;
                }
            }
            LinkedList<DownloadData> linkedList = new LinkedList();
            Iterator<DownloadData> it = e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadData next = it.next();
                if (next.getUrl().equals(str)) {
                    next.setStatus(4);
                    if (next.getCallback() != null) {
                        next.getCallback().onFileUpdateProgress(next);
                    }
                    linkedList.add(next);
                }
            }
            for (DownloadData downloadData2 : linkedList) {
                e.remove(downloadData2);
            }
        }
    }

    public void h(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) == null) && downloadData != null) {
            g(downloadData.getUrl(), true);
            File GetFile = FileHelper.GetFile(downloadData.getId() + "_" + downloadData.getName() + ".tmp");
            if (GetFile != null) {
                GetFile.delete();
            }
        }
    }

    public void k(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, downloadData) != null) || downloadData == null) {
            return;
        }
        if (!FileHelper.checkSD()) {
            downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_no_sd));
            downloadData.setStatus(2);
        }
        if (downloadData.getStatus() == 2) {
            if (downloadData.getCallback() != null) {
                downloadData.getCallback().onFileUpdateProgress(downloadData);
                return;
            }
            return;
        }
        for (int i = 0; i < e.size(); i++) {
            DownloadData downloadData2 = e.get(i);
            if (downloadData2 != null && downloadData2.getUrl().equals(downloadData.getUrl()) && downloadData2.getId().equals(downloadData.getId())) {
                return;
            }
        }
        downloadData.setStatus(5);
        if (downloadData.getCallback() != null) {
            downloadData.getCallback().onFileUpdateProgress(downloadData);
        }
        e.add(downloadData);
        m();
    }

    public void l(DownloadData downloadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, downloadData, i) == null) {
            int type = downloadData.getType();
            int i2 = 0;
            for (DownloadData downloadData2 : e) {
                if (downloadData2.getType() == type) {
                    i2++;
                }
            }
            if (i2 >= i) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                if (downloadData.getCallback() != null) {
                    downloadData.getCallback().onFileUpdateProgress(downloadData);
                    return;
                }
                return;
            }
            k(downloadData);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && d == null && !e.isEmpty()) {
            DownloadData downloadData = e.get(0);
            d = downloadData;
            if (downloadData != null) {
                b bVar = new b(this);
                this.a = bVar;
                bVar.execute(d);
            }
        }
    }
}

package com.baidu.tieba;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.filedownloader.data.ApkDownloadData;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class an9 {
    public static /* synthetic */ Interceptable $ic;
    public static an9 c;
    public static DownloadData d;
    public static List<DownloadData> e;
    public static List<ka7> f;
    public static HashMap<String, Integer> g;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public HashMap<String, cn9> b;

    /* loaded from: classes5.dex */
    public class a extends ix5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;

        public a(an9 an9Var, DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {an9Var, downloadData};
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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.ix5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String str = this.a.getId() + "_" + this.a.getName() + ".tmp";
                File GetFile = FileHelper.GetFile(str);
                if (GetFile == null) {
                    GetFile = FileHelper.GetFileInCache(str);
                }
                FileHelper.deleteFileOrDir(GetFile);
                if (StringUtils.isNotNull(this.a.getId())) {
                    FileHelper.deleteFileOrDir(FileHelper.GetFile(this.a.getId().replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX));
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements mw5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;

        public b(an9 an9Var, DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {an9Var, downloadData};
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mw5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921626, this.a.getName()));
                List<ka7> g = zm9.i().g();
                if (!ListUtils.isEmpty(g)) {
                    this.a.setStatus(6);
                    this.a.setStatusMsg(null);
                    for (int i = 0; i < g.size(); i++) {
                        g.get(i).e(this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ka7 a;
        public final /* synthetic */ an9 b;

        public c(an9 an9Var, ka7 ka7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {an9Var, ka7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = an9Var;
            this.a = ka7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public DownloadData doInBackground(DownloadData... downloadDataArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadDataArr)) == null) {
                DownloadData downloadData = downloadDataArr[0];
                if (downloadData == null) {
                    return downloadData;
                }
                String id = downloadData.getId();
                String name = downloadData.getName();
                if (!ui.isEmpty(id) && !ui.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
                    String m = an9.m(str);
                    File GetFile = FileHelper.GetFile(str);
                    if (!isForceDownload && GetFile != null) {
                        ApkDownloadData apkDownloadData = downloadData.getApkDownloadData();
                        int source = downloadData.getSource();
                        DownloadData downloadData2 = new DownloadData(id);
                        downloadData2.setPath(m);
                        downloadData2.setSource(source);
                        downloadData2.setApkDownloadData(apkDownloadData);
                        downloadData2.setStatus(3);
                        return downloadData2;
                    }
                    downloadData.setCallback(new lh5());
                    downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                    downloadData.setType(12);
                    downloadData.setPath(m);
                    return downloadData;
                }
                return downloadData;
            }
            return (DownloadData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                super.onPostExecute(downloadData);
                this.b.a = null;
                if (downloadData != null) {
                    if (downloadData.getStatus() == 3) {
                        this.b.x(downloadData);
                        if (downloadData.isNeedInvokeApk()) {
                            if (downloadData.getApkDownloadData() != null) {
                                ez4.c().a(downloadData.getApkDownloadData().getPackageName(), downloadData.getName(), Integer.toString(downloadData.getSource()), downloadData.getUrl());
                            }
                            Application app = TbadkCoreApplication.getInst().getApp();
                            UtilHelper.install_apk(app, downloadData.getId().replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                        }
                    } else {
                        zm9.i().l(downloadData, this.a);
                        if (this.b.l(downloadData.getId(), downloadData.getName()) <= 0) {
                            if (downloadData.getDownloadStaticsData() != null) {
                                downloadData.getDownloadStaticsData().setDa_range("0");
                            }
                            if (downloadData.isNeedNotify()) {
                                String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                                cn9 cn9Var = new cn9(downloadData, 0);
                                this.b.b.put(downloadData.getUrl(), cn9Var);
                                Application app2 = TbadkCoreApplication.getInst().getApp();
                                int notifyId = downloadData.getNotifyId();
                                NotificationHelper.showProgressNotification(app2, notifyId, downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), this.b.j(downloadData.getAction()), false, cn9Var.b(), false);
                            }
                        } else if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                    }
                    DownloadData unused = an9.d = null;
                    if (!an9.e.isEmpty()) {
                        an9.e.remove(0);
                        if (!an9.f.isEmpty()) {
                            an9.f.remove(0);
                        }
                        this.b.z();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947621085, "Lcom/baidu/tieba/an9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947621085, "Lcom/baidu/tieba/an9;");
                return;
            }
        }
        e = new LinkedList();
        f = new LinkedList();
        g = new HashMap<>();
    }

    public an9() {
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
        this.b = new HashMap<>();
    }

    public static an9 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (an9.class) {
                if (c == null) {
                    c = new an9();
                }
            }
            return c;
        }
        return (an9) invokeV.objValue;
    }

    public void h(ka7 ka7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ka7Var) == null) {
            zm9.i().e(ka7Var);
        }
    }

    public void k(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, downloadData) != null) || downloadData == null) {
            return;
        }
        zm9.i().f(downloadData.getUrl(), true);
        mx5.b(new a(this, downloadData), new b(this, downloadData));
    }

    public final boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            TbadkApplication inst = TbadkApplication.getInst();
            if (inst == null) {
                return false;
            }
            try {
                if (inst.getPackageManager() == null) {
                    return false;
                }
                inst.getPackageManager().getPackageInfo(str, 64);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void w(ka7 ka7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ka7Var) == null) {
            zm9.i().j(ka7Var);
        }
    }

    public void x(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, downloadData) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(downloadData);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
        }
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(FileHelper.getCacheDir());
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            sb.append("/");
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static Integer p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (g.containsKey(str)) {
                return g.get(str);
            }
            Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
            g.put(str, valueOf);
            return valueOf;
        }
        return (Integer) invokeL.objValue;
    }

    public final PendingIntent j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Intent intent = new Intent(str);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
        }
        return (PendingIntent) invokeL.objValue;
    }

    public boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            for (DownloadData downloadData : zm9.i().h()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (FileHelper.GetFile(str.replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            for (DownloadData downloadData : zm9.i().h()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int q(DownloadData downloadData) {
        InterceptResult invokeL;
        int i;
        String id;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, downloadData)) == null) {
            if (o().u(downloadData.getId())) {
                i = 3;
            } else if (o().s(downloadData.getId())) {
                i = 5;
            } else if (o().v(downloadData.getId())) {
                i = 1;
            } else if (o().r(downloadData.getId(), downloadData.getName())) {
                i = 7;
            } else {
                i = 6;
            }
            DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
            if (downloadStaticsData != null) {
                id = downloadStaticsData.getApk_name();
            } else {
                id = downloadData.getId();
            }
            if (TextUtils.isEmpty(id)) {
                return i;
            }
            if (e36.a().k() && o().t(id)) {
                return 8;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) != null) || StringUtils.isNull(str)) {
            return;
        }
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : zm9.i().h()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                downloadData = downloadData2;
            }
        }
        zm9.i().f(str, false);
        if (downloadData != null && downloadData.isNeedNotify()) {
            int l = l(downloadData.getId(), downloadData.getName());
            String str3 = l + "%";
            if (downloadData != null && l >= 0) {
                cn9 cn9Var = this.b.get(downloadData.getUrl());
                if (cn9Var == null) {
                    cn9Var = new cn9(downloadData, l);
                }
                cn9Var.d();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), j(downloadData.getAction()), false, cn9Var.b(), false);
            }
        }
    }

    public int l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            long n = n(str, str2);
            long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
            if (0 == j) {
                return -1;
            }
            if (n > j) {
                return 0;
            }
            return (int) ((n * 100) / j);
        }
        return invokeLL.intValue;
    }

    public long n(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            String str3 = str + "_" + str2 + ".tmp";
            File GetFile = FileHelper.GetFile(str3);
            if (GetFile == null) {
                GetFile = FileHelper.GetFileInCache(str3);
            }
            if (GetFile != null && GetFile.exists() && GetFile.isFile()) {
                return GetFile.length();
            }
            return -1L;
        }
        return invokeLL.longValue;
    }

    public boolean r(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            if (TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) == 0) {
                return false;
            }
            String str3 = str + "_" + str2 + ".tmp";
            File GetFile = FileHelper.GetFile(str3);
            if (GetFile == null) {
                GetFile = FileHelper.GetFileInCache(str3);
            }
            if (GetFile == null || !GetFile.exists() || !GetFile.isFile()) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean y(DownloadData downloadData, ka7 ka7Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, downloadData, ka7Var)) == null) {
            if (downloadData == null) {
                return false;
            }
            List<DownloadData> h = zm9.i().h();
            if (h != null && h.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                x(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.download_fail_over_max);
                return false;
            }
            e.add(downloadData);
            f.add(ka7Var);
            z();
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && d == null && !e.isEmpty() && !f.isEmpty()) {
            DownloadData downloadData = e.get(0);
            d = downloadData;
            if (downloadData != null) {
                c cVar = new c(this, f.get(0));
                this.a = cVar;
                cVar.setPriority(3);
                this.a.execute(d);
            }
        }
    }
}

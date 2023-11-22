package com.baidu.tieba;

import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.downloadmanager.net.DownloadManagerHttpResponseMessage;
import com.baidu.tieba.downloadmanager.net.DownloadManagerNetModel;
import com.baidu.tieba.downloadmanager.net.DownloadManagerSocketResponseMessage;
import com.baidu.tieba.filedownloader.TbDownloadManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class cv6 extends av6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public int c;
    public boolean d;
    public final ArrayList<yu6> e;
    public final ArrayList<yu6> f;
    public final ArrayList<String> g;
    public dv6 h;
    public DownloadManagerNetModel i;
    public TbDownloadManager j;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cv6 cv6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cv6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof yu6)) {
                yu6 yu6Var = (yu6) customResponsedMessage.getData();
                cv6 cv6Var = this.a;
                if (cv6Var.s(cv6Var.e, yu6Var)) {
                    return;
                }
                yu6Var.f = true;
                this.a.e.add(0, yu6Var);
                if (this.a.h != null) {
                    this.a.h.a(this.a.e, this.a.f, 0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<nc5>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ cv6 b;

        public b(cv6 cv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cv6Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<nc5> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                super.onPostExecute(list);
                if (!this.a) {
                    new c(this.b, null).execute(list);
                } else {
                    this.b.w(list, true);
                }
            }
        }

        public final ItemData d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (StringUtils.isNull(str)) {
                    return null;
                }
                ItemData itemData = new ItemData();
                itemData.parseJson(str);
                return itemData;
            }
            return (ItemData) invokeL.objValue;
        }

        public /* synthetic */ b(cv6 cv6Var, a aVar) {
            this(cv6Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<nc5> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                ArrayList arrayList = null;
                hu6 m = this.b.r(null).m();
                List<rna> g = m.g();
                if (!ListUtils.isEmpty(g)) {
                    arrayList = new ArrayList(15);
                    if (this.b.b < g.size()) {
                        int i = this.b.b;
                        while (true) {
                            if (i >= g.size()) {
                                break;
                            }
                            rna rnaVar = g.get(i);
                            if (rnaVar != null) {
                                if (!StringUtils.isNull(rnaVar.g()) && !StringUtils.isNull(rnaVar.c())) {
                                    nc5 nc5Var = new nc5();
                                    nc5Var.a = rnaVar.g();
                                    rnaVar.q();
                                    nc5Var.d = rnaVar.p();
                                    nc5Var.c = rnaVar.c();
                                    ItemData d = d(rnaVar.c());
                                    nc5Var.b = d;
                                    if (d != null && d.apkDetail != null) {
                                        PackageInfo e = oj5.e(rnaVar.g());
                                        if (e != null && e.versionCode >= nc5Var.b.apkDetail.version_code.intValue()) {
                                            DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, 已安装数据不需要展示，删除数据库对应数据");
                                            m.c(rnaVar);
                                        } else {
                                            DownloadData downloadData = new DownloadData();
                                            downloadData.setId(rnaVar.r());
                                            if (d != null) {
                                                downloadData.setName(d.mTitle);
                                                downloadData.setItemData(d);
                                            }
                                            if (this.b.r(downloadData).q(downloadData) == 3 && !new File(this.b.r(downloadData).o(downloadData)).exists()) {
                                                DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, 已下载完成，但是没有安装包的，删除数据库对应数据");
                                                m.c(rnaVar);
                                            } else {
                                                cv6.k(this.b);
                                                arrayList.add(nc5Var);
                                                this.b.g.add(nc5Var.a);
                                                if (arrayList.size() >= 15) {
                                                    if (i < g.size()) {
                                                        this.a = true;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, apkDetail为空，删除数据库对应数据");
                                        m.c(rnaVar);
                                    }
                                } else {
                                    DefaultLog.getInstance().e("DownloadingModel", "GetDownloadMultiInfoTask, packageName或detailInfo为空，删除数据库对应数据");
                                    m.c(rnaVar);
                                }
                            }
                            i++;
                        }
                    } else {
                        return arrayList;
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<List<nc5>, Integer, List<nc5>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ cv6 b;

        public c(cv6 cv6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cv6Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<nc5> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) {
                return;
            }
            this.b.w(list, this.a);
        }

        public final ItemData d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                ItemData itemData = new ItemData();
                itemData.parseJson(str);
                return itemData;
            }
            return (ItemData) invokeL.objValue;
        }

        public /* synthetic */ c(cv6 cv6Var, a aVar) {
            this(cv6Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:77:0x0139 A[EDGE_INSN: B:77:0x0139->B:62:0x0139 ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0135 A[SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public List<nc5> doInBackground(List<nc5>... listArr) {
            InterceptResult invokeL;
            List<nc5> list;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, listArr)) == null) {
                List<nc5> d = zu6.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (listArr != null && listArr.length > 0) {
                    list = listArr[0];
                } else {
                    list = null;
                }
                if (!ListUtils.isEmpty(list)) {
                    i = list.size();
                } else {
                    i = 0;
                }
                if (this.b.c <= 0 || this.b.c < d.size()) {
                    int i2 = this.b.c;
                    while (i2 < d.size()) {
                        cv6.o(this.b);
                        nc5 nc5Var = d.get(i2);
                        ItemData d2 = d(nc5Var.c);
                        nc5Var.b = d2;
                        d2.isFromTbDownloaderTable = true;
                        if (this.b.u(list, nc5Var)) {
                            cv6.p(this.b);
                        } else if (nc5Var != null && !qd.isEmpty(nc5Var.a) && !qd.isEmpty(nc5Var.c)) {
                            ItemData itemData = nc5Var.b;
                            if (itemData != null && itemData.apkDetail != null) {
                                PackageInfo e = oj5.e(nc5Var.a);
                                if (e != null && e.versionCode >= nc5Var.b.apkDetail.version_code.intValue() && !yu6.e(nc5Var.d)) {
                                    zu6.e().c(nc5Var.a);
                                    cv6.p(this.b);
                                } else if (nc5Var.d == 2) {
                                    if (!kd5.q().s(nc5Var.a) && oj5.d(nc5Var.a, nc5Var.b.appId) == 6) {
                                        zu6.e().c(nc5Var.a);
                                        cv6.p(this.b);
                                    }
                                    arrayList.add(nc5Var);
                                    this.b.g.add(nc5Var.a);
                                    if (arrayList.size() + i < 15) {
                                        break;
                                    }
                                } else {
                                    DownloadData k = oj5.k(nc5Var.b);
                                    if (oj5.c(k) == 6 && !oj5.b(k) && !yu6.e(nc5Var.d)) {
                                        zu6.e().c(nc5Var.a);
                                        cv6.p(this.b);
                                    }
                                    arrayList.add(nc5Var);
                                    this.b.g.add(nc5Var.a);
                                    if (arrayList.size() + i < 15) {
                                    }
                                }
                            } else {
                                zu6.e().c(nc5Var.a);
                                cv6.p(this.b);
                            }
                        }
                        i2++;
                    }
                    if (!ListUtils.isEmpty(list)) {
                        arrayList.addAll(0, list);
                    }
                    if (arrayList.size() >= 15 && i2 < d.size()) {
                        this.a = true;
                    } else {
                        this.a = false;
                    }
                    return arrayList;
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cv6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        super(tbPageContext, bdUniqueId, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = 0;
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(tbPageContext, new gv6(1, i));
        this.i = downloadManagerNetModel;
        downloadManagerNetModel.q0(this);
        this.i.setUniqueId(bdUniqueId);
        t(bdUniqueId);
    }

    public static /* synthetic */ int k(cv6 cv6Var) {
        int i = cv6Var.b;
        cv6Var.b = i + 1;
        return i;
    }

    public static /* synthetic */ int o(cv6 cv6Var) {
        int i = cv6Var.c;
        cv6Var.c = i + 1;
        return i;
    }

    public static /* synthetic */ int p(cv6 cv6Var) {
        int i = cv6Var.c;
        cv6Var.c = i - 1;
        return i;
    }

    @Override // com.baidu.tieba.av6
    public void d(dv6 dv6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dv6Var) == null) {
            this.h = dv6Var;
        }
    }

    public final void t(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            a aVar = new a(this, 2921627);
            aVar.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void I(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.d = false;
            if (mvcHttpResponsedMessage == null) {
                return;
            }
            hv6 hv6Var = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                hv6Var = (hv6) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (hv6Var != null && y(hv6Var)) {
                return;
            }
            x();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void v(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.d = false;
            if (mvcSocketResponsedMessage == null) {
                return;
            }
            hv6 hv6Var = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                hv6Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (hv6Var != null && y(hv6Var)) {
                return;
            }
            x();
        }
    }

    @Override // com.baidu.tieba.av6
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.d) {
            return;
        }
        q();
    }

    @Override // com.baidu.tieba.av6
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.d) {
            return;
        }
        this.b = 0;
        this.c = 0;
        this.e.clear();
        this.f.clear();
        q();
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.d = true;
            new b(this, null).execute(new Integer[0]);
        }
    }

    public final void x() {
        dv6 dv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (dv6Var = this.h) != null) {
            dv6Var.a(this.e, null, 0);
        }
    }

    public TbDownloadManager r(DownloadData downloadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, downloadData)) == null) {
            if (this.j == null) {
                this.j = new TbDownloadManager();
            }
            if (downloadData != null && downloadData.getItemData() != null) {
                if (downloadData.getItemData().isFromTbDownloaderTable) {
                    this.j.w(1);
                } else if (downloadData.getItemData().mTbFileDownloaderType > 0) {
                    this.j.w(downloadData.getItemData().mTbFileDownloaderType);
                }
            }
            return this.j;
        }
        return (TbDownloadManager) invokeL.objValue;
    }

    public final boolean y(hv6 hv6Var) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, hv6Var)) == null) {
            if (hv6Var == null) {
                return false;
            }
            if (!ListUtils.isEmpty(hv6Var.b)) {
                for (yu6 yu6Var : hv6Var.b) {
                    if (yu6Var != null && (itemData = yu6Var.a) != null && !this.g.contains(itemData.pkgName) && oj5.e(yu6Var.a.pkgName) == null) {
                        this.f.add(yu6Var);
                    }
                }
            }
            dv6 dv6Var = this.h;
            if (dv6Var != null) {
                dv6Var.a(this.e, this.f, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean s(ArrayList<yu6> arrayList, yu6 yu6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, arrayList, yu6Var)) == null) {
            Iterator<yu6> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().d(yu6Var)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean u(List<nc5> list, nc5 nc5Var) {
        InterceptResult invokeLL;
        ItemData itemData;
        ItemData itemData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, nc5Var)) == null) {
            if (!ListUtils.isEmpty(list) && nc5Var != null) {
                for (int i = 0; i < list.size(); i++) {
                    nc5 nc5Var2 = list.get(i);
                    if (nc5Var2 != null && (itemData = nc5Var2.b) != null && (itemData2 = nc5Var.b) != null && itemData.itemId == itemData2.itemId) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void w(List<nc5> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (nc5 nc5Var : list) {
                if (nc5Var != null && nc5Var.b != null) {
                    yu6 b2 = yu6.b(nc5Var);
                    b2.f = true;
                    arrayList.add(b2);
                }
            }
            this.e.addAll(arrayList);
            if (ListUtils.getCount(this.e) <= 4) {
                this.i.loadData();
                return;
            }
            this.d = false;
            dv6 dv6Var = this.h;
            if (dv6Var != null) {
                dv6Var.a(this.e, null, z ? 1 : 0);
            }
        }
    }
}

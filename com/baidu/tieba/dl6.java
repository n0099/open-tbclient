package com.baidu.tieba;

import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class dl6 extends bl6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public boolean c;
    public final ArrayList<zk6> d;
    public final ArrayList<zk6> e;
    public final ArrayList<String> f;
    public el6 g;
    public DownloadManagerNetModel h;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dl6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dl6 dl6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl6Var, Integer.valueOf(i)};
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
            this.a = dl6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof zk6)) {
                zk6 zk6Var = (zk6) customResponsedMessage.getData();
                dl6 dl6Var = this.a;
                if (dl6Var.o(dl6Var.d, zk6Var)) {
                    return;
                }
                this.a.d.add(0, zk6Var);
                dl6.h(this.a);
                if (this.a.g != null) {
                    this.a.g.a(this.a.d, this.a.e, 0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<ia5>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ dl6 b;

        public b(dl6 dl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dl6Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<ia5> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) {
                return;
            }
            this.b.q(list, this.a);
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

        public /* synthetic */ b(dl6 dl6Var, a aVar) {
            this(dl6Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0103 A[EDGE_INSN: B:60:0x0103->B:48:0x0103 ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00ff A[SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public List<ia5> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                List<ia5> d = al6.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (this.b.b < d.size()) {
                    int i = this.b.b;
                    while (i < d.size()) {
                        dl6.h(this.b);
                        ia5 ia5Var = d.get(i);
                        if (ia5Var != null && !gi.isEmpty(ia5Var.a) && !gi.isEmpty(ia5Var.c)) {
                            ItemData d2 = d(ia5Var.c);
                            ia5Var.b = d2;
                            if (d2 != null && d2.apkDetail != null) {
                                PackageInfo e = cf5.e(ia5Var.a);
                                if (e != null && e.versionCode >= ia5Var.b.apkDetail.version_code.intValue() && ia5Var.d != 3) {
                                    al6.e().c(ia5Var.a);
                                    dl6.i(this.b);
                                } else if (ia5Var.d == 2) {
                                    if (!eb5.q().s(ia5Var.a) && cf5.d(ia5Var.a, ia5Var.b.appId) == 6) {
                                        al6.e().c(ia5Var.a);
                                        dl6.i(this.b);
                                    }
                                    arrayList.add(ia5Var);
                                    this.b.f.add(ia5Var.a);
                                    if (arrayList.size() < 15) {
                                        break;
                                    }
                                } else {
                                    DownloadData j = cf5.j(ia5Var.b);
                                    if (cf5.c(j) == 6 && !cf5.b(j.getId()) && ia5Var.d != 3) {
                                        al6.e().c(ia5Var.a);
                                        dl6.i(this.b);
                                    }
                                    arrayList.add(ia5Var);
                                    this.b.f.add(ia5Var.a);
                                    if (arrayList.size() < 15) {
                                    }
                                }
                            } else {
                                al6.e().c(ia5Var.a);
                                dl6.i(this.b);
                            }
                        }
                        i++;
                    }
                    if (arrayList.size() >= 15 && i < d.size()) {
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
    public dl6(BaseFragment baseFragment, int i) {
        super(baseFragment, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BaseFragment) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), new hl6(1, i));
        this.h = downloadManagerNetModel;
        downloadManagerNetModel.t0(this);
        this.h.setUniqueId(baseFragment.getUniqueId());
        p(baseFragment);
    }

    public static /* synthetic */ int h(dl6 dl6Var) {
        int i = dl6Var.b;
        dl6Var.b = i + 1;
        return i;
    }

    public static /* synthetic */ int i(dl6 dl6Var) {
        int i = dl6Var.b;
        dl6Var.b = i - 1;
        return i;
    }

    @Override // com.baidu.tieba.bl6
    public void d(el6 el6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, el6Var) == null) {
            this.g = el6Var;
        }
    }

    public final void p(BaseFragment baseFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, baseFragment) == null) {
            a aVar = new a(this, 2921627);
            aVar.setTag(baseFragment.getUniqueId());
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void F(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.c = false;
            if (mvcHttpResponsedMessage == null) {
                return;
            }
            il6 il6Var = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                il6Var = (il6) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (il6Var != null && s(il6Var)) {
                return;
            }
            r();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void u(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.c = false;
            if (mvcSocketResponsedMessage == null) {
                return;
            }
            il6 il6Var = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                il6Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (il6Var != null && s(il6Var)) {
                return;
            }
            r();
        }
    }

    @Override // com.baidu.tieba.bl6
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c) {
            return;
        }
        n();
    }

    @Override // com.baidu.tieba.bl6
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.c) {
            return;
        }
        this.b = 0;
        this.d.clear();
        this.e.clear();
        n();
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = true;
            new b(this, null).execute(new Integer[0]);
        }
    }

    public final void r() {
        el6 el6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (el6Var = this.g) != null) {
            el6Var.a(this.d, null, 0);
        }
    }

    public final boolean o(ArrayList<zk6> arrayList, zk6 zk6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, arrayList, zk6Var)) == null) {
            Iterator<zk6> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().f(zk6Var)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(List<ia5> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (ia5 ia5Var : list) {
                if (ia5Var != null && ia5Var.b != null) {
                    arrayList.add(zk6.b(ia5Var));
                }
            }
            this.d.addAll(arrayList);
            if (ListUtils.getCount(this.d) <= 4) {
                this.h.loadData();
                return;
            }
            this.c = false;
            el6 el6Var = this.g;
            if (el6Var != null) {
                el6Var.a(this.d, null, z ? 1 : 0);
            }
        }
    }

    public final boolean s(il6 il6Var) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, il6Var)) == null) {
            if (il6Var == null) {
                return false;
            }
            if (!ListUtils.isEmpty(il6Var.b)) {
                for (zk6 zk6Var : il6Var.b) {
                    if (zk6Var != null && (itemData = zk6Var.a) != null && !this.f.contains(itemData.pkgName) && cf5.e(zk6Var.a.pkgName) == null) {
                        this.e.add(zk6Var);
                    }
                }
            }
            el6 el6Var = this.g;
            if (el6Var != null) {
                el6Var.a(this.d, this.e, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}

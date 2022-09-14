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
/* loaded from: classes3.dex */
public class b76 extends z66 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public boolean c;
    public final ArrayList<x66> d;
    public final ArrayList<x66> e;
    public final ArrayList<String> f;
    public c76 g;
    public DownloadManagerNetModel h;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b76 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b76 b76Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b76Var, Integer.valueOf(i)};
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
            this.a = b76Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof x66)) {
                x66 x66Var = (x66) customResponsedMessage.getData();
                b76 b76Var = this.a;
                if (b76Var.p(b76Var.d, x66Var)) {
                    return;
                }
                this.a.d.add(0, x66Var);
                b76.h(this.a);
                if (this.a.g != null) {
                    this.a.g.a(this.a.d, this.a.e, 0);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b76(BaseFragment baseFragment, int i) {
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
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(baseFragment.getPageContext(), new f76(1, i));
        this.h = downloadManagerNetModel;
        downloadManagerNetModel.b0(this);
        this.h.setUniqueId(baseFragment.getUniqueId());
        q(baseFragment);
    }

    public static /* synthetic */ int h(b76 b76Var) {
        int i = b76Var.b;
        b76Var.b = i + 1;
        return i;
    }

    public static /* synthetic */ int i(b76 b76Var) {
        int i = b76Var.b;
        b76Var.b = i - 1;
        return i;
    }

    @Override // com.baidu.tieba.z66
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.c) {
            return;
        }
        o();
    }

    @Override // com.baidu.tieba.z66
    public void c() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.c) {
            return;
        }
        this.b = 0;
        this.d.clear();
        this.e.clear();
        o();
    }

    @Override // com.baidu.tieba.z66
    public void d(c76 c76Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c76Var) == null) {
            this.g = c76Var;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.c = false;
            if (mvcSocketResponsedMessage == null) {
                return;
            }
            g76 g76Var = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                g76Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (g76Var == null || !u(g76Var)) {
                t();
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c = true;
            new b(this, null).execute(new Integer[0]);
        }
    }

    public final boolean p(ArrayList<x66> arrayList, x66 x66Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, arrayList, x66Var)) == null) {
            Iterator<x66> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().f(x66Var)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(BaseFragment baseFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, baseFragment) == null) {
            a aVar = new a(this, 2921627);
            aVar.setTag(baseFragment.getUniqueId());
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    public final void r(List<r35> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (r35 r35Var : list) {
                if (r35Var != null && r35Var.b != null) {
                    arrayList.add(x66.b(r35Var));
                }
            }
            this.d.addAll(arrayList);
            if (ListUtils.getCount(this.d) <= 4) {
                this.h.loadData();
                return;
            }
            this.c = false;
            c76 c76Var = this.g;
            if (c76Var != null) {
                c76Var.a(this.d, null, z ? 1 : 0);
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void s(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.c = false;
            if (mvcHttpResponsedMessage == null) {
                return;
            }
            g76 g76Var = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                g76Var = (g76) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (g76Var == null || !u(g76Var)) {
                t();
            }
        }
    }

    public final void t() {
        c76 c76Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (c76Var = this.g) == null) {
            return;
        }
        c76Var.a(this.d, null, 0);
    }

    public final boolean u(g76 g76Var) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, g76Var)) == null) {
            if (g76Var == null) {
                return false;
            }
            if (!ListUtils.isEmpty(g76Var.b)) {
                for (x66 x66Var : g76Var.b) {
                    if (x66Var != null && (itemData = x66Var.a) != null && !this.f.contains(itemData.pkgName) && k85.e(x66Var.a.pkgName) == null) {
                        this.e.add(x66Var);
                    }
                }
            }
            c76 c76Var = this.g;
            if (c76Var != null) {
                c76Var.a(this.d, this.e, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<r35>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ b76 b;

        public b(b76 b76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b76Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<r35> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                List<r35> d = y66.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (this.b.b >= d.size()) {
                    return arrayList;
                }
                int i = this.b.b;
                while (i < d.size()) {
                    b76.h(this.b);
                    r35 r35Var = d.get(i);
                    if (r35Var != null && !dj.isEmpty(r35Var.a) && !dj.isEmpty(r35Var.c)) {
                        ItemData d2 = d(r35Var.c);
                        r35Var.b = d2;
                        if (d2 != null && d2.apkDetail != null) {
                            PackageInfo e = k85.e(r35Var.a);
                            if (e != null && e.versionCode >= r35Var.b.apkDetail.version_code.intValue()) {
                                y66.e().c(r35Var.a);
                                b76.i(this.b);
                            } else {
                                DownloadData j = k85.j(r35Var.b);
                                if (k85.c(j) == 6 && !k85.b(j.getId()) && r35Var.d != 2) {
                                    y66.e().c(r35Var.a);
                                    b76.i(this.b);
                                } else if (r35Var.d == 2 && !n45.q().s(r35Var.a) && k85.d(r35Var.a, r35Var.b.appId) == 6) {
                                    y66.e().c(r35Var.a);
                                    b76.i(this.b);
                                } else {
                                    arrayList.add(r35Var);
                                    this.b.f.add(r35Var.a);
                                    if (arrayList.size() >= 15) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            y66.e().c(r35Var.a);
                            b76.i(this.b);
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
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<r35> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.b.r(list, this.a);
            }
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

        public /* synthetic */ b(b76 b76Var, a aVar) {
            this(b76Var);
        }
    }
}

package com.baidu.tieba;

import android.content.pm.PackageInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class fw6 extends dw6 implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public boolean c;
    public final ArrayList<bw6> d;
    public final ArrayList<bw6> e;
    public final ArrayList<String> f;
    public gw6 g;
    public DownloadManagerNetModel h;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fw6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fw6 fw6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw6Var, Integer.valueOf(i)};
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
            this.a = fw6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof bw6)) {
                bw6 bw6Var = (bw6) customResponsedMessage.getData();
                fw6 fw6Var = this.a;
                if (fw6Var.o(fw6Var.d, bw6Var)) {
                    return;
                }
                this.a.d.add(0, bw6Var);
                fw6.h(this.a);
                if (this.a.g != null) {
                    this.a.g.a(this.a.d, this.a.e, 0);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Integer, Integer, List<ig5>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ fw6 b;

        public b(fw6 fw6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fw6Var;
            this.a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<ig5> list) {
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

        public /* synthetic */ b(fw6 fw6Var, a aVar) {
            this(fw6Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:60:0x010a A[EDGE_INSN: B:60:0x010a->B:48:0x010a ?: BREAK  , SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0106 A[SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public List<ig5> doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, numArr)) == null) {
                List<ig5> d = cw6.e().d();
                ArrayList arrayList = new ArrayList(15);
                if (this.b.b < d.size()) {
                    int i = this.b.b;
                    while (i < d.size()) {
                        fw6.h(this.b);
                        ig5 ig5Var = d.get(i);
                        if (ig5Var != null && !bi.isEmpty(ig5Var.a) && !bi.isEmpty(ig5Var.c)) {
                            ItemData d2 = d(ig5Var.c);
                            ig5Var.b = d2;
                            if (d2 != null && d2.apkDetail != null) {
                                PackageInfo e = gm5.e(ig5Var.a);
                                if (e != null && e.versionCode >= ig5Var.b.apkDetail.version_code.intValue() && !bw6.e(ig5Var.d)) {
                                    cw6.e().c(ig5Var.a);
                                    fw6.i(this.b);
                                } else if (ig5Var.d == 2) {
                                    if (!eh5.q().s(ig5Var.a) && gm5.d(ig5Var.a, ig5Var.b.appId) == 6) {
                                        cw6.e().c(ig5Var.a);
                                        fw6.i(this.b);
                                    }
                                    arrayList.add(ig5Var);
                                    this.b.f.add(ig5Var.a);
                                    if (arrayList.size() < 15) {
                                        break;
                                    }
                                } else {
                                    DownloadData j = gm5.j(ig5Var.b);
                                    if (gm5.c(j) == 6 && !gm5.b(j.getId()) && !bw6.e(ig5Var.d)) {
                                        cw6.e().c(ig5Var.a);
                                        fw6.i(this.b);
                                    }
                                    arrayList.add(ig5Var);
                                    this.b.f.add(ig5Var.a);
                                    if (arrayList.size() < 15) {
                                    }
                                }
                            } else {
                                cw6.e().c(ig5Var.a);
                                fw6.i(this.b);
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
    public fw6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
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
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        DownloadManagerNetModel downloadManagerNetModel = new DownloadManagerNetModel(tbPageContext, new jw6(1, i));
        this.h = downloadManagerNetModel;
        downloadManagerNetModel.p0(this);
        this.h.setUniqueId(bdUniqueId);
        p(bdUniqueId);
    }

    public static /* synthetic */ int h(fw6 fw6Var) {
        int i = fw6Var.b;
        fw6Var.b = i + 1;
        return i;
    }

    public static /* synthetic */ int i(fw6 fw6Var) {
        int i = fw6Var.b;
        fw6Var.b = i - 1;
        return i;
    }

    @Override // com.baidu.tieba.dw6
    public void d(gw6 gw6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gw6Var) == null) {
            this.g = gw6Var;
        }
    }

    public final void p(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            a aVar = new a(this, 2921627);
            aVar.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(aVar);
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void H(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) {
            this.c = false;
            if (mvcHttpResponsedMessage == null) {
                return;
            }
            kw6 kw6Var = null;
            if (!mvcHttpResponsedMessage.hasError() && (mvcHttpResponsedMessage instanceof DownloadManagerHttpResponseMessage)) {
                kw6Var = (kw6) ((DownloadManagerHttpResponseMessage) mvcHttpResponsedMessage).getData();
            }
            if (kw6Var != null && s(kw6Var)) {
                return;
            }
            r();
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void v(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) {
            this.c = false;
            if (mvcSocketResponsedMessage == null) {
                return;
            }
            kw6 kw6Var = null;
            if (!mvcSocketResponsedMessage.hasError() && (mvcSocketResponsedMessage instanceof DownloadManagerSocketResponseMessage)) {
                kw6Var = ((DownloadManagerSocketResponseMessage) mvcSocketResponsedMessage).getData();
            }
            if (kw6Var != null && s(kw6Var)) {
                return;
            }
            r();
        }
    }

    @Override // com.baidu.tieba.dw6
    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.c) {
            return;
        }
        n();
    }

    @Override // com.baidu.tieba.dw6
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
        gw6 gw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (gw6Var = this.g) != null) {
            gw6Var.a(this.d, null, 0);
        }
    }

    public final boolean o(ArrayList<bw6> arrayList, bw6 bw6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, arrayList, bw6Var)) == null) {
            Iterator<bw6> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().d(bw6Var)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(List<ig5> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, list, z) == null) {
            ArrayList arrayList = new ArrayList();
            for (ig5 ig5Var : list) {
                if (ig5Var != null && ig5Var.b != null) {
                    arrayList.add(bw6.b(ig5Var));
                }
            }
            this.d.addAll(arrayList);
            if (ListUtils.getCount(this.d) <= 4) {
                this.h.loadData();
                return;
            }
            this.c = false;
            gw6 gw6Var = this.g;
            if (gw6Var != null) {
                gw6Var.a(this.d, null, z ? 1 : 0);
            }
        }
    }

    public final boolean s(kw6 kw6Var) {
        InterceptResult invokeL;
        ItemData itemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, kw6Var)) == null) {
            if (kw6Var == null) {
                return false;
            }
            if (!ListUtils.isEmpty(kw6Var.b)) {
                for (bw6 bw6Var : kw6Var.b) {
                    if (bw6Var != null && (itemData = bw6Var.a) != null && !this.f.contains(itemData.pkgName) && gm5.e(bw6Var.a.pkgName) == null) {
                        this.e.add(bw6Var);
                    }
                }
            }
            gw6 gw6Var = this.g;
            if (gw6Var != null) {
                gw6Var.a(this.d, this.e, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}

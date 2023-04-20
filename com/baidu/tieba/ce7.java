package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class ce7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public un c;
    public List<vm> d;
    public List<vm> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<in> g;
    public FrsViewData h;
    public CustomMessageListener i;

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce7 a;

        public a(ce7 ce7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ce7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.getAdapter().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ce7 ce7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ce7Var, Integer.valueOf(i)};
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
            this.a = ce7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                ce7 ce7Var = this.a;
                ce7Var.g(ce7Var.b);
                ce7 ce7Var2 = this.a;
                ce7Var2.p(ce7Var2.g, this.a.h);
            }
        }
    }

    public ce7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsNewAreaFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new LinkedList();
        this.i = new b(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.b = bdTypeRecyclerView;
        this.c = new un(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<in> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            zk9.f(arrayList, 1);
            i(arrayList);
            this.b.setData(arrayList);
            this.g = arrayList;
            this.h = frsViewData;
            u();
        }
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.d = new ArrayList();
                ArrayList<BdUniqueId> g = zk9.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        z47<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = t47.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
                        if (b2 != null) {
                            this.e.add(b2);
                            this.d.add(b2);
                        }
                    }
                    if (!ListUtils.isEmpty(this.d)) {
                        bdTypeRecyclerView.addAdapters(this.d);
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (HashMap) invokeV.objValue;
    }

    public List<in> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (List) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.e(new a(this));
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.setData(this.g);
            l();
        }
    }

    public final void i(ArrayList<in> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                in inVar = arrayList.get(i);
                if ((inVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(inVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) inVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (vm vmVar : this.e) {
                if (vmVar instanceof z47) {
                    ((z47) vmVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (vm vmVar : this.e) {
                if (vmVar instanceof z47) {
                    ((z47) vmVar).A(frsViewData);
                }
            }
        }
    }

    public void t(sn snVar) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, snVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (vm vmVar : this.e) {
                if (vmVar != null && (vmVar instanceof z47)) {
                    ((z47) vmVar).setOnAdapterItemClickListener(snVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            k97 k97Var = new k97(frsNewAreaFragment.q(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            k97Var.C(bdTypeRecyclerView);
            w87 w87Var = new w87(frsNewAreaFragment.q(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            w87Var.C(bdTypeRecyclerView);
            h97 h97Var = new h97(frsNewAreaFragment.q(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            h97Var.C(bdTypeRecyclerView);
            e97 e97Var = new e97(frsNewAreaFragment.q(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            e97Var.C(bdTypeRecyclerView);
            v87 v87Var = new v87(frsNewAreaFragment.q(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            v87Var.C(bdTypeRecyclerView);
            y87 y87Var = new y87(frsNewAreaFragment.q(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            y87Var.C(bdTypeRecyclerView);
            m97 m97Var = new m97(frsNewAreaFragment.q(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            m97Var.C(bdTypeRecyclerView);
            i97 i97Var = new i97(frsNewAreaFragment.q(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            i97Var.C(bdTypeRecyclerView);
            g97 g97Var = new g97(frsNewAreaFragment.q(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            d97 d97Var = new d97(frsNewAreaFragment.q(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            l97 l97Var = new l97(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            l97Var.C(bdTypeRecyclerView);
            x87 x87Var = new x87(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            x87Var.C(bdTypeRecyclerView);
            b97 b97Var = new b97(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            b97Var.C(bdTypeRecyclerView);
            l87 l87Var = new l87(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            l87Var.C(bdTypeRecyclerView);
            r87 r87Var = new r87(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            r87Var.C(bdTypeRecyclerView);
            s87 s87Var = new s87(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            s87Var.C(bdTypeRecyclerView);
            f97 f97Var = new f97(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            f97Var.C(bdTypeRecyclerView);
            l97 l97Var2 = new l97(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            l97Var2.C(bdTypeRecyclerView);
            g57 g57Var = new g57(frsNewAreaFragment.getPageContext(), h57.b);
            g57Var.C(bdTypeRecyclerView);
            vm<? extends pz4, ? extends TypeAdapter.ViewHolder> a2 = t47.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            vm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = t47.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            vm<?, ?> d2 = db9.l().d(this.a, AdvertAppInfo.w);
            vm<?, ?> d3 = db9.l().d(this.a, AdvertAppInfo.z);
            j97 j97Var = new j97(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            j97Var.C(bdTypeRecyclerView);
            p87 p87Var = new p87(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            p87Var.x(bdTypeRecyclerView);
            j87 j87Var = new j87(frsNewAreaFragment.q(), wz5.g);
            this.e.add(k97Var);
            this.e.add(w87Var);
            this.e.add(h97Var);
            this.e.add(e97Var);
            this.e.add(v87Var);
            this.e.add(y87Var);
            this.e.add(i97Var);
            this.e.add(m97Var);
            this.e.add(g97Var);
            this.e.add(d97Var);
            this.e.add(l97Var);
            this.e.add(b97Var);
            this.e.add(l87Var);
            this.e.add(r87Var);
            this.e.add(s87Var);
            this.e.add(f97Var);
            this.e.add(g57Var);
            this.e.add(x87Var);
            this.e.add(l97Var2);
            this.e.add(j97Var);
            this.e.add(p87Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(d2);
            this.e.add(d3);
            this.e.add(j87Var);
            this.e.add(new o87(frsNewAreaFragment.getPageContext()));
            vm<?, ?> d4 = fk7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            vm<?, ?> d5 = fk7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.e.add(d4);
            this.e.add(d5);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<vm<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    vm<?, ?> next = it.next();
                    if (next instanceof z47) {
                        ((z47) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<vm> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            nx5 nx5Var = new nx5(this.a, 1);
            nx5Var.u(this.e);
            nx5Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, nx5Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (vm vmVar : this.e) {
                if (vmVar instanceof z47) {
                    ((z47) vmVar).x();
                } else if (vmVar instanceof ua9) {
                    ((ua9) vmVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (vm vmVar : this.e) {
            if (vmVar instanceof z47) {
                ((z47) vmVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        yf7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (vm vmVar : this.e) {
            if ((vmVar instanceof ag7) && (i = ((ag7) vmVar).i()) != null) {
                if (this.h.needLog == 1) {
                    i.a = true;
                } else {
                    i.a = false;
                }
                if (this.h.getForum() != null) {
                    i.c = this.h.getForum().getId();
                    i.d = this.h.getForum().getName();
                }
            }
        }
    }

    public void v() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getData() != null && this.b.getData().size() != 0) {
            for (in inVar : this.b.getData()) {
                if (inVar instanceof pz4) {
                    pz4 pz4Var = (pz4) inVar;
                    if (pz4Var.t.getIs_top() != 0) {
                        pz4Var.t.parser_title();
                    }
                }
            }
        }
    }
}

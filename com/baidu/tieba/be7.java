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
public class be7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public tn c;
    public List<um> d;
    public List<um> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<hn> g;
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
        public final /* synthetic */ be7 a;

        public a(be7 be7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = be7Var;
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
        public final /* synthetic */ be7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(be7 be7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {be7Var, Integer.valueOf(i)};
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
            this.a = be7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                be7 be7Var = this.a;
                be7Var.g(be7Var.b);
                be7 be7Var2 = this.a;
                be7Var2.p(be7Var2.g, this.a.h);
            }
        }
    }

    public be7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new tn(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<hn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            rk9.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = rk9.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        y47<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = s47.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public List<hn> j() {
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

    public final void i(ArrayList<hn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                hn hnVar = arrayList.get(i);
                if ((hnVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(hnVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) hnVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<um> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (um umVar : this.e) {
                if (umVar instanceof y47) {
                    ((y47) umVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<um> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (um umVar : this.e) {
                if (umVar instanceof y47) {
                    ((y47) umVar).A(frsViewData);
                }
            }
        }
    }

    public void t(rn rnVar) {
        List<um> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, rnVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (um umVar : this.e) {
                if (umVar != null && (umVar instanceof y47)) {
                    ((y47) umVar).setOnAdapterItemClickListener(rnVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            j97 j97Var = new j97(frsNewAreaFragment.q(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            j97Var.C(bdTypeRecyclerView);
            v87 v87Var = new v87(frsNewAreaFragment.q(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            v87Var.C(bdTypeRecyclerView);
            g97 g97Var = new g97(frsNewAreaFragment.q(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            g97Var.C(bdTypeRecyclerView);
            d97 d97Var = new d97(frsNewAreaFragment.q(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            d97Var.C(bdTypeRecyclerView);
            u87 u87Var = new u87(frsNewAreaFragment.q(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            u87Var.C(bdTypeRecyclerView);
            x87 x87Var = new x87(frsNewAreaFragment.q(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            x87Var.C(bdTypeRecyclerView);
            l97 l97Var = new l97(frsNewAreaFragment.q(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            l97Var.C(bdTypeRecyclerView);
            h97 h97Var = new h97(frsNewAreaFragment.q(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            h97Var.C(bdTypeRecyclerView);
            f97 f97Var = new f97(frsNewAreaFragment.q(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            c97 c97Var = new c97(frsNewAreaFragment.q(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            k97 k97Var = new k97(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            k97Var.C(bdTypeRecyclerView);
            w87 w87Var = new w87(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            w87Var.C(bdTypeRecyclerView);
            a97 a97Var = new a97(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            a97Var.C(bdTypeRecyclerView);
            k87 k87Var = new k87(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            k87Var.C(bdTypeRecyclerView);
            q87 q87Var = new q87(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            q87Var.C(bdTypeRecyclerView);
            r87 r87Var = new r87(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            r87Var.C(bdTypeRecyclerView);
            e97 e97Var = new e97(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            e97Var.C(bdTypeRecyclerView);
            k97 k97Var2 = new k97(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            k97Var2.C(bdTypeRecyclerView);
            f57 f57Var = new f57(frsNewAreaFragment.getPageContext(), g57.b);
            f57Var.C(bdTypeRecyclerView);
            um<? extends oz4, ? extends TypeAdapter.ViewHolder> a2 = s47.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            um<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = s47.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            um<?, ?> d2 = va9.l().d(this.a, AdvertAppInfo.w);
            um<?, ?> d3 = va9.l().d(this.a, AdvertAppInfo.z);
            i97 i97Var = new i97(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            i97Var.C(bdTypeRecyclerView);
            o87 o87Var = new o87(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            o87Var.x(bdTypeRecyclerView);
            i87 i87Var = new i87(frsNewAreaFragment.q(), vz5.g);
            this.e.add(j97Var);
            this.e.add(v87Var);
            this.e.add(g97Var);
            this.e.add(d97Var);
            this.e.add(u87Var);
            this.e.add(x87Var);
            this.e.add(h97Var);
            this.e.add(l97Var);
            this.e.add(f97Var);
            this.e.add(c97Var);
            this.e.add(k97Var);
            this.e.add(a97Var);
            this.e.add(k87Var);
            this.e.add(q87Var);
            this.e.add(r87Var);
            this.e.add(e97Var);
            this.e.add(f57Var);
            this.e.add(w87Var);
            this.e.add(k97Var2);
            this.e.add(i97Var);
            this.e.add(o87Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(d2);
            this.e.add(d3);
            this.e.add(i87Var);
            this.e.add(new n87(frsNewAreaFragment.getPageContext()));
            um<?, ?> d4 = ek7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            um<?, ?> d5 = ek7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.e.add(d4);
            this.e.add(d5);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<um<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    um<?, ?> next = it.next();
                    if (next instanceof y47) {
                        ((y47) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<um> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            mx5 mx5Var = new mx5(this.a, 1);
            mx5Var.u(this.e);
            mx5Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, mx5Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (um umVar : this.e) {
                if (umVar instanceof y47) {
                    ((y47) umVar).x();
                } else if (umVar instanceof ma9) {
                    ((ma9) umVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (um umVar : this.e) {
            if (umVar instanceof y47) {
                ((y47) umVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        xf7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (um umVar : this.e) {
            if ((umVar instanceof zf7) && (i = ((zf7) umVar).i()) != null) {
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
            for (hn hnVar : this.b.getData()) {
                if (hnVar instanceof oz4) {
                    oz4 oz4Var = (oz4) hnVar;
                    if (oz4Var.t.getIs_top() != 0) {
                        oz4Var.t.parser_title();
                    }
                }
            }
        }
    }
}

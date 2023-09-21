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
/* loaded from: classes6.dex */
public class gs7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public nn c;
    public List<om> d;
    public List<om> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<bn> g;
    public FrsViewData h;
    public CustomMessageListener i;

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs7 a;

        public a(gs7 gs7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gs7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.getAdapter().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gs7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(gs7 gs7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gs7Var, Integer.valueOf(i)};
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
            this.a = gs7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                gs7 gs7Var = this.a;
                gs7Var.g(gs7Var.b);
                gs7 gs7Var2 = this.a;
                gs7Var2.p(gs7Var2.g, this.a.h);
            }
        }
    }

    public gs7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new nn(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<bn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            zia.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = zia.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        pi7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = ji7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public List<bn> j() {
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

    public final void i(ArrayList<bn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                bn bnVar = arrayList.get(i);
                if ((bnVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(bnVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) bnVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (om omVar : this.e) {
                if (omVar instanceof pi7) {
                    ((pi7) omVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (om omVar : this.e) {
                if (omVar instanceof pi7) {
                    ((pi7) omVar).A(frsViewData);
                }
            }
        }
    }

    public void t(ln lnVar) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, lnVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (om omVar : this.e) {
                if (omVar != null && (omVar instanceof pi7)) {
                    ((pi7) omVar).setOnAdapterItemClickListener(lnVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            hn7 hn7Var = new hn7(frsNewAreaFragment.C(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            hn7Var.C(bdTypeRecyclerView);
            tm7 tm7Var = new tm7(frsNewAreaFragment.C(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            tm7Var.C(bdTypeRecyclerView);
            en7 en7Var = new en7(frsNewAreaFragment.C(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            en7Var.C(bdTypeRecyclerView);
            bn7 bn7Var = new bn7(frsNewAreaFragment.C(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            bn7Var.C(bdTypeRecyclerView);
            sm7 sm7Var = new sm7(frsNewAreaFragment.C(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            sm7Var.C(bdTypeRecyclerView);
            vm7 vm7Var = new vm7(frsNewAreaFragment.C(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            vm7Var.C(bdTypeRecyclerView);
            jn7 jn7Var = new jn7(frsNewAreaFragment.C(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            jn7Var.C(bdTypeRecyclerView);
            fn7 fn7Var = new fn7(frsNewAreaFragment.C(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            fn7Var.C(bdTypeRecyclerView);
            dn7 dn7Var = new dn7(frsNewAreaFragment.C(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            an7 an7Var = new an7(frsNewAreaFragment.C(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            in7 in7Var = new in7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            in7Var.C(bdTypeRecyclerView);
            um7 um7Var = new um7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            um7Var.C(bdTypeRecyclerView);
            ym7 ym7Var = new ym7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            ym7Var.C(bdTypeRecyclerView);
            gm7 gm7Var = new gm7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            gm7Var.C(bdTypeRecyclerView);
            nm7 nm7Var = new nm7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            nm7Var.C(bdTypeRecyclerView);
            om7 om7Var = new om7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            om7Var.C(bdTypeRecyclerView);
            cn7 cn7Var = new cn7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            cn7Var.C(bdTypeRecyclerView);
            in7 in7Var2 = new in7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            in7Var2.C(bdTypeRecyclerView);
            wi7 wi7Var = new wi7(frsNewAreaFragment.getPageContext(), xi7.b);
            wi7Var.C(bdTypeRecyclerView);
            om<? extends h45, ? extends TypeAdapter.ViewHolder> a2 = ji7.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            om<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = ji7.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            om<?, ?> e = g5a.m().e(this.a, AdvertAppInfo.x);
            om<?, ?> e2 = g5a.m().e(this.a, AdvertAppInfo.A);
            gn7 gn7Var = new gn7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            gn7Var.C(bdTypeRecyclerView);
            lm7 lm7Var = new lm7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            lm7Var.x(bdTypeRecyclerView);
            rm7 rm7Var = new rm7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            dm7 dm7Var = new dm7(frsNewAreaFragment.C(), w66.g);
            km7 km7Var = new km7(frsNewAreaFragment.getPageContext(), iq6.A0);
            km7Var.u(bdTypeRecyclerView);
            pm7 pm7Var = new pm7(frsNewAreaFragment.getPageContext(), nq6.j);
            pm7Var.u(bdTypeRecyclerView);
            this.e.add(hn7Var);
            this.e.add(tm7Var);
            this.e.add(en7Var);
            this.e.add(bn7Var);
            this.e.add(sm7Var);
            this.e.add(vm7Var);
            this.e.add(fn7Var);
            this.e.add(jn7Var);
            this.e.add(dn7Var);
            this.e.add(an7Var);
            this.e.add(in7Var);
            this.e.add(ym7Var);
            this.e.add(gm7Var);
            this.e.add(nm7Var);
            this.e.add(om7Var);
            this.e.add(cn7Var);
            this.e.add(wi7Var);
            this.e.add(um7Var);
            this.e.add(in7Var2);
            this.e.add(gn7Var);
            this.e.add(lm7Var);
            this.e.add(rm7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(e);
            this.e.add(e2);
            this.e.add(dm7Var);
            this.e.add(new jm7(frsNewAreaFragment.getPageContext()));
            this.e.add(km7Var);
            this.e.add(pm7Var);
            om<?, ?> g = ly7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_new_tab");
            om<?, ?> g2 = ly7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            this.e.add(g);
            this.e.add(g2);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<om<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    om<?, ?> next = it.next();
                    if (next instanceof pi7) {
                        ((pi7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<om> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            m46 m46Var = new m46(this.a, 1);
            m46Var.u(this.e);
            m46Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, m46Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (om omVar : this.e) {
                if (omVar instanceof pi7) {
                    ((pi7) omVar).x();
                } else if (omVar instanceof w4a) {
                    ((w4a) omVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (om omVar : this.e) {
            if (omVar instanceof pi7) {
                ((pi7) omVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        wt7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (om omVar : this.e) {
            if ((omVar instanceof yt7) && (i = ((yt7) omVar).i()) != null) {
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
            for (bn bnVar : this.b.getData()) {
                if (bnVar instanceof h45) {
                    h45 h45Var = (h45) bnVar;
                    if (h45Var.t.getIs_top() != 0) {
                        h45Var.t.parser_title();
                    }
                }
            }
        }
    }
}

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
/* loaded from: classes4.dex */
public class g57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public sn c;
    public List<tm> d;
    public List<tm> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<gn> g;
    public FrsViewData h;
    public CustomMessageListener i;

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g57 a;

        public a(g57 g57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g57Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.getAdapter().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g57 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g57 g57Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g57Var, Integer.valueOf(i)};
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
            this.a = g57Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                g57 g57Var = this.a;
                g57Var.g(g57Var.b);
                g57 g57Var2 = this.a;
                g57Var2.p(g57Var2.g, this.a.h);
            }
        }
    }

    public g57(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new sn(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<gn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            ab9.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = ab9.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        ew6<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = yv6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public List<gn> j() {
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

    public final void i(ArrayList<gn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                gn gnVar = arrayList.get(i);
                if ((gnVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(gnVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) gnVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<tm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (tm tmVar : this.e) {
                if (tmVar instanceof ew6) {
                    ((ew6) tmVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<tm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (tm tmVar : this.e) {
                if (tmVar instanceof ew6) {
                    ((ew6) tmVar).A(frsViewData);
                }
            }
        }
    }

    public void t(qn qnVar) {
        List<tm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, qnVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (tm tmVar : this.e) {
                if (tmVar != null && (tmVar instanceof ew6)) {
                    ((ew6) tmVar).setOnAdapterItemClickListener(qnVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            p07 p07Var = new p07(frsNewAreaFragment.n(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            p07Var.C(bdTypeRecyclerView);
            b07 b07Var = new b07(frsNewAreaFragment.n(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            b07Var.C(bdTypeRecyclerView);
            m07 m07Var = new m07(frsNewAreaFragment.n(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            m07Var.C(bdTypeRecyclerView);
            j07 j07Var = new j07(frsNewAreaFragment.n(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            j07Var.C(bdTypeRecyclerView);
            a07 a07Var = new a07(frsNewAreaFragment.n(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            a07Var.C(bdTypeRecyclerView);
            d07 d07Var = new d07(frsNewAreaFragment.n(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            d07Var.C(bdTypeRecyclerView);
            r07 r07Var = new r07(frsNewAreaFragment.n(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            r07Var.C(bdTypeRecyclerView);
            n07 n07Var = new n07(frsNewAreaFragment.n(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            n07Var.C(bdTypeRecyclerView);
            l07 l07Var = new l07(frsNewAreaFragment.n(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            i07 i07Var = new i07(frsNewAreaFragment.n(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            q07 q07Var = new q07(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            q07Var.C(bdTypeRecyclerView);
            c07 c07Var = new c07(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            c07Var.C(bdTypeRecyclerView);
            g07 g07Var = new g07(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            g07Var.C(bdTypeRecyclerView);
            qz6 qz6Var = new qz6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            qz6Var.C(bdTypeRecyclerView);
            wz6 wz6Var = new wz6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            wz6Var.C(bdTypeRecyclerView);
            xz6 xz6Var = new xz6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            xz6Var.C(bdTypeRecyclerView);
            k07 k07Var = new k07(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            k07Var.C(bdTypeRecyclerView);
            q07 q07Var2 = new q07(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            q07Var2.C(bdTypeRecyclerView);
            lw6 lw6Var = new lw6(frsNewAreaFragment.getPageContext(), mw6.b);
            lw6Var.C(bdTypeRecyclerView);
            tm<? extends mz4, ? extends TypeAdapter.ViewHolder> a2 = yv6.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            tm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = yv6.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            tm<?, ?> d2 = f19.l().d(this.a, AdvertAppInfo.w);
            tm<?, ?> d3 = f19.l().d(this.a, AdvertAppInfo.z);
            o07 o07Var = new o07(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            o07Var.C(bdTypeRecyclerView);
            uz6 uz6Var = new uz6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            uz6Var.x(bdTypeRecyclerView);
            oz6 oz6Var = new oz6(frsNewAreaFragment.n(), py5.g);
            this.e.add(p07Var);
            this.e.add(b07Var);
            this.e.add(m07Var);
            this.e.add(j07Var);
            this.e.add(a07Var);
            this.e.add(d07Var);
            this.e.add(n07Var);
            this.e.add(r07Var);
            this.e.add(l07Var);
            this.e.add(i07Var);
            this.e.add(q07Var);
            this.e.add(g07Var);
            this.e.add(qz6Var);
            this.e.add(wz6Var);
            this.e.add(xz6Var);
            this.e.add(k07Var);
            this.e.add(lw6Var);
            this.e.add(c07Var);
            this.e.add(q07Var2);
            this.e.add(o07Var);
            this.e.add(uz6Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(d2);
            this.e.add(d3);
            this.e.add(oz6Var);
            this.e.add(new tz6(frsNewAreaFragment.getPageContext()));
            tm<?, ?> d4 = ha7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            tm<?, ?> d5 = ha7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.e.add(d4);
            this.e.add(d5);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<tm<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    tm<?, ?> next = it.next();
                    if (next instanceof ew6) {
                        ((ew6) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<tm> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            gw5 gw5Var = new gw5(this.a, 1);
            gw5Var.u(this.e);
            gw5Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, gw5Var));
            bdTypeRecyclerView.addAdapters(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (tm tmVar : this.e) {
                if (tmVar instanceof ew6) {
                    ((ew6) tmVar).x();
                } else if (tmVar instanceof w09) {
                    ((w09) tmVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (tm tmVar : this.e) {
            if (tmVar instanceof ew6) {
                ((ew6) tmVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        c77 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (tm tmVar : this.e) {
            if ((tmVar instanceof e77) && (i = ((e77) tmVar).i()) != null) {
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
            for (gn gnVar : this.b.getData()) {
                if (gnVar instanceof mz4) {
                    mz4 mz4Var = (mz4) gnVar;
                    if (mz4Var.t.getIs_top() != 0) {
                        mz4Var.t.parser_title();
                    }
                }
            }
        }
    }
}

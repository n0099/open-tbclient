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
public class b47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public po c;
    public List<qn> d;
    public List<qn> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<Cdo> g;
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
        public final /* synthetic */ b47 a;

        public a(b47 b47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b47Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b47Var;
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
        public final /* synthetic */ b47 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b47 b47Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b47Var, Integer.valueOf(i)};
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
            this.a = b47Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                b47 b47Var = this.a;
                b47Var.g(b47Var.b);
                b47 b47Var2 = this.a;
                b47Var2.p(b47Var2.g, this.a.h);
            }
        }
    }

    public b47(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new po(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<Cdo> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            v49.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = v49.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        zu6<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = tu6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
                        if (b2 != null) {
                            this.e.add(b2);
                            this.d.add(b2);
                        }
                    }
                    if (!ListUtils.isEmpty(this.d)) {
                        bdTypeRecyclerView.a(this.d);
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

    public List<Cdo> j() {
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

    public final void i(ArrayList<Cdo> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                Cdo cdo = arrayList.get(i);
                if ((cdo instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(cdo)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) cdo);
                }
            }
        }
    }

    public void q(boolean z) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (qn qnVar : this.e) {
                if (qnVar instanceof zu6) {
                    ((zu6) qnVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (qn qnVar : this.e) {
                if (qnVar instanceof zu6) {
                    ((zu6) qnVar).y(frsViewData);
                }
            }
        }
    }

    public void t(no noVar) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, noVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (qn qnVar : this.e) {
                if (qnVar != null && (qnVar instanceof zu6)) {
                    ((zu6) qnVar).setOnAdapterItemClickListener(noVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            kz6 kz6Var = new kz6(frsNewAreaFragment.p(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            kz6Var.A(bdTypeRecyclerView);
            wy6 wy6Var = new wy6(frsNewAreaFragment.p(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            wy6Var.A(bdTypeRecyclerView);
            hz6 hz6Var = new hz6(frsNewAreaFragment.p(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            hz6Var.A(bdTypeRecyclerView);
            ez6 ez6Var = new ez6(frsNewAreaFragment.p(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            ez6Var.A(bdTypeRecyclerView);
            vy6 vy6Var = new vy6(frsNewAreaFragment.p(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            vy6Var.A(bdTypeRecyclerView);
            yy6 yy6Var = new yy6(frsNewAreaFragment.p(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            yy6Var.A(bdTypeRecyclerView);
            mz6 mz6Var = new mz6(frsNewAreaFragment.p(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            mz6Var.A(bdTypeRecyclerView);
            iz6 iz6Var = new iz6(frsNewAreaFragment.p(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            iz6Var.A(bdTypeRecyclerView);
            gz6 gz6Var = new gz6(frsNewAreaFragment.p(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            dz6 dz6Var = new dz6(frsNewAreaFragment.p(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            lz6 lz6Var = new lz6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            lz6Var.A(bdTypeRecyclerView);
            xy6 xy6Var = new xy6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            xy6Var.A(bdTypeRecyclerView);
            bz6 bz6Var = new bz6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            bz6Var.A(bdTypeRecyclerView);
            ly6 ly6Var = new ly6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ly6Var.A(bdTypeRecyclerView);
            ry6 ry6Var = new ry6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            ry6Var.A(bdTypeRecyclerView);
            sy6 sy6Var = new sy6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            sy6Var.A(bdTypeRecyclerView);
            fz6 fz6Var = new fz6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            fz6Var.A(bdTypeRecyclerView);
            lz6 lz6Var2 = new lz6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            lz6Var2.A(bdTypeRecyclerView);
            gv6 gv6Var = new gv6(frsNewAreaFragment.getPageContext(), hv6.b);
            gv6Var.A(bdTypeRecyclerView);
            qn<? extends d15, ? extends TypeAdapter.ViewHolder> a2 = tu6.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            qn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = tu6.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            qn<?, ?> d2 = cw8.l().d(this.a, AdvertAppInfo.w);
            qn<?, ?> d3 = cw8.l().d(this.a, AdvertAppInfo.z);
            jz6 jz6Var = new jz6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            jz6Var.A(bdTypeRecyclerView);
            py6 py6Var = new py6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            py6Var.v(bdTypeRecyclerView);
            jy6 jy6Var = new jy6(frsNewAreaFragment.p(), jz5.g);
            this.e.add(kz6Var);
            this.e.add(wy6Var);
            this.e.add(hz6Var);
            this.e.add(ez6Var);
            this.e.add(vy6Var);
            this.e.add(yy6Var);
            this.e.add(iz6Var);
            this.e.add(mz6Var);
            this.e.add(gz6Var);
            this.e.add(dz6Var);
            this.e.add(lz6Var);
            this.e.add(bz6Var);
            this.e.add(ly6Var);
            this.e.add(ry6Var);
            this.e.add(sy6Var);
            this.e.add(fz6Var);
            this.e.add(gv6Var);
            this.e.add(xy6Var);
            this.e.add(lz6Var2);
            this.e.add(jz6Var);
            this.e.add(py6Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(d2);
            this.e.add(d3);
            this.e.add(jy6Var);
            this.e.add(new oy6(frsNewAreaFragment.getPageContext()));
            qn<?, ?> d4 = b97.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            qn<?, ?> d5 = b97.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.e.add(d4);
            this.e.add(d5);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<qn<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    qn<?, ?> next = it.next();
                    if (next instanceof zu6) {
                        ((zu6) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<qn> list = this.e;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            ax5 ax5Var = new ax5(this.a, 1);
            ax5Var.u(this.e);
            ax5Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ax5Var));
            bdTypeRecyclerView.a(this.e);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (qn qnVar : this.e) {
                if (qnVar instanceof zu6) {
                    ((zu6) qnVar).v();
                } else if (qnVar instanceof tv8) {
                    ((tv8) qnVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (qn qnVar : this.e) {
            if (qnVar instanceof zu6) {
                ((zu6) qnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        x57 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (qn qnVar : this.e) {
            if ((qnVar instanceof z57) && (i = ((z57) qnVar).i()) != null) {
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
            for (Cdo cdo : this.b.getData()) {
                if (cdo instanceof d15) {
                    d15 d15Var = (d15) cdo;
                    if (d15Var.t.getIs_top() != 0) {
                        d15Var.t.parser_title();
                    }
                }
            }
        }
    }
}

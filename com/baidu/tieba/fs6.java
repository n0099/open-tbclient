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
public class fs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public List<kn> c;
    public List<kn> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<xn> f;
    public FrsViewData g;
    public CustomMessageListener h;

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fs6 a;

        public a(fs6 fs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fs6Var;
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
        public final /* synthetic */ fs6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fs6 fs6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs6Var, Integer.valueOf(i)};
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
            this.a = fs6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                fs6 fs6Var = this.a;
                fs6Var.g(fs6Var.b);
                fs6 fs6Var2 = this.a;
                fs6Var2.q(fs6Var2.f, this.a.g);
            }
        }
    }

    public fs6(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.d = new LinkedList();
        this.h = new b(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.b = bdTypeRecyclerView;
        this.e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.h);
        }
    }

    public void q(ArrayList<xn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            ko8.f(arrayList, 1);
            i(arrayList);
            this.b.setData(arrayList);
            this.f = arrayList;
            this.g = frsViewData;
            v();
        }
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.c = new ArrayList();
                ArrayList<BdUniqueId> g = ko8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        gj6<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = aj6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
                        if (b2 != null) {
                            this.d.add(b2);
                            this.c.add(b2);
                        }
                    }
                    if (!ListUtils.isEmpty(this.c)) {
                        bdTypeRecyclerView.a(this.c);
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
            return this.e;
        }
        return (HashMap) invokeV.objValue;
    }

    public List<xn> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setData(this.f);
            l();
        }
    }

    public final void i(ArrayList<xn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                xn xnVar = arrayList.get(i);
                if ((xnVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(xnVar)) {
                    this.e.put(Integer.valueOf(i), (ThreadData) xnVar);
                }
            }
        }
    }

    public void r(boolean z) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (list = this.d) != null && list.size() != 0) {
            for (kn knVar : this.d) {
                if (knVar instanceof gj6) {
                    ((gj6) knVar).setFromCDN(z);
                }
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) && (list = this.d) != null && list.size() != 0) {
            for (kn knVar : this.d) {
                if (knVar instanceof gj6) {
                    ((gj6) knVar).y(frsViewData);
                }
            }
        }
    }

    public void u(ho hoVar) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, hoVar) == null) && (list = this.d) != null && list.size() != 0) {
            for (kn knVar : this.d) {
                if (knVar != null && (knVar instanceof gj6)) {
                    ((gj6) knVar).setOnAdapterItemClickListener(hoVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            pn6 pn6Var = new pn6(frsNewAreaFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            pn6Var.A(bdTypeRecyclerView);
            bn6 bn6Var = new bn6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            bn6Var.A(bdTypeRecyclerView);
            mn6 mn6Var = new mn6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            mn6Var.A(bdTypeRecyclerView);
            jn6 jn6Var = new jn6(frsNewAreaFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            jn6Var.A(bdTypeRecyclerView);
            an6 an6Var = new an6(frsNewAreaFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            an6Var.A(bdTypeRecyclerView);
            dn6 dn6Var = new dn6(frsNewAreaFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            dn6Var.A(bdTypeRecyclerView);
            rn6 rn6Var = new rn6(frsNewAreaFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            rn6Var.A(bdTypeRecyclerView);
            nn6 nn6Var = new nn6(frsNewAreaFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            nn6Var.A(bdTypeRecyclerView);
            ln6 ln6Var = new ln6(frsNewAreaFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            in6 in6Var = new in6(frsNewAreaFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            qn6 qn6Var = new qn6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            qn6Var.A(bdTypeRecyclerView);
            cn6 cn6Var = new cn6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            cn6Var.A(bdTypeRecyclerView);
            gn6 gn6Var = new gn6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            gn6Var.A(bdTypeRecyclerView);
            rm6 rm6Var = new rm6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            rm6Var.A(bdTypeRecyclerView);
            wm6 wm6Var = new wm6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            wm6Var.A(bdTypeRecyclerView);
            xm6 xm6Var = new xm6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            xm6Var.A(bdTypeRecyclerView);
            kn6 kn6Var = new kn6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            kn6Var.A(bdTypeRecyclerView);
            qn6 qn6Var2 = new qn6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            qn6Var2.A(bdTypeRecyclerView);
            nj6 nj6Var = new nj6(frsNewAreaFragment.getPageContext(), oj6.b);
            nj6Var.A(bdTypeRecyclerView);
            kn<? extends wu4, ? extends TypeAdapter.ViewHolder> a2 = aj6.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            kn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = aj6.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            kn<?, ?> d2 = gg8.l().d(this.a, AdvertAppInfo.w);
            kn<?, ?> d3 = gg8.l().d(this.a, AdvertAppInfo.z);
            on6 on6Var = new on6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            on6Var.A(bdTypeRecyclerView);
            um6 um6Var = new um6(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            um6Var.v(bdTypeRecyclerView);
            pm6 pm6Var = new pm6(frsNewAreaFragment.o(), qr5.g);
            this.d.add(pn6Var);
            this.d.add(bn6Var);
            this.d.add(mn6Var);
            this.d.add(jn6Var);
            this.d.add(an6Var);
            this.d.add(dn6Var);
            this.d.add(nn6Var);
            this.d.add(rn6Var);
            this.d.add(ln6Var);
            this.d.add(in6Var);
            this.d.add(qn6Var);
            this.d.add(gn6Var);
            this.d.add(rm6Var);
            this.d.add(wm6Var);
            this.d.add(xm6Var);
            this.d.add(kn6Var);
            this.d.add(nj6Var);
            this.d.add(cn6Var);
            this.d.add(qn6Var2);
            this.d.add(on6Var);
            this.d.add(um6Var);
            if (a2 != null) {
                this.d.add(a2);
            }
            if (d != null) {
                this.d.add(d);
            }
            this.d.add(d2);
            this.d.add(d3);
            this.d.add(pm6Var);
            kn<?, ?> d4 = yw6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            kn<?, ?> d5 = yw6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.d.add(d4);
            this.d.add(d5);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<kn<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    kn<?, ?> next = it.next();
                    if (next instanceof gj6) {
                        ((gj6) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<kn> list = this.d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            ip5 ip5Var = new ip5(this.a, 1);
            ip5Var.u(this.d);
            ip5Var.x("frs_new_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ip5Var));
            bdTypeRecyclerView.a(this.d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.b.getScrollState() == 0 && !this.b.isComputingLayout()) {
                this.b.getAdapter().notifyDataSetChanged();
            } else {
                this.b.post(new a(this));
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (kn knVar : this.d) {
                if (knVar instanceof gj6) {
                    ((gj6) knVar).v();
                } else if (knVar instanceof xf8) {
                    ((xf8) knVar).onDestroy();
                }
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (kn knVar : this.d) {
            if (knVar instanceof gj6) {
                ((gj6) knVar).C(this.a.getTbPageTag());
            }
        }
    }

    public final void v() {
        cu6 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || this.g == null) {
            return;
        }
        for (kn knVar : this.d) {
            if ((knVar instanceof eu6) && (i = ((eu6) knVar).i()) != null) {
                if (this.g.needLog == 1) {
                    i.a = true;
                } else {
                    i.a = false;
                }
                if (this.g.getForum() != null) {
                    i.c = this.g.getForum().getId();
                    i.d = this.g.getForum().getName();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getData() != null && this.b.getData().size() != 0) {
            for (xn xnVar : this.b.getData()) {
                if (xnVar instanceof wu4) {
                    wu4 wu4Var = (wu4) xnVar;
                    if (wu4Var.t.getIs_top() != 0) {
                        wu4Var.t.parser_title();
                    }
                }
            }
        }
    }
}

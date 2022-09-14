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
import com.baidu.tieba.frs.good.FrsGoodFragment;
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
public class ao6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;
    public BdTypeRecyclerView b;
    public List<qn> c;
    public List<qn> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<Cdo> f;
    public ArrayList<Cdo> g;
    public FrsViewData h;
    public CustomMessageListener i;
    public CustomMessageListener j;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ao6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ao6 ao6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ao6Var, Integer.valueOf(i)};
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
            this.a = ao6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<qn<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    qn<?, ?> next = it.next();
                    if (next instanceof qg6) {
                        ((qg6) next).m(this.a.a.getPageContext(), this.a.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (this.a.d != null) {
                    this.a.d.addAll(arrayList);
                }
                if (this.a.b != null) {
                    this.a.b.a(arrayList);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ao6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ao6 ao6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ao6Var, Integer.valueOf(i)};
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
            this.a = ao6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                ao6 ao6Var = this.a;
                ao6Var.i(ao6Var.b);
                ao6 ao6Var2 = this.a;
                ao6Var2.w(ao6Var2.f, this.a.h);
            }
        }
    }

    public ao6(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGoodFragment, bdTypeRecyclerView};
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
        this.i = new a(this, 2003008);
        this.j = new b(this, 2016470);
        n(frsGoodFragment, bdTypeRecyclerView);
        this.b = bdTypeRecyclerView;
        this.e = new HashMap<>();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (qn qnVar : this.d) {
                if (qnVar instanceof t16) {
                    ((t16) qnVar).p(3);
                }
            }
        }
    }

    public void B(no noVar) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, noVar) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (qn qnVar : this.d) {
            if (qnVar != null && (qnVar instanceof qg6)) {
                ((qg6) qnVar).setOnAdapterItemClickListener(noVar);
            }
        }
    }

    public final void C() {
        nr6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.h == null) {
            return;
        }
        for (qn qnVar : this.d) {
            if ((qnVar instanceof pr6) && (i = ((pr6) qnVar).i()) != null) {
                if (this.h.needLog == 1) {
                    i.a = true;
                } else {
                    i.a = false;
                }
                if (this.h.getForum() != null) {
                    i.c = this.h.getForum().getId();
                    i.d = this.h.getForum().getName();
                }
                if (this.a != null) {
                    i.b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.b) == null || bdTypeRecyclerView.getData() == null || this.b.getData().size() == 0) {
            return;
        }
        for (Cdo cdo : this.b.getData()) {
            if (cdo instanceof ot4) {
                ot4 ot4Var = (ot4) cdo;
                if (ot4Var.t.getIs_top() != 0) {
                    ot4Var.t.parser_title();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) || this.a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.a.registerListener(this.j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.c = new ArrayList();
                ArrayList<BdUniqueId> g = ul8.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        qg6<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = kg6.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
                        if (b2 != null) {
                            this.d.add(b2);
                            this.c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.c)) {
                        return true;
                    }
                    bdTypeRecyclerView.a(this.c);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HashMap<Integer, ThreadData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (HashMap) invokeV.objValue;
    }

    public final void k(ArrayList<Cdo> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            Cdo cdo = arrayList.get(i);
            if ((cdo instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(cdo)) {
                this.e.put(Integer.valueOf(i), (ThreadData) cdo);
            }
        }
    }

    public List<Cdo> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : (List) invokeV.objValue;
    }

    public List<Cdo> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.g : (List) invokeV.objValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.a = frsGoodFragment;
            this.i.setPriority(1);
            this.i.setSelfListener(true);
            this.a.registerListener(this.i);
            yk6 yk6Var = new yk6(frsGoodFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            kk6 kk6Var = new kk6(frsGoodFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            vk6 vk6Var = new vk6(frsGoodFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            sk6 sk6Var = new sk6(frsGoodFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            jk6 jk6Var = new jk6(frsGoodFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            mk6 mk6Var = new mk6(frsGoodFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            al6 al6Var = new al6(frsGoodFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            wk6 wk6Var = new wk6(frsGoodFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            uk6 uk6Var = new uk6(frsGoodFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            rk6 rk6Var = new rk6(frsGoodFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            zk6 zk6Var = new zk6(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            pk6 pk6Var = new pk6(frsGoodFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            tk6 tk6Var = new tk6(frsGoodFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            zk6 zk6Var2 = new zk6(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            xg6 xg6Var = new xg6(frsGoodFragment.getPageContext(), yg6.b);
            qn<? extends ot4, ? extends TypeAdapter.ViewHolder> a2 = kg6.e().a(frsGoodFragment.getPageContext(), this.a.getUniqueId(), true);
            qn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = kg6.e().d(frsGoodFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            qn<?, ?> d2 = md8.l().d(this.a, AdvertAppInfo.w);
            qn<?, ?> d3 = md8.l().d(this.a, AdvertAppInfo.z);
            xk6 xk6Var = new xk6(frsGoodFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            ak6 ak6Var = new ak6(frsGoodFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            fk6 fk6Var = new fk6(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            gk6 gk6Var = new gk6(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            dk6 dk6Var = new dk6(frsGoodFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            dk6Var.v(bdTypeRecyclerView);
            this.d.add(yk6Var);
            this.d.add(kk6Var);
            this.d.add(vk6Var);
            this.d.add(sk6Var);
            this.d.add(jk6Var);
            this.d.add(mk6Var);
            this.d.add(wk6Var);
            this.d.add(al6Var);
            this.d.add(uk6Var);
            this.d.add(rk6Var);
            this.d.add(zk6Var);
            this.d.add(pk6Var);
            this.d.add(pk6Var);
            this.d.add(tk6Var);
            this.d.add(xg6Var);
            this.d.add(zk6Var);
            this.d.add(zk6Var2);
            this.d.add(xk6Var);
            this.d.add(ak6Var);
            this.d.add(fk6Var);
            this.d.add(gk6Var);
            this.d.add(dk6Var);
            if (a2 != null) {
                this.d.add(a2);
            }
            if (d != null) {
                this.d.add(d);
            }
            this.d.add(d2);
            this.d.add(d3);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.d.add(ju6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, null));
            this.d.add(ju6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, null));
            dn5 dn5Var = new dn5(this.a, 1);
            dn5Var.u(this.d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, dn5Var));
            bdTypeRecyclerView.a(this.d);
            v("page_frs_good");
            for (qn qnVar : this.d) {
                if (qnVar instanceof u16) {
                    ((u16) qnVar).j(true);
                }
            }
        }
    }

    public boolean o(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (qn qnVar : this.d) {
                if (qnVar != null && qnVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (qn qnVar : this.d) {
                if (qnVar instanceof qg6) {
                    ((qg6) qnVar).v();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.b.setData(this.g);
            p();
        }
    }

    public final void u(ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<Cdo> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == ThreadData.TYPE_TOP) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.d) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof go5) {
                ((go5) qnVar).g(str);
            }
        }
    }

    public void w(ArrayList<Cdo> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof yg6)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            ul8.f(arrayList, 1);
            k(arrayList);
            ArrayList<Cdo> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.b.setData(switchThreadDataToThreadCardInfo);
            this.g = switchThreadDataToThreadCardInfo;
            this.f = arrayList;
            this.h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (qn qnVar : this.d) {
            if (qnVar instanceof qg6) {
                ((qg6) qnVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (qn qnVar : this.d) {
            if (qnVar instanceof qg6) {
                ((qg6) qnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        for (qn qnVar : this.d) {
            if (qnVar instanceof qg6) {
                ((qg6) qnVar).y(frsViewData);
            }
        }
    }
}

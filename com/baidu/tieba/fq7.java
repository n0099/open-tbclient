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
/* loaded from: classes5.dex */
public class fq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;
    public BdTypeRecyclerView b;
    public List<pm> c;
    public List<pm> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<cn> f;
    public ArrayList<cn> g;
    public FrsViewData h;
    public CustomMessageListener i;
    public CustomMessageListener j;

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fq7 fq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq7Var, Integer.valueOf(i)};
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
            this.a = fq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<pm<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    pm<?, ?> next = it.next();
                    if (next instanceof fi7) {
                        ((fi7) next).m(this.a.a.getPageContext(), this.a.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (this.a.d != null) {
                    this.a.d.addAll(arrayList);
                }
                if (this.a.b != null) {
                    this.a.b.addAdapters(arrayList);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(fq7 fq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fq7Var, Integer.valueOf(i)};
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
            this.a = fq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                fq7 fq7Var = this.a;
                fq7Var.i(fq7Var.b);
                fq7 fq7Var2 = this.a;
                fq7Var2.w(fq7Var2.f, this.a.h);
            }
        }
    }

    public fq7(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public void w(ArrayList<cn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof ni7)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            tga.f(arrayList, 1);
            k(arrayList);
            ArrayList<cn> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.b.setData(switchThreadDataToThreadCardInfo);
            this.g = switchThreadDataToThreadCardInfo;
            this.f = arrayList;
            this.h = frsViewData;
            C();
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !i(bdTypeRecyclerView)) {
            this.a.registerListener(this.j);
        }
    }

    public final void v(String str) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, str) != null) || (list = this.d) == null) {
            return;
        }
        for (pm pmVar : list) {
            if (pmVar instanceof o56) {
                ((o56) pmVar).g(str);
            }
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (pm pmVar : this.d) {
                if (pmVar instanceof kp6) {
                    ((kp6) pmVar).p(3);
                }
            }
        }
    }

    public HashMap<Integer, ThreadData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (HashMap) invokeV.objValue;
    }

    public List<cn> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public List<cn> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.g;
        }
        return (List) invokeV.objValue;
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

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.b.setData(this.g);
            p();
        }
    }

    public void B(mn mnVar) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mnVar) == null) && (list = this.d) != null && list.size() != 0) {
            for (pm pmVar : this.d) {
                if (pmVar != null && (pmVar instanceof fi7)) {
                    ((fi7) pmVar).setOnAdapterItemClickListener(mnVar);
                }
            }
        }
    }

    public final void k(ArrayList<cn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                cn cnVar = arrayList.get(i);
                if ((cnVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(cnVar)) {
                    this.e.put(Integer.valueOf(i), (ThreadData) cnVar);
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
            for (pm pmVar : this.d) {
                if (pmVar != null && pmVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void u(ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) && arrayList != null && arrayList.size() > 0) {
            Iterator<cn> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == ThreadData.TYPE_TOP) {
                    it.remove();
                }
            }
        }
    }

    public void x(boolean z) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048596, this, z) == null) && (list = this.d) != null && list.size() != 0) {
            for (pm pmVar : this.d) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).setFromCDN(z);
                }
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<pm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) && (list = this.d) != null && list.size() != 0) {
            for (pm pmVar : this.d) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).A(frsViewData);
                }
            }
        }
    }

    public final void C() {
        vt7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.h == null) {
            return;
        }
        for (pm pmVar : this.d) {
            if ((pmVar instanceof xt7) && (i = ((xt7) pmVar).i()) != null) {
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
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getData() != null && this.b.getData().size() != 0) {
            for (cn cnVar : this.b.getData()) {
                if (cnVar instanceof h45) {
                    h45 h45Var = (h45) cnVar;
                    if (h45Var.t.getIs_top() != 0) {
                        h45Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.c = new ArrayList();
                ArrayList<BdUniqueId> g = tga.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        fi7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = zh7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
                        if (b2 != null) {
                            this.d.add(b2);
                            this.c.add(b2);
                        }
                    }
                    if (!ListUtils.isEmpty(this.c)) {
                        bdTypeRecyclerView.addAdapters(this.c);
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.a = frsGoodFragment;
            this.i.setPriority(1);
            this.i.setSelfListener(true);
            this.a.registerListener(this.i);
            xm7 xm7Var = new xm7(frsGoodFragment.u(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            jm7 jm7Var = new jm7(frsGoodFragment.u(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            um7 um7Var = new um7(frsGoodFragment.u(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            rm7 rm7Var = new rm7(frsGoodFragment.u(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            im7 im7Var = new im7(frsGoodFragment.u(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            lm7 lm7Var = new lm7(frsGoodFragment.u(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            zm7 zm7Var = new zm7(frsGoodFragment.u(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            vm7 vm7Var = new vm7(frsGoodFragment.u(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            tm7 tm7Var = new tm7(frsGoodFragment.u(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            qm7 qm7Var = new qm7(frsGoodFragment.u(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            ym7 ym7Var = new ym7(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            om7 om7Var = new om7(frsGoodFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            sm7 sm7Var = new sm7(frsGoodFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            ym7 ym7Var2 = new ym7(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            mi7 mi7Var = new mi7(frsGoodFragment.getPageContext(), ni7.b);
            pm<? extends h45, ? extends TypeAdapter.ViewHolder> a2 = zh7.e().a(frsGoodFragment.getPageContext(), this.a.getUniqueId(), true);
            pm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = zh7.e().d(frsGoodFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            pm<?, ?> e = i3a.m().e(this.a, AdvertAppInfo.x);
            pm<?, ?> e2 = i3a.m().e(this.a, AdvertAppInfo.A);
            wm7 wm7Var = new wm7(frsGoodFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            wl7 wl7Var = new wl7(frsGoodFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            dm7 dm7Var = new dm7(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            em7 em7Var = new em7(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            bm7 bm7Var = new bm7(frsGoodFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            bm7Var.x(bdTypeRecyclerView);
            hm7 hm7Var = new hm7(frsGoodFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            this.d.add(xm7Var);
            this.d.add(jm7Var);
            this.d.add(um7Var);
            this.d.add(rm7Var);
            this.d.add(im7Var);
            this.d.add(lm7Var);
            this.d.add(vm7Var);
            this.d.add(zm7Var);
            this.d.add(tm7Var);
            this.d.add(qm7Var);
            this.d.add(ym7Var);
            this.d.add(om7Var);
            this.d.add(om7Var);
            this.d.add(sm7Var);
            this.d.add(mi7Var);
            this.d.add(ym7Var);
            this.d.add(ym7Var2);
            this.d.add(wm7Var);
            this.d.add(wl7Var);
            this.d.add(dm7Var);
            this.d.add(em7Var);
            this.d.add(bm7Var);
            this.d.add(hm7Var);
            if (a2 != null) {
                this.d.add(a2);
            }
            if (d != null) {
                this.d.add(d);
            }
            this.d.add(e);
            this.d.add(e2);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.d.add(jy7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, null));
            this.d.add(jy7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, null));
            l46 l46Var = new l46(this.a, 1);
            l46Var.u(this.d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, l46Var));
            bdTypeRecyclerView.addAdapters(this.d);
            v("page_frs_good");
            for (pm pmVar : this.d) {
                if (pmVar instanceof lp6) {
                    ((lp6) pmVar).j(true);
                }
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (pm pmVar : this.d) {
                if (pmVar instanceof fi7) {
                    ((fi7) pmVar).x();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (pm pmVar : this.d) {
            if (pmVar instanceof fi7) {
                ((fi7) pmVar).E(this.a.getTbPageTag());
            }
        }
    }
}

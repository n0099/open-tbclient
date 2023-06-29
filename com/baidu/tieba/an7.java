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
/* loaded from: classes5.dex */
public class an7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public BdTypeRecyclerView b;
    public jo c;
    public List<kn> d;
    public List<kn> e;
    public final HashMap<Integer, ThreadData> f;
    public ArrayList<xn> g;
    public FrsViewData h;
    public CustomMessageListener i;

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ an7 a;

        public a(an7 an7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {an7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = an7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.getAdapter().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ an7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(an7 an7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {an7Var, Integer.valueOf(i)};
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
            this.a = an7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.d)) {
                an7 an7Var = this.a;
                an7Var.g(an7Var.b);
                an7 an7Var2 = this.a;
                an7Var2.p(an7Var2.g, this.a.h);
            }
        }
    }

    public an7(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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
        this.c = new jo(bdTypeRecyclerView);
        this.f = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !g(bdTypeRecyclerView)) {
            this.a.registerListener(this.i);
        }
    }

    public void p(ArrayList<xn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, arrayList, frsViewData) == null) {
            s(frsViewData);
            r();
            m3a.f(arrayList, 1);
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
                ArrayList<BdUniqueId> g = m3a.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        sd7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = md7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
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

    public List<xn> j() {
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

    public final void i(ArrayList<xn> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                xn xnVar = arrayList.get(i);
                if ((xnVar instanceof AdvertAppInfo) && (hashMap = this.f) != null && !hashMap.containsValue(xnVar)) {
                    this.f.put(Integer.valueOf(i), (ThreadData) xnVar);
                }
            }
        }
    }

    public void q(boolean z) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (list = this.e) != null && list.size() != 0) {
            for (kn knVar : this.e) {
                if (knVar instanceof sd7) {
                    ((sd7) knVar).setFromCDN(z);
                }
            }
        }
    }

    public void s(FrsViewData frsViewData) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, frsViewData) == null) && (list = this.e) != null && list.size() != 0) {
            for (kn knVar : this.e) {
                if (knVar instanceof sd7) {
                    ((sd7) knVar).A(frsViewData);
                }
            }
        }
    }

    public void t(ho hoVar) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, hoVar) == null) && (list = this.e) != null && list.size() != 0) {
            for (kn knVar : this.e) {
                if (knVar != null && (knVar instanceof sd7)) {
                    ((sd7) knVar).setOnAdapterItemClickListener(hoVar);
                }
            }
        }
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.a = frsNewAreaFragment;
            di7 di7Var = new di7(frsNewAreaFragment.t(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            di7Var.C(bdTypeRecyclerView);
            ph7 ph7Var = new ph7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            ph7Var.C(bdTypeRecyclerView);
            ai7 ai7Var = new ai7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            ai7Var.C(bdTypeRecyclerView);
            xh7 xh7Var = new xh7(frsNewAreaFragment.t(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            xh7Var.C(bdTypeRecyclerView);
            oh7 oh7Var = new oh7(frsNewAreaFragment.t(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            oh7Var.C(bdTypeRecyclerView);
            rh7 rh7Var = new rh7(frsNewAreaFragment.t(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            rh7Var.C(bdTypeRecyclerView);
            fi7 fi7Var = new fi7(frsNewAreaFragment.t(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            fi7Var.C(bdTypeRecyclerView);
            bi7 bi7Var = new bi7(frsNewAreaFragment.t(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            bi7Var.C(bdTypeRecyclerView);
            zh7 zh7Var = new zh7(frsNewAreaFragment.t(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            wh7 wh7Var = new wh7(frsNewAreaFragment.t(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            ei7 ei7Var = new ei7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            ei7Var.C(bdTypeRecyclerView);
            qh7 qh7Var = new qh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            qh7Var.C(bdTypeRecyclerView);
            uh7 uh7Var = new uh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            uh7Var.C(bdTypeRecyclerView);
            eh7 eh7Var = new eh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            eh7Var.C(bdTypeRecyclerView);
            kh7 kh7Var = new kh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            kh7Var.C(bdTypeRecyclerView);
            lh7 lh7Var = new lh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            lh7Var.C(bdTypeRecyclerView);
            yh7 yh7Var = new yh7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            yh7Var.C(bdTypeRecyclerView);
            ei7 ei7Var2 = new ei7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            ei7Var2.C(bdTypeRecyclerView);
            zd7 zd7Var = new zd7(frsNewAreaFragment.getPageContext(), ae7.b);
            zd7Var.C(bdTypeRecyclerView);
            kn<? extends r45, ? extends TypeAdapter.ViewHolder> a2 = md7.e().a(frsNewAreaFragment.getPageContext(), this.a.getUniqueId(), true);
            kn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = md7.e().d(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            kn<?, ?> d2 = ns9.l().d(this.a, AdvertAppInfo.w);
            kn<?, ?> d3 = ns9.l().d(this.a, AdvertAppInfo.z);
            ci7 ci7Var = new ci7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            ci7Var.C(bdTypeRecyclerView);
            ih7 ih7Var = new ih7(frsNewAreaFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            ih7Var.x(bdTypeRecyclerView);
            ch7 ch7Var = new ch7(frsNewAreaFragment.t(), w66.g);
            this.e.add(di7Var);
            this.e.add(ph7Var);
            this.e.add(ai7Var);
            this.e.add(xh7Var);
            this.e.add(oh7Var);
            this.e.add(rh7Var);
            this.e.add(bi7Var);
            this.e.add(fi7Var);
            this.e.add(zh7Var);
            this.e.add(wh7Var);
            this.e.add(ei7Var);
            this.e.add(uh7Var);
            this.e.add(eh7Var);
            this.e.add(kh7Var);
            this.e.add(lh7Var);
            this.e.add(yh7Var);
            this.e.add(zd7Var);
            this.e.add(qh7Var);
            this.e.add(ei7Var2);
            this.e.add(ci7Var);
            this.e.add(ih7Var);
            if (a2 != null) {
                this.e.add(a2);
            }
            if (d != null) {
                this.e.add(d);
            }
            this.e.add(d2);
            this.e.add(d3);
            this.e.add(ch7Var);
            this.e.add(new hh7(frsNewAreaFragment.getPageContext()));
            kn<?, ?> d4 = gt7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_new_tab");
            kn<?, ?> d5 = gt7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.G, "frs_new_tab");
            this.e.add(d4);
            this.e.add(d5);
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
                    if (next instanceof sd7) {
                        ((sd7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<kn> list = this.e;
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
            for (kn knVar : this.e) {
                if (knVar instanceof sd7) {
                    ((sd7) knVar).x();
                } else if (knVar instanceof ds9) {
                    ((ds9) knVar).onDestroy();
                }
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048588, this) != null) || ListUtils.isEmpty(this.e) || this.a == null) {
            return;
        }
        for (kn knVar : this.e) {
            if (knVar instanceof sd7) {
                ((sd7) knVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void u() {
        zo7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.h == null) {
            return;
        }
        for (kn knVar : this.e) {
            if ((knVar instanceof bp7) && (i = ((bp7) knVar).i()) != null) {
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
            for (xn xnVar : this.b.getData()) {
                if (xnVar instanceof r45) {
                    r45 r45Var = (r45) xnVar;
                    if (r45Var.t.getIs_top() != 0) {
                        r45Var.t.parser_title();
                    }
                }
            }
        }
    }
}

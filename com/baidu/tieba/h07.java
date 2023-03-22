package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
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
public class h07 implements v07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public mn b;
    public List<tm> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<gn> e;
    public FrsViewData f;
    public boolean g;
    public final cw6 h;
    public u07 i;
    public tm j;
    public p07 k;
    public b07 l;
    public m07 m;
    public j07 n;
    public a07 o;
    public d07 p;
    public n07 q;
    public r07 r;
    public l07 s;
    public i07 t;
    public q07 u;
    public c07 v;
    public k07 w;

    public h07(FrsFragment frsFragment, mn mnVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, mnVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new LinkedList();
        this.g = false;
        this.b = mnVar;
        this.h = new cw6();
        o(frsFragment, mnVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.v07
    public void a(String str) {
        List<tm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (tm tmVar : list) {
            if (tmVar instanceof jf6) {
                ((jf6) tmVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.v07
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(gn gnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, gnVar)) == null) {
            if (gnVar == null) {
                return false;
            }
            BdUniqueId type = gnVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<tm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (tm tmVar : list) {
            if (tmVar instanceof jx5) {
                ((jx5) tmVar).g(str);
            }
        }
    }

    public final void z(List<tm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (tm tmVar : list) {
            if (tmVar instanceof ew6) {
                ((ew6) tmVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.v07
    public void b() {
        mn mnVar;
        List<gn> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (mnVar = this.b) != null && mnVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (gn gnVar : data) {
                if (gnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) gnVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (gnVar instanceof mz4) {
                    mz4 mz4Var = (mz4) gnVar;
                    if (mz4Var.t.getIs_top() != 0) {
                        mz4Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        c77 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (tm tmVar : this.c) {
            if ((tmVar instanceof e77) && (i = ((e77) tmVar).i()) != null) {
                if (this.f.needLog == 1) {
                    i.a = true;
                } else {
                    i.a = false;
                }
                if (this.f.getForum() != null) {
                    i.c = this.f.getForum().getId();
                    i.d = this.f.getForum().getName();
                }
                FrsFragment frsFragment = this.a;
                if (frsFragment != null && frsFragment.Q0() != null) {
                    int m0 = this.a.Q0().m0();
                    if (m0 == -1) {
                        m0 = this.a.Q0().l0();
                    }
                    i.b = m0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.v07
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c21;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.v07
    public List<gn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            mn mnVar = this.b;
            if (mnVar != null) {
                return mnVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v07
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v07
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090bfc;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.v07
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090cc8;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.v07
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<gn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.v07
    public void d(qn qnVar) {
        List<tm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, qnVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (tm tmVar : this.c) {
                if (tmVar instanceof ew6) {
                    ((ew6) tmVar).setOnAdapterItemClickListener(qnVar);
                } else if ((tmVar instanceof k07) || (tmVar instanceof q07)) {
                    tmVar.setOnAdapterItemClickListener(qnVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.v07
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (tm tmVar : this.c) {
                if (tmVar != null && tmVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.v07
    public void l(zv6 zv6Var) {
        List<tm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, zv6Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (tm tmVar : this.c) {
                if (tmVar instanceof ew6) {
                    ((ew6) tmVar).z(zv6Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<tm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (tm tmVar : this.c) {
                if (tmVar instanceof ew6) {
                    ((ew6) tmVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.v07
    public void e() {
        List<tm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (tm tmVar : this.c) {
                if (tmVar instanceof ew6) {
                    ((ew6) tmVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.v07
    public void g(ArrayList<gn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            ab9.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<gn> it = arrayList.iterator();
            while (it.hasNext()) {
                gn next = it.next();
                if ((next instanceof mz4) && ((mz4) next).t.isTop()) {
                    it.remove();
                }
            }
            this.b.setData(arrayList);
            this.f = frsViewData;
            w();
            y();
            this.e = arrayList;
        }
    }

    public final ArrayList<Integer> n(ArrayList<gn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    gn gnVar = arrayList.get(i);
                    if (gnVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(gnVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) gnVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<gn> arrayList) {
        List<tm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<gn> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (tm tmVar : this.c) {
                if (tmVar instanceof ew6) {
                    ((ew6) tmVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, mnVar) == null) {
            this.a = frsFragment;
            this.j = yv6.e().c(frsFragment.getPageContext(), db9.d, this.a.getUniqueId(), false);
            p07 p07Var = new p07(frsFragment.n(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = p07Var;
            p07Var.C(mnVar);
            b07 b07Var = new b07(frsFragment.n(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = b07Var;
            b07Var.C(mnVar);
            m07 m07Var = new m07(frsFragment.n(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = m07Var;
            m07Var.C(mnVar);
            j07 j07Var = new j07(frsFragment.n(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = j07Var;
            j07Var.C(mnVar);
            a07 a07Var = new a07(frsFragment.n(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = a07Var;
            a07Var.C(mnVar);
            d07 d07Var = new d07(frsFragment.n(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = d07Var;
            d07Var.C(mnVar);
            r07 r07Var = new r07(frsFragment.n(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = r07Var;
            r07Var.C(mnVar);
            n07 n07Var = new n07(frsFragment.n(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = n07Var;
            n07Var.C(mnVar);
            l07 l07Var = new l07(frsFragment.n(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = l07Var;
            l07Var.C(mnVar);
            i07 i07Var = new i07(frsFragment.n(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = i07Var;
            i07Var.C(mnVar);
            q07 q07Var = new q07(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = q07Var;
            q07Var.C(mnVar);
            c07 c07Var = new c07(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = c07Var;
            c07Var.C(mnVar);
            g07 g07Var = new g07(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            g07Var.C(mnVar);
            o07 o07Var = new o07(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            o07Var.C(mnVar);
            pz6 pz6Var = new pz6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            pz6Var.C(mnVar);
            pz6Var.p(1);
            rz6 rz6Var = new rz6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            rz6Var.C(mnVar);
            qz6 qz6Var = new qz6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            qz6Var.C(mnVar);
            qz6Var.g0(true);
            wz6 wz6Var = new wz6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            wz6Var.C(mnVar);
            wz6Var.g0(true);
            xz6 xz6Var = new xz6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            xz6Var.C(mnVar);
            xz6Var.h0(true);
            q07 q07Var2 = new q07(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            q07Var2.C(mnVar);
            f07 f07Var = new f07(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            f07Var.C(mnVar);
            e07 e07Var = new e07(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            e07Var.C(mnVar);
            this.i = new u07(frsFragment.getPageContext(), va9.c, this.a.getUniqueId());
            k07 k07Var = new k07(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = k07Var;
            k07Var.C(mnVar);
            tm<? extends mz4, ? extends TypeAdapter.ViewHolder> a = yv6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            tm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = yv6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            lw6 lw6Var = new lw6(frsFragment.getPageContext(), mw6.b);
            yz6 yz6Var = new yz6(frsFragment.getPageContext(), pw6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), rw6.e, this.a.getUniqueId());
            uz6 uz6Var = new uz6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            uz6Var.x((BdTypeRecyclerView) mnVar);
            zz6 zz6Var = new zz6(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            oz6 oz6Var = new oz6(frsFragment.n(), py5.g);
            this.c.add(this.j);
            this.c.add(this.k);
            this.c.add(this.l);
            this.c.add(this.m);
            this.c.add(this.n);
            this.c.add(this.o);
            this.c.add(this.p);
            this.c.add(this.q);
            this.c.add(this.r);
            this.c.add(this.s);
            this.c.add(this.t);
            this.c.add(this.i);
            this.c.add(g07Var);
            this.c.add(o07Var);
            this.c.add(pz6Var);
            this.c.add(rz6Var);
            this.c.add(qz6Var);
            this.c.add(wz6Var);
            this.c.add(xz6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(lw6Var);
            this.c.add(yz6Var);
            this.c.add(f07Var);
            this.c.add(e07Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(q07Var2);
            this.c.add(uz6Var);
            this.c.add(zz6Var);
            this.c.add(oz6Var);
            this.c.add(new tz6(frsFragment.getPageContext()));
            this.c.add(ha7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            gw5 gw5Var = new gw5(this.a, 1);
            gw5Var.u(this.c);
            gw5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, gw5Var));
            z(this.c);
            mnVar.addAdapters(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
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
                List<tm> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                mn mnVar2 = this.b;
                if (mnVar2 != null) {
                    mnVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.v07
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (tm tmVar : this.c) {
                if (tmVar instanceof ew6) {
                    ((ew6) tmVar).x();
                } else if (tmVar instanceof w09) {
                    ((w09) tmVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (tm tmVar : this.c) {
            if (tmVar instanceof ew6) {
                ((ew6) tmVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        u07 u07Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (u07Var = this.i) != null) {
            u07Var.M(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<gn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                gn gnVar = (gn) ListUtils.getItem(arrayList, i - 1);
                gn gnVar2 = (gn) ListUtils.getItem(arrayList, i);
                if (gnVar2 instanceof mz4) {
                    ThreadData threadData = ((mz4) gnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (gnVar instanceof pw6) {
                        threadData.needTopMargin = false;
                    } else if (gnVar != null && !p(gnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((gnVar instanceof mz4) && p(gnVar) && !TextUtils.isEmpty(((mz4) gnVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(gnVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.v07
    public void setFromCDN(boolean z) {
        List<tm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (tm tmVar : this.c) {
                if (tmVar instanceof ew6) {
                    ((ew6) tmVar).setFromCDN(z);
                }
            }
            p07 p07Var = this.k;
            if (p07Var != null) {
                p07Var.setFromCDN(z);
            }
            b07 b07Var = this.l;
            if (b07Var != null) {
                b07Var.setFromCDN(z);
            }
            m07 m07Var = this.m;
            if (m07Var != null) {
                m07Var.setFromCDN(z);
            }
            j07 j07Var = this.n;
            if (j07Var != null) {
                j07Var.setFromCDN(z);
            }
            a07 a07Var = this.o;
            if (a07Var != null) {
                a07Var.setFromCDN(z);
            }
            d07 d07Var = this.p;
            if (d07Var != null) {
                d07Var.setFromCDN(z);
            }
            q07 q07Var = this.u;
            if (q07Var != null) {
                q07Var.setFromCDN(z);
            }
            k07 k07Var = this.w;
            if (k07Var != null) {
                k07Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<tm> list;
        Class<?> cls;
        Class<?> cls2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, str) == null) && (list = this.c) != null && list.size() != 0) {
            try {
                cls = Class.forName("com.baidu.tieba.InjectPlugin.FrsFeedAd.FrsFeedAdAdapter");
                cls2 = Class.forName("com.baidu.tieba.funad.adapter.FunAdNativeNewAdapter");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return;
            }
            for (tm tmVar : this.c) {
                if (tmVar != null) {
                    Class<?> cls3 = tmVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(tmVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(tmVar, str);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}

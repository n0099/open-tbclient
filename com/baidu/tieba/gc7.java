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
/* loaded from: classes5.dex */
public class gc7 implements uc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public xn b;
    public List<en> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<rn> e;
    public FrsViewData f;
    public boolean g;
    public final b87 h;
    public tc7 i;
    public en j;
    public oc7 k;
    public ac7 l;
    public lc7 m;
    public ic7 n;
    public zb7 o;
    public cc7 p;
    public mc7 q;
    public qc7 r;
    public kc7 s;
    public hc7 t;
    public pc7 u;
    public bc7 v;
    public jc7 w;

    public gc7(FrsFragment frsFragment, xn xnVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, xnVar, Boolean.valueOf(z)};
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
        this.b = xnVar;
        this.h = new b87();
        o(frsFragment, xnVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.uc7
    public void a(String str) {
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (en enVar : list) {
            if (enVar instanceof uj6) {
                ((uj6) enVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.uc7
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(rn rnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, rnVar)) == null) {
            if (rnVar == null) {
                return false;
            }
            BdUniqueId type = rnVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (en enVar : list) {
            if (enVar instanceof c16) {
                ((c16) enVar).g(str);
            }
        }
    }

    public final void z(List<en> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (en enVar : list) {
            if (enVar instanceof d87) {
                ((d87) enVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.uc7
    public void b() {
        xn xnVar;
        List<rn> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (xnVar = this.b) != null && xnVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (rn rnVar : data) {
                if (rnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) rnVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (rnVar instanceof o15) {
                    o15 o15Var = (o15) rnVar;
                    if (o15Var.t.getIs_top() != 0) {
                        o15Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        hj7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (en enVar : this.c) {
            if ((enVar instanceof jj7) && (i = ((jj7) enVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.U0() != null) {
                    int p0 = this.a.U0().p0();
                    if (p0 == -1) {
                        p0 = this.a.U0().o0();
                    }
                    i.b = p0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.uc7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c54;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.uc7
    public List<rn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            xn xnVar = this.b;
            if (xnVar != null) {
                return xnVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uc7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uc7
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c2f;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.uc7
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090cfb;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.uc7
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<rn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.uc7
    public void d(bo boVar) {
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, boVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (en enVar : this.c) {
                if (enVar instanceof d87) {
                    ((d87) enVar).setOnAdapterItemClickListener(boVar);
                } else if ((enVar instanceof jc7) || (enVar instanceof pc7)) {
                    enVar.setOnAdapterItemClickListener(boVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.uc7
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (en enVar : this.c) {
                if (enVar != null && enVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.uc7
    public void l(y77 y77Var) {
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, y77Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (en enVar : this.c) {
                if (enVar instanceof d87) {
                    ((d87) enVar).z(y77Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (en enVar : this.c) {
                if (enVar instanceof d87) {
                    ((d87) enVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.uc7
    public void e() {
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (en enVar : this.c) {
                if (enVar instanceof d87) {
                    ((d87) enVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.uc7
    public void g(ArrayList<rn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            rq9.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<rn> it = arrayList.iterator();
            while (it.hasNext()) {
                rn next = it.next();
                if ((next instanceof o15) && ((o15) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<rn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    rn rnVar = arrayList.get(i);
                    if (rnVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(rnVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) rnVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<rn> arrayList) {
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<rn> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (en enVar : this.c) {
                if (enVar instanceof d87) {
                    ((d87) enVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, xn xnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, xnVar) == null) {
            this.a = frsFragment;
            this.j = x77.e().c(frsFragment.getPageContext(), uq9.d, this.a.getUniqueId(), false);
            oc7 oc7Var = new oc7(frsFragment.s(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = oc7Var;
            oc7Var.C(xnVar);
            ac7 ac7Var = new ac7(frsFragment.s(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = ac7Var;
            ac7Var.C(xnVar);
            lc7 lc7Var = new lc7(frsFragment.s(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = lc7Var;
            lc7Var.C(xnVar);
            ic7 ic7Var = new ic7(frsFragment.s(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = ic7Var;
            ic7Var.C(xnVar);
            zb7 zb7Var = new zb7(frsFragment.s(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = zb7Var;
            zb7Var.C(xnVar);
            cc7 cc7Var = new cc7(frsFragment.s(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = cc7Var;
            cc7Var.C(xnVar);
            qc7 qc7Var = new qc7(frsFragment.s(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = qc7Var;
            qc7Var.C(xnVar);
            mc7 mc7Var = new mc7(frsFragment.s(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = mc7Var;
            mc7Var.C(xnVar);
            kc7 kc7Var = new kc7(frsFragment.s(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = kc7Var;
            kc7Var.C(xnVar);
            hc7 hc7Var = new hc7(frsFragment.s(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = hc7Var;
            hc7Var.C(xnVar);
            pc7 pc7Var = new pc7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = pc7Var;
            pc7Var.C(xnVar);
            bc7 bc7Var = new bc7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = bc7Var;
            bc7Var.C(xnVar);
            fc7 fc7Var = new fc7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            fc7Var.C(xnVar);
            nc7 nc7Var = new nc7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            nc7Var.C(xnVar);
            ob7 ob7Var = new ob7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            ob7Var.C(xnVar);
            ob7Var.p(1);
            qb7 qb7Var = new qb7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            qb7Var.C(xnVar);
            pb7 pb7Var = new pb7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            pb7Var.C(xnVar);
            pb7Var.g0(true);
            vb7 vb7Var = new vb7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            vb7Var.C(xnVar);
            vb7Var.g0(true);
            wb7 wb7Var = new wb7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            wb7Var.C(xnVar);
            wb7Var.h0(true);
            pc7 pc7Var2 = new pc7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            pc7Var2.C(xnVar);
            ec7 ec7Var = new ec7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            ec7Var.C(xnVar);
            dc7 dc7Var = new dc7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            dc7Var.C(xnVar);
            this.i = new tc7(frsFragment.getPageContext(), mq9.c, this.a.getUniqueId());
            jc7 jc7Var = new jc7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = jc7Var;
            jc7Var.C(xnVar);
            en<? extends o15, ? extends TypeAdapter.ViewHolder> a = x77.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            en<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = x77.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            k87 k87Var = new k87(frsFragment.getPageContext(), l87.b);
            xb7 xb7Var = new xb7(frsFragment.getPageContext(), o87.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), q87.e, this.a.getUniqueId());
            tb7 tb7Var = new tb7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            tb7Var.x((BdTypeRecyclerView) xnVar);
            yb7 yb7Var = new yb7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            nb7 nb7Var = new nb7(frsFragment.s(), j26.g);
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
            this.c.add(fc7Var);
            this.c.add(nc7Var);
            this.c.add(ob7Var);
            this.c.add(qb7Var);
            this.c.add(pb7Var);
            this.c.add(vb7Var);
            this.c.add(wb7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(k87Var);
            this.c.add(xb7Var);
            this.c.add(ec7Var);
            this.c.add(dc7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(pc7Var2);
            this.c.add(tb7Var);
            this.c.add(yb7Var);
            this.c.add(nb7Var);
            this.c.add(new sb7(frsFragment.getPageContext()));
            this.c.add(on7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            zz5 zz5Var = new zz5(this.a, 1);
            zz5Var.u(this.c);
            zz5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, zz5Var));
            z(this.c);
            xnVar.addAdapters(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<en<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    en<?, ?> next = it.next();
                    if (next instanceof d87) {
                        ((d87) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<en> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                xn xnVar2 = this.b;
                if (xnVar2 != null) {
                    xnVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.uc7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (en enVar : this.c) {
                if (enVar instanceof d87) {
                    ((d87) enVar).x();
                } else if (enVar instanceof nf9) {
                    ((nf9) enVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (en enVar : this.c) {
            if (enVar instanceof d87) {
                ((d87) enVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        tc7 tc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (tc7Var = this.i) != null) {
            tc7Var.M(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<rn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                rn rnVar = (rn) ListUtils.getItem(arrayList, i - 1);
                rn rnVar2 = (rn) ListUtils.getItem(arrayList, i);
                if (rnVar2 instanceof o15) {
                    ThreadData threadData = ((o15) rnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (rnVar instanceof o87) {
                        threadData.needTopMargin = false;
                    } else if (rnVar != null && !p(rnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((rnVar instanceof o15) && p(rnVar) && !TextUtils.isEmpty(((o15) rnVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(rnVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.uc7
    public void setFromCDN(boolean z) {
        List<en> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (en enVar : this.c) {
                if (enVar instanceof d87) {
                    ((d87) enVar).setFromCDN(z);
                }
            }
            oc7 oc7Var = this.k;
            if (oc7Var != null) {
                oc7Var.setFromCDN(z);
            }
            ac7 ac7Var = this.l;
            if (ac7Var != null) {
                ac7Var.setFromCDN(z);
            }
            lc7 lc7Var = this.m;
            if (lc7Var != null) {
                lc7Var.setFromCDN(z);
            }
            ic7 ic7Var = this.n;
            if (ic7Var != null) {
                ic7Var.setFromCDN(z);
            }
            zb7 zb7Var = this.o;
            if (zb7Var != null) {
                zb7Var.setFromCDN(z);
            }
            cc7 cc7Var = this.p;
            if (cc7Var != null) {
                cc7Var.setFromCDN(z);
            }
            pc7 pc7Var = this.u;
            if (pc7Var != null) {
                pc7Var.setFromCDN(z);
            }
            jc7 jc7Var = this.w;
            if (jc7Var != null) {
                jc7Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<en> list;
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
            for (en enVar : this.c) {
                if (enVar != null) {
                    Class<?> cls3 = enVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(enVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(enVar, str);
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

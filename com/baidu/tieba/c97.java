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
/* loaded from: classes3.dex */
public class c97 implements q97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public on b;
    public List<vm> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<in> e;
    public FrsViewData f;
    public boolean g;
    public final x47 h;
    public p97 i;
    public vm j;
    public k97 k;
    public w87 l;
    public h97 m;
    public e97 n;
    public v87 o;
    public y87 p;
    public i97 q;
    public m97 r;
    public g97 s;
    public d97 t;
    public l97 u;
    public x87 v;
    public f97 w;

    public c97(FrsFragment frsFragment, on onVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, onVar, Boolean.valueOf(z)};
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
        this.b = onVar;
        this.h = new x47();
        o(frsFragment, onVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.q97
    public void a(String str) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (vm vmVar : list) {
            if (vmVar instanceof wg6) {
                ((wg6) vmVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.q97
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(in inVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, inVar)) == null) {
            if (inVar == null) {
                return false;
            }
            BdUniqueId type = inVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (vm vmVar : list) {
            if (vmVar instanceof qy5) {
                ((qy5) vmVar).g(str);
            }
        }
    }

    public final void z(List<vm> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (vm vmVar : list) {
            if (vmVar instanceof z47) {
                ((z47) vmVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.q97
    public void b() {
        on onVar;
        List<in> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (onVar = this.b) != null && onVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (in inVar : data) {
                if (inVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) inVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (inVar instanceof pz4) {
                    pz4 pz4Var = (pz4) inVar;
                    if (pz4Var.t.getIs_top() != 0) {
                        pz4Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        yf7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (vm vmVar : this.c) {
            if ((vmVar instanceof ag7) && (i = ((ag7) vmVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.S0() != null) {
                    int l0 = this.a.S0().l0();
                    if (l0 == -1) {
                        l0 = this.a.S0().k0();
                    }
                    i.b = l0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.q97
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

    @Override // com.baidu.tieba.q97
    public List<in> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            on onVar = this.b;
            if (onVar != null) {
                return onVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q97
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q97
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

    @Override // com.baidu.tieba.q97
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

    @Override // com.baidu.tieba.q97
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<in> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.q97
    public void d(sn snVar) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, snVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (vm vmVar : this.c) {
                if (vmVar instanceof z47) {
                    ((z47) vmVar).setOnAdapterItemClickListener(snVar);
                } else if ((vmVar instanceof f97) || (vmVar instanceof l97)) {
                    vmVar.setOnAdapterItemClickListener(snVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.q97
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (vm vmVar : this.c) {
                if (vmVar != null && vmVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.q97
    public void l(u47 u47Var) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, u47Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (vm vmVar : this.c) {
                if (vmVar instanceof z47) {
                    ((z47) vmVar).z(u47Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (vm vmVar : this.c) {
                if (vmVar instanceof z47) {
                    ((z47) vmVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.q97
    public void e() {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (vm vmVar : this.c) {
                if (vmVar instanceof z47) {
                    ((z47) vmVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.q97
    public void g(ArrayList<in> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            zk9.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<in> it = arrayList.iterator();
            while (it.hasNext()) {
                in next = it.next();
                if ((next instanceof pz4) && ((pz4) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<in> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    in inVar = arrayList.get(i);
                    if (inVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(inVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) inVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<in> arrayList) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<in> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (vm vmVar : this.c) {
                if (vmVar instanceof z47) {
                    ((z47) vmVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, onVar) == null) {
            this.a = frsFragment;
            this.j = t47.e().c(frsFragment.getPageContext(), cl9.d, this.a.getUniqueId(), false);
            k97 k97Var = new k97(frsFragment.q(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = k97Var;
            k97Var.C(onVar);
            w87 w87Var = new w87(frsFragment.q(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = w87Var;
            w87Var.C(onVar);
            h97 h97Var = new h97(frsFragment.q(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = h97Var;
            h97Var.C(onVar);
            e97 e97Var = new e97(frsFragment.q(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = e97Var;
            e97Var.C(onVar);
            v87 v87Var = new v87(frsFragment.q(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = v87Var;
            v87Var.C(onVar);
            y87 y87Var = new y87(frsFragment.q(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = y87Var;
            y87Var.C(onVar);
            m97 m97Var = new m97(frsFragment.q(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = m97Var;
            m97Var.C(onVar);
            i97 i97Var = new i97(frsFragment.q(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = i97Var;
            i97Var.C(onVar);
            g97 g97Var = new g97(frsFragment.q(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = g97Var;
            g97Var.C(onVar);
            d97 d97Var = new d97(frsFragment.q(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = d97Var;
            d97Var.C(onVar);
            l97 l97Var = new l97(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = l97Var;
            l97Var.C(onVar);
            x87 x87Var = new x87(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = x87Var;
            x87Var.C(onVar);
            b97 b97Var = new b97(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            b97Var.C(onVar);
            j97 j97Var = new j97(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            j97Var.C(onVar);
            k87 k87Var = new k87(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            k87Var.C(onVar);
            k87Var.p(1);
            m87 m87Var = new m87(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            m87Var.C(onVar);
            l87 l87Var = new l87(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            l87Var.C(onVar);
            l87Var.g0(true);
            r87 r87Var = new r87(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            r87Var.C(onVar);
            r87Var.g0(true);
            s87 s87Var = new s87(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            s87Var.C(onVar);
            s87Var.h0(true);
            l97 l97Var2 = new l97(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            l97Var2.C(onVar);
            a97 a97Var = new a97(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            a97Var.C(onVar);
            z87 z87Var = new z87(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            z87Var.C(onVar);
            this.i = new p97(frsFragment.getPageContext(), uk9.c, this.a.getUniqueId());
            f97 f97Var = new f97(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = f97Var;
            f97Var.C(onVar);
            vm<? extends pz4, ? extends TypeAdapter.ViewHolder> a = t47.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            vm<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = t47.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            g57 g57Var = new g57(frsFragment.getPageContext(), h57.b);
            t87 t87Var = new t87(frsFragment.getPageContext(), k57.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), m57.e, this.a.getUniqueId());
            p87 p87Var = new p87(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            p87Var.x((BdTypeRecyclerView) onVar);
            u87 u87Var = new u87(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            j87 j87Var = new j87(frsFragment.q(), wz5.g);
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
            this.c.add(b97Var);
            this.c.add(j97Var);
            this.c.add(k87Var);
            this.c.add(m87Var);
            this.c.add(l87Var);
            this.c.add(r87Var);
            this.c.add(s87Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(g57Var);
            this.c.add(t87Var);
            this.c.add(a97Var);
            this.c.add(z87Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(l97Var2);
            this.c.add(p87Var);
            this.c.add(u87Var);
            this.c.add(j87Var);
            this.c.add(new o87(frsFragment.getPageContext()));
            this.c.add(fk7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            nx5 nx5Var = new nx5(this.a, 1);
            nx5Var.u(this.c);
            nx5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, nx5Var));
            z(this.c);
            onVar.addAdapters(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<vm<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    vm<?, ?> next = it.next();
                    if (next instanceof z47) {
                        ((z47) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<vm> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                on onVar2 = this.b;
                if (onVar2 != null) {
                    onVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.q97
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (vm vmVar : this.c) {
                if (vmVar instanceof z47) {
                    ((z47) vmVar).x();
                } else if (vmVar instanceof ua9) {
                    ((ua9) vmVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (vm vmVar : this.c) {
            if (vmVar instanceof z47) {
                ((z47) vmVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        p97 p97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (p97Var = this.i) != null) {
            p97Var.M(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<in> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                in inVar = (in) ListUtils.getItem(arrayList, i - 1);
                in inVar2 = (in) ListUtils.getItem(arrayList, i);
                if (inVar2 instanceof pz4) {
                    ThreadData threadData = ((pz4) inVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (inVar instanceof k57) {
                        threadData.needTopMargin = false;
                    } else if (inVar != null && !p(inVar)) {
                        threadData.needTopMargin = false;
                    } else if ((inVar instanceof pz4) && p(inVar) && !TextUtils.isEmpty(((pz4) inVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(inVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.q97
    public void setFromCDN(boolean z) {
        List<vm> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (vm vmVar : this.c) {
                if (vmVar instanceof z47) {
                    ((z47) vmVar).setFromCDN(z);
                }
            }
            k97 k97Var = this.k;
            if (k97Var != null) {
                k97Var.setFromCDN(z);
            }
            w87 w87Var = this.l;
            if (w87Var != null) {
                w87Var.setFromCDN(z);
            }
            h97 h97Var = this.m;
            if (h97Var != null) {
                h97Var.setFromCDN(z);
            }
            e97 e97Var = this.n;
            if (e97Var != null) {
                e97Var.setFromCDN(z);
            }
            v87 v87Var = this.o;
            if (v87Var != null) {
                v87Var.setFromCDN(z);
            }
            y87 y87Var = this.p;
            if (y87Var != null) {
                y87Var.setFromCDN(z);
            }
            l97 l97Var = this.u;
            if (l97Var != null) {
                l97Var.setFromCDN(z);
            }
            f97 f97Var = this.w;
            if (f97Var != null) {
                f97Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<vm> list;
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
            for (vm vmVar : this.c) {
                if (vmVar != null) {
                    Class<?> cls3 = vmVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(vmVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(vmVar, str);
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

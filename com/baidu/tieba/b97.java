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
public class b97 implements p97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public nn b;
    public List<um> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<hn> e;
    public FrsViewData f;
    public boolean g;
    public final w47 h;
    public o97 i;
    public um j;
    public j97 k;
    public v87 l;
    public g97 m;
    public d97 n;
    public u87 o;
    public x87 p;
    public h97 q;
    public l97 r;
    public f97 s;
    public c97 t;
    public k97 u;
    public w87 v;
    public e97 w;

    public b97(FrsFragment frsFragment, nn nnVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, nnVar, Boolean.valueOf(z)};
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
        this.b = nnVar;
        this.h = new w47();
        o(frsFragment, nnVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.p97
    public void a(String str) {
        List<um> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (um umVar : list) {
            if (umVar instanceof vg6) {
                ((vg6) umVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.p97
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(hn hnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, hnVar)) == null) {
            if (hnVar == null) {
                return false;
            }
            BdUniqueId type = hnVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<um> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (um umVar : list) {
            if (umVar instanceof py5) {
                ((py5) umVar).g(str);
            }
        }
    }

    public final void z(List<um> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (um umVar : list) {
            if (umVar instanceof y47) {
                ((y47) umVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.p97
    public void b() {
        nn nnVar;
        List<hn> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (nnVar = this.b) != null && nnVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (hn hnVar : data) {
                if (hnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) hnVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (hnVar instanceof oz4) {
                    oz4 oz4Var = (oz4) hnVar;
                    if (oz4Var.t.getIs_top() != 0) {
                        oz4Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        xf7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (um umVar : this.c) {
            if ((umVar instanceof zf7) && (i = ((zf7) umVar).i()) != null) {
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

    @Override // com.baidu.tieba.p97
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

    @Override // com.baidu.tieba.p97
    public List<hn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            nn nnVar = this.b;
            if (nnVar != null) {
                return nnVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p97
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p97
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

    @Override // com.baidu.tieba.p97
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

    @Override // com.baidu.tieba.p97
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<hn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.p97
    public void d(rn rnVar) {
        List<um> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, rnVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (um umVar : this.c) {
                if (umVar instanceof y47) {
                    ((y47) umVar).setOnAdapterItemClickListener(rnVar);
                } else if ((umVar instanceof e97) || (umVar instanceof k97)) {
                    umVar.setOnAdapterItemClickListener(rnVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.p97
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (um umVar : this.c) {
                if (umVar != null && umVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.p97
    public void l(t47 t47Var) {
        List<um> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, t47Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (um umVar : this.c) {
                if (umVar instanceof y47) {
                    ((y47) umVar).z(t47Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<um> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (um umVar : this.c) {
                if (umVar instanceof y47) {
                    ((y47) umVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.p97
    public void e() {
        List<um> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (um umVar : this.c) {
                if (umVar instanceof y47) {
                    ((y47) umVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.p97
    public void g(ArrayList<hn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            rk9.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<hn> it = arrayList.iterator();
            while (it.hasNext()) {
                hn next = it.next();
                if ((next instanceof oz4) && ((oz4) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<hn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    hn hnVar = arrayList.get(i);
                    if (hnVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(hnVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) hnVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<hn> arrayList) {
        List<um> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<hn> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (um umVar : this.c) {
                if (umVar instanceof y47) {
                    ((y47) umVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, nnVar) == null) {
            this.a = frsFragment;
            this.j = s47.e().c(frsFragment.getPageContext(), uk9.d, this.a.getUniqueId(), false);
            j97 j97Var = new j97(frsFragment.q(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = j97Var;
            j97Var.C(nnVar);
            v87 v87Var = new v87(frsFragment.q(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = v87Var;
            v87Var.C(nnVar);
            g97 g97Var = new g97(frsFragment.q(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = g97Var;
            g97Var.C(nnVar);
            d97 d97Var = new d97(frsFragment.q(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = d97Var;
            d97Var.C(nnVar);
            u87 u87Var = new u87(frsFragment.q(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = u87Var;
            u87Var.C(nnVar);
            x87 x87Var = new x87(frsFragment.q(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = x87Var;
            x87Var.C(nnVar);
            l97 l97Var = new l97(frsFragment.q(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = l97Var;
            l97Var.C(nnVar);
            h97 h97Var = new h97(frsFragment.q(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = h97Var;
            h97Var.C(nnVar);
            f97 f97Var = new f97(frsFragment.q(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = f97Var;
            f97Var.C(nnVar);
            c97 c97Var = new c97(frsFragment.q(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = c97Var;
            c97Var.C(nnVar);
            k97 k97Var = new k97(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = k97Var;
            k97Var.C(nnVar);
            w87 w87Var = new w87(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = w87Var;
            w87Var.C(nnVar);
            a97 a97Var = new a97(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            a97Var.C(nnVar);
            i97 i97Var = new i97(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            i97Var.C(nnVar);
            j87 j87Var = new j87(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            j87Var.C(nnVar);
            j87Var.p(1);
            l87 l87Var = new l87(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            l87Var.C(nnVar);
            k87 k87Var = new k87(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            k87Var.C(nnVar);
            k87Var.g0(true);
            q87 q87Var = new q87(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            q87Var.C(nnVar);
            q87Var.g0(true);
            r87 r87Var = new r87(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            r87Var.C(nnVar);
            r87Var.h0(true);
            k97 k97Var2 = new k97(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            k97Var2.C(nnVar);
            z87 z87Var = new z87(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            z87Var.C(nnVar);
            y87 y87Var = new y87(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            y87Var.C(nnVar);
            this.i = new o97(frsFragment.getPageContext(), mk9.c, this.a.getUniqueId());
            e97 e97Var = new e97(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = e97Var;
            e97Var.C(nnVar);
            um<? extends oz4, ? extends TypeAdapter.ViewHolder> a = s47.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            um<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = s47.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            f57 f57Var = new f57(frsFragment.getPageContext(), g57.b);
            s87 s87Var = new s87(frsFragment.getPageContext(), j57.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), l57.e, this.a.getUniqueId());
            o87 o87Var = new o87(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            o87Var.x((BdTypeRecyclerView) nnVar);
            t87 t87Var = new t87(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            i87 i87Var = new i87(frsFragment.q(), vz5.g);
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
            this.c.add(a97Var);
            this.c.add(i97Var);
            this.c.add(j87Var);
            this.c.add(l87Var);
            this.c.add(k87Var);
            this.c.add(q87Var);
            this.c.add(r87Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(f57Var);
            this.c.add(s87Var);
            this.c.add(z87Var);
            this.c.add(y87Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(k97Var2);
            this.c.add(o87Var);
            this.c.add(t87Var);
            this.c.add(i87Var);
            this.c.add(new n87(frsFragment.getPageContext()));
            this.c.add(ek7.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            mx5 mx5Var = new mx5(this.a, 1);
            mx5Var.u(this.c);
            mx5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, mx5Var));
            z(this.c);
            nnVar.addAdapters(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<um<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    um<?, ?> next = it.next();
                    if (next instanceof y47) {
                        ((y47) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<um> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                nn nnVar2 = this.b;
                if (nnVar2 != null) {
                    nnVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.p97
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (um umVar : this.c) {
                if (umVar instanceof y47) {
                    ((y47) umVar).x();
                } else if (umVar instanceof ma9) {
                    ((ma9) umVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (um umVar : this.c) {
            if (umVar instanceof y47) {
                ((y47) umVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        o97 o97Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (o97Var = this.i) != null) {
            o97Var.M(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<hn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                hn hnVar = (hn) ListUtils.getItem(arrayList, i - 1);
                hn hnVar2 = (hn) ListUtils.getItem(arrayList, i);
                if (hnVar2 instanceof oz4) {
                    ThreadData threadData = ((oz4) hnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (hnVar instanceof j57) {
                        threadData.needTopMargin = false;
                    } else if (hnVar != null && !p(hnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((hnVar instanceof oz4) && p(hnVar) && !TextUtils.isEmpty(((oz4) hnVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(hnVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.p97
    public void setFromCDN(boolean z) {
        List<um> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (um umVar : this.c) {
                if (umVar instanceof y47) {
                    ((y47) umVar).setFromCDN(z);
                }
            }
            j97 j97Var = this.k;
            if (j97Var != null) {
                j97Var.setFromCDN(z);
            }
            v87 v87Var = this.l;
            if (v87Var != null) {
                v87Var.setFromCDN(z);
            }
            g97 g97Var = this.m;
            if (g97Var != null) {
                g97Var.setFromCDN(z);
            }
            d97 d97Var = this.n;
            if (d97Var != null) {
                d97Var.setFromCDN(z);
            }
            u87 u87Var = this.o;
            if (u87Var != null) {
                u87Var.setFromCDN(z);
            }
            x87 x87Var = this.p;
            if (x87Var != null) {
                x87Var.setFromCDN(z);
            }
            k97 k97Var = this.u;
            if (k97Var != null) {
                k97Var.setFromCDN(z);
            }
            e97 e97Var = this.w;
            if (e97Var != null) {
                e97Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<um> list;
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
            for (um umVar : this.c) {
                if (umVar != null) {
                    Class<?> cls3 = umVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(umVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(umVar, str);
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

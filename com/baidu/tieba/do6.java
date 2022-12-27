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
public class do6 implements ro6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public Cdo b;
    public List<kn> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<xn> e;
    public FrsViewData f;
    public boolean g;
    public final ak6 h;
    public qo6 i;
    public kn j;
    public lo6 k;
    public xn6 l;
    public io6 m;
    public fo6 n;
    public wn6 o;
    public zn6 p;
    public jo6 q;
    public no6 r;
    public ho6 s;
    public eo6 t;
    public mo6 u;
    public yn6 v;
    public go6 w;

    public do6(FrsFragment frsFragment, Cdo cdo, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, cdo, Boolean.valueOf(z)};
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
        this.b = cdo;
        this.h = new ak6();
        o(frsFragment, cdo);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.ro6
    public void a(String str) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (kn knVar : list) {
            if (knVar instanceof f56) {
                ((f56) knVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.ro6
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(xn xnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, xnVar)) == null) {
            if (xnVar == null) {
                return false;
            }
            BdUniqueId type = xnVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (kn knVar : list) {
            if (knVar instanceof hr5) {
                ((hr5) knVar).g(str);
            }
        }
    }

    public final void z(List<kn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (kn knVar : list) {
            if (knVar instanceof ck6) {
                ((ck6) knVar).w(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.ro6
    public void b() {
        Cdo cdo;
        List<xn> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (cdo = this.b) != null && cdo.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (xn xnVar : data) {
                if (xnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) xnVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (xnVar instanceof yu4) {
                    yu4 yu4Var = (yu4) xnVar;
                    if (yu4Var.t.getIs_top() != 0) {
                        yu4Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        yu6 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (kn knVar : this.c) {
            if ((knVar instanceof av6) && (i = ((av6) knVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.N0() != null) {
                    int b0 = this.a.N0().b0();
                    if (b0 == -1) {
                        b0 = this.a.N0().a0();
                    }
                    i.b = b0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.ro6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b53;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ro6
    public List<xn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Cdo cdo = this.b;
            if (cdo != null) {
                return cdo.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ro6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ro6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b2e;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ro6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090bf9;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ro6
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<xn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ro6
    public void d(ho hoVar) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, hoVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof ck6) {
                    ((ck6) knVar).setOnAdapterItemClickListener(hoVar);
                } else if ((knVar instanceof go6) || (knVar instanceof mo6)) {
                    knVar.setOnAdapterItemClickListener(hoVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ro6
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (kn knVar : this.c) {
                if (knVar != null && knVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ro6
    public void l(xj6 xj6Var) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, xj6Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof ck6) {
                    ((ck6) knVar).x(xj6Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof ck6) {
                    ((ck6) knVar).y(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ro6
    public void e() {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof ck6) {
                    ((ck6) knVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.ro6
    public void g(ArrayList<xn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            lr8.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<xn> it = arrayList.iterator();
            while (it.hasNext()) {
                xn next = it.next();
                if ((next instanceof yu4) && ((yu4) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<xn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    xn xnVar = arrayList.get(i);
                    if (xnVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(xnVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) xnVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<xn> arrayList) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<xn> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (kn knVar : this.c) {
                if (knVar instanceof ck6) {
                    ((ck6) knVar).D(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, cdo) == null) {
            this.a = frsFragment;
            this.j = wj6.e().c(frsFragment.getPageContext(), or8.d, this.a.getUniqueId(), false);
            lo6 lo6Var = new lo6(frsFragment.p(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = lo6Var;
            lo6Var.A(cdo);
            xn6 xn6Var = new xn6(frsFragment.p(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = xn6Var;
            xn6Var.A(cdo);
            io6 io6Var = new io6(frsFragment.p(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = io6Var;
            io6Var.A(cdo);
            fo6 fo6Var = new fo6(frsFragment.p(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = fo6Var;
            fo6Var.A(cdo);
            wn6 wn6Var = new wn6(frsFragment.p(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = wn6Var;
            wn6Var.A(cdo);
            zn6 zn6Var = new zn6(frsFragment.p(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = zn6Var;
            zn6Var.A(cdo);
            no6 no6Var = new no6(frsFragment.p(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = no6Var;
            no6Var.A(cdo);
            jo6 jo6Var = new jo6(frsFragment.p(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = jo6Var;
            jo6Var.A(cdo);
            ho6 ho6Var = new ho6(frsFragment.p(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = ho6Var;
            ho6Var.A(cdo);
            eo6 eo6Var = new eo6(frsFragment.p(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = eo6Var;
            eo6Var.A(cdo);
            mo6 mo6Var = new mo6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = mo6Var;
            mo6Var.A(cdo);
            yn6 yn6Var = new yn6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = yn6Var;
            yn6Var.A(cdo);
            co6 co6Var = new co6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            co6Var.A(cdo);
            ko6 ko6Var = new ko6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            ko6Var.A(cdo);
            mn6 mn6Var = new mn6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            mn6Var.A(cdo);
            mn6Var.p(1);
            on6 on6Var = new on6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            on6Var.A(cdo);
            nn6 nn6Var = new nn6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            nn6Var.A(cdo);
            nn6Var.e0(true);
            sn6 sn6Var = new sn6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            sn6Var.A(cdo);
            sn6Var.e0(true);
            tn6 tn6Var = new tn6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            tn6Var.A(cdo);
            tn6Var.f0(true);
            mo6 mo6Var2 = new mo6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            mo6Var2.A(cdo);
            bo6 bo6Var = new bo6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            bo6Var.A(cdo);
            ao6 ao6Var = new ao6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            ao6Var.A(cdo);
            this.i = new qo6(frsFragment.getPageContext(), gr8.c, this.a.getUniqueId());
            go6 go6Var = new go6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = go6Var;
            go6Var.A(cdo);
            kn<? extends yu4, ? extends TypeAdapter.ViewHolder> a = wj6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            kn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = wj6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            jk6 jk6Var = new jk6(frsFragment.getPageContext(), kk6.b);
            un6 un6Var = new un6(frsFragment.getPageContext(), nk6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), pk6.e, this.a.getUniqueId());
            qn6 qn6Var = new qn6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            qn6Var.v((BdTypeRecyclerView) cdo);
            vn6 vn6Var = new vn6(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            ln6 ln6Var = new ln6(frsFragment.p(), ms5.g);
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
            this.c.add(co6Var);
            this.c.add(ko6Var);
            this.c.add(mn6Var);
            this.c.add(on6Var);
            this.c.add(nn6Var);
            this.c.add(sn6Var);
            this.c.add(tn6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(jk6Var);
            this.c.add(un6Var);
            this.c.add(bo6Var);
            this.c.add(ao6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(mo6Var2);
            this.c.add(qn6Var);
            this.c.add(vn6Var);
            this.c.add(ln6Var);
            this.c.add(wx6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            eq5 eq5Var = new eq5(this.a, 1);
            eq5Var.u(this.c);
            eq5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, eq5Var));
            z(this.c);
            cdo.a(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<kn<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    kn<?, ?> next = it.next();
                    if (next instanceof ck6) {
                        ((ck6) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<kn> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                Cdo cdo2 = this.b;
                if (cdo2 != null) {
                    cdo2.a(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ro6
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (kn knVar : this.c) {
                if (knVar instanceof ck6) {
                    ((ck6) knVar).v();
                } else if (knVar instanceof ri8) {
                    ((ri8) knVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (kn knVar : this.c) {
            if (knVar instanceof ck6) {
                ((ck6) knVar).C(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        qo6 qo6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (qo6Var = this.i) != null) {
            qo6Var.K(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<xn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                xn xnVar = (xn) ListUtils.getItem(arrayList, i - 1);
                xn xnVar2 = (xn) ListUtils.getItem(arrayList, i);
                if (xnVar2 instanceof yu4) {
                    ThreadData threadData = ((yu4) xnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (xnVar instanceof nk6) {
                        threadData.needTopMargin = false;
                    } else if (xnVar != null && !p(xnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((xnVar instanceof yu4) && p(xnVar) && !TextUtils.isEmpty(((yu4) xnVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(xnVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ro6
    public void setFromCDN(boolean z) {
        List<kn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (kn knVar : this.c) {
                if (knVar instanceof ck6) {
                    ((ck6) knVar).setFromCDN(z);
                }
            }
            lo6 lo6Var = this.k;
            if (lo6Var != null) {
                lo6Var.setFromCDN(z);
            }
            xn6 xn6Var = this.l;
            if (xn6Var != null) {
                xn6Var.setFromCDN(z);
            }
            io6 io6Var = this.m;
            if (io6Var != null) {
                io6Var.setFromCDN(z);
            }
            fo6 fo6Var = this.n;
            if (fo6Var != null) {
                fo6Var.setFromCDN(z);
            }
            wn6 wn6Var = this.o;
            if (wn6Var != null) {
                wn6Var.setFromCDN(z);
            }
            zn6 zn6Var = this.p;
            if (zn6Var != null) {
                zn6Var.setFromCDN(z);
            }
            mo6 mo6Var = this.u;
            if (mo6Var != null) {
                mo6Var.setFromCDN(z);
            }
            go6 go6Var = this.w;
            if (go6Var != null) {
                go6Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<kn> list;
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
            for (kn knVar : this.c) {
                if (knVar != null) {
                    Class<?> cls3 = knVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(knVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(knVar, str);
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

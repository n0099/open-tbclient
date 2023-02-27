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
public class cz6 implements qz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public jo b;
    public List<qn> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<Cdo> e;
    public FrsViewData f;
    public boolean g;
    public final xu6 h;
    public pz6 i;
    public qn j;
    public kz6 k;
    public wy6 l;
    public hz6 m;
    public ez6 n;
    public vy6 o;
    public yy6 p;
    public iz6 q;
    public mz6 r;
    public gz6 s;
    public dz6 t;
    public lz6 u;
    public xy6 v;
    public fz6 w;

    public cz6(FrsFragment frsFragment, jo joVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, joVar, Boolean.valueOf(z)};
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
        this.b = joVar;
        this.h = new xu6();
        o(frsFragment, joVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.qz6
    public void a(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof vf6) {
                ((vf6) qnVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.qz6
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(Cdo cdo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, cdo)) == null) {
            if (cdo == null) {
                return false;
            }
            BdUniqueId type = cdo.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof dy5) {
                ((dy5) qnVar).g(str);
            }
        }
    }

    public final void z(List<qn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof zu6) {
                ((zu6) qnVar).w(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.qz6
    public void b() {
        jo joVar;
        List<Cdo> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (joVar = this.b) != null && joVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (Cdo cdo : data) {
                if (cdo instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) cdo;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (cdo instanceof d15) {
                    d15 d15Var = (d15) cdo;
                    if (d15Var.t.getIs_top() != 0) {
                        d15Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        x57 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (qn qnVar : this.c) {
            if ((qnVar instanceof z57) && (i = ((z57) qnVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.P0() != null) {
                    int i0 = this.a.P0().i0();
                    if (i0 == -1) {
                        i0 = this.a.P0().h0();
                    }
                    i.b = i0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.qz6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090bf6;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qz6
    public List<Cdo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            jo joVar = this.b;
            if (joVar != null) {
                return joVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qz6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qz6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090bd1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qz6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c9b;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qz6
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<Cdo> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.qz6
    public void d(no noVar) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, noVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (qn qnVar : this.c) {
                if (qnVar instanceof zu6) {
                    ((zu6) qnVar).setOnAdapterItemClickListener(noVar);
                } else if ((qnVar instanceof fz6) || (qnVar instanceof lz6)) {
                    qnVar.setOnAdapterItemClickListener(noVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.qz6
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (qn qnVar : this.c) {
                if (qnVar != null && qnVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.qz6
    public void l(uu6 uu6Var) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, uu6Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (qn qnVar : this.c) {
                if (qnVar instanceof zu6) {
                    ((zu6) qnVar).x(uu6Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (qn qnVar : this.c) {
                if (qnVar instanceof zu6) {
                    ((zu6) qnVar).y(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.qz6
    public void e() {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (qn qnVar : this.c) {
                if (qnVar instanceof zu6) {
                    ((zu6) qnVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.qz6
    public void g(ArrayList<Cdo> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            v49.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<Cdo> it = arrayList.iterator();
            while (it.hasNext()) {
                Cdo next = it.next();
                if ((next instanceof d15) && ((d15) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<Cdo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    Cdo cdo = arrayList.get(i);
                    if (cdo instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(cdo)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) cdo);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<Cdo> arrayList) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Cdo> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (qn qnVar : this.c) {
                if (qnVar instanceof zu6) {
                    ((zu6) qnVar).D(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, joVar) == null) {
            this.a = frsFragment;
            this.j = tu6.e().c(frsFragment.getPageContext(), y49.d, this.a.getUniqueId(), false);
            kz6 kz6Var = new kz6(frsFragment.p(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = kz6Var;
            kz6Var.A(joVar);
            wy6 wy6Var = new wy6(frsFragment.p(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = wy6Var;
            wy6Var.A(joVar);
            hz6 hz6Var = new hz6(frsFragment.p(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = hz6Var;
            hz6Var.A(joVar);
            ez6 ez6Var = new ez6(frsFragment.p(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = ez6Var;
            ez6Var.A(joVar);
            vy6 vy6Var = new vy6(frsFragment.p(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = vy6Var;
            vy6Var.A(joVar);
            yy6 yy6Var = new yy6(frsFragment.p(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = yy6Var;
            yy6Var.A(joVar);
            mz6 mz6Var = new mz6(frsFragment.p(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = mz6Var;
            mz6Var.A(joVar);
            iz6 iz6Var = new iz6(frsFragment.p(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = iz6Var;
            iz6Var.A(joVar);
            gz6 gz6Var = new gz6(frsFragment.p(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = gz6Var;
            gz6Var.A(joVar);
            dz6 dz6Var = new dz6(frsFragment.p(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = dz6Var;
            dz6Var.A(joVar);
            lz6 lz6Var = new lz6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = lz6Var;
            lz6Var.A(joVar);
            xy6 xy6Var = new xy6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = xy6Var;
            xy6Var.A(joVar);
            bz6 bz6Var = new bz6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            bz6Var.A(joVar);
            jz6 jz6Var = new jz6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            jz6Var.A(joVar);
            ky6 ky6Var = new ky6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            ky6Var.A(joVar);
            ky6Var.p(1);
            my6 my6Var = new my6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            my6Var.A(joVar);
            ly6 ly6Var = new ly6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ly6Var.A(joVar);
            ly6Var.e0(true);
            ry6 ry6Var = new ry6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            ry6Var.A(joVar);
            ry6Var.e0(true);
            sy6 sy6Var = new sy6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            sy6Var.A(joVar);
            sy6Var.f0(true);
            lz6 lz6Var2 = new lz6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            lz6Var2.A(joVar);
            az6 az6Var = new az6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            az6Var.A(joVar);
            zy6 zy6Var = new zy6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            zy6Var.A(joVar);
            this.i = new pz6(frsFragment.getPageContext(), q49.c, this.a.getUniqueId());
            fz6 fz6Var = new fz6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = fz6Var;
            fz6Var.A(joVar);
            qn<? extends d15, ? extends TypeAdapter.ViewHolder> a = tu6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            qn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = tu6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            gv6 gv6Var = new gv6(frsFragment.getPageContext(), hv6.b);
            ty6 ty6Var = new ty6(frsFragment.getPageContext(), kv6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), mv6.e, this.a.getUniqueId());
            py6 py6Var = new py6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            py6Var.v((BdTypeRecyclerView) joVar);
            uy6 uy6Var = new uy6(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            jy6 jy6Var = new jy6(frsFragment.p(), jz5.g);
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
            this.c.add(bz6Var);
            this.c.add(jz6Var);
            this.c.add(ky6Var);
            this.c.add(my6Var);
            this.c.add(ly6Var);
            this.c.add(ry6Var);
            this.c.add(sy6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(gv6Var);
            this.c.add(ty6Var);
            this.c.add(az6Var);
            this.c.add(zy6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(lz6Var2);
            this.c.add(py6Var);
            this.c.add(uy6Var);
            this.c.add(jy6Var);
            this.c.add(new oy6(frsFragment.getPageContext()));
            this.c.add(b97.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            ax5 ax5Var = new ax5(this.a, 1);
            ax5Var.u(this.c);
            ax5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, ax5Var));
            z(this.c);
            joVar.a(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
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
                List<qn> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                jo joVar2 = this.b;
                if (joVar2 != null) {
                    joVar2.a(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.qz6
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (qn qnVar : this.c) {
                if (qnVar instanceof zu6) {
                    ((zu6) qnVar).v();
                } else if (qnVar instanceof tv8) {
                    ((tv8) qnVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof zu6) {
                ((zu6) qnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        pz6 pz6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (pz6Var = this.i) != null) {
            pz6Var.K(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                Cdo cdo = (Cdo) ListUtils.getItem(arrayList, i - 1);
                Cdo cdo2 = (Cdo) ListUtils.getItem(arrayList, i);
                if (cdo2 instanceof d15) {
                    ThreadData threadData = ((d15) cdo2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (cdo instanceof kv6) {
                        threadData.needTopMargin = false;
                    } else if (cdo != null && !p(cdo)) {
                        threadData.needTopMargin = false;
                    } else if ((cdo instanceof d15) && p(cdo) && !TextUtils.isEmpty(((d15) cdo).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(cdo2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.qz6
    public void setFromCDN(boolean z) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (qn qnVar : this.c) {
                if (qnVar instanceof zu6) {
                    ((zu6) qnVar).setFromCDN(z);
                }
            }
            kz6 kz6Var = this.k;
            if (kz6Var != null) {
                kz6Var.setFromCDN(z);
            }
            wy6 wy6Var = this.l;
            if (wy6Var != null) {
                wy6Var.setFromCDN(z);
            }
            hz6 hz6Var = this.m;
            if (hz6Var != null) {
                hz6Var.setFromCDN(z);
            }
            ez6 ez6Var = this.n;
            if (ez6Var != null) {
                ez6Var.setFromCDN(z);
            }
            vy6 vy6Var = this.o;
            if (vy6Var != null) {
                vy6Var.setFromCDN(z);
            }
            yy6 yy6Var = this.p;
            if (yy6Var != null) {
                yy6Var.setFromCDN(z);
            }
            lz6 lz6Var = this.u;
            if (lz6Var != null) {
                lz6Var.setFromCDN(z);
            }
            fz6 fz6Var = this.w;
            if (fz6Var != null) {
                fz6Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<qn> list;
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
            for (qn qnVar : this.c) {
                if (qnVar != null) {
                    Class<?> cls3 = qnVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(qnVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(qnVar, str);
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

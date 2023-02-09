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
public class dw6 implements rw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public jo b;
    public List<qn> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<Cdo> e;
    public FrsViewData f;
    public boolean g;
    public final yr6 h;
    public qw6 i;
    public qn j;
    public lw6 k;
    public xv6 l;
    public iw6 m;
    public fw6 n;
    public wv6 o;
    public zv6 p;
    public jw6 q;
    public nw6 r;
    public hw6 s;
    public ew6 t;
    public mw6 u;
    public yv6 v;
    public gw6 w;

    public dw6(FrsFragment frsFragment, jo joVar, boolean z) {
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
        this.h = new yr6();
        o(frsFragment, joVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.rw6
    public void a(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof jd6) {
                ((jd6) qnVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.rw6
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
            if (qnVar instanceof mw5) {
                ((mw5) qnVar).g(str);
            }
        }
    }

    public final void z(List<qn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof as6) {
                ((as6) qnVar).w(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.rw6
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
                } else if (cdo instanceof wz4) {
                    wz4 wz4Var = (wz4) cdo;
                    if (wz4Var.t.getIs_top() != 0) {
                        wz4Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        b37 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (qn qnVar : this.c) {
            if ((qnVar instanceof d37) && (i = ((d37) qnVar).i()) != null) {
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
                    int b0 = this.a.P0().b0();
                    if (b0 == -1) {
                        b0 = this.a.P0().a0();
                    }
                    i.b = b0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.rw6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090bb5;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rw6
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

    @Override // com.baidu.tieba.rw6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rw6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b90;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rw6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c5a;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rw6
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

    @Override // com.baidu.tieba.rw6
    public void d(no noVar) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, noVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (qn qnVar : this.c) {
                if (qnVar instanceof as6) {
                    ((as6) qnVar).setOnAdapterItemClickListener(noVar);
                } else if ((qnVar instanceof gw6) || (qnVar instanceof mw6)) {
                    qnVar.setOnAdapterItemClickListener(noVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.rw6
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

    @Override // com.baidu.tieba.rw6
    public void l(vr6 vr6Var) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, vr6Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (qn qnVar : this.c) {
                if (qnVar instanceof as6) {
                    ((as6) qnVar).x(vr6Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (qn qnVar : this.c) {
                if (qnVar instanceof as6) {
                    ((as6) qnVar).y(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.rw6
    public void e() {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (qn qnVar : this.c) {
                if (qnVar instanceof as6) {
                    ((as6) qnVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.rw6
    public void g(ArrayList<Cdo> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            j19.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<Cdo> it = arrayList.iterator();
            while (it.hasNext()) {
                Cdo next = it.next();
                if ((next instanceof wz4) && ((wz4) next).t.isTop()) {
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
                if (qnVar instanceof as6) {
                    ((as6) qnVar).D(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, joVar) == null) {
            this.a = frsFragment;
            this.j = ur6.e().c(frsFragment.getPageContext(), m19.d, this.a.getUniqueId(), false);
            lw6 lw6Var = new lw6(frsFragment.p(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = lw6Var;
            lw6Var.A(joVar);
            xv6 xv6Var = new xv6(frsFragment.p(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = xv6Var;
            xv6Var.A(joVar);
            iw6 iw6Var = new iw6(frsFragment.p(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = iw6Var;
            iw6Var.A(joVar);
            fw6 fw6Var = new fw6(frsFragment.p(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = fw6Var;
            fw6Var.A(joVar);
            wv6 wv6Var = new wv6(frsFragment.p(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = wv6Var;
            wv6Var.A(joVar);
            zv6 zv6Var = new zv6(frsFragment.p(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = zv6Var;
            zv6Var.A(joVar);
            nw6 nw6Var = new nw6(frsFragment.p(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = nw6Var;
            nw6Var.A(joVar);
            jw6 jw6Var = new jw6(frsFragment.p(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = jw6Var;
            jw6Var.A(joVar);
            hw6 hw6Var = new hw6(frsFragment.p(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = hw6Var;
            hw6Var.A(joVar);
            ew6 ew6Var = new ew6(frsFragment.p(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = ew6Var;
            ew6Var.A(joVar);
            mw6 mw6Var = new mw6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = mw6Var;
            mw6Var.A(joVar);
            yv6 yv6Var = new yv6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = yv6Var;
            yv6Var.A(joVar);
            cw6 cw6Var = new cw6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            cw6Var.A(joVar);
            kw6 kw6Var = new kw6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            kw6Var.A(joVar);
            lv6 lv6Var = new lv6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            lv6Var.A(joVar);
            lv6Var.p(1);
            nv6 nv6Var = new nv6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            nv6Var.A(joVar);
            mv6 mv6Var = new mv6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            mv6Var.A(joVar);
            mv6Var.e0(true);
            sv6 sv6Var = new sv6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            sv6Var.A(joVar);
            sv6Var.e0(true);
            tv6 tv6Var = new tv6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            tv6Var.A(joVar);
            tv6Var.f0(true);
            mw6 mw6Var2 = new mw6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            mw6Var2.A(joVar);
            bw6 bw6Var = new bw6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            bw6Var.A(joVar);
            aw6 aw6Var = new aw6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            aw6Var.A(joVar);
            this.i = new qw6(frsFragment.getPageContext(), e19.c, this.a.getUniqueId());
            gw6 gw6Var = new gw6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = gw6Var;
            gw6Var.A(joVar);
            qn<? extends wz4, ? extends TypeAdapter.ViewHolder> a = ur6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            qn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = ur6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            hs6 hs6Var = new hs6(frsFragment.getPageContext(), is6.b);
            uv6 uv6Var = new uv6(frsFragment.getPageContext(), ls6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), ns6.e, this.a.getUniqueId());
            qv6 qv6Var = new qv6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            qv6Var.v((BdTypeRecyclerView) joVar);
            vv6 vv6Var = new vv6(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            kv6 kv6Var = new kv6(frsFragment.p(), sx5.g);
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
            this.c.add(cw6Var);
            this.c.add(kw6Var);
            this.c.add(lv6Var);
            this.c.add(nv6Var);
            this.c.add(mv6Var);
            this.c.add(sv6Var);
            this.c.add(tv6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(hs6Var);
            this.c.add(uv6Var);
            this.c.add(bw6Var);
            this.c.add(aw6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(mw6Var2);
            this.c.add(qv6Var);
            this.c.add(vv6Var);
            this.c.add(kv6Var);
            this.c.add(new pv6(frsFragment.getPageContext()));
            this.c.add(f67.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            jv5 jv5Var = new jv5(this.a, 1);
            jv5Var.u(this.c);
            jv5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, jv5Var));
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
                    if (next instanceof as6) {
                        ((as6) next).m(this.a.getPageContext(), this.a.getUniqueId());
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

    @Override // com.baidu.tieba.rw6
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (qn qnVar : this.c) {
                if (qnVar instanceof as6) {
                    ((as6) qnVar).v();
                } else if (qnVar instanceof hs8) {
                    ((hs8) qnVar).onDestroy();
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
            if (qnVar instanceof as6) {
                ((as6) qnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        qw6 qw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (qw6Var = this.i) != null) {
            qw6Var.K(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                Cdo cdo = (Cdo) ListUtils.getItem(arrayList, i - 1);
                Cdo cdo2 = (Cdo) ListUtils.getItem(arrayList, i);
                if (cdo2 instanceof wz4) {
                    ThreadData threadData = ((wz4) cdo2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (cdo instanceof ls6) {
                        threadData.needTopMargin = false;
                    } else if (cdo != null && !p(cdo)) {
                        threadData.needTopMargin = false;
                    } else if ((cdo instanceof wz4) && p(cdo) && !TextUtils.isEmpty(((wz4) cdo).t.getRecomReason())) {
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

    @Override // com.baidu.tieba.rw6
    public void setFromCDN(boolean z) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (qn qnVar : this.c) {
                if (qnVar instanceof as6) {
                    ((as6) qnVar).setFromCDN(z);
                }
            }
            lw6 lw6Var = this.k;
            if (lw6Var != null) {
                lw6Var.setFromCDN(z);
            }
            xv6 xv6Var = this.l;
            if (xv6Var != null) {
                xv6Var.setFromCDN(z);
            }
            iw6 iw6Var = this.m;
            if (iw6Var != null) {
                iw6Var.setFromCDN(z);
            }
            fw6 fw6Var = this.n;
            if (fw6Var != null) {
                fw6Var.setFromCDN(z);
            }
            wv6 wv6Var = this.o;
            if (wv6Var != null) {
                wv6Var.setFromCDN(z);
            }
            zv6 zv6Var = this.p;
            if (zv6Var != null) {
                zv6Var.setFromCDN(z);
            }
            mw6 mw6Var = this.u;
            if (mw6Var != null) {
                mw6Var.setFromCDN(z);
            }
            gw6 gw6Var = this.w;
            if (gw6Var != null) {
                gw6Var.setFromCDN(z);
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

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
/* loaded from: classes6.dex */
public class gl7 implements ul7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public hn b;
    public List<om> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<bn> e;
    public FrsViewData f;
    public boolean g;
    public final wg7 h;
    public tl7 i;
    public om j;
    public ol7 k;
    public al7 l;
    public ll7 m;
    public il7 n;
    public zk7 o;
    public cl7 p;
    public ml7 q;
    public ql7 r;
    public kl7 s;
    public hl7 t;
    public pl7 u;
    public bl7 v;
    public jl7 w;

    public gl7(FrsFragment frsFragment, hn hnVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, hnVar, Boolean.valueOf(z)};
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
        this.b = hnVar;
        this.h = new wg7();
        o(frsFragment, hnVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.ul7
    public void a(String str) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (om omVar : list) {
            if (omVar instanceof ho6) {
                ((ho6) omVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.ul7
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(bn bnVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bnVar)) == null) {
            if (bnVar == null) {
                return false;
            }
            BdUniqueId type = bnVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (om omVar : list) {
            if (omVar instanceof s46) {
                ((s46) omVar).g(str);
            }
        }
    }

    public final void z(List<om> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (om omVar : list) {
            if (omVar instanceof yg7) {
                ((yg7) omVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.ul7
    public void b() {
        hn hnVar;
        List<bn> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hnVar = this.b) != null && hnVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (bn bnVar : data) {
                if (bnVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) bnVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (bnVar instanceof c45) {
                    c45 c45Var = (c45) bnVar;
                    if (c45Var.t.getIs_top() != 0) {
                        c45Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        ms7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (om omVar : this.c) {
            if ((omVar instanceof os7) && (i = ((os7) omVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.e1() != null) {
                    int i0 = this.a.e1().i0();
                    if (i0 == -1) {
                        i0 = this.a.e1().h0();
                    }
                    i.b = i0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.ul7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c99;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ul7
    public List<bn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            hn hnVar = this.b;
            if (hnVar != null) {
                return hnVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ul7
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c74;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ul7
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090d40;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ul7
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<bn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.ul7
    public void d(ln lnVar) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, lnVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (om omVar : this.c) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).setOnAdapterItemClickListener(lnVar);
                } else if ((omVar instanceof jl7) || (omVar instanceof pl7)) {
                    omVar.setOnAdapterItemClickListener(lnVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ul7
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (om omVar : this.c) {
                if (omVar != null && omVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ul7
    public void l(tg7 tg7Var) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, tg7Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (om omVar : this.c) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).z(tg7Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (om omVar : this.c) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ul7
    public void e() {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (om omVar : this.c) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.ul7
    public void g(ArrayList<bn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            afa.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<bn> it = arrayList.iterator();
            while (it.hasNext()) {
                bn next = it.next();
                if ((next instanceof c45) && ((c45) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<bn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    bn bnVar = arrayList.get(i);
                    if (bnVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(bnVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) bnVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<bn> arrayList) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<bn> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (om omVar : this.c) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, hnVar) == null) {
            this.a = frsFragment;
            this.j = sg7.e().c(frsFragment.getPageContext(), cfa.d, this.a.getUniqueId(), false);
            ol7 ol7Var = new ol7(frsFragment.u(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = ol7Var;
            ol7Var.C(hnVar);
            al7 al7Var = new al7(frsFragment.u(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = al7Var;
            al7Var.C(hnVar);
            ll7 ll7Var = new ll7(frsFragment.u(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = ll7Var;
            ll7Var.C(hnVar);
            il7 il7Var = new il7(frsFragment.u(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = il7Var;
            il7Var.C(hnVar);
            zk7 zk7Var = new zk7(frsFragment.u(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = zk7Var;
            zk7Var.C(hnVar);
            cl7 cl7Var = new cl7(frsFragment.u(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = cl7Var;
            cl7Var.C(hnVar);
            ql7 ql7Var = new ql7(frsFragment.u(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = ql7Var;
            ql7Var.C(hnVar);
            ml7 ml7Var = new ml7(frsFragment.u(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = ml7Var;
            ml7Var.C(hnVar);
            kl7 kl7Var = new kl7(frsFragment.u(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = kl7Var;
            kl7Var.C(hnVar);
            hl7 hl7Var = new hl7(frsFragment.u(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = hl7Var;
            hl7Var.C(hnVar);
            pl7 pl7Var = new pl7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = pl7Var;
            pl7Var.C(hnVar);
            bl7 bl7Var = new bl7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = bl7Var;
            bl7Var.C(hnVar);
            fl7 fl7Var = new fl7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            fl7Var.C(hnVar);
            nl7 nl7Var = new nl7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            nl7Var.C(hnVar);
            nk7 nk7Var = new nk7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            nk7Var.C(hnVar);
            nk7Var.p(1);
            pk7 pk7Var = new pk7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            pk7Var.C(hnVar);
            ok7 ok7Var = new ok7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            ok7Var.C(hnVar);
            ok7Var.g0(true);
            vk7 vk7Var = new vk7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            vk7Var.C(hnVar);
            vk7Var.g0(true);
            wk7 wk7Var = new wk7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            wk7Var.C(hnVar);
            wk7Var.h0(true);
            pl7 pl7Var2 = new pl7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            pl7Var2.C(hnVar);
            el7 el7Var = new el7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            el7Var.C(hnVar);
            dl7 dl7Var = new dl7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            dl7Var.C(hnVar);
            this.i = new tl7(frsFragment.getPageContext(), vea.c, this.a.getUniqueId());
            jl7 jl7Var = new jl7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = jl7Var;
            jl7Var.C(hnVar);
            om<? extends c45, ? extends TypeAdapter.ViewHolder> a = sg7.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            om<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = sg7.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            fh7 fh7Var = new fh7(frsFragment.getPageContext(), gh7.b);
            xk7 xk7Var = new xk7(frsFragment.getPageContext(), jh7.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), lh7.e, this.a.getUniqueId());
            tk7 tk7Var = new tk7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            tk7Var.x((BdTypeRecyclerView) hnVar);
            yk7 yk7Var = new yk7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            mk7 mk7Var = new mk7(frsFragment.u(), z56.g);
            sk7 sk7Var = new sk7(frsFragment.getPageContext(), zo6.A0);
            sk7Var.u(hnVar);
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
            this.c.add(fl7Var);
            this.c.add(nl7Var);
            this.c.add(nk7Var);
            this.c.add(pk7Var);
            this.c.add(ok7Var);
            this.c.add(vk7Var);
            this.c.add(wk7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(fh7Var);
            this.c.add(xk7Var);
            this.c.add(el7Var);
            this.c.add(dl7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(pl7Var2);
            this.c.add(tk7Var);
            this.c.add(yk7Var);
            this.c.add(mk7Var);
            this.c.add(new rk7(frsFragment.getPageContext()));
            this.c.add(sk7Var);
            this.c.add(zw7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_hot_tab"));
            p36 p36Var = new p36(this.a, 1);
            p36Var.u(this.c);
            p36Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, p36Var));
            z(this.c);
            hnVar.addAdapters(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<om<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    om<?, ?> next = it.next();
                    if (next instanceof yg7) {
                        ((yg7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<om> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                hn hnVar2 = this.b;
                if (hnVar2 != null) {
                    hnVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ul7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (om omVar : this.c) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).x();
                } else if (omVar instanceof h1a) {
                    ((h1a) omVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (om omVar : this.c) {
            if (omVar instanceof yg7) {
                ((yg7) omVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        tl7 tl7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (tl7Var = this.i) != null) {
            tl7Var.L(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<bn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                bn bnVar = (bn) ListUtils.getItem(arrayList, i - 1);
                bn bnVar2 = (bn) ListUtils.getItem(arrayList, i);
                if (bnVar2 instanceof c45) {
                    ThreadData threadData = ((c45) bnVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (bnVar instanceof jh7) {
                        threadData.needTopMargin = false;
                    } else if (bnVar != null && !p(bnVar)) {
                        threadData.needTopMargin = false;
                    } else if ((bnVar instanceof c45) && p(bnVar) && !TextUtils.isEmpty(((c45) bnVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(bnVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.ul7
    public void setFromCDN(boolean z) {
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (om omVar : this.c) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).setFromCDN(z);
                }
            }
            ol7 ol7Var = this.k;
            if (ol7Var != null) {
                ol7Var.setFromCDN(z);
            }
            al7 al7Var = this.l;
            if (al7Var != null) {
                al7Var.setFromCDN(z);
            }
            ll7 ll7Var = this.m;
            if (ll7Var != null) {
                ll7Var.setFromCDN(z);
            }
            il7 il7Var = this.n;
            if (il7Var != null) {
                il7Var.setFromCDN(z);
            }
            zk7 zk7Var = this.o;
            if (zk7Var != null) {
                zk7Var.setFromCDN(z);
            }
            cl7 cl7Var = this.p;
            if (cl7Var != null) {
                cl7Var.setFromCDN(z);
            }
            pl7 pl7Var = this.u;
            if (pl7Var != null) {
                pl7Var.setFromCDN(z);
            }
            jl7 jl7Var = this.w;
            if (jl7Var != null) {
                jl7Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<om> list;
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
            for (om omVar : this.c) {
                if (omVar != null) {
                    Class<?> cls3 = omVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(omVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(omVar, str);
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

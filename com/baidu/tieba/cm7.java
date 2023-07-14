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
public class cm7 implements qm7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public eo b;
    public List<ln> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<yn> e;
    public FrsViewData f;
    public boolean g;
    public final wh7 h;
    public pm7 i;
    public ln j;
    public km7 k;
    public wl7 l;
    public hm7 m;
    public em7 n;
    public vl7 o;
    public yl7 p;
    public im7 q;
    public mm7 r;
    public gm7 s;
    public dm7 t;
    public lm7 u;
    public xl7 v;
    public fm7 w;

    public cm7(FrsFragment frsFragment, eo eoVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, eoVar, Boolean.valueOf(z)};
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
        this.b = eoVar;
        this.h = new wh7();
        o(frsFragment, eoVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.qm7
    public void a(String str) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (ln lnVar : list) {
            if (lnVar instanceof sp6) {
                ((sp6) lnVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.qm7
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(yn ynVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, ynVar)) == null) {
            if (ynVar == null) {
                return false;
            }
            BdUniqueId type = ynVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (ln lnVar : list) {
            if (lnVar instanceof t66) {
                ((t66) lnVar).g(str);
            }
        }
    }

    public final void z(List<ln> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (ln lnVar : list) {
            if (lnVar instanceof yh7) {
                ((yh7) lnVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.qm7
    public void b() {
        eo eoVar;
        List<yn> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (eoVar = this.b) != null && eoVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (yn ynVar : data) {
                if (ynVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) ynVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (ynVar instanceof z45) {
                    z45 z45Var = (z45) ynVar;
                    if (z45Var.t.getIs_top() != 0) {
                        z45Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        it7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (ln lnVar : this.c) {
            if ((lnVar instanceof kt7) && (i = ((kt7) lnVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.V0() != null) {
                    int q0 = this.a.V0().q0();
                    if (q0 == -1) {
                        q0 = this.a.V0().p0();
                    }
                    i.b = q0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.qm7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c7a;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qm7
    public List<yn> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            eo eoVar = this.b;
            if (eoVar != null) {
                return eoVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qm7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qm7
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c55;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qm7
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090d21;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qm7
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<yn> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.qm7
    public void d(io ioVar) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ioVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (ln lnVar : this.c) {
                if (lnVar instanceof yh7) {
                    ((yh7) lnVar).setOnAdapterItemClickListener(ioVar);
                } else if ((lnVar instanceof fm7) || (lnVar instanceof lm7)) {
                    lnVar.setOnAdapterItemClickListener(ioVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.qm7
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (ln lnVar : this.c) {
                if (lnVar != null && lnVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.qm7
    public void l(th7 th7Var) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, th7Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (ln lnVar : this.c) {
                if (lnVar instanceof yh7) {
                    ((yh7) lnVar).z(th7Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (ln lnVar : this.c) {
                if (lnVar instanceof yh7) {
                    ((yh7) lnVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.qm7
    public void e() {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (ln lnVar : this.c) {
                if (lnVar instanceof yh7) {
                    ((yh7) lnVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.qm7
    public void g(ArrayList<yn> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            xba.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<yn> it = arrayList.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if ((next instanceof z45) && ((z45) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<yn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    yn ynVar = arrayList.get(i);
                    if (ynVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(ynVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) ynVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<yn> arrayList) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<yn> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (ln lnVar : this.c) {
                if (lnVar instanceof yh7) {
                    ((yh7) lnVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, eoVar) == null) {
            this.a = frsFragment;
            this.j = sh7.e().c(frsFragment.getPageContext(), aca.d, this.a.getUniqueId(), false);
            km7 km7Var = new km7(frsFragment.t(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = km7Var;
            km7Var.C(eoVar);
            wl7 wl7Var = new wl7(frsFragment.t(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = wl7Var;
            wl7Var.C(eoVar);
            hm7 hm7Var = new hm7(frsFragment.t(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = hm7Var;
            hm7Var.C(eoVar);
            em7 em7Var = new em7(frsFragment.t(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = em7Var;
            em7Var.C(eoVar);
            vl7 vl7Var = new vl7(frsFragment.t(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = vl7Var;
            vl7Var.C(eoVar);
            yl7 yl7Var = new yl7(frsFragment.t(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = yl7Var;
            yl7Var.C(eoVar);
            mm7 mm7Var = new mm7(frsFragment.t(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = mm7Var;
            mm7Var.C(eoVar);
            im7 im7Var = new im7(frsFragment.t(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = im7Var;
            im7Var.C(eoVar);
            gm7 gm7Var = new gm7(frsFragment.t(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = gm7Var;
            gm7Var.C(eoVar);
            dm7 dm7Var = new dm7(frsFragment.t(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = dm7Var;
            dm7Var.C(eoVar);
            lm7 lm7Var = new lm7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = lm7Var;
            lm7Var.C(eoVar);
            xl7 xl7Var = new xl7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = xl7Var;
            xl7Var.C(eoVar);
            bm7 bm7Var = new bm7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            bm7Var.C(eoVar);
            jm7 jm7Var = new jm7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            jm7Var.C(eoVar);
            jl7 jl7Var = new jl7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            jl7Var.C(eoVar);
            jl7Var.p(1);
            ll7 ll7Var = new ll7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            ll7Var.C(eoVar);
            kl7 kl7Var = new kl7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            kl7Var.C(eoVar);
            kl7Var.g0(true);
            rl7 rl7Var = new rl7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            rl7Var.C(eoVar);
            rl7Var.g0(true);
            sl7 sl7Var = new sl7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            sl7Var.C(eoVar);
            sl7Var.h0(true);
            lm7 lm7Var2 = new lm7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            lm7Var2.C(eoVar);
            am7 am7Var = new am7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            am7Var.C(eoVar);
            zl7 zl7Var = new zl7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            zl7Var.C(eoVar);
            this.i = new pm7(frsFragment.getPageContext(), sba.c, this.a.getUniqueId());
            fm7 fm7Var = new fm7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = fm7Var;
            fm7Var.C(eoVar);
            ln<? extends z45, ? extends TypeAdapter.ViewHolder> a = sh7.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            ln<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = sh7.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            fi7 fi7Var = new fi7(frsFragment.getPageContext(), gi7.b);
            tl7 tl7Var = new tl7(frsFragment.getPageContext(), ji7.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), li7.e, this.a.getUniqueId());
            pl7 pl7Var = new pl7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            pl7Var.x((BdTypeRecyclerView) eoVar);
            ul7 ul7Var = new ul7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            il7 il7Var = new il7(frsFragment.t(), a86.g);
            ol7 ol7Var = new ol7(frsFragment.getPageContext(), kq6.A0);
            ol7Var.u(eoVar);
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
            this.c.add(bm7Var);
            this.c.add(jm7Var);
            this.c.add(jl7Var);
            this.c.add(ll7Var);
            this.c.add(kl7Var);
            this.c.add(rl7Var);
            this.c.add(sl7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(fi7Var);
            this.c.add(tl7Var);
            this.c.add(am7Var);
            this.c.add(zl7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(lm7Var2);
            this.c.add(pl7Var);
            this.c.add(ul7Var);
            this.c.add(il7Var);
            this.c.add(new nl7(frsFragment.getPageContext()));
            this.c.add(ol7Var);
            this.c.add(vx7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_hot_tab"));
            q56 q56Var = new q56(this.a, 1);
            q56Var.u(this.c);
            q56Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, q56Var));
            z(this.c);
            eoVar.addAdapters(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<ln<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    ln<?, ?> next = it.next();
                    if (next instanceof yh7) {
                        ((yh7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<ln> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                eo eoVar2 = this.b;
                if (eoVar2 != null) {
                    eoVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.qm7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (ln lnVar : this.c) {
                if (lnVar instanceof yh7) {
                    ((yh7) lnVar).x();
                } else if (lnVar instanceof ky9) {
                    ((ky9) lnVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (ln lnVar : this.c) {
            if (lnVar instanceof yh7) {
                ((yh7) lnVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        pm7 pm7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (pm7Var = this.i) != null) {
            pm7Var.M(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                yn ynVar = (yn) ListUtils.getItem(arrayList, i - 1);
                yn ynVar2 = (yn) ListUtils.getItem(arrayList, i);
                if (ynVar2 instanceof z45) {
                    ThreadData threadData = ((z45) ynVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (ynVar instanceof ji7) {
                        threadData.needTopMargin = false;
                    } else if (ynVar != null && !p(ynVar)) {
                        threadData.needTopMargin = false;
                    } else if ((ynVar instanceof z45) && p(ynVar) && !TextUtils.isEmpty(((z45) ynVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(ynVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.qm7
    public void setFromCDN(boolean z) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (ln lnVar : this.c) {
                if (lnVar instanceof yh7) {
                    ((yh7) lnVar).setFromCDN(z);
                }
            }
            km7 km7Var = this.k;
            if (km7Var != null) {
                km7Var.setFromCDN(z);
            }
            wl7 wl7Var = this.l;
            if (wl7Var != null) {
                wl7Var.setFromCDN(z);
            }
            hm7 hm7Var = this.m;
            if (hm7Var != null) {
                hm7Var.setFromCDN(z);
            }
            em7 em7Var = this.n;
            if (em7Var != null) {
                em7Var.setFromCDN(z);
            }
            vl7 vl7Var = this.o;
            if (vl7Var != null) {
                vl7Var.setFromCDN(z);
            }
            yl7 yl7Var = this.p;
            if (yl7Var != null) {
                yl7Var.setFromCDN(z);
            }
            lm7 lm7Var = this.u;
            if (lm7Var != null) {
                lm7Var.setFromCDN(z);
            }
            fm7 fm7Var = this.w;
            if (fm7Var != null) {
                fm7Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<ln> list;
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
            for (ln lnVar : this.c) {
                if (lnVar != null) {
                    Class<?> cls3 = lnVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(lnVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(lnVar, str);
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

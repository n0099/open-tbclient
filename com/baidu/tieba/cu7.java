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
public class cu7 implements qu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public ui b;
    public List<bi> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<oi> e;
    public FrsViewData f;
    public boolean g;
    public final np7 h;
    public pu7 i;
    public bi j;
    public ku7 k;
    public wt7 l;
    public hu7 m;
    public eu7 n;
    public vt7 o;
    public yt7 p;
    public iu7 q;
    public mu7 r;
    public gu7 s;
    public du7 t;
    public lu7 u;
    public xt7 v;
    public fu7 w;

    public cu7(FrsFragment frsFragment, ui uiVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, uiVar, Boolean.valueOf(z)};
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
        this.b = uiVar;
        this.h = new np7();
        o(frsFragment, uiVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.qu7
    public void a(String str) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (bi biVar : list) {
            if (biVar instanceof vl6) {
                ((vl6) biVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.qu7
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(oi oiVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, oiVar)) == null) {
            if (oiVar == null) {
                return false;
            }
            BdUniqueId type = oiVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (bi biVar : list) {
            if (biVar instanceof s16) {
                ((s16) biVar).g(str);
            }
        }
    }

    public final void z(List<bi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (bi biVar : list) {
            if (biVar instanceof pp7) {
                ((pp7) biVar).z(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.qu7
    public void b() {
        ui uiVar;
        List<oi> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (uiVar = this.b) != null && uiVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (oi oiVar : data) {
                if (oiVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) oiVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (oiVar instanceof hz4) {
                    hz4 hz4Var = (hz4) oiVar;
                    if (hz4Var.t.getIs_top() != 0) {
                        hz4Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        a18 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (bi biVar : this.c) {
            if ((biVar instanceof c18) && (i = ((c18) biVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.y1() != null) {
                    int j0 = this.a.y1().j0();
                    if (j0 == -1) {
                        j0 = this.a.y1().i0();
                    }
                    i.b = j0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.qu7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090cd7;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qu7
    public List<oi> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ui uiVar = this.b;
            if (uiVar != null) {
                return uiVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qu7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qu7
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090cae;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qu7
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090d80;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qu7
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<oi> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.qu7
    public void d(yi yiVar) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, yiVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (bi biVar : this.c) {
                if (biVar instanceof pp7) {
                    ((pp7) biVar).setOnAdapterItemClickListener(yiVar);
                } else if ((biVar instanceof fu7) || (biVar instanceof lu7)) {
                    biVar.setOnAdapterItemClickListener(yiVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.qu7
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (bi biVar : this.c) {
                if (biVar != null && biVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.qu7
    public void l(kp7 kp7Var) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, kp7Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (bi biVar : this.c) {
                if (biVar instanceof pp7) {
                    ((pp7) biVar).A(kp7Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (bi biVar : this.c) {
                if (biVar instanceof pp7) {
                    ((pp7) biVar).B(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.qu7
    public void e() {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (bi biVar : this.c) {
                if (biVar instanceof pp7) {
                    ((pp7) biVar).n(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.qu7
    public void g(ArrayList<oi> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            uqa.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<oi> it = arrayList.iterator();
            while (it.hasNext()) {
                oi next = it.next();
                if ((next instanceof hz4) && ((hz4) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<oi> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    oi oiVar = arrayList.get(i);
                    if (oiVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(oiVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) oiVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<oi> arrayList) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<oi> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (bi biVar : this.c) {
                if (biVar instanceof pp7) {
                    ((pp7) biVar).G(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, uiVar) == null) {
            this.a = frsFragment;
            this.j = jp7.e().c(frsFragment.getPageContext(), wqa.d, this.a.getUniqueId(), false);
            ku7 ku7Var = new ku7(frsFragment.H(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = ku7Var;
            ku7Var.D(uiVar);
            wt7 wt7Var = new wt7(frsFragment.H(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = wt7Var;
            wt7Var.D(uiVar);
            hu7 hu7Var = new hu7(frsFragment.H(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = hu7Var;
            hu7Var.D(uiVar);
            eu7 eu7Var = new eu7(frsFragment.H(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = eu7Var;
            eu7Var.D(uiVar);
            vt7 vt7Var = new vt7(frsFragment.H(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = vt7Var;
            vt7Var.D(uiVar);
            yt7 yt7Var = new yt7(frsFragment.H(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = yt7Var;
            yt7Var.D(uiVar);
            mu7 mu7Var = new mu7(frsFragment.H(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = mu7Var;
            mu7Var.D(uiVar);
            iu7 iu7Var = new iu7(frsFragment.H(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = iu7Var;
            iu7Var.D(uiVar);
            gu7 gu7Var = new gu7(frsFragment.H(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = gu7Var;
            gu7Var.D(uiVar);
            du7 du7Var = new du7(frsFragment.H(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = du7Var;
            du7Var.D(uiVar);
            lu7 lu7Var = new lu7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = lu7Var;
            lu7Var.D(uiVar);
            xt7 xt7Var = new xt7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = xt7Var;
            xt7Var.D(uiVar);
            bu7 bu7Var = new bu7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            bu7Var.D(uiVar);
            ju7 ju7Var = new ju7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            ju7Var.D(uiVar);
            it7 it7Var = new it7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            it7Var.D(uiVar);
            it7Var.q(1);
            kt7 kt7Var = new kt7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            kt7Var.D(uiVar);
            jt7 jt7Var = new jt7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            jt7Var.D(uiVar);
            jt7Var.g0(true);
            qt7 qt7Var = new qt7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            qt7Var.D(uiVar);
            qt7Var.Q(true);
            rt7 rt7Var = new rt7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            rt7Var.D(uiVar);
            rt7Var.Q(true);
            lu7 lu7Var2 = new lu7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            lu7Var2.D(uiVar);
            au7 au7Var = new au7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            au7Var.D(uiVar);
            zt7 zt7Var = new zt7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            zt7Var.D(uiVar);
            this.i = new pu7(frsFragment.getPageContext(), pqa.c, this.a.getUniqueId());
            fu7 fu7Var = new fu7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = fu7Var;
            fu7Var.D(uiVar);
            bi<? extends hz4, ? extends TypeAdapter.ViewHolder> a = jp7.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            bi<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = jp7.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            wp7 wp7Var = new wp7(frsFragment.getPageContext(), xp7.b);
            tt7 tt7Var = new tt7(frsFragment.getPageContext(), aq7.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), cq7.e, this.a.getUniqueId());
            ot7 ot7Var = new ot7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            ot7Var.y((BdTypeRecyclerView) uiVar);
            ut7 ut7Var = new ut7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            gt7 gt7Var = new gt7(frsFragment.H(), z26.g);
            nt7 nt7Var = new nt7(frsFragment.getPageContext(), nm6.A0);
            nt7Var.x(uiVar);
            st7 st7Var = new st7(frsFragment.getPageContext(), sm6.j);
            st7Var.x(uiVar);
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
            this.c.add(bu7Var);
            this.c.add(ju7Var);
            this.c.add(it7Var);
            this.c.add(kt7Var);
            this.c.add(jt7Var);
            this.c.add(qt7Var);
            this.c.add(rt7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(wp7Var);
            this.c.add(tt7Var);
            this.c.add(au7Var);
            this.c.add(zt7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(lu7Var2);
            this.c.add(ot7Var);
            this.c.add(ut7Var);
            this.c.add(gt7Var);
            this.c.add(new mt7(frsFragment.getPageContext()));
            this.c.add(nt7Var);
            this.c.add(st7Var);
            this.c.add(r58.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.J, "frs_hot_tab"));
            p06 p06Var = new p06(this.a, 1);
            p06Var.u(this.c);
            p06Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, p06Var));
            z(this.c);
            uiVar.addAdapters(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<bi<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    bi<?, ?> next = it.next();
                    if (next instanceof pp7) {
                        ((pp7) next).n(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<bi> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                ui uiVar2 = this.b;
                if (uiVar2 != null) {
                    uiVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.qu7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (bi biVar : this.c) {
                if (biVar instanceof pp7) {
                    ((pp7) biVar).y();
                } else if (biVar instanceof oca) {
                    ((oca) biVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (bi biVar : this.c) {
            if (biVar instanceof pp7) {
                ((pp7) biVar).F(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        pu7 pu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (pu7Var = this.i) != null) {
            pu7Var.M(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<oi> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                oi oiVar = (oi) ListUtils.getItem(arrayList, i - 1);
                oi oiVar2 = (oi) ListUtils.getItem(arrayList, i);
                if (oiVar2 instanceof hz4) {
                    ThreadData threadData = ((hz4) oiVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (oiVar instanceof aq7) {
                        threadData.needTopMargin = false;
                    } else if (oiVar != null && !p(oiVar)) {
                        threadData.needTopMargin = false;
                    } else if ((oiVar instanceof hz4) && p(oiVar) && !TextUtils.isEmpty(((hz4) oiVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(oiVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.qu7
    public void setFromCDN(boolean z) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (bi biVar : this.c) {
                if (biVar instanceof pp7) {
                    ((pp7) biVar).setFromCDN(z);
                }
            }
            ku7 ku7Var = this.k;
            if (ku7Var != null) {
                ku7Var.setFromCDN(z);
            }
            wt7 wt7Var = this.l;
            if (wt7Var != null) {
                wt7Var.setFromCDN(z);
            }
            hu7 hu7Var = this.m;
            if (hu7Var != null) {
                hu7Var.setFromCDN(z);
            }
            eu7 eu7Var = this.n;
            if (eu7Var != null) {
                eu7Var.setFromCDN(z);
            }
            vt7 vt7Var = this.o;
            if (vt7Var != null) {
                vt7Var.setFromCDN(z);
            }
            yt7 yt7Var = this.p;
            if (yt7Var != null) {
                yt7Var.setFromCDN(z);
            }
            lu7 lu7Var = this.u;
            if (lu7Var != null) {
                lu7Var.setFromCDN(z);
            }
            fu7 fu7Var = this.w;
            if (fu7Var != null) {
                fu7Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<bi> list;
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
            for (bi biVar : this.c) {
                if (biVar != null) {
                    Class<?> cls3 = biVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(biVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(biVar, str);
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

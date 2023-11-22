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
public class du7 implements ru7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public ui b;
    public List<bi> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<oi> e;
    public FrsViewData f;
    public boolean g;
    public final op7 h;
    public qu7 i;
    public bi j;
    public lu7 k;
    public xt7 l;
    public iu7 m;
    public fu7 n;
    public wt7 o;
    public zt7 p;
    public ju7 q;
    public nu7 r;
    public hu7 s;
    public eu7 t;
    public mu7 u;
    public yt7 v;
    public gu7 w;

    public du7(FrsFragment frsFragment, ui uiVar, boolean z) {
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
        this.h = new op7();
        o(frsFragment, uiVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.ru7
    public void a(String str) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (bi biVar : list) {
            if (biVar instanceof wl6) {
                ((wl6) biVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.ru7
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
            if (biVar instanceof t16) {
                ((t16) biVar).g(str);
            }
        }
    }

    public final void z(List<bi> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (bi biVar : list) {
            if (biVar instanceof qp7) {
                ((qp7) biVar).z(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.ru7
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
        b18 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (bi biVar : this.c) {
            if ((biVar instanceof d18) && (i = ((d18) biVar).i()) != null) {
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

    @Override // com.baidu.tieba.ru7
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

    @Override // com.baidu.tieba.ru7
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

    @Override // com.baidu.tieba.ru7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ru7
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

    @Override // com.baidu.tieba.ru7
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

    @Override // com.baidu.tieba.ru7
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

    @Override // com.baidu.tieba.ru7
    public void d(yi yiVar) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, yiVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (bi biVar : this.c) {
                if (biVar instanceof qp7) {
                    ((qp7) biVar).setOnAdapterItemClickListener(yiVar);
                } else if ((biVar instanceof gu7) || (biVar instanceof mu7)) {
                    biVar.setOnAdapterItemClickListener(yiVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ru7
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

    @Override // com.baidu.tieba.ru7
    public void l(lp7 lp7Var) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, lp7Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (bi biVar : this.c) {
                if (biVar instanceof qp7) {
                    ((qp7) biVar).A(lp7Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (bi biVar : this.c) {
                if (biVar instanceof qp7) {
                    ((qp7) biVar).B(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ru7
    public void e() {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (bi biVar : this.c) {
                if (biVar instanceof qp7) {
                    ((qp7) biVar).n(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.ru7
    public void g(ArrayList<oi> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            vqa.f(arrayList, 1);
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
                if (biVar instanceof qp7) {
                    ((qp7) biVar).G(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, ui uiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, uiVar) == null) {
            this.a = frsFragment;
            this.j = kp7.e().c(frsFragment.getPageContext(), xqa.d, this.a.getUniqueId(), false);
            lu7 lu7Var = new lu7(frsFragment.H(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = lu7Var;
            lu7Var.D(uiVar);
            xt7 xt7Var = new xt7(frsFragment.H(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = xt7Var;
            xt7Var.D(uiVar);
            iu7 iu7Var = new iu7(frsFragment.H(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = iu7Var;
            iu7Var.D(uiVar);
            fu7 fu7Var = new fu7(frsFragment.H(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = fu7Var;
            fu7Var.D(uiVar);
            wt7 wt7Var = new wt7(frsFragment.H(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = wt7Var;
            wt7Var.D(uiVar);
            zt7 zt7Var = new zt7(frsFragment.H(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = zt7Var;
            zt7Var.D(uiVar);
            nu7 nu7Var = new nu7(frsFragment.H(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = nu7Var;
            nu7Var.D(uiVar);
            ju7 ju7Var = new ju7(frsFragment.H(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = ju7Var;
            ju7Var.D(uiVar);
            hu7 hu7Var = new hu7(frsFragment.H(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = hu7Var;
            hu7Var.D(uiVar);
            eu7 eu7Var = new eu7(frsFragment.H(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = eu7Var;
            eu7Var.D(uiVar);
            mu7 mu7Var = new mu7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = mu7Var;
            mu7Var.D(uiVar);
            yt7 yt7Var = new yt7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = yt7Var;
            yt7Var.D(uiVar);
            cu7 cu7Var = new cu7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            cu7Var.D(uiVar);
            ku7 ku7Var = new ku7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            ku7Var.D(uiVar);
            jt7 jt7Var = new jt7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            jt7Var.D(uiVar);
            jt7Var.q(1);
            lt7 lt7Var = new lt7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            lt7Var.D(uiVar);
            kt7 kt7Var = new kt7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            kt7Var.D(uiVar);
            kt7Var.g0(true);
            rt7 rt7Var = new rt7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            rt7Var.D(uiVar);
            rt7Var.Q(true);
            st7 st7Var = new st7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            st7Var.D(uiVar);
            st7Var.Q(true);
            mu7 mu7Var2 = new mu7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            mu7Var2.D(uiVar);
            bu7 bu7Var = new bu7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            bu7Var.D(uiVar);
            au7 au7Var = new au7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            au7Var.D(uiVar);
            this.i = new qu7(frsFragment.getPageContext(), qqa.c, this.a.getUniqueId());
            gu7 gu7Var = new gu7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = gu7Var;
            gu7Var.D(uiVar);
            bi<? extends hz4, ? extends TypeAdapter.ViewHolder> a = kp7.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            bi<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = kp7.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            xp7 xp7Var = new xp7(frsFragment.getPageContext(), yp7.b);
            ut7 ut7Var = new ut7(frsFragment.getPageContext(), bq7.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), dq7.e, this.a.getUniqueId());
            pt7 pt7Var = new pt7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            pt7Var.y((BdTypeRecyclerView) uiVar);
            vt7 vt7Var = new vt7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            ht7 ht7Var = new ht7(frsFragment.H(), a36.g);
            ot7 ot7Var = new ot7(frsFragment.getPageContext(), om6.A0);
            ot7Var.x(uiVar);
            tt7 tt7Var = new tt7(frsFragment.getPageContext(), tm6.j);
            tt7Var.x(uiVar);
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
            this.c.add(cu7Var);
            this.c.add(ku7Var);
            this.c.add(jt7Var);
            this.c.add(lt7Var);
            this.c.add(kt7Var);
            this.c.add(rt7Var);
            this.c.add(st7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(xp7Var);
            this.c.add(ut7Var);
            this.c.add(bu7Var);
            this.c.add(au7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(mu7Var2);
            this.c.add(pt7Var);
            this.c.add(vt7Var);
            this.c.add(ht7Var);
            this.c.add(new nt7(frsFragment.getPageContext()));
            this.c.add(ot7Var);
            this.c.add(tt7Var);
            this.c.add(s58.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.J, "frs_hot_tab"));
            q06 q06Var = new q06(this.a, 1);
            q06Var.u(this.c);
            q06Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, q06Var));
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
                    if (next instanceof qp7) {
                        ((qp7) next).n(this.a.getPageContext(), this.a.getUniqueId());
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

    @Override // com.baidu.tieba.ru7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (bi biVar : this.c) {
                if (biVar instanceof qp7) {
                    ((qp7) biVar).y();
                } else if (biVar instanceof pca) {
                    ((pca) biVar).onDestroy();
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
            if (biVar instanceof qp7) {
                ((qp7) biVar).F(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        qu7 qu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (qu7Var = this.i) != null) {
            qu7Var.M(this.f.getForum().getId());
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
                    if (oiVar instanceof bq7) {
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

    @Override // com.baidu.tieba.ru7
    public void setFromCDN(boolean z) {
        List<bi> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (bi biVar : this.c) {
                if (biVar instanceof qp7) {
                    ((qp7) biVar).setFromCDN(z);
                }
            }
            lu7 lu7Var = this.k;
            if (lu7Var != null) {
                lu7Var.setFromCDN(z);
            }
            xt7 xt7Var = this.l;
            if (xt7Var != null) {
                xt7Var.setFromCDN(z);
            }
            iu7 iu7Var = this.m;
            if (iu7Var != null) {
                iu7Var.setFromCDN(z);
            }
            fu7 fu7Var = this.n;
            if (fu7Var != null) {
                fu7Var.setFromCDN(z);
            }
            wt7 wt7Var = this.o;
            if (wt7Var != null) {
                wt7Var.setFromCDN(z);
            }
            zt7 zt7Var = this.p;
            if (zt7Var != null) {
                zt7Var.setFromCDN(z);
            }
            mu7 mu7Var = this.u;
            if (mu7Var != null) {
                mu7Var.setFromCDN(z);
            }
            gu7 gu7Var = this.w;
            if (gu7Var != null) {
                gu7Var.setFromCDN(z);
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

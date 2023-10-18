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
public class ih7 implements wh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public ei b;
    public List<lh> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<yh> e;
    public FrsViewData f;
    public boolean g;
    public final wc7 h;
    public vh7 i;
    public lh j;
    public qh7 k;
    public ch7 l;
    public nh7 m;
    public kh7 n;
    public bh7 o;
    public eh7 p;
    public oh7 q;
    public sh7 r;
    public mh7 s;
    public jh7 t;
    public rh7 u;
    public dh7 v;
    public lh7 w;

    public ih7(FrsFragment frsFragment, ei eiVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, eiVar, Boolean.valueOf(z)};
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
        this.b = eiVar;
        this.h = new wc7();
        o(frsFragment, eiVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.wh7
    public void a(String str) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (lh lhVar : list) {
            if (lhVar instanceof zj6) {
                ((zj6) lhVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.wh7
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && this.g != z) {
            this.g = z;
        }
    }

    public final boolean p(yh yhVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, yhVar)) == null) {
            if (yhVar == null) {
                return false;
            }
            BdUniqueId type = yhVar.getType();
            if (type != ThreadData.TYPE_NORMAL && type != ThreadData.TYPE_GOD_NORMAL && type != ThreadData.TYPE_VIDEO && type != ThreadData.TYPE_VIDEO_GOD && type != ThreadData.TYPE_INSERT_VIDEO) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void s(String str) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, str) != null) || (list = this.c) == null) {
            return;
        }
        for (lh lhVar : list) {
            if (lhVar instanceof yz5) {
                ((yz5) lhVar).g(str);
            }
        }
    }

    public final void z(List<lh> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, list) != null) || list == null) {
            return;
        }
        for (lh lhVar : list) {
            if (lhVar instanceof yc7) {
                ((yc7) lhVar).y(this.h);
            }
        }
    }

    @Override // com.baidu.tieba.wh7
    public void b() {
        ei eiVar;
        List<yh> data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (eiVar = this.b) != null && eiVar.getData() != null && this.b.getData().size() != 0 && (data = this.b.getData()) != null && data.size() != 0) {
            for (yh yhVar : data) {
                if (yhVar instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) yhVar;
                    if (threadData.getIs_top() != 0) {
                        threadData.parser_title();
                    }
                } else if (yhVar instanceof py4) {
                    py4 py4Var = (py4) yhVar;
                    if (py4Var.t.getIs_top() != 0) {
                        py4Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final void w() {
        go7 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048601, this) != null) || this.f == null) {
            return;
        }
        for (lh lhVar : this.c) {
            if ((lhVar instanceof io7) && (i = ((io7) lhVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.l1() != null) {
                    int i0 = this.a.l1().i0();
                    if (i0 == -1) {
                        i0 = this.a.l1().h0();
                    }
                    i.b = i0;
                }
            }
        }
    }

    @Override // com.baidu.tieba.wh7
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090ca5;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.wh7
    public List<yh> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ei eiVar = this.b;
            if (eiVar != null) {
                return eiVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wh7
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.wh7
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090c80;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.wh7
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090d4c;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.wh7
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b.getListAdapter() != null) {
            this.b.getListAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<yh> arrayList = this.e;
            if (arrayList != null) {
                this.b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.wh7
    public void d(ii iiVar) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, iiVar) == null) && (list = this.c) != null && list.size() != 0) {
            for (lh lhVar : this.c) {
                if (lhVar instanceof yc7) {
                    ((yc7) lhVar).setOnAdapterItemClickListener(iiVar);
                } else if ((lhVar instanceof lh7) || (lhVar instanceof rh7)) {
                    lhVar.setOnAdapterItemClickListener(iiVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.wh7
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (lh lhVar : this.c) {
                if (lhVar != null && lhVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.wh7
    public void l(tc7 tc7Var) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, tc7Var) == null) && (list = this.c) != null && list.size() != 0) {
            for (lh lhVar : this.c) {
                if (lhVar instanceof yc7) {
                    ((yc7) lhVar).z(tc7Var);
                }
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) && (list = this.c) != null && list.size() != 0) {
            for (lh lhVar : this.c) {
                if (lhVar instanceof yc7) {
                    ((yc7) lhVar).A(frsViewData);
                }
            }
        }
    }

    @Override // com.baidu.tieba.wh7
    public void e() {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (list = this.c) != null && list.size() != 0) {
            for (lh lhVar : this.c) {
                if (lhVar instanceof yc7) {
                    ((yc7) lhVar).m(this.a.getPageContext(), this.a.getUniqueId());
                }
            }
            z(this.c);
        }
    }

    @Override // com.baidu.tieba.wh7
    public void g(ArrayList<yh> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            pda.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<yh> it = arrayList.iterator();
            while (it.hasNext()) {
                yh next = it.next();
                if ((next instanceof py4) && ((py4) next).t.isTop()) {
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

    public final ArrayList<Integer> n(ArrayList<yh> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList != null && arrayList.size() != 0) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                for (int i = 0; i < arrayList.size(); i++) {
                    yh yhVar = arrayList.get(i);
                    if (yhVar instanceof AdvertAppInfo) {
                        arrayList2.add(Integer.valueOf(i));
                        HashMap<Integer, ThreadData> hashMap = this.d;
                        if (hashMap != null && !hashMap.containsValue(yhVar)) {
                            this.d.put(Integer.valueOf(i), (ThreadData) yhVar);
                        }
                    }
                }
                return arrayList2;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void x(ArrayList<yh> arrayList) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) && (list = this.c) != null && list.size() != 0) {
            int i = 0;
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<yh> it = arrayList.iterator();
                while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                    i++;
                }
            }
            for (lh lhVar : this.c) {
                if (lhVar instanceof yc7) {
                    ((yc7) lhVar).F(i);
                }
            }
        }
    }

    public void o(FrsFragment frsFragment, ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, eiVar) == null) {
            this.a = frsFragment;
            this.j = sc7.e().c(frsFragment.getPageContext(), rda.d, this.a.getUniqueId(), false);
            qh7 qh7Var = new qh7(frsFragment.D(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = qh7Var;
            qh7Var.C(eiVar);
            ch7 ch7Var = new ch7(frsFragment.D(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = ch7Var;
            ch7Var.C(eiVar);
            nh7 nh7Var = new nh7(frsFragment.D(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = nh7Var;
            nh7Var.C(eiVar);
            kh7 kh7Var = new kh7(frsFragment.D(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = kh7Var;
            kh7Var.C(eiVar);
            bh7 bh7Var = new bh7(frsFragment.D(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = bh7Var;
            bh7Var.C(eiVar);
            eh7 eh7Var = new eh7(frsFragment.D(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = eh7Var;
            eh7Var.C(eiVar);
            sh7 sh7Var = new sh7(frsFragment.D(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = sh7Var;
            sh7Var.C(eiVar);
            oh7 oh7Var = new oh7(frsFragment.D(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = oh7Var;
            oh7Var.C(eiVar);
            mh7 mh7Var = new mh7(frsFragment.D(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = mh7Var;
            mh7Var.C(eiVar);
            jh7 jh7Var = new jh7(frsFragment.D(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = jh7Var;
            jh7Var.C(eiVar);
            rh7 rh7Var = new rh7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = rh7Var;
            rh7Var.C(eiVar);
            dh7 dh7Var = new dh7(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = dh7Var;
            dh7Var.C(eiVar);
            hh7 hh7Var = new hh7(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            hh7Var.C(eiVar);
            ph7 ph7Var = new ph7(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            ph7Var.C(eiVar);
            og7 og7Var = new og7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            og7Var.C(eiVar);
            og7Var.r(1);
            qg7 qg7Var = new qg7(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            qg7Var.C(eiVar);
            pg7 pg7Var = new pg7(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            pg7Var.C(eiVar);
            pg7Var.g0(true);
            wg7 wg7Var = new wg7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            wg7Var.C(eiVar);
            wg7Var.P(true);
            xg7 xg7Var = new xg7(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            xg7Var.C(eiVar);
            xg7Var.P(true);
            rh7 rh7Var2 = new rh7(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            rh7Var2.C(eiVar);
            gh7 gh7Var = new gh7(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            gh7Var.C(eiVar);
            fh7 fh7Var = new fh7(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            fh7Var.C(eiVar);
            this.i = new vh7(frsFragment.getPageContext(), kda.c, this.a.getUniqueId());
            lh7 lh7Var = new lh7(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = lh7Var;
            lh7Var.C(eiVar);
            lh<? extends py4, ? extends TypeAdapter.ViewHolder> a = sc7.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            lh<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = sc7.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            fd7 fd7Var = new fd7(frsFragment.getPageContext(), gd7.b);
            zg7 zg7Var = new zg7(frsFragment.getPageContext(), jd7.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), ld7.e, this.a.getUniqueId());
            ug7 ug7Var = new ug7(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            ug7Var.x((BdTypeRecyclerView) eiVar);
            ah7 ah7Var = new ah7(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            mg7 mg7Var = new mg7(frsFragment.D(), f16.g);
            tg7 tg7Var = new tg7(frsFragment.getPageContext(), rk6.A0);
            tg7Var.u(eiVar);
            yg7 yg7Var = new yg7(frsFragment.getPageContext(), wk6.j);
            yg7Var.u(eiVar);
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
            this.c.add(hh7Var);
            this.c.add(ph7Var);
            this.c.add(og7Var);
            this.c.add(qg7Var);
            this.c.add(pg7Var);
            this.c.add(wg7Var);
            this.c.add(xg7Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(fd7Var);
            this.c.add(zg7Var);
            this.c.add(gh7Var);
            this.c.add(fh7Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(rh7Var2);
            this.c.add(ug7Var);
            this.c.add(ah7Var);
            this.c.add(mg7Var);
            this.c.add(new sg7(frsFragment.getPageContext()));
            this.c.add(tg7Var);
            this.c.add(yg7Var);
            this.c.add(ws7.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, "frs_hot_tab"));
            vy5 vy5Var = new vy5(this.a, 1);
            vy5Var.u(this.c);
            vy5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, vy5Var));
            z(this.c);
            eiVar.addAdapters(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<lh<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    lh<?, ?> next = it.next();
                    if (next instanceof yc7) {
                        ((yc7) next).m(this.a.getPageContext(), this.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<lh> list = this.c;
                if (list != null) {
                    list.addAll(arrayList);
                }
                ei eiVar2 = this.b;
                if (eiVar2 != null) {
                    eiVar2.addAdapters(arrayList);
                }
            }
        }
    }

    @Override // com.baidu.tieba.wh7
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (lh lhVar : this.c) {
                if (lhVar instanceof yc7) {
                    ((yc7) lhVar).x();
                } else if (lhVar instanceof jz9) {
                    ((jz9) lhVar).onDestroy();
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048599, this) != null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (lh lhVar : this.c) {
            if (lhVar instanceof yc7) {
                ((yc7) lhVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        vh7 vh7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (frsViewData = this.f) != null && frsViewData.getForum() != null && !StringUtils.isNull(this.f.getForum().getId()) && (vh7Var = this.i) != null) {
            vh7Var.L(this.f.getForum().getId());
        }
    }

    public final void r(ArrayList<yh> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                yh yhVar = (yh) ListUtils.getItem(arrayList, i - 1);
                yh yhVar2 = (yh) ListUtils.getItem(arrayList, i);
                if (yhVar2 instanceof py4) {
                    ThreadData threadData = ((py4) yhVar2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (yhVar instanceof jd7) {
                        threadData.needTopMargin = false;
                    } else if (yhVar != null && !p(yhVar)) {
                        threadData.needTopMargin = false;
                    } else if ((yhVar instanceof py4) && p(yhVar) && !TextUtils.isEmpty(((py4) yhVar).t.getRecomReason())) {
                        threadData.needTopMargin = true;
                    } else if (p(yhVar2) && !TextUtils.isEmpty(recomReason)) {
                        threadData.needTopMargin = true;
                    } else {
                        threadData.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.wh7
    public void setFromCDN(boolean z) {
        List<lh> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048597, this, z) == null) && (list = this.c) != null && list.size() != 0) {
            for (lh lhVar : this.c) {
                if (lhVar instanceof yc7) {
                    ((yc7) lhVar).setFromCDN(z);
                }
            }
            qh7 qh7Var = this.k;
            if (qh7Var != null) {
                qh7Var.setFromCDN(z);
            }
            ch7 ch7Var = this.l;
            if (ch7Var != null) {
                ch7Var.setFromCDN(z);
            }
            nh7 nh7Var = this.m;
            if (nh7Var != null) {
                nh7Var.setFromCDN(z);
            }
            kh7 kh7Var = this.n;
            if (kh7Var != null) {
                kh7Var.setFromCDN(z);
            }
            bh7 bh7Var = this.o;
            if (bh7Var != null) {
                bh7Var.setFromCDN(z);
            }
            eh7 eh7Var = this.p;
            if (eh7Var != null) {
                eh7Var.setFromCDN(z);
            }
            rh7 rh7Var = this.u;
            if (rh7Var != null) {
                rh7Var.setFromCDN(z);
            }
            lh7 lh7Var = this.w;
            if (lh7Var != null) {
                lh7Var.setFromCDN(z);
            }
        }
    }

    public void t(String str) {
        List<lh> list;
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
            for (lh lhVar : this.c) {
                if (lhVar != null) {
                    Class<?> cls3 = lhVar.getClass();
                    if (cls3 == cls) {
                        try {
                            cls3.getDeclaredMethod("setTab", String.class).invoke(lhVar, str);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else if (cls3 == cls2) {
                        try {
                            cls3.getDeclaredMethod("setPageTab", String.class).invoke(lhVar, str);
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

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
public class dl6 implements rl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsFragment a;
    public jo b;
    public List<qn> c;
    public final HashMap<Integer, ThreadData> d;
    public ArrayList<Cdo> e;
    public FrsViewData f;
    public boolean g;
    public final bh6 h;
    public ql6 i;
    public qn j;
    public ll6 k;
    public xk6 l;
    public il6 m;
    public fl6 n;
    public wk6 o;
    public zk6 p;
    public jl6 q;
    public nl6 r;
    public hl6 s;
    public el6 t;
    public ml6 u;
    public yk6 v;
    public gl6 w;

    public dl6(FrsFragment frsFragment, jo joVar, boolean z) {
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
        this.h = new bh6();
        o(frsFragment, joVar);
        this.d = new HashMap<>();
        m(z);
    }

    @Override // com.baidu.tieba.rl6
    public void a(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof g26) {
                ((g26) qnVar).a(str);
            }
        }
    }

    @Override // com.baidu.tieba.rl6
    public void b() {
        jo joVar;
        List<Cdo> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (joVar = this.b) == null || joVar.getData() == null || this.b.getData().size() == 0 || (data = this.b.getData()) == null || data.size() == 0) {
            return;
        }
        for (Cdo cdo : data) {
            if (cdo instanceof ThreadData) {
                ThreadData threadData = (ThreadData) cdo;
                if (threadData.getIs_top() != 0) {
                    threadData.parser_title();
                }
            } else if (cdo instanceof bu4) {
                bu4 bu4Var = (bu4) cdo;
                if (bu4Var.t.getIs_top() != 0) {
                    bu4Var.t.parser_title();
                }
            }
        }
    }

    @Override // com.baidu.tieba.rl6
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090b1a;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rl6
    public void d(no noVar) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, noVar) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof dh6) {
                ((dh6) qnVar).setOnAdapterItemClickListener(noVar);
            } else if ((qnVar instanceof gl6) || (qnVar instanceof ml6)) {
                qnVar.setOnAdapterItemClickListener(noVar);
            }
        }
    }

    @Override // com.baidu.tieba.rl6
    public void e() {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof dh6) {
                ((dh6) qnVar).m(this.a.getPageContext(), this.a.getUniqueId());
            }
        }
        z(this.c);
    }

    @Override // com.baidu.tieba.rl6
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

    @Override // com.baidu.tieba.rl6
    public void g(ArrayList<Cdo> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            jm8.f(arrayList, 1);
            n(arrayList);
            x(arrayList);
            r(arrayList);
            Iterator<Cdo> it = arrayList.iterator();
            while (it.hasNext()) {
                Cdo next = it.next();
                if ((next instanceof bu4) && ((bu4) next).t.isTop()) {
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

    @Override // com.baidu.tieba.rl6
    public HashMap<Integer, ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.rl6
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090af5;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rl6
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.obfuscated_res_0x7f090bc0;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.rl6
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

    @Override // com.baidu.tieba.rl6
    public void l(yg6 yg6Var) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, yg6Var) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof dh6) {
                ((dh6) qnVar).x(yg6Var);
            }
        }
    }

    @Override // com.baidu.tieba.rl6
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || this.g == z) {
            return;
        }
        this.g = z;
    }

    public final ArrayList<Integer> n(ArrayList<Cdo> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
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
        return (ArrayList) invokeL.objValue;
    }

    @Override // com.baidu.tieba.rl6
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.b.getListAdapter() == null) {
            return;
        }
        this.b.getListAdapter().notifyDataSetChanged();
    }

    public void o(FrsFragment frsFragment, jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, frsFragment, joVar) == null) {
            this.a = frsFragment;
            this.j = xg6.e().c(frsFragment.getPageContext(), mm8.d, this.a.getUniqueId(), false);
            ll6 ll6Var = new ll6(frsFragment.o(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            this.k = ll6Var;
            ll6Var.A(joVar);
            xk6 xk6Var = new xk6(frsFragment.o(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            this.l = xk6Var;
            xk6Var.A(joVar);
            il6 il6Var = new il6(frsFragment.o(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            this.m = il6Var;
            il6Var.A(joVar);
            fl6 fl6Var = new fl6(frsFragment.o(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            this.n = fl6Var;
            fl6Var.A(joVar);
            wk6 wk6Var = new wk6(frsFragment.o(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            this.o = wk6Var;
            wk6Var.A(joVar);
            zk6 zk6Var = new zk6(frsFragment.o(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            this.p = zk6Var;
            zk6Var.A(joVar);
            nl6 nl6Var = new nl6(frsFragment.o(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            this.r = nl6Var;
            nl6Var.A(joVar);
            jl6 jl6Var = new jl6(frsFragment.o(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            this.q = jl6Var;
            jl6Var.A(joVar);
            hl6 hl6Var = new hl6(frsFragment.o(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            this.s = hl6Var;
            hl6Var.A(joVar);
            el6 el6Var = new el6(frsFragment.o(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            this.t = el6Var;
            el6Var.A(joVar);
            ml6 ml6Var = new ml6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            this.u = ml6Var;
            ml6Var.A(joVar);
            yk6 yk6Var = new yk6(frsFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, this.a.getUniqueId());
            this.v = yk6Var;
            yk6Var.A(joVar);
            cl6 cl6Var = new cl6(frsFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            cl6Var.A(joVar);
            kl6 kl6Var = new kl6(frsFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            kl6Var.A(joVar);
            mk6 mk6Var = new mk6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsFragment.getUniqueId());
            mk6Var.A(joVar);
            mk6Var.p(1);
            ok6 ok6Var = new ok6(frsFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsFragment.getUniqueId());
            ok6Var.A(joVar);
            nk6 nk6Var = new nk6(frsFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            nk6Var.A(joVar);
            nk6Var.e0(true);
            sk6 sk6Var = new sk6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            sk6Var.A(joVar);
            sk6Var.e0(true);
            tk6 tk6Var = new tk6(frsFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            tk6Var.A(joVar);
            tk6Var.f0(true);
            ml6 ml6Var2 = new ml6(frsFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            ml6Var2.A(joVar);
            bl6 bl6Var = new bl6(frsFragment.getPageContext(), ThreadData.TYPE_INSERT_VIDEO, this.a.getUniqueId());
            bl6Var.A(joVar);
            al6 al6Var = new al6(frsFragment.getPageContext(), ThreadData.TYPE_FRS_HOTTOPIC, this.a.getUniqueId());
            al6Var.A(joVar);
            this.i = new ql6(frsFragment.getPageContext(), em8.c, this.a.getUniqueId());
            gl6 gl6Var = new gl6(frsFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            this.w = gl6Var;
            gl6Var.A(joVar);
            qn<? extends bu4, ? extends TypeAdapter.ViewHolder> a = xg6.e().a(frsFragment.getPageContext(), this.a.getUniqueId(), true);
            qn<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = xg6.e().d(frsFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            kh6 kh6Var = new kh6(frsFragment.getPageContext(), lh6.b);
            uk6 uk6Var = new uk6(frsFragment.getPageContext(), oh6.a);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), qh6.e, this.a.getUniqueId());
            qk6 qk6Var = new qk6(frsFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            qk6Var.v((BdTypeRecyclerView) joVar);
            vk6 vk6Var = new vk6(frsFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
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
            this.c.add(cl6Var);
            this.c.add(kl6Var);
            this.c.add(mk6Var);
            this.c.add(ok6Var);
            this.c.add(nk6Var);
            this.c.add(sk6Var);
            this.c.add(tk6Var);
            this.c.add(this.w);
            this.c.add(this.u);
            this.c.add(this.v);
            this.c.add(a);
            this.c.add(d);
            this.c.add(kh6Var);
            this.c.add(uk6Var);
            this.c.add(bl6Var);
            this.c.add(al6Var);
            this.c.add(frsUserRecommendAdapter);
            this.c.add(ml6Var2);
            this.c.add(qk6Var);
            this.c.add(vk6Var);
            this.c.add(xu6.e().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H, "frs_hot_tab"));
            qn5 qn5Var = new qn5(this.a, 1);
            qn5Var.u(this.c);
            qn5Var.x("frs_hot_tab");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, qn5Var));
            z(this.c);
            joVar.a(this.c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            s("page_frs");
            if (absDelegateAdapterList.isEmpty()) {
                return;
            }
            Iterator<qn<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                qn<?, ?> next = it.next();
                if (next instanceof dh6) {
                    ((dh6) next).m(this.a.getPageContext(), this.a.getUniqueId());
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

    @Override // com.baidu.tieba.rl6
    public void onDestory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            for (qn qnVar : this.c) {
                if (qnVar instanceof dh6) {
                    ((dh6) qnVar).v();
                } else if (qnVar instanceof sd8) {
                    ((sd8) qnVar).onDestroy();
                }
            }
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
            return type == ThreadData.TYPE_NORMAL || type == ThreadData.TYPE_GOD_NORMAL || type == ThreadData.TYPE_VIDEO || type == ThreadData.TYPE_VIDEO_GOD || type == ThreadData.TYPE_INSERT_VIDEO;
        }
        return invokeL.booleanValue;
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

    public final void r(ArrayList<Cdo> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i = 0; i < count; i++) {
                Cdo cdo = (Cdo) ListUtils.getItem(arrayList, i - 1);
                Cdo cdo2 = (Cdo) ListUtils.getItem(arrayList, i);
                if (cdo2 instanceof bu4) {
                    ThreadData threadData = ((bu4) cdo2).t;
                    if (i == 0) {
                        threadData.isFirstFloor = true;
                    } else {
                        threadData.isFirstFloor = false;
                    }
                    String recomReason = threadData.getRecomReason();
                    if (cdo instanceof oh6) {
                        threadData.needTopMargin = false;
                    } else if (cdo != null && !p(cdo)) {
                        threadData.needTopMargin = false;
                    } else if ((cdo instanceof bu4) && p(cdo) && !TextUtils.isEmpty(((bu4) cdo).t.getRecomReason())) {
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

    public final void s(String str) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (list = this.c) == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof to5) {
                ((to5) qnVar).g(str);
            }
        }
    }

    @Override // com.baidu.tieba.rl6
    public void setFromCDN(boolean z) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof dh6) {
                ((dh6) qnVar).setFromCDN(z);
            }
        }
        ll6 ll6Var = this.k;
        if (ll6Var != null) {
            ll6Var.setFromCDN(z);
        }
        xk6 xk6Var = this.l;
        if (xk6Var != null) {
            xk6Var.setFromCDN(z);
        }
        il6 il6Var = this.m;
        if (il6Var != null) {
            il6Var.setFromCDN(z);
        }
        fl6 fl6Var = this.n;
        if (fl6Var != null) {
            fl6Var.setFromCDN(z);
        }
        wk6 wk6Var = this.o;
        if (wk6Var != null) {
            wk6Var.setFromCDN(z);
        }
        zk6 zk6Var = this.p;
        if (zk6Var != null) {
            zk6Var.setFromCDN(z);
        }
        ml6 ml6Var = this.u;
        if (ml6Var != null) {
            ml6Var.setFromCDN(z);
        }
        gl6 gl6Var = this.w;
        if (gl6Var != null) {
            gl6Var.setFromCDN(z);
        }
    }

    public void t(String str) {
        List<qn> list;
        Class<?> cls;
        Class<?> cls2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
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

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || ListUtils.isEmpty(this.c) || this.a == null) {
            return;
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof dh6) {
                ((dh6) qnVar).C(this.a.getTbPageTag());
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, frsViewData) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof dh6) {
                ((dh6) qnVar).y(frsViewData);
            }
        }
    }

    public final void w() {
        bs6 i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.f == null) {
            return;
        }
        for (qn qnVar : this.c) {
            if ((qnVar instanceof ds6) && (i = ((ds6) qnVar).i()) != null) {
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
                if (frsFragment != null && frsFragment.J0() != null) {
                    int U = this.a.J0().U();
                    if (U == -1) {
                        U = this.a.J0().T();
                    }
                    i.b = U;
                }
            }
        }
    }

    public final void x(ArrayList<Cdo> arrayList) {
        List<qn> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, arrayList) == null) || (list = this.c) == null || list.size() == 0) {
            return;
        }
        int i = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Cdo> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == ThreadData.TYPE_TOP.getId()) {
                i++;
            }
        }
        for (qn qnVar : this.c) {
            if (qnVar instanceof dh6) {
                ((dh6) qnVar).D(i);
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        ql6 ql6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (frsViewData = this.f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f.getForum().getId()) || (ql6Var = this.i) == null) {
            return;
        }
        ql6Var.K(this.f.getForum().getId());
    }

    public final void z(List<qn> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, list) == null) || list == null) {
            return;
        }
        for (qn qnVar : list) {
            if (qnVar instanceof dh6) {
                ((dh6) qnVar).w(this.h);
            }
        }
    }
}

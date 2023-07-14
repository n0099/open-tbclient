package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class al7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public ko B;
    public CustomMessageListener C;
    public FrsCommonTabFragment a;
    public BdTypeRecyclerView b;
    public fi7 c;
    public List<ln> d;
    public km7 e;
    public wl7 f;
    public hm7 g;
    public em7 h;
    public vl7 i;
    public yl7 j;
    public im7 k;
    public mm7 l;
    public gm7 m;
    public dm7 n;
    public lm7 o;
    public xl7 p;
    public fm7 q;
    public bm7 r;
    public jm7 s;
    public jl7 t;
    public ll7 u;
    public kl7 v;
    public rl7 w;
    public sl7 x;
    public lm7 y;
    public pl7 z;

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(al7 al7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {al7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = al7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<ln<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    ln<?, ?> next = it.next();
                    if (next instanceof rp6) {
                        rp6 rp6Var = (rp6) next;
                        if ("FrsHottopicDelegateAdapter".equals(rp6Var.from()) && this.a.d != null) {
                            rp6Var.m(this.a.a.getPageContext(), this.a.a.getUniqueId());
                            if (this.a.A) {
                                rp6Var.setFrom("c13010");
                            }
                            this.a.d.add(next);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al7 a;

        public b(al7 al7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {al7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = al7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public al7(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new LinkedList();
        this.C = new a(this, 2003008);
        e(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.b = bdTypeRecyclerView;
        this.B = new ko(bdTypeRecyclerView);
    }

    public void j(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            l();
            this.b.setData(i(arrayList));
        }
    }

    public void e(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)}) == null) {
            this.a = frsCommonTabFragment;
            this.C.setPriority(1);
            this.C.setSelfListener(true);
            this.a.registerListener(this.C);
            this.e = new km7(frsCommonTabFragment.t(), ThreadData.TYPE_USER_NORMAL, frsCommonTabFragment.getUniqueId());
            this.f = new wl7(frsCommonTabFragment.t(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, frsCommonTabFragment.getUniqueId());
            this.g = new hm7(frsCommonTabFragment.t(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, frsCommonTabFragment.getUniqueId());
            this.h = new em7(frsCommonTabFragment.t(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, frsCommonTabFragment.getUniqueId());
            this.i = new vl7(frsCommonTabFragment.t(), ThreadData.TYPE_BOTTOM_NORMAL, frsCommonTabFragment.getUniqueId());
            this.j = new yl7(frsCommonTabFragment.t(), ThreadData.TYPE_GODREPLY_NORMAL, frsCommonTabFragment.getUniqueId());
            this.k = new im7(frsCommonTabFragment.t(), ThreadData.TYPE_SMART_APP, frsCommonTabFragment.getUniqueId());
            this.l = new mm7(frsCommonTabFragment.t(), ThreadData.TYPE_VOTE, frsCommonTabFragment.getUniqueId());
            gm7 gm7Var = new gm7(frsCommonTabFragment.t(), ThreadData.TYPE_SINGLE_LINK, frsCommonTabFragment.getUniqueId());
            this.m = gm7Var;
            gm7Var.I(frsCommonTabFragment.h);
            dm7 dm7Var = new dm7(frsCommonTabFragment.t(), ThreadData.TYPE_MULTI_LINK, frsCommonTabFragment.getUniqueId());
            this.n = dm7Var;
            dm7Var.I(frsCommonTabFragment.h);
            this.o = new lm7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_VIDEO, frsCommonTabFragment.getUniqueId());
            this.p = new xl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, frsCommonTabFragment.getUniqueId());
            this.q = new fm7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, frsCommonTabFragment.getUniqueId());
            this.r = new bm7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_LINK, frsCommonTabFragment.getUniqueId());
            this.s = new jm7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.t = new jl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsCommonTabFragment.getUniqueId());
            this.u = new ll7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsCommonTabFragment.getUniqueId());
            this.v = new kl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.w = new rl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.x = new sl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.y = new lm7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, frsCommonTabFragment.getUniqueId());
            this.c = new fi7(frsCommonTabFragment.getPageContext(), gi7.b);
            if (!z) {
                this.z = new pl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ITEM, frsCommonTabFragment.getUniqueId());
            }
            this.d.add(this.e);
            this.d.add(this.f);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.i);
            this.d.add(this.j);
            this.d.add(this.k);
            this.d.add(this.l);
            this.d.add(this.m);
            this.d.add(this.n);
            this.d.add(this.o);
            this.d.add(this.p);
            this.d.add(this.q);
            this.d.add(this.r);
            this.d.add(this.s);
            this.d.add(this.t);
            this.d.add(this.u);
            this.d.add(this.v);
            this.d.add(this.w);
            this.d.add(this.x);
            this.d.add(this.y);
            this.d.add(this.c);
            if (!z) {
                this.d.add(this.z);
            }
            f();
            for (ln lnVar : this.d) {
                if (lnVar instanceof yh7) {
                    yh7 yh7Var = (yh7) lnVar;
                    yh7Var.C(bdTypeRecyclerView);
                    if (frsCommonTabFragment.g == 89) {
                        yh7Var.setFrom("c13010");
                    }
                }
                if (lnVar instanceof sp6) {
                    ((sp6) lnVar).p(3);
                }
            }
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003022);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
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
                List<ln> list = this.d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            if (frsCommonTabFragment.j == 1) {
                m(frsViewData);
            }
            l();
            bdTypeRecyclerView.addAdapters(this.d);
            n();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ln<?, ?> e = uy9.m().e(this.a, AdvertAppInfo.x);
            ln<?, ?> e2 = uy9.m().e(this.a, AdvertAppInfo.A);
            ln<?, ?> e3 = uy9.m().e(this.a, AdvertAppInfo.B);
            ln<?, ?> e4 = uy9.m().e(this.a, AdvertAppInfo.C);
            ln<?, ?> e5 = uy9.m().e(this.a, AdvertAppInfo.D);
            this.d.add(e);
            this.d.add(e2);
            this.d.add(e3);
            this.d.add(e4);
            this.d.add(e5);
            ln<?, ?> d = vx7.h().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.I);
            ln<?, ?> d2 = vx7.h().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H);
            this.d.add(d);
            this.d.add(d2);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.a != null && !ListUtils.isEmpty(this.d)) {
            for (ln lnVar : this.d) {
                if (lnVar instanceof kt7) {
                    kt7 kt7Var = (kt7) lnVar;
                    if (kt7Var.i() != null) {
                        kt7Var.i().a = this.a.k;
                        kt7Var.i().c = this.a.e;
                        kt7Var.i().d = this.a.f;
                        kt7Var.i().e = this.a.g;
                        it7 i = kt7Var.i();
                        FrsCommonTabFragment frsCommonTabFragment = this.a;
                        i.h = frsCommonTabFragment.h;
                        if (frsCommonTabFragment.j == 1) {
                            kt7Var.i().g = 12;
                        }
                    }
                }
            }
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.B.e(new b(this));
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (ln lnVar : this.d) {
                if (lnVar instanceof yh7) {
                    ((yh7) lnVar).x();
                } else if (lnVar instanceof ky9) {
                    ((ky9) lnVar).onDestroy();
                }
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (ln lnVar : this.d) {
            if (lnVar instanceof yh7) {
                ((yh7) lnVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final ArrayList<yn> i(ArrayList<yn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, arrayList)) == null) {
            ArrayList<yn> arrayList2 = new ArrayList<>();
            Iterator<yn> it = arrayList.iterator();
            while (it.hasNext()) {
                yn next = it.next();
                if (next instanceof ThreadData) {
                    ThreadData threadData = (ThreadData) next;
                    if (threadData.getItem() != null) {
                        if (!threadData.isVoteThreadType()) {
                            arrayList2.add(next);
                        } else {
                            threadData.setItem(null);
                            arrayList2.add(next);
                        }
                    } else {
                        arrayList2.add(next);
                    }
                } else {
                    arrayList2.add(next);
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public final void m(FrsViewData frsViewData) {
        List<ln> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) && (list = this.d) != null && list.size() != 0) {
            for (ln lnVar : this.d) {
                if (lnVar instanceof yh7) {
                    ((yh7) lnVar).A(frsViewData);
                }
            }
        }
    }
}

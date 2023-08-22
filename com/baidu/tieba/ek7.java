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
public class ek7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public nn B;
    public CustomMessageListener C;
    public FrsCommonTabFragment a;
    public BdTypeRecyclerView b;
    public fh7 c;
    public List<om> d;
    public ol7 e;
    public al7 f;
    public ll7 g;
    public il7 h;
    public zk7 i;
    public cl7 j;
    public ml7 k;
    public ql7 l;
    public kl7 m;
    public hl7 n;
    public pl7 o;
    public bl7 p;
    public jl7 q;
    public fl7 r;
    public nl7 s;
    public nk7 t;
    public pk7 u;
    public ok7 v;
    public vk7 w;
    public wk7 x;
    public pl7 y;
    public tk7 z;

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ek7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ek7 ek7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ek7Var, Integer.valueOf(i)};
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
            this.a = ek7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<om<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    om<?, ?> next = it.next();
                    if (next instanceof go6) {
                        go6 go6Var = (go6) next;
                        if ("FrsHottopicDelegateAdapter".equals(go6Var.from()) && this.a.d != null) {
                            go6Var.m(this.a.a.getPageContext(), this.a.a.getUniqueId());
                            if (this.a.A) {
                                go6Var.setFrom("c13010");
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
        public final /* synthetic */ ek7 a;

        public b(ek7 ek7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ek7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ek7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.getAdapter().notifyDataSetChanged();
            }
        }
    }

    public ek7(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
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
        this.B = new nn(bdTypeRecyclerView);
    }

    public void j(ArrayList<bn> arrayList) {
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
            this.e = new ol7(frsCommonTabFragment.u(), ThreadData.TYPE_USER_NORMAL, frsCommonTabFragment.getUniqueId());
            this.f = new al7(frsCommonTabFragment.u(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, frsCommonTabFragment.getUniqueId());
            this.g = new ll7(frsCommonTabFragment.u(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, frsCommonTabFragment.getUniqueId());
            this.h = new il7(frsCommonTabFragment.u(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, frsCommonTabFragment.getUniqueId());
            this.i = new zk7(frsCommonTabFragment.u(), ThreadData.TYPE_BOTTOM_NORMAL, frsCommonTabFragment.getUniqueId());
            this.j = new cl7(frsCommonTabFragment.u(), ThreadData.TYPE_GODREPLY_NORMAL, frsCommonTabFragment.getUniqueId());
            this.k = new ml7(frsCommonTabFragment.u(), ThreadData.TYPE_SMART_APP, frsCommonTabFragment.getUniqueId());
            this.l = new ql7(frsCommonTabFragment.u(), ThreadData.TYPE_VOTE, frsCommonTabFragment.getUniqueId());
            kl7 kl7Var = new kl7(frsCommonTabFragment.u(), ThreadData.TYPE_SINGLE_LINK, frsCommonTabFragment.getUniqueId());
            this.m = kl7Var;
            kl7Var.I(frsCommonTabFragment.h);
            hl7 hl7Var = new hl7(frsCommonTabFragment.u(), ThreadData.TYPE_MULTI_LINK, frsCommonTabFragment.getUniqueId());
            this.n = hl7Var;
            hl7Var.I(frsCommonTabFragment.h);
            this.o = new pl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_VIDEO, frsCommonTabFragment.getUniqueId());
            this.p = new bl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_FAKE_VIDEO, frsCommonTabFragment.getUniqueId());
            this.q = new jl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, frsCommonTabFragment.getUniqueId());
            this.r = new fl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_LINK, frsCommonTabFragment.getUniqueId());
            this.s = new nl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.t = new nk7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ARTICLE, frsCommonTabFragment.getUniqueId());
            this.u = new pk7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_CONTENT_FEED_PIC_NORMMAL, frsCommonTabFragment.getUniqueId());
            this.v = new ok7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.w = new vk7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.x = new wk7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, frsCommonTabFragment.getUniqueId());
            this.y = new pl7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, frsCommonTabFragment.getUniqueId());
            this.c = new fh7(frsCommonTabFragment.getPageContext(), gh7.b);
            if (!z) {
                this.z = new tk7(frsCommonTabFragment.getPageContext(), ThreadData.TYPE_ITEM, frsCommonTabFragment.getUniqueId());
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
            for (om omVar : this.d) {
                if (omVar instanceof yg7) {
                    yg7 yg7Var = (yg7) omVar;
                    yg7Var.C(bdTypeRecyclerView);
                    if (frsCommonTabFragment.g == 89) {
                        yg7Var.setFrom("c13010");
                    }
                }
                if (omVar instanceof ho6) {
                    ((ho6) omVar).p(3);
                }
            }
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003022);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
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
                List<om> list = this.d;
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
            om<?, ?> e = r1a.m().e(this.a, AdvertAppInfo.x);
            om<?, ?> e2 = r1a.m().e(this.a, AdvertAppInfo.A);
            om<?, ?> e3 = r1a.m().e(this.a, AdvertAppInfo.B);
            om<?, ?> e4 = r1a.m().e(this.a, AdvertAppInfo.C);
            om<?, ?> e5 = r1a.m().e(this.a, AdvertAppInfo.D);
            this.d.add(e);
            this.d.add(e2);
            this.d.add(e3);
            this.d.add(e4);
            this.d.add(e5);
            om<?, ?> d = zw7.h().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.I);
            om<?, ?> d2 = zw7.h().d(this.a.getBaseFragmentActivity(), AdvertAppInfo.H);
            this.d.add(d);
            this.d.add(d2);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.a != null && !ListUtils.isEmpty(this.d)) {
            for (om omVar : this.d) {
                if (omVar instanceof os7) {
                    os7 os7Var = (os7) omVar;
                    if (os7Var.i() != null) {
                        os7Var.i().a = this.a.k;
                        os7Var.i().c = this.a.e;
                        os7Var.i().d = this.a.f;
                        os7Var.i().e = this.a.g;
                        ms7 i = os7Var.i();
                        FrsCommonTabFragment frsCommonTabFragment = this.a;
                        i.h = frsCommonTabFragment.h;
                        if (frsCommonTabFragment.j == 1) {
                            os7Var.i().g = 12;
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
            for (om omVar : this.d) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).x();
                } else if (omVar instanceof h1a) {
                    ((h1a) omVar).onDestroy();
                }
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (om omVar : this.d) {
            if (omVar instanceof yg7) {
                ((yg7) omVar).E(this.a.getTbPageTag());
            }
        }
    }

    public final ArrayList<bn> i(ArrayList<bn> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, arrayList)) == null) {
            ArrayList<bn> arrayList2 = new ArrayList<>();
            Iterator<bn> it = arrayList.iterator();
            while (it.hasNext()) {
                bn next = it.next();
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
        List<om> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) && (list = this.d) != null && list.size() != 0) {
            for (om omVar : this.d) {
                if (omVar instanceof yg7) {
                    ((yg7) omVar).A(frsViewData);
                }
            }
        }
    }
}

package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class f58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<kn> a;
    public DetailInfoFragment b;
    public ox7 c;
    public BdTypeRecyclerView d;
    public List<xn> e;
    public k58 f;
    public i58 g;
    public PbFirstFloorCommentAndPraiseAdapter h;
    public c08 i;
    public a08 j;
    public s08 k;
    public PbFirstFloorItemAdapter l;
    public r18 m;
    public kn n;
    public kn o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f58 a;

        /* renamed from: com.baidu.tieba.f58$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0259a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: com.baidu.tieba.f58$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0260a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C0259a a;

                public RunnableC0260a(C0259a c0259a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0259a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c0259a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.a.a.a.b.K().o3(3);
                    }
                }
            }

            public C0259a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        ah.a().postDelayed(new RunnableC0260a(this), 10L);
                    } else {
                        this.a.a.b.I1();
                    }
                }
            }
        }

        public a(f58 f58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f58Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null && this.a.b.K() != null) {
                FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.b.getPageContext(), new C0259a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f58 a;

        public b(f58 f58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f58Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091b6f) {
                    if (!this.a.f(11009)) {
                        return;
                    }
                    this.a.i(8);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091eee) {
                    if (!this.a.f(11009)) {
                        return;
                    }
                    this.a.i(3);
                } else if (this.a.b != null && this.a.b.B() != null && this.a.b.B().O3() != null) {
                    this.a.b.B().O3().onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends nj5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f58 a;

        public c(f58 f58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nj5
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (ShareSwitch.isOn()) {
                    i = 1;
                } else {
                    i = 6;
                }
                return o38.d(this.a.h(), i, this.a.b.K());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements si5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ f58 b;

        public d(f58 f58Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f58Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f58Var;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.si5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.b.getContext(), this.a, shareItem, false));
            }
        }
    }

    public f58(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.p = new a(this);
        this.q = new b(this);
        this.b = detailInfoFragment;
        this.d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(kp8 kp8Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, kp8Var) == null) && kp8Var != null && this.c != null && kp8Var.getAdvertAppInfo() != null) {
            kp8Var.getAdvertAppInfo().i = new xr4();
            if (this.c.z() != null) {
                kp8Var.getAdvertAppInfo().i.b = this.c.z().a();
            }
            kp8Var.getAdvertAppInfo().i.a = kp8Var.o1();
            if (this.c.l() != null && (l = this.c.l()) != null) {
                kp8Var.getAdvertAppInfo().i.c = l.getId();
                kp8Var.getAdvertAppInfo().i.d = l.getFirst_class();
                kp8Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                kp8Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            kp8Var.getAdvertAppInfo().i.g = kp8Var.getAdvertAppInfo().g;
            kp8Var.getAdvertAppInfo().i.h = false;
        }
    }

    public final boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(this.b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.b.P(), true, i)));
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            rj5.b(new c(this), new d(this, i));
            StatisticItem statisticItem = new StatisticItem("c13833");
            statisticItem.param("obj_locate", 1);
            if (i == 3) {
                statisticItem.param("obj_type", 1);
            } else if (i == 8) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void j(DetailInfoFragment detailInfoFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, detailInfoFragment) == null) {
            this.n = gg8.l().a(detailInfoFragment.B().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.o = gg8.l().a(detailInfoFragment.B().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.a.add(this.n);
            this.a.add(this.o);
        }
    }

    public void n(ox7 ox7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, ox7Var) != null) || ox7Var == null) {
            return;
        }
        this.c = ox7Var;
        BdTypeRecyclerView bdTypeRecyclerView = this.d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f.U(ox7Var);
        this.j.y(ox7Var);
        this.k.w(ox7Var);
        this.d.setData(g(ox7Var));
    }

    public final List<xn> g(ox7 ox7Var) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ox7Var)) == null) {
            kp8 kp8Var = null;
            if (ox7Var == null) {
                return null;
            }
            this.e = new ArrayList();
            Iterator<PostData> it = ox7Var.H().iterator();
            while (true) {
                if (it.hasNext()) {
                    PostData next = it.next();
                    if (next instanceof PostData) {
                        postData = next;
                        if (postData.D() == 1) {
                            break;
                        }
                    }
                } else {
                    postData = null;
                    break;
                }
            }
            if (postData == null && ox7Var.j() != null) {
                postData = ox7Var.j();
            }
            if (postData != null) {
                this.e.add(postData);
            }
            iy7 iy7Var = new iy7();
            ThreadData Q = ox7Var.Q();
            iy7Var.a = Q;
            if (Q != null && xi.isEmpty(Q.getForum_name())) {
                iy7Var.a.setForum_name(ox7Var.n());
            }
            this.e.add(iy7Var);
            cy7 cy7Var = new cy7(ox7Var.Q(), ox7Var.d());
            cy7Var.b = true;
            this.e.add(cy7Var);
            if (postData != null && postData.q0 != null && (ox7Var.l() == null || !TextUtils.equals(ox7Var.l().getName(), this.b.K().r1()) || !this.b.K().x1())) {
                rx7 rx7Var = new rx7(postData.q0);
                rx7Var.b = this.b.K().m2();
                this.e.add(rx7Var);
            }
            List<kp8> c0 = ox7Var.c0();
            int i = 0;
            int i2 = -1;
            if (!gj7.e(c0) && (kp8Var = (kp8) gj7.d(c0, 0)) != null) {
                i2 = kp8Var.getPosition();
            }
            if (ox7Var.f() != null) {
                nx7 nx7Var = new nx7();
                nx7Var.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f1011));
                this.e.add(nx7Var);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.e.add(new dy7());
                } else {
                    int i3 = 1;
                    for (js4 js4Var : ox7Var.f()) {
                        if (c0 != null && i3 == i2) {
                            if (kp8Var != null) {
                                e(kp8Var);
                                gj7.a(this.e, kp8Var);
                                i++;
                                if (kp8Var.getType() != AdvertAppInfo.x) {
                                    i3++;
                                }
                            }
                            if (i < c0.size() && (kp8Var = (kp8) gj7.d(c0, i)) != null) {
                                i2 = kp8Var.getPosition();
                            }
                        }
                        gj7.a(this.e, js4Var);
                        i3++;
                        if (i3 == 4 && ox7Var.D() != null) {
                            gj7.a(this.e, ox7Var.D());
                            i3++;
                        }
                    }
                }
            }
            return this.e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ox7 ox7Var = this.c;
            if (ox7Var != null && ox7Var.Q() != null) {
                return this.c.Q().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (bdTypeRecyclerView = this.d) != null && bdTypeRecyclerView.getAdapter() != null) {
            this.d.getListAdapter().notifyDataSetChanged();
        }
    }

    public void m() {
        k58 k58Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (k58Var = this.f) != null) {
            k58Var.notifyDataSetChanged();
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment B = detailInfoFragment.B();
            this.f = new k58(B, B, PostData.M0);
            this.g = new i58(detailInfoFragment.getContext(), iy7.b);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.B(), cy7.f);
            this.h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.H(this.q);
            this.i = new c08(detailInfoFragment.B(), nx7.c);
            a08 a08Var = new a08(detailInfoFragment.B(), js4.e);
            this.j = a08Var;
            a08Var.z(true);
            this.k = new s08(detailInfoFragment.B());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), rx7.c);
            r18 r18Var = new r18(detailInfoFragment.B(), dy7.a);
            this.m = r18Var;
            r18Var.x(this.p);
            this.a.add(this.f);
            this.a.add(this.g);
            this.a.add(this.h);
            this.a.add(this.i);
            this.a.add(this.j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.a(this.a);
        }
    }
}

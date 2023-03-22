package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class cq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<tm> a;
    public DetailInfoFragment b;
    public ki8 c;
    public BdTypeRecyclerView d;
    public List<gn> e;
    public hq8 f;
    public fq8 g;
    public PbFirstFloorCommentAndPraiseAdapter h;
    public yk8 i;
    public wk8 j;
    public ol8 k;
    public PbFirstFloorItemAdapter l;
    public nm8 m;
    public tm n;
    public tm o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cq8 a;

        public a(cq8 cq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.b != null && this.a.b.L() != null) {
                FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.b.getPageContext());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cq8 a;

        public b(cq8 cq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.qq_share_container) {
                    if (!this.a.f(11009)) {
                        return;
                    }
                    this.a.i(8);
                } else if (view2.getId() == R.id.share_num_container) {
                    if (!this.a.f(11009)) {
                        return;
                    }
                    this.a.i(3);
                } else if (this.a.b != null && this.a.b.D() != null && this.a.b.D().c4() != null) {
                    this.a.b.D().c4().onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends wp5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cq8 a;

        public c(cq8 cq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cq8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp5
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
                return lo8.d(this.a.h(), i, this.a.b.L());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements zo5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ cq8 b;

        public d(cq8 cq8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cq8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cq8Var;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zo5
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.b.b.getContext(), this.a, shareItem, false));
            }
        }
    }

    public cq8(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
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

    public final void e(ac9 ac9Var) {
        ForumData l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ac9Var) == null) && ac9Var != null && this.c != null && ac9Var.getAdvertAppInfo() != null) {
            ac9Var.getAdvertAppInfo().i = new mw4();
            if (this.c.z() != null) {
                ac9Var.getAdvertAppInfo().i.b = this.c.z().a();
            }
            ac9Var.getAdvertAppInfo().i.a = ac9Var.r1();
            if (this.c.l() != null && (l = this.c.l()) != null) {
                ac9Var.getAdvertAppInfo().i.c = l.getId();
                ac9Var.getAdvertAppInfo().i.d = l.getFirst_class();
                ac9Var.getAdvertAppInfo().i.e = l.getSecond_class();
            }
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                ac9Var.getAdvertAppInfo().i.f = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
            }
            ac9Var.getAdvertAppInfo().i.g = ac9Var.getAdvertAppInfo().g;
            ac9Var.getAdvertAppInfo().i.h = false;
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
            TbadkCoreApplication.getInst().login(this.b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.b.M(), true, i)));
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            aq5.b(new c(this), new d(this, i));
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
            this.n = f19.l().a(detailInfoFragment.D().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.o = f19.l().a(detailInfoFragment.D().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.a.add(this.n);
            this.a.add(this.o);
        }
    }

    public void n(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, ki8Var) != null) || ki8Var == null) {
            return;
        }
        this.c = ki8Var;
        BdTypeRecyclerView bdTypeRecyclerView = this.d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f.W(ki8Var);
        this.j.A(ki8Var);
        this.k.y(ki8Var);
        this.d.setData(g(ki8Var));
    }

    public final List<gn> g(ki8 ki8Var) {
        InterceptResult invokeL;
        bc9 bc9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ki8Var)) == null) {
            ac9 ac9Var = null;
            if (ki8Var == null) {
                return null;
            }
            this.e = new ArrayList();
            Iterator<bc9> it = ki8Var.H().iterator();
            while (true) {
                if (it.hasNext()) {
                    bc9 next = it.next();
                    if (next instanceof bc9) {
                        bc9Var = next;
                        if (bc9Var.E() == 1) {
                            break;
                        }
                    }
                } else {
                    bc9Var = null;
                    break;
                }
            }
            if (bc9Var == null && ki8Var.j() != null) {
                bc9Var = ki8Var.j();
            }
            if (bc9Var != null) {
                this.e.add(bc9Var);
            }
            ej8 ej8Var = new ej8();
            ThreadData Q = ki8Var.Q();
            ej8Var.a = Q;
            if (Q != null && gi.isEmpty(Q.getForum_name())) {
                ej8Var.a.setForum_name(ki8Var.n());
            }
            this.e.add(ej8Var);
            yi8 yi8Var = new yi8(ki8Var.Q(), ki8Var.d());
            yi8Var.b = true;
            this.e.add(yi8Var);
            if (bc9Var != null && bc9Var.r0 != null && (ki8Var.l() == null || !TextUtils.equals(ki8Var.l().getName(), this.b.L().V0()) || !this.b.L().b1())) {
                ni8 ni8Var = new ni8(bc9Var.r0);
                ni8Var.b = this.b.L().Q1();
                this.e.add(ni8Var);
            }
            List<ac9> c0 = ki8Var.c0();
            int i = 0;
            int i2 = -1;
            if (!v38.e(c0) && (ac9Var = (ac9) v38.d(c0, 0)) != null) {
                i2 = ac9Var.getPosition();
            }
            if (ki8Var.f() != null) {
                ji8 ji8Var = new ji8();
                ji8Var.f(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                this.e.add(ji8Var);
                if (PermissionUtil.isBrowseMode()) {
                    this.e.add(new zi8());
                } else {
                    int i3 = 1;
                    for (yw4 yw4Var : ki8Var.f()) {
                        if (c0 != null && i3 == i2) {
                            if (ac9Var != null) {
                                e(ac9Var);
                                v38.a(this.e, ac9Var);
                                i++;
                                if (ac9Var.getType() != AdvertAppInfo.x) {
                                    i3++;
                                }
                            }
                            if (i < c0.size() && (ac9Var = (ac9) v38.d(c0, i)) != null) {
                                i2 = ac9Var.getPosition();
                            }
                        }
                        v38.a(this.e, yw4Var);
                        i3++;
                        if (i3 == 4 && ki8Var.D() != null) {
                            v38.a(this.e, ki8Var.D());
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
            ki8 ki8Var = this.c;
            if (ki8Var != null && ki8Var.Q() != null) {
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
        hq8 hq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (hq8Var = this.f) != null) {
            hq8Var.notifyDataSetChanged();
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment D = detailInfoFragment.D();
            this.f = new hq8(D, D, bc9.P0);
            this.g = new fq8(detailInfoFragment.getContext(), ej8.b);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.D(), yi8.f);
            this.h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.J(this.q);
            this.i = new yk8(detailInfoFragment.D(), ji8.c);
            wk8 wk8Var = new wk8(detailInfoFragment.D(), yw4.e);
            this.j = wk8Var;
            wk8Var.B(true);
            this.k = new ol8(detailInfoFragment.D());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), ni8.c);
            nm8 nm8Var = new nm8(detailInfoFragment.D(), zi8.a);
            this.m = nm8Var;
            nm8Var.y(this.p);
            this.a.add(this.f);
            this.a.add(this.g);
            this.a.add(this.h);
            this.a.add(this.i);
            this.a.add(this.j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.addAdapters(this.a);
        }
    }
}

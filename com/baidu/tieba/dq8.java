package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class dq8 extends aq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gq8 A;
    public PbFirstFloorItemAdapter B;
    public tm C;
    public tm D;
    public View.OnClickListener E;
    public zk8 n;
    public hq8 o;
    public PbFirstFloorCommentAndPraiseAdapter p;
    public eq8 q;
    public PbFirstFloorEnterForumAdapter r;
    public em8 s;
    public PbReplyLoadMoreAdapter t;
    public zl8 u;
    public ql8 v;
    public rl8 w;
    public yk8 x;
    public wk8 y;
    public ol8 z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq8 a;

        public a(dq8 dq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.qq_share_container) {
                    if (this.a.L(11009)) {
                        this.a.N(8);
                    }
                } else if (view2.getId() == R.id.share_num_container && this.a.L(11009)) {
                    this.a.N(3);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends wp5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dq8 a;

        public b(dq8 dq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dq8Var;
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
                return lo8.d(this.a.M(), i, this.a.b.L());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements zo5<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ dq8 b;

        public c(dq8 dq8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dq8Var;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dq8(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        super(detailInfoAndReplyFragment, bdTypeRecyclerView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DetailInfoAndReplyFragment) objArr2[0], (BdTypeRecyclerView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.E = new a(this);
        O();
    }

    @Override // com.baidu.tieba.aq8
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            super.A(onClickListener);
            this.n.e(onClickListener);
            this.s.e(onClickListener);
            this.t.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void B(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
            this.v.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void C(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.w.y(onClickListener);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void D(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ki8Var) == null) {
            this.s.r(ki8Var);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void E(mj8 mj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mj8Var) == null) {
            super.E(mj8Var);
            this.n.y0(mj8Var);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void F(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ki8Var) == null) {
            this.o.W(ki8Var);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.o.o(str);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void p(boolean z) {
        tm tmVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && (tmVar = this.D) != null && (tmVar instanceof b19)) {
            ((b19) tmVar).setIsFromCDN(z);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void v(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            super.v(onClickListener);
            this.n.k(onClickListener);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void w(boolean z) {
        zk8 zk8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048595, this, z) == null) && (zk8Var = this.n) != null) {
            zk8Var.x0(z);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void x(TbRichTextView.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, a0Var) == null) {
            super.x(a0Var);
            this.n.n(a0Var);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void y(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onLongClickListener) == null) {
            super.y(onLongClickListener);
            this.n.d(onLongClickListener);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void z(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, fVar) == null) {
            super.z(fVar);
            this.s.B(fVar);
        }
    }

    public final boolean L(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(this.b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.b.M(), true, i)));
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            aq5.b(new b(this), new c(this, i));
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

    public final int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ki8 ki8Var = this.d;
            if (ki8Var != null && ki8Var.Q() != null) {
                return this.d.Q().getActInfoType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.aq8
    public em8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.s;
        }
        return (em8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.aq8
    public zk8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.n;
        }
        return (zk8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.aq8
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.p;
        }
        return (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // com.baidu.tieba.aq8
    public void m() {
        hq8 hq8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (hq8Var = this.o) != null) {
            hq8Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.aq8
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            em8 em8Var = this.s;
            if (em8Var != null) {
                em8Var.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.p;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AbsVideoPbFragment D = this.b.D();
            this.o = new hq8(D, D, bc9.P0);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.b.D(), yi8.f);
            this.p = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.J(this.E);
            this.q = new eq8(this.b.getContext(), fj8.b);
            this.r = new PbFirstFloorEnterForumAdapter(this.b, mi8.j);
            this.s = new em8(this.b.D(), xi8.i);
            this.v = new ql8(this.b.D(), qi8.c, this.b.getUniqueId());
            this.w = new rl8(this.b.D(), ri8.a);
            this.u = new zl8(this.b.D(), ui8.f1);
            this.x = new yk8(this.b.D(), ji8.c);
            wk8 wk8Var = new wk8(this.b.D(), yw4.e);
            this.y = wk8Var;
            wk8Var.B(true);
            this.z = new ol8(this.b.D());
            zk8 zk8Var = new zk8(this.b.D(), bc9.Q0);
            this.n = zk8Var;
            zk8Var.z0(this.b.D());
            this.t = new PbReplyLoadMoreAdapter(this.b.D(), bc9.X0);
            this.C = f19.l().a(this.b.D().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.D = f19.l().a(this.b.D().getBaseFragmentActivity(), AdvertAppInfo.z);
            gq8 gq8Var = new gq8(this.b.getPageContext(), ThreadData.TYPE_ITEM, this.b.getUniqueId());
            this.A = gq8Var;
            gq8Var.u(this.c);
            this.B = new PbFirstFloorItemAdapter(this.b.getContext(), ni8.c);
            this.e.add(this.o);
            this.e.add(this.p);
            this.e.add(this.q);
            this.e.add(this.r);
            this.e.add(this.s);
            this.e.add(this.u);
            this.e.add(this.v);
            this.e.add(this.w);
            this.e.add(this.x);
            this.e.add(this.y);
            this.e.add(this.z);
            this.e.add(this.C);
            this.e.add(this.D);
            this.e.add(this.n);
            this.e.add(this.t);
            this.e.add(this.A);
            this.e.add(this.B);
            this.e.add(new PbPrivateTitleAdapter(this.b.D()));
            this.c.addAdapters(this.e);
        }
    }

    @Override // com.baidu.tieba.aq8
    public void q(ki8 ki8Var, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{ki8Var, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.n.r(ki8Var);
            this.n.setFromCDN(z);
            this.n.o(str);
            this.n.c(z2);
        }
    }
}

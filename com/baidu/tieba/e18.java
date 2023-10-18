package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.kt;
import com.baidu.tieba.vt;
import com.baidu.tieba.wr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e18 extends lh<sk6, AutoVideoCardViewHolder<sk6>> implements yz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public f28 c;
    public String d;
    public ei e;
    public st f;
    public bk6<sk6> g;

    /* loaded from: classes5.dex */
    public class a extends bk6<sk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e18 b;

        public a(e18 e18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bk6
        /* renamed from: d */
        public void a(View view2, sk6 sk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, sk6Var) == null) {
                tj6.b().d(true);
                wz5.c().h("page_recommend", "show_");
                if (this.b.c != null && sk6Var != null && sk6Var.getThreadData() != null && !StringUtils.isNull(sk6Var.getThreadData().getTid())) {
                    if (sk6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(sk6Var.G(sk6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !b08.b(JavaTypesHelper.toLong(sk6Var.getThreadData().getTid(), 0L))) {
                        b08.a(JavaTypesHelper.toLong(sk6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(JavaTypesHelper.toLong(sk6Var.getThreadData().getTid(), 0L), sk6Var.u(), sk6Var.i(), sk6Var.h(), sk6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, sk6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, sk6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements wr.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ st a;
        public final /* synthetic */ e18 b;

        public b(e18 e18Var, st stVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e18Var, stVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e18Var;
            this.a = stVar;
        }

        @Override // com.baidu.tieba.wr.a
        public void a(jv4 jv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, jv4Var) != null) || jv4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (jv4Var instanceof sk6) {
                jv4Var.objType = 5;
                ThreadCardUtils.jumpToPB(jv4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(jv4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e18 a;

        public c(e18 e18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e18Var;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (yhVar instanceof sk6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                sk6 sk6Var = (sk6) yhVar;
                sk6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), sk6Var);
                }
                ThreadCardUtils.jumpToPB((jv4) sk6Var, view2.getContext(), 2, false, as.a((ei) viewGroup, view2, i));
                autoVideoCardViewHolder.a().q(new vt.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e18(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new a(this);
        this.b = tbPageContext;
        B();
    }

    public void E(f28 f28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, f28Var) == null) {
            this.c = f28Var;
        }
    }

    public void F(ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, eiVar) == null) {
            this.e = eiVar;
        }
    }

    @Override // com.baidu.tieba.yz5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(View view2, sk6 sk6Var) {
        st stVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, sk6Var) == null) && (stVar = this.f) != null && stVar.u() != null && this.f.u().getMainView() != null) {
            if (view2.getId() == this.f.u().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, sk6Var);
                k28.d(sk6Var.a, this.a, sk6Var.h(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(sk6Var.I()));
                k28.c(sk6Var.a, sk6Var.i(), sk6Var.h(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(sk6Var.G(sk6Var.a)));
                k28.c(sk6Var.a, sk6Var.i(), sk6Var.h(), 1);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sk6.V = "c10708";
            sk6.W = "c10735";
            sk6.X = "c10709";
            sk6.Y = "c10734";
            sk6.Z = "c11929";
            sk6.a0 = "c11928";
            sk6.b0 = "c10756";
        }
    }

    public void onPause() {
        st stVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (stVar = this.f) != null) {
            stVar.z();
        }
    }

    public void onResume() {
        st stVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (stVar = this.f) != null) {
            stVar.A();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: C */
    public AutoVideoCardViewHolder<sk6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            kt.b bVar = new kt.b(this.b.getPageActivity(), false);
            s28 s28Var = new s28(this.b.getPageActivity());
            s28Var.B(new b(this, s28Var));
            this.f = s28Var;
            s28Var.q(this.a);
            this.f.setFrom("index");
            this.f.setStageType("2001");
            bVar.n(this.f);
            kt k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<sk6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.r(this.g);
            k.t(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, sk6 sk6Var, AutoVideoCardViewHolder<sk6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, sk6Var, autoVideoCardViewHolder})) == null) {
            if (sk6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            sk6Var.A(sk6Var.position + 1);
            sk6Var.a.statFloor = sk6Var.h();
            autoVideoCardViewHolder.a().s(i);
            sk6Var.f1160T = 0;
            tj6.b().a(sk6Var.r());
            autoVideoCardViewHolder.y(z(sk6Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(sk6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().r(this.g);
            k28.p(sk6Var.a, this.a, sk6Var.h());
            k28.o(sk6Var.a, sk6Var.i(), sk6Var.h());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final aw9 z(sk6 sk6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, sk6Var)) == null) {
            if (sk6Var != null) {
                aw9 aw9Var = new aw9();
                aw9Var.a = "1";
                aw9Var.c = sk6Var.g;
                if (sk6Var.getThreadData() != null) {
                    aw9Var.d = String.valueOf(sk6Var.getThreadData().getFid());
                    aw9Var.v = sk6Var.getThreadData().getNid();
                    if (sk6Var.getThreadData().getThreadVideoInfo() != null) {
                        aw9Var.m = sk6Var.getThreadData().getThreadVideoInfo().video_md5;
                        aw9Var.p = String.valueOf(sk6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                aw9Var.k = sk6Var.e();
                aw9Var.f = sk6Var.i();
                aw9Var.l = sk6Var.c();
                aw9Var.h = sk6Var.u();
                aw9Var.e = TbadkCoreApplication.getCurrentAccount();
                aw9Var.q = String.valueOf(sk6Var.h());
                if (sk6Var.getThreadData() != null && sk6Var.getThreadData().getBaijiahaoData() != null) {
                    aw9Var.t = sk6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    aw9Var.u = sk6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return aw9Var;
                }
                return aw9Var;
            }
            return null;
        }
        return (aw9) invokeL.objValue;
    }
}

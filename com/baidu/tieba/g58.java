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
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.tieba.zw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g58 extends om<ap6, AutoVideoCardViewHolder<ap6>> implements s46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public h68 c;
    public String d;
    public hn e;
    public vy f;
    public jo6<ap6> g;

    /* loaded from: classes6.dex */
    public class a extends jo6<ap6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g58 b;

        public a(g58 g58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jo6
        /* renamed from: d */
        public void a(View view2, ap6 ap6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ap6Var) == null) {
                co6.b().d(true);
                q46.c().h("page_recommend", "show_");
                if (this.b.c != null && ap6Var != null && ap6Var.getThreadData() != null && !StringUtils.isNull(ap6Var.getThreadData().getTid())) {
                    if (ap6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(ap6Var.G(ap6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !d48.b(JavaTypesHelper.toLong(ap6Var.getThreadData().getTid(), 0L))) {
                        d48.a(JavaTypesHelper.toLong(ap6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(JavaTypesHelper.toLong(ap6Var.getThreadData().getTid(), 0L), ap6Var.u(), ap6Var.i(), ap6Var.h(), ap6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, ap6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.A(view2, ap6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements zw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;
        public final /* synthetic */ g58 b;

        public b(g58 g58Var, vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g58Var, vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = g58Var;
            this.a = vyVar;
        }

        @Override // com.baidu.tieba.zw.a
        public void a(w05 w05Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, w05Var) != null) || w05Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (w05Var instanceof ap6) {
                w05Var.objType = 5;
                ThreadCardUtils.jumpToPB(w05Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(w05Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g58 a;

        public c(g58 g58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g58Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof ap6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                ap6 ap6Var = (ap6) bnVar;
                ap6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), ap6Var);
                }
                ThreadCardUtils.jumpToPB((w05) ap6Var, view2.getContext(), 2, false, dx.a((hn) viewGroup, view2, i));
                autoVideoCardViewHolder.b().p(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g58(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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

    public void E(h68 h68Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, h68Var) == null) {
            this.c = h68Var;
        }
    }

    public void F(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, hnVar) == null) {
            this.e = hnVar;
        }
    }

    @Override // com.baidu.tieba.s46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public final void A(View view2, ap6 ap6Var) {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, ap6Var) == null) && (vyVar = this.f) != null && vyVar.u() != null && this.f.u().getMainView() != null) {
            if (view2.getId() == this.f.u().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, ap6Var);
                m68.d(ap6Var.a, this.a, ap6Var.h(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(ap6Var.I()));
                m68.c(ap6Var.a, ap6Var.i(), ap6Var.h(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(ap6Var.G(ap6Var.a)));
                m68.c(ap6Var.a, ap6Var.i(), ap6Var.h(), 1);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ap6.V = "c10708";
            ap6.W = "c10735";
            ap6.X = "c10709";
            ap6.Y = "c10734";
            ap6.Z = "c11929";
            ap6.a0 = "c11928";
            ap6.b0 = "c10756";
        }
    }

    public void onPause() {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (vyVar = this.f) != null) {
            vyVar.z();
        }
    }

    public void onResume() {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (vyVar = this.f) != null) {
            vyVar.A();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: C */
    public AutoVideoCardViewHolder<ap6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity(), false);
            t68 t68Var = new t68(this.b.getPageActivity());
            t68Var.B(new b(this, t68Var));
            this.f = t68Var;
            t68Var.q(this.a);
            this.f.setFrom("index");
            this.f.setStageType("2001");
            bVar.n(this.f);
            ny k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<ap6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.a);
            k.q(this.g);
            k.s(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: D */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ap6 ap6Var, AutoVideoCardViewHolder<ap6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ap6Var, autoVideoCardViewHolder})) == null) {
            if (ap6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            ap6Var.A(ap6Var.position + 1);
            ap6Var.a.statFloor = ap6Var.h();
            autoVideoCardViewHolder.b().r(i);
            ap6Var.f1090T = 0;
            co6.b().a(ap6Var.r());
            autoVideoCardViewHolder.y(z(ap6Var));
            if (autoVideoCardViewHolder.b() != null) {
                autoVideoCardViewHolder.b().b(this.d);
            }
            autoVideoCardViewHolder.f(ap6Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().q(this.g);
            m68.p(ap6Var.a, this.a, ap6Var.h());
            m68.o(ap6Var.a, ap6Var.i(), ap6Var.h());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final yx9 z(ap6 ap6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, ap6Var)) == null) {
            if (ap6Var != null) {
                yx9 yx9Var = new yx9();
                yx9Var.a = "1";
                yx9Var.c = ap6Var.g;
                if (ap6Var.getThreadData() != null) {
                    yx9Var.d = String.valueOf(ap6Var.getThreadData().getFid());
                    yx9Var.v = ap6Var.getThreadData().getNid();
                    if (ap6Var.getThreadData().getThreadVideoInfo() != null) {
                        yx9Var.m = ap6Var.getThreadData().getThreadVideoInfo().video_md5;
                        yx9Var.p = String.valueOf(ap6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                yx9Var.k = ap6Var.e();
                yx9Var.f = ap6Var.i();
                yx9Var.l = ap6Var.c();
                yx9Var.h = ap6Var.u();
                yx9Var.e = TbadkCoreApplication.getCurrentAccount();
                yx9Var.q = String.valueOf(ap6Var.h());
                if (ap6Var.getThreadData() != null && ap6Var.getThreadData().getBaijiahaoData() != null) {
                    yx9Var.t = ap6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    yx9Var.u = ap6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return yx9Var;
                }
                return yx9Var;
            }
            return null;
        }
        return (yx9) invokeL.objValue;
    }
}

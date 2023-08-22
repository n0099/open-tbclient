package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ny;
import com.baidu.tieba.yy;
import com.baidu.tieba.zw;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f08 extends om<ap6, AutoVideoCardViewHolder<ap6>> implements s46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public String d;
    public hn e;
    public vy f;
    public jo6<ap6> g;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: B */
    public AutoVideoCardViewHolder<ap6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            return null;
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
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* loaded from: classes5.dex */
    public class a extends jo6<ap6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f08 b;

        public a(f08 f08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.jo6
        /* renamed from: d */
        public void a(View view2, ap6 ap6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ap6Var) == null) {
                co6.b().d(true);
                q46.c().h("page_recommend", "show_");
                if (ap6Var != null && ap6Var.getThreadData() != null && !StringUtils.isNull(ap6Var.getThreadData().getTid())) {
                    if (ap6Var.getThreadData().middle_page_num <= 0) {
                        this.b.z(view2, ap6Var);
                        return;
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(ap6Var.G(ap6Var.getThreadData())));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements zw.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vy a;
        public final /* synthetic */ f08 b;

        public b(f08 f08Var, vy vyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var, vyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f08Var;
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
                ThreadCardUtils.jumpToPB(w05Var, this.b.mContext, 1, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(w05Var, this.b.mContext, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f08 a;

        public c(f08 f08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f08Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof um) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                um umVar = (um) bnVar;
                if (!(umVar.c() instanceof ap6)) {
                    return;
                }
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ap6 ap6Var = (ap6) umVar.c();
                ap6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), ap6Var);
                }
                ThreadCardUtils.jumpToPB((w05) ap6Var, view2.getContext(), 1, false, dx.a((hn) viewGroup, view2, i));
                threadCardViewHolder.b().p(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f08(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
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
        this.c = tbPageContext;
        this.b = bdUniqueId2;
    }

    public void E(hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hnVar) == null) {
            this.e = hnVar;
        }
    }

    @Override // com.baidu.tieba.s46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: A */
    public AutoVideoCardViewHolder<ap6> onCreateContentViewHolder(ViewGroup viewGroup, ap6 ap6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, viewGroup, ap6Var)) == null) {
            ny.b bVar = new ny.b(this.c.getPageActivity(), false);
            t68 t68Var = new t68(this.c.getPageActivity());
            t68Var.q(this.a);
            t68Var.setFrom("concern_tab");
            t68Var.B(new b(this, t68Var));
            this.f = t68Var;
            bVar.n(t68Var);
            vy vyVar = this.f;
            if (vyVar != null) {
                vyVar.setStageType("2001");
            }
            ny k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<ap6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.a);
            k.q(this.g);
            k.s(1);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: C */
    public View onFillContentViewHolder(int i, View view2, ViewGroup viewGroup, ap6 ap6Var, AutoVideoCardViewHolder<ap6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ap6Var, autoVideoCardViewHolder})) == null) {
            if (ap6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            ap6Var.A(ap6Var.position + 1);
            co6.b().a(ap6Var.d("c12351"));
            autoVideoCardViewHolder.b().r(i);
            ap6Var.f1090T = 0;
            autoVideoCardViewHolder.y(y(ap6Var));
            if (autoVideoCardViewHolder.b() instanceof r46) {
                autoVideoCardViewHolder.b().b(this.d);
            }
            autoVideoCardViewHolder.f(ap6Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().q(this.g);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.om
    public BdUniqueId getBottomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return ro6.M;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.om
    public BdUniqueId getContentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return ro6.J;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.om
    public BdUniqueId getExtendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return ro6.L;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.om
    public BdUniqueId getHeaderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BdUniqueId bdUniqueId = this.b;
            if (bdUniqueId != null) {
                return bdUniqueId;
            }
            return ro6.D;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final yx9 y(ap6 ap6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, ap6Var)) == null) {
            if (ap6Var != null) {
                yx9 yx9Var = new yx9();
                yx9Var.a = "7";
                yx9Var.c = ap6Var.g;
                if (ap6Var.getThreadData() != null) {
                    yx9Var.d = String.valueOf(ap6Var.getThreadData().getFid());
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
                return yx9Var;
            }
            return null;
        }
        return (yx9) invokeL.objValue;
    }

    public final void z(View view2, ap6 ap6Var) {
        vy vyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, view2, ap6Var) == null) && (vyVar = this.f) != null && vyVar.u() != null && this.f.u().getMainView() != null) {
            if (view2.getId() == this.f.u().getMainView().getId()) {
                gz7.b(view2, ap6Var, 4);
            } else if (view2.getId() == R.id.thread_card_root) {
                gz7.b(view2, ap6Var, 2);
            }
        }
    }
}

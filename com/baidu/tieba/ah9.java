package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tieba.mz;
import com.baidu.tieba.xx;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ah9 extends ln<lq6, AutoVideoCardViewHolder<lq6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public eo c;
    public uz d;
    public up6<lq6> e;

    /* loaded from: classes5.dex */
    public class a extends up6<lq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah9 b;

        public a(ah9 ah9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ah9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, lq6 lq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, lq6Var) == null) {
                np6.b().d(true);
                if (lq6Var != null && lq6Var.getThreadData() != null && !StringUtils.isNull(lq6Var.getThreadData().getTid())) {
                    if (lq6Var.getThreadData().middle_page_num <= 0) {
                        this.b.z(view2, lq6Var);
                        return;
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(lq6Var.J(lq6Var.getThreadData())));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements xx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz a;
        public final /* synthetic */ ah9 b;

        public b(ah9 ah9Var, uz uzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah9Var, uzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ah9Var;
            this.a = uzVar;
        }

        @Override // com.baidu.tieba.xx.a
        public void a(t15 t15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, t15Var) != null) || t15Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (t15Var instanceof lq6) {
                t15Var.objType = 5;
                ThreadCardUtils.jumpToPB(t15Var, this.b.mContext, 0, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(t15Var, this.b.mContext, 0, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah9 a;

        public c(ah9 ah9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ah9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ah9Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof lq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                lq6 lq6Var = (lq6) ynVar;
                lq6Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), lq6Var);
                }
                ThreadCardUtils.jumpToPB((t15) lq6Var, view2.getContext(), lq6Var.C, false, by.a((eo) viewGroup, view2, i));
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah9(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = new a(this);
        this.b = tbPageContext;
    }

    public final void z(View view2, lq6 lq6Var) {
        uz uzVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, lq6Var) == null) && (uzVar = this.d) != null && uzVar.x() != null && this.d.x().getMainView() != null) {
            if (view2.getId() == this.d.x().getMainView().getId()) {
                xm9.m(lq6Var, 4, this.b);
            } else if (view2.getId() == R.id.thread_card_root) {
                xm9.m(lq6Var, 1, this.b);
            }
        }
    }

    public void C(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eoVar) == null) {
            this.c = eoVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: A */
    public AutoVideoCardViewHolder<lq6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.b.getPageActivity(), false);
            bVar.l().k(true);
            dy dyVar = new dy(this.b.getPageActivity());
            dyVar.r(this.a);
            dyVar.setFrom("pb");
            dyVar.C(new b(this, dyVar));
            this.d = dyVar;
            bVar.n(dyVar);
            uz uzVar = this.d;
            if (uzVar != null) {
                uzVar.setStageType("2002");
            }
            mz k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.c);
            AutoVideoCardViewHolder<lq6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.j(this.a);
            k.q(this.e);
            k.s(0);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    public final av9 y(lq6 lq6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, lq6Var)) == null) {
            if (lq6Var != null) {
                av9 av9Var = new av9();
                av9Var.a = "6";
                av9Var.c = lq6Var.g;
                if (lq6Var.getThreadData() != null) {
                    av9Var.d = String.valueOf(lq6Var.getThreadData().getFid());
                    if (lq6Var.getThreadData().getThreadVideoInfo() != null) {
                        av9Var.m = lq6Var.getThreadData().getThreadVideoInfo().video_md5;
                        av9Var.p = String.valueOf(lq6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                av9Var.k = lq6Var.e();
                av9Var.f = lq6Var.i();
                av9Var.l = lq6Var.c();
                av9Var.h = lq6Var.v();
                av9Var.e = TbadkCoreApplication.getCurrentAccount();
                av9Var.q = String.valueOf(lq6Var.h());
                return av9Var;
            }
            return null;
        }
        return (av9) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, lq6 lq6Var, AutoVideoCardViewHolder<lq6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, lq6Var, autoVideoCardViewHolder})) == null) {
            if (lq6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lq6Var.B(lq6Var.position + 1);
            autoVideoCardViewHolder.b().r(i);
            lq6Var.f1139T = 0;
            autoVideoCardViewHolder.y(y(lq6Var));
            autoVideoCardViewHolder.f(lq6Var);
            autoVideoCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.b().q(this.e);
            xm9.o(lq6Var, this.b);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}

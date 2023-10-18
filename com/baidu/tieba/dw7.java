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
import com.baidu.tieba.kt;
import com.baidu.tieba.vt;
import com.baidu.tieba.wr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dw7 extends lh<sk6, AutoVideoCardViewHolder<sk6>> implements yz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public ei d;
    public st e;
    public bk6<sk6> f;

    /* loaded from: classes5.dex */
    public class a extends bk6<sk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dw7 b;

        public a(dw7 dw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dw7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bk6
        /* renamed from: d */
        public void a(View view2, sk6 sk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, sk6Var) == null) {
                tj6.b().d(true);
                wz5.c().h("page_recommend", "show_");
                if (sk6Var != null && sk6Var.getThreadData() != null && !StringUtils.isNull(sk6Var.getThreadData().getTid())) {
                    if (sk6Var.getThreadData().middle_page_num <= 0) {
                        this.b.z(view2, sk6Var);
                        return;
                    }
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(sk6Var.G(sk6Var.getThreadData())));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements wr.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ st a;
        public final /* synthetic */ dw7 b;

        public b(dw7 dw7Var, st stVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dw7Var, stVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dw7Var;
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
                ThreadCardUtils.jumpToPB(jv4Var, this.b.mContext, 1, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(jv4Var, this.b.mContext, 1, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ii {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dw7 a;

        public c(dw7 dw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dw7Var;
        }

        @Override // com.baidu.tieba.ii
        public void b(View view2, yh yhVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, yhVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (yhVar instanceof sk6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                sk6 sk6Var = (sk6) yhVar;
                sk6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), sk6Var);
                }
                ThreadCardUtils.jumpToPB((jv4) sk6Var, view2.getContext(), 1, false, as.a((ei) viewGroup, view2, i));
                threadCardViewHolder.a().q(new vt.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dw7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new a(this);
        this.b = tbPageContext;
    }

    public final void z(View view2, sk6 sk6Var) {
        st stVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, view2, sk6Var) == null) && (stVar = this.e) != null && stVar.u() != null && this.e.u().getMainView() != null) {
            if (view2.getId() == this.e.u().getMainView().getId()) {
                dv7.b(view2, sk6Var, 4);
            } else if (view2.getId() == R.id.thread_card_root) {
                dv7.b(view2, sk6Var, 2);
            }
        }
    }

    public void C(ei eiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eiVar) == null) {
            this.d = eiVar;
        }
    }

    @Override // com.baidu.tieba.yz5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.c = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: A */
    public AutoVideoCardViewHolder<sk6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            kt.b bVar = new kt.b(this.b.getPageActivity(), false);
            s28 s28Var = new s28(this.b.getPageActivity());
            s28Var.q(this.a);
            s28Var.setFrom("concern_tab");
            s28Var.B(new b(this, s28Var));
            this.e = s28Var;
            bVar.n(s28Var);
            st stVar = this.e;
            if (stVar != null) {
                stVar.setStageType("2001");
            }
            kt k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.d);
            AutoVideoCardViewHolder<sk6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.r(this.f);
            k.t(1);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    public final aw9 y(sk6 sk6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, sk6Var)) == null) {
            if (sk6Var != null) {
                aw9 aw9Var = new aw9();
                aw9Var.a = "7";
                aw9Var.c = sk6Var.g;
                if (sk6Var.getThreadData() != null) {
                    aw9Var.d = String.valueOf(sk6Var.getThreadData().getFid());
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
                return aw9Var;
            }
            return null;
        }
        return (aw9) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, sk6 sk6Var, AutoVideoCardViewHolder<sk6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, sk6Var, autoVideoCardViewHolder})) == null) {
            if (sk6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            sk6Var.A(sk6Var.position + 1);
            tj6.b().a(sk6Var.d("c12351"));
            autoVideoCardViewHolder.a().s(i);
            sk6Var.f1160T = 0;
            autoVideoCardViewHolder.y(y(sk6Var));
            if (autoVideoCardViewHolder.a() instanceof xz5) {
                autoVideoCardViewHolder.a().b(this.c);
            }
            autoVideoCardViewHolder.e(sk6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().r(this.f);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}

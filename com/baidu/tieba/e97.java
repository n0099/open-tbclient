package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
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
import com.baidu.tieba.bz;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cx;
import com.baidu.tieba.qy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e97 extends ln<p96, AutoVideoCardViewHolder<p96>> implements bs5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public y97 c;
    public String d;
    public eo e;
    public yy f;
    public z86<p96> g;

    /* loaded from: classes4.dex */
    public class a extends z86<p96> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e97 b;

        public a(e97 e97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e97Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z86
        /* renamed from: d */
        public void a(View view2, p96 p96Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, p96Var) == null) {
                s86.b().d(true);
                zr5.c().h("page_recommend", "show_");
                if (this.b.c != null && p96Var != null && p96Var.getThreadData() != null && !StringUtils.isNull(p96Var.getThreadData().getTid())) {
                    if (p96Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(p96Var.N(p96Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !c87.b(yg.g(p96Var.getThreadData().getTid(), 0L))) {
                        c87.a(yg.g(p96Var.getThreadData().getTid(), 0L));
                        this.b.c.e(yg.g(p96Var.getThreadData().getTid(), 0L), p96Var.z(), p96Var.o(), p96Var.m(), p96Var.c(), yg.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, p96Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.y(view2, p96Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements cx.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yy a;
        public final /* synthetic */ e97 b;

        public b(e97 e97Var, yy yyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e97Var, yyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e97Var;
            this.a = yyVar;
        }

        @Override // com.baidu.tieba.cx.a
        public void a(fs4 fs4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, fs4Var) != null) || fs4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (fs4Var instanceof p96) {
                fs4Var.objType = 5;
                ThreadCardUtils.jumpToPB(fs4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(fs4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e97 a;

        public c(e97 e97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e97Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof p96) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                p96 p96Var = (p96) ynVar;
                p96Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), p96Var);
                }
                ThreadCardUtils.jumpToPB((fs4) p96Var, view2.getContext(), 2, false, gx.a((eo) viewGroup, view2, i));
                autoVideoCardViewHolder.a().p(new bz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e97(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        z();
    }

    public void C(y97 y97Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y97Var) == null) {
            this.c = y97Var;
        }
    }

    public void D(eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eoVar) == null) {
            this.e = eoVar;
        }
    }

    @Override // com.baidu.tieba.bs5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: A */
    public AutoVideoCardViewHolder<p96> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            qy.b bVar = new qy.b(this.b.getPageActivity(), false);
            ia7 ia7Var = new ia7(this.b.getPageActivity());
            ia7Var.y(new b(this, ia7Var));
            this.f = ia7Var;
            ia7Var.A(this.a);
            this.f.x("index");
            this.f.B("2001");
            bVar.n(this.f);
            qy k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<p96> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.q(this.g);
            k.s(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, p96 p96Var, AutoVideoCardViewHolder<p96> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, p96Var, autoVideoCardViewHolder})) == null) {
            if (p96Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            p96Var.I(p96Var.position + 1);
            p96Var.a.statFloor = p96Var.m();
            autoVideoCardViewHolder.a().r(i);
            p96Var.T = 0;
            s86.b().a(p96Var.x());
            autoVideoCardViewHolder.u(x(p96Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(p96Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().q(this.g);
            da7.k(p96Var.a, this.a, p96Var.m());
            da7.j(p96Var.a, p96Var.o(), p96Var.m());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void onPause() {
        yy yyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (yyVar = this.f) != null) {
            yyVar.v();
        }
    }

    public void onResume() {
        yy yyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (yyVar = this.f) != null) {
            yyVar.w();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            p96.V = "c10708";
            p96.W = "c10735";
            p96.X = "c10709";
            p96.Y = "c10734";
            p96.Z = "c11929";
            p96.a0 = "c11928";
            p96.b0 = "c10756";
        }
    }

    public final qk8 x(p96 p96Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, p96Var)) == null) {
            if (p96Var != null) {
                qk8 qk8Var = new qk8();
                qk8Var.a = "1";
                qk8Var.c = p96Var.g;
                if (p96Var.getThreadData() != null) {
                    qk8Var.d = String.valueOf(p96Var.getThreadData().getFid());
                    qk8Var.v = p96Var.getThreadData().getNid();
                    if (p96Var.getThreadData().getThreadVideoInfo() != null) {
                        qk8Var.m = p96Var.getThreadData().getThreadVideoInfo().video_md5;
                        qk8Var.p = String.valueOf(p96Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                qk8Var.k = p96Var.g();
                qk8Var.f = p96Var.o();
                qk8Var.l = p96Var.c();
                qk8Var.h = p96Var.z();
                qk8Var.e = TbadkCoreApplication.getCurrentAccount();
                qk8Var.q = String.valueOf(p96Var.m());
                if (p96Var.getThreadData() != null && p96Var.getThreadData().getBaijiahaoData() != null) {
                    qk8Var.t = p96Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    qk8Var.u = p96Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return qk8Var;
                }
                return qk8Var;
            }
            return null;
        }
        return (qk8) invokeL.objValue;
    }

    public final void y(View view2, p96 p96Var) {
        yy yyVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048586, this, view2, p96Var) == null) && (yyVar = this.f) != null && yyVar.s() != null && this.f.s().getMainView() != null) {
            if (view2.getId() == this.f.s().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, p96Var);
                da7.d(p96Var.a, this.a, p96Var.m(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(p96Var.P()));
                da7.c(p96Var.a, p96Var.o(), p96Var.m(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(p96Var.N(p96Var.a)));
                da7.c(p96Var.a, p96Var.o(), p96Var.m(), 1);
            }
        }
    }
}

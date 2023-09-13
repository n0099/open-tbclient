package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.dx;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f68 extends i08<cq6, ThreadCardViewHolder<cq6>> implements o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId b;
    public TbPageContext<?> c;
    public NEGFeedBackView.NEGFeedbackEventCallback d;
    public s78 e;
    public String f;
    public boolean g;
    public bg<ConstrainImageLayout> h;
    public bg<TbImageView> i;
    public mp6<cq6> j;

    /* loaded from: classes5.dex */
    public class a implements cg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f68 a;

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        public a(f68 f68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f68Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new ConstrainImageLayout(this.a.c.getPageActivity());
            }
            return (ConstrainImageLayout) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements cg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f68 a;

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        public b(f68 f68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f68Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.baidu.tieba.cg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cg
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.c.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends mp6<cq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f68 b;

        public c(f68 f68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f68Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, cq6 cq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, cq6Var) == null) {
                ep6.b().d(true);
                m56.c().h("page_recommend", "show_");
                if (view2 != null && this.b.e != null && cq6Var != null && cq6Var.getThreadData() != null && !StringUtils.isNull(cq6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !o58.b(JavaTypesHelper.toLong(cq6Var.getThreadData().getTid(), 0L))) {
                        o58.a(JavaTypesHelper.toLong(cq6Var.getThreadData().getTid(), 0L));
                        this.b.e.e(JavaTypesHelper.toLong(cq6Var.getThreadData().getTid(), 0L), cq6Var.u(), cq6Var.i(), cq6Var.h(), cq6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, cq6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.C(view2, cq6Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements dx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(f68 f68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.dx.b
        public void a(b15 b15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, b15Var, view2) == null) && b15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    b15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    b15Var.objType = 4;
                } else {
                    b15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements mm {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ by a;
        public final /* synthetic */ f68 b;

        public e(f68 f68Var, by byVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f68Var, byVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = f68Var;
            this.a = byVar;
        }

        @Override // com.baidu.tieba.mm
        public void a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                this.b.setPreloadSize(i, i2, i3);
                if (this.b.isPreloadSizeReady(1) && this.b.isPreloadSizeReady(2)) {
                    this.a.B(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f68 a;

        public f(f68 f68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f68Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f68Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof cq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                cq6 cq6Var = (cq6) cnVar;
                cq6Var.f = 1;
                if (this.a.j != null) {
                    this.a.j.a(threadCardViewHolder.getView(), cq6Var);
                }
                ThreadCardUtils.jumpToPB((b15) cq6Var, view2.getContext(), 2, false);
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f68(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.d = null;
        this.g = true;
        this.h = new bg<>(new a(this), 6, 0);
        this.i = new bg<>(new b(this), 12, 0);
        this.j = new c(this);
        this.c = tbPageContext;
        z();
    }

    public void D(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nEGFeedbackEventCallback) == null) {
            this.d = nEGFeedbackEventCallback;
        }
    }

    public void E(s78 s78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, s78Var) == null) {
            this.e = s78Var;
        }
    }

    @Override // com.baidu.tieba.o56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.g = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: A */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.c.getPageActivity());
            dx dxVar = new dx(this.c.getPageActivity());
            dxVar.p(this.b);
            dxVar.f(1024);
            dxVar.y(new d(this));
            bVar.o(dxVar);
            by byVar = new by(this.c.getPageActivity());
            byVar.setFrom("index");
            byVar.y(this.h);
            byVar.x(this.i);
            byVar.z(this.g);
            bVar.n(byVar);
            xx xxVar = new xx(this.c.getPageActivity());
            xxVar.C(true);
            bVar.h(xxVar);
            bVar.h(new ky(this.c.getPageActivity()));
            bVar.h(new ey(this.c.getPageActivity()));
            bVar.h(new lx(this.c.getPageActivity()));
            px pxVar = new px(this.c.getPageActivity());
            pxVar.D(this.g);
            pxVar.C("index");
            bVar.h(pxVar);
            if (!isPreloadSizeReady(1) || !isPreloadSizeReady(2)) {
                byVar.B(new e(this, byVar));
            }
            qy qyVar = new qy(this.c.getPageActivity());
            h15 h15Var = new h15();
            h15Var.b = 1;
            h15Var.h = 1;
            qyVar.D(h15Var);
            qyVar.F(1);
            qyVar.K(3);
            qyVar.G(2);
            qyVar.E(false);
            bVar.m(qyVar);
            oy i = bVar.i();
            i.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(i);
            threadCardViewHolder.i(this.b);
            setOnAdapterItemClickListener(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: B */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, cq6 cq6Var, ThreadCardViewHolder<cq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, cq6Var, threadCardViewHolder})) == null) {
            if (cq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && cq6Var.a != null) {
                cq6Var.B(cq6Var.position + 1);
                cq6Var.a.statFloor = cq6Var.h();
                threadCardViewHolder.a().b(this.f);
                threadCardViewHolder.p(true).setNegEventCallback(this.d);
                threadCardViewHolder.l(cq6Var.showFollowBtn(), this.a);
                threadCardViewHolder.e(cq6Var);
                threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.j);
                ep6.b().a(cq6Var.s());
                m56.c().i("page_recommend", "show_", cq6Var.s());
                x78.p(cq6Var.a, this.b, cq6Var.h());
                x78.o(cq6Var.a, cq6Var.i(), cq6Var.h());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void C(View view2, cq6 cq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, cq6Var) == null) {
            int id = view2.getId();
            int i = 3;
            if (view2.getId() == R.id.thread_card_root) {
                TiebaStatic.log(cq6Var.q());
                m56.c().i("page_recommend", "clk_", cq6Var.q());
                x78.c(cq6Var.a, cq6Var.i(), cq6Var.h(), 1);
                i = 1;
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(cq6Var.q());
                m56.c().i("page_recommend", "clk_", cq6Var.q());
                i = 5;
                x78.c(cq6Var.a, cq6Var.i(), cq6Var.h(), 1);
            } else {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(cq6Var.O());
                    m56.c().i("page_recommend", "clk_", cq6Var.O());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(cq6Var.N());
                        m56.c().i("page_recommend", "clk_", cq6Var.N());
                        x78.c(cq6Var.a, cq6Var.i(), cq6Var.h(), 4);
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(cq6Var.N());
                        m56.c().i("page_recommend", "clk_", cq6Var.N());
                        x78.c(cq6Var.a, cq6Var.i(), cq6Var.h(), 4);
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(cq6Var.f());
                        m56.c().i("page_recommend", "clk_", cq6Var.f());
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 4);
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c10760");
                        statisticItem2.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem2);
                        x78.c(cq6Var.a, cq6Var.i(), cq6Var.h(), 1);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view2 instanceof TbImageView) {
                            if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem3 = new StatisticItem("c10760");
                                statisticItem3.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem3);
                            }
                            TiebaStatic.log(cq6Var.K());
                            m56.c().i("page_recommend", "clk_", cq6Var.K());
                            x78.c(cq6Var.a, cq6Var.i(), cq6Var.h(), 2);
                        }
                    } else {
                        StatisticItem statisticItem4 = new StatisticItem("c10760");
                        statisticItem4.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem4);
                    }
                    i = 2;
                }
                i = 0;
            }
            if (i != 0) {
                x78.d(cq6Var.a, this.b, cq6Var.h(), i);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            cq6.f1090T = "c10705";
            cq6.U = "c10730";
            cq6.V = "c10731";
            cq6.W = "c10704";
            cq6.X = "c10755";
            cq6.Y = "c10710";
            cq6.Z = "c10736";
            cq6.a0 = "c10737";
            cq6.b0 = "c10711";
            cq6.c0 = "c10758";
            cq6.d0 = "c10757";
        }
    }
}

package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.gz;
import com.baidu.tieba.vy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class id7 extends qn<ae6, ThreadCardViewHolder<ae6>> implements mw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public je7 c;
    public String d;
    public jo e;
    public NEGFeedBackView.b f;
    public ld6<ae6> g;

    /* loaded from: classes4.dex */
    public class a extends ld6<ae6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id7 b;

        public a(id7 id7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = id7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ld6
        /* renamed from: d */
        public void a(View view2, ae6 ae6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ae6Var) == null) {
                ed6.b().d(true);
                kw5.c().h("page_recommend", "show_");
                if (view2 != null && this.b.c != null && ae6Var != null && ae6Var.getThreadData() != null && !StringUtils.isNull(ae6Var.getThreadData().getTid())) {
                    if ((view2.getTag() instanceof String) && !nc7.b(dh.g(ae6Var.getThreadData().getTid(), 0L))) {
                        nc7.a(dh.g(ae6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(dh.g(ae6Var.getThreadData().getTid(), 0L), ae6Var.z(), ae6Var.o(), ae6Var.m(), ae6Var.c(), dh.e((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, ae6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.z(view2, ae6Var);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id7 a;

        public b(id7 id7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id7Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof ae6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ae6 ae6Var = (ae6) cdo;
                ae6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(threadCardViewHolder.getView(), ae6Var);
                }
                ThreadCardUtils.jumpToPB((sw4) ae6Var, view2.getContext(), 2, false, lx.a((jo) viewGroup, view2, i));
                threadCardViewHolder.a().p(new gz.a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ View b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ae6 d;
        public final /* synthetic */ id7 e;

        public c(id7 id7Var, ViewGroup viewGroup, View view2, int i, ae6 ae6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id7Var, viewGroup, view2, Integer.valueOf(i), ae6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = id7Var;
            this.a = viewGroup;
            this.b = view2;
            this.c = i;
            this.d = ae6Var;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.k
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) {
                if (intentConfig instanceof PbActivityConfig) {
                    ((PbActivityConfig) intentConfig).setVideoOriginArea(lx.a((jo) this.a, this.b, this.c));
                    if (this.d.getThreadData() != null && this.d.getThreadData().getSmartApp() != null) {
                        StatisticItem p = this.d.p(ae6.d0);
                        p.param("obj_type", this.d.getThreadData().getSmartApp().id);
                        p.param("obj_name", this.d.getThreadData().getSmartApp().name);
                        TiebaStatic.log(p);
                    }
                }
                CardLinkageManager.INSTANCE.cancelHighLight(this.e.e, this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public id7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        w();
    }

    public void A(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f = bVar;
        }
    }

    public void B(je7 je7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, je7Var) == null) {
            this.c = je7Var;
        }
    }

    public void C(jo joVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, joVar) == null) {
            this.e = joVar;
        }
    }

    @Override // com.baidu.tieba.mw5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.d = str;
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ae6.S = "c10730";
            ae6.T = "c10731";
            ae6.U = "c10704";
            ae6.V = "c10755";
            ae6.W = "c10710";
            ae6.X = "c10736";
            ae6.Y = "c10737";
            ae6.Z = "c10711";
            ae6.a0 = "c10758";
            ae6.b0 = "c10757";
            ae6.e0 = "c10734";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: x */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            vy.b bVar = new vy.b(this.b.getPageActivity(), false);
            xy xyVar = new xy(this.b.getPageActivity());
            yw4 yw4Var = new yw4();
            yw4Var.b = 1;
            yw4Var.h = 1;
            xyVar.z(yw4Var);
            xyVar.B(1);
            xyVar.H("personalize_page");
            xyVar.G(3);
            xyVar.C(2);
            xyVar.f(32);
            xyVar.A(false);
            bVar.m(xyVar);
            vy k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.e);
            k.s(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ae6 ae6Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ae6Var, threadCardViewHolder})) == null) {
            if (ae6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && ae6Var.a != null) {
                ae6Var.I(ae6Var.position + 1);
                ae6Var.a.statFloor = ae6Var.m();
                threadCardViewHolder.a().r(i);
                threadCardViewHolder.a().b(this.d);
                if (threadCardViewHolder.a().f() instanceof xy) {
                    ((xy) threadCardViewHolder.a().f()).F(new c(this, viewGroup, view2, i, ae6Var));
                }
                threadCardViewHolder.p(false, Align.ALIGN_RIGHT_BOTTOM, this.f);
                threadCardViewHolder.e(ae6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.g);
                ed6.b().a(ae6Var.x());
                kw5.c().a(ae6Var.x());
                oe7.k(ae6Var.a, this.a, ae6Var.m());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void z(View view2, ae6 ae6Var) {
        StatisticItem u;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view2, ae6Var) == null) {
            int id = view2.getId();
            int i = 5;
            int i2 = 2;
            if (view2.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(ae6Var.T());
                    kw5.c().i("page_recommend", "clk_", ae6Var.T());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(ae6Var.S());
                        kw5.c().i("page_recommend", "clk_", ae6Var.S());
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(ae6Var.S());
                        kw5.c().i("page_recommend", "clk_", ae6Var.S());
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(ae6Var.i());
                        kw5.c().i("page_recommend", "clk_", ae6Var.i());
                        i2 = 9;
                    } else {
                        if (id == R.id.god_reply_voice_btn) {
                            StatisticItem statisticItem = new StatisticItem("c10760");
                            statisticItem.param("obj_locate", 4);
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.god_reply_content) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 2);
                            TiebaStatic.log(statisticItem2);
                            oe7.c(ae6Var.a, ae6Var.o(), ae6Var.m(), 1);
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            i2 = 0;
                        } else {
                            StatisticItem statisticItem3 = new StatisticItem("c10760");
                            statisticItem3.param("obj_locate", 1);
                            TiebaStatic.log(statisticItem3);
                        }
                        i2 = 5;
                    }
                    if (id == R.id.thread_info_commont_container || ae6Var == null || ae6Var.getThreadData() == null || ae6Var.getThreadData().getForumData() == null || StringUtils.isNull(ae6Var.getThreadData().getForumData().f())) {
                        i = i2;
                    }
                    if (i == 0) {
                        oe7.d(ae6Var.a, this.a, ae6Var.m(), i);
                        return;
                    }
                    return;
                }
            } else {
                if (be6.R(ae6Var.a)) {
                    u = ae6Var.y();
                    TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(u));
                } else {
                    u = ae6Var.u();
                    TiebaStatic.log(u);
                }
                kw5.c().i("page_recommend", "clk_", u);
                oe7.c(ae6Var.a, ae6Var.o(), ae6Var.m(), 1);
            }
            i2 = 1;
            if (id == R.id.thread_info_commont_container) {
            }
            i = i2;
            if (i == 0) {
            }
        }
    }
}

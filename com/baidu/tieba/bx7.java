package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.tieba.rs;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bx7 extends hs7<mz4, ThreadCardViewHolder<ThreadData>> implements km6, x38, e26, lm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String l;
    public String m;
    public int n;
    public mm6<ThreadData> o;

    @Override // com.baidu.tieba.km6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.lm6
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends mm6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx7 b;

        public a(bx7 bx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bx7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (this.b.i != null) {
                    this.b.i.b(view2, threadData, this.b.getType());
                }
                if ("c13010".equals(this.b.l)) {
                    TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2 instanceof TbImageView) {
                        if (this.b.o.a instanceof Boolean) {
                            if (((Boolean) this.b.o.a).booleanValue()) {
                                u38.e(threadData, 1, this.b.mPageId, x38.q0, this.b.u());
                            } else {
                                u38.e(threadData, 3, this.b.mPageId, x38.q0, this.b.u());
                            }
                        }
                        a78.h(threadData, this.b.b, 2);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        u38.e(threadData, 15, this.b.mPageId, x38.q0, this.b.u());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            u38.c(threadData, this.b.b.getForum().getId());
                        }
                    } else {
                        u38.e(threadData, 1, this.b.mPageId, x38.q0, this.b.u());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            u38.c(threadData, this.b.b.getForum().getId());
                        }
                    }
                } else {
                    u38.e(threadData, 2, this.b.mPageId, x38.q0, this.b.u());
                }
                if (view2.getId() == R.id.thread_card_root && threadData.isVideoThreadType()) {
                    this.b.b0(threadData);
                } else if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.card_divider_tv) {
                        a78.a(x38.q0, threadData.getRecomReason());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.o.a instanceof Boolean) {
                            if (((Boolean) this.b.o.a).booleanValue()) {
                                w38.k().h(x38.q0, threadData, 1);
                            } else {
                                w38.k().h(x38.q0, threadData, 3);
                            }
                        }
                    } else if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                    } else if (view2.getId() == R.id.thread_card_voice) {
                        w38.k().h(x38.q0, threadData, 5);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        int i = 6;
                        if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().f0() != null && threadData.getTopAgreePost().f0().Q() != null && threadData.getTopAgreePost().f0().Q().size() > 0) {
                            i = threadData.getTopAgreePost().N ? 9 : 8;
                        }
                        w38.k().h(x38.q0, threadData, i);
                    } else {
                        w38.k().h(x38.q0, threadData, 1);
                    }
                } else {
                    w38.k().h(x38.q0, threadData, 2);
                }
                nua.t(CommonStatisticKey.KEY_LIVE_MERGE_CARD_CLICK, threadData.getThreadData(), 4);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements rs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(bx7 bx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.rs.b
        public void a(fw4 fw4Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, fw4Var, view2) == null) && fw4Var != null) {
                if (view2.getId() == R.id.user_name) {
                    fw4Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    fw4Var.objType = 4;
                } else {
                    fw4Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bx7 a;

        public c(bx7 bx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bx7Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof mz4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((mz4) piVar).t;
                threadData.objType = 1;
                if (this.a.o != null) {
                    this.a.o.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((fw4) threadData, view2.getContext(), this.a.n, false, ss.a((vi) viewGroup, view2, i));
                threadCardViewHolder.a().q(new nu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 3;
        this.o = new a(this);
        this.c = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    @Override // com.baidu.tieba.e26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.km6
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.n = i;
        }
    }

    @Override // com.baidu.tieba.hs7
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.l = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: Z */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.c.getPageActivity(), true);
            rs rsVar = new rs(this.c.getPageActivity());
            rsVar.b(4280);
            rsVar.o(this.mPageId);
            rsVar.y(2);
            rsVar.x(new b(this));
            if (this.k) {
                bVar.l().d(0);
                bVar.l().i(0);
            }
            bVar.o(rsVar);
            cu k = bVar.k(BaseCardInfo.SupportType.TOP, viewGroup, this.e);
            k.t(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.mPageId);
            threadCardViewHolder.q(false);
            setOnAdapterItemClickListener(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hs7, com.baidu.tieba.ci
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mz4 mz4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mz4Var, threadCardViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) mz4Var, (mz4) threadCardViewHolder);
            if (mz4Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && (((i2 = frsViewData.frsCurrentTabId) == 503 || i2 == 1) && i == 0)) {
                xoa.a("frs", true);
            }
            c68.a(this.c);
            threadCardViewHolder.a().b(this.m);
            threadCardViewHolder.a().s(i);
            gs7.j(threadCardViewHolder.a().f(), this.b);
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                mz4Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.n(mz4Var.t.showFollowBtn(), null);
            threadCardViewHolder.s(true, Align.ALIGN_RIGHT_TOP, null);
            if (!mz4Var.t.isBjh() && !mz4Var.t.isWorksInfo() && !CommonStatisticKey.KEY_FRS_ITEM_TAB_COMMENT_CLICK.equals(this.l)) {
                threadCardViewHolder.u();
            } else {
                threadCardViewHolder.f();
            }
            threadCardViewHolder.e(mz4Var.t);
            threadCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.a().r(this.o);
            mz4Var.t.updateShowStatus();
            if (x38.q0 != null) {
                int i3 = 0;
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null) {
                    i3 = frsViewData3.getTopThreadSize();
                }
                mz4Var.t.statFloor = (mz4Var.position + 1) - i3;
            }
            w38.k().c(x38.q0, mz4Var.t);
            mz4Var.t.updateShowStatus();
            u38.p(mz4Var.t, this.mPageId, x38.q0, u());
            FrsViewData frsViewData4 = this.b;
            if (frsViewData4 != null && frsViewData4.getForum() != null) {
                u38.n(mz4Var.t, u());
                u38.o(mz4Var.t, this.b.getForum().getId());
            }
            if (mz4Var != null) {
                mz4Var.t.updateShowStatus();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void b0(ThreadData threadData) {
        int i;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            StatisticItem param = new StatisticItem("c12126").param("tid", threadData.getId());
            if (x()) {
                i = 2;
            } else {
                i = 1;
            }
            StatisticItem param2 = param.param("obj_locate", i);
            if (threadData.getThreadAlaInfo() == null) {
                j = -1;
            } else {
                j = threadData.getThreadAlaInfo().live_id;
            }
            TiebaStatic.log(param2.param("obj_id", j).param("obj_type", 1));
        }
    }

    @Override // com.baidu.tieba.x38
    public v38 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return x38.q0;
        }
        return (v38) invokeV.objValue;
    }
}

package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.switchs.HeadlinesPreRenderSwitch;
import com.baidu.tbadk.switchs.HeadlinesPrefetchSwitch;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.oy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.CustomFitFrameCard;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class an7 extends fi7<h45, AutoVideoCardViewHolder<ThreadData>> implements kp6, xt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> l;
    public int m;
    public vt7 n;
    public boolean o;
    public mp6<ThreadData> p;

    @Override // com.baidu.tieba.kp6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends mp6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ an7 b;

        public a(an7 an7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {an7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = an7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        ut7.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.img_interview_live) {
                        ut7.e(threadData, 3, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().z1()) {
                            ut7.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.TOP_AGREE_POST_LOCATE);
                        } else {
                            ut7.e(threadData, 15, this.b.mPageId, this.b.n, this.b.t());
                        }
                    } else if ((view2 instanceof CustomFitFrameCard) && ThreadCardUtils.isHeadlinesCard(threadData.getTaskInfoData())) {
                        ThreadCardUtils.jumpToPB((b15) threadData, view2.getContext(), this.b.m, false);
                        ut7.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.ACTIVITY_LOCATE);
                    } else if (view2.getId() != R.id.video_seg_title && view2.getId() != R.id.video_seg_abstract) {
                        if (view2.getId() == R.id.share_num_container) {
                            ut7.e(threadData, 14, this.b.mPageId, this.b.n, this.b.t());
                        } else if (view2.getId() == R.id.img_agree) {
                            ut7.e(threadData, 12, this.b.mPageId, this.b.n, this.b.t());
                        } else if (view2.getId() == R.id.img_disagree) {
                            ut7.e(threadData, 13, this.b.mPageId, this.b.n, this.b.t());
                        } else {
                            ut7.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                        }
                    } else {
                        ThreadCardUtils.jumpToPB((b15) threadData, view2.getContext(), this.b.m, false);
                        if (ThreadCardUtils.isHeadlinesCard(threadData.getTaskInfoData())) {
                            ut7.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.TITLE_LOCATE);
                        }
                    }
                } else {
                    ut7.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_card_root) {
                        if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                            String e = threadData.getTaskInfoData().e();
                            if (StringUtils.isNull(e)) {
                                e = threadData.getTaskInfoData().h();
                            }
                            String str = e;
                            String valueOf = String.valueOf(threadData.getFid());
                            String forum_name = threadData.getForum_name();
                            String k = threadData.getTaskInfoData().k();
                            zha.c("frs", "CLICK", valueOf, forum_name, k, "tieba.baidu.com/p/" + threadData.getTaskInfoData().k(), str);
                            String h = threadData.getTaskInfoData().h();
                            StatisticItem statisticItem = new StatisticItem("c13329");
                            statisticItem.param("fid", threadData.getFid());
                            statisticItem.param("obj_id", h);
                            TiebaStatic.log(statisticItem);
                        }
                        wt7.k().h(this.b.n, threadData, 1);
                        return;
                    }
                    return;
                }
                wt7.k().h(this.b.n, threadData, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ an7 a;

        public b(an7 an7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {an7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = an7Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof h45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((h45) cnVar).t;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((b15) threadData, view2.getContext(), this.a.m, false);
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 3;
        this.n = new vt7();
        this.o = false;
        this.p = new a(this);
        this.l = new HashSet();
    }

    @Override // com.baidu.tieba.kp6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.fi7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.o = z;
        }
    }

    public final pz9 R(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            pz9 pz9Var = new pz9();
            String str = "3";
            if (100 == t().tabType) {
                if (!threadData.isFloor5Video()) {
                    str = "25";
                }
                pz9Var.a = str;
            } else {
                if (!threadData.isFloor5Video()) {
                    str = "2";
                }
                pz9Var.a = str;
            }
            pz9Var.d = this.n.c;
            pz9Var.c = threadData.getTid();
            pz9Var.f = threadData.mRecomSource;
            pz9Var.g = threadData.mRecomReason;
            pz9Var.h = threadData.mRecomWeight;
            pz9Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                pz9Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return pz9Var;
        }
        return (pz9) invokeL.objValue;
    }

    public final void S(f45 f45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f45Var) == null) && f45Var != null && StringUtils.isNotNull(f45Var.r())) {
            if (HeadlinesPreRenderSwitch.isOn() && !UbsABTestHelper.isExistSid(ThreadCardUtils.KEY_TOUTIAO_PRE_RENDER_A)) {
                Activity a2 = im6.a(this.mContext);
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("FrsSpliteStarInterviewItemAdapter", "头条卡，frs的onFillViewHolder中开始预渲染, url: " + f45Var.r());
                mm6.a(a2, f45Var.r(), true, true);
            } else if (HeadlinesPrefetchSwitch.isOn() && !UbsABTestHelper.isExistSid(ThreadCardUtils.KEY_TOUTIAO_PREFETCH_A)) {
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.i("FrsSpliteStarInterviewItemAdapter", "头条卡，frs的onFillViewHolder中开始预取, url: " + f45Var.r());
                nm6.c(f45Var.r());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: T */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.c.getPageActivity());
            dx dxVar = new dx(this.c.getPageActivity());
            dxVar.e(696);
            dxVar.p(this.mPageId);
            bVar.o(dxVar);
            wx wxVar = new wx(this.c.getPageActivity());
            wxVar.F(this.o);
            bVar.n(wxVar);
            yy yyVar = new yy(this.c.getPageActivity());
            yyVar.D(this.c);
            yyVar.C(3);
            bVar.h(yyVar);
            tx txVar = new tx(this.c.getPageActivity());
            txVar.D(this.c);
            txVar.C(1);
            bVar.h(txVar);
            bVar.h(new sx(this.c.getPageActivity()));
            rx rxVar = new rx(this.c.getPageActivity());
            rxVar.E(1);
            bVar.h(rxVar);
            px pxVar = new px(this.c.getPageActivity());
            pxVar.D(this.o);
            pxVar.C("frs");
            bVar.h(pxVar);
            qy qyVar = new qy(this.c.getPageActivity(), false);
            h15 h15Var = new h15();
            if (100 == t().tabType) {
                h15Var.b = 25;
                qyVar.F(19);
                qyVar.K(14);
            } else {
                h15Var.b = 2;
                qyVar.F(2);
                qyVar.K(1);
            }
            h15Var.h = 2;
            qyVar.D(h15Var);
            qyVar.G(this.m);
            qyVar.e(16);
            qyVar.N();
            bVar.m(qyVar);
            oy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.q(this.p);
            k.s(this.m);
            setOnAdapterItemClickListener(new b(this));
            autoVideoCardViewHolder.n();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.fi7, com.baidu.tieba.pm
    /* renamed from: U */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, h45 h45Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, h45Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            char c = 1;
            if (this.n != null) {
                int i2 = 0;
                FrsViewData frsViewData = this.b;
                if (frsViewData != null) {
                    i2 = frsViewData.getTopThreadSize();
                }
                h45Var.t.statFloor = (i + 1) - i2;
            }
            wt7.k().c(this.n, h45Var.t);
            ut7.p(h45Var.t, this.mPageId, this.n, t());
            f45 taskInfoData = h45Var.t.getTaskInfoData();
            if (taskInfoData != null) {
                String h = taskInfoData.h();
                String e = taskInfoData.e();
                if (StringUtils.isNull(e)) {
                    e = taskInfoData.h();
                }
                String str = e;
                if (this.c.getOrignalPage() instanceof rj7) {
                    rj7 rj7Var = (rj7) this.c.getOrignalPage();
                    if (this.l.add(h)) {
                        String w = rj7Var.w();
                        String v = rj7Var.v();
                        String k = taskInfoData.k();
                        zha.c("frs", "VIEW_TRUE", w, v, k, "tieba.baidu.com/p/" + h45Var.t.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", h45Var.t.getFid());
                statisticItem.param("tid", h45Var.t.getTid());
                statisticItem.param("obj_id", h);
                statisticItem.param("thread_type", h45Var.t.getThreadType());
                TiebaStatic.log(statisticItem);
                if (!taskInfoData.s && ThreadCardUtils.isHeadlinesCard(taskInfoData)) {
                    ut7.m(TbadkCoreStatisticKey.HEADLINES_2_SHOW, h45Var.t, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.NO_LOCATE);
                    S(taskInfoData);
                    taskInfoData.s = true;
                }
            }
            if (h45Var != null) {
                h45Var.t.updateShowStatus();
                if (h45Var.t.getThreadVideoInfo() != null) {
                    c = 2;
                }
                if (c == 2) {
                    autoVideoCardViewHolder.x(R(h45Var.t));
                }
                ei7.i(autoVideoCardViewHolder.a().f(), this.b);
                autoVideoCardViewHolder.a().f().e(32);
                autoVideoCardViewHolder.e(h45Var.t);
                autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.a().q(this.p);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.xt7
    public vt7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (vt7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fi7
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.x();
            this.l.clear();
        }
    }
}

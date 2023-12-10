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
import com.baidu.tieba.cu;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.nu;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.CustomFitFrameCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class ex7 extends hs7<mz4, AutoVideoCardViewHolder<ThreadData>> implements km6, x38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> l;
    public int m;
    public v38 n;
    public boolean o;
    public mm6<ThreadData> p;

    @Override // com.baidu.tieba.km6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends mm6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex7 b;

        public a(ex7 ex7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ex7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        u38.e(threadData, 5, this.b.mPageId, this.b.n, this.b.u());
                    } else if (view2.getId() == R.id.img_interview_live) {
                        u38.e(threadData, 3, this.b.mPageId, this.b.n, this.b.u());
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().D1()) {
                            u38.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.TOP_AGREE_POST_LOCATE);
                        } else {
                            u38.e(threadData, 15, this.b.mPageId, this.b.n, this.b.u());
                        }
                    } else if ((view2 instanceof CustomFitFrameCard) && ThreadCardUtils.isHeadlinesCard(threadData.getTaskInfoData())) {
                        ThreadCardUtils.jumpToPB((fw4) threadData, view2.getContext(), this.b.m, false);
                        u38.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.ACTIVITY_LOCATE);
                    } else if (view2.getId() != R.id.video_seg_title && view2.getId() != R.id.video_seg_abstract) {
                        if (view2.getId() == R.id.share_num_container) {
                            u38.e(threadData, 14, this.b.mPageId, this.b.n, this.b.u());
                        } else if (view2.getId() == R.id.img_agree) {
                            u38.e(threadData, 12, this.b.mPageId, this.b.n, this.b.u());
                        } else if (view2.getId() == R.id.img_disagree) {
                            u38.e(threadData, 13, this.b.mPageId, this.b.n, this.b.u());
                        } else {
                            u38.e(threadData, 1, this.b.mPageId, this.b.n, this.b.u());
                        }
                    } else {
                        ThreadCardUtils.jumpToPB((fw4) threadData, view2.getContext(), this.b.m, false);
                        if (ThreadCardUtils.isHeadlinesCard(threadData.getTaskInfoData())) {
                            u38.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.TITLE_LOCATE);
                        }
                    }
                } else {
                    u38.e(threadData, 2, this.b.mPageId, this.b.n, this.b.u());
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
                            twa.c("frs", "CLICK", valueOf, forum_name, k, "tieba.baidu.com/p/" + threadData.getTaskInfoData().k(), str);
                            String h = threadData.getTaskInfoData().h();
                            StatisticItem statisticItem = new StatisticItem("c13329");
                            statisticItem.param("fid", threadData.getFid());
                            statisticItem.param("obj_id", h);
                            TiebaStatic.log(statisticItem);
                        }
                        w38.k().h(this.b.n, threadData, 1);
                        return;
                    }
                    return;
                }
                w38.k().h(this.b.n, threadData, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ex7 a;

        public b(ex7 ex7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ex7Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof mz4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((mz4) piVar).t;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((fw4) threadData, view2.getContext(), this.a.m, false);
                threadCardViewHolder.a().q(new nu.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ex7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.n = new v38();
        this.o = false;
        this.p = new a(this);
        this.l = new HashSet();
    }

    @Override // com.baidu.tieba.km6
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.hs7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.o = z;
        }
    }

    public final hea S(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            hea heaVar = new hea();
            String str = "3";
            if (100 == u().tabType) {
                if (!threadData.isFloor5Video()) {
                    str = "25";
                }
                heaVar.a = str;
            } else {
                if (!threadData.isFloor5Video()) {
                    str = "2";
                }
                heaVar.a = str;
            }
            heaVar.d = this.n.c;
            heaVar.c = threadData.getTid();
            heaVar.f = threadData.mRecomSource;
            heaVar.g = threadData.mRecomReason;
            heaVar.h = threadData.mRecomWeight;
            heaVar.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                heaVar.m = threadData.getThreadVideoInfo().video_md5;
            }
            return heaVar;
        }
        return (hea) invokeL.objValue;
    }

    public final void T(kz4 kz4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kz4Var) == null) && kz4Var != null && StringUtils.isNotNull(kz4Var.r())) {
            if (HeadlinesPreRenderSwitch.isOn() && !UbsABTestHelper.isExistSid(ThreadCardUtils.KEY_TOUTIAO_PRE_RENDER_A)) {
                Activity a2 = fj6.a(this.mContext);
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("FrsSpliteStarInterviewItemAdapter", "头条卡，frs的onFillViewHolder中开始预渲染, url: " + kz4Var.r());
                jj6.a(a2, kz4Var.r(), true, true);
            } else if (HeadlinesPrefetchSwitch.isOn() && !UbsABTestHelper.isExistSid(ThreadCardUtils.KEY_TOUTIAO_PREFETCH_A)) {
                TbLog defaultLog2 = DefaultLog.getInstance();
                defaultLog2.i("FrsSpliteStarInterviewItemAdapter", "头条卡，frs的onFillViewHolder中开始预取, url: " + kz4Var.r());
                kj6.c(kz4Var.r());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: U */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.c.getPageActivity());
            rs rsVar = new rs(this.c.getPageActivity());
            rsVar.b(696);
            rsVar.o(this.mPageId);
            bVar.o(rsVar);
            kt ktVar = new kt(this.c.getPageActivity());
            ktVar.E(this.o);
            bVar.n(ktVar);
            mu muVar = new mu(this.c.getPageActivity());
            muVar.C(this.c);
            muVar.B(3);
            bVar.h(muVar);
            ht htVar = new ht(this.c.getPageActivity());
            htVar.C(this.c);
            htVar.B(1);
            bVar.h(htVar);
            bVar.h(new gt(this.c.getPageActivity()));
            ft ftVar = new ft(this.c.getPageActivity());
            ftVar.D(1);
            bVar.h(ftVar);
            dt dtVar = new dt(this.c.getPageActivity());
            dtVar.C(this.o);
            dtVar.B("frs");
            bVar.h(dtVar);
            eu euVar = new eu(this.c.getPageActivity(), false);
            lw4 lw4Var = new lw4();
            if (100 == u().tabType) {
                lw4Var.b = 25;
                euVar.E(19);
                euVar.J(14);
            } else {
                lw4Var.b = 2;
                euVar.E(2);
                euVar.J(1);
            }
            lw4Var.h = 2;
            euVar.C(lw4Var);
            euVar.F(this.m);
            euVar.b(16);
            euVar.M();
            bVar.m(euVar);
            cu k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.r(this.p);
            k.t(this.m);
            setOnAdapterItemClickListener(new b(this));
            autoVideoCardViewHolder.p();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hs7, com.baidu.tieba.ci
    /* renamed from: V */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mz4 mz4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mz4Var, autoVideoCardViewHolder})) == null) {
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
                mz4Var.t.statFloor = (i + 1) - i2;
            }
            w38.k().c(this.n, mz4Var.t);
            u38.p(mz4Var.t, this.mPageId, this.n, u());
            kz4 taskInfoData = mz4Var.t.getTaskInfoData();
            if (taskInfoData != null) {
                String h = taskInfoData.h();
                String e = taskInfoData.e();
                if (StringUtils.isNull(e)) {
                    e = taskInfoData.h();
                }
                String str = e;
                if (this.c.getOrignalPage() instanceof tt7) {
                    tt7 tt7Var = (tt7) this.c.getOrignalPage();
                    if (this.l.add(h)) {
                        String w = tt7Var.w();
                        String v = tt7Var.v();
                        String k = taskInfoData.k();
                        twa.c("frs", "VIEW_TRUE", w, v, k, "tieba.baidu.com/p/" + mz4Var.t.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", mz4Var.t.getFid());
                statisticItem.param("tid", mz4Var.t.getTid());
                statisticItem.param("obj_id", h);
                statisticItem.param("thread_type", mz4Var.t.getThreadType());
                TiebaStatic.log(statisticItem);
                if (!taskInfoData.s && ThreadCardUtils.isHeadlinesCard(taskInfoData)) {
                    u38.m(TbadkCoreStatisticKey.HEADLINES_2_SHOW, mz4Var.t, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.NO_LOCATE);
                    T(taskInfoData);
                    taskInfoData.s = true;
                }
            }
            if (mz4Var != null) {
                mz4Var.t.updateShowStatus();
                if (mz4Var.t.getThreadVideoInfo() != null) {
                    c = 2;
                }
                if (c == 2) {
                    autoVideoCardViewHolder.z(S(mz4Var.t));
                }
                gs7.j(autoVideoCardViewHolder.a().f(), this.b);
                autoVideoCardViewHolder.a().f().b(32);
                autoVideoCardViewHolder.e(mz4Var.t);
                autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.a().r(this.p);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.x38
    public v38 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (v38) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hs7
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.y();
            this.l.clear();
        }
    }
}

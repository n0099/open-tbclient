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
import com.baidu.tieba.lz;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.CustomFitFrameCard;
import com.baidu.tieba.wz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class gi7 extends sd7<r45, AutoVideoCardViewHolder<ThreadData>> implements oo6, bp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> l;
    public int m;
    public zo7 n;
    public boolean o;
    public qo6<ThreadData> p;

    @Override // com.baidu.tieba.oo6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends qo6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi7 b;

        public a(gi7 gi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gi7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qo6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        yo7.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.img_interview_live) {
                        yo7.e(threadData, 3, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().v1()) {
                            yo7.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.TOP_AGREE_POST_LOCATE);
                        } else {
                            yo7.e(threadData, 15, this.b.mPageId, this.b.n, this.b.t());
                        }
                    } else if ((view2 instanceof CustomFitFrameCard) && ThreadCardUtils.isHeadlinesCard(threadData.getTaskInfoData())) {
                        ThreadCardUtils.jumpToPB((l15) threadData, view2.getContext(), this.b.m, false);
                        yo7.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.ACTIVITY_LOCATE);
                    } else if (view2.getId() != R.id.video_seg_title && view2.getId() != R.id.video_seg_abstract) {
                        if (view2.getId() == R.id.share_num_container) {
                            yo7.e(threadData, 14, this.b.mPageId, this.b.n, this.b.t());
                        } else if (view2.getId() == R.id.img_agree) {
                            yo7.e(threadData, 12, this.b.mPageId, this.b.n, this.b.t());
                        } else if (view2.getId() == R.id.img_disagree) {
                            yo7.e(threadData, 13, this.b.mPageId, this.b.n, this.b.t());
                        } else {
                            yo7.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                        }
                    } else {
                        ThreadCardUtils.jumpToPB((l15) threadData, view2.getContext(), this.b.m, false);
                        if (ThreadCardUtils.isHeadlinesCard(threadData.getTaskInfoData())) {
                            yo7.m(TbadkCoreStatisticKey.TOP_AGREE_POST_CLICK, threadData, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.TITLE_LOCATE);
                        }
                    }
                } else {
                    yo7.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
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
                            t4a.c("frs", "CLICK", valueOf, forum_name, k, "tieba.baidu.com/p/" + threadData.getTaskInfoData().k(), str);
                            String h = threadData.getTaskInfoData().h();
                            StatisticItem statisticItem = new StatisticItem("c13329");
                            statisticItem.param("fid", threadData.getFid());
                            statisticItem.param("obj_id", h);
                            TiebaStatic.log(statisticItem);
                        }
                        ap7.k().h(this.b.n, threadData, 1);
                        return;
                    }
                    return;
                }
                ap7.k().h(this.b.n, threadData, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi7 a;

        public b(gi7 gi7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gi7Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof r45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((r45) xnVar).t;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((l15) threadData, view2.getContext(), this.a.m, false);
                threadCardViewHolder.a().p(new wz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gi7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.n = new zo7();
        this.o = false;
        this.p = new a(this);
        this.l = new HashSet();
    }

    @Override // com.baidu.tieba.oo6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.sd7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.o = z;
        }
    }

    public final to9 S(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            to9 to9Var = new to9();
            String str = "3";
            if (100 == t().tabType) {
                if (!threadData.isFloor5Video()) {
                    str = "25";
                }
                to9Var.a = str;
            } else {
                if (!threadData.isFloor5Video()) {
                    str = "2";
                }
                to9Var.a = str;
            }
            to9Var.d = this.n.c;
            to9Var.c = threadData.getTid();
            to9Var.f = threadData.mRecomSource;
            to9Var.g = threadData.mRecomReason;
            to9Var.h = threadData.mRecomWeight;
            to9Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                to9Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return to9Var;
        }
        return (to9) invokeL.objValue;
    }

    public final void T(p45 p45Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p45Var) == null) && p45Var != null && StringUtils.isNotNull(p45Var.r())) {
            if (HeadlinesPreRenderSwitch.isOn() && !UbsABTestHelper.isExistSid(ThreadCardUtils.KEY_TOUTIAO_PRE_RENDER_A)) {
                Activity a2 = tl6.a(this.mContext);
                ew8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("FrsSpliteStarInterviewItemAdapter", "头条卡，frs的onFillViewHolder中开始预渲染, url: " + p45Var.r());
                xl6.a(a2, p45Var.r(), true, true);
            } else if (HeadlinesPrefetchSwitch.isOn() && !UbsABTestHelper.isExistSid(ThreadCardUtils.KEY_TOUTIAO_PREFETCH_A)) {
                ew8 defaultLog2 = DefaultLog.getInstance();
                defaultLog2.c("FrsSpliteStarInterviewItemAdapter", "头条卡，frs的onFillViewHolder中开始预取, url: " + p45Var.r());
                yl6.c(p45Var.r());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: U */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            lz.b bVar = new lz.b(this.c.getPageActivity());
            zx zxVar = new zx(this.c.getPageActivity());
            zxVar.f(696);
            zxVar.z(this.mPageId);
            bVar.o(zxVar);
            sy syVar = new sy(this.c.getPageActivity());
            syVar.G(this.o);
            bVar.n(syVar);
            vz vzVar = new vz(this.c.getPageActivity());
            vzVar.D(this.c);
            vzVar.C(3);
            bVar.h(vzVar);
            py pyVar = new py(this.c.getPageActivity());
            pyVar.D(this.c);
            pyVar.C(1);
            bVar.h(pyVar);
            bVar.h(new oy(this.c.getPageActivity()));
            ny nyVar = new ny(this.c.getPageActivity());
            nyVar.E(1);
            bVar.h(nyVar);
            ly lyVar = new ly(this.c.getPageActivity());
            lyVar.D(this.o);
            lyVar.C("frs");
            bVar.h(lyVar);
            nz nzVar = new nz(this.c.getPageActivity(), false);
            r15 r15Var = new r15();
            if (100 == t().tabType) {
                r15Var.b = 25;
                nzVar.D(19);
                nzVar.I(14);
            } else {
                r15Var.b = 2;
                nzVar.D(2);
                nzVar.I(1);
            }
            r15Var.h = 2;
            nzVar.B(r15Var);
            nzVar.E(this.m);
            nzVar.f(16);
            nzVar.M();
            bVar.m(nzVar);
            lz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
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
    @Override // com.baidu.tieba.sd7, com.baidu.tieba.kn
    /* renamed from: V */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, r45 r45Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, r45Var, autoVideoCardViewHolder})) == null) {
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
                r45Var.t.statFloor = (i + 1) - i2;
            }
            ap7.k().c(this.n, r45Var.t);
            yo7.p(r45Var.t, this.mPageId, this.n, t());
            p45 taskInfoData = r45Var.t.getTaskInfoData();
            if (taskInfoData != null) {
                String h = taskInfoData.h();
                String e = taskInfoData.e();
                if (StringUtils.isNull(e)) {
                    e = taskInfoData.h();
                }
                String str = e;
                if (this.c.getOrignalPage() instanceof ef7) {
                    ef7 ef7Var = (ef7) this.c.getOrignalPage();
                    if (this.l.add(h)) {
                        String w = ef7Var.w();
                        String v = ef7Var.v();
                        String k = taskInfoData.k();
                        t4a.c("frs", "VIEW_TRUE", w, v, k, "tieba.baidu.com/p/" + r45Var.t.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", r45Var.t.getFid());
                statisticItem.param("tid", r45Var.t.getTid());
                statisticItem.param("obj_id", h);
                statisticItem.param("thread_type", r45Var.t.getThreadType());
                TiebaStatic.log(statisticItem);
                if (!taskInfoData.s && ThreadCardUtils.isHeadlinesCard(taskInfoData)) {
                    yo7.m(TbadkCoreStatisticKey.HEADLINES_2_SHOW, r45Var.t, TbadkCoreStatisticKey.HeadlinesFrontCardLocateValue.NO_LOCATE);
                    T(taskInfoData);
                    taskInfoData.s = true;
                }
            }
            if (r45Var != null) {
                r45Var.t.updateShowStatus();
                if (r45Var.t.getThreadVideoInfo() != null) {
                    c = 2;
                }
                if (c == 2) {
                    autoVideoCardViewHolder.x(S(r45Var.t));
                }
                rd7.i(autoVideoCardViewHolder.a().f(), this.b);
                autoVideoCardViewHolder.a().f().f(32);
                autoVideoCardViewHolder.e(r45Var.t);
                autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.a().q(this.p);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.bp7
    public zo7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.n;
        }
        return (zo7) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sd7
    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.x();
            this.l.clear();
        }
    }
}

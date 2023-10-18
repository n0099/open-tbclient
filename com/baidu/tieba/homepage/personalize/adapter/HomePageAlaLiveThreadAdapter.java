package com.baidu.tieba.homepage.personalize.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoLiveViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.bk6;
import com.baidu.tieba.k28;
import com.baidu.tieba.kj6;
import com.baidu.tieba.lh;
import com.baidu.tieba.qk6;
import com.baidu.tieba.tm5;
import com.baidu.tieba.xz5;
import com.baidu.tieba.yz5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class HomePageAlaLiveThreadAdapter extends lh<qk6, HomePageAlaLiveThreadViewHolder> implements yz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public kj6 c;
    public NEGFeedBackView.NEGFeedbackEventCallback d;
    public String e;
    public bk6<qk6> f;

    /* loaded from: classes6.dex */
    public static class HomePageAlaLiveThreadViewHolder extends AutoLiveViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public kj6 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(kj6 kj6Var) {
            super(kj6Var.i());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kj6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kj6Var;
            this.a = kj6Var.N();
        }
    }

    /* loaded from: classes6.dex */
    public class a extends bk6<qk6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageAlaLiveThreadAdapter b;

        public a(HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageAlaLiveThreadAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = homePageAlaLiveThreadAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x020c, code lost:
            if (r14.getId() == r13.b.c.O().getId()) goto L20;
         */
        @Override // com.baidu.tieba.bk6
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, qk6 qk6Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, qk6Var) == null) {
                LinearLayout linearLayout = this.b.c.w;
                String str = TiebaStatic.YYValues.YY_LIVE;
                int i2 = 2;
                if (linearLayout == view2) {
                    long j = 0;
                    String str2 = "";
                    if (qk6Var == null || qk6Var.getThreadData() == null) {
                        str = "";
                        i = 0;
                    } else {
                        i = YYLiveUtil.calculateLiveType(qk6Var.getThreadData().getThreadAlaInfo());
                        String tid = qk6Var.getThreadData().getTid();
                        j = qk6Var.getThreadData().getThreadAlaInfo().live_id;
                        if (!StringUtils.isNull(qk6Var.getThreadData().getThreadAlaInfo().appId)) {
                            str2 = qk6Var.getThreadData().getThreadAlaInfo().appId;
                        }
                        if (qk6Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                            str = str2;
                        }
                        str2 = tid;
                    }
                    StatisticItem statisticItem = new StatisticItem("c11824");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
                    statisticItem.param("ab_tag", qk6Var.c());
                    statisticItem.param("liveid", j);
                    statisticItem.param("obj_type", i);
                    statisticItem.param("tid", str2);
                    statisticItem.param("obj_param1", qk6Var.e());
                    statisticItem.param("obj_source", qk6Var.i());
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, qk6Var.h());
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, 0);
                    statisticItem.param("nid", qk6Var.getThreadData().getThreadAlaInfo().mYyExtData.feedId);
                    if (qk6Var.getThreadData() != null) {
                        statisticItem.param("fid", qk6Var.getThreadData().getFid());
                        statisticItem.param("fname", qk6Var.getThreadData().getForum_name());
                    }
                    TiebaStaticHelper.addYYParam(statisticItem, qk6Var.getThreadData().getThreadAlaInfo().mYyExtData);
                    TiebaStatic.log(statisticItem);
                    k28.c(qk6Var.a, qk6Var.i(), qk6Var.h(), 1);
                    i2 = 1;
                } else if (view2 == this.b.c.l.getCommentContainer()) {
                    this.b.u(qk6Var, view2);
                    i2 = 5;
                } else {
                    if (view2 == this.b.c.m.getCommentContainer()) {
                        this.b.u(qk6Var, view2);
                    } else if (this.b.c.M() != null && view2.getId() == this.b.c.M().getId()) {
                        if (qk6Var.getThreadData() != null && qk6Var.getThreadData().getThreadAlaInfo() != null && qk6Var.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                            ThreadData threadData = qk6Var.getThreadData();
                            AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                            int calculateLiveType = YYLiveUtil.calculateLiveType(qk6Var.getThreadData().getThreadAlaInfo());
                            String str3 = null;
                            if (!StringUtils.isNull(qk6Var.getThreadData().getThreadAlaInfo().appId)) {
                                str3 = qk6Var.getThreadData().getThreadAlaInfo().appId;
                            }
                            if (qk6Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                                str = str3;
                            }
                            StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_CLICK);
                            statisticItem2.param("fid", threadData.getFid());
                            statisticItem2.param("fname", threadData.getForum_name());
                            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem2.param("tid", threadData.getTid());
                            statisticItem2.param("obj_param1", calculateLiveType);
                            statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str);
                            TiebaStaticHelper.addYYParam(statisticItem2, threadAlaInfo.mYyExtData);
                            TiebaStatic.log(statisticItem2);
                        }
                    } else if (this.b.c.O() != null) {
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    k28.d(qk6Var.a, this.b.a, qk6Var.h(), i2);
                }
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageAlaLiveThreadAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.f = new a(this);
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.yz5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.e = str;
        }
    }

    public void z(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, nEGFeedbackEventCallback) == null) {
            this.d = nEGFeedbackEventCallback;
        }
    }

    public final void u(qk6 qk6Var, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, qk6Var, view2) == null) {
            String str2 = "";
            if (qk6Var == null || qk6Var.getThreadData() == null) {
                str = "";
            } else {
                str2 = qk6Var.getThreadData().getTid();
                str = qk6Var.getThreadData().getNid();
            }
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", 5);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_source", qk6Var.i());
            statisticItem.param("nid", str);
            tm5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
            if (findPageExtraByView != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: x */
    public HomePageAlaLiveThreadViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            kj6 kj6Var = new kj6(this.b, this.a);
            this.c = kj6Var;
            kj6Var.F(2);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.c.a0(bdUniqueId);
            }
            return new HomePageAlaLiveThreadViewHolder(this.c);
        }
        return (HomePageAlaLiveThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, qk6 qk6Var, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qk6Var, homePageAlaLiveThreadViewHolder})) == null) {
            qk6Var.A(qk6Var.position + 1);
            qk6Var.a.statFloor = qk6Var.h();
            kj6 kj6Var = homePageAlaLiveThreadViewHolder.b;
            if (kj6Var instanceof xz5) {
                kj6Var.b(this.e);
            }
            homePageAlaLiveThreadViewHolder.b.d0(i + 1);
            homePageAlaLiveThreadViewHolder.b.j(qk6Var);
            homePageAlaLiveThreadViewHolder.b.Q();
            homePageAlaLiveThreadViewHolder.b.l(this.f);
            homePageAlaLiveThreadViewHolder.b.E(this.d);
            if (qk6Var != null && qk6Var.getThreadData() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(qk6Var.getThreadData().getThreadAlaInfo());
                String tid = qk6Var.getThreadData().getTid();
                if (!StringUtils.isNull(qk6Var.getThreadData().getThreadAlaInfo().appId)) {
                    str = qk6Var.getThreadData().getThreadAlaInfo().appId;
                } else {
                    str = "";
                }
                if (qk6Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                long j = qk6Var.getThreadData().getThreadAlaInfo().live_id;
                StatisticItem statisticItem = new StatisticItem("c11823");
                statisticItem.param("obj_type", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                statisticItem.param("tid", tid);
                statisticItem.param("ab_tag", qk6Var.c());
                statisticItem.param("liveid", j);
                statisticItem.param("fid", qk6Var.getThreadData().getFid());
                statisticItem.param("fname", qk6Var.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
                statisticItem.param("obj_param1", qk6Var.e());
                statisticItem.param("obj_source", qk6Var.i());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, qk6Var.h());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, 0);
                statisticItem.param("nid", qk6Var.getThreadData().getThreadAlaInfo().mYyExtData.feedId);
                TiebaStaticHelper.addYYParam(statisticItem, qk6Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_SHOW);
                statisticItem2.param("fid", qk6Var.getThreadData().getFid());
                statisticItem2.param("fname", qk6Var.getThreadData().getForum_name());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("tid", qk6Var.getThreadData().getTid());
                statisticItem2.param("obj_param1", calculateLiveType);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem2, qk6Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem2);
            }
            k28.p(qk6Var.a, this.a, qk6Var.h());
            k28.o(qk6Var.a, qk6Var.i(), qk6Var.h());
            return homePageAlaLiveThreadViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}

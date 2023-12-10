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
import com.baidu.tieba.ci;
import com.baidu.tieba.cn6;
import com.baidu.tieba.d26;
import com.baidu.tieba.e26;
import com.baidu.tieba.ii8;
import com.baidu.tieba.mm6;
import com.baidu.tieba.vl6;
import com.baidu.tieba.xo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class HomePageAlaLiveThreadAdapter extends ci<cn6, HomePageAlaLiveThreadViewHolder> implements e26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public vl6 c;
    public NEGFeedBackView.NEGFeedbackEventCallback d;
    public String e;
    public mm6<cn6> f;

    /* loaded from: classes6.dex */
    public static class HomePageAlaLiveThreadViewHolder extends AutoLiveViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public vl6 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(vl6 vl6Var) {
            super(vl6Var.i());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vl6Var};
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
            this.b = vl6Var;
            this.a = vl6Var.O();
        }
    }

    /* loaded from: classes6.dex */
    public class a extends mm6<cn6> {
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
            if (r14.getId() == r13.b.c.P().getId()) goto L20;
         */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, cn6 cn6Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, cn6Var) == null) {
                LinearLayout linearLayout = this.b.c.w;
                String str = TiebaStatic.YYValues.YY_LIVE;
                int i2 = 2;
                if (linearLayout == view2) {
                    long j = 0;
                    String str2 = "";
                    if (cn6Var == null || cn6Var.getThreadData() == null) {
                        str = "";
                        i = 0;
                    } else {
                        i = YYLiveUtil.calculateLiveType(cn6Var.getThreadData().getThreadAlaInfo());
                        String tid = cn6Var.getThreadData().getTid();
                        j = cn6Var.getThreadData().getThreadAlaInfo().live_id;
                        if (!StringUtils.isNull(cn6Var.getThreadData().getThreadAlaInfo().appId)) {
                            str2 = cn6Var.getThreadData().getThreadAlaInfo().appId;
                        }
                        if (cn6Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                            str = str2;
                        }
                        str2 = tid;
                    }
                    StatisticItem statisticItem = new StatisticItem("c11824");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
                    statisticItem.param("ab_tag", cn6Var.c());
                    statisticItem.param("liveid", j);
                    statisticItem.param("obj_type", i);
                    statisticItem.param("tid", str2);
                    statisticItem.param("obj_param1", cn6Var.e());
                    statisticItem.param("obj_source", cn6Var.k());
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, cn6Var.h());
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, 0);
                    statisticItem.param("nid", cn6Var.getThreadData().getThreadAlaInfo().mYyExtData.feedId);
                    if (cn6Var.getThreadData() != null) {
                        statisticItem.param("fid", cn6Var.getThreadData().getFid());
                        statisticItem.param("fname", cn6Var.getThreadData().getForum_name());
                    }
                    TiebaStaticHelper.addYYParam(statisticItem, cn6Var.getThreadData().getThreadAlaInfo().mYyExtData);
                    TiebaStatic.log(statisticItem);
                    ii8.c(cn6Var.a, cn6Var.k(), cn6Var.h(), 1);
                    i2 = 1;
                } else if (view2 == this.b.c.l.getCommentContainer()) {
                    this.b.x(cn6Var, view2);
                    i2 = 5;
                } else {
                    if (view2 == this.b.c.m.getCommentContainer()) {
                        this.b.x(cn6Var, view2);
                    } else if (this.b.c.N() != null && view2.getId() == this.b.c.N().getId()) {
                        if (cn6Var.getThreadData() != null && cn6Var.getThreadData().getThreadAlaInfo() != null && cn6Var.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                            ThreadData threadData = cn6Var.getThreadData();
                            AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                            int calculateLiveType = YYLiveUtil.calculateLiveType(cn6Var.getThreadData().getThreadAlaInfo());
                            String str3 = null;
                            if (!StringUtils.isNull(cn6Var.getThreadData().getThreadAlaInfo().appId)) {
                                str3 = cn6Var.getThreadData().getThreadAlaInfo().appId;
                            }
                            if (cn6Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
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
                    } else if (this.b.c.P() != null) {
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    ii8.d(cn6Var.a, this.b.a, cn6Var.h(), i2);
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

    public void A(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nEGFeedbackEventCallback) == null) {
            this.d = nEGFeedbackEventCallback;
        }
    }

    @Override // com.baidu.tieba.e26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.e = str;
        }
    }

    public final void x(cn6 cn6Var, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cn6Var, view2) == null) {
            String str2 = "";
            if (cn6Var == null || cn6Var.getThreadData() == null) {
                str = "";
            } else {
                str2 = cn6Var.getThreadData().getTid();
                str = cn6Var.getThreadData().getNid();
            }
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", 5);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_source", cn6Var.k());
            statisticItem.param("nid", str);
            xo5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
    @Override // com.baidu.tieba.ci
    /* renamed from: y */
    public HomePageAlaLiveThreadViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            vl6 vl6Var = new vl6(this.b, this.a);
            this.c = vl6Var;
            vl6Var.G(2);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.c.a0(bdUniqueId);
            }
            return new HomePageAlaLiveThreadViewHolder(this.c);
        }
        return (HomePageAlaLiveThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: z */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, cn6 cn6Var, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, cn6Var, homePageAlaLiveThreadViewHolder})) == null) {
            cn6Var.B(cn6Var.position + 1);
            cn6Var.a.statFloor = cn6Var.h();
            vl6 vl6Var = homePageAlaLiveThreadViewHolder.b;
            if (vl6Var instanceof d26) {
                vl6Var.b(this.e);
            }
            homePageAlaLiveThreadViewHolder.b.d0(i + 1);
            homePageAlaLiveThreadViewHolder.b.j(cn6Var);
            homePageAlaLiveThreadViewHolder.b.R();
            homePageAlaLiveThreadViewHolder.b.l(this.f);
            homePageAlaLiveThreadViewHolder.b.F(this.d);
            if (cn6Var != null && cn6Var.getThreadData() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(cn6Var.getThreadData().getThreadAlaInfo());
                String tid = cn6Var.getThreadData().getTid();
                if (!StringUtils.isNull(cn6Var.getThreadData().getThreadAlaInfo().appId)) {
                    str = cn6Var.getThreadData().getThreadAlaInfo().appId;
                } else {
                    str = "";
                }
                if (cn6Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                long j = cn6Var.getThreadData().getThreadAlaInfo().live_id;
                StatisticItem statisticItem = new StatisticItem("c11823");
                statisticItem.param("obj_type", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                statisticItem.param("tid", tid);
                statisticItem.param("ab_tag", cn6Var.c());
                statisticItem.param("liveid", j);
                statisticItem.param("fid", cn6Var.getThreadData().getFid());
                statisticItem.param("fname", cn6Var.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
                statisticItem.param("obj_param1", cn6Var.e());
                statisticItem.param("obj_source", cn6Var.k());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, cn6Var.h());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, 0);
                statisticItem.param("nid", cn6Var.getThreadData().getThreadAlaInfo().mYyExtData.feedId);
                TiebaStaticHelper.addYYParam(statisticItem, cn6Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_SHOW);
                statisticItem2.param("fid", cn6Var.getThreadData().getFid());
                statisticItem2.param("fname", cn6Var.getThreadData().getForum_name());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("tid", cn6Var.getThreadData().getTid());
                statisticItem2.param("obj_param1", calculateLiveType);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem2, cn6Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem2);
            }
            ii8.p(cn6Var.a, this.a, cn6Var.h());
            ii8.o(cn6Var.a, cn6Var.k(), cn6Var.h());
            return homePageAlaLiveThreadViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}

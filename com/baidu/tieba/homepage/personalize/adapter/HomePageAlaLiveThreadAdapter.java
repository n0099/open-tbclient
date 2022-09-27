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
import com.baidu.tieba.d37;
import com.baidu.tieba.i26;
import com.baidu.tieba.oc5;
import com.baidu.tieba.qn;
import com.baidu.tieba.r16;
import com.baidu.tieba.so5;
import com.baidu.tieba.to5;
import com.baidu.tieba.w26;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class HomePageAlaLiveThreadAdapter extends qn<w26, HomePageAlaLiveThreadViewHolder> implements to5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public r16 c;
    public NEGFeedBackView.b d;
    public String e;
    public i26<w26> f;

    /* loaded from: classes4.dex */
    public static class HomePageAlaLiveThreadViewHolder extends AutoLiveViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public r16 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(r16 r16Var) {
            super(r16Var.h());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r16Var};
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
            this.b = r16Var;
            this.a = r16Var.N();
        }
    }

    /* loaded from: classes4.dex */
    public class a extends i26<w26> {
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
        /* JADX WARN: Code restructure failed: missing block: B:50:0x01ee, code lost:
            if (r14.getId() == r13.b.c.O().getId()) goto L20;
         */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, w26 w26Var) {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, w26Var) == null) {
                LinearLayout linearLayout = this.b.c.w;
                String str2 = TiebaStatic.YYValues.YY_LIVE;
                int i2 = 2;
                if (linearLayout != view2) {
                    if (view2 == this.b.c.l.getCommentContainer()) {
                        this.b.u(w26Var, view2);
                        i2 = 5;
                    } else {
                        if (view2 == this.b.c.m.getCommentContainer()) {
                            this.b.u(w26Var, view2);
                        } else if (this.b.c.M() == null || view2.getId() != this.b.c.M().getId()) {
                            if (this.b.c.O() != null) {
                            }
                        } else if (w26Var.getThreadData() != null && w26Var.getThreadData().getThreadAlaInfo() != null && w26Var.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                            ThreadData threadData = w26Var.getThreadData();
                            AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                            int calculateLiveType = YYLiveUtil.calculateLiveType(w26Var.getThreadData().getThreadAlaInfo());
                            String str3 = StringUtils.isNull(w26Var.getThreadData().getThreadAlaInfo().appId) ? null : w26Var.getThreadData().getThreadAlaInfo().appId;
                            if (w26Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                                str2 = str3;
                            }
                            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_CLICK);
                            statisticItem.param("fid", threadData.getFid());
                            statisticItem.param("fname", threadData.getForum_name());
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            statisticItem.param("tid", threadData.getTid());
                            statisticItem.param("obj_param1", calculateLiveType);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                            TiebaStaticHelper.addYYParam(statisticItem, threadAlaInfo.mYyExtData);
                            TiebaStatic.log(statisticItem);
                        }
                        i2 = 0;
                    }
                } else {
                    long j = 0;
                    str = "";
                    if (w26Var == null || w26Var.getThreadData() == null) {
                        str2 = "";
                        i = 0;
                    } else {
                        i = YYLiveUtil.calculateLiveType(w26Var.getThreadData().getThreadAlaInfo());
                        String tid = w26Var.getThreadData().getTid();
                        j = w26Var.getThreadData().getThreadAlaInfo().live_id;
                        str = StringUtils.isNull(w26Var.getThreadData().getThreadAlaInfo().appId) ? "" : w26Var.getThreadData().getThreadAlaInfo().appId;
                        if (w26Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                            str2 = str;
                        }
                        str = tid;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c11824");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("ab_tag", w26Var.c());
                    statisticItem2.param("liveid", j);
                    statisticItem2.param("obj_type", i);
                    statisticItem2.param("tid", str);
                    statisticItem2.param("obj_param1", w26Var.h());
                    statisticItem2.param("obj_source", w26Var.r());
                    statisticItem2.param(TiebaStatic.Params.OBJ_FLOOR, w26Var.n());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, 0);
                    if (w26Var.getThreadData() != null) {
                        statisticItem2.param("fid", w26Var.getThreadData().getFid());
                        statisticItem2.param("fname", w26Var.getThreadData().getForum_name());
                    }
                    TiebaStaticHelper.addYYParam(statisticItem2, w26Var.getThreadData().getThreadAlaInfo().mYyExtData);
                    TiebaStatic.log(statisticItem2);
                    d37.c(w26Var.a, w26Var.r(), w26Var.n(), 1);
                    i2 = 1;
                }
                if (i2 != 0) {
                    d37.d(w26Var.a, this.b.a, w26Var.n(), i2);
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

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.e = str;
        }
    }

    public final void u(w26 w26Var, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, w26Var, view2) == null) {
            String str2 = "";
            if (w26Var == null || w26Var.getThreadData() == null) {
                str = "";
            } else {
                str2 = w26Var.getThreadData().getTid();
                str = w26Var.getThreadData().getNid();
            }
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", 5);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_source", w26Var.r());
            statisticItem.param("nid", str);
            oc5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
    @Override // com.baidu.tieba.qn
    /* renamed from: v */
    public HomePageAlaLiveThreadViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            r16 r16Var = new r16(this.b, this.a);
            this.c = r16Var;
            r16Var.C(2);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.c.Y(bdUniqueId);
            }
            return new HomePageAlaLiveThreadViewHolder(this.c);
        }
        return (HomePageAlaLiveThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, w26 w26Var, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, w26Var, homePageAlaLiveThreadViewHolder})) == null) {
            w26Var.I(w26Var.position + 1);
            w26Var.a.statFloor = w26Var.n();
            r16 r16Var = homePageAlaLiveThreadViewHolder.b;
            if (r16Var instanceof so5) {
                r16Var.b(this.e);
            }
            homePageAlaLiveThreadViewHolder.b.b0(i + 1);
            homePageAlaLiveThreadViewHolder.b.i(w26Var);
            homePageAlaLiveThreadViewHolder.b.Q();
            homePageAlaLiveThreadViewHolder.b.n(this.f);
            homePageAlaLiveThreadViewHolder.b.B(this.d);
            if (w26Var != null && w26Var.getThreadData() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(w26Var.getThreadData().getThreadAlaInfo());
                String tid = w26Var.getThreadData().getTid();
                String str = !StringUtils.isNull(w26Var.getThreadData().getThreadAlaInfo().appId) ? w26Var.getThreadData().getThreadAlaInfo().appId : "";
                if (w26Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                long j = w26Var.getThreadData().getThreadAlaInfo().live_id;
                StatisticItem statisticItem = new StatisticItem("c11823");
                statisticItem.param("obj_type", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                statisticItem.param("tid", tid);
                statisticItem.param("ab_tag", w26Var.c());
                statisticItem.param("liveid", j);
                statisticItem.param("fid", w26Var.getThreadData().getFid());
                statisticItem.param("fname", w26Var.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_param1", w26Var.h());
                statisticItem.param("obj_source", w26Var.r());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, w26Var.n());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, 0);
                TiebaStaticHelper.addYYParam(statisticItem, w26Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_SHOW);
                statisticItem2.param("fid", w26Var.getThreadData().getFid());
                statisticItem2.param("fname", w26Var.getThreadData().getForum_name());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("tid", w26Var.getThreadData().getTid());
                statisticItem2.param("obj_param1", calculateLiveType);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem2, w26Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem2);
            }
            d37.i(w26Var.a, this.a, w26Var.n());
            d37.h(w26Var.a, w26Var.r(), w26Var.n());
            return homePageAlaLiveThreadViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void x(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.d = bVar;
        }
    }
}

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b06;
import com.repackage.b17;
import com.repackage.bn;
import com.repackage.kz5;
import com.repackage.m06;
import com.repackage.o95;
import com.repackage.ol5;
import com.repackage.pl5;
/* loaded from: classes3.dex */
public class HomePageAlaLiveThreadAdapter extends bn<m06, HomePageAlaLiveThreadViewHolder> implements pl5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public kz5 c;
    public NEGFeedBackView.b d;
    public String e;
    public b06<m06> f;

    /* loaded from: classes3.dex */
    public static class HomePageAlaLiveThreadViewHolder extends AutoLiveViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public kz5 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(kz5 kz5Var) {
            super(kz5Var.h());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kz5Var};
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
            this.b = kz5Var;
            this.a = kz5Var.N();
        }
    }

    /* loaded from: classes3.dex */
    public class a extends b06<m06> {
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
        @Override // com.repackage.b06
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, m06 m06Var) {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, m06Var) == null) {
                LinearLayout linearLayout = this.b.c.w;
                String str2 = TiebaStatic.YYValues.YY_LIVE;
                int i2 = 2;
                if (linearLayout != view2) {
                    if (view2 == this.b.c.l.getCommentContainer()) {
                        this.b.u(m06Var, view2);
                        i2 = 5;
                    } else {
                        if (view2 == this.b.c.m.getCommentContainer()) {
                            this.b.u(m06Var, view2);
                        } else if (this.b.c.M() == null || view2.getId() != this.b.c.M().getId()) {
                            if (this.b.c.O() != null) {
                            }
                        } else if (m06Var.getThreadData() != null && m06Var.getThreadData().getThreadAlaInfo() != null && m06Var.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                            ThreadData threadData = m06Var.getThreadData();
                            AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                            int calculateLiveType = YYLiveUtil.calculateLiveType(m06Var.getThreadData().getThreadAlaInfo());
                            String str3 = StringUtils.isNull(m06Var.getThreadData().getThreadAlaInfo().appId) ? null : m06Var.getThreadData().getThreadAlaInfo().appId;
                            if (m06Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
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
                    if (m06Var == null || m06Var.getThreadData() == null) {
                        str2 = "";
                        i = 0;
                    } else {
                        i = YYLiveUtil.calculateLiveType(m06Var.getThreadData().getThreadAlaInfo());
                        String tid = m06Var.getThreadData().getTid();
                        j = m06Var.getThreadData().getThreadAlaInfo().live_id;
                        str = StringUtils.isNull(m06Var.getThreadData().getThreadAlaInfo().appId) ? "" : m06Var.getThreadData().getThreadAlaInfo().appId;
                        if (m06Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                            str2 = str;
                        }
                        str = tid;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c11824");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("ab_tag", m06Var.c());
                    statisticItem2.param("liveid", j);
                    statisticItem2.param("obj_type", i);
                    statisticItem2.param("tid", str);
                    statisticItem2.param("obj_param1", m06Var.h());
                    statisticItem2.param("obj_source", m06Var.r());
                    statisticItem2.param(TiebaStatic.Params.OBJ_FLOOR, m06Var.n());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, 0);
                    if (m06Var.getThreadData() != null) {
                        statisticItem2.param("fid", m06Var.getThreadData().getFid());
                        statisticItem2.param("fname", m06Var.getThreadData().getForum_name());
                    }
                    TiebaStaticHelper.addYYParam(statisticItem2, m06Var.getThreadData().getThreadAlaInfo().mYyExtData);
                    TiebaStatic.log(statisticItem2);
                    b17.c(m06Var.a, m06Var.r(), m06Var.n(), 1);
                    i2 = 1;
                }
                if (i2 != 0) {
                    b17.d(m06Var.a, this.b.a, m06Var.n(), i2);
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

    @Override // com.repackage.pl5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.e = str;
        }
    }

    public final void u(m06 m06Var, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, m06Var, view2) == null) {
            String str2 = "";
            if (m06Var == null || m06Var.getThreadData() == null) {
                str = "";
            } else {
                str2 = m06Var.getThreadData().getTid();
                str = m06Var.getThreadData().getNid();
            }
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", 5);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_source", m06Var.r());
            statisticItem.param("nid", str);
            o95 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
    @Override // com.repackage.bn
    /* renamed from: v */
    public HomePageAlaLiveThreadViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            kz5 kz5Var = new kz5(this.b, this.a);
            this.c = kz5Var;
            kz5Var.C(2);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.c.Y(bdUniqueId);
            }
            return new HomePageAlaLiveThreadViewHolder(this.c);
        }
        return (HomePageAlaLiveThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, m06 m06Var, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, m06Var, homePageAlaLiveThreadViewHolder})) == null) {
            m06Var.I(m06Var.position + 1);
            m06Var.a.statFloor = m06Var.n();
            kz5 kz5Var = homePageAlaLiveThreadViewHolder.b;
            if (kz5Var instanceof ol5) {
                kz5Var.b(this.e);
            }
            homePageAlaLiveThreadViewHolder.b.b0(i + 1);
            homePageAlaLiveThreadViewHolder.b.i(m06Var);
            homePageAlaLiveThreadViewHolder.b.Q();
            homePageAlaLiveThreadViewHolder.b.n(this.f);
            homePageAlaLiveThreadViewHolder.b.B(this.d);
            if (m06Var != null && m06Var.getThreadData() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(m06Var.getThreadData().getThreadAlaInfo());
                String tid = m06Var.getThreadData().getTid();
                String str = !StringUtils.isNull(m06Var.getThreadData().getThreadAlaInfo().appId) ? m06Var.getThreadData().getThreadAlaInfo().appId : "";
                if (m06Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                long j = m06Var.getThreadData().getThreadAlaInfo().live_id;
                StatisticItem statisticItem = new StatisticItem("c11823");
                statisticItem.param("obj_type", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                statisticItem.param("tid", tid);
                statisticItem.param("ab_tag", m06Var.c());
                statisticItem.param("liveid", j);
                statisticItem.param("fid", m06Var.getThreadData().getFid());
                statisticItem.param("fname", m06Var.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_param1", m06Var.h());
                statisticItem.param("obj_source", m06Var.r());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, m06Var.n());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, 0);
                TiebaStaticHelper.addYYParam(statisticItem, m06Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_SHOW);
                statisticItem2.param("fid", m06Var.getThreadData().getFid());
                statisticItem2.param("fname", m06Var.getThreadData().getForum_name());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("tid", m06Var.getThreadData().getTid());
                statisticItem2.param("obj_param1", calculateLiveType);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem2, m06Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem2);
            }
            b17.i(m06Var.a, this.a, m06Var.n());
            b17.h(m06Var.a, m06Var.r(), m06Var.n());
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

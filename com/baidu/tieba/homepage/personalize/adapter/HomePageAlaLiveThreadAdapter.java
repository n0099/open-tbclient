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
import com.baidu.tieba.f67;
import com.baidu.tieba.gr5;
import com.baidu.tieba.h56;
import com.baidu.tieba.hr5;
import com.baidu.tieba.kn;
import com.baidu.tieba.pe5;
import com.baidu.tieba.q46;
import com.baidu.tieba.v56;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class HomePageAlaLiveThreadAdapter extends kn<v56, HomePageAlaLiveThreadViewHolder> implements hr5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public q46 c;
    public NEGFeedBackView.b d;
    public String e;
    public h56<v56> f;

    /* loaded from: classes4.dex */
    public static class HomePageAlaLiveThreadViewHolder extends AutoLiveViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public q46 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(q46 q46Var) {
            super(q46Var.h());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q46Var};
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
            this.b = q46Var;
            this.a = q46Var.L();
        }
    }

    /* loaded from: classes4.dex */
    public class a extends h56<v56> {
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
        /* JADX WARN: Code restructure failed: missing block: B:50:0x01ff, code lost:
            if (r14.getId() == r13.b.c.M().getId()) goto L20;
         */
        @Override // com.baidu.tieba.h56
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, v56 v56Var) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, v56Var) == null) {
                LinearLayout linearLayout = this.b.c.w;
                String str = TiebaStatic.YYValues.YY_LIVE;
                int i2 = 2;
                if (linearLayout == view2) {
                    long j = 0;
                    String str2 = "";
                    if (v56Var == null || v56Var.getThreadData() == null) {
                        str = "";
                        i = 0;
                    } else {
                        i = YYLiveUtil.calculateLiveType(v56Var.getThreadData().getThreadAlaInfo());
                        String tid = v56Var.getThreadData().getTid();
                        j = v56Var.getThreadData().getThreadAlaInfo().live_id;
                        if (!StringUtils.isNull(v56Var.getThreadData().getThreadAlaInfo().appId)) {
                            str2 = v56Var.getThreadData().getThreadAlaInfo().appId;
                        }
                        if (v56Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                            str = str2;
                        }
                        str2 = tid;
                    }
                    StatisticItem statisticItem = new StatisticItem("c11824");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("ab_tag", v56Var.c());
                    statisticItem.param("liveid", j);
                    statisticItem.param("obj_type", i);
                    statisticItem.param("tid", str2);
                    statisticItem.param("obj_param1", v56Var.g());
                    statisticItem.param("obj_source", v56Var.o());
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, v56Var.m());
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, 0);
                    statisticItem.param("nid", v56Var.getThreadData().getThreadAlaInfo().mYyExtData.feedId);
                    if (v56Var.getThreadData() != null) {
                        statisticItem.param("fid", v56Var.getThreadData().getFid());
                        statisticItem.param("fname", v56Var.getThreadData().getForum_name());
                    }
                    TiebaStaticHelper.addYYParam(statisticItem, v56Var.getThreadData().getThreadAlaInfo().mYyExtData);
                    TiebaStatic.log(statisticItem);
                    f67.c(v56Var.a, v56Var.o(), v56Var.m(), 1);
                    i2 = 1;
                } else if (view2 == this.b.c.l.getCommentContainer()) {
                    this.b.u(v56Var, view2);
                    i2 = 5;
                } else {
                    if (view2 == this.b.c.m.getCommentContainer()) {
                        this.b.u(v56Var, view2);
                    } else if (this.b.c.K() != null && view2.getId() == this.b.c.K().getId()) {
                        if (v56Var.getThreadData() != null && v56Var.getThreadData().getThreadAlaInfo() != null && v56Var.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                            ThreadData threadData = v56Var.getThreadData();
                            AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                            int calculateLiveType = YYLiveUtil.calculateLiveType(v56Var.getThreadData().getThreadAlaInfo());
                            String str3 = null;
                            if (!StringUtils.isNull(v56Var.getThreadData().getThreadAlaInfo().appId)) {
                                str3 = v56Var.getThreadData().getThreadAlaInfo().appId;
                            }
                            if (v56Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
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
                    } else if (this.b.c.M() != null) {
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    f67.d(v56Var.a, this.b.a, v56Var.m(), i2);
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

    @Override // com.baidu.tieba.hr5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.e = str;
        }
    }

    public void x(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public final void u(v56 v56Var, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, v56Var, view2) == null) {
            String str2 = "";
            if (v56Var == null || v56Var.getThreadData() == null) {
                str = "";
            } else {
                str2 = v56Var.getThreadData().getTid();
                str = v56Var.getThreadData().getNid();
            }
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", 5);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_source", v56Var.o());
            statisticItem.param("nid", str);
            pe5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
    @Override // com.baidu.tieba.kn
    /* renamed from: v */
    public HomePageAlaLiveThreadViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            q46 q46Var = new q46(this.b, this.a);
            this.c = q46Var;
            q46Var.C(2);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.c.X(bdUniqueId);
            }
            return new HomePageAlaLiveThreadViewHolder(this.c);
        }
        return (HomePageAlaLiveThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: w */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, v56 v56Var, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, v56Var, homePageAlaLiveThreadViewHolder})) == null) {
            v56Var.I(v56Var.position + 1);
            v56Var.a.statFloor = v56Var.m();
            q46 q46Var = homePageAlaLiveThreadViewHolder.b;
            if (q46Var instanceof gr5) {
                q46Var.b(this.e);
            }
            homePageAlaLiveThreadViewHolder.b.a0(i + 1);
            homePageAlaLiveThreadViewHolder.b.i(v56Var);
            homePageAlaLiveThreadViewHolder.b.O();
            homePageAlaLiveThreadViewHolder.b.n(this.f);
            homePageAlaLiveThreadViewHolder.b.B(this.d);
            if (v56Var != null && v56Var.getThreadData() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(v56Var.getThreadData().getThreadAlaInfo());
                String tid = v56Var.getThreadData().getTid();
                if (!StringUtils.isNull(v56Var.getThreadData().getThreadAlaInfo().appId)) {
                    str = v56Var.getThreadData().getThreadAlaInfo().appId;
                } else {
                    str = "";
                }
                if (v56Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                long j = v56Var.getThreadData().getThreadAlaInfo().live_id;
                StatisticItem statisticItem = new StatisticItem("c11823");
                statisticItem.param("obj_type", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                statisticItem.param("tid", tid);
                statisticItem.param("ab_tag", v56Var.c());
                statisticItem.param("liveid", j);
                statisticItem.param("fid", v56Var.getThreadData().getFid());
                statisticItem.param("fname", v56Var.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_param1", v56Var.g());
                statisticItem.param("obj_source", v56Var.o());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, v56Var.m());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, 0);
                statisticItem.param("nid", v56Var.getThreadData().getThreadAlaInfo().mYyExtData.feedId);
                TiebaStaticHelper.addYYParam(statisticItem, v56Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_SHOW);
                statisticItem2.param("fid", v56Var.getThreadData().getFid());
                statisticItem2.param("fname", v56Var.getThreadData().getForum_name());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("tid", v56Var.getThreadData().getTid());
                statisticItem2.param("obj_param1", calculateLiveType);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem2, v56Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem2);
            }
            f67.k(v56Var.a, this.a, v56Var.m());
            f67.j(v56Var.a, v56Var.o(), v56Var.m());
            return homePageAlaLiveThreadViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}

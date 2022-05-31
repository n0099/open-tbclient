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
import com.repackage.bi5;
import com.repackage.ci5;
import com.repackage.jx6;
import com.repackage.nw5;
import com.repackage.wm;
import com.repackage.wv5;
import com.repackage.xc5;
import com.repackage.yw5;
import com.repackage.z65;
/* loaded from: classes3.dex */
public class HomePageAlaLiveThreadAdapter extends wm<yw5, HomePageAlaLiveThreadViewHolder> implements ci5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public wv5 k;
    public NEGFeedBackView.b l;
    public String m;
    public nw5<yw5> n;

    /* loaded from: classes3.dex */
    public static class HomePageAlaLiveThreadViewHolder extends AutoLiveViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public wv5 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(wv5 wv5Var) {
            super(wv5Var.k());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wv5Var};
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
            this.b = wv5Var;
            this.a = wv5Var.N();
        }
    }

    /* loaded from: classes3.dex */
    public class a extends nw5<yw5> {
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
        /* JADX WARN: Code restructure failed: missing block: B:51:0x01fb, code lost:
            if (r13.getId() == r12.b.k.O().getId()) goto L50;
         */
        @Override // com.repackage.nw5
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, yw5 yw5Var) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, yw5Var) == null) {
                LinearLayout linearLayout = this.b.k.w;
                String str2 = TiebaStatic.YYValues.YY_LIVE;
                int i = 1;
                int i2 = 0;
                if (linearLayout != view2) {
                    if (view2 == this.b.k.l.getCommentContainer()) {
                        this.b.b0(yw5Var, view2);
                        i = 5;
                    } else {
                        if (view2 == this.b.k.m.getCommentContainer()) {
                            this.b.b0(yw5Var, view2);
                        } else {
                            if (this.b.k.M() == null || view2.getId() != this.b.k.M().getId()) {
                                if (this.b.k.O() != null) {
                                }
                            } else if (yw5Var.getThreadData() != null && yw5Var.getThreadData().getThreadAlaInfo() != null && yw5Var.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                                ThreadData threadData = yw5Var.getThreadData();
                                AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                                int calculateLiveType = YYLiveUtil.calculateLiveType(yw5Var.getThreadData().getThreadAlaInfo());
                                String str3 = StringUtils.isNull(yw5Var.getThreadData().getThreadAlaInfo().appId) ? null : yw5Var.getThreadData().getThreadAlaInfo().appId;
                                if (yw5Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
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
                            i = 2;
                        }
                        i = 0;
                    }
                } else {
                    long j = 0;
                    str = "";
                    if (yw5Var == null || yw5Var.getThreadData() == null) {
                        str2 = "";
                    } else {
                        i2 = YYLiveUtil.calculateLiveType(yw5Var.getThreadData().getThreadAlaInfo());
                        String tid = yw5Var.getThreadData().getTid();
                        j = yw5Var.getThreadData().getThreadAlaInfo().live_id;
                        str = StringUtils.isNull(yw5Var.getThreadData().getThreadAlaInfo().appId) ? "" : yw5Var.getThreadData().getThreadAlaInfo().appId;
                        if (yw5Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                            str2 = str;
                        }
                        str = tid;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c11824");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("ab_tag", yw5Var.e());
                    statisticItem2.param("liveid", j);
                    statisticItem2.param("obj_type", i2);
                    statisticItem2.param("tid", str);
                    statisticItem2.param("obj_param1", yw5Var.i());
                    statisticItem2.param("obj_source", yw5Var.r());
                    statisticItem2.param(TiebaStatic.Params.OBJ_FLOOR, yw5Var.q());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, xc5.d(this.b.k.getContext()) ? 1 : 0);
                    if (yw5Var.getThreadData() != null) {
                        statisticItem2.param("fid", yw5Var.getThreadData().getFid());
                        statisticItem2.param("fname", yw5Var.getThreadData().getForum_name());
                    }
                    TiebaStaticHelper.addYYParam(statisticItem2, yw5Var.getThreadData().getThreadAlaInfo().mYyExtData);
                    TiebaStatic.log(statisticItem2);
                    jx6.c(yw5Var.a, yw5Var.r(), yw5Var.q(), 1);
                }
                if (i != 0) {
                    jx6.d(yw5Var.a, this.b.i, yw5Var.q(), i);
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
        this.l = null;
        this.n = new a(this);
        this.j = tbPageContext;
    }

    public final void b0(yw5 yw5Var, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, yw5Var, view2) == null) {
            String str2 = "";
            if (yw5Var == null || yw5Var.getThreadData() == null) {
                str = "";
            } else {
                str2 = yw5Var.getThreadData().getTid();
                str = yw5Var.getThreadData().getNid();
            }
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", 5);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_source", yw5Var.r());
            statisticItem.param("nid", str);
            z65 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
    @Override // com.repackage.wm
    /* renamed from: c0 */
    public HomePageAlaLiveThreadViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            wv5 wv5Var = new wv5(this.j, this.i);
            this.k = wv5Var;
            wv5Var.D(2);
            BdUniqueId bdUniqueId = this.i;
            if (bdUniqueId != null) {
                this.k.Y(bdUniqueId);
            }
            return new HomePageAlaLiveThreadViewHolder(this.k);
        }
        return (HomePageAlaLiveThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, yw5 yw5Var, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yw5Var, homePageAlaLiveThreadViewHolder})) == null) {
            yw5Var.I(yw5Var.position + 1);
            yw5Var.a.statFloor = yw5Var.q();
            wv5 wv5Var = homePageAlaLiveThreadViewHolder.b;
            if (wv5Var instanceof bi5) {
                wv5Var.b(this.m);
            }
            homePageAlaLiveThreadViewHolder.b.b0(i + 1);
            homePageAlaLiveThreadViewHolder.b.l(yw5Var);
            homePageAlaLiveThreadViewHolder.b.Q();
            homePageAlaLiveThreadViewHolder.b.n(this.n);
            homePageAlaLiveThreadViewHolder.b.C(this.l);
            if (yw5Var != null && yw5Var.getThreadData() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(yw5Var.getThreadData().getThreadAlaInfo());
                String tid = yw5Var.getThreadData().getTid();
                String str = !StringUtils.isNull(yw5Var.getThreadData().getThreadAlaInfo().appId) ? yw5Var.getThreadData().getThreadAlaInfo().appId : "";
                if (yw5Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                long j = yw5Var.getThreadData().getThreadAlaInfo().live_id;
                StatisticItem statisticItem = new StatisticItem("c11823");
                statisticItem.param("obj_type", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                statisticItem.param("tid", tid);
                statisticItem.param("ab_tag", yw5Var.e());
                statisticItem.param("liveid", j);
                statisticItem.param("fid", yw5Var.getThreadData().getFid());
                statisticItem.param("fname", yw5Var.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_param1", yw5Var.i());
                statisticItem.param("obj_source", yw5Var.r());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, yw5Var.q());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, xc5.d(homePageAlaLiveThreadViewHolder.b.getContext()) ? 1 : 0);
                TiebaStaticHelper.addYYParam(statisticItem, yw5Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_SHOW);
                statisticItem2.param("fid", yw5Var.getThreadData().getFid());
                statisticItem2.param("fname", yw5Var.getThreadData().getForum_name());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("tid", yw5Var.getThreadData().getTid());
                statisticItem2.param("obj_param1", calculateLiveType);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem2, yw5Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem2);
            }
            jx6.h(yw5Var.a, this.i, yw5Var.q());
            jx6.g(yw5Var.a, yw5Var.r(), yw5Var.q());
            return homePageAlaLiveThreadViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.l = bVar;
        }
    }

    @Override // com.repackage.ci5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.m = str;
        }
    }
}

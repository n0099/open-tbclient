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
import com.repackage.an;
import com.repackage.bk5;
import com.repackage.ck5;
import com.repackage.iz6;
import com.repackage.jy5;
import com.repackage.q85;
import com.repackage.sx5;
import com.repackage.uy5;
/* loaded from: classes3.dex */
public class HomePageAlaLiveThreadAdapter extends an<uy5, HomePageAlaLiveThreadViewHolder> implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public sx5 k;
    public NEGFeedBackView.b l;
    public String m;
    public jy5<uy5> n;

    /* loaded from: classes3.dex */
    public static class HomePageAlaLiveThreadViewHolder extends AutoLiveViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public sx5 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(sx5 sx5Var) {
            super(sx5Var.h());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx5Var};
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
            this.b = sx5Var;
            this.a = sx5Var.N();
        }
    }

    /* loaded from: classes3.dex */
    public class a extends jy5<uy5> {
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
            if (r14.getId() == r13.b.k.O().getId()) goto L20;
         */
        @Override // com.repackage.jy5
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, uy5 uy5Var) {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, uy5Var) == null) {
                LinearLayout linearLayout = this.b.k.w;
                String str2 = TiebaStatic.YYValues.YY_LIVE;
                int i2 = 2;
                if (linearLayout != view2) {
                    if (view2 == this.b.k.l.getCommentContainer()) {
                        this.b.b0(uy5Var, view2);
                        i2 = 5;
                    } else {
                        if (view2 == this.b.k.m.getCommentContainer()) {
                            this.b.b0(uy5Var, view2);
                        } else if (this.b.k.M() == null || view2.getId() != this.b.k.M().getId()) {
                            if (this.b.k.O() != null) {
                            }
                        } else if (uy5Var.getThreadData() != null && uy5Var.getThreadData().getThreadAlaInfo() != null && uy5Var.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                            ThreadData threadData = uy5Var.getThreadData();
                            AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                            int calculateLiveType = YYLiveUtil.calculateLiveType(uy5Var.getThreadData().getThreadAlaInfo());
                            String str3 = StringUtils.isNull(uy5Var.getThreadData().getThreadAlaInfo().appId) ? null : uy5Var.getThreadData().getThreadAlaInfo().appId;
                            if (uy5Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
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
                    if (uy5Var == null || uy5Var.getThreadData() == null) {
                        str2 = "";
                        i = 0;
                    } else {
                        i = YYLiveUtil.calculateLiveType(uy5Var.getThreadData().getThreadAlaInfo());
                        String tid = uy5Var.getThreadData().getTid();
                        j = uy5Var.getThreadData().getThreadAlaInfo().live_id;
                        str = StringUtils.isNull(uy5Var.getThreadData().getThreadAlaInfo().appId) ? "" : uy5Var.getThreadData().getThreadAlaInfo().appId;
                        if (uy5Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                            str2 = str;
                        }
                        str = tid;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c11824");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("ab_tag", uy5Var.c());
                    statisticItem2.param("liveid", j);
                    statisticItem2.param("obj_type", i);
                    statisticItem2.param("tid", str);
                    statisticItem2.param("obj_param1", uy5Var.g());
                    statisticItem2.param("obj_source", uy5Var.o());
                    statisticItem2.param(TiebaStatic.Params.OBJ_FLOOR, uy5Var.m());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, 0);
                    if (uy5Var.getThreadData() != null) {
                        statisticItem2.param("fid", uy5Var.getThreadData().getFid());
                        statisticItem2.param("fname", uy5Var.getThreadData().getForum_name());
                    }
                    TiebaStaticHelper.addYYParam(statisticItem2, uy5Var.getThreadData().getThreadAlaInfo().mYyExtData);
                    TiebaStatic.log(statisticItem2);
                    iz6.c(uy5Var.a, uy5Var.o(), uy5Var.m(), 1);
                    i2 = 1;
                }
                if (i2 != 0) {
                    iz6.d(uy5Var.a, this.b.i, uy5Var.m(), i2);
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

    public final void b0(uy5 uy5Var, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uy5Var, view2) == null) {
            String str2 = "";
            if (uy5Var == null || uy5Var.getThreadData() == null) {
                str = "";
            } else {
                str2 = uy5Var.getThreadData().getTid();
                str = uy5Var.getThreadData().getNid();
            }
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", 5);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_source", uy5Var.o());
            statisticItem.param("nid", str);
            q85 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
    @Override // com.repackage.an
    /* renamed from: c0 */
    public HomePageAlaLiveThreadViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            sx5 sx5Var = new sx5(this.j, this.i);
            this.k = sx5Var;
            sx5Var.C(2);
            BdUniqueId bdUniqueId = this.i;
            if (bdUniqueId != null) {
                this.k.Y(bdUniqueId);
            }
            return new HomePageAlaLiveThreadViewHolder(this.k);
        }
        return (HomePageAlaLiveThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, uy5 uy5Var, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, uy5Var, homePageAlaLiveThreadViewHolder})) == null) {
            uy5Var.I(uy5Var.position + 1);
            uy5Var.a.statFloor = uy5Var.m();
            sx5 sx5Var = homePageAlaLiveThreadViewHolder.b;
            if (sx5Var instanceof bk5) {
                sx5Var.b(this.m);
            }
            homePageAlaLiveThreadViewHolder.b.b0(i + 1);
            homePageAlaLiveThreadViewHolder.b.i(uy5Var);
            homePageAlaLiveThreadViewHolder.b.Q();
            homePageAlaLiveThreadViewHolder.b.n(this.n);
            homePageAlaLiveThreadViewHolder.b.B(this.l);
            if (uy5Var != null && uy5Var.getThreadData() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(uy5Var.getThreadData().getThreadAlaInfo());
                String tid = uy5Var.getThreadData().getTid();
                String str = !StringUtils.isNull(uy5Var.getThreadData().getThreadAlaInfo().appId) ? uy5Var.getThreadData().getThreadAlaInfo().appId : "";
                if (uy5Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                long j = uy5Var.getThreadData().getThreadAlaInfo().live_id;
                StatisticItem statisticItem = new StatisticItem("c11823");
                statisticItem.param("obj_type", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                statisticItem.param("tid", tid);
                statisticItem.param("ab_tag", uy5Var.c());
                statisticItem.param("liveid", j);
                statisticItem.param("fid", uy5Var.getThreadData().getFid());
                statisticItem.param("fname", uy5Var.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_param1", uy5Var.g());
                statisticItem.param("obj_source", uy5Var.o());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, uy5Var.m());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, 0);
                TiebaStaticHelper.addYYParam(statisticItem, uy5Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_SHOW);
                statisticItem2.param("fid", uy5Var.getThreadData().getFid());
                statisticItem2.param("fname", uy5Var.getThreadData().getForum_name());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("tid", uy5Var.getThreadData().getTid());
                statisticItem2.param("obj_param1", calculateLiveType);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem2, uy5Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem2);
            }
            iz6.i(uy5Var.a, this.i, uy5Var.m());
            iz6.h(uy5Var.a, uy5Var.o(), uy5Var.m());
            return homePageAlaLiveThreadViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.l = bVar;
        }
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.m = str;
        }
    }
}

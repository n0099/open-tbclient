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
import com.repackage.mx5;
import com.repackage.n75;
import com.repackage.sy6;
import com.repackage.vw5;
import com.repackage.xx5;
import com.repackage.yi5;
import com.repackage.zi5;
/* loaded from: classes3.dex */
public class HomePageAlaLiveThreadAdapter extends an<xx5, HomePageAlaLiveThreadViewHolder> implements zi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public vw5 k;
    public NEGFeedBackView.b l;
    public String m;
    public mx5<xx5> n;

    /* loaded from: classes3.dex */
    public static class HomePageAlaLiveThreadViewHolder extends AutoLiveViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public vw5 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(vw5 vw5Var) {
            super(vw5Var.h());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vw5Var};
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
            this.b = vw5Var;
            this.a = vw5Var.N();
        }
    }

    /* loaded from: classes3.dex */
    public class a extends mx5<xx5> {
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
        @Override // com.repackage.mx5
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, xx5 xx5Var) {
            String str;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, xx5Var) == null) {
                LinearLayout linearLayout = this.b.k.w;
                String str2 = TiebaStatic.YYValues.YY_LIVE;
                int i2 = 2;
                if (linearLayout != view2) {
                    if (view2 == this.b.k.l.getCommentContainer()) {
                        this.b.b0(xx5Var, view2);
                        i2 = 5;
                    } else {
                        if (view2 == this.b.k.m.getCommentContainer()) {
                            this.b.b0(xx5Var, view2);
                        } else if (this.b.k.M() == null || view2.getId() != this.b.k.M().getId()) {
                            if (this.b.k.O() != null) {
                            }
                        } else if (xx5Var.getThreadData() != null && xx5Var.getThreadData().getThreadAlaInfo() != null && xx5Var.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                            ThreadData threadData = xx5Var.getThreadData();
                            AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                            int calculateLiveType = YYLiveUtil.calculateLiveType(xx5Var.getThreadData().getThreadAlaInfo());
                            String str3 = StringUtils.isNull(xx5Var.getThreadData().getThreadAlaInfo().appId) ? null : xx5Var.getThreadData().getThreadAlaInfo().appId;
                            if (xx5Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
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
                    if (xx5Var == null || xx5Var.getThreadData() == null) {
                        str2 = "";
                        i = 0;
                    } else {
                        i = YYLiveUtil.calculateLiveType(xx5Var.getThreadData().getThreadAlaInfo());
                        String tid = xx5Var.getThreadData().getTid();
                        j = xx5Var.getThreadData().getThreadAlaInfo().live_id;
                        str = StringUtils.isNull(xx5Var.getThreadData().getThreadAlaInfo().appId) ? "" : xx5Var.getThreadData().getThreadAlaInfo().appId;
                        if (xx5Var.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                            str2 = str;
                        }
                        str = tid;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c11824");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("ab_tag", xx5Var.c());
                    statisticItem2.param("liveid", j);
                    statisticItem2.param("obj_type", i);
                    statisticItem2.param("tid", str);
                    statisticItem2.param("obj_param1", xx5Var.h());
                    statisticItem2.param("obj_source", xx5Var.r());
                    statisticItem2.param(TiebaStatic.Params.OBJ_FLOOR, xx5Var.n());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, 0);
                    if (xx5Var.getThreadData() != null) {
                        statisticItem2.param("fid", xx5Var.getThreadData().getFid());
                        statisticItem2.param("fname", xx5Var.getThreadData().getForum_name());
                    }
                    TiebaStaticHelper.addYYParam(statisticItem2, xx5Var.getThreadData().getThreadAlaInfo().mYyExtData);
                    TiebaStatic.log(statisticItem2);
                    sy6.c(xx5Var.a, xx5Var.r(), xx5Var.n(), 1);
                    i2 = 1;
                }
                if (i2 != 0) {
                    sy6.d(xx5Var.a, this.b.i, xx5Var.n(), i2);
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

    public final void b0(xx5 xx5Var, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, xx5Var, view2) == null) {
            String str2 = "";
            if (xx5Var == null || xx5Var.getThreadData() == null) {
                str = "";
            } else {
                str2 = xx5Var.getThreadData().getTid();
                str = xx5Var.getThreadData().getNid();
            }
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", 5);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_source", xx5Var.r());
            statisticItem.param("nid", str);
            n75 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
            vw5 vw5Var = new vw5(this.j, this.i);
            this.k = vw5Var;
            vw5Var.C(2);
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
    public View S(int i, View view2, ViewGroup viewGroup, xx5 xx5Var, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xx5Var, homePageAlaLiveThreadViewHolder})) == null) {
            xx5Var.I(xx5Var.position + 1);
            xx5Var.a.statFloor = xx5Var.n();
            vw5 vw5Var = homePageAlaLiveThreadViewHolder.b;
            if (vw5Var instanceof yi5) {
                vw5Var.b(this.m);
            }
            homePageAlaLiveThreadViewHolder.b.b0(i + 1);
            homePageAlaLiveThreadViewHolder.b.i(xx5Var);
            homePageAlaLiveThreadViewHolder.b.Q();
            homePageAlaLiveThreadViewHolder.b.n(this.n);
            homePageAlaLiveThreadViewHolder.b.B(this.l);
            if (xx5Var != null && xx5Var.getThreadData() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(xx5Var.getThreadData().getThreadAlaInfo());
                String tid = xx5Var.getThreadData().getTid();
                String str = !StringUtils.isNull(xx5Var.getThreadData().getThreadAlaInfo().appId) ? xx5Var.getThreadData().getThreadAlaInfo().appId : "";
                if (xx5Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                long j = xx5Var.getThreadData().getThreadAlaInfo().live_id;
                StatisticItem statisticItem = new StatisticItem("c11823");
                statisticItem.param("obj_type", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                statisticItem.param("tid", tid);
                statisticItem.param("ab_tag", xx5Var.c());
                statisticItem.param("liveid", j);
                statisticItem.param("fid", xx5Var.getThreadData().getFid());
                statisticItem.param("fname", xx5Var.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_param1", xx5Var.h());
                statisticItem.param("obj_source", xx5Var.r());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, xx5Var.n());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, 0);
                TiebaStaticHelper.addYYParam(statisticItem, xx5Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_SHOW);
                statisticItem2.param("fid", xx5Var.getThreadData().getFid());
                statisticItem2.param("fname", xx5Var.getThreadData().getForum_name());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("tid", xx5Var.getThreadData().getTid());
                statisticItem2.param("obj_param1", calculateLiveType);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem2, xx5Var.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem2);
            }
            sy6.h(xx5Var.a, this.i, xx5Var.n());
            sy6.g(xx5Var.a, xx5Var.r(), xx5Var.n());
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

    @Override // com.repackage.zi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.m = str;
        }
    }
}

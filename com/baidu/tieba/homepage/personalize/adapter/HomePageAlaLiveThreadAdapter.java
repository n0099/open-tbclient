package com.baidu.tieba.homepage.personalize.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import c.a.o0.c1.t0;
import c.a.o0.n0.c;
import c.a.p0.h0.b0;
import c.a.p0.h0.e0.j;
import c.a.p0.h0.k;
import c.a.p0.v.e;
import c.a.p0.v.f;
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
/* loaded from: classes5.dex */
public class HomePageAlaLiveThreadAdapter extends c.a.d.o.e.a<j, HomePageAlaLiveThreadViewHolder> implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public k k;
    public NEGFeedBackView.b l;
    public String m;
    public b0<j> n;

    /* loaded from: classes5.dex */
    public static class HomePageAlaLiveThreadViewHolder extends AutoLiveViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public k f33376b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(k kVar) {
            super(kVar.k());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
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
            this.f33376b = kVar;
            this.a = kVar.M();
        }
    }

    /* loaded from: classes5.dex */
    public class a extends b0<j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageAlaLiveThreadAdapter f33377b;

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
            this.f33377b = homePageAlaLiveThreadAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x01fb, code lost:
            if (r13.getId() == r12.f33377b.k.N().getId()) goto L50;
         */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, j jVar) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, jVar) == null) {
                LinearLayout linearLayout = this.f33377b.k.w;
                String str2 = TiebaStatic.YYValues.YY_LIVE;
                int i = 1;
                int i2 = 0;
                if (linearLayout != view) {
                    if (view == this.f33377b.k.l.getCommentContainer()) {
                        this.f33377b.b0(jVar, view);
                        i = 5;
                    } else {
                        if (view == this.f33377b.k.m.getCommentContainer()) {
                            this.f33377b.b0(jVar, view);
                        } else {
                            if (this.f33377b.k.L() == null || view.getId() != this.f33377b.k.L().getId()) {
                                if (this.f33377b.k.N() != null) {
                                }
                            } else if (jVar.getThreadData() != null && jVar.getThreadData().getThreadAlaInfo() != null && jVar.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                                ThreadData threadData = jVar.getThreadData();
                                AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                                int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.getThreadData().getThreadAlaInfo());
                                String str3 = StringUtils.isNull(jVar.getThreadData().getThreadAlaInfo().appId) ? null : jVar.getThreadData().getThreadAlaInfo().appId;
                                if (jVar.getThreadData().getThreadAlaInfo().mYyExtData == null) {
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
                    if (jVar == null || jVar.getThreadData() == null) {
                        str2 = "";
                    } else {
                        i2 = YYLiveUtil.calculateLiveType(jVar.getThreadData().getThreadAlaInfo());
                        String tid = jVar.getThreadData().getTid();
                        j = jVar.getThreadData().getThreadAlaInfo().live_id;
                        str = StringUtils.isNull(jVar.getThreadData().getThreadAlaInfo().appId) ? "" : jVar.getThreadData().getThreadAlaInfo().appId;
                        if (jVar.getThreadData().getThreadAlaInfo().mYyExtData == null) {
                            str2 = str;
                        }
                        str = tid;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c11824");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("ab_tag", jVar.e());
                    statisticItem2.param("liveid", j);
                    statisticItem2.param("obj_type", i2);
                    statisticItem2.param("tid", str);
                    statisticItem2.param("obj_param1", jVar.i());
                    statisticItem2.param("obj_source", jVar.r());
                    statisticItem2.param(TiebaStatic.Params.OBJ_FLOOR, jVar.q());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, t0.d(this.f33377b.k.getContext()) ? 1 : 0);
                    if (jVar.getThreadData() != null) {
                        statisticItem2.param("fid", jVar.getThreadData().getFid());
                        statisticItem2.param("fname", jVar.getThreadData().getForum_name());
                    }
                    TiebaStaticHelper.addYYParam(statisticItem2, jVar.getThreadData().getThreadAlaInfo().mYyExtData);
                    TiebaStatic.log(statisticItem2);
                    c.a.p0.q1.i.m.a.c(jVar.a, jVar.r(), jVar.q(), 1);
                }
                if (i != 0) {
                    c.a.p0.q1.i.m.a.d(jVar.a, this.f33377b.i, jVar.q(), i);
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

    public final void b0(j jVar, View view) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jVar, view) == null) {
            String str2 = "";
            if (jVar == null || jVar.getThreadData() == null) {
                str = "";
            } else {
                str2 = jVar.getThreadData().getTid();
                str = jVar.getThreadData().getNid();
            }
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", 5);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_source", jVar.r());
            statisticItem.param("nid", str);
            c findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view);
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
    @Override // c.a.d.o.e.a
    /* renamed from: c0 */
    public HomePageAlaLiveThreadViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            k kVar = new k(this.j, this.i);
            this.k = kVar;
            kVar.C(2);
            BdUniqueId bdUniqueId = this.i;
            if (bdUniqueId != null) {
                this.k.X(bdUniqueId);
            }
            return new HomePageAlaLiveThreadViewHolder(this.k);
        }
        return (HomePageAlaLiveThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: d0 */
    public View S(int i, View view, ViewGroup viewGroup, j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, jVar, homePageAlaLiveThreadViewHolder})) == null) {
            jVar.I(jVar.position + 1);
            jVar.a.statFloor = jVar.q();
            k kVar = homePageAlaLiveThreadViewHolder.f33376b;
            if (kVar instanceof e) {
                kVar.e(this.m);
            }
            homePageAlaLiveThreadViewHolder.f33376b.a0(i + 1);
            homePageAlaLiveThreadViewHolder.f33376b.l(jVar);
            homePageAlaLiveThreadViewHolder.f33376b.P();
            homePageAlaLiveThreadViewHolder.f33376b.n(this.n);
            homePageAlaLiveThreadViewHolder.f33376b.B(this.l);
            if (jVar != null && jVar.getThreadData() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.getThreadData().getThreadAlaInfo());
                String tid = jVar.getThreadData().getTid();
                String str = !StringUtils.isNull(jVar.getThreadData().getThreadAlaInfo().appId) ? jVar.getThreadData().getThreadAlaInfo().appId : "";
                if (jVar.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                long j = jVar.getThreadData().getThreadAlaInfo().live_id;
                StatisticItem statisticItem = new StatisticItem("c11823");
                statisticItem.param("obj_type", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                statisticItem.param("tid", tid);
                statisticItem.param("ab_tag", jVar.e());
                statisticItem.param("liveid", j);
                statisticItem.param("fid", jVar.getThreadData().getFid());
                statisticItem.param("fname", jVar.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_param1", jVar.i());
                statisticItem.param("obj_source", jVar.r());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, jVar.q());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, t0.d(homePageAlaLiveThreadViewHolder.f33376b.getContext()) ? 1 : 0);
                TiebaStaticHelper.addYYParam(statisticItem, jVar.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_SHOW);
                statisticItem2.param("fid", jVar.getThreadData().getFid());
                statisticItem2.param("fname", jVar.getThreadData().getForum_name());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("tid", jVar.getThreadData().getTid());
                statisticItem2.param("obj_param1", calculateLiveType);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem2, jVar.getThreadData().getThreadAlaInfo().mYyExtData);
                TiebaStatic.log(statisticItem2);
            }
            c.a.p0.q1.i.m.a.h(jVar.a, this.i, jVar.q());
            c.a.p0.q1.i.m.a.g(jVar.a, jVar.r(), jVar.q());
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

    @Override // c.a.p0.v.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.m = str;
        }
    }
}

package com.baidu.tieba.homepage.personalize.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import c.a.q0.c1.t0;
import c.a.q0.n0.c;
import c.a.q0.r.r.e2;
import c.a.r0.f0.b0;
import c.a.r0.f0.d0.j;
import c.a.r0.f0.k;
import c.a.r0.t.e;
import c.a.r0.t.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoLiveViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
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
    public BdUniqueId m;
    public TbPageContext<?> n;
    public k o;
    public NEGFeedBackView.b p;
    public String q;
    public b0<j> r;

    /* loaded from: classes5.dex */
    public static class HomePageAlaLiveThreadViewHolder extends AutoLiveViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public k mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(k kVar) {
            super(kVar.j());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mView = kVar;
            this.tbLiveContainer = kVar.L();
        }
    }

    /* loaded from: classes5.dex */
    public class a extends b0<j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageAlaLiveThreadAdapter f43018b;

        public a(HomePageAlaLiveThreadAdapter homePageAlaLiveThreadAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageAlaLiveThreadAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43018b = homePageAlaLiveThreadAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x01fb, code lost:
            if (r13.getId() == r12.f43018b.o.M().getId()) goto L50;
         */
        @Override // c.a.r0.f0.b0
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, j jVar) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, jVar) == null) {
                LinearLayout linearLayout = this.f43018b.o.A;
                String str2 = TiebaStatic.YYValues.YY_LIVE;
                int i2 = 1;
                int i3 = 0;
                if (linearLayout != view) {
                    if (view == this.f43018b.o.p.getCommentContainer()) {
                        this.f43018b.b0(jVar, view);
                        i2 = 5;
                    } else {
                        if (view == this.f43018b.o.q.getCommentContainer()) {
                            this.f43018b.b0(jVar, view);
                        } else {
                            if (this.f43018b.o.K() == null || view.getId() != this.f43018b.o.K().getId()) {
                                if (this.f43018b.o.M() != null) {
                                }
                            } else if (jVar.getThreadData() != null && jVar.getThreadData().p1() != null && jVar.getThreadData().p1().isLegalYYLiveData()) {
                                e2 threadData = jVar.getThreadData();
                                AlaInfoData p1 = threadData.p1();
                                int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.getThreadData().p1());
                                String str3 = StringUtils.isNull(jVar.getThreadData().p1().appId) ? null : jVar.getThreadData().p1().appId;
                                if (jVar.getThreadData().p1().mYyExtData == null) {
                                    str2 = str3;
                                }
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_CLICK);
                                statisticItem.param("fid", threadData.U());
                                statisticItem.param("fname", threadData.b0());
                                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                statisticItem.param("tid", threadData.w1());
                                statisticItem.param("obj_param1", calculateLiveType);
                                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                                TiebaStaticHelper.addYYParam(statisticItem, p1.mYyExtData);
                                TiebaStatic.log(statisticItem);
                            }
                            i2 = 2;
                        }
                        i2 = 0;
                    }
                } else {
                    long j2 = 0;
                    str = "";
                    if (jVar == null || jVar.getThreadData() == null) {
                        str2 = "";
                    } else {
                        i3 = YYLiveUtil.calculateLiveType(jVar.getThreadData().p1());
                        String w1 = jVar.getThreadData().w1();
                        j2 = jVar.getThreadData().p1().live_id;
                        str = StringUtils.isNull(jVar.getThreadData().p1().appId) ? "" : jVar.getThreadData().p1().appId;
                        if (jVar.getThreadData().p1().mYyExtData == null) {
                            str2 = str;
                        }
                        str = w1;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c11824");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("ab_tag", jVar.g());
                    statisticItem2.param("liveid", j2);
                    statisticItem2.param("obj_type", i3);
                    statisticItem2.param("tid", str);
                    statisticItem2.param("obj_param1", jVar.k());
                    statisticItem2.param("obj_source", jVar.t());
                    statisticItem2.param(TiebaStatic.Params.OBJ_FLOOR, jVar.q());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, t0.d(this.f43018b.o.getContext()) ? 1 : 0);
                    if (jVar.getThreadData() != null) {
                        statisticItem2.param("fid", jVar.getThreadData().U());
                        statisticItem2.param("fname", jVar.getThreadData().b0());
                    }
                    TiebaStaticHelper.addYYParam(statisticItem2, jVar.getThreadData().p1().mYyExtData);
                    TiebaStatic.log(statisticItem2);
                    c.a.r0.o1.i.m.a.c(jVar.f17272e, jVar.t(), jVar.q(), 1);
                }
                if (i2 != 0) {
                    c.a.r0.o1.i.m.a.d(jVar.f17272e, this.f43018b.m, jVar.q(), i2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = null;
        this.r = new a(this);
        this.n = tbPageContext;
    }

    public final void b0(j jVar, View view) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, jVar, view) == null) {
            String str2 = "";
            if (jVar == null || jVar.getThreadData() == null) {
                str = "";
            } else {
                str2 = jVar.getThreadData().w1();
                str = jVar.getThreadData().H0();
            }
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", 5);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_source", jVar.t());
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
            k kVar = new k(this.n, this.m);
            this.o = kVar;
            kVar.B(2);
            BdUniqueId bdUniqueId = this.m;
            if (bdUniqueId != null) {
                this.o.W(bdUniqueId);
            }
            return new HomePageAlaLiveThreadViewHolder(this.o);
        }
        return (HomePageAlaLiveThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: d0 */
    public View S(int i2, View view, ViewGroup viewGroup, j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, jVar, homePageAlaLiveThreadViewHolder})) == null) {
            jVar.J(jVar.position + 1);
            jVar.f17272e.T1 = jVar.q();
            k kVar = homePageAlaLiveThreadViewHolder.mView;
            if (kVar instanceof e) {
                kVar.d(this.q);
            }
            homePageAlaLiveThreadViewHolder.mView.Z(i2 + 1);
            homePageAlaLiveThreadViewHolder.mView.k(jVar);
            homePageAlaLiveThreadViewHolder.mView.O();
            homePageAlaLiveThreadViewHolder.mView.m(this.r);
            homePageAlaLiveThreadViewHolder.mView.A(this.p);
            if (jVar != null && jVar.getThreadData() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.getThreadData().p1());
                String w1 = jVar.getThreadData().w1();
                String str = !StringUtils.isNull(jVar.getThreadData().p1().appId) ? jVar.getThreadData().p1().appId : "";
                if (jVar.getThreadData().p1().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                long j2 = jVar.getThreadData().p1().live_id;
                StatisticItem statisticItem = new StatisticItem("c11823");
                statisticItem.param("obj_type", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                statisticItem.param("tid", w1);
                statisticItem.param("ab_tag", jVar.g());
                statisticItem.param("liveid", j2);
                statisticItem.param("fid", jVar.getThreadData().U());
                statisticItem.param("fname", jVar.getThreadData().b0());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_param1", jVar.k());
                statisticItem.param("obj_source", jVar.t());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, jVar.q());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, t0.d(homePageAlaLiveThreadViewHolder.mView.getContext()) ? 1 : 0);
                TiebaStaticHelper.addYYParam(statisticItem, jVar.getThreadData().p1().mYyExtData);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_SHOW);
                statisticItem2.param("fid", jVar.getThreadData().U());
                statisticItem2.param("fname", jVar.getThreadData().b0());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("tid", jVar.getThreadData().w1());
                statisticItem2.param("obj_param1", calculateLiveType);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem2, jVar.getThreadData().p1().mYyExtData);
                TiebaStatic.log(statisticItem2);
            }
            c.a.r0.o1.i.m.a.h(jVar.f17272e, this.m, jVar.q());
            c.a.r0.o1.i.m.a.g(jVar.f17272e, jVar.t(), jVar.q());
            return homePageAlaLiveThreadViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.p = bVar;
        }
    }

    @Override // c.a.r0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.q = str;
        }
    }
}

package com.baidu.tieba.homepage.personalize.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import b.a.q0.c1.r0;
import b.a.q0.m0.c;
import b.a.q0.s.q.d2;
import b.a.r0.b0.d0;
import b.a.r0.b0.f0.j;
import b.a.r0.b0.k;
import b.a.r0.p.e;
import b.a.r0.p.f;
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
/* loaded from: classes9.dex */
public class HomePageAlaLiveThreadAdapter extends b.a.e.m.e.a<j, HomePageAlaLiveThreadViewHolder> implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public k o;
    public NEGFeedBackView.b p;
    public String q;
    public d0<j> r;

    /* loaded from: classes9.dex */
    public static class HomePageAlaLiveThreadViewHolder extends AutoLiveViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public k mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(k kVar) {
            super(kVar.i());
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
            this.tbLiveContainer = kVar.R();
        }
    }

    /* loaded from: classes9.dex */
    public class a extends d0<j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageAlaLiveThreadAdapter f50590b;

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
            this.f50590b = homePageAlaLiveThreadAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x01fb, code lost:
            if (r13.getId() == r12.f50590b.o.S().getId()) goto L50;
         */
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, j jVar) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, jVar) == null) {
                LinearLayout linearLayout = this.f50590b.o.A;
                String str2 = TiebaStatic.YYValues.YY_LIVE;
                int i2 = 1;
                int i3 = 0;
                if (linearLayout != view) {
                    if (view == this.f50590b.o.p.getCommentContainer()) {
                        this.f50590b.i0(jVar, view);
                        i2 = 5;
                    } else {
                        if (view == this.f50590b.o.q.getCommentContainer()) {
                            this.f50590b.i0(jVar, view);
                        } else {
                            if (this.f50590b.o.Q() == null || view.getId() != this.f50590b.o.Q().getId()) {
                                if (this.f50590b.o.S() != null) {
                                }
                            } else if (jVar.getThreadData() != null && jVar.getThreadData().m1() != null && jVar.getThreadData().m1().isLegalYYLiveData()) {
                                d2 threadData = jVar.getThreadData();
                                AlaInfoData m1 = threadData.m1();
                                int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.getThreadData().m1());
                                String str3 = StringUtils.isNull(jVar.getThreadData().m1().appId) ? null : jVar.getThreadData().m1().appId;
                                if (jVar.getThreadData().m1().mYyExtData == null) {
                                    str2 = str3;
                                }
                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_CLICK);
                                statisticItem.param("fid", threadData.T());
                                statisticItem.param("fname", threadData.Z());
                                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                statisticItem.param("tid", threadData.t1());
                                statisticItem.param("obj_param1", calculateLiveType);
                                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                                TiebaStaticHelper.addYYParam(statisticItem, m1.mYyExtData);
                                TiebaStatic.log(statisticItem);
                            }
                            i2 = 2;
                        }
                        i2 = 0;
                    }
                } else {
                    long j = 0;
                    str = "";
                    if (jVar == null || jVar.getThreadData() == null) {
                        str2 = "";
                    } else {
                        i3 = YYLiveUtil.calculateLiveType(jVar.getThreadData().m1());
                        String t1 = jVar.getThreadData().t1();
                        j = jVar.getThreadData().m1().live_id;
                        str = StringUtils.isNull(jVar.getThreadData().m1().appId) ? "" : jVar.getThreadData().m1().appId;
                        if (jVar.getThreadData().m1().mYyExtData == null) {
                            str2 = str;
                        }
                        str = t1;
                    }
                    StatisticItem statisticItem2 = new StatisticItem("c11824");
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem2.param("ab_tag", jVar.g());
                    statisticItem2.param("liveid", j);
                    statisticItem2.param("obj_type", i3);
                    statisticItem2.param("tid", str);
                    statisticItem2.param("obj_param1", jVar.k());
                    statisticItem2.param("obj_source", jVar.t());
                    statisticItem2.param(TiebaStatic.Params.OBJ_FLOOR, jVar.q());
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM4, r0.d(this.f50590b.o.getContext()) ? 1 : 0);
                    if (jVar.getThreadData() != null) {
                        statisticItem2.param("fid", jVar.getThreadData().T());
                        statisticItem2.param("fname", jVar.getThreadData().Z());
                    }
                    TiebaStaticHelper.addYYParam(statisticItem2, jVar.getThreadData().m1().mYyExtData);
                    TiebaStatic.log(statisticItem2);
                    b.a.r0.h1.h.m.a.b(jVar.f16235e, jVar.t(), jVar.q(), 1);
                }
                if (i2 != 0) {
                    b.a.r0.h1.h.m.a.c(jVar.f16235e, this.f50590b.m, jVar.q(), i2);
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

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.q = str;
        }
    }

    public final void i0(j jVar, View view) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, jVar, view) == null) {
            String str2 = "";
            if (jVar == null || jVar.getThreadData() == null) {
                str = "";
            } else {
                str2 = jVar.getThreadData().t1();
                str = jVar.getThreadData().F0();
            }
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", 5);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_source", jVar.t());
            statisticItem.param("nid", str);
            c f2 = TbPageExtraHelper.f(view);
            if (f2 != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, f2.a());
            }
            if (TbPageExtraHelper.m() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: j0 */
    public HomePageAlaLiveThreadViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            k kVar = new k(this.n, this.m);
            this.o = kVar;
            kVar.A(2);
            BdUniqueId bdUniqueId = this.m;
            if (bdUniqueId != null) {
                this.o.e0(bdUniqueId);
            }
            return new HomePageAlaLiveThreadViewHolder(this.o);
        }
        return (HomePageAlaLiveThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: k0 */
    public View Z(int i2, View view, ViewGroup viewGroup, j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, jVar, homePageAlaLiveThreadViewHolder})) == null) {
            jVar.K(jVar.position + 1);
            jVar.f16235e.T1 = jVar.q();
            k kVar = homePageAlaLiveThreadViewHolder.mView;
            if (kVar instanceof e) {
                kVar.setPage(this.q);
            }
            homePageAlaLiveThreadViewHolder.mView.g0(i2 + 1);
            homePageAlaLiveThreadViewHolder.mView.j(jVar);
            homePageAlaLiveThreadViewHolder.mView.U();
            homePageAlaLiveThreadViewHolder.mView.l(this.r);
            homePageAlaLiveThreadViewHolder.mView.z(this.p);
            if (jVar != null && jVar.getThreadData() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.getThreadData().m1());
                String t1 = jVar.getThreadData().t1();
                String str = !StringUtils.isNull(jVar.getThreadData().m1().appId) ? jVar.getThreadData().m1().appId : "";
                if (jVar.getThreadData().m1().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                long j = jVar.getThreadData().m1().live_id;
                StatisticItem statisticItem = new StatisticItem("c11823");
                statisticItem.param("obj_type", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                statisticItem.param("tid", t1);
                statisticItem.param("ab_tag", jVar.g());
                statisticItem.param("liveid", j);
                statisticItem.param("fid", jVar.getThreadData().T());
                statisticItem.param("fname", jVar.getThreadData().Z());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_param1", jVar.k());
                statisticItem.param("obj_source", jVar.t());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, jVar.q());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, r0.d(homePageAlaLiveThreadViewHolder.mView.getContext()) ? 1 : 0);
                TiebaStaticHelper.addYYParam(statisticItem, jVar.getThreadData().m1().mYyExtData);
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_YY_LIVE_AVATER_SHOW);
                statisticItem2.param("fid", jVar.getThreadData().T());
                statisticItem2.param("fname", jVar.getThreadData().Z());
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("tid", jVar.getThreadData().t1());
                statisticItem2.param("obj_param1", calculateLiveType);
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str);
                TiebaStaticHelper.addYYParam(statisticItem2, jVar.getThreadData().m1().mYyExtData);
                TiebaStatic.log(statisticItem2);
            }
            b.a.r0.h1.h.m.a.f(jVar.f16235e, this.m, jVar.q());
            b.a.r0.h1.h.m.a.e(jVar.f16235e, jVar.t(), jVar.q());
            return homePageAlaLiveThreadViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.p = bVar;
        }
    }
}

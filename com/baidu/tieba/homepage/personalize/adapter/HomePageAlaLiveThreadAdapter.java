package com.baidu.tieba.homepage.personalize.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import d.a.o0.i0.c;
import d.a.p0.a0.b0;
import d.a.p0.a0.e0.j;
import d.a.p0.a0.k;
import d.a.p0.o.e;
import d.a.p0.o.f;
/* loaded from: classes4.dex */
public class HomePageAlaLiveThreadAdapter extends d.a.c.k.e.a<j, HomePageAlaLiveThreadViewHolder> implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public k o;
    public NEGFeedBackView.b p;
    public String q;
    public b0<j> r;

    /* loaded from: classes4.dex */
    public static class HomePageAlaLiveThreadViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public k f16758a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(k kVar) {
            super(kVar.k());
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
            this.f16758a = kVar;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends b0<j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageAlaLiveThreadAdapter f16759b;

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
            this.f16759b = homePageAlaLiveThreadAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x010a, code lost:
            if (r9.getId() == r8.f16759b.o.K().getId()) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x012b, code lost:
            if (r9.getId() == r8.f16759b.o.L().getId()) goto L17;
         */
        @Override // d.a.p0.a0.b0
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, j jVar) {
            String str;
            long j;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, jVar) == null) {
                int i2 = 2;
                int i3 = 0;
                if (this.f16759b.o.x != view) {
                    if (view == this.f16759b.o.p.getCommentContainer()) {
                        this.f16759b.h0(jVar, view);
                        i2 = 5;
                    } else {
                        if (view == this.f16759b.o.q.getCommentContainer()) {
                            this.f16759b.h0(jVar, view);
                        } else {
                            if (this.f16759b.o.K() != null) {
                            }
                            if (this.f16759b.o.L() != null) {
                            }
                        }
                        i2 = 0;
                    }
                } else {
                    str = "";
                    if (jVar == null || jVar.getThreadData() == null) {
                        j = 0;
                        str2 = "";
                    } else {
                        i3 = YYLiveUtil.calculateLiveType(jVar.getThreadData().g1());
                        String n1 = jVar.getThreadData().n1();
                        j = jVar.getThreadData().g1().live_id;
                        str = StringUtils.isNull(jVar.getThreadData().g1().appId) ? "" : jVar.getThreadData().g1().appId;
                        if (jVar.getThreadData().g1().mYyExtData != null) {
                            str = TiebaStatic.YYValues.YY_LIVE;
                        }
                        str2 = str;
                        str = n1;
                    }
                    StatisticItem statisticItem = new StatisticItem("c11824");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem.param("ab_tag", jVar.c());
                    statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                    statisticItem.param("obj_type", i3);
                    statisticItem.param("tid", str);
                    statisticItem.param("obj_param1", jVar.e());
                    statisticItem.param("obj_source", jVar.p());
                    statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, jVar.o());
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str2);
                    TiebaStaticHelper.addYYParam(statisticItem, jVar.getThreadData().g1().mYyExtData);
                    TiebaStatic.log(statisticItem);
                    i2 = 1;
                }
                if (i2 != 0) {
                    d.a.p0.e1.h.m.a.a(jVar.f53795e, this.f16759b.m, jVar.o(), i2);
                }
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

    @Override // d.a.p0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.q = str;
        }
    }

    public final void h0(j jVar, View view) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, jVar, view) == null) {
            String str2 = "";
            if (jVar == null || jVar.getThreadData() == null) {
                str = "";
            } else {
                str2 = jVar.getThreadData().n1();
                str = jVar.getThreadData().A0();
            }
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", 5);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_source", jVar.p());
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
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public HomePageAlaLiveThreadViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            k kVar = new k(this.n, this.m);
            this.o = kVar;
            kVar.z(2);
            BdUniqueId bdUniqueId = this.m;
            if (bdUniqueId != null) {
                this.o.T(bdUniqueId);
            }
            return new HomePageAlaLiveThreadViewHolder(this.o);
        }
        return (HomePageAlaLiveThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: j0 */
    public View X(int i2, View view, ViewGroup viewGroup, j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, jVar, homePageAlaLiveThreadViewHolder})) == null) {
            jVar.I(jVar.position + 1);
            k kVar = homePageAlaLiveThreadViewHolder.f16758a;
            if (kVar instanceof e) {
                kVar.setPage(this.q);
            }
            homePageAlaLiveThreadViewHolder.f16758a.W(i2 + 1);
            homePageAlaLiveThreadViewHolder.f16758a.l(jVar);
            homePageAlaLiveThreadViewHolder.f16758a.n(this.r);
            homePageAlaLiveThreadViewHolder.f16758a.y(this.p);
            if (jVar != null && jVar.getThreadData() != null) {
                int calculateLiveType = YYLiveUtil.calculateLiveType(jVar.getThreadData().g1());
                String n1 = jVar.getThreadData().n1();
                String str = !StringUtils.isNull(jVar.getThreadData().g1().appId) ? jVar.getThreadData().g1().appId : "";
                if (jVar.getThreadData().g1().mYyExtData != null) {
                    str = TiebaStatic.YYValues.YY_LIVE;
                }
                long j = jVar.getThreadData().g1().live_id;
                StatisticItem statisticItem = new StatisticItem("c11823");
                statisticItem.param("obj_type", calculateLiveType);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str);
                statisticItem.param("tid", n1);
                statisticItem.param("ab_tag", jVar.c());
                statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, j);
                statisticItem.param("fid", jVar.getThreadData().Q());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("obj_param1", jVar.e());
                statisticItem.param("obj_source", jVar.p());
                statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, jVar.o());
                TiebaStaticHelper.addYYParam(statisticItem, jVar.getThreadData().g1().mYyExtData);
                TiebaStatic.log(statisticItem);
            }
            d.a.p0.e1.h.m.a.c(jVar.f53795e, this.m, jVar.o());
            return homePageAlaLiveThreadViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void k0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.p = bVar;
        }
    }
}

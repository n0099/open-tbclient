package com.baidu.tieba.homepage.personalize.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.q0.m0.c;
import b.a.r0.b0.c0;
import b.a.r0.b0.e0.j;
import b.a.r0.p.e;
import b.a.r0.p.f;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class HomePageAlaFriendRoomAdapter extends b.a.e.l.e.a<j, HomePageAlaLiveThreadViewHolder> implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public b.a.r0.b0.j o;
    public NEGFeedBackView.b p;
    public String q;
    public c0<j> r;

    /* loaded from: classes9.dex */
    public static class HomePageAlaLiveThreadViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public b.a.r0.b0.j mView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(b.a.r0.b0.j jVar) {
            super(jVar.i());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
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
            this.mView = jVar;
        }
    }

    /* loaded from: classes9.dex */
    public class a extends c0<j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ HomePageAlaFriendRoomAdapter f49677b;

        public a(HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageAlaFriendRoomAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49677b = homePageAlaFriendRoomAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
            if (r5.getId() == r4.f49677b.o.P().getId()) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
            if (r5.getId() == r4.f49677b.o.Q().getId()) goto L6;
         */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, jVar) == null) {
                int i2 = 2;
                if (this.f49677b.o.A == view) {
                    i2 = 1;
                } else if (view == this.f49677b.o.p.getCommentContainer()) {
                    this.f49677b.i0(jVar, view);
                    i2 = 5;
                } else {
                    if (view == this.f49677b.o.q.getCommentContainer()) {
                        this.f49677b.i0(jVar, view);
                    } else {
                        if (this.f49677b.o.P() != null) {
                        }
                        if (this.f49677b.o.Q() != null) {
                        }
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    b.a.r0.h1.h.m.a.c(jVar.f14748e, this.f49677b.m, jVar.q(), i2);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageAlaFriendRoomAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
                str2 = jVar.getThreadData().s1();
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
    @Override // b.a.e.l.e.a
    /* renamed from: j0 */
    public HomePageAlaLiveThreadViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            b.a.r0.b0.j jVar = new b.a.r0.b0.j(this.n, this.m);
            this.o = jVar;
            jVar.A(2);
            BdUniqueId bdUniqueId = this.m;
            if (bdUniqueId != null) {
                this.o.W(bdUniqueId);
            }
            return new HomePageAlaLiveThreadViewHolder(this.o);
        }
        return (HomePageAlaLiveThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: k0 */
    public View Z(int i2, View view, ViewGroup viewGroup, j jVar, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, jVar, homePageAlaLiveThreadViewHolder})) == null) {
            jVar.K(jVar.position + 1);
            jVar.f14748e.T1 = jVar.q();
            b.a.r0.b0.j jVar2 = homePageAlaLiveThreadViewHolder.mView;
            if (jVar2 instanceof e) {
                jVar2.setPage(this.q);
            }
            homePageAlaLiveThreadViewHolder.mView.Y(i2 + 1);
            homePageAlaLiveThreadViewHolder.mView.j(jVar);
            homePageAlaLiveThreadViewHolder.mView.l(this.r);
            homePageAlaLiveThreadViewHolder.mView.z(this.p);
            b.a.r0.h1.h.m.a.f(jVar.f14748e, this.m, jVar.q());
            if (jVar.getThreadData() != null && jVar.getThreadData().l1() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_param1", jVar.getThreadData().l1().live_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
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

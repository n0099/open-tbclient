package com.baidu.tieba.homepage.personalize.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tieba.ix5;
import com.baidu.tieba.jx5;
import com.baidu.tieba.lf6;
import com.baidu.tieba.pi7;
import com.baidu.tieba.tm;
import com.baidu.tieba.ue6;
import com.baidu.tieba.zf6;
import com.baidu.tieba.zj5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class HomePageAlaFriendRoomAdapter extends tm<zf6, HomePageAlaLiveThreadViewHolder> implements jx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public ue6 c;
    public NEGFeedBackView.b d;
    public String e;
    public lf6<zf6> f;

    /* loaded from: classes4.dex */
    public static class HomePageAlaLiveThreadViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ue6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(ue6 ue6Var) {
            super(ue6Var.h());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue6Var};
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
            this.a = ue6Var;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends lf6<zf6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HomePageAlaFriendRoomAdapter b;

        public a(HomePageAlaFriendRoomAdapter homePageAlaFriendRoomAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homePageAlaFriendRoomAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = homePageAlaFriendRoomAdapter;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
            if (r5.getId() == r4.b.c.N().getId()) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
            if (r5.getId() == r4.b.c.O().getId()) goto L6;
         */
        @Override // com.baidu.tieba.lf6
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, zf6 zf6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, zf6Var) == null) {
                int i = 2;
                if (this.b.c.w == view2) {
                    i = 1;
                } else if (view2 == this.b.c.l.getCommentContainer()) {
                    this.b.u(zf6Var, view2);
                    i = 5;
                } else {
                    if (view2 == this.b.c.m.getCommentContainer()) {
                        this.b.u(zf6Var, view2);
                    } else {
                        if (this.b.c.N() != null) {
                        }
                        if (this.b.c.O() != null) {
                        }
                    }
                    i = 0;
                }
                if (i != 0) {
                    pi7.d(zf6Var.a, this.b.a, zf6Var.k(), i);
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

    @Override // com.baidu.tieba.jx5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.e = str;
        }
    }

    public void z(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public final void u(zf6 zf6Var, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, zf6Var, view2) == null) {
            String str2 = "";
            if (zf6Var == null || zf6Var.getThreadData() == null) {
                str = "";
            } else {
                str2 = zf6Var.getThreadData().getTid();
                str = zf6Var.getThreadData().getNid();
            }
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", 5);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_source", zf6Var.m());
            statisticItem.param("nid", str);
            zj5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
    @Override // com.baidu.tieba.tm
    /* renamed from: x */
    public HomePageAlaLiveThreadViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            ue6 ue6Var = new ue6(this.b, this.a);
            this.c = ue6Var;
            ue6Var.E(2);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.c.U(bdUniqueId);
            }
            return new HomePageAlaLiveThreadViewHolder(this.c);
        }
        return (HomePageAlaLiveThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, zf6 zf6Var, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zf6Var, homePageAlaLiveThreadViewHolder})) == null) {
            zf6Var.E(zf6Var.position + 1);
            zf6Var.a.statFloor = zf6Var.k();
            ue6 ue6Var = homePageAlaLiveThreadViewHolder.a;
            if (ue6Var instanceof ix5) {
                ue6Var.b(this.e);
            }
            homePageAlaLiveThreadViewHolder.a.W(i + 1);
            homePageAlaLiveThreadViewHolder.a.l(zf6Var);
            homePageAlaLiveThreadViewHolder.a.n(this.f);
            homePageAlaLiveThreadViewHolder.a.D(this.d);
            pi7.p(zf6Var.a, this.a, zf6Var.k());
            if (zf6Var.getThreadData() != null && zf6Var.getThreadData().getThreadAlaInfo() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_param1", zf6Var.getThreadData().getThreadAlaInfo().live_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
            return homePageAlaLiveThreadViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}

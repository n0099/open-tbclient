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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bx5;
import com.repackage.ey5;
import com.repackage.f07;
import com.repackage.ho;
import com.repackage.p75;
import com.repackage.pi5;
import com.repackage.qi5;
import com.repackage.tx5;
/* loaded from: classes3.dex */
public class HomePageAlaFriendRoomAdapter extends ho<ey5, HomePageAlaLiveThreadViewHolder> implements qi5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public bx5 k;
    public NEGFeedBackView.b l;
    public String m;
    public tx5<ey5> n;

    /* loaded from: classes3.dex */
    public static class HomePageAlaLiveThreadViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public bx5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomePageAlaLiveThreadViewHolder(bx5 bx5Var) {
            super(bx5Var.k());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bx5Var};
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
            this.a = bx5Var;
        }
    }

    /* loaded from: classes3.dex */
    public class a extends tx5<ey5> {
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
            if (r5.getId() == r4.b.k.L().getId()) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0079, code lost:
            if (r5.getId() == r4.b.k.M().getId()) goto L6;
         */
        @Override // com.repackage.tx5
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(View view2, ey5 ey5Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ey5Var) == null) {
                int i = 2;
                if (this.b.k.w == view2) {
                    i = 1;
                } else if (view2 == this.b.k.l.getCommentContainer()) {
                    this.b.b0(ey5Var, view2);
                    i = 5;
                } else {
                    if (view2 == this.b.k.m.getCommentContainer()) {
                        this.b.b0(ey5Var, view2);
                    } else {
                        if (this.b.k.L() != null) {
                        }
                        if (this.b.k.M() != null) {
                        }
                    }
                    i = 0;
                }
                if (i != 0) {
                    f07.d(ey5Var.a, this.b.i, ey5Var.q(), i);
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
        this.l = null;
        this.n = new a(this);
        this.j = tbPageContext;
    }

    public final void b0(ey5 ey5Var, View view2) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, ey5Var, view2) == null) {
            String str2 = "";
            if (ey5Var == null || ey5Var.getThreadData() == null) {
                str = "";
            } else {
                str2 = ey5Var.getThreadData().getTid();
                str = ey5Var.getThreadData().getNid();
            }
            StatisticItem statisticItem = new StatisticItem("c12942");
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", 5);
            statisticItem.param("tid", str2);
            statisticItem.param("obj_source", ey5Var.r());
            statisticItem.param("nid", str);
            p75 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
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
    @Override // com.repackage.ho
    /* renamed from: c0 */
    public HomePageAlaLiveThreadViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            bx5 bx5Var = new bx5(this.j, this.i);
            this.k = bx5Var;
            bx5Var.D(2);
            BdUniqueId bdUniqueId = this.i;
            if (bdUniqueId != null) {
                this.k.S(bdUniqueId);
            }
            return new HomePageAlaLiveThreadViewHolder(this.k);
        }
        return (HomePageAlaLiveThreadViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: d0 */
    public View S(int i, View view2, ViewGroup viewGroup, ey5 ey5Var, HomePageAlaLiveThreadViewHolder homePageAlaLiveThreadViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ey5Var, homePageAlaLiveThreadViewHolder})) == null) {
            ey5Var.I(ey5Var.position + 1);
            ey5Var.a.statFloor = ey5Var.q();
            bx5 bx5Var = homePageAlaLiveThreadViewHolder.a;
            if (bx5Var instanceof pi5) {
                bx5Var.b(this.m);
            }
            homePageAlaLiveThreadViewHolder.a.U(i + 1);
            homePageAlaLiveThreadViewHolder.a.l(ey5Var);
            homePageAlaLiveThreadViewHolder.a.n(this.n);
            homePageAlaLiveThreadViewHolder.a.C(this.l);
            f07.h(ey5Var.a, this.i, ey5Var.q());
            if (ey5Var.getThreadData() != null && ey5Var.getThreadData().getThreadAlaInfo() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
                statisticItem.param("obj_locate", 1);
                statisticItem.param("obj_param1", ey5Var.getThreadData().getThreadAlaInfo().live_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
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

    @Override // com.repackage.qi5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.m = str;
        }
    }
}

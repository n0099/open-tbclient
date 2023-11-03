package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tieba.frs.entelechy.adapter.FrsCardVideoViewHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class au7 extends pp7<hz4, FrsCardVideoViewHolder<zu7>> implements vl6, c18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public a18 n;
    public xl6<ThreadData> o;

    public final String X(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i == 5 ? "3" : i == 10 ? "10" : i == 15 ? "11" : "" : (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.vl6
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends xl6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au7 b;

        public a(au7 au7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = au7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xl6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() == R.id.frame_video) {
                    this.b.W(threadData, "c11718");
                } else if (view2.getId() == R.id.layout_root) {
                    this.b.W(threadData, TbadkCoreStatisticKey.FRS_PHOTO_LIVE_VIEW_PAGER_ITEM);
                } else if (view2.getId() == R.id.image_user || view2.getId() == R.id.pendant_image_user) {
                    this.b.W(threadData, "c10241");
                } else if (view2.getId() == R.id.card_divider_tv) {
                    a48.a(this.b.n, threadData.getRecomReason());
                }
                if (view2.getId() != R.id.card_home_page_normal_thread_user_name && !(view2 instanceof HeadImageView) && !(view2 instanceof HeadPendantView)) {
                    if (view2.getId() == R.id.frame_video) {
                        z08.e(threadData, 4, this.b.mPageId, this.b.n, this.b.u());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            z08.c(threadData, this.b.b.getForum().getId());
                            return;
                        }
                        return;
                    } else if (view2.getId() == R.id.thread_info_commont_container) {
                        z08.e(threadData, 5, this.b.mPageId, this.b.n, this.b.u());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            z08.c(threadData, this.b.b.getForum().getId());
                            return;
                        }
                        return;
                    } else {
                        z08.e(threadData, 1, this.b.mPageId, this.b.n, this.b.u());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            z08.c(threadData, this.b.b.getForum().getId());
                            return;
                        }
                        return;
                    }
                }
                z08.e(threadData, 2, this.b.mPageId, this.b.n, this.b.u());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a18();
        this.o = new a(this);
        this.l = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: Z */
    public FrsCardVideoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            zu7 zu7Var = new zu7(this.l, this.mPageId);
            zu7Var.X(this.mPageId);
            zu7Var.a(this.m);
            return new FrsCardVideoViewHolder(zu7Var);
        }
        return (FrsCardVideoViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.vl6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    public final void W(ThreadData threadData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, threadData, str) != null) || threadData == null) {
            return;
        }
        int insertFloor = threadData.getInsertFloor();
        StatisticItem statisticItem = new StatisticItem(str);
        statisticItem.param("obj_locate", X(insertFloor));
        statisticItem.param("tid", threadData.getTid());
        statisticItem.param("obj_type", 2);
        TiebaStatic.log(statisticItem);
    }

    public final f9a Y(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData != null) {
                f9a f9aVar = new f9a();
                f9aVar.a = X(threadData.getInsertFloor());
                f9aVar.d = this.n.c;
                f9aVar.c = threadData.getTid();
                f9aVar.l = threadData.mRecomAbTag;
                if (threadData.getThreadVideoInfo() != null) {
                    f9aVar.m = threadData.getThreadVideoInfo().video_md5;
                }
                threadData.updateShowStatus();
                return f9aVar;
            }
            return null;
        }
        return (f9a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pp7, com.baidu.tieba.bi
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, hz4 hz4Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, hz4Var, frsCardVideoViewHolder})) == null) {
            if (frsCardVideoViewHolder != null && frsCardVideoViewHolder.a() != null) {
                frsCardVideoViewHolder.a().d0(Y(hz4Var.t));
                frsCardVideoViewHolder.a().k(hz4Var.t);
                frsCardVideoViewHolder.a().m(this.o);
                z08.p(hz4Var.t, this.mPageId, this.n, u());
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null) {
                    z08.n(hz4Var.t, u());
                    z08.o(hz4Var.t, this.b.getForum().getId());
                }
                return frsCardVideoViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.c18
    public a18 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.n;
        }
        return (a18) invokeV.objValue;
    }
}

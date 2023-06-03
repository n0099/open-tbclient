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
/* loaded from: classes6.dex */
public class hh7 extends gd7<l45, FrsCardVideoViewHolder<gi7>> implements co6, mo7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public ko7 n;
    public eo6<ThreadData> o;

    public final String X(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? i == 5 ? "3" : i == 10 ? "10" : i == 15 ? "11" : "" : (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.co6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends eo6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh7 b;

        public a(hh7 hh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.eo6
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
                    cr7.a(this.b.n, threadData.getRecomReason());
                }
                if (view2.getId() != R.id.card_home_page_normal_thread_user_name && !(view2 instanceof HeadImageView) && !(view2 instanceof HeadPendantView)) {
                    if (view2.getId() == R.id.frame_video) {
                        jo7.e(threadData, 4, this.b.mPageId, this.b.n, this.b.t());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            jo7.c(threadData, this.b.b.getForum().getId());
                            return;
                        }
                        return;
                    } else if (view2.getId() == R.id.thread_info_commont_container) {
                        jo7.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            jo7.c(threadData, this.b.b.getForum().getId());
                            return;
                        }
                        return;
                    } else {
                        jo7.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            jo7.c(threadData, this.b.b.getForum().getId());
                            return;
                        }
                        return;
                    }
                }
                jo7.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hh7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.n = new ko7();
        this.o = new a(this);
        this.l = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: Z */
    public FrsCardVideoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            gi7 gi7Var = new gi7(this.l, this.mPageId);
            gi7Var.W(this.mPageId);
            gi7Var.a(this.m);
            return new FrsCardVideoViewHolder(gi7Var);
        }
        return (FrsCardVideoViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.tieba.co6
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

    public final zi9 Y(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData)) == null) {
            if (threadData != null) {
                zi9 zi9Var = new zi9();
                zi9Var.a = X(threadData.getInsertFloor());
                zi9Var.d = this.n.c;
                zi9Var.c = threadData.getTid();
                zi9Var.l = threadData.mRecomAbTag;
                if (threadData.getThreadVideoInfo() != null) {
                    zi9Var.m = threadData.getThreadVideoInfo().video_md5;
                }
                threadData.updateShowStatus();
                return zi9Var;
            }
            return null;
        }
        return (zi9) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.gd7, com.baidu.tieba.in
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, l45 l45Var, FrsCardVideoViewHolder frsCardVideoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, l45Var, frsCardVideoViewHolder})) == null) {
            if (frsCardVideoViewHolder != null && frsCardVideoViewHolder.a() != null) {
                frsCardVideoViewHolder.a().c0(Y(l45Var.t));
                frsCardVideoViewHolder.a().i(l45Var.t);
                frsCardVideoViewHolder.a().k(this.o);
                jo7.p(l45Var.t, this.mPageId, this.n, t());
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null) {
                    jo7.n(l45Var.t, t());
                    jo7.o(l45Var.t, this.b.getForum().getId());
                }
                return frsCardVideoViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.mo7
    public ko7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.n;
        }
        return (ko7) invokeV.objValue;
    }
}

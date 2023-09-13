package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.oy;
import com.baidu.tieba.zy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e18 extends pm<cq6, ThreadCardViewHolder<cq6>> implements o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public boolean d;
    public in e;
    public mp6<cq6> f;

    /* loaded from: classes5.dex */
    public class a extends mp6<cq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e18 b;

        public a(e18 e18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e18Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, cq6 cq6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, cq6Var) == null) && view2 != null && cq6Var != null && cq6Var.getThreadData() != null && !StringUtils.isNull(cq6Var.getThreadData().getTid())) {
                this.b.y(view2, cq6Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e18 a;

        public b(e18 e18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e18Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e18Var;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cnVar instanceof cq6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                cq6 cq6Var = (cq6) cnVar;
                cq6Var.f = 1;
                if (this.a.f != null) {
                    this.a.f.a(threadCardViewHolder.getView(), cq6Var);
                }
                ThreadCardUtils.jumpToPB((b15) cq6Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().p(new zy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e18(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.d = true;
        this.f = new a(this);
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.o56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    public void z(in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, inVar) == null) {
            this.e = inVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: u */
    public ThreadCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            oy.b bVar = new oy.b(this.b.getPageActivity(), false);
            px pxVar = new px(this.b.getPageActivity());
            pxVar.D(this.d);
            pxVar.C(ImageViewerConfig.FROM_CONCERN);
            bVar.h(pxVar);
            oy k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.e);
            k.s(1);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: x */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, cq6 cq6Var, ThreadCardViewHolder<cq6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, cq6Var, threadCardViewHolder})) == null) {
            if (cq6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && cq6Var.a != null) {
                cq6Var.B(cq6Var.position + 1);
                ep6.b().a(new StatisticItem("c13424"));
                threadCardViewHolder.a().r(i);
                if (threadCardViewHolder.a() instanceof n56) {
                    threadCardViewHolder.a().b(this.c);
                }
                threadCardViewHolder.e(cq6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.f);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void y(View view2, cq6 cq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, cq6Var) == null) {
            int id = view2.getId();
            if (view2.getId() == R.id.thread_card_root) {
                q08.b(view2, cq6Var, 2);
            } else if (id == R.id.god_reply_voice_btn) {
                StatisticItem statisticItem = new StatisticItem("c13423");
                statisticItem.param("obj_locate", 4);
                if (cq6Var != null) {
                    statisticItem.param("tid", cq6Var.g);
                    ThreadData threadData = cq6Var.a;
                    if (threadData != null && threadData.getTopAgreePost() != null) {
                        statisticItem.param("pid", cq6Var.a.getTopAgreePost().U());
                    }
                }
                TiebaStatic.log(statisticItem);
            } else if (id == R.id.god_reply_content) {
                StatisticItem statisticItem2 = new StatisticItem("c13423");
                statisticItem2.param("obj_locate", 2);
                if (cq6Var != null) {
                    statisticItem2.param("tid", cq6Var.g);
                    ThreadData threadData2 = cq6Var.a;
                    if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                        statisticItem2.param("pid", cq6Var.a.getTopAgreePost().U());
                    }
                }
                TiebaStatic.log(statisticItem2);
            } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                if (id == R.id.god_reply_agree_view) {
                    StatisticItem statisticItem3 = new StatisticItem("c13423");
                    statisticItem3.param("obj_locate", 5);
                    if (cq6Var != null) {
                        statisticItem3.param("tid", cq6Var.g);
                        ThreadData threadData3 = cq6Var.a;
                        if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                            statisticItem3.param("pid", cq6Var.a.getTopAgreePost().U());
                        }
                    }
                    TiebaStatic.log(statisticItem3);
                } else if ((view2 instanceof TbImageView) && (view2.getTag(R.id.god_reply_image_layout) instanceof Integer)) {
                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                    statisticItem4.param("obj_locate", 3);
                    if (cq6Var != null) {
                        statisticItem4.param("tid", cq6Var.g);
                        ThreadData threadData4 = cq6Var.a;
                        if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                            statisticItem4.param("pid", cq6Var.a.getTopAgreePost().U());
                        }
                    }
                    TiebaStatic.log(statisticItem4);
                }
            } else {
                StatisticItem statisticItem5 = new StatisticItem("c13423");
                statisticItem5.param("obj_locate", 1);
                if (cq6Var != null) {
                    statisticItem5.param("tid", cq6Var.g);
                    ThreadData threadData5 = cq6Var.a;
                    if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                        statisticItem5.param("pid", cq6Var.a.getTopAgreePost().U());
                    }
                }
                TiebaStatic.log(statisticItem5);
            }
        }
    }
}

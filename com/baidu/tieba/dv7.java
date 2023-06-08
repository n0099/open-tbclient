package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.jz;
import com.baidu.tieba.ux;
import com.baidu.tieba.uz;
import com.baidu.tieba.xx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dv7 extends in<wo6, ThreadCardViewHolder<wo6>> implements f56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public bo d;
    public go6<wo6> e;

    /* loaded from: classes5.dex */
    public class a extends go6<wo6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.go6
        /* renamed from: d */
        public void a(View view2, wo6 wo6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, wo6Var) == null) && view2 != null && wo6Var != null && wo6Var.getThreadData() != null && !StringUtils.isNull(wo6Var.getThreadData().getTid())) {
                int id = view2.getId();
                if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                    if (id != R.id.user_avatar && id != R.id.user_name) {
                        if (id == R.id.god_reply_voice_btn) {
                            StatisticItem statisticItem = new StatisticItem("c13423");
                            statisticItem.param("obj_locate", 4);
                            if (wo6Var != null) {
                                statisticItem.param("tid", wo6Var.g);
                                ThreadData threadData = wo6Var.a;
                                if (threadData != null && threadData.getTopAgreePost() != null) {
                                    statisticItem.param("pid", wo6Var.a.getTopAgreePost().O());
                                }
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        } else if (id == R.id.god_reply_content) {
                            StatisticItem statisticItem2 = new StatisticItem("c13423");
                            statisticItem2.param("obj_locate", 2);
                            if (wo6Var != null) {
                                statisticItem2.param("tid", wo6Var.g);
                                ThreadData threadData2 = wo6Var.a;
                                if (threadData2 != null && threadData2.getTopAgreePost() != null) {
                                    statisticItem2.param("pid", wo6Var.a.getTopAgreePost().O());
                                }
                            }
                            TiebaStatic.log(statisticItem2);
                            return;
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            if (id == R.id.god_reply_agree_view) {
                                StatisticItem statisticItem3 = new StatisticItem("c13423");
                                statisticItem3.param("obj_locate", 5);
                                if (wo6Var != null) {
                                    statisticItem3.param("tid", wo6Var.g);
                                    ThreadData threadData3 = wo6Var.a;
                                    if (threadData3 != null && threadData3.getTopAgreePost() != null) {
                                        statisticItem3.param("pid", wo6Var.a.getTopAgreePost().O());
                                    }
                                }
                                TiebaStatic.log(statisticItem3);
                                return;
                            } else if (id == R.id.forum_name_text) {
                                xu7.b(view2, wo6Var, 7);
                                return;
                            } else if (id != R.id.thread_card_title && id != R.id.thread_card_abstract) {
                                if (view2 instanceof TbImageView) {
                                    if (view2.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                        StatisticItem statisticItem4 = new StatisticItem("c13423");
                                        statisticItem4.param("obj_locate", 3);
                                        if (wo6Var != null) {
                                            statisticItem4.param("tid", wo6Var.g);
                                            ThreadData threadData4 = wo6Var.a;
                                            if (threadData4 != null && threadData4.getTopAgreePost() != null) {
                                                statisticItem4.param("pid", wo6Var.a.getTopAgreePost().O());
                                            }
                                        }
                                        TiebaStatic.log(statisticItem4);
                                        return;
                                    }
                                    xu7.b(view2, wo6Var, 6);
                                    return;
                                }
                                return;
                            } else {
                                xu7.b(view2, wo6Var, 2);
                                return;
                            }
                        } else {
                            StatisticItem statisticItem5 = new StatisticItem("c13423");
                            statisticItem5.param("obj_locate", 1);
                            if (wo6Var != null) {
                                statisticItem5.param("tid", wo6Var.g);
                                ThreadData threadData5 = wo6Var.a;
                                if (threadData5 != null && threadData5.getTopAgreePost() != null) {
                                    statisticItem5.param("pid", wo6Var.a.getTopAgreePost().O());
                                }
                            }
                            TiebaStatic.log(statisticItem5);
                            return;
                        }
                    }
                    xu7.b(view2, wo6Var, 1);
                    return;
                }
                xu7.b(view2, wo6Var, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements xx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.xx.b
        public void a(h15 h15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, h15Var, view2) == null) && h15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    h15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    h15Var.objType = 4;
                } else {
                    h15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ux.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ez a;
        public final /* synthetic */ dv7 b;

        public c(dv7 dv7Var, ez ezVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var, ezVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dv7Var;
            this.a = ezVar;
        }

        @Override // com.baidu.tieba.ux.a
        public void a(h15 h15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, h15Var) == null) && h15Var != null && h15Var.getThreadData() != null && h15Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(h15Var.getThreadData().originalThreadData, this.b.mContext, 1);
                xu7.b(this.a.k(), h15Var, 6);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ux.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mz a;
        public final /* synthetic */ dv7 b;

        public d(dv7 dv7Var, mz mzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var, mzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dv7Var;
            this.a = mzVar;
        }

        @Override // com.baidu.tieba.ux.a
        public void a(h15 h15Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, h15Var) == null) && h15Var != null && h15Var.getThreadData() != null && h15Var.getThreadData().originalThreadData != null) {
                ThreadCardUtils.jumpToPB(h15Var.getThreadData().originalThreadData, this.b.mContext, 1);
                xu7.b(this.a.k(), h15Var, 6);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements fo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        public e(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // com.baidu.tieba.fo
        public void b(View view2, vn vnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, vnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (vnVar instanceof wo6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                wo6 wo6Var = (wo6) vnVar;
                wo6Var.f = 1;
                if (this.a.e != null) {
                    this.a.e.a(threadCardViewHolder.getView(), wo6Var);
                }
                ThreadCardUtils.jumpToPB((h15) wo6Var, view2.getContext(), 1, false);
                threadCardViewHolder.a().p(new uz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dv7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.e = new a(this);
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.f56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    public void z(bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, boVar) == null) {
            this.d = boVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: x */
    public ThreadCardViewHolder<wo6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            jz.b bVar = new jz.b(this.b.getPageActivity());
            xx xxVar = new xx(this.b.getPageActivity());
            xxVar.z(this.a);
            xxVar.f(128);
            xxVar.g(1024);
            xxVar.y(new b(this));
            bVar.o(xxVar);
            ez ezVar = new ez(this.b);
            ezVar.r(Boolean.FALSE);
            ezVar.setFrom(ImageViewerConfig.FROM_CONCERN);
            bVar.l().i(vi.g(this.mContext, R.dimen.tbds28));
            bVar.n(ezVar);
            ez ezVar2 = new ez(this.b);
            ezVar2.r(Boolean.TRUE);
            ezVar2.setFrom(ImageViewerConfig.FROM_CONCERN);
            ezVar2.D(HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), HomeGroupUbsUIHelper.getTransmitLRMarginByUbs(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            ezVar2.B(new c(this, ezVar2));
            bVar.h(ezVar2);
            mz mzVar = new mz(this.b.getPageActivity());
            mzVar.r(Boolean.TRUE);
            mzVar.A(new d(this, mzVar));
            bVar.h(mzVar);
            bVar.h(new fy(this.b.getPageActivity()));
            lz lzVar = new lz(this.b.getPageActivity());
            n15 n15Var = new n15();
            n15Var.b = 9;
            n15Var.h = 9;
            lzVar.B(n15Var);
            lzVar.D(9);
            lzVar.I(4);
            lzVar.E(1);
            lzVar.f(32);
            lzVar.C(false);
            bVar.m(lzVar);
            jz k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.d);
            k.s(1);
            ThreadCardViewHolder<wo6> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.i(this.a);
            setOnAdapterItemClickListener(new e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, wo6 wo6Var, ThreadCardViewHolder<wo6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wo6Var, threadCardViewHolder})) == null) {
            if (wo6Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null && wo6Var.a != null) {
                wo6Var.B(wo6Var.position + 1);
                threadCardViewHolder.a().r(i);
                zn6.b().a(wo6Var.d("c12351"));
                threadCardViewHolder.a().b(this.c);
                threadCardViewHolder.t(true, Align.ALIGN_RIGHT_TOP);
                threadCardViewHolder.j();
                threadCardViewHolder.e(wo6Var);
                threadCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.e);
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}

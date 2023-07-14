package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.ay;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.mz;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class bm7 extends yh7<z45, ThreadCardViewHolder<ThreadData>> implements sp6, kt7, t66 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public boolean n;
    public int o;
    public it7 p;
    public up6<ThreadData> q;
    public NEGFeedBackView.b r;

    @Override // com.baidu.tieba.sp6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends up6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm7 b;

        public a(bm7 bm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bm7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.up6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        ht7.e(threadData, 5, this.b.mPageId, this.b.p, this.b.t());
                        fw7.g(threadData, this.b.b, 1);
                    } else if (view2.getId() == R.id.share_num_container) {
                        ht7.e(threadData, 14, this.b.mPageId, this.b.p, this.b.t());
                    } else if (view2.getId() == R.id.img_agree) {
                        ht7.e(threadData, 12, this.b.mPageId, this.b.p, this.b.t());
                    } else if (view2.getId() == R.id.img_disagree) {
                        ht7.e(threadData, 13, this.b.mPageId, this.b.p, this.b.t());
                    } else if (view2 instanceof TbImageView) {
                        if (this.b.q.a instanceof Boolean) {
                            if (((Boolean) this.b.q.a).booleanValue()) {
                                ht7.e(threadData, 1, this.b.mPageId, this.b.p, this.b.t());
                            } else {
                                ht7.e(threadData, 3, this.b.mPageId, this.b.p, this.b.t());
                            }
                        }
                        fw7.g(threadData, this.b.b, 2);
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        ht7.e(threadData, 15, this.b.mPageId, this.b.p, this.b.t());
                        fw7.g(threadData, this.b.b, 1);
                    } else {
                        ht7.e(threadData, 1, this.b.mPageId, this.b.p, this.b.t());
                        fw7.g(threadData, this.b.b, 1);
                    }
                } else {
                    ht7.e(threadData, 2, this.b.mPageId, this.b.p, this.b.t());
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                        return;
                    } else {
                        jt7.k().h(this.b.p, threadData, 7);
                        return;
                    }
                }
                jt7.k().h(this.b.p, threadData, 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(s35 s35Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s35Var, compoundButton, z) == null) {
            }
        }

        public b(bm7 bm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, s35 s35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, s35Var) == null) && arrayList != null && s35Var != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", s35Var.c()).param("tid", s35Var.f()).param("nid", s35Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", s35Var.l).param("weight", s35Var.k).param("ab_tag", s35Var.p).param("extra", s35Var.m).param("card_type", s35Var.o).param(TiebaStatic.Params.OBJ_FLOOR, s35Var.q));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(s35 s35Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s35Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", s35Var.c()).param("tid", s35Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ay.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(bm7 bm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.ay.b
        public void a(t15 t15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, t15Var, view2) == null) && t15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    t15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    t15Var.objType = 4;
                } else {
                    t15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bm7 a;

        public d(bm7 bm7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bm7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bm7Var;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (ynVar instanceof z45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((z45) ynVar).t;
                threadData.objType = 1;
                if (this.a.q != null) {
                    this.a.q.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((t15) threadData, view2.getContext(), this.a.o, false);
                threadCardViewHolder.b().p(new xz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bm7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = true;
        this.o = 3;
        this.p = new it7();
        this.q = new a(this);
        this.r = new b(this);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    @Override // com.baidu.tieba.t66
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.sp6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.yh7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.n = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: X */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            mz.b bVar = new mz.b(this.l.getPageActivity());
            ay ayVar = new ay(this.l.getPageActivity());
            ayVar.r(this.mPageId);
            ayVar.g(4272);
            ayVar.A(new c(this));
            bVar.o(ayVar);
            bVar.n(new vy(this.l.getPageActivity()));
            my myVar = new my(this.l.getPageActivity());
            myVar.F(this.n);
            myVar.E("frs");
            bVar.h(myVar);
            oz ozVar = new oz(this.l.getPageActivity());
            z15 z15Var = new z15();
            if (100 == t().tabType) {
                z15Var.b = 25;
                ozVar.F(19);
            } else {
                z15Var.b = 2;
                ozVar.F(2);
            }
            z15Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !xi.isEmpty(this.b.getForum().getId())) {
                z15Var.j = this.b.getForum().getId();
            }
            ozVar.D(z15Var);
            ozVar.L(this.o);
            ozVar.G(this.o);
            ozVar.g(48);
            bVar.m(ozVar);
            mz j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
            j.s(this.o);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(j);
            threadCardViewHolder.j(this.mPageId);
            setOnAdapterItemClickListener(new d(this));
            threadCardViewHolder.o();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yh7, com.baidu.tieba.ln
    /* renamed from: Y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, z45 z45Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, z45Var, threadCardViewHolder})) == null) {
            if (z45Var != null && threadCardViewHolder != null && threadCardViewHolder.b() != null) {
                super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) z45Var, (z45) threadCardViewHolder);
                if (threadCardViewHolder.b() instanceof s66) {
                    threadCardViewHolder.b().b(this.m);
                }
                xh7.i(threadCardViewHolder.b().f(), this.b);
                int i2 = 0;
                if (z45Var.t.getAuthor() != null && z45Var.t.getAuthor().getUserId() != null && z45Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                } else {
                    z = false;
                }
                if (z45Var.t.isSmartFrsThread() && z45Var.t.getFeedBackReasonMap() != null && !z) {
                    cz q = threadCardViewHolder.q(true);
                    q.s(this.r);
                    q.b(z45Var.t.getNegFeedBackData());
                }
                threadCardViewHolder.t();
                threadCardViewHolder.f(z45Var.t);
                threadCardViewHolder.i(this.q);
                threadCardViewHolder.b().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
                if (this.p != null) {
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null) {
                        i2 = frsViewData.getTopThreadSize();
                    }
                    z45Var.t.statFloor = (z45Var.position + 1) - i2;
                }
                jt7.k().c(this.p, z45Var.t);
                ht7.p(z45Var.t, this.mPageId, this.p, t());
                FrsViewData frsViewData2 = this.b;
                if (frsViewData2 != null && frsViewData2.getForum() != null) {
                    ht7.n(z45Var.t, t());
                    ht7.o(z45Var.t, this.b.getForum().getId());
                }
                if (z45Var != null) {
                    z45Var.t.updateShowStatus();
                }
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.kt7
    public it7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.p;
        }
        return (it7) invokeV.objValue;
    }
}

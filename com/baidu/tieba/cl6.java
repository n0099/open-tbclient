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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.jx;
import com.baidu.tieba.sy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class cl6 extends dh6<bu4, ThreadCardViewHolder<ThreadData>> implements g26, ds6, to5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public String m;
    public boolean n;
    public int o;
    public bs6 p;
    public i26<ThreadData> q;
    public NEGFeedBackView.b r;

    /* loaded from: classes3.dex */
    public class a extends i26<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cl6 b;

        public a(cl6 cl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cl6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i26
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f0924b6 && view2.getId() != R.id.obfuscated_res_0x7f092488) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092194) {
                    as6.e(threadData, 5, this.b.mPageId, this.b.p, this.b.t());
                    mt6.g(threadData, this.b.b, 1);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e97) {
                    as6.e(threadData, 14, this.b.mPageId, this.b.p, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ec6) {
                    as6.e(threadData, 12, this.b.mPageId, this.b.p, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090edf) {
                    as6.e(threadData, 13, this.b.mPageId, this.b.p, this.b.t());
                } else if (view2 instanceof TbImageView) {
                    if (this.b.q.a instanceof Boolean) {
                        if (((Boolean) this.b.q.a).booleanValue()) {
                            as6.e(threadData, 1, this.b.mPageId, this.b.p, this.b.t());
                        } else {
                            as6.e(threadData, 3, this.b.mPageId, this.b.p, this.b.t());
                        }
                    }
                    mt6.g(threadData, this.b.b, 2);
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    as6.e(threadData, 15, this.b.mPageId, this.b.p, this.b.t());
                    mt6.g(threadData, this.b.b, 1);
                } else {
                    as6.e(threadData, 1, this.b.mPageId, this.b.p, this.b.t());
                    mt6.g(threadData, this.b.b, 1);
                }
            } else {
                as6.e(threadData, 2, this.b.mPageId, this.b.p, this.b.t());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b6 || view2.getId() == R.id.obfuscated_res_0x7f092488) {
                cs6.k().h(this.b.p, threadData, 2);
            } else if (view2.getId() != R.id.obfuscated_res_0x7f09054b) {
                cs6.k().h(this.b.p, threadData, 7);
            } else {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(cl6 cl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl6Var};
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
        public void a(ArrayList<Integer> arrayList, String str, vs4 vs4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, vs4Var) == null) || arrayList == null || vs4Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", vs4Var.c()).param("tid", vs4Var.f()).param("nid", vs4Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", vs4Var.l).param("weight", vs4Var.k).param("ab_tag", vs4Var.p).param("extra", vs4Var.m).param("card_type", vs4Var.o).param(TiebaStatic.Params.OBJ_FLOOR, vs4Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(vs4 vs4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vs4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(vs4 vs4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vs4Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", vs4Var.c()).param("tid", vs4Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements jx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(cl6 cl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.jx.b
        public void a(yq4 yq4Var, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, yq4Var, view2) == null) || yq4Var == null) {
                return;
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b6) {
                yq4Var.objType = 3;
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092488) {
                yq4Var.objType = 4;
            } else {
                yq4Var.objType = 1;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cl6 a;

        public d(cl6 cl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cl6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof bu4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((bu4) cdo).t;
                threadData.objType = 1;
                if (this.a.q != null) {
                    this.a.q.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((yq4) threadData, view2.getContext(), this.a.o, false);
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cl6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.p = new bs6();
        this.q = new a(this);
        this.r = new b(this);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: V */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.l.getPageActivity());
            jx jxVar = new jx(this.l.getPageActivity());
            jxVar.u(this.mPageId);
            jxVar.c(4272);
            jxVar.t(new c(this));
            bVar.o(jxVar);
            bVar.n(new ay(this.l.getPageActivity()));
            ux uxVar = new ux(this.l.getPageActivity());
            uxVar.y(this.n);
            uxVar.x("frs");
            bVar.h(uxVar);
            uy uyVar = new uy(this.l.getPageActivity());
            er4 er4Var = new er4();
            if (100 == t().tabType) {
                er4Var.b = 25;
                uyVar.y(19);
            } else {
                er4Var.b = 2;
                uyVar.y(2);
            }
            er4Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !dj.isEmpty(this.b.getForum().getId())) {
                er4Var.j = this.b.getForum().getId();
            }
            uyVar.w(er4Var);
            uyVar.D(this.o);
            uyVar.z(this.o);
            uyVar.c(48);
            bVar.m(uyVar);
            sy j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
            j.r(this.o);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(j);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new d(this));
            threadCardViewHolder.m();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.dh6, com.baidu.tieba.qn
    /* renamed from: W */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bu4 bu4Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bu4Var, threadCardViewHolder})) == null) {
            if (bu4Var == null || threadCardViewHolder == null || threadCardViewHolder.a() == null) {
                return null;
            }
            super.onFillViewHolder(i, view2, viewGroup, bu4Var, threadCardViewHolder);
            if (threadCardViewHolder.a() instanceof so5) {
                threadCardViewHolder.a().b(this.m);
            }
            ch6.i(threadCardViewHolder.a().f(), this.b);
            boolean z = (bu4Var.t.getAuthor() == null || bu4Var.t.getAuthor().getUserId() == null || !bu4Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (bu4Var.t.isSmartFrsThread() && bu4Var.t.getFeedBackReasonMap() != null && !z) {
                iy o = threadCardViewHolder.o(true);
                o.u(this.r);
                o.a(bu4Var.t.getNegFeedBackData());
            }
            threadCardViewHolder.r();
            threadCardViewHolder.e(bu4Var.t);
            threadCardViewHolder.h(this.q);
            threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
            if (this.p != null) {
                FrsViewData frsViewData = this.b;
                bu4Var.t.statFloor = (bu4Var.position + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            cs6.k().c(this.p, bu4Var.t);
            as6.o(bu4Var.t, this.mPageId, this.p, t());
            FrsViewData frsViewData2 = this.b;
            if (frsViewData2 != null && frsViewData2.getForum() != null) {
                as6.m(bu4Var.t, t());
                as6.n(bu4Var.t, this.b.getForum().getId());
            }
            if (bu4Var != null) {
                bu4Var.t.updateShowStatus();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.g26
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.to5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.ds6
    public bs6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.p : (bs6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g26
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.o = i;
        }
    }

    @Override // com.baidu.tieba.dh6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.n = z;
        }
    }
}

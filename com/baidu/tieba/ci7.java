package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
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
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.OriginalThreadCardView;
import com.baidu.tieba.lz;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.wz;
import com.baidu.tieba.zx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class ci7 extends sd7<r45, ThreadCardViewHolder<ThreadData>> implements oo6, bp7, p56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> l;
    public HashSet<String> m;
    public String n;
    public String o;
    public boolean p;
    public int q;
    public zo7 r;
    public qo6<ThreadData> s;
    public NEGFeedBackView.b t;

    @Override // com.baidu.tieba.oo6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends qo6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci7 b;

        public a(ci7 ci7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qo6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if ("c13010".equals(this.b.o)) {
                    TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 3).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.thread_info_commont_container) {
                        yo7.e(threadData, 5, this.b.mPageId, this.b.r, this.b.t());
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            yo7.c(threadData, this.b.b.getForum().getId());
                        }
                    } else if (view2.getId() == R.id.share_num_container) {
                        yo7.e(threadData, 14, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.img_agree) {
                        yo7.e(threadData, 12, this.b.mPageId, this.b.r, this.b.t());
                    } else if (view2.getId() == R.id.img_disagree) {
                        yo7.e(threadData, 13, this.b.mPageId, this.b.r, this.b.t());
                    } else {
                        if (view2 instanceof ThreadGodReplyLayout) {
                            yo7.e(threadData, 15, this.b.mPageId, this.b.r, this.b.t());
                        } else {
                            yo7.e(threadData, 1, this.b.mPageId, this.b.r, this.b.t());
                        }
                        if (this.b.b != null && this.b.b.getForum() != null) {
                            yo7.c(threadData, this.b.b.getForum().getId());
                        }
                    }
                } else {
                    yo7.e(threadData, 2, this.b.mPageId, this.b.r, this.b.t());
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.card_home_page_normal_thread_user_icon) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                    } else {
                        ap7.k().h(this.b.r, threadData, 1);
                    }
                } else {
                    ap7.k().h(this.b.r, threadData, 2);
                }
                if (view2.getId() != R.id.user_name && view2.getId() != R.id.user_avatar) {
                    if (view2 instanceof OriginalThreadCardView) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                        statisticItem.param("obj_type", "3");
                        statisticItem.param("tid", threadData.getTid());
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FRS_TRANSMIT_THREAD);
                statisticItem2.param("obj_type", "1");
                statisticItem2.param("tid", threadData.getTid());
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(k35 k35Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k35Var, compoundButton, z) == null) {
            }
        }

        public b(ci7 ci7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci7Var};
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
        public void a(ArrayList<Integer> arrayList, String str, k35 k35Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, k35Var) == null) && arrayList != null && k35Var != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arrayList.size(); i++) {
                    sb.append(arrayList.get(i) + ",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", k35Var.c()).param("tid", k35Var.f()).param("nid", k35Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", k35Var.l).param("weight", k35Var.k).param("ab_tag", k35Var.p).param("extra", k35Var.m).param("card_type", k35Var.o).param(TiebaStatic.Params.OBJ_FLOOR, k35Var.q));
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(k35 k35Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k35Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", k35Var.c()).param("tid", k35Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements zx.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(ci7 ci7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zx.b
        public void a(l15 l15Var, View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, l15Var, view2) == null) && l15Var != null) {
                if (view2.getId() == R.id.user_name) {
                    l15Var.objType = 3;
                } else if (view2.getId() == R.id.user_avatar) {
                    l15Var.objType = 4;
                } else {
                    l15Var.objType = 1;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ci7 a;

        public d(ci7 ci7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ci7Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (xnVar instanceof r45) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((r45) xnVar).t;
                threadData.objType = 1;
                if (this.a.s != null) {
                    this.a.s.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((l15) threadData, view2.getContext(), this.a.q, false);
                threadCardViewHolder.a().p(new wz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ci7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.p = true;
        this.q = 3;
        this.r = new zo7();
        this.s = new a(this);
        this.t = new b(this);
        this.l = tbPageContext;
        this.mPageId = bdUniqueId2;
    }

    public final void Y(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            if (this.m == null) {
                this.m = new HashSet<>();
            }
            ap7.k().d(threadData, this.m);
        }
    }

    @Override // com.baidu.tieba.p56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.oo6
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.q = i;
        }
    }

    @Override // com.baidu.tieba.sd7
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.baidu.tieba.sd7
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.p = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: Z */
    public ThreadCardViewHolder<ThreadData> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            lz.b bVar = new lz.b(this.l.getPageActivity());
            zx zxVar = new zx(this.l.getPageActivity());
            zxVar.f(4280);
            zxVar.z(this.mPageId);
            zxVar.y(new c(this));
            bVar.o(zxVar);
            qz qzVar = new qz(this.l.getPageActivity());
            bVar.n(qzVar);
            qzVar.z(true);
            qzVar.A(3);
            ly lyVar = new ly(this.l.getPageActivity());
            lyVar.D(this.p);
            lyVar.C("frs");
            bVar.h(lyVar);
            nz nzVar = new nz(this.l.getPageActivity());
            r15 r15Var = new r15();
            if (100 == t().tabType) {
                r15Var.b = 25;
                nzVar.D(19);
            } else {
                r15Var.b = 2;
                nzVar.D(2);
            }
            r15Var.h = 2;
            FrsViewData frsViewData = this.b;
            if (frsViewData != null && frsViewData.getForum() != null && !wi.isEmpty(this.b.getForum().getId())) {
                r15Var.j = this.b.getForum().getId();
            }
            nzVar.B(r15Var);
            nzVar.I(3);
            nzVar.E(2);
            nzVar.f(16);
            bVar.m(nzVar);
            bVar.l().i(xi.g(this.mContext, R.dimen.tbds28));
            lz i = bVar.i();
            i.s(2);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.i(this.mPageId);
            setOnAdapterItemClickListener(new d(this));
            threadCardViewHolder.n();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sd7, com.baidu.tieba.kn
    /* renamed from: a0 */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, r45 r45Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, r45Var, threadCardViewHolder})) == null) {
            if (r45Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                if (threadCardViewHolder.a() instanceof o56) {
                    threadCardViewHolder.a().b(this.n);
                }
                super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) r45Var, (r45) threadCardViewHolder);
                rd7.i(threadCardViewHolder.a().f(), this.b);
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.b.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.b.getForum().getTopic_special_icon_right())) {
                    r45Var.t.setSpecUrl(this.b.getForum().getTopic_special_icon(), this.b.getForum().getTopic_special_icon_right());
                }
                int i2 = 0;
                if (r45Var.t.getAuthor() != null && r45Var.t.getAuthor().getUserId() != null && r45Var.t.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                } else {
                    z = false;
                }
                if (r45Var.t.isSmartFrsThread() && r45Var.t.getFeedBackReasonMap() != null && !z) {
                    threadCardViewHolder.p(true).s(this.t);
                }
                threadCardViewHolder.s();
                if (threadCardViewHolder.a().f() != null) {
                    threadCardViewHolder.a().f().f(32);
                }
                threadCardViewHolder.e(r45Var.t);
                threadCardViewHolder.a().onChangeSkinType(this.l, TbadkCoreApplication.getInst().getSkinType());
                threadCardViewHolder.a().q(this.s);
                if (this.r != null) {
                    FrsViewData frsViewData2 = this.b;
                    if (frsViewData2 != null) {
                        i2 = frsViewData2.getTopThreadSize();
                    }
                    r45Var.t.statFloor = (r45Var.position + 1) - i2;
                }
                ap7.k().c(this.r, r45Var.t);
                Y(r45Var.t);
                r45Var.t.updateShowStatus();
                yo7.p(r45Var.t, this.mPageId, this.r, t());
                FrsViewData frsViewData3 = this.b;
                if (frsViewData3 != null && frsViewData3.getForum() != null) {
                    yo7.n(r45Var.t, t());
                    yo7.o(r45Var.t, this.b.getForum().getId());
                }
                ThreadData threadData = r45Var.t;
                if (threadData != null) {
                    threadData.updateShowStatus();
                }
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.bp7
    public zo7 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return (zo7) invokeV.objValue;
    }
}

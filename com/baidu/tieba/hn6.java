package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.ny;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.yy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class hn6 extends ui6<ThreadData, AutoVideoCardViewHolder<ThreadData>> implements x36, st6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> l;
    public int m;
    public qt6 n;
    public boolean o;
    public z36<ThreadData> p;

    @Override // com.baidu.tieba.x36
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a extends z36<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hn6 b;

        public a(hn6 hn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hn6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z36
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) && view2 != null && threadData != null) {
                if (view2.getId() != R.id.obfuscated_res_0x7f0924f6 && view2.getId() != R.id.obfuscated_res_0x7f0924c8) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f0921e4) {
                        pt6.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090f15) {
                        pt6.e(threadData, 3, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2 instanceof ThreadGodReplyLayout) {
                        pt6.e(threadData, 15, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f091ee2) {
                        pt6.e(threadData, 14, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090ef3) {
                        pt6.e(threadData, 12, this.b.mPageId, this.b.n, this.b.t());
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090f0c) {
                        pt6.e(threadData, 13, this.b.mPageId, this.b.n, this.b.t());
                    } else {
                        pt6.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                    }
                } else {
                    pt6.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
                }
                if (view2.getId() != R.id.obfuscated_res_0x7f0924f6 && view2.getId() != R.id.obfuscated_res_0x7f0924c8) {
                    if (view2.getId() == R.id.obfuscated_res_0x7f0921d0) {
                        if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                            String d = threadData.getTaskInfoData().d();
                            if (StringUtils.isNull(d)) {
                                d = threadData.getTaskInfoData().g();
                            }
                            String str = d;
                            String valueOf = String.valueOf(threadData.getFid());
                            String forum_name = threadData.getForum_name();
                            String i = threadData.getTaskInfoData().i();
                            fp8.c("frs", "CLICK", valueOf, forum_name, i, "tieba.baidu.com/p/" + threadData.getTaskInfoData().i(), str);
                            String g = threadData.getTaskInfoData().g();
                            StatisticItem statisticItem = new StatisticItem("c13329");
                            statisticItem.param("fid", threadData.getFid());
                            statisticItem.param("obj_id", g);
                            TiebaStatic.log(statisticItem);
                        }
                        rt6.k().h(this.b.n, threadData, 1);
                        return;
                    }
                    return;
                }
                rt6.k().h(this.b.n, threadData, 2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hn6 a;

        public b(hn6 hn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hn6Var;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (wnVar instanceof ThreadData) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = (ThreadData) wnVar;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((rr4) threadData, view2.getContext(), this.a.m, false);
                threadCardViewHolder.a().o(new yy.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hn6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, Boolean.valueOf(z)};
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
        this.m = 3;
        this.n = new qt6();
        this.o = false;
        this.p = new a(this);
        this.l = new HashSet();
    }

    @Override // com.baidu.tieba.x36
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.ui6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }

    public final uc8 Q(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            uc8 uc8Var = new uc8();
            String str = "3";
            if (100 == t().tabType) {
                if (!threadData.isFloor5Video()) {
                    str = "25";
                }
                uc8Var.a = str;
            } else {
                if (!threadData.isFloor5Video()) {
                    str = "2";
                }
                uc8Var.a = str;
            }
            uc8Var.d = this.n.c;
            uc8Var.c = threadData.getTid();
            uc8Var.f = threadData.mRecomSource;
            uc8Var.g = threadData.mRecomReason;
            uc8Var.h = threadData.mRecomWeight;
            uc8Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                uc8Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return uc8Var;
        }
        return (uc8) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jn
    /* renamed from: R */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.c.getPageActivity());
            cx cxVar = new cx(this.c.getPageActivity());
            cxVar.f(696);
            cxVar.x(this.mPageId);
            bVar.o(cxVar);
            tx txVar = new tx(this.c.getPageActivity());
            txVar.E(this.o);
            bVar.n(txVar);
            nx nxVar = new nx(this.c.getPageActivity());
            nxVar.B(this.o);
            nxVar.A("frs");
            bVar.h(nxVar);
            py pyVar = new py(this.c.getPageActivity());
            xr4 xr4Var = new xr4();
            if (100 == t().tabType) {
                xr4Var.b = 25;
                pyVar.B(19);
                pyVar.G(14);
            } else {
                xr4Var.b = 2;
                pyVar.B(2);
                pyVar.G(1);
            }
            xr4Var.h = 2;
            pyVar.z(xr4Var);
            pyVar.C(this.m);
            pyVar.f(16);
            bVar.m(pyVar);
            ny i = bVar.i();
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i);
            autoVideoCardViewHolder.i(this.mPageId);
            i.p(this.p);
            i.r(this.m);
            setOnAdapterItemClickListener(new b(this));
            autoVideoCardViewHolder.m();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ui6, com.baidu.tieba.jn
    /* renamed from: S */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ThreadData threadData, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, threadData, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            char c = 1;
            if (this.n != null) {
                int i2 = 0;
                FrsViewData frsViewData = this.b;
                if (frsViewData != null) {
                    i2 = frsViewData.getTopThreadSize();
                }
                threadData.statFloor = (i + 1) - i2;
            }
            rt6.k().c(this.n, threadData);
            pt6.o(threadData, this.mPageId, this.n, t());
            tu4 taskInfoData = threadData.getTaskInfoData();
            if (taskInfoData != null) {
                String g = taskInfoData.g();
                String d = taskInfoData.d();
                if (StringUtils.isNull(d)) {
                    d = taskInfoData.g();
                }
                String str = d;
                if (this.c.getOrignalPage() instanceof fk6) {
                    fk6 fk6Var = (fk6) this.c.getOrignalPage();
                    if (this.l.add(g)) {
                        String k = fk6Var.k();
                        String c2 = fk6Var.c();
                        String i3 = taskInfoData.i();
                        fp8.c("frs", "VIEW_TRUE", k, c2, i3, "tieba.baidu.com/p/" + threadData.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", threadData.getFid());
                statisticItem.param("tid", threadData.getTid());
                statisticItem.param("obj_id", g);
                statisticItem.param("thread_type", threadData.getThreadType());
                TiebaStatic.log(statisticItem);
            }
            if (threadData != null) {
                threadData.updateShowStatus();
                if (threadData.getThreadVideoInfo() != null) {
                    c = 2;
                }
                if (c == 2) {
                    autoVideoCardViewHolder.u(Q(threadData));
                }
                autoVideoCardViewHolder.a().f().f(32);
                autoVideoCardViewHolder.e(threadData);
                autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.a().p(this.p);
                ti6.i(autoVideoCardViewHolder.a().f(), this.b);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.st6
    public qt6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.n;
        }
        return (qt6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ui6
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.v();
            this.l.clear();
        }
    }
}

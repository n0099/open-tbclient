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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.dz;
import com.baidu.tieba.sy;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class bl6 extends qg6<ot4, AutoVideoCardViewHolder<ThreadData>> implements t16, pr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> l;
    public int m;
    public nr6 n;
    public boolean o;
    public v16<ThreadData> p;

    /* loaded from: classes3.dex */
    public class a extends v16<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bl6 b;

        public a(bl6 bl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bl6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.v16
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) || view2 == null || threadData == null) {
                return;
            }
            if (view2.getId() != R.id.obfuscated_res_0x7f0924b4 && view2.getId() != R.id.obfuscated_res_0x7f092486) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092192) {
                    mr6.e(threadData, 5, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ee8) {
                    mr6.e(threadData, 3, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2 instanceof ThreadGodReplyLayout) {
                    mr6.e(threadData, 15, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f091e95) {
                    mr6.e(threadData, 14, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090ec6) {
                    mr6.e(threadData, 12, this.b.mPageId, this.b.n, this.b.t());
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090edf) {
                    mr6.e(threadData, 13, this.b.mPageId, this.b.n, this.b.t());
                } else {
                    mr6.e(threadData, 1, this.b.mPageId, this.b.n, this.b.t());
                }
            } else {
                mr6.e(threadData, 2, this.b.mPageId, this.b.n, this.b.t());
            }
            if (view2.getId() == R.id.obfuscated_res_0x7f0924b4 || view2.getId() == R.id.obfuscated_res_0x7f092486) {
                or6.k().h(this.b.n, threadData, 2);
            } else if (view2.getId() == R.id.obfuscated_res_0x7f09217e) {
                if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                    String d = threadData.getTaskInfoData().d();
                    if (StringUtils.isNull(d)) {
                        d = threadData.getTaskInfoData().f();
                    }
                    String str = d;
                    String valueOf = String.valueOf(threadData.getFid());
                    String forum_name = threadData.getForum_name();
                    String g = threadData.getTaskInfoData().g();
                    an8.c("frs", "CLICK", valueOf, forum_name, g, "tieba.baidu.com/p/" + threadData.getTaskInfoData().g(), str);
                    String f = threadData.getTaskInfoData().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", threadData.getFid());
                    statisticItem.param("obj_id", f);
                    TiebaStatic.log(statisticItem);
                }
                or6.k().h(this.b.n, threadData, 1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements no {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bl6 a;

        public b(bl6 bl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bl6Var;
        }

        @Override // com.baidu.tieba.no
        public void b(View view2, Cdo cdo, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, cdo, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (cdo instanceof ot4) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view2.getTag();
                ThreadData threadData = ((ot4) cdo).t;
                threadData.objType = 1;
                if (this.a.p != null) {
                    this.a.p.a(threadCardViewHolder.getView(), threadData);
                }
                ThreadCardUtils.jumpToPB((lq4) threadData, view2.getContext(), this.a.m, false);
                threadCardViewHolder.a().o(new dz.a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bl6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.n = new nr6();
        this.o = false;
        this.p = new a(this);
        this.l = new HashSet();
    }

    public final ma8 Q(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            ma8 ma8Var = new ma8();
            if (100 == t().tabType) {
                ma8Var.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                ma8Var.a = threadData.isFloor5Video() ? "3" : "2";
            }
            ma8Var.d = this.n.c;
            ma8Var.c = threadData.getTid();
            ma8Var.f = threadData.mRecomSource;
            ma8Var.g = threadData.mRecomReason;
            ma8Var.h = threadData.mRecomWeight;
            ma8Var.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                ma8Var.m = threadData.getThreadVideoInfo().video_md5;
            }
            return ma8Var;
        }
        return (ma8) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: R */
    public AutoVideoCardViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            sy.b bVar = new sy.b(this.c.getPageActivity());
            jx jxVar = new jx(this.c.getPageActivity());
            jxVar.c(696);
            jxVar.u(this.mPageId);
            bVar.o(jxVar);
            yx yxVar = new yx(this.c.getPageActivity());
            yxVar.B(this.o);
            bVar.n(yxVar);
            ux uxVar = new ux(this.c.getPageActivity());
            uxVar.y(this.o);
            uxVar.x("frs");
            bVar.h(uxVar);
            uy uyVar = new uy(this.c.getPageActivity());
            rq4 rq4Var = new rq4();
            if (100 == t().tabType) {
                rq4Var.b = 25;
                uyVar.y(19);
                uyVar.D(14);
            } else {
                rq4Var.b = 2;
                uyVar.y(2);
                uyVar.D(1);
            }
            rq4Var.h = 2;
            uyVar.w(rq4Var);
            uyVar.z(this.m);
            uyVar.c(16);
            bVar.m(uyVar);
            sy k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.e);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.i(this.mPageId);
            k.p(this.p);
            k.r(this.m);
            setOnAdapterItemClickListener(new b(this));
            autoVideoCardViewHolder.m();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qg6, com.baidu.tieba.qn
    /* renamed from: S */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ot4 ot4Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ot4Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.n != null) {
                FrsViewData frsViewData = this.b;
                ot4Var.t.statFloor = (i + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            or6.k().c(this.n, ot4Var.t);
            mr6.o(ot4Var.t, this.mPageId, this.n, t());
            mt4 taskInfoData = ot4Var.t.getTaskInfoData();
            if (taskInfoData != null) {
                String f = taskInfoData.f();
                String d = taskInfoData.d();
                if (StringUtils.isNull(d)) {
                    d = taskInfoData.f();
                }
                String str = d;
                if (this.c.getOrignalPage() instanceof bi6) {
                    bi6 bi6Var = (bi6) this.c.getOrignalPage();
                    if (this.l.add(f)) {
                        String d2 = bi6Var.d();
                        String c = bi6Var.c();
                        String g = taskInfoData.g();
                        an8.c("frs", "VIEW_TRUE", d2, c, g, "tieba.baidu.com/p/" + ot4Var.t.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", ot4Var.t.getFid());
                statisticItem.param("tid", ot4Var.t.getTid());
                statisticItem.param("obj_id", f);
                statisticItem.param("thread_type", ot4Var.t.getThreadType());
                TiebaStatic.log(statisticItem);
            }
            if (ot4Var != null) {
                ot4Var.t.updateShowStatus();
                if ((ot4Var.t.getThreadVideoInfo() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.u(Q(ot4Var.t));
                }
                autoVideoCardViewHolder.a().f().c(32);
                autoVideoCardViewHolder.e(ot4Var.t);
                autoVideoCardViewHolder.a().onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.a().p(this.p);
                pg6.i(autoVideoCardViewHolder.a().f(), this.b);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.t16
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.baidu.tieba.pr6
    public nr6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : (nr6) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t16
    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.qg6
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.o = z;
        }
    }

    @Override // com.baidu.tieba.qg6
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.v();
            this.l.clear();
        }
    }
}

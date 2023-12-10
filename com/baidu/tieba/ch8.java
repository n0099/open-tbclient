package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.CardLinkageManager;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.cu;
import com.baidu.tieba.nu;
import com.baidu.tieba.os;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ch8 extends ci<en6, AutoVideoCardViewHolder<en6>> implements e26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public di8 c;
    public String d;
    public vi e;
    public ku f;
    public mm6<en6> g;

    /* loaded from: classes5.dex */
    public class a extends mm6<en6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch8 b;

        public a(ch8 ch8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ch8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, en6 en6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, en6Var) == null) {
                em6.b().d(true);
                c26.c().h("page_recommend", "show_");
                if (this.b.c != null && en6Var != null && en6Var.getThreadData() != null && !StringUtils.isNull(en6Var.getThreadData().getTid())) {
                    if (en6Var.getThreadData().middle_page_num > 0) {
                        TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(en6Var.G(en6Var.getThreadData())));
                        return;
                    }
                    if ((view2.getTag() instanceof String) && !yf8.b(JavaTypesHelper.toLong(en6Var.getThreadData().getTid(), 0L))) {
                        yf8.a(JavaTypesHelper.toLong(en6Var.getThreadData().getTid(), 0L));
                        this.b.c.e(JavaTypesHelper.toLong(en6Var.getThreadData().getTid(), 0L), en6Var.u(), en6Var.k(), en6Var.h(), en6Var.c(), JavaTypesHelper.toInt((String) view2.getTag(), 1), DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, en6Var.getThreadData().getBaijiahaoData());
                    }
                    this.b.B(view2, en6Var);
                    TbSingleton.getInstance().saveHomeRecommendItemClickTime();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements os.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ku a;
        public final /* synthetic */ ch8 b;

        public b(ch8 ch8Var, ku kuVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch8Var, kuVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ch8Var;
            this.a = kuVar;
        }

        @Override // com.baidu.tieba.os.a
        public void a(fw4 fw4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, fw4Var) != null) || fw4Var == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (fw4Var instanceof en6) {
                fw4Var.objType = 5;
                ThreadCardUtils.jumpToPB(fw4Var, this.b.mContext, 2, false, computeViewArea);
                return;
            }
            ThreadCardUtils.jumpToPB(fw4Var, this.b.mContext, 2, false, computeViewArea);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements zi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch8 a;

        public c(ch8 ch8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch8Var;
        }

        @Override // com.baidu.tieba.zi
        public void b(View view2, pi piVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, piVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (piVar instanceof en6) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                AutoVideoCardViewHolder autoVideoCardViewHolder = (AutoVideoCardViewHolder) view2.getTag();
                en6 en6Var = (en6) piVar;
                en6Var.f = 1;
                if (this.a.g != null) {
                    this.a.g.a(autoVideoCardViewHolder.getView(), en6Var);
                }
                if (!s36.a(view2.getContext(), en6Var.getThreadData())) {
                    ThreadCardUtils.jumpToPB((fw4) en6Var, view2.getContext(), 2, false, ss.a((vi) viewGroup, view2, i));
                    autoVideoCardViewHolder.a().q(new nu.a(1));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ch8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.g = new a(this);
        this.b = tbPageContext;
        C();
    }

    public void F(di8 di8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, di8Var) == null) {
            this.c = di8Var;
        }
    }

    public void G(vi viVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, viVar) == null) {
            this.e = viVar;
        }
    }

    @Override // com.baidu.tieba.e26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.d = str;
        }
    }

    public final hea A(en6 en6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, en6Var)) == null) {
            if (en6Var != null) {
                hea heaVar = new hea();
                heaVar.a = "1";
                heaVar.c = en6Var.g;
                if (en6Var.getThreadData() != null) {
                    heaVar.d = String.valueOf(en6Var.getThreadData().getFid());
                    heaVar.v = en6Var.getThreadData().getNid();
                    if (en6Var.getThreadData().getThreadVideoInfo() != null) {
                        heaVar.m = en6Var.getThreadData().getThreadVideoInfo().video_md5;
                        heaVar.p = String.valueOf(en6Var.getThreadData().getThreadVideoInfo().is_vertical);
                    }
                }
                heaVar.k = en6Var.e();
                heaVar.f = en6Var.k();
                heaVar.l = en6Var.c();
                heaVar.h = en6Var.u();
                heaVar.e = TbadkCoreApplication.getCurrentAccount();
                heaVar.q = String.valueOf(en6Var.h());
                if (en6Var.getThreadData() != null && en6Var.getThreadData().getBaijiahaoData() != null) {
                    heaVar.t = en6Var.getThreadData().getBaijiahaoData().oriUgcNid;
                    heaVar.u = en6Var.getThreadData().getBaijiahaoData().oriUgcVid;
                    return heaVar;
                }
                return heaVar;
            }
            return null;
        }
        return (hea) invokeL.objValue;
    }

    public final void B(View view2, en6 en6Var) {
        ku kuVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, en6Var) == null) && (kuVar = this.f) != null && kuVar.s() != null && this.f.s().getMainView() != null) {
            if (view2.getId() == this.f.s().getMainView().getId()) {
                CardLinkageManager.INSTANCE.cancelHighLight(this.e, en6Var);
                ii8.d(en6Var.a, this.a, en6Var.h(), 4);
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(en6Var.I()));
                ii8.c(en6Var.a, en6Var.k(), en6Var.h(), 2);
            } else if (view2.getId() == R.id.thread_card_root) {
                TbSingleton.getInstance().setCurrentClickTime(TiebaStatic.logWithBackTime(en6Var.G(en6Var.a)));
                ii8.c(en6Var.a, en6Var.k(), en6Var.h(), 1);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            en6.V = "c10708";
            en6.W = "c10735";
            en6.X = "c10709";
            en6.Y = "c10734";
            en6.Z = "c11929";
            en6.a0 = "c11928";
            en6.b0 = "c10756";
        }
    }

    public void onPause() {
        ku kuVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (kuVar = this.f) != null) {
            kuVar.x();
        }
    }

    public void onResume() {
        ku kuVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (kuVar = this.f) != null) {
            kuVar.y();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: D */
    public AutoVideoCardViewHolder<en6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            cu.b bVar = new cu.b(this.b.getPageActivity(), false);
            ri8 ri8Var = new ri8(this.b.getPageActivity());
            ri8Var.z(new b(this, ri8Var));
            this.f = ri8Var;
            ri8Var.o(this.a);
            this.f.setFrom("index");
            this.f.setStageType("2001");
            bVar.n(this.f);
            cu k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.e);
            AutoVideoCardViewHolder<en6> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(k);
            autoVideoCardViewHolder.i(this.a);
            k.r(this.g);
            k.t(2);
            setOnAdapterItemClickListener(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: E */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, en6 en6Var, AutoVideoCardViewHolder<en6> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, en6Var, autoVideoCardViewHolder})) == null) {
            if (en6Var == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            en6Var.B(en6Var.position + 1);
            en6Var.a.statFloor = en6Var.h();
            autoVideoCardViewHolder.a().s(i);
            en6Var.f1091T = 0;
            em6.b().a(en6Var.s());
            autoVideoCardViewHolder.z(A(en6Var));
            if (autoVideoCardViewHolder.a() != null) {
                autoVideoCardViewHolder.a().b(this.d);
            }
            autoVideoCardViewHolder.e(en6Var);
            autoVideoCardViewHolder.a().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.a().r(this.g);
            ii8.p(en6Var.a, this.a, en6Var.h());
            ii8.o(en6Var.a, en6Var.k(), en6Var.h());
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}

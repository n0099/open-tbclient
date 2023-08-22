package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.ny;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a58 extends om<h98, ThreadCardViewHolder<h98>> implements s46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public NEGFeedBackView.NEGFeedbackEventCallback d;

    /* loaded from: classes5.dex */
    public class a implements ln {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a58 a;

        public a(a58 a58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a58Var;
        }

        @Override // com.baidu.tieba.ln
        public void b(View view2, bn bnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, bnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (bnVar instanceof h98) && (view2.getTag() instanceof ThreadCardViewHolder)) {
                h98 h98Var = (h98) bnVar;
                if (h98Var != null && h98Var.Z != 1) {
                    TiebaStatic.log(new StatisticItem("c13351").param("topic_id", h98Var.S).param("obj_locate", h98Var.R));
                }
                if (h98Var != null && h98Var.Z == 1) {
                    TiebaStatic.log(new StatisticItem("c13449").param("topic_id", h98Var.S));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(this.a.mContext, h98Var.S)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a58(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.s46
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.c = str;
        }
    }

    public void x(NEGFeedBackView.NEGFeedbackEventCallback nEGFeedbackEventCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, nEGFeedbackEventCallback) == null) {
            this.d = nEGFeedbackEventCallback;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: t */
    public ThreadCardViewHolder<h98> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            ny.b bVar = new ny.b(this.b.getPageActivity(), false);
            x68 x68Var = new x68(this.mContext, this.b);
            x68Var.u(this.mPageId);
            bVar.n(x68Var);
            bVar.l().c(0);
            bVar.l().f(0);
            bVar.l().g(0);
            bVar.l().j(0);
            bVar.l().i(0);
            ny j = bVar.j(BaseCardInfo.SupportType.FULL, viewGroup);
            j.s(2);
            ThreadCardViewHolder<h98> threadCardViewHolder = new ThreadCardViewHolder<>(j);
            threadCardViewHolder.j(this.a);
            setOnAdapterItemClickListener(new a(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, h98 h98Var, ThreadCardViewHolder<h98> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, h98Var, threadCardViewHolder})) == null) {
            if (h98Var != null && threadCardViewHolder != null && threadCardViewHolder.getView() != null) {
                TiebaStatic.log(new StatisticItem("c13448").param("topic_id", h98Var.S));
                threadCardViewHolder.b().r(i);
                threadCardViewHolder.b().b(this.c);
                threadCardViewHolder.q(false).setNegEventCallback(this.d);
                threadCardViewHolder.f(h98Var);
                threadCardViewHolder.b().onChangeSkinType(this.b, TbadkCoreApplication.getInst().getSkinType());
                return threadCardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}

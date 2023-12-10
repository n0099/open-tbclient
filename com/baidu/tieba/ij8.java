package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ij8 extends ci<cn6, CardViewHolder<vl6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public vl6 d;
    public NEGFeedBackView.NEGFeedbackEventCallback e;
    public mm6<cn6> f;

    /* loaded from: classes6.dex */
    public class a extends mm6<cn6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ij8 b;

        public a(ij8 ij8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ij8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, cn6 cn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, cn6Var) == null) {
                int i = 2;
                if (this.b.d.w == view2) {
                    i = 1;
                } else if (view2 == this.b.d.l.getCommentContainer()) {
                    i = 5;
                } else if ((this.b.d.N() == null || view2.getId() != this.b.d.N().getId()) && (this.b.d.P() == null || view2.getId() != this.b.d.P().getId())) {
                    i = 0;
                }
                if (i != 0) {
                    ii8.d(cn6Var.a, this.b.a, cn6Var.h(), i);
                }
                cj8.k(view2, cn6Var, this.b.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ij8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, str};
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
        this.e = null;
        this.f = new a(this);
        this.b = tbPageContext;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: x */
    public CardViewHolder<vl6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            vl6 vl6Var = new vl6(this.b, this.a);
            this.d = vl6Var;
            vl6Var.G(2);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.d.a0(bdUniqueId);
            }
            return new CardViewHolder<>(this.d);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, cn6 cn6Var, CardViewHolder<vl6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, cn6Var, cardViewHolder})) == null) {
            cn6Var.B(cn6Var.position + 1);
            cn6Var.a.statFloor = cn6Var.h();
            vl6 a2 = cardViewHolder.a();
            a2.d0(i + 1);
            a2.j(cn6Var);
            a2.l(this.f);
            a2.F(this.e);
            ii8.p(cn6Var.a, this.a, cn6Var.h());
            cj8.r(cn6Var, this.c);
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}

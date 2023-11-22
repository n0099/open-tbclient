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
public class gg8 extends bi<nm6, CardViewHolder<hl6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public String c;
    public hl6 d;
    public NEGFeedBackView.NEGFeedbackEventCallback e;
    public yl6<nm6> f;

    /* loaded from: classes6.dex */
    public class a extends yl6<nm6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gg8 b;

        public a(gg8 gg8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gg8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gg8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yl6
        /* renamed from: d */
        public void a(View view2, nm6 nm6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, nm6Var) == null) {
                int i = 2;
                if (this.b.d.w == view2) {
                    i = 1;
                } else if (view2 == this.b.d.l.getCommentContainer()) {
                    i = 5;
                } else if ((this.b.d.N() == null || view2.getId() != this.b.d.N().getId()) && (this.b.d.P() == null || view2.getId() != this.b.d.P().getId())) {
                    i = 0;
                }
                if (i != 0) {
                    gf8.d(nm6Var.a, this.b.a, nm6Var.h(), i);
                }
                ag8.k(view2, nm6Var, this.b.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gg8(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
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
    @Override // com.baidu.tieba.bi
    /* renamed from: x */
    public CardViewHolder<hl6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            hl6 hl6Var = new hl6(this.b, this.a);
            this.d = hl6Var;
            hl6Var.G(2);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.d.a0(bdUniqueId);
            }
            return new CardViewHolder<>(this.d);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, nm6 nm6Var, CardViewHolder<hl6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, nm6Var, cardViewHolder})) == null) {
            nm6Var.A(nm6Var.position + 1);
            nm6Var.a.statFloor = nm6Var.h();
            hl6 a2 = cardViewHolder.a();
            a2.d0(i + 1);
            a2.k(nm6Var);
            a2.m(this.f);
            a2.F(this.e);
            gf8.p(nm6Var.a, this.a, nm6Var.h());
            ag8.r(nm6Var, this.c);
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}

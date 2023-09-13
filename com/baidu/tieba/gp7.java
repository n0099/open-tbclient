package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.ro6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gp7 extends pm<wx6, CardViewHolder<ro6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public ro6 b;
    public mp6 c;
    public String d;

    /* loaded from: classes6.dex */
    public class a implements ro6.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp7 a;

        public a(gp7 gp7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gp7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gp7Var;
        }

        @Override // com.baidu.tieba.ro6.a
        public void a(View view2, BaseCardInfo baseCardInfo) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, baseCardInfo) == null) && this.a.c != null) {
                this.a.c.a(view2, baseCardInfo);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gp7(TbPageContext tbPageContext, String str) {
        super(tbPageContext.getPageActivity(), wx6.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
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
        this.a = tbPageContext;
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: t */
    public CardViewHolder<ro6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.b = new ro6(this.a, this.d);
            return new CardViewHolder<>(this.b);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public void x(mp6 mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mp6Var) == null) {
            this.c = mp6Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, wx6 wx6Var, CardViewHolder<ro6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, wx6Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            cardViewHolder.a().i(wx6Var);
            cardViewHolder.a().j(this.a, TbadkCoreApplication.getInst().getSkinType());
            cardViewHolder.a().u(new a(this));
            return cardViewHolder.a().h();
        }
        return (View) invokeCommon.objValue;
    }
}

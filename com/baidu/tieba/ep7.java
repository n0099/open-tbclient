package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ep7 extends pm<tx6, CardViewHolder<po6>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public po6 b;
    public String c;
    public String d;
    public mp6 e;

    /* loaded from: classes5.dex */
    public class a extends mp6<tx6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ep7 b;

        public a(ep7 ep7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ep7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ep7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mp6
        /* renamed from: d */
        public void a(View view2, tx6 tx6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, tx6Var) == null) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 2).param("fid", this.b.c));
                this.b.u(view2, tx6Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ep7(TbPageContext tbPageContext, String str, String str2) {
        super(tbPageContext.getPageActivity(), tx6.b);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str, str2};
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
        this.c = str;
        this.d = str2;
        this.a = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: x */
    public CardViewHolder<po6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            this.b = new po6(this.a, this.c, this.d);
            return new CardViewHolder<>(this.b);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public void z(mp6 mp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mp6Var) == null) {
            this.e = mp6Var;
        }
    }

    public final void u(View view2, tx6 tx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, tx6Var) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.a.getPageActivity()).createFromThreadCfg(tx6Var.getThreadData(), null, xo6.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(tx6Var.getThreadData().getFid()));
            createFromThreadCfg.setForumName(tx6Var.getThreadData().getForum_name());
            createFromThreadCfg.setStartFrom(0);
            xo6.a(tx6Var.getThreadData().getTid());
            this.a.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
            mp6 mp6Var = this.e;
            if (mp6Var != null) {
                mp6Var.a(view2, tx6Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: y */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, tx6 tx6Var, CardViewHolder<po6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, tx6Var, cardViewHolder})) == null) {
            if (cardViewHolder.a() == null) {
                return null;
            }
            cardViewHolder.a().i(tx6Var);
            cardViewHolder.a().j(this.a, TbadkCoreApplication.getInst().getSkinType());
            cardViewHolder.a().k(new a(this));
            return cardViewHolder.a().h();
        }
        return (View) invokeCommon.objValue;
    }
}

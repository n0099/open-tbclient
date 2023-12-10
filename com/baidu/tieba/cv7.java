package com.baidu.tieba;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class cv7 extends ci<ev7, CardViewHolder<zu7>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public zu7 b;
    public boolean c;
    public List<zu7> d;
    public Handler e;
    public yu7 f;
    public boolean g;
    public mm6<ev7> h;

    /* loaded from: classes5.dex */
    public class a extends mm6<ev7> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv7 b;

        public a(cv7 cv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cv7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, ev7 ev7Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, ev7Var) == null) && view2 != null && ev7Var != null) {
                if ((view2.getId() == R.id.video_container || view2.getId() == R.id.obfuscated_res_0x7f0929a4 || view2.getId() == R.id.obfuscated_res_0x7f09184e) && view2.getTag() != null && (view2.getTag() instanceof zu7)) {
                    zu7 zu7Var = (zu7) view2.getTag();
                    if (this.b.b != null && this.b.b != zu7Var && (view2.getId() == R.id.video_container || view2.getId() == R.id.obfuscated_res_0x7f09184e)) {
                        this.b.b.S();
                    }
                    if (this.b.b != zu7Var) {
                        this.b.b = zu7Var;
                    }
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f092685) {
                    StatisticItem statisticItem = new StatisticItem("c12411");
                    statisticItem.param("fid", ev7Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090182) {
                    StatisticItem statisticItem2 = new StatisticItem("c12414");
                    statisticItem2.param("fid", ev7Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem2);
                } else if (view2.getId() != R.id.thread_info_commont_container && view2.getId() != R.id.card_root_view) {
                    if (view2.getId() != R.id.obfuscated_res_0x7f092928 && view2.getId() != R.id.user_name) {
                        if (view2.getId() == R.id.obfuscated_res_0x7f090310) {
                            StatisticItem statisticItem3 = new StatisticItem("c12413");
                            statisticItem3.param("fid", ev7Var.a);
                            if (TbadkCoreApplication.isLogin()) {
                                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                            }
                            TiebaStatic.log(statisticItem3);
                            return;
                        } else if (view2.getId() == R.id.obfuscated_res_0x7f09184e) {
                            StatisticItem statisticItem4 = new StatisticItem("c12416");
                            statisticItem4.param("fid", ev7Var.a);
                            if (TbadkCoreApplication.isLogin()) {
                                statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                            }
                            TiebaStatic.log(statisticItem4);
                            return;
                        } else {
                            return;
                        }
                    }
                    StatisticItem statisticItem5 = new StatisticItem("c12412");
                    statisticItem5.param("fid", ev7Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem5);
                } else {
                    StatisticItem statisticItem6 = new StatisticItem("c12415");
                    statisticItem6.param("fid", ev7Var.a);
                    if (TbadkCoreApplication.isLogin()) {
                        statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                    }
                    TiebaStatic.log(statisticItem6);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cv7 a;

        public b(cv7 cv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cv7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !this.a.c) {
                return;
            }
            this.a.c = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cv7(TbPageContext<?> tbPageContext, yu7 yu7Var, boolean z) {
        super(tbPageContext.getPageActivity().getBaseContext(), ev7.u);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, yu7Var, Boolean.valueOf(z)};
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
        this.d = new ArrayList();
        this.e = new Handler();
        this.h = new a(this);
        this.a = tbPageContext;
        this.f = yu7Var;
        this.g = z;
    }

    public void A(Configuration configuration) {
        zu7 zu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) && (zu7Var = this.b) != null) {
            this.c = true;
            zu7Var.I(configuration);
            if (configuration.orientation == 1) {
                this.e.postDelayed(new b(this), 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: B */
    public CardViewHolder<zu7> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            zu7 zu7Var = new zu7(this.a, this.g);
            zu7Var.l(this.h);
            this.d.add(zu7Var);
            return new CardViewHolder<>(zu7Var);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    public boolean D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            zu7 zu7Var = this.b;
            if (zu7Var == null) {
                return false;
            }
            return zu7Var.K(i);
        }
        return invokeI.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: C */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ev7 ev7Var, CardViewHolder<zu7> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ev7Var, cardViewHolder})) == null) {
            if (ev7Var != null && cardViewHolder != null) {
                if (!this.c) {
                    cardViewHolder.a().H(ev7Var, i, this.f);
                    cardViewHolder.a().F = i;
                }
                return cardViewHolder.getView();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public void E() {
        zu7 zu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (zu7Var = this.b) == null) {
            return;
        }
        zu7Var.L();
    }

    public void F() {
        zu7 zu7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (zu7Var = this.b) == null) {
            return;
        }
        zu7Var.S();
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (zu7 zu7Var : this.d) {
                if (zu7Var != null) {
                    zu7Var.J();
                }
            }
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            zu7 zu7Var = this.b;
            if (zu7Var != null) {
                return zu7Var.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}

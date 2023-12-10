package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout;
import com.baidu.tieba.frs.gamepaltform.GameRankListViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fz7 extends hs7<q98, GameRankListViewHolder> implements x38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v38 l;

    /* loaded from: classes6.dex */
    public class a implements GameRankHorizontalLayout.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fz7 a;

        public a(fz7 fz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fz7Var;
        }

        @Override // com.baidu.tieba.frs.gamepaltform.GameRankHorizontalLayout.b
        public void a(p98 p98Var, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, p98Var, i) != null) || p98Var == null) {
                return;
            }
            if (this.a.l != null) {
                TiebaStatic.log(new StatisticItem("c12105").param("fid", this.a.l.c).param("obj_locate", i + 1));
            }
            if (!StringUtils.isNull(p98Var.c())) {
                BrowserHelper.startWebActivity(this.a.c.getPageActivity(), p98Var.c());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(fz7 fz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                sharedPrefHelper.putString("game_rank_list_info", System.currentTimeMillis() + ",7");
                SharedPrefHelper.getInstance().putInt("game_rank_list_show_times", 0);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921005));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fz7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new v38();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: J */
    public GameRankListViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return new GameRankListViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d03eb, (ViewGroup) null));
        }
        return (GameRankListViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hs7, com.baidu.tieba.ci
    /* renamed from: K */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, q98 q98Var, GameRankListViewHolder gameRankListViewHolder) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, q98Var, gameRankListViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) q98Var, (q98) gameRankListViewHolder);
            if (q98Var == null) {
                return null;
            }
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            if (this.l != null) {
                TiebaStatic.log(new StatisticItem("c12104").param("fid", this.l.c));
            }
            GameRankHorizontalLayout gameRankHorizontalLayout = gameRankListViewHolder.a;
            if (gameRankHorizontalLayout != null) {
                gameRankHorizontalLayout.setData(q98Var);
                gameRankListViewHolder.a.setOnCardClickListener(new a(this));
            }
            TextView textView = gameRankListViewHolder.b;
            if (textView != null) {
                textView.setOnClickListener(new b(this));
            }
            BDLayoutMode layoutMode = this.c.getLayoutMode();
            if (this.f == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.c.getLayoutMode().onModeChanged(view2);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.x38
    public v38 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.l;
        }
        return (v38) invokeV.objValue;
    }
}

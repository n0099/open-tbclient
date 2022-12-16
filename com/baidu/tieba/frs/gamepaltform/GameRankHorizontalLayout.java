package com.baidu.tieba.frs.gamepaltform;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ly6;
import com.baidu.tieba.my6;
import com.baidu.tieba.ry4;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GameRankHorizontalLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public b b;

    /* loaded from: classes4.dex */
    public interface b {
        void a(ly6 ly6Var, int i);
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly6 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ GameRankHorizontalLayout c;

        public a(GameRankHorizontalLayout gameRankHorizontalLayout, ly6 ly6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRankHorizontalLayout, ly6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gameRankHorizontalLayout;
            this.a = ly6Var;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.b != null) {
                this.c.b.a(this.a, this.b);
                if (ry4.l().m("game_rank_list_show_times", 0) != 0) {
                    ry4.l().x("game_rank_list_show_times", 0);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRankHorizontalLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRankHorizontalLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRankHorizontalLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        b(context);
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setFillViewport(true);
            setHorizontalScrollBarEnabled(false);
            LinearLayout linearLayout = new LinearLayout(context);
            this.a = linearLayout;
            addView(linearLayout, -1, -1);
        }
    }

    public void setOnCardClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.b = bVar;
        }
    }

    public final View c(ly6 ly6Var, int i) {
        InterceptResult invokeLI;
        RoundAngleRelativeLayout roundAngleRelativeLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ly6Var, i)) == null) {
            if (ly6Var == null) {
                return null;
            }
            if (!StringUtils.isNull(ly6Var.b())) {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d037e, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                HeadImageView headImageView = (HeadImageView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f090daf);
                headImageView.setIsRound(true);
                headImageView.K(ly6Var.b(), 10, false);
                ((TbImageView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f092733)).K(ly6Var.b(), 10, false);
            } else {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d037d, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                HeadImageView headImageView2 = (HeadImageView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f090daf);
                headImageView2.setIsRound(true);
                headImageView2.K(ly6Var.f(), 10, false);
                ((TbImageView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f091794)).K(ly6Var.f(), 10, false);
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.user_name)).setText(ly6Var.e());
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f091c09)).setText(ly6Var.g());
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f092588)).setText(getContext().getString(R.string.obfuscated_res_0x7f0f07d1, ly6Var.d()));
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f091c02)).setText(ly6Var.a());
            }
            if (roundAngleRelativeLayout != null) {
                roundAngleRelativeLayout.setOnClickListener(new a(this, ly6Var, i));
            }
            return roundAngleRelativeLayout;
        }
        return (View) invokeLI.objValue;
    }

    public void setData(my6 my6Var) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, my6Var) == null) && (linearLayout = this.a) != null && my6Var != null) {
            linearLayout.removeAllViews();
            if (!ListUtils.isEmpty(my6Var.b())) {
                for (int i = 0; i < my6Var.b().size(); i++) {
                    View c = c(my6Var.b().get(i), i);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(yi.g(getContext(), R.dimen.obfuscated_res_0x7f0702c9), yi.g(getContext(), R.dimen.obfuscated_res_0x7f070267));
                    if (i != 0) {
                        layoutParams.leftMargin = yi.g(getContext(), R.dimen.obfuscated_res_0x7f070302);
                    } else {
                        layoutParams.leftMargin = yi.g(getContext(), R.dimen.obfuscated_res_0x7f070225);
                    }
                    if (i == my6Var.b().size() - 1) {
                        layoutParams.rightMargin = yi.g(getContext(), R.dimen.obfuscated_res_0x7f070225);
                    } else {
                        layoutParams.rightMargin = 0;
                    }
                    c.setLayoutParams(layoutParams);
                    this.a.addView(c);
                }
            }
        }
    }
}

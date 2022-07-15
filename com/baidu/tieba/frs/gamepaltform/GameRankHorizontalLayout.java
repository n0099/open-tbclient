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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.pi;
import com.repackage.pr6;
import com.repackage.qr6;
import com.repackage.xt4;
/* loaded from: classes3.dex */
public class GameRankHorizontalLayout extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public b b;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pr6 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ GameRankHorizontalLayout c;

        public a(GameRankHorizontalLayout gameRankHorizontalLayout, pr6 pr6Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameRankHorizontalLayout, pr6Var, Integer.valueOf(i)};
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
            this.a = pr6Var;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.c.b == null) {
                return;
            }
            this.c.b.a(this.a, this.b);
            if (xt4.k().l("game_rank_list_show_times", 0) != 0) {
                xt4.k().w("game_rank_list_show_times", 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(pr6 pr6Var, int i);
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

    public final View c(pr6 pr6Var, int i) {
        InterceptResult invokeLI;
        RoundAngleRelativeLayout roundAngleRelativeLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pr6Var, i)) == null) {
            if (pr6Var == null) {
                return null;
            }
            if (!StringUtils.isNull(pr6Var.b())) {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d036e, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                HeadImageView headImageView = (HeadImageView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f090cd8);
                headImageView.setIsRound(true);
                headImageView.J(pr6Var.b(), 10, false);
                ((TbImageView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f0924df)).J(pr6Var.b(), 10, false);
            } else {
                roundAngleRelativeLayout = (RoundAngleRelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d036d, (ViewGroup) null);
                roundAngleRelativeLayout.setRadius(4.0f);
                HeadImageView headImageView2 = (HeadImageView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f090cd8);
                headImageView2.setIsRound(true);
                headImageView2.J(pr6Var.f(), 10, false);
                ((TbImageView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f09161c)).J(pr6Var.f(), 10, false);
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f09232d)).setText(pr6Var.e());
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f091a55)).setText(pr6Var.g());
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f09233c)).setText(getContext().getString(R.string.obfuscated_res_0x7f0f0794, pr6Var.d()));
                ((TextView) roundAngleRelativeLayout.findViewById(R.id.obfuscated_res_0x7f091a4e)).setText(pr6Var.a());
            }
            if (roundAngleRelativeLayout != null) {
                roundAngleRelativeLayout.setOnClickListener(new a(this, pr6Var, i));
            }
            return roundAngleRelativeLayout;
        }
        return (View) invokeLI.objValue;
    }

    public void setData(qr6 qr6Var) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qr6Var) == null) || (linearLayout = this.a) == null || qr6Var == null) {
            return;
        }
        linearLayout.removeAllViews();
        if (ListUtils.isEmpty(qr6Var.b())) {
            return;
        }
        for (int i = 0; i < qr6Var.b().size(); i++) {
            View c = c(qr6Var.b().get(i), i);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(pi.f(getContext(), R.dimen.obfuscated_res_0x7f0702cb), pi.f(getContext(), R.dimen.obfuscated_res_0x7f070269));
            if (i != 0) {
                layoutParams.leftMargin = pi.f(getContext(), R.dimen.obfuscated_res_0x7f070304);
            } else {
                layoutParams.leftMargin = pi.f(getContext(), R.dimen.obfuscated_res_0x7f070225);
            }
            if (i == qr6Var.b().size() - 1) {
                layoutParams.rightMargin = pi.f(getContext(), R.dimen.obfuscated_res_0x7f070225);
            } else {
                layoutParams.rightMargin = 0;
            }
            c.setLayoutParams(layoutParams);
            this.a.addView(c);
        }
    }

    public void setOnCardClickListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.b = bVar;
        }
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
}

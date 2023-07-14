package com.baidu.tieba;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cp6 extends wo6<dy6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public TextView m;
    public LinearLayout n;
    public ImageView o;
    public ImageView p;
    public ImageView q;
    public ImageView r;
    public ImageView s;
    public TextView t;
    public dy6 u;
    public View v;

    @Override // com.baidu.tieba.wo6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d01b0 : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp6(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        r(h());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && e() != null) {
            e().a(h(), this.u);
        }
    }

    @Override // com.baidu.tieba.wo6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            if (this.a != i) {
                SkinManager.setBackgroundResource(h(), R.color.CAM_X0201);
                SkinManager.setBackgroundResource(this.v, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
                SkinManager.setViewTextColor(this.m, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(this.t, R.color.CAM_X0107, 1);
                t(this.u);
            }
            this.a = i;
        }
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905ae);
            this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0905af);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905b9);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905b0);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905b2);
            this.n = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0905b8);
            this.o = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905b3);
            this.p = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905b4);
            this.q = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905b5);
            this.r = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905b6);
            this.s = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f0905b7);
            this.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0905ad);
            this.i.setDefaultResource(17170445);
            this.i.setDefaultBgResource(R.color.CAM_X0205);
            this.i.setDrawBorder(true);
            this.i.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            this.i.setBorderWidth(this.c.getResources().getDimensionPixelSize(R.dimen.tbds1));
            this.i.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds26));
            h().setOnClickListener(this);
            this.v = view2.findViewById(R.id.obfuscated_res_0x7f0908f9);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wo6
    /* renamed from: s */
    public void i(dy6 dy6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, dy6Var) == null) && dy6Var != null && dy6Var.c() != null) {
            this.u = dy6Var;
            this.i.N(dy6Var.c().avatar, 10, false);
            this.k.setText(dy6Var.c().game_name);
            this.l.setText(dy6Var.c().title_small);
            this.m.setText(String.valueOf(dy6Var.c().game_score));
            t(dy6Var);
            this.t.setText(this.c.getResources().getString(R.string.obfuscated_res_0x7f0f0819, StringHelper.numberUniform(dy6Var.c().game_score_num)));
        }
    }

    public final void t(dy6 dy6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, dy6Var) != null) || dy6Var == null) {
            return;
        }
        SkinManager.setImageResource(this.o, R.drawable.game_comment_score_btn_small_empty_bg);
        SkinManager.setImageResource(this.p, R.drawable.game_comment_score_btn_small_empty_bg);
        SkinManager.setImageResource(this.q, R.drawable.game_comment_score_btn_small_empty_bg);
        SkinManager.setImageResource(this.r, R.drawable.game_comment_score_btn_small_empty_bg);
        SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_empty_bg);
        if (dy6Var.c().game_score > 0.0d) {
            if (dy6Var.c().game_score < 2.0d) {
                SkinManager.setImageResource(this.o, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (dy6Var.c().game_score == 2.0d) {
                SkinManager.setImageResource(this.o, R.drawable.game_comment_score_btn_small_full_bg);
            } else if (dy6Var.c().game_score < 4.0d) {
                SkinManager.setImageResource(this.o, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.p, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (dy6Var.c().game_score == 4.0d) {
                SkinManager.setImageResource(this.o, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.p, R.drawable.game_comment_score_btn_small_full_bg);
            } else if (dy6Var.c().game_score < 6.0d) {
                SkinManager.setImageResource(this.o, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.p, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.q, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (dy6Var.c().game_score == 6.0d) {
                SkinManager.setImageResource(this.o, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.p, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.q, R.drawable.game_comment_score_btn_small_full_bg);
            } else if (dy6Var.c().game_score < 8.0d) {
                SkinManager.setImageResource(this.o, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.p, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.q, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.r, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (dy6Var.c().game_score == 8.0d) {
                SkinManager.setImageResource(this.o, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.p, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.q, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.r, R.drawable.game_comment_score_btn_small_full_bg);
            } else if (dy6Var.c().game_score < 10.0d) {
                SkinManager.setImageResource(this.o, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.p, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.q, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.r, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_half_bg);
            } else if (dy6Var.c().game_score == 10.0d) {
                SkinManager.setImageResource(this.o, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.p, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.q, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.r, R.drawable.game_comment_score_btn_small_full_bg);
                SkinManager.setImageResource(this.s, R.drawable.game_comment_score_btn_small_full_bg);
            }
        }
    }
}

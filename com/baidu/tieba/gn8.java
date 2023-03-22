package com.baidu.tieba;

import android.graphics.Matrix;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public mj8 b;
    public RelativeLayout c;
    public TextView d;
    public ImageView e;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public a(gn8 gn8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public gn8(PbFragment pbFragment, mj8 mj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, mj8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.a = pbFragment;
        this.b = mj8Var;
        f();
    }

    public void a(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, bdTypeListView) == null) && bdTypeListView != null) {
            this.c.setVisibility(0);
            bdTypeListView.addHeaderView(this.c);
            this.c.setTag(Integer.valueOf(bdTypeListView.getHeaderViewsCount()));
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0205);
            TextView textView = this.d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
                this.d.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
            }
        }
    }

    public void h(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bdTypeListView) == null) && bdTypeListView != null) {
            this.c.setVisibility(8);
            bdTypeListView.removeHeaderView(this.c);
        }
    }

    public void b(ki8 ki8Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{ki8Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && ki8Var != null && ki8Var.Q() != null && ki8Var.Q().getIsNoTitle() == 0 && !ki8Var.Q().isVideoThreadType()) {
            if (ki8Var.j) {
                this.e.setImageResource(R.drawable.pic_frs_headlines_n);
                this.e.setVisibility(0);
            } else if (z && z2) {
                this.e.setImageResource(R.drawable.obfuscated_res_0x7f08101b);
                this.e.setVisibility(0);
            } else if (z) {
                this.e.setImageResource(R.drawable.obfuscated_res_0x7f081019);
                this.e.setVisibility(0);
            } else if (z2) {
                this.e.setImageResource(R.drawable.obfuscated_res_0x7f08101a);
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
            if (this.e.getVisibility() == 0 && this.e.getLayoutParams() != null) {
                this.e.getLayoutParams().height = mm8.s() - mm8.t();
            }
        }
    }

    public final SpannableStringBuilder c(SpannableStringBuilder spannableStringBuilder, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, spannableStringBuilder, z)) == null) {
            if (!z) {
                return spannableStringBuilder;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            spannableStringBuilder2.insert(0, (CharSequence) "icon");
            int g = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int g2 = hi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g3 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds49);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(R.drawable.icon_mask_label_toutiao16, -1, EMRichTextAnyIconSpan.IconType.PIC);
            eMRichTextAnyIconSpan.f(g2);
            eMRichTextAnyIconSpan.g(g);
            eMRichTextAnyIconSpan.h(g3);
            eMRichTextAnyIconSpan.b(true);
            spannableStringBuilder2.setSpan(eMRichTextAnyIconSpan, 0, 4, 17);
            return spannableStringBuilder2;
        }
        return (SpannableStringBuilder) invokeLZ.objValue;
    }

    public RelativeLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final SpannableStringBuilder e(SpannableStringBuilder spannableStringBuilder, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, spannableStringBuilder, z)) == null) {
            if (!z) {
                return spannableStringBuilder;
            }
            int g = hi.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int g2 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int g3 = hi.g(TbadkCoreApplication.getInst(), R.dimen.T_X09);
            int g4 = hi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g5 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int g6 = hi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g7 = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds52);
            String string = TbadkCoreApplication.getInst().getString(R.string.pb_ask_post_title_help);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append((CharSequence) string);
            q35 q35Var = new q35(g, -1, R.color.CAM_X0302, g3, R.color.CAM_X0101, g4, g7);
            q35Var.f(true);
            q35Var.b(g2);
            q35Var.h(g5);
            q35Var.i(g6);
            q35Var.g(true);
            q35Var.d(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds7));
            spannableStringBuilder2.setSpan(q35Var, 0, string.length(), 17);
            spannableStringBuilder2.append((CharSequence) spannableStringBuilder);
            return spannableStringBuilder2;
        }
        return (SpannableStringBuilder) invokeLZ.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d069d, (ViewGroup) null);
        this.c = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091a18);
        this.e = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -mm8.t());
        this.e.setImageMatrix(matrix);
        TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f0925d7);
        this.d = textView;
        n15 d = n15.d(textView);
        d.A(R.dimen.T_X03);
        d.x(R.dimen.M_T_X003);
        d.w(R.color.CAM_X0105);
        d.B(R.string.F_X02);
        d.s(R.color.CAM_X0304);
        this.d.setVisibility(8);
        if (this.d.getParent() == null) {
            this.c.addView(this.d);
        }
        this.c.setOnTouchListener(this.b);
        this.c.setOnLongClickListener(new a(this));
    }

    public void i(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ki8Var) == null) && ki8Var != null && ki8Var.Q() != null) {
            SpannableStringBuilder span_str = ki8Var.Q().getSpan_str();
            SpannableString h = mm8.h(ki8Var.Q());
            if (!StringUtils.isNull(ki8Var.Q().getTitle())) {
                if (h != null) {
                    span_str.append((CharSequence) h);
                    this.d.setText(span_str, TextView.BufferType.SPANNABLE);
                } else {
                    this.d.setText(span_str);
                }
                l(ki8Var);
                this.d.setVisibility(0);
                this.d.setMaxLines(3);
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                this.d.invalidate();
                return;
            }
            this.d.setVisibility(8);
        }
    }

    public void j(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ki8Var) == null) {
            if (ki8Var != null && !ki8Var.Q().isVideoThreadType() && this.d.getText() != null && this.d.getText().length() > 0) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public void l(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, ki8Var) != null) || this.d == null) {
            return;
        }
        int g = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        if (ki8Var.l0()) {
            g = 0;
        }
        layoutParams.bottomMargin = g;
        this.d.setLayoutParams(layoutParams);
    }

    public void k(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, ki8Var) == null) && ki8Var != null && ki8Var.Q() != null) {
            SpannableStringBuilder span_str = ki8Var.Q().getSpan_str();
            this.d.setOnTouchListener(new to9(span_str));
            SpannableStringBuilder e = e(span_str, ki8Var.Q().isQuestionThread());
            if (!ki8Var.Q().isQuestionThread()) {
                e = c(span_str, ki8Var.Q().isPbHeadLinesThread());
            }
            this.d.setText(e);
            this.d.setVisibility(0);
        }
    }
}

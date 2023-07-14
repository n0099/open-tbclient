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
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
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
/* loaded from: classes5.dex */
public class fk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public gg9 b;
    public RelativeLayout c;
    public TextView d;
    public ImageView e;

    /* loaded from: classes5.dex */
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

        public a(fk9 fk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fk9Var};
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

    public fk9(PbFragment pbFragment, gg9 gg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, gg9Var};
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
        this.b = gg9Var;
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

    public RelativeLayout b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Nullable
    public ImageView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (ImageView) invokeV.objValue;
    }

    public final SpannableStringBuilder c(SpannableStringBuilder spannableStringBuilder, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, spannableStringBuilder, z)) == null) {
            if (!z) {
                return spannableStringBuilder;
            }
            int g = yi.g(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.T_X09);
            int g4 = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g5 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int g6 = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g7 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds52);
            String string = TbadkCoreApplication.getInst().getString(R.string.pb_ask_post_title_help);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append((CharSequence) string);
            na5 na5Var = new na5(g, -1, R.color.CAM_X0302, g3, R.color.CAM_X0101, g4, g7);
            na5Var.f(true);
            na5Var.b(g2);
            na5Var.h(g5);
            na5Var.i(g6);
            na5Var.g(true);
            na5Var.d(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds7));
            spannableStringBuilder2.setSpan(na5Var, 0, string.length(), 17);
            spannableStringBuilder2.append((CharSequence) spannableStringBuilder);
            return spannableStringBuilder2;
        }
        return (SpannableStringBuilder) invokeLZ.objValue;
    }

    public final SpannableStringBuilder e(SpannableStringBuilder spannableStringBuilder, @DrawableRes int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{spannableStringBuilder, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (!z) {
                return spannableStringBuilder;
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
            spannableStringBuilder2.insert(0, (CharSequence) "icon");
            int g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds49);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(i, -1, EMRichTextAnyIconSpan.IconType.PIC);
            eMRichTextAnyIconSpan.j(g2);
            eMRichTextAnyIconSpan.f(0);
            eMRichTextAnyIconSpan.k(g);
            eMRichTextAnyIconSpan.l(g3);
            eMRichTextAnyIconSpan.c(true);
            spannableStringBuilder2.setSpan(eMRichTextAnyIconSpan, 0, 4, 17);
            return spannableStringBuilder2;
        }
        return (SpannableStringBuilder) invokeCommon.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || this.c != null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0700, (ViewGroup) null);
        this.c = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091b12);
        this.e = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -hj9.s());
        this.e.setImageMatrix(matrix);
        TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09272b);
        this.d = textView;
        d85 d = d85.d(textView);
        d.C(R.dimen.T_X03);
        d.z(R.dimen.M_T_X003);
        d.x(R.color.CAM_X0105);
        d.D(R.string.F_X02);
        d.t(R.color.CAM_X0304);
        this.d.setVisibility(8);
        if (this.d.getParent() == null) {
            this.c.addView(this.d);
        }
        this.c.setOnTouchListener(this.b);
        this.c.setOnLongClickListener(new a(this));
    }

    public void i(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ze9Var) == null) && ze9Var != null && ze9Var.N() != null) {
            SpannableStringBuilder span_str = ze9Var.N().getSpan_str();
            SpannableString h = hj9.h(ze9Var.N());
            if (!StringUtils.isNull(ze9Var.N().getTitle())) {
                if (h != null) {
                    span_str.append((CharSequence) h);
                    this.d.setText(span_str, TextView.BufferType.SPANNABLE);
                } else {
                    this.d.setText(span_str);
                }
                l(ze9Var);
                this.d.setVisibility(0);
                this.d.setMaxLines(3);
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                this.d.invalidate();
                return;
            }
            this.d.setVisibility(8);
        }
    }

    public void k(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, ze9Var) == null) && ze9Var != null && ze9Var.N() != null) {
            SpannableStringBuilder span_str = ze9Var.N().getSpan_str();
            this.d.setOnTouchListener(new jqa(span_str));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(span_str);
            if (ze9Var.N().isQuestionThread()) {
                spannableStringBuilder = c(span_str, true);
            } else if (ze9Var.N().isPbHeadLinesThread()) {
                spannableStringBuilder = e(span_str, R.drawable.icon_mask_label_toutiao16, true);
            } else if (ze9Var.N().isExcellentThread()) {
                spannableStringBuilder = e(span_str, R.drawable.icon_mask_excellent_pb, true);
            }
            this.d.setText(spannableStringBuilder);
            this.d.setVisibility(0);
        }
    }

    public void j(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ze9Var) == null) {
            if (ze9Var != null && !ze9Var.N().isVideoThreadType() && this.d.getText() != null && this.d.getText().length() > 0) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public void l(ze9 ze9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, ze9Var) != null) || this.d == null) {
            return;
        }
        int g = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        if (ze9Var.i0()) {
            g = 0;
        }
        layoutParams.bottomMargin = g;
        this.d.setLayoutParams(layoutParams);
    }
}

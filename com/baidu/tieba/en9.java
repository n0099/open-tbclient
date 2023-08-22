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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class en9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFragment a;
    public fj9 b;
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

        public a(en9 en9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {en9Var};
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

    public en9(PbFragment pbFragment, fj9 fj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, fj9Var};
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
        this.b = fj9Var;
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
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.L_X01);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.T_X09);
            int dimens4 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int dimens5 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens6 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int dimens7 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52);
            String string = TbadkCoreApplication.getInst().getString(R.string.pb_ask_post_title_help);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            spannableStringBuilder2.append((CharSequence) string);
            k95 k95Var = new k95(dimens, -1, R.color.CAM_X0302, dimens3, R.color.CAM_X0101, dimens4, dimens7);
            k95Var.f(true);
            k95Var.b(dimens2);
            k95Var.h(dimens5);
            k95Var.i(dimens6);
            k95Var.g(true);
            k95Var.d(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds7));
            spannableStringBuilder2.setSpan(k95Var, 0, string.length(), 17);
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
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2);
            int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X002);
            int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds49);
            EMRichTextAnyIconSpan eMRichTextAnyIconSpan = new EMRichTextAnyIconSpan(i, -1, EMRichTextAnyIconSpan.IconType.PIC);
            eMRichTextAnyIconSpan.j(dimens2);
            eMRichTextAnyIconSpan.f(0);
            eMRichTextAnyIconSpan.k(dimens);
            eMRichTextAnyIconSpan.l(dimens3);
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
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d070c, (ViewGroup) null);
        this.c = relativeLayout;
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091b51);
        this.e = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postTranslate(0.0f, -gm9.s());
        this.e.setImageMatrix(matrix);
        TextView textView = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09277c);
        this.d = textView;
        EMManager.from(textView).setTextSize(R.dimen.T_X03).setTextLinePadding(R.dimen.M_T_X003).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X02).setLinkTextColor(R.color.CAM_X0304);
        this.d.setVisibility(8);
        if (this.d.getParent() == null) {
            this.c.addView(this.d);
        }
        this.c.setOnTouchListener(this.b);
        this.c.setOnLongClickListener(new a(this));
    }

    public void i(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yh9Var) == null) && yh9Var != null && yh9Var.O() != null) {
            SpannableStringBuilder span_str = yh9Var.O().getSpan_str();
            SpannableString h = gm9.h(yh9Var.O());
            if (!StringUtils.isNull(yh9Var.O().getTitle())) {
                if (h != null) {
                    span_str.append((CharSequence) h);
                    this.d.setText(span_str, TextView.BufferType.SPANNABLE);
                } else {
                    this.d.setText(span_str);
                }
                l(yh9Var);
                this.d.setVisibility(0);
                this.d.setMaxLines(3);
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                this.d.invalidate();
                return;
            }
            this.d.setVisibility(8);
        }
    }

    public void k(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, yh9Var) == null) && yh9Var != null && yh9Var.O() != null) {
            SpannableStringBuilder span_str = yh9Var.O().getSpan_str();
            this.d.setOnTouchListener(new xta(span_str));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(span_str);
            if (yh9Var.O().isQuestionThread()) {
                spannableStringBuilder = c(span_str, true);
            } else if (yh9Var.O().isPbHeadLinesThread()) {
                spannableStringBuilder = e(span_str, R.drawable.icon_mask_label_toutiao16, true);
            } else if (yh9Var.O().isExcellentThread()) {
                spannableStringBuilder = e(span_str, R.drawable.icon_mask_excellent_pb, true);
            }
            this.d.setText(spannableStringBuilder);
            this.d.setVisibility(0);
        }
    }

    public void j(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yh9Var) == null) {
            if (yh9Var != null && !yh9Var.O().isVideoThreadType() && this.d.getText() != null && this.d.getText().length() > 0) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public void l(yh9 yh9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, yh9Var) != null) || this.d == null) {
            return;
        }
        int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds56);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        if (yh9Var.j0()) {
            dimens = 0;
        }
        layoutParams.bottomMargin = dimens;
        this.d.setLayoutParams(layoutParams);
    }
}

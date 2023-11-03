package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TagTextHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.bw4;
import com.baidu.tieba.sb8;
import com.baidu.tieba.vu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class HotTopicTabThreadItem extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbImageView b;
    public View c;
    public View d;
    public ImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public View j;
    public sb8 k;
    public vu4<sb8> l;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicTabThreadItem a;

        public a(HotTopicTabThreadItem hotTopicTabThreadItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicTabThreadItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicTabThreadItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.k != null && this.a.k.f != null) {
                if (this.a.l != null) {
                    this.a.l.b(view2, this.a.k, this.a.k.a, this.a.k.a);
                }
                ThreadCardUtils.jumpToPB((bw4) this.a.k.f, view2.getContext(), 2, false, true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabThreadItem(Context context) {
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
        this.a = 3;
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet) {
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
        this.a = 3;
        e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabThreadItem(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.a = 3;
        e();
    }

    public void setOnItemCoverListener(vu4<sb8> vu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vu4Var) == null) {
            this.l = vu4Var;
        }
    }

    public void c(sb8 sb8Var) {
        sb8 sb8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, sb8Var) == null) && sb8Var != null) {
            this.k = sb8Var;
            if (TextUtils.isEmpty(sb8Var.d)) {
                this.b.setVisibility(8);
                this.c.setVisibility(8);
                this.d.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams.addRule(8, 0);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f092604);
                this.i.setLayoutParams(layoutParams);
            } else {
                this.b.startLoad(sb8Var.d, 10, false);
                this.b.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams2.addRule(8, R.id.obfuscated_res_0x7f090828);
                layoutParams2.addRule(3, 0);
                this.i.setLayoutParams(layoutParams2);
                if (sb8Var.e > 0) {
                    this.d.setVisibility(0);
                    this.c.setVisibility(0);
                    this.f.setText(StringUtils.translateSecondsToString(sb8Var.e));
                } else {
                    this.d.setVisibility(8);
                    this.c.setVisibility(8);
                }
            }
            this.h.setText(sb8Var.b);
            int i = sb8Var.c;
            if (i < 1000) {
                i = 1000;
            }
            String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i);
            TextView textView = this.i;
            textView.setText(textView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0a45, numberUniformFormatExtraWithRoundInt));
            this.g.setText(String.valueOf(sb8Var.a));
            d();
            vu4<sb8> vu4Var = this.l;
            if (vu4Var != null && (sb8Var2 = this.k) != null) {
                int i2 = sb8Var2.a;
                vu4Var.d(this, sb8Var2, i2, i2);
            }
        }
    }

    public final void d() {
        sb8 sb8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (sb8Var = this.k) != null) {
            int indexTextColorRes = TagTextHelper.getIndexTextColorRes(sb8Var.a);
            Drawable background = this.i.getBackground();
            DrawableCompat.setTint(background, SkinManager.getColor(indexTextColorRes));
            background.setAlpha(40);
            this.i.setBackgroundDrawable(background);
            SkinManager.setViewTextColor(this.i, indexTextColorRes);
            Drawable background2 = this.g.getBackground();
            DrawableCompat.setTint(background2, SkinManager.getColor(indexTextColorRes));
            this.g.setBackgroundDrawable(background2);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0435, (ViewGroup) this, true);
            this.b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090828);
            this.c = findViewById(R.id.obfuscated_res_0x7f090827);
            this.d = findViewById(R.id.obfuscated_res_0x7f092909);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f092907);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f092908);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091177);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f092604);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f092409);
            this.b.setPlaceHolder(2);
            this.b.setRadius(BdUtilHelper.getDimens(getContext(), R.dimen.tbds10));
            this.b.setConrers(15);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091ff3);
            this.j = findViewById;
            findViewById.setOnClickListener(new a(this));
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.a != i) {
            TBSelector.setViewBackgroundColorWithPressedState(this.j, R.color.CAM_X0205, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            this.e.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
            d();
            this.a = i;
        }
    }
}

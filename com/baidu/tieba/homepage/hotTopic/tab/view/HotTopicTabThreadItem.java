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
import com.baidu.tieba.cn4;
import com.baidu.tieba.go4;
import com.baidu.tieba.ri;
import com.baidu.tieba.zx6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
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
    public zx6 k;
    public cn4<zx6> l;

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.k == null || this.a.k.f == null) {
                return;
            }
            if (this.a.l != null) {
                this.a.l.c(view2, this.a.k, this.a.k.a, this.a.k.a);
            }
            ThreadCardUtils.jumpToPB((go4) this.a.k.f, view2.getContext(), 2, false, true);
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

    public void c(zx6 zx6Var) {
        zx6 zx6Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, zx6Var) == null) || zx6Var == null) {
            return;
        }
        this.k = zx6Var;
        if (TextUtils.isEmpty(zx6Var.d)) {
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams.addRule(8, 0);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f0921c9);
            this.i.setLayoutParams(layoutParams);
        } else {
            this.b.K(zx6Var.d, 10, false);
            this.b.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams2.addRule(8, R.id.obfuscated_res_0x7f0906ff);
            layoutParams2.addRule(3, 0);
            this.i.setLayoutParams(layoutParams2);
            if (zx6Var.e > 0) {
                this.d.setVisibility(0);
                this.c.setVisibility(0);
                this.f.setText(StringUtils.translateSecondsToString(zx6Var.e));
            } else {
                this.d.setVisibility(8);
                this.c.setVisibility(8);
            }
        }
        this.h.setText(zx6Var.b);
        int i = zx6Var.c;
        if (i < 1000) {
            i = 1000;
        }
        String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i);
        TextView textView = this.i;
        textView.setText(textView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f089a, numberUniformFormatExtraWithRoundInt));
        this.g.setText(String.valueOf(zx6Var.a));
        d();
        cn4<zx6> cn4Var = this.l;
        if (cn4Var == null || (zx6Var2 = this.k) == null) {
            return;
        }
        int i2 = zx6Var2.a;
        cn4Var.d(this, zx6Var2, i2, i2);
    }

    public final void d() {
        zx6 zx6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (zx6Var = this.k) == null) {
            return;
        }
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(zx6Var.a);
        Drawable background = this.i.getBackground();
        DrawableCompat.setTint(background, SkinManager.getColor(indexTextColorRes));
        background.setAlpha(40);
        this.i.setBackgroundDrawable(background);
        SkinManager.setViewTextColor(this.i, indexTextColorRes);
        Drawable background2 = this.g.getBackground();
        DrawableCompat.setTint(background2, SkinManager.getColor(indexTextColorRes));
        this.g.setBackgroundDrawable(background2);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03b0, (ViewGroup) this, true);
            this.b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0906ff);
            this.c = findViewById(R.id.obfuscated_res_0x7f0906fe);
            this.d = findViewById(R.id.obfuscated_res_0x7f092499);
            this.e = (ImageView) findViewById(R.id.obfuscated_res_0x7f092497);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f092498);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f090f07);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0921c9);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091fe1);
            this.b.setPlaceHolder(2);
            this.b.setRadius(ri.f(getContext(), R.dimen.tbds10));
            this.b.setConrers(15);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091c1d);
            this.j = findViewById;
            findViewById.setOnClickListener(new a(this));
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || this.a == i) {
            return;
        }
        TBSelector.setViewBackgroundColorWithPressedState(this.j, R.color.CAM_X0205, R.color.CAM_X0204);
        SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
        this.e.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
        d();
        this.a = i;
    }

    public void setOnItemCoverListener(cn4<zx6> cn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cn4Var) == null) {
            this.l = cn4Var;
        }
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
}

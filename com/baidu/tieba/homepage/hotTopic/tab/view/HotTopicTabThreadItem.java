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
import c.a.d.f.p.n;
import c.a.o0.m.f;
import c.a.p0.q1.g.a.e.e;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class HotTopicTabThreadItem extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f33336b;

    /* renamed from: c  reason: collision with root package name */
    public View f33337c;

    /* renamed from: d  reason: collision with root package name */
    public View f33338d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f33339e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f33340f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f33341g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33342h;
    public TextView i;
    public View j;
    public e k;
    public f<e> l;

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.k == null || this.a.k.f17330f == null) {
                return;
            }
            if (this.a.l != null) {
                this.a.l.a(view, this.a.k, this.a.k.a, this.a.k.a);
            }
            ThreadCardUtils.jumpToPB((c.a.o0.r.r.a) this.a.k.f17330f, view.getContext(), 2, false, true);
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

    public void c(e eVar) {
        e eVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) || eVar == null) {
            return;
        }
        this.k = eVar;
        if (TextUtils.isEmpty(eVar.f17328d)) {
            this.f33336b.setVisibility(8);
            this.f33337c.setVisibility(8);
            this.f33338d.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams.addRule(8, 0);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f092032);
            this.i.setLayoutParams(layoutParams);
        } else {
            this.f33336b.J(eVar.f17328d, 10, false);
            this.f33336b.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            layoutParams2.addRule(8, R.id.obfuscated_res_0x7f090707);
            layoutParams2.addRule(3, 0);
            this.i.setLayoutParams(layoutParams2);
            if (eVar.f17329e > 0) {
                this.f33338d.setVisibility(0);
                this.f33337c.setVisibility(0);
                this.f33340f.setText(StringUtils.translateSecondsToString(eVar.f17329e));
            } else {
                this.f33338d.setVisibility(8);
                this.f33337c.setVisibility(8);
            }
        }
        this.f33342h.setText(eVar.f17326b);
        int i = eVar.f17327c;
        if (i < 1000) {
            i = 1000;
        }
        String numberUniformFormatExtraWithRoundInt = StringHelper.numberUniformFormatExtraWithRoundInt(i);
        TextView textView = this.i;
        textView.setText(textView.getContext().getResources().getString(R.string.obfuscated_res_0x7f0f0882, numberUniformFormatExtraWithRoundInt));
        this.f33341g.setText(String.valueOf(eVar.a));
        d();
        f<e> fVar = this.l;
        if (fVar == null || (eVar2 = this.k) == null) {
            return;
        }
        int i2 = eVar2.a;
        fVar.c(this, eVar2, i2, i2);
    }

    public final void d() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (eVar = this.k) == null) {
            return;
        }
        int indexTextColorRes = TagTextHelper.getIndexTextColorRes(eVar.a);
        Drawable background = this.i.getBackground();
        DrawableCompat.setTint(background, SkinManager.getColor(indexTextColorRes));
        background.setAlpha(40);
        this.i.setBackgroundDrawable(background);
        SkinManager.setViewTextColor(this.i, indexTextColorRes);
        Drawable background2 = this.f33341g.getBackground();
        DrawableCompat.setTint(background2, SkinManager.getColor(indexTextColorRes));
        this.f33341g.setBackgroundDrawable(background2);
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03c1, (ViewGroup) this, true);
            this.f33336b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090707);
            this.f33337c = findViewById(R.id.obfuscated_res_0x7f090706);
            this.f33338d = findViewById(R.id.obfuscated_res_0x7f0922fb);
            this.f33339e = (ImageView) findViewById(R.id.obfuscated_res_0x7f0922f9);
            this.f33340f = (TextView) findViewById(R.id.obfuscated_res_0x7f0922fa);
            this.f33341g = (TextView) findViewById(R.id.obfuscated_res_0x7f090ef0);
            this.f33342h = (TextView) findViewById(R.id.obfuscated_res_0x7f092032);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f091e60);
            this.f33336b.setPlaceHolder(2);
            this.f33336b.setRadius(n.f(getContext(), R.dimen.tbds10));
            this.f33336b.setConrers(15);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f091ad8);
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
        SkinManager.setViewTextColor(this.f33342h, (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f33341g, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f33340f, (int) R.color.CAM_X0101);
        this.f33339e.setImageDrawable(SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_video_play12_svg, R.color.CAM_X0101, null));
        d();
        this.a = i;
    }

    public void setOnItemCoverListener(f<e> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.l = fVar;
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

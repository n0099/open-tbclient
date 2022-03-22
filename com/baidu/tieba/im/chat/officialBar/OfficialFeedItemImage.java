package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.u1.i.a.b.b;
import c.a.p0.u1.l.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.selector.DrawableSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class OfficialFeedItemImage extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public TbImageView f33748b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f33749c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33750d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33751e;

    /* renamed from: f  reason: collision with root package name */
    public View f33752f;

    /* renamed from: g  reason: collision with root package name */
    public View f33753g;

    /* renamed from: h  reason: collision with root package name */
    public View f33754h;
    public boolean i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OfficialFeedItemImage(Context context, boolean z) {
        this(context, (AttributeSet) null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = z;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f33748b.setRadius(n.f(this.a, R.dimen.tbds31));
            this.f33748b.setConrers(3);
            ViewGroup.LayoutParams layoutParams = this.f33753g.getLayoutParams();
            layoutParams.height = n.f(this.a, R.dimen.tbds579);
            this.f33753g.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f33754h.getLayoutParams();
            layoutParams2.leftMargin = n.f(this.a, R.dimen.tbds27);
            this.f33754h.setLayoutParams(layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f33751e.getLayoutParams();
            layoutParams3.leftMargin = n.f(this.a, R.dimen.tbds30);
            layoutParams3.bottomMargin = n.f(this.a, R.dimen.tbds27);
            this.f33751e.setLayoutParams(layoutParams3);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0642, (ViewGroup) this, true);
            this.f33748b = (TbImageView) findViewById(R.id.obfuscated_res_0x7f091401);
            this.f33749c = (ImageView) findViewById(R.id.obfuscated_res_0x7f091408);
            this.f33750d = (TextView) findViewById(R.id.obfuscated_res_0x7f091407);
            this.f33751e = (TextView) findViewById(R.id.obfuscated_res_0x7f09140c);
            this.f33752f = findViewById(R.id.obfuscated_res_0x7f090382);
            this.f33748b.setConrers(15);
            this.f33748b.setRadius(n.f(this.a, R.dimen.tbds21));
            this.f33753g = findViewById(R.id.obfuscated_res_0x7f090e6f);
            this.f33754h = findViewById(R.id.obfuscated_res_0x7f09145c);
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f33749c, R.drawable.obfuscated_res_0x7f0808e3, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            DrawableSelector gradientLinear = TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0606);
            if (this.i) {
                gradientLinear.into(this.f33752f);
            } else {
                gradientLinear.blRadius(n.f(getContext(), R.dimen.tbds21)).brRadius(n.f(getContext(), R.dimen.tbds21)).into(this.f33752f);
            }
            SkinManager.setViewTextColor(this.f33750d, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f33751e, (int) R.color.CAM_X0101);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i > 0) {
                this.f33750d.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0e32, StringHelper.numberUniformFormatExtraWithRound(i)));
                this.f33750d.setVisibility(0);
                this.f33749c.setVisibility(0);
                return;
            }
            this.f33750d.setVisibility(8);
            this.f33749c.setVisibility(8);
        }
    }

    public void setData(a.C1417a c1417a, int i, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048580, this, c1417a, i, bVar) == null) {
            this.f33748b.J(c1417a.f18835c, 10, false);
            this.f33751e.setText(c1417a.a);
            if (bVar != null) {
                i = bVar.i();
            }
            d(i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialFeedItemImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        b();
    }
}

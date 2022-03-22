package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SearchView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f31594b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f31595c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f31596d;

    /* renamed from: e  reason: collision with root package name */
    public View f31597e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f31598f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f31599g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f31600h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) && this.f31600h == null) {
            this.f31600h = onClickListener;
            this.f31597e.setOnClickListener(onClickListener);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f31594b = findViewById(R.id.obfuscated_res_0x7f091c4f);
            this.f31595c = (TextView) findViewById(R.id.obfuscated_res_0x7f091c4e);
            this.f31596d = (TextView) findViewById(R.id.obfuscated_res_0x7f091c4d);
            this.f31597e = findViewById(R.id.obfuscated_res_0x7f091c23);
            this.f31598f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091c1c);
            this.f31599g = (TextView) findViewById(R.id.obfuscated_res_0x7f091c4b);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = getContext();
            setOrientation(1);
            setMinimumHeight(n.f(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d08b8, (ViewGroup) this, true);
            b();
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            SkinManager.setBackgroundShapeDrawable(this.f31597e, n.f(getContext(), R.dimen.tbds100), R.color.CAM_X0204, R.color.CAM_X0204, i);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f31598f, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setViewTextColor(this.f31595c, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.f31596d, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.f31599g, R.color.CAM_X0109, 1, i);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201, i);
        }
    }

    public void setRank(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.f31594b.setVisibility(0);
            this.f31596d.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02d7), Integer.valueOf(i)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchView(Context context, AttributeSet attributeSet) {
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
        c();
    }
}

package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class SearchView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f43183e;

    /* renamed from: f  reason: collision with root package name */
    public View f43184f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f43185g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f43186h;

    /* renamed from: i  reason: collision with root package name */
    public View f43187i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f43188j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f43189k;
    public View.OnClickListener l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f43184f = findViewById(R.id.search_view_title_container);
            this.f43185g = (TextView) findViewById(R.id.search_view_title);
            this.f43186h = (TextView) findViewById(R.id.search_view_rank);
            this.f43187i = findViewById(R.id.search_container);
            this.f43188j = (ImageView) findViewById(R.id.search_bar_icon);
            this.f43189k = (TextView) findViewById(R.id.search_text);
        }
    }

    public void addOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) && this.l == null) {
            this.l = onClickListener;
            this.f43187i.setOnClickListener(onClickListener);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f43183e = getContext();
            setOrientation(1);
            setMinimumHeight(l.f(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.vote_search_layout, (ViewGroup) this, true);
            a();
        }
    }

    public void onSkinChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            int f2 = l.f(getContext(), R.dimen.tbds100);
            View view = this.f43187i;
            int i3 = R.color.CAM_X0204;
            SkinManager.setBackgroundShapeDrawable(view, f2, i3, i3, i2);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f43188j, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setViewTextColor(this.f43185g, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f43186h, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f43189k, R.color.CAM_X0109, 1, i2);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201, i2);
        }
    }

    public void setRank(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f43184f.setVisibility(0);
            this.f43186h.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.bar_manager_search_num), Integer.valueOf(i2)));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        b();
    }
}

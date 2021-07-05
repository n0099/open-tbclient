package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class SearchView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f14421e;

    /* renamed from: f  reason: collision with root package name */
    public View f14422f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14423g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f14424h;

    /* renamed from: i  reason: collision with root package name */
    public View f14425i;
    public ImageView j;
    public TextView k;
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

    public void a(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) && this.l == null) {
            this.l = onClickListener;
            this.f14425i.setOnClickListener(onClickListener);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14422f = findViewById(R.id.search_view_title_container);
            this.f14423g = (TextView) findViewById(R.id.search_view_title);
            this.f14424h = (TextView) findViewById(R.id.search_view_rank);
            this.f14425i = findViewById(R.id.search_container);
            this.j = (ImageView) findViewById(R.id.search_bar_icon);
            this.k = (TextView) findViewById(R.id.search_text);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f14421e = getContext();
            setOrientation(1);
            setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.vote_search_layout, (ViewGroup) this, true);
            b();
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            int g2 = l.g(getContext(), R.dimen.tbds100);
            View view = this.f14425i;
            int i3 = R.color.CAM_X0204;
            SkinManager.setBackgroundShapeDrawable(view, g2, i3, i3, i2);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_search_import16_svg, R.color.CAM_X0109, null);
            SkinManager.setViewTextColor(this.f14423g, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.f14424h, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0109, 1, i2);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201, i2);
        }
    }

    public void setRank(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f14422f.setVisibility(0);
            this.f14424h.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.bar_manager_search_num), Integer.valueOf(i2)));
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
        c();
    }
}

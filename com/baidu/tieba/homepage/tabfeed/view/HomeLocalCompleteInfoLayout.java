package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.l.q;
import c.a.u0.p1.k.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class HomeLocalCompleteInfoLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f44708e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f44709f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f44710g;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HomeLocalCompleteInfoLayout f44711e;

        public a(HomeLocalCompleteInfoLayout homeLocalCompleteInfoLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {homeLocalCompleteInfoLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44711e = homeLocalCompleteInfoLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f44711e.getContext() == null) {
                return;
            }
            c.g();
            PersonChangeActivityConfig personChangeActivityConfig = new PersonChangeActivityConfig(this.f44711e.getContext());
            personChangeActivityConfig.setIsCompleteLocalInfo(true);
            personChangeActivityConfig.start();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HomeLocalCompleteInfoLayout(Context context) {
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
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            marginLayoutParams.setMargins(0, n.f(getContext(), R.dimen.M_H_X003), 0, 0);
            setLayoutParams(marginLayoutParams);
            setOrientation(0);
            setGravity(16);
            int f2 = n.f(getContext(), R.dimen.M_W_X005);
            setPadding(f2, 0, f2, 0);
            TextView textView = new TextView(getContext());
            this.f44708e = textView;
            textView.setText(getContext().getString(R.string.home_local_complete_info_title));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            addView(this.f44708e, layoutParams);
            EMTextView eMTextView = new EMTextView(getContext());
            this.f44709f = eMTextView;
            eMTextView.setText(getContext().getString(R.string.home_local_go_complete));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, n.f(getContext(), R.dimen.tbds75));
            int f3 = n.f(getContext(), R.dimen.M_W_X004);
            layoutParams2.setMargins(f3, n.f(getContext(), R.dimen.M_H_X005), f3, n.f(getContext(), R.dimen.tbds38));
            int f4 = n.f(getContext(), R.dimen.M_W_X007);
            this.f44709f.setGravity(16);
            this.f44709f.setPadding(f4, 0, f4, 0);
            addView(this.f44709f, layoutParams2);
            this.f44709f.setOnClickListener(new a(this));
            this.f44710g = new ImageView(getContext());
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.tbds57);
            addView(this.f44710g, new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            TextView textView = this.f44708e;
            if (textView != null) {
                c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(textView);
                d2.v(R.color.CAM_X0105);
                d2.z(R.dimen.T_X06);
                d2.A(R.string.F_X01);
            }
            EMTextView eMTextView = this.f44709f;
            if (eMTextView != null) {
                c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(eMTextView);
                d3.v(R.color.CAM_X0302);
                d3.z(R.dimen.T_X08);
                d3.A(R.string.F_X01);
                d3.n(R.string.J_X01);
                d3.l(R.dimen.L_X02);
                d3.k(R.color.CAM_X0302);
            }
            ImageView imageView = this.f44710g;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            }
            c.a.t0.s.v.c d4 = c.a.t0.s.v.c.d(this);
            d4.n(R.string.J_X06);
            d4.f(R.color.CAM_X0205);
        }
    }

    public void setCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) || (imageView = this.f44710g) == null) {
            return;
        }
        imageView.setOnClickListener(onClickListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HomeLocalCompleteInfoLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HomeLocalCompleteInfoLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeLocalCompleteInfoLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        a();
    }
}

package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import c.a.d.f.p.n;
import c.a.p0.b2.o.k.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BazhuHeadView extends HeadPendantView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BazhuHeadView(Context context, AttributeSet attributeSet, int i) {
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
    }

    @Override // com.baidu.tbadk.core.view.HeadPendantView
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.d();
            int f2 = n.f(getContext(), R.dimen.tbds92);
            int f3 = n.f(getContext(), R.dimen.tbds82);
            if (getPendantView() != null) {
                getPendantView().setLayoutParams(new RelativeLayout.LayoutParams(f2, f3));
            }
            TbImageView tbImageView = new TbImageView(getContext());
            this.m = tbImageView;
            tbImageView.setDefaultBgResource(0);
            this.m.setDefaultResource(0);
            this.m.setImageDrawable(null);
            int f4 = n.f(getContext(), R.dimen.tbds115);
            int f5 = n.f(getContext(), R.dimen.tbds34);
            int f6 = n.f(getContext(), R.dimen.tbds154);
            int f7 = n.f(getContext(), R.dimen.tbds32);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f4, f5);
            layoutParams.topMargin = f6;
            layoutParams.leftMargin = f7;
            this.m.setLayoutParams(layoutParams);
            this.m.setVisibility(8);
        }
    }

    public TbImageView getBawuLogoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (TbImageView) invokeV.objValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                int f2 = n.f(getContext(), R.dimen.tbds5);
                int f3 = n.f(getContext(), R.dimen.tbds130);
                int f4 = n.f(getContext(), R.dimen.tbds26);
                int f5 = n.f(getContext(), R.dimen.tbds44);
                getHeadView().setBorderWidth(f2);
                getHeadView().setBorderColor(b.b("#FCD442"));
                getHeadView().setDrawBorder(true);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f3, f3);
                layoutParams.leftMargin = f4;
                layoutParams.topMargin = f5;
                getHeadView().setLayoutParams(layoutParams);
                return;
            }
            int f6 = n.f(getContext(), R.dimen.tbds90);
            getHeadView().setBorderWidth(0);
            getHeadView().setDrawBorder(false);
            getHeadView().setLayoutParams(new RelativeLayout.LayoutParams(f6, f6));
            TbImageView tbImageView = this.m;
            if (tbImageView != null) {
                tbImageView.setVisibility(8);
            }
            if (getPendantView() != null) {
                getPendantView().setVisibility(8);
            }
        }
    }

    public void setBawuLogoView(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 0) {
                this.m.setVisibility(8);
                return;
            }
            this.m.setImageResource(i);
            this.m.setVisibility(0);
        }
    }

    public void setPendantView(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || getPendantView() == null) {
            return;
        }
        if (i == 0) {
            getPendantView().setVisibility(8);
            return;
        }
        getPendantView().setVisibility(0);
        getPendantView().setImageResource(i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BazhuHeadView(Context context, AttributeSet attributeSet) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BazhuHeadView(Context context) {
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
    }
}

package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tp8;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BazhuHeadView extends HeadPendantView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView n;

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
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.e();
            int g = wi.g(getContext(), R.dimen.tbds92);
            int g2 = wi.g(getContext(), R.dimen.tbds82);
            if (getPendantView() != null) {
                getPendantView().setLayoutParams(new RelativeLayout.LayoutParams(g, g2));
            }
            if (getLayerImageView() != null) {
                getLayerImageView().setLayoutParams(new RelativeLayout.LayoutParams(g, g2));
            }
            TbImageView tbImageView = new TbImageView(getContext());
            this.n = tbImageView;
            tbImageView.setDefaultBgResource(0);
            this.n.setDefaultResource(0);
            this.n.setImageDrawable(null);
            int g3 = wi.g(getContext(), R.dimen.tbds115);
            int g4 = wi.g(getContext(), R.dimen.tbds34);
            int g5 = wi.g(getContext(), R.dimen.tbds154);
            int g6 = wi.g(getContext(), R.dimen.tbds32);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g3, g4);
            layoutParams.topMargin = g5;
            layoutParams.leftMargin = g6;
            this.n.setLayoutParams(layoutParams);
            this.n.setVisibility(8);
        }
    }

    public TbImageView getBawuLogoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.n;
        }
        return (TbImageView) invokeV.objValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                int g = wi.g(getContext(), R.dimen.tbds5);
                int g2 = wi.g(getContext(), R.dimen.tbds130);
                int g3 = wi.g(getContext(), R.dimen.tbds26);
                int g4 = wi.g(getContext(), R.dimen.tbds44);
                getHeadView().setBorderWidth(g);
                getHeadView().setBorderColor(tp8.b("#FCD442"));
                getHeadView().setDrawBorder(true);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
                layoutParams.leftMargin = g3;
                layoutParams.topMargin = g4;
                getHeadView().setLayoutParams(layoutParams);
                return;
            }
            int g5 = wi.g(getContext(), R.dimen.tbds90);
            getHeadView().setBorderWidth(0);
            getHeadView().setDrawBorder(false);
            getHeadView().setLayoutParams(new RelativeLayout.LayoutParams(g5, g5));
            TbImageView tbImageView = this.n;
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
                this.n.setVisibility(8);
                return;
            }
            this.n.setImageResource(i);
            this.n.setVisibility(0);
        }
    }

    public void setPendantView(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && getPendantView() != null) {
            if (i == 0) {
                getPendantView().setVisibility(8);
                return;
            }
            getPendantView().setVisibility(0);
            getPendantView().setImageResource(i);
        }
    }
}

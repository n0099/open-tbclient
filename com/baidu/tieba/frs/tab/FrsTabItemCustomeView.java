package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.graphics.ColorFilter;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.TabPic;
import tbclient.TabPicDesc;
/* loaded from: classes4.dex */
public class FrsTabItemCustomeView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TbImageView b;
    public int c;
    public TabPic d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsTabItemCustomeView(Context context) {
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
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsTabItemCustomeView(Context context, AttributeSet attributeSet) {
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
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsTabItemCustomeView(Context context, AttributeSet attributeSet, int i) {
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
        d(context);
    }

    public void a() {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.d != null && this.b != null && (tbImageView = this.a) != null) {
            tbImageView.getLayoutParams().height = this.c;
            this.b.getLayoutParams().height = this.c;
            if (TbadkApplication.getInst().getSkinType() == 1 && this.d.dark != null) {
                this.a.getLayoutParams().width = c(this.d.dark.pic_width.intValue(), this.d.dark.pic_height.intValue());
                this.b.getLayoutParams().width = c(this.d.dark.pic_width.intValue(), this.d.dark.pic_height.intValue());
                TbImageView tbImageView2 = this.b;
                TabPicDesc tabPicDesc = this.d.dark;
                tbImageView2.G(tabPicDesc.unselected_pic_url, 45, c(tabPicDesc.pic_width.intValue(), this.d.dark.pic_height.intValue()), this.c, false);
                TbImageView tbImageView3 = this.a;
                TabPicDesc tabPicDesc2 = this.d.dark;
                tbImageView3.G(tabPicDesc2.selected_pic_url, 45, c(tabPicDesc2.pic_width.intValue(), this.d.dark.pic_height.intValue()), this.c, false);
            } else if (this.d.normal != null) {
                this.a.getLayoutParams().width = c(this.d.normal.pic_width.intValue(), this.d.normal.pic_height.intValue());
                this.b.getLayoutParams().width = c(this.d.normal.pic_width.intValue(), this.d.normal.pic_height.intValue());
                TbImageView tbImageView4 = this.b;
                TabPicDesc tabPicDesc3 = this.d.normal;
                tbImageView4.G(tabPicDesc3.unselected_pic_url, 45, c(tabPicDesc3.pic_width.intValue(), this.d.normal.pic_height.intValue()), this.c, false);
                TbImageView tbImageView5 = this.a;
                TabPicDesc tabPicDesc4 = this.d.normal;
                tbImageView5.G(tabPicDesc4.selected_pic_url, 45, c(tabPicDesc4.pic_width.intValue(), this.d.normal.pic_height.intValue()), this.c, false);
            }
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (z) {
                this.b.setVisibility(4);
                this.a.setVisibility(0);
                return;
            }
            this.a.setVisibility(4);
            this.b.setVisibility(0);
        }
    }

    public void e(TabPic tabPic) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tabPic) == null) {
            this.d = tabPic;
            a();
        }
    }

    public void setNeedNightShade(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                tbImageView.setNeedNightShade(z);
            }
            TbImageView tbImageView2 = this.b;
            if (tbImageView2 != null) {
                tbImageView2.setNeedNightShade(z);
            }
        }
    }

    public void setSelectColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, colorFilter) == null) {
            TbImageView tbImageView = this.a;
            if (tbImageView != null) {
                tbImageView.setContentColorFilter(colorFilter);
            }
            TbImageView tbImageView2 = this.b;
            if (tbImageView2 != null) {
                tbImageView2.setContentColorFilter(colorFilter);
            }
        }
    }

    public void setTabHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.c = i;
        }
    }

    public final int c(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            return (int) (((this.c * 1.0f) * i) / i2);
        }
        return invokeII.intValue;
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            this.c = UtilHelper.getDimenPixelSize(R.dimen.tbds47);
            setGravity(17);
            this.a = new TbImageView(context);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.a.setLayoutParams(layoutParams);
            this.a.setVisibility(4);
            this.a.setPlaceHolder(1);
            addView(this.a);
            this.b = new TbImageView(context);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.b.setPlaceHolder(1);
            this.b.setLayoutParams(layoutParams2);
            addView(this.b);
        }
    }
}

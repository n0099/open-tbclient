package com.baidu.tieba.funad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class FunAdNativePicView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TbImageView b;
    public TbImageView c;
    public TbImageView d;
    public TbImageView e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunAdNativePicView(Context context) {
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

    public final void a(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tbImageView) == null) {
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            tbImageView.setIsLongPic(false);
            tbImageView.setIsSmartCrop(false);
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
            tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            tbImageView.setBorderSurroundContent(true);
            tbImageView.setDrawBorder(true);
            tbImageView.setPlaceHolder(2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunAdNativePicView(Context context, @Nullable AttributeSet attributeSet) {
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
        b();
    }

    private void setImageData(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, list) == null) {
            if (ListUtils.getCount(list) != 0) {
                if (list.size() == 1) {
                    this.a.setVisibility(8);
                    this.e.setVisibility(0);
                    c((String) ListUtils.getItem(list, 0));
                    return;
                }
                this.e.setVisibility(8);
                this.a.setVisibility(0);
                if (ListUtils.getCount(list) == 2) {
                    e((String) ListUtils.getItem(list, 0), this.b);
                    e((String) ListUtils.getItem(list, 1), this.c);
                    this.d.reset();
                    return;
                } else if (ListUtils.getCount(list) >= 3) {
                    this.c.setVisibility(0);
                    e((String) ListUtils.getItem(list, 0), this.b);
                    e((String) ListUtils.getItem(list, 1), this.c);
                    e((String) ListUtils.getItem(list, 2), this.d);
                    return;
                } else {
                    this.a.setVisibility(8);
                    return;
                }
            }
            this.e.setVisibility(8);
            this.a.setVisibility(8);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d03ba, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.a = findViewById(R.id.obfuscated_res_0x7f090dc8);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090dc9);
            this.b = tbImageView;
            tbImageView.setDrawCorner(true);
            this.b.setPlaceHolder(2);
            this.b.setRadiusById(R.string.J_X12);
            this.b.setConrers(15);
            a(this.b);
            TbImageView tbImageView2 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090dcb);
            this.c = tbImageView2;
            tbImageView2.setDrawCorner(false);
            this.c.setPlaceHolder(2);
            this.c.setRadiusById(R.string.J_X02);
            this.c.setConrers(15);
            a(this.c);
            TbImageView tbImageView3 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090dca);
            this.d = tbImageView3;
            tbImageView3.setDrawCorner(true);
            this.d.setPlaceHolder(2);
            this.d.setRadiusById(R.string.J_X11);
            this.d.setConrers(15);
            a(this.d);
            TbImageView tbImageView4 = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090dc7);
            this.e = tbImageView4;
            tbImageView4.setDrawCorner(true);
            this.e.setPlaceHolder(3);
            this.e.setRadiusById(R.string.J_X05);
            this.e.setConrers(15);
            a(this.e);
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (!StringHelper.equals(str, this.e.getUrl())) {
                this.e.reset();
            }
            this.e.startLoad(str, 10, false);
        }
    }

    public void setFunNativeAd(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            setImageData(list);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0205);
            this.e.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.b.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.b.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.b.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
    }

    public final void e(String str, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, tbImageView) == null) {
            if (!StringHelper.equals(str, tbImageView.getUrl())) {
                tbImageView.reset();
            }
            tbImageView.startLoad(str, 10, false);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            super.onMeasure(i, i2);
        }
    }
}

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
/* loaded from: classes5.dex */
public class FunAdNativePicView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f42639e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f42640f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f42641g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f42642h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f42643i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FunAdNativePicView(Context context) {
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

    private void setImageData(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, list) == null) {
            if (ListUtils.getCount(list) != 0) {
                if (list.size() == 1) {
                    this.f42639e.setVisibility(8);
                    this.f42643i.setVisibility(0);
                    c((String) ListUtils.getItem(list, 0));
                    return;
                }
                this.f42643i.setVisibility(8);
                this.f42639e.setVisibility(0);
                if (ListUtils.getCount(list) == 2) {
                    d((String) ListUtils.getItem(list, 0), this.f42640f);
                    d((String) ListUtils.getItem(list, 1), this.f42641g);
                    this.f42642h.reset();
                    return;
                } else if (ListUtils.getCount(list) >= 3) {
                    this.f42641g.setVisibility(0);
                    d((String) ListUtils.getItem(list, 0), this.f42640f);
                    d((String) ListUtils.getItem(list, 1), this.f42641g);
                    d((String) ListUtils.getItem(list, 2), this.f42642h);
                    return;
                } else {
                    this.f42639e.setVisibility(8);
                    return;
                }
            }
            this.f42643i.setVisibility(8);
            this.f42639e.setVisibility(8);
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

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.fun_ad_native_pic, (ViewGroup) this, true);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f42639e = findViewById(R.id.fun_ad_img_more_container);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.fun_ad_img_more_one);
            this.f42640f = tbImageView;
            tbImageView.setDrawCorner(true);
            this.f42640f.setPlaceHolder(2);
            this.f42640f.setRadiusById(R.string.J_X12);
            this.f42640f.setConrers(15);
            a(this.f42640f);
            TbImageView tbImageView2 = (TbImageView) findViewById(R.id.fun_ad_img_more_two);
            this.f42641g = tbImageView2;
            tbImageView2.setDrawCorner(false);
            this.f42641g.setPlaceHolder(2);
            this.f42641g.setRadiusById(R.string.J_X02);
            this.f42641g.setConrers(15);
            a(this.f42641g);
            TbImageView tbImageView3 = (TbImageView) findViewById(R.id.fun_ad_img_more_three);
            this.f42642h = tbImageView3;
            tbImageView3.setDrawCorner(true);
            this.f42642h.setPlaceHolder(2);
            this.f42642h.setRadiusById(R.string.J_X11);
            this.f42642h.setConrers(15);
            a(this.f42642h);
            TbImageView tbImageView4 = (TbImageView) findViewById(R.id.fun_ad_img_big_one);
            this.f42643i = tbImageView4;
            tbImageView4.setDrawCorner(true);
            this.f42643i.setPlaceHolder(3);
            this.f42643i.setRadiusById(R.string.J_X05);
            this.f42643i.setConrers(15);
            a(this.f42643i);
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (!StringHelper.equals(str, this.f42643i.getUrl())) {
                this.f42643i.reset();
            }
            this.f42643i.startLoad(str, 10, false);
        }
    }

    public final void d(String str, TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, tbImageView) == null) {
            if (!StringHelper.equals(str, tbImageView.getUrl())) {
                tbImageView.reset();
            }
            tbImageView.startLoad(str, 10, false);
        }
    }

    public void onChangedSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SkinManager.setBackgroundColor(this.f42639e, R.color.CAM_X0205);
            this.f42643i.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f42640f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f42640f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            this.f42640f.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f42640f.reset();
            this.f42641g.reset();
            this.f42642h.reset();
            this.f42643i.reset();
        }
    }

    public void setFunNativeAd(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            if (ListUtils.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            setImageData(list);
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

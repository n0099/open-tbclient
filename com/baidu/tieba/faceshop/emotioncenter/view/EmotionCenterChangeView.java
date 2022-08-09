package com.baidu.tieba.faceshop.emotioncenter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.emotioncenter.data.EmotionCenterData;
import com.baidu.tieba.faceshop.emotioncenter.model.EmotionChangeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mb6;
import java.util.List;
/* loaded from: classes3.dex */
public class EmotionCenterChangeView extends LinearLayout implements View.OnClickListener, mb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public EmotionHorizontalView b;
    public EmotionHorizontalView c;
    public EmotionHorizontalView d;
    public ImageView e;
    public LinearLayout f;
    public RelativeLayout g;
    public View h;
    public TextView i;
    public TextView j;
    public EmotionChangeModel k;
    public Animation l;
    public List<EmotionPackageData> m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionCenterChangeView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = null;
        this.a = tbPageContext;
        b();
    }

    private Animation getClickRotateAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.l == null) {
                this.l = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f010108);
                this.l.setInterpolator(new LinearInterpolator());
                this.l.setFillAfter(true);
            }
            return this.l;
        }
        return (Animation) invokeV.objValue;
    }

    @Override // com.repackage.mb6
    public void H0(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, emotionCenterData) == null) {
            a();
            if (emotionCenterData == null || ListUtils.isEmpty(emotionCenterData.package_list)) {
                return;
            }
            setData(emotionCenterData.package_list);
        }
    }

    @Override // com.repackage.mb6
    public void T0(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionCenterData) == null) {
            a();
        }
    }

    public void a() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (imageView = this.e) == null) {
            return;
        }
        imageView.clearAnimation();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0249, this);
            this.b = new EmotionHorizontalView(this.a);
            this.c = new EmotionHorizontalView(this.a);
            this.d = new EmotionHorizontalView(this.a);
            this.b.f(TbadkCoreApplication.getInst().getSkinType());
            this.c.f(TbadkCoreApplication.getInst().getSkinType());
            this.d.f(TbadkCoreApplication.getInst().getSkinType());
            addView(this.b);
            addView(this.c);
            addView(this.d);
            this.b.setVisibility(8);
            this.c.setVisibility(8);
            this.d.setVisibility(8);
            this.f = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090880);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0905da);
            this.g = relativeLayout;
            relativeLayout.setVisibility(8);
            ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f090881);
            this.e = imageView;
            imageView.setOnClickListener(this);
            this.h = findViewById(R.id.obfuscated_res_0x7f09059f);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0908c0);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f090890);
            this.j = textView;
            textView.setOnClickListener(this);
            this.k = new EmotionChangeModel(this.a);
            c(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            SkinManager.setBackgroundColor(this.h, R.color.common_color_10312);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0107);
            SkinManager.setImageResource(this.e, R.drawable.emotion_icon_refresh);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
        }
    }

    public void d() {
        EmotionChangeModel emotionChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (emotionChangeModel = this.k) == null) {
            return;
        }
        emotionChangeModel.z(this);
    }

    public void e() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (imageView = this.e) == null) {
            return;
        }
        imageView.startAnimation(getClickRotateAnimation());
    }

    public void f(EmotionPackageData emotionPackageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.m)) {
            return;
        }
        for (EmotionPackageData emotionPackageData2 : this.m) {
            if (emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                setData(this.m);
                return;
            }
        }
    }

    public List<EmotionPackageData> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : (List) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        EmotionChangeModel emotionChangeModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            if ((view2 == this.e || view2 == this.j) && (emotionChangeModel = this.k) != null) {
                emotionChangeModel.z(this);
                e();
            }
        }
    }

    public void setData(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.m = list;
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            this.b.setVisibility(0);
            this.b.setData(list.get(0));
            this.c.setVisibility(8);
            this.d.setVisibility(8);
        } else if (size == 2) {
            this.b.setVisibility(0);
            this.b.setData(list.get(0));
            this.c.setVisibility(0);
            this.c.setData(list.get(1));
            this.d.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            this.b.setData(list.get(0));
            this.c.setVisibility(0);
            this.c.setData(list.get(1));
            this.d.setVisibility(0);
            this.d.setData(list.get(2));
        }
    }

    @Override // com.repackage.mb6
    public void w0(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, emotionCenterData) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionCenterChangeView(Context context, AttributeSet attributeSet) {
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
        this.l = null;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionCenterChangeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = null;
        b();
    }
}

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
import d.a.p0.p0.y.d.b;
import java.util.List;
/* loaded from: classes4.dex */
public class EmotionCenterChangeView extends LinearLayout implements View.OnClickListener, b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f15086e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionHorizontalView f15087f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionHorizontalView f15088g;

    /* renamed from: h  reason: collision with root package name */
    public EmotionHorizontalView f15089h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f15090i;
    public LinearLayout j;
    public RelativeLayout k;
    public View l;
    public TextView m;
    public TextView n;
    public EmotionChangeModel o;
    public Animation p;
    public List<EmotionPackageData> q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionCenterChangeView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = null;
        this.f15086e = tbPageContext;
        b();
    }

    private Animation getClickRotateAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (this.p == null) {
                this.p = AnimationUtils.loadAnimation(getContext(), R.anim.refresh_rotate);
                this.p.setInterpolator(new LinearInterpolator());
                this.p.setFillAfter(true);
            }
            return this.p;
        }
        return (Animation) invokeV.objValue;
    }

    @Override // d.a.p0.p0.y.d.b
    public void U(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, emotionCenterData) == null) {
        }
    }

    public void a() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (imageView = this.f15090i) == null) {
            return;
        }
        imageView.clearAnimation();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(R.layout.emotion_category_layout, this);
            this.f15087f = new EmotionHorizontalView(this.f15086e);
            this.f15088g = new EmotionHorizontalView(this.f15086e);
            this.f15089h = new EmotionHorizontalView(this.f15086e);
            this.f15087f.f(TbadkCoreApplication.getInst().getSkinType());
            this.f15088g.f(TbadkCoreApplication.getInst().getSkinType());
            this.f15089h.f(TbadkCoreApplication.getInst().getSkinType());
            addView(this.f15087f);
            addView(this.f15088g);
            addView(this.f15089h);
            this.f15087f.setVisibility(8);
            this.f15088g.setVisibility(8);
            this.f15089h.setVisibility(8);
            this.j = (LinearLayout) findViewById(R.id.emotion_change_item);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.change_head_layout);
            this.k = relativeLayout;
            relativeLayout.setVisibility(8);
            ImageView imageView = (ImageView) findViewById(R.id.emotion_change_iv);
            this.f15090i = imageView;
            imageView.setOnClickListener(this);
            this.l = findViewById(R.id.category_line_top);
            this.m = (TextView) findViewById(R.id.emotion_title);
            TextView textView = (TextView) findViewById(R.id.emotion_function);
            this.n = textView;
            textView.setOnClickListener(this);
            this.o = new EmotionChangeModel(this.f15086e);
            c(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SkinManager.setBackgroundColor(this.l, R.color.common_color_10312);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107);
            SkinManager.setImageResource(this.f15090i, R.drawable.emotion_icon_refresh);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
        }
    }

    @Override // d.a.p0.p0.y.d.b
    public void c0(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, emotionCenterData) == null) {
            a();
            if (emotionCenterData == null || ListUtils.isEmpty(emotionCenterData.package_list)) {
                return;
            }
            setData(emotionCenterData.package_list);
        }
    }

    public void d() {
        EmotionChangeModel emotionChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (emotionChangeModel = this.o) == null) {
            return;
        }
        emotionChangeModel.w(this);
    }

    public void e() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (imageView = this.f15090i) == null) {
            return;
        }
        imageView.startAnimation(getClickRotateAnimation());
    }

    public void f(EmotionPackageData emotionPackageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.q)) {
            return;
        }
        for (EmotionPackageData emotionPackageData2 : this.q) {
            if (emotionPackageData2.id == emotionPackageData.id) {
                emotionPackageData2.download = emotionPackageData.download;
                emotionPackageData2.share = emotionPackageData.share;
                setData(this.q);
                return;
            }
        }
    }

    public List<EmotionPackageData> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.q : (List) invokeV.objValue;
    }

    @Override // d.a.p0.p0.y.d.b
    public void j0(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, emotionCenterData) == null) {
            a();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmotionChangeModel emotionChangeModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            if ((view == this.f15090i || view == this.n) && (emotionChangeModel = this.o) != null) {
                emotionChangeModel.w(this);
                e();
            }
        }
    }

    public void setData(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.q = list;
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            this.f15087f.setVisibility(0);
            this.f15087f.setData(list.get(0));
            this.f15088g.setVisibility(8);
            this.f15089h.setVisibility(8);
        } else if (size == 2) {
            this.f15087f.setVisibility(0);
            this.f15087f.setData(list.get(0));
            this.f15088g.setVisibility(0);
            this.f15088g.setData(list.get(1));
            this.f15089h.setVisibility(8);
        } else {
            this.f15087f.setVisibility(0);
            this.f15087f.setData(list.get(0));
            this.f15088g.setVisibility(0);
            this.f15088g.setData(list.get(1));
            this.f15089h.setVisibility(0);
            this.f15089h.setData(list.get(2));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = null;
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionCenterChangeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = null;
        b();
    }
}

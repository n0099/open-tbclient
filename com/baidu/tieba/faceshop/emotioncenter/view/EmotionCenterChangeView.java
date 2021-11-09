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
import b.a.r0.s0.x.d.b;
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
import java.util.List;
/* loaded from: classes9.dex */
public class EmotionCenterChangeView extends LinearLayout implements View.OnClickListener, b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f48032e;

    /* renamed from: f  reason: collision with root package name */
    public EmotionHorizontalView f48033f;

    /* renamed from: g  reason: collision with root package name */
    public EmotionHorizontalView f48034g;

    /* renamed from: h  reason: collision with root package name */
    public EmotionHorizontalView f48035h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f48036i;
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
        this.f48032e = tbPageContext;
        a();
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setOrientation(1);
            LayoutInflater.from(getContext()).inflate(R.layout.emotion_category_layout, this);
            this.f48033f = new EmotionHorizontalView(this.f48032e);
            this.f48034g = new EmotionHorizontalView(this.f48032e);
            this.f48035h = new EmotionHorizontalView(this.f48032e);
            this.f48033f.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.f48034g.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            this.f48035h.onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
            addView(this.f48033f);
            addView(this.f48034g);
            addView(this.f48035h);
            this.f48033f.setVisibility(8);
            this.f48034g.setVisibility(8);
            this.f48035h.setVisibility(8);
            this.j = (LinearLayout) findViewById(R.id.emotion_change_item);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.change_head_layout);
            this.k = relativeLayout;
            relativeLayout.setVisibility(8);
            ImageView imageView = (ImageView) findViewById(R.id.emotion_change_iv);
            this.f48036i = imageView;
            imageView.setOnClickListener(this);
            this.l = findViewById(R.id.category_line_top);
            this.m = (TextView) findViewById(R.id.emotion_title);
            TextView textView = (TextView) findViewById(R.id.emotion_function);
            this.n = textView;
            textView.setOnClickListener(this);
            this.o = new EmotionChangeModel(this.f48032e);
            onChangeSkin(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // b.a.r0.s0.x.d.b
    public void change(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, emotionCenterData) == null) {
            endRefreshAnimation();
            if (emotionCenterData == null || ListUtils.isEmpty(emotionCenterData.package_list)) {
                return;
            }
            setData(emotionCenterData.package_list);
        }
    }

    public void endRefreshAnimation() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (imageView = this.f48036i) == null) {
            return;
        }
        imageView.clearAnimation();
    }

    public void failed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            endRefreshAnimation();
        }
    }

    public List<EmotionPackageData> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.q : (List) invokeV.objValue;
    }

    @Override // b.a.r0.s0.x.d.b
    public void loadMore(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, emotionCenterData) == null) {
        }
    }

    public void onChangeSkin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            SkinManager.setBackgroundColor(this.l, R.color.common_color_10312);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0107);
            SkinManager.setImageResource(this.f48036i, R.drawable.emotion_icon_refresh);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EmotionChangeModel emotionChangeModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            if ((view == this.f48036i || view == this.n) && (emotionChangeModel = this.o) != null) {
                emotionChangeModel.w(this);
                startRefreshAnimation();
            }
        }
    }

    public void refreshNetData() {
        EmotionChangeModel emotionChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (emotionChangeModel = this.o) == null) {
            return;
        }
        emotionChangeModel.w(this);
    }

    @Override // b.a.r0.s0.x.d.b
    public void refreshSuccess(EmotionCenterData emotionCenterData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, emotionCenterData) == null) {
            endRefreshAnimation();
        }
    }

    public void setData(List<EmotionPackageData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.q = list;
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        int size = list.size();
        if (size == 1) {
            this.f48033f.setVisibility(0);
            this.f48033f.setData(list.get(0));
            this.f48034g.setVisibility(8);
            this.f48035h.setVisibility(8);
        } else if (size == 2) {
            this.f48033f.setVisibility(0);
            this.f48033f.setData(list.get(0));
            this.f48034g.setVisibility(0);
            this.f48034g.setData(list.get(1));
            this.f48035h.setVisibility(8);
        } else {
            this.f48033f.setVisibility(0);
            this.f48033f.setData(list.get(0));
            this.f48034g.setVisibility(0);
            this.f48034g.setData(list.get(1));
            this.f48035h.setVisibility(0);
            this.f48035h.setData(list.get(2));
        }
    }

    public void startRefreshAnimation() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (imageView = this.f48036i) == null) {
            return;
        }
        imageView.startAnimation(getClickRotateAnimation());
    }

    public void updataData(EmotionPackageData emotionPackageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, emotionPackageData) == null) || emotionPackageData == null || ListUtils.isEmpty(this.q)) {
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
        a();
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
        a();
    }
}

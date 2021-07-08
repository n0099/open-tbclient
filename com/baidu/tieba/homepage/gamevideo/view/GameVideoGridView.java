package com.baidu.tieba.homepage.gamevideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.BdGridView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class GameVideoGridView extends BdGridView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f16640e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f16641f;

    /* renamed from: g  reason: collision with root package name */
    public GridLayoutAnimationController f16642g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameVideoGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f16640e = -1;
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f16641f == null) {
                this.f16641f = AnimationUtils.loadAnimation(getContext(), R.anim.game_choose_slide_in_top);
            }
            if (this.f16642g == null) {
                GridLayoutAnimationController gridLayoutAnimationController = new GridLayoutAnimationController(this.f16641f);
                this.f16642g = gridLayoutAnimationController;
                gridLayoutAnimationController.setColumnDelay(0.4f);
                this.f16642g.setRowDelay(0.2f);
                this.f16642g.setDirection(0);
                this.f16642g.setDirectionPriority(0);
            }
        }
    }

    public void d() {
        Animation animation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (animation = this.f16641f) == null) {
            return;
        }
        animation.cancel();
    }

    public void e() {
        GridLayoutAnimationController gridLayoutAnimationController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gridLayoutAnimationController = this.f16642g) == null) {
            return;
        }
        setLayoutAnimation(gridLayoutAnimationController);
        this.f16642g.start();
        startLayoutAnimation();
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i3);
            int i4 = this.f16640e;
            if (i4 <= size && i4 > -1) {
                i3 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
        }
    }

    public void setMaxHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f16640e = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameVideoGridView(Context context, AttributeSet attributeSet) {
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
        this.f16640e = -1;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameVideoGridView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16640e = -1;
        c();
    }
}

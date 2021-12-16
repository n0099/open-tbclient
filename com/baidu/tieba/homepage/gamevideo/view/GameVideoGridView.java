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
/* loaded from: classes12.dex */
public class GameVideoGridView extends BdGridView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f45721e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f45722f;

    /* renamed from: g  reason: collision with root package name */
    public GridLayoutAnimationController f45723g;

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
        this.f45721e = -1;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f45722f == null) {
                this.f45722f = AnimationUtils.loadAnimation(getContext(), R.anim.game_choose_slide_in_top);
            }
            if (this.f45723g == null) {
                GridLayoutAnimationController gridLayoutAnimationController = new GridLayoutAnimationController(this.f45722f);
                this.f45723g = gridLayoutAnimationController;
                gridLayoutAnimationController.setColumnDelay(0.4f);
                this.f45723g.setRowDelay(0.2f);
                this.f45723g.setDirection(0);
                this.f45723g.setDirectionPriority(0);
            }
        }
    }

    public void onDestroy() {
        Animation animation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (animation = this.f45722f) == null) {
            return;
        }
        animation.cancel();
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i3);
            int i4 = this.f45721e;
            if (i4 <= size && i4 > -1) {
                i3 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
        }
    }

    public void setMaxHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f45721e = i2;
        }
    }

    public void showAppearAnim() {
        GridLayoutAnimationController gridLayoutAnimationController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (gridLayoutAnimationController = this.f45723g) == null) {
            return;
        }
        setLayoutAnimation(gridLayoutAnimationController);
        this.f45723g.start();
        startLayoutAnimation();
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
        this.f45721e = -1;
        a();
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
        this.f45721e = -1;
        a();
    }
}

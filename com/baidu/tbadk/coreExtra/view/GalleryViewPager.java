package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class GalleryViewPager extends BaseViewPager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PointF i;
    public DragImageView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GalleryViewPager(Context context) {
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

    public final float[] e(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
            if (action == 0) {
                this.i = new PointF(motionEvent.getX(), motionEvent.getY());
                return null;
            } else if (action == 1 || action == 2) {
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                float f = pointF.x;
                PointF pointF2 = this.i;
                return new float[]{f - pointF2.x, pointF.y - pointF2.y};
            } else {
                return null;
            }
        }
        return (float[]) invokeL.objValue;
    }

    public DragImageView getCurrentView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (DragImageView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
                super.onInterceptTouchEvent(motionEvent);
            }
            float[] e = e(motionEvent);
            DragImageView dragImageView = this.j;
            if (dragImageView == null) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (dragImageView.f0()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (e != null && this.j.e0() && e[0] < 0.0f) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (e != null && this.j.d0() && e[0] > 0.0f) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (e == null && (this.j.d0() || this.j.e0())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
                super.onTouchEvent(motionEvent);
                DragImageView dragImageView = this.j;
                if (dragImageView != null) {
                    dragImageView.N();
                }
            }
            if (this.j == null) {
                return super.onTouchEvent(motionEvent);
            }
            float[] e = e(motionEvent);
            if (this.j.f0()) {
                return super.onTouchEvent(motionEvent);
            }
            if (e != null && this.j.e0() && e[0] < 0.0f) {
                return super.onTouchEvent(motionEvent);
            }
            if (e != null && this.j.d0() && e[0] > 0.0f) {
                return super.onTouchEvent(motionEvent);
            }
            if (e == null && (this.j.d0() || this.j.e0())) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setCurrentView(DragImageView dragImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dragImageView) == null) {
            this.j = dragImageView;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GalleryViewPager(Context context, AttributeSet attributeSet) {
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
}

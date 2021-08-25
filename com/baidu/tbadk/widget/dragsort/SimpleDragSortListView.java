package com.baidu.tbadk.widget.dragsort;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.d1.e.c;
import c.a.p0.d1.e.d;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SimpleDragSortListView extends BdListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c K;
    public AttributeSet L;
    public final d M;

    /* loaded from: classes6.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SimpleDragSortListView f48503a;

        public a(SimpleDragSortListView simpleDragSortListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {simpleDragSortListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48503a = simpleDragSortListView;
        }

        @Override // c.a.p0.d1.e.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SimpleDragSortListView.super.layoutChildren();
            }
        }

        @Override // c.a.p0.d1.e.d
        public void b(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
                SimpleDragSortListView.super.dispatchDraw(canvas);
            }
        }

        @Override // c.a.p0.d1.e.d
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
                SimpleDragSortListView.super.onDraw(canvas);
            }
        }

        @Override // c.a.p0.d1.e.d
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) ? SimpleDragSortListView.super.onInterceptTouchEvent(motionEvent) : invokeL.booleanValue;
        }

        @Override // c.a.p0.d1.e.d
        public void onMeasure(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
                SimpleDragSortListView.super.onMeasure(i2, i3);
            }
        }

        @Override // c.a.p0.d1.e.d
        public void onSizeChanged(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
                SimpleDragSortListView.super.onSizeChanged(i2, i3, i4, i5);
            }
        }

        @Override // c.a.p0.d1.e.d
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) ? SimpleDragSortListView.super.onTouchEvent(motionEvent) : invokeL.booleanValue;
        }

        @Override // c.a.p0.d1.e.d
        public void requestLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                SimpleDragSortListView.super.requestLayout();
            }
        }

        @Override // c.a.p0.d1.e.d
        public void setAdapter(ListAdapter listAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, listAdapter) == null) {
                SimpleDragSortListView.super.setAdapter(listAdapter);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleDragSortListView(Context context, AttributeSet attributeSet) {
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
        this.M = new a(this);
        this.L = attributeSet;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            c cVar = this.K;
            if (cVar != null) {
                cVar.b(canvas);
            } else {
                super.dispatchDraw(canvas);
            }
        }
    }

    public d getViewSuperMethods() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.M : (d) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c cVar = this.K;
            if (cVar != null) {
                cVar.a();
            } else {
                super.layoutChildren();
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            c cVar = this.K;
            if (cVar != null) {
                cVar.onDraw(canvas);
            } else {
                super.onDraw(canvas);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            c cVar = this.K;
            if (cVar != null) {
                return cVar.onInterceptTouchEvent(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            c cVar = this.K;
            if (cVar != null) {
                cVar.onMeasure(i2, i3);
            } else {
                super.onMeasure(i2, i3);
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i2, i3, i4, i5) == null) {
            c cVar = this.K;
            if (cVar != null) {
                cVar.onSizeChanged(i2, i3, i4, i5);
            } else {
                super.onSizeChanged(i2, i3, i4, i5);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            c cVar = this.K;
            if (cVar != null) {
                return cVar.onTouchEvent(motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            c cVar = this.K;
            if (cVar != null) {
                cVar.requestLayout();
            } else {
                super.requestLayout();
            }
        }
    }

    public void setDragSortViewEventDelegate(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.K = cVar;
            cVar.c(this, getContext(), this.L);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, listAdapter) == null) {
            c cVar = this.K;
            if (cVar != null) {
                cVar.setAdapter(listAdapter);
            } else {
                super.setAdapter(listAdapter);
            }
        }
    }
}

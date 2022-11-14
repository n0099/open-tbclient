package com.baidu.tbadk.widget.dragsort;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.sk5;
import com.baidu.tieba.tk5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SimpleDragSortListView extends BdListView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sk5 G;
    public AttributeSet H;
    public final tk5 I;

    /* loaded from: classes3.dex */
    public class a implements tk5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SimpleDragSortListView a;

        public a(SimpleDragSortListView simpleDragSortListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {simpleDragSortListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = simpleDragSortListView;
        }

        @Override // com.baidu.tieba.tk5
        public void b(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) != null) {
                return;
            }
            SimpleDragSortListView.super.dispatchDraw(canvas);
        }

        @Override // com.baidu.tieba.tk5
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) != null) {
                return;
            }
            SimpleDragSortListView.super.onDraw(canvas);
        }

        @Override // com.baidu.tieba.tk5
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, motionEvent)) != null) {
                return invokeL.booleanValue;
            }
            return SimpleDragSortListView.super.onInterceptTouchEvent(motionEvent);
        }

        @Override // com.baidu.tieba.tk5
        public boolean onTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048582, this, motionEvent)) != null) {
                return invokeL.booleanValue;
            }
            return SimpleDragSortListView.super.onTouchEvent(motionEvent);
        }

        @Override // com.baidu.tieba.tk5
        public void setAdapter(ListAdapter listAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, listAdapter) != null) {
                return;
            }
            SimpleDragSortListView.super.setAdapter(listAdapter);
        }

        @Override // com.baidu.tieba.tk5
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            SimpleDragSortListView.super.layoutChildren();
        }

        @Override // com.baidu.tieba.tk5
        public void requestLayout() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048583, this) != null) {
                return;
            }
            SimpleDragSortListView.super.requestLayout();
        }

        @Override // com.baidu.tieba.tk5
        public void onMeasure(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048580, this, i, i2) != null) {
                return;
            }
            SimpleDragSortListView.super.onMeasure(i, i2);
        }

        @Override // com.baidu.tieba.tk5
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
                SimpleDragSortListView.super.onSizeChanged(i, i2, i3, i4);
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
        this.I = new a(this);
        this.H = attributeSet;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            sk5 sk5Var = this.G;
            if (sk5Var != null) {
                sk5Var.onMeasure(i, i2);
            } else {
                super.onMeasure(i, i2);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            sk5 sk5Var = this.G;
            if (sk5Var != null) {
                sk5Var.b(canvas);
            } else {
                super.dispatchDraw(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            sk5 sk5Var = this.G;
            if (sk5Var != null) {
                sk5Var.onDraw(canvas);
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
            sk5 sk5Var = this.G;
            if (sk5Var != null) {
                return sk5Var.onInterceptTouchEvent(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            sk5 sk5Var = this.G;
            if (sk5Var != null) {
                return sk5Var.onTouchEvent(motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setDragSortViewEventDelegate(sk5 sk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sk5Var) == null) {
            this.G = sk5Var;
            sk5Var.c(this, getContext(), this.H);
        }
    }

    public tk5 getViewSuperMethods() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.I;
        }
        return (tk5) invokeV.objValue;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            sk5 sk5Var = this.G;
            if (sk5Var != null) {
                sk5Var.a();
            } else {
                super.layoutChildren();
            }
        }
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            sk5 sk5Var = this.G;
            if (sk5Var != null) {
                sk5Var.requestLayout();
            } else {
                super.requestLayout();
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048582, this, i, i2, i3, i4) == null) {
            sk5 sk5Var = this.G;
            if (sk5Var != null) {
                sk5Var.onSizeChanged(i, i2, i3, i4);
            } else {
                super.onSizeChanged(i, i2, i3, i4);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, listAdapter) == null) {
            sk5 sk5Var = this.G;
            if (sk5Var != null) {
                sk5Var.setAdapter(listAdapter);
            } else {
                super.setAdapter(listAdapter);
            }
        }
    }
}

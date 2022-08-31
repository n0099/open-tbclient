package com.baidu.tieba;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.dragsort.SimpleDragSortListView;
import com.baidu.tieba.eg5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SimpleDragSortListView a;
    public final a b;
    public final eg5 c;

    /* loaded from: classes3.dex */
    public static class a extends fg5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int F;
        public int G;
        public ListView H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(eg5 eg5Var, ListView listView) {
            super(eg5Var, listView, 0, 2, 0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg5Var, listView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((eg5) objArr2[0], (ListView) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.F = 0;
            this.G = Integer.MAX_VALUE;
            s(false);
            this.H = listView;
        }

        @Override // com.baidu.tieba.ig5, com.baidu.tieba.eg5.j
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        @Override // com.baidu.tieba.fg5, com.baidu.tieba.eg5.j
        public void c(View view2, Point point, Point point2) {
            int top;
            int top2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, point, point2) == null) {
                int firstVisiblePosition = this.H.getFirstVisiblePosition();
                int dividerHeight = this.H.getDividerHeight();
                int headerViewsCount = (this.F - firstVisiblePosition) + this.H.getHeaderViewsCount();
                int headerViewsCount2 = (this.G - firstVisiblePosition) + this.H.getHeaderViewsCount();
                int childCount = this.H.getChildCount();
                View view3 = null;
                View childAt = (headerViewsCount < 0 || headerViewsCount >= childCount) ? null : this.H.getChildAt(headerViewsCount);
                if (headerViewsCount2 >= 0 && headerViewsCount2 < childCount) {
                    view3 = this.H.getChildAt(headerViewsCount2);
                }
                if (childAt != null && point.y < (top2 = childAt.getTop())) {
                    point.y = top2;
                }
                if (view3 == null || point.y <= (top = (view3.getTop() - dividerHeight) - view2.getHeight())) {
                    return;
                }
                point.y = top;
            }
        }

        @Override // com.baidu.tieba.fg5
        public int w(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                int n = super.n(motionEvent);
                int headerViewsCount = n - this.H.getHeaderViewsCount();
                if (headerViewsCount < this.F || headerViewsCount >= this.G) {
                    return -1;
                }
                return n;
            }
            return invokeL.intValue;
        }

        public void z(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
                this.F = i;
                this.G = i2;
            }
        }
    }

    public cq7(SimpleDragSortListView simpleDragSortListView) {
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
        eg5 eg5Var = new eg5(simpleDragSortListView, simpleDragSortListView.getViewSuperMethods());
        this.c = eg5Var;
        simpleDragSortListView.setDragSortViewEventDelegate(eg5Var);
        a aVar = new a(this.c, simpleDragSortListView);
        this.b = aVar;
        aVar.d(-1);
        this.c.s0(this.b);
        this.c.u0(this.b);
        simpleDragSortListView.setOnTouchListener(this.b);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.c.o0(z);
        }
    }

    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            this.b.z(i, i2);
        }
    }

    public void c(eg5.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iVar) == null) {
            this.c.t0(iVar);
        }
    }
}

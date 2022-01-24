package com.baidu.tieba.frs.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f43882b;

    /* renamed from: c  reason: collision with root package name */
    public int f43883c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43884d;

    public GridSpacingItemDecoration(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i2;
        this.f43882b = i3;
        this.f43883c = i4;
        this.f43884d = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i2 = this.a;
            int i3 = childAdapterPosition % i2;
            if (this.f43884d) {
                int i4 = this.f43882b;
                rect.left = i4 - ((i3 * i4) / i2);
                rect.right = ((i3 + 1) * i4) / i2;
                if (childAdapterPosition < i2) {
                    rect.top = i4;
                }
                rect.bottom = this.f43882b;
                return;
            }
            int i5 = this.f43882b;
            rect.left = (i3 * i5) / i2;
            rect.right = i5 - (((i3 + 1) * i5) / i2);
            if (childAdapterPosition >= i2) {
                rect.top = this.f43883c;
            }
        }
    }
}

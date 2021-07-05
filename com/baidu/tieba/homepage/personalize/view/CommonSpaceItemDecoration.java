package com.baidu.tieba.homepage.personalize.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CommonSpaceItemDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f16748a;

    /* renamed from: b  reason: collision with root package name */
    public int f16749b;

    /* renamed from: c  reason: collision with root package name */
    public int f16750c;

    public CommonSpaceItemDecoration(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16748a = i2;
        this.f16749b = i3;
        this.f16750c = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
            super.getItemOffsets(rect, view, recyclerView, state);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.f16748a;
                } else {
                    rect.top = this.f16749b;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.f16750c;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.f16748a;
            } else {
                rect.left = this.f16749b;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.f16750c;
            }
        }
    }
}

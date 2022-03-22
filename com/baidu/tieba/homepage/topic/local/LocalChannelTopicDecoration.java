package com.baidu.tieba.homepage.topic.local;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class LocalChannelTopicDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33515b;

    /* renamed from: c  reason: collision with root package name */
    public ColorDrawable f33516c;

    public LocalChannelTopicDecoration() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds3);
        this.f33515b = n.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
        this.f33516c = new ColorDrawable(SkinManager.getColor(R.color.CAM_X0203));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view, recyclerView, state) == null) {
            super.getItemOffsets(rect, view, recyclerView, state);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
            if (childLayoutPosition != -1 && (layoutManager instanceof LinearLayoutManager)) {
                if (childLayoutPosition == state.getItemCount() - 1) {
                    rect.set(0, 0, 0, 0);
                } else {
                    rect.set(0, 0, 0, this.a);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, recyclerView, state) == null) {
            super.onDraw(canvas, recyclerView, state);
            for (int i = 0; i < recyclerView.getChildCount() - 1; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != null) {
                    int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
                    this.f33516c.setBounds(this.f33515b, bottom, recyclerView.getWidth() - this.f33515b, this.a + bottom);
                    this.f33516c.draw(canvas);
                }
            }
        }
    }
}

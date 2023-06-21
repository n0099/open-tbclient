package com.baidu.tieba.homepage.topic.local;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class LocalChannelTopicDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public ColorDrawable c;

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
        this.a = wi.g(TbadkCoreApplication.getInst(), R.dimen.tbds3);
        this.b = wi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X007);
        this.c = new ColorDrawable(SkinManager.getColor(R.color.CAM_X0203));
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.c = new ColorDrawable(SkinManager.getColor(R.color.CAM_X0203));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view2, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect, view2, recyclerView, state) == null) {
            super.getItemOffsets(rect, view2, recyclerView, state);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view2);
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
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, canvas, recyclerView, state) == null) {
            super.onDraw(canvas, recyclerView, state);
            for (int i = 0; i < recyclerView.getChildCount() - 1; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != null) {
                    int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
                    this.c.setBounds(this.b, bottom, recyclerView.getWidth() - this.b, this.a + bottom);
                    this.c.draw(canvas);
                }
            }
        }
    }
}

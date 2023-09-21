package com.baidu.tieba.im.base.core.tag;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class TagGridLayoutManager extends GridLayoutManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    @NonNull
    public final RecyclerView b;
    public final List<Integer> c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TagGridLayoutManager(Context context, @NonNull RecyclerView recyclerView, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, recyclerView, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.c = new ArrayList();
        this.b = recyclerView;
    }

    public final void a() {
        int itemCount;
        int decoratedBottom;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (itemCount = getItemCount()) == 0) {
            return;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = itemCount - 1; i2 >= 0; i2--) {
            View findViewByPosition = findViewByPosition(i2);
            if (findViewByPosition != null && (decoratedBottom = getDecoratedBottom(findViewByPosition)) < i) {
                this.c.add(Integer.valueOf(i2));
                i = decoratedBottom;
            }
        }
        int measuredWidth = this.b.getMeasuredWidth();
        for (int i3 = 0; i3 < this.c.size(); i3++) {
            int intValue = this.c.get(i3).intValue();
            View findViewByPosition2 = findViewByPosition(intValue);
            if (findViewByPosition2 != null && measuredWidth > 0) {
                int decoratedRight = measuredWidth - getDecoratedRight(findViewByPosition2);
                if (i3 == this.c.size() - 1) {
                    b(decoratedRight, intValue, 0);
                } else {
                    b(decoratedRight, intValue, this.c.get(i3 + 1).intValue() + 1);
                }
            }
        }
        this.c.clear();
    }

    public final void b(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3) == null) {
            while (i2 >= i3) {
                View findViewByPosition = findViewByPosition(i2);
                if (findViewByPosition != null) {
                    findViewByPosition.offsetLeftAndRight(i);
                }
                i2--;
            }
        }
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, state) == null) {
            super.onLayoutCompleted(state);
            if (this.a) {
                a();
            }
        }
    }
}

package com.baidu.tieba.frs.recommend;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class FrsLikeRecommendDecoration extends RecyclerView.ItemDecoration {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    public FrsLikeRecommendDecoration() {
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
        this.a = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X004);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view2, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, rect, view2, recyclerView, state) == null) {
            super.getItemOffsets(rect, view2, recyclerView, state);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int childLayoutPosition = recyclerView.getChildLayoutPosition(view2);
            if (childLayoutPosition != -1 && (layoutManager instanceof LinearLayoutManager)) {
                if (childLayoutPosition == state.getItemCount() - 1) {
                    rect.set(0, 0, 0, 0);
                } else {
                    rect.set(0, 0, this.a, 0);
                }
            }
        }
    }
}

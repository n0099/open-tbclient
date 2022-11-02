package com.baidu.tieba;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.sina.weibo.sdk.utils.ResourceManager;
import java.util.List;
/* loaded from: classes3.dex */
public class dx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Rect a(co coVar, View view2, int i) {
        InterceptResult invokeLLI;
        BdTypeRecyclerView bdTypeRecyclerView;
        RecyclerView.LayoutManager layoutManager;
        int i2;
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, coVar, view2, i)) == null) {
            if (view2.getTag() instanceof AutoVideoCardViewHolder) {
                return ThreadCardUtils.computeViewArea(((AutoVideoCardViewHolder) view2.getTag()).t().getVideoContainer());
            }
            if (!(coVar instanceof BdTypeRecyclerView) || (layoutManager = (bdTypeRecyclerView = (BdTypeRecyclerView) coVar).getLayoutManager()) == null) {
                return null;
            }
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            List<wn> data = coVar.getData();
            Object item = ListUtils.getItem(data, i);
            if (!(item instanceof BaseCardInfo)) {
                return null;
            }
            BaseCardInfo baseCardInfo = (BaseCardInfo) item;
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
            if (firstVisiblePosition > headerViewsCount) {
                i2 = firstVisiblePosition - headerViewsCount;
            } else {
                i2 = headerViewsCount;
            }
            while (i2 <= lastVisiblePosition) {
                Object item2 = ListUtils.getItem(data, i2 - headerViewsCount);
                if ((item2 instanceof BaseCardInfo) && baseCardInfo.position == ((BaseCardInfo) item2).position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null && (findViewByPosition.getTag() instanceof AutoVideoCardViewHolder)) {
                    return ThreadCardUtils.computeViewArea(((AutoVideoCardViewHolder) findViewByPosition.getTag()).t().getVideoContainer());
                }
                i2++;
            }
            return null;
        }
        return (Rect) invokeLLI.objValue;
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            Resources resources = TbadkCoreApplication.getInst().getResources();
            return resources.getIdentifier("icon_mask_level_usergrouth_" + i, ResourceManager.DRAWABLE, TbadkCoreApplication.getInst().getPackageName());
        }
        return invokeI.intValue;
    }
}

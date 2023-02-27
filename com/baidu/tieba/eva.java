package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class eva {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i, View view2, GridView gridView) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(65536, null, i, view2, gridView) == null) && i != 0 && gridView != null && view2 != null) {
            if (i >= 3) {
                i2 = 82;
            } else {
                i2 = 110;
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            gridView.setNumColumns(3);
                            layoutParams.width = wua.a((i2 * 3) + 14);
                        } else {
                            gridView.setNumColumns(2);
                            layoutParams.width = wua.a((i2 * 2) + 7);
                        }
                    } else {
                        gridView.setNumColumns(3);
                        layoutParams.width = wua.a((i2 * 3) + 14);
                    }
                } else {
                    gridView.setNumColumns(2);
                    layoutParams.width = wua.a((i2 * 2) + 7);
                }
            } else {
                gridView.setNumColumns(1);
                layoutParams.width = wua.a(i2);
            }
            view2.setLayoutParams(layoutParams);
        }
    }
}

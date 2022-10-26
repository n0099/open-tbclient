package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: TopViewLogic.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class as6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, view2) == null) {
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0204);
        }
    }

    public static void b(TextView textView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, textView, i) == null) {
            Context context = textView.getContext();
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(fj.f(context, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(i).into(textView);
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            textView.setTextSize(0, fj.f(context, R.dimen.T_X10));
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = fj.f(context, R.dimen.tbds74);
            layoutParams.height = fj.f(context, R.dimen.tbds40);
        }
    }
}

package com.baidu.tieba;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dab implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Spannable a;
    public uy5 b;

    public dab(Spannable spannable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spannable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.a = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        uy5 uy5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (!(view2 instanceof TextView)) {
                return false;
            }
            TextView textView = (TextView) view2;
            if (action == 3 && (uy5Var = this.b) != null) {
                uy5Var.m(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                view2.invalidate();
                this.b = null;
                return false;
            }
            if (action == 1 || action == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                Layout layout = textView.getLayout();
                if (layout == null) {
                    return false;
                }
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((y - textView.getTotalPaddingTop()) + textView.getScrollY()), (x - textView.getTotalPaddingLeft()) + textView.getScrollX());
                Spannable spannable = this.a;
                if (spannable == null) {
                    return false;
                }
                uy5[] uy5VarArr = (uy5[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, uy5.class);
                if (uy5VarArr != null && uy5VarArr.length != 0 && uy5VarArr[0] != null) {
                    if (action == 1) {
                        uy5VarArr[0].m(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        uy5VarArr[0].onClick(textView);
                        view2.invalidate();
                    } else {
                        this.b = uy5VarArr[0];
                        Spannable spannable2 = this.a;
                        Selection.setSelection(spannable2, spannable2.getSpanStart(uy5VarArr[0]), this.a.getSpanEnd(uy5VarArr[0]));
                        view2.invalidate();
                    }
                    return true;
                }
                uy5 uy5Var2 = this.b;
                if (uy5Var2 != null) {
                    uy5Var2.m(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                    view2.invalidate();
                }
                Selection.removeSelection(this.a);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

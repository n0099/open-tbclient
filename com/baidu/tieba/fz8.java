package com.baidu.tieba;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fz8 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Spannable a;
    public il5 b;
    public int c;

    public fz8(Spannable spannable) {
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
        this.c = 0;
        this.a = spannable;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        il5 il5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                if (action == 3 && (il5Var = this.b) != null) {
                    il5Var.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
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
                    il5[] il5VarArr = (il5[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, il5.class);
                    if (il5VarArr != null && il5VarArr.length != 0 && il5VarArr[0] != null) {
                        if (action == 1) {
                            il5VarArr[0].g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                            il5VarArr[0].onClick(textView);
                            view2.invalidate();
                        } else {
                            il5 il5Var2 = il5VarArr[0];
                            this.b = il5Var2;
                            if (il5Var2.e()) {
                                int i = this.c;
                                if (i != 0) {
                                    il5VarArr[0].g(SkinManager.getColor(i));
                                } else if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                    il5VarArr[0].g(SkinManager.getColor(R.color.CAM_X0204));
                                } else {
                                    il5VarArr[0].g(SkinManager.getColor(R.color.cp_bg_line_z));
                                }
                            }
                            Spannable spannable2 = this.a;
                            Selection.setSelection(spannable2, spannable2.getSpanStart(il5VarArr[0]), this.a.getSpanEnd(il5VarArr[0]));
                            view2.invalidate();
                        }
                        return true;
                    }
                    il5 il5Var3 = this.b;
                    if (il5Var3 != null) {
                        il5Var3.g(TbadkCoreApplication.getInst().getResources().getColor(R.color.transparent));
                        view2.invalidate();
                    }
                    Selection.removeSelection(this.a);
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}

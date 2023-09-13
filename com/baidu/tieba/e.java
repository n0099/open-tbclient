package com.baidu.tieba;

import android.content.Context;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e extends ArrayAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, int i, Object[] objArr) {
        super(context, i, objArr);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr2 = {context, Integer.valueOf(i), objArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr3 = newInitContext.callArgs;
                super((Context) objArr3[0], ((Integer) objArr3[1]).intValue(), (Object[]) objArr3[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        TextPaint paint;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i, view2, viewGroup)) == null) {
            View dropDownView = super.getDropDownView(i, view2, viewGroup);
            TextView textView = (TextView) dropDownView;
            if (this.a == i) {
                textView.setTextColor(-13158591);
                paint = textView.getPaint();
                z = true;
            } else {
                textView.setTextColor(-9605779);
                paint = textView.getPaint();
                z = false;
            }
            paint.setFakeBoldText(z);
            return dropDownView;
        }
        return (View) invokeILL.objValue;
    }
}

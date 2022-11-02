package com.baidu.tieba;

import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupForegroundColorSpan;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;
    public String b;

    public b59() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public ArrayList<String> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public boolean a(EditText editText) {
        InterceptResult invokeL;
        Editable text;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, editText)) == null) {
            if (editText == null || (text = editText.getText()) == null) {
                return false;
            }
            int d = d(text);
            if (d > 0) {
                editText.requestFocus();
                editText.setSelection(d);
                return true;
            }
            editText.setSelection(editText.getSelectionEnd());
            return false;
        }
        return invokeL.booleanValue;
    }

    public int d(Spanned spanned) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, spanned)) == null) {
            if (spanned == null) {
                return 0;
            }
            BackgroundColorSpan[] backgroundColorSpanArr = (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class);
            int length = spanned.length();
            if (backgroundColorSpanArr != null && backgroundColorSpanArr.length > 0) {
                return spanned.getSpanEnd(backgroundColorSpanArr[0]);
            }
            return length;
        }
        return invokeL.intValue;
    }

    public void m(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, arrayList) == null) {
            this.a = arrayList;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.b = str;
        }
    }

    public boolean b(EditText editText, EditText editText2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, editText, editText2)) == null) {
            if (ListUtils.isEmpty(c())) {
                return false;
            }
            if (!a(editText) && !a(editText2)) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void h(EditText editText, EditText editText2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, editText, editText2) == null) {
            i(editText, true);
            i(editText2, false);
            b(editText, editText2);
        }
    }

    public void i(EditText editText, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, editText, z) != null) || editText == null) {
            return;
        }
        f(editText, z);
    }

    public void l(EditText editText, EditText editText2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, editText, editText2) == null) {
            h(editText, editText2);
        }
    }

    public void f(EditText editText, boolean z) {
        Editable text;
        Object[] spans;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048581, this, editText, z) != null) || editText == null || (text = editText.getText()) == null) {
            return;
        }
        for (Object obj : text.getSpans(0, text.length(), Object.class)) {
            if (((obj instanceof ForegroundColorSpan) && !(obj instanceof SpanGroupForegroundColorSpan)) || (obj instanceof BackgroundColorSpan)) {
                text.removeSpan(obj);
            }
        }
        ki5.j(text);
        j(text);
    }

    public void g(SpanGroupEditText spanGroupEditText) {
        Editable text;
        Object[] spans;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, spanGroupEditText) != null) || spanGroupEditText == null || (text = spanGroupEditText.getText()) == null) {
            return;
        }
        for (Object obj : text.getSpans(0, text.length(), Object.class)) {
            if ((obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan)) {
                text.removeSpan(obj);
            }
        }
        ki5.k(spanGroupEditText);
    }

    public final void j(Spannable spannable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, spannable) == null) && spannable != null && !ListUtils.isEmpty(this.a)) {
            String obj = spannable.toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            Iterator<String> it = this.a.iterator();
            while (it.hasNext()) {
                k(spannable, obj, it.next());
            }
        }
    }

    public final void k(Spannable spannable, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048586, this, spannable, str, str2) == null) && spannable != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int indexOf = str.indexOf(str2);
            int length = str2.length();
            while (indexOf >= 0) {
                int i = indexOf + length;
                int color = SkinManager.getColor(R.color.CAM_X0101);
                int color2 = SkinManager.getColor(R.color.cp_cont_h_alpha85);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
                BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(color2);
                spannable.setSpan(foregroundColorSpan, indexOf, i, 33);
                spannable.setSpan(backgroundColorSpan, indexOf, i, 33);
                indexOf = str.indexOf(str2, i);
            }
        }
    }
}

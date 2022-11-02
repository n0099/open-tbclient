package com.baidu.tbadk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"WrongCall"})
/* loaded from: classes3.dex */
public class TbListTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final List<Object> b;
        public final List<Object> c;

        public a(boolean z, List<Object> list, List<Object> list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = list;
            this.c = list2;
        }

        public static a a(List<Object> list, List<Object> list2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, list2)) == null) {
                return new a(true, list, list2);
            }
            return (a) invokeLL.objValue;
        }

        public static a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return new a(false, null, null);
            }
            return (a) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbListTextView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbListTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbListTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = true;
    }

    public final a a(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, spannableStringBuilder, i, i2)) == null) {
            Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), Object.class);
            ArrayList arrayList = new ArrayList(spans.length);
            ArrayList arrayList2 = new ArrayList(spans.length);
            for (Object obj : spans) {
                int spanStart = spannableStringBuilder.getSpanStart(obj);
                if (e(spannableStringBuilder, spanStart - 1)) {
                    spannableStringBuilder.insert(spanStart, " ");
                    arrayList.add(obj);
                }
                int spanEnd = spannableStringBuilder.getSpanEnd(obj);
                if (e(spannableStringBuilder, spanEnd)) {
                    spannableStringBuilder.insert(spanEnd, " ");
                    arrayList2.add(obj);
                }
                try {
                    g(spannableStringBuilder, i, i2);
                    return a.a(arrayList, arrayList2);
                } catch (IndexOutOfBoundsException e) {
                    BdLog.e(e.getMessage());
                }
            }
            return a.b();
        }
        return (a) invokeLII.objValue;
    }

    public final void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            g(getText().toString(), i, i2);
        }
    }

    public final void c(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            CharSequence text = getText();
            if (text instanceof Spanned) {
                d(new SpannableStringBuilder(text), i, i2);
            } else {
                b(i, i2);
            }
        }
    }

    public final boolean e(CharSequence charSequence, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, charSequence, i)) == null) {
            if (charSequence == null || i < 0 || i >= charSequence.length() || charSequence.charAt(i) != ' ') {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            try {
                super.onMeasure(i, i2);
            } catch (IndexOutOfBoundsException unused) {
                c(i, i2);
            }
        }
    }

    public final void d(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, spannableStringBuilder, i, i2) == null) {
            a a2 = a(spannableStringBuilder, i, i2);
            if (a2.a) {
                f(i, i2, spannableStringBuilder, a2);
            } else {
                b(i, i2);
            }
        }
    }

    public final void g(CharSequence charSequence, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, charSequence, i, i2) == null) {
            setText(charSequence);
            super.onMeasure(i, i2);
        }
    }

    public final void f(int i, int i2, SpannableStringBuilder spannableStringBuilder, a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), spannableStringBuilder, aVar}) == null) {
            for (Object obj : aVar.c) {
                int spanEnd = spannableStringBuilder.getSpanEnd(obj);
                spannableStringBuilder.delete(spanEnd, spanEnd + 1);
                try {
                    g(spannableStringBuilder, i, i2);
                } catch (IndexOutOfBoundsException unused) {
                    spannableStringBuilder.insert(spanEnd, " ");
                }
            }
            loop1: while (true) {
                z = true;
                for (Object obj2 : aVar.b) {
                    int spanStart = spannableStringBuilder.getSpanStart(obj2);
                    int i3 = spanStart - 1;
                    spannableStringBuilder.delete(i3, spanStart);
                    try {
                        g(spannableStringBuilder, i, i2);
                        z = false;
                    } catch (IndexOutOfBoundsException unused2) {
                        spannableStringBuilder.insert(i3, " ");
                    }
                }
                break loop1;
            }
            if (z) {
                setText(spannableStringBuilder);
                super.onMeasure(i, i2);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            if (!this.a) {
                return super.onTouchEvent(motionEvent);
            }
            setLongClickable(false);
            super.onTouchEvent(motionEvent);
            if (motionEvent.getAction() != 0 || !hasSelection()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setCheckSelection(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.a = z;
        }
    }
}

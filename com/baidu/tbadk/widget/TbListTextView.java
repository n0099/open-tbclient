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
/* loaded from: classes6.dex */
public class TbListTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48485e;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final boolean f48486a;

        /* renamed from: b  reason: collision with root package name */
        public final List<Object> f48487b;

        /* renamed from: c  reason: collision with root package name */
        public final List<Object> f48488c;

        public a(boolean z, List<Object> list, List<Object> list2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), list, list2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48486a = z;
            this.f48487b = list;
            this.f48488c = list2;
        }

        public static a a(List<Object> list, List<Object> list2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, list2)) == null) ? new a(true, list, list2) : (a) invokeLL.objValue;
        }

        public static a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new a(false, null, null) : (a) invokeV.objValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48485e = true;
    }

    public final a a(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, spannableStringBuilder, i2, i3)) == null) {
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
                    g(spannableStringBuilder, i2, i3);
                    return a.a(arrayList, arrayList2);
                } catch (IndexOutOfBoundsException e2) {
                    BdLog.e(e2.getMessage());
                }
            }
            return a.b();
        }
        return (a) invokeLII.objValue;
    }

    public final void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            g(getText().toString(), i2, i3);
        }
    }

    public final void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            CharSequence text = getText();
            if (text instanceof Spanned) {
                d(new SpannableStringBuilder(text), i2, i3);
            } else {
                b(i2, i3);
            }
        }
    }

    public final void d(SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048579, this, spannableStringBuilder, i2, i3) == null) {
            a a2 = a(spannableStringBuilder, i2, i3);
            if (a2.f48486a) {
                f(i2, i3, spannableStringBuilder, a2);
            } else {
                b(i2, i3);
            }
        }
    }

    public final boolean e(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, charSequence, i2)) == null) ? charSequence == null || i2 < 0 || i2 >= charSequence.length() || charSequence.charAt(i2) != ' ' : invokeLI.booleanValue;
    }

    public final void f(int i2, int i3, SpannableStringBuilder spannableStringBuilder, a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), spannableStringBuilder, aVar}) == null) {
            for (Object obj : aVar.f48488c) {
                int spanEnd = spannableStringBuilder.getSpanEnd(obj);
                spannableStringBuilder.delete(spanEnd, spanEnd + 1);
                try {
                    g(spannableStringBuilder, i2, i3);
                } catch (IndexOutOfBoundsException unused) {
                    spannableStringBuilder.insert(spanEnd, " ");
                }
            }
            loop1: while (true) {
                z = true;
                for (Object obj2 : aVar.f48487b) {
                    int spanStart = spannableStringBuilder.getSpanStart(obj2);
                    int i4 = spanStart - 1;
                    spannableStringBuilder.delete(i4, spanStart);
                    try {
                        g(spannableStringBuilder, i2, i3);
                        z = false;
                    } catch (IndexOutOfBoundsException unused2) {
                        spannableStringBuilder.insert(i4, " ");
                    }
                }
                break loop1;
            }
            if (z) {
                setText(spannableStringBuilder);
                super.onMeasure(i2, i3);
            }
        }
    }

    public final void g(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, charSequence, i2, i3) == null) {
            setText(charSequence);
            super.onMeasure(i2, i3);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            try {
                super.onMeasure(i2, i3);
            } catch (IndexOutOfBoundsException unused) {
                c(i2, i3);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            if (!this.f48485e) {
                return super.onTouchEvent(motionEvent);
            }
            setLongClickable(false);
            super.onTouchEvent(motionEvent);
            return motionEvent.getAction() == 0 && hasSelection();
        }
        return invokeL.booleanValue;
    }

    public void setCheckSelection(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f48485e = z;
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48485e = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbListTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f48485e = true;
    }
}

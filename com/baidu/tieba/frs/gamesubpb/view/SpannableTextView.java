package com.baidu.tieba.frs.gamesubpb.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.u0.v1.a;
import d.a.q0.u0.v1.d.d;
/* loaded from: classes4.dex */
public class SpannableTextView extends TextView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f15841e;

    /* renamed from: f  reason: collision with root package name */
    public int f15842f;

    /* renamed from: g  reason: collision with root package name */
    public int f15843g;

    /* renamed from: h  reason: collision with root package name */
    public int f15844h;

    /* renamed from: i  reason: collision with root package name */
    public int f15845i;
    public long j;
    public int k;
    public boolean l;
    public a.InterfaceC1734a m;

    /* loaded from: classes4.dex */
    public static class a extends LinkMovementMethod {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f15846a;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                if (f15846a == null) {
                    f15846a = new a();
                }
                return f15846a;
            }
            return (a) invokeV.objValue;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, textView, spannable, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action != 1 && action != 0) {
                    return Touch.onTouchEvent(textView, spannable, motionEvent);
                }
                int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
                int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
                int scrollX = x + textView.getScrollX();
                int scrollY = y + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                Object[] objArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (objArr.length != 0) {
                    if (action == 1) {
                        objArr[0].onClick(textView);
                    } else if (action == 0) {
                        Selection.setSelection(spannable, spannable.getSpanStart(objArr[0]), spannable.getSpanEnd(objArr[0]));
                    }
                    if (textView instanceof SpannableTextView) {
                        ((SpannableTextView) textView).l = true;
                    }
                    return true;
                }
                Selection.removeSelection(spannable);
                super.onTouchEvent(textView, spannable, motionEvent);
                return false;
            }
            return invokeLLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d f15847e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SpannableTextView f15848f;

        public b(SpannableTextView spannableTextView, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableTextView, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15848f = spannableTextView;
            this.f15847e = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15848f.m == null) {
                return;
            }
            this.f15848f.m.a(this.f15847e);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f15848f.f15844h);
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d f15849e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SpannableTextView f15850f;

        public c(SpannableTextView spannableTextView, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spannableTextView, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15850f = spannableTextView;
            this.f15849e = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f15850f.m == null) {
                return;
            }
            this.f15850f.m.b(this.f15849e);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(this.f15850f.f15841e);
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpannableTextView(Context context) {
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
        h();
    }

    public void e(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            setText(g(dVar));
            setMovementMethod(a.a());
        }
    }

    public final int f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            Rect rect = new Rect();
            getPaint().getTextBounds(str, 0, str.length(), rect);
            return rect.width();
        }
        return invokeL.intValue;
    }

    public final SpannableString g(d dVar) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar)) == null) {
            String str3 = dVar.f64565h;
            int length = str3 != null ? str3.length() : 0;
            if (dVar.k) {
                str = dVar.f64565h + "  楼主: ";
            } else {
                str = dVar.f64565h + ": ";
            }
            String str4 = dVar.f64566i;
            int length2 = str4 != null ? str4.length() : 0;
            int f2 = f(str + str4);
            int f3 = f("|" + dVar.j);
            int i2 = this.k;
            if ((f2 % i2) + f3 >= i2) {
                str2 = "\n" + dVar.j;
            } else {
                str2 = " " + dVar.j;
            }
            int length3 = str2 != null ? str2.length() : 0;
            boolean equals = String.valueOf(this.j).equals(dVar.f64564g);
            String str5 = "|  删除";
            if (equals) {
                int f4 = f(str + str4 + str2);
                int f5 = f("|  删除");
                int i3 = this.k;
                str5 = (f4 % i3) + f5 >= i3 ? "\n删除" : "  删除";
            }
            int length4 = str5.length();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str4);
            sb.append(str2);
            if (!equals) {
                str5 = "";
            }
            sb.append(str5);
            sb.append(equals ? "|" : "");
            SpannableString spannableString = new SpannableString(sb.toString());
            int i4 = length + 0;
            spannableString.setSpan(new c(this, dVar), 0, i4, 17);
            if (dVar.k) {
                int i5 = i4 + 4;
                spannableString.setSpan(new ForegroundColorSpan(this.f15842f), i4, i5, 17);
                i4 = i5;
            }
            int i6 = i4 + 2 + length2;
            int i7 = length3 + i6;
            spannableString.setSpan(new ForegroundColorSpan(this.f15843g), i6, i7, 17);
            if (equals) {
                int i8 = length4 + i7;
                spannableString.setSpan(new b(this, dVar), i7, i8, 17);
                spannableString.setSpan(new ForegroundColorSpan(this.f15845i), i8, i8 + 1, 17);
            }
            return spannableString;
        }
        return (SpannableString) invokeL.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j = d.a.d.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), -1L);
            this.k = (l.k(getContext()) - (getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) - 20;
            i();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f15841e = SkinManager.getColor(R.color.CAM_X0304);
            this.f15842f = SkinManager.getColor(R.color.CAM_X0302);
            this.f15843g = SkinManager.getColor(R.color.CAM_X0109);
            this.f15844h = SkinManager.getColor(R.color.CAM_X0304);
            this.f15845i = SkinManager.getColor(R.color.CAM_X0201);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            this.l = false;
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean performClick() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.l) {
                return true;
            }
            return super.performClick();
        }
        return invokeV.booleanValue;
    }

    public void setClickListener(a.InterfaceC1734a interfaceC1734a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, interfaceC1734a) == null) {
            this.m = interfaceC1734a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpannableTextView(Context context, AttributeSet attributeSet) {
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
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpannableTextView(Context context, AttributeSet attributeSet, int i2) {
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
        h();
    }
}

package com.baidu.tbadk.youngster;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class PasswordView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditText f40259e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f40260f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f40261g;

    /* renamed from: h  reason: collision with root package name */
    public EditText f40262h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f40263i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f40264j;
    public ImageView k;
    public ImageView l;
    public ImageView m;
    public FrameLayout n;
    public List<EditText> o;
    public List<ImageView> p;
    public g q;
    public Map<EditText, List<TextWatcher>> r;
    public Runnable s;
    public Runnable t;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PasswordView f40265e;

        public a(PasswordView passwordView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passwordView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40265e = passwordView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f40265e.f40263i == null) {
                return;
            }
            n.L(this.f40265e.getContext(), this.f40265e.f40263i);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PasswordView f40266e;

        public b(PasswordView passwordView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passwordView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40266e = passwordView;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.f40266e.q) == null) {
                return;
            }
            gVar.onComplete();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PasswordView f40267e;

        public c(PasswordView passwordView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passwordView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40267e = passwordView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f40267e.showSoftKeyboard();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f40268e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f40269f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PasswordView f40270g;

        public d(PasswordView passwordView, ImageView imageView, EditText editText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passwordView, imageView, editText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40270g = passwordView;
            this.f40268e = imageView;
            this.f40269f = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable.length() > 0) {
                    this.f40268e.setVisibility(0);
                    this.f40270g.n(this.f40269f);
                    this.f40269f.requestFocus();
                    this.f40270g.f40263i = this.f40269f;
                    return;
                }
                this.f40268e.setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImageView f40271e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PasswordView f40272f;

        public e(PasswordView passwordView, ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passwordView, imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40272f = passwordView;
            this.f40271e = imageView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable.length() > 0) {
                    this.f40271e.setVisibility(0);
                    c.a.d.f.m.e.a().post(this.f40272f.t);
                    return;
                }
                this.f40271e.setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditText f40273e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditText f40274f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ ImageView f40275g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PasswordView f40276h;

        public f(PasswordView passwordView, EditText editText, EditText editText2, ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passwordView, editText, editText2, imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40276h = passwordView;
            this.f40273e = editText;
            this.f40274f = editText2;
            this.f40275g = imageView;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view, i2, keyEvent)) == null) {
                if (i2 == 67 && keyEvent.getAction() == 0) {
                    if (this.f40273e.getText().length() > 0) {
                        this.f40273e.getText().clear();
                    } else {
                        this.f40274f.getText().clear();
                    }
                    this.f40275g.setVisibility(8);
                    this.f40276h.n(this.f40274f);
                    this.f40274f.requestFocus();
                    this.f40276h.f40263i = this.f40274f;
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void onComplete();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PasswordView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private Drawable getEditBackgroundDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setStroke(n.f(getContext(), R.dimen.tbds3), c.a.r0.y3.c.a(SkinManager.getColor(R.color.CAM_X0105), 0.16f));
            return gradientDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    private Drawable getEditDotDrawable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0107));
            return gradientDrawable;
        }
        return (Drawable) invokeV.objValue;
    }

    private void setEditBackgroundDrawable(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, editText) == null) {
            editText.setBackgroundDrawable(getEditBackgroundDrawable());
        }
    }

    private void setEditDotDrawable(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, imageView) == null) {
            imageView.setImageDrawable(getEditDotDrawable());
        }
    }

    public void clearPassword() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (EditText editText : this.o) {
                editText.getText().clear();
            }
            f();
            g();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            RelativeLayout.inflate(getContext(), R.layout.view_password, this);
            this.f40259e = (EditText) findViewById(R.id.edit_password_a);
            this.f40260f = (EditText) findViewById(R.id.edit_password_b);
            this.f40261g = (EditText) findViewById(R.id.edit_password_c);
            this.f40262h = (EditText) findViewById(R.id.edit_password_d);
            this.o.add(this.f40259e);
            this.o.add(this.f40260f);
            this.o.add(this.f40261g);
            this.o.add(this.f40262h);
            this.f40264j = (ImageView) findViewById(R.id.edit_dot_a);
            this.k = (ImageView) findViewById(R.id.edit_dot_b);
            this.l = (ImageView) findViewById(R.id.edit_dot_c);
            this.m = (ImageView) findViewById(R.id.edit_dot_d);
            this.p.add(this.f40264j);
            this.p.add(this.k);
            this.p.add(this.l);
            this.p.add(this.m);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.password_click);
            this.n = frameLayout;
            frameLayout.setOnClickListener(new c(this));
            k();
            i();
            g();
            f();
            onChangeSkinType();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            n(this.f40259e);
            this.f40259e.requestFocus();
            this.f40263i = this.f40259e;
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (ImageView imageView : this.p) {
                imageView.setVisibility(8);
            }
        }
    }

    public String getPassWord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            for (EditText editText : this.o) {
                sb.append(editText.getText().toString());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (EditText editText : this.o) {
                for (TextWatcher textWatcher : this.r.get(editText)) {
                    editText.removeTextChangedListener(textWatcher);
                }
            }
        }
    }

    public void hideSoftKeyboard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            n.w(getContext(), this.f40259e);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (int size = this.o.size() - 1; size > 0; size--) {
                j(this.o.get(size), this.o.get(size - 1), this.p.get(size));
            }
        }
    }

    public final void j(EditText editText, EditText editText2, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, editText, editText2, imageView) == null) {
            editText.setOnKeyListener(new f(this, editText, editText2, imageView));
        }
    }

    public final void k() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            int size = this.o.size();
            int i3 = 0;
            while (true) {
                i2 = size - 1;
                if (i3 >= i2) {
                    break;
                }
                int i4 = i3 + 1;
                m(this.o.get(i3), this.o.get(i4), this.p.get(i3));
                i3 = i4;
            }
            if (i2 >= 0) {
                l(this.o.get(i2), this.p.get(i2));
            }
        }
    }

    public final void l(EditText editText, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, editText, imageView) == null) {
            e eVar = new e(this, imageView);
            editText.addTextChangedListener(eVar);
            List<TextWatcher> list = this.r.get(editText);
            if (ListUtils.isEmpty(list)) {
                list = new ArrayList<>();
                this.r.put(editText, list);
            }
            list.add(eVar);
        }
    }

    public final void m(EditText editText, EditText editText2, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, editText, editText2, imageView) == null) {
            d dVar = new d(this, imageView, editText2);
            editText.addTextChangedListener(dVar);
            List<TextWatcher> list = this.r.get(editText);
            if (ListUtils.isEmpty(list)) {
                list = new ArrayList<>();
                this.r.put(editText, list);
            }
            list.add(dVar);
        }
    }

    public final void n(EditText editText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, editText) == null) || editText == null) {
            return;
        }
        for (EditText editText2 : this.o) {
            editText2.setFocusableInTouchMode(false);
        }
        editText.setFocusableInTouchMode(true);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (EditText editText : this.o) {
                setEditBackgroundDrawable(editText);
            }
            for (ImageView imageView : this.p) {
                setEditDotDrawable(imageView);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDetachedFromWindow();
            c.a.d.f.m.e.a().removeCallbacks(this.s);
            c.a.d.f.m.e.a().removeCallbacks(this.t);
            h();
        }
    }

    public void setOnPasswordInputComplete(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, gVar) == null) {
            this.q = gVar;
        }
    }

    public void showSoftKeyboard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.s);
            c.a.d.f.m.e.a().postDelayed(this.s, 300L);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PasswordView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasswordView(Context context, AttributeSet attributeSet, int i2) {
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
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.r = new HashMap();
        this.s = new a(this);
        this.t = new b(this);
        e();
    }
}

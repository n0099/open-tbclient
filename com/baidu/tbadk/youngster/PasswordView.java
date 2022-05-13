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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.di8;
import com.repackage.mi;
import com.repackage.ng;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class PasswordView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText a;
    public EditText b;
    public EditText c;
    public EditText d;
    public EditText e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public FrameLayout j;
    public List<EditText> k;
    public List<ImageView> l;
    public g m;
    public Map<EditText, List<TextWatcher>> n;
    public Runnable o;
    public Runnable p;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PasswordView a;

        public a(PasswordView passwordView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passwordView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = passwordView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.e == null) {
                return;
            }
            mi.L(this.a.getContext(), this.a.e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PasswordView a;

        public b(PasswordView passwordView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passwordView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = passwordView;
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (gVar = this.a.m) == null) {
                return;
            }
            gVar.onComplete();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PasswordView a;

        public c(PasswordView passwordView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passwordView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = passwordView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.q();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ PasswordView c;

        public d(PasswordView passwordView, ImageView imageView, EditText editText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passwordView, imageView, editText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = passwordView;
            this.a = imageView;
            this.b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable.length() > 0) {
                    this.a.setVisibility(0);
                    this.c.r(this.b);
                    this.b.requestFocus();
                    this.c.e = this.b;
                    return;
                }
                this.a.setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ PasswordView b;

        public e(PasswordView passwordView, ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passwordView, imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = passwordView;
            this.a = imageView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (editable.length() > 0) {
                    this.a.setVisibility(0);
                    ng.a().post(this.b.p);
                    return;
                }
                this.a.setVisibility(8);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditText a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ ImageView c;
        public final /* synthetic */ PasswordView d;

        public f(PasswordView passwordView, EditText editText, EditText editText2, ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {passwordView, editText, editText2, imageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = passwordView;
            this.a = editText;
            this.b = editText2;
            this.c = imageView;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                if (i == 67 && keyEvent.getAction() == 0) {
                    if (this.a.getText().length() > 0) {
                        this.a.getText().clear();
                    } else {
                        this.b.getText().clear();
                    }
                    this.c.setVisibility(8);
                    this.d.r(this.b);
                    this.b.requestFocus();
                    this.d.e = this.b;
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            gradientDrawable.setStroke(mi.f(getContext(), R.dimen.tbds3), di8.a(SkinManager.getColor(R.color.CAM_X0105), 0.16f));
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

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (EditText editText : this.k) {
                editText.getText().clear();
            }
            h();
            i();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            mi.w(getContext(), this.a);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            RelativeLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0889, this);
            this.a = (EditText) findViewById(R.id.obfuscated_res_0x7f090855);
            this.b = (EditText) findViewById(R.id.obfuscated_res_0x7f090856);
            this.c = (EditText) findViewById(R.id.obfuscated_res_0x7f090857);
            this.d = (EditText) findViewById(R.id.obfuscated_res_0x7f090858);
            this.k.add(this.a);
            this.k.add(this.b);
            this.k.add(this.c);
            this.k.add(this.d);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f09084d);
            this.g = (ImageView) findViewById(R.id.obfuscated_res_0x7f09084e);
            this.h = (ImageView) findViewById(R.id.obfuscated_res_0x7f09084f);
            this.i = (ImageView) findViewById(R.id.obfuscated_res_0x7f090850);
            this.l.add(this.f);
            this.l.add(this.g);
            this.l.add(this.h);
            this.l.add(this.i);
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091683);
            this.j = frameLayout;
            frameLayout.setOnClickListener(new c(this));
            n();
            l();
            i();
            h();
            j();
        }
    }

    public String getPassWord() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            for (EditText editText : this.k) {
                sb.append(editText.getText().toString());
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            r(this.a);
            this.a.requestFocus();
            this.e = this.a;
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (ImageView imageView : this.l) {
                imageView.setVisibility(8);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (EditText editText : this.k) {
                setEditBackgroundDrawable(editText);
            }
            for (ImageView imageView : this.l) {
                setEditDotDrawable(imageView);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (EditText editText : this.k) {
                for (TextWatcher textWatcher : this.n.get(editText)) {
                    editText.removeTextChangedListener(textWatcher);
                }
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (int size = this.k.size() - 1; size > 0; size--) {
                m(this.k.get(size), this.k.get(size - 1), this.l.get(size));
            }
        }
    }

    public final void m(EditText editText, EditText editText2, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, editText, editText2, imageView) == null) {
            editText.setOnKeyListener(new f(this, editText, editText2, imageView));
        }
    }

    public final void n() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int size = this.k.size();
            int i2 = 0;
            while (true) {
                i = size - 1;
                if (i2 >= i) {
                    break;
                }
                int i3 = i2 + 1;
                p(this.k.get(i2), this.k.get(i3), this.l.get(i2));
                i2 = i3;
            }
            if (i >= 0) {
                o(this.k.get(i), this.l.get(i));
            }
        }
    }

    public final void o(EditText editText, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, editText, imageView) == null) {
            e eVar = new e(this, imageView);
            editText.addTextChangedListener(eVar);
            List<TextWatcher> list = this.n.get(editText);
            if (ListUtils.isEmpty(list)) {
                list = new ArrayList<>();
                this.n.put(editText, list);
            }
            list.add(eVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDetachedFromWindow();
            ng.a().removeCallbacks(this.o);
            ng.a().removeCallbacks(this.p);
            k();
        }
    }

    public final void p(EditText editText, EditText editText2, ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, editText, editText2, imageView) == null) {
            d dVar = new d(this, imageView, editText2);
            editText.addTextChangedListener(dVar);
            List<TextWatcher> list = this.n.get(editText);
            if (ListUtils.isEmpty(list)) {
                list = new ArrayList<>();
                this.n.put(editText, list);
            }
            list.add(dVar);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ng.a().removeCallbacks(this.o);
            ng.a().postDelayed(this.o, 300L);
        }
    }

    public final void r(EditText editText) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, editText) == null) || editText == null) {
            return;
        }
        for (EditText editText2 : this.k) {
            editText2.setFocusableInTouchMode(false);
        }
        editText.setFocusableInTouchMode(true);
    }

    public void setOnPasswordInputComplete(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, gVar) == null) {
            this.m = gVar;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasswordView(Context context, AttributeSet attributeSet, int i) {
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
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.n = new HashMap();
        this.o = new a(this);
        this.p = new b(this);
        g();
    }
}

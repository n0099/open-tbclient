package com.baidu.tieba;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public View c;
    public View d;
    public TextView e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public EditText i;
    public SpanGroupEditText j;
    public View.OnClickListener k;
    public e l;
    public boolean m;

    /* loaded from: classes5.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes5.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bj7 a;

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

        /* loaded from: classes5.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        view2.getParent().requestDisallowInterceptTouchEvent(true);
                    } else if (motionEvent.getAction() == 1) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    } else if (motionEvent.getAction() == 3) {
                        view2.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        }

        public b(bj7 bj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bj7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                aj7.R(this.a.g, editable.toString().length(), 1000);
                if (this.a.l != null) {
                    this.a.l.a();
                }
                if (this.a.m) {
                    o75.d(this.a.i).w(R.color.CAM_X0105);
                    o75.d(this.a.j).w(R.color.CAM_X0105);
                    this.a.m = false;
                }
                if (this.a.j.getLineCount() > 6) {
                    this.a.j.setOnTouchListener(new a(this));
                } else {
                    this.a.j.setOnTouchListener(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bj7 a;

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

        public a(bj7 bj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bj7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                aj7.R(this.a.e, editable.toString().length(), 30);
                if (this.a.l != null) {
                    this.a.l.a();
                }
                if (this.a.m) {
                    o75.d(this.a.i).w(R.color.CAM_X0105);
                    o75.d(this.a.j).w(R.color.CAM_X0105);
                    this.a.m = false;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bj7 a;

        public c(bj7 bj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bj7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                vi.O(this.a.a, this.a.i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bj7 a;

        public d(bj7 bj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bj7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                vi.O(this.a.a, this.a.j);
            }
        }
    }

    public bj7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        n();
    }

    public final String i(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            return zi7.d(i + 1);
        }
        return (String) invokeI.objValue;
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.k = onClickListener;
            this.h.setOnClickListener(onClickListener);
        }
    }

    public void p(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.l = eVar;
        }
    }

    public void q(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (imageView = this.h) != null) {
            if (z) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.m = z;
        }
    }

    public void s(int i) {
        EditText editText;
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && (editText = this.i) != null && (context = this.a) != null) {
            editText.setHint(String.format(context.getString(R.string.obfuscated_res_0x7f0f07b9), i(i)));
        }
    }

    public void t(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (textView = this.f) != null) {
            textView.setText(String.format(this.a.getString(R.string.obfuscated_res_0x7f0f07bb), i(i)));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b != null) {
            o75.d(this.c).f(R.color.CAM_X0204);
            o75.d(this.d).f(R.color.CAM_X0210);
            o75 d2 = o75.d(this.f);
            d2.w(R.color.CAM_X0107);
            d2.C(R.string.F_X02);
            o75.d(this.e).w(R.color.CAM_X0111);
            this.h.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080b17, SkinManager.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.j.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            this.j.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0111));
            if (TbadkCoreApplication.getInst().getSkinType() == 0) {
                mea.l(this.i, R.drawable.edittext_cursor);
                mea.l(this.j, R.drawable.edittext_cursor);
                return;
            }
            mea.l(this.i, R.drawable.edittext_cursor_2);
            mea.l(this.j, R.drawable.edittext_cursor_2);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d02fc, (ViewGroup) null);
            this.b = inflate;
            this.c = inflate.findViewById(R.id.item_divider);
            this.f = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0911a3);
            this.h = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091162);
            this.i = (EditText) this.b.findViewById(R.id.obfuscated_res_0x7f0911a2);
            this.e = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0911a5);
            this.d = this.b.findViewById(R.id.obfuscated_res_0x7f0924a2);
            this.j = (SpanGroupEditText) this.b.findViewById(R.id.obfuscated_res_0x7f09115f);
            this.g = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091160);
            aj7.R(this.e, 0, 30);
            aj7.R(this.g, 0, 1000);
            this.i.addTextChangedListener(new a(this));
            this.j.addTextChangedListener(new b(this));
            this.i.setOnClickListener(new c(this));
            this.j.setOnClickListener(new d(this));
            j();
        }
    }

    public SpanGroupEditText k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (SpanGroupEditText) invokeV.objValue;
    }

    public EditText l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return (EditText) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }
}

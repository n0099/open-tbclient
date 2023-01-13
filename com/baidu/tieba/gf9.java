package com.baidu.tieba;

import android.content.Intent;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.md9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gf9 extends lf9<gg9> implements rf9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public View g;
    @Nullable
    public EditText h;
    @Nullable
    public TextView i;
    @Nullable
    public View j;
    @Nullable
    public mf9 k;
    @NonNull
    public final xg9 l;
    @NonNull
    public fe9 m;
    @Nullable
    public String n;
    public boolean o;
    public final TextWatcher p;
    public final View.OnFocusChangeListener q;

    @Override // com.baidu.tieba.rf9
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes4.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ gf9 b;

        public a(gf9 gf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gf9Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && editable != null && this.b.h != null && this.b.h.getText() != null) {
                if (this.b.n != null && this.b.n.equals(editable.toString())) {
                    this.b.h.setSelection(this.b.h.getSelectionEnd());
                    return;
                }
                gf9 gf9Var = this.b;
                gf9Var.n = gf9Var.h.getText().toString();
                if (this.b.e != null) {
                    this.b.e.setTitle(this.b.n);
                }
                if (this.b.b != null) {
                    this.b.b.i();
                }
                gf9 gf9Var2 = this.b;
                gf9Var2.m.i(gf9Var2.h, true);
                this.b.O(editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                if (charSequence != null) {
                    str = charSequence.toString();
                } else {
                    str = "";
                }
                this.a = str;
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                String str = this.a;
                int i5 = 0;
                if (str != null) {
                    i4 = str.length();
                } else {
                    i4 = 0;
                }
                if (charSequence != null) {
                    i5 = charSequence.toString().length();
                }
                if (i5 > i4) {
                    this.b.l.c(charSequence, i, i3, "from_title");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf9 a;

        public b(gf9 gf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gf9Var;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) && this.a.k != null) {
                this.a.k.q(this.a, z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf9 a;

        public c(gf9 gf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gf9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.h.setPadding(this.a.h.getPaddingLeft(), this.a.h.getPaddingTop(), this.a.h.getPaddingRight(), this.a.h.getPaddingBottom() + this.a.i.getHeight());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements md9.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gf9 a;

        public d(gf9 gf9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gf9Var;
        }

        @Override // com.baidu.tieba.md9.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zi.Q(TbadkCoreApplication.getInst(), String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f1688), 31));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gf9(@NonNull TbPageContext<?> tbPageContext, @NonNull fe9 fe9Var, @NonNull xg9 xg9Var) {
        super(tbPageContext, gg9.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, fe9Var, xg9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = true;
        this.p = new a(this);
        this.q = new b(this);
        this.m = fe9Var;
        this.l = xg9Var;
    }

    public void M(mf9 mf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mf9Var) == null) {
            this.k = mf9Var;
        }
    }

    public void P(int i) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (view2 = this.j) != null) {
            view2.setVisibility(i);
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.o = z;
        }
    }

    @Override // com.baidu.tieba.rf9
    public void b(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && !z && (editText = this.h) != null) {
            editText.clearFocus();
        }
    }

    @Override // com.baidu.tieba.qf9
    public void e(@NonNull WriteData writeData) {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, writeData) == null) && (editText = this.h) != null && editText.getText() != null) {
            writeData.setTitle(this.h.getText().toString());
        }
    }

    @Override // com.baidu.tieba.lf9, com.baidu.tieba.qf9
    public void j(@NonNull sf9 sf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, sf9Var) == null) {
            super.j(sf9Var);
            mf9 mf9Var = this.k;
            if (mf9Var != null) {
                mf9Var.l(this);
            }
            if (this.o) {
                l();
                sf9Var.o(true);
            }
        }
    }

    @Override // com.baidu.tieba.lf9, com.baidu.tieba.qf9
    public void h(@Nullable String str, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048587, this, str, writeData) != null) || StringUtils.isNull(str)) {
            return;
        }
        try {
            writeData.setTitle(new JSONObject(str).optString("t"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void L(String str) {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !StringUtils.isNull(str) && (editText = this.h) != null && editText.getText() != null) {
            this.l.f("");
            this.h.requestFocus();
            if (this.h.getText() != null && this.h.getText().length() + str.length() > 31) {
                this.a.showToast((int) R.string.over_limit_tip);
                return;
            }
            int selectionStart = this.h.getSelectionStart();
            Editable text = this.h.getText();
            if (selectionStart >= 0 && selectionStart <= text.length()) {
                text.insert(selectionStart, str);
            }
        }
    }

    public final void O(Editable editable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, editable) != null) || this.i == null) {
            return;
        }
        if (!TextUtils.isEmpty(editable)) {
            SpannableString spannableString = new SpannableString(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0975, new Object[]{Integer.valueOf(editable.length()), 31}));
            if (editable.length() > 31) {
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301)), 0, String.valueOf(editable.length()).length(), 17);
            }
            this.i.setText(spannableString);
            return;
        }
        this.i.setText(this.a.getPageActivity().getString(R.string.obfuscated_res_0x7f0f0975, new Object[]{0, 31}));
    }

    @Override // com.baidu.tieba.qf9
    public void a(@NonNull WriteData writeData) {
        WriteData writeData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) {
            WriteData writeData3 = this.e;
            if (writeData3 != null && yi.isEmpty(writeData3.getTitle())) {
                this.e.setTitle(writeData.getTitle());
            }
            if (this.h != null && (writeData2 = this.e) != null && !TextUtils.isEmpty(writeData2.getTitle())) {
                SpannableString i = ck5.i(this.e.getTitle());
                this.h.setText(i);
                this.h.setSelection(Math.min(Math.min(this.e.getTitle().length(), i.length()), this.h.getText().length()));
            }
        }
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            EditText editText = this.h;
            if (editText != null && editText.hasFocus()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.rf9
    public void l() {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (editText = this.h) != null) {
            editText.requestFocus();
        }
    }

    @Override // com.baidu.tieba.rf9
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m.f(this.h, true);
            this.m.a(this.h);
        }
    }

    @Override // com.baidu.tieba.rf9
    public EditText p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.h;
        }
        return (EditText) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lf9, com.baidu.tieba.qf9
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            EditText editText = this.h;
            if (editText != null && editText.getText() != null && this.h.getText().length() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qf9
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, writeData) == null) {
            EditText editText = this.h;
            if (editText != null && editText.getVisibility() == 0 && this.h.getText() != null) {
                String obj = this.h.getText().toString();
                writeData.setTitle(obj);
                writeData.setIsNoTitle(TextUtils.isEmpty(obj));
                return;
            }
            writeData.setTitle("");
            writeData.setIsNoTitle(true);
        }
    }

    @Override // com.baidu.tieba.lf9, com.baidu.tieba.qf9
    public boolean o() {
        InterceptResult invokeV;
        EditText editText;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.e == null || (editText = this.h) == null || editText.getText() == null) {
                return true;
            }
            if (14 == this.e.getType() && this.h.getText().toString().length() > 31) {
                sf9 sf9Var = this.b;
                if (sf9Var != null) {
                    sf9Var.d(this.a.getString(R.string.obfuscated_res_0x7f0f100b));
                }
                return false;
            } else if (!TextUtils.isEmpty(this.h.getText().toString()) && this.h.getText().toString().trim().length() >= 5) {
                return true;
            } else {
                if (this.b != null) {
                    if (14 == this.e.getType()) {
                        string = this.a.getString(R.string.obfuscated_res_0x7f0f100f);
                    } else {
                        string = this.a.getString(R.string.obfuscated_res_0x7f0f14d2);
                    }
                    this.b.d(string);
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lf9, com.baidu.tieba.qf9
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048592, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                if (i == 25004 && "from_title".equals(this.l.a())) {
                    L(this.l.d(intent));
                }
            } else if (i2 == 0 && i == 25004 && "from_title".equals(this.l.a())) {
                l();
            }
        }
    }

    @Override // com.baidu.tieba.qf9
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            EditText editText = this.h;
            if (editText != null) {
                SkinManager.setBackgroundColor(editText, R.color.CAM_X0205);
                this.h.setHintTextColor(SkinManager.getColor(R.color.CAM_X0110));
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
                O(this.h.getEditableText());
            }
            cx4.d(this.j).f(R.color.CAM_X0210);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0110);
        }
    }

    @Override // com.baidu.tieba.qf9
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0531, viewGroup, false);
            this.g = inflate;
            this.h = (EditText) inflate.findViewById(R.id.obfuscated_res_0x7f091b1e);
            this.i = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091bfc);
            this.j = this.g.findViewById(R.id.obfuscated_res_0x7f092332);
            EditText editText = this.h;
            if (editText != null) {
                editText.addTextChangedListener(this.p);
                this.h.setOnFocusChangeListener(this.q);
                WriteData writeData = this.e;
                if (writeData != null) {
                    if (14 == writeData.getType()) {
                        this.h.setHint(this.a.getString(R.string.obfuscated_res_0x7f0f100e));
                        this.h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
                        this.h.setSingleLine(false);
                        TextView textView = this.i;
                        if (textView != null) {
                            textView.setVisibility(0);
                            this.i.post(new c(this));
                        }
                    } else {
                        this.h.setFilters(new InputFilter[]{new md9.b(this.h, 31, new d(this))});
                        if (13 == this.e.getType()) {
                            this.h.setHint(R.string.obfuscated_res_0x7f0f14d1);
                        } else {
                            this.h.setHint(R.string.obfuscated_res_0x7f0f14d0);
                        }
                    }
                    if (this.e.getTitle() != null) {
                        this.h.setText(this.e.getTitle());
                        this.h.setSelection(this.e.getTitle().length());
                    }
                }
            }
            return this.g;
        }
        return (View) invokeL.objValue;
    }
}

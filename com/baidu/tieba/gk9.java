package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rva a;
    public rva b;
    public EditText c;
    public EditText d;
    public PostWriteCallBackData e;

    public gk9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        rva rvaVar = new rva();
        this.a = rvaVar;
        rvaVar.j(R.color.CAM_X0101);
        this.a.h(R.color.cp_cont_h_alpha85);
        rva rvaVar2 = new rva();
        this.b = rvaVar2;
        rvaVar2.j(R.color.CAM_X0101);
        this.b.h(R.color.cp_cont_h_alpha85);
    }

    public void a(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && (editText = this.c) != null && editText.getText() != null) {
            int selectionEnd = this.c.getSelectionEnd();
            SpannableStringBuilder f = this.a.f(this.c.getText());
            if (f != null) {
                boolean z2 = true;
                this.a.l(true);
                this.c.setText(f);
                if (z && this.a.b() >= 0) {
                    this.c.requestFocus();
                    this.c.setSelection(this.a.b());
                } else {
                    this.c.setSelection(selectionEnd);
                }
                rva rvaVar = this.a;
                if (rvaVar.b() < 0) {
                    z2 = false;
                }
                rvaVar.k(z2);
            }
        }
    }

    public void b(boolean z) {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (editText = this.d) != null && editText.getText() != null) {
            int selectionEnd = this.d.getSelectionEnd();
            SpannableStringBuilder f = this.b.f(this.d.getText());
            if (f != null) {
                boolean z2 = true;
                this.b.l(true);
                this.d.setText(f);
                if (z && this.b.b() >= 0) {
                    this.d.requestFocus();
                    this.d.setSelection(this.b.b());
                } else {
                    this.d.setSelection(selectionEnd);
                }
                rva rvaVar = this.b;
                if (rvaVar.b() < 0) {
                    z2 = false;
                }
                rvaVar.k(z2);
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.n(null);
            this.a.i(null);
            this.a.k(false);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.n(null);
            this.b.i(null);
            this.b.k(false);
        }
    }

    public rva e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (rva) invokeV.objValue;
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (EditText) invokeV.objValue;
    }

    public rva g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (rva) invokeV.objValue;
    }

    public PostWriteCallBackData h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (PostWriteCallBackData) invokeV.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.a.g();
            this.b.g();
            if (this.a.d()) {
                a(false);
            }
            if (this.b.d()) {
                b(false);
            }
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.c = null;
            this.d = null;
        }
    }

    public void k(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, postWriteCallBackData) != null) || postWriteCallBackData == null) {
            return;
        }
        this.a.i(postWriteCallBackData.getSensitiveWords());
        this.a.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.a.a())) {
            return;
        }
        a(true);
        this.e = postWriteCallBackData;
    }

    public void l(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, postWriteCallBackData) != null) || postWriteCallBackData == null) {
            return;
        }
        this.b.i(postWriteCallBackData.getSensitiveWords());
        this.b.n(postWriteCallBackData.getErrorString());
        if (ListUtils.isEmpty(this.b.a())) {
            return;
        }
        b(true);
    }

    public void m(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editText) == null) {
            this.c = editText;
        }
    }

    public void n(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, editText) == null) {
            this.d = editText;
        }
    }
}

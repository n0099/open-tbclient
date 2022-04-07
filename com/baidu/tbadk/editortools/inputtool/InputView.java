package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ax4;
import com.repackage.dz8;
import com.repackage.i05;
import com.repackage.r86;
import com.repackage.s86;
import com.repackage.v05;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes3.dex */
public class InputView extends EditText implements v05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int f;

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputView a;

        public a(InputView inputView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inputView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null || editable.toString().trim() == null) {
                return;
            }
            InputView inputView = this.a;
            inputView.d(new i05(4, -1, inputView.getText().toString()));
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || this.a.e) {
                return;
            }
            this.a.e = true;
            if (this.a.f != -1) {
                InputView inputView = this.a;
                inputView.setSelection(inputView.f);
                this.a.f = -1;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputView a;

        public b(InputView inputView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inputView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.a.d(new i05(5, -1, null));
                    this.a.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements s86.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputView a;

        public c(InputView inputView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inputView;
        }

        @Override // com.repackage.s86.g
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.setText(spannableStringBuilder);
                InputView inputView = this.a;
                inputView.setSelection(inputView.getText().length());
                this.a.d(new i05(5, -1, null));
                this.a.requestFocus();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputView(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
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
        this.b = 0;
        this.c = false;
        this.d = true;
        this.e = true;
        this.f = -1;
        setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070258));
        setMaxLines(4);
        if (z) {
            setHint(context.getString(R.string.obfuscated_res_0x7f0f1074));
        }
        setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207));
        setTextColor(getResources().getColor(R.color.CAM_X0106));
        setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        setBackgroundResource(R.color.common_color_10022);
        dz8.l(this, R.drawable.obfuscated_res_0x7f0804b6);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070224);
        setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        addTextChangedListener(new a(this));
        setOnTouchListener(new b(this));
    }

    @Override // com.repackage.v05
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setVisibility(0);
        }
    }

    @Override // com.repackage.v05
    public void d(i05 i05Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i05Var) == null) || (editorTools = this.a) == null) {
            return;
        }
        editorTools.A(i05Var);
    }

    @Override // com.repackage.v05
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : invokeV.intValue;
    }

    public final void h(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append("@");
            sb.append(arrayList.get(i));
            sb.append(" ");
        }
        String sb2 = sb.toString();
        getText().insert(getSelectionStart(), sb2);
    }

    @Override // com.repackage.v05
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(8);
        }
    }

    public final void i(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    @Override // com.repackage.v05
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final void j(i05 i05Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, i05Var) == null) || i05Var == null || (obj = i05Var.c) == null || !(obj instanceof ax4)) {
            return;
        }
        ax4 ax4Var = (ax4) obj;
        if (ax4Var.getType() == EmotionGroupType.NET_SUG) {
            l(ax4Var);
        } else {
            k(ax4Var);
        }
    }

    public final void k(ax4 ax4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ax4Var) == null) {
            if (!this.c || ax4Var.getType() == EmotionGroupType.LOCAL) {
                String obj = getText().toString();
                if (this.d && r86.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f1404);
                } else {
                    s86.b(getContext(), ax4Var, this);
                }
            }
        }
    }

    public final void l(ax4 ax4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, ax4Var) == null) || ax4Var == null || TextUtils.isEmpty(ax4Var.c()) || TextUtils.isEmpty(ax4Var.f())) {
            return;
        }
        String obj = getText().toString();
        if (this.d && r86.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f1404);
        } else {
            s86.c(getContext(), ax4Var, this);
        }
    }

    @Override // com.repackage.j05
    public void onAction(i05 i05Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, i05Var) == null) || i05Var == null) {
            return;
        }
        int i = i05Var.a;
        if (i == 3) {
            if (getSelectionStart() > 0) {
                String substring = getText().toString().substring(0, getSelectionStart());
                Matcher matcher = r86.b.matcher(substring);
                if (matcher.find()) {
                    getText().delete(getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), getSelectionStart());
                } else {
                    getText().delete(getSelectionStart() - 1, getSelectionStart());
                }
            }
        } else if (i == 6) {
            Object obj2 = i05Var.c;
            if (obj2 == null) {
                setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    setText((CharSequence) null);
                } else {
                    s86.e(getContext(), (String) i05Var.c, new c(this));
                }
            }
        } else if (i == 9) {
            if (((Boolean) i05Var.c).booleanValue()) {
                setText((CharSequence) null);
            }
        } else if (i == 17) {
            Object obj3 = i05Var.c;
            if (obj3 == null || !(obj3 instanceof ArrayList)) {
                return;
            }
            h((ArrayList) obj3);
        } else if (i == 24) {
            j(i05Var);
        } else if (i == 44 && (obj = i05Var.c) != null && (obj instanceof String)) {
            i((String) obj);
        }
    }

    @Override // com.repackage.v05
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            SkinManager.setViewTextColor(this, R.color.CAM_X0105, 2, i);
            if (i == 0) {
                dz8.l(this, R.drawable.obfuscated_res_0x7f0804b6);
                setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
                return;
            }
            dz8.l(this, R.drawable.obfuscated_res_0x7f0804b7);
            setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0110));
        }
    }

    @Override // com.repackage.v05
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.c = z;
        }
    }

    public void setNeedFaceMaxCount(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.d = z;
        }
    }

    @Override // com.repackage.v05
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.b = i;
        }
    }
}

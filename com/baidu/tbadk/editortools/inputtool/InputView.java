package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.Editable;
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
import com.baidu.tieba.g25;
import com.baidu.tieba.i79;
import com.baidu.tieba.lf6;
import com.baidu.tieba.m65;
import com.baidu.tieba.mf6;
import com.baidu.tieba.ok5;
import com.baidu.tieba.xi;
import com.baidu.tieba.y65;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes3.dex */
public class InputView extends EditText implements y65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int f;
    public boolean g;
    public boolean h;
    public int i;
    public Context j;

    @Override // com.baidu.tieba.y65
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputView a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        /* renamed from: com.baidu.tbadk.editortools.inputtool.InputView$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0211a implements mf6.h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0211a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.mf6.h
            public void a(SpannableStringBuilder spannableStringBuilder) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                    this.a.a.setText(spannableStringBuilder);
                    InputView inputView = this.a.a;
                    inputView.setSelection(inputView.getText().length());
                }
            }
        }

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
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && editable != null && editable.toString().trim() != null) {
                String obj = editable.toString();
                if (ok5.a.c(editable.toString()) > this.a.i) {
                    String a = ok5.a.a(obj, this.a.i, "");
                    if (!xi.isEquals(editable.toString(), a)) {
                        mf6.f(this.a.getContext(), a, new C0211a(this));
                    }
                }
                this.a.J(new m65(4, -1, editable.toString()));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && !this.a.e) {
                this.a.e = true;
                if (this.a.f != -1) {
                    InputView inputView = this.a;
                    inputView.setSelection(inputView.f);
                    this.a.f = -1;
                }
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
                if (!this.a.h) {
                    return true;
                }
                if (motionEvent.getAction() == 1) {
                    this.a.J(new m65(5, -1, null));
                    this.a.setCursorVisible(true);
                    this.a.J(new m65(64, -1, null));
                    this.a.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements mf6.h {
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

        @Override // com.baidu.tieba.mf6.h
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.setText(spannableStringBuilder);
                InputView inputView = this.a;
                inputView.setSelection(inputView.getText().length());
                this.a.J(new m65(5, -1, null));
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
        this.h = true;
        this.i = -1;
        this.j = context;
        this.g = z;
        setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds104));
        setMaxLines(5);
        if (z) {
            setHint(context.getString(R.string.im_msg_input_hint));
        }
        i79.l(this, R.drawable.edittext_cursor);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.M_W_X006);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        setMaxTextCount(2000);
        addTextChangedListener(new a(this));
        setOnTouchListener(new b(this));
    }

    private void setMaxTextCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65543, this, i) == null) {
            this.i = i;
        }
    }

    @Override // com.baidu.tieba.y65
    public void J(m65 m65Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m65Var) == null) && (editorTools = this.a) != null) {
            editorTools.B(m65Var);
        }
    }

    public final void i(m65 m65Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, m65Var) == null) && m65Var != null && (obj = m65Var.c) != null && (obj instanceof g25)) {
            g25 g25Var = (g25) obj;
            if (g25Var.getType() == EmotionGroupType.NET_SUG) {
                k(g25Var);
            } else {
                j(g25Var);
            }
        }
    }

    @Override // com.baidu.tieba.y65
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            SkinManager.setViewTextColor(this, R.color.CAM_X0105, 2, i);
            if (i == 0) {
                i79.l(this, R.drawable.edittext_cursor);
            } else {
                i79.l(this, R.drawable.edittext_cursor_1);
            }
            setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0109));
        }
    }

    @Override // com.baidu.tieba.y65
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

    @Override // com.baidu.tieba.y65
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.b = i;
        }
    }

    @Override // com.baidu.tieba.n65
    public void A(m65 m65Var) {
        Context context;
        Context context2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, m65Var) != null) || m65Var == null) {
            return;
        }
        int i = m65Var.a;
        if (i != 3) {
            if (i != 6) {
                if (i != 9) {
                    if (i != 17) {
                        if (i != 24) {
                            if (i != 44) {
                                switch (i) {
                                    case 71:
                                        Object obj = m65Var.c;
                                        if (obj == null) {
                                            if (this.g && (context2 = this.j) != null) {
                                                setHint(context2.getString(R.string.im_msg_input_hint));
                                            }
                                        } else if (obj instanceof String) {
                                            if (TextUtils.isEmpty((String) obj)) {
                                                if (this.g && (context = this.j) != null) {
                                                    setHint(context.getString(R.string.im_msg_input_hint));
                                                }
                                            } else {
                                                Object obj2 = m65Var.c;
                                                if (obj2 instanceof String) {
                                                    setHint((String) obj2);
                                                }
                                            }
                                        }
                                        i(m65Var);
                                        return;
                                    case 72:
                                        boolean booleanValue = ((Boolean) m65Var.c).booleanValue();
                                        this.h = booleanValue;
                                        setCursorVisible(booleanValue);
                                        return;
                                    case 73:
                                        if (((Integer) m65Var.c).intValue() != 0) {
                                            setMaxTextCount(((Integer) m65Var.c).intValue());
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                            Object obj3 = m65Var.c;
                            if (obj3 != null && (obj3 instanceof String)) {
                                h((String) obj3);
                                return;
                            }
                            return;
                        }
                        i(m65Var);
                        return;
                    }
                    Object obj4 = m65Var.c;
                    if (obj4 != null && (obj4 instanceof ArrayList)) {
                        g((ArrayList) obj4);
                        return;
                    }
                    return;
                } else if (((Boolean) m65Var.c).booleanValue()) {
                    setText((CharSequence) null);
                    return;
                } else {
                    return;
                }
            }
            Object obj5 = m65Var.c;
            if (obj5 == null) {
                setText((CharSequence) null);
            } else if (obj5 instanceof String) {
                if (TextUtils.isEmpty((String) obj5)) {
                    setText((CharSequence) null);
                } else {
                    mf6.f(getContext(), (String) m65Var.c, new c(this));
                }
            }
        } else if (getSelectionStart() > 0) {
            String substring = getText().toString().substring(0, getSelectionStart());
            Matcher matcher = lf6.b.matcher(substring);
            if (matcher.find()) {
                getText().delete(getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), getSelectionStart());
            } else {
                getText().delete(getSelectionStart() - 1, getSelectionStart());
            }
        }
    }

    @Override // com.baidu.tieba.y65
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.y65
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.y65
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(8);
        }
    }

    public final void g(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append("@");
                sb.append(arrayList.get(i));
                sb.append(" ");
            }
            String sb2 = sb.toString();
            getText().insert(getSelectionStart(), sb2);
        }
    }

    public final void j(g25 g25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, g25Var) == null) {
            if (this.c && g25Var.getType() != EmotionGroupType.LOCAL) {
                return;
            }
            String obj = getText().toString();
            if (this.d && lf6.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                mf6.b(getContext(), g25Var, this);
            }
        }
    }

    public final void k(g25 g25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, g25Var) == null) && g25Var != null && !TextUtils.isEmpty(g25Var.d()) && !TextUtils.isEmpty(g25Var.g())) {
            String obj = getText().toString();
            if (this.d && lf6.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                mf6.c(getContext(), g25Var, this);
            }
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }
}

package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.dy5;
import com.baidu.tieba.e47;
import com.baidu.tieba.ed5;
import com.baidu.tieba.ei;
import com.baidu.tieba.f47;
import com.baidu.tieba.fj5;
import com.baidu.tieba.si5;
import com.baidu.tieba.write.WriteVideoUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes4.dex */
public class InputView extends SpanGroupEditText implements fj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public Context o;

    @Override // com.baidu.tieba.fj5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputView a;

        /* renamed from: com.baidu.tbadk.editortools.inputtool.InputView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0215a implements f47.i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0215a(a aVar) {
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

            @Override // com.baidu.tieba.f47.i
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
                if (dy5.a.d(editable.toString()) > this.a.m) {
                    String a = dy5.a.a(obj, this.a.m, "");
                    if (!ei.isEquals(editable.toString(), a)) {
                        f47.h(this.a.getContext(), a, new C0215a(this));
                    }
                }
                this.a.U(new si5(4, -1, editable.toString()));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) && charSequence != null && !StringUtils.isNull(charSequence.toString())) {
                this.a.n = dy5.a.d(charSequence.toString());
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && !this.a.i) {
                this.a.i = true;
                if (this.a.j != -1) {
                    InputView inputView = this.a;
                    inputView.setSelection(inputView.j);
                    this.a.j = -1;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (!this.a.l) {
                    return true;
                }
                if (motionEvent.getAction() == 1) {
                    this.a.U(new si5(5, -1, null));
                    this.a.setCursorVisible(true);
                    this.a.U(new si5(64, -1, null));
                    this.a.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f47.i {
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

        @Override // com.baidu.tieba.f47.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.setText(spannableStringBuilder);
                InputView inputView = this.a;
                inputView.setSelection(inputView.getText().length());
                this.a.U(new si5(5, -1, null));
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
        this.f = 0;
        this.g = false;
        this.h = true;
        this.i = true;
        this.j = -1;
        this.l = true;
        this.m = -1;
        this.n = 0;
        this.o = context;
        this.k = z;
        setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds104));
        setMaxLines(5);
        if (z) {
            setHint(context.getString(R.string.im_msg_input_hint));
        }
        WriteVideoUtil.setCursorColor(this, R.drawable.edittext_cursor);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.M_W_X006);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
        setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        setMaxTextCount(2000);
        addTextChangedListener(new a(this));
        setOnTouchListener(new b(this));
    }

    private void setMaxTextCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65544, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.fj5
    public void U(si5 si5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, si5Var) == null) && (editorTools = this.e) != null) {
            editorTools.D(si5Var);
        }
    }

    @Override // com.baidu.tieba.fj5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            SkinManager.setViewTextColor(this, R.color.CAM_X0105, 2, i);
            if (i == 0) {
                WriteVideoUtil.setCursorColor(this, R.drawable.edittext_cursor);
            } else {
                WriteVideoUtil.setCursorColor(this, R.drawable.edittext_cursor_2);
            }
            setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0109));
        }
    }

    public final void s(si5 si5Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, si5Var) == null) && si5Var != null && (obj = si5Var.c) != null && (obj instanceof ed5)) {
            ed5 ed5Var = (ed5) obj;
            if (ed5Var.getType() == EmotionGroupType.NET_SUG) {
                u(ed5Var);
            } else {
                t(ed5Var);
            }
        }
    }

    @Override // com.baidu.tieba.fj5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, editorTools) == null) {
            this.e = editorTools;
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.g = z;
        }
    }

    public void setNeedFaceMaxCount(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.h = z;
        }
    }

    @Override // com.baidu.tieba.fj5
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.f = i;
        }
    }

    @Override // com.baidu.tieba.ti5
    public void G(si5 si5Var) {
        Context context;
        Context context2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, si5Var) != null) || si5Var == null) {
            return;
        }
        int i = si5Var.a;
        if (i != 3) {
            if (i != 6) {
                if (i != 9) {
                    if (i != 17) {
                        if (i != 24) {
                            if (i != 44) {
                                if (i != 75) {
                                    switch (i) {
                                        case 71:
                                            Object obj = si5Var.c;
                                            if (obj == null) {
                                                if (this.k && (context2 = this.o) != null) {
                                                    setHint(context2.getString(R.string.im_msg_input_hint));
                                                }
                                            } else if (obj instanceof String) {
                                                if (TextUtils.isEmpty((String) obj)) {
                                                    if (this.k && (context = this.o) != null) {
                                                        setHint(context.getString(R.string.im_msg_input_hint));
                                                    }
                                                } else {
                                                    Object obj2 = si5Var.c;
                                                    if (obj2 instanceof String) {
                                                        setHint((String) obj2);
                                                    }
                                                }
                                            }
                                            s(si5Var);
                                            return;
                                        case 72:
                                            boolean booleanValue = ((Boolean) si5Var.c).booleanValue();
                                            this.l = booleanValue;
                                            setCursorVisible(booleanValue);
                                            return;
                                        case 73:
                                            if (((Integer) si5Var.c).intValue() != 0) {
                                                setMaxTextCount(((Integer) si5Var.c).intValue());
                                                return;
                                            }
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                Object obj3 = si5Var.c;
                                if ((obj3 instanceof String) && !TextUtils.isEmpty((String) obj3)) {
                                    insert((String) si5Var.c);
                                    return;
                                }
                                return;
                            }
                            Object obj4 = si5Var.c;
                            if (obj4 != null && (obj4 instanceof String)) {
                                r((String) obj4);
                                return;
                            }
                            return;
                        }
                        s(si5Var);
                        return;
                    }
                    Object obj5 = si5Var.c;
                    if (obj5 != null && (obj5 instanceof ArrayList)) {
                        ArrayList<AtSelectData> arrayList = (ArrayList) obj5;
                        if (this.n + dy5.a.c(arrayList) <= this.m) {
                            q(arrayList);
                            return;
                        }
                        Context context3 = this.o;
                        if (context3 != null) {
                            BdUtilHelper.showToast(context3, context3.getString(R.string.group_chat_input_tool_upper_limit));
                            return;
                        }
                        return;
                    }
                    return;
                } else if (((Boolean) si5Var.c).booleanValue()) {
                    setText((CharSequence) null);
                    return;
                } else {
                    return;
                }
            }
            Object obj6 = si5Var.c;
            if (obj6 == null) {
                setText((CharSequence) null);
            } else if (obj6 instanceof String) {
                if (TextUtils.isEmpty((String) obj6)) {
                    setText((CharSequence) null);
                } else {
                    f47.h(getContext(), (String) si5Var.c, new c(this));
                }
            }
        } else if (getSelectionStart() > 0) {
            String substring = getText().toString().substring(0, getSelectionStart());
            Matcher matcher = e47.b.matcher(substring);
            if (matcher.find()) {
                getText().delete(getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), getSelectionStart());
            } else {
                getText().delete(getSelectionStart() - 1, getSelectionStart());
            }
        }
    }

    @Override // com.baidu.tieba.fj5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.fj5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fj5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            setVisibility(8);
        }
    }

    public final void q(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) {
            int selectionStart = getSelectionStart();
            if (selectionStart > 0 && getText() != null) {
                int i = selectionStart - 1;
                if (getText().toString().charAt(i) == '@') {
                    getEditableText().delete(i, selectionStart);
                }
            }
            if (getText() != null && arrayList != null && arrayList.size() > 0) {
                getText().delete(getSelectionStart(), getSelectionEnd());
                b(arrayList);
            }
            e(arrayList);
        }
    }

    public final void t(ed5 ed5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ed5Var) == null) {
            if (this.g && ed5Var.getType() != EmotionGroupType.LOCAL) {
                return;
            }
            String obj = getText().toString();
            if (this.h && e47.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                f47.c(getContext(), ed5Var, this);
            }
        }
    }

    public final void u(ed5 ed5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, ed5Var) == null) && ed5Var != null && !TextUtils.isEmpty(ed5Var.d()) && !TextUtils.isEmpty(ed5Var.g())) {
            String obj = getText().toString();
            if (this.h && e47.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                f47.d(getContext(), ed5Var, this);
            }
        }
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }
}

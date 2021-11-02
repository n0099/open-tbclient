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
import b.a.q0.t.c.w;
import b.a.q0.x.n;
import b.a.r0.d4.i;
import b.a.r0.r0.b;
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
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes8.dex */
public class InputView extends EditText implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f45873e;

    /* renamed from: f  reason: collision with root package name */
    public int f45874f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45875g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f45876h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45877i;
    public int j;

    /* loaded from: classes8.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InputView f45878e;

        public a(InputView inputView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45878e = inputView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null || editable.toString().trim() == null) {
                return;
            }
            InputView inputView = this.f45878e;
            inputView.sendAction(new b.a.q0.x.a(4, -1, inputView.getText().toString()));
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f45878e.f45877i) {
                return;
            }
            this.f45878e.f45877i = true;
            if (this.f45878e.j != -1) {
                InputView inputView = this.f45878e;
                inputView.setSelection(inputView.j);
                this.f45878e.j = -1;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InputView f45879e;

        public b(InputView inputView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45879e = inputView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f45879e.sendAction(new b.a.q0.x.a(5, -1, null));
                    this.f45879e.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InputView f45880a;

        public c(InputView inputView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45880a = inputView;
        }

        @Override // b.a.r0.r0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.f45880a.setText(spannableStringBuilder);
                InputView inputView = this.f45880a;
                inputView.setSelection(inputView.getText().length());
                this.f45880a.sendAction(new b.a.q0.x.a(5, -1, null));
                this.f45880a.requestFocus();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f45874f = 0;
        this.f45875g = false;
        this.f45876h = true;
        this.f45877i = true;
        this.j = -1;
        setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds64));
        setMaxLines(4);
        if (z) {
            setHint(context.getString(R.string.say_your_point));
        }
        setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        setTextColor(getResources().getColor(R.color.CAM_X0106));
        setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        setBackgroundResource(R.color.common_color_10022);
        i.o(this, R.drawable.edittext_cursor);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        addTextChangedListener(new a(this));
        setOnTouchListener(new b(this));
    }

    @Override // b.a.q0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setVisibility(0);
        }
    }

    public final void e(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            sb.append("@");
            sb.append(arrayList.get(i2));
            sb.append(" ");
        }
        String sb2 = sb.toString();
        getText().insert(getSelectionStart(), sb2);
    }

    public final void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    public final void g(b.a.q0.x.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null || (obj = aVar.f14197c) == null || !(obj instanceof w)) {
            return;
        }
        w wVar = (w) obj;
        if (wVar.getType() == EmotionGroupType.NET_SUG) {
            i(wVar);
        } else {
            h(wVar);
        }
    }

    @Override // b.a.q0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45874f : invokeV.intValue;
    }

    public final void h(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, wVar) == null) {
            if (!this.f45875g || wVar.getType() == EmotionGroupType.LOCAL) {
                String obj = getText().toString();
                if (this.f45876h && b.a.r0.r0.a.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(R.string.too_many_face);
                } else {
                    b.a.r0.r0.b.b(getContext(), wVar, this);
                }
            }
        }
    }

    @Override // b.a.q0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(8);
        }
    }

    public final void i(w wVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, wVar) == null) || wVar == null || TextUtils.isEmpty(wVar.c()) || TextUtils.isEmpty(wVar.f())) {
            return;
        }
        String obj = getText().toString();
        if (this.f45876h && b.a.r0.r0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
        } else {
            b.a.r0.r0.b.c(getContext(), wVar, this);
        }
    }

    @Override // b.a.q0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    @Override // b.a.q0.x.b
    public void onAction(b.a.q0.x.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f14195a;
        if (i2 == 3) {
            if (getSelectionStart() > 0) {
                String substring = getText().toString().substring(0, getSelectionStart());
                Matcher matcher = b.a.r0.r0.a.f23026b.matcher(substring);
                if (matcher.find()) {
                    getText().delete(getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), getSelectionStart());
                } else {
                    getText().delete(getSelectionStart() - 1, getSelectionStart());
                }
            }
        } else if (i2 == 6) {
            Object obj2 = aVar.f14197c;
            if (obj2 == null) {
                setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    setText((CharSequence) null);
                } else {
                    b.a.r0.r0.b.d(getContext(), (String) aVar.f14197c, new c(this));
                }
            }
        } else if (i2 == 9) {
            if (((Boolean) aVar.f14197c).booleanValue()) {
                setText((CharSequence) null);
            }
        } else if (i2 == 17) {
            Object obj3 = aVar.f14197c;
            if (obj3 == null || !(obj3 instanceof ArrayList)) {
                return;
            }
            e((ArrayList) obj3);
        } else if (i2 == 24) {
            g(aVar);
        } else if (i2 == 44 && (obj = aVar.f14197c) != null && (obj instanceof String)) {
            f((String) obj);
        }
    }

    @Override // b.a.q0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            SkinManager.setViewTextColor(this, R.color.CAM_X0105, 2, i2);
            if (i2 == 0) {
                i.o(this, R.drawable.edittext_cursor);
                setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
                return;
            }
            i.o(this, R.drawable.edittext_cursor_1);
            setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0110));
        }
    }

    @Override // b.a.q0.x.n
    public void sendAction(b.a.q0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || (editorTools = this.f45873e) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    @Override // b.a.q0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editorTools) == null) {
            this.f45873e = editorTools;
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f45875g = z;
        }
    }

    public void setNeedFaceMaxCount(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f45876h = z;
        }
    }

    @Override // b.a.q0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f45874f = i2;
        }
    }
}

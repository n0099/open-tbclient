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
import com.bytedance.sdk.component.net.tnc.TNCManager;
import d.a.o0.s.c.v;
import d.a.o0.w.n;
import d.a.p0.a4.i;
import d.a.p0.o0.b;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes3.dex */
public class InputView extends EditText implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f13022e;

    /* renamed from: f  reason: collision with root package name */
    public int f13023f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13024g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13025h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13026i;
    public int j;

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InputView f13027e;

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
            this.f13027e = inputView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null || editable.toString().trim() == null) {
                return;
            }
            InputView inputView = this.f13027e;
            inputView.d(new d.a.o0.w.a(4, -1, inputView.getText().toString()));
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f13027e.f13026i) {
                return;
            }
            this.f13027e.f13026i = true;
            if (this.f13027e.j != -1) {
                InputView inputView = this.f13027e;
                inputView.setSelection(inputView.j);
                this.f13027e.j = -1;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ InputView f13028e;

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
            this.f13028e = inputView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f13028e.d(new d.a.o0.w.a(5, -1, null));
                    this.f13028e.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InputView f13029a;

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
            this.f13029a = inputView;
        }

        @Override // d.a.p0.o0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.f13029a.setText(spannableStringBuilder);
                InputView inputView = this.f13029a;
                inputView.setSelection(inputView.getText().length());
                this.f13029a.d(new d.a.o0.w.a(5, -1, null));
                this.f13029a.requestFocus();
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
        this.f13023f = 0;
        this.f13024g = false;
        this.f13025h = true;
        this.f13026i = true;
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
        i.e(this, R.drawable.edittext_cursor);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        addTextChangedListener(new a(this));
        setOnTouchListener(new b(this));
    }

    @Override // d.a.o0.w.n
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setVisibility(0);
        }
    }

    @Override // d.a.o0.w.n
    public void d(d.a.o0.w.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || (editorTools = this.f13022e) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    @Override // d.a.o0.w.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13023f : invokeV.intValue;
    }

    public final void h(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            sb.append(TNCManager.TNC_PROBE_HEADER_SECEPTOR);
            sb.append(arrayList.get(i2));
            sb.append(" ");
        }
        String sb2 = sb.toString();
        getText().insert(getSelectionStart(), sb2);
    }

    @Override // d.a.o0.w.n
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

    @Override // d.a.o0.w.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final void j(d.a.o0.w.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || aVar == null || (obj = aVar.f53489c) == null || !(obj instanceof v)) {
            return;
        }
        v vVar = (v) obj;
        if (vVar.f() == EmotionGroupType.NET_SUG) {
            l(vVar);
        } else {
            k(vVar);
        }
    }

    public final void k(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vVar) == null) {
            if (!this.f13024g || vVar.f() == EmotionGroupType.LOCAL) {
                String obj = getText().toString();
                if (this.f13025h && d.a.p0.o0.a.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(R.string.too_many_face);
                } else {
                    d.a.p0.o0.b.b(getContext(), vVar, this);
                }
            }
        }
    }

    public final void l(v vVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, vVar) == null) || vVar == null || TextUtils.isEmpty(vVar.c()) || TextUtils.isEmpty(vVar.g())) {
            return;
        }
        String obj = getText().toString();
        if (this.f13025h && d.a.p0.o0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
        } else {
            d.a.p0.o0.b.c(getContext(), vVar, this);
        }
    }

    @Override // d.a.o0.w.b
    public void onAction(d.a.o0.w.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f53487a;
        if (i2 == 3) {
            if (getSelectionStart() > 0) {
                String substring = getText().toString().substring(0, getSelectionStart());
                Matcher matcher = d.a.p0.o0.a.f61066b.matcher(substring);
                if (matcher.find()) {
                    getText().delete(getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), getSelectionStart());
                } else {
                    getText().delete(getSelectionStart() - 1, getSelectionStart());
                }
            }
        } else if (i2 == 6) {
            Object obj2 = aVar.f53489c;
            if (obj2 == null) {
                setText((CharSequence) null);
            } else if (obj2 instanceof String) {
                if (TextUtils.isEmpty((String) obj2)) {
                    setText((CharSequence) null);
                } else {
                    d.a.p0.o0.b.d(getContext(), (String) aVar.f53489c, new c(this));
                }
            }
        } else if (i2 == 9) {
            if (((Boolean) aVar.f53489c).booleanValue()) {
                setText((CharSequence) null);
            }
        } else if (i2 == 17) {
            Object obj3 = aVar.f53489c;
            if (obj3 == null || !(obj3 instanceof ArrayList)) {
                return;
            }
            h((ArrayList) obj3);
        } else if (i2 == 24) {
            j(aVar);
        } else if (i2 == 44 && (obj = aVar.f53489c) != null && (obj instanceof String)) {
            i((String) obj);
        }
    }

    @Override // d.a.o0.w.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            SkinManager.setViewTextColor(this, R.color.CAM_X0105, 2, i2);
            if (i2 == 0) {
                i.e(this, R.drawable.edittext_cursor);
                setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
                return;
            }
            i.e(this, R.drawable.edittext_cursor_1);
            setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0110));
        }
    }

    @Override // d.a.o0.w.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, editorTools) == null) {
            this.f13022e = editorTools;
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f13024g = z;
        }
    }

    public void setNeedFaceMaxCount(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f13025h = z;
        }
    }

    @Override // d.a.o0.w.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f13023f = i2;
        }
    }
}

package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.l;
import c.a.p0.t.c.v;
import c.a.p0.x.n;
import c.a.q0.b4.i;
import c.a.q0.p0.b;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
/* loaded from: classes7.dex */
public class TopicDetaiInputContainer extends LinearLayout implements n, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int ALL = 0;
    public static int PICTURE = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f52358e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f52359f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f52360g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f52361h;

    /* renamed from: i  reason: collision with root package name */
    public View f52362i;

    /* renamed from: j  reason: collision with root package name */
    public int f52363j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public boolean[] o;
    public int[] p;
    public int q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicDetaiInputContainer f52364e;

        public a(TopicDetaiInputContainer topicDetaiInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetaiInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52364e = topicDetaiInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f52364e.sendAction(new c.a.p0.x.a(8, -1, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicDetaiInputContainer f52365e;

        public b(TopicDetaiInputContainer topicDetaiInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetaiInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52365e = topicDetaiInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null || editable.toString().trim() == null) {
                return;
            }
            TopicDetaiInputContainer topicDetaiInputContainer = this.f52365e;
            topicDetaiInputContainer.sendAction(new c.a.p0.x.a(4, -1, topicDetaiInputContainer.f52359f.getText().toString()));
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f52365e.m) {
                return;
            }
            this.f52365e.m = true;
            if (this.f52365e.n != -1) {
                this.f52365e.f52359f.setSelection(this.f52365e.n);
                this.f52365e.n = -1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TopicDetaiInputContainer f52366e;

        public c(TopicDetaiInputContainer topicDetaiInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetaiInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52366e = topicDetaiInputContainer;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f52366e.sendAction(new c.a.p0.x.a(5, -1, null));
                    this.f52366e.f52359f.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TopicDetaiInputContainer f52367a;

        public d(TopicDetaiInputContainer topicDetaiInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetaiInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52367a = topicDetaiInputContainer;
        }

        @Override // c.a.q0.p0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.f52367a.f52359f.setText(spannableStringBuilder);
                this.f52367a.f52359f.setSelection(this.f52367a.f52359f.getText().length());
                this.f52367a.sendAction(new c.a.p0.x.a(5, -1, null));
                this.f52367a.requestFocus();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1628757104, "Lcom/baidu/tieba/homepage/topic/topicdetail/view/TopicDetaiInputContainer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1628757104, "Lcom/baidu/tieba/homepage/topic/topicdetail/view/TopicDetaiInputContainer;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopicDetaiInputContainer(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void applyType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 == ALL) {
                boolean[] zArr = this.o;
                if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                    this.f52360g.setEnabled(false);
                } else {
                    this.f52360g.setEnabled(true);
                }
            } else if (i2 == PICTURE) {
                if (this.o[1]) {
                    this.f52360g.setEnabled(true);
                } else {
                    this.f52360g.setEnabled(false);
                }
            }
        }
    }

    @Override // c.a.p0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f52359f != null && this.f52361h.getVisibility() == 0) {
                this.f52359f.setFocusable(true);
                this.f52359f.setFocusableInTouchMode(true);
                this.f52359f.requestFocus();
                l.K(getContext(), this.f52359f);
            }
            setVisibility(0);
        }
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            EditText editText = new EditText(context);
            this.f52359f = editText;
            editText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
            this.f52359f.setMaxLines(4);
            this.f52359f.setGravity(16);
            this.f52359f.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
            this.f52359f.setTextColor(getResources().getColor(R.color.CAM_X0105));
            this.f52359f.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
            this.f52359f.setBackgroundResource(R.color.common_color_10022);
            i.e(this.f52359f, R.drawable.edittext_cursor);
            this.f52359f.setPadding(0, l.g(context, R.dimen.ds24), l.g(context, R.dimen.ds54), l.g(context, R.dimen.ds24));
            this.f52359f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.f52359f.addTextChangedListener(new b(this));
            this.f52359f.setOnTouchListener(new c(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(l.g(context, R.dimen.ds14), 0, 0, 0);
            this.f52361h.addView(this.f52359f, layoutParams);
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            TextView textView = new TextView(context);
            this.f52360g = textView;
            textView.setGravity(17);
            this.f52360g.setIncludeFontPadding(false);
            this.f52360g.setEnabled(false);
            this.f52360g.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
            this.f52360g.setText(R.string.pb_send_post);
            this.f52360g.setOnClickListener(new a(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, l.g(context, R.dimen.tbds14), 0);
            this.f52361h.addView(this.f52360g, layoutParams);
        }
    }

    public LinearLayout getInputLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f52361h : (LinearLayout) invokeV.objValue;
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f52359f : (EditText) invokeV.objValue;
    }

    public TextView getSendView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f52360g : (TextView) invokeV.objValue;
    }

    @Override // c.a.p0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f52363j : invokeV.intValue;
    }

    public final void h(c.a.p0.x.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || aVar == null || (obj = aVar.f15088c) == null || !(obj instanceof v)) {
            return;
        }
        v vVar = (v) obj;
        if (vVar.f() == EmotionGroupType.NET_SUG) {
            j(vVar);
        } else {
            i(vVar);
        }
    }

    @Override // c.a.p0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            setVisibility(8);
        }
    }

    public final void i(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, vVar) == null) {
            if (!this.k || vVar.f() == EmotionGroupType.LOCAL) {
                String obj = this.f52359f.getText().toString();
                if (this.l && c.a.q0.p0.a.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(R.string.too_many_face);
                } else {
                    c.a.q0.p0.b.b(getContext(), vVar, this.f52359f);
                }
            }
        }
    }

    @Override // c.a.p0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public final void j(v vVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, vVar) == null) || vVar == null || TextUtils.isEmpty(vVar.c()) || TextUtils.isEmpty(vVar.g())) {
            return;
        }
        String obj = this.f52359f.getText().toString();
        if (this.l && c.a.q0.p0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
        } else {
            c.a.q0.p0.b.c(getContext(), vVar, this.f52359f);
        }
    }

    @Override // c.a.p0.x.b
    public void onAction(c.a.p0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f15086a;
        if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 6) {
                    Object obj = aVar.f15088c;
                    if (obj == null) {
                        this.f52359f.setText((CharSequence) null);
                    } else if (obj instanceof String) {
                        if (TextUtils.isEmpty((String) obj)) {
                            this.f52359f.setText((CharSequence) null);
                        } else {
                            c.a.q0.p0.b.d(getContext(), (String) aVar.f15088c, new d(this));
                        }
                    }
                } else if (i2 == 9) {
                    if (((Boolean) aVar.f15088c).booleanValue()) {
                        this.f52359f.setText((CharSequence) null);
                    }
                    boolean[] zArr = this.o;
                    zArr[0] = false;
                    zArr[1] = false;
                    zArr[2] = false;
                    zArr[3] = false;
                    zArr[4] = false;
                    int[] iArr = this.p;
                    iArr[0] = 0;
                    iArr[1] = 0;
                } else if (i2 == 24) {
                    h(aVar);
                } else if (i2 == 12) {
                    Object obj2 = aVar.f15088c;
                    if (!(obj2 instanceof c.a.p0.x.r.a)) {
                        return;
                    }
                    c.a.p0.x.r.a aVar2 = (c.a.p0.x.r.a) obj2;
                    WriteImagesInfo writeImagesInfo = aVar2.f15110a;
                    if (writeImagesInfo != null) {
                        if (writeImagesInfo.getChosedFiles() != null) {
                            this.p[0] = aVar2.f15110a.getChosedFiles().size();
                        } else {
                            this.p[0] = 0;
                        }
                    }
                    if (this.p[0] > 0) {
                        this.o[1] = true;
                    } else {
                        this.o[1] = false;
                    }
                } else if (i2 == 13) {
                    int[] iArr2 = this.p;
                    iArr2[0] = iArr2[0] - 1;
                    if (iArr2[0] > 0) {
                        this.o[1] = true;
                    } else {
                        this.o[1] = false;
                    }
                }
            }
            Object obj3 = aVar.f15088c;
            if (obj3 != null && (!(obj3 instanceof String) || !StringUtils.isNull((String) obj3))) {
                this.o[0] = true;
            } else {
                this.o[0] = false;
            }
        } else if (this.f52359f.getSelectionStart() > 0) {
            String substring = this.f52359f.getText().toString().substring(0, this.f52359f.getSelectionStart());
            Matcher matcher = c.a.q0.p0.a.f23494b.matcher(substring);
            if (matcher.find()) {
                this.f52359f.getText().delete(this.f52359f.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f52359f.getSelectionStart());
            } else {
                this.f52359f.getText().delete(this.f52359f.getSelectionStart() - 1, this.f52359f.getSelectionStart());
            }
        }
        applyType(this.q);
    }

    @Override // c.a.p0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            SkinManager.setViewTextColor(this.f52359f, R.color.CAM_X0105, 2, i2);
            SkinManager.setBackgroundColor(this.f52362i, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            if (i2 == 0) {
                i.e(this.f52359f, R.drawable.edittext_cursor);
                this.f52359f.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
            } else {
                i.e(this.f52359f, R.drawable.edittext_cursor_1);
                this.f52359f.setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0110));
            }
            SkinManager.setBackgroundResource(this.f52360g, R.drawable.topic_discuss_send_bg);
            if (i2 != 1 && i2 != 4) {
                SkinManager.setViewTextColor(this.f52360g, R.color.CAM_X0101, 1);
            } else {
                this.f52360g.setTextColor(getResources().getColor(R.color.CAM_X0101));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
        }
    }

    @Override // c.a.p0.x.n
    public void sendAction(c.a.p0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) || (editorTools = this.f52358e) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    @Override // c.a.p0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, editorTools) == null) {
            this.f52358e = editorTools;
        }
    }

    public void setHasHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    public void setHint(int i2) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || (editText = this.f52359f) == null) {
            return;
        }
        editText.setHint(getContext().getString(i2));
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.k = z;
        }
    }

    @Override // c.a.p0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f52363j = i2;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.q = i2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.k = false;
        this.l = true;
        this.m = true;
        this.n = -1;
        this.o = new boolean[]{false, false, false, false, false};
        this.p = new int[]{0, 0};
        this.q = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f52361h = linearLayout;
        linearLayout.setOrientation(0);
        this.f52361h.setMinimumHeight(l.g(context, R.dimen.ds90));
        addView(this.f52361h, new LinearLayout.LayoutParams(-1, -2));
        f(context);
        g(context);
        this.f52362i = new View(getContext());
        this.f52362i.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds1)));
        addView(this.f52362i);
    }

    public void setHint(CharSequence charSequence) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, charSequence) == null) || (editText = this.f52359f) == null) {
            return;
        }
        editText.setHint(charSequence);
    }
}

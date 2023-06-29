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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ci5;
import com.baidu.tieba.gd5;
import com.baidu.tieba.pi5;
import com.baidu.tieba.tka;
import com.baidu.tieba.u17;
import com.baidu.tieba.v17;
import com.baidu.tieba.xi;
import com.baidu.tieba.yi5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
/* loaded from: classes6.dex */
public class TopicDetaiInputContainer extends LinearLayout implements pi5, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int n = 1;
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public EditText b;
    public TextView c;
    public LinearLayout d;
    public View e;
    public int f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int j;
    public boolean[] k;
    public int[] l;
    public int m;

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

    @Override // com.baidu.tieba.pi5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
        }
    }

    public void setHasHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetaiInputContainer a;

        public a(TopicDetaiInputContainer topicDetaiInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetaiInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetaiInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.H(new ci5(8, -1, null));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetaiInputContainer a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public b(TopicDetaiInputContainer topicDetaiInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetaiInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetaiInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && editable != null && editable.toString().trim() != null) {
                TopicDetaiInputContainer topicDetaiInputContainer = this.a;
                topicDetaiInputContainer.H(new ci5(4, -1, topicDetaiInputContainer.b.getText().toString()));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) != null) || this.a.i) {
                return;
            }
            this.a.i = true;
            if (this.a.j != -1) {
                this.a.b.setSelection(this.a.j);
                this.a.j = -1;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetaiInputContainer a;

        public c(TopicDetaiInputContainer topicDetaiInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetaiInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetaiInputContainer;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.a.H(new ci5(5, -1, null));
                    this.a.b.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements v17.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetaiInputContainer a;

        public d(TopicDetaiInputContainer topicDetaiInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {topicDetaiInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = topicDetaiInputContainer;
        }

        @Override // com.baidu.tieba.v17.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.H(new ci5(5, -1, null));
                this.a.requestFocus();
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.g = false;
        this.h = true;
        this.i = true;
        this.j = -1;
        this.k = new boolean[]{false, false, false, false, false};
        this.l = new int[]{0, 0};
        this.m = o;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07041c));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.d = linearLayout;
        linearLayout.setOrientation(0);
        this.d.setMinimumHeight(xi.g(context, R.dimen.obfuscated_res_0x7f07041c));
        addView(this.d, new LinearLayout.LayoutParams(-1, -2));
        g(context);
        h(context);
        this.e = new View(getContext());
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, xi.g(getContext(), R.dimen.obfuscated_res_0x7f070198)));
        addView(this.e);
    }

    @Override // com.baidu.tieba.pi5
    public void H(ci5 ci5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ci5Var) == null) && (editorTools = this.a) != null) {
            editorTools.C(ci5Var);
        }
    }

    public final void i(ci5 ci5Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, ci5Var) == null) && ci5Var != null && (obj = ci5Var.c) != null && (obj instanceof gd5)) {
            gd5 gd5Var = (gd5) obj;
            if (gd5Var.getType() == EmotionGroupType.NET_SUG) {
                k(gd5Var);
            } else {
                j(gd5Var);
            }
        }
    }

    @Override // com.baidu.tieba.pi5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    public void setHint(int i) {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048595, this, i) == null) && (editText = this.b) != null) {
            editText.setHint(getContext().getString(i));
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.g = z;
        }
    }

    @Override // com.baidu.tieba.pi5
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.f = i;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tieba.di5
    public void C(ci5 ci5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ci5Var) != null) || ci5Var == null) {
            return;
        }
        int i = ci5Var.a;
        if (i != 3) {
            if (i != 4) {
                if (i != 6) {
                    if (i != 9) {
                        if (i != 24) {
                            if (i != 12) {
                                if (i == 13) {
                                    int[] iArr = this.l;
                                    iArr[0] = iArr[0] - 1;
                                    if (iArr[0] > 0) {
                                        this.k[1] = true;
                                    } else {
                                        this.k[1] = false;
                                    }
                                }
                            } else {
                                Object obj = ci5Var.c;
                                if (!(obj instanceof yi5)) {
                                    return;
                                }
                                yi5 yi5Var = (yi5) obj;
                                WriteImagesInfo writeImagesInfo = yi5Var.a;
                                if (writeImagesInfo != null) {
                                    if (writeImagesInfo.getChosedFiles() != null) {
                                        this.l[0] = yi5Var.a.getChosedFiles().size();
                                    } else {
                                        this.l[0] = 0;
                                    }
                                }
                                if (this.l[0] > 0) {
                                    this.k[1] = true;
                                } else {
                                    this.k[1] = false;
                                }
                            }
                        } else {
                            i(ci5Var);
                        }
                    } else {
                        if (((Boolean) ci5Var.c).booleanValue()) {
                            this.b.setText((CharSequence) null);
                        }
                        boolean[] zArr = this.k;
                        zArr[0] = false;
                        zArr[1] = false;
                        zArr[2] = false;
                        zArr[3] = false;
                        zArr[4] = false;
                        int[] iArr2 = this.l;
                        iArr2[0] = 0;
                        iArr2[1] = 0;
                    }
                } else {
                    Object obj2 = ci5Var.c;
                    if (obj2 == null) {
                        this.b.setText((CharSequence) null);
                    } else if (obj2 instanceof String) {
                        if (TextUtils.isEmpty((String) obj2)) {
                            this.b.setText((CharSequence) null);
                        } else {
                            v17.h(getContext(), (String) ci5Var.c, new d(this));
                        }
                    }
                }
            }
            Object obj3 = ci5Var.c;
            if (obj3 != null && (!(obj3 instanceof String) || !StringUtils.isNull((String) obj3))) {
                this.k[0] = true;
            } else {
                this.k[0] = false;
            }
        } else if (this.b.getSelectionStart() > 0) {
            String substring = this.b.getText().toString().substring(0, this.b.getSelectionStart());
            Matcher matcher = u17.b.matcher(substring);
            if (matcher.find()) {
                this.b.getText().delete(this.b.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.b.getSelectionStart());
            } else {
                this.b.getText().delete(this.b.getSelectionStart() - 1, this.b.getSelectionStart());
            }
        }
        f(this.m);
    }

    @Override // com.baidu.tieba.pi5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.b != null && this.d.getVisibility() == 0) {
                this.b.setFocusable(true);
                this.b.setFocusableInTouchMode(true);
                this.b.requestFocus();
                xi.O(getContext(), this.b);
            }
            setVisibility(0);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == o) {
                boolean[] zArr = this.k;
                if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                    this.c.setEnabled(false);
                } else {
                    this.c.setEnabled(true);
                }
            } else if (i == n) {
                if (this.k[1]) {
                    this.c.setEnabled(true);
                } else {
                    this.c.setEnabled(false);
                }
            }
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            TextView textView = new TextView(context);
            this.c = textView;
            textView.setGravity(17);
            this.c.setIncludeFontPadding(false);
            this.c.setEnabled(false);
            this.c.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
            this.c.setText(R.string.pb_send_post);
            this.c.setOnClickListener(new a(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, xi.g(context, R.dimen.tbds14), 0);
            this.d.addView(this.c, layoutParams);
        }
    }

    public final void j(gd5 gd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, gd5Var) == null) {
            if (this.g && gd5Var.getType() != EmotionGroupType.LOCAL) {
                return;
            }
            String obj = this.b.getText().toString();
            if (this.h && u17.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                v17.c(getContext(), gd5Var, this.b);
            }
        }
    }

    public final void k(gd5 gd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, gd5Var) == null) && gd5Var != null && !TextUtils.isEmpty(gd5Var.d()) && !TextUtils.isEmpty(gd5Var.g())) {
            String obj = this.b.getText().toString();
            if (this.h && u17.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                v17.d(getContext(), gd5Var, this.b);
            }
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            EditText editText = new EditText(context);
            this.b = editText;
            editText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207));
            this.b.setMaxLines(4);
            this.b.setGravity(16);
            this.b.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207));
            this.b.setTextColor(getResources().getColor(R.color.CAM_X0105));
            this.b.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
            this.b.setBackgroundResource(R.color.common_color_10022);
            tka.l(this.b, R.drawable.edittext_cursor);
            this.b.setPadding(0, xi.g(context, R.dimen.obfuscated_res_0x7f0701e8), xi.g(context, R.dimen.obfuscated_res_0x7f0703ee), xi.g(context, R.dimen.obfuscated_res_0x7f0701e8));
            this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.b.addTextChangedListener(new b(this));
            this.b.setOnTouchListener(new c(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(xi.g(context, R.dimen.obfuscated_res_0x7f0701b2), 0, 0, 0);
            this.d.addView(this.b, layoutParams);
        }
    }

    public LinearLayout getInputLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (EditText) invokeV.objValue;
    }

    public TextView getSendView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.c;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pi5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pi5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.pi5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0105, 2, i);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            if (i == 0) {
                tka.l(this.b, R.drawable.edittext_cursor);
                this.b.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
            } else {
                tka.l(this.b, R.drawable.edittext_cursor_2);
                this.b.setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0110));
            }
            SkinManager.setBackgroundResource(this.c, R.drawable.topic_discuss_send_bg);
            if (i == 4) {
                this.c.setTextColor(getResources().getColor(R.color.CAM_X0101));
            } else {
                SkinManager.setViewTextColor(this.c, R.color.CAM_X0101, 1);
            }
        }
    }

    public void setHint(CharSequence charSequence) {
        EditText editText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, charSequence) == null) && (editText = this.b) != null) {
            editText.setHint(charSequence);
        }
    }
}

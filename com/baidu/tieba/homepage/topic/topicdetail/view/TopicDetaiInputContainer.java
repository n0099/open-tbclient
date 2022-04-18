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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c15;
import com.repackage.i05;
import com.repackage.kz8;
import com.repackage.oi;
import com.repackage.t86;
import com.repackage.u86;
import com.repackage.v05;
import com.repackage.zw4;
import java.util.regex.Matcher;
/* loaded from: classes3.dex */
public class TopicDetaiInputContainer extends LinearLayout implements v05, View.OnClickListener {
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

    /* loaded from: classes3.dex */
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
                this.a.d(new i05(8, -1, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TopicDetaiInputContainer a;

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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null || editable.toString().trim() == null) {
                return;
            }
            TopicDetaiInputContainer topicDetaiInputContainer = this.a;
            topicDetaiInputContainer.d(new i05(4, -1, topicDetaiInputContainer.b.getText().toString()));
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || this.a.i) {
                return;
            }
            this.a.i = true;
            if (this.a.j != -1) {
                this.a.b.setSelection(this.a.j);
                this.a.j = -1;
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    this.a.d(new i05(5, -1, null));
                    this.a.b.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements u86.g {
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

        @Override // com.repackage.u86.g
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.d(new i05(5, -1, null));
                this.a.requestFocus();
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

    @Override // com.repackage.v05
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.b != null && this.d.getVisibility() == 0) {
                this.b.setFocusable(true);
                this.b.setFocusableInTouchMode(true);
                this.b.requestFocus();
                oi.L(getContext(), this.b);
            }
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

    public LinearLayout getInputLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (LinearLayout) invokeV.objValue;
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (EditText) invokeV.objValue;
    }

    public TextView getSendView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (TextView) invokeV.objValue;
    }

    @Override // com.repackage.v05
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : invokeV.intValue;
    }

    @Override // com.repackage.v05
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setVisibility(8);
        }
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
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

    @Override // com.repackage.v05
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            EditText editText = new EditText(context);
            this.b = editText;
            editText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207));
            this.b.setMaxLines(4);
            this.b.setGravity(16);
            this.b.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207));
            this.b.setTextColor(getResources().getColor(R.color.CAM_X0105));
            this.b.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
            this.b.setBackgroundResource(R.color.common_color_10022);
            kz8.l(this.b, R.drawable.obfuscated_res_0x7f0804b6);
            this.b.setPadding(0, oi.f(context, R.dimen.obfuscated_res_0x7f0701e8), oi.f(context, R.dimen.obfuscated_res_0x7f0702dd), oi.f(context, R.dimen.obfuscated_res_0x7f0701e8));
            this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.b.addTextChangedListener(new b(this));
            this.b.setOnTouchListener(new c(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(oi.f(context, R.dimen.obfuscated_res_0x7f0701b2), 0, 0, 0);
            this.d.addView(this.b, layoutParams);
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            TextView textView = new TextView(context);
            this.c = textView;
            textView.setGravity(17);
            this.c.setIncludeFontPadding(false);
            this.c.setEnabled(false);
            this.c.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
            this.c.setText(R.string.obfuscated_res_0x7f0f0dc1);
            this.c.setOnClickListener(new a(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, oi.f(context, R.dimen.tbds14), 0);
            this.d.addView(this.c, layoutParams);
        }
    }

    public final void l(i05 i05Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, i05Var) == null) || i05Var == null || (obj = i05Var.c) == null || !(obj instanceof zw4)) {
            return;
        }
        zw4 zw4Var = (zw4) obj;
        if (zw4Var.getType() == EmotionGroupType.NET_SUG) {
            n(zw4Var);
        } else {
            m(zw4Var);
        }
    }

    public final void m(zw4 zw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, zw4Var) == null) {
            if (!this.g || zw4Var.getType() == EmotionGroupType.LOCAL) {
                String obj = this.b.getText().toString();
                if (this.h && t86.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f1403);
                } else {
                    u86.b(getContext(), zw4Var, this.b);
                }
            }
        }
    }

    public final void n(zw4 zw4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, zw4Var) == null) || zw4Var == null || TextUtils.isEmpty(zw4Var.c()) || TextUtils.isEmpty(zw4Var.f())) {
            return;
        }
        String obj = this.b.getText().toString();
        if (this.h && t86.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f1403);
        } else {
            u86.c(getContext(), zw4Var, this.b);
        }
    }

    @Override // com.repackage.j05
    public void onAction(i05 i05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, i05Var) == null) || i05Var == null) {
            return;
        }
        int i = i05Var.a;
        if (i != 3) {
            if (i != 4) {
                if (i == 6) {
                    Object obj = i05Var.c;
                    if (obj == null) {
                        this.b.setText((CharSequence) null);
                    } else if (obj instanceof String) {
                        if (TextUtils.isEmpty((String) obj)) {
                            this.b.setText((CharSequence) null);
                        } else {
                            u86.e(getContext(), (String) i05Var.c, new d(this));
                        }
                    }
                } else if (i == 9) {
                    if (((Boolean) i05Var.c).booleanValue()) {
                        this.b.setText((CharSequence) null);
                    }
                    boolean[] zArr = this.k;
                    zArr[0] = false;
                    zArr[1] = false;
                    zArr[2] = false;
                    zArr[3] = false;
                    zArr[4] = false;
                    int[] iArr = this.l;
                    iArr[0] = 0;
                    iArr[1] = 0;
                } else if (i == 24) {
                    l(i05Var);
                } else if (i == 12) {
                    Object obj2 = i05Var.c;
                    if (!(obj2 instanceof c15)) {
                        return;
                    }
                    c15 c15Var = (c15) obj2;
                    WriteImagesInfo writeImagesInfo = c15Var.a;
                    if (writeImagesInfo != null) {
                        if (writeImagesInfo.getChosedFiles() != null) {
                            this.l[0] = c15Var.a.getChosedFiles().size();
                        } else {
                            this.l[0] = 0;
                        }
                    }
                    if (this.l[0] > 0) {
                        this.k[1] = true;
                    } else {
                        this.k[1] = false;
                    }
                } else if (i == 13) {
                    int[] iArr2 = this.l;
                    iArr2[0] = iArr2[0] - 1;
                    if (iArr2[0] > 0) {
                        this.k[1] = true;
                    } else {
                        this.k[1] = false;
                    }
                }
            }
            Object obj3 = i05Var.c;
            if (obj3 != null && (!(obj3 instanceof String) || !StringUtils.isNull((String) obj3))) {
                this.k[0] = true;
            } else {
                this.k[0] = false;
            }
        } else if (this.b.getSelectionStart() > 0) {
            String substring = this.b.getText().toString().substring(0, this.b.getSelectionStart());
            Matcher matcher = t86.b.matcher(substring);
            if (matcher.find()) {
                this.b.getText().delete(this.b.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.b.getSelectionStart());
            } else {
                this.b.getText().delete(this.b.getSelectionStart() - 1, this.b.getSelectionStart());
            }
        }
        i(this.m);
    }

    @Override // com.repackage.v05
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0105, 2, i);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            if (i == 0) {
                kz8.l(this.b, R.drawable.obfuscated_res_0x7f0804b6);
                this.b.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
            } else {
                kz8.l(this.b, R.drawable.obfuscated_res_0x7f0804b7);
                this.b.setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0110));
            }
            SkinManager.setBackgroundResource(this.c, R.drawable.topic_discuss_send_bg);
            if (i != 1 && i != 4) {
                SkinManager.setViewTextColor(this.c, R.color.CAM_X0101, 1);
            } else {
                this.c.setTextColor(getResources().getColor(R.color.CAM_X0101));
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
        }
    }

    @Override // com.repackage.v05
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    public void setHasHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    public void setHint(int i) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || (editText = this.b) == null) {
            return;
        }
        editText.setHint(getContext().getString(i));
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.g = z;
        }
    }

    @Override // com.repackage.v05
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
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07030b));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.d = linearLayout;
        linearLayout.setOrientation(0);
        this.d.setMinimumHeight(oi.f(context, R.dimen.obfuscated_res_0x7f07030b));
        addView(this.d, new LinearLayout.LayoutParams(-1, -2));
        j(context);
        k(context);
        this.e = new View(getContext());
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, oi.f(getContext(), R.dimen.obfuscated_res_0x7f070198)));
        addView(this.e);
    }

    public void setHint(CharSequence charSequence) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, charSequence) == null) || (editText = this.b) == null) {
            return;
        }
        editText.setHint(charSequence);
    }
}

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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.a37;
import com.baidu.tieba.b37;
import com.baidu.tieba.mi5;
import com.baidu.tieba.uc5;
import com.baidu.tieba.vi5;
import com.baidu.tieba.write.WriteVideoUtil;
import com.baidu.tieba.zh5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
/* loaded from: classes6.dex */
public class TopicDetaiInputContainer extends LinearLayout implements mi5, View.OnClickListener {
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

    @Override // com.baidu.tieba.mi5
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
                this.a.S(new zh5(8, -1, null));
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
                topicDetaiInputContainer.S(new zh5(4, -1, topicDetaiInputContainer.b.getText().toString()));
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
                    this.a.S(new zh5(5, -1, null));
                    this.a.b.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements b37.i {
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

        @Override // com.baidu.tieba.b37.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.S(new zh5(5, -1, null));
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
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070422));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.d = linearLayout;
        linearLayout.setOrientation(0);
        this.d.setMinimumHeight(BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f070422));
        addView(this.d, new LinearLayout.LayoutParams(-1, -2));
        g(context);
        h(context);
        this.e = new View(getContext());
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f070198)));
        addView(this.e);
    }

    @Override // com.baidu.tieba.mi5
    public void S(zh5 zh5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zh5Var) == null) && (editorTools = this.a) != null) {
            editorTools.D(zh5Var);
        }
    }

    public final void i(zh5 zh5Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, zh5Var) == null) && zh5Var != null && (obj = zh5Var.c) != null && (obj instanceof uc5)) {
            uc5 uc5Var = (uc5) obj;
            if (uc5Var.getType() == EmotionGroupType.NET_SUG) {
                k(uc5Var);
            } else {
                j(uc5Var);
            }
        }
    }

    @Override // com.baidu.tieba.mi5
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

    @Override // com.baidu.tieba.mi5
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

    @Override // com.baidu.tieba.ai5
    public void E(zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, zh5Var) != null) || zh5Var == null) {
            return;
        }
        int i = zh5Var.a;
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
                                Object obj = zh5Var.c;
                                if (!(obj instanceof vi5)) {
                                    return;
                                }
                                vi5 vi5Var = (vi5) obj;
                                WriteImagesInfo writeImagesInfo = vi5Var.a;
                                if (writeImagesInfo != null) {
                                    if (writeImagesInfo.getChosedFiles() != null) {
                                        this.l[0] = vi5Var.a.getChosedFiles().size();
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
                            i(zh5Var);
                        }
                    } else {
                        if (((Boolean) zh5Var.c).booleanValue()) {
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
                    Object obj2 = zh5Var.c;
                    if (obj2 == null) {
                        this.b.setText((CharSequence) null);
                    } else if (obj2 instanceof String) {
                        if (TextUtils.isEmpty((String) obj2)) {
                            this.b.setText((CharSequence) null);
                        } else {
                            b37.h(getContext(), (String) zh5Var.c, new d(this));
                        }
                    }
                }
            }
            Object obj3 = zh5Var.c;
            if (obj3 != null && (!(obj3 instanceof String) || !StringUtils.isNull((String) obj3))) {
                this.k[0] = true;
            } else {
                this.k[0] = false;
            }
        } else if (this.b.getSelectionStart() > 0) {
            String substring = this.b.getText().toString().substring(0, this.b.getSelectionStart());
            Matcher matcher = a37.b.matcher(substring);
            if (matcher.find()) {
                this.b.getText().delete(this.b.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.b.getSelectionStart());
            } else {
                this.b.getText().delete(this.b.getSelectionStart() - 1, this.b.getSelectionStart());
            }
        }
        f(this.m);
    }

    @Override // com.baidu.tieba.mi5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.b != null && this.d.getVisibility() == 0) {
                this.b.setFocusable(true);
                this.b.setFocusableInTouchMode(true);
                this.b.requestFocus();
                BdUtilHelper.showSoftKeyPad(getContext(), this.b);
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
            layoutParams.setMargins(0, 0, BdUtilHelper.getDimens(context, R.dimen.tbds14), 0);
            this.d.addView(this.c, layoutParams);
        }
    }

    public final void j(uc5 uc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, uc5Var) == null) {
            if (this.g && uc5Var.getType() != EmotionGroupType.LOCAL) {
                return;
            }
            String obj = this.b.getText().toString();
            if (this.h && a37.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                b37.c(getContext(), uc5Var, this.b);
            }
        }
    }

    public final void k(uc5 uc5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, uc5Var) == null) && uc5Var != null && !TextUtils.isEmpty(uc5Var.d()) && !TextUtils.isEmpty(uc5Var.g())) {
            String obj = this.b.getText().toString();
            if (this.h && a37.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
            } else {
                b37.d(getContext(), uc5Var, this.b);
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
            WriteVideoUtil.setCursorColor(this.b, R.drawable.edittext_cursor);
            this.b.setPadding(0, BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f0701e8), BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f0703f4), BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f0701e8));
            this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.b.addTextChangedListener(new b(this));
            this.b.setOnTouchListener(new c(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(BdUtilHelper.getDimens(context, R.dimen.obfuscated_res_0x7f0701b2), 0, 0, 0);
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

    @Override // com.baidu.tieba.mi5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mi5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.mi5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0105, 2, i);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            if (i == 0) {
                WriteVideoUtil.setCursorColor(this.b, R.drawable.edittext_cursor);
                this.b.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
            } else {
                WriteVideoUtil.setCursorColor(this.b, R.drawable.edittext_cursor_2);
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

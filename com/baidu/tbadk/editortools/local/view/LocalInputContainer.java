package com.baidu.tbadk.editortools.local.view;

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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.local.view.LocalInputContainer;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.i05;
import com.repackage.kz8;
import com.repackage.lu4;
import com.repackage.o15;
import com.repackage.oi;
import com.repackage.t86;
import com.repackage.u86;
import com.repackage.v05;
import com.repackage.vr4;
import com.repackage.zw4;
import java.util.regex.Matcher;
/* loaded from: classes3.dex */
public class LocalInputContainer extends RelativeLayout implements v05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;
    public TextView b;
    public SpanGroupEditText c;
    public ImageView d;
    public TBSpecificationBtn e;
    public EditorTools f;
    public int g;
    public o15 h;
    public boolean i;
    public c j;
    public CustomMessageListener k;

    /* loaded from: classes3.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocalInputContainer a;

        public a(LocalInputContainer localInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = localInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.a.c.getText() == null || this.a.c.getText().toString().trim().isEmpty()) {
                    this.a.e.setEnabled(false);
                }
            }
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || this.a.e.isEnabled()) {
                return;
            }
            this.a.e.setEnabled(true);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocalInputContainer a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LocalInputContainer localInputContainer, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localInputContainer, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = localInputContainer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && this.a.getParent() != null && (this.a.getParent().getParent() instanceof EditorTools)) {
                ((EditorTools) this.a.getParent().getParent()).w(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(o15 o15Var, String str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalInputContainer(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.v05
    public void b() {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (spanGroupEditText = this.c) != null && spanGroupEditText.getVisibility() == 0) {
            this.c.setFocusable(true);
            this.c.setFocusableInTouchMode(true);
            this.c.requestFocus();
            oi.L(getContext(), this.c);
            setVisibility(0);
        }
    }

    @Override // com.repackage.v05
    public void d(i05 i05Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i05Var) == null) || (editorTools = this.f) == null) {
            return;
        }
        editorTools.A(i05Var);
    }

    public final void f(zw4 zw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zw4Var) == null) && zw4Var.getType() == EmotionGroupType.LOCAL) {
            u86.b(getContext(), zw4Var, this.c);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.c.getSelectionStart() <= 0 || this.c.getText() == null) {
            return;
        }
        String substring = this.c.getText().toString().substring(0, this.c.getSelectionStart());
        Matcher matcher = t86.b.matcher(substring);
        if (matcher.find()) {
            this.c.getText().delete(this.c.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.c.getSelectionStart()).toString();
            return;
        }
        this.c.getText().delete(this.c.getSelectionStart() - 1, this.c.getSelectionStart());
    }

    public String getInputContentDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.c;
            if (spanGroupEditText == null || spanGroupEditText.getText() == null) {
                return null;
            }
            return this.c.getText().toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.v05
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.g : invokeV.intValue;
    }

    public void h(o15 o15Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, o15Var) == null) || o15Var == null || o15Var.a() == null) {
            return;
        }
        this.h = o15Var;
        this.a.K(o15Var.a().c, 25, false);
        this.b.setText(o15Var.a().b);
    }

    @Override // com.repackage.v05
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setId(R.id.obfuscated_res_0x7f091314);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    @Override // com.repackage.v05
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.d = imageView;
            imageView.setId(R.id.obfuscated_res_0x7f091316);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(oi.f(getContext(), R.dimen.tbds62), oi.f(getContext(), R.dimen.tbds62));
            layoutParams.addRule(7, R.id.obfuscated_res_0x7f091315);
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f091315);
            layoutParams.setMargins(0, 0, oi.f(getContext(), R.dimen.M_W_X006), oi.f(getContext(), R.dimen.M_H_X004));
            this.d.setLayoutParams(layoutParams);
            addView(this.d);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SpanGroupEditText spanGroupEditText = new SpanGroupEditText(getContext());
            this.c = spanGroupEditText;
            spanGroupEditText.setId(R.id.obfuscated_res_0x7f091315);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(9);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f091319);
            layoutParams.setMargins(oi.f(getContext(), R.dimen.M_W_X007), oi.f(getContext(), R.dimen.M_H_X004), oi.f(getContext(), R.dimen.tbds216), oi.f(getContext(), R.dimen.M_H_X004));
            this.c.setLayoutParams(layoutParams);
            this.c.setPadding(oi.f(getContext(), R.dimen.M_W_X006), oi.f(getContext(), R.dimen.M_H_X004), oi.f(getContext(), R.dimen.M_W_X019), oi.f(getContext(), R.dimen.M_H_X004));
            this.c.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
            this.c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.c.setIncludeFontPadding(false);
            this.c.setGravity(48);
            this.c.setMinHeight(getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.c.setMaxLines(4);
            this.c.setMinLines(2);
            this.c.setLineSpacing(oi.f(getContext(), R.dimen.M_T_X002), 1.0f);
            this.c.setHint(getResources().getString(R.string.obfuscated_res_0x7f0f0a3d));
            addView(this.c);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.d.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.r15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        LocalInputContainer.this.p(view2);
                    }
                }
            });
            SpanGroupEditText spanGroupEditText = this.c;
            if (spanGroupEditText != null) {
                spanGroupEditText.addTextChangedListener(new a(this));
                this.c.setOnTouchListener(new View.OnTouchListener() { // from class: com.repackage.t15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view2, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? LocalInputContainer.this.q(view2, motionEvent) : invokeLL.booleanValue;
                    }
                });
            }
            TBSpecificationBtn tBSpecificationBtn = this.e;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.u15
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            LocalInputContainer.this.r(view2);
                        }
                    }
                });
            }
            this.k = new b(this, 2001304);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.e = tBSpecificationBtn;
            tBSpecificationBtn.setId(R.id.obfuscated_res_0x7f091317);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(oi.f(getContext(), R.dimen.tbds151), oi.f(getContext(), R.dimen.tbds75));
            layoutParams.setMargins(0, 0, oi.f(getContext(), R.dimen.M_W_X007), 0);
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f091315);
            layoutParams.addRule(11, R.id.obfuscated_res_0x7f091315);
            this.e.setLayoutParams(layoutParams);
            lu4 lu4Var = new lu4();
            lu4Var.p(R.color.CAM_X0302, R.color.CAM_X0101);
            this.e.setConfig(lu4Var);
            this.e.setEnabled(false);
            this.e.setTextSize(R.dimen.T_X08);
            this.e.setText(getContext().getString(R.string.obfuscated_res_0x7f0f10e7));
            addView(this.e);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            HeadImageView headImageView = new HeadImageView(getContext());
            this.a = headImageView;
            headImageView.setId(R.id.obfuscated_res_0x7f091319);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(oi.f(getContext(), R.dimen.tbds62), oi.f(getContext(), R.dimen.tbds62));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.setMargins(oi.f(getContext(), R.dimen.M_W_X007), oi.f(getContext(), R.dimen.M_W_X007), 0, 0);
            this.a.setLayoutParams(layoutParams);
            this.a.setConrers(15);
            this.a.setIsRound(true);
            this.a.setPlaceHolder(3);
            addView(this.a);
            TextView textView = new TextView(getContext());
            this.b = textView;
            textView.setId(R.id.obfuscated_res_0x7f09131a);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, R.id.obfuscated_res_0x7f091319);
            layoutParams2.addRule(6, R.id.obfuscated_res_0x7f091319);
            layoutParams2.addRule(8, R.id.obfuscated_res_0x7f091319);
            layoutParams2.setMargins(oi.f(getContext(), R.dimen.M_W_X004), 0, 0, 0);
            this.b.setLayoutParams(layoutParams2);
            this.b.setGravity(16);
            vr4.d(this.b).z(R.dimen.T_X09);
            addView(this.b);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            i();
            n();
            k();
            j();
            m();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.repackage.j05
    public void onAction(i05 i05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, i05Var) == null) {
            int i = i05Var.a;
            if (i == 3) {
                g();
            } else if (i != 6) {
                if (i != 24) {
                    return;
                }
                t(i05Var);
            } else {
                SpanGroupEditText spanGroupEditText = this.c;
                if (spanGroupEditText == null) {
                    return;
                }
                Object obj = i05Var.c;
                if (obj == null) {
                    spanGroupEditText.setText((CharSequence) null);
                } else if (obj instanceof String) {
                    String str = (String) obj;
                    if (TextUtils.isEmpty(str)) {
                        this.c.setText((CharSequence) null);
                    } else {
                        u86.e(getContext(), str, new u86.g() { // from class: com.repackage.s15
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // com.repackage.u86.g
                            public final void a(SpannableStringBuilder spannableStringBuilder) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, spannableStringBuilder) == null) {
                                    LocalInputContainer.this.s(spannableStringBuilder);
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.k);
        }
    }

    @Override // com.repackage.v05
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            vr4.d(this).f(R.color.CAM_X0207);
            vr4.d(this.b).v(R.color.CAM_X0107);
            if (i == 0) {
                kz8.l(this.c, R.drawable.obfuscated_res_0x7f0804b6);
            } else {
                kz8.l(this.c, R.drawable.obfuscated_res_0x7f0804b7);
            }
            this.c.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.c.setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0109));
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i).setShape(0).radius(oi.f(getContext(), R.dimen.tbds21)).into(this.c);
            this.d.setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(R.drawable.obfuscated_res_0x7f080966, R.drawable.obfuscated_res_0x7f080813, i));
            this.e.k();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.k);
        }
    }

    public /* synthetic */ void p(View view2) {
        if (this.i) {
            this.i = false;
            this.d.setSelected(false);
            d(new i05(5, 5, null));
            oi.L(getContext(), this.c);
            return;
        }
        this.i = true;
        this.d.setSelected(true);
        d(new i05(1, 5, null));
    }

    public /* synthetic */ boolean q(View view2, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            d(new i05(5, -1, null));
            this.c.requestFocus();
            this.d.setSelected(false);
            this.i = false;
        }
        return false;
    }

    public /* synthetic */ void r(View view2) {
        SpanGroupEditText spanGroupEditText = this.c;
        if (spanGroupEditText == null || spanGroupEditText.getText() == null || this.c.getText().toString().isEmpty() || this.j == null) {
            return;
        }
        this.j.a(this.h, this.c.getText().toString().trim());
    }

    public /* synthetic */ void s(SpannableStringBuilder spannableStringBuilder) {
        this.c.setText(spannableStringBuilder);
        if (this.c.getText() != null) {
            SpanGroupEditText spanGroupEditText = this.c;
            spanGroupEditText.setSelection(spanGroupEditText.getText().length());
        }
        d(new i05(5, -1, null));
        requestFocus();
    }

    @Override // com.repackage.v05
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, editorTools) == null) {
            this.f = editorTools;
        }
    }

    public void setSendBtnClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            this.j = cVar;
        }
    }

    @Override // com.repackage.v05
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.g = i;
        }
    }

    public final void t(i05 i05Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, i05Var) == null) || i05Var == null || (obj = i05Var.c) == null || !(obj instanceof zw4) || ((zw4) obj).getType() == EmotionGroupType.BIG_EMOTION || ((zw4) i05Var.c).getType() == EmotionGroupType.USER_COLLECT) {
            return;
        }
        f((zw4) i05Var.c);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        o();
        l();
    }
}

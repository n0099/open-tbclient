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
import c.a.o0.s.c.u;
import c.a.o0.w.n;
import c.a.p0.s4.i;
import c.a.p0.z0.b;
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
import java.util.regex.Matcher;
/* loaded from: classes5.dex */
public class LocalInputContainer extends RelativeLayout implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadImageView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f30514b;

    /* renamed from: c  reason: collision with root package name */
    public SpanGroupEditText f30515c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f30516d;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f30517e;

    /* renamed from: f  reason: collision with root package name */
    public EditorTools f30518f;

    /* renamed from: g  reason: collision with root package name */
    public int f30519g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.o0.w.v.f.a f30520h;
    public boolean i;
    public c j;
    public CustomMessageListener k;

    /* loaded from: classes5.dex */
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
                if (this.a.f30515c.getText() == null || this.a.f30515c.getText().toString().trim().isEmpty()) {
                    this.a.f30517e.setEnabled(false);
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) || this.a.f30517e.isEnabled()) {
                return;
            }
            this.a.f30517e.setEnabled(true);
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public interface c {
        void a(c.a.o0.w.v.f.a aVar, String str);
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

    @Override // c.a.o0.w.n
    public void b() {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (spanGroupEditText = this.f30515c) != null && spanGroupEditText.getVisibility() == 0) {
            this.f30515c.setFocusable(true);
            this.f30515c.setFocusableInTouchMode(true);
            this.f30515c.requestFocus();
            c.a.d.f.p.n.L(getContext(), this.f30515c);
            setVisibility(0);
        }
    }

    @Override // c.a.o0.w.n
    public void d(c.a.o0.w.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || (editorTools = this.f30518f) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    public final void e(u uVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uVar) == null) && uVar.getType() == EmotionGroupType.LOCAL) {
            c.a.p0.z0.b.b(getContext(), uVar, this.f30515c);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f30515c.getSelectionStart() <= 0 || this.f30515c.getText() == null) {
            return;
        }
        String substring = this.f30515c.getText().toString().substring(0, this.f30515c.getSelectionStart());
        Matcher matcher = c.a.p0.z0.a.f20857b.matcher(substring);
        if (matcher.find()) {
            this.f30515c.getText().delete(this.f30515c.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f30515c.getSelectionStart()).toString();
            return;
        }
        this.f30515c.getText().delete(this.f30515c.getSelectionStart() - 1, this.f30515c.getSelectionStart());
    }

    public String getInputContentDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.f30515c;
            if (spanGroupEditText == null || spanGroupEditText.getText() == null) {
                return null;
            }
            return this.f30515c.getText().toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.o0.w.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30519g : invokeV.intValue;
    }

    public void h(c.a.o0.w.v.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) || aVar == null || aVar.a() == null) {
            return;
        }
        this.f30520h = aVar;
        this.a.J(aVar.a().f11456c, 25, false);
        this.f30514b.setText(aVar.a().f11455b);
    }

    @Override // c.a.o0.w.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setId(R.id.obfuscated_res_0x7f09131f);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    @Override // c.a.o0.w.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.f30516d = imageView;
            imageView.setId(R.id.obfuscated_res_0x7f091321);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), R.dimen.tbds62), c.a.d.f.p.n.f(getContext(), R.dimen.tbds62));
            layoutParams.addRule(7, R.id.obfuscated_res_0x7f091320);
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f091320);
            layoutParams.setMargins(0, 0, c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X006), c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X004));
            this.f30516d.setLayoutParams(layoutParams);
            addView(this.f30516d);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SpanGroupEditText spanGroupEditText = new SpanGroupEditText(getContext());
            this.f30515c = spanGroupEditText;
            spanGroupEditText.setId(R.id.obfuscated_res_0x7f091320);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(9);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f091324);
            layoutParams.setMargins(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X007), c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X004), c.a.d.f.p.n.f(getContext(), R.dimen.tbds216), c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X004));
            this.f30515c.setLayoutParams(layoutParams);
            this.f30515c.setPadding(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X006), c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X004), c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X019), c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X004));
            this.f30515c.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
            this.f30515c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.f30515c.setIncludeFontPadding(false);
            this.f30515c.setGravity(48);
            this.f30515c.setMinHeight(getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.f30515c.setMaxLines(4);
            this.f30515c.setMinLines(2);
            this.f30515c.setLineSpacing(c.a.d.f.p.n.f(getContext(), R.dimen.M_T_X002), 1.0f);
            this.f30515c.setHint(getResources().getString(R.string.obfuscated_res_0x7f0f0a3b));
            addView(this.f30515c);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f30516d.setOnClickListener(new View.OnClickListener() { // from class: c.a.o0.w.v.h.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        LocalInputContainer.this.p(view);
                    }
                }
            });
            SpanGroupEditText spanGroupEditText = this.f30515c;
            if (spanGroupEditText != null) {
                spanGroupEditText.addTextChangedListener(new a(this));
                this.f30515c.setOnTouchListener(new View.OnTouchListener() { // from class: c.a.o0.w.v.h.c
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) ? LocalInputContainer.this.q(view, motionEvent) : invokeLL.booleanValue;
                    }
                });
            }
            TBSpecificationBtn tBSpecificationBtn = this.f30517e;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: c.a.o0.w.v.h.d
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            LocalInputContainer.this.r(view);
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
            this.f30517e = tBSpecificationBtn;
            tBSpecificationBtn.setId(R.id.obfuscated_res_0x7f091322);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), R.dimen.tbds151), c.a.d.f.p.n.f(getContext(), R.dimen.tbds75));
            layoutParams.setMargins(0, 0, c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X007), 0);
            layoutParams.addRule(8, R.id.obfuscated_res_0x7f091320);
            layoutParams.addRule(11, R.id.obfuscated_res_0x7f091320);
            this.f30517e.setLayoutParams(layoutParams);
            c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
            bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
            this.f30517e.setConfig(bVar);
            this.f30517e.setEnabled(false);
            this.f30517e.setTextSize(R.dimen.T_X08);
            this.f30517e.setText(getContext().getString(R.string.obfuscated_res_0x7f0f10e0));
            addView(this.f30517e);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            HeadImageView headImageView = new HeadImageView(getContext());
            this.a = headImageView;
            headImageView.setId(R.id.obfuscated_res_0x7f091324);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), R.dimen.tbds62), c.a.d.f.p.n.f(getContext(), R.dimen.tbds62));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.setMargins(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X007), c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X007), 0, 0);
            this.a.setLayoutParams(layoutParams);
            this.a.setConrers(15);
            this.a.setIsRound(true);
            this.a.setPlaceHolder(3);
            addView(this.a);
            TextView textView = new TextView(getContext());
            this.f30514b = textView;
            textView.setId(R.id.obfuscated_res_0x7f091325);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, R.id.obfuscated_res_0x7f091324);
            layoutParams2.addRule(6, R.id.obfuscated_res_0x7f091324);
            layoutParams2.addRule(8, R.id.obfuscated_res_0x7f091324);
            layoutParams2.setMargins(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X004), 0, 0, 0);
            this.f30514b.setLayoutParams(layoutParams2);
            this.f30514b.setGravity(16);
            c.a.o0.r.v.c.d(this.f30514b).z(R.dimen.T_X09);
            addView(this.f30514b);
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

    @Override // c.a.o0.w.b
    public void onAction(c.a.o0.w.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) {
            int i = aVar.a;
            if (i == 3) {
                g();
            } else if (i != 6) {
                if (i != 24) {
                    return;
                }
                t(aVar);
            } else {
                SpanGroupEditText spanGroupEditText = this.f30515c;
                if (spanGroupEditText == null) {
                    return;
                }
                Object obj = aVar.f11499c;
                if (obj == null) {
                    spanGroupEditText.setText((CharSequence) null);
                } else if (obj instanceof String) {
                    String str = (String) obj;
                    if (TextUtils.isEmpty(str)) {
                        this.f30515c.setText((CharSequence) null);
                    } else {
                        c.a.p0.z0.b.e(getContext(), str, new b.g() { // from class: c.a.o0.w.v.h.b
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // c.a.p0.z0.b.g
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

    @Override // c.a.o0.w.n
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            c.a.o0.r.v.c.d(this).f(R.color.CAM_X0207);
            c.a.o0.r.v.c.d(this.f30514b).v(R.color.CAM_X0107);
            if (i == 0) {
                i.l(this.f30515c, R.drawable.obfuscated_res_0x7f0804b8);
            } else {
                i.l(this.f30515c, R.drawable.obfuscated_res_0x7f0804b9);
            }
            this.f30515c.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f30515c.setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0109));
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i).setShape(0).radius(c.a.d.f.p.n.f(getContext(), R.dimen.tbds21)).into(this.f30515c);
            this.f30516d.setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(R.drawable.obfuscated_res_0x7f08095c, R.drawable.obfuscated_res_0x7f080810, i));
            this.f30517e.k();
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

    public /* synthetic */ void p(View view) {
        if (this.i) {
            this.i = false;
            this.f30516d.setSelected(false);
            d(new c.a.o0.w.a(5, 5, null));
            c.a.d.f.p.n.L(getContext(), this.f30515c);
            return;
        }
        this.i = true;
        this.f30516d.setSelected(true);
        d(new c.a.o0.w.a(1, 5, null));
    }

    public /* synthetic */ boolean q(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            d(new c.a.o0.w.a(5, -1, null));
            this.f30515c.requestFocus();
            this.f30516d.setSelected(false);
            this.i = false;
        }
        return false;
    }

    public /* synthetic */ void r(View view) {
        SpanGroupEditText spanGroupEditText = this.f30515c;
        if (spanGroupEditText == null || spanGroupEditText.getText() == null || this.f30515c.getText().toString().isEmpty() || this.j == null) {
            return;
        }
        this.j.a(this.f30520h, this.f30515c.getText().toString().trim());
    }

    public /* synthetic */ void s(SpannableStringBuilder spannableStringBuilder) {
        this.f30515c.setText(spannableStringBuilder);
        if (this.f30515c.getText() != null) {
            SpanGroupEditText spanGroupEditText = this.f30515c;
            spanGroupEditText.setSelection(spanGroupEditText.getText().length());
        }
        d(new c.a.o0.w.a(5, -1, null));
        requestFocus();
    }

    @Override // c.a.o0.w.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, editorTools) == null) {
            this.f30518f = editorTools;
        }
    }

    public void setSendBtnClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            this.j = cVar;
        }
    }

    @Override // c.a.o0.w.n
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.f30519g = i;
        }
    }

    public final void t(c.a.o0.w.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, aVar) == null) || aVar == null || (obj = aVar.f11499c) == null || !(obj instanceof u) || ((u) obj).getType() == EmotionGroupType.BIG_EMOTION || ((u) aVar.f11499c).getType() == EmotionGroupType.USER_COLLECT) {
            return;
        }
        e((u) aVar.f11499c);
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

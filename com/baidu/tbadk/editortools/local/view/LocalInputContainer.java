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
import c.a.t0.t.c.w;
import c.a.t0.x.n;
import c.a.u0.a4.d;
import c.a.u0.a4.e;
import c.a.u0.a4.f;
import c.a.u0.a4.g;
import c.a.u0.a4.j;
import c.a.u0.s4.s;
import c.a.u0.y0.b;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
/* loaded from: classes11.dex */
public class LocalInputContainer extends RelativeLayout implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f41208e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f41209f;

    /* renamed from: g  reason: collision with root package name */
    public SpanGroupEditText f41210g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f41211h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f41212i;

    /* renamed from: j  reason: collision with root package name */
    public EditorTools f41213j;
    public int k;
    public c.a.t0.x.v.f.a l;
    public boolean m;
    public c n;
    public CustomMessageListener o;

    /* loaded from: classes11.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LocalInputContainer f41214e;

        public a(LocalInputContainer localInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41214e = localInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f41214e.f41210g.getText() == null || this.f41214e.f41210g.getText().toString().trim().isEmpty()) {
                    this.f41214e.f41212i.setEnabled(false);
                }
            }
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f41214e.f41212i.isEnabled()) {
                return;
            }
            this.f41214e.f41212i.setEnabled(true);
        }
    }

    /* loaded from: classes11.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LocalInputContainer a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LocalInputContainer localInputContainer, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {localInputContainer, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                ((EditorTools) this.a.getParent().getParent()).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    /* loaded from: classes11.dex */
    public interface c {
        void a(c.a.t0.x.v.f.a aVar, String str);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void c(w wVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, wVar) == null) && wVar.getType() == EmotionGroupType.LOCAL) {
            c.a.u0.y0.b.b(getContext(), wVar, this.f41210g);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f41210g.getSelectionStart() <= 0 || this.f41210g.getText() == null) {
            return;
        }
        String substring = this.f41210g.getText().toString().substring(0, this.f41210g.getSelectionStart());
        Matcher matcher = c.a.u0.y0.a.f25325b.matcher(substring);
        if (matcher.find()) {
            this.f41210g.getText().delete(this.f41210g.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f41210g.getSelectionStart()).toString();
            return;
        }
        this.f41210g.getText().delete(this.f41210g.getSelectionStart() - 1, this.f41210g.getSelectionStart());
    }

    @Override // c.a.t0.x.n
    public void display() {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (spanGroupEditText = this.f41210g) != null && spanGroupEditText.getVisibility() == 0) {
            this.f41210g.setFocusable(true);
            this.f41210g.setFocusableInTouchMode(true);
            this.f41210g.requestFocus();
            c.a.d.f.p.n.L(getContext(), this.f41210g);
            setVisibility(0);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setId(g.local_input_container);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.f41211h = imageView;
            imageView.setId(g.local_input_emotion_img);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), e.tbds62), c.a.d.f.p.n.f(getContext(), e.tbds62));
            layoutParams.addRule(7, g.local_input_edit_text);
            layoutParams.addRule(8, g.local_input_edit_text);
            layoutParams.setMargins(0, 0, c.a.d.f.p.n.f(getContext(), e.M_W_X006), c.a.d.f.p.n.f(getContext(), e.M_H_X004));
            this.f41211h.setLayoutParams(layoutParams);
            addView(this.f41211h);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SpanGroupEditText spanGroupEditText = new SpanGroupEditText(getContext());
            this.f41210g = spanGroupEditText;
            spanGroupEditText.setId(g.local_input_edit_text);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(9);
            layoutParams.addRule(3, g.local_input_user_head_img);
            layoutParams.setMargins(c.a.d.f.p.n.f(getContext(), e.M_W_X007), c.a.d.f.p.n.f(getContext(), e.M_H_X004), c.a.d.f.p.n.f(getContext(), e.tbds216), c.a.d.f.p.n.f(getContext(), e.M_H_X004));
            this.f41210g.setLayoutParams(layoutParams);
            this.f41210g.setPadding(c.a.d.f.p.n.f(getContext(), e.M_W_X006), c.a.d.f.p.n.f(getContext(), e.M_H_X004), c.a.d.f.p.n.f(getContext(), e.M_W_X019), c.a.d.f.p.n.f(getContext(), e.M_H_X004));
            this.f41210g.setTextSize(0, getResources().getDimensionPixelSize(e.T_X06));
            this.f41210g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.f41210g.setIncludeFontPadding(false);
            this.f41210g.setGravity(48);
            this.f41210g.setMinHeight(getResources().getDimensionPixelSize(e.M_H_X005));
            this.f41210g.setMaxLines(4);
            this.f41210g.setMinLines(2);
            this.f41210g.setLineSpacing(c.a.d.f.p.n.f(getContext(), e.M_T_X002), 1.0f);
            this.f41210g.setHint(getResources().getString(j.local_input_hint));
            addView(this.f41210g);
        }
    }

    public String getInputContentDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.f41210g;
            if (spanGroupEditText == null || spanGroupEditText.getText() == null) {
                return null;
            }
            return this.f41210g.getText().toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.t0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f41211h.setOnClickListener(new View.OnClickListener() { // from class: c.a.t0.x.v.h.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        LocalInputContainer.this.l(view);
                    }
                }
            });
            SpanGroupEditText spanGroupEditText = this.f41210g;
            if (spanGroupEditText != null) {
                spanGroupEditText.addTextChangedListener(new a(this));
                this.f41210g.setOnTouchListener(new View.OnTouchListener() { // from class: c.a.t0.x.v.h.c
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) ? LocalInputContainer.this.m(view, motionEvent) : invokeLL.booleanValue;
                    }
                });
            }
            TBSpecificationBtn tBSpecificationBtn = this.f41212i;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: c.a.t0.x.v.h.d
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            LocalInputContainer.this.n(view);
                        }
                    }
                });
            }
            this.o = new b(this, 2001304);
        }
    }

    @Override // c.a.t0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.f41212i = tBSpecificationBtn;
            tBSpecificationBtn.setId(g.local_input_send_btn);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), e.tbds151), c.a.d.f.p.n.f(getContext(), e.tbds75));
            layoutParams.setMargins(0, 0, c.a.d.f.p.n.f(getContext(), e.M_W_X007), 0);
            layoutParams.addRule(8, g.local_input_edit_text);
            layoutParams.addRule(11, g.local_input_edit_text);
            this.f41212i.setLayoutParams(layoutParams);
            c.a.t0.s.l0.n.b bVar = new c.a.t0.s.l0.n.b();
            bVar.p(d.CAM_X0302, d.CAM_X0101);
            this.f41212i.setConfig(bVar);
            this.f41212i.setEnabled(false);
            this.f41212i.setTextSize(e.T_X08);
            this.f41212i.setText(getContext().getString(j.send_msg));
            addView(this.f41212i);
        }
    }

    @Override // c.a.t0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public void init(c.a.t0.x.v.f.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || aVar == null || aVar.a() == null) {
            return;
        }
        this.l = aVar;
        this.f41208e.startLoad(aVar.a().f14548g, 25, false);
        this.f41209f.setText(aVar.a().f14547f);
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            HeadImageView headImageView = new HeadImageView(getContext());
            this.f41208e = headImageView;
            headImageView.setId(g.local_input_user_head_img);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), e.tbds62), c.a.d.f.p.n.f(getContext(), e.tbds62));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.setMargins(c.a.d.f.p.n.f(getContext(), e.M_W_X007), c.a.d.f.p.n.f(getContext(), e.M_W_X007), 0, 0);
            this.f41208e.setLayoutParams(layoutParams);
            this.f41208e.setConrers(15);
            this.f41208e.setIsRound(true);
            this.f41208e.setPlaceHolder(3);
            addView(this.f41208e);
            TextView textView = new TextView(getContext());
            this.f41209f = textView;
            textView.setId(g.local_input_user_nick_name);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, g.local_input_user_head_img);
            layoutParams2.addRule(6, g.local_input_user_head_img);
            layoutParams2.addRule(8, g.local_input_user_head_img);
            layoutParams2.setMargins(c.a.d.f.p.n.f(getContext(), e.M_W_X004), 0, 0, 0);
            this.f41209f.setLayoutParams(layoutParams2);
            this.f41209f.setGravity(16);
            c.a.t0.s.v.c.d(this.f41209f).z(e.T_X09);
            addView(this.f41209f);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            e();
            j();
            g();
            f();
            i();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public /* synthetic */ void l(View view) {
        if (this.m) {
            this.m = false;
            this.f41211h.setSelected(false);
            sendAction(new c.a.t0.x.a(5, 5, null));
            c.a.d.f.p.n.L(getContext(), this.f41210g);
            return;
        }
        this.m = true;
        this.f41211h.setSelected(true);
        sendAction(new c.a.t0.x.a(1, 5, null));
    }

    public /* synthetic */ boolean m(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            sendAction(new c.a.t0.x.a(5, -1, null));
            this.f41210g.requestFocus();
            this.f41211h.setSelected(false);
            this.m = false;
        }
        return false;
    }

    public /* synthetic */ void n(View view) {
        SpanGroupEditText spanGroupEditText = this.f41210g;
        if (spanGroupEditText == null || spanGroupEditText.getText() == null || this.f41210g.getText().toString().isEmpty() || this.n == null) {
            return;
        }
        this.n.a(this.l, this.f41210g.getText().toString().trim());
    }

    public /* synthetic */ void o(SpannableStringBuilder spannableStringBuilder) {
        this.f41210g.setText(spannableStringBuilder);
        if (this.f41210g.getText() != null) {
            SpanGroupEditText spanGroupEditText = this.f41210g;
            spanGroupEditText.setSelection(spanGroupEditText.getText().length());
        }
        sendAction(new c.a.t0.x.a(5, -1, null));
        requestFocus();
    }

    @Override // c.a.t0.x.b
    public void onAction(c.a.t0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, aVar) == null) {
            int i2 = aVar.a;
            if (i2 == 3) {
                d();
            } else if (i2 != 6) {
                if (i2 != 24) {
                    return;
                }
                p(aVar);
            } else {
                SpanGroupEditText spanGroupEditText = this.f41210g;
                if (spanGroupEditText == null) {
                    return;
                }
                Object obj = aVar.f14594c;
                if (obj == null) {
                    spanGroupEditText.setText((CharSequence) null);
                } else if (obj instanceof String) {
                    String str = (String) obj;
                    if (TextUtils.isEmpty(str)) {
                        this.f41210g.setText((CharSequence) null);
                    } else {
                        c.a.u0.y0.b.e(getContext(), str, new b.g() { // from class: c.a.t0.x.v.h.b
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // c.a.u0.y0.b.g
                            public final void a(SpannableStringBuilder spannableStringBuilder) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, spannableStringBuilder) == null) {
                                    LocalInputContainer.this.o(spannableStringBuilder);
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
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.o);
        }
    }

    @Override // c.a.t0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            c.a.t0.s.v.c.d(this).f(d.CAM_X0207);
            c.a.t0.s.v.c.d(this.f41209f).v(d.CAM_X0107);
            if (i2 == 0) {
                s.l(this.f41210g, f.edittext_cursor);
            } else {
                s.l(this.f41210g, f.edittext_cursor_1);
            }
            this.f41210g.setTextColor(SkinManager.getColor(d.CAM_X0105));
            this.f41210g.setHintTextColor(SkinManager.getColor(i2, d.CAM_X0109));
            TBSelector.makeDrawableSelector().defaultColor(d.CAM_X0209, i2).setShape(0).radius(c.a.d.f.p.n.f(getContext(), e.tbds21)).into(this.f41210g);
            this.f41211h.setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(f.icon_pure_post_expression24, f.icon_mask_post_keyboard24_selection, i2));
            this.f41212i.changeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    public final void p(c.a.t0.x.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) || aVar == null || (obj = aVar.f14594c) == null || !(obj instanceof w) || ((w) obj).getType() == EmotionGroupType.BIG_EMOTION || ((w) aVar.f14594c).getType() == EmotionGroupType.USER_COLLECT) {
            return;
        }
        c((w) aVar.f14594c);
    }

    @Override // c.a.t0.x.n
    public void sendAction(c.a.t0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) || (editorTools = this.f41213j) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    @Override // c.a.t0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, editorTools) == null) {
            this.f41213j = editorTools;
        }
    }

    public void setSendBtnClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) {
            this.n = cVar;
        }
    }

    @Override // c.a.t0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.k = i2;
        }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalInputContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        k();
        h();
    }
}

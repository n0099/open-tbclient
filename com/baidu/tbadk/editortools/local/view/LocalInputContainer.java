package com.baidu.tbadk.editortools.local.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.t.c.w;
import c.a.s0.x.n;
import c.a.t0.o4.s;
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
/* loaded from: classes11.dex */
public class LocalInputContainer extends RelativeLayout implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f42437e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42438f;

    /* renamed from: g  reason: collision with root package name */
    public SpanGroupEditText f42439g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f42440h;

    /* renamed from: i  reason: collision with root package name */
    public TBSpecificationBtn f42441i;

    /* renamed from: j  reason: collision with root package name */
    public EditorTools f42442j;

    /* renamed from: k  reason: collision with root package name */
    public int f42443k;
    public c.a.s0.x.v.e.a l;
    public boolean m;
    public c n;
    public CustomMessageListener o;

    /* loaded from: classes11.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LocalInputContainer f42444e;

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
            this.f42444e = localInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                if (this.f42444e.f42439g.getText() == null || this.f42444e.f42439g.getText().toString().trim().isEmpty()) {
                    this.f42444e.f42441i.setEnabled(false);
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f42444e.f42441i.isEnabled()) {
                return;
            }
            this.f42444e.f42441i.setEnabled(true);
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
        void a(c.a.s0.x.v.e.a aVar, String str);
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
            c.a.t0.x0.b.b(getContext(), wVar, this.f42439g);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f42439g.getSelectionStart() <= 0 || this.f42439g.getText() == null) {
            return;
        }
        String substring = this.f42439g.getText().toString().substring(0, this.f42439g.getSelectionStart());
        Matcher matcher = c.a.t0.x0.a.f25852b.matcher(substring);
        if (matcher.find()) {
            this.f42439g.getText().delete(this.f42439g.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.f42439g.getSelectionStart()).toString();
            return;
        }
        this.f42439g.getText().delete(this.f42439g.getSelectionStart() - 1, this.f42439g.getSelectionStart());
    }

    @Override // c.a.s0.x.n
    public void display() {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (spanGroupEditText = this.f42439g) != null && spanGroupEditText.getVisibility() == 0) {
            this.f42439g.setFocusable(true);
            this.f42439g.setFocusableInTouchMode(true);
            this.f42439g.requestFocus();
            c.a.d.f.p.n.K(getContext(), this.f42439g);
            setVisibility(0);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            setId(R.id.local_input_container);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ImageView imageView = new ImageView(getContext());
            this.f42440h = imageView;
            imageView.setId(R.id.local_input_emotion_img);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), R.dimen.tbds62), c.a.d.f.p.n.f(getContext(), R.dimen.tbds62));
            layoutParams.addRule(7, R.id.local_input_edit_text);
            layoutParams.addRule(8, R.id.local_input_edit_text);
            layoutParams.setMargins(0, 0, c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X006), c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X004));
            this.f42440h.setLayoutParams(layoutParams);
            addView(this.f42440h);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SpanGroupEditText spanGroupEditText = new SpanGroupEditText(getContext());
            this.f42439g = spanGroupEditText;
            spanGroupEditText.setId(R.id.local_input_edit_text);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(9);
            layoutParams.addRule(3, R.id.local_input_user_head_img);
            layoutParams.setMargins(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X007), c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X004), c.a.d.f.p.n.f(getContext(), R.dimen.tbds216), c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X004));
            this.f42439g.setLayoutParams(layoutParams);
            this.f42439g.setPadding(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X006), c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X004), c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X019), c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X004));
            this.f42439g.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
            this.f42439g.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.f42439g.setIncludeFontPadding(false);
            this.f42439g.setGravity(48);
            this.f42439g.setMinHeight(getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.f42439g.setMaxLines(4);
            this.f42439g.setMinLines(2);
            this.f42439g.setLineSpacing(c.a.d.f.p.n.f(getContext(), R.dimen.M_T_X002), 1.0f);
            this.f42439g.setHint(getResources().getString(R.string.local_input_hint));
            addView(this.f42439g);
        }
    }

    @Override // c.a.s0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f42443k : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f42440h.setOnClickListener(new View.OnClickListener() { // from class: c.a.s0.x.v.g.c
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
            SpanGroupEditText spanGroupEditText = this.f42439g;
            if (spanGroupEditText != null) {
                spanGroupEditText.addTextChangedListener(new a(this));
                this.f42439g.setOnTouchListener(new View.OnTouchListener() { // from class: c.a.s0.x.v.g.a
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) ? LocalInputContainer.this.l(view, motionEvent) : invokeLL.booleanValue;
                    }
                });
            }
            TBSpecificationBtn tBSpecificationBtn = this.f42441i;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setOnClickListener(new View.OnClickListener() { // from class: c.a.s0.x.v.g.b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            LocalInputContainer.this.m(view);
                        }
                    }
                });
            }
            this.o = new b(this, 2001304);
        }
    }

    @Override // c.a.s0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setVisibility(8);
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.f42441i = tBSpecificationBtn;
            tBSpecificationBtn.setId(R.id.local_input_send_btn);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), R.dimen.tbds151), c.a.d.f.p.n.f(getContext(), R.dimen.tbds75));
            layoutParams.setMargins(0, 0, c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X007), 0);
            layoutParams.addRule(8, R.id.local_input_edit_text);
            layoutParams.addRule(11, R.id.local_input_edit_text);
            this.f42441i.setLayoutParams(layoutParams);
            c.a.s0.s.i0.n.b bVar = new c.a.s0.s.i0.n.b();
            bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
            this.f42441i.setConfig(bVar);
            this.f42441i.setEnabled(false);
            this.f42441i.setTextSize(R.dimen.T_X08);
            this.f42441i.setText(getContext().getString(R.string.send_msg));
            addView(this.f42441i);
        }
    }

    @Override // c.a.s0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
        }
    }

    public void init(c.a.s0.x.v.e.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null || aVar.a() == null) {
            return;
        }
        this.l = aVar;
        this.f42437e.startLoad(aVar.a().f14471g, 25, false);
        this.f42438f.setText(aVar.a().f14470f);
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            HeadImageView headImageView = new HeadImageView(getContext());
            this.f42437e = headImageView;
            headImageView.setId(R.id.local_input_user_head_img);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), R.dimen.tbds62), c.a.d.f.p.n.f(getContext(), R.dimen.tbds62));
            layoutParams.addRule(9);
            layoutParams.addRule(10);
            layoutParams.setMargins(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X007), c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X007), 0, 0);
            this.f42437e.setLayoutParams(layoutParams);
            this.f42437e.setConrers(15);
            this.f42437e.setIsRound(true);
            this.f42437e.setPlaceHolder(3);
            addView(this.f42437e);
            TextView textView = new TextView(getContext());
            this.f42438f = textView;
            textView.setId(R.id.local_input_user_nick_name);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(1, R.id.local_input_user_head_img);
            layoutParams2.addRule(6, R.id.local_input_user_head_img);
            layoutParams2.addRule(8, R.id.local_input_user_head_img);
            layoutParams2.setMargins(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X004), 0, 0, 0);
            this.f42438f.setLayoutParams(layoutParams2);
            this.f42438f.setGravity(16);
            c.a.s0.s.u.c.d(this.f42438f).z(R.dimen.T_X09);
            addView(this.f42438f);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            e();
            j();
            g();
            f();
            i();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public /* synthetic */ boolean l(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            sendAction(new c.a.s0.x.a(5, -1, null));
            this.f42439g.requestFocus();
            this.f42440h.setSelected(false);
            this.m = false;
        }
        return false;
    }

    public /* synthetic */ void m(View view) {
        SpanGroupEditText spanGroupEditText = this.f42439g;
        if (spanGroupEditText == null || spanGroupEditText.getText() == null || this.f42439g.getText().toString().isEmpty() || this.n == null) {
            return;
        }
        this.n.a(this.l, this.f42439g.getText().toString().trim());
    }

    public /* synthetic */ void n(View view) {
        if (this.m) {
            this.m = false;
            this.f42440h.setSelected(false);
            sendAction(new c.a.s0.x.a(5, 5, null));
            c.a.d.f.p.n.K(getContext(), this.f42439g);
            return;
        }
        this.m = true;
        this.f42440h.setSelected(true);
        sendAction(new c.a.s0.x.a(1, 5, null));
    }

    public final void o(c.a.s0.x.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) || aVar == null || (obj = aVar.f14519c) == null || !(obj instanceof w) || ((w) obj).getType() == EmotionGroupType.BIG_EMOTION || ((w) aVar.f14519c).getType() == EmotionGroupType.USER_COLLECT) {
            return;
        }
        c((w) aVar.f14519c);
    }

    @Override // c.a.s0.x.b
    public void onAction(c.a.s0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            int i2 = aVar.a;
            if (i2 == 3) {
                d();
            } else if (i2 != 24) {
            } else {
                o(aVar);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.o);
        }
    }

    @Override // c.a.s0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            c.a.s0.s.u.c.d(this).f(R.color.CAM_X0207);
            c.a.s0.s.u.c.d(this.f42438f).v(R.color.CAM_X0107);
            if (i2 == 0) {
                s.n(this.f42439g, R.drawable.edittext_cursor);
            } else {
                s.n(this.f42439g, R.drawable.edittext_cursor_1);
            }
            this.f42439g.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f42439g.setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0109));
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i2).setShape(0).radius(c.a.d.f.p.n.f(getContext(), R.dimen.tbds21)).into(this.f42439g);
            this.f42440h.setImageDrawable(WebPManager.getSeletableDrawableForEditorToolsEM(R.drawable.icon_pure_post_expression24, R.drawable.icon_mask_post_keyboard24_selection, i2));
            this.f42441i.changeSkinType();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.o);
        }
    }

    @Override // c.a.s0.x.n
    public void sendAction(c.a.s0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) || (editorTools = this.f42442j) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    @Override // c.a.s0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, editorTools) == null) {
            this.f42442j = editorTools;
        }
    }

    public void setSendBtnClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) {
            this.n = cVar;
        }
    }

    @Override // c.a.s0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.f42443k = i2;
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

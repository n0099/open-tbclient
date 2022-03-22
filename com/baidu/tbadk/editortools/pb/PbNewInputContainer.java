package com.baidu.tbadk.editortools.pb;

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
import c.a.o0.s.c.u;
import c.a.o0.s.c.v;
import c.a.o0.w.n;
import c.a.o0.w.y.j;
import c.a.p0.s4.i;
import c.a.p0.z0.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.data.AtSelectData;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
/* loaded from: classes5.dex */
public class PbNewInputContainer extends LinearLayout implements n, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int x = 1;
    public static int y;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;

    /* renamed from: b  reason: collision with root package name */
    public SpanGroupEditText f30523b;

    /* renamed from: c  reason: collision with root package name */
    public TBSpecificationBtn f30524c;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f30525d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f30526e;

    /* renamed from: f  reason: collision with root package name */
    public View f30527f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f30528g;

    /* renamed from: h  reason: collision with root package name */
    public int f30529h;
    public j i;
    public SpannableStringBuilder j;
    public String k;
    public String l;
    public String m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public boolean[] s;
    public int[] t;
    public int u;
    public List<u> v;
    public Runnable w;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public a(PbNewInputContainer pbNewInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbNewInputContainer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.f30523b == null) {
                return;
            }
            PbNewInputContainer pbNewInputContainer = this.a;
            pbNewInputContainer.d(new c.a.o0.w.a(4, -1, pbNewInputContainer.f30523b.getSpanGroupManager()));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public b(PbNewInputContainer pbNewInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbNewInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.f30523b != null && this.a.f30523b.getText().toString().trim().equals("")) {
                    c.a.d.f.p.n.N(this.a.getContext(), String.format(c.a.o0.r.v.a.E(R.string.obfuscated_res_0x7f0f0f8f), new Object[0]));
                    return;
                }
                this.a.d(new c.a.o0.w.a(8, -1, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public c(PbNewInputContainer pbNewInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbNewInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null || editable.toString().trim() == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.a.j)) {
                if (this.a.i == null) {
                    this.a.i = new j();
                }
                this.a.i.f11575b = this.a.j.toString();
                this.a.i.f11577d = this.a.k;
                this.a.i.f11578e = this.a.l;
                this.a.i.a = this.a.f30523b.getText().toString();
                this.a.i.f11576c = this.a.f30523b.getSpanGroupManager();
                PbNewInputContainer pbNewInputContainer = this.a;
                pbNewInputContainer.d(new c.a.o0.w.a(4, -1, pbNewInputContainer.i));
                return;
            }
            c.a.d.f.m.e.a().removeCallbacks(this.a.w);
            c.a.d.f.m.e.a().post(this.a.w);
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
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                if (charSequence != null && i2 == 0 && i3 == 1 && charSequence.charAt(i) == '@') {
                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext(), this.a.n, true);
                    if (this.a.f30523b != null) {
                        atListActivityConfig.setSelectedAtList(this.a.f30523b.getAtDataInText());
                    }
                    if (this.a.a != null) {
                        atListActivityConfig.setFromTid(this.a.a.getTid());
                        atListActivityConfig.setFromFid(String.valueOf(this.a.a.getFid()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.a != null) {
                        statisticItem.addParam("tid", this.a.a.getTid());
                        statisticItem.addParam("fid", this.a.a.getFid());
                    }
                    TiebaStatic.log(statisticItem);
                }
                if (this.a.q) {
                    return;
                }
                this.a.q = true;
                if (this.a.f30523b == null || this.a.r == -1) {
                    return;
                }
                this.a.f30523b.setSelection(this.a.r);
                this.a.r = -1;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public d(PbNewInputContainer pbNewInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbNewInputContainer;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.a.d(new c.a.o0.w.a(5, -1, null));
                    this.a.f30523b.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements b.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public e(PbNewInputContainer pbNewInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbNewInputContainer;
        }

        @Override // c.a.p0.z0.b.g
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.f30523b.setText(spannableStringBuilder);
                this.a.f30523b.setSelection(this.a.f30523b.getText().length());
                this.a.d(new c.a.o0.w.a(5, -1, null));
                this.a.requestFocus();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements b.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f30530b;

        public f(PbNewInputContainer pbNewInputContainer, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30530b = pbNewInputContainer;
            this.a = jVar;
        }

        @Override // c.a.p0.z0.b.g
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.f30530b.j = spannableStringBuilder;
                this.f30530b.k = this.a.f11577d;
                this.f30530b.l = this.a.f11578e;
                if (TextUtils.isEmpty(this.a.a)) {
                    this.f30530b.f30523b.setText("");
                    this.f30530b.d(new c.a.o0.w.a(5, -1, null));
                    this.f30530b.requestFocus();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements b.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public g(PbNewInputContainer pbNewInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbNewInputContainer;
        }

        @Override // c.a.p0.z0.b.g
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.f30523b.setText(spannableStringBuilder);
                this.a.f30523b.setSelection(this.a.f30523b.getText().length());
                this.a.d(new c.a.o0.w.a(5, -1, null));
                this.a.requestFocus();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1275257521, "Lcom/baidu/tbadk/editortools/pb/PbNewInputContainer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1275257521, "Lcom/baidu/tbadk/editortools/pb/PbNewInputContainer;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbNewInputContainer(Context context) {
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

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EMTextView eMTextView = new EMTextView(getContext());
            this.f30528g = eMTextView;
            eMTextView.setId(R.id.obfuscated_res_0x7f090683);
            this.f30528g.setVisibility(8);
            this.f30528g.setMaxLines(1);
            this.f30528g.setEllipsize(TextUtils.TruncateAt.END);
            this.f30528g.setPadding(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X009), c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X005), c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X009), c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X003));
            this.f30528g.setTextSize(0, c.a.d.f.p.n.f(getContext(), R.dimen.T_X08));
            addView(this.f30528g, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public final void B(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(80);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
            bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.f30524c = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.f30524c.setEnabled(false);
            this.f30524c.setTextSize(R.dimen.T_X08);
            this.f30524c.setText(context.getString(R.string.obfuscated_res_0x7f0f0dbe));
            this.f30524c.setOnClickListener(new b(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(c.a.d.f.p.n.f(context, R.dimen.tbds150), c.a.d.f.p.n.f(context, R.dimen.tbds75));
            layoutParams2.rightMargin = c.a.d.f.p.n.f(context, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = c.a.d.f.p.n.f(context, R.dimen.M_H_X002);
            linearLayout.addView(this.f30524c, layoutParams2);
            this.f30526e.addView(linearLayout, layoutParams);
        }
    }

    public final void C(c.a.o0.w.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null || (obj = aVar.f11499c) == null || !(obj instanceof u) || ((u) obj).getType() == EmotionGroupType.BIG_EMOTION || ((u) aVar.f11499c).getType() == EmotionGroupType.USER_COLLECT) {
            return;
        }
        u uVar = (u) aVar.f11499c;
        if (uVar.getType() == EmotionGroupType.NET_SUG) {
            E(uVar);
        } else {
            D(uVar);
        }
    }

    public final void D(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uVar) == null) {
            if (!this.o || uVar.getType() == EmotionGroupType.LOCAL) {
                String obj = this.f30523b.getText().toString();
                if (this.p && c.a.p0.z0.a.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f13fc);
                    return;
                }
                this.v.add(uVar);
                c.a.p0.z0.b.b(getContext(), uVar, this.f30523b);
            }
        }
    }

    public final void E(u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, uVar) == null) || uVar == null || TextUtils.isEmpty(uVar.c()) || TextUtils.isEmpty(uVar.f())) {
            return;
        }
        String obj = this.f30523b.getText().toString();
        if (this.p && c.a.p0.z0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f13fc);
            return;
        }
        this.v.add(uVar);
        c.a.p0.z0.b.c(getContext(), uVar, this.f30523b);
    }

    public void F(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (tBSpecificationBtn = this.f30525d) == null) {
            return;
        }
        tBSpecificationBtn.setVisibility(z ? 0 : 8);
    }

    @Override // c.a.o0.w.n
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f30523b != null && this.f30526e.getVisibility() == 0) {
                this.f30523b.setFocusable(true);
                this.f30523b.setFocusableInTouchMode(true);
                this.f30523b.requestFocus();
                c.a.d.f.p.n.L(getContext(), this.f30523b);
            }
            setVisibility(0);
        }
    }

    @Override // c.a.o0.w.n
    public void d(c.a.o0.w.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) || (editorTools = this.a) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    public LinearLayout getInputLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f30526e : (LinearLayout) invokeV.objValue;
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f30523b : (EditText) invokeV.objValue;
    }

    public TBSpecificationBtn getSendView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f30524c : (TBSpecificationBtn) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f30528g : (TextView) invokeV.objValue;
    }

    @Override // c.a.o0.w.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f30529h : invokeV.intValue;
    }

    @Override // c.a.o0.w.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            setVisibility(8);
        }
    }

    @Override // c.a.o0.w.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // c.a.o0.w.b
    public void onAction(c.a.o0.w.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) || aVar == null) {
            return;
        }
        int i = aVar.a;
        if (i != 3) {
            if (i == 4) {
                t(aVar);
            } else if (i == 6) {
                Object obj = aVar.f11499c;
                if (obj == null) {
                    this.f30523b.setText((CharSequence) null);
                } else if (obj instanceof String) {
                    if (TextUtils.isEmpty((String) obj)) {
                        this.f30523b.setText((CharSequence) null);
                    } else {
                        c.a.p0.z0.b.e(getContext(), (String) aVar.f11499c, new e(this));
                    }
                } else if (obj instanceof j) {
                    this.j = null;
                    String str = this.m;
                    if (str != null) {
                        this.f30523b.setHint(str);
                    }
                    Object obj2 = aVar.f11499c;
                    j jVar = (j) obj2;
                    if (TextUtils.isEmpty(((j) obj2).f11575b) && TextUtils.isEmpty(((j) aVar.f11499c).a)) {
                        this.f30523b.setText((CharSequence) null);
                    } else {
                        if (!TextUtils.isEmpty(jVar.f11575b)) {
                            c.a.p0.z0.b.e(getContext(), jVar.f11575b, new f(this, jVar));
                        }
                        if (!TextUtils.isEmpty(jVar.a)) {
                            c.a.p0.z0.b.e(getContext(), jVar.a, new g(this));
                        }
                    }
                }
                t(aVar);
            } else if (i == 17) {
                Object obj3 = aVar.f11499c;
                if (obj3 != null && (obj3 instanceof ArrayList)) {
                    u((ArrayList) obj3);
                }
            } else if (i != 24) {
                if (i != 39) {
                    if (i != 19) {
                        if (i == 20) {
                            F(true);
                            this.f30525d.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a48));
                        } else if (i != 28) {
                            if (i == 29) {
                                this.s[3] = false;
                            } else if (i == 44) {
                                Object obj4 = aVar.f11499c;
                                if (obj4 != null) {
                                    if (obj4 instanceof String) {
                                        v((String) obj4);
                                    } else if ((obj4 instanceof j) && ((j) obj4).a != null) {
                                        v(((j) obj4).a);
                                    }
                                }
                            } else if (i != 45) {
                                switch (i) {
                                    case 9:
                                        for (u uVar : this.v) {
                                            x(uVar.a());
                                        }
                                        this.v.clear();
                                        if (((Boolean) aVar.f11499c).booleanValue()) {
                                            this.i = null;
                                            this.j = null;
                                            this.f30523b.setText((CharSequence) null);
                                        }
                                        boolean[] zArr = this.s;
                                        zArr[0] = false;
                                        zArr[1] = false;
                                        zArr[2] = false;
                                        zArr[3] = false;
                                        zArr[4] = false;
                                        int[] iArr = this.t;
                                        iArr[0] = 0;
                                        iArr[1] = 0;
                                        break;
                                    case 10:
                                        this.s[2] = true;
                                        break;
                                    case 11:
                                        this.s[2] = false;
                                        break;
                                    case 12:
                                        Object obj5 = aVar.f11499c;
                                        if (obj5 instanceof c.a.o0.w.r.a) {
                                            c.a.o0.w.r.a aVar2 = (c.a.o0.w.r.a) obj5;
                                            WriteImagesInfo writeImagesInfo = aVar2.a;
                                            if (writeImagesInfo != null) {
                                                if (writeImagesInfo.getChosedFiles() != null) {
                                                    this.t[0] = aVar2.a.getChosedFiles().size();
                                                } else {
                                                    this.t[0] = 0;
                                                }
                                            }
                                            if (this.t[0] > 0) {
                                                this.s[1] = true;
                                                break;
                                            } else {
                                                this.s[1] = false;
                                                break;
                                            }
                                        } else {
                                            return;
                                        }
                                    case 13:
                                        int[] iArr2 = this.t;
                                        iArr2[0] = iArr2[0] - 1;
                                        if (iArr2[0] > 0) {
                                            this.s[1] = true;
                                            break;
                                        } else {
                                            this.s[1] = false;
                                            break;
                                        }
                                }
                            } else {
                                Object obj6 = aVar.f11499c;
                                if (obj6 instanceof String) {
                                    String str2 = (String) obj6;
                                    if (StringUtils.isNull(str2)) {
                                        this.f30528g.setVisibility(8);
                                    } else {
                                        this.f30528g.setVisibility(0);
                                        this.f30528g.setText(str2);
                                    }
                                } else {
                                    this.f30528g.setVisibility(8);
                                }
                            }
                        }
                    } else if (aVar.f11499c == null) {
                        F(false);
                    } else {
                        F(true);
                        c.a.o0.w.w.a aVar3 = (c.a.o0.w.w.a) aVar.f11499c;
                        if (aVar3.a == 1) {
                            this.f30525d.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a42));
                        } else if (!TextUtils.isEmpty(aVar3.f11528b)) {
                            this.f30525d.setText(aVar3.f11528b);
                        } else {
                            this.f30525d.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a48));
                        }
                    }
                }
                this.s[3] = true;
            } else {
                C(aVar);
            }
        } else if (this.f30523b.getSelectionStart() > 0) {
            String substring = this.f30523b.getText().toString().substring(0, this.f30523b.getSelectionStart());
            Matcher matcher = c.a.p0.z0.a.f20857b.matcher(substring);
            if (matcher.find()) {
                int length = substring.length() - matcher.replaceFirst("").length();
                String substring2 = this.f30523b.getText().toString().substring(this.f30523b.getSelectionStart() - length, this.f30523b.getSelectionStart());
                Iterator<u> it = this.v.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    u next = it.next();
                    if (next.c().equals(substring2)) {
                        this.v.remove(next);
                        break;
                    }
                }
                this.f30523b.getText().delete(this.f30523b.getSelectionStart() - length, this.f30523b.getSelectionStart()).toString();
            } else {
                this.f30523b.getText().delete(this.f30523b.getSelectionStart() - 1, this.f30523b.getSelectionStart());
            }
        }
        w(this.u);
    }

    @Override // c.a.o0.w.n
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.f30523b.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(this.f30523b, R.color.CAM_X0105, 2, i);
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i).setShape(0).radius(c.a.d.f.p.n.f(getContext(), R.dimen.tbds21)).into(this.f30523b);
            SkinManager.setBackgroundColor(this.f30527f, R.color.CAM_X0207, i);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i);
            if (i == 0) {
                i.l(this.f30523b, R.drawable.obfuscated_res_0x7f0804b8);
                this.f30523b.setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0109));
            } else {
                i.l(this.f30523b, R.drawable.obfuscated_res_0x7f0804b9);
                this.f30523b.setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0109));
            }
            this.f30524c.l(i);
            this.f30525d.l(i);
            c.a.o0.r.v.c.d(this.f30528g).v(R.color.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, view) == null) && view == this.f30525d) {
            d(new c.a.o0.w.a(18, -1, null));
        }
    }

    public void setDefaultHint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.m = str;
        }
    }

    @Override // c.a.o0.w.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    public void setHasHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
        }
    }

    public void setHint(int i) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || (spanGroupEditText = this.f30523b) == null) {
            return;
        }
        spanGroupEditText.setHint(getContext().getString(i));
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.o = z;
        }
    }

    @Override // c.a.o0.w.n
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.f30529h = i;
        }
    }

    public void setTransLink(boolean z) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (spanGroupEditText = this.f30523b) == null) {
            return;
        }
        spanGroupEditText.setTransLink(z);
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.u = i;
        }
    }

    public void setmAtListRequestResponseCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.n = i;
        }
    }

    public final void t(c.a.o0.w.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, aVar) == null) || aVar == null) {
            return;
        }
        boolean[] zArr = this.s;
        Object obj = aVar.f11499c;
        if (obj != null && (!(obj instanceof String) || !StringUtils.isNull((String) obj))) {
            Object obj2 = aVar.f11499c;
            if (!(obj2 instanceof j) || !TextUtils.isEmpty(((j) obj2).a)) {
                Object obj3 = aVar.f11499c;
                if (!(obj3 instanceof SpanGroupManager) || !((SpanGroupManager) obj3).I()) {
                    z = true;
                    zArr[0] = z;
                }
            }
        }
        z = false;
        zArr[0] = z;
    }

    public final void u(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, arrayList) == null) {
            int selectionStart = this.f30523b.getSelectionStart();
            if (selectionStart > 0) {
                int i = selectionStart - 1;
                if (this.f30523b.getText().toString().charAt(i) == '@') {
                    this.f30523b.getEditableText().delete(i, selectionStart);
                }
            }
            SpanGroupEditText spanGroupEditText = this.f30523b;
            if (spanGroupEditText instanceof SpanGroupEditText) {
                spanGroupEditText.e(arrayList);
            }
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.f30523b.getText().delete(this.f30523b.getSelectionStart(), this.f30523b.getSelectionEnd());
            SpanGroupEditText spanGroupEditText2 = this.f30523b;
            if (spanGroupEditText2 instanceof SpanGroupEditText) {
                spanGroupEditText2.b(arrayList);
            }
        }
    }

    public final void v(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f30523b.getText().insert(this.f30523b.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            if (i == y) {
                boolean[] zArr = this.s;
                if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                    this.f30524c.setEnabled(false);
                } else {
                    this.f30524c.setEnabled(true);
                }
            } else if (i == x) {
                if (this.s[1]) {
                    this.f30524c.setEnabled(true);
                } else {
                    this.f30524c.setEnabled(false);
                }
            }
        }
    }

    public final void x(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, vVar) == null) {
            StatisticItem statisticItem = new StatisticItem("c14122");
            statisticItem.param("fid", vVar.a).param("tid", vVar.f11268b).param("uid", vVar.f11269c).param("obj_type", vVar.f11270d).param("obj_source", vVar.f11271e).param("obj_locate", vVar.f11272f).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, vVar.f11274h);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, context) == null) {
            SpanGroupEditText spanGroupEditText = new SpanGroupEditText(context);
            this.f30523b = spanGroupEditText;
            spanGroupEditText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.f30523b.setMaxLines(4);
            this.f30523b.setMinLines(2);
            this.f30523b.setGravity(48);
            this.f30523b.setIncludeFontPadding(false);
            this.f30523b.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
            this.f30523b.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f30523b.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
            i.l(this.f30523b, R.drawable.obfuscated_res_0x7f0804b8);
            this.f30523b.setLineSpacing(c.a.d.f.p.n.f(context, R.dimen.M_T_X002), 1.0f);
            this.f30523b.setPadding(c.a.d.f.p.n.f(context, R.dimen.M_W_X006), c.a.d.f.p.n.f(context, R.dimen.M_H_X004), c.a.d.f.p.n.f(context, R.dimen.M_W_X006), c.a.d.f.p.n.f(context, R.dimen.M_H_X004));
            this.f30523b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.f30523b.addTextChangedListener(new c(this));
            this.f30523b.setOnTouchListener(new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(c.a.d.f.p.n.f(context, R.dimen.M_W_X007), c.a.d.f.p.n.f(context, R.dimen.M_H_X002), c.a.d.f.p.n.f(context, R.dimen.M_W_X006), c.a.d.f.p.n.f(context, R.dimen.M_H_X002));
            this.f30526e.addView(this.f30523b, layoutParams);
        }
    }

    public final void z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, context) == null) {
            c.a.o0.r.l0.n.b bVar = new c.a.o0.r.l0.n.b();
            bVar.p(R.color.CAM_X0209, R.color.CAM_X0105);
            bVar.i(R.drawable.obfuscated_res_0x7f080610, 0, TBSpecificationButtonConfig.IconType.WEBP);
            bVar.h(R.color.CAM_X0110);
            bVar.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            bVar.m(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X004), c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X004));
            bVar.n(c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X002));
            bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, c.a.d.f.p.n.f(getContext(), R.dimen.tbds62));
            layoutParams.setMargins(c.a.d.f.p.n.f(context, R.dimen.M_W_X007), c.a.d.f.p.n.f(context, R.dimen.M_H_X004), c.a.d.f.p.n.f(context, R.dimen.M_W_X007), c.a.d.f.p.n.f(context, R.dimen.M_H_X003));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.f30525d = tBSpecificationBtn;
            tBSpecificationBtn.setLayoutParams(layoutParams);
            this.f30525d.setOnClickListener(this);
            this.f30525d.setConfig(bVar);
            this.f30525d.setTextSize(R.dimen.T_X09);
            this.f30525d.setOnClickListener(this);
            this.f30525d.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a48));
            addView(this.f30525d);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
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
    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
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
        this.n = 12004;
        this.o = false;
        this.p = true;
        this.q = true;
        this.r = -1;
        this.s = new boolean[]{false, false, false, false, false};
        this.t = new int[]{0, 0};
        this.u = y;
        this.w = new a(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070301));
        A();
        z(context);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f30526e = linearLayout;
        linearLayout.setOrientation(0);
        this.f30526e.setMinimumHeight(c.a.d.f.p.n.f(context, R.dimen.tbds128));
        addView(this.f30526e, new LinearLayout.LayoutParams(-1, -2));
        y(context);
        B(context);
        this.f30527f = new View(getContext());
        this.f30527f.setLayoutParams(new LinearLayout.LayoutParams(-1, c.a.d.f.p.n.f(getContext(), R.dimen.obfuscated_res_0x7f070198)));
        addView(this.f30527f);
        this.v = new ArrayList();
    }

    public void setHint(CharSequence charSequence) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, charSequence) == null) || (spanGroupEditText = this.f30523b) == null) {
            return;
        }
        spanGroupEditText.setHint(charSequence);
    }
}

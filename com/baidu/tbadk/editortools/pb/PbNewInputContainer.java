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
import com.repackage.c86;
import com.repackage.d86;
import com.repackage.es4;
import com.repackage.g35;
import com.repackage.gs4;
import com.repackage.hy8;
import com.repackage.j15;
import com.repackage.mi;
import com.repackage.mx4;
import com.repackage.n25;
import com.repackage.ng;
import com.repackage.nx4;
import com.repackage.r15;
import com.repackage.w05;
import com.repackage.yu4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
/* loaded from: classes3.dex */
public class PbNewInputContainer extends LinearLayout implements j15, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int x = 1;
    public static int y;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public SpanGroupEditText b;
    public TBSpecificationBtn c;
    public TBSpecificationBtn d;
    public LinearLayout e;
    public View f;
    public TextView g;
    public int h;
    public g35 i;
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
    public List<mx4> v;
    public Runnable w;

    /* loaded from: classes3.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            PbNewInputContainer pbNewInputContainer = this.a;
            pbNewInputContainer.g(new w05(4, -1, pbNewInputContainer.b.getSpanGroupManager()));
        }
    }

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.b != null && this.a.b.getText().toString().trim().equals("")) {
                    mi.N(this.a.getContext(), String.format(es4.E(R.string.obfuscated_res_0x7f0f0fad), new Object[0]));
                    return;
                }
                this.a.g(new w05(8, -1, null));
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    this.a.i = new g35();
                }
                this.a.i.b = this.a.j.toString();
                this.a.i.d = this.a.k;
                this.a.i.e = this.a.l;
                this.a.i.a = this.a.b.getText().toString();
                this.a.i.c = this.a.b.getSpanGroupManager();
                PbNewInputContainer pbNewInputContainer = this.a;
                pbNewInputContainer.g(new w05(4, -1, pbNewInputContainer.i));
                return;
            }
            ng.a().removeCallbacks(this.a.w);
            ng.a().post(this.a.w);
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
                    if (this.a.b != null) {
                        atListActivityConfig.setSelectedAtList(this.a.b.getAtDataInText());
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
                if (this.a.b == null || this.a.r == -1) {
                    return;
                }
                this.a.b.setSelection(this.a.r);
                this.a.r = -1;
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.a.g(new w05(5, -1, null));
                    this.a.b.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d86.h {
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

        @Override // com.repackage.d86.h
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.g(new w05(5, -1, null));
                this.a.requestFocus();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d86.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g35 a;
        public final /* synthetic */ PbNewInputContainer b;

        public f(PbNewInputContainer pbNewInputContainer, g35 g35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer, g35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbNewInputContainer;
            this.a = g35Var;
        }

        @Override // com.repackage.d86.h
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.b.j = spannableStringBuilder;
                this.b.k = this.a.d;
                this.b.l = this.a.e;
                if (TextUtils.isEmpty(this.a.a)) {
                    this.b.b.setText("");
                    this.b.g(new w05(5, -1, null));
                    this.b.requestFocus();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements d86.h {
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

        @Override // com.repackage.d86.h
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.g(new w05(5, -1, null));
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

    public final void A(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            yu4 yu4Var = new yu4();
            yu4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            yu4Var.i(R.drawable.obfuscated_res_0x7f0805fe, 0, TBSpecificationButtonConfig.IconType.WEBP);
            yu4Var.h(R.color.CAM_X0110);
            yu4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            yu4Var.m(mi.f(getContext(), R.dimen.M_W_X004), mi.f(getContext(), R.dimen.M_W_X004));
            yu4Var.n(mi.f(getContext(), R.dimen.M_H_X002));
            yu4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, mi.f(getContext(), R.dimen.tbds62));
            layoutParams.setMargins(mi.f(context, R.dimen.M_W_X007), mi.f(context, R.dimen.M_H_X004), mi.f(context, R.dimen.M_W_X007), mi.f(context, R.dimen.M_H_X003));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.d = tBSpecificationBtn;
            tBSpecificationBtn.setLayoutParams(layoutParams);
            this.d.setOnClickListener(this);
            this.d.setConfig(yu4Var);
            this.d.setTextSize(R.dimen.T_X09);
            this.d.setOnClickListener(this);
            this.d.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a50));
            addView(this.d);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EMTextView eMTextView = new EMTextView(getContext());
            this.g = eMTextView;
            eMTextView.setId(R.id.obfuscated_res_0x7f090687);
            this.g.setVisibility(8);
            this.g.setMaxLines(1);
            this.g.setEllipsize(TextUtils.TruncateAt.END);
            this.g.setPadding(mi.f(getContext(), R.dimen.M_W_X009), mi.f(getContext(), R.dimen.M_H_X005), mi.f(getContext(), R.dimen.M_W_X009), mi.f(getContext(), R.dimen.M_H_X003));
            this.g.setTextSize(0, mi.f(getContext(), R.dimen.T_X08));
            addView(this.g, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public final void C(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(80);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            yu4 yu4Var = new yu4();
            yu4Var.p(R.color.CAM_X0302, R.color.CAM_X0101);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.c = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(yu4Var);
            this.c.setEnabled(false);
            this.c.setTextSize(R.dimen.T_X08);
            this.c.setText(context.getString(R.string.obfuscated_res_0x7f0f0ddb));
            this.c.setOnClickListener(new b(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(mi.f(context, R.dimen.tbds150), mi.f(context, R.dimen.tbds75));
            layoutParams2.rightMargin = mi.f(context, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = mi.f(context, R.dimen.M_H_X002);
            linearLayout.addView(this.c, layoutParams2);
            this.e.addView(linearLayout, layoutParams);
        }
    }

    public final void D(w05 w05Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, w05Var) == null) || w05Var == null || (obj = w05Var.c) == null || !(obj instanceof mx4) || ((mx4) obj).getType() == EmotionGroupType.BIG_EMOTION || ((mx4) w05Var.c).getType() == EmotionGroupType.USER_COLLECT) {
            return;
        }
        mx4 mx4Var = (mx4) w05Var.c;
        if (mx4Var.getType() == EmotionGroupType.NET_SUG) {
            F(mx4Var);
        } else {
            E(mx4Var);
        }
    }

    public final void E(mx4 mx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, mx4Var) == null) {
            if (!this.o || mx4Var.getType() == EmotionGroupType.LOCAL) {
                String obj = this.b.getText().toString();
                if (this.p && c86.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f142b);
                    return;
                }
                this.v.add(mx4Var);
                d86.b(getContext(), mx4Var, this.b);
            }
        }
    }

    public final void F(mx4 mx4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, mx4Var) == null) || mx4Var == null || TextUtils.isEmpty(mx4Var.d()) || TextUtils.isEmpty(mx4Var.g())) {
            return;
        }
        String obj = this.b.getText().toString();
        if (this.p && c86.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f142b);
            return;
        }
        this.v.add(mx4Var);
        d86.c(getContext(), mx4Var, this.b);
    }

    public void G(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (tBSpecificationBtn = this.d) == null) {
            return;
        }
        tBSpecificationBtn.setVisibility(z ? 0 : 8);
    }

    @Override // com.repackage.j15
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.b != null && this.e.getVisibility() == 0) {
                this.b.setFocusable(true);
                this.b.setFocusableInTouchMode(true);
                this.b.requestFocus();
                mi.L(getContext(), this.b);
            }
            setVisibility(0);
        }
    }

    @Override // com.repackage.j15
    public void g(w05 w05Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, w05Var) == null) || (editorTools = this.a) == null) {
            return;
        }
        editorTools.A(w05Var);
    }

    public LinearLayout getInputLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.e : (LinearLayout) invokeV.objValue;
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b : (EditText) invokeV.objValue;
    }

    public TBSpecificationBtn getSendView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.c : (TBSpecificationBtn) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.g : (TextView) invokeV.objValue;
    }

    @Override // com.repackage.j15
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.h : invokeV.intValue;
    }

    @Override // com.repackage.j15
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.repackage.j15
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.repackage.x05
    public void onAction(w05 w05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, w05Var) == null) || w05Var == null) {
            return;
        }
        int i = w05Var.a;
        if (i != 3) {
            if (i == 4) {
                u(w05Var);
            } else if (i == 6) {
                Object obj = w05Var.c;
                if (obj == null) {
                    this.b.setText((CharSequence) null);
                } else if (obj instanceof String) {
                    if (TextUtils.isEmpty((String) obj)) {
                        this.b.setText((CharSequence) null);
                    } else {
                        d86.f(getContext(), (String) w05Var.c, new e(this));
                    }
                } else if (obj instanceof g35) {
                    this.j = null;
                    String str = this.m;
                    if (str != null) {
                        this.b.setHint(str);
                    }
                    Object obj2 = w05Var.c;
                    g35 g35Var = (g35) obj2;
                    if (TextUtils.isEmpty(((g35) obj2).b) && TextUtils.isEmpty(((g35) w05Var.c).a)) {
                        this.b.setText((CharSequence) null);
                    } else {
                        if (!TextUtils.isEmpty(g35Var.b)) {
                            d86.f(getContext(), g35Var.b, new f(this, g35Var));
                        }
                        if (!TextUtils.isEmpty(g35Var.a)) {
                            d86.f(getContext(), g35Var.a, new g(this));
                        }
                    }
                }
                u(w05Var);
            } else if (i == 17) {
                Object obj3 = w05Var.c;
                if (obj3 != null && (obj3 instanceof ArrayList)) {
                    v((ArrayList) obj3);
                }
            } else if (i != 24) {
                if (i != 39) {
                    if (i != 19) {
                        if (i == 20) {
                            G(true);
                            this.d.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a50));
                        } else if (i != 28) {
                            if (i == 29) {
                                this.s[3] = false;
                            } else if (i == 44) {
                                Object obj4 = w05Var.c;
                                if (obj4 != null) {
                                    if (obj4 instanceof String) {
                                        w((String) obj4);
                                    } else if ((obj4 instanceof g35) && ((g35) obj4).a != null) {
                                        w(((g35) obj4).a);
                                    }
                                }
                            } else if (i != 45) {
                                switch (i) {
                                    case 9:
                                        for (mx4 mx4Var : this.v) {
                                            y(mx4Var.a());
                                        }
                                        this.v.clear();
                                        if (((Boolean) w05Var.c).booleanValue()) {
                                            this.i = null;
                                            this.j = null;
                                            this.b.setText((CharSequence) null);
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
                                        Object obj5 = w05Var.c;
                                        if (obj5 instanceof r15) {
                                            r15 r15Var = (r15) obj5;
                                            WriteImagesInfo writeImagesInfo = r15Var.a;
                                            if (writeImagesInfo != null) {
                                                if (writeImagesInfo.getChosedFiles() != null) {
                                                    this.t[0] = r15Var.a.getChosedFiles().size();
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
                                Object obj6 = w05Var.c;
                                if (obj6 instanceof String) {
                                    String str2 = (String) obj6;
                                    if (StringUtils.isNull(str2)) {
                                        this.g.setVisibility(8);
                                    } else {
                                        this.g.setVisibility(0);
                                        this.g.setText(str2);
                                    }
                                } else {
                                    this.g.setVisibility(8);
                                }
                            }
                        }
                    } else if (w05Var.c == null) {
                        G(false);
                    } else {
                        G(true);
                        n25 n25Var = (n25) w05Var.c;
                        if (n25Var.a == 1) {
                            this.d.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a4a));
                        } else if (!TextUtils.isEmpty(n25Var.b)) {
                            this.d.setText(n25Var.b);
                        } else {
                            this.d.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a50));
                        }
                    }
                }
                this.s[3] = true;
            } else {
                D(w05Var);
            }
        } else if (this.b.getSelectionStart() > 0) {
            String substring = this.b.getText().toString().substring(0, this.b.getSelectionStart());
            Matcher matcher = c86.b.matcher(substring);
            if (matcher.find()) {
                int length = substring.length() - matcher.replaceFirst("").length();
                String substring2 = this.b.getText().toString().substring(this.b.getSelectionStart() - length, this.b.getSelectionStart());
                Iterator<mx4> it = this.v.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    mx4 next = it.next();
                    if (next.d().equals(substring2)) {
                        this.v.remove(next);
                        break;
                    }
                }
                this.b.getText().delete(this.b.getSelectionStart() - length, this.b.getSelectionStart()).toString();
            } else {
                this.b.getText().delete(this.b.getSelectionStart() - 1, this.b.getSelectionStart());
            }
        }
        x(this.u);
    }

    @Override // com.repackage.j15
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.b.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0105, 2, i);
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i).setShape(0).radius(mi.f(getContext(), R.dimen.tbds21)).into(this.b);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0207, i);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i);
            if (i == 0) {
                hy8.l(this.b, R.drawable.obfuscated_res_0x7f0804af);
                this.b.setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0109));
            } else {
                hy8.l(this.b, R.drawable.obfuscated_res_0x7f0804b0);
                this.b.setHintTextColor(SkinManager.getColor(i, (int) R.color.CAM_X0109));
            }
            this.c.l(i);
            this.d.l(i);
            gs4.d(this.g).v(R.color.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, view2) == null) && view2 == this.d) {
            g(new w05(18, -1, null));
        }
    }

    public void setDefaultHint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.repackage.j15
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    public void setHasHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
        }
    }

    public void setHint(int i) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i) == null) || (spanGroupEditText = this.b) == null) {
            return;
        }
        spanGroupEditText.setHint(getContext().getString(i));
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.o = z;
        }
    }

    @Override // com.repackage.j15
    public void setToolId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.h = i;
        }
    }

    public void setTransLink(boolean z) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048602, this, z) == null) || (spanGroupEditText = this.b) == null) {
            return;
        }
        spanGroupEditText.setTransLink(z);
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.u = i;
        }
    }

    public void setmAtListRequestResponseCode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.n = i;
        }
    }

    public final void u(w05 w05Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, w05Var) == null) || w05Var == null) {
            return;
        }
        boolean[] zArr = this.s;
        Object obj = w05Var.c;
        if (obj != null && (!(obj instanceof String) || !StringUtils.isNull((String) obj))) {
            Object obj2 = w05Var.c;
            if (!(obj2 instanceof g35) || !TextUtils.isEmpty(((g35) obj2).a)) {
                Object obj3 = w05Var.c;
                if (!(obj3 instanceof SpanGroupManager) || !((SpanGroupManager) obj3).I()) {
                    z = true;
                    zArr[0] = z;
                }
            }
        }
        z = false;
        zArr[0] = z;
    }

    public final void v(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, arrayList) == null) {
            int selectionStart = this.b.getSelectionStart();
            if (selectionStart > 0) {
                int i = selectionStart - 1;
                if (this.b.getText().toString().charAt(i) == '@') {
                    this.b.getEditableText().delete(i, selectionStart);
                }
            }
            SpanGroupEditText spanGroupEditText = this.b;
            if (spanGroupEditText instanceof SpanGroupEditText) {
                spanGroupEditText.e(arrayList);
            }
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.b.getText().delete(this.b.getSelectionStart(), this.b.getSelectionEnd());
            SpanGroupEditText spanGroupEditText2 = this.b;
            if (spanGroupEditText2 instanceof SpanGroupEditText) {
                spanGroupEditText2.b(arrayList);
            }
        }
    }

    public final void w(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.b.getText().insert(this.b.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            if (i == y) {
                boolean[] zArr = this.s;
                if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                    this.c.setEnabled(false);
                } else {
                    this.c.setEnabled(true);
                }
            } else if (i == x) {
                if (this.s[1]) {
                    this.c.setEnabled(true);
                } else {
                    this.c.setEnabled(false);
                }
            }
        }
    }

    public final void y(nx4 nx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, nx4Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c14122");
            statisticItem.param("fid", nx4Var.a).param("tid", nx4Var.b).param("uid", nx4Var.c).param("obj_type", nx4Var.d).param("obj_source", nx4Var.e).param("obj_locate", nx4Var.f).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, nx4Var.h);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, context) == null) {
            SpanGroupEditText spanGroupEditText = new SpanGroupEditText(context);
            this.b = spanGroupEditText;
            spanGroupEditText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.b.setMaxLines(4);
            this.b.setMinLines(2);
            this.b.setGravity(48);
            this.b.setIncludeFontPadding(false);
            this.b.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
            this.b.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.b.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
            hy8.l(this.b, R.drawable.obfuscated_res_0x7f0804af);
            this.b.setLineSpacing(mi.f(context, R.dimen.M_T_X002), 1.0f);
            this.b.setPadding(mi.f(context, R.dimen.M_W_X006), mi.f(context, R.dimen.M_H_X004), mi.f(context, R.dimen.M_W_X006), mi.f(context, R.dimen.M_H_X004));
            this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.b.addTextChangedListener(new c(this));
            this.b.setOnTouchListener(new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(mi.f(context, R.dimen.M_W_X007), mi.f(context, R.dimen.M_H_X002), mi.f(context, R.dimen.M_W_X006), mi.f(context, R.dimen.M_H_X002));
            this.e.addView(this.b, layoutParams);
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
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07030b));
        B();
        A(context);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.e = linearLayout;
        linearLayout.setOrientation(0);
        this.e.setMinimumHeight(mi.f(context, R.dimen.tbds128));
        addView(this.e, new LinearLayout.LayoutParams(-1, -2));
        z(context);
        C(context);
        this.f = new View(getContext());
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, mi.f(getContext(), R.dimen.obfuscated_res_0x7f070198)));
        addView(this.f);
        this.v = new ArrayList();
    }

    public void setHint(CharSequence charSequence) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, charSequence) == null) || (spanGroupEditText = this.b) == null) {
            return;
        }
        spanGroupEditText.setHint(charSequence);
    }
}

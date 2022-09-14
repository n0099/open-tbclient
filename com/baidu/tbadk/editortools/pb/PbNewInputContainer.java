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
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tieba.ac6;
import com.baidu.tieba.ay4;
import com.baidu.tieba.bx4;
import com.baidu.tieba.c75;
import com.baidu.tieba.ej;
import com.baidu.tieba.g55;
import com.baidu.tieba.gh;
import com.baidu.tieba.j19;
import com.baidu.tieba.p55;
import com.baidu.tieba.r05;
import com.baidu.tieba.s05;
import com.baidu.tieba.s38;
import com.baidu.tieba.su4;
import com.baidu.tieba.u45;
import com.baidu.tieba.uu4;
import com.baidu.tieba.z65;
import com.baidu.tieba.zb6;
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
/* loaded from: classes3.dex */
public class PbNewInputContainer extends LinearLayout implements g55, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int A = 2;
    public static int B = 0;
    public static int z = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public SpanGroupEditText b;
    public TBSpecificationBtn c;
    public LinearLayout d;
    public View e;
    public TextView f;
    public LinearLayout g;
    public TBSpecificationBtn h;
    public int i;
    public c75 j;
    public SpannableStringBuilder k;
    public String l;
    public String m;
    public String n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public boolean[] t;
    public int[] u;
    public int v;
    public boolean w;
    public List<r05> x;
    public Runnable y;

    /* loaded from: classes3.dex */
    public class a implements ac6.h {
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

        @Override // com.baidu.tieba.ac6.h
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.K(new u45(5, -1, null));
                this.a.requestFocus();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            PbNewInputContainer pbNewInputContainer = this.a;
            pbNewInputContainer.K(new u45(4, -1, pbNewInputContainer.b.getSpanGroupManager()));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !((Boolean) this.a.h.a).booleanValue();
                bx4.k().u("key_virtual_image_and_state_has_show", z);
                this.a.I(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ PbNewInputContainer b;

        public d(PbNewInputContainer pbNewInputContainer, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer, Boolean.valueOf(z)};
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
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.K(new u45(67, -1, Boolean.valueOf(this.a)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        /* loaded from: classes3.dex */
        public class a implements z65.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // com.baidu.tieba.z65.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.w = false;
                    bx4.k().u("key_virtual_image_and_state_has_show", false);
                    this.a.a.I(false);
                }
            }
        }

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = false;
                if (this.a.b == null || !this.a.b.getText().toString().trim().equals("")) {
                    if (this.a.f != null && this.a.f.getText() != null && this.a.f.getText().length() > 0) {
                        z = true;
                    }
                    boolean h = bx4.k().h("key_virtual_image_and_state_has_show", true);
                    s38 a2 = s38.a();
                    if (h && (a2 == null || a2.b() != 1)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 21).param("obj_type", z ? 2 : 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        this.a.w = true;
                        z65.c(new a(this));
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 11).param("obj_type", z ? 2 : 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.a.K(new u45(8, -1, null));
                    return;
                }
                ej.N(this.a.getContext(), String.format(su4.E(R.string.obfuscated_res_0x7f0f1003), new Object[0]));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public f(PbNewInputContainer pbNewInputContainer) {
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
            if (!TextUtils.isEmpty(this.a.k)) {
                if (this.a.j == null) {
                    this.a.j = new c75();
                }
                this.a.j.b = this.a.k.toString();
                this.a.j.d = this.a.l;
                this.a.j.e = this.a.m;
                this.a.j.a = this.a.b.getText().toString();
                this.a.j.c = this.a.b.getSpanGroupManager();
                PbNewInputContainer pbNewInputContainer = this.a;
                pbNewInputContainer.K(new u45(4, -1, pbNewInputContainer.j));
                return;
            }
            gh.a().removeCallbacks(this.a.y);
            gh.a().post(this.a.y);
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
                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext(), this.a.o, true);
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
                if (this.a.r) {
                    return;
                }
                this.a.r = true;
                if (this.a.b == null || this.a.s == -1) {
                    return;
                }
                this.a.b.setSelection(this.a.s);
                this.a.s = -1;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.a.K(new u45(5, -1, null));
                    this.a.b.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public h(PbNewInputContainer pbNewInputContainer) {
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ej.L(this.a.getContext(), this.a.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements ac6.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public i(PbNewInputContainer pbNewInputContainer) {
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

        @Override // com.baidu.tieba.ac6.h
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.K(new u45(5, -1, null));
                this.a.requestFocus();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements ac6.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c75 a;
        public final /* synthetic */ PbNewInputContainer b;

        public j(PbNewInputContainer pbNewInputContainer, c75 c75Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer, c75Var};
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
            this.a = c75Var;
        }

        @Override // com.baidu.tieba.ac6.h
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.b.k = spannableStringBuilder;
                this.b.l = this.a.d;
                this.b.m = this.a.e;
                if (TextUtils.isEmpty(this.a.a)) {
                    this.b.b.setText("");
                    this.b.K(new u45(5, -1, null));
                    this.b.requestFocus();
                }
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

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            EMTextView eMTextView = new EMTextView(getContext());
            this.f = eMTextView;
            eMTextView.setId(R.id.obfuscated_res_0x7f09067d);
            this.f.setVisibility(8);
            this.f.setMaxLines(1);
            this.f.setEllipsize(TextUtils.TruncateAt.END);
            this.f.setPadding(ej.f(getContext(), R.dimen.M_W_X009), ej.f(getContext(), R.dimen.M_H_X005), ej.f(getContext(), R.dimen.M_W_X009), ej.f(getContext(), R.dimen.M_H_X003));
            this.f.setTextSize(0, ej.f(getContext(), R.dimen.T_X08));
            addView(this.f, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    @Override // com.baidu.tieba.v45
    public void B(u45 u45Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, u45Var) == null) || u45Var == null) {
            return;
        }
        int i2 = u45Var.a;
        if (i2 != 3) {
            if (i2 == 4) {
                u(u45Var);
            } else if (i2 == 6) {
                Object obj = u45Var.c;
                if (obj == null) {
                    this.b.setText((CharSequence) null);
                } else if (obj instanceof String) {
                    if (TextUtils.isEmpty((String) obj)) {
                        this.b.setText((CharSequence) null);
                    } else {
                        ac6.f(getContext(), (String) u45Var.c, new i(this));
                    }
                } else if (obj instanceof c75) {
                    this.k = null;
                    String str = this.n;
                    if (str != null) {
                        this.b.setHint(str);
                    }
                    Object obj2 = u45Var.c;
                    c75 c75Var = (c75) obj2;
                    if (TextUtils.isEmpty(((c75) obj2).b) && TextUtils.isEmpty(((c75) u45Var.c).a)) {
                        this.b.setText((CharSequence) null);
                    } else {
                        if (!TextUtils.isEmpty(c75Var.b)) {
                            ac6.f(getContext(), c75Var.b, new j(this, c75Var));
                        }
                        if (!TextUtils.isEmpty(c75Var.a)) {
                            ac6.f(getContext(), c75Var.a, new a(this));
                        }
                    }
                }
                u(u45Var);
            } else if (i2 == 17) {
                Object obj3 = u45Var.c;
                if (obj3 != null && (obj3 instanceof ArrayList)) {
                    v((ArrayList) obj3);
                }
            } else if (i2 == 24) {
                E(u45Var);
            } else if (i2 == 39 || i2 == 28) {
                this.t[3] = true;
            } else if (i2 == 29) {
                this.t[3] = false;
            } else if (i2 == 44) {
                Object obj4 = u45Var.c;
                if (obj4 != null) {
                    if (obj4 instanceof String) {
                        w((String) obj4);
                    } else if ((obj4 instanceof c75) && ((c75) obj4).a != null) {
                        w(((c75) obj4).a);
                    }
                }
            } else if (i2 != 45) {
                switch (i2) {
                    case 9:
                        for (r05 r05Var : this.x) {
                            y(r05Var.a());
                        }
                        this.x.clear();
                        if (((Boolean) u45Var.c).booleanValue()) {
                            this.j = null;
                            this.k = null;
                            this.b.setText((CharSequence) null);
                        }
                        boolean[] zArr = this.t;
                        zArr[0] = false;
                        zArr[1] = false;
                        zArr[2] = false;
                        zArr[3] = false;
                        zArr[4] = false;
                        int[] iArr = this.u;
                        iArr[0] = 0;
                        iArr[1] = 0;
                        break;
                    case 10:
                        this.t[2] = true;
                        break;
                    case 11:
                        this.t[2] = false;
                        break;
                    case 12:
                        Object obj5 = u45Var.c;
                        if (obj5 instanceof p55) {
                            p55 p55Var = (p55) obj5;
                            WriteImagesInfo writeImagesInfo = p55Var.a;
                            if (writeImagesInfo != null) {
                                if (writeImagesInfo.getChosedFiles() != null) {
                                    this.u[0] = p55Var.a.getChosedFiles().size();
                                } else {
                                    this.u[0] = 0;
                                }
                            }
                            if (this.u[0] > 0) {
                                this.t[1] = true;
                                break;
                            } else {
                                this.t[1] = false;
                                break;
                            }
                        } else {
                            return;
                        }
                    case 13:
                        int[] iArr2 = this.u;
                        iArr2[0] = iArr2[0] - 1;
                        if (iArr2[0] > 0) {
                            this.t[1] = true;
                            break;
                        } else {
                            this.t[1] = false;
                            break;
                        }
                }
            } else {
                Object obj6 = u45Var.c;
                if (obj6 instanceof String) {
                    String str2 = (String) obj6;
                    if (StringUtils.isNull(str2)) {
                        this.f.setVisibility(8);
                    } else {
                        this.f.setVisibility(0);
                        this.f.setText(str2);
                    }
                } else {
                    this.f.setVisibility(8);
                }
            }
        } else if (this.b.getSelectionStart() > 0) {
            String substring = this.b.getText().toString().substring(0, this.b.getSelectionStart());
            Matcher matcher = zb6.b.matcher(substring);
            if (matcher.find()) {
                int length = substring.length() - matcher.replaceFirst("").length();
                String substring2 = this.b.getText().toString().substring(this.b.getSelectionStart() - length, this.b.getSelectionStart());
                Iterator<r05> it = this.x.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    r05 next = it.next();
                    if (next.d().equals(substring2)) {
                        this.x.remove(next);
                        break;
                    }
                }
                this.b.getText().delete(this.b.getSelectionStart() - length, this.b.getSelectionStart()).toString();
            } else {
                this.b.getText().delete(this.b.getSelectionStart() - 1, this.b.getSelectionStart());
            }
        }
        x(this.v);
    }

    public final void C(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(80);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            ay4 ay4Var = new ay4();
            ay4Var.p(R.color.CAM_X0302, R.color.CAM_X0101);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.c = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(ay4Var);
            this.c.setEnabled(false);
            this.c.setTextSize(R.dimen.T_X08);
            this.c.setText(context.getString(R.string.obfuscated_res_0x7f0f0e0c));
            this.c.setOnClickListener(new e(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ej.f(context, R.dimen.tbds150), ej.f(context, R.dimen.tbds75));
            layoutParams2.rightMargin = ej.f(context, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = ej.f(context, R.dimen.M_H_X002);
            linearLayout.addView(this.c, layoutParams2);
            this.d.addView(linearLayout, layoutParams);
        }
    }

    public final void D(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            ay4 ay4Var = new ay4();
            ay4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            ay4Var.h(R.color.CAM_X0302);
            ay4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            ay4Var.m(ej.f(getContext(), R.dimen.M_W_X004), ej.f(getContext(), R.dimen.M_W_X004));
            ay4Var.n(ej.f(getContext(), R.dimen.M_H_X002));
            ay4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.h = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(ay4Var);
            this.h.setTextSize(R.dimen.T_X09);
            boolean h2 = bx4.k().h("key_virtual_image_and_state_has_show", true);
            if (!h2) {
                I(h2);
            } else {
                I(h2);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ej.f(getContext(), R.dimen.tbds62));
            layoutParams.setMargins(ej.f(context, R.dimen.M_W_X007), ej.f(context, R.dimen.M_H_X004), ej.f(context, R.dimen.M_W_X007), ej.f(context, R.dimen.M_H_X003));
            this.h.setLayoutParams(layoutParams);
            this.h.setOnClickListener(new c(this));
            this.g.addView(this.h);
        }
    }

    public final void E(u45 u45Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, u45Var) == null) || u45Var == null || (obj = u45Var.c) == null || !(obj instanceof r05) || EmotionGroupType.isSendAsPic(((r05) obj).getType())) {
            return;
        }
        r05 r05Var = (r05) u45Var.c;
        if (r05Var.getType() == EmotionGroupType.NET_SUG) {
            G(r05Var);
        } else {
            F(r05Var);
        }
    }

    public final void F(r05 r05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, r05Var) == null) {
            if (!this.p || r05Var.getType() == EmotionGroupType.LOCAL) {
                String obj = this.b.getText().toString();
                if (this.q && zb6.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f1456);
                    return;
                }
                this.x.add(r05Var);
                ac6.b(getContext(), r05Var, this.b);
            }
        }
    }

    public final void G(r05 r05Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, r05Var) == null) || r05Var == null || TextUtils.isEmpty(r05Var.d()) || TextUtils.isEmpty(r05Var.g())) {
            return;
        }
        String obj = this.b.getText().toString();
        if (this.q && zb6.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f1456);
            return;
        }
        this.x.add(r05Var);
        ac6.c(getContext(), r05Var, this.b);
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.w) {
            this.w = false;
            if (this.b == null || this.d.getVisibility() != 0) {
                return;
            }
            this.b.setFocusable(true);
            this.b.setFocusableInTouchMode(true);
            this.b.requestFocus();
            ej.L(getContext(), this.b);
        }
    }

    public final void I(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2) == null) {
            this.h.setText(BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f119b));
            this.h.getStyleConfig().i(z2 ? R.drawable.obfuscated_res_0x7f0809b4 : R.drawable.obfuscated_res_0x7f0809b3, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.h.getStyleConfig().h(z2 ? R.color.CAM_X0302 : R.color.CAM_X0110);
            this.h.a = Boolean.valueOf(z2);
            gh.a().postDelayed(new d(this, z2), 200L);
        }
    }

    @Override // com.baidu.tieba.g55
    public void K(u45 u45Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, u45Var) == null) || (editorTools = this.a) == null) {
            return;
        }
        editorTools.A(u45Var);
    }

    public void L(boolean z2) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) || (tBSpecificationBtn = this.h) == null) {
            return;
        }
        tBSpecificationBtn.setVisibility(z2 ? 0 : 8);
    }

    @Override // com.baidu.tieba.g55
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.b != null && this.d.getVisibility() == 0) {
                this.b.setFocusable(true);
                this.b.setFocusableInTouchMode(true);
                this.b.requestFocus();
                gh.a().postDelayed(new h(this), 200L);
            }
            setVisibility(0);
        }
    }

    public LinearLayout getInputLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.d : (LinearLayout) invokeV.objValue;
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.b : (EditText) invokeV.objValue;
    }

    public TBSpecificationBtn getSendView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.c : (TBSpecificationBtn) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f : (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g55
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.i : invokeV.intValue;
    }

    @Override // com.baidu.tieba.g55
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.g55
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    @Override // com.baidu.tieba.g55
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.b.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0105, 2, i2);
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i2).setShape(0).radius(ej.f(getContext(), R.dimen.tbds21)).into(this.b);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0207, i2);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i2);
            if (i2 == 0) {
                j19.l(this.b, R.drawable.obfuscated_res_0x7f0804c2);
                this.b.setHintTextColor(SkinManager.getColor(i2, (int) R.color.CAM_X0109));
            } else {
                j19.l(this.b, R.drawable.obfuscated_res_0x7f0804c3);
                this.b.setHintTextColor(SkinManager.getColor(i2, (int) R.color.CAM_X0109));
            }
            this.c.l(i2);
            TBSpecificationBtn tBSpecificationBtn = this.h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.l(i2);
            }
            uu4.d(this.f).v(R.color.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
        }
    }

    public void setDefaultHint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.n = str;
        }
    }

    @Override // com.baidu.tieba.g55
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    public void setHasHint(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z2) == null) {
        }
    }

    public void setHint(int i2) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048600, this, i2) == null) || (spanGroupEditText = this.b) == null) {
            return;
        }
        spanGroupEditText.setHint(getContext().getString(i2));
    }

    public void setIsOnlyLocalEmotion(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            this.p = z2;
        }
    }

    @Override // com.baidu.tieba.g55
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.i = i2;
        }
    }

    public void setTransLink(boolean z2) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048604, this, z2) == null) || (spanGroupEditText = this.b) == null) {
            return;
        }
        spanGroupEditText.setTransLink(z2);
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.v = i2;
        }
    }

    public void setmAtListRequestResponseCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.o = i2;
        }
    }

    public final void u(u45 u45Var) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, u45Var) == null) || u45Var == null) {
            return;
        }
        boolean[] zArr = this.t;
        Object obj = u45Var.c;
        if (obj != null && (!(obj instanceof String) || !StringUtils.isNull((String) obj))) {
            Object obj2 = u45Var.c;
            if (!(obj2 instanceof c75) || !TextUtils.isEmpty(((c75) obj2).a)) {
                Object obj3 = u45Var.c;
                if (!(obj3 instanceof SpanGroupManager) || !((SpanGroupManager) obj3).K()) {
                    z2 = true;
                    zArr[0] = z2;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(true ^ this.t[0])));
                }
            }
        }
        z2 = false;
        zArr[0] = z2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(true ^ this.t[0])));
    }

    public final void v(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, arrayList) == null) {
            int selectionStart = this.b.getSelectionStart();
            if (selectionStart > 0) {
                int i2 = selectionStart - 1;
                if (this.b.getText().toString().charAt(i2) == '@') {
                    this.b.getEditableText().delete(i2, selectionStart);
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
        if (!(interceptable == null || interceptable.invokeL(1048609, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.b.getText().insert(this.b.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    public void x(int i2) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            if (i2 != B && i2 != A) {
                if (i2 == z) {
                    if (this.t[1]) {
                        this.c.setEnabled(true);
                        return;
                    } else {
                        this.c.setEnabled(false);
                        return;
                    }
                }
                return;
            }
            if (i2 == A && (tBSpecificationBtn = this.h) != null) {
                tBSpecificationBtn.setVisibility(8);
            }
            boolean[] zArr = this.t;
            if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                this.c.setEnabled(false);
            } else {
                this.c.setEnabled(true);
            }
        }
    }

    public final void y(s05 s05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, s05Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c14122");
            statisticItem.param("fid", s05Var.a).param("tid", s05Var.b).param("uid", s05Var.c).param("obj_type", s05Var.d).param("obj_source", s05Var.e).param("obj_locate", s05Var.f).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, s05Var.h);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, context) == null) {
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
            j19.l(this.b, R.drawable.obfuscated_res_0x7f0804c2);
            this.b.setLineSpacing(ej.f(context, R.dimen.M_T_X002), 1.0f);
            this.b.setPadding(ej.f(context, R.dimen.M_W_X006), ej.f(context, R.dimen.M_H_X004), ej.f(context, R.dimen.M_W_X006), ej.f(context, R.dimen.M_H_X004));
            this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.b.addTextChangedListener(new f(this));
            this.b.setOnTouchListener(new g(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(ej.f(context, R.dimen.M_W_X007), ej.f(context, R.dimen.M_H_X002), ej.f(context, R.dimen.M_W_X006), ej.f(context, R.dimen.M_H_X002));
            this.d.addView(this.b, layoutParams);
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
    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i2) {
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
        this.o = 12004;
        this.p = false;
        this.q = true;
        this.r = true;
        this.s = -1;
        this.t = new boolean[]{false, false, false, false, false};
        this.u = new int[]{0, 0};
        this.v = B;
        this.w = false;
        this.y = new b(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070308));
        A();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.g = linearLayout;
        linearLayout.setOrientation(0);
        addView(this.g, new LinearLayout.LayoutParams(-1, -2));
        D(context);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.d = linearLayout2;
        linearLayout2.setOrientation(0);
        this.d.setMinimumHeight(ej.f(context, R.dimen.tbds128));
        addView(this.d, new LinearLayout.LayoutParams(-1, -2));
        z(context);
        C(context);
        this.e = new View(getContext());
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, ej.f(getContext(), R.dimen.obfuscated_res_0x7f070198)));
        addView(this.e);
        this.x = new ArrayList();
    }

    public void setHint(CharSequence charSequence) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, charSequence) == null) || (spanGroupEditText = this.b) == null) {
            return;
        }
        spanGroupEditText.setHint(charSequence);
    }
}

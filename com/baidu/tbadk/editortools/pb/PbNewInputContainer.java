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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c35;
import com.repackage.da6;
import com.repackage.ea6;
import com.repackage.gy4;
import com.repackage.h25;
import com.repackage.hy4;
import com.repackage.jz8;
import com.repackage.ks4;
import com.repackage.l28;
import com.repackage.ms4;
import com.repackage.n45;
import com.repackage.pv4;
import com.repackage.q45;
import com.repackage.qi;
import com.repackage.rg;
import com.repackage.ru4;
import com.repackage.t25;
import com.repackage.w35;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
/* loaded from: classes3.dex */
public class PbNewInputContainer extends LinearLayout implements t25, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int A = 1;
    public static int B = 2;
    public static int C;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public SpanGroupEditText b;
    public TBSpecificationBtn c;
    public TBSpecificationBtn d;
    public LinearLayout e;
    public View f;
    public TextView g;
    public LinearLayout h;
    public TBSpecificationBtn i;
    public int j;
    public q45 k;
    public SpannableStringBuilder l;
    public String m;
    public String n;
    public String o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean[] u;
    public int[] v;
    public int w;
    public boolean x;
    public List<gy4> y;
    public Runnable z;

    /* loaded from: classes3.dex */
    public class a implements ea6.h {
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

        @Override // com.repackage.ea6.h
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.J(new h25(5, -1, null));
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
            pbNewInputContainer.J(new h25(4, -1, pbNewInputContainer.b.getSpanGroupManager()));
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
                boolean z = !((Boolean) this.a.i.a).booleanValue();
                ru4.k().u("key_virtual_image_and_state_has_show", z);
                this.a.M(z);
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
                this.b.J(new h25(67, -1, Boolean.valueOf(this.a)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        /* loaded from: classes3.dex */
        public class a implements n45.c {
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

            @Override // com.repackage.n45.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.x = false;
                    ru4.k().u("key_virtual_image_and_state_has_show", false);
                    this.a.a.M(false);
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
                    if (this.a.g != null && this.a.g.getText() != null && this.a.g.getText().length() > 0) {
                        z = true;
                    }
                    boolean h = ru4.k().h("key_virtual_image_and_state_has_show", true);
                    l28 a2 = l28.a();
                    if (h && (a2 == null || a2.b() != 1)) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 21).param("obj_type", z ? 2 : 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                        this.a.x = true;
                        n45.c(new a(this));
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 11).param("obj_type", z ? 2 : 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.a.J(new h25(8, -1, null));
                    return;
                }
                qi.O(this.a.getContext(), String.format(ks4.E(R.string.obfuscated_res_0x7f0f0fe3), new Object[0]));
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
            if (!TextUtils.isEmpty(this.a.l)) {
                if (this.a.k == null) {
                    this.a.k = new q45();
                }
                this.a.k.b = this.a.l.toString();
                this.a.k.d = this.a.m;
                this.a.k.e = this.a.n;
                this.a.k.a = this.a.b.getText().toString();
                this.a.k.c = this.a.b.getSpanGroupManager();
                PbNewInputContainer pbNewInputContainer = this.a;
                pbNewInputContainer.J(new h25(4, -1, pbNewInputContainer.k));
                return;
            }
            rg.a().removeCallbacks(this.a.z);
            rg.a().post(this.a.z);
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
                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext(), this.a.p, true);
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
                if (this.a.s) {
                    return;
                }
                this.a.s = true;
                if (this.a.b == null || this.a.t == -1) {
                    return;
                }
                this.a.b.setSelection(this.a.t);
                this.a.t = -1;
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
                    this.a.J(new h25(5, -1, null));
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
                qi.M(this.a.getContext(), this.a.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements ea6.h {
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

        @Override // com.repackage.ea6.h
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.J(new h25(5, -1, null));
                this.a.requestFocus();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements ea6.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q45 a;
        public final /* synthetic */ PbNewInputContainer b;

        public j(PbNewInputContainer pbNewInputContainer, q45 q45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer, q45Var};
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
            this.a = q45Var;
        }

        @Override // com.repackage.ea6.h
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.b.l = spannableStringBuilder;
                this.b.m = this.a.d;
                this.b.n = this.a.e;
                if (TextUtils.isEmpty(this.a.a)) {
                    this.b.b.setText("");
                    this.b.J(new h25(5, -1, null));
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

    @Override // com.repackage.i25
    public void A(h25 h25Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, h25Var) == null) || h25Var == null) {
            return;
        }
        int i2 = h25Var.a;
        if (i2 != 3) {
            if (i2 == 4) {
                u(h25Var);
            } else if (i2 == 6) {
                Object obj = h25Var.c;
                if (obj == null) {
                    this.b.setText((CharSequence) null);
                } else if (obj instanceof String) {
                    if (TextUtils.isEmpty((String) obj)) {
                        this.b.setText((CharSequence) null);
                    } else {
                        ea6.f(getContext(), (String) h25Var.c, new i(this));
                    }
                } else if (obj instanceof q45) {
                    this.l = null;
                    String str = this.o;
                    if (str != null) {
                        this.b.setHint(str);
                    }
                    Object obj2 = h25Var.c;
                    q45 q45Var = (q45) obj2;
                    if (TextUtils.isEmpty(((q45) obj2).b) && TextUtils.isEmpty(((q45) h25Var.c).a)) {
                        this.b.setText((CharSequence) null);
                    } else {
                        if (!TextUtils.isEmpty(q45Var.b)) {
                            ea6.f(getContext(), q45Var.b, new j(this, q45Var));
                        }
                        if (!TextUtils.isEmpty(q45Var.a)) {
                            ea6.f(getContext(), q45Var.a, new a(this));
                        }
                    }
                }
                u(h25Var);
            } else if (i2 == 17) {
                Object obj3 = h25Var.c;
                if (obj3 != null && (obj3 instanceof ArrayList)) {
                    v((ArrayList) obj3);
                }
            } else if (i2 != 24) {
                if (i2 != 39) {
                    if (i2 != 19) {
                        if (i2 == 20) {
                            L(true);
                            this.d.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a58));
                        } else if (i2 != 28) {
                            if (i2 == 29) {
                                this.u[3] = false;
                            } else if (i2 == 44) {
                                Object obj4 = h25Var.c;
                                if (obj4 != null) {
                                    if (obj4 instanceof String) {
                                        w((String) obj4);
                                    } else if ((obj4 instanceof q45) && ((q45) obj4).a != null) {
                                        w(((q45) obj4).a);
                                    }
                                }
                            } else if (i2 != 45) {
                                switch (i2) {
                                    case 9:
                                        for (gy4 gy4Var : this.y) {
                                            y(gy4Var.a());
                                        }
                                        this.y.clear();
                                        if (((Boolean) h25Var.c).booleanValue()) {
                                            this.k = null;
                                            this.l = null;
                                            this.b.setText((CharSequence) null);
                                        }
                                        boolean[] zArr = this.u;
                                        zArr[0] = false;
                                        zArr[1] = false;
                                        zArr[2] = false;
                                        zArr[3] = false;
                                        zArr[4] = false;
                                        int[] iArr = this.v;
                                        iArr[0] = 0;
                                        iArr[1] = 0;
                                        break;
                                    case 10:
                                        this.u[2] = true;
                                        break;
                                    case 11:
                                        this.u[2] = false;
                                        break;
                                    case 12:
                                        Object obj5 = h25Var.c;
                                        if (obj5 instanceof c35) {
                                            c35 c35Var = (c35) obj5;
                                            WriteImagesInfo writeImagesInfo = c35Var.a;
                                            if (writeImagesInfo != null) {
                                                if (writeImagesInfo.getChosedFiles() != null) {
                                                    this.v[0] = c35Var.a.getChosedFiles().size();
                                                } else {
                                                    this.v[0] = 0;
                                                }
                                            }
                                            if (this.v[0] > 0) {
                                                this.u[1] = true;
                                                break;
                                            } else {
                                                this.u[1] = false;
                                                break;
                                            }
                                        } else {
                                            return;
                                        }
                                    case 13:
                                        int[] iArr2 = this.v;
                                        iArr2[0] = iArr2[0] - 1;
                                        if (iArr2[0] > 0) {
                                            this.u[1] = true;
                                            break;
                                        } else {
                                            this.u[1] = false;
                                            break;
                                        }
                                }
                            } else {
                                Object obj6 = h25Var.c;
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
                    } else if (h25Var.c == null) {
                        L(false);
                    } else {
                        L(true);
                        w35 w35Var = (w35) h25Var.c;
                        if (w35Var.a == 1) {
                            this.d.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a52));
                        } else if (!TextUtils.isEmpty(w35Var.b)) {
                            this.d.setText(w35Var.b);
                        } else {
                            this.d.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a58));
                        }
                    }
                }
                this.u[3] = true;
            } else {
                F(h25Var);
            }
        } else if (this.b.getSelectionStart() > 0) {
            String substring = this.b.getText().toString().substring(0, this.b.getSelectionStart());
            Matcher matcher = da6.b.matcher(substring);
            if (matcher.find()) {
                int length = substring.length() - matcher.replaceFirst("").length();
                String substring2 = this.b.getText().toString().substring(this.b.getSelectionStart() - length, this.b.getSelectionStart());
                Iterator<gy4> it = this.y.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    gy4 next = it.next();
                    if (next.d().equals(substring2)) {
                        this.y.remove(next);
                        break;
                    }
                }
                this.b.getText().delete(this.b.getSelectionStart() - length, this.b.getSelectionStart()).toString();
            } else {
                this.b.getText().delete(this.b.getSelectionStart() - 1, this.b.getSelectionStart());
            }
        }
        x(this.w);
    }

    public final void B(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            pv4 pv4Var = new pv4();
            pv4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            pv4Var.i(R.drawable.obfuscated_res_0x7f0805ff, 0, TBSpecificationButtonConfig.IconType.WEBP);
            pv4Var.h(R.color.CAM_X0110);
            pv4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            pv4Var.m(qi.f(getContext(), R.dimen.M_W_X004), qi.f(getContext(), R.dimen.M_W_X004));
            pv4Var.n(qi.f(getContext(), R.dimen.M_H_X002));
            pv4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, qi.f(getContext(), R.dimen.tbds62));
            layoutParams.setMargins(qi.f(context, R.dimen.M_W_X007), qi.f(context, R.dimen.M_H_X004), qi.f(context, R.dimen.M_W_X007), qi.f(context, R.dimen.M_H_X003));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.d = tBSpecificationBtn;
            tBSpecificationBtn.setLayoutParams(layoutParams);
            this.d.setOnClickListener(this);
            this.d.setConfig(pv4Var);
            this.d.setTextSize(R.dimen.T_X09);
            this.d.setOnClickListener(this);
            this.d.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0a58));
            this.h.addView(this.d);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            EMTextView eMTextView = new EMTextView(getContext());
            this.g = eMTextView;
            eMTextView.setId(R.id.obfuscated_res_0x7f09066a);
            this.g.setVisibility(8);
            this.g.setMaxLines(1);
            this.g.setEllipsize(TextUtils.TruncateAt.END);
            this.g.setPadding(qi.f(getContext(), R.dimen.M_W_X009), qi.f(getContext(), R.dimen.M_H_X005), qi.f(getContext(), R.dimen.M_W_X009), qi.f(getContext(), R.dimen.M_H_X003));
            this.g.setTextSize(0, qi.f(getContext(), R.dimen.T_X08));
            addView(this.g, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public final void D(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(80);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            pv4 pv4Var = new pv4();
            pv4Var.p(R.color.CAM_X0302, R.color.CAM_X0101);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.c = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(pv4Var);
            this.c.setEnabled(false);
            this.c.setTextSize(R.dimen.T_X08);
            this.c.setText(context.getString(R.string.obfuscated_res_0x7f0f0dee));
            this.c.setOnClickListener(new e(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(qi.f(context, R.dimen.tbds150), qi.f(context, R.dimen.tbds75));
            layoutParams2.rightMargin = qi.f(context, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = qi.f(context, R.dimen.M_H_X002);
            linearLayout.addView(this.c, layoutParams2);
            this.e.addView(linearLayout, layoutParams);
        }
    }

    public final void E(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            pv4 pv4Var = new pv4();
            pv4Var.p(R.color.CAM_X0209, R.color.CAM_X0105);
            pv4Var.h(R.color.CAM_X0302);
            pv4Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            pv4Var.m(qi.f(getContext(), R.dimen.M_W_X004), qi.f(getContext(), R.dimen.M_W_X004));
            pv4Var.n(qi.f(getContext(), R.dimen.M_H_X002));
            pv4Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.i = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(pv4Var);
            this.i.setTextSize(R.dimen.T_X09);
            boolean h2 = ru4.k().h("key_virtual_image_and_state_has_show", true);
            if (!h2) {
                M(h2);
            } else {
                M(h2);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, qi.f(getContext(), R.dimen.tbds62));
            layoutParams.setMargins(0, qi.f(context, R.dimen.M_H_X004), qi.f(context, R.dimen.M_W_X007), qi.f(context, R.dimen.M_H_X003));
            this.i.setLayoutParams(layoutParams);
            this.i.setOnClickListener(new c(this));
            this.h.addView(this.i);
        }
    }

    public final void F(h25 h25Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, h25Var) == null) || h25Var == null || (obj = h25Var.c) == null || !(obj instanceof gy4) || EmotionGroupType.isSendAsPic(((gy4) obj).getType())) {
            return;
        }
        gy4 gy4Var = (gy4) h25Var.c;
        if (gy4Var.getType() == EmotionGroupType.NET_SUG) {
            H(gy4Var);
        } else {
            G(gy4Var);
        }
    }

    public final void G(gy4 gy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gy4Var) == null) {
            if (!this.q || gy4Var.getType() == EmotionGroupType.LOCAL) {
                String obj = this.b.getText().toString();
                if (this.r && da6.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f1431);
                    return;
                }
                this.y.add(gy4Var);
                ea6.b(getContext(), gy4Var, this.b);
            }
        }
    }

    public final void H(gy4 gy4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, gy4Var) == null) || gy4Var == null || TextUtils.isEmpty(gy4Var.d()) || TextUtils.isEmpty(gy4Var.g())) {
            return;
        }
        String obj = this.b.getText().toString();
        if (this.r && da6.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.obfuscated_res_0x7f0f1431);
            return;
        }
        this.y.add(gy4Var);
        ea6.c(getContext(), gy4Var, this.b);
    }

    @Override // com.repackage.t25
    public void J(h25 h25Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h25Var) == null) || (editorTools = this.a) == null) {
            return;
        }
        editorTools.A(h25Var);
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.x) {
            this.x = false;
            if (this.b == null || this.e.getVisibility() != 0) {
                return;
            }
            this.b.setFocusable(true);
            this.b.setFocusableInTouchMode(true);
            this.b.requestFocus();
            qi.M(getContext(), this.b);
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.d;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setVisibility(z ? 0 : 8);
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.i;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.setVisibility(z ? 0 : 8);
            }
        }
    }

    public final void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.i.setText(BdBaseApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1179));
            this.i.getStyleConfig().i(z ? R.drawable.obfuscated_res_0x7f080997 : R.drawable.obfuscated_res_0x7f080996, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.i.getStyleConfig().h(z ? R.color.CAM_X0302 : R.color.CAM_X0110);
            this.i.a = Boolean.valueOf(z);
            rg.a().postDelayed(new d(this, z), 200L);
        }
    }

    @Override // com.repackage.t25
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.b != null && this.e.getVisibility() == 0) {
                this.b.setFocusable(true);
                this.b.setFocusableInTouchMode(true);
                this.b.requestFocus();
                rg.a().postDelayed(new h(this), 200L);
            }
            setVisibility(0);
        }
    }

    public LinearLayout getInputLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.e : (LinearLayout) invokeV.objValue;
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.b : (EditText) invokeV.objValue;
    }

    public TBSpecificationBtn getSendView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.c : (TBSpecificationBtn) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.g : (TextView) invokeV.objValue;
    }

    @Override // com.repackage.t25
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.j : invokeV.intValue;
    }

    @Override // com.repackage.t25
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            setVisibility(8);
        }
    }

    @Override // com.repackage.t25
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.repackage.t25
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.b.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0105, 2, i2);
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i2).setShape(0).radius(qi.f(getContext(), R.dimen.tbds21)).into(this.b);
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0207, i2);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i2);
            if (i2 == 0) {
                jz8.l(this.b, R.drawable.obfuscated_res_0x7f0804ae);
                this.b.setHintTextColor(SkinManager.getColor(i2, (int) R.color.CAM_X0109));
            } else {
                jz8.l(this.b, R.drawable.obfuscated_res_0x7f0804af);
                this.b.setHintTextColor(SkinManager.getColor(i2, (int) R.color.CAM_X0109));
            }
            this.c.l(i2);
            this.d.l(i2);
            TBSpecificationBtn tBSpecificationBtn = this.i;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.l(i2);
            }
            ms4.d(this.g).v(R.color.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, view2) == null) && view2 == this.d) {
            J(new h25(18, -1, null));
        }
    }

    public void setDefaultHint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.repackage.t25
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    public void setHasHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
        }
    }

    public void setHint(int i2) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i2) == null) || (spanGroupEditText = this.b) == null) {
            return;
        }
        spanGroupEditText.setHint(getContext().getString(i2));
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.repackage.t25
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.j = i2;
        }
    }

    public void setTransLink(boolean z) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || (spanGroupEditText = this.b) == null) {
            return;
        }
        spanGroupEditText.setTransLink(z);
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setmAtListRequestResponseCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.p = i2;
        }
    }

    public final void u(h25 h25Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, h25Var) == null) || h25Var == null) {
            return;
        }
        boolean[] zArr = this.u;
        Object obj = h25Var.c;
        if (obj != null && (!(obj instanceof String) || !StringUtils.isNull((String) obj))) {
            Object obj2 = h25Var.c;
            if (!(obj2 instanceof q45) || !TextUtils.isEmpty(((q45) obj2).a)) {
                Object obj3 = h25Var.c;
                if (!(obj3 instanceof SpanGroupManager) || !((SpanGroupManager) obj3).K()) {
                    z = true;
                    zArr[0] = z;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(true ^ this.u[0])));
                }
            }
        }
        z = false;
        zArr[0] = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(true ^ this.u[0])));
    }

    public final void v(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, arrayList) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(1048610, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.b.getText().insert(this.b.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    public void x(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            if (i2 != C && i2 != B) {
                if (i2 == A) {
                    if (this.u[1]) {
                        this.c.setEnabled(true);
                        return;
                    } else {
                        this.c.setEnabled(false);
                        return;
                    }
                }
                return;
            }
            if (i2 == B) {
                TBSpecificationBtn tBSpecificationBtn = this.i;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.setVisibility(8);
                }
                TBSpecificationBtn tBSpecificationBtn2 = this.d;
                if (tBSpecificationBtn2 != null) {
                    tBSpecificationBtn2.setVisibility(8);
                }
            }
            boolean[] zArr = this.u;
            if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                this.c.setEnabled(false);
            } else {
                this.c.setEnabled(true);
            }
        }
    }

    public final void y(hy4 hy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, hy4Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c14122");
            statisticItem.param("fid", hy4Var.a).param("tid", hy4Var.b).param("uid", hy4Var.c).param("obj_type", hy4Var.d).param("obj_source", hy4Var.e).param("obj_locate", hy4Var.f).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, hy4Var.h);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, context) == null) {
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
            jz8.l(this.b, R.drawable.obfuscated_res_0x7f0804ae);
            this.b.setLineSpacing(qi.f(context, R.dimen.M_T_X002), 1.0f);
            this.b.setPadding(qi.f(context, R.dimen.M_W_X006), qi.f(context, R.dimen.M_H_X004), qi.f(context, R.dimen.M_W_X006), qi.f(context, R.dimen.M_H_X004));
            this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.b.addTextChangedListener(new f(this));
            this.b.setOnTouchListener(new g(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(qi.f(context, R.dimen.M_W_X007), qi.f(context, R.dimen.M_H_X002), qi.f(context, R.dimen.M_W_X006), qi.f(context, R.dimen.M_H_X002));
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
        this.p = 12004;
        this.q = false;
        this.r = true;
        this.s = true;
        this.t = -1;
        this.u = new boolean[]{false, false, false, false, false};
        this.v = new int[]{0, 0};
        this.w = C;
        this.x = false;
        this.z = new b(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070308));
        C();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.h = linearLayout;
        linearLayout.setOrientation(0);
        addView(this.h, new LinearLayout.LayoutParams(-1, -2));
        B(context);
        E(context);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.e = linearLayout2;
        linearLayout2.setOrientation(0);
        this.e.setMinimumHeight(qi.f(context, R.dimen.tbds128));
        addView(this.e, new LinearLayout.LayoutParams(-1, -2));
        z(context);
        D(context);
        this.f = new View(getContext());
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, qi.f(getContext(), R.dimen.obfuscated_res_0x7f070198)));
        addView(this.f);
        this.y = new ArrayList();
    }

    public void setHint(CharSequence charSequence) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, charSequence) == null) || (spanGroupEditText = this.b) == null) {
            return;
        }
        spanGroupEditText.setHint(charSequence);
    }
}

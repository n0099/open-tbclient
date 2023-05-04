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
import com.baidu.tieba.e35;
import com.baidu.tieba.e65;
import com.baidu.tieba.ee5;
import com.baidu.tieba.f55;
import com.baidu.tieba.g35;
import com.baidu.tieba.gg;
import com.baidu.tieba.ii;
import com.baidu.tieba.jd5;
import com.baidu.tieba.jg;
import com.baidu.tieba.kf5;
import com.baidu.tieba.p5a;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.pf5;
import com.baidu.tieba.sf5;
import com.baidu.tieba.tu6;
import com.baidu.tieba.uu6;
import com.baidu.tieba.v85;
import com.baidu.tieba.vd5;
import com.baidu.tieba.w85;
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
public class PbNewInputContainer extends LinearLayout implements vd5, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int A = 1;
    public static int B = 2;
    public static int C;
    public transient /* synthetic */ FieldHolder $fh;
    public EditorTools a;
    public SpanGroupEditText b;
    public TBSpecificationBtn c;
    public LinearLayout d;
    public View e;
    public TextView f;
    public LinearLayout g;
    public TBSpecificationBtn h;
    public TBSpecificationBtn i;
    public int j;
    public sf5 k;
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
    public List<v85> y;
    public Runnable z;

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

    @Override // com.baidu.tieba.vd5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, view2) == null) {
        }
    }

    public void setHasHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        /* loaded from: classes3.dex */
        public class a implements pf5.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // com.baidu.tieba.pf5.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.x = false;
                f55.m().w("key_virtual_image_and_state_has_show", false);
                this.a.a.R(false);
            }
        }

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = false;
                if (this.a.b != null && this.a.b.getText().toString().trim().equals("")) {
                    ii.Q(this.a.getContext(), String.format(e35.H(R.string.reply_not_empty), new Object[0]));
                    return;
                }
                int i = 1;
                if (this.a.f != null && this.a.f.getText() != null && this.a.f.getText().length() > 0) {
                    z = true;
                }
                boolean i2 = f55.m().i("key_virtual_image_and_state_has_show", true);
                ProfileVirtualImageInfo profileVirtualImageInfo = ProfileVirtualImageInfo.getInstance();
                int i3 = 2;
                if (i2 && (profileVirtualImageInfo == null || profileVirtualImageInfo.getIsSetVirtualImage() != 1)) {
                    StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 21);
                    if (!z) {
                        i3 = 1;
                    }
                    TiebaStatic.log(param.param("obj_type", i3).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.a.x = true;
                    pf5.c(new a(this));
                    return;
                }
                StatisticItem param2 = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 11);
                if (z) {
                    i = 2;
                }
                TiebaStatic.log(param2.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.a.H(new jd5(8, -1, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements uu6.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sf5 a;
        public final /* synthetic */ PbNewInputContainer b;

        public a(PbNewInputContainer pbNewInputContainer, sf5 sf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer, sf5Var};
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
            this.a = sf5Var;
        }

        @Override // com.baidu.tieba.uu6.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, spannableStringBuilder) != null) {
                return;
            }
            this.b.l = spannableStringBuilder;
            this.b.m = this.a.d;
            this.b.n = this.a.e;
            if (TextUtils.isEmpty(this.a.a)) {
                this.b.b.setText("");
                this.b.H(new jd5(5, -1, null));
                this.b.requestFocus();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements uu6.i {
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

        @Override // com.baidu.tieba.uu6.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.H(new jd5(5, -1, null));
                this.a.requestFocus();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                PbNewInputContainer pbNewInputContainer = this.a;
                pbNewInputContainer.H(new jd5(4, -1, pbNewInputContainer.b.getSpanGroupManager()));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !((Boolean) this.a.h.a).booleanValue();
                f55.m().w("key_virtual_image_and_state_has_show", z);
                this.a.R(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ PbNewInputContainer b;

        public e(PbNewInputContainer pbNewInputContainer, boolean z) {
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
                this.b.H(new jd5(67, -1, Boolean.valueOf(this.a)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !((Boolean) this.a.i.a).booleanValue();
                f55.m().w(f55.q("key_reply_add_bless_enable"), z);
                this.a.Q(z);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && editable != null && editable.toString().trim() != null) {
                if (!TextUtils.isEmpty(this.a.l)) {
                    if (this.a.k == null) {
                        this.a.k = new sf5();
                    }
                    this.a.k.b = this.a.l.toString();
                    this.a.k.d = this.a.m;
                    this.a.k.e = this.a.n;
                    this.a.k.a = this.a.b.getText().toString();
                    this.a.k.c = this.a.b.getSpanGroupManager();
                    PbNewInputContainer pbNewInputContainer = this.a;
                    pbNewInputContainer.H(new jd5(4, -1, pbNewInputContainer.k));
                    return;
                }
                jg.a().removeCallbacks(this.a.z);
                jg.a().post(this.a.z);
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
                if (this.a.b != null && this.a.t != -1) {
                    this.a.b.setSelection(this.a.t);
                    this.a.t = -1;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.a.H(new jd5(5, -1, null));
                    this.a.b.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public j(PbNewInputContainer pbNewInputContainer) {
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
                ii.O(this.a.getContext(), this.a.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements uu6.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public k(PbNewInputContainer pbNewInputContainer) {
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

        @Override // com.baidu.tieba.uu6.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.H(new jd5(5, -1, null));
                this.a.requestFocus();
            }
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

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        this.b.getText().insert(this.b.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    public final void J(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, context) != null) || !kf5.a()) {
            return;
        }
        this.i = D(context);
        Q(f55.m().i(f55.q("key_reply_add_bless_enable"), true));
        this.i.setOnClickListener(new f(this));
        this.g.addView(this.i);
    }

    public final void K(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, context) != null) || !ProfileVirtualImageInfo.getInstance().isDisplayVirtual()) {
            return;
        }
        this.h = D(context);
        R(f55.m().i("key_virtual_image_and_state_has_show", true));
        this.h.setOnClickListener(new d(this));
        this.g.addView(this.h);
    }

    public final void M(jd5 jd5Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, jd5Var) == null) && jd5Var != null && (obj = jd5Var.c) != null && (obj instanceof v85) && !EmotionGroupType.isSendAsPic(((v85) obj).getType())) {
            v85 v85Var = (v85) jd5Var.c;
            if (v85Var.getType() == EmotionGroupType.NET_SUG) {
                O(v85Var);
            } else {
                N(v85Var);
            }
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
        this.z = new c(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070309));
        G();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.g = linearLayout;
        linearLayout.setOrientation(0);
        addView(this.g, new LinearLayout.LayoutParams(-1, -2));
        J(context);
        K(context);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.d = linearLayout2;
        linearLayout2.setOrientation(0);
        this.d.setMinimumHeight(ii.g(context, R.dimen.tbds128));
        addView(this.d, new LinearLayout.LayoutParams(-1, -2));
        F(context);
        I(context);
        this.e = new View(getContext());
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, ii.g(getContext(), R.dimen.obfuscated_res_0x7f070198)));
        addView(this.e);
        this.y = new ArrayList();
    }

    @Override // com.baidu.tieba.vd5
    public void H(jd5 jd5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, jd5Var) == null) && (editorTools = this.a) != null) {
            editorTools.C(jd5Var);
        }
    }

    public void S(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.h;
            int i3 = 0;
            if (tBSpecificationBtn != null) {
                if (z) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                tBSpecificationBtn.setVisibility(i2);
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.i;
            if (tBSpecificationBtn2 != null) {
                if (!z) {
                    i3 = 8;
                }
                tBSpecificationBtn2.setVisibility(i3);
            }
        }
    }

    public void setDefaultHint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.o = str;
        }
    }

    @Override // com.baidu.tieba.vd5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    public void setHint(int i2) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048607, this, i2) == null) && (spanGroupEditText = this.b) != null) {
            spanGroupEditText.setHint(getContext().getString(i2));
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.q = z;
        }
    }

    @Override // com.baidu.tieba.vd5
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.j = i2;
        }
    }

    public void setTransLink(boolean z) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048611, this, z) == null) && (spanGroupEditText = this.b) != null) {
            spanGroupEditText.setTransLink(z);
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setmAtListRequestResponseCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.p = i2;
        }
    }

    public void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
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
                TBSpecificationBtn tBSpecificationBtn = this.h;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.setVisibility(8);
                }
                TBSpecificationBtn tBSpecificationBtn2 = this.i;
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

    public final void I(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(80);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            e65 e65Var = new e65();
            e65Var.r(R.color.CAM_X0302, R.color.CAM_X0101);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.c = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(e65Var);
            this.c.setEnabled(false);
            this.c.setTextSize(R.dimen.T_X08);
            this.c.setText(context.getString(R.string.pb_send_post));
            this.c.setOnClickListener(new g(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(ii.g(context, R.dimen.tbds150), ii.g(context, R.dimen.tbds75));
            layoutParams2.rightMargin = ii.g(context, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = ii.g(context, R.dimen.M_H_X002);
            linearLayout.addView(this.c, layoutParams2);
            this.d.addView(linearLayout, layoutParams);
        }
    }

    @Override // com.baidu.tieba.kd5
    public void C(jd5 jd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jd5Var) != null) || jd5Var == null) {
            return;
        }
        int i2 = jd5Var.a;
        if (i2 != 3) {
            if (i2 != 4) {
                if (i2 != 6) {
                    if (i2 != 17) {
                        if (i2 != 24) {
                            if (i2 != 39) {
                                if (i2 != 70) {
                                    if (i2 != 28) {
                                        if (i2 != 29) {
                                            if (i2 != 44) {
                                                if (i2 != 45) {
                                                    switch (i2) {
                                                        case 9:
                                                            for (v85 v85Var : this.y) {
                                                                E(v85Var.a());
                                                            }
                                                            this.y.clear();
                                                            if (((Boolean) jd5Var.c).booleanValue()) {
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
                                                            Object obj = jd5Var.c;
                                                            if (!(obj instanceof ee5)) {
                                                                return;
                                                            }
                                                            ee5 ee5Var = (ee5) obj;
                                                            WriteImagesInfo writeImagesInfo = ee5Var.a;
                                                            if (writeImagesInfo != null) {
                                                                if (writeImagesInfo.getChosedFiles() != null) {
                                                                    this.v[0] = ee5Var.a.getChosedFiles().size();
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
                                                    Object obj2 = jd5Var.c;
                                                    if (obj2 instanceof String) {
                                                        String str = (String) obj2;
                                                        if (StringUtils.isNull(str)) {
                                                            this.f.setVisibility(8);
                                                        } else {
                                                            this.f.setVisibility(0);
                                                            this.f.setText(str);
                                                        }
                                                    } else {
                                                        this.f.setVisibility(8);
                                                    }
                                                }
                                            } else {
                                                Object obj3 = jd5Var.c;
                                                if (obj3 != null) {
                                                    if (obj3 instanceof String) {
                                                        A((String) obj3);
                                                    } else if ((obj3 instanceof sf5) && ((sf5) obj3).a != null) {
                                                        A(((sf5) obj3).a);
                                                    }
                                                }
                                            }
                                        } else {
                                            this.u[3] = false;
                                        }
                                    }
                                } else {
                                    Object obj4 = jd5Var.c;
                                    if (obj4 instanceof String) {
                                        long g2 = gg.g((String) obj4, 0L);
                                        if (g2 > 0) {
                                            this.b.setForumId(g2);
                                        }
                                    }
                                }
                            }
                            this.u[3] = true;
                        } else {
                            M(jd5Var);
                        }
                    } else {
                        Object obj5 = jd5Var.c;
                        if (obj5 != null && (obj5 instanceof ArrayList)) {
                            z((ArrayList) obj5);
                        }
                    }
                } else {
                    Object obj6 = jd5Var.c;
                    if (obj6 == null) {
                        this.b.setText((CharSequence) null);
                    } else if (obj6 instanceof String) {
                        if (TextUtils.isEmpty((String) obj6)) {
                            this.b.setText((CharSequence) null);
                        } else {
                            uu6.g(getContext(), (String) jd5Var.c, new k(this));
                        }
                    } else if (obj6 instanceof sf5) {
                        this.l = null;
                        String str2 = this.o;
                        if (str2 != null) {
                            this.b.setHint(str2);
                        }
                        Object obj7 = jd5Var.c;
                        sf5 sf5Var = (sf5) obj7;
                        if (TextUtils.isEmpty(((sf5) obj7).b) && TextUtils.isEmpty(((sf5) jd5Var.c).a)) {
                            this.b.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(sf5Var.b)) {
                                uu6.g(getContext(), sf5Var.b, new a(this, sf5Var));
                            }
                            if (!TextUtils.isEmpty(sf5Var.a)) {
                                uu6.g(getContext(), sf5Var.a, new b(this));
                            }
                        }
                    }
                    y(jd5Var);
                }
            } else {
                y(jd5Var);
            }
        } else if (this.b.getSelectionStart() > 0) {
            String substring = this.b.getText().toString().substring(0, this.b.getSelectionStart());
            Matcher matcher = tu6.b.matcher(substring);
            if (matcher.find()) {
                int length = substring.length() - matcher.replaceFirst("").length();
                String substring2 = this.b.getText().toString().substring(this.b.getSelectionStart() - length, this.b.getSelectionStart());
                Iterator<v85> it = this.y.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    v85 next = it.next();
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
        B(this.w);
    }

    public final TBSpecificationBtn D(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            e65 e65Var = new e65();
            e65Var.r(R.color.CAM_X0209, SkinManager.getColor(R.color.CAM_X0105));
            e65Var.y(false);
            e65Var.h(kf5.b(true));
            e65Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            e65Var.n(ii.g(getContext(), R.dimen.M_W_X004), ii.g(getContext(), R.dimen.M_W_X004));
            e65Var.o(ii.g(getContext(), R.dimen.M_H_X002));
            e65Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            tBSpecificationBtn.setConfig(e65Var);
            tBSpecificationBtn.setTextSize(R.dimen.T_X09);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ii.g(getContext(), R.dimen.tbds62));
            layoutParams.setMargins(ii.g(context, R.dimen.M_W_X007), ii.g(context, R.dimen.M_H_X004), 0, ii.g(context, R.dimen.M_H_X003));
            tBSpecificationBtn.setLayoutParams(layoutParams);
            return tBSpecificationBtn;
        }
        return (TBSpecificationBtn) invokeL.objValue;
    }

    public final void E(w85 w85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, w85Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c14122");
            statisticItem.param("fid", w85Var.a).param("tid", w85Var.b).param("uid", w85Var.c).param("obj_type", w85Var.d).param("obj_source", w85Var.e).param("obj_locate", w85Var.f).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, w85Var.h);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void N(v85 v85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, v85Var) == null) {
            if (this.q && v85Var.getType() != EmotionGroupType.LOCAL) {
                return;
            }
            String obj = this.b.getText().toString();
            if (this.r && tu6.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
                return;
            }
            this.y.add(v85Var);
            uu6.b(getContext(), v85Var, this.b);
        }
    }

    public final void O(v85 v85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, v85Var) == null) && v85Var != null && !TextUtils.isEmpty(v85Var.d()) && !TextUtils.isEmpty(v85Var.g())) {
            String obj = this.b.getText().toString();
            if (this.r && tu6.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
                return;
            }
            this.y.add(v85Var);
            uu6.c(getContext(), v85Var, this.b);
        }
    }

    public final void Q(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.i.setText(getResources().getString(R.string.show_spring_festival));
            TBSpecificationBtn tBSpecificationBtn = this.i;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setText(BdBaseApplication.getInst().getResources().getString(R.string.show_spring_festival));
                TBSpecificationButtonConfig styleConfig = this.i.getStyleConfig();
                if (z) {
                    i2 = R.drawable.icon_pure_post_chosen12;
                } else {
                    i2 = R.drawable.icon_pure_post_chose12;
                }
                styleConfig.i(i2, 0, TBSpecificationButtonConfig.IconType.WEBP);
                this.i.getStyleConfig().h(kf5.b(z));
                this.i.a = Boolean.valueOf(z);
            }
        }
    }

    public final void R(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setText(BdBaseApplication.getInst().getResources().getString(R.string.show_virtual_image_state));
                TBSpecificationButtonConfig styleConfig = this.h.getStyleConfig();
                if (z) {
                    i2 = R.drawable.icon_pure_post_chosen12;
                } else {
                    i2 = R.drawable.icon_pure_post_chose12;
                }
                styleConfig.i(i2, 0, TBSpecificationButtonConfig.IconType.WEBP);
                this.h.getStyleConfig().h(kf5.b(z));
                this.h.a = Boolean.valueOf(z);
            }
            jg.a().postDelayed(new e(this, z), 200L);
        }
    }

    public final void y(jd5 jd5Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048614, this, jd5Var) != null) || jd5Var == null) {
            return;
        }
        boolean[] zArr = this.u;
        Object obj = jd5Var.c;
        if (obj != null && (!(obj instanceof String) || !StringUtils.isNull((String) obj))) {
            Object obj2 = jd5Var.c;
            if (!(obj2 instanceof sf5) || !TextUtils.isEmpty(((sf5) obj2).a)) {
                Object obj3 = jd5Var.c;
                if (!(obj3 instanceof SpanGroupManager) || !((SpanGroupManager) obj3).L()) {
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

    public final void z(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, arrayList) == null) {
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
            if (arrayList != null && arrayList.size() > 0) {
                this.b.getText().delete(this.b.getSelectionStart(), this.b.getSelectionEnd());
                SpanGroupEditText spanGroupEditText2 = this.b;
                if (spanGroupEditText2 instanceof SpanGroupEditText) {
                    spanGroupEditText2.b(arrayList);
                }
            }
        }
    }

    public final void F(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            SpanGroupEditText spanGroupEditText = new SpanGroupEditText(context);
            this.b = spanGroupEditText;
            spanGroupEditText.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_PB);
            this.b.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.b.setMaxLines(4);
            this.b.setMinLines(2);
            this.b.setGravity(48);
            this.b.setIncludeFontPadding(false);
            this.b.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
            this.b.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.b.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
            p5a.l(this.b, R.drawable.edittext_cursor);
            this.b.setLineSpacing(ii.g(context, R.dimen.M_T_X002), 1.0f);
            this.b.setPadding(ii.g(context, R.dimen.M_W_X006), ii.g(context, R.dimen.M_H_X004), ii.g(context, R.dimen.M_W_X006), ii.g(context, R.dimen.M_H_X004));
            this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.b.addTextChangedListener(new h(this));
            this.b.setOnTouchListener(new i(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(ii.g(context, R.dimen.M_W_X007), ii.g(context, R.dimen.M_H_X002), ii.g(context, R.dimen.M_W_X006), ii.g(context, R.dimen.M_H_X002));
            this.d.addView(this.b, layoutParams);
        }
    }

    @Override // com.baidu.tieba.vd5
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.b.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0105, 2, i2);
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i2).setShape(0).radius(ii.g(getContext(), R.dimen.tbds21)).into(this.b);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0207, i2);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i2);
            if (i2 == 0) {
                p5a.l(this.b, R.drawable.edittext_cursor);
                this.b.setHintTextColor(SkinManager.getColor(i2, (int) R.color.CAM_X0109));
            } else {
                p5a.l(this.b, R.drawable.edittext_cursor_2);
                this.b.setHintTextColor(SkinManager.getColor(i2, (int) R.color.CAM_X0109));
            }
            this.c.l(i2);
            TBSpecificationBtn tBSpecificationBtn = this.h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.getStyleConfig().k(SkinManager.getColor(R.color.CAM_X0105));
                this.h.getStyleConfig().h(kf5.b(((Boolean) this.h.a).booleanValue()));
                this.h.l(i2);
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.i;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.getStyleConfig().k(SkinManager.getColor(R.color.CAM_X0105));
                this.i.getStyleConfig().h(kf5.b(((Boolean) this.i.a).booleanValue()));
                this.i.l(i2);
            }
            g35.d(this.f).w(R.color.CAM_X0109);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            EMTextView eMTextView = new EMTextView(getContext());
            this.f = eMTextView;
            eMTextView.setId(R.id.comment_content);
            this.f.setVisibility(8);
            this.f.setMaxLines(1);
            this.f.setEllipsize(TextUtils.TruncateAt.END);
            this.f.setPadding(ii.g(getContext(), R.dimen.M_W_X009), ii.g(getContext(), R.dimen.M_H_X005), ii.g(getContext(), R.dimen.M_W_X009), ii.g(getContext(), R.dimen.M_H_X003));
            this.f.setTextSize(0, ii.g(getContext(), R.dimen.T_X08));
            addView(this.f, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.x) {
            this.x = false;
            if (this.b != null && this.d.getVisibility() == 0) {
                this.b.setFocusable(true);
                this.b.setFocusableInTouchMode(true);
                this.b.requestFocus();
                ii.O(getContext(), this.b);
            }
        }
    }

    @Override // com.baidu.tieba.vd5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.b != null && this.d.getVisibility() == 0) {
                this.b.setFocusable(true);
                this.b.setFocusableInTouchMode(true);
                this.b.requestFocus();
                jg.a().postDelayed(new j(this), 200L);
            }
            setVisibility(0);
        }
    }

    public LinearLayout getInputLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.d;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.b;
        }
        return (EditText) invokeV.objValue;
    }

    public TBSpecificationBtn getSendView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.c;
        }
        return (TBSpecificationBtn) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vd5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.vd5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            setVisibility(8);
        }
    }

    public void setHint(CharSequence charSequence) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, charSequence) == null) && (spanGroupEditText = this.b) != null) {
            spanGroupEditText.setHint(charSequence);
        }
    }
}

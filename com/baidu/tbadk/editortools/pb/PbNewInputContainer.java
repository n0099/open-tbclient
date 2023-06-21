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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
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
import com.baidu.tbadk.editortools.pb.PbNewEditorTool;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.bk5;
import com.baidu.tieba.dd5;
import com.baidu.tieba.dga;
import com.baidu.tieba.di5;
import com.baidu.tieba.ed5;
import com.baidu.tieba.fk5;
import com.baidu.tieba.ik5;
import com.baidu.tieba.iz4;
import com.baidu.tieba.li5;
import com.baidu.tieba.ma5;
import com.baidu.tieba.n75;
import com.baidu.tieba.o95;
import com.baidu.tieba.p17;
import com.baidu.tieba.p75;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.q17;
import com.baidu.tieba.tr8;
import com.baidu.tieba.ug;
import com.baidu.tieba.ui5;
import com.baidu.tieba.wi;
import com.baidu.tieba.xg;
import com.baidu.tieba.yh5;
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
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PbNewInputContainer extends LinearLayout implements li5, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int E = 1;
    public static int F = 2;
    public static int G;
    public transient /* synthetic */ FieldHolder $fh;
    public PbNewEditorTool.InputShowType A;
    public List<dd5> B;
    public Runnable C;
    public iz4.c D;
    public EditorTools a;
    public SpanGroupEditText b;
    public TBSpecificationBtn c;
    public LinearLayout d;
    public View e;
    public TextView f;
    public LinearLayout g;
    public TBSpecificationBtn h;
    public TBSpecificationBtn i;
    public FrameLayout j;
    public int k;
    public ik5 l;
    public SpannableStringBuilder m;
    public String n;
    public String o;
    public String p;
    public int q;
    public String r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean[] w;
    public int[] x;
    public int y;
    public boolean z;

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

    @Override // com.baidu.tieba.li5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view2) == null) {
        }
    }

    public void setHasHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        /* loaded from: classes4.dex */
        public class a implements fk5.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ k a;

            public a(k kVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = kVar;
            }

            @Override // com.baidu.tieba.fk5.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.z = false;
                o95.p().A("key_virtual_image_and_state_has_show", false);
                this.a.a.V(false);
            }
        }

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = false;
                if (this.a.b != null && this.a.b.getText().toString().trim().equals("")) {
                    wi.Q(this.a.getContext(), String.format(n75.H(R.string.reply_not_empty), new Object[0]));
                    return;
                }
                int i = 1;
                if (this.a.f != null && this.a.f.getText() != null && this.a.f.getText().length() > 0) {
                    z = true;
                }
                boolean l = o95.p().l("key_virtual_image_and_state_has_show", true);
                ProfileVirtualImageInfo profileVirtualImageInfo = ProfileVirtualImageInfo.getInstance();
                int i2 = 2;
                if (l && (profileVirtualImageInfo == null || profileVirtualImageInfo.getIsSetVirtualImage() != 1)) {
                    StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 21);
                    if (!z) {
                        i2 = 1;
                    }
                    TiebaStatic.log(param.param("obj_type", i2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.a.z = true;
                    fk5.c(new a(this));
                    return;
                }
                StatisticItem param2 = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 11);
                if (z) {
                    i = 2;
                }
                TiebaStatic.log(param2.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.a.H(new yh5(8, -1, null));
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wi.O(this.a.getContext(), this.a.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements q17.i {
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

        @Override // com.baidu.tieba.q17.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.H(new yh5(5, -1, null));
                this.a.requestFocus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements q17.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ik5 a;
        public final /* synthetic */ PbNewInputContainer b;

        public c(PbNewInputContainer pbNewInputContainer, ik5 ik5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer, ik5Var};
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
            this.a = ik5Var;
        }

        @Override // com.baidu.tieba.q17.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, spannableStringBuilder) != null) {
                return;
            }
            this.b.m = spannableStringBuilder;
            this.b.n = this.a.d;
            this.b.o = this.a.e;
            if (TextUtils.isEmpty(this.a.a)) {
                this.b.b.setText("");
                this.b.H(new yh5(5, -1, null));
                this.b.requestFocus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements q17.i {
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

        @Override // com.baidu.tieba.q17.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.H(new yh5(5, -1, null));
                this.a.requestFocus();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                PbNewInputContainer pbNewInputContainer = this.a;
                pbNewInputContainer.H(new yh5(4, -1, pbNewInputContainer.b.getSpanGroupManager()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements iz4.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        @Override // com.baidu.tieba.iz4.c
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setPbReply" : (String) invokeV.objValue;
        }

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

        @Override // com.baidu.tieba.iz4.c
        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                tr8 defaultLog = DefaultLog.getInstance();
                defaultLog.c("PbNewInputContainer", "收到H5通知，更新pb回帖内容：" + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        str = new JSONObject(str).optString("data", str);
                    } catch (Exception e) {
                        tr8 defaultLog2 = DefaultLog.getInstance();
                        defaultLog2.c("PbNewInputContainer", "更新pb回帖内容失败" + e);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        this.a.H(new yh5(6, 27, str));
                        if (this.a.A == PbNewEditorTool.InputShowType.REPLY_BIG_IMAGE) {
                            this.a.H(new yh5(78, -1, str));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                di5.d(view2);
                StatisticItem addParam = new StatisticItem("c15295").param("obj_source", this.a.getObjResourceByFrom()).param("obj_type", "2").addParam("uid", TbadkCoreApplication.getCurrentAccount());
                if (!TextUtils.isEmpty(this.a.r) && !"0".equals(this.a.r)) {
                    addParam.addParam("fid", this.a.r);
                } else if (this.a.a != null && this.a.a.getFid() != 0) {
                    addParam.addParam("fid", String.valueOf(this.a.a.getFid()));
                }
                TiebaStatic.log(addParam);
                this.a.H(new yh5(77, -1, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !((Boolean) this.a.h.a).booleanValue();
                o95.p().A("key_virtual_image_and_state_has_show", z);
                this.a.V(z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ PbNewInputContainer b;

        public i(PbNewInputContainer pbNewInputContainer, boolean z) {
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
                this.b.H(new yh5(67, -1, Boolean.valueOf(this.a)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = !((Boolean) this.a.i.a).booleanValue();
                o95.p().A(o95.t("key_reply_add_bless_enable"), z);
                this.a.U(z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public l(PbNewInputContainer pbNewInputContainer) {
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
                if (!TextUtils.isEmpty(this.a.m)) {
                    if (this.a.l == null) {
                        this.a.l = new ik5();
                    }
                    this.a.l.b = this.a.m.toString();
                    this.a.l.d = this.a.n;
                    this.a.l.e = this.a.o;
                    this.a.l.a = this.a.b.getText().toString();
                    this.a.l.c = this.a.b.getSpanGroupManager();
                    PbNewInputContainer pbNewInputContainer = this.a;
                    pbNewInputContainer.H(new yh5(4, -1, pbNewInputContainer.l));
                    return;
                }
                xg.a().removeCallbacks(this.a.C);
                xg.a().post(this.a.C);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                if (charSequence != null && i2 == 0 && i3 == 1 && charSequence.charAt(i) == '@') {
                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext(), this.a.q, true);
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
                if (this.a.u) {
                    return;
                }
                this.a.u = true;
                if (this.a.b != null && this.a.v != -1) {
                    this.a.b.setSelection(this.a.v);
                    this.a.v = -1;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public m(PbNewInputContainer pbNewInputContainer) {
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
                    this.a.H(new yh5(5, -1, null));
                    this.a.b.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
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

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        this.b.getText().insert(this.b.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    public final void O(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, context) != null) || !bk5.a()) {
            return;
        }
        this.i = G(context);
        U(o95.p().l(o95.t("key_reply_add_bless_enable"), true));
        this.i.setOnClickListener(new j(this));
        this.g.addView(this.i);
    }

    public final void P(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, context) != null) || !ProfileVirtualImageInfo.getInstance().isDisplayVirtual()) {
            return;
        }
        this.h = G(context);
        V(o95.p().l("key_virtual_image_and_state_has_show", true));
        this.h.setOnClickListener(new h(this));
        this.g.addView(this.h);
    }

    public final void Q(yh5 yh5Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, yh5Var) == null) && yh5Var != null && (obj = yh5Var.c) != null && (obj instanceof dd5) && !EmotionGroupType.isSendAsPic(((dd5) obj).getType())) {
            dd5 dd5Var = (dd5) yh5Var.c;
            if (dd5Var.getType() == EmotionGroupType.NET_SUG) {
                S(dd5Var);
            } else {
                R(dd5Var);
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
        this.q = 12004;
        this.s = false;
        this.t = true;
        this.u = true;
        this.v = -1;
        this.w = new boolean[]{false, false, false, false, false};
        this.x = new int[]{0, 0};
        this.y = G;
        this.z = false;
        this.A = PbNewEditorTool.InputShowType.REPLY;
        this.C = new e(this);
        this.D = new f(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07041c));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.g = linearLayout;
        linearLayout.setOrientation(0);
        addView(this.g, new LinearLayout.LayoutParams(-1, -2));
        J(context);
        O(context);
        P(context);
        M();
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.d = linearLayout2;
        linearLayout2.setOrientation(0);
        this.d.setMinimumHeight(wi.g(context, R.dimen.tbds128));
        addView(this.d, new LinearLayout.LayoutParams(-1, -2));
        K(context);
        N(context);
        this.e = new View(getContext());
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, wi.g(getContext(), R.dimen.obfuscated_res_0x7f070198)));
        addView(this.e);
        this.B = new ArrayList();
    }

    @Override // com.baidu.tieba.li5
    public void H(yh5 yh5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, yh5Var) == null) && (editorTools = this.a) != null) {
            editorTools.C(yh5Var);
        }
    }

    public void W(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.p = str;
        }
    }

    @Override // com.baidu.tieba.li5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, editorTools) == null) {
            this.a = editorTools;
        }
    }

    public void setFromType(PbNewEditorTool.InputShowType inputShowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, inputShowType) == null) {
            this.A = inputShowType;
        }
    }

    public void setHint(int i2) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i2) == null) && (spanGroupEditText = this.b) != null) {
            spanGroupEditText.setHint(getContext().getString(i2));
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.s = z;
        }
    }

    @Override // com.baidu.tieba.li5
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.k = i2;
        }
    }

    public void setTransLink(boolean z) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048615, this, z) == null) && (spanGroupEditText = this.b) != null) {
            spanGroupEditText.setTransLink(z);
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.y = i2;
        }
    }

    public void setmAtListRequestResponseCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.q = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getObjResourceByFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            PbNewEditorTool.InputShowType inputShowType = this.A;
            if (inputShowType == PbNewEditorTool.InputShowType.REPLY_FLOOR) {
                return 3;
            }
            if (inputShowType == PbNewEditorTool.InputShowType.REPLY_VIDEO) {
                return 4;
            }
            if (inputShowType == PbNewEditorTool.InputShowType.REPLY_BIG_IMAGE) {
                return 5;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    public LinearLayout getInputLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.d;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.b;
        }
        return (EditText) invokeV.objValue;
    }

    public TBSpecificationBtn getSendView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.c;
        }
        return (TBSpecificationBtn) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.li5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.li5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            iz4.a().d(this.D);
            setVisibility(8);
        }
    }

    public final void B(yh5 yh5Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, yh5Var) != null) || yh5Var == null) {
            return;
        }
        boolean[] zArr = this.w;
        Object obj = yh5Var.c;
        if (obj != null && (!(obj instanceof String) || !StringUtils.isNull((String) obj))) {
            Object obj2 = yh5Var.c;
            if (!(obj2 instanceof ik5) || !TextUtils.isEmpty(((ik5) obj2).a)) {
                Object obj3 = yh5Var.c;
                if (!(obj3 instanceof SpanGroupManager) || !((SpanGroupManager) obj3).L()) {
                    z = true;
                    zArr[0] = z;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(true ^ this.w[0])));
                }
            }
        }
        z = false;
        zArr[0] = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(true ^ this.w[0])));
    }

    public final void D(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
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

    public final void I(ed5 ed5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ed5Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c14122");
            statisticItem.param("fid", ed5Var.a).param("tid", ed5Var.b).param("uid", ed5Var.c).param("obj_type", ed5Var.d).param("obj_source", ed5Var.e).param("obj_locate", ed5Var.f).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, ed5Var.h);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void J(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            FrameLayout a2 = di5.a(context);
            this.j = a2;
            a2.setOnClickListener(new g(this));
            ((FrameLayout.LayoutParams) this.j.getLayoutParams()).setMargins(wi.g(context, R.dimen.M_W_X007), wi.g(context, R.dimen.M_H_X004), 0, wi.g(context, R.dimen.M_H_X003));
            this.j.setVisibility(8);
            this.g.addView(this.j);
        }
    }

    public final void R(dd5 dd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dd5Var) == null) {
            if (this.s && dd5Var.getType() != EmotionGroupType.LOCAL) {
                return;
            }
            String obj = this.b.getText().toString();
            if (this.t && p17.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
                return;
            }
            this.B.add(dd5Var);
            q17.c(getContext(), dd5Var, this.b);
        }
    }

    public final void S(dd5 dd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, dd5Var) == null) && dd5Var != null && !TextUtils.isEmpty(dd5Var.d()) && !TextUtils.isEmpty(dd5Var.g())) {
            String obj = this.b.getText().toString();
            if (this.t && p17.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
                return;
            }
            this.B.add(dd5Var);
            q17.d(getContext(), dd5Var, this.b);
        }
    }

    public final void U(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
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
                this.i.getStyleConfig().h(bk5.b(z));
                this.i.a = Boolean.valueOf(z);
            }
        }
    }

    public final void V(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
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
                this.h.getStyleConfig().h(bk5.b(z));
                this.h.a = Boolean.valueOf(z);
            }
            xg.a().postDelayed(new i(this, z), 200L);
        }
    }

    @Override // com.baidu.tieba.zh5
    public void C(yh5 yh5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yh5Var) != null) || yh5Var == null) {
            return;
        }
        int i2 = yh5Var.a;
        if (i2 != 3) {
            if (i2 != 4) {
                if (i2 != 6) {
                    if (i2 != 17) {
                        if (i2 != 24) {
                            if (i2 != 39) {
                                if (i2 != 70) {
                                    if (i2 != 76) {
                                        if (i2 != 28) {
                                            if (i2 != 29) {
                                                if (i2 != 44) {
                                                    if (i2 != 45) {
                                                        switch (i2) {
                                                            case 9:
                                                                for (dd5 dd5Var : this.B) {
                                                                    I(dd5Var.a());
                                                                }
                                                                this.B.clear();
                                                                if (((Boolean) yh5Var.c).booleanValue()) {
                                                                    this.l = null;
                                                                    this.m = null;
                                                                    this.b.setText((CharSequence) null);
                                                                }
                                                                boolean[] zArr = this.w;
                                                                zArr[0] = false;
                                                                zArr[1] = false;
                                                                zArr[2] = false;
                                                                zArr[3] = false;
                                                                zArr[4] = false;
                                                                int[] iArr = this.x;
                                                                iArr[0] = 0;
                                                                iArr[1] = 0;
                                                                break;
                                                            case 10:
                                                                this.w[2] = true;
                                                                break;
                                                            case 11:
                                                                this.w[2] = false;
                                                                break;
                                                            case 12:
                                                                Object obj = yh5Var.c;
                                                                if (!(obj instanceof ui5)) {
                                                                    return;
                                                                }
                                                                ui5 ui5Var = (ui5) obj;
                                                                WriteImagesInfo writeImagesInfo = ui5Var.a;
                                                                if (writeImagesInfo != null) {
                                                                    if (writeImagesInfo.getChosedFiles() != null) {
                                                                        this.x[0] = ui5Var.a.getChosedFiles().size();
                                                                    } else {
                                                                        this.x[0] = 0;
                                                                    }
                                                                }
                                                                if (this.x[0] > 0) {
                                                                    this.w[1] = true;
                                                                    break;
                                                                } else {
                                                                    this.w[1] = false;
                                                                    break;
                                                                }
                                                            case 13:
                                                                int[] iArr2 = this.x;
                                                                iArr2[0] = iArr2[0] - 1;
                                                                if (iArr2[0] > 0) {
                                                                    this.w[1] = true;
                                                                    break;
                                                                } else {
                                                                    this.w[1] = false;
                                                                    break;
                                                                }
                                                        }
                                                    } else {
                                                        Object obj2 = yh5Var.c;
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
                                                    Object obj3 = yh5Var.c;
                                                    if (obj3 != null) {
                                                        if (obj3 instanceof String) {
                                                            E((String) obj3);
                                                        } else if ((obj3 instanceof ik5) && ((ik5) obj3).a != null) {
                                                            E(((ik5) obj3).a);
                                                        }
                                                    }
                                                }
                                            } else {
                                                this.w[3] = false;
                                            }
                                        }
                                    } else if (this.j != null) {
                                        Object obj4 = yh5Var.c;
                                        if (obj4 instanceof String) {
                                            this.r = (String) obj4;
                                        }
                                        this.j.setVisibility(0);
                                        TextView textView = this.f;
                                        if (textView != null) {
                                            textView.setPadding(textView.getPaddingLeft(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), this.f.getPaddingRight(), this.f.getPaddingBottom());
                                        }
                                    }
                                } else {
                                    Object obj5 = yh5Var.c;
                                    if (obj5 instanceof String) {
                                        long g2 = ug.g((String) obj5, 0L);
                                        if (g2 > 0) {
                                            this.b.setForumId(g2);
                                        }
                                    }
                                }
                            }
                            this.w[3] = true;
                        } else {
                            Q(yh5Var);
                        }
                    } else {
                        Object obj6 = yh5Var.c;
                        if (obj6 != null && (obj6 instanceof ArrayList)) {
                            D((ArrayList) obj6);
                        }
                    }
                } else {
                    Object obj7 = yh5Var.c;
                    if (obj7 == null) {
                        this.b.setText((CharSequence) null);
                    } else if (obj7 instanceof String) {
                        if (TextUtils.isEmpty((String) obj7)) {
                            this.b.setText((CharSequence) null);
                        } else {
                            q17.h(getContext(), (String) yh5Var.c, new b(this));
                        }
                    } else if (obj7 instanceof ik5) {
                        this.m = null;
                        String str2 = this.p;
                        if (str2 != null) {
                            this.b.setHint(str2);
                        }
                        Object obj8 = yh5Var.c;
                        ik5 ik5Var = (ik5) obj8;
                        if (TextUtils.isEmpty(((ik5) obj8).b) && TextUtils.isEmpty(((ik5) yh5Var.c).a)) {
                            this.b.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(ik5Var.b)) {
                                q17.h(getContext(), ik5Var.b, new c(this, ik5Var));
                            }
                            if (!TextUtils.isEmpty(ik5Var.a)) {
                                q17.h(getContext(), ik5Var.a, new d(this));
                            }
                        }
                    }
                    B(yh5Var);
                }
            } else {
                B(yh5Var);
            }
        } else if (this.b.getSelectionStart() > 0) {
            String substring = this.b.getText().toString().substring(0, this.b.getSelectionStart());
            Matcher matcher = p17.b.matcher(substring);
            if (matcher.find()) {
                int length = substring.length() - matcher.replaceFirst("").length();
                String substring2 = this.b.getText().toString().substring(this.b.getSelectionStart() - length, this.b.getSelectionStart());
                Iterator<dd5> it = this.B.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    dd5 next = it.next();
                    if (next.d().equals(substring2)) {
                        this.B.remove(next);
                        break;
                    }
                }
                this.b.getText().delete(this.b.getSelectionStart() - length, this.b.getSelectionStart()).toString();
            } else {
                this.b.getText().delete(this.b.getSelectionStart() - 1, this.b.getSelectionStart());
            }
        }
        F(this.y);
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            if (i2 != G && i2 != F) {
                if (i2 == E) {
                    if (this.w[1]) {
                        this.c.setEnabled(true);
                        return;
                    } else {
                        this.c.setEnabled(false);
                        return;
                    }
                }
                return;
            }
            if (i2 == F) {
                TBSpecificationBtn tBSpecificationBtn = this.h;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.setVisibility(8);
                }
                TBSpecificationBtn tBSpecificationBtn2 = this.i;
                if (tBSpecificationBtn2 != null) {
                    tBSpecificationBtn2.setVisibility(8);
                }
            }
            boolean[] zArr = this.w;
            if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                this.c.setEnabled(false);
            } else {
                this.c.setEnabled(true);
            }
        }
    }

    public final void N(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(80);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            ma5 ma5Var = new ma5();
            ma5Var.r(R.color.CAM_X0302, R.color.CAM_X0101);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.c = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(ma5Var);
            this.c.setEnabled(false);
            this.c.setTextSize(R.dimen.T_X08);
            this.c.setText(context.getString(R.string.pb_send_post));
            this.c.setOnClickListener(new k(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(wi.g(context, R.dimen.tbds150), wi.g(context, R.dimen.tbds75));
            layoutParams2.rightMargin = wi.g(context, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = wi.g(context, R.dimen.M_H_X002);
            linearLayout.addView(this.c, layoutParams2);
            this.d.addView(linearLayout, layoutParams);
        }
    }

    public final TBSpecificationBtn G(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            ma5 ma5Var = new ma5();
            ma5Var.r(R.color.CAM_X0209, SkinManager.getColor(R.color.CAM_X0105));
            ma5Var.y(false);
            ma5Var.h(bk5.b(true));
            ma5Var.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            ma5Var.n(wi.g(getContext(), R.dimen.M_W_X004), wi.g(getContext(), R.dimen.M_W_X004));
            ma5Var.o(wi.g(getContext(), R.dimen.M_H_X002));
            ma5Var.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            tBSpecificationBtn.setConfig(ma5Var);
            tBSpecificationBtn.setTextSize(R.dimen.T_X09);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, wi.g(getContext(), R.dimen.tbds62));
            layoutParams.setMargins(wi.g(context, R.dimen.M_W_X007), wi.g(context, R.dimen.M_H_X004), 0, wi.g(context, R.dimen.M_H_X003));
            tBSpecificationBtn.setLayoutParams(layoutParams);
            return tBSpecificationBtn;
        }
        return (TBSpecificationBtn) invokeL.objValue;
    }

    public final void K(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
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
            dga.l(this.b, R.drawable.edittext_cursor);
            this.b.setLineSpacing(wi.g(context, R.dimen.M_T_X002), 1.0f);
            this.b.setPadding(wi.g(context, R.dimen.M_W_X006), wi.g(context, R.dimen.M_H_X004), wi.g(context, R.dimen.M_W_X006), wi.g(context, R.dimen.M_H_X004));
            this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.b.addTextChangedListener(new l(this));
            this.b.setOnTouchListener(new m(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(wi.g(context, R.dimen.M_W_X007), wi.g(context, R.dimen.M_H_X002), wi.g(context, R.dimen.M_W_X006), wi.g(context, R.dimen.M_H_X002));
            this.d.addView(this.b, layoutParams);
        }
    }

    @Override // com.baidu.tieba.li5
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.b.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0105, 2, i2);
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i2).setShape(0).radius(wi.g(getContext(), R.dimen.tbds21)).into(this.b);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0207, i2);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i2);
            if (i2 == 0) {
                dga.l(this.b, R.drawable.edittext_cursor);
                this.b.setHintTextColor(SkinManager.getColor(i2, (int) R.color.CAM_X0109));
            } else {
                dga.l(this.b, R.drawable.edittext_cursor_2);
                this.b.setHintTextColor(SkinManager.getColor(i2, (int) R.color.CAM_X0109));
            }
            this.c.l(i2);
            TBSpecificationBtn tBSpecificationBtn = this.h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.getStyleConfig().k(SkinManager.getColor(R.color.CAM_X0105));
                this.h.getStyleConfig().h(bk5.b(((Boolean) this.h.a).booleanValue()));
                this.h.l(i2);
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.i;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.getStyleConfig().k(SkinManager.getColor(R.color.CAM_X0105));
                this.i.getStyleConfig().h(bk5.b(((Boolean) this.i.a).booleanValue()));
                this.i.l(i2);
            }
            FrameLayout frameLayout = this.j;
            if (frameLayout != null) {
                p75 d2 = p75.d(frameLayout);
                d2.m(R.dimen.L_X02);
                d2.o(R.string.J_X06);
                d2.f(R.color.CAM_X0209);
            }
            p75.d(this.f).x(R.color.CAM_X0109);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            EMTextView eMTextView = new EMTextView(getContext());
            this.f = eMTextView;
            eMTextView.setId(R.id.comment_content);
            this.f.setVisibility(8);
            this.f.setMaxLines(1);
            this.f.setEllipsize(TextUtils.TruncateAt.END);
            this.f.setPadding(wi.g(getContext(), R.dimen.M_W_X009), wi.g(getContext(), R.dimen.M_H_X005), wi.g(getContext(), R.dimen.M_W_X009), wi.g(getContext(), R.dimen.M_H_X003));
            this.f.setTextSize(0, wi.g(getContext(), R.dimen.T_X08));
            addView(this.f, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.z) {
            this.z = false;
            if (this.b != null && this.d.getVisibility() == 0) {
                this.b.setFocusable(true);
                this.b.setFocusableInTouchMode(true);
                this.b.requestFocus();
                wi.O(getContext(), this.b);
            }
        }
    }

    @Override // com.baidu.tieba.li5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.b != null && this.d.getVisibility() == 0) {
                this.b.setFocusable(true);
                this.b.setFocusableInTouchMode(true);
                this.b.requestFocus();
                xg.a().postDelayed(new a(this), 200L);
            }
            iz4.a().c(this.D);
            setVisibility(0);
            FrameLayout frameLayout = this.j;
            if (frameLayout != null && frameLayout.getVisibility() == 0) {
                StatisticItem addParam = new StatisticItem("c15295").param("obj_source", getObjResourceByFrom()).param("obj_type", "1").addParam("uid", TbadkCoreApplication.getCurrentAccount());
                if (!TextUtils.isEmpty(this.r) && !"0".equals(this.r)) {
                    addParam.addParam("fid", this.r);
                } else {
                    EditorTools editorTools = this.a;
                    if (editorTools != null && editorTools.getFid() != 0) {
                        addParam.addParam("fid", String.valueOf(this.a.getFid()));
                    }
                }
                TiebaStatic.log(addParam);
            }
        }
    }

    public void setHint(CharSequence charSequence) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, charSequence) == null) && (spanGroupEditText = this.b) != null) {
            spanGroupEditText.setHint(charSequence);
        }
    }
}

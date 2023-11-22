package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.content.res.Configuration;
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
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tbadk.editortools.EditorToolsState;
import com.baidu.tbadk.editortools.meme.SpriteMemeShowStrategy;
import com.baidu.tbadk.editortools.meme.pan.SpriteMemePan;
import com.baidu.tbadk.editortools.meme.pan.SpriteMemePanController;
import com.baidu.tbadk.editortools.pb.PbNewEditorTool;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ah5;
import com.baidu.tieba.cg5;
import com.baidu.tieba.de5;
import com.baidu.tieba.ee5;
import com.baidu.tieba.gu4;
import com.baidu.tieba.l07;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.m07;
import com.baidu.tieba.m85;
import com.baidu.tieba.me5;
import com.baidu.tieba.n85;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.r25;
import com.baidu.tieba.tbadkCore.util.AICapacityApplyHelper;
import com.baidu.tieba.tg5;
import com.baidu.tieba.v55;
import com.baidu.tieba.ve5;
import com.baidu.tieba.write.WriteVideoUtil;
import com.baidu.tieba.xg5;
import com.baidu.tieba.yd5;
import com.baidu.tieba.zf5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.SpriteMemeInfo;
/* loaded from: classes5.dex */
public class PbNewInputContainer extends LinearLayout implements me5, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int K = 1;
    public static int L = 2;
    public static int M;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public PbNewEditorTool.InputShowType C;
    public List<m85> D;
    public Runnable E;
    public gu4.d F;
    public gu4.d G;
    public cg5 H;
    public de5 I;
    public View.OnClickListener J;
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
    public SpriteMemePan k;
    public int l;
    public ah5 m;
    public SpannableStringBuilder n;
    public String o;
    public String p;
    public String q;
    public int r;
    public String s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean[] x;
    public int[] y;
    public int z;

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

    @Override // com.baidu.tieba.me5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view2) == null) {
        }
    }

    public void setHasHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        /* loaded from: classes5.dex */
        public class a implements xg5.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.baidu.tieba.xg5.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.A = false;
                SharedPrefHelper.getInstance().putBoolean("key_virtual_image_and_state_has_show", false);
                this.a.a.i0(false);
            }
        }

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
                boolean z = false;
                if (this.a.b != null && this.a.b.getText().toString().trim().equals("")) {
                    BdUtilHelper.showToast(this.a.getContext(), String.format(r25.H(R.string.reply_not_empty), new Object[0]));
                    return;
                }
                int i = 1;
                if (this.a.f != null && this.a.f.getText() != null && this.a.f.getText().length() > 0) {
                    z = true;
                }
                boolean z2 = SharedPrefHelper.getInstance().getBoolean("key_virtual_image_and_state_has_show", true);
                ProfileVirtualImageInfo profileVirtualImageInfo = ProfileVirtualImageInfo.getInstance();
                int i2 = 2;
                if (z2 && (profileVirtualImageInfo == null || profileVirtualImageInfo.getIsSetVirtualImage() != 1)) {
                    StatisticItem param = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 21);
                    if (!z) {
                        i2 = 1;
                    }
                    TiebaStatic.log(param.param("obj_type", i2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                    this.a.A = true;
                    xg5.c(new a(this));
                    return;
                }
                StatisticItem param2 = new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 11);
                if (z) {
                    i = 2;
                }
                TiebaStatic.log(param2.param("obj_type", i).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                this.a.g0(new yd5(8, -1, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.b0();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

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
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && editable != null && editable.toString().trim() != null) {
                if (!TextUtils.isEmpty(this.a.n)) {
                    if (this.a.m == null) {
                        this.a.m = new ah5();
                    }
                    this.a.m.b = this.a.n.toString();
                    this.a.m.d = this.a.o;
                    this.a.m.e = this.a.p;
                    this.a.m.a = this.a.b.getText().toString();
                    this.a.m.c = this.a.b.getSpanGroupManager();
                    PbNewInputContainer pbNewInputContainer = this.a;
                    pbNewInputContainer.g0(new yd5(4, -1, pbNewInputContainer.m));
                } else {
                    SafeHandler.getInst().removeCallbacks(this.a.E);
                    SafeHandler.getInst().post(this.a.E);
                }
                if (!this.a.B) {
                    if (!SpriteMemePanController.a.m(this.a.getContext(), this.a.C)) {
                        return;
                    }
                    String obj = editable.toString();
                    long j = 0;
                    if (this.a.a == null) {
                        str = "";
                        str2 = str;
                    } else {
                        j = this.a.a.getFid();
                        str = this.a.a.getFname();
                        str2 = this.a.a.getTid();
                    }
                    long j2 = j;
                    if (this.a.k != null) {
                        SpriteMemePanController.n(this.a.k, obj, j2, this.a.T(), str, str2);
                        return;
                    }
                    return;
                }
                this.a.B = false;
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                if (charSequence != null && i2 == 0 && i3 == 1 && charSequence.charAt(i) == '@') {
                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext(), this.a.r, true);
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
                if (this.a.v) {
                    return;
                }
                this.a.v = true;
                if (this.a.b != null && this.a.w != -1) {
                    this.a.b.setSelection(this.a.w);
                    this.a.w = -1;
                }
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
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.a.g0(new yd5(5, -1, null));
                    this.a.b.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
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
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                BdUtilHelper.showSoftKeyPad(this.a.getContext(), this.a.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements m07.i {
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

        @Override // com.baidu.tieba.m07.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.g0(new yd5(5, -1, null));
                this.a.requestFocus();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements m07.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ah5 a;
        public final /* synthetic */ PbNewInputContainer b;

        public g(PbNewInputContainer pbNewInputContainer, ah5 ah5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer, ah5Var};
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
            this.a = ah5Var;
        }

        @Override // com.baidu.tieba.m07.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, spannableStringBuilder) != null) {
                return;
            }
            this.b.n = spannableStringBuilder;
            this.b.o = this.a.d;
            this.b.p = this.a.e;
            if (TextUtils.isEmpty(this.a.a)) {
                this.b.b.setText("");
                this.b.g0(new yd5(5, -1, null));
                this.b.requestFocus();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements m07.i {
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

        @Override // com.baidu.tieba.m07.i
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.b.setText(spannableStringBuilder);
                this.a.b.setSelection(this.a.b.getText().length());
                this.a.g0(new yd5(5, -1, null));
                this.a.requestFocus();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class i {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1456817110, "Lcom/baidu/tbadk/editortools/pb/PbNewInputContainer$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1456817110, "Lcom/baidu/tbadk/editortools/pb/PbNewInputContainer$i;");
                    return;
                }
            }
            int[] iArr = new int[EditorToolsState.values().length];
            a = iArr;
            try {
                iArr[EditorToolsState.EDITOR_TOOLS_SHOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EditorToolsState.EDITOR_TOOLS_HIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                PbNewInputContainer pbNewInputContainer = this.a;
                pbNewInputContainer.g0(new yd5(4, -1, pbNewInputContainer.b.getSpanGroupManager()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements gu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        @Override // com.baidu.tieba.gu4.d
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setPbReply" : (String) invokeV.objValue;
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

        @Override // com.baidu.tieba.gu4.c
        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.i("PbNewInputContainer", "收到H5通知，更新pb回帖内容：" + str);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        str = new JSONObject(str).optString("data", str);
                    } catch (Exception e) {
                        TbLog defaultLog2 = DefaultLog.getInstance();
                        defaultLog2.i("PbNewInputContainer", "更新pb回帖内容失败" + e);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        this.a.g0(new yd5(6, 27, str));
                        if (this.a.C == PbNewEditorTool.InputShowType.REPLY_BIG_IMAGE || this.a.C == PbNewEditorTool.InputShowType.REPLY_BIG_IMAGE_FLOOR) {
                            this.a.g0(new yd5(78, -1, str));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements gu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        @Override // com.baidu.tieba.gu4.d
        @NonNull
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "ai.applyCapability" : (String) invokeV.objValue;
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

        @Override // com.baidu.tieba.gu4.c
        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    boolean z = true;
                    if (jSONObject.optInt("status") != 1) {
                        z = false;
                    }
                    this.a.O(z, jSONObject.optString("toastText"));
                } catch (JSONException e) {
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.e("ai.applyCapability", "JSONException:" + e.getMessage());
                    if (!TbadkCoreApplication.getInst().isDebugMode()) {
                        return;
                    }
                    throw new JsonSyntaxException("NotifyDataChanged.applyCapability端能力json解析失败 " + e.getMessage());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements cg5 {
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

        @Override // com.baidu.tieba.cg5
        public boolean a(@NonNull View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            return this.a.b0();
        }
    }

    /* loaded from: classes5.dex */
    public class n implements de5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public n(PbNewInputContainer pbNewInputContainer) {
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

        @Override // com.baidu.tieba.de5
        public void a(@NonNull EditorToolsState editorToolsState, @Nullable SpriteMemeInfo spriteMemeInfo) {
            String str;
            String str2;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, editorToolsState, spriteMemeInfo) == null) {
                if (this.a.a == null) {
                    str = "";
                    str2 = str;
                    j = 0;
                } else {
                    j = this.a.a.getFid();
                    str = this.a.a.getFname();
                    str2 = this.a.a.getTid();
                }
                int i = i.a[editorToolsState.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (GlobalBuildConfig.isDebug()) {
                            throw new IllegalArgumentException("PbNewInputContainer.onEditorToolsStateChanged: " + editorToolsState);
                        }
                    } else if (!SpriteMemePanController.a.m(this.a.getContext(), this.a.C)) {
                    } else {
                        SpriteMemePanController.l(this.a.k, j, str, str2, this.a.T());
                        SpriteMemePanController.d();
                    }
                } else if (!SpriteMemePanController.a.m(this.a.getContext(), this.a.C) || this.a.k == null) {
                } else {
                    if (spriteMemeInfo != null && spriteMemeInfo.meme_id.longValue() > 0) {
                        SpriteMemePanController.f(this.a.k, "use_same", j, this.a.T(), str, str2, true, spriteMemeInfo.query, spriteMemeInfo.meme_id.longValue());
                        SpriteMemePanController.l(this.a.k, j, str, str2, this.a.T());
                    } else if (this.a.T()) {
                        SpriteMemePanController.k(this.a.k, this.a.T(), j, str, str2);
                    } else if (SpriteMemeShowStrategy.a.l()) {
                        SpriteMemePanController.e(this.a.k, "click_recom", j, this.a.T(), str, str2, true);
                        SpriteMemePanController.l(this.a.k, j, str, str2, this.a.T());
                    } else {
                        SpriteMemePanController.k(this.a.k, this.a.T(), j, str, str2);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public o(PbNewInputContainer pbNewInputContainer) {
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
                ee5.d(view2);
                StatisticItem addParam = new StatisticItem("c15295").param("obj_source", this.a.getObjResourceByFrom()).param("obj_type", "2").addParam("uid", TbadkCoreApplication.getCurrentAccount());
                if (!TextUtils.isEmpty(this.a.s) && !"0".equals(this.a.s)) {
                    addParam.addParam("fid", this.a.s);
                } else if (this.a.a != null && this.a.a.getFid() != 0) {
                    addParam.addParam("fid", String.valueOf(this.a.a.getFid()));
                }
                TiebaStatic.log(addParam);
                if (AICapacityApplyHelper.c().b()) {
                    this.a.g0(new yd5(77, -1, null));
                } else {
                    AICapacityApplyHelper.c().d(AICapacityApplyHelper.capacityApplyType.AI_WRITE_REPLY);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public p(PbNewInputContainer pbNewInputContainer) {
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
                SharedPrefHelper.getInstance().putBoolean("key_virtual_image_and_state_has_show", z);
                this.a.i0(z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ PbNewInputContainer b;

        public q(PbNewInputContainer pbNewInputContainer, boolean z) {
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
                this.b.g0(new yd5(67, -1, Boolean.valueOf(this.a)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbNewInputContainer a;

        public r(PbNewInputContainer pbNewInputContainer) {
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
                SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reply_add_bless_enable"), z);
                this.a.h0(z);
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

    public final void K(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        this.b.getText().insert(this.b.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    public final void U(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            FrameLayout a2 = ee5.a(context);
            this.j = a2;
            a2.setOnClickListener(new o(this));
            ((FrameLayout.LayoutParams) this.j.getLayoutParams()).setMargins(BdUtilHelper.getDimens(context, R.dimen.M_W_X007), BdUtilHelper.getDimens(context, R.dimen.M_H_X004), 0, BdUtilHelper.getDimens(context, R.dimen.M_H_X003));
            this.j.setVisibility(8);
        }
    }

    public final void Y(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, context) != null) || !tg5.a()) {
            return;
        }
        this.i = Q(context);
        h0(SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_reply_add_bless_enable"), true));
        this.i.setOnClickListener(new r(this));
    }

    public final void a0(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, context) != null) || !ProfileVirtualImageInfo.getInstance().isDisplayVirtual()) {
            return;
        }
        this.h = Q(context);
        i0(SharedPrefHelper.getInstance().getBoolean("key_virtual_image_and_state_has_show", true));
        this.h.setOnClickListener(new p(this));
    }

    public final void c0(yd5 yd5Var) {
        Object obj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, yd5Var) == null) && yd5Var != null && (obj = yd5Var.c) != null && (obj instanceof m85) && !EmotionGroupType.isSendAsPic(((m85) obj).g())) {
            m85 m85Var = (m85) yd5Var.c;
            if (m85Var.g() == EmotionGroupType.NET_SUG) {
                e0(m85Var);
            } else {
                d0(m85Var);
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
        this.r = 12004;
        this.t = false;
        this.u = true;
        this.v = true;
        this.w = -1;
        this.x = new boolean[]{false, false, false, false, false};
        this.y = new int[]{0, 0};
        this.z = M;
        this.A = false;
        this.B = false;
        this.C = PbNewEditorTool.InputShowType.REPLY;
        this.E = new j(this);
        this.F = new k(this);
        this.G = new l(this);
        this.H = new m(this);
        this.I = new n(this);
        this.J = new a(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070422));
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.g = linearLayout;
        linearLayout.setOrientation(0);
        addView(this.g, new LinearLayout.LayoutParams(-1, -2));
        Z(context);
        U(context);
        Y(context);
        a0(context);
        W();
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.d = linearLayout2;
        linearLayout2.setOrientation(0);
        this.d.setMinimumHeight(BdUtilHelper.getDimens(context, R.dimen.tbds128));
        addView(this.d, new LinearLayout.LayoutParams(-1, -2));
        V(context);
        X(context);
        this.e = new View(getContext());
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, BdUtilHelper.getDimens(getContext(), R.dimen.obfuscated_res_0x7f070198)));
        addView(this.e);
        this.D = new ArrayList();
    }

    public final void N(@Nullable View view2, @NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, view2, viewGroup) == null) && view2 != null) {
            viewGroup.addView(view2);
        }
    }

    public final void M(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, viewGroup) == null) {
            N(this.j, viewGroup);
            N(this.i, viewGroup);
            N(this.h, viewGroup);
        }
    }

    public final void Z(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            this.k = new SpriteMemePan(context);
            this.k.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        }
    }

    @Override // com.baidu.tieba.me5
    public void g0(yd5 yd5Var) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, yd5Var) == null) && (editorTools = this.a) != null) {
            editorTools.K(yd5Var);
        }
    }

    public void j0(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
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

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            L();
        }
    }

    public void setDefaultHint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.q = str;
        }
    }

    @Override // com.baidu.tieba.me5
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, editorTools) == null) {
            EditorTools editorTools2 = this.a;
            if (editorTools2 != null) {
                editorTools2.H(this.I);
            }
            this.a = editorTools;
            if (editorTools != null) {
                editorTools.e(this.I);
                this.a.setOnInterceptCancelClickListener(this.H);
                this.a.setOnLauncherClickListener(this.J);
            }
        }
    }

    public void setFromType(PbNewEditorTool.InputShowType inputShowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, inputShowType) == null) {
            this.C = inputShowType;
            L();
        }
    }

    public void setHint(int i2) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048619, this, i2) == null) && (spanGroupEditText = this.b) != null) {
            spanGroupEditText.setHint(getContext().getString(i2));
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.t = z;
        }
    }

    @Override // com.baidu.tieba.me5
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.l = i2;
        }
    }

    public void setTransLink(boolean z) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048623, this, z) == null) && (spanGroupEditText = this.b) != null) {
            spanGroupEditText.setTransLink(z);
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            this.z = i2;
        }
    }

    public void setmAtListRequestResponseCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.r = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getObjResourceByFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            PbNewEditorTool.InputShowType inputShowType = this.C;
            if (inputShowType == PbNewEditorTool.InputShowType.REPLY_FLOOR) {
                return 3;
            }
            if (inputShowType == PbNewEditorTool.InputShowType.REPLY_VIDEO) {
                return 4;
            }
            if (inputShowType != PbNewEditorTool.InputShowType.REPLY_BIG_IMAGE && inputShowType != PbNewEditorTool.InputShowType.REPLY_BIG_IMAGE_FLOOR) {
                return 2;
            }
            return 5;
        }
        return invokeV.intValue;
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.b;
            if (spanGroupEditText != null && spanGroupEditText.getText() != null && !TextUtils.isEmpty(this.b.getText().toString())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public LinearLayout getInputLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.d;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.b;
        }
        return (EditText) invokeV.objValue;
    }

    public TBSpecificationBtn getSendView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.c;
        }
        return (TBSpecificationBtn) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.me5
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.me5
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            gu4.a().e(this.F);
            gu4.a().e(this.G);
            SpriteMemePanController.s();
            setVisibility(8);
        }
    }

    public final void I(yd5 yd5Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, yd5Var) != null) || yd5Var == null) {
            return;
        }
        boolean[] zArr = this.x;
        Object obj = yd5Var.c;
        if (obj != null && (!(obj instanceof String) || !StringUtils.isNull((String) obj))) {
            Object obj2 = yd5Var.c;
            if (!(obj2 instanceof ah5) || !TextUtils.isEmpty(((ah5) obj2).a)) {
                Object obj3 = yd5Var.c;
                if (!(obj3 instanceof SpanGroupManager) || !((SpanGroupManager) obj3).M()) {
                    z = true;
                    zArr[0] = z;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(true ^ this.x[0])));
                }
            }
        }
        z = false;
        zArr[0] = z;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921706, Boolean.valueOf(true ^ this.x[0])));
    }

    public final void J(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList) == null) {
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

    public final void R(n85 n85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, n85Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c14122");
            statisticItem.param("fid", n85Var.a).param("tid", n85Var.b).param("uid", n85Var.c).param("obj_type", n85Var.d).param("obj_source", n85Var.e).param("obj_locate", n85Var.f).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, n85Var.h);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void d0(m85 m85Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, m85Var) == null) {
            if (this.t && m85Var.g() != EmotionGroupType.LOCAL) {
                return;
            }
            String obj = this.b.getText().toString();
            if (this.u && l07.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
                return;
            }
            this.D.add(m85Var);
            m07.c(getContext(), m85Var, this.b);
        }
    }

    public final void e0(m85 m85Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, m85Var) == null) && m85Var != null && !TextUtils.isEmpty(m85Var.d()) && !TextUtils.isEmpty(m85Var.h())) {
            String obj = this.b.getText().toString();
            if (this.u && l07.a(obj) >= 10 && getContext() != null) {
                CustomToast.newInstance().showToast(R.string.too_many_face);
                return;
            }
            this.D.add(m85Var);
            m07.d(getContext(), m85Var, this.b);
        }
    }

    public final void h0(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
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
                styleConfig.j(i2, 0, TBSpecificationButtonConfig.IconType.WEBP);
                this.i.getStyleConfig().i(tg5.b(z));
                this.i.a = Boolean.valueOf(z);
            }
        }
    }

    public final void i0(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            TBSpecificationBtn tBSpecificationBtn = this.h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setText(BdBaseApplication.getInst().getResources().getString(R.string.show_virtual_image_state));
                TBSpecificationButtonConfig styleConfig = this.h.getStyleConfig();
                if (z) {
                    i2 = R.drawable.icon_pure_post_chosen12;
                } else {
                    i2 = R.drawable.icon_pure_post_chose12;
                }
                styleConfig.j(i2, 0, TBSpecificationButtonConfig.IconType.WEBP);
                this.h.getStyleConfig().i(tg5.b(z));
                this.h.a = Boolean.valueOf(z);
            }
            SafeHandler.getInst().postDelayed(new q(this, z), 200L);
        }
    }

    public final void L() {
        LinearLayout linearLayout;
        PbNewEditorTool.InputShowType inputShowType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (linearLayout = this.g) == null) {
            return;
        }
        linearLayout.removeAllViews();
        if (zf5.isOn() && ((inputShowType = this.C) == PbNewEditorTool.InputShowType.REPLY || inputShowType == PbNewEditorTool.InputShowType.REPLY_BIG_IMAGE || inputShowType == PbNewEditorTool.InputShowType.REPLY_VIDEO)) {
            if ((UtilHelper.isFoldScreen() || UtilHelper.isLargeScreen(getContext())) && this.C == PbNewEditorTool.InputShowType.REPLY_VIDEO) {
                M(this.g);
                return;
            } else {
                N(this.k, this.g);
                return;
            }
        }
        M(this.g);
    }

    public final boolean b0() {
        InterceptResult invokeV;
        SpriteMemePan spriteMemePan;
        long j2;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (!SpriteMemePanController.a.m(getContext(), this.C) || (spriteMemePan = this.k) == null) {
                return false;
            }
            boolean a2 = spriteMemePan.a();
            if (a2) {
                EditorTools editorTools = this.a;
                if (editorTools != null) {
                    long fid = editorTools.getFid();
                    String fname = this.a.getFname();
                    j2 = fid;
                    str2 = this.a.getTid();
                    str = fname;
                } else {
                    j2 = 0;
                    str = "";
                    str2 = str;
                }
                SpriteMemePanController.k(this.k, T(), j2, str, str2);
            }
            return a2;
        }
        return invokeV.booleanValue;
    }

    public final void O(boolean z, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048582, this, z, str) == null) {
            if (z) {
                AICapacityApplyHelper.c().k(true);
            } else if (!TextUtils.isEmpty(str)) {
                if (!TbadkCoreApplication.getInst().isMainProcess(false)) {
                    AICapacityApplyHelper.c().e(str);
                } else {
                    AICapacityApplyHelper.c().j(str);
                }
            }
        }
    }

    public void P(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            if (i2 != M && i2 != L) {
                if (i2 == K) {
                    if (this.x[1]) {
                        this.c.setEnabled(true);
                        return;
                    } else {
                        this.c.setEnabled(false);
                        return;
                    }
                }
                return;
            }
            if (i2 == L) {
                TBSpecificationBtn tBSpecificationBtn = this.h;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.setVisibility(8);
                }
                TBSpecificationBtn tBSpecificationBtn2 = this.i;
                if (tBSpecificationBtn2 != null) {
                    tBSpecificationBtn2.setVisibility(8);
                }
            }
            boolean[] zArr = this.x;
            if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                this.c.setEnabled(false);
            } else {
                this.c.setEnabled(true);
            }
        }
    }

    public final void X(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, context) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(80);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            v55 v55Var = new v55();
            v55Var.s(R.color.CAM_X0302, R.color.CAM_X0101);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.c = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(v55Var);
            this.c.setEnabled(false);
            this.c.setTextSize(R.dimen.T_X08);
            this.c.setText(context.getString(R.string.pb_send_post));
            this.c.setOnClickListener(new b(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(context, R.dimen.tbds150), BdUtilHelper.getDimens(context, R.dimen.tbds75));
            layoutParams2.rightMargin = BdUtilHelper.getDimens(context, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = BdUtilHelper.getDimens(context, R.dimen.M_H_X002);
            linearLayout.addView(this.c, layoutParams2);
            this.d.addView(linearLayout, layoutParams);
        }
    }

    public final TBSpecificationBtn Q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            v55 v55Var = new v55();
            v55Var.s(R.color.CAM_X0209, SkinManager.getColor(R.color.CAM_X0105));
            v55Var.y(false);
            v55Var.i(tg5.b(true));
            v55Var.g(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            v55Var.o(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X004));
            v55Var.p(BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X002));
            v55Var.h(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            tBSpecificationBtn.setConfig(v55Var);
            tBSpecificationBtn.setTextSize(R.dimen.T_X09);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, BdUtilHelper.getDimens(getContext(), R.dimen.tbds62));
            layoutParams.setMargins(BdUtilHelper.getDimens(context, R.dimen.M_W_X007), BdUtilHelper.getDimens(context, R.dimen.M_H_X004), 0, BdUtilHelper.getDimens(context, R.dimen.M_H_X003));
            tBSpecificationBtn.setLayoutParams(layoutParams);
            return tBSpecificationBtn;
        }
        return (TBSpecificationBtn) invokeL.objValue;
    }

    @Override // com.baidu.tieba.zd5
    public void S(yd5 yd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, yd5Var) != null) || yd5Var == null) {
            return;
        }
        int i2 = yd5Var.a;
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
                                                                for (m85 m85Var : this.D) {
                                                                    R(m85Var.a());
                                                                }
                                                                this.D.clear();
                                                                if (((Boolean) yd5Var.c).booleanValue()) {
                                                                    this.m = null;
                                                                    this.n = null;
                                                                    this.b.setText((CharSequence) null);
                                                                }
                                                                boolean[] zArr = this.x;
                                                                zArr[0] = false;
                                                                zArr[1] = false;
                                                                zArr[2] = false;
                                                                zArr[3] = false;
                                                                zArr[4] = false;
                                                                int[] iArr = this.y;
                                                                iArr[0] = 0;
                                                                iArr[1] = 0;
                                                                break;
                                                            case 10:
                                                                this.x[2] = true;
                                                                break;
                                                            case 11:
                                                                this.x[2] = false;
                                                                break;
                                                            case 12:
                                                                Object obj = yd5Var.c;
                                                                if (!(obj instanceof ve5)) {
                                                                    return;
                                                                }
                                                                ve5 ve5Var = (ve5) obj;
                                                                WriteImagesInfo writeImagesInfo = ve5Var.a;
                                                                if (writeImagesInfo != null) {
                                                                    if (writeImagesInfo.getChosedFiles() != null) {
                                                                        this.y[0] = ve5Var.a.getChosedFiles().size();
                                                                    } else {
                                                                        this.y[0] = 0;
                                                                    }
                                                                }
                                                                if (this.y[0] > 0) {
                                                                    this.x[1] = true;
                                                                    break;
                                                                } else {
                                                                    this.x[1] = false;
                                                                    break;
                                                                }
                                                            case 13:
                                                                int[] iArr2 = this.y;
                                                                iArr2[0] = iArr2[0] - 1;
                                                                if (iArr2[0] > 0) {
                                                                    this.x[1] = true;
                                                                    break;
                                                                } else {
                                                                    this.x[1] = false;
                                                                    break;
                                                                }
                                                        }
                                                    } else {
                                                        Object obj2 = yd5Var.c;
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
                                                    Object obj3 = yd5Var.c;
                                                    if (obj3 != null) {
                                                        if (obj3 instanceof String) {
                                                            K((String) obj3);
                                                        } else if ((obj3 instanceof ah5) && ((ah5) obj3).a != null) {
                                                            K(((ah5) obj3).a);
                                                        }
                                                    }
                                                }
                                            } else {
                                                this.x[3] = false;
                                            }
                                        }
                                    } else if (this.j != null) {
                                        Object obj4 = yd5Var.c;
                                        if (obj4 instanceof String) {
                                            this.s = (String) obj4;
                                        }
                                        this.j.setVisibility(0);
                                        TextView textView = this.f;
                                        if (textView != null) {
                                            textView.setPadding(textView.getPaddingLeft(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), this.f.getPaddingRight(), this.f.getPaddingBottom());
                                        }
                                    }
                                } else {
                                    Object obj5 = yd5Var.c;
                                    if (obj5 instanceof String) {
                                        long j2 = JavaTypesHelper.toLong((String) obj5, 0L);
                                        if (j2 > 0) {
                                            this.b.setForumId(j2);
                                        }
                                    }
                                }
                            }
                            this.x[3] = true;
                        } else {
                            c0(yd5Var);
                        }
                    } else {
                        Object obj6 = yd5Var.c;
                        if (obj6 != null && (obj6 instanceof ArrayList)) {
                            J((ArrayList) obj6);
                        }
                    }
                } else {
                    Object obj7 = yd5Var.c;
                    if (obj7 == null) {
                        this.b.setText((CharSequence) null);
                    } else if (obj7 instanceof String) {
                        this.B = true;
                        if (TextUtils.isEmpty((String) obj7)) {
                            this.b.setText((CharSequence) null);
                        } else {
                            m07.h(getContext(), (String) yd5Var.c, new f(this));
                        }
                    } else if (obj7 instanceof ah5) {
                        this.n = null;
                        String str2 = this.q;
                        if (str2 != null) {
                            this.b.setHint(str2);
                        }
                        Object obj8 = yd5Var.c;
                        ah5 ah5Var = (ah5) obj8;
                        if (TextUtils.isEmpty(((ah5) obj8).b) && TextUtils.isEmpty(((ah5) yd5Var.c).a)) {
                            this.b.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(ah5Var.b)) {
                                m07.h(getContext(), ah5Var.b, new g(this, ah5Var));
                            }
                            if (!TextUtils.isEmpty(ah5Var.a)) {
                                m07.h(getContext(), ah5Var.a, new h(this));
                            }
                        }
                    }
                    I(yd5Var);
                }
            } else {
                I(yd5Var);
            }
        } else if (this.b.getSelectionStart() > 0) {
            String substring = this.b.getText().toString().substring(0, this.b.getSelectionStart());
            Matcher matcher = l07.b.matcher(substring);
            if (matcher.find()) {
                int length = substring.length() - matcher.replaceFirst("").length();
                String substring2 = this.b.getText().toString().substring(this.b.getSelectionStart() - length, this.b.getSelectionStart());
                Iterator<m85> it = this.D.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    m85 next = it.next();
                    if (next.d().equals(substring2)) {
                        this.D.remove(next);
                        break;
                    }
                }
                this.b.getText().delete(this.b.getSelectionStart() - length, this.b.getSelectionStart()).toString();
            } else {
                this.b.getText().delete(this.b.getSelectionStart() - 1, this.b.getSelectionStart());
            }
        }
        P(this.z);
    }

    public final void V(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, context) == null) {
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
            WriteVideoUtil.setCursorColor(this.b, R.drawable.edittext_cursor);
            this.b.setLineSpacing(BdUtilHelper.getDimens(context, R.dimen.M_T_X002), 1.0f);
            this.b.setPadding(BdUtilHelper.getDimens(context, R.dimen.M_W_X006), BdUtilHelper.getDimens(context, R.dimen.M_H_X004), BdUtilHelper.getDimens(context, R.dimen.M_W_X006), BdUtilHelper.getDimens(context, R.dimen.M_H_X004));
            this.b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.b.addTextChangedListener(new c(this));
            this.b.setOnTouchListener(new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(BdUtilHelper.getDimens(context, R.dimen.M_W_X007), BdUtilHelper.getDimens(context, R.dimen.M_H_X002), BdUtilHelper.getDimens(context, R.dimen.M_W_X006), BdUtilHelper.getDimens(context, R.dimen.M_H_X002));
            this.d.addView(this.b, layoutParams);
        }
    }

    @Override // com.baidu.tieba.me5
    public void onChangeSkinType(int i2) {
        SpriteMemePan spriteMemePan;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.b.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(this.b, R.color.CAM_X0105, 2, i2);
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i2).setShape(0).radius(BdUtilHelper.getDimens(getContext(), R.dimen.tbds21)).into(this.b);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0207, i2);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i2);
            if (i2 == 0) {
                WriteVideoUtil.setCursorColor(this.b, R.drawable.edittext_cursor);
                this.b.setHintTextColor(SkinManager.getColor(i2, (int) R.color.CAM_X0109));
            } else {
                WriteVideoUtil.setCursorColor(this.b, R.drawable.edittext_cursor_2);
                this.b.setHintTextColor(SkinManager.getColor(i2, (int) R.color.CAM_X0109));
            }
            this.c.l(i2);
            TBSpecificationBtn tBSpecificationBtn = this.h;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.getStyleConfig().l(SkinManager.getColor(R.color.CAM_X0105));
                this.h.getStyleConfig().i(tg5.b(((Boolean) this.h.a).booleanValue()));
                this.h.l(i2);
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.i;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.getStyleConfig().l(SkinManager.getColor(R.color.CAM_X0105));
                this.i.getStyleConfig().i(tg5.b(((Boolean) this.i.a).booleanValue()));
                this.i.l(i2);
            }
            FrameLayout frameLayout = this.j;
            if (frameLayout != null) {
                EMManager.from(frameLayout).setBorderWidth(R.dimen.L_X02).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0209);
            }
            EMManager.from(this.f).setTextColor(R.color.CAM_X0109);
            if (SpriteMemePanController.a.m(getContext(), this.C) && (spriteMemePan = this.k) != null) {
                spriteMemePan.b();
            }
        }
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            EMTextView eMTextView = new EMTextView(getContext());
            this.f = eMTextView;
            eMTextView.setId(R.id.comment_content);
            this.f.setVisibility(8);
            this.f.setMaxLines(1);
            this.f.setEllipsize(TextUtils.TruncateAt.END);
            this.f.setPadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X009), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X005), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X009), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X003));
            this.f.setTextSize(0, BdUtilHelper.getDimens(getContext(), R.dimen.T_X08));
            addView(this.f, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    @Override // com.baidu.tieba.me5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            if (this.b != null && this.d.getVisibility() == 0) {
                this.b.setFocusable(true);
                this.b.setFocusableInTouchMode(true);
                this.b.requestFocus();
                SafeHandler.getInst().postDelayed(new e(this), 200L);
            }
            gu4.a().e(this.F);
            gu4.a().c(this.F);
            gu4.a().e(this.G);
            gu4.a().c(this.G);
            setVisibility(0);
            FrameLayout frameLayout = this.j;
            if (frameLayout != null && frameLayout.getVisibility() == 0) {
                StatisticItem addParam = new StatisticItem("c15295").param("obj_source", getObjResourceByFrom()).param("obj_type", "1").addParam("uid", TbadkCoreApplication.getCurrentAccount());
                if (!TextUtils.isEmpty(this.s) && !"0".equals(this.s)) {
                    addParam.addParam("fid", this.s);
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

    public void f0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.A) {
            this.A = false;
            if (this.b != null && this.d.getVisibility() == 0) {
                this.b.setFocusable(true);
                this.b.setFocusableInTouchMode(true);
                this.b.requestFocus();
                BdUtilHelper.showSoftKeyPad(getContext(), this.b);
            }
        }
    }

    public void setHint(CharSequence charSequence) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, charSequence) == null) && (spanGroupEditText = this.b) != null) {
            spanGroupEditText.setHint(charSequence);
        }
    }
}

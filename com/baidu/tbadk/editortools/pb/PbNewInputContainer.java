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
import b.a.e.f.p.l;
import b.a.q0.t.c.w;
import b.a.q0.t.c.x;
import b.a.q0.x.n;
import b.a.q0.x.x.j;
import b.a.r0.e4.i;
import b.a.r0.r0.b;
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
/* loaded from: classes8.dex */
public class PbNewInputContainer extends LinearLayout implements n, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int ALL = 0;
    public static int PICTURE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f46740e;

    /* renamed from: f  reason: collision with root package name */
    public SpanGroupEditText f46741f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f46742g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f46743h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f46744i;
    public View j;
    public TextView k;
    public int l;
    public j m;
    public SpannableStringBuilder n;
    public String o;
    public String p;
    public String q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean[] w;
    public int[] x;
    public int y;
    public List<w> z;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f46745e;

        public a(PbNewInputContainer pbNewInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46745e = pbNewInputContainer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f46745e.f46741f == null) {
                return;
            }
            PbNewInputContainer pbNewInputContainer = this.f46745e;
            pbNewInputContainer.sendAction(new b.a.q0.x.a(4, -1, pbNewInputContainer.f46741f.getSpanGroupManager()));
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f46746e;

        public b(PbNewInputContainer pbNewInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46746e = pbNewInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f46746e.sendAction(new b.a.q0.x.a(8, -1, null));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f46747e;

        public c(PbNewInputContainer pbNewInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46747e = pbNewInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null || editable.toString().trim() == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.f46747e.n)) {
                if (this.f46747e.m == null) {
                    this.f46747e.m = new j();
                }
                this.f46747e.m.f15058b = this.f46747e.n.toString();
                this.f46747e.m.f15060d = this.f46747e.o;
                this.f46747e.m.f15061e = this.f46747e.p;
                this.f46747e.m.f15057a = this.f46747e.f46741f.getText().toString();
                this.f46747e.m.f15059c = this.f46747e.f46741f.getSpanGroupManager();
                PbNewInputContainer pbNewInputContainer = this.f46747e;
                pbNewInputContainer.sendAction(new b.a.q0.x.a(4, -1, pbNewInputContainer.m));
                return;
            }
            b.a.e.f.m.e.a().removeCallbacks(this.f46747e.A);
            b.a.e.f.m.e.a().post(this.f46747e.A);
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
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                if (charSequence != null && i3 == 0 && i4 == 1 && charSequence.charAt(i2) == '@') {
                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.f46747e.getContext(), this.f46747e.r, true);
                    if (this.f46747e.f46741f != null) {
                        atListActivityConfig.setSelectedAtList(this.f46747e.f46741f.getAtDataInText());
                    }
                    if (this.f46747e.f46740e != null) {
                        atListActivityConfig.setFromTid(this.f46747e.f46740e.getTid());
                        atListActivityConfig.setFromFid(String.valueOf(this.f46747e.f46740e.getFid()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f46747e.f46740e != null) {
                        statisticItem.addParam("tid", this.f46747e.f46740e.getTid());
                        statisticItem.addParam("fid", this.f46747e.f46740e.getFid());
                    }
                    TiebaStatic.log(statisticItem);
                }
                if (this.f46747e.u) {
                    return;
                }
                this.f46747e.u = true;
                if (this.f46747e.f46741f == null || this.f46747e.v == -1) {
                    return;
                }
                this.f46747e.f46741f.setSelection(this.f46747e.v);
                this.f46747e.v = -1;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f46748e;

        public d(PbNewInputContainer pbNewInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46748e = pbNewInputContainer;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f46748e.sendAction(new b.a.q0.x.a(5, -1, null));
                    this.f46748e.f46741f.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f46749a;

        public e(PbNewInputContainer pbNewInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46749a = pbNewInputContainer;
        }

        @Override // b.a.r0.r0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.f46749a.f46741f.setText(spannableStringBuilder);
                this.f46749a.f46741f.setSelection(this.f46749a.f46741f.getText().length());
                this.f46749a.sendAction(new b.a.q0.x.a(5, -1, null));
                this.f46749a.requestFocus();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f46750a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f46751b;

        public f(PbNewInputContainer pbNewInputContainer, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46751b = pbNewInputContainer;
            this.f46750a = jVar;
        }

        @Override // b.a.r0.r0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.f46751b.n = spannableStringBuilder;
                this.f46751b.o = this.f46750a.f15060d;
                this.f46751b.p = this.f46750a.f15061e;
                if (TextUtils.isEmpty(this.f46750a.f15057a)) {
                    this.f46751b.f46741f.setText("");
                    this.f46751b.sendAction(new b.a.q0.x.a(5, -1, null));
                    this.f46751b.requestFocus();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f46752a;

        public g(PbNewInputContainer pbNewInputContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbNewInputContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46752a = pbNewInputContainer;
        }

        @Override // b.a.r0.r0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.f46752a.f46741f.setText(spannableStringBuilder);
                this.f46752a.f46741f.setSelection(this.f46752a.f46741f.getText().length());
                this.f46752a.sendAction(new b.a.q0.x.a(5, -1, null));
                this.f46752a.requestFocus();
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

    public final void A(w wVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, wVar) == null) || wVar == null || TextUtils.isEmpty(wVar.c()) || TextUtils.isEmpty(wVar.f())) {
            return;
        }
        String obj = this.f46741f.getText().toString();
        if (this.t && b.a.r0.r0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
            return;
        }
        this.z.add(wVar);
        b.a.r0.r0.b.c(getContext(), wVar, this.f46741f);
    }

    public void applyType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 == ALL) {
                boolean[] zArr = this.w;
                if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                    this.f46742g.setEnabled(false);
                } else {
                    this.f46742g.setEnabled(true);
                }
            } else if (i2 == PICTURE) {
                if (this.w[1]) {
                    this.f46742g.setEnabled(true);
                } else {
                    this.f46742g.setEnabled(false);
                }
            }
        }
    }

    @Override // b.a.q0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f46741f != null && this.f46744i.getVisibility() == 0) {
                this.f46741f.setFocusable(true);
                this.f46741f.setFocusableInTouchMode(true);
                this.f46741f.requestFocus();
                l.K(getContext(), this.f46741f);
            }
            setVisibility(0);
        }
    }

    public LinearLayout getInputLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f46744i : (LinearLayout) invokeV.objValue;
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f46741f : (EditText) invokeV.objValue;
    }

    public TBSpecificationBtn getSendView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f46742g : (TBSpecificationBtn) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    @Override // b.a.q0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.intValue;
    }

    @Override // b.a.q0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setVisibility(8);
        }
    }

    @Override // b.a.q0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // b.a.q0.x.b
    public void onAction(b.a.q0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f14962a;
        if (i2 != 3) {
            if (i2 == 4) {
                q(aVar);
            } else if (i2 == 6) {
                Object obj = aVar.f14964c;
                if (obj == null) {
                    this.f46741f.setText((CharSequence) null);
                } else if (obj instanceof String) {
                    if (TextUtils.isEmpty((String) obj)) {
                        this.f46741f.setText((CharSequence) null);
                    } else {
                        b.a.r0.r0.b.d(getContext(), (String) aVar.f14964c, new e(this));
                    }
                } else if (obj instanceof j) {
                    this.n = null;
                    String str = this.q;
                    if (str != null) {
                        this.f46741f.setHint(str);
                    }
                    Object obj2 = aVar.f14964c;
                    j jVar = (j) obj2;
                    if (TextUtils.isEmpty(((j) obj2).f15058b) && TextUtils.isEmpty(((j) aVar.f14964c).f15057a)) {
                        this.f46741f.setText((CharSequence) null);
                    } else {
                        if (!TextUtils.isEmpty(jVar.f15058b)) {
                            b.a.r0.r0.b.d(getContext(), jVar.f15058b, new f(this, jVar));
                        }
                        if (!TextUtils.isEmpty(jVar.f15057a)) {
                            b.a.r0.r0.b.d(getContext(), jVar.f15057a, new g(this));
                        }
                    }
                }
                q(aVar);
            } else if (i2 == 17) {
                Object obj3 = aVar.f14964c;
                if (obj3 != null && (obj3 instanceof ArrayList)) {
                    r((ArrayList) obj3);
                }
            } else if (i2 != 24) {
                if (i2 != 39) {
                    if (i2 != 19) {
                        if (i2 == 20) {
                            updateLocationVisibility(true);
                            this.f46743h.setText(getContext().getString(R.string.location_where_are_you));
                        } else if (i2 != 28) {
                            if (i2 == 29) {
                                this.w[3] = false;
                            } else if (i2 == 44) {
                                Object obj4 = aVar.f14964c;
                                if (obj4 != null) {
                                    if (obj4 instanceof String) {
                                        s((String) obj4);
                                    } else if ((obj4 instanceof j) && ((j) obj4).f15057a != null) {
                                        s(((j) obj4).f15057a);
                                    }
                                }
                            } else if (i2 != 45) {
                                switch (i2) {
                                    case 9:
                                        for (w wVar : this.z) {
                                            t(wVar.a());
                                        }
                                        this.z.clear();
                                        if (((Boolean) aVar.f14964c).booleanValue()) {
                                            this.m = null;
                                            this.n = null;
                                            this.f46741f.setText((CharSequence) null);
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
                                        Object obj5 = aVar.f14964c;
                                        if (obj5 instanceof b.a.q0.x.r.a) {
                                            b.a.q0.x.r.a aVar2 = (b.a.q0.x.r.a) obj5;
                                            WriteImagesInfo writeImagesInfo = aVar2.f14992a;
                                            if (writeImagesInfo != null) {
                                                if (writeImagesInfo.getChosedFiles() != null) {
                                                    this.x[0] = aVar2.f14992a.getChosedFiles().size();
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
                                        } else {
                                            return;
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
                                Object obj6 = aVar.f14964c;
                                if (obj6 instanceof String) {
                                    String str2 = (String) obj6;
                                    if (StringUtils.isNull(str2)) {
                                        this.k.setVisibility(8);
                                    } else {
                                        this.k.setVisibility(0);
                                        this.k.setText(str2);
                                    }
                                } else {
                                    this.k.setVisibility(8);
                                }
                            }
                        }
                    } else if (aVar.f14964c == null) {
                        updateLocationVisibility(false);
                    } else {
                        updateLocationVisibility(true);
                        b.a.q0.x.v.a aVar3 = (b.a.q0.x.v.a) aVar.f14964c;
                        if (aVar3.f14995a == 1) {
                            this.f46743h.setText(getContext().getString(R.string.location_loading));
                        } else if (!TextUtils.isEmpty(aVar3.f14996b)) {
                            this.f46743h.setText(aVar3.f14996b);
                        } else {
                            this.f46743h.setText(getContext().getString(R.string.location_where_are_you));
                        }
                    }
                }
                this.w[3] = true;
            } else {
                y(aVar);
            }
        } else if (this.f46741f.getSelectionStart() > 0) {
            String substring = this.f46741f.getText().toString().substring(0, this.f46741f.getSelectionStart());
            Matcher matcher = b.a.r0.r0.a.f24558b.matcher(substring);
            if (matcher.find()) {
                int length = substring.length() - matcher.replaceFirst("").length();
                String substring2 = this.f46741f.getText().toString().substring(this.f46741f.getSelectionStart() - length, this.f46741f.getSelectionStart());
                Iterator<w> it = this.z.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    w next = it.next();
                    if (next.c().equals(substring2)) {
                        this.z.remove(next);
                        break;
                    }
                }
                this.f46741f.getText().delete(this.f46741f.getSelectionStart() - length, this.f46741f.getSelectionStart()).toString();
            } else {
                this.f46741f.getText().delete(this.f46741f.getSelectionStart() - 1, this.f46741f.getSelectionStart());
            }
        }
        applyType(this.y);
    }

    @Override // b.a.q0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f46741f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(this.f46741f, R.color.CAM_X0105, 2, i2);
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i2).setShape(0).radius(l.g(getContext(), R.dimen.tbds21)).into(this.f46741f);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0207, i2);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i2);
            if (i2 == 0) {
                i.o(this.f46741f, R.drawable.edittext_cursor);
                this.f46741f.setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0109));
            } else {
                i.o(this.f46741f, R.drawable.edittext_cursor_1);
                this.f46741f.setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0109));
            }
            this.f46742g.changeSkinType(i2);
            this.f46743h.changeSkinType(i2);
            b.a.q0.s.u.c.d(this.k).v(R.color.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, view) == null) && view == this.f46743h) {
            sendAction(new b.a.q0.x.a(18, -1, null));
        }
    }

    public final void q(b.a.q0.x.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || aVar == null) {
            return;
        }
        boolean[] zArr = this.w;
        Object obj = aVar.f14964c;
        if (obj != null && (!(obj instanceof String) || !StringUtils.isNull((String) obj))) {
            Object obj2 = aVar.f14964c;
            if (!(obj2 instanceof j) || !TextUtils.isEmpty(((j) obj2).f15057a)) {
                Object obj3 = aVar.f14964c;
                if (!(obj3 instanceof SpanGroupManager) || !((SpanGroupManager) obj3).G()) {
                    z = true;
                    zArr[0] = z;
                }
            }
        }
        z = false;
        zArr[0] = z;
    }

    public final void r(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, arrayList) == null) {
            int selectionStart = this.f46741f.getSelectionStart();
            if (selectionStart > 0) {
                int i2 = selectionStart - 1;
                if (this.f46741f.getText().toString().charAt(i2) == '@') {
                    this.f46741f.getEditableText().delete(i2, selectionStart);
                }
            }
            SpanGroupEditText spanGroupEditText = this.f46741f;
            if (spanGroupEditText instanceof SpanGroupEditText) {
                spanGroupEditText.checkAndRemoveUnusedAtSpanGroup(arrayList);
            }
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.f46741f.getText().delete(this.f46741f.getSelectionStart(), this.f46741f.getSelectionEnd());
            SpanGroupEditText spanGroupEditText2 = this.f46741f;
            if (spanGroupEditText2 instanceof SpanGroupEditText) {
                spanGroupEditText2.addAtSpanGroupList(arrayList);
            }
        }
    }

    public final void s(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f46741f.getText().insert(this.f46741f.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    @Override // b.a.q0.x.n
    public void sendAction(b.a.q0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) || (editorTools = this.f46740e) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    public void setDefaultHint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.q = str;
        }
    }

    @Override // b.a.q0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editorTools) == null) {
            this.f46740e = editorTools;
        }
    }

    public void setHasHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
        }
    }

    public void setHint(int i2) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (spanGroupEditText = this.f46741f) == null) {
            return;
        }
        spanGroupEditText.setHint(getContext().getString(i2));
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.s = z;
        }
    }

    @Override // b.a.q0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.l = i2;
        }
    }

    public void setTransLink(boolean z) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || (spanGroupEditText = this.f46741f) == null) {
            return;
        }
        spanGroupEditText.setTransLink(z);
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.y = i2;
        }
    }

    public void setmAtListRequestResponseCode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.r = i2;
        }
    }

    public final void t(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, xVar) == null) {
            StatisticItem statisticItem = new StatisticItem("c14122");
            statisticItem.param("fid", xVar.f14653a).param("tid", xVar.f14654b).param("uid", xVar.f14655c).param("obj_type", xVar.f14656d).param("obj_source", xVar.f14657e).param("obj_locate", xVar.f14658f).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, xVar.f14660h);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, context) == null) {
            SpanGroupEditText spanGroupEditText = new SpanGroupEditText(context);
            this.f46741f = spanGroupEditText;
            spanGroupEditText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.f46741f.setMaxLines(4);
            this.f46741f.setMinLines(2);
            this.f46741f.setGravity(48);
            this.f46741f.setIncludeFontPadding(false);
            this.f46741f.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
            this.f46741f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f46741f.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
            i.o(this.f46741f, R.drawable.edittext_cursor);
            this.f46741f.setLineSpacing(l.g(context, R.dimen.M_T_X002), 1.0f);
            this.f46741f.setPadding(l.g(context, R.dimen.M_W_X006), l.g(context, R.dimen.M_H_X004), l.g(context, R.dimen.M_W_X006), l.g(context, R.dimen.M_H_X004));
            this.f46741f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.f46741f.addTextChangedListener(new c(this));
            this.f46741f.setOnTouchListener(new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(l.g(context, R.dimen.M_W_X007), l.g(context, R.dimen.M_H_X002), l.g(context, R.dimen.M_W_X006), l.g(context, R.dimen.M_H_X002));
            this.f46744i.addView(this.f46741f, layoutParams);
        }
    }

    public void updateLocationVisibility(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || (tBSpecificationBtn = this.f46743h) == null) {
            return;
        }
        tBSpecificationBtn.setVisibility(z ? 0 : 8);
    }

    public final void v(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, context) == null) {
            b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
            bVar.p(R.color.CAM_X0209, R.color.CAM_X0105);
            bVar.i(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
            bVar.h(R.color.CAM_X0110);
            bVar.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            bVar.m(l.g(getContext(), R.dimen.M_W_X004), l.g(getContext(), R.dimen.M_W_X004));
            bVar.n(l.g(getContext(), R.dimen.M_H_X002));
            bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.g(getContext(), R.dimen.tbds62));
            layoutParams.setMargins(l.g(context, R.dimen.M_W_X007), l.g(context, R.dimen.M_H_X004), l.g(context, R.dimen.M_W_X007), l.g(context, R.dimen.M_H_X003));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.f46743h = tBSpecificationBtn;
            tBSpecificationBtn.setLayoutParams(layoutParams);
            this.f46743h.setOnClickListener(this);
            this.f46743h.setConfig(bVar);
            this.f46743h.setTextSize(R.dimen.T_X09);
            this.f46743h.setOnClickListener(this);
            this.f46743h.setText(getContext().getString(R.string.location_where_are_you));
            addView(this.f46743h);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            EMTextView eMTextView = new EMTextView(getContext());
            this.k = eMTextView;
            eMTextView.setId(R.id.comment_content);
            this.k.setVisibility(8);
            this.k.setMaxLines(1);
            this.k.setEllipsize(TextUtils.TruncateAt.END);
            this.k.setPadding(l.g(getContext(), R.dimen.M_W_X009), l.g(getContext(), R.dimen.M_H_X005), l.g(getContext(), R.dimen.M_W_X009), l.g(getContext(), R.dimen.M_H_X003));
            this.k.setTextSize(0, l.g(getContext(), R.dimen.T_X08));
            addView(this.k, new LinearLayout.LayoutParams(-1, -2));
        }
    }

    public final void x(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, context) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(80);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            b.a.q0.s.g0.n.b bVar = new b.a.q0.s.g0.n.b();
            bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.f46742g = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.f46742g.setEnabled(false);
            this.f46742g.setTextSize(R.dimen.T_X08);
            this.f46742g.setText(context.getString(R.string.pb_send_post));
            this.f46742g.setOnClickListener(new b(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.g(context, R.dimen.tbds150), l.g(context, R.dimen.tbds75));
            layoutParams2.rightMargin = l.g(context, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = l.g(context, R.dimen.M_H_X002);
            linearLayout.addView(this.f46742g, layoutParams2);
            this.f46744i.addView(linearLayout, layoutParams);
        }
    }

    public final void y(b.a.q0.x.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, aVar) == null) || aVar == null || (obj = aVar.f14964c) == null || !(obj instanceof w) || ((w) obj).getType() == EmotionGroupType.BIG_EMOTION || ((w) aVar.f14964c).getType() == EmotionGroupType.USER_COLLECT) {
            return;
        }
        w wVar = (w) aVar.f14964c;
        if (wVar.getType() == EmotionGroupType.NET_SUG) {
            A(wVar);
        } else {
            z(wVar);
        }
    }

    public final void z(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, wVar) == null) {
            if (!this.s || wVar.getType() == EmotionGroupType.LOCAL) {
                String obj = this.f46741f.getText().toString();
                if (this.t && b.a.r0.r0.a.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(R.string.too_many_face);
                    return;
                }
                this.z.add(wVar);
                b.a.r0.r0.b.b(getContext(), wVar, this.f46741f);
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
        this.s = false;
        this.t = true;
        this.u = true;
        this.v = -1;
        this.w = new boolean[]{false, false, false, false, false};
        this.x = new int[]{0, 0};
        this.y = ALL;
        this.A = new a(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        w();
        v(context);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f46744i = linearLayout;
        linearLayout.setOrientation(0);
        this.f46744i.setMinimumHeight(l.g(context, R.dimen.tbds128));
        addView(this.f46744i, new LinearLayout.LayoutParams(-1, -2));
        u(context);
        x(context);
        this.j = new View(getContext());
        this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds1)));
        addView(this.j);
        this.z = new ArrayList();
    }

    public void setHint(CharSequence charSequence) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, charSequence) == null) || (spanGroupEditText = this.f46741f) == null) {
            return;
        }
        spanGroupEditText.setHint(charSequence);
    }
}

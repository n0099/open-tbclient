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
import c.a.q0.s.c.u;
import c.a.q0.s.c.v;
import c.a.q0.w.n;
import c.a.q0.w.y.j;
import c.a.r0.q4.i;
import c.a.r0.x0.b;
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
    public static int ALL = 0;
    public static int PICTURE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable A;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f39629e;

    /* renamed from: f  reason: collision with root package name */
    public SpanGroupEditText f39630f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f39631g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f39632h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f39633i;

    /* renamed from: j  reason: collision with root package name */
    public View f39634j;
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
    public List<u> z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f39635e;

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
            this.f39635e = pbNewInputContainer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f39635e.f39630f == null) {
                return;
            }
            PbNewInputContainer pbNewInputContainer = this.f39635e;
            pbNewInputContainer.sendAction(new c.a.q0.w.a(4, -1, pbNewInputContainer.f39630f.getSpanGroupManager()));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f39636e;

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
            this.f39636e = pbNewInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f39636e.f39630f != null && this.f39636e.f39630f.getText().toString().trim().equals("")) {
                    c.a.d.f.p.n.N(this.f39636e.getContext(), String.format(c.a.q0.r.v.a.E(R.string.reply_not_empty), new Object[0]));
                    return;
                }
                this.f39636e.sendAction(new c.a.q0.w.a(8, -1, null));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f39637e;

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
            this.f39637e = pbNewInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null || editable.toString().trim() == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.f39637e.n)) {
                if (this.f39637e.m == null) {
                    this.f39637e.m = new j();
                }
                this.f39637e.m.f14076b = this.f39637e.n.toString();
                this.f39637e.m.f14078d = this.f39637e.o;
                this.f39637e.m.f14079e = this.f39637e.p;
                this.f39637e.m.a = this.f39637e.f39630f.getText().toString();
                this.f39637e.m.f14077c = this.f39637e.f39630f.getSpanGroupManager();
                PbNewInputContainer pbNewInputContainer = this.f39637e;
                pbNewInputContainer.sendAction(new c.a.q0.w.a(4, -1, pbNewInputContainer.m));
                return;
            }
            c.a.d.f.m.e.a().removeCallbacks(this.f39637e.A);
            c.a.d.f.m.e.a().post(this.f39637e.A);
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
                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.f39637e.getContext(), this.f39637e.r, true);
                    if (this.f39637e.f39630f != null) {
                        atListActivityConfig.setSelectedAtList(this.f39637e.f39630f.getAtDataInText());
                    }
                    if (this.f39637e.f39629e != null) {
                        atListActivityConfig.setFromTid(this.f39637e.f39629e.getTid());
                        atListActivityConfig.setFromFid(String.valueOf(this.f39637e.f39629e.getFid()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.f39637e.f39629e != null) {
                        statisticItem.addParam("tid", this.f39637e.f39629e.getTid());
                        statisticItem.addParam("fid", this.f39637e.f39629e.getFid());
                    }
                    TiebaStatic.log(statisticItem);
                }
                if (this.f39637e.u) {
                    return;
                }
                this.f39637e.u = true;
                if (this.f39637e.f39630f == null || this.f39637e.v == -1) {
                    return;
                }
                this.f39637e.f39630f.setSelection(this.f39637e.v);
                this.f39637e.v = -1;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f39638e;

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
            this.f39638e = pbNewInputContainer;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f39638e.sendAction(new c.a.q0.w.a(5, -1, null));
                    this.f39638e.f39630f.requestFocus();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbNewInputContainer;
        }

        @Override // c.a.r0.x0.b.g
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.f39630f.setText(spannableStringBuilder);
                this.a.f39630f.setSelection(this.a.f39630f.getText().length());
                this.a.sendAction(new c.a.q0.w.a(5, -1, null));
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
        public final /* synthetic */ PbNewInputContainer f39639b;

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
            this.f39639b = pbNewInputContainer;
            this.a = jVar;
        }

        @Override // c.a.r0.x0.b.g
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.f39639b.n = spannableStringBuilder;
                this.f39639b.o = this.a.f14078d;
                this.f39639b.p = this.a.f14079e;
                if (TextUtils.isEmpty(this.a.a)) {
                    this.f39639b.f39630f.setText("");
                    this.f39639b.sendAction(new c.a.q0.w.a(5, -1, null));
                    this.f39639b.requestFocus();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbNewInputContainer;
        }

        @Override // c.a.r0.x0.b.g
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.a.f39630f.setText(spannableStringBuilder);
                this.a.f39630f.setSelection(this.a.f39630f.getText().length());
                this.a.sendAction(new c.a.q0.w.a(5, -1, null));
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

    public final void A(u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, uVar) == null) || uVar == null || TextUtils.isEmpty(uVar.c()) || TextUtils.isEmpty(uVar.f())) {
            return;
        }
        String obj = this.f39630f.getText().toString();
        if (this.t && c.a.r0.x0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
            return;
        }
        this.z.add(uVar);
        c.a.r0.x0.b.c(getContext(), uVar, this.f39630f);
    }

    public void applyType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 == ALL) {
                boolean[] zArr = this.w;
                if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                    this.f39631g.setEnabled(false);
                } else {
                    this.f39631g.setEnabled(true);
                }
            } else if (i2 == PICTURE) {
                if (this.w[1]) {
                    this.f39631g.setEnabled(true);
                } else {
                    this.f39631g.setEnabled(false);
                }
            }
        }
    }

    @Override // c.a.q0.w.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.f39630f != null && this.f39633i.getVisibility() == 0) {
                this.f39630f.setFocusable(true);
                this.f39630f.setFocusableInTouchMode(true);
                this.f39630f.requestFocus();
                c.a.d.f.p.n.L(getContext(), this.f39630f);
            }
            setVisibility(0);
        }
    }

    public LinearLayout getInputLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f39633i : (LinearLayout) invokeV.objValue;
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f39630f : (EditText) invokeV.objValue;
    }

    public TBSpecificationBtn getSendView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f39631g : (TBSpecificationBtn) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    @Override // c.a.q0.w.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.intValue;
    }

    @Override // c.a.q0.w.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setVisibility(8);
        }
    }

    @Override // c.a.q0.w.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // c.a.q0.w.b
    public void onAction(c.a.q0.w.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.a;
        if (i2 != 3) {
            if (i2 == 4) {
                q(aVar);
            } else if (i2 == 6) {
                Object obj = aVar.f13989c;
                if (obj == null) {
                    this.f39630f.setText((CharSequence) null);
                } else if (obj instanceof String) {
                    if (TextUtils.isEmpty((String) obj)) {
                        this.f39630f.setText((CharSequence) null);
                    } else {
                        c.a.r0.x0.b.e(getContext(), (String) aVar.f13989c, new e(this));
                    }
                } else if (obj instanceof j) {
                    this.n = null;
                    String str = this.q;
                    if (str != null) {
                        this.f39630f.setHint(str);
                    }
                    Object obj2 = aVar.f13989c;
                    j jVar = (j) obj2;
                    if (TextUtils.isEmpty(((j) obj2).f14076b) && TextUtils.isEmpty(((j) aVar.f13989c).a)) {
                        this.f39630f.setText((CharSequence) null);
                    } else {
                        if (!TextUtils.isEmpty(jVar.f14076b)) {
                            c.a.r0.x0.b.e(getContext(), jVar.f14076b, new f(this, jVar));
                        }
                        if (!TextUtils.isEmpty(jVar.a)) {
                            c.a.r0.x0.b.e(getContext(), jVar.a, new g(this));
                        }
                    }
                }
                q(aVar);
            } else if (i2 == 17) {
                Object obj3 = aVar.f13989c;
                if (obj3 != null && (obj3 instanceof ArrayList)) {
                    r((ArrayList) obj3);
                }
            } else if (i2 != 24) {
                if (i2 != 39) {
                    if (i2 != 19) {
                        if (i2 == 20) {
                            updateLocationVisibility(true);
                            this.f39632h.setText(getContext().getString(R.string.location_where_are_you));
                        } else if (i2 != 28) {
                            if (i2 == 29) {
                                this.w[3] = false;
                            } else if (i2 == 44) {
                                Object obj4 = aVar.f13989c;
                                if (obj4 != null) {
                                    if (obj4 instanceof String) {
                                        s((String) obj4);
                                    } else if ((obj4 instanceof j) && ((j) obj4).a != null) {
                                        s(((j) obj4).a);
                                    }
                                }
                            } else if (i2 != 45) {
                                switch (i2) {
                                    case 9:
                                        for (u uVar : this.z) {
                                            t(uVar.a());
                                        }
                                        this.z.clear();
                                        if (((Boolean) aVar.f13989c).booleanValue()) {
                                            this.m = null;
                                            this.n = null;
                                            this.f39630f.setText((CharSequence) null);
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
                                        Object obj5 = aVar.f13989c;
                                        if (obj5 instanceof c.a.q0.w.r.a) {
                                            c.a.q0.w.r.a aVar2 = (c.a.q0.w.r.a) obj5;
                                            WriteImagesInfo writeImagesInfo = aVar2.a;
                                            if (writeImagesInfo != null) {
                                                if (writeImagesInfo.getChosedFiles() != null) {
                                                    this.x[0] = aVar2.a.getChosedFiles().size();
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
                                Object obj6 = aVar.f13989c;
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
                    } else if (aVar.f13989c == null) {
                        updateLocationVisibility(false);
                    } else {
                        updateLocationVisibility(true);
                        c.a.q0.w.w.a aVar3 = (c.a.q0.w.w.a) aVar.f13989c;
                        if (aVar3.a == 1) {
                            this.f39632h.setText(getContext().getString(R.string.location_loading));
                        } else if (!TextUtils.isEmpty(aVar3.f14025b)) {
                            this.f39632h.setText(aVar3.f14025b);
                        } else {
                            this.f39632h.setText(getContext().getString(R.string.location_where_are_you));
                        }
                    }
                }
                this.w[3] = true;
            } else {
                y(aVar);
            }
        } else if (this.f39630f.getSelectionStart() > 0) {
            String substring = this.f39630f.getText().toString().substring(0, this.f39630f.getSelectionStart());
            Matcher matcher = c.a.r0.x0.a.f24472b.matcher(substring);
            if (matcher.find()) {
                int length = substring.length() - matcher.replaceFirst("").length();
                String substring2 = this.f39630f.getText().toString().substring(this.f39630f.getSelectionStart() - length, this.f39630f.getSelectionStart());
                Iterator<u> it = this.z.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    u next = it.next();
                    if (next.c().equals(substring2)) {
                        this.z.remove(next);
                        break;
                    }
                }
                this.f39630f.getText().delete(this.f39630f.getSelectionStart() - length, this.f39630f.getSelectionStart()).toString();
            } else {
                this.f39630f.getText().delete(this.f39630f.getSelectionStart() - 1, this.f39630f.getSelectionStart());
            }
        }
        applyType(this.y);
    }

    @Override // c.a.q0.w.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f39630f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(this.f39630f, R.color.CAM_X0105, 2, i2);
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i2).setShape(0).radius(c.a.d.f.p.n.f(getContext(), R.dimen.tbds21)).into(this.f39630f);
            SkinManager.setBackgroundColor(this.f39634j, R.color.CAM_X0207, i2);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i2);
            if (i2 == 0) {
                i.l(this.f39630f, R.drawable.edittext_cursor);
                this.f39630f.setHintTextColor(SkinManager.getColor(i2, (int) R.color.CAM_X0109));
            } else {
                i.l(this.f39630f, R.drawable.edittext_cursor_1);
                this.f39630f.setHintTextColor(SkinManager.getColor(i2, (int) R.color.CAM_X0109));
            }
            this.f39631g.changeSkinType(i2);
            this.f39632h.changeSkinType(i2);
            c.a.q0.r.v.c.d(this.k).v(R.color.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, view) == null) && view == this.f39632h) {
            sendAction(new c.a.q0.w.a(18, -1, null));
        }
    }

    public final void q(c.a.q0.w.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || aVar == null) {
            return;
        }
        boolean[] zArr = this.w;
        Object obj = aVar.f13989c;
        if (obj != null && (!(obj instanceof String) || !StringUtils.isNull((String) obj))) {
            Object obj2 = aVar.f13989c;
            if (!(obj2 instanceof j) || !TextUtils.isEmpty(((j) obj2).a)) {
                Object obj3 = aVar.f13989c;
                if (!(obj3 instanceof SpanGroupManager) || !((SpanGroupManager) obj3).I()) {
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
            int selectionStart = this.f39630f.getSelectionStart();
            if (selectionStart > 0) {
                int i2 = selectionStart - 1;
                if (this.f39630f.getText().toString().charAt(i2) == '@') {
                    this.f39630f.getEditableText().delete(i2, selectionStart);
                }
            }
            SpanGroupEditText spanGroupEditText = this.f39630f;
            if (spanGroupEditText instanceof SpanGroupEditText) {
                spanGroupEditText.checkAndRemoveUnusedAtSpanGroup(arrayList);
            }
            if (arrayList == null || arrayList.size() <= 0) {
                return;
            }
            this.f39630f.getText().delete(this.f39630f.getSelectionStart(), this.f39630f.getSelectionEnd());
            SpanGroupEditText spanGroupEditText2 = this.f39630f;
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
        this.f39630f.getText().insert(this.f39630f.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    @Override // c.a.q0.w.n
    public void sendAction(c.a.q0.w.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) || (editorTools = this.f39629e) == null) {
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

    @Override // c.a.q0.w.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, editorTools) == null) {
            this.f39629e = editorTools;
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
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (spanGroupEditText = this.f39630f) == null) {
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

    @Override // c.a.q0.w.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.l = i2;
        }
    }

    public void setTransLink(boolean z) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048600, this, z) == null) || (spanGroupEditText = this.f39630f) == null) {
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

    public final void t(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, vVar) == null) {
            StatisticItem statisticItem = new StatisticItem("c14122");
            statisticItem.param("fid", vVar.a).param("tid", vVar.f13717b).param("uid", vVar.f13718c).param("obj_type", vVar.f13719d).param("obj_source", vVar.f13720e).param("obj_locate", vVar.f13721f).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, vVar.f13723h);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, context) == null) {
            SpanGroupEditText spanGroupEditText = new SpanGroupEditText(context);
            this.f39630f = spanGroupEditText;
            spanGroupEditText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.f39630f.setMaxLines(4);
            this.f39630f.setMinLines(2);
            this.f39630f.setGravity(48);
            this.f39630f.setIncludeFontPadding(false);
            this.f39630f.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
            this.f39630f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f39630f.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
            i.l(this.f39630f, R.drawable.edittext_cursor);
            this.f39630f.setLineSpacing(c.a.d.f.p.n.f(context, R.dimen.M_T_X002), 1.0f);
            this.f39630f.setPadding(c.a.d.f.p.n.f(context, R.dimen.M_W_X006), c.a.d.f.p.n.f(context, R.dimen.M_H_X004), c.a.d.f.p.n.f(context, R.dimen.M_W_X006), c.a.d.f.p.n.f(context, R.dimen.M_H_X004));
            this.f39630f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.f39630f.addTextChangedListener(new c(this));
            this.f39630f.setOnTouchListener(new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(c.a.d.f.p.n.f(context, R.dimen.M_W_X007), c.a.d.f.p.n.f(context, R.dimen.M_H_X002), c.a.d.f.p.n.f(context, R.dimen.M_W_X006), c.a.d.f.p.n.f(context, R.dimen.M_H_X002));
            this.f39633i.addView(this.f39630f, layoutParams);
        }
    }

    public void updateLocationVisibility(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048605, this, z) == null) || (tBSpecificationBtn = this.f39632h) == null) {
            return;
        }
        tBSpecificationBtn.setVisibility(z ? 0 : 8);
    }

    public final void v(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, context) == null) {
            c.a.q0.r.l0.n.b bVar = new c.a.q0.r.l0.n.b();
            bVar.p(R.color.CAM_X0209, R.color.CAM_X0105);
            bVar.i(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
            bVar.h(R.color.CAM_X0110);
            bVar.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            bVar.m(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X004), c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X004));
            bVar.n(c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X002));
            bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, c.a.d.f.p.n.f(getContext(), R.dimen.tbds62));
            layoutParams.setMargins(c.a.d.f.p.n.f(context, R.dimen.M_W_X007), c.a.d.f.p.n.f(context, R.dimen.M_H_X004), c.a.d.f.p.n.f(context, R.dimen.M_W_X007), c.a.d.f.p.n.f(context, R.dimen.M_H_X003));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.f39632h = tBSpecificationBtn;
            tBSpecificationBtn.setLayoutParams(layoutParams);
            this.f39632h.setOnClickListener(this);
            this.f39632h.setConfig(bVar);
            this.f39632h.setTextSize(R.dimen.T_X09);
            this.f39632h.setOnClickListener(this);
            this.f39632h.setText(getContext().getString(R.string.location_where_are_you));
            addView(this.f39632h);
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
            this.k.setPadding(c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X009), c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X005), c.a.d.f.p.n.f(getContext(), R.dimen.M_W_X009), c.a.d.f.p.n.f(getContext(), R.dimen.M_H_X003));
            this.k.setTextSize(0, c.a.d.f.p.n.f(getContext(), R.dimen.T_X08));
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
            c.a.q0.r.l0.n.b bVar = new c.a.q0.r.l0.n.b();
            bVar.p(R.color.CAM_X0302, R.color.CAM_X0101);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.f39631g = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.f39631g.setEnabled(false);
            this.f39631g.setTextSize(R.dimen.T_X08);
            this.f39631g.setText(context.getString(R.string.pb_send_post));
            this.f39631g.setOnClickListener(new b(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(c.a.d.f.p.n.f(context, R.dimen.tbds150), c.a.d.f.p.n.f(context, R.dimen.tbds75));
            layoutParams2.rightMargin = c.a.d.f.p.n.f(context, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = c.a.d.f.p.n.f(context, R.dimen.M_H_X002);
            linearLayout.addView(this.f39631g, layoutParams2);
            this.f39633i.addView(linearLayout, layoutParams);
        }
    }

    public final void y(c.a.q0.w.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, aVar) == null) || aVar == null || (obj = aVar.f13989c) == null || !(obj instanceof u) || ((u) obj).getType() == EmotionGroupType.BIG_EMOTION || ((u) aVar.f13989c).getType() == EmotionGroupType.USER_COLLECT) {
            return;
        }
        u uVar = (u) aVar.f13989c;
        if (uVar.getType() == EmotionGroupType.NET_SUG) {
            A(uVar);
        } else {
            z(uVar);
        }
    }

    public final void z(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, uVar) == null) {
            if (!this.s || uVar.getType() == EmotionGroupType.LOCAL) {
                String obj = this.f39630f.getText().toString();
                if (this.t && c.a.r0.x0.a.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(R.string.too_many_face);
                    return;
                }
                this.z.add(uVar);
                c.a.r0.x0.b.b(getContext(), uVar, this.f39630f);
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
        this.f39633i = linearLayout;
        linearLayout.setOrientation(0);
        this.f39633i.setMinimumHeight(c.a.d.f.p.n.f(context, R.dimen.tbds128));
        addView(this.f39633i, new LinearLayout.LayoutParams(-1, -2));
        u(context);
        x(context);
        this.f39634j = new View(getContext());
        this.f39634j.setLayoutParams(new LinearLayout.LayoutParams(-1, c.a.d.f.p.n.f(getContext(), R.dimen.ds1)));
        addView(this.f39634j);
        this.z = new ArrayList();
    }

    public void setHint(CharSequence charSequence) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, charSequence) == null) || (spanGroupEditText = this.f39630f) == null) {
            return;
        }
        spanGroupEditText.setHint(charSequence);
    }
}

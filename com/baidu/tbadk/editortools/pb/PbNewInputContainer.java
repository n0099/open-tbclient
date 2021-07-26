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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
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
import com.bytedance.sdk.component.net.tnc.TNCManager;
import d.a.d.e.p.l;
import d.a.p0.t.c.v;
import d.a.p0.t.c.w;
import d.a.p0.x.n;
import d.a.p0.x.w.j;
import d.a.q0.a4.i;
import d.a.q0.o0.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
/* loaded from: classes3.dex */
public class PbNewInputContainer extends LinearLayout implements n, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static int y = 1;
    public static int z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public EditorTools f13088e;

    /* renamed from: f  reason: collision with root package name */
    public SpanGroupEditText f13089f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f13090g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f13091h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f13092i;
    public View j;
    public TextView k;
    public int l;
    public j m;
    public SpannableStringBuilder n;
    public String o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public boolean[] t;
    public int[] u;
    public int v;
    public List<v> w;
    public Runnable x;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f13093e;

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
            this.f13093e = pbNewInputContainer;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13093e.f13089f == null) {
                return;
            }
            PbNewInputContainer pbNewInputContainer = this.f13093e;
            pbNewInputContainer.d(new d.a.p0.x.a(4, -1, pbNewInputContainer.f13089f.getSpanGroupManager()));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f13094e;

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
            this.f13094e = pbNewInputContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f13094e.d(new d.a.p0.x.a(8, -1, null));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f13095e;

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
            this.f13095e = pbNewInputContainer;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable == null || editable.toString().trim() == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.f13095e.n)) {
                if (this.f13095e.m == null) {
                    this.f13095e.m = new j();
                }
                this.f13095e.m.f54246b = this.f13095e.n.toString();
                this.f13095e.m.f54245a = this.f13095e.f13089f.getText().toString();
                this.f13095e.m.f54247c = this.f13095e.f13089f.getSpanGroupManager();
                PbNewInputContainer pbNewInputContainer = this.f13095e;
                pbNewInputContainer.d(new d.a.p0.x.a(4, -1, pbNewInputContainer.m));
                return;
            }
            d.a.d.e.m.e.a().removeCallbacks(this.f13095e.x);
            d.a.d.e.m.e.a().post(this.f13095e.x);
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
            if (!(interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || this.f13095e.r) {
                return;
            }
            this.f13095e.r = true;
            if (this.f13095e.s != -1) {
                this.f13095e.f13089f.setSelection(this.f13095e.s);
                this.f13095e.s = -1;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f13096e;

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
            this.f13096e = pbNewInputContainer;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f13096e.d(new d.a.p0.x.a(5, -1, null));
                    this.f13096e.f13089f.requestFocus();
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f13097a;

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
            this.f13097a = pbNewInputContainer;
        }

        @Override // d.a.q0.o0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.f13097a.f13089f.setText(spannableStringBuilder);
                this.f13097a.f13089f.setSelection(this.f13097a.f13089f.getText().length());
                this.f13097a.d(new d.a.p0.x.a(5, -1, null));
                this.f13097a.requestFocus();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f13098a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f13099b;

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
            this.f13099b = pbNewInputContainer;
            this.f13098a = jVar;
        }

        @Override // d.a.q0.o0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.f13099b.n = spannableStringBuilder;
                if (TextUtils.isEmpty(this.f13098a.f54245a)) {
                    this.f13099b.f13089f.setText("");
                    this.f13099b.d(new d.a.p0.x.a(5, -1, null));
                    this.f13099b.requestFocus();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements b.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbNewInputContainer f13100a;

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
            this.f13100a = pbNewInputContainer;
        }

        @Override // d.a.q0.o0.b.f
        public void a(SpannableStringBuilder spannableStringBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spannableStringBuilder) == null) {
                this.f13100a.f13089f.setText(spannableStringBuilder);
                this.f13100a.f13089f.setSelection(this.f13100a.f13089f.getText().length());
                this.f13100a.d(new d.a.p0.x.a(5, -1, null));
                this.f13100a.requestFocus();
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

    @Override // d.a.p0.x.n
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f13089f != null && this.f13092i.getVisibility() == 0) {
                this.f13089f.setFocusable(true);
                this.f13089f.setFocusableInTouchMode(true);
                this.f13089f.requestFocus();
                l.K(getContext(), this.f13089f);
            }
            setVisibility(0);
        }
    }

    @Override // d.a.p0.x.n
    public void d(d.a.p0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || (editorTools = this.f13088e) == null) {
            return;
        }
        editorTools.A(aVar);
    }

    public LinearLayout getInputLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13092i : (LinearLayout) invokeV.objValue;
    }

    public EditText getInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f13089f : (EditText) invokeV.objValue;
    }

    public TBSpecificationBtn getSendView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f13090g : (TBSpecificationBtn) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    @Override // d.a.p0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : invokeV.intValue;
    }

    @Override // d.a.p0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setVisibility(8);
        }
    }

    @Override // d.a.p0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public final void n(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            sb.append(TNCManager.TNC_PROBE_HEADER_SECEPTOR);
            sb.append(arrayList.get(i2));
            sb.append(" ");
        }
        String sb2 = sb.toString();
        this.f13089f.getText().insert(this.f13089f.getSelectionStart(), sb2);
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f13089f.getText().insert(this.f13089f.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
    }

    @Override // d.a.p0.x.b
    public void onAction(d.a.p0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f54158a;
        if (i2 != 3) {
            if (i2 != 4) {
                if (i2 == 6) {
                    Object obj = aVar.f54160c;
                    if (obj == null) {
                        this.f13089f.setText((CharSequence) null);
                    } else if (obj instanceof String) {
                        if (TextUtils.isEmpty((String) obj)) {
                            this.f13089f.setText((CharSequence) null);
                        } else {
                            d.a.q0.o0.b.d(getContext(), (String) aVar.f54160c, new e(this));
                        }
                    } else if (obj instanceof j) {
                        this.n = null;
                        String str = this.o;
                        if (str != null) {
                            this.f13089f.setHint(str);
                        }
                        Object obj2 = aVar.f54160c;
                        j jVar = (j) obj2;
                        if (TextUtils.isEmpty(((j) obj2).f54246b) && TextUtils.isEmpty(((j) aVar.f54160c).f54245a)) {
                            this.f13089f.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.f54246b)) {
                                d.a.q0.o0.b.d(getContext(), jVar.f54246b, new f(this, jVar));
                            }
                            if (!TextUtils.isEmpty(jVar.f54245a)) {
                                d.a.q0.o0.b.d(getContext(), jVar.f54245a, new g(this));
                            }
                        }
                    }
                } else if (i2 == 17) {
                    Object obj3 = aVar.f54160c;
                    if (obj3 != null && (obj3 instanceof ArrayList)) {
                        n((ArrayList) obj3);
                    }
                } else if (i2 != 24) {
                    if (i2 != 39) {
                        if (i2 != 19) {
                            if (i2 == 20) {
                                y(true);
                                this.f13091h.setText(getContext().getString(R.string.location_where_are_you));
                            } else if (i2 != 28) {
                                if (i2 == 29) {
                                    this.t[3] = false;
                                } else if (i2 == 44) {
                                    Object obj4 = aVar.f54160c;
                                    if (obj4 != null) {
                                        if (obj4 instanceof String) {
                                            o((String) obj4);
                                        } else if ((obj4 instanceof j) && ((j) obj4).f54245a != null) {
                                            o(((j) obj4).f54245a);
                                        }
                                    }
                                } else if (i2 != 45) {
                                    switch (i2) {
                                        case 9:
                                            for (v vVar : this.w) {
                                                q(vVar.a());
                                            }
                                            this.w.clear();
                                            if (((Boolean) aVar.f54160c).booleanValue()) {
                                                this.m = null;
                                                this.n = null;
                                                this.f13089f.setText((CharSequence) null);
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
                                            Object obj5 = aVar.f54160c;
                                            if (obj5 instanceof d.a.p0.x.r.a) {
                                                d.a.p0.x.r.a aVar2 = (d.a.p0.x.r.a) obj5;
                                                WriteImagesInfo writeImagesInfo = aVar2.f54181a;
                                                if (writeImagesInfo != null) {
                                                    if (writeImagesInfo.getChosedFiles() != null) {
                                                        this.u[0] = aVar2.f54181a.getChosedFiles().size();
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
                                    Object obj6 = aVar.f54160c;
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
                        } else if (aVar.f54160c == null) {
                            y(false);
                        } else {
                            y(true);
                            d.a.p0.x.u.a aVar3 = (d.a.p0.x.u.a) aVar.f54160c;
                            if (aVar3.f54184a == 1) {
                                this.f13091h.setText(getContext().getString(R.string.location_loading));
                            } else if (!TextUtils.isEmpty(aVar3.f54185b)) {
                                this.f13091h.setText(aVar3.f54185b);
                            } else {
                                this.f13091h.setText(getContext().getString(R.string.location_where_are_you));
                            }
                        }
                    }
                    this.t[3] = true;
                } else {
                    v(aVar);
                }
            }
            Object obj7 = aVar.f54160c;
            if (obj7 != null && (!(obj7 instanceof String) || !StringUtils.isNull((String) obj7))) {
                Object obj8 = aVar.f54160c;
                if (!(obj8 instanceof j) || !TextUtils.isEmpty(((j) obj8).f54245a)) {
                    Object obj9 = aVar.f54160c;
                    if (!(obj9 instanceof SpanGroupManager) || !((SpanGroupManager) obj9).w()) {
                        this.t[0] = true;
                    }
                }
            }
            this.t[0] = false;
        } else if (this.f13089f.getSelectionStart() > 0) {
            String substring = this.f13089f.getText().toString().substring(0, this.f13089f.getSelectionStart());
            Matcher matcher = d.a.q0.o0.a.f61680b.matcher(substring);
            if (matcher.find()) {
                int length = substring.length() - matcher.replaceFirst("").length();
                String substring2 = this.f13089f.getText().toString().substring(this.f13089f.getSelectionStart() - length, this.f13089f.getSelectionStart());
                Iterator<v> it = this.w.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    v next = it.next();
                    if (next.c().equals(substring2)) {
                        this.w.remove(next);
                        break;
                    }
                }
                this.f13089f.getText().delete(this.f13089f.getSelectionStart() - length, this.f13089f.getSelectionStart()).toString();
            } else {
                this.f13089f.getText().delete(this.f13089f.getSelectionStart() - 1, this.f13089f.getSelectionStart());
            }
        }
        p(this.v);
    }

    @Override // d.a.p0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f13089f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(this.f13089f, R.color.CAM_X0105, 2, i2);
            TBSelector.makeDrawableSelector().defaultColor(R.color.CAM_X0209, i2).setShape(0).radius(l.g(getContext(), R.dimen.tbds21)).into(this.f13089f);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0207, i2);
            SkinManager.setBackgroundColor(this, R.color.CAM_X0207, i2);
            if (i2 == 0) {
                i.e(this.f13089f, R.drawable.edittext_cursor);
                this.f13089f.setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0109));
            } else {
                i.e(this.f13089f, R.drawable.edittext_cursor_1);
                this.f13089f.setHintTextColor(SkinManager.getColor(i2, R.color.CAM_X0109));
            }
            this.f13090g.l(i2);
            this.f13091h.l(i2);
            d.a.p0.s.u.c.d(this.k).t(R.color.CAM_X0109);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, view) == null) && view == this.f13091h) {
            d(new d.a.p0.x.a(18, -1, null));
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            if (i2 == z) {
                boolean[] zArr = this.t;
                if (!zArr[0] && !zArr[1] && !zArr[2] && !zArr[3] && !zArr[4]) {
                    this.f13090g.setEnabled(false);
                } else {
                    this.f13090g.setEnabled(true);
                }
            } else if (i2 == y) {
                if (this.t[1]) {
                    this.f13090g.setEnabled(true);
                } else {
                    this.f13090g.setEnabled(false);
                }
            }
        }
    }

    public final void q(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, wVar) == null) {
            StatisticItem statisticItem = new StatisticItem("c14122");
            statisticItem.param("fid", wVar.f53847a).param("tid", wVar.f53848b).param("uid", wVar.f53849c).param("obj_type", wVar.f53850d).param("obj_source", wVar.f53851e).param("obj_locate", wVar.f53852f).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, wVar.f53854h);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, context) == null) {
            SpanGroupEditText spanGroupEditText = new SpanGroupEditText(context);
            this.f13089f = spanGroupEditText;
            spanGroupEditText.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
            this.f13089f.setMaxLines(4);
            this.f13089f.setMinLines(2);
            this.f13089f.setGravity(48);
            this.f13089f.setIncludeFontPadding(false);
            this.f13089f.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
            this.f13089f.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.f13089f.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
            i.e(this.f13089f, R.drawable.edittext_cursor);
            this.f13089f.setLineSpacing(l.g(context, R.dimen.M_T_X002), 1.0f);
            this.f13089f.setPadding(l.g(context, R.dimen.M_W_X006), l.g(context, R.dimen.M_H_X004), l.g(context, R.dimen.M_W_X006), l.g(context, R.dimen.M_H_X004));
            this.f13089f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
            this.f13089f.addTextChangedListener(new c(this));
            this.f13089f.setOnTouchListener(new d(this));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(l.g(context, R.dimen.M_W_X007), l.g(context, R.dimen.M_H_X002), l.g(context, R.dimen.M_W_X006), l.g(context, R.dimen.M_H_X002));
            this.f13092i.addView(this.f13089f, layoutParams);
        }
    }

    public final void s(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            d.a.p0.s.f0.n.b bVar = new d.a.p0.s.f0.n.b();
            bVar.o(R.color.CAM_X0209, R.color.CAM_X0105);
            bVar.i(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
            bVar.h(R.color.CAM_X0110);
            bVar.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            bVar.l(l.g(getContext(), R.dimen.M_W_X004), l.g(getContext(), R.dimen.M_W_X004));
            bVar.m(l.g(getContext(), R.dimen.M_H_X002));
            bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.g(getContext(), R.dimen.tbds62));
            layoutParams.setMargins(l.g(context, R.dimen.M_W_X007), l.g(context, R.dimen.M_H_X004), l.g(context, R.dimen.M_W_X007), l.g(context, R.dimen.M_H_X003));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
            this.f13091h = tBSpecificationBtn;
            tBSpecificationBtn.setLayoutParams(layoutParams);
            this.f13091h.setOnClickListener(this);
            this.f13091h.setConfig(bVar);
            this.f13091h.setTextSize(R.dimen.T_X09);
            this.f13091h.setOnClickListener(this);
            this.f13091h.setText(getContext().getString(R.string.location_where_are_you));
            addView(this.f13091h);
        }
    }

    public void setDefaultHint(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.o = str;
        }
    }

    @Override // d.a.p0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, editorTools) == null) {
            this.f13088e = editorTools;
        }
    }

    public void setHasHint(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z2) == null) {
        }
    }

    public void setHint(int i2) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (spanGroupEditText = this.f13089f) == null) {
            return;
        }
        spanGroupEditText.setHint(getContext().getString(i2));
    }

    public void setIsOnlyLocalEmotion(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z2) == null) {
            this.p = z2;
        }
    }

    @Override // d.a.p0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.l = i2;
        }
    }

    public void setTransLink(boolean z2) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z2) == null) || (spanGroupEditText = this.f13089f) == null) {
            return;
        }
        spanGroupEditText.setTransLink(z2);
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.v = i2;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
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

    public final void u(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, context) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(80);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            d.a.p0.s.f0.n.b bVar = new d.a.p0.s.f0.n.b();
            bVar.o(R.color.CAM_X0302, R.color.CAM_X0101);
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.f13090g = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.f13090g.setEnabled(false);
            this.f13090g.setTextSize(R.dimen.T_X08);
            this.f13090g.setText(context.getString(R.string.pb_send_post));
            this.f13090g.setOnClickListener(new b(this));
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.g(context, R.dimen.tbds150), l.g(context, R.dimen.tbds75));
            layoutParams2.rightMargin = l.g(context, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = l.g(context, R.dimen.M_H_X002);
            linearLayout.addView(this.f13090g, layoutParams2);
            this.f13092i.addView(linearLayout, layoutParams);
        }
    }

    public final void v(d.a.p0.x.a aVar) {
        Object obj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, aVar) == null) || aVar == null || (obj = aVar.f54160c) == null || !(obj instanceof v) || ((v) obj).f() == EmotionGroupType.BIG_EMOTION || ((v) aVar.f54160c).f() == EmotionGroupType.USER_COLLECT) {
            return;
        }
        v vVar = (v) aVar.f54160c;
        if (vVar.f() == EmotionGroupType.NET_SUG) {
            x(vVar);
        } else {
            w(vVar);
        }
    }

    public final void w(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, vVar) == null) {
            if (!this.p || vVar.f() == EmotionGroupType.LOCAL) {
                String obj = this.f13089f.getText().toString();
                if (this.q && d.a.q0.o0.a.a(obj) >= 10 && getContext() != null) {
                    CustomToast.newInstance().showToast(R.string.too_many_face);
                    return;
                }
                this.w.add(vVar);
                d.a.q0.o0.b.b(getContext(), vVar, this.f13089f);
            }
        }
    }

    public final void x(v vVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, vVar) == null) || vVar == null || TextUtils.isEmpty(vVar.c()) || TextUtils.isEmpty(vVar.g())) {
            return;
        }
        String obj = this.f13089f.getText().toString();
        if (this.q && d.a.q0.o0.a.a(obj) >= 10 && getContext() != null) {
            CustomToast.newInstance().showToast(R.string.too_many_face);
            return;
        }
        this.w.add(vVar);
        d.a.q0.o0.b.c(getContext(), vVar, this.f13089f);
    }

    public void y(boolean z2) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048608, this, z2) == null) || (tBSpecificationBtn = this.f13091h) == null) {
            return;
        }
        tBSpecificationBtn.setVisibility(z2 ? 0 : 8);
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
        this.p = false;
        this.q = true;
        this.r = true;
        this.s = -1;
        this.t = new boolean[]{false, false, false, false, false};
        this.u = new int[]{0, 0};
        this.v = z;
        this.x = new a(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        t();
        s(context);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f13092i = linearLayout;
        linearLayout.setOrientation(0);
        this.f13092i.setMinimumHeight(l.g(context, R.dimen.tbds128));
        addView(this.f13092i, new LinearLayout.LayoutParams(-1, -2));
        r(context);
        u(context);
        this.j = new View(getContext());
        this.j.setLayoutParams(new LinearLayout.LayoutParams(-1, l.g(getContext(), R.dimen.ds1)));
        addView(this.j);
        this.w = new ArrayList();
    }

    public void setHint(CharSequence charSequence) {
        SpanGroupEditText spanGroupEditText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, charSequence) == null) || (spanGroupEditText = this.f13089f) == null) {
            return;
        }
        spanGroupEditText.setHint(charSequence);
    }
}

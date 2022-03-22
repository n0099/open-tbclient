package com.baidu.tieba.gift.giftTab;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.o0.r.r.j0;
import c.a.o0.r.r.k0;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftPagerAdapter;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class GiftTabView implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.p0.j1.b.d A;
    public GiftPagerAdapter B;
    public c.a.o0.r.l0.a C;
    public ArrayList<c.a.p0.j1.b.c> D;
    public ArrayList<c.a.p0.j1.b.a> E;
    public ArrayList<c.a.p0.j1.b.e> F;
    public int G;
    public String H;
    public int I;
    public k0 J;
    public o K;
    public n L;
    public int M;
    public int N;
    public int O;
    public int P;
    public j0 Q;
    public SparseIntArray R;
    public SparseBooleanArray S;
    public int T;
    public int U;
    public int V;
    public View.OnClickListener W;
    public int X;
    public View.OnClickListener Y;
    public View.OnClickListener Z;
    public GiftTabActivity a;

    /* renamed from: b  reason: collision with root package name */
    public View f33118b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f33119c;

    /* renamed from: d  reason: collision with root package name */
    public View f33120d;

    /* renamed from: e  reason: collision with root package name */
    public View f33121e;

    /* renamed from: f  reason: collision with root package name */
    public View f33122f;

    /* renamed from: g  reason: collision with root package name */
    public EditText f33123g;
    public Handler g0;

    /* renamed from: h  reason: collision with root package name */
    public View f33124h;
    public Runnable h0;
    public TextView i;
    public boolean i0;
    public TextView j;
    public ImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public BaseViewPager q;
    public IndicatorView r;
    public HorizontalScrollView s;
    public LinearLayout t;
    public View u;
    public View v;
    public FrameLayout w;
    public View x;
    public ListView y;
    public List<View> z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabView a;

        public a(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.a.J.f10900b)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{this.a.J.f10900b});
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabView a;

        public b(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.n.w(this.a.a.getPageContext().getPageActivity(), this.a.f33123g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabView a;

        public c(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.a.x.getVisibility() != 0) {
                    this.a.a.closeActivity();
                } else {
                    this.a.x.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabView a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.w(false);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.a.a.U, -2);
                    int[] iArr = new int[2];
                    this.a.a.f33123g.getLocationOnScreen(iArr);
                    layoutParams.leftMargin = iArr[0] - this.a.a.V;
                    int i = (iArr[1] - this.a.a.T) - this.a.a.V;
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        i += UtilHelper.getStatusBarHeight();
                    }
                    layoutParams.topMargin = i;
                    this.a.a.y.setLayoutParams(layoutParams);
                    this.a.a.x.setVisibility(0);
                }
            }
        }

        public d(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.n.w(this.a.a.getPageContext().getPageActivity(), this.a.f33123g);
                this.a.a.mHandler.postDelayed(new a(this), 200L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabView a;

        public e(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabView;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (z) {
                    c.a.d.f.p.n.L(this.a.a.getPageContext().getPageActivity(), this.a.f33123g);
                } else {
                    c.a.d.f.p.n.w(this.a.a.getPageContext().getPageActivity(), this.a.f33123g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabView a;

        public f(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.x.setVisibility(8);
                c.a.d.f.p.n.w(this.a.a.getPageContext().getPageActivity(), this.a.f33123g);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabView a;

        public g(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.K == null) {
                return;
            }
            this.a.S.append(this.a.P, true);
            this.a.K.a(((c.a.p0.j1.b.c) this.a.D.get(this.a.P)).a());
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabView a;

        public h(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.L == null) {
                return;
            }
            this.a.L.a();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabView a;

        public i(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S();
                this.a.y(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabView a;

        public j(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                GiftTabView giftTabView = this.a;
                giftTabView.N = giftTabView.M;
                this.a.O = i;
                c.a.d.f.p.n.w(this.a.a.getPageContext().getPageActivity(), this.a.f33123g);
                c.a.p0.j1.b.b bVar = (c.a.p0.j1.b.b) adapterView.getAdapter();
                if (bVar != null) {
                    j0 item = bVar.getItem(i);
                    if (item != null) {
                        this.a.Q = item;
                    }
                    bVar.d(i);
                    bVar.notifyDataSetChanged();
                }
                this.a.L();
                this.a.y(true);
            }
        }

        public /* synthetic */ j(GiftTabView giftTabView, a aVar) {
            this(giftTabView);
        }
    }

    /* loaded from: classes5.dex */
    public class k implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabView a;

        public k(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (this.a.F == null || this.a.F.size() <= 0) {
                    this.a.w(true);
                    Selection.selectAll(this.a.f33123g.getText());
                    this.a.x.setVisibility(8);
                    this.a.y(true);
                    return;
                }
                if (i == this.a.F.size()) {
                    this.a.w(true);
                    Selection.selectAll(this.a.f33123g.getText());
                } else {
                    this.a.f33123g.setCursorVisible(true);
                    this.a.f33123g.setFocusable(true);
                    c.a.p0.j1.b.e eVar = (c.a.p0.j1.b.e) this.a.F.get(i);
                    if (eVar != null) {
                        EditText editText = this.a.f33123g;
                        editText.setText("" + eVar.b());
                    }
                }
                this.a.x.setVisibility(8);
                this.a.y(true);
            }
        }

        public /* synthetic */ k(GiftTabView giftTabView, a aVar) {
            this(giftTabView);
        }
    }

    /* loaded from: classes5.dex */
    public class l implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabView a;

        public l(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = giftTabView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int e2 = c.a.d.f.m.b.e(editable.toString(), 0);
                if (editable.toString().length() == String.valueOf(e2).length()) {
                    this.a.y(true);
                    return;
                }
                int i = e2 >= 0 ? e2 : 0;
                EditText editText = this.a.f33123g;
                editText.setText("" + i);
                this.a.f33123g.setSelection(String.valueOf(i).length());
            }
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
            }
        }

        public /* synthetic */ l(GiftTabView giftTabView, a aVar) {
            this(giftTabView);
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f33125b;

        public m(GiftTabView giftTabView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33125b = giftTabView;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int min = Math.min(this.a, this.f33125b.R.size());
                int i = 0;
                for (int i2 = 0; i2 < min; i2++) {
                    i += this.f33125b.R.get(i2);
                }
                this.f33125b.M = i;
                GiftTabView giftTabView = this.f33125b;
                giftTabView.q.setCurrentItem(giftTabView.M);
                this.f33125b.T();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface n {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface o {
        void a(int i);
    }

    public GiftTabView(GiftTabActivity giftTabActivity, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {giftTabActivity, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = new ArrayList();
        this.G = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.R = new SparseIntArray();
        this.S = new SparseBooleanArray();
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.Y = new a(this);
        this.Z = new b(this);
        this.g0 = new Handler();
        this.h0 = new i(this);
        this.i0 = false;
        this.a = giftTabActivity;
        this.W = onClickListener;
        View inflate = LayoutInflater.from(giftTabActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0386, (ViewGroup) null);
        this.f33118b = inflate;
        this.a.setContentView(inflate);
        J();
        this.T = c.a.d.f.p.n.r(this.a.getActivity());
        this.U = c.a.d.f.p.n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07029b);
        this.V = c.a.d.f.p.n.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070229);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g0.removeCallbacks(this.h0);
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.X : invokeV.intValue;
    }

    public j0 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.Q : (j0) invokeV.objValue;
    }

    public final View D(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0384, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091539);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource((TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09153b), R.drawable.new_pic_emotion_08);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09153d), R.color.CAM_X0105, 1, skinType);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0111, 1, skinType);
            SkinManager.setBackgroundResource(textView, R.drawable.btn_appdownload, skinType);
            if (z) {
                textView.setOnClickListener(new g(this));
            } else {
                textView.setOnClickListener(new h(this));
            }
            return inflate;
        }
        return (View) invokeZ.objValue;
    }

    public final GridView E(List<j0> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, list, i2)) == null) {
            c.a.p0.j1.b.b bVar = new c.a.p0.j1.b.b(this.a.getPageContext().getPageActivity());
            bVar.c(list);
            bVar.d(i2);
            TableLineGridView tableLineGridView = new TableLineGridView(this.a.getPageContext().getPageActivity());
            tableLineGridView.setColumnCount(4);
            tableLineGridView.setRowCount(2);
            tableLineGridView.setBackgroundLineResource(SkinManager.getColor(R.color.CAM_X0204));
            tableLineGridView.setVerticalScrollBarEnabled(false);
            tableLineGridView.setNumColumns(4);
            tableLineGridView.setSelector(R.color.common_color_10022);
            tableLineGridView.setAdapter((ListAdapter) bVar);
            tableLineGridView.setOnItemClickListener(new j(this, null));
            return tableLineGridView;
        }
        return (GridView) invokeLI.objValue;
    }

    @SuppressLint({"ResourceAsColor"})
    public final void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            int childCount = this.t.getChildCount();
            if (i2 < 0 || i2 >= childCount) {
                return;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                LinearLayout linearLayout = (LinearLayout) this.t.getChildAt(i3);
                TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091f58);
                View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f091f36);
                if (i3 != i2) {
                    SkinManager.setViewTextColor(textView, R.color.gift_tab_textcolor_normal, 1);
                    SkinManager.setBackgroundColor(findViewById, R.color.common_color_10022);
                    textView.setEnabled(true);
                    findViewById.setEnabled(true);
                } else {
                    SkinManager.setViewTextColor(textView, R.color.gift_tab_textcolor_selected, 1);
                    SkinManager.setBackgroundColor(findViewById, R.color.gift_tab_textcolor_selected);
                    textView.setEnabled(false);
                    findViewById.setEnabled(false);
                    x(i2);
                    this.P = i2;
                    this.s.scrollTo(linearLayout.getLeft(), 0);
                }
            }
        }
    }

    public void G() {
        c.a.o0.r.l0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.C) == null) {
            return;
        }
        aVar.h(false);
    }

    public final void H(ArrayList<c.a.p0.j1.b.c> arrayList, boolean z) {
        List<j0> subList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048583, this, arrayList, z) == null) || arrayList == null) {
            return;
        }
        this.R.clear();
        this.z.clear();
        this.q.setAdapter(null);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            List<j0> b2 = arrayList.get(i2).b();
            int size = b2 != null ? b2.size() : 0;
            int i3 = 1;
            if (size <= 0) {
                List<j0> arrayList2 = new ArrayList<>();
                if (!this.S.get(i2)) {
                    this.z.add(E(arrayList2, -1));
                } else {
                    this.z.add(D(true));
                }
            } else {
                int ceil = (int) Math.ceil(size / 8.0d);
                for (int i4 = 0; i4 < ceil; i4++) {
                    if (i4 == ceil - 1) {
                        int i5 = i4 * 8;
                        int i6 = size - 1;
                        if (i5 == i6) {
                            subList = new ArrayList<>();
                            subList.add(b2.get(i6));
                        } else {
                            subList = b2.subList(i5, size);
                        }
                    } else {
                        subList = b2.subList(i4 * 8, (i4 + 1) * 8);
                    }
                    if (i2 == 0 && i4 == 0 && z) {
                        this.z.add(E(subList, 0));
                        this.Q = subList.get(0);
                    } else {
                        this.z.add(E(subList, -1));
                    }
                }
                i3 = ceil;
            }
            this.R.append(i2, i3);
        }
        GiftPagerAdapter giftPagerAdapter = new GiftPagerAdapter(this.z);
        this.B = giftPagerAdapter;
        this.q.setAdapter(giftPagerAdapter);
        this.q.setCurrentItem(this.M);
        T();
    }

    public final void I(List<c.a.p0.j1.b.e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (c.a.p0.j1.b.e eVar : list) {
                    if (eVar.b() <= 0) {
                        arrayList.add(eVar);
                    }
                }
                list.removeAll(arrayList);
            }
            c.a.p0.j1.b.d dVar = new c.a.p0.j1.b.d(this.a.getPageContext().getPageActivity());
            this.A = dVar;
            this.y.setAdapter((ListAdapter) dVar);
            this.A.b(list);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f33119c = (FrameLayout) this.f33118b.findViewById(R.id.obfuscated_res_0x7f090cae);
            View findViewById = this.f33118b.findViewById(R.id.obfuscated_res_0x7f0908be);
            this.f33120d = findViewById;
            findViewById.setOnClickListener(new c(this));
            View findViewById2 = this.f33118b.findViewById(R.id.obfuscated_res_0x7f090c9f);
            this.f33122f = findViewById2;
            findViewById2.setOnClickListener(this.Z);
            this.f33121e = this.f33118b.findViewById(R.id.obfuscated_res_0x7f090ca5);
            EditText editText = (EditText) this.f33118b.findViewById(R.id.obfuscated_res_0x7f090c9e);
            this.f33123g = editText;
            editText.setSelection(1);
            w(false);
            this.f33123g.addTextChangedListener(new l(this, null));
            this.f33123g.setOnClickListener(new d(this));
            this.f33123g.setOnFocusChangeListener(new e(this));
            this.f33124h = this.f33118b.findViewById(R.id.obfuscated_res_0x7f091a87);
            this.i = (TextView) this.f33118b.findViewById(R.id.obfuscated_res_0x7f091a83);
            this.j = (TextView) this.f33118b.findViewById(R.id.obfuscated_res_0x7f091a85);
            this.k = (ImageView) this.f33118b.findViewById(R.id.obfuscated_res_0x7f091a86);
            this.f33124h.setOnClickListener(this.Y);
            this.l = (TextView) this.f33118b.findViewById(R.id.obfuscated_res_0x7f090ca0);
            TextView textView = (TextView) this.f33118b.findViewById(R.id.obfuscated_res_0x7f090c9d);
            this.m = textView;
            textView.setEnabled(false);
            this.m.setOnClickListener(this.W);
            TextView textView2 = (TextView) this.f33118b.findViewById(R.id.obfuscated_res_0x7f090ca2);
            this.n = textView2;
            textView2.setOnClickListener(this.Z);
            TextView textView3 = (TextView) this.f33118b.findViewById(R.id.obfuscated_res_0x7f090c8c);
            this.o = textView3;
            textView3.setOnClickListener(this.W);
            TextView textView4 = (TextView) this.f33118b.findViewById(R.id.obfuscated_res_0x7f091f5c);
            this.p = textView4;
            textView4.setOnClickListener(this.Z);
            this.u = this.f33118b.findViewById(R.id.obfuscated_res_0x7f090ca8);
            BaseViewPager baseViewPager = (BaseViewPager) this.f33118b.findViewById(R.id.obfuscated_res_0x7f090cba);
            this.q = baseViewPager;
            baseViewPager.setOnPageChangeListener(this);
            this.r = (IndicatorView) this.f33118b.findViewById(R.id.obfuscated_res_0x7f090cb5);
            this.t = (LinearLayout) this.f33118b.findViewById(R.id.obfuscated_res_0x7f090cb6);
            this.s = (HorizontalScrollView) this.f33118b.findViewById(R.id.obfuscated_res_0x7f090cb7);
            View findViewById3 = this.f33118b.findViewById(R.id.obfuscated_res_0x7f090cab);
            this.x = findViewById3;
            findViewById3.setOnClickListener(new f(this));
            ListView listView = (ListView) this.f33118b.findViewById(R.id.obfuscated_res_0x7f090cac);
            this.y = listView;
            listView.setOnItemClickListener(new k(this, null));
            this.w = (FrameLayout) this.f33118b.findViewById(R.id.obfuscated_res_0x7f091e3a);
            View D = D(false);
            this.v = D;
            D.setVisibility(8);
            this.w.addView(this.v);
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            c.a.o0.w0.a.a(this.a.getPageContext(), this.f33121e);
            SkinManager.setBackgroundResource(this.y, R.drawable.chx_box_im_gift);
            c.a.p0.j1.b.d dVar = this.A;
            if (dVar != null) {
                dVar.notifyDataSetChanged();
            }
            this.r.setSelector(SkinManager.getDrawable(R.drawable.point_live_s));
            this.r.setDrawable(SkinManager.getDrawable(R.drawable.point_live_n));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0274  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void L() {
        String str;
        long j2;
        String timeSpace;
        String format;
        String str2;
        String str3;
        String string;
        String string2;
        String formatOverBaiwanNum;
        String formatOverBaiwanNum2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048587, this) != null) {
            return;
        }
        if (this.a.accountType == 1) {
            this.f33118b.findViewById(R.id.obfuscated_res_0x7f090780).setVisibility(8);
            return;
        }
        j0 j0Var = this.Q;
        if (j0Var == null) {
            return;
        }
        int i2 = j0Var.f10894f;
        String str4 = "";
        if (StringUtils.isNull(j0Var.f10893e)) {
            str = "";
        } else {
            str = "\"" + this.Q.f10893e + "\" ";
        }
        if (i2 != 1) {
            if (i2 == 2) {
                str2 = "" + this.Q.k;
                str4 = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f09ce), Integer.valueOf(this.Q.k));
            } else if (i2 == 3) {
                if (CurrencySwitchUtil.isYyIsConvert(this.Q.s)) {
                    string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ce8);
                    string2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f04dc);
                    j0 j0Var2 = this.Q;
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(j0Var2.s, j0Var2.b());
                    j0 j0Var3 = this.Q;
                    formatOverBaiwanNum2 = CurrencyHelper.getFormatOverBaiwanNum(j0Var3.s, j0Var3.a());
                } else {
                    string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ce7);
                    string2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f04db);
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(this.Q.b());
                    formatOverBaiwanNum2 = StringHelper.formatOverBaiwanNum(this.Q.a());
                }
                String format2 = String.format(string, formatOverBaiwanNum);
                str2 = String.format(string2, formatOverBaiwanNum2);
                j2 = 0;
                str3 = format2;
                str4 = " " + format2 + GlideException.IndentedAppendable.INDENT + str2;
                if (i2 != 5 && this.G <= 0 && !StringUtils.isNull(this.H)) {
                    this.o.setVisibility(0);
                } else {
                    this.o.setVisibility(8);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) c.a.p0.j1.b.g.c(str4, str2, str3));
                this.n.setText(spannableStringBuilder);
                if (i2 == 1) {
                    this.g0.removeCallbacks(this.h0);
                    return;
                } else if (j2 > 0 && j2 <= 3600000) {
                    this.i0 = true;
                    this.g0.postDelayed(this.h0, 1000L);
                    return;
                } else if (this.i0) {
                    this.i0 = false;
                    this.g0.postDelayed(this.h0, 1000L);
                    return;
                } else {
                    return;
                }
            } else {
                if (i2 != 4 && i2 == 5) {
                    if (this.G > 0) {
                        String format3 = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ad3), Integer.valueOf(this.G));
                        this.f33123g.setText("" + this.G);
                        str4 = format3;
                        str2 = "" + this.G;
                    } else {
                        this.f33123g.setText("0");
                        this.m.setEnabled(false);
                        str4 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0814);
                    }
                }
                str3 = null;
                str2 = null;
            }
            str3 = null;
        } else {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            j0 j0Var4 = this.Q;
            if (currentTimeMillis > j0Var4.f10896h) {
                long j3 = j0Var4.i;
                if (currentTimeMillis < j3) {
                    j2 = (j3 - currentTimeMillis) * 1000;
                    timeSpace = StringHelper.getTimeSpace(j2);
                    format = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0795), timeSpace);
                    str2 = timeSpace;
                    str4 = format;
                    str3 = null;
                    if (i2 != 5) {
                    }
                    this.o.setVisibility(8);
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    SpannableString spannableString2 = new SpannableString(str);
                    spannableString2.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString2.length(), 33);
                    spannableStringBuilder2.append((CharSequence) spannableString2);
                    spannableStringBuilder2.append((CharSequence) c.a.p0.j1.b.g.c(str4, str2, str3));
                    this.n.setText(spannableStringBuilder2);
                    if (i2 == 1) {
                    }
                }
            }
            j0 j0Var5 = this.Q;
            long j4 = j0Var5.f10896h;
            if (currentTimeMillis < j4) {
                j2 = (j4 - currentTimeMillis) * 1000;
                timeSpace = StringHelper.getTimeSpace(j2);
                format = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0798), timeSpace);
                str2 = timeSpace;
                str4 = format;
                str3 = null;
                if (i2 != 5) {
                }
                this.o.setVisibility(8);
                SpannableStringBuilder spannableStringBuilder22 = new SpannableStringBuilder();
                SpannableString spannableString22 = new SpannableString(str);
                spannableString22.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString22.length(), 33);
                spannableStringBuilder22.append((CharSequence) spannableString22);
                spannableStringBuilder22.append((CharSequence) c.a.p0.j1.b.g.c(str4, str2, str3));
                this.n.setText(spannableStringBuilder22);
                if (i2 == 1) {
                }
            } else {
                str4 = currentTimeMillis > j0Var5.i ? this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0796) : null;
                str3 = null;
                str2 = null;
            }
        }
        j2 = 0;
        if (i2 != 5) {
        }
        this.o.setVisibility(8);
        SpannableStringBuilder spannableStringBuilder222 = new SpannableStringBuilder();
        SpannableString spannableString222 = new SpannableString(str);
        spannableString222.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString222.length(), 33);
        spannableStringBuilder222.append((CharSequence) spannableString222);
        spannableStringBuilder222.append((CharSequence) c.a.p0.j1.b.g.c(str4, str2, str3));
        this.n.setText(spannableStringBuilder222);
        if (i2 == 1) {
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.H = str;
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.G = i2;
            j0 j0Var = this.Q;
            if (j0Var == null || j0Var.f10894f != 5) {
                return;
            }
            L();
        }
    }

    public void O(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, oVar) == null) {
            this.K = oVar;
        }
    }

    public void P(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, nVar) == null) {
            this.L = nVar;
        }
    }

    public void Q(boolean z, ArrayList<c.a.p0.j1.b.c> arrayList, ArrayList<c.a.p0.j1.b.a> arrayList2, ArrayList<c.a.p0.j1.b.e> arrayList3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), arrayList, arrayList2, arrayList3}) == null) {
            this.D = arrayList;
            this.E = arrayList2;
            this.F = arrayList3;
            U(z);
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.C == null) {
                this.C = new c.a.o0.r.l0.a(this.a.getPageContext());
            }
            this.C.h(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void S() {
        j0 j0Var;
        int i2;
        String str;
        long j2;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || (j0Var = this.Q) == null || (i2 = j0Var.f10894f) != 1) {
            return;
        }
        if (StringUtils.isNull(j0Var.f10893e)) {
            str = "";
        } else {
            str = "\"" + this.Q.f10893e + "\" ";
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        j0 j0Var2 = this.Q;
        if (currentTimeMillis > j0Var2.f10896h) {
            long j3 = j0Var2.i;
            if (currentTimeMillis < j3) {
                j2 = (j3 - currentTimeMillis) * 1000;
                str2 = StringHelper.getTimeSpace(j2);
                str3 = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0795), str2);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) c.a.p0.j1.b.g.c(str3, str2, null));
                this.n.setText(spannableStringBuilder);
                if (i2 == 1) {
                    this.g0.removeCallbacks(this.h0);
                    return;
                } else if (j2 > 0 && j2 <= 3600000) {
                    this.i0 = true;
                    this.g0.postDelayed(this.h0, 1000L);
                    return;
                } else if (this.i0) {
                    this.i0 = false;
                    this.g0.postDelayed(this.h0, 1000L);
                    return;
                } else {
                    return;
                }
            }
        }
        j0 j0Var3 = this.Q;
        long j4 = j0Var3.f10896h;
        if (currentTimeMillis < j4) {
            j2 = (j4 - currentTimeMillis) * 1000;
            str2 = StringHelper.getTimeSpace(j2);
            str3 = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0798), str2);
        } else if (currentTimeMillis > j0Var3.i) {
            str3 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0796);
            j2 = 0;
            str2 = null;
        } else {
            j2 = 0;
            str2 = null;
            str3 = null;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        SpannableString spannableString2 = new SpannableString(str);
        spannableString2.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString2.length(), 33);
        spannableStringBuilder2.append((CharSequence) spannableString2);
        spannableStringBuilder2.append((CharSequence) c.a.p0.j1.b.g.c(str3, str2, null));
        this.n.setText(spannableStringBuilder2);
        if (i2 == 1) {
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.R.size(); i3++) {
                for (int i4 = 0; i4 < this.R.get(i3); i4++) {
                    if (i2 + i4 == this.M) {
                        if (this.R.get(i3) <= 1) {
                            this.r.setVisibility(4);
                        } else {
                            this.r.setVisibility(0);
                        }
                        this.r.setCount(this.R.get(i3));
                        this.r.setPosition(i4);
                        F(i3);
                        return;
                    }
                }
                i2 += this.R.get(i3);
            }
        }
    }

    public final void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            z();
            G();
            ArrayList<c.a.p0.j1.b.c> arrayList = this.D;
            if (arrayList != null && arrayList.size() > 0) {
                this.m.setEnabled(true);
                this.v.setVisibility(8);
                this.u.setVisibility(0);
                if (z) {
                    v(this.E);
                    I(this.F);
                }
                H(this.D, z);
                L();
                y(true);
                return;
            }
            this.u.setVisibility(8);
            this.v.setVisibility(0);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.M = i2;
            T();
            if (i2 < 0 || i2 >= this.z.size() || !(this.z.get(i2) instanceof GridView)) {
                return;
            }
            GridView gridView = (GridView) this.z.get(i2);
            if (gridView.getAdapter() != null) {
                c.a.p0.j1.b.b bVar = (c.a.p0.j1.b.b) gridView.getAdapter();
                if (bVar.b() >= 0 && i2 != this.N) {
                    bVar.d(-1);
                    bVar.notifyDataSetChanged();
                }
                if (bVar.b() >= 0 || i2 != this.N) {
                    return;
                }
                bVar.d(this.O);
                bVar.notifyDataSetChanged();
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void v(ArrayList<c.a.p0.j1.b.a> arrayList) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, arrayList) == null) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.t.removeAllViews();
        int size = arrayList.size();
        int k2 = c.a.d.f.p.n.k(this.a.getPageContext().getPageActivity());
        if (size >= 5) {
            i2 = k2 / 5;
        } else {
            i2 = k2 / size;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        for (int i3 = 0; i3 < size; i3++) {
            c.a.p0.j1.b.a aVar = arrayList.get(i3);
            if (!TextUtils.isEmpty(aVar.b()) && aVar.c() != null && aVar.c().size() > 0) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0387, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091f58);
                textView.setText(aVar.b());
                linearLayout.setOnClickListener(new m(this, i3));
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.END);
                this.t.addView(linearLayout, layoutParams);
            }
        }
        F(this.P);
    }

    public final void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.f33123g.setCursorVisible(z);
            this.f33123g.setFocusable(z);
            this.f33123g.setFocusableInTouchMode(z);
            if (z) {
                this.f33123g.requestFocus();
            } else {
                this.f33123g.clearFocus();
            }
        }
    }

    public final void x(int i2) {
        ArrayList<c.a.p0.j1.b.c> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            int childCount = this.t.getChildCount();
            if (i2 < 0 || i2 >= childCount || (arrayList = this.D) == null || arrayList.size() <= i2 || this.D.get(i2) == null || this.S.get(i2)) {
                return;
            }
            if ((this.D.get(i2).b() == null || this.D.get(i2).b().size() <= 0) && this.K != null) {
                this.S.append(i2, true);
                this.K.a(this.D.get(i2).a());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float y(boolean z) {
        InterceptResult invokeZ;
        long a2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeZ = interceptable.invokeZ(1048603, this, z)) != null) {
            return invokeZ.floatValue;
        }
        if (this.Q == null) {
            return 0.0f;
        }
        int e2 = c.a.d.f.m.b.e(this.f33123g.getText().toString(), 0);
        this.X = e2;
        j0 j0Var = this.Q;
        int i2 = j0Var.f10894f;
        int i3 = j0Var.s;
        if (i2 == 3) {
            if (j0Var.a() >= 0) {
                a2 = this.Q.a();
                j2 = a2 * e2;
                if (z) {
                }
            }
            a2 = 0;
            j2 = a2 * e2;
            if (z) {
            }
        } else if (i2 != 5) {
            if (j0Var.b() >= 0) {
                a2 = this.Q.b();
                j2 = a2 * e2;
                if (z) {
                    this.l.setText(c.a.p0.j1.b.g.b(j2, true, i3));
                    if (e2 <= 0) {
                        SkinManager.setBackgroundResource(this.m, R.drawable.btn_gift_give_d);
                        this.m.setEnabled(false);
                    } else if (i2 == 1) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        j0 j0Var2 = this.Q;
                        if (currentTimeMillis >= j0Var2.f10896h && currentTimeMillis <= j0Var2.i) {
                            SkinManager.setBackgroundResource(this.m, R.drawable.orange_btn_selector);
                            this.m.setEnabled(true);
                        } else {
                            SkinManager.setBackgroundResource(this.m, R.drawable.btn_gift_give_d);
                            this.m.setEnabled(false);
                        }
                    } else {
                        SkinManager.setBackgroundResource(this.m, R.drawable.orange_btn_selector);
                        this.m.setEnabled(true);
                    }
                    int i4 = this.Q.q;
                    this.i.setText(c.a.p0.j1.b.g.a((i4 >= 0 ? i4 : 0L) * e2, this.I, i3));
                    return (float) j2;
                }
                return (float) j2;
            }
            a2 = 0;
            j2 = a2 * e2;
            if (z) {
            }
        } else {
            j2 = 0;
            if (z) {
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || ListUtils.getCount(this.E) == 0 || ListUtils.getCount(this.D) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<c.a.p0.j1.b.a> it = this.E.iterator();
        while (it.hasNext()) {
            c.a.p0.j1.b.a next = it.next();
            if (next != null && (TextUtils.isEmpty(next.b()) || ListUtils.getCount(next.c()) == 0)) {
                arrayList.add(next);
                Iterator<c.a.p0.j1.b.c> it2 = this.D.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    c.a.p0.j1.b.c next2 = it2.next();
                    if (next2 != null && next2.a() == next.a()) {
                        arrayList2.add(next2);
                        break;
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            this.E.removeAll(arrayList);
        }
        if (arrayList2.size() > 0) {
            this.D.removeAll(arrayList2);
        }
    }
}

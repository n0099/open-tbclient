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
import d.a.r0.r.q.j0;
import d.a.r0.r.q.k0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class GiftTabView implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout A;
    public View B;
    public ListView C;
    public List<View> D;
    public d.a.s0.y0.b.d E;
    public GiftPagerAdapter F;
    public d.a.r0.r.f0.a G;
    public ArrayList<d.a.s0.y0.b.c> H;
    public ArrayList<d.a.s0.y0.b.a> I;
    public ArrayList<d.a.s0.y0.b.e> J;
    public int K;
    public String L;
    public int M;
    public k0 N;
    public o O;
    public n P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public j0 U;
    public SparseIntArray V;
    public SparseBooleanArray W;
    public int X;
    public int Y;
    public int Z;
    public View.OnClickListener a0;
    public int b0;
    public View.OnClickListener c0;

    /* renamed from: e  reason: collision with root package name */
    public GiftTabActivity f16325e;

    /* renamed from: f  reason: collision with root package name */
    public View f16326f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f16327g;

    /* renamed from: h  reason: collision with root package name */
    public View f16328h;

    /* renamed from: i  reason: collision with root package name */
    public View f16329i;
    public View.OnClickListener i0;
    public View j;
    public Handler j0;
    public EditText k;
    public Runnable k0;
    public View l;
    public boolean l0;
    public TextView m;
    public TextView n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public BaseViewPager u;
    public IndicatorView v;
    public HorizontalScrollView w;
    public LinearLayout x;
    public View y;
    public View z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f16330e;

        public a(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16330e = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f16330e.N.f55995b)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f16330e.f16325e.getPageContext(), new String[]{this.f16330e.N.f55995b});
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f16331e;

        public b(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16331e = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.c.e.p.l.x(this.f16331e.f16325e.getPageContext().getPageActivity(), this.f16331e.k);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f16332e;

        public c(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16332e = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f16332e.B.getVisibility() != 0) {
                    this.f16332e.f16325e.closeActivity();
                } else {
                    this.f16332e.B.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f16333e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f16334e;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f16334e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f16334e.f16333e.w(false);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f16334e.f16333e.Y, -2);
                    int[] iArr = new int[2];
                    this.f16334e.f16333e.k.getLocationOnScreen(iArr);
                    layoutParams.leftMargin = iArr[0] - this.f16334e.f16333e.Z;
                    int i2 = (iArr[1] - this.f16334e.f16333e.X) - this.f16334e.f16333e.Z;
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        i2 += UtilHelper.getStatusBarHeight();
                    }
                    layoutParams.topMargin = i2;
                    this.f16334e.f16333e.C.setLayoutParams(layoutParams);
                    this.f16334e.f16333e.B.setVisibility(0);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16333e = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.c.e.p.l.x(this.f16333e.f16325e.getPageContext().getPageActivity(), this.f16333e.k);
                this.f16333e.f16325e.mHandler.postDelayed(new a(this), 200L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f16335e;

        public e(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16335e = giftTabView;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (z) {
                    d.a.c.e.p.l.K(this.f16335e.f16325e.getPageContext().getPageActivity(), this.f16335e.k);
                } else {
                    d.a.c.e.p.l.x(this.f16335e.f16325e.getPageContext().getPageActivity(), this.f16335e.k);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f16336e;

        public f(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16336e = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f16336e.B.setVisibility(8);
                d.a.c.e.p.l.x(this.f16336e.f16325e.getPageContext().getPageActivity(), this.f16336e.k);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f16337e;

        public g(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16337e = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16337e.O == null) {
                return;
            }
            this.f16337e.W.append(this.f16337e.T, true);
            this.f16337e.O.a(((d.a.s0.y0.b.c) this.f16337e.H.get(this.f16337e.T)).a());
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f16338e;

        public h(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16338e = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16338e.P == null) {
                return;
            }
            this.f16338e.P.a();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f16339e;

        public i(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16339e = giftTabView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f16339e.S();
                this.f16339e.y(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f16340e;

        public j(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16340e = giftTabView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                GiftTabView giftTabView = this.f16340e;
                giftTabView.R = giftTabView.Q;
                this.f16340e.S = i2;
                d.a.c.e.p.l.x(this.f16340e.f16325e.getPageContext().getPageActivity(), this.f16340e.k);
                d.a.s0.y0.b.b bVar = (d.a.s0.y0.b.b) adapterView.getAdapter();
                if (bVar != null) {
                    j0 item = bVar.getItem(i2);
                    if (item != null) {
                        this.f16340e.U = item;
                    }
                    bVar.d(i2);
                    bVar.notifyDataSetChanged();
                }
                this.f16340e.L();
                this.f16340e.y(true);
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f16341e;

        public k(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16341e = giftTabView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                if (this.f16341e.J == null || this.f16341e.J.size() <= 0) {
                    this.f16341e.w(true);
                    Selection.selectAll(this.f16341e.k.getText());
                    this.f16341e.B.setVisibility(8);
                    this.f16341e.y(true);
                    return;
                }
                if (i2 == this.f16341e.J.size()) {
                    this.f16341e.w(true);
                    Selection.selectAll(this.f16341e.k.getText());
                } else {
                    this.f16341e.k.setCursorVisible(true);
                    this.f16341e.k.setFocusable(true);
                    d.a.s0.y0.b.e eVar = (d.a.s0.y0.b.e) this.f16341e.J.get(i2);
                    if (eVar != null) {
                        EditText editText = this.f16341e.k;
                        editText.setText("" + eVar.b());
                    }
                }
                this.f16341e.B.setVisibility(8);
                this.f16341e.y(true);
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f16342e;

        public l(GiftTabView giftTabView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16342e = giftTabView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int d2 = d.a.c.e.m.b.d(editable.toString(), 0);
                if (editable.toString().length() == String.valueOf(d2).length()) {
                    this.f16342e.y(true);
                    return;
                }
                int i2 = d2 >= 0 ? d2 : 0;
                EditText editText = this.f16342e.k;
                editText.setText("" + i2);
                this.f16342e.k.setSelection(String.valueOf(i2).length());
            }
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

        /* renamed from: e  reason: collision with root package name */
        public int f16343e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f16344f;

        public m(GiftTabView giftTabView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {giftTabView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16344f = giftTabView;
            this.f16343e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int min = Math.min(this.f16343e, this.f16344f.V.size());
                int i2 = 0;
                for (int i3 = 0; i3 < min; i3++) {
                    i2 += this.f16344f.V.get(i3);
                }
                this.f16344f.Q = i2;
                GiftTabView giftTabView = this.f16344f;
                giftTabView.u.setCurrentItem(giftTabView.Q);
                this.f16344f.T();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface n {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface o {
        void a(int i2);
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
        this.D = new ArrayList();
        this.K = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.V = new SparseIntArray();
        this.W = new SparseBooleanArray();
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.c0 = new a(this);
        this.i0 = new b(this);
        this.j0 = new Handler();
        this.k0 = new i(this);
        this.l0 = false;
        this.f16325e = giftTabActivity;
        this.a0 = onClickListener;
        View inflate = LayoutInflater.from(giftTabActivity.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_activity, (ViewGroup) null);
        this.f16326f = inflate;
        this.f16325e.setContentView(inflate);
        J();
        this.X = d.a.c.e.p.l.r(this.f16325e.getActivity());
        this.Y = d.a.c.e.p.l.g(this.f16325e.getActivity(), R.dimen.ds330);
        this.Z = d.a.c.e.p.l.g(this.f16325e.getActivity(), R.dimen.ds10);
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j0.removeCallbacks(this.k0);
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b0 : invokeV.intValue;
    }

    public j0 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.U : (j0) invokeV.objValue;
    }

    public final View D(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            View inflate = LayoutInflater.from(this.f16325e.getPageContext().getPageActivity()).inflate(R.layout.gift_nodata_view, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.net_refresh_button);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource((TbImageView) inflate.findViewById(R.id.net_refresh_image), R.drawable.new_pic_emotion_08);
            SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.net_refresh_title), R.color.CAM_X0105, 1, skinType);
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
            d.a.s0.y0.b.b bVar = new d.a.s0.y0.b.b(this.f16325e.getPageContext().getPageActivity());
            bVar.c(list);
            bVar.d(i2);
            TableLineGridView tableLineGridView = new TableLineGridView(this.f16325e.getPageContext().getPageActivity());
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
            int childCount = this.x.getChildCount();
            if (i2 < 0 || i2 >= childCount) {
                return;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                LinearLayout linearLayout = (LinearLayout) this.x.getChildAt(i3);
                TextView textView = (TextView) linearLayout.findViewById(R.id.text_view);
                View findViewById = linearLayout.findViewById(R.id.text_divider_line);
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
                    this.T = i2;
                    this.w.scrollTo(linearLayout.getLeft(), 0);
                }
            }
        }
    }

    public void G() {
        d.a.r0.r.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (aVar = this.G) == null) {
            return;
        }
        aVar.h(false);
    }

    public final void H(ArrayList<d.a.s0.y0.b.c> arrayList, boolean z) {
        List<j0> subList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048583, this, arrayList, z) == null) || arrayList == null) {
            return;
        }
        this.V.clear();
        this.D.clear();
        this.u.setAdapter(null);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            List<j0> b2 = arrayList.get(i2).b();
            int size = b2 != null ? b2.size() : 0;
            int i3 = 1;
            if (size <= 0) {
                List<j0> arrayList2 = new ArrayList<>();
                if (!this.W.get(i2)) {
                    this.D.add(E(arrayList2, -1));
                } else {
                    this.D.add(D(true));
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
                        this.D.add(E(subList, 0));
                        this.U = subList.get(0);
                    } else {
                        this.D.add(E(subList, -1));
                    }
                }
                i3 = ceil;
            }
            this.V.append(i2, i3);
        }
        GiftPagerAdapter giftPagerAdapter = new GiftPagerAdapter(this.D);
        this.F = giftPagerAdapter;
        this.u.setAdapter(giftPagerAdapter);
        this.u.setCurrentItem(this.Q);
        T();
    }

    public final void I(List<d.a.s0.y0.b.e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (d.a.s0.y0.b.e eVar : list) {
                    if (eVar.b() <= 0) {
                        arrayList.add(eVar);
                    }
                }
                list.removeAll(arrayList);
            }
            d.a.s0.y0.b.d dVar = new d.a.s0.y0.b.d(this.f16325e.getPageContext().getPageActivity());
            this.E = dVar;
            this.C.setAdapter((ListAdapter) dVar);
            this.E.b(list);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f16327g = (FrameLayout) this.f16326f.findViewById(R.id.gift_panel_lay);
            View findViewById = this.f16326f.findViewById(R.id.empty_layout);
            this.f16328h = findViewById;
            findViewById.setOnClickListener(new c(this));
            View findViewById2 = this.f16326f.findViewById(R.id.gift_count_layout);
            this.j = findViewById2;
            findViewById2.setOnClickListener(this.i0);
            this.f16329i = this.f16326f.findViewById(R.id.gift_list_layout);
            EditText editText = (EditText) this.f16326f.findViewById(R.id.gift_count_input);
            this.k = editText;
            editText.setSelection(1);
            w(false);
            this.k.addTextChangedListener(new l(this, null));
            this.k.setOnClickListener(new d(this));
            this.k.setOnFocusChangeListener(new e(this));
            this.l = this.f16326f.findViewById(R.id.reward_parent_view);
            this.m = (TextView) this.f16326f.findViewById(R.id.reward_count_result);
            this.n = (TextView) this.f16326f.findViewById(R.id.reward_jump);
            this.o = (ImageView) this.f16326f.findViewById(R.id.reward_jump_arrow);
            this.l.setOnClickListener(this.c0);
            this.p = (TextView) this.f16326f.findViewById(R.id.gift_count_result);
            TextView textView = (TextView) this.f16326f.findViewById(R.id.gift_button);
            this.q = textView;
            textView.setEnabled(false);
            this.q.setOnClickListener(this.a0);
            TextView textView2 = (TextView) this.f16326f.findViewById(R.id.gift_desc_view);
            this.r = textView2;
            textView2.setOnClickListener(this.i0);
            TextView textView3 = (TextView) this.f16326f.findViewById(R.id.get_free_chance_view);
            this.s = textView3;
            textView3.setOnClickListener(this.a0);
            TextView textView4 = (TextView) this.f16326f.findViewById(R.id.text_view_gift_to);
            this.t = textView4;
            textView4.setOnClickListener(this.i0);
            this.y = this.f16326f.findViewById(R.id.gift_lower_layout);
            BaseViewPager baseViewPager = (BaseViewPager) this.f16326f.findViewById(R.id.gift_viewpager);
            this.u = baseViewPager;
            baseViewPager.setOnPageChangeListener(this);
            this.v = (IndicatorView) this.f16326f.findViewById(R.id.gift_tab_indicator);
            this.x = (LinearLayout) this.f16326f.findViewById(R.id.gift_tab_layout);
            this.w = (HorizontalScrollView) this.f16326f.findViewById(R.id.gift_tab_scrollview);
            View findViewById3 = this.f16326f.findViewById(R.id.gift_num_layout);
            this.B = findViewById3;
            findViewById3.setOnClickListener(new f(this));
            ListView listView = (ListView) this.f16326f.findViewById(R.id.gift_num_list);
            this.C = listView;
            listView.setOnItemClickListener(new k(this, null));
            this.A = (FrameLayout) this.f16326f.findViewById(R.id.tab_container_view);
            View D = D(false);
            this.z = D;
            D.setVisibility(8);
            this.A.addView(this.z);
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            d.a.r0.s0.a.a(this.f16325e.getPageContext(), this.f16329i);
            SkinManager.setBackgroundResource(this.C, R.drawable.chx_box_im_gift);
            d.a.s0.y0.b.d dVar = this.E;
            if (dVar != null) {
                dVar.notifyDataSetChanged();
            }
            this.v.setSelector(SkinManager.getDrawable(R.drawable.point_live_s));
            this.v.setDrawable(SkinManager.getDrawable(R.drawable.point_live_n));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0267  */
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
        if (this.f16325e.accountType == 1) {
            this.f16326f.findViewById(R.id.desc_parent_view).setVisibility(8);
            return;
        }
        j0 j0Var = this.U;
        if (j0Var == null) {
            return;
        }
        int i2 = j0Var.f55986f;
        String str4 = "";
        if (StringUtils.isNull(j0Var.f55985e)) {
            str = "";
        } else {
            str = "\"" + this.U.f55985e + "\" ";
        }
        if (i2 != 1) {
            if (i2 == 2) {
                str2 = "" + this.U.k;
                str4 = String.format(this.f16325e.getPageContext().getString(R.string.left_number), Integer.valueOf(this.U.k));
            } else if (i2 == 3) {
                if (CurrencySwitchUtil.isYyIsConvert(this.U.s)) {
                    string = this.f16325e.getPageContext().getString(R.string.original_price_ybean);
                    string2 = this.f16325e.getPageContext().getString(R.string.discount_price_ybean);
                    j0 j0Var2 = this.U;
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(j0Var2.s, j0Var2.b());
                    j0 j0Var3 = this.U;
                    formatOverBaiwanNum2 = CurrencyHelper.getFormatOverBaiwanNum(j0Var3.s, j0Var3.a());
                } else {
                    string = this.f16325e.getPageContext().getString(R.string.original_price);
                    string2 = this.f16325e.getPageContext().getString(R.string.discount_price);
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(this.U.b());
                    formatOverBaiwanNum2 = StringHelper.formatOverBaiwanNum(this.U.a());
                }
                String format2 = String.format(string, formatOverBaiwanNum);
                str2 = String.format(string2, formatOverBaiwanNum2);
                j2 = 0;
                str3 = format2;
                str4 = " " + format2 + GlideException.IndentedAppendable.INDENT + str2;
                if (i2 != 5 && this.K <= 0 && !StringUtils.isNull(this.L)) {
                    this.s.setVisibility(0);
                } else {
                    this.s.setVisibility(8);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) d.a.s0.y0.b.g.c(str4, str2, str3));
                this.r.setText(spannableStringBuilder);
                if (i2 == 1) {
                    this.j0.removeCallbacks(this.k0);
                    return;
                } else if (j2 > 0 && j2 <= 3600000) {
                    this.l0 = true;
                    this.j0.postDelayed(this.k0, 1000L);
                    return;
                } else if (this.l0) {
                    this.l0 = false;
                    this.j0.postDelayed(this.k0, 1000L);
                    return;
                } else {
                    return;
                }
            } else {
                if (i2 != 4 && i2 == 5) {
                    if (this.K > 0) {
                        String format3 = String.format(this.f16325e.getPageContext().getString(R.string.most_free_gift), Integer.valueOf(this.K));
                        this.k.setText("" + this.K);
                        str4 = format3;
                        str2 = "" + this.K;
                    } else {
                        this.k.setText("0");
                        this.q.setEnabled(false);
                        str4 = this.f16325e.getPageContext().getString(R.string.have_no_free_chance);
                    }
                }
                str3 = null;
                str2 = null;
            }
            str3 = null;
        } else {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            j0 j0Var4 = this.U;
            if (currentTimeMillis > j0Var4.f55988h) {
                long j3 = j0Var4.f55989i;
                if (currentTimeMillis < j3) {
                    j2 = (j3 - currentTimeMillis) * 1000;
                    timeSpace = StringHelper.getTimeSpace(j2);
                    format = String.format(this.f16325e.getPageContext().getString(R.string.gift_limit_time_end), timeSpace);
                    str2 = timeSpace;
                    str4 = format;
                    str3 = null;
                    if (i2 != 5) {
                    }
                    this.s.setVisibility(8);
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    SpannableString spannableString2 = new SpannableString(str);
                    spannableString2.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString2.length(), 33);
                    spannableStringBuilder2.append((CharSequence) spannableString2);
                    spannableStringBuilder2.append((CharSequence) d.a.s0.y0.b.g.c(str4, str2, str3));
                    this.r.setText(spannableStringBuilder2);
                    if (i2 == 1) {
                    }
                }
            }
            j0 j0Var5 = this.U;
            long j4 = j0Var5.f55988h;
            if (currentTimeMillis < j4) {
                j2 = (j4 - currentTimeMillis) * 1000;
                timeSpace = StringHelper.getTimeSpace(j2);
                format = String.format(this.f16325e.getPageContext().getString(R.string.gift_limit_time_start), timeSpace);
                str2 = timeSpace;
                str4 = format;
                str3 = null;
                if (i2 != 5) {
                }
                this.s.setVisibility(8);
                SpannableStringBuilder spannableStringBuilder22 = new SpannableStringBuilder();
                SpannableString spannableString22 = new SpannableString(str);
                spannableString22.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString22.length(), 33);
                spannableStringBuilder22.append((CharSequence) spannableString22);
                spannableStringBuilder22.append((CharSequence) d.a.s0.y0.b.g.c(str4, str2, str3));
                this.r.setText(spannableStringBuilder22);
                if (i2 == 1) {
                }
            } else {
                str4 = currentTimeMillis > j0Var5.f55989i ? this.f16325e.getPageContext().getString(R.string.gift_limit_time_has_over) : null;
                str3 = null;
                str2 = null;
            }
        }
        j2 = 0;
        if (i2 != 5) {
        }
        this.s.setVisibility(8);
        SpannableStringBuilder spannableStringBuilder222 = new SpannableStringBuilder();
        SpannableString spannableString222 = new SpannableString(str);
        spannableString222.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString222.length(), 33);
        spannableStringBuilder222.append((CharSequence) spannableString222);
        spannableStringBuilder222.append((CharSequence) d.a.s0.y0.b.g.c(str4, str2, str3));
        this.r.setText(spannableStringBuilder222);
        if (i2 == 1) {
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.L = str;
        }
    }

    public void N(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.K = i2;
            j0 j0Var = this.U;
            if (j0Var == null || j0Var.f55986f != 5) {
                return;
            }
            L();
        }
    }

    public void O(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, oVar) == null) {
            this.O = oVar;
        }
    }

    public void P(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, nVar) == null) {
            this.P = nVar;
        }
    }

    public void Q(boolean z, ArrayList<d.a.s0.y0.b.c> arrayList, ArrayList<d.a.s0.y0.b.a> arrayList2, ArrayList<d.a.s0.y0.b.e> arrayList3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), arrayList, arrayList2, arrayList3}) == null) {
            this.H = arrayList;
            this.I = arrayList2;
            this.J = arrayList3;
            U(z);
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.G == null) {
                this.G = new d.a.r0.r.f0.a(this.f16325e.getPageContext());
            }
            this.G.h(true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fd  */
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
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || (j0Var = this.U) == null || (i2 = j0Var.f55986f) != 1) {
            return;
        }
        if (StringUtils.isNull(j0Var.f55985e)) {
            str = "";
        } else {
            str = "\"" + this.U.f55985e + "\" ";
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        j0 j0Var2 = this.U;
        if (currentTimeMillis > j0Var2.f55988h) {
            long j3 = j0Var2.f55989i;
            if (currentTimeMillis < j3) {
                j2 = (j3 - currentTimeMillis) * 1000;
                str2 = StringHelper.getTimeSpace(j2);
                str3 = String.format(this.f16325e.getPageContext().getString(R.string.gift_limit_time_end), str2);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) d.a.s0.y0.b.g.c(str3, str2, null));
                this.r.setText(spannableStringBuilder);
                if (i2 == 1) {
                    this.j0.removeCallbacks(this.k0);
                    return;
                } else if (j2 > 0 && j2 <= 3600000) {
                    this.l0 = true;
                    this.j0.postDelayed(this.k0, 1000L);
                    return;
                } else if (this.l0) {
                    this.l0 = false;
                    this.j0.postDelayed(this.k0, 1000L);
                    return;
                } else {
                    return;
                }
            }
        }
        j0 j0Var3 = this.U;
        long j4 = j0Var3.f55988h;
        if (currentTimeMillis < j4) {
            j2 = (j4 - currentTimeMillis) * 1000;
            str2 = StringHelper.getTimeSpace(j2);
            str3 = String.format(this.f16325e.getPageContext().getString(R.string.gift_limit_time_start), str2);
        } else if (currentTimeMillis > j0Var3.f55989i) {
            str3 = this.f16325e.getPageContext().getString(R.string.gift_limit_time_has_over);
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
        spannableStringBuilder2.append((CharSequence) d.a.s0.y0.b.g.c(str3, str2, null));
        this.r.setText(spannableStringBuilder2);
        if (i2 == 1) {
        }
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.V.size(); i3++) {
                for (int i4 = 0; i4 < this.V.get(i3); i4++) {
                    if (i2 + i4 == this.Q) {
                        if (this.V.get(i3) <= 1) {
                            this.v.setVisibility(4);
                        } else {
                            this.v.setVisibility(0);
                        }
                        this.v.setCount(this.V.get(i3));
                        this.v.setPosition(i4);
                        F(i3);
                        return;
                    }
                }
                i2 += this.V.get(i3);
            }
        }
    }

    public final void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            z();
            G();
            ArrayList<d.a.s0.y0.b.c> arrayList = this.H;
            if (arrayList != null && arrayList.size() > 0) {
                this.q.setEnabled(true);
                this.z.setVisibility(8);
                this.y.setVisibility(0);
                if (z) {
                    v(this.I);
                    I(this.J);
                }
                H(this.H, z);
                L();
                y(true);
                return;
            }
            this.y.setVisibility(8);
            this.z.setVisibility(0);
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
            this.Q = i2;
            T();
            if (i2 < 0 || i2 >= this.D.size() || !(this.D.get(i2) instanceof GridView)) {
                return;
            }
            GridView gridView = (GridView) this.D.get(i2);
            if (gridView.getAdapter() != null) {
                d.a.s0.y0.b.b bVar = (d.a.s0.y0.b.b) gridView.getAdapter();
                if (bVar.b() >= 0 && i2 != this.R) {
                    bVar.d(-1);
                    bVar.notifyDataSetChanged();
                }
                if (bVar.b() >= 0 || i2 != this.R) {
                    return;
                }
                bVar.d(this.S);
                bVar.notifyDataSetChanged();
            }
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void v(ArrayList<d.a.s0.y0.b.a> arrayList) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, arrayList) == null) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.x.removeAllViews();
        int size = arrayList.size();
        int k2 = d.a.c.e.p.l.k(this.f16325e.getPageContext().getPageActivity());
        if (size >= 5) {
            i2 = k2 / 5;
        } else {
            i2 = k2 / size;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        for (int i3 = 0; i3 < size; i3++) {
            d.a.s0.y0.b.a aVar = arrayList.get(i3);
            if (!TextUtils.isEmpty(aVar.b()) && aVar.c() != null && aVar.c().size() > 0) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f16325e.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_item, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(R.id.text_view);
                textView.setText(aVar.b());
                linearLayout.setOnClickListener(new m(this, i3));
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.END);
                this.x.addView(linearLayout, layoutParams);
            }
        }
        F(this.T);
    }

    public final void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.k.setCursorVisible(z);
            this.k.setFocusable(z);
            this.k.setFocusableInTouchMode(z);
            if (z) {
                this.k.requestFocus();
            } else {
                this.k.clearFocus();
            }
        }
    }

    public final void x(int i2) {
        ArrayList<d.a.s0.y0.b.c> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            int childCount = this.x.getChildCount();
            if (i2 < 0 || i2 >= childCount || (arrayList = this.H) == null || arrayList.size() <= i2 || this.H.get(i2) == null || this.W.get(i2)) {
                return;
            }
            if ((this.H.get(i2).b() == null || this.H.get(i2).b().size() <= 0) && this.O != null) {
                this.W.append(i2, true);
                this.O.a(this.H.get(i2).a());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
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
        if (this.U == null) {
            return 0.0f;
        }
        int d2 = d.a.c.e.m.b.d(this.k.getText().toString(), 0);
        this.b0 = d2;
        j0 j0Var = this.U;
        int i2 = j0Var.f55986f;
        int i3 = j0Var.s;
        if (i2 == 3) {
            if (j0Var.a() >= 0) {
                a2 = this.U.a();
                j2 = a2 * d2;
                if (z) {
                }
            }
            a2 = 0;
            j2 = a2 * d2;
            if (z) {
            }
        } else if (i2 != 5) {
            if (j0Var.b() >= 0) {
                a2 = this.U.b();
                j2 = a2 * d2;
                if (z) {
                    this.p.setText(d.a.s0.y0.b.g.b(j2, true, i3));
                    if (d2 <= 0) {
                        SkinManager.setBackgroundResource(this.q, R.drawable.btn_gift_give_d);
                        this.q.setEnabled(false);
                    } else if (i2 == 1) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        j0 j0Var2 = this.U;
                        if (currentTimeMillis >= j0Var2.f55988h && currentTimeMillis <= j0Var2.f55989i) {
                            SkinManager.setBackgroundResource(this.q, R.drawable.orange_btn_selector);
                            this.q.setEnabled(true);
                        } else {
                            SkinManager.setBackgroundResource(this.q, R.drawable.btn_gift_give_d);
                            this.q.setEnabled(false);
                        }
                    } else {
                        SkinManager.setBackgroundResource(this.q, R.drawable.orange_btn_selector);
                        this.q.setEnabled(true);
                    }
                    int i4 = this.U.q;
                    this.m.setText(d.a.s0.y0.b.g.a((i4 >= 0 ? i4 : 0L) * d2, this.M, i3));
                    return (float) j2;
                }
                return (float) j2;
            }
            a2 = 0;
            j2 = a2 * d2;
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
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || ListUtils.getCount(this.I) == 0 || ListUtils.getCount(this.H) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<d.a.s0.y0.b.a> it = this.I.iterator();
        while (it.hasNext()) {
            d.a.s0.y0.b.a next = it.next();
            if (next != null && (TextUtils.isEmpty(next.b()) || ListUtils.getCount(next.c()) == 0)) {
                arrayList.add(next);
                Iterator<d.a.s0.y0.b.c> it2 = this.H.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    d.a.s0.y0.b.c next2 = it2.next();
                    if (next2 != null && next2.a() == next.a()) {
                        arrayList2.add(next2);
                        break;
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            this.I.removeAll(arrayList);
        }
        if (arrayList2.size() > 0) {
            this.H.removeAll(arrayList2);
        }
    }
}

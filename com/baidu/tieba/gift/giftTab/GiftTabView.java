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
import c.a.s0.s.q.j0;
import c.a.s0.s.q.k0;
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
/* loaded from: classes12.dex */
public class GiftTabView implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener A;
    public Handler B;
    public Runnable C;
    public boolean D;
    public int currencyType;

    /* renamed from: e  reason: collision with root package name */
    public GiftTabActivity f44013e;
    public View empty_layout;

    /* renamed from: f  reason: collision with root package name */
    public View f44014f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<c.a.t0.h1.b.c> f44015g;
    public TextView get_free_chance_view;
    public TextView gift_button;
    public EditText gift_count_input;
    public View gift_count_layout;
    public TextView gift_count_result;
    public TextView gift_desc_view;
    public View gift_list_layout;
    public View gift_lower_layout;
    public View gift_num_layout;
    public ListView gift_num_list;
    public FrameLayout gift_panel_lay;
    public IndicatorView gift_tab_indicator;
    public LinearLayout gift_tab_layout;
    public HorizontalScrollView gift_tab_scrollview;
    public BaseViewPager gift_viewpager;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c.a.t0.h1.b.a> f44016h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<c.a.t0.h1.b.e> f44017i;

    /* renamed from: j  reason: collision with root package name */
    public int f44018j;
    public String k;
    public o l;
    public n m;
    public c.a.t0.h1.b.d mGiftNumAdapter;
    public GiftPagerAdapter mGiftPagerAdapter;
    public FrameLayout mTabContainerView;
    public List<View> mViewPagerContent;
    public c.a.s0.s.j0.a mWaittingDialog;
    public int n;
    public View nodataView;
    public int o;
    public int p;
    public int q;
    public j0 r;
    public TextView reward_count_result;
    public TextView reward_link;
    public ImageView reward_link_arrow;
    public View reward_parent_view;
    public SparseIntArray s;
    public SparseBooleanArray t;
    public TextView text_view_gift_to;
    public int u;
    public k0 urlTitleData;
    public int v;
    public int w;
    public View.OnClickListener x;
    public int y;
    public View.OnClickListener z;

    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f44019e;

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
            this.f44019e = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || StringUtils.isNull(this.f44019e.urlTitleData.f13443b)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(this.f44019e.f44013e.getPageContext(), new String[]{this.f44019e.urlTitleData.f13443b});
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f44020e;

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
            this.f44020e = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.n.w(this.f44020e.f44013e.getPageContext().getPageActivity(), this.f44020e.gift_count_input);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f44021e;

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
            this.f44021e = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f44021e.gift_num_layout.getVisibility() != 0) {
                    this.f44021e.f44013e.closeActivity();
                } else {
                    this.f44021e.gift_num_layout.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f44022e;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f44023e;

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
                this.f44023e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f44023e.f44022e.w(false);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f44023e.f44022e.v, -2);
                    int[] iArr = new int[2];
                    this.f44023e.f44022e.gift_count_input.getLocationOnScreen(iArr);
                    layoutParams.leftMargin = iArr[0] - this.f44023e.f44022e.w;
                    int i2 = (iArr[1] - this.f44023e.f44022e.u) - this.f44023e.f44022e.w;
                    if (UtilHelper.canUseStyleImmersiveSticky()) {
                        i2 += UtilHelper.getStatusBarHeight();
                    }
                    layoutParams.topMargin = i2;
                    this.f44023e.f44022e.gift_num_list.setLayoutParams(layoutParams);
                    this.f44023e.f44022e.gift_num_layout.setVisibility(0);
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
            this.f44022e = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.d.f.p.n.w(this.f44022e.f44013e.getPageContext().getPageActivity(), this.f44022e.gift_count_input);
                this.f44022e.f44013e.mHandler.postDelayed(new a(this), 200L);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f44024e;

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
            this.f44024e = giftTabView;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (z) {
                    c.a.d.f.p.n.L(this.f44024e.f44013e.getPageContext().getPageActivity(), this.f44024e.gift_count_input);
                } else {
                    c.a.d.f.p.n.w(this.f44024e.f44013e.getPageContext().getPageActivity(), this.f44024e.gift_count_input);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f44025e;

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
            this.f44025e = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f44025e.gift_num_layout.setVisibility(8);
                c.a.d.f.p.n.w(this.f44025e.f44013e.getPageContext().getPageActivity(), this.f44025e.gift_count_input);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f44026e;

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
            this.f44026e = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f44026e.l == null) {
                return;
            }
            this.f44026e.t.append(this.f44026e.q, true);
            this.f44026e.l.a(((c.a.t0.h1.b.c) this.f44026e.f44015g.get(this.f44026e.q)).a());
        }
    }

    /* loaded from: classes12.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f44027e;

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
            this.f44027e = giftTabView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f44027e.m == null) {
                return;
            }
            this.f44027e.m.a();
        }
    }

    /* loaded from: classes12.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f44028e;

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
            this.f44028e = giftTabView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f44028e.H();
                this.f44028e.y(true);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class j implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f44029e;

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
            this.f44029e = giftTabView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                GiftTabView giftTabView = this.f44029e;
                giftTabView.o = giftTabView.n;
                this.f44029e.p = i2;
                c.a.d.f.p.n.w(this.f44029e.f44013e.getPageContext().getPageActivity(), this.f44029e.gift_count_input);
                c.a.t0.h1.b.b bVar = (c.a.t0.h1.b.b) adapterView.getAdapter();
                if (bVar != null) {
                    j0 item = bVar.getItem(i2);
                    if (item != null) {
                        this.f44029e.r = item;
                    }
                    bVar.d(i2);
                    bVar.notifyDataSetChanged();
                }
                this.f44029e.G();
                this.f44029e.y(true);
            }
        }

        public /* synthetic */ j(GiftTabView giftTabView, a aVar) {
            this(giftTabView);
        }
    }

    /* loaded from: classes12.dex */
    public class k implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f44030e;

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
            this.f44030e = giftTabView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                if (this.f44030e.f44017i == null || this.f44030e.f44017i.size() <= 0) {
                    this.f44030e.w(true);
                    Selection.selectAll(this.f44030e.gift_count_input.getText());
                    this.f44030e.gift_num_layout.setVisibility(8);
                    this.f44030e.y(true);
                    return;
                }
                if (i2 == this.f44030e.f44017i.size()) {
                    this.f44030e.w(true);
                    Selection.selectAll(this.f44030e.gift_count_input.getText());
                } else {
                    this.f44030e.gift_count_input.setCursorVisible(true);
                    this.f44030e.gift_count_input.setFocusable(true);
                    c.a.t0.h1.b.e eVar = (c.a.t0.h1.b.e) this.f44030e.f44017i.get(i2);
                    if (eVar != null) {
                        EditText editText = this.f44030e.gift_count_input;
                        editText.setText("" + eVar.b());
                    }
                }
                this.f44030e.gift_num_layout.setVisibility(8);
                this.f44030e.y(true);
            }
        }

        public /* synthetic */ k(GiftTabView giftTabView, a aVar) {
            this(giftTabView);
        }
    }

    /* loaded from: classes12.dex */
    public class l implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f44031e;

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
            this.f44031e = giftTabView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int e2 = c.a.d.f.m.b.e(editable.toString(), 0);
                if (editable.toString().length() == String.valueOf(e2).length()) {
                    this.f44031e.y(true);
                    return;
                }
                int i2 = e2 >= 0 ? e2 : 0;
                EditText editText = this.f44031e.gift_count_input;
                editText.setText("" + i2);
                this.f44031e.gift_count_input.setSelection(String.valueOf(i2).length());
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

    /* loaded from: classes12.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f44032e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GiftTabView f44033f;

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
            this.f44033f = giftTabView;
            this.f44032e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int min = Math.min(this.f44032e, this.f44033f.s.size());
                int i2 = 0;
                for (int i3 = 0; i3 < min; i3++) {
                    i2 += this.f44033f.s.get(i3);
                }
                this.f44033f.n = i2;
                GiftTabView giftTabView = this.f44033f;
                giftTabView.gift_viewpager.setCurrentItem(giftTabView.n);
                this.f44033f.I();
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface n {
        void a();
    }

    /* loaded from: classes12.dex */
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
        this.mViewPagerContent = new ArrayList();
        this.f44018j = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.s = new SparseIntArray();
        this.t = new SparseBooleanArray();
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.z = new a(this);
        this.A = new b(this);
        this.B = new Handler();
        this.C = new i(this);
        this.D = false;
        this.f44013e = giftTabActivity;
        this.x = onClickListener;
        View inflate = LayoutInflater.from(giftTabActivity.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_activity, (ViewGroup) null);
        this.f44014f = inflate;
        this.f44013e.setContentView(inflate);
        F();
        this.u = c.a.d.f.p.n.r(this.f44013e.getActivity());
        this.v = c.a.d.f.p.n.f(this.f44013e.getActivity(), R.dimen.ds330);
        this.w = c.a.d.f.p.n.f(this.f44013e.getActivity(), R.dimen.ds10);
    }

    public final View A(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            View inflate = LayoutInflater.from(this.f44013e.getPageContext().getPageActivity()).inflate(R.layout.gift_nodata_view, (ViewGroup) null);
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

    public final GridView B(List<j0> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, i2)) == null) {
            c.a.t0.h1.b.b bVar = new c.a.t0.h1.b.b(this.f44013e.getPageContext().getPageActivity());
            bVar.c(list);
            bVar.d(i2);
            TableLineGridView tableLineGridView = new TableLineGridView(this.f44013e.getPageContext().getPageActivity());
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
    public final void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            int childCount = this.gift_tab_layout.getChildCount();
            if (i2 < 0 || i2 >= childCount) {
                return;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                LinearLayout linearLayout = (LinearLayout) this.gift_tab_layout.getChildAt(i3);
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
                    this.q = i2;
                    this.gift_tab_scrollview.scrollTo(linearLayout.getLeft(), 0);
                }
            }
        }
    }

    public final void D(ArrayList<c.a.t0.h1.b.c> arrayList, boolean z) {
        List<j0> subList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048579, this, arrayList, z) == null) || arrayList == null) {
            return;
        }
        this.s.clear();
        this.mViewPagerContent.clear();
        this.gift_viewpager.setAdapter(null);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            List<j0> b2 = arrayList.get(i2).b();
            int size = b2 != null ? b2.size() : 0;
            int i3 = 1;
            if (size <= 0) {
                List<j0> arrayList2 = new ArrayList<>();
                if (!this.t.get(i2)) {
                    this.mViewPagerContent.add(B(arrayList2, -1));
                } else {
                    this.mViewPagerContent.add(A(true));
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
                        this.mViewPagerContent.add(B(subList, 0));
                        this.r = subList.get(0);
                    } else {
                        this.mViewPagerContent.add(B(subList, -1));
                    }
                }
                i3 = ceil;
            }
            this.s.append(i2, i3);
        }
        GiftPagerAdapter giftPagerAdapter = new GiftPagerAdapter(this.mViewPagerContent);
        this.mGiftPagerAdapter = giftPagerAdapter;
        this.gift_viewpager.setAdapter(giftPagerAdapter);
        this.gift_viewpager.setCurrentItem(this.n);
        I();
    }

    public final void E(List<c.a.t0.h1.b.e> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (c.a.t0.h1.b.e eVar : list) {
                    if (eVar.b() <= 0) {
                        arrayList.add(eVar);
                    }
                }
                list.removeAll(arrayList);
            }
            c.a.t0.h1.b.d dVar = new c.a.t0.h1.b.d(this.f44013e.getPageContext().getPageActivity());
            this.mGiftNumAdapter = dVar;
            this.gift_num_list.setAdapter((ListAdapter) dVar);
            this.mGiftNumAdapter.b(list);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.gift_panel_lay = (FrameLayout) this.f44014f.findViewById(R.id.gift_panel_lay);
            View findViewById = this.f44014f.findViewById(R.id.empty_layout);
            this.empty_layout = findViewById;
            findViewById.setOnClickListener(new c(this));
            View findViewById2 = this.f44014f.findViewById(R.id.gift_count_layout);
            this.gift_count_layout = findViewById2;
            findViewById2.setOnClickListener(this.A);
            this.gift_list_layout = this.f44014f.findViewById(R.id.gift_list_layout);
            EditText editText = (EditText) this.f44014f.findViewById(R.id.gift_count_input);
            this.gift_count_input = editText;
            editText.setSelection(1);
            w(false);
            this.gift_count_input.addTextChangedListener(new l(this, null));
            this.gift_count_input.setOnClickListener(new d(this));
            this.gift_count_input.setOnFocusChangeListener(new e(this));
            this.reward_parent_view = this.f44014f.findViewById(R.id.reward_parent_view);
            this.reward_count_result = (TextView) this.f44014f.findViewById(R.id.reward_count_result);
            this.reward_link = (TextView) this.f44014f.findViewById(R.id.reward_jump);
            this.reward_link_arrow = (ImageView) this.f44014f.findViewById(R.id.reward_jump_arrow);
            this.reward_parent_view.setOnClickListener(this.z);
            this.gift_count_result = (TextView) this.f44014f.findViewById(R.id.gift_count_result);
            TextView textView = (TextView) this.f44014f.findViewById(R.id.gift_button);
            this.gift_button = textView;
            textView.setEnabled(false);
            this.gift_button.setOnClickListener(this.x);
            TextView textView2 = (TextView) this.f44014f.findViewById(R.id.gift_desc_view);
            this.gift_desc_view = textView2;
            textView2.setOnClickListener(this.A);
            TextView textView3 = (TextView) this.f44014f.findViewById(R.id.get_free_chance_view);
            this.get_free_chance_view = textView3;
            textView3.setOnClickListener(this.x);
            TextView textView4 = (TextView) this.f44014f.findViewById(R.id.text_view_gift_to);
            this.text_view_gift_to = textView4;
            textView4.setOnClickListener(this.A);
            this.gift_lower_layout = this.f44014f.findViewById(R.id.gift_lower_layout);
            BaseViewPager baseViewPager = (BaseViewPager) this.f44014f.findViewById(R.id.gift_viewpager);
            this.gift_viewpager = baseViewPager;
            baseViewPager.setOnPageChangeListener(this);
            this.gift_tab_indicator = (IndicatorView) this.f44014f.findViewById(R.id.gift_tab_indicator);
            this.gift_tab_layout = (LinearLayout) this.f44014f.findViewById(R.id.gift_tab_layout);
            this.gift_tab_scrollview = (HorizontalScrollView) this.f44014f.findViewById(R.id.gift_tab_scrollview);
            View findViewById3 = this.f44014f.findViewById(R.id.gift_num_layout);
            this.gift_num_layout = findViewById3;
            findViewById3.setOnClickListener(new f(this));
            ListView listView = (ListView) this.f44014f.findViewById(R.id.gift_num_list);
            this.gift_num_list = listView;
            listView.setOnItemClickListener(new k(this, null));
            this.mTabContainerView = (FrameLayout) this.f44014f.findViewById(R.id.tab_container_view);
            View A = A(false);
            this.nodataView = A;
            A.setVisibility(8);
            this.mTabContainerView.addView(this.nodataView);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0267  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void G() {
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
        if (interceptable != null && interceptable.invokeV(1048582, this) != null) {
            return;
        }
        if (this.f44013e.accountType == 1) {
            this.f44014f.findViewById(R.id.desc_parent_view).setVisibility(8);
            return;
        }
        j0 j0Var = this.r;
        if (j0Var == null) {
            return;
        }
        int i2 = j0Var.f13429f;
        String str4 = "";
        if (StringUtils.isNull(j0Var.f13428e)) {
            str = "";
        } else {
            str = "\"" + this.r.f13428e + "\" ";
        }
        if (i2 != 1) {
            if (i2 == 2) {
                str2 = "" + this.r.k;
                str4 = String.format(this.f44013e.getPageContext().getString(R.string.left_number), Integer.valueOf(this.r.k));
            } else if (i2 == 3) {
                if (CurrencySwitchUtil.isYyIsConvert(this.r.s)) {
                    string = this.f44013e.getPageContext().getString(R.string.original_price_ybean);
                    string2 = this.f44013e.getPageContext().getString(R.string.discount_price_ybean);
                    j0 j0Var2 = this.r;
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(j0Var2.s, j0Var2.b());
                    j0 j0Var3 = this.r;
                    formatOverBaiwanNum2 = CurrencyHelper.getFormatOverBaiwanNum(j0Var3.s, j0Var3.a());
                } else {
                    string = this.f44013e.getPageContext().getString(R.string.original_price);
                    string2 = this.f44013e.getPageContext().getString(R.string.discount_price);
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(this.r.b());
                    formatOverBaiwanNum2 = StringHelper.formatOverBaiwanNum(this.r.a());
                }
                String format2 = String.format(string, formatOverBaiwanNum);
                str2 = String.format(string2, formatOverBaiwanNum2);
                j2 = 0;
                str3 = format2;
                str4 = " " + format2 + GlideException.IndentedAppendable.INDENT + str2;
                if (i2 != 5 && this.f44018j <= 0 && !StringUtils.isNull(this.k)) {
                    this.get_free_chance_view.setVisibility(0);
                } else {
                    this.get_free_chance_view.setVisibility(8);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) c.a.t0.h1.b.g.c(str4, str2, str3));
                this.gift_desc_view.setText(spannableStringBuilder);
                if (i2 == 1) {
                    this.B.removeCallbacks(this.C);
                    return;
                } else if (j2 > 0 && j2 <= 3600000) {
                    this.D = true;
                    this.B.postDelayed(this.C, 1000L);
                    return;
                } else if (this.D) {
                    this.D = false;
                    this.B.postDelayed(this.C, 1000L);
                    return;
                } else {
                    return;
                }
            } else {
                if (i2 != 4 && i2 == 5) {
                    if (this.f44018j > 0) {
                        String format3 = String.format(this.f44013e.getPageContext().getString(R.string.most_free_gift), Integer.valueOf(this.f44018j));
                        this.gift_count_input.setText("" + this.f44018j);
                        str4 = format3;
                        str2 = "" + this.f44018j;
                    } else {
                        this.gift_count_input.setText("0");
                        this.gift_button.setEnabled(false);
                        str4 = this.f44013e.getPageContext().getString(R.string.have_no_free_chance);
                    }
                }
                str3 = null;
                str2 = null;
            }
            str3 = null;
        } else {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            j0 j0Var4 = this.r;
            if (currentTimeMillis > j0Var4.f13431h) {
                long j3 = j0Var4.f13432i;
                if (currentTimeMillis < j3) {
                    j2 = (j3 - currentTimeMillis) * 1000;
                    timeSpace = StringHelper.getTimeSpace(j2);
                    format = String.format(this.f44013e.getPageContext().getString(R.string.gift_limit_time_end), timeSpace);
                    str2 = timeSpace;
                    str4 = format;
                    str3 = null;
                    if (i2 != 5) {
                    }
                    this.get_free_chance_view.setVisibility(8);
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                    SpannableString spannableString2 = new SpannableString(str);
                    spannableString2.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString2.length(), 33);
                    spannableStringBuilder2.append((CharSequence) spannableString2);
                    spannableStringBuilder2.append((CharSequence) c.a.t0.h1.b.g.c(str4, str2, str3));
                    this.gift_desc_view.setText(spannableStringBuilder2);
                    if (i2 == 1) {
                    }
                }
            }
            j0 j0Var5 = this.r;
            long j4 = j0Var5.f13431h;
            if (currentTimeMillis < j4) {
                j2 = (j4 - currentTimeMillis) * 1000;
                timeSpace = StringHelper.getTimeSpace(j2);
                format = String.format(this.f44013e.getPageContext().getString(R.string.gift_limit_time_start), timeSpace);
                str2 = timeSpace;
                str4 = format;
                str3 = null;
                if (i2 != 5) {
                }
                this.get_free_chance_view.setVisibility(8);
                SpannableStringBuilder spannableStringBuilder22 = new SpannableStringBuilder();
                SpannableString spannableString22 = new SpannableString(str);
                spannableString22.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString22.length(), 33);
                spannableStringBuilder22.append((CharSequence) spannableString22);
                spannableStringBuilder22.append((CharSequence) c.a.t0.h1.b.g.c(str4, str2, str3));
                this.gift_desc_view.setText(spannableStringBuilder22);
                if (i2 == 1) {
                }
            } else {
                str4 = currentTimeMillis > j0Var5.f13432i ? this.f44013e.getPageContext().getString(R.string.gift_limit_time_has_over) : null;
                str3 = null;
                str2 = null;
            }
        }
        j2 = 0;
        if (i2 != 5) {
        }
        this.get_free_chance_view.setVisibility(8);
        SpannableStringBuilder spannableStringBuilder222 = new SpannableStringBuilder();
        SpannableString spannableString222 = new SpannableString(str);
        spannableString222.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString222.length(), 33);
        spannableStringBuilder222.append((CharSequence) spannableString222);
        spannableStringBuilder222.append((CharSequence) c.a.t0.h1.b.g.c(str4, str2, str3));
        this.gift_desc_view.setText(spannableStringBuilder222);
        if (i2 == 1) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H() {
        j0 j0Var;
        int i2;
        String str;
        long j2;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || (j0Var = this.r) == null || (i2 = j0Var.f13429f) != 1) {
            return;
        }
        if (StringUtils.isNull(j0Var.f13428e)) {
            str = "";
        } else {
            str = "\"" + this.r.f13428e + "\" ";
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        j0 j0Var2 = this.r;
        if (currentTimeMillis > j0Var2.f13431h) {
            long j3 = j0Var2.f13432i;
            if (currentTimeMillis < j3) {
                j2 = (j3 - currentTimeMillis) * 1000;
                str2 = StringHelper.getTimeSpace(j2);
                str3 = String.format(this.f44013e.getPageContext().getString(R.string.gift_limit_time_end), str2);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(str);
                spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableString);
                spannableStringBuilder.append((CharSequence) c.a.t0.h1.b.g.c(str3, str2, null));
                this.gift_desc_view.setText(spannableStringBuilder);
                if (i2 == 1) {
                    this.B.removeCallbacks(this.C);
                    return;
                } else if (j2 > 0 && j2 <= 3600000) {
                    this.D = true;
                    this.B.postDelayed(this.C, 1000L);
                    return;
                } else if (this.D) {
                    this.D = false;
                    this.B.postDelayed(this.C, 1000L);
                    return;
                } else {
                    return;
                }
            }
        }
        j0 j0Var3 = this.r;
        long j4 = j0Var3.f13431h;
        if (currentTimeMillis < j4) {
            j2 = (j4 - currentTimeMillis) * 1000;
            str2 = StringHelper.getTimeSpace(j2);
            str3 = String.format(this.f44013e.getPageContext().getString(R.string.gift_limit_time_start), str2);
        } else if (currentTimeMillis > j0Var3.f13432i) {
            str3 = this.f44013e.getPageContext().getString(R.string.gift_limit_time_has_over);
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
        spannableStringBuilder2.append((CharSequence) c.a.t0.h1.b.g.c(str3, str2, null));
        this.gift_desc_view.setText(spannableStringBuilder2);
        if (i2 == 1) {
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.s.size(); i3++) {
                for (int i4 = 0; i4 < this.s.get(i3); i4++) {
                    if (i2 + i4 == this.n) {
                        if (this.s.get(i3) <= 1) {
                            this.gift_tab_indicator.setVisibility(4);
                        } else {
                            this.gift_tab_indicator.setVisibility(0);
                        }
                        this.gift_tab_indicator.setCount(this.s.get(i3));
                        this.gift_tab_indicator.setPosition(i4);
                        C(i3);
                        return;
                    }
                }
                i2 += this.s.get(i3);
            }
        }
    }

    public final void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            z();
            hideWattingDialog();
            ArrayList<c.a.t0.h1.b.c> arrayList = this.f44015g;
            if (arrayList != null && arrayList.size() > 0) {
                this.gift_button.setEnabled(true);
                this.nodataView.setVisibility(8);
                this.gift_lower_layout.setVisibility(0);
                if (z) {
                    v(this.f44016h);
                    E(this.f44017i);
                }
                D(this.f44015g, z);
                G();
                y(true);
                return;
            }
            this.gift_lower_layout.setVisibility(8);
            this.nodataView.setVisibility(0);
        }
    }

    public void destroyRefreshHandler() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.B.removeCallbacks(this.C);
        }
    }

    public String getAddFreeUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public int getCurrentSendCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.y : invokeV.intValue;
    }

    public j0 getCurrentSendGift() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.r : (j0) invokeV.objValue;
    }

    public int getFreeChance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f44018j : invokeV.intValue;
    }

    public void hideWattingDialog() {
        c.a.s0.s.j0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (aVar = this.mWaittingDialog) == null) {
            return;
        }
        aVar.h(false);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            c.a.s0.x0.a.a(this.f44013e.getPageContext(), this.gift_list_layout);
            SkinManager.setBackgroundResource(this.gift_num_list, R.drawable.chx_box_im_gift);
            c.a.t0.h1.b.d dVar = this.mGiftNumAdapter;
            if (dVar != null) {
                dVar.notifyDataSetChanged();
            }
            this.gift_tab_indicator.setSelector(SkinManager.getDrawable(R.drawable.point_live_s));
            this.gift_tab_indicator.setDrawable(SkinManager.getDrawable(R.drawable.point_live_n));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.n = i2;
            I();
            if (i2 < 0 || i2 >= this.mViewPagerContent.size() || !(this.mViewPagerContent.get(i2) instanceof GridView)) {
                return;
            }
            GridView gridView = (GridView) this.mViewPagerContent.get(i2);
            if (gridView.getAdapter() != null) {
                c.a.t0.h1.b.b bVar = (c.a.t0.h1.b.b) gridView.getAdapter();
                if (bVar.b() >= 0 && i2 != this.o) {
                    bVar.d(-1);
                    bVar.notifyDataSetChanged();
                }
                if (bVar.b() >= 0 || i2 != this.o) {
                    return;
                }
                bVar.d(this.p);
                bVar.notifyDataSetChanged();
            }
        }
    }

    public void setAddFreeUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.k = str;
        }
    }

    public void setCurrentSendCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.y = i2;
        }
    }

    public void setFreeChance(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.f44018j = i2;
            j0 j0Var = this.r;
            if (j0Var == null || j0Var.f13429f != 5) {
                return;
            }
            G();
        }
    }

    public void setLoadDataByCategoryCallback(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, oVar) == null) {
            this.l = oVar;
        }
    }

    public void setLoadDefaultListCallback(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, nVar) == null) {
            this.m = nVar;
        }
    }

    public void showGiftListView(boolean z, ArrayList<c.a.t0.h1.b.c> arrayList, ArrayList<c.a.t0.h1.b.a> arrayList2, ArrayList<c.a.t0.h1.b.e> arrayList3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), arrayList, arrayList2, arrayList3}) == null) {
            this.f44015g = arrayList;
            this.f44016h = arrayList2;
            this.f44017i = arrayList3;
            J(z);
        }
    }

    public void showWaittingDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.mWaittingDialog == null) {
                this.mWaittingDialog = new c.a.s0.s.j0.a(this.f44013e.getPageContext());
            }
            this.mWaittingDialog.h(true);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public final void v(ArrayList<c.a.t0.h1.b.a> arrayList) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, arrayList) == null) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.gift_tab_layout.removeAllViews();
        int size = arrayList.size();
        int k2 = c.a.d.f.p.n.k(this.f44013e.getPageContext().getPageActivity());
        if (size >= 5) {
            i2 = k2 / 5;
        } else {
            i2 = k2 / size;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
        for (int i3 = 0; i3 < size; i3++) {
            c.a.t0.h1.b.a aVar = arrayList.get(i3);
            if (!TextUtils.isEmpty(aVar.b()) && aVar.c() != null && aVar.c().size() > 0) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f44013e.getPageContext().getPageActivity()).inflate(R.layout.gift_tab_item, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(R.id.text_view);
                textView.setText(aVar.b());
                linearLayout.setOnClickListener(new m(this, i3));
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.END);
                this.gift_tab_layout.addView(linearLayout, layoutParams);
            }
        }
        C(this.q);
    }

    public final void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.gift_count_input.setCursorVisible(z);
            this.gift_count_input.setFocusable(z);
            this.gift_count_input.setFocusableInTouchMode(z);
            if (z) {
                this.gift_count_input.requestFocus();
            } else {
                this.gift_count_input.clearFocus();
            }
        }
    }

    public final void x(int i2) {
        ArrayList<c.a.t0.h1.b.c> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            int childCount = this.gift_tab_layout.getChildCount();
            if (i2 < 0 || i2 >= childCount || (arrayList = this.f44015g) == null || arrayList.size() <= i2 || this.f44015g.get(i2) == null || this.t.get(i2)) {
                return;
            }
            if ((this.f44015g.get(i2).b() == null || this.f44015g.get(i2).b().size() <= 0) && this.l != null) {
                this.t.append(i2, true);
                this.l.a(this.f44015g.get(i2).a());
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
        if (interceptable != null && (invokeZ = interceptable.invokeZ(1048606, this, z)) != null) {
            return invokeZ.floatValue;
        }
        if (this.r == null) {
            return 0.0f;
        }
        int e2 = c.a.d.f.m.b.e(this.gift_count_input.getText().toString(), 0);
        this.y = e2;
        j0 j0Var = this.r;
        int i2 = j0Var.f13429f;
        int i3 = j0Var.s;
        if (i2 == 3) {
            if (j0Var.a() >= 0) {
                a2 = this.r.a();
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
                a2 = this.r.b();
                j2 = a2 * e2;
                if (z) {
                    this.gift_count_result.setText(c.a.t0.h1.b.g.b(j2, true, i3));
                    if (e2 <= 0) {
                        SkinManager.setBackgroundResource(this.gift_button, R.drawable.btn_gift_give_d);
                        this.gift_button.setEnabled(false);
                    } else if (i2 == 1) {
                        long currentTimeMillis = System.currentTimeMillis() / 1000;
                        j0 j0Var2 = this.r;
                        if (currentTimeMillis >= j0Var2.f13431h && currentTimeMillis <= j0Var2.f13432i) {
                            SkinManager.setBackgroundResource(this.gift_button, R.drawable.orange_btn_selector);
                            this.gift_button.setEnabled(true);
                        } else {
                            SkinManager.setBackgroundResource(this.gift_button, R.drawable.btn_gift_give_d);
                            this.gift_button.setEnabled(false);
                        }
                    } else {
                        SkinManager.setBackgroundResource(this.gift_button, R.drawable.orange_btn_selector);
                        this.gift_button.setEnabled(true);
                    }
                    int i4 = this.r.q;
                    this.reward_count_result.setText(c.a.t0.h1.b.g.a((i4 >= 0 ? i4 : 0L) * e2, this.currencyType, i3));
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
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || ListUtils.getCount(this.f44016h) == 0 || ListUtils.getCount(this.f44015g) == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<c.a.t0.h1.b.a> it = this.f44016h.iterator();
        while (it.hasNext()) {
            c.a.t0.h1.b.a next = it.next();
            if (next != null && (TextUtils.isEmpty(next.b()) || ListUtils.getCount(next.c()) == 0)) {
                arrayList.add(next);
                Iterator<c.a.t0.h1.b.c> it2 = this.f44015g.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    c.a.t0.h1.b.c next2 = it2.next();
                    if (next2 != null && next2.a() == next.a()) {
                        arrayList2.add(next2);
                        break;
                    }
                }
            }
        }
        if (arrayList.size() > 0) {
            this.f44016h.removeAll(arrayList);
        }
        if (arrayList2.size() > 0) {
            this.f44015g.removeAll(arrayList2);
        }
    }
}

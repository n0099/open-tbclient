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
import android.util.DisplayMetrics;
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
import com.baidu.tieba.al7;
import com.baidu.tieba.an5;
import com.baidu.tieba.cl7;
import com.baidu.tieba.gg;
import com.baidu.tieba.ii;
import com.baidu.tieba.r25;
import com.baidu.tieba.t45;
import com.baidu.tieba.vx4;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.tieba.wk7;
import com.baidu.tieba.wx4;
import com.baidu.tieba.xk7;
import com.baidu.tieba.yk7;
import com.baidu.tieba.zk7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class GiftTabView implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zk7 A;
    public GiftPagerAdapter B;
    public t45 C;
    public ArrayList<yk7> D;
    public ArrayList<wk7> E;
    public ArrayList<al7> F;
    public int G;
    public String H;
    public int I;
    public wx4 J;
    public o K;
    public n L;
    public int M;
    public int N;
    public int O;
    public int P;
    public vx4 Q;
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
    public Handler a0;
    public View b;
    public Runnable b0;
    public FrameLayout c;
    public boolean c0;
    public View d;
    public View e;
    public View f;
    public EditText g;
    public View h;
    public TextView i;
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

    /* loaded from: classes4.dex */
    public interface n {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface o {
        void a(int i);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabView a;

        /* loaded from: classes4.dex */
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
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                this.a.a.w(false);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.a.a.U, -2);
                int[] iArr = new int[2];
                this.a.a.g.getLocationOnScreen(iArr);
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ii.z(this.a.a.getPageContext().getPageActivity(), this.a.g);
                this.a.a.mHandler.postDelayed(new a(this), 200L);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !StringUtils.isNull(this.a.J.b)) {
                UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{this.a.J.b});
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ii.z(this.a.a.getPageContext().getPageActivity(), this.a.g);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.x.getVisibility() == 0) {
                    this.a.x.setVisibility(8);
                } else {
                    this.a.a.closeActivity();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (z) {
                    ii.O(this.a.a.getPageContext().getPageActivity(), this.a.g);
                } else {
                    ii.z(this.a.a.getPageContext().getPageActivity(), this.a.g);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.x.setVisibility(8);
                ii.z(this.a.a.getPageContext().getPageActivity(), this.a.g);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.K != null) {
                this.a.S.append(this.a.P, true);
                this.a.K.a(((yk7) this.a.D.get(this.a.P)).a());
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.L != null) {
                this.a.L.a();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.T();
                this.a.y(true);
            }
        }
    }

    /* loaded from: classes4.dex */
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

        public /* synthetic */ j(GiftTabView giftTabView, a aVar) {
            this(giftTabView);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                GiftTabView giftTabView = this.a;
                giftTabView.N = giftTabView.M;
                this.a.O = i;
                ii.z(this.a.a.getPageContext().getPageActivity(), this.a.g);
                xk7 xk7Var = (xk7) adapterView.getAdapter();
                if (xk7Var != null) {
                    vx4 item = xk7Var.getItem(i);
                    if (item != null) {
                        this.a.Q = item;
                    }
                    xk7Var.d(i);
                    xk7Var.notifyDataSetChanged();
                }
                this.a.M();
                this.a.y(true);
            }
        }
    }

    /* loaded from: classes4.dex */
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

        public /* synthetic */ k(GiftTabView giftTabView, a aVar) {
            this(giftTabView);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                if (this.a.F == null || this.a.F.size() <= 0) {
                    this.a.w(true);
                    Selection.selectAll(this.a.g.getText());
                    this.a.x.setVisibility(8);
                    this.a.y(true);
                    return;
                }
                if (i == this.a.F.size()) {
                    this.a.w(true);
                    Selection.selectAll(this.a.g.getText());
                } else {
                    this.a.g.setCursorVisible(true);
                    this.a.g.setFocusable(true);
                    al7 al7Var = (al7) this.a.F.get(i);
                    if (al7Var != null) {
                        EditText editText = this.a.g;
                        editText.setText("" + al7Var.b());
                    }
                }
                this.a.x.setVisibility(8);
                this.a.y(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GiftTabView a;

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

        public /* synthetic */ l(GiftTabView giftTabView, a aVar) {
            this(giftTabView);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                int i = 0;
                int e = gg.e(editable.toString(), 0);
                if (editable.toString().length() == String.valueOf(e).length()) {
                    this.a.y(true);
                    return;
                }
                if (e >= 0) {
                    i = e;
                }
                EditText editText = this.a.g;
                editText.setText("" + i);
                this.a.g.setSelection(String.valueOf(i).length());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ GiftTabView b;

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
            this.b = giftTabView;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int min = Math.min(this.a, this.b.R.size());
                int i = 0;
                for (int i2 = 0; i2 < min; i2++) {
                    i += this.b.R.get(i2);
                }
                this.b.M = i;
                GiftTabView giftTabView = this.b;
                giftTabView.q.setCurrentItem(giftTabView.M);
                this.b.U();
            }
        }
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
        this.a0 = new Handler();
        this.b0 = new i(this);
        this.c0 = false;
        this.a = giftTabActivity;
        this.W = onClickListener;
        View inflate = LayoutInflater.from(giftTabActivity.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03a2, (ViewGroup) null);
        this.b = inflate;
        this.a.setContentView(inflate);
        J();
        this.T = ii.u(this.a.getActivity());
        this.U = ii.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f0702a3);
        this.V = ii.g(this.a.getActivity(), R.dimen.obfuscated_res_0x7f070231);
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.H = str;
        }
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.G = i2;
            vx4 vx4Var = this.Q;
            if (vx4Var != null && vx4Var.f == 5) {
                M();
            }
        }
    }

    public void P(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, oVar) == null) {
            this.K = oVar;
        }
    }

    public void Q(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, nVar) == null) {
            this.L = nVar;
        }
    }

    public final void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.g.setCursorVisible(z);
            this.g.setFocusable(z);
            this.g.setFocusableInTouchMode(z);
            if (z) {
                this.g.requestFocus();
            } else {
                this.g.clearFocus();
            }
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a0.removeCallbacks(this.b0);
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.X;
        }
        return invokeV.intValue;
    }

    public vx4 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.Q;
        }
        return (vx4) invokeV.objValue;
    }

    public void G() {
        t45 t45Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (t45Var = this.C) != null) {
            t45Var.h(false);
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.C == null) {
                this.C = new t45(this.a.getPageContext());
            }
            this.C.h(true);
        }
    }

    public final View D(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03a0, (ViewGroup) null);
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

    @SuppressLint({"ResourceAsColor"})
    public final void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            int childCount = this.t.getChildCount();
            if (i2 >= 0 && i2 < childCount) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    LinearLayout linearLayout = (LinearLayout) this.t.getChildAt(i3);
                    TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09232f);
                    View findViewById = linearLayout.findViewById(R.id.obfuscated_res_0x7f09230b);
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
    }

    public final void x(int i2) {
        ArrayList<yk7> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            int childCount = this.t.getChildCount();
            if (i2 >= 0 && i2 < childCount && (arrayList = this.D) != null && arrayList.size() > i2 && this.D.get(i2) != null && !this.S.get(i2)) {
                if ((this.D.get(i2).b() == null || this.D.get(i2).b().size() <= 0) && this.K != null) {
                    this.S.append(i2, true);
                    this.K.a(this.D.get(i2).a());
                }
            }
        }
    }

    public final GridView E(List<vx4> list, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, list, i2)) == null) {
            xk7 xk7Var = new xk7(this.a.getPageContext().getPageActivity());
            xk7Var.c(list);
            xk7Var.d(i2);
            TableLineGridView tableLineGridView = new TableLineGridView(this.a.getPageContext().getPageActivity());
            tableLineGridView.setColumnCount(4);
            tableLineGridView.setRowCount(2);
            tableLineGridView.setBackgroundLineResource(SkinManager.getColor(R.color.CAM_X0204));
            tableLineGridView.setVerticalScrollBarEnabled(false);
            tableLineGridView.setNumColumns(4);
            tableLineGridView.setSelector(R.color.common_color_10022);
            tableLineGridView.setAdapter((ListAdapter) xk7Var);
            tableLineGridView.setOnItemClickListener(new j(this, null));
            return tableLineGridView;
        }
        return (GridView) invokeLI.objValue;
    }

    public final void H(ArrayList<yk7> arrayList, boolean z) {
        int i2;
        List<vx4> subList;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048583, this, arrayList, z) != null) || arrayList == null) {
            return;
        }
        this.R.clear();
        this.z.clear();
        this.q.setAdapter(null);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            List<vx4> b2 = arrayList.get(i3).b();
            if (b2 != null) {
                i2 = b2.size();
            } else {
                i2 = 0;
            }
            int i4 = 1;
            if (i2 <= 0) {
                List<vx4> arrayList2 = new ArrayList<>();
                if (!this.S.get(i3)) {
                    this.z.add(E(arrayList2, -1));
                } else {
                    this.z.add(D(true));
                }
            } else {
                int ceil = (int) Math.ceil(i2 / 8.0d);
                for (int i5 = 0; i5 < ceil; i5++) {
                    if (i5 == ceil - 1) {
                        int i6 = i5 * 8;
                        int i7 = i2 - 1;
                        if (i6 == i7) {
                            subList = new ArrayList<>();
                            subList.add(b2.get(i7));
                        } else {
                            subList = b2.subList(i6, i2);
                        }
                    } else {
                        subList = b2.subList(i5 * 8, (i5 + 1) * 8);
                    }
                    if (i3 == 0 && i5 == 0 && z) {
                        this.z.add(E(subList, 0));
                        this.Q = subList.get(0);
                    } else {
                        this.z.add(E(subList, -1));
                    }
                }
                i4 = ceil;
            }
            this.R.append(i3, i4);
        }
        GiftPagerAdapter giftPagerAdapter = new GiftPagerAdapter(this.z);
        this.B = giftPagerAdapter;
        this.q.setAdapter(giftPagerAdapter);
        this.q.setCurrentItem(this.M);
        U();
    }

    public final void I(List<al7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (al7 al7Var : list) {
                    if (al7Var.b() <= 0) {
                        arrayList.add(al7Var);
                    }
                }
                list.removeAll(arrayList);
            }
            zk7 zk7Var = new zk7(this.a.getPageContext().getPageActivity());
            this.A = zk7Var;
            this.y.setAdapter((ListAdapter) zk7Var);
            this.A.b(list);
        }
    }

    public final void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            z();
            G();
            ArrayList<yk7> arrayList = this.D;
            if (arrayList != null && arrayList.size() > 0) {
                this.m.setEnabled(true);
                this.v.setVisibility(8);
                this.u.setVisibility(0);
                if (z) {
                    v(this.E);
                    I(this.F);
                }
                H(this.D, z);
                M();
                y(true);
                return;
            }
            this.u.setVisibility(8);
            this.v.setVisibility(0);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.M = i2;
            U();
            if (i2 < 0 || i2 >= this.z.size() || !(this.z.get(i2) instanceof GridView)) {
                return;
            }
            GridView gridView = (GridView) this.z.get(i2);
            if (gridView.getAdapter() != null) {
                xk7 xk7Var = (xk7) gridView.getAdapter();
                if (xk7Var.b() >= 0 && i2 != this.N) {
                    xk7Var.d(-1);
                    xk7Var.notifyDataSetChanged();
                }
                if (xk7Var.b() < 0 && i2 == this.N) {
                    xk7Var.d(this.O);
                    xk7Var.notifyDataSetChanged();
                }
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.c = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090dcf);
            View findViewById = this.b.findViewById(R.id.obfuscated_res_0x7f0909a0);
            this.d = findViewById;
            findViewById.setOnClickListener(new c(this));
            View findViewById2 = this.b.findViewById(R.id.obfuscated_res_0x7f090dc0);
            this.f = findViewById2;
            findViewById2.setOnClickListener(this.Z);
            this.e = this.b.findViewById(R.id.obfuscated_res_0x7f090dc6);
            EditText editText = (EditText) this.b.findViewById(R.id.obfuscated_res_0x7f090dbf);
            this.g = editText;
            r25 d2 = r25.d(editText);
            d2.m(R.dimen.tbds4);
            d2.o(R.string.J_X04);
            d2.l(R.color.CAM_X0108);
            this.g.setSelection(1);
            w(false);
            this.g.addTextChangedListener(new l(this, null));
            this.g.setOnClickListener(new d(this));
            this.g.setOnFocusChangeListener(new e(this));
            this.h = this.b.findViewById(R.id.obfuscated_res_0x7f091db3);
            this.i = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091daf);
            this.j = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091db1);
            this.k = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091db2);
            this.h.setOnClickListener(this.Y);
            this.l = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090dc1);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090dbe);
            this.m = textView;
            textView.setEnabled(false);
            this.m.setOnClickListener(this.W);
            TextView textView2 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090dc3);
            this.n = textView2;
            textView2.setOnClickListener(this.Z);
            TextView textView3 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f090dae);
            this.o = textView3;
            textView3.setOnClickListener(this.W);
            TextView textView4 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092333);
            this.p = textView4;
            textView4.setOnClickListener(this.Z);
            this.u = this.b.findViewById(R.id.obfuscated_res_0x7f090dc9);
            BaseViewPager baseViewPager = (BaseViewPager) this.b.findViewById(R.id.obfuscated_res_0x7f090dda);
            this.q = baseViewPager;
            baseViewPager.setOnPageChangeListener(this);
            this.r = (IndicatorView) this.b.findViewById(R.id.obfuscated_res_0x7f090dd5);
            this.t = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090dd6);
            this.s = (HorizontalScrollView) this.b.findViewById(R.id.obfuscated_res_0x7f090dd7);
            View findViewById3 = this.b.findViewById(R.id.obfuscated_res_0x7f090dcc);
            this.x = findViewById3;
            findViewById3.setOnClickListener(new f(this));
            ListView listView = (ListView) this.b.findViewById(R.id.obfuscated_res_0x7f090dcd);
            this.y = listView;
            listView.setOnItemClickListener(new k(this, null));
            this.w = (FrameLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0921de);
            View D = D(false);
            this.v = D;
            D.setVisibility(8);
            this.w.addView(this.v);
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            an5.a(this.a.getPageContext(), this.e);
            SkinManager.setBackgroundResource(this.y, R.drawable.chx_box_im_gift);
            zk7 zk7Var = this.A;
            if (zk7Var != null) {
                zk7Var.notifyDataSetChanged();
            }
            this.r.setSelector(SkinManager.getDrawable(R.drawable.point_live_s));
            this.r.setDrawable(SkinManager.getDrawable(R.drawable.point_live_n));
        }
    }

    public void L(DisplayMetrics displayMetrics) {
        LinearLayout linearLayout;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, displayMetrics) == null) && (linearLayout = this.t) != null && displayMetrics != null) {
            int childCount = linearLayout.getChildCount();
            if (childCount >= 5) {
                i2 = displayMetrics.widthPixels / 5;
            } else {
                i2 = displayMetrics.widthPixels / childCount;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.t.getChildAt(i3);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                layoutParams.width = i2;
                childAt.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0274  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void M() {
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.a.p == 1) {
                this.b.findViewById(R.id.obfuscated_res_0x7f090848).setVisibility(8);
                return;
            }
            vx4 vx4Var = this.Q;
            if (vx4Var == null) {
                return;
            }
            int i2 = vx4Var.f;
            String str4 = "";
            if (StringUtils.isNull(vx4Var.e)) {
                str = "";
            } else {
                str = "\"" + this.Q.e + "\" ";
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4 && i2 == 5) {
                            if (this.G > 0) {
                                String format2 = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0bb6), Integer.valueOf(this.G));
                                this.g.setText("" + this.G);
                                str4 = format2;
                                str2 = "" + this.G;
                            } else {
                                this.g.setText("0");
                                this.m.setEnabled(false);
                                str4 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f08df);
                            }
                        }
                        str3 = null;
                        str2 = null;
                    } else {
                        if (CurrencySwitchUtil.isYyIsConvert(this.Q.s)) {
                            string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0df6);
                            string2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f052c);
                            vx4 vx4Var2 = this.Q;
                            formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(vx4Var2.s, vx4Var2.b());
                            vx4 vx4Var3 = this.Q;
                            formatOverBaiwanNum2 = CurrencyHelper.getFormatOverBaiwanNum(vx4Var3.s, vx4Var3.a());
                        } else {
                            string = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0df5);
                            string2 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f052b);
                            formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(this.Q.b());
                            formatOverBaiwanNum2 = StringHelper.formatOverBaiwanNum(this.Q.a());
                        }
                        String format3 = String.format(string, formatOverBaiwanNum);
                        str2 = String.format(string2, formatOverBaiwanNum2);
                        j2 = 0;
                        str3 = format3;
                        str4 = " " + format3 + GlideException.IndentedAppendable.INDENT + str2;
                        if (i2 != 5 && this.G <= 0 && !StringUtils.isNull(this.H)) {
                            this.o.setVisibility(0);
                        } else {
                            this.o.setVisibility(8);
                        }
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        SpannableString spannableString = new SpannableString(str);
                        spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
                        spannableStringBuilder.append((CharSequence) spannableString);
                        spannableStringBuilder.append((CharSequence) cl7.c(str4, str2, str3));
                        this.n.setText(spannableStringBuilder);
                        if (i2 != 1) {
                            if (j2 > 0 && j2 <= 3600000) {
                                this.c0 = true;
                                this.a0.postDelayed(this.b0, 1000L);
                                return;
                            } else if (this.c0) {
                                this.c0 = false;
                                this.a0.postDelayed(this.b0, 1000L);
                                return;
                            } else {
                                return;
                            }
                        }
                        this.a0.removeCallbacks(this.b0);
                        return;
                    }
                } else {
                    str2 = "" + this.Q.k;
                    str4 = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0a95), Integer.valueOf(this.Q.k));
                }
                str3 = null;
            } else {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                vx4 vx4Var4 = this.Q;
                if (currentTimeMillis > vx4Var4.h) {
                    long j3 = vx4Var4.i;
                    if (currentTimeMillis < j3) {
                        j2 = (j3 - currentTimeMillis) * 1000;
                        timeSpace = StringHelper.getTimeSpace(j2);
                        format = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f081e), timeSpace);
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
                        spannableStringBuilder2.append((CharSequence) cl7.c(str4, str2, str3));
                        this.n.setText(spannableStringBuilder2);
                        if (i2 != 1) {
                        }
                    }
                }
                vx4 vx4Var5 = this.Q;
                long j4 = vx4Var5.h;
                if (currentTimeMillis < j4) {
                    j2 = (j4 - currentTimeMillis) * 1000;
                    timeSpace = StringHelper.getTimeSpace(j2);
                    format = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0821), timeSpace);
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
                    spannableStringBuilder22.append((CharSequence) cl7.c(str4, str2, str3));
                    this.n.setText(spannableStringBuilder22);
                    if (i2 != 1) {
                    }
                } else {
                    str4 = currentTimeMillis > vx4Var5.i ? this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f081f) : null;
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
            spannableStringBuilder222.append((CharSequence) cl7.c(str4, str2, str3));
            this.n.setText(spannableStringBuilder222);
            if (i2 != 1) {
            }
        }
    }

    public void R(boolean z, ArrayList<yk7> arrayList, ArrayList<wk7> arrayList2, ArrayList<al7> arrayList3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), arrayList, arrayList2, arrayList3}) == null) {
            this.D = arrayList;
            this.E = arrayList2;
            this.F = arrayList3;
            V(z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T() {
        vx4 vx4Var;
        int i2;
        String str;
        long j2;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (vx4Var = this.Q) != null && (i2 = vx4Var.f) == 1) {
            if (!StringUtils.isNull(vx4Var.e)) {
                str = "\"" + this.Q.e + "\" ";
            } else {
                str = "";
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            vx4 vx4Var2 = this.Q;
            if (currentTimeMillis > vx4Var2.h) {
                long j3 = vx4Var2.i;
                if (currentTimeMillis < j3) {
                    j2 = (j3 - currentTimeMillis) * 1000;
                    str2 = StringHelper.getTimeSpace(j2);
                    str3 = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f081e), str2);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    SpannableString spannableString = new SpannableString(str);
                    spannableString.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0109)), 0, spannableString.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) cl7.c(str3, str2, null));
                    this.n.setText(spannableStringBuilder);
                    if (i2 != 1) {
                        if (j2 > 0 && j2 <= 3600000) {
                            this.c0 = true;
                            this.a0.postDelayed(this.b0, 1000L);
                            return;
                        } else if (this.c0) {
                            this.c0 = false;
                            this.a0.postDelayed(this.b0, 1000L);
                            return;
                        } else {
                            return;
                        }
                    }
                    this.a0.removeCallbacks(this.b0);
                    return;
                }
            }
            vx4 vx4Var3 = this.Q;
            long j4 = vx4Var3.h;
            if (currentTimeMillis < j4) {
                j2 = (j4 - currentTimeMillis) * 1000;
                str2 = StringHelper.getTimeSpace(j2);
                str3 = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0821), str2);
            } else if (currentTimeMillis > vx4Var3.i) {
                str3 = this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f081f);
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
            spannableStringBuilder2.append((CharSequence) cl7.c(str3, str2, null));
            this.n.setText(spannableStringBuilder2);
            if (i2 != 1) {
            }
        }
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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

    @SuppressLint({"ResourceAsColor"})
    public final void v(ArrayList<wk7> arrayList) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, arrayList) == null) && arrayList != null && arrayList.size() > 0) {
            this.t.removeAllViews();
            int size = arrayList.size();
            int l2 = ii.l(this.a.getPageContext().getPageActivity());
            if (size >= 5) {
                i2 = l2 / 5;
            } else {
                i2 = l2 / size;
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, -1);
            for (int i3 = 0; i3 < size; i3++) {
                wk7 wk7Var = arrayList.get(i3);
                if (!TextUtils.isEmpty(wk7Var.b()) && wk7Var.c() != null && wk7Var.c().size() > 0) {
                    LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03a3, (ViewGroup) null);
                    TextView textView = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f09232f);
                    textView.setText(wk7Var.b());
                    linearLayout.setOnClickListener(new m(this, i3));
                    textView.setSingleLine();
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    this.t.addView(linearLayout, layoutParams);
                }
            }
            F(this.P);
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
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048604, this, z)) == null) {
            if (this.Q == null) {
                return 0.0f;
            }
            int e2 = gg.e(this.g.getText().toString(), 0);
            this.X = e2;
            vx4 vx4Var = this.Q;
            int i2 = vx4Var.f;
            int i3 = vx4Var.s;
            long j3 = 0;
            if (i2 != 3) {
                if (i2 != 5) {
                    if (vx4Var.b() >= 0) {
                        a2 = this.Q.b();
                        j2 = a2 * e2;
                        if (!z) {
                            return (float) j2;
                        }
                        this.l.setText(cl7.b(j2, true, i3));
                        if (e2 <= 0) {
                            SkinManager.setBackgroundResource(this.m, R.drawable.btn_gift_give_d);
                            this.m.setEnabled(false);
                        } else if (i2 == 1) {
                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                            vx4 vx4Var2 = this.Q;
                            if (currentTimeMillis >= vx4Var2.h && currentTimeMillis <= vx4Var2.i) {
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
                        if (i4 >= 0) {
                            j3 = i4;
                        }
                        this.i.setText(cl7.a(j3 * e2, this.I, i3));
                        return (float) j2;
                    }
                    a2 = 0;
                    j2 = a2 * e2;
                    if (!z) {
                    }
                } else {
                    j2 = 0;
                    if (!z) {
                    }
                }
            } else {
                if (vx4Var.a() >= 0) {
                    a2 = this.Q.a();
                    j2 = a2 * e2;
                    if (!z) {
                    }
                }
                a2 = 0;
                j2 = a2 * e2;
                if (!z) {
                }
            }
        } else {
            return invokeZ.floatValue;
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && ListUtils.getCount(this.E) != 0 && ListUtils.getCount(this.D) != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Iterator<wk7> it = this.E.iterator();
            while (it.hasNext()) {
                wk7 next = it.next();
                if (next != null && (TextUtils.isEmpty(next.b()) || ListUtils.getCount(next.c()) == 0)) {
                    arrayList.add(next);
                    Iterator<yk7> it2 = this.D.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        yk7 next2 = it2.next();
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
}

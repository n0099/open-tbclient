package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.n;
import c.a.o0.s.c.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes5.dex */
public class PagerSlidingTabStrip extends HorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public float I;
    public float J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public boolean Q;
    public Locale R;
    public RectF S;
    public int T;
    public d U;
    public Context V;
    public LinearLayout.LayoutParams a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout.LayoutParams f33268b;

    /* renamed from: c  reason: collision with root package name */
    public final e f33269c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f33270d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f33271e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f33272f;

    /* renamed from: g  reason: collision with root package name */
    public int f33273g;

    /* renamed from: h  reason: collision with root package name */
    public int f33274h;
    public int i;
    public float j;
    public int k;
    public int l;
    public Paint m;
    public Paint n;
    public RectF o;
    public boolean p;
    public boolean q;
    public int r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes5.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentPosition;

        /* loaded from: classes5.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, null) : (SavedState) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new SavedState[i] : (SavedState[]) invokeI.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-205545665, "Lcom/baidu/tieba/homepage/framework/indicator/PagerSlidingTabStrip$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-205545665, "Lcom/baidu/tieba/homepage/framework/indicator/PagerSlidingTabStrip$SavedState;");
                    return;
                }
            }
            CREATOR = new a();
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.currentPosition);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.currentPosition = parcel.readInt();
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PagerSlidingTabStrip a;

        public a(PagerSlidingTabStrip pagerSlidingTabStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pagerSlidingTabStrip;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                this.a.i = 1;
                PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
                pagerSlidingTabStrip.k = pagerSlidingTabStrip.i;
                this.a.F();
                PagerSlidingTabStrip pagerSlidingTabStrip2 = this.a;
                pagerSlidingTabStrip2.D(pagerSlidingTabStrip2.i, 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PagerSlidingTabStrip a;

        public b(PagerSlidingTabStrip pagerSlidingTabStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pagerSlidingTabStrip;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
                pagerSlidingTabStrip.i = pagerSlidingTabStrip.f33272f.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip2 = this.a;
                pagerSlidingTabStrip2.k = pagerSlidingTabStrip2.i;
                this.a.F();
                PagerSlidingTabStrip pagerSlidingTabStrip3 = this.a;
                pagerSlidingTabStrip3.D(pagerSlidingTabStrip3.i, 0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabStrip f33275b;

        public c(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabStrip, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33275b = pagerSlidingTabStrip;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f33275b.Q) {
                return;
            }
            if (this.f33275b.U != null) {
                this.f33275b.U.a(view, this.a);
            }
            if (this.a == 1 || !FullBrowseHelper.checkIsFullBrowseMode()) {
                int currentItem = this.f33275b.f33272f.getCurrentItem();
                int i = this.a;
                if (currentItem != i || i != 0 || !TbadkCoreApplication.isLogin() || !UbsABTestHelper.isConcernForumCardShow()) {
                    if (this.f33275b.f33272f.getCurrentItem() == this.a) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).param("obj_locate", this.a + 1).param("obj_type", "1"));
                    this.f33275b.P = true;
                    if (this.f33275b.f33272f.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) this.f33275b.f33272f.getAdapter()).G(this.a);
                    }
                    try {
                        this.f33275b.f33272f.setCurrentItem(this.a);
                    } catch (Exception unused) {
                    }
                    this.f33275b.F();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(View view, int i);
    }

    /* loaded from: classes5.dex */
    public class e implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PagerSlidingTabStrip a;

        public e(PagerSlidingTabStrip pagerSlidingTabStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pagerSlidingTabStrip;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.f33271e.getChildCount() == 0) {
                return;
            }
            if (i == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
                pagerSlidingTabStrip.D(pagerSlidingTabStrip.f33272f.getCurrentItem(), 0);
                this.a.j = 0.0f;
                this.a.P = false;
                this.a.Q = false;
            } else if (i == 1) {
                this.a.Q = true;
                PagerSlidingTabStrip pagerSlidingTabStrip2 = this.a;
                pagerSlidingTabStrip2.l = pagerSlidingTabStrip2.f33272f.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip3 = this.a;
                pagerSlidingTabStrip3.i = pagerSlidingTabStrip3.l;
                PagerSlidingTabStrip pagerSlidingTabStrip4 = this.a;
                pagerSlidingTabStrip4.k = pagerSlidingTabStrip4.i;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.a.f33270d;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
            HomePageStatic.a = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) || this.a.f33271e.getChildCount() == 0) {
                return;
            }
            if (!this.a.P) {
                if (i == this.a.l) {
                    this.a.i = i;
                    this.a.k = i + 1;
                } else if (i > this.a.l) {
                    this.a.i = i;
                    this.a.k = i + 1;
                } else {
                    this.a.i = i + 1;
                    this.a.k = i;
                }
                if (f2 == 0.0f) {
                    this.a.l = i;
                    this.a.i = i;
                    this.a.k = i;
                }
                this.a.j = f2;
                PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
                pagerSlidingTabStrip.D(i, (int) (pagerSlidingTabStrip.f33271e.getChildAt(i).getWidth() * f2));
            }
            this.a.F();
            this.a.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = this.a.f33270d;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f2, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.a.f33270d;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i);
                }
                if (this.a.P) {
                    PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
                    pagerSlidingTabStrip.D(i, (int) (pagerSlidingTabStrip.j * this.a.f33271e.getChildAt(i).getWidth()));
                    this.a.l = i;
                    this.a.i = i;
                    this.a.k = i;
                }
                this.a.invalidate();
            }
        }

        public /* synthetic */ e(PagerSlidingTabStrip pagerSlidingTabStrip, a aVar) {
            this(pagerSlidingTabStrip);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagerSlidingTabStrip(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public void B() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (viewPager = this.f33272f) == null || viewPager.getAdapter() == null || this.f33272f.getAdapter().getCount() == 0) {
            return;
        }
        this.f33271e.removeAllViews();
        this.f33273g = this.f33272f.getAdapter().getCount();
        for (int i = 0; i < this.f33273g; i++) {
            r(i, this.f33272f.getAdapter().getPageTitle(i).toString());
        }
        F();
        getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f33274h == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.f33274h = TbadkCoreApplication.getInst().getSkinType();
        this.w = SkinManager.getColor(this.t);
        this.x = SkinManager.getColor(this.u);
        this.m.setColor(SkinManager.getColor(this.v));
        this.n.setColor(SkinManager.getColor(R.color.CAM_X0301));
        F();
        invalidate();
    }

    public final void D(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) || this.f33273g == 0) {
            return;
        }
        int left = this.f33271e.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.y;
        }
        if (left != this.N) {
            this.N = left;
            scrollTo(left, 0);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f33271e.removeAllViews();
            ArrayList<String> c2 = c.a.p0.q1.i.n.b.c(this.V);
            this.f33273g = c2.size();
            for (int i = 0; i < this.f33273g; i++) {
                r(i, c2.get(i));
            }
            for (int i2 = 0; i2 < this.f33271e.getChildCount(); i2++) {
                View childAt = this.f33271e.getChildAt(i2);
                if (childAt != null) {
                    childAt.setFocusable(false);
                    childAt.setOnClickListener(null);
                }
            }
            F();
            getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
        }
    }

    public final void F() {
        float x;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            float f2 = this.j;
            if (this.k < this.i) {
                f2 = 1.0f - f2;
            }
            int i = 0;
            while (i < this.f33273g) {
                View childAt = this.f33271e.getChildAt(i);
                if (childAt != null) {
                    childAt.setBackgroundResource(this.O);
                    TextView textView = null;
                    if (i == this.i) {
                        x = s(f2);
                    } else {
                        x = i == this.k ? x(f2) : 1.0f;
                    }
                    if (childAt instanceof RelativeLayout) {
                        childAt.setScaleX(x);
                        childAt.setScaleY(x);
                        if (f2 >= 0.5f) {
                            if (i == this.k) {
                                RelativeLayout relativeLayout = (RelativeLayout) childAt;
                                relativeLayout.getChildAt(0).setVisibility(4);
                                relativeLayout.getChildAt(1).setVisibility(0);
                            } else {
                                RelativeLayout relativeLayout2 = (RelativeLayout) childAt;
                                relativeLayout2.getChildAt(0).setVisibility(0);
                                relativeLayout2.getChildAt(1).setVisibility(4);
                            }
                        } else if (i == this.i) {
                            RelativeLayout relativeLayout3 = (RelativeLayout) childAt;
                            relativeLayout3.getChildAt(0).setVisibility(4);
                            relativeLayout3.getChildAt(1).setVisibility(0);
                        } else {
                            RelativeLayout relativeLayout4 = (RelativeLayout) childAt;
                            relativeLayout4.getChildAt(0).setVisibility(0);
                            relativeLayout4.getChildAt(1).setVisibility(4);
                        }
                    } else if (childAt instanceof TextView) {
                        textView = (TextView) childAt;
                    } else if (childAt instanceof LinearLayout) {
                        LinearLayout linearLayout = (LinearLayout) childAt;
                        textView = (TextView) linearLayout.getChildAt(0);
                        if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                            ((ImageView) linearLayout.getChildAt(1)).setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08090f, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
                        }
                    }
                    if (textView != null) {
                        textView.setScaleX(x);
                        textView.setScaleY(x);
                        int i2 = (f2 > 0.5f ? 1 : (f2 == 0.5f ? 0 : -1));
                        if (i2 >= 0) {
                            if (i == this.k) {
                                textView.setTextColor(this.w);
                            } else {
                                textView.setTextColor(this.x);
                            }
                        } else if (i == this.i) {
                            textView.setTextColor(this.w);
                        } else {
                            textView.setTextColor(this.x);
                        }
                        if (i2 >= 0) {
                            if (i == this.k) {
                                c.a.o0.r.v.c.d(textView).A(R.string.F_X02);
                            } else {
                                c.a.o0.r.v.c.d(textView).A(R.string.F_X01);
                            }
                        } else if (i == this.i) {
                            c.a.o0.r.v.c.d(textView).A(R.string.F_X02);
                        } else {
                            c.a.o0.r.v.c.d(textView).A(R.string.F_X01);
                        }
                    }
                }
                i++;
            }
        }
    }

    public int getCurrentTabIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.i : invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            if (isInEditMode() || this.f33273g == 0) {
                return;
            }
            View childAt2 = this.f33271e.getChildAt(this.i);
            float left = childAt2.getLeft() + this.B;
            float right = childAt2.getRight() - this.B;
            if ((childAt2 instanceof LinearLayout) && (((LinearLayout) childAt2).getChildAt(0) instanceof TextView)) {
                float left2 = (childAt2.getLeft() + childAt2.getRight()) / 2.0f;
                right = v(left2, childAt2);
                left = u(left2, childAt2);
            }
            if (this.j > 0.0f) {
                int i = this.i;
                int i2 = this.k;
                if (i != i2 && i2 <= this.f33273g - 1 && i2 >= 0) {
                    View childAt3 = this.f33271e.getChildAt(i2);
                    float left3 = childAt3.getLeft() + this.B;
                    float right2 = childAt3.getRight() - this.B;
                    if ((childAt3 instanceof LinearLayout) && (((LinearLayout) childAt3).getChildAt(0) instanceof TextView)) {
                        float left4 = (childAt3.getLeft() + childAt3.getRight()) / 2.0f;
                        right2 = v(left4, childAt3);
                        left3 = u(left4, childAt3);
                    }
                    left = t(left, left3, this.j);
                    right = w(right, right2, this.j);
                }
            }
            int height = getHeight();
            RectF rectF = this.S;
            if (rectF == null) {
                int i3 = this.A;
                this.S = new RectF(left, (height - this.z) - i3, right, height - i3);
            } else {
                int i4 = this.A;
                rectF.set(left, (height - this.z) - i4, right, height - i4);
            }
            RectF rectF2 = this.S;
            int i5 = this.z;
            canvas.drawRoundRect(rectF2, i5 * 0.5f, i5 * 0.5f, this.m);
            if (!this.q || (childAt = this.f33271e.getChildAt(this.r)) == null) {
                return;
            }
            int right3 = (childAt.getRight() - this.M) - this.K;
            int top = childAt.getTop() + this.L;
            int i6 = this.K;
            this.o.set(right3, top, right3 + i6, top + i6);
            canvas.drawOval(this.o, this.n);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            int i = savedState.currentPosition;
            this.i = i;
            this.k = i;
            requestLayout();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.currentPosition = this.i;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public final void q(int i, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, view) == null) {
            view.setFocusable(true);
            view.setOnClickListener(new c(this, i));
            if (view instanceof RelativeLayout) {
                this.f33271e.addView(view, i);
            } else if (i == 0 && (view instanceof LinearLayout) && UbsABTestHelper.isConcernForumCardShow()) {
                this.f33271e.addView(view, i, this.a);
            } else {
                this.f33271e.addView(view, i, this.s ? this.f33268b : this.a);
            }
        }
    }

    public final void r(int i, String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, str) == null) {
            z a2 = z.a(str);
            if (a2 != null) {
                RelativeLayout relativeLayout = new RelativeLayout(getContext());
                relativeLayout.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0, UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0);
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds42);
                int i2 = (int) (((dimenPixelSize * 1.0f) * a2.i) / a2.j);
                TbImageView tbImageView = new TbImageView(getContext());
                tbImageView.G(a2.f11286h, 45, i2, dimenPixelSize, false);
                relativeLayout.addView(tbImageView, new RelativeLayout.LayoutParams(i2, dimenPixelSize));
                TbImageView tbImageView2 = new TbImageView(getContext());
                tbImageView2.setLayoutParams(new RelativeLayout.LayoutParams(i2, dimenPixelSize));
                tbImageView2.G(a2.f11285g, 45, i2, dimenPixelSize, false);
                tbImageView2.setVisibility(4);
                relativeLayout.addView(tbImageView2, new RelativeLayout.LayoutParams(i2, dimenPixelSize));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                relativeLayout.setLayoutParams(layoutParams);
                q(i, relativeLayout);
            } else if (UbsABTestHelper.isConcernForumCardShow() && i == 0 && (getResources().getString(R.string.obfuscated_res_0x7f0f131c).equals(str) || getResources().getString(R.string.obfuscated_res_0x7f0f02a8).equals(str))) {
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(0);
                TextView textView = new TextView(getContext());
                if (TbadkCoreApplication.isLogin() && c.a.o0.r.j0.b.k().l("key_home_concern_all_status", 0) == 1) {
                    string = getResources().getString(R.string.obfuscated_res_0x7f0f02a8);
                } else {
                    string = getResources().getString(R.string.obfuscated_res_0x7f0f131c);
                }
                textView.setText(string);
                textView.setGravity(17);
                textView.setTextSize(0, this.F);
                textView.setSingleLine();
                textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0, UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0);
                ImageView imageView = new ImageView(getContext());
                imageView.setVisibility(4);
                imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08090f, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
                linearLayout.addView(textView);
                linearLayout.addView(imageView);
                ((LinearLayout.LayoutParams) imageView.getLayoutParams()).leftMargin = this.T;
                linearLayout.setGravity(16);
                q(i, linearLayout);
            } else {
                EMTextView eMTextView = new EMTextView(getContext());
                if (i == 0) {
                    if (UbsABTestHelper.isConcernForumCardShow() && TbadkCoreApplication.isLogin() && c.a.o0.r.j0.b.k().l("key_home_concern_all_status", 0) == 1) {
                        str = getResources().getString(R.string.obfuscated_res_0x7f0f02a8);
                    } else {
                        str = getResources().getString(R.string.obfuscated_res_0x7f0f131c);
                    }
                }
                eMTextView.setTextSize(0, this.F);
                eMTextView.setSingleLine();
                eMTextView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0, UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0);
                eMTextView.setGravity(17);
                eMTextView.setText(str);
                q(i, eMTextView);
            }
        }
    }

    public final float s(float f2) {
        InterceptResult invokeF;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f2)) == null) {
            if (f2 <= 0.1f) {
                f3 = this.I;
                f4 = (this.J - f3) / 0.1f;
            } else {
                f3 = this.J;
                f4 = (f3 - 1.0f) / (-0.9f);
                f2 -= 0.1f;
            }
            return f3 + (f4 * f2);
        }
        return invokeF.floatValue;
    }

    public void setConcernTabIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, layoutParams) == null) {
            this.f33268b = layoutParams;
        }
    }

    public void setHotTopicIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.r = i;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onPageChangeListener) == null) {
            this.f33270d = onPageChangeListener;
        }
    }

    public void setOnTabItemClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.U = dVar;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.p = z;
            invalidate();
        }
    }

    public void setShowHotTopicRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.q = z;
            invalidate();
        }
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.P = z;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, viewPager) == null) {
            this.f33272f = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.f33269c);
            B();
        }
    }

    public final float t(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f3 <= f2) {
                return ((double) f4) >= 0.5d ? f2 - (((f2 - f3) * (1.0f - f4)) / 0.5f) : f3;
            }
            double d2 = f4;
            if (d2 <= 0.5d) {
                return f2;
            }
            if (d2 <= 0.8d) {
                return f2 + ((((f3 + this.C) - f2) * (f4 - 0.5f)) / 0.3f);
            }
            int i = this.C;
            return (f3 + i) - ((i * (f4 - 0.8f)) / 0.2f);
        }
        return invokeCommon.floatValue;
    }

    public final float u(float f2, View view) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Float.valueOf(f2), view})) == null) ? (f2 - ((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.obfuscated_res_0x7f0f131c)) + (UtilHelper.getDimenPixelSize(R.dimen.tbds26) * 2)) / 2.0f)) + this.B : invokeCommon.floatValue;
    }

    public final float v(float f2, View view) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Float.valueOf(f2), view})) == null) ? (f2 + ((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.obfuscated_res_0x7f0f131c)) + (UtilHelper.getDimenPixelSize(R.dimen.tbds26) * 2)) / 2.0f)) - this.B : invokeCommon.floatValue;
    }

    public final float w(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f3 > f2) {
                return ((double) f4) <= 0.5d ? f2 + (((f3 - f2) * f4) / 0.5f) : f3;
            }
            double d2 = f4;
            if (d2 >= 0.5d) {
                return f2;
            }
            if (d2 >= 0.2d) {
                return f2 - ((((this.C + f2) - f3) * (0.5f - f4)) / 0.3f);
            }
            int i = this.C;
            return (f3 - i) + ((i * (0.2f - f4)) / 0.2f);
        }
        return invokeCommon.floatValue;
    }

    public final float x(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048602, this, f2)) == null) {
            if (f2 <= 0.1f) {
                return 1.0f;
            }
            if (f2 <= 0.9f) {
                return (((1.0f - this.J) / (-0.79999995f)) * (f2 - 0.1f)) + 1.0f;
            }
            float f3 = this.J;
            return f3 + (((f3 - this.I) / (-0.100000024f)) * (f2 - 0.9f));
        }
        return invokeF.floatValue;
    }

    public View y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) ? this.f33271e.getChildAt(i) : (View) invokeI.objValue;
    }

    public void z(int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            setFillViewport(true);
            setWillNotDraw(false);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f33271e = linearLayout;
            linearLayout.setOrientation(0);
            this.f33271e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.f33271e);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.y = (int) TypedValue.applyDimension(1, this.y, displayMetrics);
            this.D = (int) TypedValue.applyDimension(1, this.D, displayMetrics);
            this.E = (int) TypedValue.applyDimension(1, this.E, displayMetrics);
            this.F = i;
            this.G = i2;
            int f2 = n.f(getContext(), R.dimen.tbds46);
            this.H = f2;
            int i4 = this.F;
            this.I = (this.G * 1.0f) / i4;
            this.J = (f2 * 1.0f) / i4;
            this.T = -n.f(getContext(), R.dimen.tbds11);
            this.z = i3;
            this.s = z;
            Paint paint = new Paint();
            this.m = paint;
            paint.setAntiAlias(true);
            this.m.setStyle(Paint.Style.FILL);
            this.m.setColor(SkinManager.getColor(R.color.CAM_X0302));
            Paint paint2 = new Paint();
            this.n = paint2;
            paint2.setAntiAlias(true);
            this.n.setStyle(Paint.Style.FILL);
            this.n.setColor(SkinManager.getColor(R.color.CAM_X0301));
            setLayerType(1, null);
            this.o = new RectF();
            this.K = n.f(getContext(), R.dimen.tbds20);
            this.L = (int) (n.f(getContext(), R.dimen.tbds28) * 0.5d);
            this.M = (int) (n.f(getContext(), R.dimen.tbds22) * 0.4d);
            this.a = new LinearLayout.LayoutParams(-2, -1);
            this.f33268b = new LinearLayout.LayoutParams(n.f(getContext(), R.dimen.tbds165), -1);
            this.B = UtilHelper.getDimenPixelSize(R.dimen.tbds26) + Math.round(i * 0.5f);
            this.A = n.f(getContext(), R.dimen.tbds5);
            this.C = n.f(getContext(), R.dimen.tbds8);
            if (this.R == null) {
                this.R = getResources().getConfiguration().locale;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f33269c = new e(this, null);
        this.f33274h = 3;
        this.i = 0;
        this.j = 0.0f;
        this.k = 0;
        this.l = 0;
        this.q = false;
        this.r = -1;
        this.s = false;
        this.t = R.color.CAM_X0105;
        this.u = R.color.CAM_X0105;
        this.v = R.color.CAM_X0302;
        this.w = SkinManager.getColor(R.color.CAM_X0105);
        this.x = SkinManager.getColor(this.u);
        this.y = 52;
        this.z = 4;
        this.D = 12;
        this.E = 1;
        this.F = 17;
        this.G = 17;
        this.N = 0;
        this.O = R.drawable.obfuscated_res_0x7f080e52;
        this.P = false;
        this.Q = false;
        this.V = context;
    }
}

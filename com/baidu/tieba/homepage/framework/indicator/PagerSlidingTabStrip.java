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
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.e.e.p.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes7.dex */
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
    public int I;
    public int J;
    public int K;
    public float L;
    public float M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;
    public Locale U;
    public RectF V;
    public int W;
    public c a0;
    public ViewPager.OnPageChangeListener delegatePageListener;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout.LayoutParams f52267e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout.LayoutParams f52268f;

    /* renamed from: g  reason: collision with root package name */
    public final d f52269g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f52270h;

    /* renamed from: i  reason: collision with root package name */
    public ViewPager f52271i;

    /* renamed from: j  reason: collision with root package name */
    public int f52272j;
    public int k;
    public int l;
    public float m;
    public int n;
    public int o;
    public Paint p;
    public Paint q;
    public RectF r;
    public boolean s;
    public boolean t;
    public int u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes7.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentPosition;

        /* loaded from: classes7.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
            public SavedState[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
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
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.currentPosition = parcel.readInt();
        }
    }

    /* loaded from: classes7.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabStrip f52273e;

        public a(PagerSlidingTabStrip pagerSlidingTabStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52273e = pagerSlidingTabStrip;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52273e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                PagerSlidingTabStrip pagerSlidingTabStrip = this.f52273e;
                pagerSlidingTabStrip.l = pagerSlidingTabStrip.f52271i.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip2 = this.f52273e;
                pagerSlidingTabStrip2.n = pagerSlidingTabStrip2.l;
                this.f52273e.z();
                PagerSlidingTabStrip pagerSlidingTabStrip3 = this.f52273e;
                pagerSlidingTabStrip3.y(pagerSlidingTabStrip3.l, 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f52274e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabStrip f52275f;

        public b(PagerSlidingTabStrip pagerSlidingTabStrip, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabStrip, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52275f = pagerSlidingTabStrip;
            this.f52274e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52275f.T) {
                return;
            }
            if (this.f52275f.a0 != null) {
                this.f52275f.a0.a(view, this.f52274e);
            }
            if (this.f52274e == 1 || !FullBrowseHelper.checkIsFullBrowseMode()) {
                int currentItem = this.f52275f.f52271i.getCurrentItem();
                int i2 = this.f52274e;
                if (currentItem != i2 || i2 != 0 || !TbadkCoreApplication.isLogin() || !c.a.q0.b.d.i()) {
                    if (this.f52275f.f52271i.getCurrentItem() == this.f52274e) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).param("obj_locate", this.f52274e + 1).param("obj_type", "1"));
                    this.f52275f.S = true;
                    if (this.f52275f.f52271i.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) this.f52275f.f52271i.getAdapter()).setTargetItemIndex(this.f52274e);
                    }
                    this.f52275f.f52271i.setCurrentItem(this.f52274e);
                    this.f52275f.z();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(View view, int i2);
    }

    /* loaded from: classes7.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PagerSlidingTabStrip f52276e;

        public d(PagerSlidingTabStrip pagerSlidingTabStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pagerSlidingTabStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52276e = pagerSlidingTabStrip;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f52276e.f52270h.getChildCount() == 0) {
                return;
            }
            if (i2 == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = this.f52276e;
                pagerSlidingTabStrip.y(pagerSlidingTabStrip.f52271i.getCurrentItem(), 0);
                this.f52276e.m = 0.0f;
                this.f52276e.S = false;
                this.f52276e.T = false;
            } else if (i2 == 1) {
                this.f52276e.T = true;
                PagerSlidingTabStrip pagerSlidingTabStrip2 = this.f52276e;
                pagerSlidingTabStrip2.o = pagerSlidingTabStrip2.f52271i.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip3 = this.f52276e;
                pagerSlidingTabStrip3.l = pagerSlidingTabStrip3.o;
                PagerSlidingTabStrip pagerSlidingTabStrip4 = this.f52276e;
                pagerSlidingTabStrip4.n = pagerSlidingTabStrip4.l;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.f52276e.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
            HomePageStatic.f52123a = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f52276e.f52270h.getChildCount() == 0) {
                return;
            }
            if (!this.f52276e.S) {
                if (i2 == this.f52276e.o) {
                    this.f52276e.l = i2;
                    this.f52276e.n = i2 + 1;
                } else if (i2 > this.f52276e.o) {
                    this.f52276e.l = i2;
                    this.f52276e.n = i2 + 1;
                } else {
                    this.f52276e.l = i2 + 1;
                    this.f52276e.n = i2;
                }
                if (f2 == 0.0f) {
                    this.f52276e.o = i2;
                    this.f52276e.l = i2;
                    this.f52276e.n = i2;
                }
                this.f52276e.m = f2;
                PagerSlidingTabStrip pagerSlidingTabStrip = this.f52276e;
                pagerSlidingTabStrip.y(i2, (int) (pagerSlidingTabStrip.f52270h.getChildAt(i2).getWidth() * f2));
            }
            this.f52276e.z();
            this.f52276e.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = this.f52276e.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.f52276e.delegatePageListener;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i2);
                }
                if (this.f52276e.S) {
                    PagerSlidingTabStrip pagerSlidingTabStrip = this.f52276e;
                    pagerSlidingTabStrip.y(i2, (int) (pagerSlidingTabStrip.m * this.f52276e.f52270h.getChildAt(i2).getWidth()));
                    this.f52276e.o = i2;
                    this.f52276e.l = i2;
                    this.f52276e.n = i2;
                }
                this.f52276e.invalidate();
            }
        }

        public /* synthetic */ d(PagerSlidingTabStrip pagerSlidingTabStrip, a aVar) {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public int getCurrentTabIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l : invokeV.intValue;
    }

    public View getTabView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f52270h.getChildAt(i2) : (View) invokeI.objValue;
    }

    public void init(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            setFillViewport(true);
            setWillNotDraw(false);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.f52270h = linearLayout;
            linearLayout.setOrientation(0);
            this.f52270h.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.f52270h);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.B = (int) TypedValue.applyDimension(1, this.B, displayMetrics);
            this.G = (int) TypedValue.applyDimension(1, this.G, displayMetrics);
            this.H = (int) TypedValue.applyDimension(1, this.H, displayMetrics);
            this.I = i2;
            this.J = i3;
            int g2 = l.g(getContext(), R.dimen.tbds46);
            this.K = g2;
            int i5 = this.I;
            this.L = (this.J * 1.0f) / i5;
            this.M = (g2 * 1.0f) / i5;
            this.W = -l.g(getContext(), R.dimen.tbds11);
            this.C = i4;
            this.v = z;
            Paint paint = new Paint();
            this.p = paint;
            paint.setAntiAlias(true);
            this.p.setStyle(Paint.Style.FILL);
            this.p.setColor(SkinManager.getColor(R.color.CAM_X0302));
            Paint paint2 = new Paint();
            this.q = paint2;
            paint2.setAntiAlias(true);
            this.q.setStyle(Paint.Style.FILL);
            this.q.setColor(SkinManager.getColor(R.color.CAM_X0301));
            setLayerType(1, null);
            this.r = new RectF();
            this.N = l.g(getContext(), R.dimen.tbds20);
            this.O = (int) (l.g(getContext(), R.dimen.tbds28) * 0.5d);
            this.P = (int) (l.g(getContext(), R.dimen.tbds22) * 0.4d);
            this.f52267e = new LinearLayout.LayoutParams(-2, -1);
            this.f52268f = new LinearLayout.LayoutParams(l.g(getContext(), R.dimen.tbds165), -1);
            this.E = UtilHelper.getDimenPixelSize(R.dimen.tbds26) + Math.round(i2 * 0.5f);
            this.D = l.g(getContext(), R.dimen.tbds5);
            this.F = l.g(getContext(), R.dimen.tbds8);
            if (this.U == null) {
                this.U = getResources().getConfiguration().locale;
            }
        }
    }

    public boolean isShowConcernRedTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean isShowHotTopicRedTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.t : invokeV.booleanValue;
    }

    public boolean isTabItemClicked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.S : invokeV.booleanValue;
    }

    public void notifyDataSetChanged() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (viewPager = this.f52271i) == null || viewPager.getAdapter() == null || this.f52271i.getAdapter().getCount() == 0) {
            return;
        }
        this.f52270h.removeAllViews();
        this.f52272j = this.f52271i.getAdapter().getCount();
        for (int i2 = 0; i2 < this.f52272j; i2++) {
            r(i2, this.f52271i.getAdapter().getPageTitle(i2).toString());
        }
        z();
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.k == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.k = TbadkCoreApplication.getInst().getSkinType();
        this.z = SkinManager.getColor(this.w);
        this.A = SkinManager.getColor(this.x);
        this.p.setColor(SkinManager.getColor(this.y));
        this.q.setColor(SkinManager.getColor(R.color.CAM_X0301));
        z();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, canvas) == null) {
            super.onDraw(canvas);
            if (isInEditMode() || this.f52272j == 0) {
                return;
            }
            View childAt2 = this.f52270h.getChildAt(this.l);
            float left = childAt2.getLeft() + this.E;
            float right = childAt2.getRight() - this.E;
            if ((childAt2 instanceof LinearLayout) && (((LinearLayout) childAt2).getChildAt(0) instanceof TextView)) {
                float left2 = (childAt2.getLeft() + childAt2.getRight()) / 2.0f;
                right = v(left2, childAt2);
                left = u(left2, childAt2);
            }
            if (this.m > 0.0f) {
                int i2 = this.l;
                int i3 = this.n;
                if (i2 != i3 && i3 <= this.f52272j - 1 && i3 >= 0) {
                    View childAt3 = this.f52270h.getChildAt(i3);
                    float left3 = childAt3.getLeft() + this.E;
                    float right2 = childAt3.getRight() - this.E;
                    if ((childAt3 instanceof LinearLayout) && (((LinearLayout) childAt3).getChildAt(0) instanceof TextView)) {
                        float left4 = (childAt3.getLeft() + childAt3.getRight()) / 2.0f;
                        right2 = v(left4, childAt3);
                        left3 = u(left4, childAt3);
                    }
                    left = t(left, left3, this.m);
                    right = w(right, right2, this.m);
                }
            }
            int height = getHeight();
            RectF rectF = this.V;
            if (rectF == null) {
                int i4 = this.D;
                this.V = new RectF(left, (height - this.C) - i4, right, height - i4);
            } else {
                int i5 = this.D;
                rectF.set(left, (height - this.C) - i5, right, height - i5);
            }
            RectF rectF2 = this.V;
            int i6 = this.C;
            canvas.drawRoundRect(rectF2, i6 * 0.5f, i6 * 0.5f, this.p);
            if (!this.t || (childAt = this.f52270h.getChildAt(this.u)) == null) {
                return;
            }
            int right3 = (childAt.getRight() - this.P) - this.N;
            int top = childAt.getTop() + this.O;
            int i7 = this.N;
            this.r.set(right3, top, right3 + i7, top + i7);
            canvas.drawOval(this.r, this.q);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            int i2 = savedState.currentPosition;
            this.l = i2;
            this.n = i2;
            requestLayout();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.currentPosition = this.l;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public final void q(int i2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, view) == null) {
            view.setFocusable(true);
            view.setOnClickListener(new b(this, i2));
            if (i2 == 0 && (view instanceof LinearLayout) && c.a.q0.b.d.i()) {
                this.f52270h.addView(view, i2, this.f52267e);
            } else {
                this.f52270h.addView(view, i2, this.v ? this.f52268f : this.f52267e);
            }
        }
    }

    public final void r(int i2, String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i2, str) == null) {
            if (c.a.q0.b.d.i() && i2 == 0 && (getResources().getString(R.string.tab_name_concern).equals(str) || getResources().getString(R.string.attention_person).equals(str))) {
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(0);
                TextView textView = new TextView(getContext());
                if (TbadkCoreApplication.isLogin() && c.a.q0.s.d0.b.j().k("key_home_concern_all_status", 0) == 1) {
                    string = getResources().getString(R.string.attention_person);
                } else {
                    string = getResources().getString(R.string.tab_name_concern);
                }
                textView.setText(string);
                textView.setGravity(17);
                textView.setTextSize(0, this.I);
                textView.setSingleLine();
                textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0, UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0);
                ImageView imageView = new ImageView(getContext());
                imageView.setVisibility(4);
                imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_home_unfold16, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
                linearLayout.addView(textView);
                linearLayout.addView(imageView);
                ((LinearLayout.LayoutParams) imageView.getLayoutParams()).leftMargin = this.W;
                linearLayout.setGravity(16);
                q(i2, linearLayout);
                return;
            }
            EMTextView eMTextView = new EMTextView(getContext());
            if (i2 == 0) {
                if (c.a.q0.b.d.i() && TbadkCoreApplication.isLogin() && c.a.q0.s.d0.b.j().k("key_home_concern_all_status", 0) == 1) {
                    str = getResources().getString(R.string.attention_person);
                } else {
                    str = getResources().getString(R.string.tab_name_concern);
                }
            }
            eMTextView.setTextSize(0, this.I);
            eMTextView.setSingleLine();
            eMTextView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0, UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0);
            eMTextView.setGravity(17);
            eMTextView.setText(str);
            q(i2, eMTextView);
        }
    }

    public final float s(float f2) {
        InterceptResult invokeF;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048589, this, f2)) == null) {
            if (f2 <= 0.1f) {
                f3 = this.L;
                f4 = (this.M - f3) / 0.1f;
            } else {
                f3 = this.M;
                f4 = (f3 - 1.0f) / (-0.9f);
                f2 -= 0.1f;
            }
            return f3 + (f4 * f2);
        }
        return invokeF.floatValue;
    }

    public void setConcernTabIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, layoutParams) == null) {
            this.f52268f = layoutParams;
        }
    }

    public void setHotTopicIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.u = i2;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onPageChangeListener) == null) {
            this.delegatePageListener = onPageChangeListener;
        }
    }

    public void setOnTabItemClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, cVar) == null) {
            this.a0 = cVar;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.s = z;
            invalidate();
        }
    }

    public void setShowHotTopicRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.t = z;
            invalidate();
        }
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.S = z;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, viewPager) == null) {
            this.f52271i = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.f52269g);
            notifyDataSetChanged();
        }
    }

    public final float t(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f3 <= f2) {
                return ((double) f4) >= 0.5d ? f2 - (((f2 - f3) * (1.0f - f4)) / 0.5f) : f3;
            }
            double d2 = f4;
            if (d2 <= 0.5d) {
                return f2;
            }
            if (d2 <= 0.8d) {
                return f2 + ((((f3 + this.F) - f2) * (f4 - 0.5f)) / 0.3f);
            }
            int i2 = this.F;
            return (f3 + i2) - ((i2 * (f4 - 0.8f)) / 0.2f);
        }
        return invokeCommon.floatValue;
    }

    public final float u(float f2, View view) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Float.valueOf(f2), view})) == null) ? (f2 - ((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.tbds26) * 2)) / 2.0f)) + this.E : invokeCommon.floatValue;
    }

    public void updateData() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || (viewPager = this.f52271i) == null || viewPager.getAdapter() == null || this.f52271i.getAdapter().getCount() == 0) {
            return;
        }
        this.f52270h.removeAllViews();
        this.f52272j = this.f52271i.getAdapter().getCount();
        for (int i2 = 0; i2 < this.f52272j; i2++) {
            r(i2, this.f52271i.getAdapter().getPageTitle(i2).toString());
        }
        z();
    }

    public final float v(float f2, View view) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Float.valueOf(f2), view})) == null) ? (f2 + ((((TextView) ((LinearLayout) view).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.tab_name_concern)) + (UtilHelper.getDimenPixelSize(R.dimen.tbds26) * 2)) / 2.0f)) - this.E : invokeCommon.floatValue;
    }

    public final float w(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f3 > f2) {
                return ((double) f4) <= 0.5d ? f2 + (((f3 - f2) * f4) / 0.5f) : f3;
            }
            double d2 = f4;
            if (d2 >= 0.5d) {
                return f2;
            }
            if (d2 >= 0.2d) {
                return f2 - ((((this.F + f2) - f3) * (0.5f - f4)) / 0.3f);
            }
            int i2 = this.F;
            return (f3 - i2) + ((i2 * (0.2f - f4)) / 0.2f);
        }
        return invokeCommon.floatValue;
    }

    public final float x(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048604, this, f2)) == null) {
            if (f2 <= 0.1f) {
                return 1.0f;
            }
            if (f2 <= 0.9f) {
                return (((1.0f - this.M) / (-0.79999995f)) * (f2 - 0.1f)) + 1.0f;
            }
            float f3 = this.M;
            return f3 + (((f3 - this.L) / (-0.100000024f)) * (f2 - 0.9f));
        }
        return invokeF.floatValue;
    }

    public final void y(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048605, this, i2, i3) == null) || this.f52272j == 0) {
            return;
        }
        int left = this.f52270h.getChildAt(i2).getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
            left -= this.B;
        }
        if (left != this.Q) {
            this.Q = left;
            scrollTo(left, 0);
        }
    }

    public final void z() {
        float x;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            float f2 = this.m;
            if (this.n < this.l) {
                f2 = 1.0f - f2;
            }
            int i2 = 0;
            while (i2 < this.f52272j) {
                View childAt = this.f52270h.getChildAt(i2);
                if (childAt != null) {
                    childAt.setBackgroundResource(this.R);
                    TextView textView = null;
                    if (childAt instanceof TextView) {
                        textView = (TextView) childAt;
                    } else if (childAt instanceof LinearLayout) {
                        LinearLayout linearLayout = (LinearLayout) childAt;
                        textView = (TextView) linearLayout.getChildAt(0);
                        if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                            ((ImageView) linearLayout.getChildAt(1)).setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_home_unfold16, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
                        }
                    }
                    if (textView != null) {
                        if (i2 == this.l) {
                            x = s(f2);
                        } else {
                            x = i2 == this.n ? x(f2) : 1.0f;
                        }
                        textView.setScaleX(x);
                        textView.setScaleY(x);
                        int i3 = (f2 > 0.5f ? 1 : (f2 == 0.5f ? 0 : -1));
                        if (i3 >= 0) {
                            if (i2 == this.n) {
                                textView.setTextColor(this.z);
                            } else {
                                textView.setTextColor(this.A);
                            }
                        } else if (i2 == this.l) {
                            textView.setTextColor(this.z);
                        } else {
                            textView.setTextColor(this.A);
                        }
                        if (i3 >= 0) {
                            if (i2 == this.n) {
                                c.a.q0.s.u.c.d(textView).B(R.string.F_X02);
                            } else {
                                c.a.q0.s.u.c.d(textView).B(R.string.F_X01);
                            }
                        } else if (i2 == this.l) {
                            c.a.q0.s.u.c.d(textView).B(R.string.F_X02);
                        } else {
                            c.a.q0.s.u.c.d(textView).B(R.string.F_X01);
                        }
                    }
                }
                i2++;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f52269g = new d(this, null);
        this.k = 3;
        this.l = 0;
        this.m = 0.0f;
        this.n = 0;
        this.o = 0;
        this.t = false;
        this.u = -1;
        this.v = false;
        int i5 = R.color.CAM_X0105;
        this.w = i5;
        this.x = i5;
        this.y = R.color.CAM_X0302;
        this.z = SkinManager.getColor(i5);
        this.A = SkinManager.getColor(this.x);
        this.B = 52;
        this.C = 4;
        this.G = 12;
        this.H = 1;
        this.I = 17;
        this.J = 17;
        this.Q = 0;
        this.R = R.drawable.pager_sliding_view;
        this.S = false;
        this.T = false;
    }
}

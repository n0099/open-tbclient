package com.baidu.tieba.homepage.framework.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.tab.FrsTabItemCustomeView;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.au6;
import com.repackage.fr4;
import com.repackage.ht4;
import com.repackage.pi;
import com.repackage.tw4;
import java.util.Locale;
/* loaded from: classes3.dex */
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
    public float H;
    public float I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public Locale Q;
    public RectF R;
    public int S;
    public c T;
    public Context U;
    public LinearLayout.LayoutParams a;
    public LinearLayout.LayoutParams b;
    public final d c;
    public ViewPager.OnPageChangeListener d;
    public LinearLayout e;
    public ViewPager f;
    public int g;
    public int h;
    public float i;
    public int j;
    public int k;
    public Paint l;
    public Paint m;
    public RectF n;
    public boolean o;
    public boolean p;
    public int q;
    public boolean r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentPosition;

        /* loaded from: classes3.dex */
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

        public /* synthetic */ SavedState(Parcel parcel, au6 au6Var) {
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

    /* loaded from: classes3.dex */
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
                PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
                pagerSlidingTabStrip.h = pagerSlidingTabStrip.f.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip2 = this.a;
                pagerSlidingTabStrip2.j = pagerSlidingTabStrip2.h;
                this.a.E();
                PagerSlidingTabStrip pagerSlidingTabStrip3 = this.a;
                pagerSlidingTabStrip3.D(pagerSlidingTabStrip3.h, 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PagerSlidingTabStrip b;

        public b(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
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
            this.b = pagerSlidingTabStrip;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.b.P) {
                return;
            }
            if (this.b.T != null) {
                this.b.T.a(view2, this.a);
            }
            if (this.a == 1 || !FullBrowseHelper.checkIsFullBrowseMode()) {
                int currentItem = this.b.f.getCurrentItem();
                int i = this.a;
                if (currentItem != i || i != 0 || !TbadkCoreApplication.isLogin() || !UbsABTestHelper.isConcernForumCardShow()) {
                    if (this.b.f.getCurrentItem() == this.a) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, 0));
                        return;
                    }
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RECOMMEND_TIP_ITEM_CLICK).param("obj_locate", this.a + 1).param("obj_type", "1"));
                    this.b.O = true;
                    if (this.b.f.getAdapter() instanceof NewScrollFragmentAdapter) {
                        ((NewScrollFragmentAdapter) this.b.f.getAdapter()).H(this.a);
                    }
                    try {
                        this.b.f.setCurrentItem(this.a);
                    } catch (Exception unused) {
                    }
                    this.b.E();
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921501, 1));
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(View view2, int i);
    }

    /* loaded from: classes3.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PagerSlidingTabStrip a;

        public d(PagerSlidingTabStrip pagerSlidingTabStrip) {
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
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.e.getChildCount() == 0) {
                return;
            }
            if (i == 0) {
                PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
                pagerSlidingTabStrip.D(pagerSlidingTabStrip.f.getCurrentItem(), 0);
                this.a.i = 0.0f;
                this.a.O = false;
                this.a.P = false;
            } else if (i == 1) {
                this.a.P = true;
                PagerSlidingTabStrip pagerSlidingTabStrip2 = this.a;
                pagerSlidingTabStrip2.k = pagerSlidingTabStrip2.f.getCurrentItem();
                PagerSlidingTabStrip pagerSlidingTabStrip3 = this.a;
                pagerSlidingTabStrip3.h = pagerSlidingTabStrip3.k;
                PagerSlidingTabStrip pagerSlidingTabStrip4 = this.a;
                pagerSlidingTabStrip4.j = pagerSlidingTabStrip4.h;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.a.d;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
            HomePageStatic.a = false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) || this.a.e.getChildCount() == 0) {
                return;
            }
            if (!this.a.O) {
                if (i == this.a.k) {
                    this.a.h = i;
                    this.a.j = i + 1;
                } else if (i > this.a.k) {
                    this.a.h = i;
                    this.a.j = i + 1;
                } else {
                    this.a.h = i + 1;
                    this.a.j = i;
                }
                if (f == 0.0f) {
                    this.a.k = i;
                    this.a.h = i;
                    this.a.j = i;
                }
                this.a.i = f;
                PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
                pagerSlidingTabStrip.D(i, (int) (pagerSlidingTabStrip.e.getChildAt(i).getWidth() * f));
            }
            this.a.E();
            this.a.invalidate();
            ViewPager.OnPageChangeListener onPageChangeListener = this.a.d;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f, i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.a.d;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i);
                }
                if (this.a.O) {
                    PagerSlidingTabStrip pagerSlidingTabStrip = this.a;
                    pagerSlidingTabStrip.D(i, (int) (pagerSlidingTabStrip.i * this.a.e.getChildAt(i).getWidth()));
                    this.a.k = i;
                    this.a.h = i;
                    this.a.j = i;
                }
                this.a.invalidate();
            }
        }

        public /* synthetic */ d(PagerSlidingTabStrip pagerSlidingTabStrip, au6 au6Var) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public void B() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (viewPager = this.f) == null || viewPager.getAdapter() == null || this.f.getAdapter().getCount() == 0) {
            return;
        }
        this.e.removeAllViews();
        this.g = this.f.getAdapter().getCount();
        for (int i = 0; i < this.g; i++) {
            r(i, this.f.getAdapter().getPageTitle(i).toString());
        }
        E();
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (TbadkApplication.getInst().isUseLuckyHeader()) {
                this.v = SkinManager.getColor(R.color.CAM_X0101);
                this.w = SkinManager.getColor(R.color.CAM_X0101);
                this.l.setColor(SkinManager.getColor(R.color.CAM_X0101));
            } else {
                this.v = SkinManager.getColor(this.s);
                this.w = SkinManager.getColor(this.t);
                this.l.setColor(SkinManager.getColor(this.u));
            }
            this.m.setColor(SkinManager.getColor(R.color.CAM_X0301));
            E();
            invalidate();
        }
    }

    public final void D(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) || this.g == 0) {
            return;
        }
        int left = this.e.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.x;
        }
        if (left != this.M) {
            this.M = left;
            scrollTo(left, 0);
        }
    }

    public final void E() {
        float x;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            float f = this.i;
            if (this.j < this.h) {
                f = 1.0f - f;
            }
            int i = 0;
            while (i < this.g) {
                View childAt = this.e.getChildAt(i);
                if (childAt != null) {
                    childAt.setBackgroundResource(this.N);
                    if (i == this.h) {
                        x = s(f);
                    } else {
                        x = i == this.j ? x(f) : 1.0f;
                    }
                    TextView textView = null;
                    if (childAt instanceof FrsTabItemCustomeView) {
                        FrsTabItemCustomeView frsTabItemCustomeView = (FrsTabItemCustomeView) childAt;
                        frsTabItemCustomeView.a();
                        if (TbadkApplication.getInst().isUseLuckyHeader()) {
                            frsTabItemCustomeView.setSelectColorFilter(new PorterDuffColorFilter(SkinManager.getColor(R.color.CAM_X0101), PorterDuff.Mode.SRC_IN));
                        } else {
                            frsTabItemCustomeView.setSelectColorFilter(null);
                        }
                        frsTabItemCustomeView.setScaleX(x);
                        frsTabItemCustomeView.setScaleY(x);
                        if (f >= 0.5f) {
                            if (i == this.j) {
                                frsTabItemCustomeView.b(false);
                            } else {
                                frsTabItemCustomeView.b(true);
                            }
                        } else if (i == this.h) {
                            frsTabItemCustomeView.b(true);
                        } else {
                            frsTabItemCustomeView.b(false);
                        }
                    } else if (childAt instanceof TextView) {
                        textView = (TextView) childAt;
                    } else if (childAt instanceof LinearLayout) {
                        LinearLayout linearLayout = (LinearLayout) childAt;
                        textView = (TextView) linearLayout.getChildAt(0);
                        if (linearLayout.getChildCount() > 1 && (linearLayout.getChildAt(1) instanceof ImageView)) {
                            ((ImageView) linearLayout.getChildAt(1)).setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08091b, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
                        }
                    }
                    if (textView != null) {
                        textView.setScaleX(x);
                        textView.setScaleY(x);
                        int i2 = (f > 0.5f ? 1 : (f == 0.5f ? 0 : -1));
                        if (i2 >= 0) {
                            if (i == this.j) {
                                textView.setTextColor(this.v);
                            } else {
                                textView.setTextColor(this.w);
                            }
                        } else if (i == this.h) {
                            textView.setTextColor(this.v);
                        } else {
                            textView.setTextColor(this.w);
                        }
                        if (i2 >= 0) {
                            if (i == this.j) {
                                fr4.d(textView).A(R.string.F_X02);
                            } else {
                                fr4.d(textView).A(R.string.F_X01);
                            }
                        } else if (i == this.h) {
                            fr4.d(textView).A(R.string.F_X02);
                        } else {
                            fr4.d(textView).A(R.string.F_X01);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.h : invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            super.onDraw(canvas);
            if (isInEditMode() || this.g == 0) {
                return;
            }
            View childAt2 = this.e.getChildAt(this.h);
            float left = childAt2.getLeft() + this.A;
            float right = childAt2.getRight() - this.A;
            if ((childAt2 instanceof LinearLayout) && (((LinearLayout) childAt2).getChildAt(0) instanceof TextView)) {
                float left2 = (childAt2.getLeft() + childAt2.getRight()) / 2.0f;
                right = v(left2, childAt2);
                left = u(left2, childAt2);
            }
            if (this.i > 0.0f) {
                int i = this.h;
                int i2 = this.j;
                if (i != i2 && i2 <= this.g - 1 && i2 >= 0) {
                    View childAt3 = this.e.getChildAt(i2);
                    float left3 = childAt3.getLeft() + this.A;
                    float right2 = childAt3.getRight() - this.A;
                    if ((childAt3 instanceof LinearLayout) && (((LinearLayout) childAt3).getChildAt(0) instanceof TextView)) {
                        float left4 = (childAt3.getLeft() + childAt3.getRight()) / 2.0f;
                        right2 = v(left4, childAt3);
                        left3 = u(left4, childAt3);
                    }
                    left = t(left, left3, this.i);
                    right = w(right, right2, this.i);
                }
            }
            int height = getHeight();
            RectF rectF = this.R;
            if (rectF == null) {
                int i3 = this.z;
                this.R = new RectF(left, (height - this.y) - i3, right, height - i3);
            } else {
                int i4 = this.z;
                rectF.set(left, (height - this.y) - i4, right, height - i4);
            }
            RectF rectF2 = this.R;
            int i5 = this.y;
            canvas.drawRoundRect(rectF2, i5 * 0.5f, i5 * 0.5f, this.l);
            if (!this.p || (childAt = this.e.getChildAt(this.q)) == null) {
                return;
            }
            int right3 = (childAt.getRight() - this.L) - this.J;
            int top = childAt.getTop() + this.K;
            int i6 = this.J;
            this.n.set(right3, top, right3 + i6, top + i6);
            canvas.drawOval(this.n, this.m);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            int i = savedState.currentPosition;
            this.h = i;
            this.j = i;
            requestLayout();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.currentPosition = this.h;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public final void q(int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i, view2) == null) {
            view2.setFocusable(true);
            view2.setOnClickListener(new b(this, i));
            if (view2 instanceof FrsTabItemCustomeView) {
                this.e.addView(view2, i);
            } else if (i == 0 && (view2 instanceof LinearLayout) && UbsABTestHelper.isConcernForumCardShow()) {
                this.e.addView(view2, i, this.a);
            } else {
                this.e.addView(view2, i, this.r ? this.b : this.a);
            }
        }
    }

    public final void r(int i, String str) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
            tw4 a2 = tw4.a(str);
            if (a2 != null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds47);
                FrsTabItemCustomeView frsTabItemCustomeView = new FrsTabItemCustomeView(getContext());
                frsTabItemCustomeView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0, UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0);
                frsTabItemCustomeView.setTabHeight(dimenPixelSize);
                frsTabItemCustomeView.setNeedNightShade(false);
                frsTabItemCustomeView.e(a2.g);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
                layoutParams.rightMargin = pi.f(getContext(), R.dimen.tbds5);
                layoutParams.gravity = 16;
                frsTabItemCustomeView.setLayoutParams(layoutParams);
                q(i, frsTabItemCustomeView);
            } else if (UbsABTestHelper.isConcernForumCardShow() && i == 0 && (getResources().getString(R.string.obfuscated_res_0x7f0f1364).equals(str) || getResources().getString(R.string.obfuscated_res_0x7f0f02b0).equals(str))) {
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(0);
                TextView textView = new TextView(getContext());
                if (TbadkCoreApplication.isLogin() && ht4.k().l("key_home_concern_all_status", 0) == 1) {
                    string = getResources().getString(R.string.obfuscated_res_0x7f0f02b0);
                } else {
                    string = getResources().getString(R.string.obfuscated_res_0x7f0f1364);
                }
                textView.setText(string);
                textView.setGravity(17);
                textView.setTextSize(0, this.E);
                textView.setSingleLine();
                textView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0, UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0);
                ImageView imageView = new ImageView(getContext());
                imageView.setVisibility(4);
                imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08091b, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
                linearLayout.addView(textView);
                linearLayout.addView(imageView);
                ((LinearLayout.LayoutParams) imageView.getLayoutParams()).leftMargin = this.S;
                linearLayout.setGravity(16);
                q(i, linearLayout);
            } else {
                EMTextView eMTextView = new EMTextView(getContext());
                if (i == 0) {
                    if (UbsABTestHelper.isConcernForumCardShow() && TbadkCoreApplication.isLogin() && ht4.k().l("key_home_concern_all_status", 0) == 1) {
                        str = getResources().getString(R.string.obfuscated_res_0x7f0f02b0);
                    } else {
                        str = getResources().getString(R.string.obfuscated_res_0x7f0f1364);
                    }
                }
                eMTextView.setTextSize(0, this.E);
                eMTextView.setSingleLine();
                eMTextView.setPadding(UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0, UtilHelper.getDimenPixelSize(R.dimen.tbds26), 0);
                eMTextView.setGravity(17);
                eMTextView.setText(str);
                q(i, eMTextView);
            }
        }
    }

    public final float s(float f) {
        InterceptResult invokeF;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f)) == null) {
            if (f <= 0.1f) {
                f2 = this.H;
                f3 = (this.I - f2) / 0.1f;
            } else {
                f2 = this.I;
                f3 = (f2 - 1.0f) / (-0.9f);
                f -= 0.1f;
            }
            return f2 + (f3 * f);
        }
        return invokeF.floatValue;
    }

    public void setConcernTabIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, layoutParams) == null) {
            this.b = layoutParams;
        }
    }

    public void setHotTopicIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.q = i;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onPageChangeListener) == null) {
            this.d = onPageChangeListener;
        }
    }

    public void setOnTabItemClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.T = cVar;
        }
    }

    public void setShowConcernRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.o = z;
            invalidate();
        }
    }

    public void setShowHotTopicRedTip(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.p = z;
            invalidate();
        }
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.O = z;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, viewPager) == null) {
            this.f = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.c);
            B();
        }
    }

    public final float t(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f2 <= f) {
                return ((double) f3) >= 0.5d ? f - (((f - f2) * (1.0f - f3)) / 0.5f) : f2;
            }
            double d2 = f3;
            if (d2 <= 0.5d) {
                return f;
            }
            if (d2 <= 0.8d) {
                return f + ((((f2 + this.B) - f) * (f3 - 0.5f)) / 0.3f);
            }
            int i = this.B;
            return (f2 + i) - ((i * (f3 - 0.8f)) / 0.2f);
        }
        return invokeCommon.floatValue;
    }

    public final float u(float f, View view2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Float.valueOf(f), view2})) == null) ? (f - ((((TextView) ((LinearLayout) view2).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.obfuscated_res_0x7f0f1364)) + (UtilHelper.getDimenPixelSize(R.dimen.tbds26) * 2)) / 2.0f)) + this.A : invokeCommon.floatValue;
    }

    public final float v(float f, View view2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Float.valueOf(f), view2})) == null) ? (f + ((((TextView) ((LinearLayout) view2).getChildAt(0)).getPaint().measureText(getResources().getString(R.string.obfuscated_res_0x7f0f1364)) + (UtilHelper.getDimenPixelSize(R.dimen.tbds26) * 2)) / 2.0f)) - this.A : invokeCommon.floatValue;
    }

    public final float w(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f2 > f) {
                return ((double) f3) <= 0.5d ? f + (((f2 - f) * f3) / 0.5f) : f2;
            }
            double d2 = f3;
            if (d2 >= 0.5d) {
                return f;
            }
            if (d2 >= 0.2d) {
                return f - ((((this.B + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            int i = this.B;
            return (f2 - i) + ((i * (0.2f - f3)) / 0.2f);
        }
        return invokeCommon.floatValue;
    }

    public final float x(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048601, this, f)) == null) {
            if (f <= 0.1f) {
                return 1.0f;
            }
            if (f <= 0.9f) {
                return (((1.0f - this.I) / (-0.79999995f)) * (f - 0.1f)) + 1.0f;
            }
            float f2 = this.I;
            return f2 + (((f2 - this.H) / (-0.100000024f)) * (f - 0.9f));
        }
        return invokeF.floatValue;
    }

    public View y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i)) == null) ? this.e.getChildAt(i) : (View) invokeI.objValue;
    }

    public void z(int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            setFillViewport(true);
            setWillNotDraw(false);
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.e = linearLayout;
            linearLayout.setOrientation(0);
            this.e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(this.e);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.x = (int) TypedValue.applyDimension(1, this.x, displayMetrics);
            this.C = (int) TypedValue.applyDimension(1, this.C, displayMetrics);
            this.D = (int) TypedValue.applyDimension(1, this.D, displayMetrics);
            this.E = i;
            this.F = i2;
            int f = pi.f(getContext(), R.dimen.tbds46);
            this.G = f;
            int i4 = this.E;
            this.H = (this.F * 1.0f) / i4;
            this.I = (f * 1.0f) / i4;
            this.S = -pi.f(getContext(), R.dimen.tbds11);
            this.y = i3;
            this.r = z;
            Paint paint = new Paint();
            this.l = paint;
            paint.setAntiAlias(true);
            this.l.setStyle(Paint.Style.FILL);
            this.l.setColor(SkinManager.getColor(R.color.CAM_X0302));
            Paint paint2 = new Paint();
            this.m = paint2;
            paint2.setAntiAlias(true);
            this.m.setStyle(Paint.Style.FILL);
            this.m.setColor(SkinManager.getColor(R.color.CAM_X0301));
            setLayerType(1, null);
            this.n = new RectF();
            this.J = pi.f(getContext(), R.dimen.tbds20);
            this.K = (int) (pi.f(getContext(), R.dimen.tbds28) * 0.5d);
            this.L = (int) (pi.f(getContext(), R.dimen.tbds22) * 0.4d);
            this.a = new LinearLayout.LayoutParams(-2, -1);
            this.b = new LinearLayout.LayoutParams(pi.f(getContext(), R.dimen.tbds165), -1);
            this.A = UtilHelper.getDimenPixelSize(R.dimen.tbds26) + Math.round(i * 0.5f);
            this.z = pi.f(getContext(), R.dimen.tbds5);
            this.B = pi.f(getContext(), R.dimen.tbds8);
            if (this.Q == null) {
                this.Q = getResources().getConfiguration().locale;
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
        this.c = new d(this, null);
        this.h = 0;
        this.i = 0.0f;
        this.j = 0;
        this.k = 0;
        this.p = false;
        this.q = -1;
        this.r = false;
        this.s = R.color.CAM_X0105;
        this.t = R.color.CAM_X0105;
        this.u = R.color.CAM_X0302;
        this.v = SkinManager.getColor(R.color.CAM_X0105);
        this.w = SkinManager.getColor(this.t);
        this.x = 52;
        this.y = 4;
        this.C = 12;
        this.D = 1;
        this.E = 17;
        this.F = 17;
        this.M = 0;
        this.N = R.drawable.obfuscated_res_0x7f080e7c;
        this.O = false;
        this.P = false;
        this.U = context;
    }
}

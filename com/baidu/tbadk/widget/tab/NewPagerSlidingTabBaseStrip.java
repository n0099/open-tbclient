package com.baidu.tbadk.widget.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes12.dex */
public class NewPagerSlidingTabBaseStrip extends HorizontalScrollView {
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
    public boolean K;
    public int L;
    public int M;
    public int N;
    public float O;
    public float P;
    public LinearLayout Q;
    public TextView R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int a0;
    public boolean b0;
    public boolean c0;
    public Locale d0;
    public ViewPager.OnPageChangeListener delegatePageListener;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout.LayoutParams f41764e;
    public RectF e0;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout.LayoutParams f41765f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public int[] f41766g;
    public c g0;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f41767h;

    /* renamed from: i  reason: collision with root package name */
    public final d f41768i;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f41769j;
    public ViewPager k;
    public int l;
    public int m;
    public int n;
    public float o;
    public int p;
    public int q;
    public Paint r;
    public Paint s;
    public RectF t;
    public boolean u;
    public boolean v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes12.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentPosition;

        /* loaded from: classes12.dex */
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1697402824, "Lcom/baidu/tbadk/widget/tab/NewPagerSlidingTabBaseStrip$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1697402824, "Lcom/baidu/tbadk/widget/tab/NewPagerSlidingTabBaseStrip$SavedState;");
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

    /* loaded from: classes12.dex */
    public class TabTextView extends TextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41770e;

        /* renamed from: f  reason: collision with root package name */
        public Paint f41771f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ NewPagerSlidingTabBaseStrip f41772g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabTextView(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41772g = newPagerSlidingTabBaseStrip;
            this.f41770e = false;
            Paint paint = new Paint();
            this.f41771f = paint;
            paint.setColor(-16776961);
            this.f41771f.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f41771f.setStrokeWidth(20.0f);
            this.f41771f.setAntiAlias(true);
            this.f41771f.setDither(true);
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                super.onDraw(canvas);
                if (this.f41770e) {
                    int width = (getWidth() - this.f41772g.V) - this.f41772g.T;
                    int i2 = this.f41772g.U;
                    this.f41772g.t.set(width, i2, width + this.f41772g.T, i2 + this.f41772g.T);
                    canvas.drawOval(this.f41772g.t, this.f41772g.s);
                }
            }
        }

        public void setHasRedDot(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.f41770e = z;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewPagerSlidingTabBaseStrip f41773e;

        public a(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41773e = newPagerSlidingTabBaseStrip;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41773e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f41773e;
                newPagerSlidingTabBaseStrip.n = newPagerSlidingTabBaseStrip.k.getCurrentItem();
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip2 = this.f41773e;
                newPagerSlidingTabBaseStrip2.p = newPagerSlidingTabBaseStrip2.n;
                this.f41773e.C();
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip3 = this.f41773e;
                newPagerSlidingTabBaseStrip3.B(newPagerSlidingTabBaseStrip3.n, 0);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f41774e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewPagerSlidingTabBaseStrip f41775f;

        public b(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41775f = newPagerSlidingTabBaseStrip;
            this.f41774e = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f41775f.c0) {
                return;
            }
            if (this.f41775f.g0 != null) {
                this.f41775f.g0.a(view, this.f41774e);
            }
            if (this.f41775f.k.getCurrentItem() != this.f41774e) {
                this.f41775f.b0 = true;
                this.f41775f.k.setCurrentItem(this.f41774e);
                this.f41775f.C();
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface c {
        void a(View view, int i2);
    }

    /* loaded from: classes12.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewPagerSlidingTabBaseStrip f41776e;

        public d(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41776e = newPagerSlidingTabBaseStrip;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f41776e.f41769j.getChildCount() == 0) {
                return;
            }
            if (i2 == 0) {
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f41776e;
                newPagerSlidingTabBaseStrip.B(newPagerSlidingTabBaseStrip.k.getCurrentItem(), 0);
                this.f41776e.o = 0.0f;
                this.f41776e.b0 = false;
                this.f41776e.c0 = false;
            } else if (i2 == 1) {
                this.f41776e.c0 = true;
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip2 = this.f41776e;
                newPagerSlidingTabBaseStrip2.q = newPagerSlidingTabBaseStrip2.k.getCurrentItem();
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip3 = this.f41776e;
                newPagerSlidingTabBaseStrip3.n = newPagerSlidingTabBaseStrip3.q;
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip4 = this.f41776e;
                newPagerSlidingTabBaseStrip4.p = newPagerSlidingTabBaseStrip4.n;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.f41776e.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || this.f41776e.f41769j.getChildCount() == 0) {
                return;
            }
            if (!this.f41776e.b0) {
                if (i2 == this.f41776e.q) {
                    this.f41776e.n = i2;
                    this.f41776e.p = i2 + 1;
                } else if (i2 > this.f41776e.q) {
                    this.f41776e.n = i2;
                    this.f41776e.p = i2 + 1;
                } else {
                    this.f41776e.n = i2 + 1;
                    this.f41776e.p = i2;
                }
                if (f2 == 0.0f) {
                    this.f41776e.q = i2;
                    this.f41776e.n = i2;
                    this.f41776e.p = i2;
                }
                this.f41776e.o = f2;
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f41776e;
                newPagerSlidingTabBaseStrip.B(i2, (int) (newPagerSlidingTabBaseStrip.f41769j.getChildAt(i2).getWidth() * f2));
                this.f41776e.C();
                this.f41776e.invalidate();
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.f41776e.delegatePageListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.f41776e.delegatePageListener;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i2);
                }
                if (this.f41776e.b0) {
                    NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.f41776e;
                    newPagerSlidingTabBaseStrip.B(i2, (int) (newPagerSlidingTabBaseStrip.o * this.f41776e.f41769j.getChildAt(i2).getWidth()));
                    this.f41776e.q = i2;
                    this.f41776e.n = i2;
                    this.f41776e.p = i2;
                }
                if (this.f41776e.f41769j.getChildAt(i2) instanceof TabTextView) {
                    ((TabTextView) this.f41776e.f41769j.getChildAt(i2)).setHasRedDot(false);
                    this.f41776e.f41769j.getChildAt(i2).invalidate();
                }
                this.f41776e.invalidate();
            }
        }

        public /* synthetic */ d(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip, a aVar) {
            this(newPagerSlidingTabBaseStrip);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewPagerSlidingTabBaseStrip(Context context) {
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

    public final float A(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
            if (f2 <= 0.1f) {
                return 1.0f;
            }
            if (f2 <= 0.9f) {
                return (((1.0f - this.P) / (-0.79999995f)) * (f2 - 0.1f)) + 1.0f;
            }
            float f3 = this.P;
            return f3 + (((f3 - this.O) / (-0.100000024f)) * (f2 - 0.9f));
        }
        return invokeF.floatValue;
    }

    public final void B(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) || this.l == 0) {
            return;
        }
        int left = this.f41769j.getChildAt(i2).getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
            left -= this.B;
        }
        if (left != this.W) {
            this.W = left;
            scrollTo(left, 0);
        }
    }

    public final void C() {
        float A;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            float f2 = this.o;
            if (this.p < this.n) {
                f2 = 1.0f - f2;
            }
            int i2 = 0;
            while (i2 < this.l) {
                View childAt = this.f41769j.getChildAt(i2);
                if (childAt != null) {
                    childAt.setBackgroundResource(this.a0);
                    if (childAt instanceof TextView) {
                        TextView textView = (TextView) childAt;
                        if (i2 == this.n) {
                            A = x(f2);
                        } else {
                            A = i2 == this.p ? A(f2) : 1.0f;
                        }
                        textView.setScaleX(A);
                        textView.setScaleY(A);
                        int i3 = (f2 > 0.5f ? 1 : (f2 == 0.5f ? 0 : -1));
                        if (i3 >= 0) {
                            if (i2 == this.p) {
                                textView.setTextColor(this.z);
                            } else {
                                textView.setTextColor(this.A);
                            }
                        } else if (i2 == this.n) {
                            textView.setTextColor(this.z);
                        } else {
                            textView.setTextColor(this.A);
                        }
                        if (i3 >= 0) {
                            if (i2 == this.p) {
                                textView.setTypeface(Typeface.defaultFromStyle(1));
                            } else {
                                textView.setTypeface(Typeface.defaultFromStyle(0));
                            }
                        } else if (i2 == this.n) {
                            textView.setTypeface(Typeface.defaultFromStyle(1));
                        } else {
                            textView.setTypeface(Typeface.defaultFromStyle(0));
                        }
                    }
                }
                i2++;
            }
        }
    }

    public View getTabView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.f41769j.getChildAt(i2) : (View) invokeI.objValue;
    }

    public void init(int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            setFillViewport(true);
            setWillNotDraw(false);
            if (this.v) {
                LinearLayout linearLayout = new LinearLayout(getContext());
                this.Q = linearLayout;
                linearLayout.setOrientation(0);
                FrameLayout.LayoutParams layoutParams = this.f41767h;
                if (layoutParams == null) {
                    this.Q.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                } else {
                    this.Q.setLayoutParams(layoutParams);
                }
                addView(this.Q);
            }
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.f41769j = linearLayout2;
            linearLayout2.setOrientation(0);
            if (this.v) {
                this.f41769j.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
                this.Q.addView(this.f41769j);
            } else {
                this.f41769j.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                addView(this.f41769j);
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.B = (int) TypedValue.applyDimension(1, this.B, displayMetrics);
            this.I = (int) TypedValue.applyDimension(1, this.I, displayMetrics);
            this.J = (int) TypedValue.applyDimension(1, this.J, displayMetrics);
            this.L = i2;
            this.M = i3;
            int f2 = n.f(getContext(), R.dimen.tbds74);
            this.N = f2;
            int i5 = this.L;
            this.O = (this.M * 1.0f) / i5;
            this.P = (f2 * 1.0f) / i5;
            this.C = i4;
            this.u = z;
            Paint paint = new Paint();
            this.r = paint;
            paint.setAntiAlias(true);
            this.r.setStyle(Paint.Style.FILL);
            this.r.setColor(SkinManager.getColor(this.w));
            Paint paint2 = new Paint();
            this.s = paint2;
            paint2.setAntiAlias(true);
            this.s.setStyle(Paint.Style.FILL);
            this.s.setColor(SkinManager.getColor(R.color.CAM_X0301));
            this.t = new RectF();
            this.T = n.f(getContext(), R.dimen.tbds20);
            this.U = n.f(getContext(), R.dimen.tbds16);
            this.V = n.f(getContext(), R.dimen.tbds25);
            this.f41764e = new LinearLayout.LayoutParams(-2, -1);
            this.f41765f = new LinearLayout.LayoutParams(n.f(getContext(), R.dimen.tbds200), -1);
            this.E = n.f(getContext(), R.dimen.tbds22);
            this.D = n.f(getContext(), R.dimen.tbds20);
            this.G = n.f(getContext(), R.dimen.tbds15);
            if (this.d0 == null) {
                this.d0 = getResources().getConfiguration().locale;
            }
            if (!this.v || this.Q == null) {
                return;
            }
            this.S = n.f(getContext(), R.dimen.tbds32);
            TextView textView = new TextView(getContext());
            this.R = textView;
            textView.setGravity(17);
            this.R.setTextSize(0, this.S);
            this.R.setSingleLine();
            this.R.setTextColor(this.A);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
            layoutParams2.leftMargin = n.f(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
            layoutParams2.gravity = 16;
            this.Q.addView(this.R, layoutParams2);
        }
    }

    public boolean isTabItemClicked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.b0 : invokeV.booleanValue;
    }

    public void notifyDataSetChanged() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (viewPager = this.k) == null || viewPager.getAdapter() == null || this.k.getAdapter().getCount() == 0) {
            return;
        }
        this.f41769j.removeAllViews();
        this.l = this.k.getAdapter().getCount();
        boolean z = false;
        for (int i2 = 0; i2 < this.l; i2++) {
            if (this.k.getAdapter() instanceof c.a.t0.f1.o.a) {
                z = ((c.a.t0.f1.o.a) this.k.getAdapter()).showRedDot(i2);
            }
            w(i2, this.k.getAdapter().getPageTitle(i2).toString(), z);
        }
        C();
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void notifyTailData(String str) {
        ViewPager viewPager;
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || (viewPager = this.k) == null || viewPager.getAdapter() == null || this.k.getAdapter().getCount() == 0 || !this.v || (textView = this.R) == null) {
            return;
        }
        textView.setText(str);
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.m == TbadkCoreApplication.getInst().getSkinType()) {
            return;
        }
        this.m = TbadkCoreApplication.getInst().getSkinType();
        this.z = SkinManager.getColor(this.x);
        this.A = SkinManager.getColor(this.y);
        this.r.setColor(SkinManager.getColor(this.w));
        this.s.setColor(SkinManager.getColor(R.color.CAM_X0301));
        C();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            super.onDraw(canvas);
            if (isInEditMode() || this.l == 0) {
                return;
            }
            View childAt = this.f41769j.getChildAt(this.n);
            float f5 = 0.0f;
            if (childAt == null) {
                f2 = 0.0f;
                f3 = 0.0f;
            } else if (this.K && this.F > 0) {
                f3 = ((childAt.getLeft() + childAt.getRight()) - this.F) / 2;
                f2 = ((childAt.getLeft() + childAt.getRight()) + this.F) / 2;
            } else {
                f3 = childAt.getLeft() + this.E;
                f2 = childAt.getRight() - this.E;
            }
            if (this.o > 0.0f) {
                int i2 = this.n;
                int i3 = this.p;
                if (i2 != i3 && i3 <= this.l - 1 && i3 >= 0) {
                    View childAt2 = this.f41769j.getChildAt(i3);
                    if (childAt2 == null) {
                        f4 = 0.0f;
                    } else if (this.K && this.F > 0) {
                        f5 = ((childAt2.getLeft() + childAt2.getRight()) - this.F) / 2;
                        f4 = ((childAt2.getLeft() + childAt2.getRight()) + this.F) / 2;
                    } else {
                        f5 = childAt2.getLeft() + this.E;
                        f4 = childAt2.getRight() - this.E;
                    }
                    f3 = y(f3, f5, this.o);
                    f2 = z(f2, f4, this.o);
                }
            }
            int height = getHeight();
            RectF rectF = this.e0;
            if (rectF == null) {
                this.e0 = new RectF(f3 + getPaddingLeft(), (height - this.C) - this.D, f2 + getPaddingLeft(), height - this.D);
            } else {
                rectF.set(f3 + getPaddingLeft(), (height - this.C) - this.D, f2 + getPaddingLeft(), height - this.D);
            }
            RectF rectF2 = this.e0;
            int i4 = this.H;
            canvas.drawRoundRect(rectF2, i4, i4, this.r);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            int i2 = savedState.currentPosition;
            this.n = i2;
            this.p = i2;
            requestLayout();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.currentPosition = this.n;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void setConcernTabIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
        }
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, layoutParams) == null) {
            this.f41767h = layoutParams;
        }
    }

    public void setDefaultSelectorColorResourceId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.x = i2;
        }
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, layoutParams) == null) {
            this.f41764e = layoutParams;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, layoutParams) == null) {
            this.f41765f = layoutParams;
        }
    }

    public void setIndicatorMarginBottom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.D = i2;
        }
    }

    public void setIndicatorOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.E = i2;
            this.K = false;
        }
    }

    public void setIndicatorOvershot(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.G = i2;
        }
    }

    public void setIndicatorRadius(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.H = i2;
        }
    }

    public void setNormalSelectorColorResId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.y = i2;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onPageChangeListener) == null) {
            this.delegatePageListener = onPageChangeListener;
        }
    }

    public void setOnTabItemClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            this.g0 = cVar;
        }
    }

    public void setRectPaintColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.w = i2;
        }
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.b0 = z;
        }
    }

    public void setTabPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048604, this, i2, i3, i4, i5) == null) {
            this.f41766g = r0;
            int[] iArr = {i2, i3, i4, i5};
        }
    }

    public void setTextViewShadowStringArrayId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.f0 = i2;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, viewPager) == null) {
            this.k = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.f41768i);
            notifyDataSetChanged();
        }
    }

    public void setWhiteStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            if (!z) {
                this.x = R.color.CAM_X0105;
                this.y = R.color.CAM_X0107;
            } else {
                int i2 = R.color.CAM_X0101;
                this.x = i2;
                this.y = i2;
            }
            this.z = SkinManager.getColor(this.x);
            this.A = SkinManager.getColor(this.y);
            C();
            invalidate();
        }
    }

    public void setmIndicatorWidth(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.F = i2;
            this.K = true;
        }
    }

    public final void v(int i2, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048609, this, i2, view) == null) {
            view.setFocusable(true);
            view.setOnClickListener(new b(this, i2));
            int[] iArr = this.f41766g;
            if (iArr != null && iArr.length == 4) {
                view.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
            }
            this.f41769j.addView(view, i2, this.u ? this.f41765f : this.f41764e);
        }
    }

    public final void w(int i2, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), str, Boolean.valueOf(z)}) == null) {
            TabTextView tabTextView = new TabTextView(this, getContext());
            tabTextView.setHasRedDot(z);
            tabTextView.setText(str);
            if (this.f0 != 0) {
                c.a.t0.s.v.c.d(tabTextView).y(this.f0);
            }
            tabTextView.setGravity(17);
            tabTextView.setTextSize(0, this.L);
            tabTextView.setMaxLines(1);
            v(i2, tabTextView);
        }
    }

    public final float x(float f2) {
        InterceptResult invokeF;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048611, this, f2)) == null) {
            if (f2 <= 0.1f) {
                f3 = this.O;
                f4 = (this.P - f3) / 0.1f;
            } else {
                f3 = this.P;
                f4 = (f3 - 1.0f) / (-0.9f);
                f2 -= 0.1f;
            }
            return f3 + (f4 * f2);
        }
        return invokeF.floatValue;
    }

    public final float y(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f3 <= f2) {
                return ((double) f4) >= 0.5d ? f2 - (((f2 - f3) * (1.0f - f4)) / 0.5f) : f3;
            }
            double d2 = f4;
            if (d2 <= 0.5d) {
                return f2;
            }
            if (d2 <= 0.8d) {
                return f2 + ((((f3 + this.G) - f2) * (f4 - 0.5f)) / 0.3f);
            }
            int i2 = this.G;
            return (f3 + i2) - ((i2 * (f4 - 0.8f)) / 0.2f);
        }
        return invokeCommon.floatValue;
    }

    public final float z(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f3 > f2) {
                return ((double) f4) <= 0.5d ? f2 + (((f3 - f2) * f4) / 0.5f) : f3;
            }
            double d2 = f4;
            if (d2 >= 0.5d) {
                return f2;
            }
            if (d2 >= 0.2d) {
                return f2 - ((((this.G + f2) - f3) * (0.5f - f4)) / 0.3f);
            }
            int i2 = this.G;
            return (f3 - i2) + ((i2 * (0.2f - f4)) / 0.2f);
        }
        return invokeCommon.floatValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet) {
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
    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i2) {
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
        this.f41768i = new d(this, null);
        this.m = 3;
        this.n = 0;
        this.o = 0.0f;
        this.p = 0;
        this.q = 0;
        this.u = false;
        this.v = false;
        this.w = R.color.CAM_X0312;
        int i5 = R.color.CAM_X0105;
        this.x = i5;
        this.y = R.color.CAM_X0107;
        this.z = SkinManager.getColor(i5);
        this.A = SkinManager.getColor(this.y);
        this.B = 52;
        this.C = 4;
        this.H = 16;
        this.I = 12;
        this.J = 1;
        this.K = false;
        this.L = 17;
        this.M = 17;
        this.W = 0;
        this.a0 = R.drawable.pager_sliding_view;
        this.b0 = false;
        this.c0 = false;
        this.f0 = 0;
    }

    public void init(int i2, int i3, int i4, int i5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)}) == null) {
            init(i2, i3, i4, z);
            this.N = i5;
            this.P = (i5 * 1.0f) / this.L;
        }
    }

    public void init(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.v = z2;
            init(i2, i3, i4, i5, z);
        }
    }
}

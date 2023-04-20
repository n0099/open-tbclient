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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.hv5;
import com.baidu.tieba.ii;
import com.baidu.tieba.r25;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes3.dex */
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
    public boolean H;
    public int I;
    public int J;
    public int K;
    public float L;
    public float M;
    public LinearLayout N;
    public TextView O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    public boolean W;
    public LinearLayout.LayoutParams a;
    public Locale a0;
    public LinearLayout.LayoutParams b;
    public RectF b0;
    public int[] c;
    public int c0;
    public FrameLayout.LayoutParams d;
    public c d0;
    public final d e;
    public ViewPager.OnPageChangeListener f;
    public LinearLayout g;
    public ViewPager h;
    public int i;
    public int j;
    public int k;
    public float l;
    public int m;
    public int n;
    public Paint o;
    public Paint p;
    public RectF q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes3.dex */
    public interface c {
        void a(View view2, int i);
    }

    public void setConcernTabIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
        }
    }

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
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                    return new SavedState(parcel, null);
                }
                return (SavedState) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                    return new SavedState[i];
                }
                return (SavedState[]) invokeI.objValue;
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
    }

    /* loaded from: classes3.dex */
    public class TabTextView extends TextView {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public Paint b;
        public final /* synthetic */ NewPagerSlidingTabBaseStrip c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabTextView(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = newPagerSlidingTabBaseStrip;
            this.a = false;
            Paint paint = new Paint();
            this.b = paint;
            paint.setColor(-16776961);
            this.b.setStyle(Paint.Style.FILL_AND_STROKE);
            this.b.setStrokeWidth(20.0f);
            this.b.setAntiAlias(true);
            this.b.setDither(true);
        }

        @Override // android.widget.TextView, android.view.View
        public void onDraw(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
                super.onDraw(canvas);
                if (this.a) {
                    int width = (getWidth() - this.c.S) - this.c.Q;
                    int i = this.c.R;
                    this.c.q.set(width, i, width + this.c.Q, i + this.c.Q);
                    canvas.drawOval(this.c.q, this.c.p);
                }
            }
        }

        public void setHasRedDot(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a = z;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewPagerSlidingTabBaseStrip a;

        public a(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newPagerSlidingTabBaseStrip;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.a;
                newPagerSlidingTabBaseStrip.k = newPagerSlidingTabBaseStrip.h.getCurrentItem();
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip2 = this.a;
                newPagerSlidingTabBaseStrip2.m = newPagerSlidingTabBaseStrip2.k;
                this.a.G();
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip3 = this.a;
                newPagerSlidingTabBaseStrip3.F(newPagerSlidingTabBaseStrip3.k, 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ NewPagerSlidingTabBaseStrip b;

        public b(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = newPagerSlidingTabBaseStrip;
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.W) {
                return;
            }
            if (this.b.d0 != null) {
                this.b.d0.a(view2, this.a);
            }
            if (this.b.h.getCurrentItem() == this.a) {
                return;
            }
            this.b.V = true;
            this.b.h.setCurrentItem(this.a);
            this.b.G();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewPagerSlidingTabBaseStrip a;

        public d(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newPagerSlidingTabBaseStrip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newPagerSlidingTabBaseStrip;
        }

        public /* synthetic */ d(NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip, a aVar) {
            this(newPagerSlidingTabBaseStrip);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048576, this, i) != null) || this.a.g.getChildCount() == 0) {
                return;
            }
            if (i == 0) {
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.a;
                newPagerSlidingTabBaseStrip.F(newPagerSlidingTabBaseStrip.h.getCurrentItem(), 0);
                this.a.l = 0.0f;
                this.a.V = false;
                this.a.W = false;
            } else if (i == 1) {
                this.a.W = true;
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip2 = this.a;
                newPagerSlidingTabBaseStrip2.n = newPagerSlidingTabBaseStrip2.h.getCurrentItem();
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip3 = this.a;
                newPagerSlidingTabBaseStrip3.k = newPagerSlidingTabBaseStrip3.n;
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip4 = this.a;
                newPagerSlidingTabBaseStrip4.m = newPagerSlidingTabBaseStrip4.k;
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.a.f;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                ViewPager.OnPageChangeListener onPageChangeListener = this.a.f;
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i);
                }
                if (this.a.V) {
                    NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.a;
                    newPagerSlidingTabBaseStrip.F(i, (int) (newPagerSlidingTabBaseStrip.l * this.a.g.getChildAt(i).getWidth()));
                    this.a.n = i;
                    this.a.k = i;
                    this.a.m = i;
                }
                if (this.a.g.getChildAt(i) instanceof TabTextView) {
                    ((TabTextView) this.a.g.getChildAt(i)).setHasRedDot(false);
                    this.a.g.getChildAt(i).invalidate();
                }
                this.a.invalidate();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) != null) || this.a.g.getChildCount() == 0) {
                return;
            }
            if (!this.a.V) {
                if (i != this.a.n) {
                    if (i > this.a.n) {
                        this.a.k = i;
                        this.a.m = i + 1;
                    } else {
                        this.a.k = i + 1;
                        this.a.m = i;
                    }
                } else {
                    this.a.k = i;
                    this.a.m = i + 1;
                }
                if (f == 0.0f) {
                    this.a.n = i;
                    this.a.k = i;
                    this.a.m = i;
                }
                this.a.l = f;
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.a;
                newPagerSlidingTabBaseStrip.F(i, (int) (newPagerSlidingTabBaseStrip.g.getChildAt(i).getWidth() * f));
                this.a.G();
                this.a.invalidate();
            }
            ViewPager.OnPageChangeListener onPageChangeListener = this.a.f;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f, i2);
            }
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

    public final float A(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            if (f <= 0.1f) {
                return 1.0f;
            }
            if (f <= 0.9f) {
                return (((1.0f - this.M) / (-0.79999995f)) * (f - 0.1f)) + 1.0f;
            }
            float f2 = this.M;
            return f2 + (((f2 - this.L) / (-0.100000024f)) * (f - 0.9f));
        }
        return invokeF.floatValue;
    }

    public void setWhiteStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            if (!z) {
                this.u = R.color.CAM_X0105;
                this.v = R.color.CAM_X0107;
            } else {
                this.u = R.color.CAM_X0101;
                this.v = R.color.CAM_X0101;
            }
            this.w = SkinManager.getColor(this.u);
            this.x = SkinManager.getColor(this.v);
            G();
            invalidate();
        }
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
    public NewPagerSlidingTabBaseStrip(Context context, AttributeSet attributeSet, int i) {
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
        this.e = new d(this, null);
        this.j = 3;
        this.k = 0;
        this.l = 0.0f;
        this.m = 0;
        this.n = 0;
        this.r = false;
        this.s = false;
        this.t = R.color.CAM_X0312;
        this.u = R.color.CAM_X0105;
        this.v = R.color.CAM_X0107;
        this.w = SkinManager.getColor(R.color.CAM_X0105);
        this.x = SkinManager.getColor(this.v);
        this.y = 52;
        this.z = 4;
        this.E = 16;
        this.F = 12;
        this.G = 1;
        this.H = false;
        this.I = 17;
        this.J = 17;
        this.T = 0;
        this.U = R.drawable.pager_sliding_view;
        this.V = false;
        this.W = false;
        this.c0 = 0;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            int i = savedState.currentPosition;
            this.k = i;
            this.m = i;
            requestLayout();
        }
    }

    public void setContainerLayoutParams(FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, layoutParams) == null) {
            this.d = layoutParams;
        }
    }

    public void setDefaultSelectorColorResourceId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.u = i;
        }
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, layoutParams) == null) {
            this.a = layoutParams;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, layoutParams) == null) {
            this.b = layoutParams;
        }
    }

    public void setIndicatorMarginBottom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.A = i;
        }
    }

    public void setIndicatorOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.B = i;
            this.H = false;
        }
    }

    public void setIndicatorOvershot(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.D = i;
        }
    }

    public void setIndicatorRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.E = i;
        }
    }

    public void setNormalSelectorColorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.v = i;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onPageChangeListener) == null) {
            this.f = onPageChangeListener;
        }
    }

    public void setOnTabItemClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) {
            this.d0 = cVar;
        }
    }

    public void setRectPaintColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.t = i;
        }
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.V = z;
        }
    }

    public void setTextViewShadowStringArrayId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.c0 = i;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, viewPager) == null) {
            this.h = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.e);
            D();
        }
    }

    public void setmIndicatorWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.C = i;
            this.H = true;
        }
    }

    public final float x(float f) {
        InterceptResult invokeF;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048607, this, f)) == null) {
            if (f <= 0.1f) {
                f2 = this.L;
                f3 = (this.M - f2) / 0.1f;
            } else {
                f2 = this.M;
                f3 = (f2 - 1.0f) / (-0.9f);
                f -= 0.1f;
            }
            return f2 + (f3 * f);
        }
        return invokeF.floatValue;
    }

    public final void F(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048581, this, i, i2) != null) || this.i == 0) {
            return;
        }
        int left = this.g.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.y;
        }
        if (left != this.T) {
            this.T = left;
            scrollTo(left, 0);
        }
    }

    public void B(int i, int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            C(i, i2, i3, z);
            this.K = i4;
            this.M = (i4 * 1.0f) / this.I;
        }
    }

    public void C(int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            setFillViewport(true);
            setWillNotDraw(false);
            if (this.s) {
                LinearLayout linearLayout = new LinearLayout(getContext());
                this.N = linearLayout;
                linearLayout.setOrientation(0);
                FrameLayout.LayoutParams layoutParams = this.d;
                if (layoutParams == null) {
                    this.N.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                } else {
                    this.N.setLayoutParams(layoutParams);
                }
                addView(this.N);
            }
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.g = linearLayout2;
            linearLayout2.setOrientation(0);
            if (this.s) {
                this.g.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
                this.N.addView(this.g);
            } else {
                this.g.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                addView(this.g);
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.y = (int) TypedValue.applyDimension(1, this.y, displayMetrics);
            this.F = (int) TypedValue.applyDimension(1, this.F, displayMetrics);
            this.G = (int) TypedValue.applyDimension(1, this.G, displayMetrics);
            this.I = i;
            this.J = i2;
            int g = ii.g(getContext(), R.dimen.tbds74);
            this.K = g;
            int i4 = this.I;
            this.L = (this.J * 1.0f) / i4;
            this.M = (g * 1.0f) / i4;
            this.z = i3;
            this.r = z;
            Paint paint = new Paint();
            this.o = paint;
            paint.setAntiAlias(true);
            this.o.setStyle(Paint.Style.FILL);
            this.o.setColor(SkinManager.getColor(this.t));
            Paint paint2 = new Paint();
            this.p = paint2;
            paint2.setAntiAlias(true);
            this.p.setStyle(Paint.Style.FILL);
            this.p.setColor(SkinManager.getColor(R.color.CAM_X0301));
            this.q = new RectF();
            this.Q = ii.g(getContext(), R.dimen.tbds20);
            this.R = ii.g(getContext(), R.dimen.tbds16);
            this.S = ii.g(getContext(), R.dimen.tbds25);
            this.a = new LinearLayout.LayoutParams(-2, -1);
            this.b = new LinearLayout.LayoutParams(ii.g(getContext(), R.dimen.tbds200), -1);
            this.B = ii.g(getContext(), R.dimen.tbds22);
            this.A = ii.g(getContext(), R.dimen.tbds20);
            this.D = ii.g(getContext(), R.dimen.tbds15);
            if (this.a0 == null) {
                this.a0 = getResources().getConfiguration().locale;
            }
            if (this.s && this.N != null) {
                this.P = ii.g(getContext(), R.dimen.tbds32);
                TextView textView = new TextView(getContext());
                this.O = textView;
                textView.setGravity(17);
                this.O.setTextSize(0, this.P);
                this.O.setSingleLine();
                this.O.setTextColor(this.x);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
                layoutParams2.leftMargin = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
                layoutParams2.gravity = 16;
                this.N.addView(this.O, layoutParams2);
            }
        }
    }

    public void D() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (viewPager = this.h) != null && viewPager.getAdapter() != null && this.h.getAdapter().getCount() != 0) {
            this.g.removeAllViews();
            this.i = this.h.getAdapter().getCount();
            boolean z = false;
            for (int i = 0; i < this.i; i++) {
                if (this.h.getAdapter() instanceof hv5) {
                    z = ((hv5) this.h.getAdapter()).a(i);
                }
                w(i, this.h.getAdapter().getPageTitle(i).toString(), z);
            }
            G();
            getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.j != TbadkCoreApplication.getInst().getSkinType()) {
            this.j = TbadkCoreApplication.getInst().getSkinType();
            this.w = SkinManager.getColor(this.u);
            this.x = SkinManager.getColor(this.v);
            this.o.setColor(SkinManager.getColor(this.t));
            this.p.setColor(SkinManager.getColor(R.color.CAM_X0301));
            G();
            invalidate();
        }
    }

    public final void G() {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            float f2 = this.l;
            if (this.m < this.k) {
                f2 = 1.0f - f2;
            }
            for (int i = 0; i < this.i; i++) {
                View childAt = this.g.getChildAt(i);
                if (childAt != null) {
                    childAt.setBackgroundResource(this.U);
                    if (childAt instanceof TextView) {
                        TextView textView = (TextView) childAt;
                        if (i == this.k) {
                            f = x(f2);
                        } else if (i == this.m) {
                            f = A(f2);
                        } else {
                            f = 1.0f;
                        }
                        textView.setScaleX(f);
                        textView.setScaleY(f);
                        int i2 = (f2 > 0.5f ? 1 : (f2 == 0.5f ? 0 : -1));
                        if (i2 >= 0) {
                            if (i == this.m) {
                                textView.setTextColor(this.w);
                            } else {
                                textView.setTextColor(this.x);
                            }
                        } else if (i == this.k) {
                            textView.setTextColor(this.w);
                        } else {
                            textView.setTextColor(this.x);
                        }
                        if (i2 >= 0) {
                            if (i == this.m) {
                                textView.setTypeface(Typeface.defaultFromStyle(1));
                            } else {
                                textView.setTypeface(Typeface.defaultFromStyle(0));
                            }
                        } else if (i == this.k) {
                            textView.setTypeface(Typeface.defaultFromStyle(1));
                        } else {
                            textView.setTypeface(Typeface.defaultFromStyle(0));
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.onDraw(canvas);
            if (!isInEditMode() && this.i != 0) {
                View childAt = this.g.getChildAt(this.k);
                float f4 = 0.0f;
                if (childAt != null) {
                    if (this.H && this.C > 0) {
                        f2 = ((childAt.getLeft() + childAt.getRight()) - this.C) / 2;
                        f = ((childAt.getLeft() + childAt.getRight()) + this.C) / 2;
                    } else {
                        f2 = childAt.getLeft() + this.B;
                        f = childAt.getRight() - this.B;
                    }
                } else {
                    f = 0.0f;
                    f2 = 0.0f;
                }
                if (this.l > 0.0f) {
                    int i = this.k;
                    int i2 = this.m;
                    if (i != i2 && i2 <= this.i - 1 && i2 >= 0) {
                        View childAt2 = this.g.getChildAt(i2);
                        if (childAt2 != null) {
                            if (this.H && this.C > 0) {
                                f4 = ((childAt2.getLeft() + childAt2.getRight()) - this.C) / 2;
                                f3 = ((childAt2.getLeft() + childAt2.getRight()) + this.C) / 2;
                            } else {
                                f4 = childAt2.getLeft() + this.B;
                                f3 = childAt2.getRight() - this.B;
                            }
                        } else {
                            f3 = 0.0f;
                        }
                        f2 = y(f2, f4, this.l);
                        f = z(f, f3, this.l);
                    }
                }
                int height = getHeight();
                RectF rectF = this.b0;
                if (rectF == null) {
                    this.b0 = new RectF(f2 + getPaddingLeft(), (height - this.z) - this.A, f + getPaddingLeft(), height - this.A);
                } else {
                    rectF.set(f2 + getPaddingLeft(), (height - this.z) - this.A, f + getPaddingLeft(), height - this.A);
                }
                RectF rectF2 = this.b0;
                int i3 = this.E;
                canvas.drawRoundRect(rectF2, i3, i3, this.o);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.currentPosition = this.k;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048600, this, i, i2, i3, i4) == null) {
            this.c = r0;
            int[] iArr = {i, i2, i3, i4};
        }
    }

    public final void v(int i, View view2) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048605, this, i, view2) == null) {
            view2.setFocusable(true);
            view2.setOnClickListener(new b(this, i));
            int[] iArr = this.c;
            if (iArr != null && iArr.length == 4) {
                view2.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
            }
            LinearLayout linearLayout = this.g;
            if (this.r) {
                layoutParams = this.b;
            } else {
                layoutParams = this.a;
            }
            linearLayout.addView(view2, i, layoutParams);
        }
    }

    public final void w(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            TabTextView tabTextView = new TabTextView(this, getContext());
            tabTextView.setHasRedDot(z);
            tabTextView.setText(str);
            if (this.c0 != 0) {
                r25.d(tabTextView).A(this.c0);
            }
            tabTextView.setGravity(17);
            tabTextView.setTextSize(0, this.I);
            tabTextView.setMaxLines(1);
            v(i, tabTextView);
        }
    }

    public final float y(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f2 > f) {
                double d2 = f3;
                if (d2 <= 0.5d) {
                    return f;
                }
                if (d2 <= 0.8d) {
                    return f + ((((f2 + this.D) - f) * (f3 - 0.5f)) / 0.3f);
                }
                int i = this.D;
                return (f2 + i) - ((i * (f3 - 0.8f)) / 0.2f);
            } else if (f3 >= 0.5d) {
                return f - (((f - f2) * (1.0f - f3)) / 0.5f);
            } else {
                return f2;
            }
        }
        return invokeCommon.floatValue;
    }

    public final float z(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f2 > f) {
                if (f3 <= 0.5d) {
                    return f + (((f2 - f) * f3) / 0.5f);
                }
                return f2;
            }
            double d2 = f3;
            if (d2 >= 0.5d) {
                return f;
            }
            if (d2 >= 0.2d) {
                return f - ((((this.D + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            int i = this.D;
            return (f2 - i) + ((i * (0.2f - f3)) / 0.2f);
        }
        return invokeCommon.floatValue;
    }
}

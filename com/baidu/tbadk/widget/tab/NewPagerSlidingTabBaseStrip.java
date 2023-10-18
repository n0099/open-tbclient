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
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tw5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes5.dex */
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
    public boolean I;
    public int J;
    public int K;
    public int L;
    public float M;
    public float N;
    public LinearLayout O;
    public TextView P;
    public int Q;
    public int R;
    public int S;

    /* renamed from: T  reason: collision with root package name */
    public int f1086T;
    public int U;
    public int V;
    public boolean W;
    public LinearLayout.LayoutParams a;
    public boolean a0;
    public LinearLayout.LayoutParams b;
    public Locale b0;
    public int[] c;
    public RectF c0;
    public FrameLayout.LayoutParams d;
    public int d0;
    public final d e;
    public c e0;
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
    public boolean t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view2, int i);
    }

    public void setConcernTabIndex(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public int currentPosition;

        /* loaded from: classes5.dex */
        public class a implements Parcelable.Creator<SavedState> {
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

    /* loaded from: classes5.dex */
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
            paint.setColor(BaseAnimatedElement.DEBUG_PAINT_COLOR);
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
                    int width = (getWidth() - this.c.f1086T) - this.c.R;
                    int i = this.c.S;
                    this.c.q.set(width, i, width + this.c.R, i + this.c.R);
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

    /* loaded from: classes5.dex */
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
                this.a.J();
                NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip3 = this.a;
                newPagerSlidingTabBaseStrip3.I(newPagerSlidingTabBaseStrip3.k, 0);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.a0) {
                return;
            }
            if (this.b.e0 != null) {
                this.b.e0.a(view2, this.a);
            }
            if (this.b.h.getCurrentItem() == this.a) {
                return;
            }
            this.b.W = true;
            this.b.h.setCurrentItem(this.a);
            this.b.J();
        }
    }

    /* loaded from: classes5.dex */
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
                newPagerSlidingTabBaseStrip.I(newPagerSlidingTabBaseStrip.h.getCurrentItem(), 0);
                this.a.l = 0.0f;
                this.a.W = false;
                this.a.a0 = false;
            } else if (i == 1) {
                this.a.a0 = true;
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
                if (this.a.W) {
                    NewPagerSlidingTabBaseStrip newPagerSlidingTabBaseStrip = this.a;
                    newPagerSlidingTabBaseStrip.I(i, (int) (newPagerSlidingTabBaseStrip.l * this.a.g.getChildAt(i).getWidth()));
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
            if (!this.a.W) {
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
                newPagerSlidingTabBaseStrip.I(i, (int) (newPagerSlidingTabBaseStrip.g.getChildAt(i).getWidth() * f));
                this.a.J();
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

    public final float D(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f)) == null) {
            if (f <= 0.1f) {
                return 1.0f;
            }
            if (f <= 0.9f) {
                return (((1.0f - this.N) / (-0.79999995f)) * (f - 0.1f)) + 1.0f;
            }
            float f2 = this.N;
            return f2 + (((f2 - this.M) / (-0.100000024f)) * (f - 0.9f));
        }
        return invokeF.floatValue;
    }

    public void setWhiteStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            if (!z) {
                this.v = R.color.CAM_X0105;
                this.w = R.color.CAM_X0107;
            } else {
                this.v = R.color.CAM_X0101;
                this.w = R.color.CAM_X0101;
            }
            this.x = SkinManager.getColor(this.v);
            this.y = SkinManager.getColor(this.w);
            J();
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
        this.r = true;
        this.s = false;
        this.t = false;
        this.u = R.color.CAM_X0312;
        this.v = R.color.CAM_X0105;
        this.w = R.color.CAM_X0107;
        this.x = SkinManager.getColor(R.color.CAM_X0105);
        this.y = SkinManager.getColor(this.w);
        this.z = 52;
        this.A = 4;
        this.F = 16;
        this.G = 12;
        this.H = 1;
        this.I = false;
        this.J = 17;
        this.K = 17;
        this.U = 0;
        this.V = R.drawable.pager_sliding_view;
        this.W = false;
        this.a0 = false;
        this.d0 = 0;
    }

    public final float A(float f) {
        InterceptResult invokeF;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            if (f <= 0.1f) {
                f2 = this.M;
                f3 = (this.N - f2) / 0.1f;
            } else {
                f2 = this.N;
                f3 = (f2 - 1.0f) / (-0.9f);
                f -= 0.1f;
            }
            return f2 + (f3 * f);
        }
        return invokeF.floatValue;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, parcelable) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048590, this, layoutParams) == null) {
            this.d = layoutParams;
        }
    }

    public void setDefaultSelectorColorResourceId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.v = i;
        }
    }

    public void setDefaultTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, layoutParams) == null) {
            this.a = layoutParams;
        }
    }

    public void setExpandedTabLayoutParams(LinearLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, layoutParams) == null) {
            this.b = layoutParams;
        }
    }

    public void setIndicatorMarginBottom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.B = i;
        }
    }

    public void setIndicatorOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.C = i;
            this.I = false;
        }
    }

    public void setIndicatorOvershot(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.E = i;
        }
    }

    public void setIndicatorRadius(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.F = i;
        }
    }

    public void setNormalSelectorColorResId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.w = i;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onPageChangeListener) == null) {
            this.f = onPageChangeListener;
        }
    }

    public void setOnTabItemClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) {
            this.e0 = cVar;
        }
    }

    public void setRectPaintColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.u = i;
        }
    }

    public void setTabItemClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.W = z;
        }
    }

    public void setTextViewShadowStringArrayId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.d0 = i;
        }
    }

    public void setViewPager(ViewPager viewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, viewPager) == null) {
            this.h = viewPager;
            if (viewPager.getAdapter() == null) {
                return;
            }
            viewPager.setOnPageChangeListener(this.e);
            G();
        }
    }

    public void setmIndicatorWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.D = i;
            this.I = true;
        }
    }

    public final void I(int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) != null) || this.i == 0) {
            return;
        }
        int left = this.g.getChildAt(i).getLeft() + i2;
        if (i > 0 || i2 > 0) {
            left -= this.z;
        }
        if (left != this.U) {
            this.U = left;
            scrollTo(left, 0);
        }
    }

    public final float B(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (f2 > f) {
                double d2 = f3;
                if (d2 <= 0.5d) {
                    return f;
                }
                if (d2 <= 0.8d) {
                    return f + ((((f2 + this.E) - f) * (f3 - 0.5f)) / 0.3f);
                }
                int i = this.E;
                return (f2 + i) - ((i * (f3 - 0.8f)) / 0.2f);
            } else if (f3 >= 0.5d) {
                return f - (((f - f2) * (1.0f - f3)) / 0.5f);
            } else {
                return f2;
            }
        }
        return invokeCommon.floatValue;
    }

    public final float C(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
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
                return f - ((((this.E + f) - f2) * (0.5f - f3)) / 0.3f);
            }
            int i = this.E;
            return (f2 - i) + ((i * (0.2f - f3)) / 0.2f);
        }
        return invokeCommon.floatValue;
    }

    public void E(int i, int i2, int i3, int i4, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            F(i, i2, i3, z);
            this.L = i4;
            this.N = (i4 * 1.0f) / this.J;
        }
    }

    public void F(int i, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            setFillViewport(true);
            setWillNotDraw(false);
            if (this.t) {
                LinearLayout linearLayout = new LinearLayout(getContext());
                this.O = linearLayout;
                linearLayout.setOrientation(0);
                FrameLayout.LayoutParams layoutParams = this.d;
                if (layoutParams == null) {
                    this.O.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                } else {
                    this.O.setLayoutParams(layoutParams);
                }
                addView(this.O);
            }
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            this.g = linearLayout2;
            linearLayout2.setOrientation(0);
            if (this.t) {
                this.g.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
                this.O.addView(this.g);
            } else {
                this.g.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                addView(this.g);
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.z = (int) TypedValue.applyDimension(1, this.z, displayMetrics);
            this.G = (int) TypedValue.applyDimension(1, this.G, displayMetrics);
            this.H = (int) TypedValue.applyDimension(1, this.H, displayMetrics);
            this.J = i;
            this.K = i2;
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds74);
            this.L = dimens;
            int i4 = this.J;
            this.M = (this.K * 1.0f) / i4;
            this.N = (dimens * 1.0f) / i4;
            this.A = i3;
            this.s = z;
            Paint paint = new Paint();
            this.o = paint;
            paint.setAntiAlias(true);
            this.o.setStyle(Paint.Style.FILL);
            this.o.setColor(SkinManager.getColor(this.u));
            Paint paint2 = new Paint();
            this.p = paint2;
            paint2.setAntiAlias(true);
            this.p.setStyle(Paint.Style.FILL);
            this.p.setColor(SkinManager.getColor(R.color.CAM_X0301));
            this.q = new RectF();
            this.R = BdUtilHelper.getDimens(getContext(), R.dimen.tbds20);
            this.S = BdUtilHelper.getDimens(getContext(), R.dimen.tbds16);
            this.f1086T = BdUtilHelper.getDimens(getContext(), R.dimen.tbds25);
            this.a = new LinearLayout.LayoutParams(-2, -1);
            this.b = new LinearLayout.LayoutParams(BdUtilHelper.getDimens(getContext(), R.dimen.tbds200), -1);
            this.C = BdUtilHelper.getDimens(getContext(), R.dimen.tbds22);
            this.B = BdUtilHelper.getDimens(getContext(), R.dimen.tbds20);
            this.E = BdUtilHelper.getDimens(getContext(), R.dimen.tbds15);
            if (this.b0 == null) {
                this.b0 = getResources().getConfiguration().locale;
            }
            if (this.t && this.O != null) {
                this.Q = BdUtilHelper.getDimens(getContext(), R.dimen.tbds32);
                TextView textView = new TextView(getContext());
                this.P = textView;
                textView.setGravity(17);
                this.P.setTextSize(0, this.Q);
                this.P.setSingleLine();
                this.P.setTextColor(this.y);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
                layoutParams2.leftMargin = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds_30);
                layoutParams2.gravity = 16;
                this.O.addView(this.P, layoutParams2);
            }
        }
    }

    public void G() {
        ViewPager viewPager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (viewPager = this.h) != null && viewPager.getAdapter() != null && this.h.getAdapter().getCount() != 0) {
            this.g.removeAllViews();
            this.i = this.h.getAdapter().getCount();
            boolean z = false;
            for (int i = 0; i < this.i; i++) {
                if (this.h.getAdapter() instanceof tw5) {
                    z = ((tw5) this.h.getAdapter()).a(i);
                }
                w(i, this.h.getAdapter().getPageTitle(i).toString(), z);
            }
            J();
            getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.j != TbadkCoreApplication.getInst().getSkinType()) {
            this.j = TbadkCoreApplication.getInst().getSkinType();
            this.x = SkinManager.getColor(this.v);
            this.y = SkinManager.getColor(this.w);
            this.o.setColor(SkinManager.getColor(this.u));
            this.p.setColor(SkinManager.getColor(R.color.CAM_X0301));
            J();
            invalidate();
        }
    }

    public final void J() {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            float f2 = this.l;
            if (this.m < this.k) {
                f2 = 1.0f - f2;
            }
            for (int i = 0; i < this.i; i++) {
                View childAt = this.g.getChildAt(i);
                if (childAt != null) {
                    childAt.setBackgroundResource(this.V);
                    if (childAt instanceof TextView) {
                        TextView textView = (TextView) childAt;
                        if (i == this.k) {
                            f = A(f2);
                        } else if (i == this.m) {
                            f = D(f2);
                        } else {
                            f = 1.0f;
                        }
                        textView.setScaleX(f);
                        textView.setScaleY(f);
                        int i2 = (f2 > 0.5f ? 1 : (f2 == 0.5f ? 0 : -1));
                        if (i2 >= 0) {
                            if (i == this.m) {
                                textView.setTextColor(this.x);
                            } else {
                                textView.setTextColor(this.y);
                            }
                        } else if (i == this.k) {
                            textView.setTextColor(this.x);
                        } else {
                            textView.setTextColor(this.y);
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
        if (interceptable == null || interceptable.invokeL(1048586, this, canvas) == null) {
            super.onDraw(canvas);
            if (!isInEditMode() && this.i != 0 && this.r) {
                View childAt = this.g.getChildAt(this.k);
                float f4 = 0.0f;
                if (childAt != null) {
                    if (this.I && this.D > 0) {
                        f2 = ((childAt.getLeft() + childAt.getRight()) - this.D) / 2;
                        f = ((childAt.getLeft() + childAt.getRight()) + this.D) / 2;
                    } else {
                        f2 = childAt.getLeft() + this.C;
                        f = childAt.getRight() - this.C;
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
                            if (this.I && this.D > 0) {
                                f4 = ((childAt2.getLeft() + childAt2.getRight()) - this.D) / 2;
                                f3 = ((childAt2.getLeft() + childAt2.getRight()) + this.D) / 2;
                            } else {
                                f4 = childAt2.getLeft() + this.C;
                                f3 = childAt2.getRight() - this.C;
                            }
                        } else {
                            f3 = 0.0f;
                        }
                        f2 = B(f2, f4, this.l);
                        f = C(f, f3, this.l);
                    }
                }
                int height = getHeight();
                RectF rectF = this.c0;
                if (rectF == null) {
                    this.c0 = new RectF(f2 + getPaddingLeft(), (height - this.A) - this.B, f + getPaddingLeft(), height - this.B);
                } else {
                    rectF.set(f2 + getPaddingLeft(), (height - this.A) - this.B, f + getPaddingLeft(), height - this.B);
                }
                RectF rectF2 = this.c0;
                int i3 = this.F;
                canvas.drawRoundRect(rectF2, i3, i3, this.o);
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.currentPosition = this.k;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public void setTabPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048603, this, i, i2, i3, i4) == null) {
            this.c = r0;
            int[] iArr = {i, i2, i3, i4};
        }
    }

    public final void v(int i, View view2) {
        LinearLayout.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048608, this, i, view2) == null) {
            view2.setFocusable(true);
            view2.setOnClickListener(new b(this, i));
            int[] iArr = this.c;
            if (iArr != null && iArr.length == 4) {
                view2.setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
            }
            LinearLayout linearLayout = this.g;
            if (this.s) {
                layoutParams = this.b;
            } else {
                layoutParams = this.a;
            }
            linearLayout.addView(view2, i, layoutParams);
        }
    }

    public final void w(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            TabTextView tabTextView = new TabTextView(this, getContext());
            tabTextView.setHasRedDot(z);
            tabTextView.setText(str);
            if (this.d0 != 0) {
                EMManager.from(tabTextView).setTextShadow(this.d0);
            }
            tabTextView.setGravity(17);
            tabTextView.setTextSize(0, this.J);
            tabTextView.setMaxLines(1);
            v(i, tabTextView);
        }
    }

    public final void x(View view2, int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) && i2 > 0 && i >= 0 && i < i2) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, (((i2 - 1) >> 1) * 1.0f) - i, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(300L);
            translateAnimation.setStartOffset(j);
            translateAnimation.setFillAfter(true);
            view2.startAnimation(translateAnimation);
        }
    }

    public void y(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048611, this, j) != null) || !this.r) {
            return;
        }
        this.r = false;
        invalidate();
        int childCount = this.g.getChildCount();
        int i = this.k;
        if (childCount > 0 && i >= 0 && i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.g.getChildAt(i2);
                childAt.setClickable(false);
                if (i2 < i) {
                    z(childAt, true, i2, j);
                } else if (i2 > i) {
                    z(childAt, false, (childCount - 1) - i2, j);
                } else {
                    x(childAt, i2, childCount, j);
                }
            }
        }
    }

    public final void z(View view2, boolean z, int i, long j) {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i), Long.valueOf(j)}) == null) {
            int i2 = i;
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.setDuration(300L);
            animationSet.setStartOffset(j);
            if (z) {
                f = 0.0f;
            } else {
                f = 1.0f;
            }
            animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, f, 1, 0.5f));
            if (z) {
                i2 *= -1;
            }
            animationSet.addAnimation(new TranslateAnimation(1, 0.0f, 1, i2, 1, 0.0f, 1, 0.0f));
            animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
            animationSet.setFillAfter(true);
            view2.startAnimation(animationSet);
        }
    }
}

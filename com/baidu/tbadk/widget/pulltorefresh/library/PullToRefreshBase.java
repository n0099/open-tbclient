package com.baidu.tbadk.widget.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.widget.pulltorefresh.library.internal.FlipLoadingLayout;
import com.baidu.tbadk.widget.pulltorefresh.library.internal.LoadingLayout;
import com.baidu.tbadk.widget.pulltorefresh.library.internal.RotateLoadingLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int SMOOTH_SCROLL_DURATION_MS = 200;
    public static final int SMOOTH_SCROLL_LONG_DURATION_MS = 325;
    public transient /* synthetic */ FieldHolder $fh;
    public e<T> A;
    public PullToRefreshBase<T>.i B;

    /* renamed from: e  reason: collision with root package name */
    public int f40073e;

    /* renamed from: f  reason: collision with root package name */
    public float f40074f;

    /* renamed from: g  reason: collision with root package name */
    public float f40075g;

    /* renamed from: h  reason: collision with root package name */
    public float f40076h;

    /* renamed from: i  reason: collision with root package name */
    public float f40077i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f40078j;
    public State k;
    public Mode l;
    public Mode m;
    public T n;
    public FrameLayout o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public Interpolator u;
    public AnimationStyle v;
    public LoadingLayout w;
    public LoadingLayout x;
    public g<T> y;
    public f<T> z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class AnimationStyle {
        public static final /* synthetic */ AnimationStyle[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AnimationStyle FLIP;
        public static final AnimationStyle ROTATE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(882356582, "Lcom/baidu/tbadk/widget/pulltorefresh/library/PullToRefreshBase$AnimationStyle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(882356582, "Lcom/baidu/tbadk/widget/pulltorefresh/library/PullToRefreshBase$AnimationStyle;");
                    return;
                }
            }
            ROTATE = new AnimationStyle("ROTATE", 0);
            AnimationStyle animationStyle = new AnimationStyle("FLIP", 1);
            FLIP = animationStyle;
            $VALUES = new AnimationStyle[]{ROTATE, animationStyle};
        }

        public AnimationStyle(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static AnimationStyle getDefault() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? ROTATE : (AnimationStyle) invokeV.objValue;
        }

        public static AnimationStyle mapIntToValue(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
                if (i2 != 1) {
                    return ROTATE;
                }
                return FLIP;
            }
            return (AnimationStyle) invokeI.objValue;
        }

        public static AnimationStyle valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (AnimationStyle) Enum.valueOf(AnimationStyle.class, str) : (AnimationStyle) invokeL.objValue;
        }

        public static AnimationStyle[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (AnimationStyle[]) $VALUES.clone() : (AnimationStyle[]) invokeV.objValue;
        }

        public LoadingLayout createLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, mode, orientation, typedArray)) == null) {
                if (d.f40082d[ordinal()] != 2) {
                    return new RotateLoadingLayout(context, mode, orientation, typedArray);
                }
                return new FlipLoadingLayout(context, mode, orientation, typedArray);
            }
            return (LoadingLayout) invokeLLLL.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class Mode {
        public static final /* synthetic */ Mode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Mode BOTH;
        public static final Mode DISABLED;
        public static final Mode MANUAL_REFRESH_ONLY;
        public static Mode PULL_DOWN_TO_REFRESH;
        public static final Mode PULL_FROM_END;
        public static final Mode PULL_FROM_START;
        public static Mode PULL_UP_TO_REFRESH;
        public transient /* synthetic */ FieldHolder $fh;
        public int mIntValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-747209456, "Lcom/baidu/tbadk/widget/pulltorefresh/library/PullToRefreshBase$Mode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-747209456, "Lcom/baidu/tbadk/widget/pulltorefresh/library/PullToRefreshBase$Mode;");
                    return;
                }
            }
            DISABLED = new Mode("DISABLED", 0, 0);
            PULL_FROM_START = new Mode("PULL_FROM_START", 1, 1);
            PULL_FROM_END = new Mode("PULL_FROM_END", 2, 2);
            BOTH = new Mode("BOTH", 3, 3);
            Mode mode = new Mode("MANUAL_REFRESH_ONLY", 4, 4);
            MANUAL_REFRESH_ONLY = mode;
            Mode mode2 = PULL_FROM_START;
            Mode mode3 = PULL_FROM_END;
            $VALUES = new Mode[]{DISABLED, mode2, mode3, BOTH, mode};
            PULL_DOWN_TO_REFRESH = mode2;
            PULL_UP_TO_REFRESH = mode3;
        }

        public Mode(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mIntValue = i3;
        }

        public static Mode getDefault() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? PULL_FROM_START : (Mode) invokeV.objValue;
        }

        public static Mode mapIntToValue(int i2) {
            InterceptResult invokeI;
            Mode[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
                for (Mode mode : values()) {
                    if (i2 == mode.getIntValue()) {
                        return mode;
                    }
                }
                return getDefault();
            }
            return (Mode) invokeI.objValue;
        }

        public static Mode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (Mode) Enum.valueOf(Mode.class, str) : (Mode) invokeL.objValue;
        }

        public static Mode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (Mode[]) $VALUES.clone() : (Mode[]) invokeV.objValue;
        }

        public int getIntValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIntValue : invokeV.intValue;
        }

        public boolean permitsPullToRefresh() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true : invokeV.booleanValue;
        }

        public boolean showFooterLoadingLayout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY : invokeV.booleanValue;
        }

        public boolean showHeaderLoadingLayout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this == PULL_FROM_START || this == BOTH : invokeV.booleanValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class Orientation {
        public static final /* synthetic */ Orientation[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Orientation HORIZONTAL;
        public static final Orientation VERTICAL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-695257261, "Lcom/baidu/tbadk/widget/pulltorefresh/library/PullToRefreshBase$Orientation;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-695257261, "Lcom/baidu/tbadk/widget/pulltorefresh/library/PullToRefreshBase$Orientation;");
                    return;
                }
            }
            VERTICAL = new Orientation("VERTICAL", 0);
            Orientation orientation = new Orientation("HORIZONTAL", 1);
            HORIZONTAL = orientation;
            $VALUES = new Orientation[]{VERTICAL, orientation};
        }

        public Orientation(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Orientation valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Orientation) Enum.valueOf(Orientation.class, str) : (Orientation) invokeL.objValue;
        }

        public static Orientation[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Orientation[]) $VALUES.clone() : (Orientation[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final State MANUAL_REFRESHING;
        public static final State OVERSCROLLING;
        public static final State PULL_TO_REFRESH;
        public static final State REFRESHING;
        public static final State RELEASE_TO_REFRESH;
        public static final State RESET;
        public transient /* synthetic */ FieldHolder $fh;
        public int mIntValue;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1512337742, "Lcom/baidu/tbadk/widget/pulltorefresh/library/PullToRefreshBase$State;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1512337742, "Lcom/baidu/tbadk/widget/pulltorefresh/library/PullToRefreshBase$State;");
                    return;
                }
            }
            RESET = new State("RESET", 0, 0);
            PULL_TO_REFRESH = new State("PULL_TO_REFRESH", 1, 1);
            RELEASE_TO_REFRESH = new State("RELEASE_TO_REFRESH", 2, 2);
            REFRESHING = new State("REFRESHING", 3, 8);
            MANUAL_REFRESHING = new State("MANUAL_REFRESHING", 4, 9);
            State state = new State("OVERSCROLLING", 5, 16);
            OVERSCROLLING = state;
            $VALUES = new State[]{RESET, PULL_TO_REFRESH, RELEASE_TO_REFRESH, REFRESHING, MANUAL_REFRESHING, state};
        }

        public State(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mIntValue = i3;
        }

        public static State mapIntToValue(int i2) {
            InterceptResult invokeI;
            State[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                for (State state : values()) {
                    if (i2 == state.getIntValue()) {
                        return state;
                    }
                }
                return RESET;
            }
            return (State) invokeI.objValue;
        }

        public static State valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (State) Enum.valueOf(State.class, str) : (State) invokeL.objValue;
        }

        public static State[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (State[]) $VALUES.clone() : (State[]) invokeV.objValue;
        }

        public int getIntValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIntValue : invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PullToRefreshBase a;

        public a(PullToRefreshBase pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pullToRefreshBase;
        }

        @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PullToRefreshBase f40079e;

        public b(PullToRefreshBase pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40079e = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f40079e.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PullToRefreshBase a;

        public c(PullToRefreshBase pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pullToRefreshBase;
        }

        @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.h
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k(0, 200L, 225L, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class d {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f40080b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f40081c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f40082d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1935506145, "Lcom/baidu/tbadk/widget/pulltorefresh/library/PullToRefreshBase$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1935506145, "Lcom/baidu/tbadk/widget/pulltorefresh/library/PullToRefreshBase$d;");
                    return;
                }
            }
            int[] iArr = new int[AnimationStyle.values().length];
            f40082d = iArr;
            try {
                iArr[AnimationStyle.ROTATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40082d[AnimationStyle.FLIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Mode.values().length];
            f40081c = iArr2;
            try {
                iArr2[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40081c[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40081c[Mode.MANUAL_REFRESH_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f40081c[Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[State.values().length];
            f40080b = iArr3;
            try {
                iArr3[State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f40080b[State.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f40080b[State.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f40080b[State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f40080b[State.MANUAL_REFRESHING.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f40080b[State.OVERSCROLLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr4 = new int[Orientation.values().length];
            a = iArr4;
            try {
                iArr4[Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface e<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase, State state, Mode mode);
    }

    /* loaded from: classes5.dex */
    public interface f<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* loaded from: classes5.dex */
    public interface g<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a();
    }

    /* loaded from: classes5.dex */
    public final class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final Interpolator f40083e;

        /* renamed from: f  reason: collision with root package name */
        public final int f40084f;

        /* renamed from: g  reason: collision with root package name */
        public final int f40085g;

        /* renamed from: h  reason: collision with root package name */
        public final long f40086h;

        /* renamed from: i  reason: collision with root package name */
        public h f40087i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f40088j;
        public long k;
        public int l;
        public final /* synthetic */ PullToRefreshBase m;

        public i(PullToRefreshBase pullToRefreshBase, int i2, int i3, long j2, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = pullToRefreshBase;
            this.f40088j = true;
            this.k = -1L;
            this.l = -1;
            this.f40085g = i2;
            this.f40084f = i3;
            this.f40083e = pullToRefreshBase.u;
            this.f40086h = j2;
            this.f40087i = hVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f40088j = false;
                this.m.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.k == -1) {
                    this.k = System.currentTimeMillis();
                } else {
                    int round = this.f40085g - Math.round((this.f40085g - this.f40084f) * this.f40083e.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.k) * 1000) / this.f40086h, 1000L), 0L)) / 1000.0f));
                    this.l = round;
                    this.m.setHeaderScroll(round);
                }
                if (this.f40088j && this.f40084f != this.l) {
                    c.a.q0.e1.m.a.d.b.a(this.m, this);
                    return;
                }
                h hVar = this.f40087i;
                if (hVar != null) {
                    hVar.a();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBase(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.f40078j = false;
        this.k = State.RESET;
        this.l = Mode.getDefault();
        this.p = true;
        this.q = false;
        this.r = true;
        this.s = true;
        this.t = true;
        this.v = AnimationStyle.getDefault();
        f(context, null);
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (d.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                return new LinearLayout.LayoutParams(-1, -2);
            }
            return new LinearLayout.LayoutParams(-2, -1);
        }
        return (LinearLayout.LayoutParams) invokeV.objValue;
    }

    private int getMaximumPullScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            if (d.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                return Math.round(getHeight() / 2.0f);
            }
            return Math.round(getWidth() / 2.0f);
        }
        return invokeV.intValue;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view, i2, layoutParams) == null) {
            T refreshableView = getRefreshableView();
            if (refreshableView instanceof ViewGroup) {
                ((ViewGroup) refreshableView).addView(view, i2, layoutParams);
                return;
            }
            throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
        }
    }

    public final void addViewInternal(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2, layoutParams) == null) {
            super.addView(view, i2, layoutParams);
        }
    }

    public LoadingLayout createLoadingLayout(Context context, Mode mode, TypedArray typedArray) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, mode, typedArray)) == null) {
            LoadingLayout createLoadingLayout = this.v.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
            createLoadingLayout.setVisibility(4);
            return createLoadingLayout;
        }
        return (LoadingLayout) invokeLLL.objValue;
    }

    public c.a.q0.e1.m.a.b createLoadingLayoutProxy(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            c.a.q0.e1.m.a.b bVar = new c.a.q0.e1.m.a.b();
            if (z && this.l.showHeaderLoadingLayout()) {
                bVar.a(this.w);
            }
            if (z2 && this.l.showFooterLoadingLayout()) {
                bVar.a(this.x);
            }
            return bVar;
        }
        return (c.a.q0.e1.m.a.b) invokeCommon.objValue;
    }

    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public final void d(Context context, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, t) == null) {
            FrameLayout frameLayout = new FrameLayout(context);
            this.o = frameLayout;
            frameLayout.addView(t, -1, -1);
            addViewInternal(this.o, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    public final boolean demo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.l.showHeaderLoadingLayout() && isReadyForPullStart()) {
                l((-getHeaderSize()) * 2);
                return true;
            } else if (this.l.showFooterLoadingLayout() && isReadyForPullEnd()) {
                l(getFooterSize() * 2);
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void disableLoadingLayoutVisibilityChanges() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.t = false;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            g<T> gVar = this.y;
            if (gVar != null) {
                gVar.a(this);
                return;
            }
            f<T> fVar = this.z;
            if (fVar != null) {
                Mode mode = this.m;
                if (mode == Mode.PULL_FROM_START) {
                    fVar.b(this);
                } else if (mode == Mode.PULL_FROM_END) {
                    fVar.a(this);
                }
            }
        }
    }

    public final void f(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, attributeSet) == null) {
            if (d.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                setOrientation(1);
            } else {
                setOrientation(0);
            }
            setGravity(17);
            this.f40073e = ViewConfiguration.get(context).getScaledTouchSlop();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.ptrAdapterViewBackground, R.attr.ptrAnimationStyle, R.attr.ptrDrawable, R.attr.ptrDrawableBottom, R.attr.ptrDrawableEnd, R.attr.ptrDrawableStart, R.attr.ptrDrawableTop, R.attr.ptrHeaderBackground, R.attr.ptrHeaderSubTextColor, R.attr.ptrHeaderTextAppearance, R.attr.ptrHeaderTextColor, R.attr.ptrListViewExtrasEnabled, R.attr.ptrLoadingDimension, R.attr.ptrOverScroll, R.attr.ptrRefreshableViewBackground, R.attr.ptrRotateDrawableWhilePulling, R.attr.ptrScrollingWhileRefreshingEnabled, R.attr.ptrShowIndicator, R.attr.ptrSubHeaderTextAppearance, R.attr.tb_ptrAdapterViewBackground, R.attr.tb_ptrAnimationStyle, R.attr.tb_ptrDrawable, R.attr.tb_ptrDrawableBottom, R.attr.tb_ptrDrawableEnd, R.attr.tb_ptrDrawableStart, R.attr.tb_ptrDrawableTop, R.attr.tb_ptrHeaderBackground, R.attr.tb_ptrHeaderSubTextColor, R.attr.tb_ptrHeaderTextAppearance, R.attr.tb_ptrHeaderTextColor, R.attr.tb_ptrListViewExtrasEnabled, R.attr.tb_ptrMode, R.attr.tb_ptrOverScroll, R.attr.tb_ptrRefreshableViewBackground, R.attr.tb_ptrRotateDrawableWhilePulling, R.attr.tb_ptrScrollingWhileRefreshingEnabled, R.attr.tb_ptrShowIndicator, R.attr.tb_ptrSubHeaderTextAppearance});
            if (obtainStyledAttributes.hasValue(31)) {
                this.l = Mode.mapIntToValue(obtainStyledAttributes.getInteger(31, 0));
            }
            if (obtainStyledAttributes.hasValue(20)) {
                this.v = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(20, 0));
            }
            T createRefreshableView = createRefreshableView(context, attributeSet);
            this.n = createRefreshableView;
            d(context, createRefreshableView);
            this.w = createLoadingLayout(context, Mode.PULL_FROM_START, obtainStyledAttributes);
            this.x = createLoadingLayout(context, Mode.PULL_FROM_END, obtainStyledAttributes);
            if (obtainStyledAttributes.hasValue(33)) {
                Drawable drawable = obtainStyledAttributes.getDrawable(33);
                if (drawable != null) {
                    this.n.setBackgroundDrawable(drawable);
                }
            } else if (obtainStyledAttributes.hasValue(19)) {
                c.a.q0.e1.m.a.d.a.a("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
                Drawable drawable2 = obtainStyledAttributes.getDrawable(19);
                if (drawable2 != null) {
                    this.n.setBackgroundDrawable(drawable2);
                }
            }
            if (obtainStyledAttributes.hasValue(32)) {
                this.s = obtainStyledAttributes.getBoolean(32, true);
            }
            if (obtainStyledAttributes.hasValue(35)) {
                this.q = obtainStyledAttributes.getBoolean(35, false);
            }
            handleStyledAttributes(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
            updateUIForMode();
        }
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            int i2 = d.f40081c[this.l.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 4) {
                        return false;
                    }
                    return isReadyForPullEnd() || isReadyForPullStart();
                }
                return isReadyForPullStart();
            }
            return isReadyForPullEnd();
        }
        return invokeV.booleanValue;
    }

    public final Mode getCurrentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : (Mode) invokeV.objValue;
    }

    public final boolean getFilterTouchEvents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public final LoadingLayout getFooterLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.x : (LoadingLayout) invokeV.objValue;
    }

    public final int getFooterSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.x.getContentSize() : invokeV.intValue;
    }

    public final LoadingLayout getHeaderLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.w : (LoadingLayout) invokeV.objValue;
    }

    public final int getHeaderSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.w.getContentSize() : invokeV.intValue;
    }

    public final c.a.q0.e1.m.a.a getLoadingLayoutProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? getLoadingLayoutProxy(true, true) : (c.a.q0.e1.m.a.a) invokeV.objValue;
    }

    public final Mode getMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.l : (Mode) invokeV.objValue;
    }

    public abstract Orientation getPullToRefreshScrollDirection();

    public int getPullToRefreshScrollDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return 200;
        }
        return invokeV.intValue;
    }

    public int getPullToRefreshScrollDurationLonger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? SMOOTH_SCROLL_LONG_DURATION_MS : invokeV.intValue;
    }

    public final T getRefreshableView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.n : (T) invokeV.objValue;
    }

    public FrameLayout getRefreshableViewWrapper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.o : (FrameLayout) invokeV.objValue;
    }

    public final boolean getShowViewWhileRefreshing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public final State getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.k : (State) invokeV.objValue;
    }

    public final void h() {
        float f2;
        float f3;
        int round;
        int footerSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (d.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                f2 = this.f40077i;
                f3 = this.f40075g;
            } else {
                f2 = this.f40076h;
                f3 = this.f40074f;
            }
            if (d.f40081c[this.m.ordinal()] != 1) {
                round = Math.round(Math.min(f2 - f3, 0.0f) / 2.0f);
                footerSize = getHeaderSize();
            } else {
                round = Math.round(Math.max(f2 - f3, 0.0f) / 2.0f);
                footerSize = getFooterSize();
            }
            setHeaderScroll(round);
            if (round == 0 || isRefreshing()) {
                return;
            }
            float abs = Math.abs(round) / footerSize;
            if (d.f40081c[this.m.ordinal()] != 1) {
                this.w.onPull(abs);
            } else {
                this.x.onPull(abs);
            }
            if (this.k != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                i(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.k != State.PULL_TO_REFRESH || footerSize >= Math.abs(round)) {
            } else {
                i(State.RELEASE_TO_REFRESH, new boolean[0]);
            }
        }
    }

    public void handleStyledAttributes(TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, typedArray) == null) {
        }
    }

    public final void i(State state, boolean... zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, state, zArr) == null) {
            this.k = state;
            int i2 = d.f40080b[state.ordinal()];
            if (i2 == 1) {
                onReset();
            } else if (i2 == 2) {
                onPullToRefresh();
            } else if (i2 == 3) {
                onReleaseToRefresh();
            } else if (i2 == 4 || i2 == 5) {
                onRefreshing(zArr[0]);
            }
            e<T> eVar = this.A;
            if (eVar != null) {
                eVar.a(this, this.k, this.m);
            }
        }
    }

    public final boolean isDisableScrollingWhileRefreshing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? !isScrollingWhileRefreshingEnabled() : invokeV.booleanValue;
    }

    public final boolean isPullToRefreshEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.l.permitsPullToRefresh() : invokeV.booleanValue;
    }

    public final boolean isPullToRefreshOverScrollEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? Build.VERSION.SDK_INT >= 9 && this.s && c.a.q0.e1.m.a.c.a(this.n) : invokeV.booleanValue;
    }

    public abstract boolean isReadyForPullEnd();

    public abstract boolean isReadyForPullStart();

    public final boolean isRefreshing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            State state = this.k;
            return state == State.REFRESHING || state == State.MANUAL_REFRESHING;
        }
        return invokeV.booleanValue;
    }

    public final boolean isScrollingWhileRefreshingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public final void j(int i2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
            k(i2, j2, 0L, null);
        }
    }

    public final void k(int i2, long j2, long j3, h hVar) {
        int scrollX;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), hVar}) == null) {
            PullToRefreshBase<T>.i iVar = this.B;
            if (iVar != null) {
                iVar.a();
            }
            if (d.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                scrollX = getScrollY();
            } else {
                scrollX = getScrollX();
            }
            int i3 = scrollX;
            if (i3 != i2) {
                if (this.u == null) {
                    this.u = new DecelerateInterpolator();
                }
                PullToRefreshBase<T>.i iVar2 = new i(this, i3, i2, j2, hVar);
                this.B = iVar2;
                if (j3 > 0) {
                    postDelayed(iVar2, j3);
                } else {
                    post(iVar2);
                }
            }
        }
    }

    public final void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            k(i2, 200L, 0L, new c(this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, motionEvent)) == null) {
            if (isPullToRefreshEnabled()) {
                int action = motionEvent.getAction();
                if (action != 3 && action != 1) {
                    if (action == 0 || !this.f40078j) {
                        if (action != 0) {
                            if (action == 2) {
                                if (!this.q && isRefreshing()) {
                                    return true;
                                }
                                if (g()) {
                                    float y = motionEvent.getY();
                                    float x = motionEvent.getX();
                                    if (d.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                                        f2 = y - this.f40075g;
                                        f3 = x - this.f40074f;
                                    } else {
                                        f2 = x - this.f40074f;
                                        f3 = y - this.f40075g;
                                    }
                                    float abs = Math.abs(f2);
                                    if (abs > this.f40073e && (!this.r || abs > Math.abs(f3))) {
                                        if (this.l.showHeaderLoadingLayout() && f2 >= 1.0f && isReadyForPullStart()) {
                                            this.f40075g = y;
                                            this.f40074f = x;
                                            this.f40078j = true;
                                            if (this.l == Mode.BOTH) {
                                                this.m = Mode.PULL_FROM_START;
                                            }
                                        } else if (this.l.showFooterLoadingLayout() && f2 <= -1.0f && isReadyForPullEnd()) {
                                            this.f40075g = y;
                                            this.f40074f = x;
                                            this.f40078j = true;
                                            if (this.l == Mode.BOTH) {
                                                this.m = Mode.PULL_FROM_END;
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (g()) {
                            float y2 = motionEvent.getY();
                            this.f40077i = y2;
                            this.f40075g = y2;
                            float x2 = motionEvent.getX();
                            this.f40076h = x2;
                            this.f40074f = x2;
                            this.f40078j = false;
                        }
                        return this.f40078j;
                    }
                    return true;
                }
                this.f40078j = false;
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void onPtrRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
        }
    }

    public void onPtrSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bundle) == null) {
        }
    }

    public void onPullToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            int i2 = d.f40081c[this.m.ordinal()];
            if (i2 == 1) {
                this.x.pullToRefresh();
            } else if (i2 != 2) {
            } else {
                this.w.pullToRefresh();
            }
        }
    }

    public final void onRefreshComplete() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && isRefreshing()) {
            i(State.RESET, new boolean[0]);
        }
    }

    public void onRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            if (this.l.showHeaderLoadingLayout()) {
                this.w.refreshing();
            }
            if (this.l.showFooterLoadingLayout()) {
                this.x.refreshing();
            }
            if (z) {
                if (this.p) {
                    a aVar = new a(this);
                    int i2 = d.f40081c[this.m.ordinal()];
                    if (i2 != 1 && i2 != 3) {
                        smoothScrollTo(-getHeaderSize(), aVar);
                        return;
                    } else {
                        smoothScrollTo(getFooterSize(), aVar);
                        return;
                    }
                }
                smoothScrollTo(0);
                return;
            }
            e();
        }
    }

    public void onReleaseToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            int i2 = d.f40081c[this.m.ordinal()];
            if (i2 == 1) {
                this.x.releaseToRefresh();
            } else if (i2 != 2) {
            } else {
                this.w.releaseToRefresh();
            }
        }
    }

    public void onReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.f40078j = false;
            this.t = true;
            this.w.reset();
            this.x.reset();
            smoothScrollTo(0);
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, parcelable) == null) {
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
                this.m = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
                this.q = bundle.getBoolean("ptr_disable_scrolling", false);
                this.p = bundle.getBoolean("ptr_show_refreshing_view", true);
                super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
                State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
                if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                    i(mapIntToValue, true);
                }
                onPtrRestoreInstanceState(bundle);
                return;
            }
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            Bundle bundle = new Bundle();
            onPtrSaveInstanceState(bundle);
            bundle.putInt("ptr_state", this.k.getIntValue());
            bundle.putInt("ptr_mode", this.l.getIntValue());
            bundle.putInt("ptr_current_mode", this.m.getIntValue());
            bundle.putBoolean("ptr_disable_scrolling", this.q);
            bundle.putBoolean("ptr_show_refreshing_view", this.p);
            bundle.putParcelable("ptr_super", super.onSaveInstanceState());
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048627, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            refreshLoadingViewsSize();
            refreshRefreshableViewSize(i2, i3);
            post(new b(this));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:
        if (r0 != 3) goto L24;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, motionEvent)) == null) {
            if (isPullToRefreshEnabled()) {
                if (this.q || !isRefreshing()) {
                    if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                        int action = motionEvent.getAction();
                        if (action != 0) {
                            if (action != 1) {
                                if (action == 2) {
                                    if (this.f40078j) {
                                        this.f40075g = motionEvent.getY();
                                        this.f40074f = motionEvent.getX();
                                        h();
                                        return true;
                                    }
                                }
                            }
                            if (this.f40078j) {
                                this.f40078j = false;
                                if (this.k == State.RELEASE_TO_REFRESH && (this.y != null || this.z != null)) {
                                    i(State.REFRESHING, true);
                                    return true;
                                } else if (isRefreshing()) {
                                    smoothScrollTo(0);
                                    return true;
                                } else {
                                    i(State.RESET, new boolean[0]);
                                    return true;
                                }
                            }
                        } else if (g()) {
                            float y = motionEvent.getY();
                            this.f40077i = y;
                            this.f40075g = y;
                            float x = motionEvent.getX();
                            this.f40076h = x;
                            this.f40074f = x;
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void refreshLoadingViewsSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            int maximumPullScroll = (int) (getMaximumPullScroll() * 1.2f);
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int i2 = d.a[getPullToRefreshScrollDirection().ordinal()];
            if (i2 == 1) {
                if (this.l.showHeaderLoadingLayout()) {
                    this.w.setWidth(maximumPullScroll);
                    paddingLeft = -maximumPullScroll;
                } else {
                    paddingLeft = 0;
                }
                if (this.l.showFooterLoadingLayout()) {
                    this.x.setWidth(maximumPullScroll);
                    paddingRight = -maximumPullScroll;
                } else {
                    paddingRight = 0;
                }
            } else if (i2 == 2) {
                if (this.l.showHeaderLoadingLayout()) {
                    this.w.setHeight(maximumPullScroll);
                    paddingTop = -maximumPullScroll;
                } else {
                    paddingTop = 0;
                }
                if (this.l.showFooterLoadingLayout()) {
                    this.x.setHeight(maximumPullScroll);
                    paddingBottom = -maximumPullScroll;
                } else {
                    paddingBottom = 0;
                }
            }
            setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public final void refreshRefreshableViewSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048630, this, i2, i3) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            int i4 = d.a[getPullToRefreshScrollDirection().ordinal()];
            if (i4 != 1) {
                if (i4 == 2 && layoutParams.height != i3) {
                    layoutParams.height = i3;
                    this.o.requestLayout();
                }
            } else if (layoutParams.width != i2) {
                layoutParams.width = i2;
                this.o.requestLayout();
            }
        }
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            setScrollingWhileRefreshingEnabled(!z);
        }
    }

    public final void setFilterTouchEvents(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.r = z;
        }
    }

    public final void setHeaderScroll(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            int maximumPullScroll = getMaximumPullScroll();
            int min = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i2));
            if (this.t) {
                if (min < 0) {
                    this.w.setVisibility(0);
                } else if (min > 0) {
                    this.x.setVisibility(0);
                } else {
                    this.w.setVisibility(4);
                    this.x.setVisibility(4);
                }
            }
            int i3 = d.a[getPullToRefreshScrollDirection().ordinal()];
            if (i3 == 1) {
                scrollTo(min, 0);
            } else if (i3 != 2) {
            } else {
                scrollTo(0, min);
            }
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, charSequence) == null) {
            getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
        }
    }

    public void setLoadingDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, drawable) == null) {
            getLoadingLayoutProxy().setLoadingDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            getRefreshableView().setLongClickable(z);
        }
    }

    public final void setMode(Mode mode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, mode) == null) || mode == this.l) {
            return;
        }
        this.l = mode;
        updateUIForMode();
    }

    public void setOnPullEventListener(e<T> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, eVar) == null) {
            this.A = eVar;
        }
    }

    public final void setOnRefreshListener(g<T> gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, gVar) == null) {
            this.y = gVar;
            this.z = null;
        }
    }

    public void setPullLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, charSequence) == null) {
            getLoadingLayoutProxy().setPullLabel(charSequence);
        }
    }

    public final void setPullToRefreshEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            setMode(z ? Mode.getDefault() : Mode.DISABLED);
        }
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.s = z;
        }
    }

    public final void setRefreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            setRefreshing(true);
        }
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, charSequence) == null) {
            getLoadingLayoutProxy().setRefreshingLabel(charSequence);
        }
    }

    public void setReleaseLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, charSequence) == null) {
            setReleaseLabel(charSequence, Mode.BOTH);
        }
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, interpolator) == null) {
            this.u = interpolator;
        }
    }

    public final void setScrollingWhileRefreshingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048653, this, z) == null) {
            this.q = z;
        }
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            this.p = z;
        }
    }

    public final void smoothScrollTo(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i2) == null) {
            j(i2, getPullToRefreshScrollDuration());
        }
    }

    public final void smoothScrollToLonger(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i2) == null) {
            j(i2, getPullToRefreshScrollDurationLonger());
        }
    }

    public void updateUIForMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
            if (this == this.w.getParent()) {
                removeView(this.w);
            }
            if (this.l.showHeaderLoadingLayout()) {
                addViewInternal(this.w, 0, loadingLayoutLayoutParams);
            }
            if (this == this.x.getParent()) {
                removeView(this.x);
            }
            if (this.l.showFooterLoadingLayout()) {
                addViewInternal(this.x, loadingLayoutLayoutParams);
            }
            refreshLoadingViewsSize();
            Mode mode = this.l;
            if (mode == Mode.BOTH) {
                mode = Mode.PULL_FROM_START;
            }
            this.m = mode;
        }
    }

    public final void addViewInternal(View view, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, layoutParams) == null) {
            super.addView(view, -1, layoutParams);
        }
    }

    public final c.a.q0.e1.m.a.a getLoadingLayoutProxy(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? createLoadingLayoutProxy(z, z2) : (c.a.q0.e1.m.a.a) invokeCommon.objValue;
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, drawable, mode) == null) {
            getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
        }
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048643, this, charSequence, mode) == null) {
            getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
        }
    }

    public final void setRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048647, this, z) == null) || isRefreshing()) {
            return;
        }
        i(State.MANUAL_REFRESHING, z);
    }

    public void setRefreshingLabel(CharSequence charSequence, Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048649, this, charSequence, mode) == null) {
            getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
        }
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048651, this, charSequence, mode) == null) {
            getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
        }
    }

    public final void smoothScrollTo(int i2, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048656, this, i2, hVar) == null) {
            k(i2, getPullToRefreshScrollDuration(), 0L, hVar);
        }
    }

    public final void setOnRefreshListener(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, fVar) == null) {
            this.z = fVar;
            this.y = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40078j = false;
        this.k = State.RESET;
        this.l = Mode.getDefault();
        this.p = true;
        this.q = false;
        this.r = true;
        this.s = true;
        this.t = true;
        this.v = AnimationStyle.getDefault();
        f(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBase(Context context, Mode mode) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mode};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f40078j = false;
        this.k = State.RESET;
        this.l = Mode.getDefault();
        this.p = true;
        this.q = false;
        this.r = true;
        this.s = true;
        this.t = true;
        this.v = AnimationStyle.getDefault();
        this.l = mode;
        f(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullToRefreshBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mode, animationStyle};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f40078j = false;
        this.k = State.RESET;
        this.l = Mode.getDefault();
        this.p = true;
        this.q = false;
        this.r = true;
        this.s = true;
        this.t = true;
        this.v = AnimationStyle.getDefault();
        this.l = mode;
        this.v = animationStyle;
        f(context, null);
    }
}

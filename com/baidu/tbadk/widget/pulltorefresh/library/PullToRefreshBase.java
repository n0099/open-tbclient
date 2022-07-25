package com.baidu.tbadk.widget.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
import com.repackage.jg5;
import com.repackage.kg5;
import com.repackage.lg5;
import com.repackage.mg5;
/* loaded from: classes3.dex */
public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public float b;
    public float c;
    public float d;
    public float e;
    public boolean f;
    public State g;
    public Mode h;
    public Mode i;
    public T j;
    public FrameLayout k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public Interpolator p;
    public AnimationStyle q;
    public LoadingLayout r;
    public LoadingLayout s;
    public f<T> t;
    public e<T> u;
    public d<T> v;
    public PullToRefreshBase<T>.h w;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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

        public AnimationStyle(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        public static AnimationStyle mapIntToValue(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
                if (i != 1) {
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
                if (c.d[ordinal()] != 2) {
                    return new RotateLoadingLayout(context, mode, orientation, typedArray);
                }
                return new FlipLoadingLayout(context, mode, orientation, typedArray);
            }
            return (LoadingLayout) invokeLLLL.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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

        public Mode(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mIntValue = i2;
        }

        public static Mode getDefault() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? PULL_FROM_START : (Mode) invokeV.objValue;
        }

        public static Mode mapIntToValue(int i) {
            InterceptResult invokeI;
            Mode[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
                for (Mode mode : values()) {
                    if (i == mode.getIntValue()) {
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
    /* loaded from: classes3.dex */
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

        public Orientation(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
    /* loaded from: classes3.dex */
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

        public State(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mIntValue = i2;
        }

        public static State mapIntToValue(int i) {
            InterceptResult invokeI;
            State[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                for (State state : values()) {
                    if (i == state.getIntValue()) {
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

    /* loaded from: classes3.dex */
    public class a implements g {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pullToRefreshBase;
        }

        @Override // com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PullToRefreshBase a;

        public b(PullToRefreshBase pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pullToRefreshBase;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1935506176, "Lcom/baidu/tbadk/widget/pulltorefresh/library/PullToRefreshBase$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1935506176, "Lcom/baidu/tbadk/widget/pulltorefresh/library/PullToRefreshBase$c;");
                    return;
                }
            }
            int[] iArr = new int[AnimationStyle.values().length];
            d = iArr;
            try {
                iArr[AnimationStyle.ROTATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[AnimationStyle.FLIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Mode.values().length];
            c = iArr2;
            try {
                iArr2[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[Mode.MANUAL_REFRESH_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                c[Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[State.values().length];
            b = iArr3;
            try {
                iArr3[State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[State.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[State.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[State.MANUAL_REFRESHING.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                b[State.OVERSCROLLING.ordinal()] = 6;
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

    /* loaded from: classes3.dex */
    public interface d<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase, State state, Mode mode);
    }

    /* loaded from: classes3.dex */
    public interface e<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);

        void b(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* loaded from: classes3.dex */
    public interface f<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a();
    }

    /* loaded from: classes3.dex */
    public final class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Interpolator a;
        public final int b;
        public final int c;
        public final long d;
        public g e;
        public boolean f;
        public long g;
        public int h;
        public final /* synthetic */ PullToRefreshBase i;

        public h(PullToRefreshBase pullToRefreshBase, int i, int i2, long j, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pullToRefreshBase, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = pullToRefreshBase;
            this.f = true;
            this.g = -1L;
            this.h = -1;
            this.c = i;
            this.b = i2;
            this.a = pullToRefreshBase.p;
            this.d = j;
            this.e = gVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f = false;
                this.i.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.g == -1) {
                    this.g = System.currentTimeMillis();
                } else {
                    int round = this.c - Math.round((this.c - this.b) * this.a.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.g) * 1000) / this.d, 1000L), 0L)) / 1000.0f));
                    this.h = round;
                    this.i.setHeaderScroll(round);
                }
                if (this.f && this.b != this.h) {
                    mg5.a(this.i, this);
                    return;
                }
                g gVar = this.e;
                if (gVar != null) {
                    gVar.a();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = State.RESET;
        this.h = Mode.getDefault();
        this.l = true;
        this.m = false;
        this.n = true;
        this.o = true;
        this.q = AnimationStyle.getDefault();
        l(context, null);
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (c.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                return new LinearLayout.LayoutParams(-1, -2);
            }
            return new LinearLayout.LayoutParams(-2, -1);
        }
        return (LinearLayout.LayoutParams) invokeV.objValue;
    }

    private int getMaximumPullScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (c.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                return Math.round(getHeight() / 2.0f);
            }
            return Math.round(getWidth() / 2.0f);
        }
        return invokeV.intValue;
    }

    public final void A(State state, boolean... zArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, state, zArr) == null) {
            this.g = state;
            int i = c.b[state.ordinal()];
            if (i == 1) {
                w();
            } else if (i == 2) {
                t();
            } else if (i == 3) {
                v();
            } else if (i == 4 || i == 5) {
                u(zArr[0]);
            }
            d<T> dVar = this.v;
            if (dVar != null) {
                dVar.a(this, this.g, this.i);
            }
        }
    }

    public final void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            C(i, getPullToRefreshScrollDuration());
        }
    }

    public final void C(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            D(i, j, 0L, null);
        }
    }

    public final void D(int i, long j, long j2, g gVar) {
        int scrollX;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), gVar}) == null) {
            PullToRefreshBase<T>.h hVar = this.w;
            if (hVar != null) {
                hVar.a();
            }
            if (c.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                scrollX = getScrollY();
            } else {
                scrollX = getScrollX();
            }
            int i2 = scrollX;
            if (i2 != i) {
                if (this.p == null) {
                    this.p = new DecelerateInterpolator();
                }
                PullToRefreshBase<T>.h hVar2 = new h(this, i2, i, j, gVar);
                this.w = hVar2;
                if (j2 > 0) {
                    postDelayed(hVar2, j2);
                } else {
                    post(hVar2);
                }
            }
        }
    }

    public final void E(int i, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, gVar) == null) {
            D(i, getPullToRefreshScrollDuration(), 0L, gVar);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LinearLayout.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
            if (this == this.r.getParent()) {
                removeView(this.r);
            }
            if (this.h.showHeaderLoadingLayout()) {
                d(this.r, 0, loadingLayoutLayoutParams);
            }
            if (this == this.s.getParent()) {
                removeView(this.s);
            }
            if (this.h.showFooterLoadingLayout()) {
                e(this.s, loadingLayoutLayoutParams);
            }
            y();
            Mode mode = this.h;
            if (mode == Mode.BOTH) {
                mode = Mode.PULL_FROM_START;
            }
            this.i = mode;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, view2, i, layoutParams) == null) {
            T refreshableView = getRefreshableView();
            if (refreshableView instanceof ViewGroup) {
                ((ViewGroup) refreshableView).addView(view2, i, layoutParams);
                return;
            }
            throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
        }
    }

    public final void c(Context context, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, t) == null) {
            FrameLayout frameLayout = new FrameLayout(context);
            this.k = frameLayout;
            frameLayout.addView(t, -1, -1);
            e(this.k, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    public final void d(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, i, layoutParams) == null) {
            super.addView(view2, i, layoutParams);
        }
    }

    public final void e(View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view2, layoutParams) == null) {
            super.addView(view2, -1, layoutParams);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            f<T> fVar = this.t;
            if (fVar != null) {
                fVar.a(this);
                return;
            }
            e<T> eVar = this.u;
            if (eVar != null) {
                Mode mode = this.i;
                if (mode == Mode.PULL_FROM_START) {
                    eVar.b(this);
                } else if (mode == Mode.PULL_FROM_END) {
                    eVar.a(this);
                }
            }
        }
    }

    public LoadingLayout g(Context context, Mode mode, TypedArray typedArray) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, context, mode, typedArray)) == null) {
            LoadingLayout createLoadingLayout = this.q.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
            createLoadingLayout.setVisibility(4);
            return createLoadingLayout;
        }
        return (LoadingLayout) invokeLLL.objValue;
    }

    public final Mode getCurrentMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.i : (Mode) invokeV.objValue;
    }

    public final boolean getFilterTouchEvents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public final LoadingLayout getFooterLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.s : (LoadingLayout) invokeV.objValue;
    }

    public final int getFooterSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.s.getContentSize() : invokeV.intValue;
    }

    public final LoadingLayout getHeaderLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.r : (LoadingLayout) invokeV.objValue;
    }

    public final int getHeaderSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.r.getContentSize() : invokeV.intValue;
    }

    public final jg5 getLoadingLayoutProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? j(true, true) : (jg5) invokeV.objValue;
    }

    public final Mode getMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.h : (Mode) invokeV.objValue;
    }

    public abstract Orientation getPullToRefreshScrollDirection();

    public int getPullToRefreshScrollDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return 200;
        }
        return invokeV.intValue;
    }

    public int getPullToRefreshScrollDurationLonger() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return 325;
        }
        return invokeV.intValue;
    }

    public final T getRefreshableView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.j : (T) invokeV.objValue;
    }

    public FrameLayout getRefreshableViewWrapper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.k : (FrameLayout) invokeV.objValue;
    }

    public final boolean getShowViewWhileRefreshing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public final State getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.g : (State) invokeV.objValue;
    }

    public kg5 h(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            kg5 kg5Var = new kg5();
            if (z && this.h.showHeaderLoadingLayout()) {
                kg5Var.a(this.r);
            }
            if (z2 && this.h.showFooterLoadingLayout()) {
                kg5Var.a(this.s);
            }
            return kg5Var;
        }
        return (kg5) invokeCommon.objValue;
    }

    public abstract T i(Context context, AttributeSet attributeSet);

    public final jg5 j(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? h(z, z2) : (jg5) invokeCommon.objValue;
    }

    public void k(TypedArray typedArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, typedArray) == null) {
        }
    }

    public final void l(Context context, AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, context, attributeSet) == null) {
            if (c.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                setOrientation(1);
            } else {
                setOrientation(0);
            }
            setGravity(17);
            this.a = ViewConfiguration.get(context).getScaledTouchSlop();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f040628, R.attr.obfuscated_res_0x7f040629, R.attr.obfuscated_res_0x7f04062a, R.attr.obfuscated_res_0x7f04062b, R.attr.obfuscated_res_0x7f04062c, R.attr.obfuscated_res_0x7f04062d, R.attr.obfuscated_res_0x7f04062e, R.attr.obfuscated_res_0x7f04062f, R.attr.obfuscated_res_0x7f040630, R.attr.obfuscated_res_0x7f040631, R.attr.obfuscated_res_0x7f040632, R.attr.obfuscated_res_0x7f040633, R.attr.obfuscated_res_0x7f040634, R.attr.obfuscated_res_0x7f040635, R.attr.obfuscated_res_0x7f040636, R.attr.obfuscated_res_0x7f040637, R.attr.obfuscated_res_0x7f040638, R.attr.obfuscated_res_0x7f040639, R.attr.obfuscated_res_0x7f04063a});
            if (obtainStyledAttributes.hasValue(12)) {
                this.h = Mode.mapIntToValue(obtainStyledAttributes.getInteger(12, 0));
            }
            if (obtainStyledAttributes.hasValue(1)) {
                this.q = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(1, 0));
            }
            T i = i(context, attributeSet);
            this.j = i;
            c(context, i);
            this.r = g(context, Mode.PULL_FROM_START, obtainStyledAttributes);
            this.s = g(context, Mode.PULL_FROM_END, obtainStyledAttributes);
            if (obtainStyledAttributes.hasValue(14)) {
                Drawable drawable = obtainStyledAttributes.getDrawable(14);
                if (drawable != null) {
                    this.j.setBackgroundDrawable(drawable);
                }
            } else if (obtainStyledAttributes.hasValue(0)) {
                lg5.a("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
                Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
                if (drawable2 != null) {
                    this.j.setBackgroundDrawable(drawable2);
                }
            }
            if (obtainStyledAttributes.hasValue(13)) {
                obtainStyledAttributes.getBoolean(13, true);
            }
            if (obtainStyledAttributes.hasValue(16)) {
                this.m = obtainStyledAttributes.getBoolean(16, false);
            }
            k(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
            F();
        }
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.h.permitsPullToRefresh() : invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            int i = c.c[this.h.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 4) {
                        return false;
                    }
                    return o() || p();
                }
                return p();
            }
            return o();
        }
        return invokeV.booleanValue;
    }

    public abstract boolean o();

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, motionEvent)) == null) {
            if (m()) {
                int action = motionEvent.getAction();
                if (action != 3 && action != 1) {
                    if (action == 0 || !this.f) {
                        if (action != 0) {
                            if (action == 2) {
                                if (!this.m && q()) {
                                    return true;
                                }
                                if (n()) {
                                    float y = motionEvent.getY();
                                    float x = motionEvent.getX();
                                    if (c.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                                        f2 = y - this.c;
                                        f3 = x - this.b;
                                    } else {
                                        f2 = x - this.b;
                                        f3 = y - this.c;
                                    }
                                    float abs = Math.abs(f2);
                                    if (abs > this.a && (!this.n || abs > Math.abs(f3))) {
                                        if (this.h.showHeaderLoadingLayout() && f2 >= 1.0f && p()) {
                                            this.c = y;
                                            this.b = x;
                                            this.f = true;
                                            if (this.h == Mode.BOTH) {
                                                this.i = Mode.PULL_FROM_START;
                                            }
                                        } else if (this.h.showFooterLoadingLayout() && f2 <= -1.0f && o()) {
                                            this.c = y;
                                            this.b = x;
                                            this.f = true;
                                            if (this.h == Mode.BOTH) {
                                                this.i = Mode.PULL_FROM_END;
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (n()) {
                            float y2 = motionEvent.getY();
                            this.e = y2;
                            this.c = y2;
                            float x2 = motionEvent.getX();
                            this.d = x2;
                            this.b = x2;
                            this.f = false;
                        }
                        return this.f;
                    }
                    return true;
                }
                this.f = false;
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, parcelable) == null) {
            if (parcelable instanceof Bundle) {
                Bundle bundle = (Bundle) parcelable;
                setMode(Mode.mapIntToValue(bundle.getInt("ptr_mode", 0)));
                this.i = Mode.mapIntToValue(bundle.getInt("ptr_current_mode", 0));
                this.m = bundle.getBoolean("ptr_disable_scrolling", false);
                this.l = bundle.getBoolean("ptr_show_refreshing_view", true);
                super.onRestoreInstanceState(bundle.getParcelable("ptr_super"));
                State mapIntToValue = State.mapIntToValue(bundle.getInt("ptr_state", 0));
                if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                    A(mapIntToValue, true);
                }
                r(bundle);
                return;
            }
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            Bundle bundle = new Bundle();
            s(bundle);
            bundle.putInt("ptr_state", this.g.getIntValue());
            bundle.putInt("ptr_mode", this.h.getIntValue());
            bundle.putInt("ptr_current_mode", this.i.getIntValue());
            bundle.putBoolean("ptr_disable_scrolling", this.m);
            bundle.putBoolean("ptr_show_refreshing_view", this.l);
            bundle.putParcelable("ptr_super", super.onSaveInstanceState());
            return bundle;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048614, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            y();
            z(i, i2);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, motionEvent)) == null) {
            if (m()) {
                if (this.m || !q()) {
                    if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
                        int action = motionEvent.getAction();
                        if (action != 0) {
                            if (action != 1) {
                                if (action == 2) {
                                    if (this.f) {
                                        this.c = motionEvent.getY();
                                        this.b = motionEvent.getX();
                                        x();
                                        return true;
                                    }
                                }
                            }
                            if (this.f) {
                                this.f = false;
                                if (this.g == State.RELEASE_TO_REFRESH && (this.t != null || this.u != null)) {
                                    A(State.REFRESHING, true);
                                    return true;
                                } else if (q()) {
                                    B(0);
                                    return true;
                                } else {
                                    A(State.RESET, new boolean[0]);
                                    return true;
                                }
                            }
                        } else if (n()) {
                            float y = motionEvent.getY();
                            this.e = y;
                            this.c = y;
                            float x = motionEvent.getX();
                            this.d = x;
                            this.b = x;
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

    public abstract boolean p();

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            State state = this.g;
            return state == State.REFRESHING || state == State.MANUAL_REFRESHING;
        }
        return invokeV.booleanValue;
    }

    public void r(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
        }
    }

    public void s(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bundle) == null) {
        }
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            setScrollingWhileRefreshingEnabled(!z);
        }
    }

    public final void setFilterTouchEvents(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.n = z;
        }
    }

    public final void setHeaderScroll(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            int maximumPullScroll = getMaximumPullScroll();
            int min = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i));
            if (this.o) {
                if (min < 0) {
                    this.r.setVisibility(0);
                } else if (min > 0) {
                    this.s.setVisibility(0);
                } else {
                    this.r.setVisibility(4);
                    this.s.setVisibility(4);
                }
            }
            int i2 = c.a[getPullToRefreshScrollDirection().ordinal()];
            if (i2 == 1) {
                scrollTo(min, 0);
            } else if (i2 != 2) {
            } else {
                scrollTo(0, min);
            }
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, charSequence) == null) {
            getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
        }
    }

    public void setLoadingDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, drawable) == null) {
            getLoadingLayoutProxy().setLoadingDrawable(drawable);
        }
    }

    @Override // android.view.View
    public void setLongClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            getRefreshableView().setLongClickable(z);
        }
    }

    public final void setMode(Mode mode) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, mode) == null) || mode == this.h) {
            return;
        }
        this.h = mode;
        F();
    }

    public void setOnPullEventListener(d<T> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, dVar) == null) {
            this.v = dVar;
        }
    }

    public final void setOnRefreshListener(f<T> fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, fVar) == null) {
            this.t = fVar;
            this.u = null;
        }
    }

    public void setPullLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, charSequence) == null) {
            getLoadingLayoutProxy().setPullLabel(charSequence);
        }
    }

    public final void setPullToRefreshEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            setMode(z ? Mode.getDefault() : Mode.DISABLED);
        }
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
        }
    }

    public final void setRefreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            setRefreshing(true);
        }
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, charSequence) == null) {
            getLoadingLayoutProxy().setRefreshingLabel(charSequence);
        }
    }

    public void setReleaseLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, charSequence) == null) {
            setReleaseLabel(charSequence, Mode.BOTH);
        }
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, interpolator) == null) {
            this.p = interpolator;
        }
    }

    public final void setScrollingWhileRefreshingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.m = z;
        }
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.l = z;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            int i = c.c[this.i.ordinal()];
            if (i == 1) {
                this.s.d();
            } else if (i != 2) {
            } else {
                this.r.d();
            }
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            if (this.h.showHeaderLoadingLayout()) {
                this.r.f();
            }
            if (this.h.showFooterLoadingLayout()) {
                this.s.f();
            }
            if (z) {
                if (this.l) {
                    a aVar = new a(this);
                    int i = c.c[this.i.ordinal()];
                    if (i != 1 && i != 3) {
                        E(-getHeaderSize(), aVar);
                        return;
                    } else {
                        E(getFooterSize(), aVar);
                        return;
                    }
                }
                B(0);
                return;
            }
            f();
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            int i = c.c[this.i.ordinal()];
            if (i == 1) {
                this.s.h();
            } else if (i != 2) {
            } else {
                this.r.h();
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            this.f = false;
            this.o = true;
            this.r.j();
            this.s.j();
            B(0);
        }
    }

    public final void x() {
        float f2;
        float f3;
        int round;
        int footerSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            if (c.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                f2 = this.e;
                f3 = this.c;
            } else {
                f2 = this.d;
                f3 = this.b;
            }
            if (c.c[this.i.ordinal()] != 1) {
                round = Math.round(Math.min(f2 - f3, 0.0f) / 2.0f);
                footerSize = getHeaderSize();
            } else {
                round = Math.round(Math.max(f2 - f3, 0.0f) / 2.0f);
                footerSize = getFooterSize();
            }
            setHeaderScroll(round);
            if (round == 0 || q()) {
                return;
            }
            float abs = Math.abs(round) / footerSize;
            if (c.c[this.i.ordinal()] != 1) {
                this.r.b(abs);
            } else {
                this.s.b(abs);
            }
            if (this.g != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                A(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.g != State.PULL_TO_REFRESH || footerSize >= Math.abs(round)) {
            } else {
                A(State.RELEASE_TO_REFRESH, new boolean[0]);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            int maximumPullScroll = (int) (getMaximumPullScroll() * 1.2f);
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingRight = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            int i = c.a[getPullToRefreshScrollDirection().ordinal()];
            if (i == 1) {
                if (this.h.showHeaderLoadingLayout()) {
                    this.r.setWidth(maximumPullScroll);
                    paddingLeft = -maximumPullScroll;
                } else {
                    paddingLeft = 0;
                }
                if (this.h.showFooterLoadingLayout()) {
                    this.s.setWidth(maximumPullScroll);
                    paddingRight = -maximumPullScroll;
                } else {
                    paddingRight = 0;
                }
            } else if (i == 2) {
                if (this.h.showHeaderLoadingLayout()) {
                    this.r.setHeight(maximumPullScroll);
                    paddingTop = -maximumPullScroll;
                } else {
                    paddingTop = 0;
                }
                if (this.h.showFooterLoadingLayout()) {
                    this.s.setHeight(maximumPullScroll);
                    paddingBottom = -maximumPullScroll;
                } else {
                    paddingBottom = 0;
                }
            }
            setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        }
    }

    public final void z(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048650, this, i, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            int i3 = c.a[getPullToRefreshScrollDirection().ordinal()];
            if (i3 != 1) {
                if (i3 == 2 && layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.k.requestLayout();
                }
            } else if (layoutParams.width != i) {
                layoutParams.width = i;
                this.k.requestLayout();
            }
        }
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, drawable, mode) == null) {
            j(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
        }
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, charSequence, mode) == null) {
            j(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
        }
    }

    public final void setRefreshing(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048636, this, z) == null) || q()) {
            return;
        }
        A(State.MANUAL_REFRESHING, z);
    }

    public void setRefreshingLabel(CharSequence charSequence, Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048638, this, charSequence, mode) == null) {
            j(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
        }
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, charSequence, mode) == null) {
            j(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
        }
    }

    public final void setOnRefreshListener(e<T> eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, eVar) == null) {
            this.u = eVar;
            this.t = null;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = State.RESET;
        this.h = Mode.getDefault();
        this.l = true;
        this.m = false;
        this.n = true;
        this.o = true;
        this.q = AnimationStyle.getDefault();
        l(context, attributeSet);
    }
}

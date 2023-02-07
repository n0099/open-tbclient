package com.baidu.tieba.danmu.data.state;

import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.of6;
import com.baidu.tieba.uh6;
import com.baidu.tieba.wf6;
import com.baidu.tieba.wh6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapWithDefaultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010_\u001a\u00020<2\u0006\u0010+\u001a\u00020\nJ\b\u0010`\u001a\u00020*H\u0002J\u0006\u0010a\u001a\u00020*J\b\u0010b\u001a\u00020*H\u0016J\u0006\u0010c\u001a\u00020*J\b\u0010d\u001a\u00020\u001eH\u0016J\u0010\u0010e\u001a\u00020*2\u0006\u0010f\u001a\u00020JH\u0002J\u0010\u0010g\u001a\u00020*2\u0006\u00107\u001a\u000208H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u0018\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\n0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u001f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR+\u0010$\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0011\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020*0)X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010+\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0011\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR+\u0010/\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010#\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR+\u00103\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010#\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u0016\u00107\u001a\u0002088@X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010=\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010#\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR+\u0010A\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010#\u001a\u0004\bB\u0010\u0006\"\u0004\bC\u0010\bR+\u0010E\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010#\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u0016\u0010I\u001a\u00020J8@X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010N\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bQ\u0010#\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR+\u0010R\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bU\u0010#\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR\u001a\u0010V\u001a\u00020<X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR+\u0010[\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b^\u0010#\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\b¨\u0006h"}, d2 = {"Lcom/baidu/tieba/danmu/data/state/DrawState;", "Lcom/baidu/tieba/danmu/data/state/State;", "()V", Key.ALPHA, "", "getAlpha", "()F", "setAlpha", "(F)V", "<set-?>", "", "cacheGeneration", "getCacheGeneration", "()I", "setCacheGeneration", "(I)V", "cacheGeneration$delegate", "Ljava/util/Map;", "drawingCache", "Lcom/baidu/tieba/danmu/cache/DrawingCache;", "getDrawingCache", "()Lcom/baidu/tieba/danmu/cache/DrawingCache;", "setDrawingCache", "(Lcom/baidu/tieba/danmu/cache/DrawingCache;)V", "generation", "getGeneration", "setGeneration", "generation$delegate", "generationMap", "", "", "height", "getHeight", "setHeight", "height$delegate", "Lcom/baidu/tieba/danmu/utils/ChangeObserverDelegate;", "layoutGeneration", "getLayoutGeneration", "setLayoutGeneration", "layoutGeneration$delegate", "marker", "Lkotlin/Function1;", "", "measureGeneration", "getMeasureGeneration", "setMeasureGeneration", "measureGeneration$delegate", "positionX", "getPositionX", "setPositionX", "positionX$delegate", "positionY", "getPositionY", "setPositionY", "positionY$delegate", "rect", "Landroid/graphics/RectF;", "getRect$danmu_release", "()Landroid/graphics/RectF;", "rectDirty", "", "rotation", "getRotation", "setRotation", "rotation$delegate", Key.SCALE_X, "getScaleX", "setScaleX", "scaleX$delegate", Key.SCALE_Y, "getScaleY", "setScaleY", "scaleY$delegate", "transform", "Landroid/graphics/Matrix;", "getTransform$danmu_release", "()Landroid/graphics/Matrix;", "transformDirty", "translateX", "getTranslateX", "setTranslateX", "translateX$delegate", "translateY", "getTranslateY", "setTranslateY", "translateY$delegate", "visibility", "getVisibility", "()Z", "setVisibility", "(Z)V", "width", "getWidth", "setWidth", "width$delegate", "isMeasured", "markDirty", "recycle", "reset", "resetActionProperty", "toString", "updateMatrix", "matrix", "updateRect", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class DrawState extends wf6 {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ KProperty<Object>[] u;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final RectF b;
    public boolean c;
    public final Matrix d;
    public final Map<String, Integer> e;
    public final Map f;
    public final Map g;
    public final Map h;
    public final Function1<Float, Unit> i;
    public of6 j;
    public boolean k;
    public final uh6 l;
    public final uh6 m;
    public final uh6 n;
    public final uh6 o;
    public final uh6 p;
    public final uh6 q;
    public final uh6 r;
    public final uh6 s;
    public final uh6 t;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-593349331, "Lcom/baidu/tieba/danmu/data/state/DrawState;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-593349331, "Lcom/baidu/tieba/danmu/data/state/DrawState;");
                return;
            }
        }
        u = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(DrawState.class, "layoutGeneration", "getLayoutGeneration()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DrawState.class, "measureGeneration", "getMeasureGeneration()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DrawState.class, "cacheGeneration", "getCacheGeneration()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DrawState.class, "generation", "getGeneration()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DrawState.class, "positionX", "getPositionX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DrawState.class, "positionY", "getPositionY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DrawState.class, "width", "getWidth()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DrawState.class, "height", "getHeight()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DrawState.class, "translateX", "getTranslateX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DrawState.class, "translateY", "getTranslateY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DrawState.class, Key.SCALE_X, "getScaleX()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DrawState.class, Key.SCALE_Y, "getScaleY()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(DrawState.class, "rotation", "getRotation()F", 0))};
    }

    public DrawState() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new RectF();
        this.d = new Matrix();
        Map<String, Integer> withDefaultMutable = MapsKt__MapWithDefaultKt.withDefaultMutable(new LinkedHashMap(), DrawState$generationMap$1.INSTANCE);
        this.e = withDefaultMutable;
        this.f = withDefaultMutable;
        this.g = withDefaultMutable;
        this.h = withDefaultMutable;
        this.i = new Function1<Float, Unit>(this) { // from class: com.baidu.tieba.danmu.data.state.DrawState$marker$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DrawState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                invoke(f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) != null) {
                    return;
                }
                this.this$0.s();
            }
        };
        this.j = of6.f.a();
        Float valueOf = Float.valueOf(0.0f);
        this.l = wh6.a(valueOf, this.i);
        this.m = wh6.a(valueOf, this.i);
        this.n = wh6.a(valueOf, this.i);
        this.o = wh6.a(valueOf, this.i);
        this.p = wh6.a(valueOf, this.i);
        this.q = wh6.a(valueOf, this.i);
        Float valueOf2 = Float.valueOf(1.0f);
        this.r = wh6.a(valueOf2, this.i);
        this.s = wh6.a(valueOf2, this.i);
        this.t = wh6.a(valueOf, this.i);
    }

    public final void A(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
            this.l.setValue(this, u[4], Float.valueOf(f));
        }
    }

    public final void B(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
            this.m.setValue(this, u[5], Float.valueOf(f));
        }
    }

    public final void C(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
            this.t.setValue(this, u[12], Float.valueOf(f));
        }
    }

    public final void D(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            this.r.setValue(this, u[10], Float.valueOf(f));
        }
    }

    public final void E(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f) == null) {
            this.s.setValue(this, u[11], Float.valueOf(f));
        }
    }

    public final void F(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
            this.p.setValue(this, u[8], Float.valueOf(f));
        }
    }

    public final void G(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            this.q.setValue(this, u[9], Float.valueOf(f));
        }
    }

    public final void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.k = z;
        }
    }

    public final void I(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f) == null) {
            this.n.setValue(this, u[6], Float.valueOf(f));
        }
    }

    public final void K(RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rectF) == null) {
            this.a = false;
            rectF.set(g(), h(), g() + q(), h() + d());
        }
    }

    public final boolean r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
            if (q() > 0.0f && d() > 0.0f && f() == i) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            Map map = this.h;
            KProperty<Object> kProperty = u[2];
            map.put(kProperty.getName(), Integer.valueOf(i));
        }
    }

    public final void w(of6 of6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, of6Var) == null) {
            Intrinsics.checkNotNullParameter(of6Var, "<set-?>");
            this.j = of6Var;
        }
    }

    public final void x(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048610, this, f) == null) {
            this.o.setValue(this, u[7], Float.valueOf(f));
        }
    }

    public final void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            Map map = this.f;
            KProperty<Object> kProperty = u[0];
            map.put(kProperty.getName(), Integer.valueOf(i));
        }
    }

    public final void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            Map map = this.g;
            KProperty<Object> kProperty = u[1];
            map.put(kProperty.getName(), Integer.valueOf(i));
        }
    }

    public final void J(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, matrix) == null) {
            this.c = false;
            matrix.reset();
            matrix.setScale(k(), l());
            matrix.postRotate(j());
            matrix.postTranslate(g() + n(), h() + o());
        }
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return ((Number) MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(this.h, u[2].getName())).intValue();
        }
        return invokeV.intValue;
    }

    public final of6 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.j;
        }
        return (of6) invokeV.objValue;
    }

    public final float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return ((Number) this.o.getValue(this, u[7])).floatValue();
        }
        return invokeV.floatValue;
    }

    public final int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return ((Number) MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(this.f, u[0].getName())).intValue();
        }
        return invokeV.intValue;
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return ((Number) MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(this.g, u[1].getName())).intValue();
        }
        return invokeV.intValue;
    }

    public final float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return ((Number) this.l.getValue(this, u[4])).floatValue();
        }
        return invokeV.floatValue;
    }

    public final float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return ((Number) this.m.getValue(this, u[5])).floatValue();
        }
        return invokeV.floatValue;
    }

    public final RectF i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.a) {
                K(this.b);
            }
            return this.b;
        }
        return (RectF) invokeV.objValue;
    }

    public final float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return ((Number) this.t.getValue(this, u[12])).floatValue();
        }
        return invokeV.floatValue;
    }

    public final float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return ((Number) this.r.getValue(this, u[10])).floatValue();
        }
        return invokeV.floatValue;
    }

    public final float l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return ((Number) this.s.getValue(this, u[11])).floatValue();
        }
        return invokeV.floatValue;
    }

    public final Matrix m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.c) {
                J(this.d);
            }
            return this.d;
        }
        return (Matrix) invokeV.objValue;
    }

    public final float n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return ((Number) this.p.getValue(this, u[8])).floatValue();
        }
        return invokeV.floatValue;
    }

    public final float o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return ((Number) this.q.getValue(this, u[9])).floatValue();
        }
        return invokeV.floatValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public final float q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return ((Number) this.n.getValue(this, u[6])).floatValue();
        }
        return invokeV.floatValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.c = true;
            this.a = true;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            F(0.0f);
            G(0.0f);
            D(1.0f);
            E(1.0f);
            C(0.0f);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            if (!Intrinsics.areEqual(this.j, of6.f.a())) {
                this.j.d();
            }
            this.j = of6.f.a();
            y(-1);
            v(-1);
            this.k = false;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return "DrawState[measure: " + f() + ", layout: " + e() + ']';
        }
        return (String) invokeV.objValue;
    }
}

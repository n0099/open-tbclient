package com.baidu.tbadk.graphic;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ql5;
import com.baidu.tieba.rl5;
import com.baidu.tieba.zl5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes4.dex */
public abstract class FrameAnimationDrawable<Decoder extends ql5<?, ?>> extends Drawable implements Animatable2Compat, rl5 {
    public static /* synthetic */ Interceptable $ic;
    public static final String l;
    public transient /* synthetic */ FieldHolder $fh;
    public final Paint a;
    public final Decoder b;
    public final DrawFilter c;
    public final Matrix d;
    public final Set<Animatable2Compat.AnimationCallback> e;
    public Bitmap f;
    public final Handler g;
    public final Runnable h;
    public boolean i;
    public final Set<WeakReference<Drawable.Callback>> j;
    public boolean k;

    public abstract Decoder d(zl5 zl5Var, rl5 rl5Var);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrameAnimationDrawable a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(FrameAnimationDrawable frameAnimationDrawable, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frameAnimationDrawable, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frameAnimationDrawable;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        Iterator it = new ArrayList(this.a.e).iterator();
                        while (it.hasNext()) {
                            ((Animatable2Compat.AnimationCallback) it.next()).onAnimationEnd(this.a);
                        }
                        return;
                    }
                    return;
                }
                Iterator it2 = new ArrayList(this.a.e).iterator();
                while (it2.hasNext()) {
                    ((Animatable2Compat.AnimationCallback) it2.next()).onAnimationStart(this.a);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrameAnimationDrawable a;

        public b(FrameAnimationDrawable frameAnimationDrawable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frameAnimationDrawable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frameAnimationDrawable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.invalidateSelf();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1873344164, "Lcom/baidu/tbadk/graphic/FrameAnimationDrawable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1873344164, "Lcom/baidu/tbadk/graphic/FrameAnimationDrawable;");
                return;
            }
        }
        l = FrameAnimationDrawable.class.getSimpleName();
    }

    @Override // com.baidu.tieba.rl5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Message.obtain(this.g, 2).sendToTarget();
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.clear();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.b.o(this);
            if (this.i) {
                this.b.M();
            } else if (!this.b.D()) {
                this.b.M();
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.I(this);
            if (this.i) {
                this.b.O();
            } else {
                this.b.P();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.Callback getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return super.getCallback();
        }
        return (Drawable.Callback) invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.k) {
                return -1;
            }
            try {
                return this.b.r().height();
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.k) {
                return -1;
            }
            try {
                return this.b.r().width();
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeV.intValue;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.b.D();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.rl5
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Message.obtain(this.g, 1).sendToTarget();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.b.D()) {
                this.b.O();
            }
            this.b.K();
            f();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            g();
        }
    }

    public FrameAnimationDrawable(zl5 zl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zl5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new Paint();
        this.c = new PaintFlagsDrawFilter(0, 3);
        this.d = new Matrix();
        this.e = new HashSet();
        this.g = new a(this, Looper.getMainLooper());
        this.h = new b(this);
        this.i = true;
        this.j = new HashSet();
        this.k = false;
        this.a.setAntiAlias(true);
        this.b = d(zl5Var, this);
    }

    @Override // com.baidu.tieba.rl5
    public void b(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) != null) || !isRunning()) {
            return;
        }
        Bitmap bitmap = this.f;
        if (bitmap == null || bitmap.isRecycled()) {
            this.f = Bitmap.createBitmap(this.b.r().width() / this.b.y(), this.b.r().height() / this.b.y(), Bitmap.Config.ARGB_8888);
        }
        byteBuffer.rewind();
        if (byteBuffer.remaining() < this.f.getByteCount()) {
            Log.e(l, "onRender:Buffer not large enough for pixels");
            return;
        }
        this.f.copyPixelsFromBuffer(byteBuffer);
        this.g.post(this.h);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) && (bitmap = this.f) != null && !bitmap.isRecycled()) {
            canvas.setDrawFilter(this.c);
            canvas.drawBitmap(this.f, this.d, this.a);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, animationCallback) == null) {
            this.e.add(animationCallback);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.a.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, colorFilter) == null) {
            this.a.setColorFilter(colorFilter);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, animationCallback)) == null) {
            return this.e.remove(animationCallback);
        }
        return invokeL.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ArrayList<WeakReference> arrayList = new ArrayList();
            Drawable.Callback callback = getCallback();
            boolean z = false;
            for (WeakReference weakReference : new HashSet(this.j)) {
                Drawable.Callback callback2 = (Drawable.Callback) weakReference.get();
                if (callback2 == null) {
                    arrayList.add(weakReference);
                } else if (callback2 == callback) {
                    z = true;
                } else {
                    callback2.invalidateDrawable(this);
                }
            }
            for (WeakReference weakReference2 : arrayList) {
                this.j.remove(weakReference2);
            }
            if (!z) {
                this.j.add(new WeakReference<>(callback));
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.invalidateSelf();
            for (WeakReference weakReference : new HashSet(this.j)) {
                Drawable.Callback callback = (Drawable.Callback) weakReference.get();
                if (callback != null && callback != getCallback()) {
                    callback.invalidateDrawable(this);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048593, this, i, i2, i3, i4) == null) {
            super.setBounds(i, i2, i3, i4);
            boolean L = this.b.L(getBounds().width(), getBounds().height());
            this.d.setScale(((getBounds().width() * 1.0f) * this.b.y()) / this.b.r().width(), ((getBounds().height() * 1.0f) * this.b.y()) / this.b.r().height());
            if (L) {
                this.f = Bitmap.createBitmap(this.b.r().width() / this.b.y(), this.b.r().height() / this.b.y(), Bitmap.Config.ARGB_8888);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            e();
            if (this.i) {
                if (z) {
                    if (!isRunning()) {
                        f();
                    }
                } else if (isRunning()) {
                    g();
                }
            }
            return super.setVisible(z, z2);
        }
        return invokeCommon.booleanValue;
    }
}

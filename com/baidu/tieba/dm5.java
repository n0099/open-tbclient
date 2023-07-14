package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class dm5 extends qm5<nm5, om5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public om5 v;
    public int w;
    public final Paint x;
    public final b y;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte a;
        public Rect b;
        public ByteBuffer c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new Rect();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dm5(zm5 zm5Var, rm5 rm5Var) {
        super(zm5Var, rm5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zm5Var, rm5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((zm5) objArr2[0], (rm5) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = new Paint();
        this.y = new b(null);
        this.x.setAntiAlias(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qm5
    /* renamed from: Q */
    public nm5 x(vm5 vm5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, vm5Var)) == null) {
            return new nm5(vm5Var);
        }
        return (nm5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qm5
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.y.c = null;
            this.v = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qm5
    /* renamed from: R */
    public om5 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.v == null) {
                this.v = new om5();
            }
            return this.v;
        }
        return (om5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qm5
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qm5
    public void J(pm5<nm5, om5> pm5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pm5Var) == null) && pm5Var != null && this.o != null) {
            try {
                Bitmap E = E(this.o.width() / this.j, this.o.height() / this.j);
                Canvas canvas = this.m.get(E);
                if (canvas == null) {
                    canvas = new Canvas(E);
                    this.m.put(E, canvas);
                }
                Canvas canvas2 = canvas;
                if (pm5Var instanceof em5) {
                    this.n.rewind();
                    E.copyPixelsFromBuffer(this.n);
                    if (this.d == 0) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else {
                        canvas2.save();
                        canvas2.clipRect(this.y.b);
                        byte b2 = this.y.a;
                        if (b2 != 1) {
                            if (b2 == 2) {
                                this.y.c.rewind();
                                E.copyPixelsFromBuffer(this.y.c);
                            }
                        } else {
                            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                        }
                        canvas2.restore();
                    }
                    if (((em5) pm5Var).j == 2 && this.y.a != 2) {
                        this.y.c.rewind();
                        E.copyPixelsToBuffer(this.y.c);
                    }
                    this.y.a = ((em5) pm5Var).j;
                    canvas2.save();
                    if (((em5) pm5Var).i == 0) {
                        canvas2.clipRect(pm5Var.d / this.j, pm5Var.e / this.j, (pm5Var.d + pm5Var.b) / this.j, (pm5Var.e + pm5Var.c) / this.j);
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    }
                    this.y.b.set(pm5Var.d / this.j, pm5Var.e / this.j, (pm5Var.d + pm5Var.b) / this.j, (pm5Var.e + pm5Var.c) / this.j);
                    canvas2.restore();
                }
                Bitmap E2 = E(pm5Var.b, pm5Var.c);
                G(pm5Var.a(canvas2, this.x, this.j, E2, z()));
                G(E2);
                this.n.rewind();
                E.copyPixelsToBuffer(this.n);
                G(E);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qm5
    /* renamed from: S */
    public Rect F(nm5 nm5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, nm5Var)) == null) {
            List<gm5> a2 = fm5.a(nm5Var);
            ArrayList arrayList = new ArrayList();
            byte[] bArr = new byte[0];
            Iterator<gm5> it = a2.iterator();
            em5 em5Var = null;
            boolean z = false;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                gm5 next = it.next();
                if (next instanceof cm5) {
                    this.w = ((cm5) next).c;
                    z = true;
                } else if (next instanceof hm5) {
                    em5Var = new em5(nm5Var, (hm5) next);
                    em5Var.m = arrayList;
                    em5Var.k = bArr;
                    this.c.add(em5Var);
                } else if (next instanceof im5) {
                    if (em5Var != null) {
                        em5Var.l.add(next);
                    }
                } else if (next instanceof jm5) {
                    if (!z) {
                        mm5 mm5Var = new mm5(nm5Var);
                        mm5Var.b = i;
                        mm5Var.c = i2;
                        this.c.add(mm5Var);
                        this.w = 1;
                        break;
                    } else if (em5Var != null) {
                        em5Var.l.add(next);
                    }
                } else if (next instanceof lm5) {
                    lm5 lm5Var = (lm5) next;
                    i = lm5Var.c;
                    i2 = lm5Var.d;
                    bArr = lm5Var.e;
                } else if (!(next instanceof km5)) {
                    arrayList.add(next);
                }
            }
            int i3 = i * i2;
            int i4 = this.j;
            this.n = ByteBuffer.allocate(((i3 / (i4 * i4)) + 1) * 4);
            b bVar = this.y;
            int i5 = this.j;
            bVar.c = ByteBuffer.allocate(((i3 / (i5 * i5)) + 1) * 4);
            return new Rect(0, 0, i, i2);
        }
        return (Rect) invokeL.objValue;
    }
}

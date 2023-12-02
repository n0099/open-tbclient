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
public class fi5 extends si5<pi5, qi5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qi5 v;
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
    public fi5(bj5 bj5Var, ti5 ti5Var) {
        super(bj5Var, ti5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bj5Var, ti5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((bj5) objArr2[0], (ti5) objArr2[1]);
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
    @Override // com.baidu.tieba.si5
    /* renamed from: Q */
    public pi5 x(xi5 xi5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, xi5Var)) == null) {
            return new pi5(xi5Var);
        }
        return (pi5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.si5
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.y.c = null;
            this.v = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.si5
    /* renamed from: R */
    public qi5 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.v == null) {
                this.v = new qi5();
            }
            return this.v;
        }
        return (qi5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.si5
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.si5
    public void J(ri5<pi5, qi5> ri5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ri5Var) == null) && ri5Var != null && this.o != null) {
            try {
                Bitmap E = E(this.o.width() / this.j, this.o.height() / this.j);
                Canvas canvas = this.m.get(E);
                if (canvas == null) {
                    canvas = new Canvas(E);
                    this.m.put(E, canvas);
                }
                Canvas canvas2 = canvas;
                if (ri5Var instanceof gi5) {
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
                    if (((gi5) ri5Var).j == 2 && this.y.a != 2) {
                        this.y.c.rewind();
                        E.copyPixelsToBuffer(this.y.c);
                    }
                    this.y.a = ((gi5) ri5Var).j;
                    canvas2.save();
                    if (((gi5) ri5Var).i == 0) {
                        canvas2.clipRect(ri5Var.d / this.j, ri5Var.e / this.j, (ri5Var.d + ri5Var.b) / this.j, (ri5Var.e + ri5Var.c) / this.j);
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    }
                    this.y.b.set(ri5Var.d / this.j, ri5Var.e / this.j, (ri5Var.d + ri5Var.b) / this.j, (ri5Var.e + ri5Var.c) / this.j);
                    canvas2.restore();
                }
                Bitmap E2 = E(ri5Var.b, ri5Var.c);
                G(ri5Var.a(canvas2, this.x, this.j, E2, z()));
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
    @Override // com.baidu.tieba.si5
    /* renamed from: S */
    public Rect F(pi5 pi5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pi5Var)) == null) {
            List<ii5> a2 = hi5.a(pi5Var);
            ArrayList arrayList = new ArrayList();
            byte[] bArr = new byte[0];
            Iterator<ii5> it = a2.iterator();
            gi5 gi5Var = null;
            boolean z = false;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ii5 next = it.next();
                if (next instanceof ei5) {
                    this.w = ((ei5) next).c;
                    z = true;
                } else if (next instanceof ji5) {
                    gi5Var = new gi5(pi5Var, (ji5) next);
                    gi5Var.m = arrayList;
                    gi5Var.k = bArr;
                    this.c.add(gi5Var);
                } else if (next instanceof ki5) {
                    if (gi5Var != null) {
                        gi5Var.l.add(next);
                    }
                } else if (next instanceof li5) {
                    if (!z) {
                        oi5 oi5Var = new oi5(pi5Var);
                        oi5Var.b = i;
                        oi5Var.c = i2;
                        this.c.add(oi5Var);
                        this.w = 1;
                        break;
                    } else if (gi5Var != null) {
                        gi5Var.l.add(next);
                    }
                } else if (next instanceof ni5) {
                    ni5 ni5Var = (ni5) next;
                    i = ni5Var.c;
                    i2 = ni5Var.d;
                    bArr = ni5Var.e;
                } else if (!(next instanceof mi5)) {
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

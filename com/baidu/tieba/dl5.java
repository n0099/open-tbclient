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
public class dl5 extends ql5<nl5, ol5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ol5 v;
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
    public dl5(zl5 zl5Var, rl5 rl5Var) {
        super(zl5Var, rl5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zl5Var, rl5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((zl5) objArr2[0], (rl5) objArr2[1]);
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
    @Override // com.baidu.tieba.ql5
    /* renamed from: Q */
    public nl5 x(vl5 vl5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, vl5Var)) == null) {
            return new nl5(vl5Var);
        }
        return (nl5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ql5
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.y.c = null;
            this.v = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ql5
    /* renamed from: R */
    public ol5 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.v == null) {
                this.v = new ol5();
            }
            return this.v;
        }
        return (ol5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ql5
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ql5
    public void J(pl5<nl5, ol5> pl5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pl5Var) == null) && pl5Var != null && this.o != null) {
            try {
                Bitmap E = E(this.o.width() / this.j, this.o.height() / this.j);
                Canvas canvas = this.m.get(E);
                if (canvas == null) {
                    canvas = new Canvas(E);
                    this.m.put(E, canvas);
                }
                Canvas canvas2 = canvas;
                if (pl5Var instanceof el5) {
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
                    if (((el5) pl5Var).j == 2 && this.y.a != 2) {
                        this.y.c.rewind();
                        E.copyPixelsToBuffer(this.y.c);
                    }
                    this.y.a = ((el5) pl5Var).j;
                    canvas2.save();
                    if (((el5) pl5Var).i == 0) {
                        canvas2.clipRect(pl5Var.d / this.j, pl5Var.e / this.j, (pl5Var.d + pl5Var.b) / this.j, (pl5Var.e + pl5Var.c) / this.j);
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    }
                    this.y.b.set(pl5Var.d / this.j, pl5Var.e / this.j, (pl5Var.d + pl5Var.b) / this.j, (pl5Var.e + pl5Var.c) / this.j);
                    canvas2.restore();
                }
                Bitmap E2 = E(pl5Var.b, pl5Var.c);
                G(pl5Var.a(canvas2, this.x, this.j, E2, z()));
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
    @Override // com.baidu.tieba.ql5
    /* renamed from: S */
    public Rect F(nl5 nl5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, nl5Var)) == null) {
            List<gl5> a2 = fl5.a(nl5Var);
            ArrayList arrayList = new ArrayList();
            byte[] bArr = new byte[0];
            Iterator<gl5> it = a2.iterator();
            el5 el5Var = null;
            boolean z = false;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                gl5 next = it.next();
                if (next instanceof cl5) {
                    this.w = ((cl5) next).c;
                    z = true;
                } else if (next instanceof hl5) {
                    el5Var = new el5(nl5Var, (hl5) next);
                    el5Var.m = arrayList;
                    el5Var.k = bArr;
                    this.c.add(el5Var);
                } else if (next instanceof il5) {
                    if (el5Var != null) {
                        el5Var.l.add(next);
                    }
                } else if (next instanceof jl5) {
                    if (!z) {
                        ml5 ml5Var = new ml5(nl5Var);
                        ml5Var.b = i;
                        ml5Var.c = i2;
                        this.c.add(ml5Var);
                        this.w = 1;
                        break;
                    } else if (el5Var != null) {
                        el5Var.l.add(next);
                    }
                } else if (next instanceof ll5) {
                    ll5 ll5Var = (ll5) next;
                    i = ll5Var.c;
                    i2 = ll5Var.d;
                    bArr = ll5Var.e;
                } else if (!(next instanceof kl5)) {
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

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
/* loaded from: classes6.dex */
public class gg5 extends tg5<qg5, rg5> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rg5 v;
    public int w;
    public final Paint x;
    public final b y;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
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
    public gg5(ch5 ch5Var, ug5 ug5Var) {
        super(ch5Var, ug5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ch5Var, ug5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ch5) objArr2[0], (ug5) objArr2[1]);
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
    @Override // com.baidu.tieba.tg5
    /* renamed from: Q */
    public qg5 x(yg5 yg5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, yg5Var)) == null) {
            return new qg5(yg5Var);
        }
        return (qg5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tg5
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.y.c = null;
            this.v = null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tg5
    /* renamed from: R */
    public rg5 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.v == null) {
                this.v = new rg5();
            }
            return this.v;
        }
        return (rg5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tg5
    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.tg5
    public void J(sg5<qg5, rg5> sg5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sg5Var) == null) && sg5Var != null && this.o != null) {
            try {
                Bitmap E = E(this.o.width() / this.j, this.o.height() / this.j);
                Canvas canvas = this.m.get(E);
                if (canvas == null) {
                    canvas = new Canvas(E);
                    this.m.put(E, canvas);
                }
                Canvas canvas2 = canvas;
                if (sg5Var instanceof hg5) {
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
                    if (((hg5) sg5Var).j == 2 && this.y.a != 2) {
                        this.y.c.rewind();
                        E.copyPixelsToBuffer(this.y.c);
                    }
                    this.y.a = ((hg5) sg5Var).j;
                    canvas2.save();
                    if (((hg5) sg5Var).i == 0) {
                        canvas2.clipRect(sg5Var.d / this.j, sg5Var.e / this.j, (sg5Var.d + sg5Var.b) / this.j, (sg5Var.e + sg5Var.c) / this.j);
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    }
                    this.y.b.set(sg5Var.d / this.j, sg5Var.e / this.j, (sg5Var.d + sg5Var.b) / this.j, (sg5Var.e + sg5Var.c) / this.j);
                    canvas2.restore();
                }
                Bitmap E2 = E(sg5Var.b, sg5Var.c);
                G(sg5Var.a(canvas2, this.x, this.j, E2, z()));
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
    @Override // com.baidu.tieba.tg5
    /* renamed from: S */
    public Rect F(qg5 qg5Var) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, qg5Var)) == null) {
            List<jg5> a2 = ig5.a(qg5Var);
            ArrayList arrayList = new ArrayList();
            byte[] bArr = new byte[0];
            Iterator<jg5> it = a2.iterator();
            hg5 hg5Var = null;
            boolean z = false;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                jg5 next = it.next();
                if (next instanceof fg5) {
                    this.w = ((fg5) next).c;
                    z = true;
                } else if (next instanceof kg5) {
                    hg5Var = new hg5(qg5Var, (kg5) next);
                    hg5Var.m = arrayList;
                    hg5Var.k = bArr;
                    this.c.add(hg5Var);
                } else if (next instanceof lg5) {
                    if (hg5Var != null) {
                        hg5Var.l.add(next);
                    }
                } else if (next instanceof mg5) {
                    if (!z) {
                        pg5 pg5Var = new pg5(qg5Var);
                        pg5Var.b = i;
                        pg5Var.c = i2;
                        this.c.add(pg5Var);
                        this.w = 1;
                        break;
                    } else if (hg5Var != null) {
                        hg5Var.l.add(next);
                    }
                } else if (next instanceof og5) {
                    og5 og5Var = (og5) next;
                    i = og5Var.c;
                    i2 = og5Var.d;
                    bArr = og5Var.e;
                } else if (!(next instanceof ng5)) {
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

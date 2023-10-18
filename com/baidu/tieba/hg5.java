package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
/* loaded from: classes6.dex */
public class hg5 extends sg5<qg5, rg5> {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] n;
    public static final byte[] o;
    public static final ThreadLocal<CRC32> p;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte i;
    public final byte j;
    public byte[] k;
    public List<jg5> l;
    public List<jg5> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947822771, "Lcom/baidu/tieba/hg5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947822771, "Lcom/baidu/tieba/hg5;");
                return;
            }
        }
        n = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        o = new byte[]{0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
        p = new ThreadLocal<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hg5(qg5 qg5Var, kg5 kg5Var) {
        super(qg5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qg5Var, kg5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((yg5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.i = kg5Var.j;
        this.j = kg5Var.i;
        int i3 = kg5Var.g * 1000;
        short s = kg5Var.h;
        int i4 = i3 / (s == 0 ? (short) 100 : s);
        this.f = i4;
        if (i4 < 10) {
            this.f = 100;
        }
        this.b = kg5Var.c;
        this.c = kg5Var.d;
        this.d = kg5Var.e;
        this.e = kg5Var.f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sg5
    /* renamed from: b */
    public Bitmap a(Canvas canvas, Paint paint, int i, Bitmap bitmap, rg5 rg5Var) {
        byte[] bArr;
        Bitmap decodeByteArray;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, paint, Integer.valueOf(i), bitmap, rg5Var})) == null) {
            try {
                int c = c(rg5Var);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = i;
                options.inMutable = true;
                options.inBitmap = bitmap;
                try {
                    decodeByteArray = BitmapFactory.decodeByteArray(rg5Var.f(), 0, c, options);
                } catch (IllegalArgumentException unused) {
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inJustDecodeBounds = false;
                    options2.inSampleSize = i;
                    options2.inMutable = true;
                    decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, c, options2);
                }
                this.g.left = 0;
                this.g.top = 0;
                this.g.right = decodeByteArray.getWidth();
                this.g.bottom = decodeByteArray.getHeight();
                float f = i;
                this.h.left = (int) (this.d / f);
                this.h.top = (int) (this.e / f);
                this.h.right = (int) ((this.d / f) + decodeByteArray.getWidth());
                this.h.bottom = (int) ((this.e / f) + decodeByteArray.getHeight());
                canvas.drawBitmap(decodeByteArray, this.g, this.h, paint);
                return decodeByteArray;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeCommon.objValue;
    }

    public final int c(rg5 rg5Var) throws IOException {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rg5Var)) == null) {
            int i2 = 33;
            for (jg5 jg5Var : this.m) {
                i2 += jg5Var.a + 12;
            }
            for (jg5 jg5Var2 : this.l) {
                if (jg5Var2 instanceof mg5) {
                    i = jg5Var2.a + 12;
                } else if (jg5Var2 instanceof lg5) {
                    i = jg5Var2.a + 8;
                }
                i2 += i;
            }
            int length = i2 + o.length;
            rg5Var.d(length);
            rg5Var.c(n);
            rg5Var.h(13);
            int a = rg5Var.a();
            rg5Var.g(og5.f);
            rg5Var.h(this.b);
            rg5Var.h(this.c);
            rg5Var.c(this.k);
            CRC32 d = d();
            d.reset();
            d.update(rg5Var.f(), a, 17);
            rg5Var.h((int) d.getValue());
            for (jg5 jg5Var3 : this.m) {
                if (!(jg5Var3 instanceof ng5)) {
                    ((qg5) this.a).reset();
                    ((qg5) this.a).skip(jg5Var3.b);
                    ((qg5) this.a).read(rg5Var.f(), rg5Var.a(), jg5Var3.a + 12);
                    rg5Var.e(jg5Var3.a + 12);
                }
            }
            for (jg5 jg5Var4 : this.l) {
                if (jg5Var4 instanceof mg5) {
                    ((qg5) this.a).reset();
                    ((qg5) this.a).skip(jg5Var4.b);
                    ((qg5) this.a).read(rg5Var.f(), rg5Var.a(), jg5Var4.a + 12);
                    rg5Var.e(jg5Var4.a + 12);
                } else if (jg5Var4 instanceof lg5) {
                    rg5Var.h(jg5Var4.a - 4);
                    int a2 = rg5Var.a();
                    rg5Var.g(mg5.c);
                    ((qg5) this.a).reset();
                    ((qg5) this.a).skip(jg5Var4.b + 4 + 4 + 4);
                    ((qg5) this.a).read(rg5Var.f(), rg5Var.a(), jg5Var4.a - 4);
                    rg5Var.e(jg5Var4.a - 4);
                    d.reset();
                    d.update(rg5Var.f(), a2, jg5Var4.a);
                    rg5Var.h((int) d.getValue());
                }
            }
            rg5Var.c(o);
            return length;
        }
        return invokeL.intValue;
    }

    public final CRC32 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            CRC32 crc32 = p.get();
            if (crc32 == null) {
                CRC32 crc322 = new CRC32();
                p.set(crc322);
                return crc322;
            }
            return crc32;
        }
        return (CRC32) invokeV.objValue;
    }
}

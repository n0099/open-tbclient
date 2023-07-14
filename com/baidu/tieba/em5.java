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
/* loaded from: classes5.dex */
public class em5 extends pm5<nm5, om5> {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] n;
    public static final byte[] o;
    public static final ThreadLocal<CRC32> p;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte i;
    public final byte j;
    public byte[] k;
    public List<gm5> l;
    public List<gm5> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947739164, "Lcom/baidu/tieba/em5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947739164, "Lcom/baidu/tieba/em5;");
                return;
            }
        }
        n = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        o = new byte[]{0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
        p = new ThreadLocal<>();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public em5(nm5 nm5Var, hm5 hm5Var) {
        super(nm5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nm5Var, hm5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vm5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.i = hm5Var.j;
        this.j = hm5Var.i;
        int i3 = hm5Var.g * 1000;
        short s = hm5Var.h;
        int i4 = i3 / (s == 0 ? (short) 100 : s);
        this.f = i4;
        if (i4 < 10) {
            this.f = 100;
        }
        this.b = hm5Var.c;
        this.c = hm5Var.d;
        this.d = hm5Var.e;
        this.e = hm5Var.f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm5
    /* renamed from: b */
    public Bitmap a(Canvas canvas, Paint paint, int i, Bitmap bitmap, om5 om5Var) {
        byte[] bArr;
        Bitmap decodeByteArray;
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, paint, Integer.valueOf(i), bitmap, om5Var})) == null) {
            try {
                int c = c(om5Var);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = false;
                options.inSampleSize = i;
                options.inMutable = true;
                options.inBitmap = bitmap;
                try {
                    decodeByteArray = BitmapFactory.decodeByteArray(om5Var.f(), 0, c, options);
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

    public final int c(om5 om5Var) throws IOException {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, om5Var)) == null) {
            int i2 = 33;
            for (gm5 gm5Var : this.m) {
                i2 += gm5Var.a + 12;
            }
            for (gm5 gm5Var2 : this.l) {
                if (gm5Var2 instanceof jm5) {
                    i = gm5Var2.a + 12;
                } else if (gm5Var2 instanceof im5) {
                    i = gm5Var2.a + 8;
                }
                i2 += i;
            }
            int length = i2 + o.length;
            om5Var.d(length);
            om5Var.c(n);
            om5Var.h(13);
            int a = om5Var.a();
            om5Var.g(lm5.f);
            om5Var.h(this.b);
            om5Var.h(this.c);
            om5Var.c(this.k);
            CRC32 d = d();
            d.reset();
            d.update(om5Var.f(), a, 17);
            om5Var.h((int) d.getValue());
            for (gm5 gm5Var3 : this.m) {
                if (!(gm5Var3 instanceof km5)) {
                    ((nm5) this.a).reset();
                    ((nm5) this.a).skip(gm5Var3.b);
                    ((nm5) this.a).read(om5Var.f(), om5Var.a(), gm5Var3.a + 12);
                    om5Var.e(gm5Var3.a + 12);
                }
            }
            for (gm5 gm5Var4 : this.l) {
                if (gm5Var4 instanceof jm5) {
                    ((nm5) this.a).reset();
                    ((nm5) this.a).skip(gm5Var4.b);
                    ((nm5) this.a).read(om5Var.f(), om5Var.a(), gm5Var4.a + 12);
                    om5Var.e(gm5Var4.a + 12);
                } else if (gm5Var4 instanceof im5) {
                    om5Var.h(gm5Var4.a - 4);
                    int a2 = om5Var.a();
                    om5Var.g(jm5.c);
                    ((nm5) this.a).reset();
                    ((nm5) this.a).skip(gm5Var4.b + 4 + 4 + 4);
                    ((nm5) this.a).read(om5Var.f(), om5Var.a(), gm5Var4.a - 4);
                    om5Var.e(gm5Var4.a - 4);
                    d.reset();
                    d.update(om5Var.f(), a2, gm5Var4.a);
                    om5Var.h((int) d.getValue());
                }
            }
            om5Var.c(o);
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

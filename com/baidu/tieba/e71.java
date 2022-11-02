package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.DataEntryUrlBox;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class e71 implements g71<ImageView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, h> c;
    public final Lock d;

    /* loaded from: classes3.dex */
    public interface g {
        void a();

        void b(Bitmap bitmap);
    }

    /* loaded from: classes3.dex */
    public class a implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ e71 c;

        /* renamed from: com.baidu.tieba.e71$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0246a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ a b;

            public RunnableC0246a(a aVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.setImageBitmap(this.a);
                    this.b.a.setBackgroundResource(17170445);
                    a aVar = this.b;
                    if (aVar.b) {
                        aVar.a.setVisibility(0);
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.a;
                    this.a.a.setImageDrawable(aVar.c.l(aVar.a));
                }
            }
        }

        public a(e71 e71Var, ImageView imageView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e71Var, imageView, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e71Var;
            this.a = imageView;
            this.b = z;
        }

        @Override // com.baidu.tieba.e71.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nj0.b(new b(this));
            }
        }

        @Override // com.baidu.tieba.e71.g
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                nj0.b(new RunnableC0246a(this, bitmap));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ e71 d;

        @Override // com.baidu.tieba.e71.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bitmap a;
            public final /* synthetic */ c b;

            public a(c cVar, Bitmap bitmap) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bitmap};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = cVar;
                this.a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.setImageBitmap(this.a);
                    c cVar = this.b;
                    int i = cVar.c;
                    if (i >= 0) {
                        cVar.a.setAlpha(i / 100.0f);
                    }
                }
            }
        }

        public c(e71 e71Var, ImageView imageView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e71Var, imageView, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = e71Var;
            this.a = imageView;
            this.b = i;
            this.c = i2;
        }

        @Override // com.baidu.tieba.e71.g
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) != null) {
                return;
            }
            this.a.post(new a(this, this.d.k(this.a, bitmap, this.b, this.c)));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements br0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ h b;
        public final /* synthetic */ e71 c;

        public b(e71 e71Var, String str, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e71Var, str, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e71Var;
            this.a = str;
            this.b = hVar;
        }

        @Override // com.baidu.tieba.br0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) {
                this.c.d.lock();
                try {
                    this.c.c.remove(this.a);
                    this.b.a();
                } finally {
                    this.c.d.unlock();
                }
            }
        }

        @Override // com.baidu.tieba.br0
        public void c(Headers headers, InputStream inputStream, int i) {
            Bitmap bitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPurgeable = true;
                options.inInputShareable = true;
                Bitmap decodeStream = BitmapFactory.decodeStream(new f(inputStream), null, options);
                if (decodeStream != null) {
                    String str = this.a;
                    if (!str.substring(str.lastIndexOf("/") + 1).toUpperCase().contains("PNG")) {
                        bitmap = e71.p(e71.q(decodeStream, 100 - (this.c.r(decodeStream) * 10)), e71.s(options));
                    } else {
                        bitmap = decodeStream;
                    }
                    if (bitmap != null) {
                        decodeStream = bitmap;
                    }
                    xh0.d().j(this.a, decodeStream);
                    this.c.d.lock();
                    try {
                        this.c.c.remove(this.a);
                        this.b.b(decodeStream);
                        return;
                    } finally {
                    }
                }
                this.c.d.lock();
                try {
                    this.c.c.remove(this.a);
                    this.b.a();
                } finally {
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qn0 a;

        public d(e71 e71Var, qn0 qn0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e71Var, qn0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qn0Var;
        }

        @Override // com.baidu.tieba.e71.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }

        @Override // com.baidu.tieba.e71.g
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.a.b(bitmap);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qn0 a;

        public e(e71 e71Var, qn0 qn0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e71Var, qn0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qn0Var;
        }

        @Override // com.baidu.tieba.e71.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }

        @Override // com.baidu.tieba.e71.g
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.a.b(bitmap);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(InputStream inputStream) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
                long j2 = 0;
                while (j2 < j) {
                    long skip = ((FilterInputStream) this).in.skip(j - j2);
                    if (skip == 0) {
                        if (read() < 0) {
                            break;
                        }
                        skip = 1;
                    }
                    j2 += skip;
                }
                return j2;
            }
            return invokeJ.longValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class h implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final List<g> a;

        public h() {
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
            this.a = new LinkedList();
        }

        @Override // com.baidu.tieba.e71.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (g gVar : this.a) {
                    gVar.a();
                }
            }
        }

        @Override // com.baidu.tieba.e71.g
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                for (g gVar : this.a) {
                    gVar.b(bitmap);
                }
            }
        }

        public void c(@Nullable g gVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) && gVar != null) {
                o01.b(this.a, gVar);
            }
        }
    }

    public e71() {
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
        this.c = new ConcurrentHashMap();
        this.d = new ReentrantLock();
    }

    @Override // com.baidu.tieba.rn0
    public void c(String str, qn0 qn0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, qn0Var) != null) || qn0Var == null) {
            return;
        }
        Bitmap h2 = xh0.d().h(str);
        if (h2 == null) {
            n(str, new e(this, qn0Var));
        } else {
            qn0Var.b(h2);
        }
    }

    @Override // com.baidu.tieba.g71
    public void e(@NonNull String str, qn0 qn0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, qn0Var) == null) {
            Bitmap h2 = xh0.d().h(str);
            if (h2 == null) {
                n(str, new d(this, qn0Var));
            } else {
                qn0Var.b(h2);
            }
        }
    }

    public final void o(String str, @NonNull h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, hVar) == null) {
            kr0 kr0Var = new kr0();
            kr0Var.l(str);
            kr0Var.c();
            rq0.b().a().b(kr0Var, new b(this, str, hVar));
        }
    }

    public static int j(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bitmap)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 19) {
                return bitmap.getAllocationByteCount();
            }
            if (i >= 12) {
                return bitmap.getByteCount();
            }
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
        return invokeL.intValue;
    }

    public static int s(BitmapFactory.Options options) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, options)) == null) {
            int i2 = options.outHeight;
            int i3 = options.outWidth;
            if (i2 <= 1140 && i3 <= 1140) {
                i = 1;
            } else {
                int i4 = 2;
                int i5 = i2 / 2;
                int i6 = i3 / 2;
                while (true) {
                    if (i5 < 1140 && i6 < 1140) {
                        break;
                    }
                    i4 *= 2;
                }
                i = i4;
            }
            if (i > 6) {
                return 6;
            }
            return i;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.rn0
    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || xh0.d().h(str) != null) {
            return;
        }
        n(str, null);
    }

    public int r(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bitmap)) == null) {
            int j = j(bitmap);
            if (j > 2457600) {
                int i = j / 2457600;
                if (i > 6) {
                    return 6;
                }
                return i;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static Bitmap p(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, bitmap, i)) == null) {
            if (i <= 1) {
                return bitmap;
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Matrix matrix = new Matrix();
            float f2 = 1.0f / i;
            matrix.postScale(f2, f2);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        return (Bitmap) invokeLI.objValue;
    }

    public static Bitmap q(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, bitmap, i)) == null) {
            if (i == 100) {
                return bitmap;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            try {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Bitmap) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.g71
    public void a(String str, ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(1048576, this, str, imageView, z) != null) || imageView == null) {
            return;
        }
        Bitmap h2 = xh0.d().h(str);
        if (h2 == null) {
            imageView.setImageDrawable(m(imageView));
            n(str, new a(this, imageView, z));
            return;
        }
        imageView.setImageBitmap(h2);
        imageView.setBackgroundResource(17170445);
        if (z) {
            imageView.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.g71
    public void b(String str, ImageView imageView, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, imageView, i, i2) != null) || imageView == null) {
            return;
        }
        Bitmap h2 = xh0.d().h(str);
        if (h2 == null) {
            n(str, new c(this, imageView, i, i2));
            return;
        }
        imageView.setImageBitmap(k(imageView, h2, i, i2));
        if (i2 >= 0) {
            imageView.setAlpha(i2 / 100.0f);
        }
    }

    public final Bitmap k(View view2, Bitmap bitmap, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048581, this, view2, bitmap, i, i2)) == null) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
            Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
            RenderScript create = RenderScript.create(view2.getContext());
            if (Build.VERSION.SDK_INT >= 17) {
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(i);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
            }
            return createBitmap;
        }
        return (Bitmap) invokeLLII.objValue;
    }

    public final Drawable l(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            if (!(view2 instanceof AdImageView)) {
                return z61.b().a(view2.getContext());
            }
            int i = ((AdImageView) view2).getConfig().c;
            if (i != 0) {
                return view2.getResources().getDrawable(i);
            }
            return z61.b().a(view2.getContext());
        }
        return (Drawable) invokeL.objValue;
    }

    public final Drawable m(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view2)) == null) {
            if (!(view2 instanceof AdImageView)) {
                return z61.b().b(view2.getContext());
            }
            AdImageView adImageView = (AdImageView) view2;
            if (adImageView.getConfig().b != null) {
                return adImageView.getConfig().b;
            }
            int i = adImageView.getConfig().a;
            if (i != 0) {
                return view2.getResources().getDrawable(i);
            }
            return z61.b().b(view2.getContext());
        }
        return (Drawable) invokeL.objValue;
    }

    public final void n(String str, @Nullable g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, gVar) == null) {
            this.d.lock();
            try {
                h hVar = this.c.get(str);
                if (hVar == null) {
                    h hVar2 = new h();
                    this.c.put(str, hVar2);
                    hVar2.c(gVar);
                    o(str, hVar2);
                } else {
                    wj0.a(ImageLoader.TAG, DataEntryUrlBox.TYPE + str + " cached connection!");
                    hVar.c(gVar);
                }
            } finally {
                this.d.unlock();
            }
        }
    }
}

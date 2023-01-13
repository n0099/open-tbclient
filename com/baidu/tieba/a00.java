package com.baidu.tieba;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cesium.i.i;
import com.baidu.tieba.oz;
import com.baidu.tieba.xz;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class a00 extends xz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context f;
    public g g;

    /* loaded from: classes3.dex */
    public static final class a implements Comparable<a> {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] b;
        public transient /* synthetic */ FieldHolder $fh;
        public final int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-999423829, "Lcom/baidu/tieba/a00$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-999423829, "Lcom/baidu/tieba/a00$a;");
                    return;
                }
            }
            b = new String[]{"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};
        }

        public a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        public static a c(byte b2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Byte.valueOf(b2), Boolean.valueOf(z)})) == null) {
                int i = b2 & 255;
                return d(z ? i >> 4 : i & 15);
            }
            return (a) invokeCommon.objValue;
        }

        public static a d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
                if (i < 0 || i >= 16) {
                    throw new IllegalArgumentException("invalid idx " + i);
                }
                return new a(i);
            }
            return (a) invokeI.objValue;
        }

        public byte a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (byte) this.a : invokeV.byteValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: b */
        public int compareTo(a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? this.a - aVar.a : invokeL.intValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? b[this.a] : (String) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return obj != null && a.class == obj.getClass() && this.a == ((a) obj).a;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : invokeV.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Map<a, Integer> a;

        /* loaded from: classes3.dex */
        public class a implements Comparator<Map.Entry<a, Integer>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Map.Entry<a, Integer> entry, Map.Entry<a, Integer> entry2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) {
                    int intValue = entry2.getValue().intValue() - entry.getValue().intValue();
                    return intValue != 0 ? intValue : entry.getKey().compareTo(entry2.getKey());
                }
                return invokeLL.intValue;
            }
        }

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
            this.a = new HashMap();
        }

        public List<a> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList(this.a.entrySet());
                Collections.sort(arrayList, new a(this));
                ArrayList arrayList2 = new ArrayList(6);
                int min = Math.min(6, arrayList.size());
                for (int i = 0; i < min; i++) {
                    Map.Entry entry = (Map.Entry) arrayList.get(i);
                    if (((Integer) entry.getValue()).intValue() > 1) {
                        arrayList2.add(entry.getKey());
                    }
                }
                return arrayList2;
            }
            return (List) invokeV.objValue;
        }

        public void b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                Integer num = this.a.get(aVar);
                this.a.put(aVar, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public a[] a;
        public int b;

        public c(a00 a00Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a00Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new a[33];
        }

        public c(a00 a00Var, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a00Var, bArr};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = new a[33];
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            for (int i3 = 0; i3 < bArr.length; i3++) {
                a c = a.c(bArr[i3], false);
                a c2 = a.c(bArr[i3], true);
                c(c);
                c(c2);
            }
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.intValue;
        }

        public final void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                a[] aVarArr = this.a;
                if (i - aVarArr.length > 0) {
                    int length = aVarArr.length;
                    int i2 = length + (length >> 1);
                    if (i2 - i >= 0) {
                        i = i2;
                    }
                    this.a = (a[]) Arrays.copyOf(this.a, i);
                }
            }
        }

        public void c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                b(this.b + 1);
                a[] aVarArr = this.a;
                int i = this.b;
                this.b = i + 1;
                aVarArr[i] = aVar;
            }
        }

        public a d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                if (i < this.b) {
                    return this.a[i];
                }
                throw new IndexOutOfBoundsException("idx " + i + " size " + this.b);
            }
            return (a) invokeI.objValue;
        }

        public byte[] e() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i2 = 0;
                while (true) {
                    i = this.b;
                    if (i2 >= i / 2) {
                        break;
                    }
                    int i3 = i2 * 2;
                    byteArrayOutputStream.write((byte) (((d(i3 + 1).a() & 255) << 4) | (d(i3).a() & 255)));
                    i2++;
                }
                if (i % 2 != 0) {
                    byteArrayOutputStream.write((byte) (d(i - 1).a() & 255));
                }
                return byteArrayOutputStream.toByteArray();
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<b> a;

        /* loaded from: classes3.dex */
        public class a implements Comparator<b> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(b bVar, b bVar2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, bVar2)) == null) ? bVar.a - bVar2.a : invokeLL.intValue;
            }
        }

        /* loaded from: classes3.dex */
        public static class b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public a b;

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
                this.b = aVar;
            }

            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a++;
                }
            }
        }

        public d() {
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
            this.a = new ArrayList();
        }

        public List<b> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                ArrayList arrayList = new ArrayList(this.a);
                Collections.sort(arrayList, new a(this));
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public void b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.a.add(new b(aVar));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;
        public byte b;
        public byte[] c;
        public boolean d;
        public String e;

        public e(byte[] bArr, byte b, byte[] bArr2, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bArr, Byte.valueOf(b), bArr2, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = "";
            this.a = bArr;
            this.b = b;
            this.c = bArr2;
            this.d = z;
            this.e = str;
        }

        public static e b(oz.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, aVar)) == null) {
                try {
                    byte[] y = a00.y(aVar.n());
                    if (y.length > 16) {
                        return null;
                    }
                    return new e(y, aVar.v().getBytes("UTF-8")[0], aVar.p() != null ? aVar.p().getBytes("UTF-8") : null, aVar.m(), aVar.u());
                } catch (Exception unused) {
                    return null;
                }
            }
            return (e) invokeL.objValue;
        }

        public oz.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    return oz.c(w00.a(this.a, "", true), new String(new byte[]{this.b}, "UTF-8"), this.c != null ? new String(this.c, "UTF-8") : null, this.d, this.e);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (oz.a) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Method a;
        public Method b;
        public Method c;
        public Method d;
        public Method e;

        public g() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int a(Context context, Uri uri, int i, int i2, int i3) throws i.a {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                try {
                    return ((Integer) this.a.invoke(context, uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
                } catch (Exception e) {
                    throw new i.a(e);
                }
            }
            return invokeCommon.intValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.a = com.baidu.cesium.i.i.b(Context.class, com.baidu.cesium.i.i.a(rz.a()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    this.b = com.baidu.cesium.i.i.b(Context.class, com.baidu.cesium.i.i.a(rz.d()), new Class[]{String.class, Uri.class, Integer.TYPE});
                    this.c = com.baidu.cesium.i.i.b(ContentResolver.class, com.baidu.cesium.i.i.a(rz.g()), new Class[]{Uri.class, Integer.TYPE});
                    this.d = com.baidu.cesium.i.i.b(Context.class, com.baidu.cesium.i.i.a(rz.f()), new Class[]{Uri.class, Integer.TYPE});
                    this.e = com.baidu.cesium.i.i.b(ContentResolver.class, com.baidu.cesium.i.i.a(rz.e()), new Class[]{Uri.class, Integer.TYPE});
                } catch (Exception unused) {
                }
            }
        }

        public void c(ContentResolver contentResolver, Uri uri, int i) throws i.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, contentResolver, uri, i) == null) {
                try {
                    this.e.invoke(contentResolver, uri, Integer.valueOf(i));
                } catch (Exception e) {
                    throw new i.a(e);
                }
            }
        }

        public void d(Context context, Uri uri, int i) throws i.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, context, uri, i) == null) {
                try {
                    this.d.invoke(context, uri, Integer.valueOf(i));
                } catch (Exception e) {
                    throw new i.a(e);
                }
            }
        }

        public void e(Context context, String str, Uri uri, int i) throws i.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(1048580, this, context, str, uri, i) == null) {
                try {
                    this.b.invoke(context, str, uri, Integer.valueOf(i));
                } catch (Exception e) {
                    throw new i.a(e);
                }
            }
        }

        public void f(ContentResolver contentResolver, Uri uri, int i) throws i.a {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048581, this, contentResolver, uri, i) == null) {
                try {
                    this.c.invoke(contentResolver, uri, Integer.valueOf(i));
                } catch (Exception e) {
                    throw new i.a(e);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a00() {
        super("upc", 9000000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g gVar = new g();
        this.g = gVar;
        gVar.b();
    }

    public static byte[] y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    int digit = Character.digit(str.charAt(i2), 16);
                    int digit2 = Character.digit(str.charAt(i2 + 1), 16);
                    if (digit == -1 || digit2 == -1) {
                        throw new IllegalArgumentException("input is not hexadecimal");
                    }
                    bArr[i] = (byte) ((digit * 16) + digit2);
                }
                return bArr;
            }
            throw new IllegalArgumentException("Expected a string of even length");
        }
        return (byte[]) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xz
    public xz.f a(xz.e eVar, oz.a aVar) {
        InterceptResult invokeLL;
        e b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, eVar, aVar)) == null) {
            if (Build.VERSION.SDK_INT >= 26 && (b2 = e.b(aVar)) != null) {
                c cVar = new c(this, b2.a);
                cVar.c(a.c(b2.b, false));
                cVar.c(a.c(b2.b, true));
                byte[] bArr = b2.c;
                if (bArr != null) {
                    for (byte b3 : bArr) {
                        cVar.c(a.c(b3, false));
                        cVar.c(a.c(b3, true));
                    }
                }
                b bVar = new b();
                for (int i = 0; i < cVar.a(); i++) {
                    bVar.b(cVar.d(i));
                }
                List<a> a2 = bVar.a();
                if (p(cVar, a2)) {
                    for (int a3 = cVar.a() - 1; a3 >= 0; a3--) {
                        l(a3, cVar.d(a3));
                    }
                    for (a aVar2 : a2) {
                        o(aVar2);
                    }
                    x(oz.n());
                    return xz.f.c();
                }
                return xz.f.c();
            }
            return xz.f.a();
        }
        return (xz.f) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01c2  */
    @Override // com.baidu.tieba.xz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public xz.h b(String str, xz.g gVar) {
        InterceptResult invokeLL;
        int i;
        Byte b2;
        Byte b3;
        boolean z;
        byte[] bArr;
        String str2;
        boolean z2;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, gVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return xz.h.a();
            }
            try {
                i = this.f.getPackageManager().getPackageUid(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                i = -1;
            }
            if (i < 0) {
                return xz.h.a();
            }
            f fVar = new f();
            c cVar2 = new c(this);
            d dVar = new d();
            d dVar2 = new d();
            for (int i2 = 0; i2 < 16; i2++) {
                a d2 = a.d(i2);
                if (s(str, d2, i)) {
                    dVar.b(d2);
                } else {
                    dVar2.b(d2);
                }
            }
            for (int i3 = 0; i3 < 32; i3++) {
                a g2 = g(str, i3, dVar.a(), i, fVar);
                if (g2 == null) {
                    g2 = g(str, i3, dVar2.a(), i, fVar);
                }
                if (g2 == null) {
                    return xz.h.a();
                }
                cVar2.c(g2);
            }
            byte[] e2 = cVar2.e();
            int i4 = 3;
            byte[] bArr2 = {"0".getBytes()[0], "O".getBytes()[0], ExifInterface.GPS_MEASUREMENT_INTERRUPTED.getBytes()[0]};
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    b2 = null;
                    break;
                }
                byte b4 = bArr2[i5];
                a c2 = a.c(b4, false);
                int i6 = i5;
                byte[] bArr3 = bArr2;
                if (r(str, 32, c2, i, fVar)) {
                    a c3 = a.c(b4, true);
                    if (r(str, 33, c3, i, fVar)) {
                        c cVar3 = new c(this);
                        cVar3.c(c2);
                        cVar3.c(c3);
                        b2 = Byte.valueOf(cVar3.e()[0]);
                        break;
                    }
                }
                i5 = i6 + 1;
                bArr2 = bArr3;
                i4 = 3;
            }
            if (b2 == null) {
                c cVar4 = new c(this);
                int i7 = 32;
                for (int i8 = 34; i7 < i8; i8 = 34) {
                    int i9 = i7;
                    c cVar5 = cVar4;
                    a g3 = g(str, i7, dVar.a(), i, fVar);
                    if (g3 == null) {
                        g3 = g(str, i9, dVar2.a(), i, fVar);
                    }
                    if (g3 == null) {
                        return xz.h.a();
                    }
                    cVar5.c(g3);
                    i7 = i9 + 1;
                    cVar4 = cVar5;
                }
                b3 = Byte.valueOf(cVar4.e()[0]);
                z = true;
            } else {
                b3 = b2;
                z = false;
            }
            if (z) {
                c cVar6 = new c(this);
                int i10 = 34;
                while (true) {
                    if (i10 >= 94) {
                        cVar = cVar6;
                        break;
                    }
                    int i11 = i10;
                    cVar = cVar6;
                    a g4 = g(str, i10, dVar.a(), i, fVar);
                    if (g4 == null) {
                        g4 = g(str, i11, dVar2.a(), i, fVar);
                    }
                    if (g4 == null) {
                        break;
                    }
                    cVar.c(g4);
                    i10 = i11 + 1;
                    cVar6 = cVar;
                }
                if (cVar.a() > 0) {
                    bArr = cVar.e();
                    if (q(str, i)) {
                        str2 = "";
                        z2 = false;
                    } else {
                        str2 = t(str, oz.n(), i) ? oz.n() : "";
                        z2 = true;
                    }
                    return xz.h.c(new e(e2, b3.byteValue(), bArr, z2, str2).a());
                }
            }
            bArr = null;
            if (q(str, i)) {
            }
            return xz.h.c(new e(e2, b3.byteValue(), bArr, z2, str2).a());
        }
        return (xz.h) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.xz
    public void e(xz.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f = this.a.a;
        }
    }

    public final a g(String str, int i, List<d.b> list, int i2, f fVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Integer.valueOf(i), list, Integer.valueOf(i2), fVar})) == null) {
            for (d.b bVar : list) {
                if (r(str, i, bVar.b, i2, fVar)) {
                    bVar.c();
                    return bVar.b;
                }
            }
            return null;
        }
        return (a) invokeCommon.objValue;
    }

    public final String h(String str, int i, a aVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, str, i, aVar)) == null) ? String.format("content://%s/dat/v1/i%d/%s", v(str), Integer.valueOf(i), aVar.e()) : (String) invokeLIL.objValue;
    }

    public final String i(String str, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, aVar)) == null) ? String.format("content://%s/dic/v1/%s", v(str), aVar.e()) : (String) invokeLL.objValue;
    }

    public final String j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) ? String.format("content://%s/clo/v1/%s", v(str), str2) : (String) invokeLL.objValue;
    }

    public final void k(UriMatcher uriMatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, uriMatcher) == null) {
            uriMatcher.addURI(v(this.f.getPackageName()), "dat/v1/*/*", 1);
            uriMatcher.addURI(v(this.f.getPackageName()), "dic/v1/*", 2);
            uriMatcher.addURI(v(this.f.getPackageName()), "clo/v1/*", 3);
        }
    }

    public final boolean l(int i, a aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, aVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            return m(Uri.parse(h(this.f.getPackageName(), i, aVar)));
        }
        return invokeIL.booleanValue;
    }

    public final boolean m(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, uri)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            Context context = this.f;
            ContentResolver contentResolver = context.getContentResolver();
            try {
                this.g.e(context, context.getPackageName(), uri, 65);
                this.g.f(contentResolver, uri, 1);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean n(Uri uri, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, uri, i)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            Context context = this.f;
            ContentResolver contentResolver = context.getContentResolver();
            try {
                this.g.d(context, uri, i);
                this.g.c(contentResolver, uri, i);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public final boolean o(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, aVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            return m(Uri.parse(i(this.f.getPackageName(), aVar)));
        }
        return invokeL.booleanValue;
    }

    public final boolean p(c cVar, List<a> list) {
        InterceptResult invokeLL;
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, cVar, list)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            ContentResolver contentResolver = this.f.getContentResolver();
            UriMatcher uriMatcher = new UriMatcher(-1);
            k(uriMatcher);
            List<UriPermission> persistedUriPermissions = contentResolver.getPersistedUriPermissions();
            if (persistedUriPermissions == null || persistedUriPermissions.size() == 0) {
                persistedUriPermissions = contentResolver.getOutgoingPersistedUriPermissions();
            }
            if (persistedUriPermissions == null || persistedUriPermissions.size() == 0) {
                return true;
            }
            for (UriPermission uriPermission : persistedUriPermissions) {
                Uri uri = uriPermission.getUri();
                int match = uriMatcher.match(uri);
                List<String> pathSegments = uri.getPathSegments();
                if ((match == 1 || match == 2 || match == 3) && uriPermission.isWritePermission()) {
                    n(uri, uriPermission.isReadPermission() ? 3 : 2);
                } else if (match == 1) {
                    try {
                        i = Integer.valueOf(pathSegments.get(2).substring(1)).intValue();
                    } catch (Exception unused) {
                        i = -1;
                    }
                    if (i >= 0 && i < cVar.a()) {
                        if (!cVar.d(i).e().equals(pathSegments.get(3))) {
                        }
                    }
                    n(uri, 1);
                } else if (match == 2) {
                    String str = pathSegments.get(2);
                    Iterator<a> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().e().equals(str)) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        n(uri, 1);
                    }
                } else if (match == 3) {
                    String str2 = pathSegments.get(2);
                    if (!TextUtils.equals(str2, oz.n()) && !TextUtils.equals(str2, "yes")) {
                        n(uri, 1);
                    }
                }
            }
            int a2 = cVar.a();
            for (int i2 = 0; i2 < a2; i2++) {
                if (!r(this.f.getPackageName(), i2, cVar.d(i2), Process.myUid(), null)) {
                    return true;
                }
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (!s(this.f.getPackageName(), list.get(i3), Process.myUid())) {
                    return true;
                }
            }
            if (q(this.f.getPackageName(), Process.myUid())) {
                String n = oz.n();
                return (TextUtils.isEmpty(n) || t(this.f.getPackageName(), n, Process.myUid())) ? false : true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean q(String str, int i) {
        InterceptResult invokeLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, str, i)) == null) {
            Uri parse = Uri.parse(w(str));
            int i3 = 0;
            while (true) {
                if (i3 >= 2) {
                    i2 = -1;
                    break;
                }
                try {
                    i2 = this.g.a(this.f, parse, 0, i, 1);
                    break;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i3++;
                }
            }
            return i2 == 0;
        }
        return invokeLI.booleanValue;
    }

    public final boolean r(String str, int i, a aVar, int i2, f fVar) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, Integer.valueOf(i), aVar, Integer.valueOf(i2), fVar})) == null) {
            Uri parse = Uri.parse(h(str, i, aVar));
            int i4 = 0;
            while (true) {
                if (i4 >= 2) {
                    i3 = -1;
                    break;
                }
                if (fVar != null) {
                    try {
                        fVar.a++;
                    } catch (Throwable unused) {
                        try {
                            Thread.sleep(5L);
                        } catch (Exception unused2) {
                        }
                        i4++;
                    }
                }
                i3 = this.g.a(this.f, parse, 0, i2, 1);
                break;
            }
            if (i3 == 0) {
                return true;
            }
            if (fVar != null) {
                fVar.b++;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean s(String str, a aVar, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048591, this, str, aVar, i)) == null) {
            Uri parse = Uri.parse(i(str, aVar));
            int i3 = 0;
            while (true) {
                if (i3 >= 2) {
                    i2 = -1;
                    break;
                }
                try {
                    i2 = this.g.a(this.f, parse, 0, i, 1);
                    break;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i3++;
                }
            }
            return i2 == 0;
        }
        return invokeLLI.booleanValue;
    }

    public final boolean t(String str, String str2, int i) {
        InterceptResult invokeLLI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048592, this, str, str2, i)) == null) {
            Uri parse = Uri.parse(j(str, str2));
            int i3 = 0;
            while (true) {
                if (i3 >= 2) {
                    i2 = -1;
                    break;
                }
                try {
                    i2 = this.g.a(this.f, parse, 0, i, 1);
                    break;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5L);
                    } catch (Exception unused2) {
                    }
                    i3++;
                }
            }
            return i2 == 0;
        }
        return invokeLLI.booleanValue;
    }

    public final String v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            return str + ".cesium";
        }
        return (String) invokeL.objValue;
    }

    public final String w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) ? String.format("content://%s/clo/v1/%s", v(str), "yes") : (String) invokeL.objValue;
    }

    public final boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && Build.VERSION.SDK_INT >= 26) {
                return m(Uri.parse(w(this.f.getPackageName()))) && m(Uri.parse(j(this.f.getPackageName(), str)));
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}

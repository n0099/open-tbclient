package com.baidu.tieba;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.net.http.Headers;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.channels.upc.ReflectUtil;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tieba.e50;
import com.baidu.tieba.x20;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.common.ExceptionCode;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g30 extends x20 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;
    public Context f;
    public k g;
    public e50.a h;
    public j i;

    /* loaded from: classes6.dex */
    public static class c<T extends b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<C0305c<T>> a;

        /* loaded from: classes6.dex */
        public class a implements Comparator<C0305c<T>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
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
            public int compare(C0305c<T> c0305c, C0305c<T> c0305c2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, c0305c, c0305c2)) == null) {
                    return c0305c.a - c0305c2.a;
                }
                return invokeLL.intValue;
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Comparator<C0305c<T>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
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
            public int compare(C0305c<T> c0305c, C0305c<T> c0305c2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, c0305c, c0305c2)) == null) {
                    return c0305c2.a - c0305c.a;
                }
                return invokeLL.intValue;
            }
        }

        /* renamed from: com.baidu.tieba.g30$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0305c<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int a;
            public T b;

            public C0305c(T t) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {t};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = t;
            }

            public T c() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.b;
                }
                return (T) invokeV.objValue;
            }

            public void d() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a++;
                }
            }
        }

        public c() {
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

        public List<C0305c<T>> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ArrayList arrayList = new ArrayList(this.a);
                Collections.sort(arrayList, new a(this));
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public List<C0305c<T>> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                ArrayList arrayList = new ArrayList(this.a);
                Collections.sort(arrayList, new b(this));
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return d(1);
            }
            return (String) invokeV.objValue;
        }

        public C0305c a(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
                C0305c<T> c0305c = new C0305c<>(t);
                this.a.add(c0305c);
                return c0305c;
            }
            return (C0305c) invokeL.objValue;
        }

        public String d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                StringBuilder sb = new StringBuilder();
                List<C0305c<T>> b2 = b();
                sb.append("{");
                for (C0305c<T> c0305c : b2) {
                    sb.append(((b) c0305c.b).b());
                    sb.append(":");
                    sb.append(c0305c.a / i);
                    sb.append("; ");
                }
                sb.append("}");
                return sb.toString();
            }
            return (String) invokeI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f<T extends b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Map<T, Integer> b;

        /* loaded from: classes6.dex */
        public class a implements Comparator<Map.Entry<T, Integer>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
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
            public int compare(Map.Entry<T, Integer> entry, Map.Entry<T, Integer> entry2) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, entry, entry2)) == null) {
                    int intValue = entry2.getValue().intValue() - entry.getValue().intValue();
                    if (intValue != 0) {
                        return intValue;
                    }
                    return entry.getKey().compareTo(entry2.getKey());
                }
                return invokeLL.intValue;
            }
        }

        public f(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new HashMap();
            this.a = i;
        }

        public void a(T t) {
            int valueOf;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
                Integer num = this.b.get(t);
                if (num == null) {
                    valueOf = 1;
                } else {
                    valueOf = Integer.valueOf(num.intValue() + 1);
                }
                this.b.put(t, valueOf);
            }
        }

        public List<T> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ArrayList arrayList = new ArrayList(this.b.entrySet());
                Collections.sort(arrayList, new a(this));
                ArrayList arrayList2 = new ArrayList(this.a);
                int min = Math.min(this.a, arrayList.size());
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
    }

    /* loaded from: classes6.dex */
    public static final class a extends b<a> {
        public static /* synthetic */ Interceptable $ic;
        public static final String[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-824878360, "Lcom/baidu/tieba/g30$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-824878360, "Lcom/baidu/tieba/g30$a;");
                    return;
                }
            }
            b = new String[]{"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};
            b.c(4);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i, 4);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public static a d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                return new a(i);
            }
            return (a) invokeI.objValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b[b()];
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b<T extends b> implements Comparable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public static int c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? (1 << i) - 1 : invokeI.intValue;
        }

        public b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            int c = c(i2);
            if (i >= 0 && i <= c) {
                this.a = i;
                return;
            }
            throw new IllegalArgumentException("invalid index " + i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
                return this.a - t.b();
            }
            return invokeL.intValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj != null && getClass() == obj.getClass() && this.a == ((b) obj).a) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends b<d> {
        public static /* synthetic */ Interceptable $ic;
        public static final int b;
        public static final String[] c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-824878267, "Lcom/baidu/tieba/g30$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-824878267, "Lcom/baidu/tieba/g30$d;");
                    return;
                }
            }
            int c2 = b.c(6);
            b = c2;
            c = new String[c2 + 1];
            String[] strArr = {ExceptionCode.READ, "access", NativeConstants.COMPONENT_SYNC_TEXT_VIEW, "open", Headers.REFRESH, ApkCheckUBCManagerKt.PAGE, "close", "release"};
            for (int i = 0; i <= b; i++) {
                String str = strArr[i / 8];
                String valueOf = String.valueOf(i % 8);
                String[] strArr2 = c;
                strArr2[i] = str + valueOf;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i) {
            super(i, 6);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public static d d(g gVar, a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, gVar, aVar)) == null) {
                return e((gVar.b() << 4) | aVar.b());
            }
            return (d) invokeLL.objValue;
        }

        public static d e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
                return new d(i);
            }
            return (d) invokeI.objValue;
        }

        public static d i(byte b2) {
            InterceptResult invokeB;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeB = interceptable.invokeB(InputDeviceCompat.SOURCE_TRACKBALL, null, b2)) == null) {
                return e(b2 & 255);
            }
            return (d) invokeB.objValue;
        }

        public a f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return a.d(b() & 15);
            }
            return (a) invokeV.objValue;
        }

        public byte g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (byte) b();
            }
            return invokeV.byteValue;
        }

        public String h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return c[b()];
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public d[] b;
        public int c;

        public e() {
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
            this.a = 27;
            this.b = new d[27];
        }

        public int d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }

        public static e f(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) {
                e eVar = new e();
                for (byte b : f30.c(bArr)) {
                    eVar.a(d.i(b));
                }
                return eVar;
            }
            return (e) invokeL.objValue;
        }

        public void a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
                b(this.c + 1);
                d[] dVarArr = this.b;
                int i = this.c;
                this.c = i + 1;
                dVarArr[i] = dVar;
            }
        }

        public final void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                d[] dVarArr = this.b;
                if (i - dVarArr.length > 0) {
                    int length = dVarArr.length;
                    int i2 = length + (length >> 1);
                    if (i2 - i >= 0) {
                        i = i2;
                    }
                    this.b = (d[]) Arrays.copyOf(this.b, i);
                }
            }
        }

        public d c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (i < this.c) {
                    return this.b[i];
                }
                throw new IndexOutOfBoundsException("idx " + i + " size " + this.c);
            }
            return (d) invokeI.objValue;
        }

        public byte[] e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                for (int i = 0; i < this.c; i++) {
                    byteArrayOutputStream.write(this.b[i].g());
                }
                return f30.a(byteArrayOutputStream.toByteArray());
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class g extends b<g> {
        public static /* synthetic */ Interceptable $ic;
        public static final int b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-824878174, "Lcom/baidu/tieba/g30$g;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-824878174, "Lcom/baidu/tieba/g30$g;");
                    return;
                }
            }
            b = b.c(2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i) {
            super(i, 2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public static g d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                return new g(i);
            }
            return (g) invokeI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;

        public i() {
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
            this.c = 16;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (g30.j) {
                    return "stat {total count = " + (this.a + this.c) + ", miss count = " + this.b + ", data probe count = " + this.a + '}';
                }
                return "";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public long b;
        public b50 c;
        public long d;
        public String e;
        public boolean f;
        public final /* synthetic */ g30 g;

        public j(g30 g30Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g30Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = g30Var;
            this.c = new b50();
            this.f = true;
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.e;
            }
            return (String) invokeV.objValue;
        }

        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.d;
            }
            return invokeV.longValue;
        }

        public long b(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
                return this.c.a(j);
            }
            return invokeJ.longValue;
        }

        public boolean f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                String str2 = this.e;
                if (str2 == str) {
                    return false;
                }
                if (str != null && str.equals(str2)) {
                    return false;
                }
                this.f = true;
                this.e = str;
                return true;
            }
            return invokeL.booleanValue;
        }

        public void h(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048583, this, j) == null) && this.b != j) {
                this.b = j;
                this.f = true;
            }
        }

        public boolean i(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) {
                if (this.d != j) {
                    this.d = j;
                    this.f = true;
                    return true;
                }
                return false;
            }
            return invokeJ.booleanValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_ver", this.a);
                        jSONObject.put("pub_lst_ts", this.b);
                        jSONObject.put("pkg_lst_up_ts", this.d);
                        jSONObject.put("flags", this.c.d());
                        jSONObject.put("d_form_ver", 1);
                        jSONObject.put("aid", this.e);
                        this.g.h.i("pub.dat", jSONObject.toString(), true);
                        this.f = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                String g = this.g.h.g("pub.dat", true);
                if (!TextUtils.isEmpty(g)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g);
                        this.a = jSONObject.getInt("pub_ver");
                        this.b = jSONObject.getLong("pub_lst_ts");
                        this.d = jSONObject.getLong("pkg_lst_up_ts");
                        this.c.b(jSONObject.getLong("flags"));
                        jSONObject.getInt("d_form_ver");
                        this.e = jSONObject.optString("aid");
                        this.f = false;
                    } catch (Exception unused) {
                        this.f = true;
                    }
                }
            }
        }

        public boolean g(long j, long j2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
                if (this.c.c(j, j2)) {
                    this.f = true;
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Method a;
        public Method b;
        public Method c;
        public Method d;
        public Method e;

        public k() {
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

        public int a(Context context, Uri uri, int i, int i2, int i3) throws ReflectUtil.MethodInvokeException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
                try {
                    return ((Integer) this.a.invoke(context, uri, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).intValue();
                } catch (Exception e) {
                    throw new ReflectUtil.MethodInvokeException(e);
                }
            }
            return invokeCommon.intValue;
        }

        public void b(Context context, String str, Uri uri, int i) throws ReflectUtil.MethodInvokeException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, uri, i) == null) {
                try {
                    this.b.invoke(context, str, uri, Integer.valueOf(i));
                } catch (Exception e) {
                    throw new ReflectUtil.MethodInvokeException(e);
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    this.a = ReflectUtil.a(Context.class, ReflectUtil.b(h30.a()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                    this.b = ReflectUtil.a(Context.class, ReflectUtil.b(h30.b()), new Class[]{String.class, Uri.class, Integer.TYPE});
                    this.c = ReflectUtil.a(ContentResolver.class, ReflectUtil.b(h30.e()), new Class[]{Uri.class, Integer.TYPE});
                    this.d = ReflectUtil.a(Context.class, ReflectUtil.b(h30.d()), new Class[]{Uri.class, Integer.TYPE});
                    this.e = ReflectUtil.a(ContentResolver.class, ReflectUtil.b(h30.c()), new Class[]{Uri.class, Integer.TYPE});
                } catch (Exception unused) {
                }
            }
        }

        public void d(ContentResolver contentResolver, Uri uri, int i) throws ReflectUtil.MethodInvokeException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048579, this, contentResolver, uri, i) == null) {
                try {
                    this.e.invoke(contentResolver, uri, Integer.valueOf(i));
                } catch (Exception e) {
                    throw new ReflectUtil.MethodInvokeException(e);
                }
            }
        }

        public void e(Context context, Uri uri, int i) throws ReflectUtil.MethodInvokeException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048580, this, context, uri, i) == null) {
                try {
                    this.d.invoke(context, uri, Integer.valueOf(i));
                } catch (Exception e) {
                    throw new ReflectUtil.MethodInvokeException(e);
                }
            }
        }

        public void f(ContentResolver contentResolver, Uri uri, int i) throws ReflectUtil.MethodInvokeException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048581, this, contentResolver, uri, i) == null) {
                try {
                    this.c.invoke(contentResolver, uri, Integer.valueOf(i));
                } catch (Exception e) {
                    throw new ReflectUtil.MethodInvokeException(e);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends x20.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String d;
        public long e;
        public String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(g30 g30Var, String str) {
            super(g30Var.h, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g30Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((e50.a) objArr2[0], (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tieba.x20.c
        public void c(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.d = jSONObject.getString("pkg");
                this.e = jSONObject.getLong("last_fe_ts");
                this.f = jSONObject.getString("id");
                jSONObject.getInt("d_form_ver");
            }
        }

        @Override // com.baidu.tieba.x20.c
        public void e(JSONObject jSONObject) throws JSONException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                jSONObject.put("pkg", this.d);
                jSONObject.put("last_fe_ts", this.e);
                jSONObject.put("id", this.f);
                jSONObject.put("d_form_ver", 1);
            }
        }

        public void h(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && !str.equals(this.f)) {
                this.f = str;
                a(true);
            }
        }

        public void i(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048581, this, j) == null) && this.e != j) {
                this.e = j;
                a(true);
            }
        }

        public void j(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !str.equals(this.d)) {
                this.d = str;
                a(true);
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.f;
            }
            return (String) invokeV.objValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.d;
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947742853, "Lcom/baidu/tieba/g30;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947742853, "Lcom/baidu/tieba/g30;");
                return;
            }
        }
        j = e30.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g30() {
        super("upc", 8500000L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], ((Long) objArr[1]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = new k();
        this.i = new j(this);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF, IF] complete} */
    @Override // com.baidu.tieba.x20
    public x20.h b(String str, x20.g gVar) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, gVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return x20.h.a();
            }
            h hVar = new h();
            l lVar = null;
            try {
                packageInfo = this.f.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return x20.h.a();
            }
            if (gVar.a) {
                lVar = new l(this, str);
                lVar.d();
                if (str.equals(lVar.g())) {
                    String f2 = lVar.f();
                    if (!TextUtils.isEmpty(f2)) {
                        return x20.h.f(f2);
                    }
                }
                lVar.j(str);
            }
            l lVar2 = lVar;
            int i2 = packageInfo.applicationInfo.uid;
            i iVar = new i();
            c cVar = new c();
            c cVar2 = new c();
            for (int i3 = 0; i3 < 16; i3++) {
                try {
                    a d2 = a.d(i3);
                    if (v(str, d2, i2)) {
                        cVar.a(d2);
                    } else {
                        cVar2.a(d2);
                    }
                } finally {
                    if (gVar.a && lVar2 != null) {
                        lVar2.b();
                    }
                }
            }
            e eVar = new e();
            int e2 = f30.e(20);
            c cVar3 = new c();
            for (int i4 = 0; i4 <= g.b; i4++) {
                cVar3.a(g.d(i4));
            }
            int i5 = 0;
            while (i5 < e2) {
                int i6 = i5;
                c cVar4 = cVar3;
                int i7 = e2;
                e eVar2 = eVar;
                d t = t(str, i5, cVar.b(), cVar3.c(), i2, iVar);
                if (t == null) {
                    t = t(str, i6, cVar2.b(), cVar4.c(), i2, iVar);
                }
                if (t == null) {
                    return x20.h.a();
                }
                eVar2.a(t);
                i5 = i6 + 1;
                eVar = eVar2;
                cVar3 = cVar4;
                e2 = i7;
            }
            c cVar5 = cVar3;
            e eVar3 = eVar;
            if (j) {
                Log.i("Helios", "hi he dict count usage : " + cVar5.e());
                Log.i("Helios", "lo dict count usage : " + cVar.e());
                Log.i("Helios", "lo normal count usage : " + cVar2.e());
            }
            String i8 = j50.i(eVar3.e());
            if (gVar.a && lVar2 != null) {
                lVar2.h(i8);
                lVar2.i(System.currentTimeMillis());
            }
            if (j) {
                Log.i("Helios", "probe suc, stat = " + iVar);
            }
            x20.h f3 = x20.h.f(i8);
            if (gVar.b) {
                f3.c = hVar;
            }
            if (gVar.a && lVar2 != null) {
                lVar2.b();
            }
            return f3;
        }
        return (x20.h) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.x20
    public void e(x20.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            this.f = this.a.a;
            this.h = this.b.f("upc");
            this.g.c();
        }
    }

    @Override // com.baidu.tieba.x20
    public x20.f f(x20.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            this.i.e();
            try {
                return r(eVar);
            } finally {
                this.i.d();
            }
        }
        return (x20.f) invokeL.objValue;
    }

    public final void j(UriMatcher uriMatcher) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uriMatcher) == null) {
            uriMatcher.addURI(k(this.f.getPackageName()), "dat/v1/*/*", 1);
            uriMatcher.addURI(k(this.f.getPackageName()), "dic/v1/*", 2);
        }
    }

    public final String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return str + ".helios.quark";
        }
        return (String) invokeL.objValue;
    }

    public final boolean n(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, uri)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            Context context = this.f;
            ContentResolver contentResolver = context.getContentResolver();
            try {
                this.g.b(context, context.getPackageName(), uri, 65);
                this.g.f(contentResolver, uri, 1);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean p(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, aVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            return n(Uri.parse(l(this.f.getPackageName(), aVar)));
        }
        return invokeL.booleanValue;
    }

    public final boolean i(e eVar, List<a> list) {
        InterceptResult invokeLL;
        int i2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, eVar, list)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            ContentResolver contentResolver = this.f.getContentResolver();
            UriMatcher uriMatcher = new UriMatcher(-1);
            j(uriMatcher);
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
                int i3 = 3;
                if ((match == 1 || match == 2) && uriPermission.isWritePermission()) {
                    if (!uriPermission.isReadPermission()) {
                        i3 = 2;
                    }
                    s(uri, i3);
                } else if (match == 1) {
                    try {
                        i2 = Integer.valueOf(pathSegments.get(2).substring(1)).intValue();
                    } catch (Exception unused) {
                        i2 = -1;
                    }
                    if (i2 >= 0 && i2 < eVar.d()) {
                        if (!eVar.c(i2).h().equals(pathSegments.get(3))) {
                            s(uri, 1);
                        }
                    } else {
                        s(uri, 1);
                    }
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
                        s(uri, 1);
                    }
                }
            }
            int d2 = eVar.d();
            for (int i4 = 0; i4 < d2; i4++) {
                if (!u(this.f.getPackageName(), i4, eVar.c(i4), Process.myUid(), null)) {
                    return true;
                }
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (!v(this.f.getPackageName(), list.get(i5), Process.myUid())) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final String l(String str, a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, aVar)) == null) {
            return String.format("content://%s/dic/v1/%s", k(str), aVar.e());
        }
        return (String) invokeLL.objValue;
    }

    public final boolean o(int i2, d dVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, dVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            return n(Uri.parse(m(this.f.getPackageName(), i2, dVar)));
        }
        return invokeIL.booleanValue;
    }

    public final boolean s(Uri uri, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, uri, i2)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            Context context = this.f;
            ContentResolver contentResolver = context.getContentResolver();
            try {
                this.g.e(context, uri, i2);
                this.g.d(contentResolver, uri, i2);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public final String m(String str, int i2, d dVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048583, this, str, i2, dVar)) == null) {
            return String.format("content://%s/dat/v1/i%d/%s", k(str), Integer.valueOf(i2), dVar.h());
        }
        return (String) invokeLIL.objValue;
    }

    public final x20.f q(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, eVar)) == null) {
            f fVar = new f(6);
            for (int i2 = 0; i2 < eVar.d(); i2++) {
                fVar.a(eVar.c(i2).f());
            }
            List<a> b2 = fVar.b();
            if (!i(eVar, b2)) {
                this.i.g(1L, 1L);
                return x20.f.d();
            }
            for (int d2 = eVar.d() - 1; d2 >= 0; d2--) {
                o(d2, eVar.c(d2));
            }
            for (a aVar : b2) {
                p(aVar);
            }
            this.i.h(System.currentTimeMillis());
            this.i.g(1L, 1L);
            return x20.f.d();
        }
        return (x20.f) invokeL.objValue;
    }

    public final x20.f r(x20.e eVar) {
        InterceptResult invokeL;
        boolean z;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, eVar)) == null) {
            if (Build.VERSION.SDK_INT < 26) {
                return x20.f.a();
            }
            Context context = this.a.a;
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                if (packageInfo.lastUpdateTime != this.i.c()) {
                    z = true;
                } else {
                    z = false;
                }
                this.i.i(packageInfo.lastUpdateTime);
                if (!z && this.i.b(6L) == 4) {
                    return x20.f.a();
                }
                h50 a3 = this.a.c.a("aid");
                e f2 = e.f(a3.d());
                if (f2 == null) {
                    return x20.f.a();
                }
                if (this.i.b(1L) == 1 && (a2 = this.i.a()) != null && a2.equals(a3.c())) {
                    return x20.f.d();
                }
                this.i.f(a3.c());
                ProviderInfo providerInfo = null;
                try {
                    providerInfo = packageManager.resolveContentProvider(k(packageName), 0);
                } catch (Exception unused) {
                }
                if (providerInfo == null) {
                    this.i.g(4L, 6L);
                } else {
                    this.i.g(2L, 6L);
                }
                return q(f2);
            } catch (PackageManager.NameNotFoundException unused2) {
                return x20.f.a();
            }
        }
        return (x20.f) invokeL.objValue;
    }

    public final d t(String str, int i2, List<c.C0305c<a>> list, List<c.C0305c<g>> list2, int i3, i iVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, Integer.valueOf(i2), list, list2, Integer.valueOf(i3), iVar})) == null) {
            for (c.C0305c<a> c0305c : list) {
                for (c.C0305c<g> c0305c2 : list2) {
                    d d2 = d.d(c0305c2.c(), c0305c.c());
                    if (u(str, i2, d2, i3, iVar)) {
                        c0305c.d();
                        c0305c2.d();
                        return d2;
                    }
                }
            }
            return null;
        }
        return (d) invokeCommon.objValue;
    }

    public final boolean u(String str, int i2, d dVar, int i3, i iVar) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{str, Integer.valueOf(i2), dVar, Integer.valueOf(i3), iVar})) == null) {
            Uri parse = Uri.parse(m(str, i2, dVar));
            int i5 = 0;
            while (true) {
                if (i5 < 2) {
                    if (iVar != null) {
                        try {
                            if (iVar.a > 0 && iVar.a % 100 == 0) {
                                try {
                                    Thread.sleep(10L);
                                } catch (Exception unused) {
                                }
                            }
                            iVar.a++;
                        } catch (Throwable unused2) {
                            try {
                                Thread.sleep(5L);
                            } catch (Exception unused3) {
                            }
                            i5++;
                        }
                    }
                    i4 = this.g.a(this.f, parse, 0, i3, 1);
                    break;
                }
                i4 = -1;
                break;
            }
            if (i4 == 0) {
                return true;
            }
            if (iVar != null) {
                iVar.b++;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean v(String str, a aVar, int i2) {
        InterceptResult invokeLLI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048592, this, str, aVar, i2)) == null) {
            Uri parse = Uri.parse(l(str, aVar));
            int i4 = 0;
            while (true) {
                if (i4 < 2) {
                    try {
                        i3 = this.g.a(this.f, parse, 0, i2, 1);
                        break;
                    } catch (Throwable unused) {
                        try {
                            Thread.sleep(5L);
                        } catch (Exception unused2) {
                        }
                        i4++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != 0) {
                return false;
            }
            return true;
        }
        return invokeLLI.booleanValue;
    }
}

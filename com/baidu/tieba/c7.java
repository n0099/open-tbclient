package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes5.dex */
public class c7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Locale d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public c7 a;
    public Locale b;
    public o7<String, String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448300025, "Lcom/baidu/tieba/c7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448300025, "Lcom/baidu/tieba/c7;");
                return;
            }
        }
        d = new Locale("", "", "");
        e = false;
    }

    public c7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public Locale g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (Locale) invokeV.objValue;
    }

    public static boolean a(b3 b3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, b3Var)) == null) {
            try {
                b3Var.m().close();
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static Locale f(Locale locale) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, locale)) == null) {
            Locale locale2 = Locale.getDefault();
            if (locale.equals(locale2)) {
                return null;
            }
            return locale2;
        }
        return (Locale) invokeL.objValue;
    }

    public void h(Reader reader) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reader) == null) {
            o7<String, String> o7Var = new o7<>();
            this.c = o7Var;
            t7.a(o7Var, reader);
        }
    }

    public final void k(Locale locale) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, locale) == null) {
            this.b = locale;
            new c8(locale, !e);
        }
    }

    public static c7 b(b3 b3Var, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, b3Var, locale)) == null) {
            return d(b3Var, locale, "UTF-8");
        }
        return (c7) invokeLL.objValue;
    }

    public static c7 c(b3 b3Var, Locale locale, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, b3Var, locale, str)) == null) {
            return d(b3Var, locale, str);
        }
        return (c7) invokeLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0049, code lost:
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
        throw new java.util.MissingResourceException("Can't find bundle for base file handle " + r9.j() + ", locale " + r10, r9 + "_" + r10, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c7 d(b3 b3Var, Locale locale, String str) {
        InterceptResult invokeLLL;
        c7 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, b3Var, locale, str)) == null) {
            c7 c7Var = null;
            if (b3Var != null && locale != null && str != null) {
                Locale locale2 = locale;
                do {
                    List<Locale> e2 = e(locale2);
                    j = j(b3Var, str, e2, 0, c7Var);
                    if (j != null) {
                        Locale g = j.g();
                        boolean equals = g.equals(d);
                        if (!equals || g.equals(locale) || (e2.size() == 1 && g.equals(e2.get(0)))) {
                            break;
                        } else if (equals && c7Var == null) {
                            c7Var = j;
                        }
                    }
                    locale2 = f(locale2);
                } while (locale2 != null);
                return j;
            }
            throw null;
        }
        return (c7) invokeLLL.objValue;
    }

    public static List<Locale> e(Locale locale) {
        InterceptResult invokeL;
        Locale locale2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, locale)) == null) {
            String language = locale.getLanguage();
            String country = locale.getCountry();
            String variant = locale.getVariant();
            ArrayList arrayList = new ArrayList(4);
            if (variant.length() > 0) {
                arrayList.add(locale);
            }
            if (country.length() > 0) {
                if (arrayList.isEmpty()) {
                    locale2 = locale;
                } else {
                    locale2 = new Locale(language, country);
                }
                arrayList.add(locale2);
            }
            if (language.length() > 0) {
                if (!arrayList.isEmpty()) {
                    locale = new Locale(language);
                }
                arrayList.add(locale);
            }
            arrayList.add(d);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static c7 i(b3 b3Var, String str, Locale locale) {
        InterceptResult invokeLLL;
        c7 c7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, b3Var, str, locale)) == null) {
            Reader reader = null;
            try {
                try {
                    b3 l = l(b3Var, locale);
                    if (a(l)) {
                        c7Var = new c7();
                        reader = l.r(str);
                        c7Var.h(reader);
                    } else {
                        c7Var = null;
                    }
                    if (c7Var != null) {
                        c7Var.k(locale);
                    }
                    return c7Var;
                } catch (IOException e2) {
                    throw new GdxRuntimeException(e2);
                }
            } finally {
                a8.a(reader);
            }
        }
        return (c7) invokeLLL.objValue;
    }

    public static c7 j(b3 b3Var, String str, List<Locale> list, int i, c7 c7Var) {
        InterceptResult invokeCommon;
        c7 c7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{b3Var, str, list, Integer.valueOf(i), c7Var})) == null) {
            Locale locale = list.get(i);
            if (i != list.size() - 1) {
                c7Var2 = j(b3Var, str, list, i + 1, c7Var);
            } else if (c7Var != null && locale.equals(d)) {
                return c7Var;
            } else {
                c7Var2 = null;
            }
            c7 i2 = i(b3Var, str, locale);
            if (i2 != null) {
                i2.a = c7Var2;
                return i2;
            }
            return c7Var2;
        }
        return (c7) invokeCommon.objValue;
    }

    public static b3 l(b3 b3Var, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, b3Var, locale)) == null) {
            b8 b8Var = new b8(b3Var.g());
            if (!locale.equals(d)) {
                String language = locale.getLanguage();
                String country = locale.getCountry();
                String variant = locale.getVariant();
                boolean equals = "".equals(language);
                boolean equals2 = "".equals(country);
                boolean equals3 = "".equals(variant);
                if (!equals || !equals2 || !equals3) {
                    b8Var.a('_');
                    if (!equals3) {
                        b8Var.n(language);
                        b8Var.a('_');
                        b8Var.n(country);
                        b8Var.a('_');
                        b8Var.n(variant);
                    } else if (!equals2) {
                        b8Var.n(language);
                        b8Var.a('_');
                        b8Var.n(country);
                    } else {
                        b8Var.n(language);
                    }
                }
            }
            b8Var.n(".properties");
            return b3Var.s(b8Var.toString());
        }
        return (b3) invokeLL.objValue;
    }
}

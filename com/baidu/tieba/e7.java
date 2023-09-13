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
public class e7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Locale d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public e7 a;
    public Locale b;
    public q7<String, String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448301947, "Lcom/baidu/tieba/e7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448301947, "Lcom/baidu/tieba/e7;");
                return;
            }
        }
        d = new Locale("", "", "");
        e = false;
    }

    public e7() {
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

    public static boolean a(d3 d3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, d3Var)) == null) {
            try {
                d3Var.m().close();
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
            q7<String, String> q7Var = new q7<>();
            this.c = q7Var;
            v7.a(q7Var, reader);
        }
    }

    public final void k(Locale locale) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, locale) == null) {
            this.b = locale;
            new e8(locale, !e);
        }
    }

    public static e7 b(d3 d3Var, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, d3Var, locale)) == null) {
            return d(d3Var, locale, "UTF-8");
        }
        return (e7) invokeLL.objValue;
    }

    public static e7 c(d3 d3Var, Locale locale, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, d3Var, locale, str)) == null) {
            return d(d3Var, locale, str);
        }
        return (e7) invokeLLL.objValue;
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
    public static e7 d(d3 d3Var, Locale locale, String str) {
        InterceptResult invokeLLL;
        e7 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, d3Var, locale, str)) == null) {
            e7 e7Var = null;
            if (d3Var != null && locale != null && str != null) {
                Locale locale2 = locale;
                do {
                    List<Locale> e2 = e(locale2);
                    j = j(d3Var, str, e2, 0, e7Var);
                    if (j != null) {
                        Locale g = j.g();
                        boolean equals = g.equals(d);
                        if (!equals || g.equals(locale) || (e2.size() == 1 && g.equals(e2.get(0)))) {
                            break;
                        } else if (equals && e7Var == null) {
                            e7Var = j;
                        }
                    }
                    locale2 = f(locale2);
                } while (locale2 != null);
                return j;
            }
            throw null;
        }
        return (e7) invokeLLL.objValue;
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

    public static e7 i(d3 d3Var, String str, Locale locale) {
        InterceptResult invokeLLL;
        e7 e7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, d3Var, str, locale)) == null) {
            Reader reader = null;
            try {
                try {
                    d3 l = l(d3Var, locale);
                    if (a(l)) {
                        e7Var = new e7();
                        reader = l.r(str);
                        e7Var.h(reader);
                    } else {
                        e7Var = null;
                    }
                    if (e7Var != null) {
                        e7Var.k(locale);
                    }
                    return e7Var;
                } catch (IOException e2) {
                    throw new GdxRuntimeException(e2);
                }
            } finally {
                c8.a(reader);
            }
        }
        return (e7) invokeLLL.objValue;
    }

    public static e7 j(d3 d3Var, String str, List<Locale> list, int i, e7 e7Var) {
        InterceptResult invokeCommon;
        e7 e7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{d3Var, str, list, Integer.valueOf(i), e7Var})) == null) {
            Locale locale = list.get(i);
            if (i != list.size() - 1) {
                e7Var2 = j(d3Var, str, list, i + 1, e7Var);
            } else if (e7Var != null && locale.equals(d)) {
                return e7Var;
            } else {
                e7Var2 = null;
            }
            e7 i2 = i(d3Var, str, locale);
            if (i2 != null) {
                i2.a = e7Var2;
                return i2;
            }
            return e7Var2;
        }
        return (e7) invokeCommon.objValue;
    }

    public static d3 l(d3 d3Var, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, d3Var, locale)) == null) {
            d8 d8Var = new d8(d3Var.g());
            if (!locale.equals(d)) {
                String language = locale.getLanguage();
                String country = locale.getCountry();
                String variant = locale.getVariant();
                boolean equals = "".equals(language);
                boolean equals2 = "".equals(country);
                boolean equals3 = "".equals(variant);
                if (!equals || !equals2 || !equals3) {
                    d8Var.a('_');
                    if (!equals3) {
                        d8Var.n(language);
                        d8Var.a('_');
                        d8Var.n(country);
                        d8Var.a('_');
                        d8Var.n(variant);
                    } else if (!equals2) {
                        d8Var.n(language);
                        d8Var.a('_');
                        d8Var.n(country);
                    } else {
                        d8Var.n(language);
                    }
                }
            }
            d8Var.n(".properties");
            return d3Var.s(d8Var.toString());
        }
        return (d3) invokeLL.objValue;
    }
}

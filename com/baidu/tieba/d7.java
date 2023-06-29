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
public class d7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Locale d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;
    public d7 a;
    public Locale b;
    public p7<String, String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448300986, "Lcom/baidu/tieba/d7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448300986, "Lcom/baidu/tieba/d7;");
                return;
            }
        }
        d = new Locale("", "", "");
        e = false;
    }

    public d7() {
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

    public static boolean a(c3 c3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c3Var)) == null) {
            try {
                c3Var.m().close();
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
            p7<String, String> p7Var = new p7<>();
            this.c = p7Var;
            u7.a(p7Var, reader);
        }
    }

    public final void k(Locale locale) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, locale) == null) {
            this.b = locale;
            new d8(locale, !e);
        }
    }

    public static d7 b(c3 c3Var, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, c3Var, locale)) == null) {
            return d(c3Var, locale, "UTF-8");
        }
        return (d7) invokeLL.objValue;
    }

    public static d7 c(c3 c3Var, Locale locale, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, c3Var, locale, str)) == null) {
            return d(c3Var, locale, str);
        }
        return (d7) invokeLLL.objValue;
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
    public static d7 d(c3 c3Var, Locale locale, String str) {
        InterceptResult invokeLLL;
        d7 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, c3Var, locale, str)) == null) {
            d7 d7Var = null;
            if (c3Var != null && locale != null && str != null) {
                Locale locale2 = locale;
                do {
                    List<Locale> e2 = e(locale2);
                    j = j(c3Var, str, e2, 0, d7Var);
                    if (j != null) {
                        Locale g = j.g();
                        boolean equals = g.equals(d);
                        if (!equals || g.equals(locale) || (e2.size() == 1 && g.equals(e2.get(0)))) {
                            break;
                        } else if (equals && d7Var == null) {
                            d7Var = j;
                        }
                    }
                    locale2 = f(locale2);
                } while (locale2 != null);
                return j;
            }
            throw null;
        }
        return (d7) invokeLLL.objValue;
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

    public static d7 i(c3 c3Var, String str, Locale locale) {
        InterceptResult invokeLLL;
        d7 d7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, c3Var, str, locale)) == null) {
            Reader reader = null;
            try {
                try {
                    c3 l = l(c3Var, locale);
                    if (a(l)) {
                        d7Var = new d7();
                        reader = l.r(str);
                        d7Var.h(reader);
                    } else {
                        d7Var = null;
                    }
                    if (d7Var != null) {
                        d7Var.k(locale);
                    }
                    return d7Var;
                } catch (IOException e2) {
                    throw new GdxRuntimeException(e2);
                }
            } finally {
                b8.a(reader);
            }
        }
        return (d7) invokeLLL.objValue;
    }

    public static d7 j(c3 c3Var, String str, List<Locale> list, int i, d7 d7Var) {
        InterceptResult invokeCommon;
        d7 d7Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{c3Var, str, list, Integer.valueOf(i), d7Var})) == null) {
            Locale locale = list.get(i);
            if (i != list.size() - 1) {
                d7Var2 = j(c3Var, str, list, i + 1, d7Var);
            } else if (d7Var != null && locale.equals(d)) {
                return d7Var;
            } else {
                d7Var2 = null;
            }
            d7 i2 = i(c3Var, str, locale);
            if (i2 != null) {
                i2.a = d7Var2;
                return i2;
            }
            return d7Var2;
        }
        return (d7) invokeCommon.objValue;
    }

    public static c3 l(c3 c3Var, Locale locale) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, c3Var, locale)) == null) {
            c8 c8Var = new c8(c3Var.g());
            if (!locale.equals(d)) {
                String language = locale.getLanguage();
                String country = locale.getCountry();
                String variant = locale.getVariant();
                boolean equals = "".equals(language);
                boolean equals2 = "".equals(country);
                boolean equals3 = "".equals(variant);
                if (!equals || !equals2 || !equals3) {
                    c8Var.a('_');
                    if (!equals3) {
                        c8Var.n(language);
                        c8Var.a('_');
                        c8Var.n(country);
                        c8Var.a('_');
                        c8Var.n(variant);
                    } else if (!equals2) {
                        c8Var.n(language);
                        c8Var.a('_');
                        c8Var.n(country);
                    } else {
                        c8Var.n(language);
                    }
                }
            }
            c8Var.n(".properties");
            return c3Var.s(c8Var.toString());
        }
        return (c3) invokeLL.objValue;
    }
}

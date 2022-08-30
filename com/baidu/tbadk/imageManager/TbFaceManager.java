package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.an;
import com.baidu.tieba.bv4;
import com.baidu.tieba.e35;
import com.baidu.tieba.fg5;
import com.baidu.tieba.li5;
import com.baidu.tieba.m55;
import com.baidu.tieba.o55;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class TbFaceManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static TbFaceManager c = null;
    public static String d = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]|#[\\(]+[A-Za-z0-9_\\-\\u4e00-\\u9fa5]+[\\)]";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public m55 b;

    /* loaded from: classes3.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3736301305777944719L;
        public transient /* synthetic */ FieldHolder $fh;
        public String c;
        public String text;
        public Integer type;

        public RichUnit() {
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

    /* loaded from: classes3.dex */
    public interface a {
        ImageSpan a(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2115272915, "Lcom/baidu/tbadk/imageManager/TbFaceManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2115272915, "Lcom/baidu/tbadk/imageManager/TbFaceManager;");
        }
    }

    public TbFaceManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
    }

    public static TbFaceManager i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                c = new TbFaceManager();
            }
            TbFaceManager tbFaceManager = c;
            if (tbFaceManager.b == null) {
                tbFaceManager.b = new e35();
                c.a = TbadkCoreApplication.getInst();
            }
            return c;
        }
        return (TbFaceManager) invokeV.objValue;
    }

    public an a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? h(e(str), str) : (an) invokeL.objValue;
    }

    public Bitmap b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? BitmapHelper.getCashBitmap(e(str)) : (Bitmap) invokeL.objValue;
    }

    public li5 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? new li5(TbadkCoreApplication.getInst().getContext(), e(str)) : (li5) invokeL.objValue;
    }

    public li5 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? new li5(TbadkCoreApplication.getInst().getContext(), l(str)) : (li5) invokeL.objValue;
    }

    public final int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.b.e(str) : invokeL.intValue;
    }

    public m55.a f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            an a2 = a(str);
            if (a2 != null) {
                return new m55.a(a2.r(), a2.m());
            }
            return null;
        }
        return (m55.a) invokeL.objValue;
    }

    public m55.a g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            int l = l(str);
            an h = h(l, this.b.d(l));
            if (h != null) {
                return new m55.a(h.r(), h.m());
            }
            return null;
        }
        return (m55.a) invokeL.objValue;
    }

    public final an h(int i, String str) {
        InterceptResult invokeIL;
        Bitmap resBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, str)) == null) {
            an m = o55.k().m(str);
            if (m != null || (resBitmap = BitmapHelper.getResBitmap(this.a, i)) == null) {
                return m;
            }
            an anVar = new an(resBitmap, false, str);
            o55.k().d(str, anVar);
            return anVar;
        }
        return (an) invokeIL.objValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? this.b.c(str) : (String) invokeL.objValue;
    }

    public an k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) ? h(l(str), str) : (an) invokeL.objValue;
    }

    public final int l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) ? this.b.f(str) : invokeL.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.b.a() : invokeV.intValue;
    }

    public String n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) ? this.b.b(i) : (String) invokeI.objValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) ? e(str) > 0 : invokeL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? this.b.f(str) > 0 : invokeL.booleanValue;
    }

    public void q(Context context, m55 m55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, m55Var) == null) {
            if (context != null && m55Var != null) {
                this.a = context;
                this.b = m55Var;
                return;
            }
            throw new InvalidParameterException("TbFaceManager initial error");
        }
    }

    public SpannableString r(Context context, String str) {
        InterceptResult invokeLL;
        an h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, context, str)) == null) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(d).matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                int f = this.b.f(group);
                if (f > 0 && (h = h(f, String.valueOf(f))) != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable j = h.j();
                    j.setBounds(0, 0, 55, 55);
                    spannableString.setSpan(new bv4(j, 0), start, length + start, 33);
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    public SpannableString s(Context context, String str, int i, int i2) {
        InterceptResult invokeLLII;
        an h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048593, this, context, str, i, i2)) == null) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(d).matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                int f = this.b.f(group);
                if (f > 0 && (h = h(f, String.valueOf(f))) != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable j = h.j();
                    j.setBounds(0, 0, i > 0 ? i : h.r(), i2 > 0 ? i2 : h.m());
                    spannableString.setSpan(new fg5(j), start, length + start, 33);
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeLLII.objValue;
    }

    public SpannableString t(Context context, String str, a aVar) {
        InterceptResult invokeLLL;
        ImageSpan a2;
        double d2;
        int r;
        ImageSpan a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, context, str, aVar)) == null) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(d).matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                int f = this.b.f(group);
                if (f > 0) {
                    an h = h(f, String.valueOf(f));
                    if (h != null) {
                        int length = group.length();
                        int start = matcher.start();
                        BitmapDrawable j = h.j();
                        if (UbsABTestHelper.isResizeEmotionABTest()) {
                            d2 = 0.4d;
                            r = h.r();
                        } else {
                            d2 = 0.5d;
                            r = h.r();
                        }
                        int i = (int) (r * d2);
                        j.setBounds(0, 0, i, i);
                        spannableString.setSpan(new ImageSpan(j, 0), start, length + start, 33);
                    }
                } else if (aVar != null && (a3 = aVar.a(group)) != null) {
                    int length2 = group.length();
                    int start2 = matcher.start();
                    spannableString.setSpan(a3, start2, length2 + start2, 33);
                }
            }
            if (aVar == null) {
                return spannableString;
            }
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableString);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5 && (a2 = aVar.a(group2)) != null) {
                    int start3 = matcher2.start();
                    spannableString.setSpan(a2, start3, group2.length() + start3, 33);
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeLLL.objValue;
    }
}

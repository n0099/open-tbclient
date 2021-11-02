package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.c0.a;
import b.a.q0.c0.c;
import b.a.q0.f1.d;
import b.a.q0.s.g0.e;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.BitmapHelper;
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
/* loaded from: classes8.dex */
public class TbFaceManager {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static TbFaceManager f45945c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f45946d = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]|#[\\(]+[A-Za-z0-9_\\-\\u4e00-\\u9fa5]+[\\)]";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f45947a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.q0.c0.a f45948b;

    /* loaded from: classes8.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3736301305777944719L;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public String f45949c;
        public String text;
        public Integer type;

        public RichUnit() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45947a = null;
        this.f45948b = null;
    }

    public static TbFaceManager e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f45945c == null) {
                f45945c = new TbFaceManager();
            }
            return f45945c;
        }
        return (TbFaceManager) invokeV.objValue;
    }

    public b.a.e.l.d.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? d(b(str), str) : (b.a.e.l.d.a) invokeL.objValue;
    }

    public int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f45948b.d(str) : invokeL.intValue;
    }

    public a.C0639a c(String str) {
        InterceptResult invokeL;
        b.a.e.l.d.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            a.C0639a c2 = this.f45948b.c(this.f45947a, str);
            return (c2 != null || (a2 = a(str)) == null) ? c2 : new a.C0639a(a2.r(), a2.m());
        }
        return (a.C0639a) invokeL.objValue;
    }

    public final b.a.e.l.d.a d(int i2, String str) {
        InterceptResult invokeIL;
        Bitmap resBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, str)) == null) {
            b.a.e.l.d.a m = c.k().m(str);
            if (m != null || (resBitmap = BitmapHelper.getResBitmap(this.f45947a, i2)) == null) {
                return m;
            }
            b.a.e.l.d.a aVar = new b.a.e.l.d.a(resBitmap, false, str);
            c.k().d(str, aVar);
            return aVar;
        }
        return (b.a.e.l.d.a) invokeIL.objValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.f45948b.b(str) : (String) invokeL.objValue;
    }

    public int g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.f45948b.e(str) : invokeL.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f45948b.a() : invokeV.intValue;
    }

    public void i(Context context, b.a.q0.c0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, aVar) == null) {
            if (context != null && aVar != null) {
                this.f45947a = context;
                this.f45948b = aVar;
                return;
            }
            throw new InvalidParameterException("TbFaceManager initial error");
        }
    }

    public SpannableString j(Context context, String str) {
        InterceptResult invokeLL;
        b.a.e.l.d.a d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str)) == null) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(f45946d).matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                int e2 = this.f45948b.e(group);
                if (e2 > 0 && (d2 = d(e2, String.valueOf(e2))) != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable j = d2.j();
                    j.setBounds(0, 0, 55, 55);
                    spannableString.setSpan(new e(j, 0), start, length + start, 33);
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    public SpannableString k(Context context, String str, int i2, int i3) {
        InterceptResult invokeLLII;
        b.a.e.l.d.a d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048585, this, context, str, i2, i3)) == null) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(f45946d).matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                int e2 = this.f45948b.e(group);
                if (e2 > 0 && (d2 = d(e2, String.valueOf(e2))) != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable j = d2.j();
                    j.setBounds(0, 0, i2 > 0 ? i2 : d2.r(), i3 > 0 ? i3 : d2.m());
                    spannableString.setSpan(new d(j), start, length + start, 33);
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeLLII.objValue;
    }

    public SpannableString l(Context context, String str, a aVar) {
        InterceptResult invokeLLL;
        ImageSpan a2;
        double d2;
        int r;
        ImageSpan a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, context, str, aVar)) == null) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(f45946d).matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                int e2 = this.f45948b.e(group);
                if (e2 > 0) {
                    b.a.e.l.d.a d3 = d(e2, String.valueOf(e2));
                    if (d3 != null) {
                        int length = group.length();
                        int start = matcher.start();
                        BitmapDrawable j = d3.j();
                        if (b.a.q0.b.d.R()) {
                            d2 = 0.4d;
                            r = d3.r();
                        } else {
                            d2 = 0.5d;
                            r = d3.r();
                        }
                        int i2 = (int) (r * d2);
                        j.setBounds(0, 0, i2, i2);
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

package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.b0.a;
import c.a.o0.e1.d;
import c.a.o0.r.l0.e;
import c.a.o0.w.p.c;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes5.dex */
public class TbFaceManager {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static TbFaceManager f30565c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f30566d = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]|#[\\(]+[A-Za-z0-9_\\-\\u4e00-\\u9fa5]+[\\)]";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.o0.b0.a f30567b;

    /* loaded from: classes5.dex */
    public static class RichUnit extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3736301305777944719L;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public String f30568c;
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

    /* loaded from: classes5.dex */
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
        this.f30567b = null;
    }

    public static TbFaceManager e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f30565c == null) {
                f30565c = new TbFaceManager();
            }
            TbFaceManager tbFaceManager = f30565c;
            if (tbFaceManager.f30567b == null) {
                tbFaceManager.f30567b = new c();
                f30565c.a = TbadkCoreApplication.getInst();
            }
            return f30565c;
        }
        return (TbFaceManager) invokeV.objValue;
    }

    public c.a.d.o.d.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? d(b(str), str) : (c.a.d.o.d.a) invokeL.objValue;
    }

    public int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f30567b.d(str) : invokeL.intValue;
    }

    public a.C0786a c(String str) {
        InterceptResult invokeL;
        c.a.d.o.d.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            a.C0786a c2 = this.f30567b.c(this.a, str);
            return (c2 != null || (a2 = a(str)) == null) ? c2 : new a.C0786a(a2.r(), a2.m());
        }
        return (a.C0786a) invokeL.objValue;
    }

    public final c.a.d.o.d.a d(int i, String str) {
        InterceptResult invokeIL;
        Bitmap resBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, str)) == null) {
            c.a.d.o.d.a m = c.a.o0.b0.c.k().m(str);
            if (m != null || (resBitmap = BitmapHelper.getResBitmap(this.a, i)) == null) {
                return m;
            }
            c.a.d.o.d.a aVar = new c.a.d.o.d.a(resBitmap, false, str);
            c.a.o0.b0.c.k().d(str, aVar);
            return aVar;
        }
        return (c.a.d.o.d.a) invokeIL.objValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? this.f30567b.b(str) : (String) invokeL.objValue;
    }

    public int g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? this.f30567b.e(str) : invokeL.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f30567b.a() : invokeV.intValue;
    }

    public void i(Context context, c.a.o0.b0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, context, aVar) == null) {
            if (context != null && aVar != null) {
                this.a = context;
                this.f30567b = aVar;
                return;
            }
            throw new InvalidParameterException("TbFaceManager initial error");
        }
    }

    public SpannableString j(Context context, String str) {
        InterceptResult invokeLL;
        c.a.d.o.d.a d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str)) == null) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(f30566d).matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                int e2 = this.f30567b.e(group);
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

    public SpannableString k(Context context, String str, int i, int i2) {
        InterceptResult invokeLLII;
        c.a.d.o.d.a d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048585, this, context, str, i, i2)) == null) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(f30566d).matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                int e2 = this.f30567b.e(group);
                if (e2 > 0 && (d2 = d(e2, String.valueOf(e2))) != null) {
                    int length = group.length();
                    int start = matcher.start();
                    BitmapDrawable j = d2.j();
                    j.setBounds(0, 0, i > 0 ? i : d2.r(), i2 > 0 ? i2 : d2.m());
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
            Matcher matcher = Pattern.compile(f30566d).matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                int e2 = this.f30567b.e(group);
                if (e2 > 0) {
                    c.a.d.o.d.a d3 = d(e2, String.valueOf(e2));
                    if (d3 != null) {
                        int length = group.length();
                        int start = matcher.start();
                        BitmapDrawable j = d3.j();
                        if (UbsABTestHelper.isResizeEmotionABTest()) {
                            d2 = 0.4d;
                            r = d3.r();
                        } else {
                            d2 = 0.5d;
                            r = d3.r();
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

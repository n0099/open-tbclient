package com.baidu.tbadk.imageManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.widget.VCenterTextSpan;
import com.baidu.tieba.d55;
import com.baidu.tieba.gy5;
import com.baidu.tieba.l07;
import com.baidu.tieba.qe5;
import com.baidu.tieba.vi5;
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
    public static TbFaceManager c = null;
    public static String d = "#[\\(][\\w?~！]+[\\)]|\\[[\\u4e00-\\u9fa5\\w]+\\]|#[\\(]+[A-Za-z0-9_\\-\\u4e00-\\u9fa5]+[\\)]";
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public vi5 b;

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

    /* loaded from: classes5.dex */
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

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b.a();
        }
        return invokeV.intValue;
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
                tbFaceManager.b = new qe5();
                c.a = TbadkCoreApplication.getInst();
            }
            return c;
        }
        return (TbFaceManager) invokeV.objValue;
    }

    public BdImage a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return h(e(str), str);
        }
        return (BdImage) invokeL.objValue;
    }

    public Bitmap b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return BitmapHelper.getCashBitmap(e(str));
        }
        return (Bitmap) invokeL.objValue;
    }

    public gy5 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return new gy5(TbadkCoreApplication.getInst().getContext(), e(str));
        }
        return (gy5) invokeL.objValue;
    }

    public gy5 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return new gy5(TbadkCoreApplication.getInst().getContext(), l(str));
        }
        return (gy5) invokeL.objValue;
    }

    public final int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            return this.b.e(str);
        }
        return invokeL.intValue;
    }

    public vi5.a f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            BdImage a2 = a(str);
            if (a2 != null) {
                return new vi5.a(a2.getWidth(), a2.getHeight());
            }
            return null;
        }
        return (vi5.a) invokeL.objValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            return this.b.c(str);
        }
        return (String) invokeL.objValue;
    }

    public BdImage k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return h(l(str), str);
        }
        return (BdImage) invokeL.objValue;
    }

    public final int l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            return this.b.f(str);
        }
        return invokeL.intValue;
    }

    public String n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            return this.b.b(i);
        }
        return (String) invokeI.objValue;
    }

    public boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            if (e(str) > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (this.b.f(str) > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public vi5.a g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            int l = l(str);
            BdImage h = h(l, this.b.d(l));
            if (h != null) {
                return new vi5.a(h.getWidth(), h.getHeight());
            }
            return null;
        }
        return (vi5.a) invokeL.objValue;
    }

    public final BdImage h(int i, String str) {
        InterceptResult invokeIL;
        Bitmap resBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, str)) == null) {
            BdImage D = TbImageMemoryCache.B().D(str);
            if (D == null && (resBitmap = BitmapHelper.getResBitmap(this.a, i)) != null) {
                BdImage bdImage = new BdImage(resBitmap, false, str);
                TbImageMemoryCache.B().l(str, bdImage);
                return bdImage;
            }
            return D;
        }
        return (BdImage) invokeIL.objValue;
    }

    public void q(Context context, vi5 vi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, vi5Var) == null) {
            if (context != null && vi5Var != null) {
                this.a = context;
                this.b = vi5Var;
                return;
            }
            throw new InvalidParameterException("TbFaceManager initial error");
        }
    }

    public SpannableString r(Context context, String str) {
        InterceptResult invokeLL;
        BdImage h;
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
                    BitmapDrawable asBitmapDrawable = h.getAsBitmapDrawable();
                    asBitmapDrawable.setBounds(0, 0, 55, 55);
                    spannableString.setSpan(new d55(asBitmapDrawable, 0), start, length + start, 33);
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    public SpannableString u(Context context, String str) {
        InterceptResult invokeLL;
        BdImage h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, context, str)) == null) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(d).matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                int f = this.b.f(group);
                if (f > 0 && (h = h(f, String.valueOf(f))) != null) {
                    ImageSpan b = l07.b(h, EmotionGroupType.LOCAL, null, null);
                    int length = group.length();
                    int start = matcher.start();
                    spannableString.setSpan(b, start, length + start, 33);
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeLL.objValue;
    }

    public SpannableString s(Context context, String str, int i, int i2) {
        InterceptResult invokeLLII;
        BdImage h;
        int width;
        int height;
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
                    BitmapDrawable asBitmapDrawable = h.getAsBitmapDrawable();
                    if (i > 0) {
                        width = i;
                    } else {
                        width = h.getWidth();
                    }
                    if (i2 > 0) {
                        height = i2;
                    } else {
                        height = h.getHeight();
                    }
                    asBitmapDrawable.setBounds(0, 0, width, height);
                    spannableString.setSpan(new VCenterTextSpan(asBitmapDrawable), start, length + start, 33);
                }
            }
            return spannableString;
        }
        return (SpannableString) invokeLLII.objValue;
    }

    public SpannableString t(Context context, String str, a aVar) {
        InterceptResult invokeLLL;
        ImageSpan a2;
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
                    BdImage h = h(f, String.valueOf(f));
                    if (h != null) {
                        int length = group.length();
                        int start = matcher.start();
                        BitmapDrawable asBitmapDrawable = h.getAsBitmapDrawable();
                        int width = (int) (h.getWidth() * 0.4d);
                        asBitmapDrawable.setBounds(0, 0, width, width);
                        spannableString.setSpan(new ImageSpan(asBitmapDrawable, 0), start, length + start, 33);
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

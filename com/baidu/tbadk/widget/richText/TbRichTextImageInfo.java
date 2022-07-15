package com.baidu.tbadk.widget.richText;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.PbContent;
/* loaded from: classes3.dex */
public class TbRichTextImageInfo extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public boolean f;
    public boolean g;
    public String h;
    public long i;
    public boolean j;
    public boolean k;
    public String l;
    public String m;
    public long n;

    public TbRichTextImageInfo() {
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = 1;
        this.e = 1;
        this.f = false;
        this.g = false;
        this.h = null;
        this.i = 0L;
        this.j = false;
        this.k = false;
        this.m = null;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public long F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.n : invokeV.longValue;
    }

    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f : invokeV.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.k = z;
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.h = str;
        }
    }

    public void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.a = str;
        }
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.e : invokeV.intValue;
    }

    public long getOriginalSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.i : invokeV.longValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.d : invokeV.intValue;
    }

    public void setHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.e = i;
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.d = i;
        }
    }

    public TbRichTextImageInfo(PbContent pbContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbContent};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = 1;
        this.e = 1;
        this.f = false;
        this.g = false;
        this.h = null;
        this.i = 0L;
        this.j = false;
        this.k = false;
        this.m = null;
        if (pbContent == null) {
            return;
        }
        this.a = pbContent.src;
        String str = pbContent.cdn_src;
        this.b = str;
        if (str == null || str.length() == 0) {
            this.b = this.a;
        }
        String str2 = pbContent.big_cdn_src;
        this.c = str2;
        this.m = pbContent.big_src;
        if (StringUtils.isNull(str2)) {
            this.c = this.m;
        }
        this.n = pbContent.pic_id.longValue();
        String str3 = pbContent.bsize;
        if (str3 != null) {
            try {
                String[] split = str3.split(",");
                this.d = Integer.valueOf(split[0]).intValue();
                this.e = Integer.valueOf(split[1]).intValue();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.d <= 0) {
            this.d = 1;
        }
        if (this.e <= 0) {
            this.e = 1;
        }
        String str4 = this.b;
        if (str4 != null && str4.indexOf(".baidu.com") != -1) {
            this.f = true;
        }
        this.h = pbContent.origin_src;
        this.i = pbContent.origin_size.intValue();
        this.j = pbContent.show_original_btn.intValue() == 1;
        this.k = pbContent.is_long_pic.intValue() == 1;
        this.l = pbContent.cdn_src_active;
    }

    public TbRichTextImageInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
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
        this.c = null;
        this.d = 1;
        this.e = 1;
        this.f = false;
        this.g = false;
        this.h = null;
        this.i = 0L;
        this.j = false;
        this.k = false;
        this.m = null;
        if (jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("src");
        String optString = jSONObject.optString("cdn_src", "");
        this.b = optString;
        if (optString == null || optString.length() == 0) {
            this.b = this.a;
        }
        this.c = jSONObject.optString("big_cdn_src", null);
        try {
            String[] split = jSONObject.optString("bsize").split(",");
            this.d = Integer.valueOf(split[0]).intValue();
            this.e = Integer.valueOf(split[1]).intValue();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        if (this.d <= 0) {
            this.d = 1;
        }
        if (this.e <= 0) {
            this.e = 1;
        }
        String str = this.b;
        if (str == null || str.indexOf(".baidu.com") == -1) {
            return;
        }
        this.f = true;
    }
}

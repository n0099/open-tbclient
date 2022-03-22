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
/* loaded from: classes5.dex */
public class TbRichTextImageInfo extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f30943b;

    /* renamed from: c  reason: collision with root package name */
    public String f30944c;

    /* renamed from: d  reason: collision with root package name */
    public int f30945d;

    /* renamed from: e  reason: collision with root package name */
    public int f30946e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30947f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30948g;

    /* renamed from: h  reason: collision with root package name */
    public String f30949h;
    public long i;
    public boolean j;
    public boolean k;
    public String l;
    public String m;

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
        this.f30943b = null;
        this.f30944c = null;
        this.f30945d = 1;
        this.f30946e = 1;
        this.f30947f = false;
        this.f30948g = false;
        this.f30949h = null;
        this.i = 0L;
        this.j = false;
        this.k = false;
        this.m = null;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30943b : (String) invokeV.objValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f30949h : (String) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30948g : invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30947f : invokeV.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.k = z;
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.f30949h = str;
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.a = str;
        }
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f30946e : invokeV.intValue;
    }

    public long getOriginalSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.i : invokeV.longValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f30945d : invokeV.intValue;
    }

    public void setHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.f30946e = i;
        }
    }

    public void setWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.f30945d = i;
        }
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f30944c : (String) invokeV.objValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.m : (String) invokeV.objValue;
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
        this.f30943b = null;
        this.f30944c = null;
        this.f30945d = 1;
        this.f30946e = 1;
        this.f30947f = false;
        this.f30948g = false;
        this.f30949h = null;
        this.i = 0L;
        this.j = false;
        this.k = false;
        this.m = null;
        if (pbContent == null) {
            return;
        }
        this.a = pbContent.src;
        String str = pbContent.cdn_src;
        this.f30943b = str;
        if (str == null || str.length() == 0) {
            this.f30943b = this.a;
        }
        String str2 = pbContent.big_cdn_src;
        this.f30944c = str2;
        this.m = pbContent.big_src;
        if (StringUtils.isNull(str2)) {
            this.f30944c = this.m;
        }
        String str3 = pbContent.bsize;
        if (str3 != null) {
            try {
                String[] split = str3.split(",");
                this.f30945d = Integer.valueOf(split[0]).intValue();
                this.f30946e = Integer.valueOf(split[1]).intValue();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        if (this.f30945d <= 0) {
            this.f30945d = 1;
        }
        if (this.f30946e <= 0) {
            this.f30946e = 1;
        }
        String str4 = this.f30943b;
        if (str4 != null && str4.indexOf(".baidu.com") != -1) {
            this.f30947f = true;
        }
        this.f30949h = pbContent.origin_src;
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
        this.f30943b = null;
        this.f30944c = null;
        this.f30945d = 1;
        this.f30946e = 1;
        this.f30947f = false;
        this.f30948g = false;
        this.f30949h = null;
        this.i = 0L;
        this.j = false;
        this.k = false;
        this.m = null;
        if (jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("src");
        String optString = jSONObject.optString("cdn_src", "");
        this.f30943b = optString;
        if (optString == null || optString.length() == 0) {
            this.f30943b = this.a;
        }
        this.f30944c = jSONObject.optString("big_cdn_src", null);
        try {
            String[] split = jSONObject.optString("bsize").split(",");
            this.f30945d = Integer.valueOf(split[0]).intValue();
            this.f30946e = Integer.valueOf(split[1]).intValue();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (this.f30945d <= 0) {
            this.f30945d = 1;
        }
        if (this.f30946e <= 0) {
            this.f30946e = 1;
        }
        String str = this.f30943b;
        if (str == null || str.indexOf(".baidu.com") == -1) {
            return;
        }
        this.f30947f = true;
    }
}

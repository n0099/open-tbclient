package com.baidu.tbadk.widget.richText;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes5.dex */
public class TbRichTextCommInfo extends OrmObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NATIVE_APP_TYPE = 1;
    public static final int TYPE_LINK = 1;
    public static final int TYPE_VIDEO = 5;
    public static final int URL_VALIDITY_INVALID = 1;
    public static final int URL_VALIDITY_NORMAL = 0;
    public static final int URL_VALIDITY_VALID = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f30929b;

    /* renamed from: c  reason: collision with root package name */
    public String f30930c;

    /* renamed from: d  reason: collision with root package name */
    public String f30931d;

    /* renamed from: e  reason: collision with root package name */
    public int f30932e;

    /* renamed from: f  reason: collision with root package name */
    public int f30933f;

    /* renamed from: g  reason: collision with root package name */
    public String f30934g;

    /* renamed from: h  reason: collision with root package name */
    public String f30935h;
    public int i;
    @Nullable
    public PbContent j;

    public TbRichTextCommInfo() {
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
        this.f30929b = null;
        this.f30930c = null;
        this.f30931d = null;
        this.f30932e = 0;
        this.i = 0;
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f30934g : (String) invokeV.objValue;
    }

    @Nullable
    public PbContent B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : (PbContent) invokeV.objValue;
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : invokeV.intValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String str = this.a;
            if (str != null) {
                this.a = str.replaceAll("\n", "");
            }
            String str2 = this.f30929b;
            if (str2 != null) {
                this.f30929b = str2.replaceAll("\n", "");
            }
        }
    }

    public String getItemForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f30931d : (String) invokeV.objValue;
    }

    public String getLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f30929b : (String) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    public void setLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.f30929b = str;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.a = str;
        }
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f30933f : invokeV.intValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f30930c : (String) invokeV.objValue;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
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
        this.f30929b = null;
        this.f30930c = null;
        this.f30931d = null;
        this.f30932e = 0;
        this.i = 0;
        if (jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("text");
        this.f30929b = jSONObject.optString("link");
        this.f30930c = jSONObject.optString("item_id");
        this.f30932e = jSONObject.optInt("type", 0);
        this.i = jSONObject.optInt("url_type", 0);
        int optInt = jSONObject.optInt("is_native_app", 0);
        this.f30933f = optInt;
        if (optInt != 1) {
            return;
        }
        if (jSONObject.optJSONObject("native_app") == null) {
            this.f30933f = 0;
            return;
        }
        this.f30934g = jSONObject.optString("jump_and");
        this.f30935h = jSONObject.optString("download_and");
        if (!TextUtils.isEmpty(this.f30934g) && !TextUtils.isEmpty(this.f30935h)) {
            int i3 = this.f30932e;
            if (i3 == 1) {
                this.f30934g += ";download_url:" + this.f30935h + ";web_play_url:" + this.f30929b;
            } else if (i3 == 5) {
                this.f30934g += ";download_url:" + this.f30935h + ";web_play_url:" + this.a;
            }
            this.f30934g += ";is_native_app=1";
            return;
        }
        this.f30933f = 0;
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbContent};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.a = null;
        this.f30929b = null;
        this.f30930c = null;
        this.f30931d = null;
        this.f30932e = 0;
        this.i = 0;
        if (pbContent == null) {
            return;
        }
        this.j = pbContent;
        this.a = pbContent.text;
        this.f30929b = pbContent.link;
        this.f30932e = pbContent.type.intValue();
        this.f30930c = pbContent.item_id + "";
        this.f30931d = pbContent.item_forum_name;
        this.i = pbContent.url_type.intValue();
        int intValue = pbContent.is_native_app.intValue();
        this.f30933f = intValue;
        if (intValue != 1) {
            return;
        }
        NativeApp nativeApp = pbContent.native_app;
        if (nativeApp == null) {
            this.f30933f = 0;
            return;
        }
        String str = nativeApp.jump_and;
        this.f30934g = str;
        this.f30935h = nativeApp.download_and;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f30935h)) {
            int i3 = this.f30932e;
            if (i3 == 1) {
                this.f30934g += ";download_url:" + this.f30935h + ";web_play_url:" + this.f30929b;
            } else if (i3 == 5) {
                this.f30934g += ";download_url:" + this.f30935h + ";web_play_url:" + this.a;
            }
            this.f30934g += ";is_native_app=1";
            return;
        }
        this.f30933f = 0;
    }

    public TbRichTextCommInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
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
        this.f30929b = null;
        this.f30930c = null;
        this.f30931d = null;
        this.f30932e = 0;
        this.i = 0;
        this.a = str;
        this.f30929b = str2;
    }
}

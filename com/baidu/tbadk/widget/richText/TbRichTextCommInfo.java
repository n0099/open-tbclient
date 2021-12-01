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
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import tbclient.NativeApp;
import tbclient.PbContent;
/* loaded from: classes9.dex */
public class TbRichTextCommInfo extends OrmObject {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NATIVE_APP_TYPE = 1;
    public static final int TYPE_LINK = 1;
    public static final int TYPE_VIDEO = 5;
    public static final int URL_VALIDITY_INVALID = 1;
    public static final int URL_VALIDITY_NORMAL = 0;
    public static final int URL_VALIDITY_VALID = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f42297e;

    /* renamed from: f  reason: collision with root package name */
    public String f42298f;

    /* renamed from: g  reason: collision with root package name */
    public String f42299g;

    /* renamed from: h  reason: collision with root package name */
    public String f42300h;

    /* renamed from: i  reason: collision with root package name */
    public int f42301i;

    /* renamed from: j  reason: collision with root package name */
    public int f42302j;

    /* renamed from: k  reason: collision with root package name */
    public String f42303k;
    public String l;
    public int m;
    @Nullable
    public PbContent n;

    public TbRichTextCommInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f42297e = null;
        this.f42298f = null;
        this.f42299g = null;
        this.f42300h = null;
        this.f42301i = 0;
        this.m = 0;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.m : invokeV.intValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String str = this.f42297e;
            if (str != null) {
                this.f42297e = str.replaceAll(StringUtils.LF, "");
            }
            String str2 = this.f42298f;
            if (str2 != null) {
                this.f42298f = str2.replaceAll(StringUtils.LF, "");
            }
        }
    }

    public String getItemForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f42300h : (String) invokeV.objValue;
    }

    public String getLink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f42298f : (String) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f42297e : (String) invokeV.objValue;
    }

    public void setLink(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f42298f = str;
        }
    }

    public void setText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f42297e = str;
        }
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f42302j : invokeV.intValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f42299g : (String) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f42303k : (String) invokeV.objValue;
    }

    @Nullable
    public PbContent z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.n : (PbContent) invokeV.objValue;
    }

    public TbRichTextCommInfo(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f42297e = null;
        this.f42298f = null;
        this.f42299g = null;
        this.f42300h = null;
        this.f42301i = 0;
        this.m = 0;
        if (jSONObject == null) {
            return;
        }
        this.f42297e = jSONObject.optString("text");
        this.f42298f = jSONObject.optString("link");
        this.f42299g = jSONObject.optString("item_id");
        this.f42301i = jSONObject.optInt("type", 0);
        this.m = jSONObject.optInt("url_type", 0);
        int optInt = jSONObject.optInt("is_native_app", 0);
        this.f42302j = optInt;
        if (optInt != 1) {
            return;
        }
        if (jSONObject.optJSONObject("native_app") == null) {
            this.f42302j = 0;
            return;
        }
        this.f42303k = jSONObject.optString("jump_and");
        this.l = jSONObject.optString("download_and");
        if (!TextUtils.isEmpty(this.f42303k) && !TextUtils.isEmpty(this.l)) {
            int i4 = this.f42301i;
            if (i4 == 1) {
                this.f42303k += ";download_url:" + this.l + ";web_play_url:" + this.f42298f;
            } else if (i4 == 5) {
                this.f42303k += ";download_url:" + this.l + ";web_play_url:" + this.f42297e;
            }
            this.f42303k += ";is_native_app=1";
            return;
        }
        this.f42302j = 0;
    }

    public TbRichTextCommInfo(PbContent pbContent) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbContent};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f42297e = null;
        this.f42298f = null;
        this.f42299g = null;
        this.f42300h = null;
        this.f42301i = 0;
        this.m = 0;
        if (pbContent == null) {
            return;
        }
        this.n = pbContent;
        this.f42297e = pbContent.text;
        this.f42298f = pbContent.link;
        this.f42301i = pbContent.type.intValue();
        this.f42299g = pbContent.item_id + "";
        this.f42300h = pbContent.item_forum_name;
        this.m = pbContent.url_type.intValue();
        int intValue = pbContent.is_native_app.intValue();
        this.f42302j = intValue;
        if (intValue != 1) {
            return;
        }
        NativeApp nativeApp = pbContent.native_app;
        if (nativeApp == null) {
            this.f42302j = 0;
            return;
        }
        String str = nativeApp.jump_and;
        this.f42303k = str;
        this.l = nativeApp.download_and;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.l)) {
            int i4 = this.f42301i;
            if (i4 == 1) {
                this.f42303k += ";download_url:" + this.l + ";web_play_url:" + this.f42298f;
            } else if (i4 == 5) {
                this.f42303k += ";download_url:" + this.l + ";web_play_url:" + this.f42297e;
            }
            this.f42303k += ";is_native_app=1";
            return;
        }
        this.f42302j = 0;
    }

    public TbRichTextCommInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f42297e = null;
        this.f42298f = null;
        this.f42299g = null;
        this.f42300h = null;
        this.f42301i = 0;
        this.m = 0;
        this.f42297e = str;
        this.f42298f = str2;
    }
}

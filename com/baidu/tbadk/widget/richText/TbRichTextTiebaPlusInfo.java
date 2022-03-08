package com.baidu.tbadk.widget.richText;

import androidx.core.view.InputDeviceCompat;
import c.a.q0.r.r.e2;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
/* loaded from: classes5.dex */
public class TbRichTextTiebaPlusInfo extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TiebaPlusInfo f40140e;

    /* renamed from: f  reason: collision with root package name */
    public final int f40141f;

    /* renamed from: g  reason: collision with root package name */
    public String f40142g;

    /* renamed from: h  reason: collision with root package name */
    public String f40143h;

    /* renamed from: i  reason: collision with root package name */
    public e2 f40144i;

    public TbRichTextTiebaPlusInfo(int i2, TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), tiebaPlusInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f40140e = tiebaPlusInfo;
        this.f40141f = i2;
    }

    public void A(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, e2Var) == null) {
            this.f40144i = e2Var;
        }
    }

    public void B(TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tiebaPlusInfo) == null) {
            this.f40140e = tiebaPlusInfo;
        }
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f40143h : (String) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f40141f : invokeV.intValue;
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f40143h = str;
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f40142g = str;
        }
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            e2 e2Var = this.f40144i;
            return e2Var == null ? "0" : String.valueOf(e2Var.R());
        }
        return (String) invokeV.objValue;
    }

    public e2 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f40144i : (e2) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f40142g : (String) invokeV.objValue;
    }

    public TiebaPlusInfo z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f40140e : (TiebaPlusInfo) invokeV.objValue;
    }

    public TbRichTextTiebaPlusInfo(int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40141f = i2;
        TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder();
        builder.title = jSONObject.optString("title");
        builder.desc = jSONObject.optString("desc");
        builder.jump_url = jSONObject.optString("jump_url");
        builder.download_url = jSONObject.optString("download_url");
        builder.app_id = jSONObject.optString("app_id");
        builder.app_icon = jSONObject.optString("app_icon");
        builder.app_package = jSONObject.optString("app_package");
        builder.app_version = jSONObject.optString("app_version");
        builder.app_privacy = jSONObject.optString("app_privacy");
        builder.app_power = jSONObject.optString("app_power");
        builder.app_company = jSONObject.optString("app_company");
        builder.target_type = Integer.valueOf(jSONObject.optInt(GameGuideConfigInfo.KEY_TARGET_TYPE));
        builder.h5_jump_type = Integer.valueOf(jSONObject.optInt("h5_jump_type"));
        builder.h5_jump_number = jSONObject.optString("h5_jump_number");
        builder.h5_jump_param = jSONObject.optString("h5_jump_param");
        builder.jump_type = Integer.valueOf(jSONObject.optInt("jump_type"));
        builder.item_id = jSONObject.optString("item_id");
        builder.is_appoint = Integer.valueOf(jSONObject.optInt("is_appoint"));
        JSONObject optJSONObject = jSONObject.optJSONObject("plugin_user");
        if (optJSONObject != null) {
            PluginUser.Builder builder2 = new PluginUser.Builder();
            builder2.user_type = Integer.valueOf(optJSONObject.optInt("user_type"));
            builder2.user_id = Long.valueOf(optJSONObject.optLong("user_id"));
            builder2.user_name_show = optJSONObject.optString("user_name_show");
            builder2.user_photo = optJSONObject.optString("user_photo");
            builder.plugin_user = builder2.build(true);
        }
        builder.forum_name = jSONObject.optString("forum_name");
        builder.jump_setting = Integer.valueOf(jSONObject.optInt("jump_setting"));
        builder.wx_thumbnail = jSONObject.optString("wx_thumbnail");
        builder.button_desc = jSONObject.optString("button_desc");
        this.f40140e = builder.build(true);
    }
}

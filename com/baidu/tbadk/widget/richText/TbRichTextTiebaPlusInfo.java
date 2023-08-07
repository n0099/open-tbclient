package com.baidu.tbadk.widget.richText;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
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
    public TiebaPlusInfo a;
    public final int b;
    public String c;
    public String d;
    public ThreadData e;

    public TbRichTextTiebaPlusInfo(int i, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = i;
        TiebaPlusInfo.Builder builder = new TiebaPlusInfo.Builder();
        builder.title = jSONObject.optString("title");
        builder.desc = jSONObject.optString("desc");
        builder.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
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
        this.a = builder.build(true);
    }

    public TbRichTextTiebaPlusInfo(int i, TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), tiebaPlusInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = tiebaPlusInfo;
        this.b = i;
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ThreadData threadData = this.e;
            if (threadData == null) {
                return "0";
            }
            return String.valueOf(threadData.getDispatchedForumId());
        }
        return (String) invokeV.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public TiebaPlusInfo P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (TiebaPlusInfo) invokeV.objValue;
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (ThreadData) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public void Q(TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tiebaPlusInfo) == null) {
            this.a = tiebaPlusInfo;
        }
    }

    public void setForumId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.d = str;
        }
    }

    public void setThreadData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData) == null) {
            this.e = threadData;
        }
    }

    public void setTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.c = str;
        }
    }
}

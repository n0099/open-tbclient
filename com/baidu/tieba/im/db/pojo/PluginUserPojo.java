package com.baidu.tieba.im.db.pojo;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.PluginUser;
/* loaded from: classes4.dex */
public class PluginUserPojo extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Integer isDownloadCardWhiteuser;
    public Long userId;
    public String userNameShow;
    public String userPhoto;
    public Integer userType;

    public PluginUserPojo() {
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

    public static PluginUserPojo R(PluginUser pluginUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, pluginUser)) == null) {
            if (pluginUser == null) {
                return null;
            }
            PluginUserPojo pluginUserPojo = new PluginUserPojo();
            pluginUserPojo.userId = pluginUser.userId;
            pluginUserPojo.userNameShow = pluginUser.userNameShow;
            pluginUserPojo.userType = pluginUser.userType;
            pluginUserPojo.userPhoto = pluginUser.userPhoto;
            pluginUserPojo.isDownloadCardWhiteuser = pluginUser.isDownloadCardWhiteuser;
            return pluginUserPojo;
        }
        return (PluginUserPojo) invokeL.objValue;
    }

    public static PluginUserPojo S(tbclient.PluginUser pluginUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, pluginUser)) == null) {
            if (pluginUser == null) {
                return null;
            }
            PluginUserPojo pluginUserPojo = new PluginUserPojo();
            pluginUserPojo.userId = pluginUser.user_id;
            pluginUserPojo.userNameShow = pluginUser.user_name_show;
            pluginUserPojo.userType = pluginUser.user_type;
            pluginUserPojo.userPhoto = pluginUser.user_photo;
            pluginUserPojo.isDownloadCardWhiteuser = pluginUser.is_download_card_whiteuser;
            return pluginUserPojo;
        }
        return (PluginUserPojo) invokeL.objValue;
    }
}

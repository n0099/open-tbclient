package com.baidu.tieba.im.db.pojo;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.TiebaPlusInfo;
/* loaded from: classes6.dex */
public class TiebaPlusInfoPojo extends OrmObject {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String appCompany;
    public String appIcon;
    public String appId;
    public String appPackage;
    public String appPower;
    public String appPrivacy;
    public String appVersion;
    public String buttonDesc;
    public String desc;
    public String downloadUrl;
    public String forumName;
    public String h5JumpNumber;
    public String h5JumpParam;
    public Integer h5JumpType;
    public Integer isAppoint;
    public String itemId;
    public Integer jumpSetting;
    public Integer jumpType;
    public String jumpUrl;
    public PluginUserPojo pluginUser;
    public Integer targetType;
    public String title;
    public String wxThumbnail;

    public TiebaPlusInfoPojo() {
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

    public static TiebaPlusInfoPojo V(TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tiebaPlusInfo)) == null) {
            if (tiebaPlusInfo == null) {
                return null;
            }
            TiebaPlusInfoPojo tiebaPlusInfoPojo = new TiebaPlusInfoPojo();
            tiebaPlusInfoPojo.title = tiebaPlusInfo.title;
            tiebaPlusInfoPojo.desc = tiebaPlusInfo.desc;
            tiebaPlusInfoPojo.jumpUrl = tiebaPlusInfo.jumpUrl;
            tiebaPlusInfoPojo.downloadUrl = tiebaPlusInfo.downloadUrl;
            tiebaPlusInfoPojo.appId = tiebaPlusInfo.appId;
            tiebaPlusInfoPojo.appIcon = tiebaPlusInfo.appIcon;
            tiebaPlusInfoPojo.appPackage = tiebaPlusInfo.appPackage;
            tiebaPlusInfoPojo.appVersion = tiebaPlusInfo.appVersion;
            tiebaPlusInfoPojo.appPrivacy = tiebaPlusInfo.appPrivacy;
            tiebaPlusInfoPojo.appPower = tiebaPlusInfo.appPower;
            tiebaPlusInfoPojo.appCompany = tiebaPlusInfo.appCompany;
            tiebaPlusInfoPojo.targetType = tiebaPlusInfo.targetType;
            tiebaPlusInfoPojo.h5JumpType = tiebaPlusInfo.h5JumpType;
            tiebaPlusInfoPojo.h5JumpNumber = tiebaPlusInfo.h5JumpNumber;
            tiebaPlusInfoPojo.jumpType = tiebaPlusInfo.jumpType;
            tiebaPlusInfoPojo.itemId = tiebaPlusInfo.itemId;
            tiebaPlusInfoPojo.isAppoint = tiebaPlusInfo.isAppoint;
            tiebaPlusInfoPojo.pluginUser = PluginUserPojo.V(tiebaPlusInfo.pluginUser);
            tiebaPlusInfoPojo.forumName = tiebaPlusInfo.forumName;
            tiebaPlusInfoPojo.jumpSetting = tiebaPlusInfo.jumpSetting;
            tiebaPlusInfoPojo.wxThumbnail = tiebaPlusInfo.wxThumbnail;
            tiebaPlusInfoPojo.buttonDesc = tiebaPlusInfo.buttonDesc;
            return tiebaPlusInfoPojo;
        }
        return (TiebaPlusInfoPojo) invokeL.objValue;
    }

    public static TiebaPlusInfoPojo W(tbclient.TiebaPlusInfo tiebaPlusInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tiebaPlusInfo)) == null) {
            if (tiebaPlusInfo == null) {
                return null;
            }
            TiebaPlusInfoPojo tiebaPlusInfoPojo = new TiebaPlusInfoPojo();
            tiebaPlusInfoPojo.title = tiebaPlusInfo.title;
            tiebaPlusInfoPojo.desc = tiebaPlusInfo.desc;
            tiebaPlusInfoPojo.jumpUrl = tiebaPlusInfo.jump_url;
            tiebaPlusInfoPojo.downloadUrl = tiebaPlusInfo.download_url;
            tiebaPlusInfoPojo.appId = tiebaPlusInfo.app_id;
            tiebaPlusInfoPojo.appIcon = tiebaPlusInfo.app_icon;
            tiebaPlusInfoPojo.appPackage = tiebaPlusInfo.app_package;
            tiebaPlusInfoPojo.appVersion = tiebaPlusInfo.app_version;
            tiebaPlusInfoPojo.appPrivacy = tiebaPlusInfo.app_privacy;
            tiebaPlusInfoPojo.appPower = tiebaPlusInfo.app_power;
            tiebaPlusInfoPojo.appCompany = tiebaPlusInfo.app_company;
            tiebaPlusInfoPojo.targetType = tiebaPlusInfo.target_type;
            tiebaPlusInfoPojo.h5JumpType = tiebaPlusInfo.h5_jump_type;
            tiebaPlusInfoPojo.h5JumpNumber = tiebaPlusInfo.h5_jump_number;
            tiebaPlusInfoPojo.jumpType = tiebaPlusInfo.jump_type;
            tiebaPlusInfoPojo.itemId = tiebaPlusInfo.item_id;
            tiebaPlusInfoPojo.isAppoint = tiebaPlusInfo.is_appoint;
            tiebaPlusInfoPojo.pluginUser = PluginUserPojo.W(tiebaPlusInfo.plugin_user);
            tiebaPlusInfoPojo.forumName = tiebaPlusInfo.forum_name;
            tiebaPlusInfoPojo.jumpSetting = tiebaPlusInfo.jump_setting;
            tiebaPlusInfoPojo.wxThumbnail = tiebaPlusInfo.wx_thumbnail;
            tiebaPlusInfoPojo.buttonDesc = tiebaPlusInfo.button_desc;
            return tiebaPlusInfoPojo;
        }
        return (TiebaPlusInfoPojo) invokeL.objValue;
    }
}

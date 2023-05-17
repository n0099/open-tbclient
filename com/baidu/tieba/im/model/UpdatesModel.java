package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class UpdatesModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UpdatesModel() {
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

    public static UpdatesItemData convertToUpdatesItem(GroupNewsPojo groupNewsPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, groupNewsPojo)) == null) {
            String content = groupNewsPojo.getContent();
            if (TextUtils.isEmpty(content)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                if (jSONObject.isNull("notice_id")) {
                    UpdatesItemData updatesItemData = new UpdatesItemData();
                    updatesItemData.setNotice_id(groupNewsPojo.getNotice_id());
                    updatesItemData.setContent(jSONObject.optString(TbEnum.SystemMessage.KEY_USER_MSG));
                    JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                    if (optJSONObject == null) {
                        return null;
                    }
                    updatesItemData.setUpdatesType(groupNewsPojo.getCmd());
                    updatesItemData.setGroupHeadUrl(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_IMAGE));
                    updatesItemData.setGroupId(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID));
                    updatesItemData.setGroupName(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_NAME));
                    updatesItemData.setAuthorId(optJSONObject.optString("                                                                                                                                                                   "));
                    updatesItemData.setAuthorName(optJSONObject.optString("authorName"));
                    updatesItemData.setTime(groupNewsPojo.getTime());
                    updatesItemData.setTitle(optJSONObject.optString("title"));
                    return updatesItemData;
                }
                return (UpdatesItemData) OrmObject.objectWithJsonStr(content, UpdatesItemData.class);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (UpdatesItemData) invokeL.objValue;
    }
}

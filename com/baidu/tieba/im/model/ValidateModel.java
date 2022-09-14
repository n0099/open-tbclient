package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.ej;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.y97;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ValidateModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ValidateModel() {
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

    public static ValidateItemData convertToValidateItemData(GroupNewsPojo groupNewsPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, groupNewsPojo)) == null) {
            if (groupNewsPojo == null) {
                return null;
            }
            String content = groupNewsPojo.getContent();
            if (TextUtils.isEmpty(content)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                if (jSONObject.isNull("notice_id")) {
                    ValidateItemData validateItemData = new ValidateItemData();
                    validateItemData.setNotice_id(groupNewsPojo.getNotice_id());
                    validateItemData.setApplyTime(groupNewsPojo.getTime());
                    JSONObject optJSONObject = jSONObject.optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                    if (optJSONObject == null) {
                        return null;
                    }
                    validateItemData.setUserName(optJSONObject.optString(TbEnum.SystemMessage.KEY_USER_NAME));
                    validateItemData.setPortrait(optJSONObject.optString("portrait"));
                    String optString = optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID);
                    validateItemData.setGroupId(optString);
                    setGroupName(validateItemData, optString);
                    validateItemData.setUserId(optJSONObject.optString("userId"));
                    validateItemData.setExt(groupNewsPojo.getExt());
                    return validateItemData;
                }
                ValidateItemData validateItemData2 = (ValidateItemData) OrmObject.objectWithJsonStr(content, ValidateItemData.class);
                setGroupName(validateItemData2, validateItemData2.getGroupId());
                return validateItemData2;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (ValidateItemData) invokeL.objValue;
    }

    public static List<ValidateItemData> convertToValidateItemDataList(LinkedList<GroupNewsPojo> linkedList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, linkedList)) == null) {
            LinkedList linkedList2 = new LinkedList();
            if (linkedList == null) {
                return linkedList2;
            }
            Iterator<GroupNewsPojo> it = linkedList.iterator();
            while (it.hasNext()) {
                ValidateItemData convertToValidateItemData = convertToValidateItemData(it.next());
                if (convertToValidateItemData != null) {
                    linkedList2.add(convertToValidateItemData);
                }
            }
            return linkedList2;
        }
        return (List) invokeL.objValue;
    }

    public static void setGroupName(ValidateItemData validateItemData, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, validateItemData, str) == null) {
            if (!BdBaseApplication.getInst().isDebugMode() || ej.C()) {
                ImMessageCenterPojo i = y97.o().i(str, 1);
                validateItemData.setGroupName(i != null ? i.getGroup_name() : "");
            }
        }
    }
}

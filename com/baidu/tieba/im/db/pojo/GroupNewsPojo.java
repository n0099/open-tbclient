package com.baidu.tieba.im.db.pojo;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.ModelHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GroupNewsPojo implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int hide = 3;
    public static final int read = 2;
    public static final long serialVersionUID = -4624684256008701507L;
    public static final int un_read = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String cmd;
    public String content;
    public int content_status;
    public String ext;
    public String gid;
    public String notice_id;
    public CommonMsgPojo originalChatMsgPojo;
    public ChatMessage originalPushMsg;
    public long time;

    public GroupNewsPojo() {
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

    public String getCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.cmd;
        }
        return (String) invokeV.objValue;
    }

    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public int getContent_status() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.content_status;
        }
        return invokeV.intValue;
    }

    public String getExt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.ext;
        }
        return (String) invokeV.objValue;
    }

    public String getGid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.gid;
        }
        return (String) invokeV.objValue;
    }

    public String getNotice_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.notice_id;
        }
        return (String) invokeV.objValue;
    }

    public CommonMsgPojo getOriginalChatMsgPojo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.originalChatMsgPojo;
        }
        return (CommonMsgPojo) invokeV.objValue;
    }

    public ChatMessage getOriginalPushMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.originalPushMsg;
        }
        return (ChatMessage) invokeV.objValue;
    }

    public long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.time;
        }
        return invokeV.longValue;
    }

    public GroupNewsPojo(UpdatesItemData updatesItemData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {updatesItemData};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (updatesItemData == null) {
            return;
        }
        setCmd(updatesItemData.getUpdatesType());
        this.notice_id = updatesItemData.getNotice_id();
        this.content = updatesItemData.toJsonString();
        setTime(updatesItemData.getTime());
    }

    public GroupNewsPojo(ValidateItemData validateItemData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {validateItemData};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        initByValidateData(validateItemData);
    }

    public void setCmd(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.cmd = str;
        }
    }

    public void setContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.content = str;
        }
    }

    public void setContent_status(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.content_status = i;
        }
    }

    public void setExt(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.ext = str;
        }
    }

    public void setGid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.gid = str;
        }
    }

    public void setNotice_id(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.notice_id = str;
        }
    }

    public void setOriginalChatMsgPojo(CommonMsgPojo commonMsgPojo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, commonMsgPojo) == null) {
            this.originalChatMsgPojo = commonMsgPojo;
        }
    }

    public void setOriginalPushMsg(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, chatMessage) == null) {
            this.originalPushMsg = chatMessage;
        }
    }

    public void setTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.time = j;
        }
    }

    public GroupNewsPojo(ChatMessage chatMessage, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatMessage, str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (chatMessage == null || TextUtils.isEmpty(str)) {
            return;
        }
        setContent_status(1);
        if (str.equals("001")) {
            str2 = "apply_join_group";
        } else if (str.equals("002")) {
            str2 = "apply_join_success";
        } else if (str.equals("003")) {
            str2 = "kick_out";
        } else if (str.equals(ADConfigError.REQUEST_HAS_SUCCESS_BEFORE)) {
            str2 = "group_name_change";
        } else if (str.equals(WorkPostNotifyFlutterData.FAIL_POST)) {
            str2 = "group_notice_change";
        } else if (str.equals("103")) {
            str2 = "group_intro_change";
        } else if (str.equals("104")) {
            str2 = "group_level_up";
        } else if (str.equals("108")) {
            str2 = "group_head_change";
        } else if (str.equals("107")) {
            str2 = "dismiss_group";
        } else if (str.equals("121")) {
            str2 = "hide_group_warn";
        } else if (str.equals("122")) {
            str2 = "hide_group";
        } else if (str.equals("109")) {
            str2 = "group_event_info";
        } else if (str.equals("124")) {
            str2 = "group_activitys_change";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND)) {
            str2 = "apply_new_friend";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_PASSED_FRIEND)) {
            str2 = "passed_new_friend";
        } else if (str.equals(TbEnum.SystemMessage.EVENT_ID_DELETE_FRIEND)) {
            str2 = "delete_new_friend";
        } else if (TbEnum.SystemMessage.EVENT_ID_APPLY_REPLY_MESSAGE.equals(str)) {
            str2 = "apply_reply_message";
        } else if (TbEnum.SystemMessage.EVENT_ID_APPLY_ADD_FRIEND.equals(str)) {
            str2 = "apply_add_friend";
        } else if (TbEnum.SystemMessage.EVENT_ID_APPLY_PASS_FRIEND.equals(str)) {
            str2 = "apply_pass_friend";
        } else if (TbEnum.SystemMessage.EVENT_ID_UPLOAD_STAT.equals(str)) {
            str2 = "upload_stat";
        } else if (TbEnum.SystemMessage.EVENT_ID_PLUGIN_CONFIG_SYNC.equals(str)) {
            str2 = "plugin_config_sync";
        } else if (TbEnum.SystemMessage.EVENT_ID_OFFLINE_DEBUG.equals(str)) {
            str2 = "offline_debug";
        } else {
            str2 = "000";
        }
        setCmd(str2);
        setContent(chatMessage.getContent());
        setTime(chatMessage.getTime() * 1000);
        setNotice_id(String.valueOf(chatMessage.getMsgId()));
        setSelfNewsRead();
        String content = getContent();
        if (!TextUtils.isEmpty(content)) {
            try {
                JSONObject optJSONObject = new JSONObject(content).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                if (optJSONObject != null) {
                    setGid(optJSONObject.optString(TbEnum.SystemMessage.KEY_GROUP_ID));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (str2.equals("apply_join_group") && ModelHelper.getInstance().getValidateModel() != null) {
            initByValidateData(ModelHelper.getInstance().getValidateModel().convertToValidateItemData(this));
        }
    }

    private void initByValidateData(ValidateItemData validateItemData) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, validateItemData) != null) || validateItemData == null) {
            return;
        }
        setCmd("apply_join_group");
        this.notice_id = validateItemData.getNotice_id();
        this.content = validateItemData.toJsonString();
        setTime(validateItemData.getApplyTime());
        setGid(validateItemData.getGroupId());
        if (validateItemData.isShown()) {
            i = 2;
        } else {
            i = 1;
        }
        setContent_status(i);
        setExt(validateItemData.getExt());
    }

    private void setSelfNewsRead() {
        UpdatesItemData convertToUpdatesItem;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65541, this) != null) || TextUtils.isEmpty(getCmd())) {
            return;
        }
        if ((!getCmd().equals("group_intro_change") && !getCmd().equals("group_name_change") && !getCmd().equals("group_notice_change")) || ModelHelper.getInstance().getUpdatasModel() == null || (convertToUpdatesItem = ModelHelper.getInstance().getUpdatasModel().convertToUpdatesItem(this)) == null) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (TextUtils.isEmpty(currentAccount)) {
            return;
        }
        String authorId = convertToUpdatesItem.getAuthorId();
        if (TextUtils.isEmpty(authorId)) {
            return;
        }
        if (currentAccount.equals(authorId)) {
            setContent_status(2);
        } else {
            setContent_status(1);
        }
    }
}

package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.y67;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class CommonPersonalChatActivity<T> extends MsglistActivity<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CommonPersonalChatActivity() {
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

    public boolean checkParam() {
        InterceptResult invokeV;
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MsglistModel msglistModel = this.mListModel;
            if ((msglistModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) != null) {
                return user.getUserIdLong() != 0 || getIntent().getBooleanExtra(PersonalChatActivityConfig.KEY_FROM_REPORT_SELECT, false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public String[] getDialogOperationItems(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) ? super.getDialogOperationItems(i, true) : (String[]) invokeCommon.objValue;
    }

    public void initParam(Bundle bundle) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            this.mListModel.setIsAcceptNotify(bundle.getBoolean(IntentConfig.IS_ACCEPT_NOTIFY, true));
            onInitParam(bundle);
        }
    }

    public void onInitParam(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            UserData userData = (UserData) intent.getSerializableExtra("user");
            saveToUserData(userData);
            ((CommonPersonalMsglistModel) this.mListModel).setUser(userData);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        r0 = r0.getContent();
     */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.repackage.ef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemViewClick(View view2, int i, int i2, long j) {
        MsglistModel msglistModel;
        ChatMessage msg;
        String content;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.onItemViewClick(view2, i, i2, j);
            if (i == 7 && isExStorageOk() && (msglistModel = this.mListModel) != null && (msg = msglistModel.getMsg(i2)) != null && y67.u(msg) && content != null) {
                JSONObject jSONObject = null;
                try {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        if (jSONArray.length() > 0) {
                            jSONObject = jSONArray.getJSONObject(0);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (Exception unused) {
                    jSONObject = new JSONObject(content);
                }
                if (jSONObject != null) {
                    sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(getPageContext().getContext(), jSONObject.optString("pid"), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), jSONObject.optString("url_d"), jSONObject.optString("face_name"), 2, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putSerializable("user", OrmObject.jsonStrWithObject(((CommonPersonalMsglistModel) this.mListModel).getUser()));
        }
    }

    public void saveToUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, userData) == null) {
        }
    }

    public void initParam() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Intent intent = getIntent();
            boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
            MsglistModel msglistModel = this.mListModel;
            if (msglistModel == null) {
                return;
            }
            msglistModel.setIsAcceptNotify(booleanExtra);
            onInitParam(intent);
        }
    }

    public void onInitParam(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) || bundle == null || bundle.getString("user") == null) {
            return;
        }
        UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
        saveToUserData(userData);
        ((CommonPersonalMsglistModel) this.mListModel).setUser(userData);
    }
}

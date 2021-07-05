package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
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
import d.a.s0.i1.w.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class CommonPersonalChatActivity<T> extends MsglistActivity<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CommonPersonalChatActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            return (!(msglistModel instanceof CommonPersonalMsglistModel) || (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) == null || user.getUserIdLong() == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public String[] getDialogOperationItems(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? super.getDialogOperationItems(i2, true) : (String[]) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public abstract boolean initData(Bundle bundle);

    public void initParam(Bundle bundle) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            this.mListModel.setIsAcceptNotify(bundle.getBoolean(IntentConfig.IS_ACCEPT_NOTIFY, true));
            onInitParam(bundle);
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public abstract void initView();

    public void onInitParam(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            UserData userData = (UserData) intent.getSerializableExtra("user");
            saveToUserData(userData);
            ((CommonPersonalMsglistModel) this.mListModel).setUser(userData);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        r0 = r0.getContent();
     */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, d.a.c.e.h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemViewClick(View view, int i2, int i3, long j) {
        MsglistModel msglistModel;
        ChatMessage msg;
        String content;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            super.onItemViewClick(view, i2, i3, j);
            if (i2 == 7 && isExStorageOk() && (msglistModel = this.mListModel) != null && (msg = msglistModel.getMsg(i3)) != null && c.q(msg) && content != null) {
                JSONObject jSONObject = null;
                try {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        if (jSONArray.length() > 0) {
                            jSONObject = jSONArray.getJSONObject(0);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
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
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putSerializable("user", OrmObject.jsonStrWithObject(((CommonPersonalMsglistModel) this.mListModel).getUser()));
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.refreshHeadIcon();
        }
    }

    public void saveToUserData(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, userData) == null) {
        }
    }

    public void initParam() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
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
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) || bundle == null || bundle.getString("user") == null) {
            return;
        }
        UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
        saveToUserData(userData);
        ((CommonPersonalMsglistModel) this.mListModel).setUser(userData);
    }
}

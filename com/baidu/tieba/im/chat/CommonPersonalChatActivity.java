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
import com.baidu.tieba.fc7;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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

    public boolean A1() {
        InterceptResult invokeV;
        UserData user;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MsglistModel msglistModel = this.c;
            if ((msglistModel instanceof CommonPersonalMsglistModel) && (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) != null) {
                return user.getUserIdLong() != 0 || getIntent().getBooleanExtra(PersonalChatActivityConfig.KEY_FROM_REPORT_SELECT, false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Intent intent = getIntent();
            boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
            MsglistModel msglistModel = this.c;
            if (msglistModel == null) {
                return;
            }
            msglistModel.setIsAcceptNotify(booleanExtra);
            D1(intent);
        }
    }

    public void C1(Bundle bundle) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            this.c.setIsAcceptNotify(bundle.getBoolean(IntentConfig.IS_ACCEPT_NOTIFY, true));
            E1(bundle);
        }
    }

    public void D1(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            UserData userData = (UserData) intent.getSerializableExtra("user");
            F1(userData);
            ((CommonPersonalMsglistModel) this.c).setUser(userData);
        }
    }

    public void E1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) || bundle == null || bundle.getString("user") == null) {
            return;
        }
        UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
        F1(userData);
        ((CommonPersonalMsglistModel) this.c).setUser(userData);
    }

    public void F1(UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, userData) == null) {
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public String[] W0(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) ? super.W0(i, true) : (String[]) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putSerializable("user", OrmObject.jsonStrWithObject(((CommonPersonalMsglistModel) this.c).getUser()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002b, code lost:
        r0 = r0.getContent();
     */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.tieba.xf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(View view2, int i, int i2, long j) {
        MsglistModel msglistModel;
        ChatMessage msg;
        String content;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.q(view2, i, i2, j);
            if (i == 7 && d1() && (msglistModel = this.c) != null && (msg = msglistModel.getMsg(i2)) != null && fc7.w(msg) && content != null) {
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
}

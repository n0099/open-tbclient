package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class CommonPersonalChatActivity<T> extends MsglistActivity<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void awz() {
        super.awz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(Intent intent) {
        UserData userData = (UserData) intent.getSerializableExtra("user");
        b(userData);
        ((CommonPersonalMsglistModel) this.dDD).setUser(userData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            b(userData);
            ((CommonPersonalMsglistModel) this.dDD).setUser(userData);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("user", OrmObject.jsonStrWithObject(((CommonPersonalMsglistModel) this.dDD).getUser()));
    }

    protected void b(UserData userData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean awB() {
        UserData user;
        return (!(this.dDD instanceof CommonPersonalMsglistModel) || (user = ((CommonPersonalMsglistModel) this.dDD).getUser()) == null || user.getUserIdLong() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(Bundle bundle) throws Exception {
        this.dDD.setIsAcceptNotify(bundle.getBoolean(IntentConfig.IS_ACCEPT_NOTIFY, true));
        n(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awA() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        if (this.dDD != null) {
            this.dDD.setIsAcceptNotify(booleanExtra);
            M(intent);
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage msg;
        String content;
        super.a(view, i, i2, j);
        switch (i) {
            case 7:
                if (axl() && this.dDD != null && (msg = this.dDD.getMsg(i2)) != null && com.baidu.tieba.im.util.e.t(msg) && (content = msg.getContent()) != null) {
                    JSONObject jSONObject = null;
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        if (jSONArray.length() > 0) {
                            jSONObject = jSONArray.getJSONObject(0);
                        }
                    } catch (Exception e) {
                        try {
                            jSONObject = new JSONObject(content);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("url_d");
                        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(getPageContext().getContext(), jSONObject.optString(Info.kBaiduPIDKey), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), optString, jSONObject.optString("face_name"), 2, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public String[] r(int i, boolean z) {
        return super.r(i, true);
    }
}

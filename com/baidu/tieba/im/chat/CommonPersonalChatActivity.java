package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class CommonPersonalChatActivity<T> extends MsglistActivity<T> {
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected abstract boolean as(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected abstract void initView();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void ciT() {
        super.ciT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W(Intent intent) {
        UserData userData = (UserData) intent.getSerializableExtra("user");
        b(userData);
        ((CommonPersonalMsglistModel) this.itD).setUser(userData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void au(Bundle bundle) {
        if (bundle != null && bundle.getString("user") != null) {
            UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
            b(userData);
            ((CommonPersonalMsglistModel) this.itD).setUser(userData);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("user", OrmObject.jsonStrWithObject(((CommonPersonalMsglistModel) this.itD).getUser()));
    }

    protected void b(UserData userData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ciV() {
        UserData user;
        return (!(this.itD instanceof CommonPersonalMsglistModel) || (user = ((CommonPersonalMsglistModel) this.itD).getUser()) == null || user.getUserIdLong() == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void at(Bundle bundle) throws Exception {
        this.itD.setIsAcceptNotify(bundle.getBoolean("is_accept_notify", true));
        au(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ciU() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("is_accept_notify", true);
        if (this.itD != null) {
            this.itD.setIsAcceptNotify(booleanExtra);
            W(intent);
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        String content;
        super.onItemViewClick(view, i, i2, j);
        switch (i) {
            case 7:
                if (cjF() && this.itD != null && (msg = this.itD.getMsg(i2)) != null && com.baidu.tieba.im.util.e.p(msg) && (content = msg.getContent()) != null) {
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
                        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(getPageContext().getContext(), jSONObject.optString("pid"), jSONObject.optString("packet_name"), jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON), jSONObject.optString("url_s"), optString, jSONObject.optString("face_name"), 2, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
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
    public String[] Q(int i, boolean z) {
        return super.Q(i, true);
    }
}

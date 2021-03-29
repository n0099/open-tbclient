package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import d.b.i0.d1.w.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class CommonPersonalChatActivity<T> extends MsglistActivity<T> {
    public boolean checkParam() {
        UserData user;
        MsglistModel msglistModel = this.mListModel;
        return (!(msglistModel instanceof CommonPersonalMsglistModel) || (user = ((CommonPersonalMsglistModel) msglistModel).getUser()) == null || user.getUserIdLong() == 0) ? false : true;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public String[] getDialogOperationItems(int i, boolean z) {
        return super.getDialogOperationItems(i, true);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public abstract boolean initData(Bundle bundle);

    public void initParam(Bundle bundle) throws Exception {
        this.mListModel.setIsAcceptNotify(bundle.getBoolean(IntentConfig.IS_ACCEPT_NOTIFY, true));
        onInitParam(bundle);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public abstract void initView();

    public void onInitParam(Intent intent) {
        UserData userData = (UserData) intent.getSerializableExtra("user");
        saveToUserData(userData);
        ((CommonPersonalMsglistModel) this.mListModel).setUser(userData);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
        r0 = r0.getContent();
     */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, d.b.b.e.h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemViewClick(View view, int i, int i2, long j) {
        MsglistModel msglistModel;
        ChatMessage msg;
        String content;
        super.onItemViewClick(view, i, i2, j);
        if (i == 7 && isExStorageOk() && (msglistModel = this.mListModel) != null && (msg = msglistModel.getMsg(i2)) != null && c.q(msg) && content != null) {
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
                String optString = jSONObject.optString("url_d");
                sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(getPageContext().getContext(), jSONObject.optString("pid"), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), optString, jSONObject.optString("face_name"), 2, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("user", OrmObject.jsonStrWithObject(((CommonPersonalMsglistModel) this.mListModel).getUser()));
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        super.refreshHeadIcon();
    }

    public void saveToUserData(UserData userData) {
    }

    public void initParam() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        MsglistModel msglistModel = this.mListModel;
        if (msglistModel == null) {
            return;
        }
        msglistModel.setIsAcceptNotify(booleanExtra);
        onInitParam(intent);
    }

    public void onInitParam(Bundle bundle) {
        if (bundle == null || bundle.getString("user") == null) {
            return;
        }
        UserData userData = (UserData) OrmObject.objectWithJsonStr(bundle.getString("user"), UserData.class);
        saveToUserData(userData);
        ((CommonPersonalMsglistModel) this.mListModel).setUser(userData);
    }
}

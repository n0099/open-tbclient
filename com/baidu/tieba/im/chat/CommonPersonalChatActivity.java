package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonPersonalMsglistModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class CommonPersonalChatActivity extends MsglistActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void c() {
        super.c();
    }

    protected void a(Intent intent) {
        UserData userData = (UserData) intent.getSerializableExtra("user");
        b = String.valueOf(userData.getUserId());
        a(userData);
        ((CommonPersonalMsglistModel) this.e).a(userData);
    }

    protected void a(Bundle bundle) {
        UserData userData = (UserData) bundle.getSerializable("user");
        b = String.valueOf(userData.getUserId());
        a(userData);
        ((CommonPersonalMsglistModel) this.e).a(userData);
    }

    protected void a(UserData userData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean k() {
        if (this.e instanceof CommonPersonalMsglistModel) {
            UserData c = ((CommonPersonalMsglistModel) this.e).c();
            if (c == null) {
                BdLog.e("error:user or forum is null");
                return false;
            } else if (c.getUserIdLong() == 0) {
                BdLog.e("error:uid invalid," + c.getUserId());
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Bundle bundle) {
        this.e.a(bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, true));
        a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, true);
        if (this.e == null) {
            BdLog.e("mListModel is null");
            return;
        }
        this.e.a(booleanExtra);
        a(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(View view, int i, int i2, long j) {
        ChatMessage a;
        String content;
        JSONObject jSONObject;
        JSONArray jSONArray;
        super.a(view, i, i2, j);
        switch (i) {
            case 7:
                if (t() && this.e != null && (a = this.e.a(i2)) != null && com.baidu.tieba.im.e.r.b(a) && (content = a.getContent()) != null) {
                    try {
                        jSONArray = new JSONArray(content);
                    } catch (Exception e) {
                        try {
                            jSONObject = new JSONObject(content);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject = jSONArray.getJSONObject(0);
                        if (jSONObject == null) {
                            sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.i(this, jSONObject.optString("pid"), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), jSONObject.optString("url_d"), jSONObject.optString("face_name"), 2, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
                            return;
                        }
                        return;
                    }
                    jSONObject = null;
                    if (jSONObject == null) {
                    }
                } else {
                    return;
                }
                break;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity
    public String[] a(int i, boolean z) {
        return super.a(i, true);
    }
}

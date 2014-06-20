package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class CommonGroupChatActiviy extends MsglistActivity {
    private com.baidu.adp.framework.listener.b m = new az(this, 0);
    private CustomMessageListener n = new ba(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void c() {
        super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, true);
        if (this.e == null) {
            BdLog.e("mListModel is null");
            return;
        }
        this.e.a(booleanExtra);
        a(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.e.a(bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, true));
        b(bundle);
    }

    protected void b(Bundle bundle) {
        ((CommonGroupMsglistModel) this.e).a((GroupData) bundle.getSerializable("group"));
        b = String.valueOf(((CommonGroupMsglistModel) this.e).b().getGroupId());
    }

    protected void a(Intent intent) {
        GroupData groupData = (GroupData) intent.getSerializableExtra("group");
        String stringExtra = intent.getStringExtra("ObjTp");
        String valueOf = String.valueOf(groupData.getGroupId());
        if (!com.baidu.tieba.im.model.bt.a().a(valueOf)) {
            new com.baidu.tieba.im.e.q("chat_pg", stringExtra, valueOf).start();
            com.baidu.tieba.im.model.bt.a().a(valueOf, Long.valueOf(System.currentTimeMillis()));
        }
        ((CommonGroupMsglistModel) this.e).a(groupData);
        b = String.valueOf(((CommonGroupMsglistModel) this.e).b().getGroupId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, this.e.i());
        bundle.putSerializable("group", ((CommonGroupMsglistModel) this.e).b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean l() {
        GroupData b = ((CommonGroupMsglistModel) this.e).b();
        if (b == null) {
            BdLog.e("error:group or forum is null");
            return false;
        } else if (b.getGroupId() == 0) {
            BdLog.e("error:gid invalid," + b.getGroupId());
            return false;
        } else {
            return true;
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.b
    public void b(View view, int i, int i2, long j) {
        super.b(view, i, i2, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(View view, int i, int i2, long j) {
        ChatMessage a;
        String content;
        JSONObject jSONObject;
        JSONArray jSONArray;
        ChatMessage a2;
        String a3;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage a4 = this.e.a(i2);
                if (a4 != null && a4.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2003003, new com.baidu.tbadk.core.atomData.as(this, a4.getUserInfo().getUserId(), a4.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 3:
            case 5:
            case 6:
            default:
                return;
            case 4:
                if (t() && (a2 = this.e.a(i2)) != null && com.baidu.tieba.im.e.r.a(a2) && (a3 = com.baidu.tieba.im.e.r.a(a2.getContent(), true)) != null && (this.e instanceof CommonGroupMsglistModel) && ((CommonGroupMsglistModel) this.e).b() != null) {
                    GroupMsgImageActivity.a(this, a3, ((CommonGroupMsglistModel) this.e).b().getGroupId(), false);
                    return;
                }
                return;
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
                            sendMessage(new CustomMessage(2003001, new com.baidu.tbadk.core.atomData.i(this, jSONObject.optString("pid"), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), jSONObject.optString("url_d"), jSONObject.optString("face_name"), 3, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
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
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void m() {
        super.m();
        registerListener(MessageTypes.CMD_JOIN_GROUP, this.m);
        registerListener(MessageTypes.CMD_ADD_GROUP, this.m);
        registerListener(MessageTypes.CMD_REMOVE_MEMBERS, this.m);
        registerListener(MessageTypes.CMD_DISSMISS_GROUP, this.m);
        registerListener(MessageTypes.CMD_GROUP_MEMBER_CHANGE, this.n);
        registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.n);
        registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.n);
        registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE, this.n);
        registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.n);
        registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.n);
        registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.n);
        registerListener(MessageTypes.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.n);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void n() {
        super.n();
        MessageManager.getInstance().unRegisterListener(this.m);
        MessageManager.getInstance().unRegisterListener(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GroupNewsPojo groupNewsPojo) {
        GroupData b;
        if (groupNewsPojo != null && this.e != null && (this.e instanceof CommonGroupMsglistModel) && (b = ((CommonGroupMsglistModel) this.e).b()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(b.getGroupId()))) {
                    showToast(com.baidu.tieba.y.group_is_kicked, false);
                    finish();
                    BdLog.d("newSystemMessageNotify suc and closeBottom");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(GroupNewsPojo groupNewsPojo) {
        GroupData b;
        if (groupNewsPojo != null && this.e != null && (this.e instanceof CommonGroupMsglistModel) && (b = ((CommonGroupMsglistModel) this.e).b()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(b.getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.d.a(string2, true);
                        b.setName(string2);
                        BdLog.d("newSystemMessageNotify suc and change name");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        GroupData b;
        if (groupNewsPojo != null && this.e != null && (this.e instanceof CommonGroupMsglistModel) && (b = ((CommonGroupMsglistModel) this.e).b()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(b.getGroupId()))) {
                    showToast(com.baidu.tieba.y.group_is_dismiss, false);
                    finish();
                    BdLog.d("dismiss suc");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

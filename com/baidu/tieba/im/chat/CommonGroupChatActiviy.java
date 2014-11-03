package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.PvCacheModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class CommonGroupChatActiviy extends MsglistActivity {
    private com.baidu.adp.framework.listener.e ayS = new ay(this, 0);
    private CustomMessageListener mCustomListener = new az(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void Ju() {
        super.Ju();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Jv() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, true);
        if (this.aQe != null) {
            this.aQe.setIsAcceptNotify(booleanExtra);
            i(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Bundle bundle) {
        this.aQe.setIsAcceptNotify(bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, true));
        g(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Bundle bundle) {
        ((CommonGroupMsglistModel) this.aQe).setGroup((GroupData) bundle.getSerializable("group"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(Intent intent) {
        GroupData groupData = (GroupData) intent.getSerializableExtra("group");
        String stringExtra = intent.getStringExtra(GroupChatActivityConfig.GROUP_OBJ_TP);
        String valueOf = String.valueOf(groupData.getGroupId());
        if (!PvCacheModel.getInstance().isSameDay(valueOf)) {
            new com.baidu.tieba.im.util.h("chat_pg", stringExtra, valueOf).start();
            TiebaStatic.eventStat(TbadkApplication.m251getInst().getApp(), "chat_pg", "", 1, "obj_tp", stringExtra, "group_id", valueOf);
            PvCacheModel.getInstance().addCacheData(valueOf, Long.valueOf(System.currentTimeMillis()));
        }
        ((CommonGroupMsglistModel) this.aQe).setGroup(groupData);
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, this.aQe.getIsAcceptNotify());
        bundle.putSerializable("group", ((CommonGroupMsglistModel) this.aQe).getGroup());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Jw() {
        GroupData group = ((CommonGroupMsglistModel) this.aQe).getGroup();
        return (group == null || group.getGroupId() == 0) ? false : true;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.b
    public void b(View view, int i, int i2, long j) {
        super.b(view, i, i2, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(View view, int i, int i2, long j) {
        ChatMessage msg;
        String content;
        JSONObject jSONObject;
        JSONArray jSONArray;
        ChatMessage msg2;
        String v;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg3 = this.aQe.getMsg(i2);
                if (msg3 != null && msg3.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this, msg3.getUserInfo().getUserId(), msg3.getUserInfo().getUserName(), null, AddFriendActivityConfig.TYPE_IM_GROUP)));
                    return;
                }
                return;
            case 3:
            case 5:
            case 6:
            default:
                return;
            case 4:
                if (Kj() && (msg2 = this.aQe.getMsg(i2)) != null && com.baidu.tieba.im.util.i.p(msg2) && (v = com.baidu.tieba.im.util.i.v(msg2.getContent(), true)) != null && (this.aQe instanceof CommonGroupMsglistModel) && ((CommonGroupMsglistModel) this.aQe).getGroup() != null) {
                    GroupMsgImageActivity.a(this, v, ((CommonGroupMsglistModel) this.aQe).getGroup().getGroupId(), false, String.valueOf(msg2.getMsgId()));
                    return;
                }
                return;
            case 7:
                if (Kj() && this.aQe != null && (msg = this.aQe.getMsg(i2)) != null && com.baidu.tieba.im.util.i.q(msg) && (content = msg.getContent()) != null) {
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
                            sendMessage(new CustomMessage(2002001, new EmotionImageActivityConfig(this, jSONObject.optString("pid"), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), jSONObject.optString("url_d"), jSONObject.optString("face_name"), 3, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
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
    public void nY() {
        super.nY();
        registerListener(103110, this.ayS);
        registerListener(103101, this.ayS);
        registerListener(103112, this.ayS);
        registerListener(103104, this.ayS);
        registerListener(2001109, this.mCustomListener);
        registerListener(2001130, this.mCustomListener);
        registerListener(2001132, this.mCustomListener);
        registerListener(2001138, this.mCustomListener);
        registerListener(2001136, this.mCustomListener);
        registerListener(2001134, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
        registerListener(2001141, this.mCustomListener);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected void Jx() {
        super.Jx();
        MessageManager.getInstance().unRegisterListener(this.ayS);
        MessageManager.getInstance().unRegisterListener(this.mCustomListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GroupNewsPojo groupNewsPojo) {
        GroupData group;
        if (groupNewsPojo != null && this.aQe != null && (this.aQe instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.aQe).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(group.getGroupId()))) {
                    showToast(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.group_is_kicked), false);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(GroupNewsPojo groupNewsPojo) {
        GroupData group;
        if (groupNewsPojo != null && this.aQe != null && (this.aQe instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.aQe).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(group.getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.aQd.refreshHeaderFooter(string2, true);
                        group.setName(string2);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        GroupData group;
        if (groupNewsPojo != null && this.aQe != null && (this.aQe instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.aQe).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(group.getGroupId()))) {
                    showToast(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.group_is_dismiss), false);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

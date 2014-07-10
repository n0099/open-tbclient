package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class CommonGroupChatActiviy extends MsglistActivity {
    private com.baidu.adp.framework.listener.b a = new az(this, 0);
    private CustomMessageListener b = new ba(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void c() {
        super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, true);
        if (this.e != null) {
            this.e.a(booleanExtra);
            a(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.e.a(bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, true));
        b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Bundle bundle) {
        ((CommonGroupMsglistModel) this.e).a((GroupData) bundle.getSerializable("group"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Intent intent) {
        GroupData groupData = (GroupData) intent.getSerializableExtra("group");
        String stringExtra = intent.getStringExtra("ObjTp");
        String valueOf = String.valueOf(groupData.getGroupId());
        if (!com.baidu.tieba.im.model.bs.a().a(valueOf)) {
            new com.baidu.tieba.im.e.q("chat_pg", stringExtra, valueOf).start();
            TiebaStatic.eventStat(TbadkApplication.m252getInst().getApp(), "chat_pg", "", 1, "obj_tp", stringExtra, com.baidu.tbadk.core.frameworkData.a.GROUP_ID, valueOf);
            com.baidu.tieba.im.model.bs.a().a(valueOf, Long.valueOf(System.currentTimeMillis()));
        }
        ((CommonGroupMsglistModel) this.e).a(groupData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, this.e.i());
        bundle.putSerializable("group", ((CommonGroupMsglistModel) this.e).c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean l() {
        GroupData c = ((CommonGroupMsglistModel) this.e).c();
        return (c == null || c.getGroupId() == 0) ? false : true;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.b
    public void b(View view, int i, int i2, long j) {
        super.b(view, i, i2, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0082  */
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
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new com.baidu.tbadk.core.atomData.bb(this, a4.getUserInfo().getUserId(), a4.getUserInfo().getUserName())));
                    return;
                }
                return;
            case 3:
            case 5:
            case 6:
            default:
                return;
            case 4:
                if (t() && (a2 = this.e.a(i2)) != null && com.baidu.tieba.im.e.r.a(a2) && (a3 = com.baidu.tieba.im.e.r.a(a2.getContent(), true)) != null && (this.e instanceof CommonGroupMsglistModel) && ((CommonGroupMsglistModel) this.e).c() != null) {
                    GroupMsgImageActivity.a(this, a3, ((CommonGroupMsglistModel) this.e).c().getGroupId(), false, String.valueOf(a2.getMsgId()));
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
                            sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.l(this, jSONObject.optString("pid"), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), jSONObject.optString("url_d"), jSONObject.optString("face_name"), 3, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
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
        registerListener(103110, this.a);
        registerListener(103101, this.a);
        registerListener(103112, this.a);
        registerListener(103104, this.a);
        registerListener(2001109, this.b);
        registerListener(2001130, this.b);
        registerListener(2001132, this.b);
        registerListener(2001138, this.b);
        registerListener(2001136, this.b);
        registerListener(2001134, this.b);
        registerListener(2001137, this.b);
        registerListener(2001141, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void n() {
        super.n();
        MessageManager.getInstance().unRegisterListener(this.a);
        MessageManager.getInstance().unRegisterListener(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GroupNewsPojo groupNewsPojo) {
        GroupData c;
        if (groupNewsPojo != null && this.e != null && (this.e instanceof CommonGroupMsglistModel) && (c = ((CommonGroupMsglistModel) this.e).c()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(c.getGroupId()))) {
                    showToast(com.baidu.tieba.y.group_is_kicked, false);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(GroupNewsPojo groupNewsPojo) {
        GroupData c;
        if (groupNewsPojo != null && this.e != null && (this.e instanceof CommonGroupMsglistModel) && (c = ((CommonGroupMsglistModel) this.e).c()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(c.getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.d.a(string2, true);
                        c.setName(string2);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        GroupData c;
        if (groupNewsPojo != null && this.e != null && (this.e instanceof CommonGroupMsglistModel) && (c = ((CommonGroupMsglistModel) this.e).c()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(c.getGroupId()))) {
                    showToast(com.baidu.tieba.y.group_is_dismiss, false);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

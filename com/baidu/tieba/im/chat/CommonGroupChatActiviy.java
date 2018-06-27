package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.PvCacheModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class CommonGroupChatActiviy<T> extends MsglistActivity<T> {
    private com.baidu.adp.framework.listener.c efV = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.chat.CommonGroupChatActiviy.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            GroupData group;
            if (socketResponsedMessage != null) {
                switch (socketResponsedMessage.getCmd()) {
                    case 103101:
                    case 103110:
                    case 103112:
                        CommonGroupChatActiviy.this.ehL.refresh();
                        return;
                    case 103104:
                        if (socketResponsedMessage instanceof ResponseDismissGroupMessage) {
                            ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
                            if (responseDismissGroupMessage.getError() == 0 && (CommonGroupChatActiviy.this.ehM instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) CommonGroupChatActiviy.this.ehM).getGroup()) != null && group.getGroupId() == responseDismissGroupMessage.getGroupId()) {
                                CommonGroupChatActiviy.this.finish();
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.chat.CommonGroupChatActiviy.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage != null) {
                switch (customResponsedMessage.getCmd()) {
                    case 2001109:
                        CommonGroupChatActiviy.this.ehL.refresh();
                        return;
                    case 2001126:
                    case 2001128:
                    case 2001130:
                    case 2001132:
                    case 2001133:
                    case 2001134:
                    case 2001137:
                        if ((customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
                            String cmd = p.getCmd();
                            if (!TextUtils.isEmpty(cmd)) {
                                CommonGroupChatActiviy.this.ehL.refresh();
                                if (!cmd.equals("apply_join_success")) {
                                    if (cmd.equals("kick_out")) {
                                        CommonGroupChatActiviy.this.b(p);
                                        return;
                                    } else if (cmd.equals("group_name_change")) {
                                        CommonGroupChatActiviy.this.c(p);
                                        return;
                                    } else if (cmd.equals("dismiss_group")) {
                                        CommonGroupChatActiviy.this.d(p);
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    };

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected abstract void initView();

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected abstract boolean o(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void aFO() {
        super.aFO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aFP() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        if (this.ehM != null) {
            this.ehM.setIsAcceptNotify(booleanExtra);
            M(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(Bundle bundle) throws Exception {
        this.ehM.setIsAcceptNotify(bundle.getBoolean(IntentConfig.IS_ACCEPT_NOTIFY, true));
        q(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(Bundle bundle) {
        String string = bundle.getString("group");
        if (!StringUtils.isNull(string)) {
            ((CommonGroupMsglistModel) this.ehM).setGroup((GroupData) OrmObject.objectWithJsonStr(string, GroupData.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(Intent intent) {
        GroupData groupData = (GroupData) intent.getSerializableExtra("group");
        String stringExtra = intent.getStringExtra(GroupChatActivityConfig.GROUP_OBJ_TP);
        String valueOf = String.valueOf(groupData.getGroupId());
        if (!PvCacheModel.getInstance().isSameDay(valueOf)) {
            new com.baidu.tieba.im.util.c(TbConfig.ST_TYPE_IM, stringExtra, valueOf).start();
            TiebaStatic.eventStat(TbadkApplication.getInst().getApp(), TbConfig.ST_TYPE_IM, "", 1, "obj_tp", stringExtra, "group_id", valueOf);
            PvCacheModel.getInstance().addCacheData(valueOf, Long.valueOf(System.currentTimeMillis()));
        }
        ((CommonGroupMsglistModel) this.ehM).setGroup(groupData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(IntentConfig.IS_ACCEPT_NOTIFY, this.ehM.getIsAcceptNotify());
        if (((CommonGroupMsglistModel) this.ehM).getGroup() != null) {
            bundle.putString("group", OrmObject.jsonStrWithObject(((CommonGroupMsglistModel) this.ehM).getGroup()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aFQ() {
        GroupData group = ((CommonGroupMsglistModel) this.ehM).getGroup();
        return (group == null || group.getGroupId() == 0) ? false : true;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.b
    public void b(View view, int i, int i2, long j) {
        super.b(view, i, i2, j);
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
    public void a(View view, int i, int i2, long j) {
        ChatMessage msg;
        String content;
        ChatMessage msg2;
        super.a(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg3 = this.ehM.getMsg(i2);
                if (msg3 != null && msg3.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), msg3.getUserInfo().getUserId(), msg3.getUserInfo().getUserName(), null, AddFriendActivityConfig.TYPE_IM_GROUP)));
                    return;
                }
                return;
            case 3:
            case 5:
            case 6:
            default:
                return;
            case 4:
                if (aGA() && (msg2 = this.ehM.getMsg(i2)) != null && com.baidu.tieba.im.util.e.t(msg2)) {
                    String G = com.baidu.tieba.im.util.e.G(msg2.getContent(), true);
                    String G2 = com.baidu.tieba.im.util.e.G(msg2.getContent(), false);
                    if (G != null && (this.ehM instanceof CommonGroupMsglistModel) && ((CommonGroupMsglistModel) this.ehM).getGroup() != null) {
                        sendMessage(new CustomMessage(2002001, new GroupMsgImageActivityConfig(getPageContext().getContext(), G, ((CommonGroupMsglistModel) this.ehM).getGroup().getGroupId(), false, String.valueOf(msg2.getMsgId()), G2)));
                        return;
                    }
                    return;
                }
                return;
            case 7:
                if (aGA() && this.ehM != null && (msg = this.ehM.getMsg(i2)) != null && com.baidu.tieba.im.util.e.u(msg) && (content = msg.getContent()) != null) {
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
                        sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(getPageContext().getContext(), jSONObject.optString(Info.kBaiduPIDKey), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), optString, jSONObject.optString("face_name"), 3, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void aFR() {
        super.aFR();
        registerListener(103110, this.efV);
        registerListener(103101, this.efV);
        registerListener(103112, this.efV);
        registerListener(103104, this.efV);
        registerListener(2001109, this.mCustomListener);
        registerListener(2001126, this.mCustomListener);
        registerListener(2001128, this.mCustomListener);
        registerListener(2001134, this.mCustomListener);
        registerListener(2001132, this.mCustomListener);
        registerListener(2001130, this.mCustomListener);
        registerListener(2001133, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void aFS() {
        super.aFS();
        MessageManager.getInstance().unRegisterListener(this.efV);
        MessageManager.getInstance().unRegisterListener(this.mCustomListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(GroupNewsPojo groupNewsPojo) {
        GroupData group;
        if (groupNewsPojo != null && this.ehM != null && (this.ehM instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.ehM).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(group.getGroupId()))) {
                    showToast(TbadkApplication.getInst().getString(d.k.group_is_kicked), false);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(GroupNewsPojo groupNewsPojo) {
        GroupData group;
        if (groupNewsPojo != null && this.ehM != null && (this.ehM instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.ehM).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(group.getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.ehL.refreshHeaderFooter(string2, true);
                        group.setName(string2);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(GroupNewsPojo groupNewsPojo) {
        GroupData group;
        if (groupNewsPojo != null && this.ehM != null && (this.ehM instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.ehM).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(group.getGroupId()))) {
                    showToast(TbadkApplication.getInst().getString(d.k.group_is_dismiss), false);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

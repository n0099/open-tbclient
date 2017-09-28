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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
/* loaded from: classes.dex */
public abstract class CommonGroupChatActiviy<T> extends MsglistActivity<T> {
    private com.baidu.adp.framework.listener.c dmd = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.chat.CommonGroupChatActiviy.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            GroupData group;
            if (socketResponsedMessage != null) {
                switch (socketResponsedMessage.getCmd()) {
                    case 103101:
                    case 103110:
                    case 103112:
                        CommonGroupChatActiviy.this.dnS.refresh();
                        return;
                    case 103104:
                        if (socketResponsedMessage instanceof ResponseDismissGroupMessage) {
                            ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
                            if (responseDismissGroupMessage.getError() == 0 && (CommonGroupChatActiviy.this.dnT instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) CommonGroupChatActiviy.this.dnT).getGroup()) != null && group.getGroupId() == responseDismissGroupMessage.getGroupId()) {
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
                    case CmdConfigCustom.CMD_GROUP_MEMBER_CHANGE /* 2001109 */:
                        CommonGroupChatActiviy.this.dnS.refresh();
                        return;
                    case CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS /* 2001126 */:
                    case CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT /* 2001128 */:
                    case CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE /* 2001130 */:
                    case CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE /* 2001132 */:
                    case CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP /* 2001133 */:
                    case CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE /* 2001134 */:
                    case CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP /* 2001137 */:
                        if ((customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
                            String cmd = p.getCmd();
                            if (!TextUtils.isEmpty(cmd)) {
                                CommonGroupChatActiviy.this.dnS.refresh();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void ass() {
        super.ass();
    }

    protected void ast() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        if (this.dnT != null) {
            this.dnT.setIsAcceptNotify(booleanExtra);
            N(intent);
        }
    }

    protected void n(Bundle bundle) throws Exception {
        this.dnT.setIsAcceptNotify(bundle.getBoolean(IntentConfig.IS_ACCEPT_NOTIFY, true));
        o(bundle);
    }

    protected void o(Bundle bundle) {
        String string = bundle.getString("group");
        if (!StringUtils.isNull(string)) {
            ((CommonGroupMsglistModel) this.dnT).setGroup((GroupData) OrmObject.objectWithJsonStr(string, GroupData.class));
        }
    }

    protected void N(Intent intent) {
        GroupData groupData = (GroupData) intent.getSerializableExtra("group");
        String stringExtra = intent.getStringExtra(GroupChatActivityConfig.GROUP_OBJ_TP);
        String valueOf = String.valueOf(groupData.getGroupId());
        if (!PvCacheModel.getInstance().isSameDay(valueOf)) {
            new com.baidu.tieba.im.util.c(TbConfig.ST_TYPE_IM, stringExtra, valueOf).start();
            TiebaStatic.eventStat(TbadkApplication.getInst().getApp(), TbConfig.ST_TYPE_IM, "", 1, "obj_tp", stringExtra, "group_id", valueOf);
            PvCacheModel.getInstance().addCacheData(valueOf, Long.valueOf(System.currentTimeMillis()));
        }
        ((CommonGroupMsglistModel) this.dnT).setGroup(groupData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(IntentConfig.IS_ACCEPT_NOTIFY, this.dnT.getIsAcceptNotify());
        if (((CommonGroupMsglistModel) this.dnT).getGroup() != null) {
            bundle.putString("group", OrmObject.jsonStrWithObject(((CommonGroupMsglistModel) this.dnT).getGroup()));
        }
    }

    protected boolean asu() {
        GroupData group = ((CommonGroupMsglistModel) this.dnT).getGroup();
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
                ChatMessage msg3 = this.dnT.getMsg(i2);
                if (msg3 != null && msg3.getUserInfo() != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getContext(), msg3.getUserInfo().getUserId(), msg3.getUserInfo().getUserName(), null, AddFriendActivityConfig.TYPE_IM_GROUP)));
                    return;
                }
                return;
            case 3:
            case 5:
            case 6:
            default:
                return;
            case 4:
                if (ate() && (msg2 = this.dnT.getMsg(i2)) != null && com.baidu.tieba.im.util.e.r(msg2)) {
                    String K = com.baidu.tieba.im.util.e.K(msg2.getContent(), true);
                    String K2 = com.baidu.tieba.im.util.e.K(msg2.getContent(), false);
                    if (K != null && (this.dnT instanceof CommonGroupMsglistModel) && ((CommonGroupMsglistModel) this.dnT).getGroup() != null) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupMsgImageActivityConfig(getPageContext().getContext(), K, ((CommonGroupMsglistModel) this.dnT).getGroup().getGroupId(), false, String.valueOf(msg2.getMsgId()), K2)));
                        return;
                    }
                    return;
                }
                return;
            case 7:
                if (ate() && this.dnT != null && (msg = this.dnT.getMsg(i2)) != null && com.baidu.tieba.im.util.e.s(msg) && (content = msg.getContent()) != null) {
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
                        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(getPageContext().getContext(), jSONObject.optString(Info.kBaiduPIDKey), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), optString, jSONObject.optString("face_name"), 3, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void asv() {
        super.asv();
        registerListener(103110, this.dmd);
        registerListener(103101, this.dmd);
        registerListener(103112, this.dmd);
        registerListener(103104, this.dmd);
        registerListener((int) CmdConfigCustom.CMD_GROUP_MEMBER_CHANGE, this.mCustomListener);
        registerListener((int) CmdConfigCustom.CMD_IM_PUSH_NOTIFY_APPLY_JOIN_SUCCESS, this.mCustomListener);
        registerListener((int) CmdConfigCustom.CMD_IM_PUSH_NOTIFY_KICK_OUT, this.mCustomListener);
        registerListener((int) CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_HEAD_CHANGE, this.mCustomListener);
        registerListener((int) CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.mCustomListener);
        registerListener((int) CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.mCustomListener);
        registerListener((int) CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.mCustomListener);
        registerListener((int) CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.mCustomListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void asw() {
        super.asw();
        MessageManager.getInstance().unRegisterListener(this.dmd);
        MessageManager.getInstance().unRegisterListener(this.mCustomListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(GroupNewsPojo groupNewsPojo) {
        GroupData group;
        if (groupNewsPojo != null && this.dnT != null && (this.dnT instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.dnT).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(group.getGroupId()))) {
                    showToast(TbadkApplication.getInst().getString(d.l.group_is_kicked), false);
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
        if (groupNewsPojo != null && this.dnT != null && (this.dnT instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.dnT).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(group.getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.dnS.refreshHeaderFooter(string2, true);
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
        if (groupNewsPojo != null && this.dnT != null && (this.dnT instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.dnT).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(group.getGroupId()))) {
                    showToast(TbadkApplication.getInst().getString(d.l.group_is_dismiss), false);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.PvCacheModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public abstract class CommonGroupChatActiviy<T> extends MsglistActivity<T> {
    private com.baidu.adp.framework.listener.c icV = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.chat.CommonGroupChatActiviy.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            GroupData group;
            if (socketResponsedMessage != null) {
                switch (socketResponsedMessage.getCmd()) {
                    case CmdConfigSocket.CMD_ADD_GROUP /* 103101 */:
                    case CmdConfigSocket.CMD_JOIN_GROUP /* 103110 */:
                    case CmdConfigSocket.CMD_REMOVE_MEMBERS /* 103112 */:
                        CommonGroupChatActiviy.this.ieN.refresh();
                        return;
                    case CmdConfigSocket.CMD_DISSMISS_GROUP /* 103104 */:
                        if (socketResponsedMessage instanceof ResponseDismissGroupMessage) {
                            ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
                            if (responseDismissGroupMessage.getError() == 0 && (CommonGroupChatActiviy.this.ieO instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) CommonGroupChatActiviy.this.ieO).getGroup()) != null && group.getGroupId() == responseDismissGroupMessage.getGroupId()) {
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
                        CommonGroupChatActiviy.this.ieN.refresh();
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
                                CommonGroupChatActiviy.this.ieN.refresh();
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
    protected abstract boolean am(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected abstract void initView();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void ccw() {
        super.ccw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ccx() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra("is_accept_notify", true);
        if (this.ieO != null) {
            this.ieO.setIsAcceptNotify(booleanExtra);
            am(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void an(Bundle bundle) throws Exception {
        this.ieO.setIsAcceptNotify(bundle.getBoolean("is_accept_notify", true));
        ao(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ao(Bundle bundle) {
        String string = bundle.getString(TbEnum.ParamKey.GROUP);
        if (!StringUtils.isNull(string)) {
            ((CommonGroupMsglistModel) this.ieO).setGroup((GroupData) OrmObject.objectWithJsonStr(string, GroupData.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void am(Intent intent) {
        GroupData groupData = (GroupData) intent.getSerializableExtra(TbEnum.ParamKey.GROUP);
        String stringExtra = intent.getStringExtra(GroupChatActivityConfig.GROUP_OBJ_TP);
        String valueOf = String.valueOf(groupData.getGroupId());
        if (!PvCacheModel.getInstance().isSameDay(valueOf)) {
            new com.baidu.tieba.im.util.c(TbConfig.ST_TYPE_IM, stringExtra, valueOf).start();
            TiebaStatic.eventStat(TbadkApplication.getInst().getApp(), TbConfig.ST_TYPE_IM, "", 1, "obj_tp", stringExtra, "group_id", valueOf);
            PvCacheModel.getInstance().addCacheData(valueOf, Long.valueOf(System.currentTimeMillis()));
        }
        ((CommonGroupMsglistModel) this.ieO).setGroup(groupData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_accept_notify", this.ieO.getIsAcceptNotify());
        if (((CommonGroupMsglistModel) this.ieO).getGroup() != null) {
            bundle.putString(TbEnum.ParamKey.GROUP, OrmObject.jsonStrWithObject(((CommonGroupMsglistModel) this.ieO).getGroup()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ccy() {
        GroupData group = ((CommonGroupMsglistModel) this.ieO).getGroup();
        return (group == null || group.getGroupId() == 0) ? false : true;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.b
    public void onItemViewLongClick(View view, int i, int i2, long j) {
        super.onItemViewLongClick(view, i, i2, j);
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.b.a
    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        String content;
        ChatMessage msg2;
        super.onItemViewClick(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg3 = this.ieO.getMsg(i2);
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
                if (cdi() && (msg2 = this.ieO.getMsg(i2)) != null && com.baidu.tieba.im.util.e.o(msg2)) {
                    String au = com.baidu.tieba.im.util.e.au(msg2.getContent(), true);
                    String au2 = com.baidu.tieba.im.util.e.au(msg2.getContent(), false);
                    if (au != null && (this.ieO instanceof CommonGroupMsglistModel) && ((CommonGroupMsglistModel) this.ieO).getGroup() != null) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupMsgImageActivityConfig(getPageContext().getContext(), au, ((CommonGroupMsglistModel) this.ieO).getGroup().getGroupId(), false, String.valueOf(msg2.getMsgId()), au2)));
                        return;
                    }
                    return;
                }
                return;
            case 7:
                if (cdi() && this.ieO != null && (msg = this.ieO.getMsg(i2)) != null && com.baidu.tieba.im.util.e.p(msg) && (content = msg.getContent()) != null) {
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
                        sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(getPageContext().getContext(), jSONObject.optString("pid"), jSONObject.optString("packet_name"), jSONObject.optString(AlaStaticKeys.ALA_STATIC_VALUE_ICON), jSONObject.optString("url_s"), optString, jSONObject.optString("face_name"), 3, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void ccz() {
        super.ccz();
        registerListener((int) CmdConfigSocket.CMD_JOIN_GROUP, this.icV);
        registerListener((int) CmdConfigSocket.CMD_ADD_GROUP, this.icV);
        registerListener((int) CmdConfigSocket.CMD_REMOVE_MEMBERS, this.icV);
        registerListener((int) CmdConfigSocket.CMD_DISSMISS_GROUP, this.icV);
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
    public void ccA() {
        super.ccA();
        MessageManager.getInstance().unRegisterListener(this.icV);
        MessageManager.getInstance().unRegisterListener(this.mCustomListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(GroupNewsPojo groupNewsPojo) {
        GroupData group;
        if (groupNewsPojo != null && this.ieO != null && (this.ieO instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.ieO).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_KICKED_OUT) && string.equals(String.valueOf(group.getGroupId()))) {
                    showToast(TbadkApplication.getInst().getString(R.string.group_is_kicked), false);
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
        if (groupNewsPojo != null && this.ieO != null && (this.ieO instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.ieO).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
                String string = jSONObject2.getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY) && string.equals(String.valueOf(group.getGroupId()))) {
                    String string2 = jSONObject2.getString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                    if (!TextUtils.isEmpty(string2)) {
                        this.ieN.refreshHeaderFooter(string2, true);
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
        if (groupNewsPojo != null && this.ieO != null && (this.ieO instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.ieO).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
                if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP) && string.equals(String.valueOf(group.getGroupId()))) {
                    showToast(TbadkApplication.getInst().getString(R.string.group_is_dismiss), false);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

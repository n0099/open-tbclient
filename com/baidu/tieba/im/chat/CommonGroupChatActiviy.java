package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.PvCacheModel;
import com.baidu.tieba.n;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class CommonGroupChatActiviy<T> extends MsglistActivity<T> {
    private com.baidu.adp.framework.listener.e mListener = new m(this, 0);
    private CustomMessageListener mCustomListener = new n(this, 0);

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected abstract boolean initData(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected abstract void initView();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        super.refreshHeadIcon();
    }

    protected void initParam() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(IntentConfig.IS_ACCEPT_NOTIFY, true);
        if (this.mListModel != null) {
            this.mListModel.setIsAcceptNotify(booleanExtra);
            onInitParam(intent);
        }
    }

    protected void initParam(Bundle bundle) {
        this.mListModel.setIsAcceptNotify(bundle.getBoolean(IntentConfig.IS_ACCEPT_NOTIFY, true));
        onInitParam(bundle);
    }

    protected void onInitParam(Bundle bundle) {
        ((CommonGroupMsglistModel) this.mListModel).setGroup((GroupData) bundle.getSerializable("group"));
    }

    protected void onInitParam(Intent intent) {
        GroupData groupData = (GroupData) intent.getSerializableExtra("group");
        String stringExtra = intent.getStringExtra(GroupChatActivityConfig.GROUP_OBJ_TP);
        String valueOf = String.valueOf(groupData.getGroupId());
        if (!PvCacheModel.getInstance().isSameDay(valueOf)) {
            new com.baidu.tieba.im.util.f(TbConfig.ST_TYPE_IM, stringExtra, valueOf).start();
            TiebaStatic.eventStat(TbadkApplication.getInst().getApp(), TbConfig.ST_TYPE_IM, "", 1, "obj_tp", stringExtra, "group_id", valueOf);
            PvCacheModel.getInstance().addCacheData(valueOf, Long.valueOf(System.currentTimeMillis()));
        }
        ((CommonGroupMsglistModel) this.mListModel).setGroup(groupData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(IntentConfig.IS_ACCEPT_NOTIFY, this.mListModel.getIsAcceptNotify());
        bundle.putSerializable("group", ((CommonGroupMsglistModel) this.mListModel).getGroup());
    }

    protected boolean checkParam() {
        GroupData group = ((CommonGroupMsglistModel) this.mListModel).getGroup();
        return (group == null || group.getGroupId() == 0) ? false : true;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.b
    public void onItemViewLongClick(View view, int i, int i2, long j) {
        super.onItemViewLongClick(view, i, i2, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        String content;
        JSONObject jSONObject;
        JSONArray jSONArray;
        ChatMessage msg2;
        super.onItemViewClick(view, i, i2, j);
        switch (i) {
            case 2:
                ChatMessage msg3 = this.mListModel.getMsg(i2);
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
                if (isExStorageOk() && (msg2 = this.mListModel.getMsg(i2)) != null && com.baidu.tieba.im.util.h.p(msg2)) {
                    String z = com.baidu.tieba.im.util.h.z(msg2.getContent(), true);
                    String z2 = com.baidu.tieba.im.util.h.z(msg2.getContent(), false);
                    if (z != null && (this.mListModel instanceof CommonGroupMsglistModel) && ((CommonGroupMsglistModel) this.mListModel).getGroup() != null) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupMsgImageActivityConfig(getPageContext().getContext(), z, ((CommonGroupMsglistModel) this.mListModel).getGroup().getGroupId(), false, String.valueOf(msg2.getMsgId()), z2)));
                        return;
                    }
                    return;
                }
                return;
            case 7:
                if (isExStorageOk() && this.mListModel != null && (msg = this.mListModel.getMsg(i2)) != null && com.baidu.tieba.im.util.h.q(msg) && (content = msg.getContent()) != null) {
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
                            sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_FACESHOP_EMOTIONIMAGE, new EmotionImageActivityConfig(getPageContext().getContext(), jSONObject.optString(Info.kBaiduPIDKey), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), jSONObject.optString("url_d"), jSONObject.optString("face_name"), 3, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
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
    public void regReceiver() {
        super.regReceiver();
        registerListener(103110, this.mListener);
        registerListener(103101, this.mListener);
        registerListener(103112, this.mListener);
        registerListener(103104, this.mListener);
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
    public void unregReceiver() {
        super.unregReceiver();
        MessageManager.getInstance().unRegisterListener(this.mListener);
        MessageManager.getInstance().unRegisterListener(this.mCustomListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processKick(GroupNewsPojo groupNewsPojo) {
        GroupData group;
        if (groupNewsPojo != null && this.mListModel != null && (this.mListModel instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.mListModel).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("003") && string.equals(String.valueOf(group.getGroupId()))) {
                    showToast(TbadkApplication.getInst().getString(n.i.group_is_kicked), false);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processTitleChange(GroupNewsPojo groupNewsPojo) {
        GroupData group;
        if (groupNewsPojo != null && this.mListModel != null && (this.mListModel instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.mListModel).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                JSONObject jSONObject2 = jSONObject.getJSONObject("eventParam");
                String string = jSONObject2.getString("groupId");
                if (jSONObject.getString("eventId").equals("101") && string.equals(String.valueOf(group.getGroupId()))) {
                    String string2 = jSONObject2.getString("groupName");
                    if (!TextUtils.isEmpty(string2)) {
                        this.mListView.refreshHeaderFooter(string2, true);
                        group.setName(string2);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDismissGroup(GroupNewsPojo groupNewsPojo) {
        GroupData group;
        if (groupNewsPojo != null && this.mListModel != null && (this.mListModel instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) this.mListModel).getGroup()) != null) {
            try {
                JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
                String string = jSONObject.getJSONObject("eventParam").getString("groupId");
                if (jSONObject.getString("eventId").equals("107") && string.equals(String.valueOf(group.getGroupId()))) {
                    showToast(TbadkApplication.getInst().getString(n.i.group_is_dismiss), false);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.baidu.tieba.im.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupMsgImageActivityConfig;
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
public abstract class CommonGroupChatActiviy<T> extends MsglistActivity<T> {
    private com.baidu.adp.framework.listener.e mListener = new x(this, 0);
    private CustomMessageListener mCustomListener = new y(this, 0);

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected abstract boolean initData(Bundle bundle);

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    protected abstract void initView();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        super.refreshHeadIcon();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initParam() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, true);
        if (this.mListModel != null) {
            this.mListModel.setIsAcceptNotify(booleanExtra);
            onInitParam(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initParam(Bundle bundle) {
        this.mListModel.setIsAcceptNotify(bundle.getBoolean(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, true));
        onInitParam(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onInitParam(Bundle bundle) {
        ((CommonGroupMsglistModel) this.mListModel).setGroup((GroupData) bundle.getSerializable("group"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onInitParam(Intent intent) {
        GroupData groupData = (GroupData) intent.getSerializableExtra("group");
        String stringExtra = intent.getStringExtra(GroupChatActivityConfig.GROUP_OBJ_TP);
        String valueOf = String.valueOf(groupData.getGroupId());
        if (!PvCacheModel.getInstance().isSameDay(valueOf)) {
            new com.baidu.tieba.im.util.g(TbConfig.ST_TYPE_IM, stringExtra, valueOf).start();
            TiebaStatic.eventStat(TbadkApplication.getInst().getApp(), TbConfig.ST_TYPE_IM, "", 1, "obj_tp", stringExtra, "group_id", valueOf);
            PvCacheModel.getInstance().addCacheData(valueOf, Long.valueOf(System.currentTimeMillis()));
        }
        ((CommonGroupMsglistModel) this.mListModel).setGroup(groupData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(com.baidu.tbadk.core.frameworkData.a.IS_ACCEPT_NOTIFY, this.mListModel.getIsAcceptNotify());
        bundle.putSerializable("group", ((CommonGroupMsglistModel) this.mListModel).getGroup());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkParam() {
        GroupData group = ((CommonGroupMsglistModel) this.mListModel).getGroup();
        return (group == null || group.getGroupId() == 0) ? false : true;
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.b
    public void onItemViewLongClick(View view, int i, int i2, long j) {
        super.onItemViewLongClick(view, i, i2, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, com.baidu.adp.lib.c.a
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
                if (isExStorageOk() && (msg2 = this.mListModel.getMsg(i2)) != null && com.baidu.tieba.im.util.i.p(msg2)) {
                    String t = com.baidu.tieba.im.util.i.t(msg2.getContent(), true);
                    String t2 = com.baidu.tieba.im.util.i.t(msg2.getContent(), false);
                    if (t != null && (this.mListModel instanceof CommonGroupMsglistModel) && ((CommonGroupMsglistModel) this.mListModel).getGroup() != null) {
                        sendMessage(new CustomMessage(2002001, new GroupMsgImageActivityConfig(getPageContext().getContext(), t, ((CommonGroupMsglistModel) this.mListModel).getGroup().getGroupId(), false, String.valueOf(msg2.getMsgId()), t2)));
                        return;
                    }
                    return;
                }
                return;
            case 7:
                if (isExStorageOk() && this.mListModel != null && (msg = this.mListModel.getMsg(i2)) != null && com.baidu.tieba.im.util.i.q(msg) && (content = msg.getContent()) != null) {
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
                            sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(getPageContext().getContext(), jSONObject.optString("pid"), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), jSONObject.optString("url_d"), jSONObject.optString("face_name"), 3, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
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
        registerListener(2001109, this.mCustomListener);
        registerListener(2001130, this.mCustomListener);
        registerListener(2001132, this.mCustomListener);
        registerListener(2001138, this.mCustomListener);
        registerListener(2001136, this.mCustomListener);
        registerListener(2001134, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
        registerListener(2001141, this.mCustomListener);
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
                    showToast(TbadkApplication.getInst().getString(com.baidu.tieba.y.group_is_kicked), false);
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
                    showToast(TbadkApplication.getInst().getString(com.baidu.tieba.y.group_is_dismiss), false);
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

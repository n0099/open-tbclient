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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionImageActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.GroupMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.CommonGroupMsglistModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.model.PvCacheModel;
import d.b.c.c.g.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class CommonGroupChatActiviy<T> extends MsglistActivity<T> {
    public c mListener = new a(0);
    public CustomMessageListener mCustomListener = new b(0);

    /* loaded from: classes4.dex */
    public class a extends c {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            GroupData group;
            if (socketResponsedMessage == null) {
                return;
            }
            switch (socketResponsedMessage.getCmd()) {
                case 103101:
                case 103110:
                case 103112:
                    CommonGroupChatActiviy.this.mListView.refresh();
                    return;
                case 103104:
                    if (socketResponsedMessage instanceof ResponseDismissGroupMessage) {
                        ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
                        if (responseDismissGroupMessage.getError() != 0) {
                            return;
                        }
                        MsglistModel msglistModel = CommonGroupChatActiviy.this.mListModel;
                        if ((msglistModel instanceof CommonGroupMsglistModel) && (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) != null && group.getGroupId() == responseDismissGroupMessage.getGroupId()) {
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

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage == null) {
                return;
            }
            switch (customResponsedMessage.getCmd()) {
                case 2001109:
                    CommonGroupChatActiviy.this.mListView.refresh();
                    return;
                case 2001126:
                case 2001128:
                case 2001130:
                case 2001132:
                case 2001133:
                case 2001134:
                case 2001137:
                    if (!(customResponsedMessage instanceof PushMessage) || (p = ((PushMessage) customResponsedMessage).getP()) == null) {
                        return;
                    }
                    String cmd = p.getCmd();
                    if (TextUtils.isEmpty(cmd)) {
                        return;
                    }
                    CommonGroupChatActiviy.this.mListView.refresh();
                    if (cmd.equals("apply_join_success")) {
                        return;
                    }
                    if (cmd.equals("kick_out")) {
                        CommonGroupChatActiviy.this.processKick(p);
                        return;
                    } else if (cmd.equals("group_name_change")) {
                        CommonGroupChatActiviy.this.processTitleChange(p);
                        return;
                    } else if (cmd.equals("dismiss_group")) {
                        CommonGroupChatActiviy.this.processDismissGroup(p);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDismissGroup(GroupNewsPojo groupNewsPojo) {
        MsglistModel msglistModel;
        GroupData group;
        if (groupNewsPojo == null || (msglistModel = this.mListModel) == null || !(msglistModel instanceof CommonGroupMsglistModel) || (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
            String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
            if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP) && string.equals(String.valueOf(group.getGroupId()))) {
                showToast(TbadkApplication.getInst().getString(R.string.group_is_dismiss), false);
                finish();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processKick(GroupNewsPojo groupNewsPojo) {
        MsglistModel msglistModel;
        GroupData group;
        if (groupNewsPojo == null || (msglistModel = this.mListModel) == null || !(msglistModel instanceof CommonGroupMsglistModel) || (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
            String string = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM).getString(TbEnum.SystemMessage.KEY_GROUP_ID);
            if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals(TbEnum.SystemMessage.EVENT_ID_KICKED_OUT) && string.equals(String.valueOf(group.getGroupId()))) {
                showToast(TbadkApplication.getInst().getString(R.string.group_is_kicked), false);
                finish();
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processTitleChange(GroupNewsPojo groupNewsPojo) {
        MsglistModel msglistModel;
        GroupData group;
        if (groupNewsPojo == null || (msglistModel = this.mListModel) == null || !(msglistModel instanceof CommonGroupMsglistModel) || (group = ((CommonGroupMsglistModel) msglistModel).getGroup()) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(groupNewsPojo.getContent());
            JSONObject jSONObject2 = jSONObject.getJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            String string = jSONObject2.getString(TbEnum.SystemMessage.KEY_GROUP_ID);
            if (jSONObject.getString(TbEnum.SystemMessage.KEY_EVENT_ID).equals("101") && string.equals(String.valueOf(group.getGroupId()))) {
                String string2 = jSONObject2.getString(TbEnum.SystemMessage.KEY_GROUP_NAME);
                if (TextUtils.isEmpty(string2)) {
                    return;
                }
                this.mListView.refreshHeaderFooter(string2, true);
                group.setName(string2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public boolean checkParam() {
        GroupData group = ((CommonGroupMsglistModel) this.mListModel).getGroup();
        return (group == null || group.getGroupId() == 0) ? false : true;
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public abstract boolean initData(Bundle bundle);

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

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public abstract void initView();

    public void onInitParam(Bundle bundle) {
        String string = bundle.getString("group");
        if (StringUtils.isNull(string)) {
            return;
        }
        ((CommonGroupMsglistModel) this.mListModel).setGroup((GroupData) OrmObject.objectWithJsonStr(string, GroupData.class));
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
        r0 = r0.getContent();
     */
    @Override // com.baidu.tieba.im.chat.TalkableActivity, d.b.c.e.h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemViewClick(View view, int i, int i2, long j) {
        ChatMessage msg;
        MsglistModel msglistModel;
        ChatMessage msg2;
        String content;
        super.onItemViewClick(view, i, i2, j);
        if (i == 2) {
            ChatMessage msg3 = this.mListModel.getMsg(i2);
            if (msg3 == null || msg3.getUserInfo() == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getContext(), msg3.getUserInfo().getUserId(), msg3.getUserInfo().getUserName(), null, AddFriendActivityConfig.TYPE_IM_GROUP)));
        } else if (i != 4) {
            if (i == 7 && isExStorageOk() && (msglistModel = this.mListModel) != null && (msg2 = msglistModel.getMsg(i2)) != null && d.b.j0.e1.w.c.q(msg2) && content != null) {
                JSONObject jSONObject = null;
                try {
                    try {
                        JSONArray jSONArray = new JSONArray(content);
                        if (jSONArray.length() > 0) {
                            jSONObject = jSONArray.getJSONObject(0);
                        }
                    } catch (Exception unused) {
                        jSONObject = new JSONObject(content);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                if (jSONObject != null) {
                    String optString = jSONObject.optString("url_d");
                    sendMessage(new CustomMessage(2902011, new EmotionImageActivityConfig(getPageContext().getContext(), jSONObject.optString("pid"), jSONObject.optString("packet_name"), jSONObject.optString("icon"), jSONObject.optString("url_s"), optString, jSONObject.optString("face_name"), 3, jSONObject.optInt("size_width"), jSONObject.optInt("size_height"))));
                }
            }
        } else if (isExStorageOk() && (msg = this.mListModel.getMsg(i2)) != null && d.b.j0.e1.w.c.s(msg)) {
            String f2 = d.b.j0.e1.w.c.f(msg.getContent(), true);
            String f3 = d.b.j0.e1.w.c.f(msg.getContent(), false);
            if (f2 == null) {
                return;
            }
            MsglistModel msglistModel2 = this.mListModel;
            if (!(msglistModel2 instanceof CommonGroupMsglistModel) || ((CommonGroupMsglistModel) msglistModel2).getGroup() == null) {
                return;
            }
            sendMessage(new CustomMessage(2002001, new GroupMsgImageActivityConfig(getPageContext().getContext(), f2, ((CommonGroupMsglistModel) this.mListModel).getGroup().getGroupId(), false, String.valueOf(msg.getMsgId()), f3)));
        }
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, d.b.c.e.h.b
    public void onItemViewLongClick(View view, int i, int i2, long j) {
        super.onItemViewLongClick(view, i, i2, j);
    }

    @Override // com.baidu.tieba.im.chat.TalkableActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(IntentConfig.IS_ACCEPT_NOTIFY, this.mListModel.getIsAcceptNotify());
        if (((CommonGroupMsglistModel) this.mListModel).getGroup() != null) {
            bundle.putString("group", OrmObject.jsonStrWithObject(((CommonGroupMsglistModel) this.mListModel).getGroup()));
        }
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void refreshHeadIcon() {
        super.refreshHeadIcon();
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void regReceiver() {
        super.regReceiver();
        registerListener(103110, this.mListener);
        registerListener(103101, this.mListener);
        registerListener(103112, this.mListener);
        registerListener(103104, this.mListener);
        registerListener(2001109, this.mCustomListener);
        registerListener(2001126, this.mCustomListener);
        registerListener(2001128, this.mCustomListener);
        registerListener(2001134, this.mCustomListener);
        registerListener(2001132, this.mCustomListener);
        registerListener(2001130, this.mCustomListener);
        registerListener(2001133, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
    }

    @Override // com.baidu.tieba.im.chat.MsglistActivity
    public void unregReceiver() {
        super.unregReceiver();
        MessageManager.getInstance().unRegisterListener(this.mListener);
        MessageManager.getInstance().unRegisterListener(this.mCustomListener);
    }

    public void onInitParam(Intent intent) {
        GroupData groupData = (GroupData) intent.getSerializableExtra("group");
        String stringExtra = intent.getStringExtra(GroupChatActivityConfig.GROUP_OBJ_TP);
        String valueOf = String.valueOf(groupData.getGroupId());
        if (!PvCacheModel.getInstance().isSameDay(valueOf)) {
            new d.b.j0.e1.w.a(TbConfig.ST_TYPE_IM, stringExtra, valueOf).start();
            TiebaStatic.eventStat(TbadkApplication.getInst().getApp(), TbConfig.ST_TYPE_IM, "", 1, "obj_tp", stringExtra, "group_id", valueOf);
            PvCacheModel.getInstance().addCacheData(valueOf, Long.valueOf(System.currentTimeMillis()));
        }
        ((CommonGroupMsglistModel) this.mListModel).setGroup(groupData);
    }

    public void initParam(Bundle bundle) throws Exception {
        this.mListModel.setIsAcceptNotify(bundle.getBoolean(IntentConfig.IS_ACCEPT_NOTIFY, true));
        onInitParam(bundle);
    }
}

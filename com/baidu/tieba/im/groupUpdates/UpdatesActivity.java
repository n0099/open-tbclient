package com.baidu.tieba.im.groupUpdates;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.GroupLevelActivityConfig;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestDelSystemMessage;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.model.UpdatesModel;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes26.dex */
public class UpdatesActivity extends BaseActivity<UpdatesActivity> implements AbsListView.OnScrollListener {
    private c kyo;
    private i kyp;
    private m<LinkedList<GroupNewsPojo>> kyq;
    private m<Boolean> kyr;
    private Runnable kys;
    private UpdatesItemData kyt;
    private UpdatesModel kyu;
    private boolean iRI = false;
    private com.baidu.adp.framework.listener.c kjh = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UpdatesActivity.this.kyo.sJ(false);
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    if (UpdatesActivity.this.kyt != null) {
                        UpdatesModel.deleteUpdatesData(UpdatesActivity.this.kyt, UpdatesActivity.this.kyr);
                        UpdatesActivity.this.kyt = null;
                    }
                    if (UpdatesActivity.this.kyu != null && UpdatesActivity.this.kyu.getDeleteSize() > 0) {
                        UpdatesActivity.this.kyu.deleteDatas(UpdatesActivity.this.kyr);
                    }
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdatesActivity.this.kyo.sJ(false);
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage)) {
                int cmd = customResponsedMessage.getCmd();
                if (2001132 == cmd || 2001133 == cmd || 2001130 == cmd || 2001129 == cmd || 2001137 == cmd) {
                    UpdatesModel.requestUpdatesDataFromDB(UpdatesActivity.this.kyq);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kyu = new UpdatesModel();
        this.kyo = new c(this);
        cYs();
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.mCustomListener);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.mCustomListener);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.mCustomListener);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NOTICE_CHANGE, this.mCustomListener);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.mCustomListener);
        this.kyo.sJ(true);
        UpdatesModel.requestUpdatesDataFromDB(this.kyq);
        registerListener(CmdConfigSocket.CMD_DELETE_GROUP_MSG, this.kjh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(6, true);
        com.baidu.tbadk.coreExtra.messageCenter.b.byI().rG(2);
        com.baidu.tbadk.coreExtra.messageCenter.b.byI().byS();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.GROUP_UPDATE, -3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(6, false);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        ChatStatusManager.getInst().setIsOpen(6, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ChatStatusManager.getInst().setIsOpen(6, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ChatStatusManager.getInst().setIsOpen(6, false);
    }

    private void cYs() {
        final m<LinkedList<GroupNewsPojo>> mVar = new m<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: o */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.kyo.setData(convertToUpdatesItemData);
                UpdatesActivity.this.kyu.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.kyo.sJ(false);
                UpdatesActivity.this.kyo.Et(UpdatesActivity.this.kyu.getDeleteSize());
                UpdatesActivity.this.Yq();
                ImMessageCenterPojo imMessageCenterPojo = null;
                if (convertToUpdatesItemData != null && convertToUpdatesItemData.size() > 0) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    imMessageCenterPojo2.setLast_content(convertToUpdatesItemData.get(0).getContent());
                    imMessageCenterPojo2.setLast_content_time(convertToUpdatesItemData.get(0).getTime());
                    imMessageCenterPojo = imMessageCenterPojo2;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETED_GROUP_UPDATE, imMessageCenterPojo));
                if (convertToUpdatesItemData != null && convertToUpdatesItemData.size() == 0) {
                    UpdatesActivity.this.finish();
                }
            }
        };
        this.kyr = new m<Boolean>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            public void onReturnDataInUI(Boolean bool) {
                UpdatesActivity.this.kyu.clearSelect();
                UpdatesActivity.this.kyo.cYw();
                UpdatesActivity.this.sI(false);
                UpdatesModel.requestUpdatesDataFromDB(mVar);
            }
        };
        this.kyq = new m<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: o */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.kyo.setData(convertToUpdatesItemData);
                UpdatesActivity.this.kyu.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.kyo.sJ(false);
                UpdatesActivity.this.kyo.Et(UpdatesActivity.this.kyu.getDeleteSize());
                UpdatesActivity.this.Yq();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kyo != null) {
            this.kyo.destroy();
        }
        if (this.kyu != null) {
            this.kyu.destory();
        }
        this.kyt = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.kyo != null) {
            if (view.equals(this.kyo.cYx())) {
                finish();
            } else if (view.equals(this.kyo.cYz())) {
                this.kyu.clearSelect();
                this.kyu.calculateSelects(this.kyo.cYu().getDatas());
                this.kyo.Et(this.kyu.getDeleteSize());
                sI(true);
                this.kyo.cYv();
            } else if (view.equals(this.kyo.cYA())) {
                sI(false);
                this.kyo.cYw();
                this.kyu.clearSelect();
                UpdatesModel.requestUpdatesDataFromDB(this.kyq);
            } else if (view.equals(this.kyo.cYB())) {
                this.kyo.sJ(true);
                String deleteDatasIds = this.kyu.deleteDatasIds();
                if (!TextUtils.isEmpty(deleteDatasIds)) {
                    NI(deleteDatasIds);
                } else {
                    this.kyo.sJ(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && keyEvent.getAction() == 0 && this.iRI) {
            sI(false);
            this.kyu.clearSelect();
            this.kyo.Et(this.kyu.getDeleteSize());
            this.kyo.cYw();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.b.cZG().cZI()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.b.cZG().cZI()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.kyo.sJ(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.f.b.toLong(com.baidu.tieba.im.pushNotify.b.cZG().cZI(), 0L));
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(updatesItemData.getNotice_id()) / 100));
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void NI(String str) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String cZI = com.baidu.tieba.im.pushNotify.b.cZG().cZI();
            if (!TextUtils.isEmpty(cZI) && TextUtils.isDigitsOnly(cZI)) {
                this.kyo.sJ(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.f.b.toLong(cZI, 0L));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kyo != null) {
            this.kyo.onChangeSkinType(i);
        }
    }

    public void a(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !cAY()) {
            String groupId = updatesItemData.getGroupId();
            String updatesType = updatesItemData.getUpdatesType();
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupLevelActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(groupId, 0L), updatesItemData.isShown())));
                    } else if (!updatesType.equals("dismiss_group")) {
                        if (updatesType.equals("group_event_info")) {
                            TiebaStatic.log("update_activity_group_event_click");
                            bf.bua().b(getPageContext(), new String[]{updatesItemData.getEventLink()});
                        } else if (updatesType.equals("group_activitys_change")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupActivityActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toInt(updatesItemData.getGroupActivityId(), 0), com.baidu.adp.lib.f.b.toLong(updatesItemData.getGroupId(), 0L), 1)));
                        } else {
                            sendMessage(new CustomMessage((int) CmdConfigCustom.IM_GROUP_INFO_ACTIVITY_START, new GroupInfoActivityConfig(getPageContext().getPageActivity(), Long.parseLong(groupId), 0)));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void a(View view, boolean z, UpdatesItemData updatesItemData) {
        if (updatesItemData != null) {
            if (z) {
                this.kyu.addSelect(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.kyu.getDeleteSize() > 100) {
                    this.kyu.cancelSelect(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(R.string.updates_activity_del_limit);
                }
            } else {
                this.kyu.cancelSelect(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.kyo.Et(this.kyu.getDeleteSize());
            this.kyo.cXn();
        }
    }

    public void b(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !cAY()) {
            if (this.kyp == null) {
                this.kyt = updatesItemData;
                cYt();
            }
            this.kyp.RU();
        }
    }

    private void cYt() {
        String string = getPageContext().getString(R.string.delete_user_chat);
        k.c cVar = new k.c() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (UpdatesActivity.this.kyp != null && UpdatesActivity.this.kyp.isShowing()) {
                    UpdatesActivity.this.kyp.dismiss();
                }
                switch (i) {
                    case 0:
                        UpdatesActivity.this.kyo.sJ(true);
                        UpdatesActivity.this.a(UpdatesActivity.this.kyt);
                        return;
                    default:
                        return;
                }
            }
        };
        this.kyp = new i(getPageContext());
        this.kyp.a(null, new String[]{string}, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yq() {
        if (this.kyo.cYy() != null) {
            this.kyo.cYy().removeCallbacks(this.kys);
            this.kyo.cYy().post(this.kys);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            Yq();
        }
    }

    public boolean cAY() {
        return this.iRI;
    }

    public void sI(boolean z) {
        this.iRI = z;
    }
}

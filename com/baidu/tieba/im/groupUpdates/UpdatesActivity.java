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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestDelSystemMessage;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.model.UpdatesModel;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes20.dex */
public class UpdatesActivity extends BaseActivity<UpdatesActivity> implements AbsListView.OnScrollListener {
    private c jfc;
    private i jfd;
    private l<LinkedList<GroupNewsPojo>> jfe;
    private l<Boolean> jff;
    private Runnable jfg;
    private UpdatesItemData jfh;
    private UpdatesModel jfi;
    private boolean hEm = false;
    private com.baidu.adp.framework.listener.c iPM = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UpdatesActivity.this.jfc.qh(false);
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    if (UpdatesActivity.this.jfh != null) {
                        UpdatesModel.deleteUpdatesData(UpdatesActivity.this.jfh, UpdatesActivity.this.jff);
                        UpdatesActivity.this.jfh = null;
                    }
                    if (UpdatesActivity.this.jfi != null && UpdatesActivity.this.jfi.getDeleteSize() > 0) {
                        UpdatesActivity.this.jfi.deleteDatas(UpdatesActivity.this.jff);
                    }
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdatesActivity.this.jfc.qh(false);
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage)) {
                int cmd = customResponsedMessage.getCmd();
                if (2001132 == cmd || 2001133 == cmd || 2001130 == cmd || 2001129 == cmd || 2001137 == cmd) {
                    UpdatesModel.requestUpdatesDataFromDB(UpdatesActivity.this.jfe);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jfi = new UpdatesModel();
        this.jfc = new c(this);
        cvK();
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.mCustomListener);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.mCustomListener);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.mCustomListener);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NOTICE_CHANGE, this.mCustomListener);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.mCustomListener);
        this.jfc.qh(true);
        UpdatesModel.requestUpdatesDataFromDB(this.jfe);
        registerListener(CmdConfigSocket.CMD_DELETE_GROUP_MSG, this.iPM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(6, true);
        com.baidu.tbadk.coreExtra.messageCenter.b.bfl().nr(2);
        com.baidu.tbadk.coreExtra.messageCenter.b.bfl().bfv();
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

    private void cvK() {
        final l<LinkedList<GroupNewsPojo>> lVar = new l<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: o */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.jfc.setData(convertToUpdatesItemData);
                UpdatesActivity.this.jfi.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.jfc.qh(false);
                UpdatesActivity.this.jfc.za(UpdatesActivity.this.jfi.getDeleteSize());
                UpdatesActivity.this.KG();
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
        this.jff = new l<Boolean>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            public void onReturnDataInUI(Boolean bool) {
                UpdatesActivity.this.jfi.clearSelect();
                UpdatesActivity.this.jfc.cvO();
                UpdatesActivity.this.qg(false);
                UpdatesModel.requestUpdatesDataFromDB(lVar);
            }
        };
        this.jfe = new l<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: o */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.jfc.setData(convertToUpdatesItemData);
                UpdatesActivity.this.jfi.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.jfc.qh(false);
                UpdatesActivity.this.jfc.za(UpdatesActivity.this.jfi.getDeleteSize());
                UpdatesActivity.this.KG();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jfc != null) {
            this.jfc.destroy();
        }
        if (this.jfi != null) {
            this.jfi.destory();
        }
        this.jfh = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.jfc != null) {
            if (view.equals(this.jfc.cvP())) {
                finish();
            } else if (view.equals(this.jfc.cvR())) {
                this.jfi.clearSelect();
                this.jfi.calculateSelects(this.jfc.cvM().getDatas());
                this.jfc.za(this.jfi.getDeleteSize());
                qg(true);
                this.jfc.cvN();
            } else if (view.equals(this.jfc.cvS())) {
                qg(false);
                this.jfc.cvO();
                this.jfi.clearSelect();
                UpdatesModel.requestUpdatesDataFromDB(this.jfe);
            } else if (view.equals(this.jfc.cvT())) {
                this.jfc.qh(true);
                String deleteDatasIds = this.jfi.deleteDatasIds();
                if (!TextUtils.isEmpty(deleteDatasIds)) {
                    Ia(deleteDatasIds);
                } else {
                    this.jfc.qh(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && keyEvent.getAction() == 0 && this.hEm) {
            qg(false);
            this.jfi.clearSelect();
            this.jfc.za(this.jfi.getDeleteSize());
            this.jfc.cvO();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.b.cwZ().cxb()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.b.cwZ().cxb()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.jfc.qh(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.f.b.toLong(com.baidu.tieba.im.pushNotify.b.cwZ().cxb(), 0L));
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(updatesItemData.getNotice_id()) / 100));
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void Ia(String str) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String cxb = com.baidu.tieba.im.pushNotify.b.cwZ().cxb();
            if (!TextUtils.isEmpty(cxb) && TextUtils.isDigitsOnly(cxb)) {
                this.jfc.qh(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.f.b.toLong(cxb, 0L));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jfc != null) {
            this.jfc.onChangeSkinType(i);
        }
    }

    public void a(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !caq()) {
            String groupId = updatesItemData.getGroupId();
            String updatesType = updatesItemData.getUpdatesType();
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupLevelActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(groupId, 0L), updatesItemData.isShown())));
                    } else if (!updatesType.equals("dismiss_group")) {
                        if (updatesType.equals("group_event_info")) {
                            TiebaStatic.log("update_activity_group_event_click");
                            bd.baV().b(getPageContext(), new String[]{updatesItemData.getEventLink()});
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
                this.jfi.addSelect(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.jfi.getDeleteSize() > 100) {
                    this.jfi.cancelSelect(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(R.string.updates_activity_del_limit);
                }
            } else {
                this.jfi.cancelSelect(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.jfc.za(this.jfi.getDeleteSize());
            this.jfc.cuF();
        }
    }

    public void b(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !caq()) {
            if (this.jfd == null) {
                this.jfh = updatesItemData;
                cvL();
            }
            this.jfd.showDialog();
        }
    }

    private void cvL() {
        String string = getPageContext().getString(R.string.delete_user_chat);
        k.c cVar = new k.c() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (UpdatesActivity.this.jfd != null && UpdatesActivity.this.jfd.isShowing()) {
                    UpdatesActivity.this.jfd.dismiss();
                }
                switch (i) {
                    case 0:
                        UpdatesActivity.this.jfc.qh(true);
                        UpdatesActivity.this.a(UpdatesActivity.this.jfh);
                        return;
                    default:
                        return;
                }
            }
        };
        this.jfd = new i(getPageContext());
        this.jfd.a(null, new String[]{string}, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KG() {
        if (this.jfc.cvQ() != null) {
            this.jfc.cvQ().removeCallbacks(this.jfg);
            this.jfc.cvQ().post(this.jfg);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            KG();
        }
    }

    public boolean caq() {
        return this.hEm;
    }

    public void qg(boolean z) {
        this.hEm = z;
    }
}

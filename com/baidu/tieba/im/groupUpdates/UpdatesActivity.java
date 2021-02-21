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
/* loaded from: classes8.dex */
public class UpdatesActivity extends BaseActivity<UpdatesActivity> implements AbsListView.OnScrollListener {
    private m<Boolean> kHA;
    private Runnable kHB;
    private UpdatesItemData kHC;
    private UpdatesModel kHD;
    private c kHx;
    private i kHy;
    private m<LinkedList<GroupNewsPojo>> kHz;
    private boolean jfi = false;
    private com.baidu.adp.framework.listener.c kAh = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UpdatesActivity.this.kHx.sW(false);
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    if (UpdatesActivity.this.kHC != null) {
                        UpdatesModel.deleteUpdatesData(UpdatesActivity.this.kHC, UpdatesActivity.this.kHA);
                        UpdatesActivity.this.kHC = null;
                    }
                    if (UpdatesActivity.this.kHD != null && UpdatesActivity.this.kHD.getDeleteSize() > 0) {
                        UpdatesActivity.this.kHD.deleteDatas(UpdatesActivity.this.kHA);
                    }
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdatesActivity.this.kHx.sW(false);
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage)) {
                int cmd = customResponsedMessage.getCmd();
                if (2001132 == cmd || 2001133 == cmd || 2001130 == cmd || 2001129 == cmd || 2001137 == cmd) {
                    UpdatesModel.requestUpdatesDataFromDB(UpdatesActivity.this.kHz);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kHD = new UpdatesModel();
        this.kHx = new c(this);
        cWz();
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_INTRO_CHANGE, this.mCustomListener);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_LEVEL_UP, this.mCustomListener);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NAME_CHANGE, this.mCustomListener);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_GROUP_NOTICE_CHANGE, this.mCustomListener);
        registerListener(CmdConfigCustom.CMD_IM_PUSH_NOTIFY_DISMISS_GROUP, this.mCustomListener);
        this.kHx.sW(true);
        UpdatesModel.requestUpdatesDataFromDB(this.kHz);
        registerListener(CmdConfigSocket.CMD_DELETE_GROUP_MSG, this.kAh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(6, true);
        com.baidu.tbadk.coreExtra.messageCenter.b.bxB().qr(2);
        com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxL();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.GROUP_UPDATE, -3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(6, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
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

    private void cWz() {
        final m<LinkedList<GroupNewsPojo>> mVar = new m<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: o */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.kHx.setData(convertToUpdatesItemData);
                UpdatesActivity.this.kHD.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.kHx.sW(false);
                UpdatesActivity.this.kHx.CZ(UpdatesActivity.this.kHD.getDeleteSize());
                UpdatesActivity.this.Xq();
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
        this.kHA = new m<Boolean>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            public void onReturnDataInUI(Boolean bool) {
                UpdatesActivity.this.kHD.clearSelect();
                UpdatesActivity.this.kHx.cWD();
                UpdatesActivity.this.sV(false);
                UpdatesModel.requestUpdatesDataFromDB(mVar);
            }
        };
        this.kHz = new m<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
            /* renamed from: o */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.kHx.setData(convertToUpdatesItemData);
                UpdatesActivity.this.kHD.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.kHx.sW(false);
                UpdatesActivity.this.kHx.CZ(UpdatesActivity.this.kHD.getDeleteSize());
                UpdatesActivity.this.Xq();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kHx != null) {
            this.kHx.destroy();
        }
        if (this.kHD != null) {
            this.kHD.destory();
        }
        this.kHC = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.kHx != null) {
            if (view.equals(this.kHx.cWF())) {
                finish();
            } else if (view.equals(this.kHx.cWH())) {
                this.kHD.clearSelect();
                this.kHD.calculateSelects(this.kHx.cWB().getDatas());
                this.kHx.CZ(this.kHD.getDeleteSize());
                sV(true);
                this.kHx.cWC();
            } else if (view.equals(this.kHx.cWI())) {
                sV(false);
                this.kHx.cWD();
                this.kHD.clearSelect();
                UpdatesModel.requestUpdatesDataFromDB(this.kHz);
            } else if (view.equals(this.kHx.cWJ())) {
                this.kHx.sW(true);
                String deleteDatasIds = this.kHD.deleteDatasIds();
                if (!TextUtils.isEmpty(deleteDatasIds)) {
                    MX(deleteDatasIds);
                } else {
                    this.kHx.sW(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && keyEvent.getAction() == 0 && this.jfi) {
            sV(false);
            this.kHD.clearSelect();
            this.kHx.CZ(this.kHD.getDeleteSize());
            this.kHx.cWD();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.b.cXG().cXI()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.b.cXG().cXI()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.kHx.sW(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.f.b.toLong(com.baidu.tieba.im.pushNotify.b.cXG().cXI(), 0L));
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(updatesItemData.getNotice_id()) / 100));
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void MX(String str) {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String cXI = com.baidu.tieba.im.pushNotify.b.cXG().cXI();
            if (!TextUtils.isEmpty(cXI) && TextUtils.isDigitsOnly(cXI)) {
                this.kHx.sW(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.f.b.toLong(cXI, 0L));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.kHx != null) {
            this.kHx.onChangeSkinType(i);
        }
    }

    public void a(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !cBs()) {
            String groupId = updatesItemData.getGroupId();
            String updatesType = updatesItemData.getUpdatesType();
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupLevelActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.f.b.toLong(groupId, 0L), updatesItemData.isShown())));
                    } else if (!updatesType.equals("dismiss_group")) {
                        if (updatesType.equals("group_event_info")) {
                            TiebaStatic.log("update_activity_group_event_click");
                            bf.bsV().b(getPageContext(), new String[]{updatesItemData.getEventLink()});
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
                this.kHD.addSelect(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.kHD.getDeleteSize() > 100) {
                    this.kHD.cancelSelect(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(R.string.updates_activity_del_limit);
                }
            } else {
                this.kHD.cancelSelect(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.kHx.CZ(this.kHD.getDeleteSize());
            this.kHx.cWE();
        }
    }

    public void b(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !cBs()) {
            if (this.kHy == null) {
                this.kHC = updatesItemData;
                cWA();
            }
            this.kHy.QE();
        }
    }

    private void cWA() {
        String string = getPageContext().getString(R.string.delete_user_chat);
        k.c cVar = new k.c() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar, int i, View view) {
                if (UpdatesActivity.this.kHy != null && UpdatesActivity.this.kHy.isShowing()) {
                    UpdatesActivity.this.kHy.dismiss();
                }
                switch (i) {
                    case 0:
                        UpdatesActivity.this.kHx.sW(true);
                        UpdatesActivity.this.a(UpdatesActivity.this.kHC);
                        return;
                    default:
                        return;
                }
            }
        };
        this.kHy = new i(getPageContext());
        this.kHy.a(null, new String[]{string}, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xq() {
        if (this.kHx.cWG() != null) {
            this.kHx.cWG().removeCallbacks(this.kHB);
            this.kHx.cWG().post(this.kHB);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            Xq();
        }
    }

    public boolean cBs() {
        return this.jfi;
    }

    public void sV(boolean z) {
        this.jfi = z;
    }
}

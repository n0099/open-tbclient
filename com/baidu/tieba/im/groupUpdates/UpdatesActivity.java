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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.GroupLevelActivityConfig;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestDelSystemMessage;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.model.UpdatesModel;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class UpdatesActivity extends BaseActivity<UpdatesActivity> implements AbsListView.OnScrollListener {
    private c gnX;
    private g gnY;
    private k<LinkedList<GroupNewsPojo>> gnZ;
    private k<Boolean> goa;
    private Runnable gob;
    private UpdatesItemData goc;
    private UpdatesModel god;
    private boolean eXT = false;
    private com.baidu.adp.framework.listener.c gaF = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UpdatesActivity.this.gnX.lo(false);
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    if (UpdatesActivity.this.goc != null) {
                        UpdatesModel.deleteUpdatesData(UpdatesActivity.this.goc, UpdatesActivity.this.goa);
                        UpdatesActivity.this.goc = null;
                    }
                    if (UpdatesActivity.this.god != null && UpdatesActivity.this.god.getDeleteSize() > 0) {
                        UpdatesActivity.this.god.deleteDatas(UpdatesActivity.this.goa);
                    }
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdatesActivity.this.gnX.lo(false);
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage)) {
                int cmd = customResponsedMessage.getCmd();
                if (2001132 == cmd || 2001133 == cmd || 2001130 == cmd || 2001129 == cmd || 2001137 == cmd) {
                    UpdatesModel.requestUpdatesDataFromDB(UpdatesActivity.this.gnZ);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.god = new UpdatesModel();
        this.gnX = new c(this);
        but();
        registerListener(2001132, this.mCustomListener);
        registerListener(2001133, this.mCustomListener);
        registerListener(2001130, this.mCustomListener);
        registerListener(2001129, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
        this.gnX.lo(true);
        UpdatesModel.requestUpdatesDataFromDB(this.gnZ);
        registerListener(202004, this.gaF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(6, true);
        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().iB(2);
        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahL();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a("-1002", -3)));
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

    private void but() {
        final k<LinkedList<GroupNewsPojo>> kVar = new k<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: s */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.gnX.setData(convertToUpdatesItemData);
                UpdatesActivity.this.god.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.gnX.lo(false);
                UpdatesActivity.this.gnX.uc(UpdatesActivity.this.god.getDeleteSize());
                UpdatesActivity.this.loadImage();
                ImMessageCenterPojo imMessageCenterPojo = null;
                if (convertToUpdatesItemData != null && convertToUpdatesItemData.size() > 0) {
                    ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
                    imMessageCenterPojo2.setLast_content(convertToUpdatesItemData.get(0).getContent());
                    imMessageCenterPojo2.setLast_content_time(convertToUpdatesItemData.get(0).getTime());
                    imMessageCenterPojo = imMessageCenterPojo2;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001210, imMessageCenterPojo));
                if (convertToUpdatesItemData != null && convertToUpdatesItemData.size() == 0) {
                    UpdatesActivity.this.finish();
                }
            }
        };
        this.goa = new k<Boolean>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                UpdatesActivity.this.god.clearSelect();
                UpdatesActivity.this.gnX.bux();
                UpdatesActivity.this.ln(false);
                UpdatesModel.requestUpdatesDataFromDB(kVar);
            }
        };
        this.gnZ = new k<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: s */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.gnX.setData(convertToUpdatesItemData);
                UpdatesActivity.this.god.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.gnX.lo(false);
                UpdatesActivity.this.gnX.uc(UpdatesActivity.this.god.getDeleteSize());
                UpdatesActivity.this.loadImage();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gnX != null) {
            this.gnX.destroy();
        }
        if (this.god != null) {
            this.god.destory();
        }
        this.goc = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.gnX != null) {
            if (view.equals(this.gnX.buy())) {
                finish();
            } else if (view.equals(this.gnX.buA())) {
                this.god.clearSelect();
                this.god.calculateSelects(this.gnX.buv().getDatas());
                this.gnX.uc(this.god.getDeleteSize());
                ln(true);
                this.gnX.buw();
            } else if (view.equals(this.gnX.buB())) {
                ln(false);
                this.gnX.bux();
                this.god.clearSelect();
                UpdatesModel.requestUpdatesDataFromDB(this.gnZ);
            } else if (view.equals(this.gnX.buC())) {
                this.gnX.lo(true);
                String deleteDatasIds = this.god.deleteDatasIds();
                if (!TextUtils.isEmpty(deleteDatasIds)) {
                    xm(deleteDatasIds);
                } else {
                    this.gnX.lo(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && keyEvent.getAction() == 0 && this.eXT) {
            ln(false);
            this.god.clearSelect();
            this.gnX.uc(this.god.getDeleteSize());
            this.gnX.bux();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.b.bvI().bvK()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.b.bvI().bvK()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.gnX.lo(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.g.b.d(com.baidu.tieba.im.pushNotify.b.bvI().bvK(), 0L));
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(updatesItemData.getNotice_id()) / 100));
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void xm(String str) {
        if (!j.kY()) {
            showToast(d.j.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String bvK = com.baidu.tieba.im.pushNotify.b.bvI().bvK();
            if (!TextUtils.isEmpty(bvK) && TextUtils.isDigitsOnly(bvK)) {
                this.gnX.lo(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.g.b.d(bvK, 0L));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gnX != null) {
            this.gnX.onChangeSkinType(i);
        }
    }

    public void a(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !bbG()) {
            String groupId = updatesItemData.getGroupId();
            String updatesType = updatesItemData.getUpdatesType();
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(groupId, 0L), updatesItemData.isShown())));
                    } else if (!updatesType.equals("dismiss_group")) {
                        if (updatesType.equals("group_event_info")) {
                            TiebaStatic.log("update_activity_group_event_click");
                            ba.adD().c(getPageContext(), new String[]{updatesItemData.getEventLink()});
                        } else if (updatesType.equals("group_activitys_change")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(updatesItemData.getGroupActivityId(), 0), com.baidu.adp.lib.g.b.d(updatesItemData.getGroupId(), 0L), 1)));
                        } else {
                            sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getPageContext().getPageActivity(), Long.parseLong(groupId), 0)));
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
                this.god.addSelect(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.god.getDeleteSize() > 100) {
                    this.god.cancelSelect(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(d.j.updates_activity_del_limit);
                }
            } else {
                this.god.cancelSelect(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.gnX.uc(this.god.getDeleteSize());
            this.gnX.bto();
        }
    }

    public void b(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !bbG()) {
            if (this.gnY == null) {
                this.goc = updatesItemData;
                buu();
            }
            this.gnY.showDialog();
        }
    }

    private void buu() {
        String string = getPageContext().getString(d.j.delete_user_chat);
        i.c cVar = new i.c() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.4
            @Override // com.baidu.tbadk.core.dialog.i.c
            public void a(i iVar, int i, View view) {
                if (UpdatesActivity.this.gnY != null && UpdatesActivity.this.gnY.isShowing()) {
                    UpdatesActivity.this.gnY.dismiss();
                }
                switch (i) {
                    case 0:
                        UpdatesActivity.this.gnX.lo(true);
                        UpdatesActivity.this.a(UpdatesActivity.this.goc);
                        return;
                    default:
                        return;
                }
            }
        };
        this.gnY = new g(getPageContext());
        this.gnY.a(null, new String[]{string}, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage() {
        if (this.gnX.buz() != null) {
            this.gnX.buz().removeCallbacks(this.gob);
            this.gnX.buz().post(this.gob);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            loadImage();
        }
    }

    public boolean bbG() {
        return this.eXT;
    }

    public void ln(boolean z) {
        this.eXT = z;
    }
}

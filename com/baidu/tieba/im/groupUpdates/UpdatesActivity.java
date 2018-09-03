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
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.f;
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
    private c exc;
    private com.baidu.tbadk.core.dialog.b exd;
    private g<LinkedList<GroupNewsPojo>> exe;
    private g<Boolean> exf;
    private Runnable exg;
    private UpdatesItemData exh;
    private UpdatesModel exi;
    private boolean dlv = false;
    private com.baidu.adp.framework.listener.c ejH = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UpdatesActivity.this.exc.hJ(false);
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    if (UpdatesActivity.this.exh != null) {
                        UpdatesModel.deleteUpdatesData(UpdatesActivity.this.exh, UpdatesActivity.this.exf);
                        UpdatesActivity.this.exh = null;
                    }
                    if (UpdatesActivity.this.exi != null && UpdatesActivity.this.exi.getDeleteSize() > 0) {
                        UpdatesActivity.this.exi.deleteDatas(UpdatesActivity.this.exf);
                    }
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdatesActivity.this.exc.hJ(false);
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage)) {
                int cmd = customResponsedMessage.getCmd();
                if (2001132 == cmd || 2001133 == cmd || 2001130 == cmd || 2001129 == cmd || 2001137 == cmd) {
                    UpdatesModel.requestUpdatesDataFromDB(UpdatesActivity.this.exe);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.exi = new UpdatesModel();
        this.exc = new c(this);
        aLJ();
        registerListener(2001132, this.mCustomListener);
        registerListener(2001133, this.mCustomListener);
        registerListener(2001130, this.mCustomListener);
        registerListener(2001129, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
        this.exc.hJ(true);
        UpdatesModel.requestUpdatesDataFromDB(this.exe);
        registerListener(202004, this.ejH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(6, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dX(2);
        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().Dw();
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

    private void aLJ() {
        final g<LinkedList<GroupNewsPojo>> gVar = new g<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: r */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.exc.setData(convertToUpdatesItemData);
                UpdatesActivity.this.exi.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.exc.hJ(false);
                UpdatesActivity.this.exc.op(UpdatesActivity.this.exi.getDeleteSize());
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
        this.exf = new g<Boolean>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            public void onReturnDataInUI(Boolean bool) {
                UpdatesActivity.this.exi.clearSelect();
                UpdatesActivity.this.exc.aLN();
                UpdatesActivity.this.hI(false);
                UpdatesModel.requestUpdatesDataFromDB(gVar);
            }
        };
        this.exe = new g<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: r */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.exc.setData(convertToUpdatesItemData);
                UpdatesActivity.this.exi.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.exc.hJ(false);
                UpdatesActivity.this.exc.op(UpdatesActivity.this.exi.getDeleteSize());
                UpdatesActivity.this.loadImage();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.exc != null) {
            this.exc.destroy();
        }
        if (this.exi != null) {
            this.exi.destory();
        }
        this.exh = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.exc != null) {
            if (view.equals(this.exc.aLO())) {
                finish();
            } else if (view.equals(this.exc.aLQ())) {
                this.exi.clearSelect();
                this.exi.calculateSelects(this.exc.aLL().getDatas());
                this.exc.op(this.exi.getDeleteSize());
                hI(true);
                this.exc.aLM();
            } else if (view.equals(this.exc.aLR())) {
                hI(false);
                this.exc.aLN();
                this.exi.clearSelect();
                UpdatesModel.requestUpdatesDataFromDB(this.exe);
            } else if (view.equals(this.exc.aLS())) {
                this.exc.hJ(true);
                String deleteDatasIds = this.exi.deleteDatasIds();
                if (!TextUtils.isEmpty(deleteDatasIds)) {
                    oF(deleteDatasIds);
                } else {
                    this.exc.hJ(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && keyEvent.getAction() == 0 && this.dlv) {
            hI(false);
            this.exi.clearSelect();
            this.exc.op(this.exi.getDeleteSize());
            this.exc.aLN();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!j.jE()) {
            showToast(f.j.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.b.aMY().aNa()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.b.aMY().aNa()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.exc.hJ(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.g.b.c(com.baidu.tieba.im.pushNotify.b.aMY().aNa(), 0L));
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(updatesItemData.getNotice_id()) / 100));
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void oF(String str) {
        if (!j.jE()) {
            showToast(f.j.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String aNa = com.baidu.tieba.im.pushNotify.b.aMY().aNa();
            if (!TextUtils.isEmpty(aNa) && TextUtils.isDigitsOnly(aNa)) {
                this.exc.hJ(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.g.b.c(aNa, 0L));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.exc != null) {
            this.exc.onChangeSkinType(i);
        }
    }

    public void a(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !atD()) {
            String groupId = updatesItemData.getGroupId();
            String updatesType = updatesItemData.getUpdatesType();
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(groupId, 0L), updatesItemData.isShown())));
                    } else if (!updatesType.equals("dismiss_group")) {
                        if (updatesType.equals("group_event_info")) {
                            TiebaStatic.log("update_activity_group_event_click");
                            az.zI().c(getPageContext(), new String[]{updatesItemData.getEventLink()});
                        } else if (updatesType.equals("group_activitys_change")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.g(updatesItemData.getGroupActivityId(), 0), com.baidu.adp.lib.g.b.c(updatesItemData.getGroupId(), 0L), 1)));
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
                this.exi.addSelect(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.exi.getDeleteSize() > 100) {
                    this.exi.cancelSelect(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(f.j.updates_activity_del_limit);
                }
            } else {
                this.exi.cancelSelect(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.exc.op(this.exi.getDeleteSize());
            this.exc.aKD();
        }
    }

    public void b(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !atD()) {
            if (this.exd == null) {
                this.exh = updatesItemData;
                aLK();
            }
            this.exd.xh();
        }
    }

    private void aLK() {
        String string = getPageContext().getString(f.j.delete_user_chat);
        b.InterfaceC0101b interfaceC0101b = new b.InterfaceC0101b() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        UpdatesActivity.this.exc.hJ(true);
                        UpdatesActivity.this.a(UpdatesActivity.this.exh);
                        return;
                    default:
                        return;
                }
            }
        };
        this.exd = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        this.exd.ci(f.j.operation);
        this.exd.a(new String[]{string}, interfaceC0101b);
        this.exd.d(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage() {
        if (this.exc.aLP() != null) {
            this.exc.aLP().removeCallbacks(this.exg);
            this.exc.aLP().post(this.exg);
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

    public boolean atD() {
        return this.dlv;
    }

    public void hI(boolean z) {
        this.dlv = z;
    }
}

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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.g;
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
    private c exg;
    private com.baidu.tbadk.core.dialog.b exh;
    private g<LinkedList<GroupNewsPojo>> exi;
    private g<Boolean> exj;
    private Runnable exk;
    private UpdatesItemData exl;
    private UpdatesModel exm;
    private boolean dlx = false;
    private com.baidu.adp.framework.listener.c ejL = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UpdatesActivity.this.exg.hJ(false);
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    if (UpdatesActivity.this.exl != null) {
                        UpdatesModel.deleteUpdatesData(UpdatesActivity.this.exl, UpdatesActivity.this.exj);
                        UpdatesActivity.this.exl = null;
                    }
                    if (UpdatesActivity.this.exm != null && UpdatesActivity.this.exm.getDeleteSize() > 0) {
                        UpdatesActivity.this.exm.deleteDatas(UpdatesActivity.this.exj);
                    }
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdatesActivity.this.exg.hJ(false);
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage)) {
                int cmd = customResponsedMessage.getCmd();
                if (2001132 == cmd || 2001133 == cmd || 2001130 == cmd || 2001129 == cmd || 2001137 == cmd) {
                    UpdatesModel.requestUpdatesDataFromDB(UpdatesActivity.this.exi);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.exm = new UpdatesModel();
        this.exg = new c(this);
        aLM();
        registerListener(2001132, this.mCustomListener);
        registerListener(2001133, this.mCustomListener);
        registerListener(2001130, this.mCustomListener);
        registerListener(2001129, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
        this.exg.hJ(true);
        UpdatesModel.requestUpdatesDataFromDB(this.exi);
        registerListener(202004, this.ejL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(6, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dY(2);
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

    private void aLM() {
        final g<LinkedList<GroupNewsPojo>> gVar = new g<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: r */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.exg.setData(convertToUpdatesItemData);
                UpdatesActivity.this.exm.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.exg.hJ(false);
                UpdatesActivity.this.exg.op(UpdatesActivity.this.exm.getDeleteSize());
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
        this.exj = new g<Boolean>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            public void onReturnDataInUI(Boolean bool) {
                UpdatesActivity.this.exm.clearSelect();
                UpdatesActivity.this.exg.aLQ();
                UpdatesActivity.this.hI(false);
                UpdatesModel.requestUpdatesDataFromDB(gVar);
            }
        };
        this.exi = new g<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            /* renamed from: r */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.exg.setData(convertToUpdatesItemData);
                UpdatesActivity.this.exm.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.exg.hJ(false);
                UpdatesActivity.this.exg.op(UpdatesActivity.this.exm.getDeleteSize());
                UpdatesActivity.this.loadImage();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.exg != null) {
            this.exg.destroy();
        }
        if (this.exm != null) {
            this.exm.destory();
        }
        this.exl = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.exg != null) {
            if (view.equals(this.exg.aLR())) {
                finish();
            } else if (view.equals(this.exg.aLT())) {
                this.exm.clearSelect();
                this.exm.calculateSelects(this.exg.aLO().getDatas());
                this.exg.op(this.exm.getDeleteSize());
                hI(true);
                this.exg.aLP();
            } else if (view.equals(this.exg.aLU())) {
                hI(false);
                this.exg.aLQ();
                this.exm.clearSelect();
                UpdatesModel.requestUpdatesDataFromDB(this.exi);
            } else if (view.equals(this.exg.aLV())) {
                this.exg.hJ(true);
                String deleteDatasIds = this.exm.deleteDatasIds();
                if (!TextUtils.isEmpty(deleteDatasIds)) {
                    oD(deleteDatasIds);
                } else {
                    this.exg.hJ(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && keyEvent.getAction() == 0 && this.dlx) {
            hI(false);
            this.exm.clearSelect();
            this.exg.op(this.exm.getDeleteSize());
            this.exg.aLQ();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!j.jE()) {
            showToast(d.j.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.b.aNb().aNd()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.b.aNb().aNd()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.exg.hJ(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.g.b.c(com.baidu.tieba.im.pushNotify.b.aNb().aNd(), 0L));
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(updatesItemData.getNotice_id()) / 100));
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void oD(String str) {
        if (!j.jE()) {
            showToast(d.j.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String aNd = com.baidu.tieba.im.pushNotify.b.aNb().aNd();
            if (!TextUtils.isEmpty(aNd) && TextUtils.isDigitsOnly(aNd)) {
                this.exg.hJ(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.g.b.c(aNd, 0L));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.exg != null) {
            this.exg.onChangeSkinType(i);
        }
    }

    public void a(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !atE()) {
            String groupId = updatesItemData.getGroupId();
            String updatesType = updatesItemData.getUpdatesType();
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(groupId, 0L), updatesItemData.isShown())));
                    } else if (!updatesType.equals("dismiss_group")) {
                        if (updatesType.equals("group_event_info")) {
                            TiebaStatic.log("update_activity_group_event_click");
                            ay.zK().c(getPageContext(), new String[]{updatesItemData.getEventLink()});
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
                this.exm.addSelect(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.exm.getDeleteSize() > 100) {
                    this.exm.cancelSelect(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(d.j.updates_activity_del_limit);
                }
            } else {
                this.exm.cancelSelect(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.exg.op(this.exm.getDeleteSize());
            this.exg.aKG();
        }
    }

    public void b(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !atE()) {
            if (this.exh == null) {
                this.exl = updatesItemData;
                aLN();
            }
            this.exh.xi();
        }
    }

    private void aLN() {
        String string = getPageContext().getString(d.j.delete_user_chat);
        b.InterfaceC0101b interfaceC0101b = new b.InterfaceC0101b() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        UpdatesActivity.this.exg.hJ(true);
                        UpdatesActivity.this.a(UpdatesActivity.this.exl);
                        return;
                    default:
                        return;
                }
            }
        };
        this.exh = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        this.exh.ci(d.j.operation);
        this.exh.a(new String[]{string}, interfaceC0101b);
        this.exh.d(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage() {
        if (this.exg.aLS() != null) {
            this.exg.aLS().removeCallbacks(this.exk);
            this.exg.aLS().post(this.exk);
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

    public boolean atE() {
        return this.dlx;
    }

    public void hI(boolean z) {
        this.dlx = z;
    }
}

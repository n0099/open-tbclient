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
import com.baidu.tbadk.util.h;
import com.baidu.tieba.e;
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
    private c eMf;
    private com.baidu.tbadk.core.dialog.b eMg;
    private h<LinkedList<GroupNewsPojo>> eMh;
    private h<Boolean> eMi;
    private Runnable eMj;
    private UpdatesItemData eMk;
    private UpdatesModel eMl;
    private boolean dzp = false;
    private com.baidu.adp.framework.listener.c eyS = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UpdatesActivity.this.eMf.iz(false);
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    if (UpdatesActivity.this.eMk != null) {
                        UpdatesModel.deleteUpdatesData(UpdatesActivity.this.eMk, UpdatesActivity.this.eMi);
                        UpdatesActivity.this.eMk = null;
                    }
                    if (UpdatesActivity.this.eMl != null && UpdatesActivity.this.eMl.getDeleteSize() > 0) {
                        UpdatesActivity.this.eMl.deleteDatas(UpdatesActivity.this.eMi);
                    }
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdatesActivity.this.eMf.iz(false);
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage)) {
                int cmd = customResponsedMessage.getCmd();
                if (2001132 == cmd || 2001133 == cmd || 2001130 == cmd || 2001129 == cmd || 2001137 == cmd) {
                    UpdatesModel.requestUpdatesDataFromDB(UpdatesActivity.this.eMh);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eMl = new UpdatesModel();
        this.eMf = new c(this);
        aRn();
        registerListener(2001132, this.mCustomListener);
        registerListener(2001133, this.mCustomListener);
        registerListener(2001130, this.mCustomListener);
        registerListener(2001129, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
        this.eMf.iz(true);
        UpdatesModel.requestUpdatesDataFromDB(this.eMh);
        registerListener(202004, this.eyS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(6, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().es(2);
        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GK();
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

    private void aRn() {
        final h<LinkedList<GroupNewsPojo>> hVar = new h<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: r */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.eMf.setData(convertToUpdatesItemData);
                UpdatesActivity.this.eMl.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.eMf.iz(false);
                UpdatesActivity.this.eMf.pr(UpdatesActivity.this.eMl.getDeleteSize());
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
        this.eMi = new h<Boolean>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                UpdatesActivity.this.eMl.clearSelect();
                UpdatesActivity.this.eMf.aRr();
                UpdatesActivity.this.iy(false);
                UpdatesModel.requestUpdatesDataFromDB(hVar);
            }
        };
        this.eMh = new h<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: r */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.eMf.setData(convertToUpdatesItemData);
                UpdatesActivity.this.eMl.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.eMf.iz(false);
                UpdatesActivity.this.eMf.pr(UpdatesActivity.this.eMl.getDeleteSize());
                UpdatesActivity.this.loadImage();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eMf != null) {
            this.eMf.destroy();
        }
        if (this.eMl != null) {
            this.eMl.destory();
        }
        this.eMk = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.eMf != null) {
            if (view.equals(this.eMf.aRs())) {
                finish();
            } else if (view.equals(this.eMf.aRu())) {
                this.eMl.clearSelect();
                this.eMl.calculateSelects(this.eMf.aRp().getDatas());
                this.eMf.pr(this.eMl.getDeleteSize());
                iy(true);
                this.eMf.aRq();
            } else if (view.equals(this.eMf.aRv())) {
                iy(false);
                this.eMf.aRr();
                this.eMl.clearSelect();
                UpdatesModel.requestUpdatesDataFromDB(this.eMh);
            } else if (view.equals(this.eMf.aRw())) {
                this.eMf.iz(true);
                String deleteDatasIds = this.eMl.deleteDatasIds();
                if (!TextUtils.isEmpty(deleteDatasIds)) {
                    pM(deleteDatasIds);
                } else {
                    this.eMf.iz(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && keyEvent.getAction() == 0 && this.dzp) {
            iy(false);
            this.eMl.clearSelect();
            this.eMf.pr(this.eMl.getDeleteSize());
            this.eMf.aRr();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!j.kX()) {
            showToast(e.j.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.b.aSB().aSD()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.b.aSB().aSD()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.eMf.iz(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.g.b.d(com.baidu.tieba.im.pushNotify.b.aSB().aSD(), 0L));
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(updatesItemData.getNotice_id()) / 100));
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void pM(String str) {
        if (!j.kX()) {
            showToast(e.j.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String aSD = com.baidu.tieba.im.pushNotify.b.aSB().aSD();
            if (!TextUtils.isEmpty(aSD) && TextUtils.isDigitsOnly(aSD)) {
                this.eMf.iz(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.g.b.d(aSD, 0L));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eMf != null) {
            this.eMf.onChangeSkinType(i);
        }
    }

    public void a(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !ayO()) {
            String groupId = updatesItemData.getGroupId();
            String updatesType = updatesItemData.getUpdatesType();
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.d(groupId, 0L), updatesItemData.isShown())));
                    } else if (!updatesType.equals("dismiss_group")) {
                        if (updatesType.equals("group_event_info")) {
                            TiebaStatic.log("update_activity_group_event_click");
                            ay.CU().c(getPageContext(), new String[]{updatesItemData.getEventLink()});
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
                this.eMl.addSelect(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.eMl.getDeleteSize() > 100) {
                    this.eMl.cancelSelect(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(e.j.updates_activity_del_limit);
                }
            } else {
                this.eMl.cancelSelect(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.eMf.pr(this.eMl.getDeleteSize());
            this.eMf.aQh();
        }
    }

    public void b(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !ayO()) {
            if (this.eMg == null) {
                this.eMk = updatesItemData;
                aRo();
            }
            this.eMg.Ax();
        }
    }

    private void aRo() {
        String string = getPageContext().getString(e.j.delete_user_chat);
        b.InterfaceC0124b interfaceC0124b = new b.InterfaceC0124b() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        UpdatesActivity.this.eMf.iz(true);
                        UpdatesActivity.this.a(UpdatesActivity.this.eMk);
                        return;
                    default:
                        return;
                }
            }
        };
        this.eMg = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        this.eMg.cC(e.j.operation);
        this.eMg.a(new String[]{string}, interfaceC0124b);
        this.eMg.d(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage() {
        if (this.eMf.aRt() != null) {
            this.eMf.aRt().removeCallbacks(this.eMj);
            this.eMf.aRt().post(this.eMj);
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

    public boolean ayO() {
        return this.dzp;
    }

    public void iy(boolean z) {
        this.dzp = z;
    }
}

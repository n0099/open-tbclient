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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.h;
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
    private c edc;
    private com.baidu.tbadk.core.dialog.b edd;
    private h<LinkedList<GroupNewsPojo>> ede;
    private h<Boolean> edf;
    private Runnable edg;
    private UpdatesItemData edi;
    private UpdatesModel edj;
    private boolean edh = false;
    private com.baidu.adp.framework.listener.c dPL = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UpdatesActivity.this.edc.hp(false);
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    if (UpdatesActivity.this.edi != null) {
                        UpdatesModel.deleteUpdatesData(UpdatesActivity.this.edi, UpdatesActivity.this.edf);
                        UpdatesActivity.this.edi = null;
                    }
                    if (UpdatesActivity.this.edj != null && UpdatesActivity.this.edj.getDeleteSize() > 0) {
                        UpdatesActivity.this.edj.deleteDatas(UpdatesActivity.this.edf);
                    }
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdatesActivity.this.edc.hp(false);
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage)) {
                int cmd = customResponsedMessage.getCmd();
                if (2001132 == cmd || 2001133 == cmd || 2001130 == cmd || 2001129 == cmd || 2001137 == cmd) {
                    UpdatesModel.requestUpdatesDataFromDB(UpdatesActivity.this.ede);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.edj = new UpdatesModel();
        this.edc = new c(this);
        aFl();
        registerListener(2001132, this.mCustomListener);
        registerListener(2001133, this.mCustomListener);
        registerListener(2001130, this.mCustomListener);
        registerListener(2001129, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
        this.edc.hp(true);
        UpdatesModel.requestUpdatesDataFromDB(this.ede);
        registerListener(202004, this.dPL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(6, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.zx().dR(2);
        com.baidu.tbadk.coreExtra.messageCenter.a.zx().zI();
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

    private void aFl() {
        final h<LinkedList<GroupNewsPojo>> hVar = new h<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: t */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.edc.setData(convertToUpdatesItemData);
                UpdatesActivity.this.edj.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.edc.hp(false);
                UpdatesActivity.this.edc.nJ(UpdatesActivity.this.edj.getDeleteSize());
                UpdatesActivity.this.amq();
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
        this.edf = new h<Boolean>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                UpdatesActivity.this.edj.clearSelect();
                UpdatesActivity.this.edc.aFq();
                UpdatesActivity.this.ho(false);
                UpdatesModel.requestUpdatesDataFromDB(hVar);
            }
        };
        this.ede = new h<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: t */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.edc.setData(convertToUpdatesItemData);
                UpdatesActivity.this.edj.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.edc.hp(false);
                UpdatesActivity.this.edc.nJ(UpdatesActivity.this.edj.getDeleteSize());
                UpdatesActivity.this.amq();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.edc != null) {
            this.edc.destroy();
        }
        if (this.edj != null) {
            this.edj.destory();
        }
        this.edi = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 != null && this.edc != null) {
            if (view2.equals(this.edc.aFr())) {
                finish();
            } else if (view2.equals(this.edc.aFt())) {
                this.edj.clearSelect();
                this.edj.calculateSelects(this.edc.aFo().getDatas());
                this.edc.nJ(this.edj.getDeleteSize());
                ho(true);
                this.edc.aFp();
            } else if (view2.equals(this.edc.aFu())) {
                ho(false);
                this.edc.aFq();
                this.edj.clearSelect();
                UpdatesModel.requestUpdatesDataFromDB(this.ede);
            } else if (view2.equals(this.edc.aFv())) {
                this.edc.hp(true);
                String deleteDatasIds = this.edj.deleteDatasIds();
                if (!TextUtils.isEmpty(deleteDatasIds)) {
                    nJ(deleteDatasIds);
                } else {
                    this.edc.hp(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && keyEvent.getAction() == 0 && this.edh) {
            ho(false);
            this.edj.clearSelect();
            this.edc.nJ(this.edj.getDeleteSize());
            this.edc.aFq();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!j.gP()) {
            showToast(d.k.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.b.aGC().aGE()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.b.aGC().aGE()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.edc.hp(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.g.b.c(com.baidu.tieba.im.pushNotify.b.aGC().aGE(), 0L));
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(updatesItemData.getNotice_id()) / 100));
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void nJ(String str) {
        if (!j.gP()) {
            showToast(d.k.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String aGE = com.baidu.tieba.im.pushNotify.b.aGC().aGE();
            if (!TextUtils.isEmpty(aGE) && TextUtils.isDigitsOnly(aGE)) {
                this.edc.hp(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.g.b.c(aGE, 0L));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.edc != null) {
            this.edc.onChangeSkinType(i);
        }
    }

    public void a(View view2, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !aFn()) {
            String groupId = updatesItemData.getGroupId();
            String updatesType = updatesItemData.getUpdatesType();
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(groupId, 0L), updatesItemData.isShown())));
                    } else if (!updatesType.equals("dismiss_group")) {
                        if (updatesType.equals("group_event_info")) {
                            TiebaStatic.log("update_activity_group_event_click");
                            ax.wg().c(getPageContext(), new String[]{updatesItemData.getEventLink()});
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

    public void a(View view2, boolean z, UpdatesItemData updatesItemData) {
        if (updatesItemData != null) {
            if (z) {
                this.edj.addSelect(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.edj.getDeleteSize() > 100) {
                    this.edj.cancelSelect(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(d.k.updates_activity_del_limit);
                }
            } else {
                this.edj.cancelSelect(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.edc.nJ(this.edj.getDeleteSize());
            this.edc.aEf();
        }
    }

    public void b(View view2, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view2 != null && updatesItemData != null && 200 == i && !aFn()) {
            if (this.edd == null) {
                this.edi = updatesItemData;
                aFm();
            }
            this.edd.tG();
        }
    }

    private void aFm() {
        String string = getPageContext().getString(d.k.delete_user_chat);
        b.InterfaceC0086b interfaceC0086b = new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        UpdatesActivity.this.edc.hp(true);
                        UpdatesActivity.this.a(UpdatesActivity.this.edi);
                        return;
                    default:
                        return;
                }
            }
        };
        this.edd = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        this.edd.cc(d.k.operation);
        this.edd.a(new String[]{string}, interfaceC0086b);
        this.edd.d(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amq() {
        if (this.edc.aFs() != null) {
            this.edc.aFs().removeCallbacks(this.edg);
            this.edc.aFs().post(this.edg);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            amq();
        }
    }

    public boolean aFn() {
        return this.edh;
    }

    public void ho(boolean z) {
        this.edh = z;
    }
}

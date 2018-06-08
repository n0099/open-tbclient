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
    private UpdatesItemData epB;
    private UpdatesModel epC;
    private c epv;
    private com.baidu.tbadk.core.dialog.b epw;
    private h<LinkedList<GroupNewsPojo>> epx;
    private h<Boolean> epy;
    private Runnable epz;
    private boolean epA = false;
    private com.baidu.adp.framework.listener.c ecb = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UpdatesActivity.this.epv.hw(false);
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    if (UpdatesActivity.this.epB != null) {
                        UpdatesModel.deleteUpdatesData(UpdatesActivity.this.epB, UpdatesActivity.this.epy);
                        UpdatesActivity.this.epB = null;
                    }
                    if (UpdatesActivity.this.epC != null && UpdatesActivity.this.epC.getDeleteSize() > 0) {
                        UpdatesActivity.this.epC.deleteDatas(UpdatesActivity.this.epy);
                    }
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdatesActivity.this.epv.hw(false);
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage)) {
                int cmd = customResponsedMessage.getCmd();
                if (2001132 == cmd || 2001133 == cmd || 2001130 == cmd || 2001129 == cmd || 2001137 == cmd) {
                    UpdatesModel.requestUpdatesDataFromDB(UpdatesActivity.this.epx);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.epC = new UpdatesModel();
        this.epv = new c(this);
        aKe();
        registerListener(2001132, this.mCustomListener);
        registerListener(2001133, this.mCustomListener);
        registerListener(2001130, this.mCustomListener);
        registerListener(2001129, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
        this.epv.hw(true);
        UpdatesModel.requestUpdatesDataFromDB(this.epx);
        registerListener(202004, this.ecb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(6, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.CX().dU(2);
        com.baidu.tbadk.coreExtra.messageCenter.a.CX().Di();
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

    private void aKe() {
        final h<LinkedList<GroupNewsPojo>> hVar = new h<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: t */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.epv.setData(convertToUpdatesItemData);
                UpdatesActivity.this.epC.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.epv.hw(false);
                UpdatesActivity.this.epv.nU(UpdatesActivity.this.epC.getDeleteSize());
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
        this.epy = new h<Boolean>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                UpdatesActivity.this.epC.clearSelect();
                UpdatesActivity.this.epv.aKj();
                UpdatesActivity.this.hv(false);
                UpdatesModel.requestUpdatesDataFromDB(hVar);
            }
        };
        this.epx = new h<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            /* renamed from: t */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.epv.setData(convertToUpdatesItemData);
                UpdatesActivity.this.epC.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.epv.hw(false);
                UpdatesActivity.this.epv.nU(UpdatesActivity.this.epC.getDeleteSize());
                UpdatesActivity.this.loadImage();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.epv != null) {
            this.epv.destroy();
        }
        if (this.epC != null) {
            this.epC.destory();
        }
        this.epB = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.epv != null) {
            if (view.equals(this.epv.aKk())) {
                finish();
            } else if (view.equals(this.epv.aKm())) {
                this.epC.clearSelect();
                this.epC.calculateSelects(this.epv.aKh().getDatas());
                this.epv.nU(this.epC.getDeleteSize());
                hv(true);
                this.epv.aKi();
            } else if (view.equals(this.epv.aKn())) {
                hv(false);
                this.epv.aKj();
                this.epC.clearSelect();
                UpdatesModel.requestUpdatesDataFromDB(this.epx);
            } else if (view.equals(this.epv.aKo())) {
                this.epv.hw(true);
                String deleteDatasIds = this.epC.deleteDatasIds();
                if (!TextUtils.isEmpty(deleteDatasIds)) {
                    oA(deleteDatasIds);
                } else {
                    this.epv.hw(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && keyEvent.getAction() == 0 && this.epA) {
            hv(false);
            this.epC.clearSelect();
            this.epv.nU(this.epC.getDeleteSize());
            this.epv.aKj();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!j.jD()) {
            showToast(d.k.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.b.aLv().aLx()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.b.aLv().aLx()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.epv.hw(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.g.b.c(com.baidu.tieba.im.pushNotify.b.aLv().aLx(), 0L));
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(updatesItemData.getNotice_id()) / 100));
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void oA(String str) {
        if (!j.jD()) {
            showToast(d.k.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String aLx = com.baidu.tieba.im.pushNotify.b.aLv().aLx();
            if (!TextUtils.isEmpty(aLx) && TextUtils.isDigitsOnly(aLx)) {
                this.epv.hw(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.g.b.c(aLx, 0L));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.epv != null) {
            this.epv.onChangeSkinType(i);
        }
    }

    public void a(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !aKg()) {
            String groupId = updatesItemData.getGroupId();
            String updatesType = updatesItemData.getUpdatesType();
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(groupId, 0L), updatesItemData.isShown())));
                    } else if (!updatesType.equals("dismiss_group")) {
                        if (updatesType.equals("group_event_info")) {
                            TiebaStatic.log("update_activity_group_event_click");
                            ay.zG().c(getPageContext(), new String[]{updatesItemData.getEventLink()});
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
                this.epC.addSelect(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.epC.getDeleteSize() > 100) {
                    this.epC.cancelSelect(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(d.k.updates_activity_del_limit);
                }
            } else {
                this.epC.cancelSelect(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.epv.nU(this.epC.getDeleteSize());
            this.epv.aIY();
        }
    }

    public void b(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !aKg()) {
            if (this.epw == null) {
                this.epB = updatesItemData;
                aKf();
            }
            this.epw.xd();
        }
    }

    private void aKf() {
        String string = getPageContext().getString(d.k.delete_user_chat);
        b.InterfaceC0103b interfaceC0103b = new b.InterfaceC0103b() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.4
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                switch (i) {
                    case 0:
                        UpdatesActivity.this.epv.hw(true);
                        UpdatesActivity.this.a(UpdatesActivity.this.epB);
                        return;
                    default:
                        return;
                }
            }
        };
        this.epw = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        this.epw.cf(d.k.operation);
        this.epw.a(new String[]{string}, interfaceC0103b);
        this.epw.d(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage() {
        if (this.epv.aKl() != null) {
            this.epv.aKl().removeCallbacks(this.epz);
            this.epv.aKl().post(this.epz);
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

    public boolean aKg() {
        return this.epA;
    }

    public void hv(boolean z) {
        this.epA = z;
    }
}

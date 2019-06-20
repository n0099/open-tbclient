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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.R;
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
    private c gFb;
    private i gFc;
    private k<LinkedList<GroupNewsPojo>> gFd;
    private k<Boolean> gFe;
    private Runnable gFf;
    private UpdatesItemData gFg;
    private UpdatesModel gFh;
    private boolean fnN = false;
    private com.baidu.adp.framework.listener.c grM = new com.baidu.adp.framework.listener.c(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UpdatesActivity.this.gFb.me(false);
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() == 0) {
                    if (UpdatesActivity.this.gFg != null) {
                        UpdatesModel.deleteUpdatesData(UpdatesActivity.this.gFg, UpdatesActivity.this.gFe);
                        UpdatesActivity.this.gFg = null;
                    }
                    if (UpdatesActivity.this.gFh != null && UpdatesActivity.this.gFh.getDeleteSize() > 0) {
                        UpdatesActivity.this.gFh.deleteDatas(UpdatesActivity.this.gFe);
                    }
                }
            }
        }
    };
    private CustomMessageListener mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdatesActivity.this.gFb.me(false);
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage)) {
                int cmd = customResponsedMessage.getCmd();
                if (2001132 == cmd || 2001133 == cmd || 2001130 == cmd || 2001129 == cmd || 2001137 == cmd) {
                    UpdatesModel.requestUpdatesDataFromDB(UpdatesActivity.this.gFd);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gFh = new UpdatesModel();
        this.gFb = new c(this);
        bCg();
        registerListener(2001132, this.mCustomListener);
        registerListener(2001133, this.mCustomListener);
        registerListener(2001130, this.mCustomListener);
        registerListener(2001129, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
        this.gFb.me(true);
        UpdatesModel.requestUpdatesDataFromDB(this.gFd);
        registerListener(202004, this.grM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(6, true);
        com.baidu.tbadk.coreExtra.messageCenter.b.amy().jo(2);
        com.baidu.tbadk.coreExtra.messageCenter.b.amy().amJ();
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

    private void bCg() {
        final k<LinkedList<GroupNewsPojo>> kVar = new k<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: s */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.gFb.setData(convertToUpdatesItemData);
                UpdatesActivity.this.gFh.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.gFb.me(false);
                UpdatesActivity.this.gFb.vf(UpdatesActivity.this.gFh.getDeleteSize());
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
        this.gFe = new k<Boolean>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            public void onReturnDataInUI(Boolean bool) {
                UpdatesActivity.this.gFh.clearSelect();
                UpdatesActivity.this.gFb.bCk();
                UpdatesActivity.this.md(false);
                UpdatesModel.requestUpdatesDataFromDB(kVar);
            }
        };
        this.gFd = new k<LinkedList<GroupNewsPojo>>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.k
            /* renamed from: s */
            public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
                List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
                UpdatesActivity.this.gFb.setData(convertToUpdatesItemData);
                UpdatesActivity.this.gFh.calculateSelects(convertToUpdatesItemData);
                UpdatesActivity.this.gFb.me(false);
                UpdatesActivity.this.gFb.vf(UpdatesActivity.this.gFh.getDeleteSize());
                UpdatesActivity.this.loadImage();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gFb != null) {
            this.gFb.destroy();
        }
        if (this.gFh != null) {
            this.gFh.destory();
        }
        this.gFg = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.gFb != null) {
            if (view.equals(this.gFb.bCl())) {
                finish();
            } else if (view.equals(this.gFb.bCn())) {
                this.gFh.clearSelect();
                this.gFh.calculateSelects(this.gFb.bCi().getDatas());
                this.gFb.vf(this.gFh.getDeleteSize());
                md(true);
                this.gFb.bCj();
            } else if (view.equals(this.gFb.bCo())) {
                md(false);
                this.gFb.bCk();
                this.gFh.clearSelect();
                UpdatesModel.requestUpdatesDataFromDB(this.gFd);
            } else if (view.equals(this.gFb.bCp())) {
                this.gFb.me(true);
                String deleteDatasIds = this.gFh.deleteDatasIds();
                if (!TextUtils.isEmpty(deleteDatasIds)) {
                    yC(deleteDatasIds);
                } else {
                    this.gFb.me(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && keyEvent.getAction() == 0 && this.fnN) {
            md(false);
            this.gFh.clearSelect();
            this.gFb.vf(this.gFh.getDeleteSize());
            this.gFb.bCk();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(UpdatesItemData updatesItemData) {
        if (!j.jS()) {
            showToast(R.string.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.b.bDs().bDu()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.b.bDs().bDu()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.gFb.me(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.g.b.c(com.baidu.tieba.im.pushNotify.b.bDs().bDu(), 0L));
                requestDelSystemMessage.setMsgIds("" + (Long.parseLong(updatesItemData.getNotice_id()) / 100));
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void yC(String str) {
        if (!j.jS()) {
            showToast(R.string.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String bDu = com.baidu.tieba.im.pushNotify.b.bDs().bDu();
            if (!TextUtils.isEmpty(bDu) && TextUtils.isDigitsOnly(bDu)) {
                this.gFb.me(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(com.baidu.adp.lib.g.b.c(bDu, 0L));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.gFb != null) {
            this.gFb.onChangeSkinType(i);
        }
    }

    public void a(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !biX()) {
            String groupId = updatesItemData.getGroupId();
            String updatesType = updatesItemData.getUpdatesType();
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.c(groupId, 0L), updatesItemData.isShown())));
                    } else if (!updatesType.equals("dismiss_group")) {
                        if (updatesType.equals("group_event_info")) {
                            TiebaStatic.log("update_activity_group_event_click");
                            ba.aiz().c(getPageContext(), new String[]{updatesItemData.getEventLink()});
                        } else if (updatesType.equals("group_activitys_change")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.f(updatesItemData.getGroupActivityId(), 0), com.baidu.adp.lib.g.b.c(updatesItemData.getGroupId(), 0L), 1)));
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
                this.gFh.addSelect(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.gFh.getDeleteSize() > 100) {
                    this.gFh.cancelSelect(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(R.string.updates_activity_del_limit);
                }
            } else {
                this.gFh.cancelSelect(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.gFb.vf(this.gFh.getDeleteSize());
            this.gFb.bBb();
        }
    }

    public void b(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !biX()) {
            if (this.gFc == null) {
                this.gFg = updatesItemData;
                bCh();
            }
            this.gFc.showDialog();
        }
    }

    private void bCh() {
        String string = getPageContext().getString(R.string.delete_user_chat);
        k.c cVar = new k.c() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivity.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(com.baidu.tbadk.core.dialog.k kVar, int i, View view) {
                if (UpdatesActivity.this.gFc != null && UpdatesActivity.this.gFc.isShowing()) {
                    UpdatesActivity.this.gFc.dismiss();
                }
                switch (i) {
                    case 0:
                        UpdatesActivity.this.gFb.me(true);
                        UpdatesActivity.this.a(UpdatesActivity.this.gFg);
                        return;
                    default:
                        return;
                }
            }
        };
        this.gFc = new i(getPageContext());
        this.gFc.a(null, new String[]{string}, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage() {
        if (this.gFb.bCm() != null) {
            this.gFb.bCm().removeCallbacks(this.gFf);
            this.gFb.bCm().post(this.gFf);
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

    public boolean biX() {
        return this.fnN;
    }

    public void md(boolean z) {
        this.fnN = z;
    }
}

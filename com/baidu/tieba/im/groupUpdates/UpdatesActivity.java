package com.baidu.tieba.im.groupUpdates;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.GroupLevelActivityConfig;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.RequestDelSystemMessage;
import com.baidu.tieba.im.model.UpdatesModel;
import com.baidu.tieba.z;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class UpdatesActivity extends BaseActivity<UpdatesActivity> implements AbsListView.OnScrollListener {
    private p bhg;
    private Runnable bhh;
    private UpdatesModel bhi;
    private com.baidu.tieba.im.g<Boolean> delDataCallBack;
    private AlertDialog deleteItemDialog;
    private com.baidu.tieba.im.g<LinkedList<GroupNewsPojo>> getDataCallBack;
    private UpdatesItemData pendingToDel;
    private boolean isEditMode = false;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);
    private CustomMessageListener mCustomListener = new b(this, 0);

    static {
        KQ();
    }

    private static void KQ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008013, new c());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bhi = new UpdatesModel();
        this.bhg = new p(this);
        initDataCallBack();
        registerListener(2001136, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
        registerListener(2001134, this.mCustomListener);
        registerListener(2001133, this.mCustomListener);
        registerListener(2001141, this.mCustomListener);
        this.bhg.setLoadProgressBarVisable(true);
        UpdatesModel.requestUpdatesDataFromDB(this.getDataCallBack);
        registerListener(202004, this.mListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(6, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.rY().cE(2);
        com.baidu.tbadk.coreExtra.messageCenter.a.rY().sk();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new com.baidu.tbadk.live.message.a("-1002", -3)));
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

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        ChatStatusManager.getInst().setIsOpen(6, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ChatStatusManager.getInst().setIsOpen(6, false);
    }

    private void initDataCallBack() {
        this.delDataCallBack = new e(this, new d(this));
        this.getDataCallBack = new f(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bhg != null) {
            this.bhg.destroy();
        }
        if (this.bhi != null) {
            this.bhi.destory();
        }
        this.pendingToDel = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.bhg != null) {
            if (view.equals(this.bhg.getBack())) {
                finish();
            } else if (view.equals(this.bhg.getBtn_edit())) {
                this.bhi.clearSelect();
                this.bhi.calculateSelects(this.bhg.Qu().getDatas());
                this.bhg.setDelCount(this.bhi.getDeleteSize());
                setEditMode(true);
                this.bhg.changeToEditMode();
            } else if (view.equals(this.bhg.getBtn_cancel())) {
                setEditMode(false);
                this.bhg.cancelEditMode();
                this.bhi.clearSelect();
                UpdatesModel.requestUpdatesDataFromDB(this.getDataCallBack);
            } else if (view.equals(this.bhg.getBtn_delete())) {
                this.bhg.setLoadProgressBarVisable(true);
                String deleteDatasIds = this.bhi.deleteDatasIds();
                if (!TextUtils.isEmpty(deleteDatasIds)) {
                    processDel(deleteDatasIds);
                } else {
                    this.bhg.setLoadProgressBarVisable(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && keyEvent.getAction() == 0 && this.isEditMode) {
            setEditMode(false);
            this.bhi.clearSelect();
            this.bhg.setDelCount(this.bhi.getDeleteSize());
            this.bhg.cancelEditMode();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0067: ARITH  (r1v6 long A[REMOVE]) = (wrap: long : 0x005c: INVOKE  (r1v5 long A[REMOVE]) = 
      (wrap: java.lang.String : 0x0058: INVOKE  (r1v4 java.lang.String A[REMOVE]) = (r7v0 com.baidu.tieba.im.data.UpdatesItemData) type: VIRTUAL call: com.baidu.tieba.im.data.UpdatesItemData.getNotice_id():java.lang.String)
     type: STATIC call: java.lang.Long.parseLong(java.lang.String):long) / (100 long))] */
    /* JADX INFO: Access modifiers changed from: private */
    public void processDel(UpdatesItemData updatesItemData) {
        if (!com.baidu.adp.lib.util.i.ff()) {
            showToast(z.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.d.Sg().Si()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.d.Sg().Si()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.bhg.setLoadProgressBarVisable(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(Integer.parseInt(com.baidu.tieba.im.pushNotify.d.Sg().Si()));
                requestDelSystemMessage.setMsgIds(new StringBuilder().append(Long.parseLong(updatesItemData.getNotice_id()) / 100).toString());
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void processDel(String str) {
        if (!com.baidu.adp.lib.util.i.ff()) {
            showToast(z.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String Si = com.baidu.tieba.im.pushNotify.d.Sg().Si();
            if (!TextUtils.isEmpty(Si) && TextUtils.isDigitsOnly(Si)) {
                this.bhg.setLoadProgressBarVisable(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(Integer.parseInt(Si));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.bhg != null) {
            this.bhg.onChangeSkinType(i);
        }
    }

    public void onItemViewClick(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData != null && 101 == i && !isEditMode()) {
            String groupId = updatesItemData.getGroupId();
            String updatesType = updatesItemData.getUpdatesType();
            if (!TextUtils.isEmpty(updatesType)) {
                try {
                    if (updatesType.equals("group_level_up")) {
                        sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.a(groupId, 0L), updatesItemData.isShown())));
                    } else if (!updatesType.equals("dismiss_group")) {
                        if (updatesType.equals("group_event_info")) {
                            com.baidu.tbadk.core.i.A(getPageContext().getPageActivity(), "update_activity_group_event_click");
                            bm.pV().b(getPageContext(), new String[]{updatesItemData.getEventLink()});
                        } else if (updatesType.equals("group_activitys_change")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getPageActivity(), com.baidu.adp.lib.g.c.toInt(updatesItemData.getGroupActivityId(), 0), com.baidu.adp.lib.g.c.a(updatesItemData.getGroupId(), 0L), 1)));
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

    public void onCheckedChanged(View view, boolean z, UpdatesItemData updatesItemData) {
        if (updatesItemData != null) {
            if (z) {
                this.bhi.addSelect(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.bhi.getDeleteSize() > 100) {
                    this.bhi.cancelSelect(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(z.updates_activity_del_limit);
                }
            } else {
                this.bhi.cancelSelect(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.bhg.setDelCount(this.bhi.getDeleteSize());
            this.bhg.refreshList();
        }
    }

    public void onItemViewLongClick(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !isEditMode()) {
            if (this.deleteItemDialog == null) {
                this.pendingToDel = updatesItemData;
                initDeleteDialog();
            }
            com.baidu.adp.lib.g.k.a(this.deleteItemDialog, getPageContext());
        }
    }

    private void initDeleteDialog() {
        String string = getPageContext().getString(z.delete_user_chat);
        g gVar = new g(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder.setTitle(z.operation);
        builder.setItems(new String[]{string}, gVar);
        this.deleteItemDialog = builder.create();
        this.deleteItemDialog.setCanceledOnTouchOutside(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage() {
        if (this.bhg.getValidate_list() != null) {
            this.bhg.getValidate_list().removeCallbacks(this.bhh);
            this.bhg.getValidate_list().post(this.bhh);
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

    public boolean isEditMode() {
        return this.isEditMode;
    }

    public void setEditMode(boolean z) {
        this.isEditMode = z;
    }
}

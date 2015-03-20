package com.baidu.tieba.im.groupUpdates;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.GroupLevelActivityConfig;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.RequestDelSystemMessage;
import com.baidu.tieba.im.model.UpdatesModel;
import com.baidu.tieba.y;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class UpdatesActivity extends BaseActivity<UpdatesActivity> implements AbsListView.OnScrollListener {
    private s biv;
    private Runnable biw;
    private UpdatesModel bix;
    private com.baidu.tieba.im.g<Boolean> delDataCallBack;
    private com.baidu.tbadk.core.dialog.e deleteItemDialog;
    private com.baidu.tieba.im.g<LinkedList<GroupNewsPojo>> getDataCallBack;
    private UpdatesItemData pendingToDel;
    private boolean isEditMode = false;
    private com.baidu.adp.framework.listener.e mListener = new a(this, 0);
    private CustomMessageListener mCustomListener = new b(this, 0);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bix = new UpdatesModel();
        this.biv = new s(this);
        initDataCallBack();
        registerListener(2001136, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
        registerListener(2001134, this.mCustomListener);
        registerListener(2001133, this.mCustomListener);
        registerListener(2001141, this.mCustomListener);
        this.biv.setLoadProgressBarVisable(true);
        UpdatesModel.requestUpdatesDataFromDB(this.getDataCallBack);
        registerListener(202004, this.mListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(6, true);
        com.baidu.tbadk.coreExtra.messageCenter.a.uT().cD(2);
        com.baidu.tbadk.coreExtra.messageCenter.a.uT().vf();
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
        this.delDataCallBack = new d(this, new c(this));
        this.getDataCallBack = new e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.biv != null) {
            this.biv.destroy();
        }
        if (this.bix != null) {
            this.bix.destory();
        }
        this.pendingToDel = null;
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null && this.biv != null) {
            if (view.equals(this.biv.getBack())) {
                finish();
            } else if (view.equals(this.biv.getBtn_edit())) {
                this.bix.clearSelect();
                this.bix.calculateSelects(this.biv.RJ().getDatas());
                this.biv.setDelCount(this.bix.getDeleteSize());
                setEditMode(true);
                this.biv.changeToEditMode();
            } else if (view.equals(this.biv.getBtn_cancel())) {
                setEditMode(false);
                this.biv.cancelEditMode();
                this.bix.clearSelect();
                UpdatesModel.requestUpdatesDataFromDB(this.getDataCallBack);
            } else if (view.equals(this.biv.getBtn_delete())) {
                this.biv.setLoadProgressBarVisable(true);
                String deleteDatasIds = this.bix.deleteDatasIds();
                if (!TextUtils.isEmpty(deleteDatasIds)) {
                    processDel(deleteDatasIds);
                } else {
                    this.biv.setLoadProgressBarVisable(false);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i && keyEvent.getAction() == 0 && this.isEditMode) {
            setEditMode(false);
            this.bix.clearSelect();
            this.biv.setDelCount(this.bix.getDeleteSize());
            this.biv.cancelEditMode();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0067: ARITH  (r1v6 long A[REMOVE]) = (wrap: long : 0x005c: INVOKE  (r1v5 long A[REMOVE]) = 
      (wrap: java.lang.String : 0x0058: INVOKE  (r1v4 java.lang.String A[REMOVE]) = (r7v0 com.baidu.tieba.im.data.UpdatesItemData) type: VIRTUAL call: com.baidu.tieba.im.data.UpdatesItemData.getNotice_id():java.lang.String)
     type: STATIC call: java.lang.Long.parseLong(java.lang.String):long) / (100 long))] */
    /* JADX INFO: Access modifiers changed from: private */
    public void processDel(UpdatesItemData updatesItemData) {
        if (!com.baidu.adp.lib.util.k.iH()) {
            showToast(y.neterror);
        } else if (updatesItemData != null && !TextUtils.isEmpty(com.baidu.tieba.im.pushNotify.d.SY().Ta()) && TextUtils.isDigitsOnly(com.baidu.tieba.im.pushNotify.d.SY().Ta()) && !TextUtils.isEmpty(updatesItemData.getNotice_id()) && TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
            try {
                this.biv.setLoadProgressBarVisable(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(Integer.parseInt(com.baidu.tieba.im.pushNotify.d.SY().Ta()));
                requestDelSystemMessage.setMsgIds(new StringBuilder().append(Long.parseLong(updatesItemData.getNotice_id()) / 100).toString());
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void processDel(String str) {
        if (!com.baidu.adp.lib.util.k.iH()) {
            showToast(y.neterror);
        } else if (!TextUtils.isEmpty(str)) {
            String Ta = com.baidu.tieba.im.pushNotify.d.SY().Ta();
            if (!TextUtils.isEmpty(Ta) && TextUtils.isDigitsOnly(Ta)) {
                this.biv.setLoadProgressBarVisable(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(Integer.parseInt(Ta));
                requestDelSystemMessage.setMsgIds(str);
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.biv != null) {
            this.biv.onChangeSkinType(i);
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
                            com.baidu.tbadk.core.k.A(getPageContext().getPageActivity(), "update_activity_group_event_click");
                            bk.tl().b(getPageContext(), new String[]{updatesItemData.getEventLink()});
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
                this.bix.addSelect(updatesItemData);
                updatesItemData.setSelected(true);
                if (this.bix.getDeleteSize() > 100) {
                    this.bix.cancelSelect(updatesItemData);
                    updatesItemData.setSelected(false);
                    showToast(y.updates_activity_del_limit);
                }
            } else {
                this.bix.cancelSelect(updatesItemData);
                updatesItemData.setSelected(false);
            }
            this.biv.setDelCount(this.bix.getDeleteSize());
            this.biv.refreshList();
        }
    }

    public void onItemViewLongClick(View view, int i, int i2, long j, UpdatesItemData updatesItemData) {
        if (view != null && updatesItemData != null && 200 == i && !isEditMode()) {
            if (this.deleteItemDialog == null) {
                this.pendingToDel = updatesItemData;
                initDeleteDialog();
            }
            this.deleteItemDialog.rg();
        }
    }

    private void initDeleteDialog() {
        String string = getPageContext().getString(y.delete_user_chat);
        f fVar = new f(this);
        this.deleteItemDialog = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        this.deleteItemDialog.by(y.operation);
        this.deleteItemDialog.a(new String[]{string}, fVar);
        this.deleteItemDialog.d(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage() {
        if (this.biv.getValidate_list() != null) {
            this.biv.getValidate_list().removeCallbacks(this.biw);
            this.biv.getValidate_list().post(this.biw);
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

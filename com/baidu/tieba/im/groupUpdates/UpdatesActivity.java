package com.baidu.tieba.im.groupUpdates;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.atomData.GroupLevelActivityConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestDelSystemMessage;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.model.UpdatesModel;
import d.a.j0.r.s.j;
import d.a.j0.r.s.l;
import d.a.j0.z0.n;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class UpdatesActivity extends BaseActivity<UpdatesActivity> implements AbsListView.OnScrollListener {
    public n<Boolean> delDataCallBack;
    public j deleteItemDialog;
    public n<LinkedList<GroupNewsPojo>> getDataCallBack;
    public Runnable loadImageRunnable;
    public UpdatesModel model;
    public UpdatesItemData pendingToDel;
    public d.a.k0.e1.j.c updatesView;
    public boolean isEditMode = false;
    public d.a.c.c.g.c mListener = new e(0);
    public CustomMessageListener mCustomListener = new f(0);

    /* loaded from: classes4.dex */
    public class a implements n<LinkedList<GroupNewsPojo>> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
            ImMessageCenterPojo imMessageCenterPojo;
            List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
            UpdatesActivity.this.updatesView.o(convertToUpdatesItemData);
            UpdatesActivity.this.model.calculateSelects(convertToUpdatesItemData);
            UpdatesActivity.this.updatesView.q(false);
            UpdatesActivity.this.updatesView.p(UpdatesActivity.this.model.getDeleteSize());
            UpdatesActivity.this.loadImage();
            if (convertToUpdatesItemData == null || convertToUpdatesItemData.size() <= 0) {
                imMessageCenterPojo = null;
            } else {
                imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setLast_content(convertToUpdatesItemData.get(0).getContent());
                imMessageCenterPojo.setLast_content_time(convertToUpdatesItemData.get(0).getTime());
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001210, imMessageCenterPojo));
            if (convertToUpdatesItemData == null || convertToUpdatesItemData.size() != 0) {
                return;
            }
            UpdatesActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f17318a;

        public b(n nVar) {
            this.f17318a = nVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            UpdatesActivity.this.model.clearSelect();
            UpdatesActivity.this.updatesView.d();
            UpdatesActivity.this.setEditMode(false);
            UpdatesModel.requestUpdatesDataFromDB(this.f17318a);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements n<LinkedList<GroupNewsPojo>> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(LinkedList<GroupNewsPojo> linkedList) {
            List<UpdatesItemData> convertToUpdatesItemData = UpdatesModel.convertToUpdatesItemData(linkedList);
            UpdatesActivity.this.updatesView.o(convertToUpdatesItemData);
            UpdatesActivity.this.model.calculateSelects(convertToUpdatesItemData);
            UpdatesActivity.this.updatesView.q(false);
            UpdatesActivity.this.updatesView.p(UpdatesActivity.this.model.getDeleteSize());
            UpdatesActivity.this.loadImage();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements l.e {
        public d() {
        }

        @Override // d.a.j0.r.s.l.e
        public void onItemClick(l lVar, int i2, View view) {
            if (UpdatesActivity.this.deleteItemDialog != null && UpdatesActivity.this.deleteItemDialog.isShowing()) {
                UpdatesActivity.this.deleteItemDialog.dismiss();
            }
            if (i2 != 0) {
                return;
            }
            UpdatesActivity.this.updatesView.q(true);
            UpdatesActivity updatesActivity = UpdatesActivity.this;
            updatesActivity.processDel(updatesActivity.pendingToDel);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.a.c.c.g.c {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            UpdatesActivity.this.updatesView.q(false);
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsedMessage) && 202004 == socketResponsedMessage.getCmd()) {
                ResponseDelSystemMessage responseDelSystemMessage = (ResponseDelSystemMessage) socketResponsedMessage;
                RequestDelSystemMessage requestDelSystemMessage = (RequestDelSystemMessage) responseDelSystemMessage.getOrginalMessage();
                if (responseDelSystemMessage.getError() != 0) {
                    return;
                }
                if (UpdatesActivity.this.pendingToDel != null) {
                    UpdatesModel.deleteUpdatesData(UpdatesActivity.this.pendingToDel, UpdatesActivity.this.delDataCallBack);
                    UpdatesActivity.this.pendingToDel = null;
                }
                if (UpdatesActivity.this.model == null || UpdatesActivity.this.model.getDeleteSize() <= 0) {
                    return;
                }
                UpdatesActivity.this.model.deleteDatas(UpdatesActivity.this.delDataCallBack);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdatesActivity.this.updatesView.q(false);
            if (customResponsedMessage != null && (customResponsedMessage instanceof ResponsedMessage)) {
                int cmd = customResponsedMessage.getCmd();
                if (2001132 == cmd || 2001133 == cmd || 2001130 == cmd || 2001129 == cmd || 2001137 == cmd) {
                    UpdatesModel.requestUpdatesDataFromDB(UpdatesActivity.this.getDataCallBack);
                }
            }
        }
    }

    private void initDataCallBack() {
        this.delDataCallBack = new b(new a());
        this.getDataCallBack = new c();
    }

    private void initDeleteDialog() {
        String string = getPageContext().getString(R.string.delete_user_chat);
        d dVar = new d();
        j jVar = new j(getPageContext());
        this.deleteItemDialog = jVar;
        jVar.i(null, new String[]{string}, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImage() {
        if (this.updatesView.l() != null) {
            this.updatesView.l().removeCallbacks(this.loadImageRunnable);
            this.updatesView.l().post(this.loadImageRunnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDel(UpdatesItemData updatesItemData) {
        if (!d.a.c.e.p.j.z()) {
            showToast(R.string.neterror);
        } else if (updatesItemData == null || TextUtils.isEmpty(d.a.k0.e1.p.b.b().c()) || !TextUtils.isDigitsOnly(d.a.k0.e1.p.b.b().c()) || TextUtils.isEmpty(updatesItemData.getNotice_id()) || !TextUtils.isDigitsOnly(updatesItemData.getNotice_id())) {
        } else {
            try {
                this.updatesView.q(true);
                RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
                requestDelSystemMessage.setGroupId(d.a.c.e.m.b.f(d.a.k0.e1.p.b.b().c(), 0L));
                long parseLong = Long.parseLong(updatesItemData.getNotice_id());
                requestDelSystemMessage.setMsgIds("" + (parseLong / 100));
                MessageManager.getInstance().sendMessage(requestDelSystemMessage);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void startActivity(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, UpdatesActivity.class);
        intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        context.startActivity(intent);
    }

    public boolean isEditMode() {
        return this.isEditMode;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        d.a.k0.e1.j.c cVar = this.updatesView;
        if (cVar != null) {
            cVar.onChangeSkinType(i2);
        }
    }

    public void onCheckedChanged(View view, boolean z, UpdatesItemData updatesItemData) {
        if (updatesItemData == null) {
            return;
        }
        if (z) {
            this.model.addSelect(updatesItemData);
            updatesItemData.setSelected(true);
            if (this.model.getDeleteSize() > 100) {
                this.model.cancelSelect(updatesItemData);
                updatesItemData.setSelected(false);
                showToast(R.string.updates_activity_del_limit);
            }
        } else {
            this.model.cancelSelect(updatesItemData);
            updatesItemData.setSelected(false);
        }
        this.updatesView.p(this.model.getDeleteSize());
        this.updatesView.n();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.k0.e1.j.c cVar;
        if (view == null || (cVar = this.updatesView) == null) {
            return;
        }
        if (view.equals(cVar.f())) {
            finish();
        } else if (view.equals(this.updatesView.j())) {
            this.model.clearSelect();
            this.model.calculateSelects(this.updatesView.k().b());
            this.updatesView.p(this.model.getDeleteSize());
            setEditMode(true);
            this.updatesView.e();
        } else if (view.equals(this.updatesView.g())) {
            setEditMode(false);
            this.updatesView.d();
            this.model.clearSelect();
            UpdatesModel.requestUpdatesDataFromDB(this.getDataCallBack);
        } else if (view.equals(this.updatesView.h())) {
            this.updatesView.q(true);
            String deleteDatasIds = this.model.deleteDatasIds();
            if (!TextUtils.isEmpty(deleteDatasIds)) {
                processDel(deleteDatasIds);
            } else {
                this.updatesView.q(false);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.model = new UpdatesModel();
        this.updatesView = new d.a.k0.e1.j.c(this);
        initDataCallBack();
        registerListener(2001132, this.mCustomListener);
        registerListener(2001133, this.mCustomListener);
        registerListener(2001130, this.mCustomListener);
        registerListener(2001129, this.mCustomListener);
        registerListener(2001137, this.mCustomListener);
        this.updatesView.q(true);
        UpdatesModel.requestUpdatesDataFromDB(this.getDataCallBack);
        registerListener(202004, this.mListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.a.k0.e1.j.c cVar = this.updatesView;
        if (cVar != null) {
            cVar.destroy();
        }
        UpdatesModel updatesModel = this.model;
        if (updatesModel != null) {
            updatesModel.destory();
        }
        this.pendingToDel = null;
    }

    public void onItemViewClick(View view, int i2, int i3, long j, UpdatesItemData updatesItemData) {
        if (updatesItemData == null || 101 != i2 || isEditMode()) {
            return;
        }
        String groupId = updatesItemData.getGroupId();
        String updatesType = updatesItemData.getUpdatesType();
        if (TextUtils.isEmpty(updatesType)) {
            return;
        }
        try {
            if (updatesType.equals("group_level_up")) {
                sendMessage(new CustomMessage(2002001, new GroupLevelActivityConfig(getPageContext().getPageActivity(), d.a.c.e.m.b.f(groupId, 0L), updatesItemData.isShown())));
            } else if (updatesType.equals("dismiss_group")) {
            } else {
                if (updatesType.equals("group_event_info")) {
                    TiebaStatic.log("update_activity_group_event_click");
                    UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{updatesItemData.getEventLink()});
                } else if (updatesType.equals("group_activitys_change")) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupActivityActivityConfig(getPageContext().getPageActivity(), d.a.c.e.m.b.d(updatesItemData.getGroupActivityId(), 0), d.a.c.e.m.b.f(updatesItemData.getGroupId(), 0L), 1)));
                } else {
                    sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getPageContext().getPageActivity(), Long.parseLong(groupId), 0)));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onItemViewLongClick(View view, int i2, int i3, long j, UpdatesItemData updatesItemData) {
        if (view == null || updatesItemData == null || 200 != i2 || isEditMode()) {
            return;
        }
        if (this.deleteItemDialog == null) {
            this.pendingToDel = updatesItemData;
            initDeleteDialog();
        }
        this.deleteItemDialog.l();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (4 == i2 && keyEvent.getAction() == 0 && this.isEditMode) {
            setEditMode(false);
            this.model.clearSelect();
            this.updatesView.p(this.model.getDeleteSize());
            this.updatesView.d();
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ChatStatusManager.getInst().setIsOpen(6, false);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        ChatStatusManager.getInst().setIsOpen(6, true);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ChatStatusManager.getInst().setIsOpen(6, true);
        d.a.j0.s.d.b.g0().f(2);
        d.a.j0.s.d.b.g0().g();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.GROUP_UPDATE, -3)));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        if (i2 == 0) {
            loadImage();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ChatStatusManager.getInst().setIsOpen(6, true);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(6, false);
    }

    public void setEditMode(boolean z) {
        this.isEditMode = z;
    }

    private void processDel(String str) {
        if (!d.a.c.e.p.j.z()) {
            showToast(R.string.neterror);
        } else if (TextUtils.isEmpty(str)) {
        } else {
            String c2 = d.a.k0.e1.p.b.b().c();
            if (TextUtils.isEmpty(c2) || !TextUtils.isDigitsOnly(c2)) {
                return;
            }
            this.updatesView.q(true);
            RequestDelSystemMessage requestDelSystemMessage = new RequestDelSystemMessage();
            requestDelSystemMessage.setGroupId(d.a.c.e.m.b.f(c2, 0L));
            requestDelSystemMessage.setMsgIds(str);
            MessageManager.getInstance().sendMessage(requestDelSystemMessage);
        }
    }
}

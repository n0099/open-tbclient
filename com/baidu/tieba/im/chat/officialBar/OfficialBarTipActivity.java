package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleForumBroadcastFeedActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.model.AddMsgRecordModel;
import com.baidu.tieba.im.model.OfficialBarTipModel;
import d.b.h0.r.s.a;
import d.b.h0.r.s.j;
import d.b.h0.r.s.l;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialBarTipActivity extends BaseActivity<OfficialBarTipActivity> {
    public OfficialBarTipModel mModel;
    public d.b.h0.r.s.c mProgressDialog;
    public ImMessageCenterShowItemData mUnsubscribeItem;
    public d.b.i0.d1.f.j.e mView;
    public final CustomMessageListener mMemoryListener = new c(0);
    public final d.b.b.c.g.c mSubscribeListener = new d(104102);
    public d.b.i0.d1.f.i.a mCompleteProcess = new e();
    public final d.b.i0.d1.f.i.b IProcessImpl = new g();

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ImMessageCenterShowItemData item = OfficialBarTipActivity.this.mView.i().getItem(i);
            if (item == null || view == null) {
                return;
            }
            if (OfficialBarTipActivity.this.mView.i().c()) {
                ImageView imageView = (ImageView) view.findViewById(R.id.select_status);
                if (item.isSelected()) {
                    item.setSelected(false);
                    SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
                    SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_n);
                    if (OfficialBarTipActivity.this.hasSelectedData()) {
                        return;
                    }
                    OfficialBarTipActivity.this.mView.s(false);
                    return;
                }
                item.setSelected(true);
                SkinManager.setBackgroundColor(view, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_s);
                OfficialBarTipActivity.this.mView.r(true);
                return;
            }
            try {
                long parseLong = Long.parseLong(item.getFriendId());
                RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MREAD, parseLong + "");
                TiebaStatic.log("c12936");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SingleForumBroadcastFeedActivityConfig(OfficialBarTipActivity.this.getActivity(), item.getFriendId(), item.getFriendName())));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements AdapterView.OnItemLongClickListener {

        /* loaded from: classes4.dex */
        public class a implements l.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ j f17864e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterShowItemData f17865f;

            /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0195a implements a.e {
                public C0195a() {
                }

                @Override // d.b.h0.r.s.a.e
                public void onClick(d.b.h0.r.s.a aVar) {
                    aVar.dismiss();
                    OfficialBarTipActivity.this.mModel.subscribeBar(false, a.this.f17865f.getFriendId());
                    a aVar2 = a.this;
                    OfficialBarTipActivity.this.mUnsubscribeItem = aVar2.f17865f;
                }
            }

            /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class C0196b implements a.e {
                public C0196b(a aVar) {
                }

                @Override // d.b.h0.r.s.a.e
                public void onClick(d.b.h0.r.s.a aVar) {
                    aVar.dismiss();
                }
            }

            public a(j jVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
                this.f17864e = jVar;
                this.f17865f = imMessageCenterShowItemData;
            }

            @Override // d.b.h0.r.s.l.e
            public void onItemClick(l lVar, int i, View view) {
                j jVar = this.f17864e;
                if (jVar != null && jVar.isShowing()) {
                    this.f17864e.dismiss();
                }
                if (i == 0) {
                    OfficialBarTipActivity.this.mModel.asyncDeleteItem(this.f17865f, OfficialBarTipActivity.this.IProcessImpl);
                    return;
                }
                d.b.h0.r.s.a a2 = d.b.h0.s.h.a.a(OfficialBarTipActivity.this.getPageContext(), -1, R.string.make_sure_cancel_subscribe, R.string.confirm, R.string.cancel, new C0195a(), new C0196b(this));
                a2.setMessageShowCenter(true);
                a2.show();
            }
        }

        public b() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            ImMessageCenterShowItemData item = OfficialBarTipActivity.this.mView.i().getItem(i);
            if (item != null) {
                if (OfficialBarTipActivity.this.mView.i().c()) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.select_status);
                    if (item.isSelected()) {
                        item.setSelected(false);
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
                        SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_n);
                        if (!OfficialBarTipActivity.this.hasSelectedData()) {
                            OfficialBarTipActivity.this.mView.r(false);
                        }
                    } else {
                        item.setSelected(true);
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0205);
                        SkinManager.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_s);
                        OfficialBarTipActivity.this.mView.r(true);
                    }
                    return true;
                }
                String[] strArr = {TbadkCoreApplication.getInst().getString(R.string.delete_user_chat), TbadkCoreApplication.getInst().getString(R.string.cancel_subscribe)};
                j jVar = new j(OfficialBarTipActivity.this.getPageContext());
                jVar.i(null, strArr, new a(jVar, item));
                jVar.l();
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                OfficialBarTipActivity.this.processMemoryInitComplete(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                OfficialBarTipActivity.this.processMemoryChanged(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                OfficialBarTipActivity.this.processResponsedMemoryList(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                OfficialBarTipActivity.this.mModel.setData(null, OfficialBarTipActivity.this.mCompleteProcess);
            } else if (customResponsedMessage.getCmd() != 2016011 || OfficialBarTipActivity.this.mView == null || OfficialBarTipActivity.this.mView.i() == null) {
            } else {
                OfficialBarTipActivity.this.mView.i().notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.b.b.c.g.c {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                Message<?> orginalMessage = responseUpdateMaskInfoMessage.getOrginalMessage();
                if (orginalMessage instanceof RequestUpdateMaskInfoMessage) {
                    RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) orginalMessage;
                    if (requestUpdateMaskInfoMessage.getMaskType() == 12 && requestUpdateMaskInfoMessage.getIsMask() == 1) {
                        if (responseUpdateMaskInfoMessage.getError() == 0) {
                            OfficialBarTipActivity.this.onUnSubscribe(requestUpdateMaskInfoMessage.getList());
                        } else {
                            OfficialBarTipActivity.this.getPageContext().showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? OfficialBarTipActivity.this.getPageContext().getResources().getString(R.string.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.b.i0.d1.f.i.a {
        public e() {
        }

        @Override // d.b.i0.d1.f.i.a
        public void onComplete() {
            OfficialBarTipActivity.this.onCompleteProcess();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f17871a;

        public f(String str) {
            this.f17871a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            if (TextUtils.isEmpty(this.f17871a)) {
                return null;
            }
            d.b.i0.d1.t.d.j().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f17871a), false);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.b.i0.d1.f.i.b {
        public g() {
        }

        @Override // d.b.i0.d1.f.i.b
        public void onCanceled() {
            OfficialBarTipActivity.this.dismissDialog();
            OfficialBarTipActivity.this.onCompleteProcess();
        }

        @Override // d.b.i0.d1.f.i.b
        public void onPostExecute() {
            OfficialBarTipActivity.this.dismissDialog();
            OfficialBarTipActivity.this.showToast(R.string.delete_success, false);
            OfficialBarTipActivity.this.onCompleteProcess();
        }

        @Override // d.b.i0.d1.f.i.b
        public void onPreExecute() {
            OfficialBarTipActivity.this.showProgressDialog();
        }

        @Override // d.b.i0.d1.f.i.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (OfficialBarTipActivity.this.mProgressDialog != null) {
                OfficialBarTipActivity.this.mProgressDialog.b(i);
            }
            OfficialBarTipActivity.this.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        d.b.h0.r.s.c cVar = this.mProgressDialog;
        if (cVar != null && cVar.isShowing()) {
            this.mProgressDialog.dismiss();
            this.mProgressDialog = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    private void initData() {
        this.mModel = new OfficialBarTipModel(getPageContext());
    }

    private void initUI() {
        d.b.i0.d1.f.j.e eVar = new d.b.i0.d1.f.j.e(this);
        this.mView = eVar;
        eVar.k().setOnItemClickListener(new a());
        this.mView.k().setOnItemLongClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        d.b.i0.d1.f.j.e eVar = this.mView;
        if (eVar == null || eVar.i() == null) {
            return;
        }
        this.mView.i().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompleteProcess() {
        OfficialBarTipModel officialBarTipModel;
        d.b.i0.d1.f.j.e eVar = this.mView;
        if (eVar == null || eVar.i() == null || (officialBarTipModel = this.mModel) == null) {
            return;
        }
        if (officialBarTipModel != null && officialBarTipModel.isEmpty()) {
            finish();
        }
        new AddMsgRecordModel().req();
        this.mView.o(this.mModel.getData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUnSubscribe(String str) {
        this.mModel.asyncDeleteItem(this.mUnsubscribeItem, this.IProcessImpl);
        new f(str).execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMemoryChanged(CustomResponsedMessage<?> customResponsedMessage) {
        OfficialBarTipModel officialBarTipModel;
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                OfficialBarTipModel officialBarTipModel2 = this.mModel;
                if (officialBarTipModel2 != null) {
                    officialBarTipModel2.insertOrUpdate(data, this.mCompleteProcess);
                }
            } else if (memoryChangedMessage.getType() != 2 || (officialBarTipModel = this.mModel) == null) {
            } else {
                officialBarTipModel.remove(data, this.mCompleteProcess);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMemoryInitComplete(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processResponsedMemoryList(CustomResponsedMessage<?> customResponsedMessage) {
        OfficialBarTipModel officialBarTipModel;
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() != 2 || (officialBarTipModel = this.mModel) == null) {
                return;
            }
            officialBarTipModel.setData(data, this.mCompleteProcess);
        }
    }

    private void registerListener() {
        registerListener(2016004, this.mMemoryListener);
        registerListener(2016007, this.mMemoryListener);
        registerListener(2016001, this.mMemoryListener);
        registerListener(2016011, this.mMemoryListener);
        registerListener(2016002, this.mMemoryListener);
        registerListener(this.mSubscribeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        dismissDialog();
        if (this.mProgressDialog == null) {
            this.mProgressDialog = d.b.i0.d1.h.e.m().p(getPageContext().getPageActivity());
        }
        this.mProgressDialog.show();
        this.mProgressDialog.b(0);
    }

    public void deleteSelectedDatas() {
        this.mModel.deleteSelectedDatas(this.IProcessImpl);
    }

    public boolean hasNoRead() {
        List<ImMessageCenterShowItemData> data = this.mModel.getData();
        for (int i = 0; i != data.size(); i++) {
            if (data.get(i).getUnReadCount() != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSelectedData() {
        List<ImMessageCenterShowItemData> data = this.mModel.getData();
        for (int i = 0; i != data.size(); i++) {
            if (data.get(i).isSelected()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.mView.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        initUI();
        registerListener();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dismissDialog();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRestart() {
        super.onRestart();
        ChatStatusManager.getInst().setIsOpen(4, true);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mView.i().notifyDataSetChanged();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ChatStatusManager.getInst().setIsOpen(4, true);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(4, false);
    }

    public void setAllRead() {
        List<ImMessageCenterShowItemData> data = this.mModel.getData();
        for (int i = 0; i != data.size(); i++) {
            data.get(i).setUnReadCount(0);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.get(i).getFriendId(), 4)));
        }
        this.mView.o(this.mModel.getData());
    }

    public void updateEditStatus(boolean z) {
        this.mModel.updateEditStatus(z);
        this.mView.o(this.mModel.getData());
    }
}

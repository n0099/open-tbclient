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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.d;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.im.model.AddMsgRecordModel;
import com.baidu.tieba.im.model.OfficialBarTipModel;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarTipActivity extends BaseActivity<OfficialBarTipActivity> {
    private OfficialBarTipModel dTi;
    private f dTj;
    private ImMessageCenterShowItemData dTk;
    private com.baidu.tbadk.core.dialog.d dTl;
    private final CustomMessageListener dTm = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2016002) {
                    OfficialBarTipActivity.this.c(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016004) {
                    OfficialBarTipActivity.this.e(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016007) {
                    OfficialBarTipActivity.this.d(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2016001) {
                    OfficialBarTipActivity.this.dTi.setData(null, OfficialBarTipActivity.this.dTo);
                } else if (customResponsedMessage.getCmd() == 2016011 && OfficialBarTipActivity.this.dTj != null && OfficialBarTipActivity.this.dTj.aBu() != null) {
                    OfficialBarTipActivity.this.dTj.aBu().notifyDataSetChanged();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c dTn = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.4
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
                            OfficialBarTipActivity.this.mR(requestUpdateMaskInfoMessage.getList());
                        } else {
                            OfficialBarTipActivity.this.getPageContext().showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? OfficialBarTipActivity.this.getPageContext().getResources().getString(d.k.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a dTo = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void aBd() {
            OfficialBarTipActivity.this.aBs();
        }
    };
    private final com.baidu.tieba.im.chat.a.b dTp = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.7
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            OfficialBarTipActivity.this.aBr();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (OfficialBarTipActivity.this.dTl != null) {
                OfficialBarTipActivity.this.dTl.setPercent(i);
            }
            OfficialBarTipActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            OfficialBarTipActivity.this.Vl();
            OfficialBarTipActivity.this.showToast(d.k.delete_success, false);
            OfficialBarTipActivity.this.aBs();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            OfficialBarTipActivity.this.Vl();
            OfficialBarTipActivity.this.aBs();
        }
    };

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        initUI();
        registerListener();
    }

    private void registerListener() {
        registerListener(2016004, this.dTm);
        registerListener(2016007, this.dTm);
        registerListener(2016001, this.dTm);
        registerListener(2016011, this.dTm);
        registerListener(2016002, this.dTm);
        registerListener(this.dTn);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dTj.aBu().notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a("-1000", -8)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Vl();
        super.onDestroy();
    }

    private void initData() {
        this.dTi = new OfficialBarTipModel(getPageContext());
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        ChatStatusManager.getInst().setIsOpen(4, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ChatStatusManager.getInst().setIsOpen(4, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ChatStatusManager.getInst().setIsOpen(4, false);
    }

    private void initUI() {
        this.dTj = new f(this);
        this.dTj.aBt().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                ImMessageCenterShowItemData ni = OfficialBarTipActivity.this.dTj.aBu().getItem(i);
                if (ni != null && view2 != null) {
                    ImMessageCenterShowItemData imMessageCenterShowItemData = ni;
                    if (OfficialBarTipActivity.this.dTj.aBu().aBe()) {
                        ImageView imageView = (ImageView) view2.findViewById(d.g.select_status);
                        if (imMessageCenterShowItemData.isSelected()) {
                            imMessageCenterShowItemData.setSelected(false);
                            ak.j(view2, d.C0126d.cp_bg_line_d);
                            ak.i(imageView, d.f.btn_bgb_choice_n);
                            if (!OfficialBarTipActivity.this.aBo()) {
                                OfficialBarTipActivity.this.dTj.gP(false);
                                return;
                            }
                            return;
                        }
                        imMessageCenterShowItemData.setSelected(true);
                        ak.j(view2, d.C0126d.cp_bg_line_e);
                        ak.i(imageView, d.f.btn_bgb_choice_s);
                        OfficialBarTipActivity.this.dTj.gO(true);
                        return;
                    }
                    try {
                        long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                        RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MREAD, parseLong + "");
                        TiebaStatic.log("c12936");
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(OfficialBarTipActivity.this.getPageContext().getContext(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0, imMessageCenterShowItemData.getUserType())));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        this.dTj.aBt().setOnItemLongClickListener(new AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 implements AdapterView.OnItemLongClickListener {
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
            ImMessageCenterShowItemData ni = OfficialBarTipActivity.this.dTj.aBu().getItem(i);
            if (ni != null) {
                final ImMessageCenterShowItemData imMessageCenterShowItemData = ni;
                if (OfficialBarTipActivity.this.dTj.aBu().aBe()) {
                    ImageView imageView = (ImageView) view2.findViewById(d.g.select_status);
                    if (imMessageCenterShowItemData.isSelected()) {
                        imMessageCenterShowItemData.setSelected(false);
                        ak.j(view2, d.C0126d.cp_bg_line_d);
                        ak.i(imageView, d.f.btn_bgb_choice_n);
                        if (!OfficialBarTipActivity.this.aBo()) {
                            OfficialBarTipActivity.this.dTj.gO(false);
                        }
                    } else {
                        imMessageCenterShowItemData.setSelected(true);
                        ak.j(view2, d.C0126d.cp_bg_line_e);
                        ak.i(imageView, d.f.btn_bgb_choice_s);
                        OfficialBarTipActivity.this.dTj.gO(true);
                    }
                } else {
                    com.baidu.tbadk.coreExtra.d.a.a(OfficialBarTipActivity.this.getPageContext(), d.k.operation, new CharSequence[]{TbadkCoreApplication.getInst().getString(d.k.delete_user_chat), TbadkCoreApplication.getInst().getString(d.k.cancel_subscribe)}, new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                        public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view3) {
                            bVar.dismiss();
                            if (i2 == 0) {
                                OfficialBarTipActivity.this.dTi.asyncDeleteItem(imMessageCenterShowItemData, OfficialBarTipActivity.this.dTp);
                                return;
                            }
                            com.baidu.tbadk.core.dialog.a a = com.baidu.tbadk.coreExtra.d.a.a(OfficialBarTipActivity.this.getPageContext(), -1, d.k.make_sure_cancel_subscribe, d.k.confirm, d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                    OfficialBarTipActivity.this.dTi.subscribeBar(false, imMessageCenterShowItemData.getFriendId());
                                    OfficialBarTipActivity.this.dTk = imMessageCenterShowItemData;
                                }
                            }, new a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                }
                            });
                            a.ax(true);
                            a.tD();
                        }
                    }).tG();
                }
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dTj.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            sendMessage(new RequestMemoryListMessage(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                if (this.dTi != null) {
                    this.dTi.insertOrUpdate(data, this.dTo);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.dTi != null) {
                this.dTi.remove(data, this.dTo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 2 && this.dTi != null) {
                this.dTi.setData(data, this.dTo);
            }
        }
    }

    public void updateEditStatus(boolean z) {
        this.dTi.updateEditStatus(z);
        this.dTj.setData(this.dTi.getData());
    }

    public void aBn() {
        this.dTi.deleteSelectedDatas(this.dTp);
    }

    public boolean aBo() {
        List<ImMessageCenterShowItemData> data = this.dTi.getData();
        for (int i = 0; i != data.size(); i++) {
            if (data.get(i).isSelected()) {
                return true;
            }
        }
        return false;
    }

    public void aBp() {
        List<ImMessageCenterShowItemData> data = this.dTi.getData();
        for (int i = 0; i != data.size(); i++) {
            data.get(i).setUnReadCount(0);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.get(i).getFriendId(), 4)));
        }
        this.dTj.setData(this.dTi.getData());
    }

    public boolean aBq() {
        List<ImMessageCenterShowItemData> data = this.dTi.getData();
        for (int i = 0; i != data.size(); i++) {
            if (data.get(i).getUnReadCount() != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mR(final String str) {
        this.dTi.asyncDeleteItem(this.dTk, this.dTp);
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aGW().i(TbadkApplication.getCurrentAccount(), String.valueOf(str), false);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBr() {
        Vl();
        if (this.dTl == null) {
            this.dTl = com.baidu.tieba.im.db.e.aDa().bz(getPageContext().getPageActivity());
        }
        this.dTl.show();
        this.dTl.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vl() {
        if (this.dTl != null && this.dTl.isShowing()) {
            this.dTl.dismiss();
            this.dTl = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.dTj != null && this.dTj.aBu() != null) {
            this.dTj.aBu().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBs() {
        if (this.dTj != null && this.dTj.aBu() != null && this.dTi != null) {
            if (this.dTi != null && this.dTi.isEmpty()) {
                finish();
            }
            new AddMsgRecordModel().req();
            this.dTj.setData(this.dTi.getData());
        }
    }
}

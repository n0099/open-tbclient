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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.live.message.MemoryClearUnreadCountMessage;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.e;
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
    private OfficialBarTipModel eDI;
    private f eDJ;
    private ImMessageCenterShowItemData eDK;
    private com.baidu.tbadk.core.dialog.d eDL;
    private final CustomMessageListener eDM = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.3
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
                    OfficialBarTipActivity.this.eDI.setData(null, OfficialBarTipActivity.this.eDO);
                } else if (customResponsedMessage.getCmd() == 2016011 && OfficialBarTipActivity.this.eDJ != null && OfficialBarTipActivity.this.eDJ.aMT() != null) {
                    OfficialBarTipActivity.this.eDJ.aMT().notifyDataSetChanged();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c eDN = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.4
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
                            OfficialBarTipActivity.this.oV(requestUpdateMaskInfoMessage.getList());
                        } else {
                            OfficialBarTipActivity.this.getPageContext().showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? OfficialBarTipActivity.this.getPageContext().getResources().getString(e.j.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a eDO = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            OfficialBarTipActivity.this.aMR();
        }
    };
    private final com.baidu.tieba.im.chat.a.b eDP = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.7
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            OfficialBarTipActivity.this.awP();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (OfficialBarTipActivity.this.eDL != null) {
                OfficialBarTipActivity.this.eDL.setPercent(i);
            }
            OfficialBarTipActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            OfficialBarTipActivity.this.RV();
            OfficialBarTipActivity.this.showToast(e.j.delete_success, false);
            OfficialBarTipActivity.this.aMR();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            OfficialBarTipActivity.this.RV();
            OfficialBarTipActivity.this.aMR();
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
        registerListener(2016004, this.eDM);
        registerListener(2016007, this.eDM);
        registerListener(2016001, this.eDM);
        registerListener(2016011, this.eDM);
        registerListener(2016002, this.eDM);
        registerListener(this.eDN);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eDJ.aMT().notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a("-1000", -8)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        RV();
        super.onDestroy();
    }

    private void initData() {
        this.eDI = new OfficialBarTipModel(getPageContext());
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
        this.eDJ = new f(this);
        this.eDJ.aMS().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ImMessageCenterShowItemData pi = OfficialBarTipActivity.this.eDJ.aMT().getItem(i);
                if (pi != null && view != null) {
                    ImMessageCenterShowItemData imMessageCenterShowItemData = pi;
                    if (OfficialBarTipActivity.this.eDJ.aMT().aMF()) {
                        ImageView imageView = (ImageView) view.findViewById(e.g.select_status);
                        if (imMessageCenterShowItemData.isSelected()) {
                            imMessageCenterShowItemData.setSelected(false);
                            al.j(view, e.d.cp_bg_line_d);
                            al.i(imageView, e.f.btn_bgb_choice_n);
                            if (!OfficialBarTipActivity.this.aMO()) {
                                OfficialBarTipActivity.this.eDJ.ii(false);
                                return;
                            }
                            return;
                        }
                        imMessageCenterShowItemData.setSelected(true);
                        al.j(view, e.d.cp_bg_line_e);
                        al.i(imageView, e.f.btn_bgb_choice_s);
                        OfficialBarTipActivity.this.eDJ.ih(true);
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
        this.eDJ.aMS().setOnItemLongClickListener(new AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 implements AdapterView.OnItemLongClickListener {
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            ImMessageCenterShowItemData pi = OfficialBarTipActivity.this.eDJ.aMT().getItem(i);
            if (pi != null) {
                final ImMessageCenterShowItemData imMessageCenterShowItemData = pi;
                if (OfficialBarTipActivity.this.eDJ.aMT().aMF()) {
                    ImageView imageView = (ImageView) view.findViewById(e.g.select_status);
                    if (imMessageCenterShowItemData.isSelected()) {
                        imMessageCenterShowItemData.setSelected(false);
                        al.j(view, e.d.cp_bg_line_d);
                        al.i(imageView, e.f.btn_bgb_choice_n);
                        if (!OfficialBarTipActivity.this.aMO()) {
                            OfficialBarTipActivity.this.eDJ.ih(false);
                        }
                    } else {
                        imMessageCenterShowItemData.setSelected(true);
                        al.j(view, e.d.cp_bg_line_e);
                        al.i(imageView, e.f.btn_bgb_choice_s);
                        OfficialBarTipActivity.this.eDJ.ih(true);
                    }
                } else {
                    com.baidu.tbadk.coreExtra.d.a.a(OfficialBarTipActivity.this.getPageContext(), e.j.operation, new CharSequence[]{TbadkCoreApplication.getInst().getString(e.j.delete_user_chat), TbadkCoreApplication.getInst().getString(e.j.cancel_subscribe)}, new b.InterfaceC0148b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                        public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view2) {
                            bVar.dismiss();
                            if (i2 == 0) {
                                OfficialBarTipActivity.this.eDI.asyncDeleteItem(imMessageCenterShowItemData, OfficialBarTipActivity.this.eDP);
                                return;
                            }
                            com.baidu.tbadk.core.dialog.a a = com.baidu.tbadk.coreExtra.d.a.a(OfficialBarTipActivity.this.getPageContext(), -1, e.j.make_sure_cancel_subscribe, e.j.confirm, e.j.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                    OfficialBarTipActivity.this.eDI.subscribeBar(false, imMessageCenterShowItemData.getFriendId());
                                    OfficialBarTipActivity.this.eDK = imMessageCenterShowItemData;
                                }
                            }, new a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                }
                            });
                            a.bk(true);
                            a.AB();
                        }
                    }).AE();
                }
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.eDJ.onChangeSkinType(i);
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
                if (this.eDI != null) {
                    this.eDI.insertOrUpdate(data, this.eDO);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.eDI != null) {
                this.eDI.remove(data, this.eDO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 2 && this.eDI != null) {
                this.eDI.setData(data, this.eDO);
            }
        }
    }

    public void updateEditStatus(boolean z) {
        this.eDI.updateEditStatus(z);
        this.eDJ.setData(this.eDI.getData());
    }

    public void aMN() {
        this.eDI.deleteSelectedDatas(this.eDP);
    }

    public boolean aMO() {
        List<ImMessageCenterShowItemData> data = this.eDI.getData();
        for (int i = 0; i != data.size(); i++) {
            if (data.get(i).isSelected()) {
                return true;
            }
        }
        return false;
    }

    public void aMP() {
        List<ImMessageCenterShowItemData> data = this.eDI.getData();
        for (int i = 0; i != data.size(); i++) {
            data.get(i).setUnReadCount(0);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.get(i).getFriendId(), 4)));
        }
        this.eDJ.setData(this.eDI.getData());
    }

    public boolean aMQ() {
        List<ImMessageCenterShowItemData> data = this.eDI.getData();
        for (int i = 0; i != data.size(); i++) {
            if (data.get(i).getUnReadCount() != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oV(final String str) {
        this.eDI.asyncDeleteItem(this.eDK, this.eDP);
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aSs().i(TbadkApplication.getCurrentAccount(), String.valueOf(str), false);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awP() {
        RV();
        if (this.eDL == null) {
            this.eDL = com.baidu.tieba.im.db.e.aOz().cz(getPageContext().getPageActivity());
        }
        this.eDL.show();
        this.eDL.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RV() {
        if (this.eDL != null && this.eDL.isShowing()) {
            this.eDL.dismiss();
            this.eDL = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.eDJ != null && this.eDJ.aMT() != null) {
            this.eDJ.aMT().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMR() {
        if (this.eDJ != null && this.eDJ.aMT() != null && this.eDI != null) {
            if (this.eDI != null && this.eDI.isEmpty()) {
                finish();
            }
            new AddMsgRecordModel().req();
            this.eDJ.setData(this.eDI.getData());
        }
    }
}

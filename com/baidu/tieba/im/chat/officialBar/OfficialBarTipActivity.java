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
import com.baidu.tbadk.core.util.am;
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
    private OfficialBarTipModel ejs;
    private f ejt;
    private ImMessageCenterShowItemData eju;
    private com.baidu.tbadk.core.dialog.d ejv;
    private final CustomMessageListener ejw = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.3
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
                    OfficialBarTipActivity.this.ejs.setData(null, OfficialBarTipActivity.this.ejy);
                } else if (customResponsedMessage.getCmd() == 2016011 && OfficialBarTipActivity.this.ejt != null && OfficialBarTipActivity.this.ejt.aGU() != null) {
                    OfficialBarTipActivity.this.ejt.aGU().notifyDataSetChanged();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c ejx = new com.baidu.adp.framework.listener.c(104102) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.4
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
                            OfficialBarTipActivity.this.nH(requestUpdateMaskInfoMessage.getList());
                        } else {
                            OfficialBarTipActivity.this.getPageContext().showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? OfficialBarTipActivity.this.getPageContext().getResources().getString(d.k.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a ejy = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void aGE() {
            OfficialBarTipActivity.this.aGS();
        }
    };
    private final com.baidu.tieba.im.chat.a.b ejz = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.7
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            OfficialBarTipActivity.this.arD();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (OfficialBarTipActivity.this.ejv != null) {
                OfficialBarTipActivity.this.ejv.setPercent(i);
            }
            OfficialBarTipActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            OfficialBarTipActivity.this.Zr();
            OfficialBarTipActivity.this.showToast(d.k.delete_success, false);
            OfficialBarTipActivity.this.aGS();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            OfficialBarTipActivity.this.Zr();
            OfficialBarTipActivity.this.aGS();
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
        registerListener(2016004, this.ejw);
        registerListener(2016007, this.ejw);
        registerListener(2016001, this.ejw);
        registerListener(2016011, this.ejw);
        registerListener(2016002, this.ejw);
        registerListener(this.ejx);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ejt.aGU().notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a("-1000", -8)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Zr();
        super.onDestroy();
    }

    private void initData() {
        this.ejs = new OfficialBarTipModel(getPageContext());
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
        this.ejt = new f(this);
        this.ejt.aGT().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ImMessageCenterShowItemData nA = OfficialBarTipActivity.this.ejt.aGU().getItem(i);
                if (nA != null && view != null) {
                    ImMessageCenterShowItemData imMessageCenterShowItemData = nA;
                    if (OfficialBarTipActivity.this.ejt.aGU().aGF()) {
                        ImageView imageView = (ImageView) view.findViewById(d.g.select_status);
                        if (imMessageCenterShowItemData.isSelected()) {
                            imMessageCenterShowItemData.setSelected(false);
                            am.j(view, d.C0142d.cp_bg_line_d);
                            am.i(imageView, d.f.btn_bgb_choice_n);
                            if (!OfficialBarTipActivity.this.aGP()) {
                                OfficialBarTipActivity.this.ejt.hg(false);
                                return;
                            }
                            return;
                        }
                        imMessageCenterShowItemData.setSelected(true);
                        am.j(view, d.C0142d.cp_bg_line_e);
                        am.i(imageView, d.f.btn_bgb_choice_s);
                        OfficialBarTipActivity.this.ejt.hf(true);
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
        this.ejt.aGT().setOnItemLongClickListener(new AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 implements AdapterView.OnItemLongClickListener {
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            ImMessageCenterShowItemData nA = OfficialBarTipActivity.this.ejt.aGU().getItem(i);
            if (nA != null) {
                final ImMessageCenterShowItemData imMessageCenterShowItemData = nA;
                if (OfficialBarTipActivity.this.ejt.aGU().aGF()) {
                    ImageView imageView = (ImageView) view.findViewById(d.g.select_status);
                    if (imMessageCenterShowItemData.isSelected()) {
                        imMessageCenterShowItemData.setSelected(false);
                        am.j(view, d.C0142d.cp_bg_line_d);
                        am.i(imageView, d.f.btn_bgb_choice_n);
                        if (!OfficialBarTipActivity.this.aGP()) {
                            OfficialBarTipActivity.this.ejt.hf(false);
                        }
                    } else {
                        imMessageCenterShowItemData.setSelected(true);
                        am.j(view, d.C0142d.cp_bg_line_e);
                        am.i(imageView, d.f.btn_bgb_choice_s);
                        OfficialBarTipActivity.this.ejt.hf(true);
                    }
                } else {
                    com.baidu.tbadk.coreExtra.d.a.a(OfficialBarTipActivity.this.getPageContext(), d.k.operation, new CharSequence[]{TbadkCoreApplication.getInst().getString(d.k.delete_user_chat), TbadkCoreApplication.getInst().getString(d.k.cancel_subscribe)}, new b.InterfaceC0104b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1
                        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                        public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view2) {
                            bVar.dismiss();
                            if (i2 == 0) {
                                OfficialBarTipActivity.this.ejs.asyncDeleteItem(imMessageCenterShowItemData, OfficialBarTipActivity.this.ejz);
                                return;
                            }
                            com.baidu.tbadk.core.dialog.a a = com.baidu.tbadk.coreExtra.d.a.a(OfficialBarTipActivity.this.getPageContext(), -1, d.k.make_sure_cancel_subscribe, d.k.confirm, d.k.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                    OfficialBarTipActivity.this.ejs.subscribeBar(false, imMessageCenterShowItemData.getFriendId());
                                    OfficialBarTipActivity.this.eju = imMessageCenterShowItemData;
                                }
                            }, new a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                }
                            });
                            a.aC(true);
                            a.xn();
                        }
                    }).xq();
                }
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.ejt.onChangeSkinType(i);
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
                if (this.ejs != null) {
                    this.ejs.insertOrUpdate(data, this.ejy);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.ejs != null) {
                this.ejs.remove(data, this.ejy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 2 && this.ejs != null) {
                this.ejs.setData(data, this.ejy);
            }
        }
    }

    public void updateEditStatus(boolean z) {
        this.ejs.updateEditStatus(z);
        this.ejt.setData(this.ejs.getData());
    }

    public void aGO() {
        this.ejs.deleteSelectedDatas(this.ejz);
    }

    public boolean aGP() {
        List<ImMessageCenterShowItemData> data = this.ejs.getData();
        for (int i = 0; i != data.size(); i++) {
            if (data.get(i).isSelected()) {
                return true;
            }
        }
        return false;
    }

    public void aGQ() {
        List<ImMessageCenterShowItemData> data = this.ejs.getData();
        for (int i = 0; i != data.size(); i++) {
            data.get(i).setUnReadCount(0);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.get(i).getFriendId(), 4)));
        }
        this.ejt.setData(this.ejs.getData());
    }

    public boolean aGR() {
        List<ImMessageCenterShowItemData> data = this.ejs.getData();
        for (int i = 0; i != data.size(); i++) {
            if (data.get(i).getUnReadCount() != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nH(final String str) {
        this.ejs.asyncDeleteItem(this.eju, this.ejz);
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.aMv().i(TbadkApplication.getCurrentAccount(), String.valueOf(str), false);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arD() {
        Zr();
        if (this.ejv == null) {
            this.ejv = com.baidu.tieba.im.db.e.aIA().bJ(getPageContext().getPageActivity());
        }
        this.ejv.show();
        this.ejv.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zr() {
        if (this.ejv != null && this.ejv.isShowing()) {
            this.ejv.dismiss();
            this.ejv = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.ejt != null && this.ejt.aGU() != null) {
            this.ejt.aGU().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGS() {
        if (this.ejt != null && this.ejt.aGU() != null && this.ejs != null) {
            if (this.ejs != null && this.ejs.isEmpty()) {
                finish();
            }
            new AddMsgRecordModel().req();
            this.ejt.setData(this.ejs.getData());
        }
    }
}

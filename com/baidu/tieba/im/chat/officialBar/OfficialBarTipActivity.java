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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
import java.util.List;
/* loaded from: classes13.dex */
public class OfficialBarTipActivity extends BaseActivity<OfficialBarTipActivity> {
    private OfficialBarTipModel huQ;
    private f huR;
    private ImMessageCenterShowItemData huS;
    private com.baidu.tbadk.core.dialog.d huT;
    private final CustomMessageListener huU = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.3
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
                    OfficialBarTipActivity.this.huQ.setData(null, OfficialBarTipActivity.this.huW);
                } else if (customResponsedMessage.getCmd() == 2016011 && OfficialBarTipActivity.this.huR != null && OfficialBarTipActivity.this.huR.bSG() != null) {
                    OfficialBarTipActivity.this.huR.bSG().notifyDataSetChanged();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c huV = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.4
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
                            OfficialBarTipActivity.this.Cw(requestUpdateMaskInfoMessage.getList());
                        } else {
                            OfficialBarTipActivity.this.getPageContext().showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? OfficialBarTipActivity.this.getPageContext().getResources().getString(R.string.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a huW = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            OfficialBarTipActivity.this.bSE();
        }
    };
    private final com.baidu.tieba.im.chat.a.b huX = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.7
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            OfficialBarTipActivity.this.showProgressDialog();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (OfficialBarTipActivity.this.huT != null) {
                OfficialBarTipActivity.this.huT.setPercent(i);
            }
            OfficialBarTipActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            OfficialBarTipActivity.this.sN();
            OfficialBarTipActivity.this.showToast(R.string.delete_success, false);
            OfficialBarTipActivity.this.bSE();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            OfficialBarTipActivity.this.sN();
            OfficialBarTipActivity.this.bSE();
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.huU);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.huU);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.huU);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.huU);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.huU);
        registerListener(this.huV);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.huR.bSG().notifyDataSetChanged();
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(TbEnum.CustomGroupId.OFFICIAL_MERGE, -8)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        sN();
        super.onDestroy();
    }

    private void initData() {
        this.huQ = new OfficialBarTipModel(getPageContext());
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
        this.huR = new f(this);
        this.huR.bSF().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ImMessageCenterShowItemData wc = OfficialBarTipActivity.this.huR.bSG().getItem(i);
                if (wc != null && view != null) {
                    ImMessageCenterShowItemData imMessageCenterShowItemData = wc;
                    if (OfficialBarTipActivity.this.huR.bSG().bSs()) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.select_status);
                        if (imMessageCenterShowItemData.isSelected()) {
                            imMessageCenterShowItemData.setSelected(false);
                            am.setBackgroundColor(view, R.color.cp_bg_line_d);
                            am.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_n);
                            if (!OfficialBarTipActivity.this.bSB()) {
                                OfficialBarTipActivity.this.huR.nl(false);
                                return;
                            }
                            return;
                        }
                        imMessageCenterShowItemData.setSelected(true);
                        am.setBackgroundColor(view, R.color.cp_bg_line_e);
                        am.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_s);
                        OfficialBarTipActivity.this.huR.nk(true);
                        return;
                    }
                    try {
                        long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                        RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MREAD, parseLong + "");
                        TiebaStatic.log("c12936");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_OFFICIAL_BAR_CHAT, new OfficalBarChatActivityConfig(OfficialBarTipActivity.this.getPageContext().getContext(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendPortrait(), 0, imMessageCenterShowItemData.getUserType())));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        this.huR.bSF().setOnItemLongClickListener(new AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity$2  reason: invalid class name */
    /* loaded from: classes13.dex */
    public class AnonymousClass2 implements AdapterView.OnItemLongClickListener {
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            ImMessageCenterShowItemData wc = OfficialBarTipActivity.this.huR.bSG().getItem(i);
            if (wc != null) {
                final ImMessageCenterShowItemData imMessageCenterShowItemData = wc;
                if (OfficialBarTipActivity.this.huR.bSG().bSs()) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.select_status);
                    if (imMessageCenterShowItemData.isSelected()) {
                        imMessageCenterShowItemData.setSelected(false);
                        am.setBackgroundColor(view, R.color.cp_bg_line_d);
                        am.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_n);
                        if (!OfficialBarTipActivity.this.bSB()) {
                            OfficialBarTipActivity.this.huR.nk(false);
                        }
                    } else {
                        imMessageCenterShowItemData.setSelected(true);
                        am.setBackgroundColor(view, R.color.cp_bg_line_e);
                        am.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_s);
                        OfficialBarTipActivity.this.huR.nk(true);
                    }
                } else {
                    String[] strArr = {TbadkCoreApplication.getInst().getString(R.string.delete_user_chat), TbadkCoreApplication.getInst().getString(R.string.cancel_subscribe)};
                    final i iVar = new i(OfficialBarTipActivity.this.getPageContext());
                    iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1
                        @Override // com.baidu.tbadk.core.dialog.k.c
                        public void a(k kVar, int i2, View view2) {
                            if (iVar != null && iVar.isShowing()) {
                                iVar.dismiss();
                            }
                            if (i2 == 0) {
                                OfficialBarTipActivity.this.huQ.asyncDeleteItem(imMessageCenterShowItemData, OfficialBarTipActivity.this.huX);
                                return;
                            }
                            com.baidu.tbadk.core.dialog.a a = com.baidu.tbadk.coreExtra.c.a.a(OfficialBarTipActivity.this.getPageContext(), -1, (int) R.string.make_sure_cancel_subscribe, (int) R.string.confirm, (int) R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                    OfficialBarTipActivity.this.huQ.subscribeBar(false, imMessageCenterShowItemData.getFriendId());
                                    OfficialBarTipActivity.this.huS = imMessageCenterShowItemData;
                                }
                            }, new a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                }
                            });
                            a.setMessageShowCenter(true);
                            a.aEA();
                        }
                    });
                    iVar.showDialog();
                }
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.huR.onChangeSkinType(i);
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
                if (this.huQ != null) {
                    this.huQ.insertOrUpdate(data, this.huW);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.huQ != null) {
                this.huQ.remove(data, this.huW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 2 && this.huQ != null) {
                this.huQ.setData(data, this.huW);
            }
        }
    }

    public void updateEditStatus(boolean z) {
        this.huQ.updateEditStatus(z);
        this.huR.setData(this.huQ.getData());
    }

    public void bSA() {
        this.huQ.deleteSelectedDatas(this.huX);
    }

    public boolean bSB() {
        List<ImMessageCenterShowItemData> data = this.huQ.getData();
        for (int i = 0; i != data.size(); i++) {
            if (data.get(i).isSelected()) {
                return true;
            }
        }
        return false;
    }

    public void bSC() {
        List<ImMessageCenterShowItemData> data = this.huQ.getData();
        for (int i = 0; i != data.size(); i++) {
            data.get(i).setUnReadCount(0);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.get(i).getFriendId(), 4)));
        }
        this.huR.setData(this.huQ.getData());
    }

    public boolean bSD() {
        List<ImMessageCenterShowItemData> data = this.huQ.getData();
        for (int i = 0; i != data.size(); i++) {
            if (data.get(i).getUnReadCount() != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cw(final String str) {
        this.huQ.asyncDeleteItem(this.huS, this.huX);
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.bXZ().y(TbadkApplication.getCurrentAccount(), String.valueOf(str), false);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        sN();
        if (this.huT == null) {
            this.huT = com.baidu.tieba.im.db.e.bUl().fa(getPageContext().getPageActivity());
        }
        this.huT.show();
        this.huT.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sN() {
        if (this.huT != null && this.huT.isShowing()) {
            this.huT.dismiss();
            this.huT = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.huR != null && this.huR.bSG() != null) {
            this.huR.bSG().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSE() {
        if (this.huR != null && this.huR.bSG() != null && this.huQ != null) {
            if (this.huQ != null && this.huQ.isEmpty()) {
                finish();
            }
            new AddMsgRecordModel().req();
            this.huR.setData(this.huQ.getData());
        }
    }
}

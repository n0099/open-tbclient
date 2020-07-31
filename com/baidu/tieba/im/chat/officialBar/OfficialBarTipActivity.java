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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SingleForumBroadcastFeedActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes20.dex */
public class OfficialBarTipActivity extends BaseActivity<OfficialBarTipActivity> {
    private OfficialBarTipModel iTJ;
    private g iTK;
    private ImMessageCenterShowItemData iTL;
    private com.baidu.tbadk.core.dialog.d iTM;
    private final CustomMessageListener iTN = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.3
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
                    OfficialBarTipActivity.this.iTJ.setData(null, OfficialBarTipActivity.this.iTP);
                } else if (customResponsedMessage.getCmd() == 2016011 && OfficialBarTipActivity.this.iTK != null && OfficialBarTipActivity.this.iTK.crA() != null) {
                    OfficialBarTipActivity.this.iTK.crA().notifyDataSetChanged();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c iTO = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.4
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
                            OfficialBarTipActivity.this.Hh(requestUpdateMaskInfoMessage.getList());
                        } else {
                            OfficialBarTipActivity.this.getPageContext().showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? OfficialBarTipActivity.this.getPageContext().getResources().getString(R.string.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a iTP = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            OfficialBarTipActivity.this.cry();
        }
    };
    private final com.baidu.tieba.im.chat.a.b iTQ = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.7
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            OfficialBarTipActivity.this.crx();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (OfficialBarTipActivity.this.iTM != null) {
                OfficialBarTipActivity.this.iTM.setPercent(i);
            }
            OfficialBarTipActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            OfficialBarTipActivity.this.zA();
            OfficialBarTipActivity.this.showToast(R.string.delete_success, false);
            OfficialBarTipActivity.this.cry();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            OfficialBarTipActivity.this.zA();
            OfficialBarTipActivity.this.cry();
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.iTN);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.iTN);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.iTN);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.iTN);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.iTN);
        registerListener(this.iTO);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.iTK.crA().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        zA();
        super.onDestroy();
    }

    private void initData() {
        this.iTJ = new OfficialBarTipModel(getPageContext());
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
        this.iTK = new g(this);
        this.iTK.crz().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ImMessageCenterShowItemData ys = OfficialBarTipActivity.this.iTK.crA().getItem(i);
                if (ys != null && view != null) {
                    ImMessageCenterShowItemData imMessageCenterShowItemData = ys;
                    if (OfficialBarTipActivity.this.iTK.crA().cri()) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.select_status);
                        if (imMessageCenterShowItemData.isSelected()) {
                            imMessageCenterShowItemData.setSelected(false);
                            ao.setBackgroundColor(view, R.color.cp_bg_line_d);
                            ao.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_n);
                            if (!OfficialBarTipActivity.this.cru()) {
                                OfficialBarTipActivity.this.iTK.pG(false);
                                return;
                            }
                            return;
                        }
                        imMessageCenterShowItemData.setSelected(true);
                        ao.setBackgroundColor(view, R.color.cp_bg_line_e);
                        ao.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_s);
                        OfficialBarTipActivity.this.iTK.pF(true);
                        return;
                    }
                    try {
                        RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_V_MREAD, Long.parseLong(imMessageCenterShowItemData.getFriendId()) + "");
                        TiebaStatic.log("c12936");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SingleForumBroadcastFeedActivityConfig(OfficialBarTipActivity.this.getActivity(), imMessageCenterShowItemData.getFriendId(), imMessageCenterShowItemData.getFriendName())));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        this.iTK.crz().setOnItemLongClickListener(new AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity$2  reason: invalid class name */
    /* loaded from: classes20.dex */
    public class AnonymousClass2 implements AdapterView.OnItemLongClickListener {
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            ImMessageCenterShowItemData ys = OfficialBarTipActivity.this.iTK.crA().getItem(i);
            if (ys != null) {
                final ImMessageCenterShowItemData imMessageCenterShowItemData = ys;
                if (OfficialBarTipActivity.this.iTK.crA().cri()) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.select_status);
                    if (imMessageCenterShowItemData.isSelected()) {
                        imMessageCenterShowItemData.setSelected(false);
                        ao.setBackgroundColor(view, R.color.cp_bg_line_d);
                        ao.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_n);
                        if (!OfficialBarTipActivity.this.cru()) {
                            OfficialBarTipActivity.this.iTK.pF(false);
                        }
                    } else {
                        imMessageCenterShowItemData.setSelected(true);
                        ao.setBackgroundColor(view, R.color.cp_bg_line_e);
                        ao.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_s);
                        OfficialBarTipActivity.this.iTK.pF(true);
                    }
                } else {
                    String[] strArr = {TbadkCoreApplication.getInst().getString(R.string.delete_user_chat), TbadkCoreApplication.getInst().getString(R.string.cancel_subscribe)};
                    final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(OfficialBarTipActivity.this.getPageContext());
                    iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1
                        @Override // com.baidu.tbadk.core.dialog.k.c
                        public void a(k kVar, int i2, View view2) {
                            if (iVar != null && iVar.isShowing()) {
                                iVar.dismiss();
                            }
                            if (i2 == 0) {
                                OfficialBarTipActivity.this.iTJ.asyncDeleteItem(imMessageCenterShowItemData, OfficialBarTipActivity.this.iTQ);
                                return;
                            }
                            com.baidu.tbadk.core.dialog.a a = com.baidu.tbadk.coreExtra.c.a.a(OfficialBarTipActivity.this.getPageContext(), -1, R.string.make_sure_cancel_subscribe, R.string.confirm, R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                    OfficialBarTipActivity.this.iTJ.subscribeBar(false, imMessageCenterShowItemData.getFriendId());
                                    OfficialBarTipActivity.this.iTL = imMessageCenterShowItemData;
                                }
                            }, new a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                }
                            });
                            a.setMessageShowCenter(true);
                            a.aYL();
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
        this.iTK.onChangeSkinType(i);
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
                if (this.iTJ != null) {
                    this.iTJ.insertOrUpdate(data, this.iTP);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.iTJ != null) {
                this.iTJ.remove(data, this.iTP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 2 && this.iTJ != null) {
                this.iTJ.setData(data, this.iTP);
            }
        }
    }

    public void updateEditStatus(boolean z) {
        this.iTJ.updateEditStatus(z);
        this.iTK.setData(this.iTJ.getData());
    }

    public void crt() {
        this.iTJ.deleteSelectedDatas(this.iTQ);
    }

    public boolean cru() {
        List<ImMessageCenterShowItemData> data = this.iTJ.getData();
        for (int i = 0; i != data.size(); i++) {
            if (data.get(i).isSelected()) {
                return true;
            }
        }
        return false;
    }

    public void crv() {
        List<ImMessageCenterShowItemData> data = this.iTJ.getData();
        for (int i = 0; i != data.size(); i++) {
            data.get(i).setUnReadCount(0);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.get(i).getFriendId(), 4)));
        }
        this.iTK.setData(this.iTJ.getData());
    }

    public boolean crw() {
        List<ImMessageCenterShowItemData> data = this.iTJ.getData();
        for (int i = 0; i != data.size(); i++) {
            if (data.get(i).getUnReadCount() != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh(final String str) {
        this.iTJ.asyncDeleteItem(this.iTL, this.iTQ);
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.cxs().A(TbadkApplication.getCurrentAccount(), String.valueOf(str), false);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crx() {
        zA();
        if (this.iTM == null) {
            this.iTM = com.baidu.tieba.im.db.e.cth().eZ(getPageContext().getPageActivity());
        }
        this.iTM.show();
        this.iTM.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA() {
        if (this.iTM != null && this.iTM.isShowing()) {
            this.iTM.dismiss();
            this.iTM = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.iTK != null && this.iTK.crA() != null) {
            this.iTK.crA().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cry() {
        if (this.iTK != null && this.iTK.crA() != null && this.iTJ != null) {
            if (this.iTJ != null && this.iTJ.isEmpty()) {
                finish();
            }
            new AddMsgRecordModel().req();
            this.iTK.setData(this.iTJ.getData());
        }
    }
}

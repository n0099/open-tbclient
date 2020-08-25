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
import com.baidu.tbadk.core.util.ap;
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
    private OfficialBarTipModel jiJ;
    private g jiK;
    private ImMessageCenterShowItemData jiL;
    private com.baidu.tbadk.core.dialog.d jiM;
    private final CustomMessageListener jiN = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.3
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
                    OfficialBarTipActivity.this.jiJ.setData(null, OfficialBarTipActivity.this.jiP);
                } else if (customResponsedMessage.getCmd() == 2016011 && OfficialBarTipActivity.this.jiK != null && OfficialBarTipActivity.this.jiK.cCs() != null) {
                    OfficialBarTipActivity.this.jiK.cCs().notifyDataSetChanged();
                }
            }
        }
    };
    private final com.baidu.adp.framework.listener.c jiO = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_UPDATE_MASK_INFO) { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.4
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
                            OfficialBarTipActivity.this.JZ(requestUpdateMaskInfoMessage.getList());
                        } else {
                            OfficialBarTipActivity.this.getPageContext().showToast(StringUtils.isNull(responseUpdateMaskInfoMessage.getErrorString()) ? OfficialBarTipActivity.this.getPageContext().getResources().getString(R.string.neterror) : responseUpdateMaskInfoMessage.getErrorString());
                        }
                    }
                }
            }
        }
    };
    private com.baidu.tieba.im.chat.a.a jiP = new com.baidu.tieba.im.chat.a.a() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.5
        @Override // com.baidu.tieba.im.chat.a.a
        public void onComplete() {
            OfficialBarTipActivity.this.cCq();
        }
    };
    private final com.baidu.tieba.im.chat.a.b jiQ = new com.baidu.tieba.im.chat.a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.7
        @Override // com.baidu.tieba.im.chat.a.b
        public void onPreExecute() {
            OfficialBarTipActivity.this.cCp();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (OfficialBarTipActivity.this.jiM != null) {
                OfficialBarTipActivity.this.jiM.setPercent(i);
            }
            OfficialBarTipActivity.this.notifyDataSetChanged();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onPostExecute() {
            OfficialBarTipActivity.this.Fd();
            OfficialBarTipActivity.this.showToast(R.string.delete_success, false);
            OfficialBarTipActivity.this.cCq();
        }

        @Override // com.baidu.tieba.im.chat.a.b
        public void onCanceled() {
            OfficialBarTipActivity.this.Fd();
            OfficialBarTipActivity.this.cCq();
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
        registerListener(CmdConfigCustom.MEMORY_CHANGED, this.jiN);
        registerListener(CmdConfigCustom.MEMORY_REQUEST_MEMORY_LIST, this.jiN);
        registerListener(CmdConfigCustom.MEMORY_CLEAR, this.jiN);
        registerListener(CmdConfigCustom.MEMORY_SETTING_CHANGE, this.jiN);
        registerListener(CmdConfigCustom.MEMORY_INIT_COMPLETED, this.jiN);
        registerListener(this.jiO);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jiK.cCs().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Fd();
        super.onDestroy();
    }

    private void initData() {
        this.jiJ = new OfficialBarTipModel(getPageContext());
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
        this.jiK = new g(this);
        this.jiK.cCr().setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ImMessageCenterShowItemData AM = OfficialBarTipActivity.this.jiK.cCs().getItem(i);
                if (AM != null && view != null) {
                    ImMessageCenterShowItemData imMessageCenterShowItemData = AM;
                    if (OfficialBarTipActivity.this.jiK.cCs().cCa()) {
                        ImageView imageView = (ImageView) view.findViewById(R.id.select_status);
                        if (imMessageCenterShowItemData.isSelected()) {
                            imMessageCenterShowItemData.setSelected(false);
                            ap.setBackgroundColor(view, R.color.cp_bg_line_d);
                            ap.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_n);
                            if (!OfficialBarTipActivity.this.cCm()) {
                                OfficialBarTipActivity.this.jiK.qm(false);
                                return;
                            }
                            return;
                        }
                        imMessageCenterShowItemData.setSelected(true);
                        ap.setBackgroundColor(view, R.color.cp_bg_line_e);
                        ap.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_s);
                        OfficialBarTipActivity.this.jiK.ql(true);
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
        this.jiK.cCr().setOnItemLongClickListener(new AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity$2  reason: invalid class name */
    /* loaded from: classes20.dex */
    public class AnonymousClass2 implements AdapterView.OnItemLongClickListener {
        AnonymousClass2() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            ImMessageCenterShowItemData AM = OfficialBarTipActivity.this.jiK.cCs().getItem(i);
            if (AM != null) {
                final ImMessageCenterShowItemData imMessageCenterShowItemData = AM;
                if (OfficialBarTipActivity.this.jiK.cCs().cCa()) {
                    ImageView imageView = (ImageView) view.findViewById(R.id.select_status);
                    if (imMessageCenterShowItemData.isSelected()) {
                        imMessageCenterShowItemData.setSelected(false);
                        ap.setBackgroundColor(view, R.color.cp_bg_line_d);
                        ap.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_n);
                        if (!OfficialBarTipActivity.this.cCm()) {
                            OfficialBarTipActivity.this.jiK.ql(false);
                        }
                    } else {
                        imMessageCenterShowItemData.setSelected(true);
                        ap.setBackgroundColor(view, R.color.cp_bg_line_e);
                        ap.setBackgroundResource(imageView, R.drawable.btn_bgb_choice_s);
                        OfficialBarTipActivity.this.jiK.ql(true);
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
                                OfficialBarTipActivity.this.jiJ.asyncDeleteItem(imMessageCenterShowItemData, OfficialBarTipActivity.this.jiQ);
                                return;
                            }
                            com.baidu.tbadk.core.dialog.a a = com.baidu.tbadk.coreExtra.c.a.a(OfficialBarTipActivity.this.getPageContext(), -1, R.string.make_sure_cancel_subscribe, R.string.confirm, R.string.cancel, new a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1.1
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                    OfficialBarTipActivity.this.jiJ.subscribeBar(false, imMessageCenterShowItemData.getFriendId());
                                    OfficialBarTipActivity.this.jiL = imMessageCenterShowItemData;
                                }
                            }, new a.b() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.2.1.2
                                @Override // com.baidu.tbadk.core.dialog.a.b
                                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                                    aVar.dismiss();
                                }
                            });
                            a.setMessageShowCenter(true);
                            a.bhg();
                        }
                    });
                    iVar.Nv();
                }
            }
            return true;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.jiK.onChangeSkinType(i);
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
                if (this.jiJ != null) {
                    this.jiJ.insertOrUpdate(data, this.jiP);
                }
            } else if (memoryChangedMessage.getType() == 2 && this.jiJ != null) {
                this.jiJ.remove(data, this.jiP);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() == 2 && this.jiJ != null) {
                this.jiJ.setData(data, this.jiP);
            }
        }
    }

    public void updateEditStatus(boolean z) {
        this.jiJ.updateEditStatus(z);
        this.jiK.setData(this.jiJ.getData());
    }

    public void cCl() {
        this.jiJ.deleteSelectedDatas(this.jiQ);
    }

    public boolean cCm() {
        List<ImMessageCenterShowItemData> data = this.jiJ.getData();
        for (int i = 0; i != data.size(); i++) {
            if (data.get(i).isSelected()) {
                return true;
            }
        }
        return false;
    }

    public void cCn() {
        List<ImMessageCenterShowItemData> data = this.jiJ.getData();
        for (int i = 0; i != data.size(); i++) {
            data.get(i).setUnReadCount(0);
            MessageManager.getInstance().dispatchResponsedMessage(new MemoryClearUnreadCountMessage(new MemoryClearUnreadCountMessage.a(data.get(i).getFriendId(), 4)));
        }
        this.jiK.setData(this.jiJ.getData());
    }

    public boolean cCo() {
        List<ImMessageCenterShowItemData> data = this.jiJ.getData();
        for (int i = 0; i != data.size(); i++) {
            if (data.get(i).getUnReadCount() != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JZ(final String str) {
        this.jiJ.asyncDeleteItem(this.jiL, this.jiQ);
        new BdAsyncTask<Void, Void, Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity.6
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tieba.im.settingcache.d.cIj().z(TbadkApplication.getCurrentAccount(), String.valueOf(str), false);
                }
                return null;
            }
        }.execute(new Void[0]);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCp() {
        Fd();
        if (this.jiM == null) {
            this.jiM = com.baidu.tieba.im.db.e.cDY().fl(getPageContext().getPageActivity());
        }
        this.jiM.show();
        this.jiM.setPercent(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fd() {
        if (this.jiM != null && this.jiM.isShowing()) {
            this.jiM.dismiss();
            this.jiM = null;
        }
        closeLoadingDialog();
        dismissAllDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDataSetChanged() {
        if (this.jiK != null && this.jiK.cCs() != null) {
            this.jiK.cCs().notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCq() {
        if (this.jiK != null && this.jiK.cCs() != null && this.jiJ != null) {
            if (this.jiJ != null && this.jiJ.isEmpty()) {
                finish();
            }
            new AddMsgRecordModel().req();
            this.jiK.setData(this.jiJ.getData());
        }
    }
}

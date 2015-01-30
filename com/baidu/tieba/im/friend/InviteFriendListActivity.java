package com.baidu.tieba.im.friend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tieba.z;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class InviteFriendListActivity extends BaseActivity<InviteFriendListActivity> implements View.OnClickListener, AdapterView.OnItemClickListener {
    private s bbH;
    private x bbI;
    private boolean bbL;
    private boolean isFromInviteChat;
    public List<com.baidu.tbadk.coreExtra.relationship.b> bbJ = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.b> bbK = new LinkedList<>();
    private final AtomicBoolean bbM = new AtomicBoolean(false);
    private CustomMessageListener bbN = new k(this, 2001188);
    private final com.baidu.adp.framework.listener.e mListener = new l(this, 205002);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(InviteFriendListActivityConfig.class, InviteFriendListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.bbN);
        Intent intent = getIntent();
        Df();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bbI.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bbI.initWithBundle(bundle);
        }
        initView();
        Ed();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bbI.j(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bbI.cancelLoadData();
    }

    private void Df() {
        this.bbI = new x(this);
    }

    private void initView() {
        this.bbH = new s(this, this.isFromInviteChat);
        this.bbH.fU(100);
        this.bbH.a(new n(this));
    }

    private void Ed() {
        OM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OM() {
        String trim;
        if (!isFinishing()) {
            if (this.bbJ == null) {
                if (!this.bbM.get()) {
                    this.bbM.set(true);
                    OC();
                    this.bbH.startLoad();
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String searchText = this.bbH.getSearchText();
            if (searchText == null) {
                trim = "";
            } else {
                trim = searchText.trim();
            }
            if (this.bbJ.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(z.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.bbL = false;
                this.bbH.a(this.bbJ, false);
                return;
            }
            this.bbK.clear();
            for (com.baidu.tbadk.coreExtra.relationship.b bVar : this.bbJ) {
                String tm = bVar.tm();
                if (tm != null && tm.contains(trim)) {
                    this.bbK.add(bVar);
                }
            }
            this.bbL = true;
            this.bbH.a((List<com.baidu.tbadk.coreExtra.relationship.b>) this.bbK, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bbH != null) {
            this.bbH.OT();
            if (view.getId() == this.bbH.OP()) {
                OC();
                this.bbI.gM(this.bbH.OQ());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.bbL) {
                if (this.bbK != null && i < this.bbK.size()) {
                    bVar = this.bbK.get(i);
                }
                bVar = null;
            } else {
                if (this.bbJ != null && i < this.bbJ.size()) {
                    bVar = this.bbJ.get(i);
                }
                bVar = null;
            }
            if (bVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), bVar.getUserId(), bVar.getUserName(), bVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof q)) {
            TbCheckBox tbCheckBox = ((q) tag).bbU;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    public void OC() {
        showLoadingDialog(null, new o(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bbH.qL();
    }
}

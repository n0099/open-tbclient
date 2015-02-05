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
    private s bbG;
    private x bbH;
    private boolean bbK;
    private boolean isFromInviteChat;
    public List<com.baidu.tbadk.coreExtra.relationship.b> bbI = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.b> bbJ = new LinkedList<>();
    private final AtomicBoolean bbL = new AtomicBoolean(false);
    private CustomMessageListener bbM = new k(this, 2001188);
    private final com.baidu.adp.framework.listener.e mListener = new l(this, 205002);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(InviteFriendListActivityConfig.class, InviteFriendListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.bbM);
        Intent intent = getIntent();
        CZ();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bbH.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bbH.initWithBundle(bundle);
        }
        initView();
        DX();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bbH.j(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bbH.cancelLoadData();
    }

    private void CZ() {
        this.bbH = new x(this);
    }

    private void initView() {
        this.bbG = new s(this, this.isFromInviteChat);
        this.bbG.fU(100);
        this.bbG.a(new n(this));
    }

    private void DX() {
        OH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OH() {
        String trim;
        if (!isFinishing()) {
            if (this.bbI == null) {
                if (!this.bbL.get()) {
                    this.bbL.set(true);
                    Ox();
                    this.bbG.startLoad();
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String searchText = this.bbG.getSearchText();
            if (searchText == null) {
                trim = "";
            } else {
                trim = searchText.trim();
            }
            if (this.bbI.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(z.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.bbK = false;
                this.bbG.a(this.bbI, false);
                return;
            }
            this.bbJ.clear();
            for (com.baidu.tbadk.coreExtra.relationship.b bVar : this.bbI) {
                String tg = bVar.tg();
                if (tg != null && tg.contains(trim)) {
                    this.bbJ.add(bVar);
                }
            }
            this.bbK = true;
            this.bbG.a((List<com.baidu.tbadk.coreExtra.relationship.b>) this.bbJ, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bbG != null) {
            this.bbG.OO();
            if (view.getId() == this.bbG.OK()) {
                Ox();
                this.bbH.gJ(this.bbG.OL());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.bbK) {
                if (this.bbJ != null && i < this.bbJ.size()) {
                    bVar = this.bbJ.get(i);
                }
                bVar = null;
            } else {
                if (this.bbI != null && i < this.bbI.size()) {
                    bVar = this.bbI.get(i);
                }
                bVar = null;
            }
            if (bVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), bVar.getUserId(), bVar.getUserName(), bVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof q)) {
            TbCheckBox tbCheckBox = ((q) tag).bbT;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    public void Ox() {
        showLoadingDialog(null, new o(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bbG.qF();
    }
}

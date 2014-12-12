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
    private s bak;
    private x bal;
    private boolean bao;
    private boolean isFromInviteChat;
    public List<com.baidu.tbadk.coreExtra.relationship.b> bam = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.b> ban = new LinkedList<>();
    private final AtomicBoolean bap = new AtomicBoolean(false);
    private CustomMessageListener baq = new k(this, 2001188);
    private final com.baidu.adp.framework.listener.e mListener = new l(this, 205002);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(InviteFriendListActivityConfig.class, InviteFriendListActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.mListener);
        registerListener(this.baq);
        Intent intent = getIntent();
        CG();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bal.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.bal.initWithBundle(bundle);
        }
        initView();
        DE();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.bal.j(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bal.cancelLoadData();
    }

    private void CG() {
        this.bal = new x(this);
    }

    private void initView() {
        this.bak = new s(this, this.isFromInviteChat);
        this.bak.fP(100);
        this.bak.a(new n(this));
    }

    private void DE() {
        Oq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oq() {
        String trim;
        if (!isFinishing()) {
            if (this.bam == null) {
                if (!this.bap.get()) {
                    this.bap.set(true);
                    Og();
                    this.bak.startLoad();
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String searchText = this.bak.getSearchText();
            if (searchText == null) {
                trim = "";
            } else {
                trim = searchText.trim();
            }
            if (this.bam.isEmpty() && trim.length() > 0) {
                showToast(getPageContext().getString(z.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.bao = false;
                this.bak.a(this.bam, false);
                return;
            }
            this.ban.clear();
            for (com.baidu.tbadk.coreExtra.relationship.b bVar : this.bam) {
                String sV = bVar.sV();
                if (sV != null && sV.contains(trim)) {
                    this.ban.add(bVar);
                }
            }
            this.bao = true;
            this.bak.a((List<com.baidu.tbadk.coreExtra.relationship.b>) this.ban, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bak != null) {
            this.bak.hideKeyboard();
            if (view.getId() == this.bak.Ot()) {
                Og();
                this.bal.gH(this.bak.Ou());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.bao) {
                if (this.ban != null && i < this.ban.size()) {
                    bVar = this.ban.get(i);
                }
                bVar = null;
            } else {
                if (this.bam != null && i < this.bam.size()) {
                    bVar = this.bam.get(i);
                }
                bVar = null;
            }
            if (bVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), bVar.getUserId(), bVar.getUserName(), bVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof q)) {
            TbCheckBox tbCheckBox = ((q) tag).baz;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    public void Og() {
        showLoadingDialog(null, new o(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bak.qA();
    }
}

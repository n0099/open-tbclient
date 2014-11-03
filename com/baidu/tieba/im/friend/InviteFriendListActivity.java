package com.baidu.tieba.im.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.InviteFriendListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.coreExtra.relationship.GetContactListRequestMessage;
import com.baidu.tieba.y;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class InviteFriendListActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private s aVU;
    private x aVV;
    private boolean aVY;
    private boolean isFromInviteChat;
    public List<com.baidu.tbadk.coreExtra.relationship.b> aVW = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.b> aVX = new LinkedList<>();
    private final AtomicBoolean aVZ = new AtomicBoolean(false);
    private CustomMessageListener aWa = new k(this, 2001188);
    private final com.baidu.adp.framework.listener.e ayS = new l(this, 205002);

    static {
        TbadkApplication.m251getInst().RegisterIntent(InviteFriendListActivityConfig.class, InviteFriendListActivity.class);
    }

    public static void a(Context context, int i, int i2) {
        Intent intent = new Intent(context, InviteFriendListActivity.class);
        intent.putExtra("gid", i);
        intent.putExtra("groupid", i2);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.ayS);
        registerListener(this.aWa);
        Intent intent = getIntent();
        Ef();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.aVV.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.aVV.initWithBundle(bundle);
        }
        nu();
        yj();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.aVV.i(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aVV.cancelLoadData();
    }

    private void Ef() {
        this.aVV = new x(this);
    }

    private void nu() {
        this.aVU = new s(this, this.isFromInviteChat);
        this.aVU.fD(100);
        this.aVU.a(new n(this));
    }

    private void yj() {
        Nf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nf() {
        String trim;
        if (!isFinishing()) {
            if (this.aVW == null) {
                if (!this.aVZ.get()) {
                    this.aVZ.set(true);
                    MW();
                    this.aVU.Nn();
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String searchText = this.aVU.getSearchText();
            if (searchText == null) {
                trim = "";
            } else {
                trim = searchText.trim();
            }
            if (this.aVW.isEmpty() && trim.length() > 0) {
                showToast(getString(y.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.aVY = false;
                this.aVU.a(this.aVW, false);
                return;
            }
            this.aVX.clear();
            for (com.baidu.tbadk.coreExtra.relationship.b bVar : this.aVW) {
                String pB = bVar.pB();
                if (pB != null && pB.contains(trim)) {
                    this.aVX.add(bVar);
                }
            }
            this.aVY = true;
            this.aVU.a((List<com.baidu.tbadk.coreExtra.relationship.b>) this.aVX, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aVU != null) {
            this.aVU.Nm();
            if (view.getId() == this.aVU.Ni()) {
                MW();
                this.aVV.gd(this.aVU.Nj());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.aVY) {
                if (this.aVX != null && i < this.aVX.size()) {
                    bVar = this.aVX.get(i);
                }
                bVar = null;
            } else {
                if (this.aVW != null && i < this.aVW.size()) {
                    bVar = this.aVW.get(i);
                }
                bVar = null;
            }
            if (bVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, bVar.getUserId(), bVar.getUserName(), bVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof q)) {
            TbCheckBox tbCheckBox = ((q) tag).aWh;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    public void MW() {
        showLoadingDialog(null, new o(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.aVU.nz();
    }
}

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
    private s aVG;
    private x aVH;
    private boolean aVK;
    private boolean isFromInviteChat;
    public List<com.baidu.tbadk.coreExtra.relationship.b> aVI = null;
    private LinkedList<com.baidu.tbadk.coreExtra.relationship.b> aVJ = new LinkedList<>();
    private final AtomicBoolean aVL = new AtomicBoolean(false);
    private CustomMessageListener aVM = new k(this, 2001188);
    private final com.baidu.adp.framework.listener.e ayJ = new l(this, 205002);

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
        registerListener(this.ayJ);
        registerListener(this.aVM);
        Intent intent = getIntent();
        Ed();
        if (intent != null) {
            this.isFromInviteChat = intent.getBooleanExtra(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.aVH.initWithIntent(intent);
        } else {
            this.isFromInviteChat = bundle.getBoolean(InviteFriendListActivityConfig.IS_FROM_INVITE_CHAT, false);
            this.aVH.initWithBundle(bundle);
        }
        nu();
        yh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.aVH.i(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.aVH.cancelLoadData();
    }

    private void Ed() {
        this.aVH = new x(this);
    }

    private void nu() {
        this.aVG = new s(this, this.isFromInviteChat);
        this.aVG.fD(100);
        this.aVG.a(new n(this));
    }

    private void yh() {
        Nb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nb() {
        String trim;
        if (!isFinishing()) {
            if (this.aVI == null) {
                if (!this.aVL.get()) {
                    this.aVL.set(true);
                    MS();
                    this.aVG.Nj();
                    super.sendMessage(new GetContactListRequestMessage());
                    return;
                }
                return;
            }
            String searchText = this.aVG.getSearchText();
            if (searchText == null) {
                trim = "";
            } else {
                trim = searchText.trim();
            }
            if (this.aVI.isEmpty() && trim.length() > 0) {
                showToast(getString(y.invite_friend_no_data_now));
            }
            if (trim.length() == 0) {
                this.aVK = false;
                this.aVG.a(this.aVI, false);
                return;
            }
            this.aVJ.clear();
            for (com.baidu.tbadk.coreExtra.relationship.b bVar : this.aVI) {
                String pz = bVar.pz();
                if (pz != null && pz.contains(trim)) {
                    this.aVJ.add(bVar);
                }
            }
            this.aVK = true;
            this.aVG.a((List<com.baidu.tbadk.coreExtra.relationship.b>) this.aVJ, true);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aVG != null) {
            this.aVG.Ni();
            if (view.getId() == this.aVG.Ne()) {
                MS();
                this.aVH.gd(this.aVG.Nf());
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object tag;
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        super.onItemClick(adapterView, view, i, j);
        if (this.isFromInviteChat) {
            if (this.aVK) {
                if (this.aVJ != null && i < this.aVJ.size()) {
                    bVar = this.aVJ.get(i);
                }
                bVar = null;
            } else {
                if (this.aVI != null && i < this.aVI.size()) {
                    bVar = this.aVI.get(i);
                }
                bVar = null;
            }
            if (bVar != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this, bVar.getUserId(), bVar.getUserName(), bVar.getUserPortrait(), 0)));
            }
        } else if (view != null && (tag = view.getTag()) != null && (tag instanceof q)) {
            TbCheckBox tbCheckBox = ((q) tag).aVT;
            tbCheckBox.setChecked(tbCheckBox.isChecked() ? false : true);
        }
    }

    public void MS() {
        showLoadingDialog(null, new o(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.aVG.nz();
    }
}

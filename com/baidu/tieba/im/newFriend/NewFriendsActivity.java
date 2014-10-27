package com.baidu.tieba.im.newFriend;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.newFriends.NewFriendsActivityConfig;
/* loaded from: classes.dex */
public class NewFriendsActivity extends BaseActivity {
    private az bgS;
    private AlertDialog bgT;
    private String bgR = "recommend_new_friend" + TbadkApplication.getCurrentAccount();
    private aj bgU = new al(this);
    final CustomMessageListener bgV = new aq(this, 2001178);
    final com.baidu.adp.framework.listener.e bgW = new ar(this, 304101);
    private final com.baidu.adp.widget.ListView.f aQz = new as(this);
    private final ba bgX = new ba(this, new at(this));

    static {
        TbadkApplication.m251getInst().RegisterIntent(NewFriendsActivityConfig.class, NewFriendsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rg() {
        com.baidu.tieba.im.e.a(new au(this), new av(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.new_friend_activity);
        this.bgS = new az(this);
        this.bgS.a(this.aQz);
        this.bgS.a(this.bgU);
        registerListener(this.bgV);
        registerListener(this.bgW);
        if (TbadkSettings.getInst().loadBoolean(this.bgR, false)) {
            Rh();
            this.bgS.hO();
            return;
        }
        this.bgX.setUniqueId(getUniqueId());
        this.bgX.registerListener();
        this.bgX.xD();
        this.bgS.hO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bgS.a(getLayoutMode(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rh() {
        com.baidu.tieba.im.e.a(new aw(this), new ax(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ri() {
        com.baidu.tieba.im.e.a(new am(this), new an(this));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.new_friend_textview_container) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(this)));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.e item = this.bgS.Rl().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.e)) {
            com.baidu.tieba.im.data.e eVar = item;
            if (i == j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this, String.valueOf(eVar.getId()), eVar.getName())));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.e item = this.bgS.Rl().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.e)) {
            com.baidu.tieba.im.data.e eVar = item;
            if (this.bgT == null) {
                this.bgT = Rj();
            }
            ay ayVar = new ay(this, eVar);
            this.bgT.setButton(-1, getString(com.baidu.tieba.y.confirm), ayVar);
            this.bgT.setButton(-2, getString(com.baidu.tieba.y.cancel), ayVar);
            com.baidu.adp.lib.g.j.a(this.bgT, this);
            return true;
        }
        return true;
    }

    private AlertDialog Rj() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(com.baidu.tieba.y.operation);
        builder.setMessage(com.baidu.tieba.y.delete);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.im.data.e eVar) {
        if (eVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(this, String.valueOf(eVar.getId()), eVar.getName(), eVar.getPortrait(), "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.im.data.e eVar) {
        com.baidu.tbadk.newFriends.a.un().c(eVar.getId(), AddFriendActivityConfig.TYPE_NEW_FRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.baidu.tieba.im.data.e eVar) {
        com.baidu.tieba.im.e.a(new ao(this, eVar), new ap(this, eVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bgT != null) {
            com.baidu.adp.lib.g.j.b(this.bgT, this);
        }
    }
}

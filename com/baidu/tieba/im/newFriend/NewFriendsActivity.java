package com.baidu.tieba.im.newFriend;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.newFriends.NewFriendsActivityConfig;
/* loaded from: classes.dex */
public class NewFriendsActivity extends BaseActivity<NewFriendsActivity> {
    private az bjY;
    private AlertDialog bjZ;
    private String bjX = "recommend_new_friend" + TbadkCoreApplication.getCurrentAccount();
    private aj bka = new al(this);
    final CustomMessageListener bkb = new aq(this, 2001178);
    final com.baidu.adp.framework.listener.e bkc = new ar(this, 304101);
    private final com.baidu.adp.widget.ListView.g aSr = new as(this);
    private final ba bkd = new ba(this, new at(this));

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(NewFriendsActivityConfig.class, NewFriendsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RD() {
        com.baidu.tieba.im.i.a(new au(this), new av(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.new_friend_activity);
        this.bjY = new az(this);
        this.bjY.a(this.aSr);
        this.bjY.a(this.bka);
        registerListener(this.bkb);
        registerListener(this.bkc);
        if (TbadkSettings.getInst().loadBoolean(this.bjX, false)) {
            RE();
            this.bjY.jK();
            return;
        }
        this.bkd.setUniqueId(getUniqueId());
        this.bkd.registerListener();
        this.bkd.AY();
        this.bjY.jK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bjY.changeSkinType(getLayoutMode(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RE() {
        com.baidu.tieba.im.i.a(new aw(this), new ax(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RF() {
        com.baidu.tieba.im.i.a(new am(this), new an(this));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.w.new_friend_textview_container) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.b item = this.bjY.RI().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.b)) {
            com.baidu.tieba.im.data.b bVar = item;
            if (i == j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(bVar.getId()), bVar.getName())));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.b item = this.bjY.RI().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.b)) {
            com.baidu.tieba.im.data.b bVar = item;
            if (this.bjZ == null) {
                this.bjZ = RG();
            }
            ay ayVar = new ay(this, bVar);
            this.bjZ.setButton(-1, getPageContext().getString(com.baidu.tieba.z.confirm), ayVar);
            this.bjZ.setButton(-2, getPageContext().getString(com.baidu.tieba.z.cancel), ayVar);
            com.baidu.adp.lib.g.k.a(this.bjZ, getPageContext());
            return true;
        }
        return true;
    }

    private AlertDialog RG() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder.setTitle(com.baidu.tieba.z.operation);
        builder.setMessage(com.baidu.tieba.z.delete);
        AlertDialog create = builder.create();
        create.setCanceledOnTouchOutside(true);
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), String.valueOf(bVar.getId()), bVar.getName(), bVar.getPortrait(), "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(com.baidu.tieba.im.data.b bVar) {
        com.baidu.tbadk.newFriends.a.yC().c(bVar.getId(), AddFriendActivityConfig.TYPE_NEW_FRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tieba.im.data.b bVar) {
        com.baidu.tieba.im.i.a(new ao(this, bVar), new ap(this, bVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bjZ != null) {
            com.baidu.adp.lib.g.k.b(this.bjZ, getPageContext());
        }
    }
}

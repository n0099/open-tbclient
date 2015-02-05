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
    private az blu;
    private AlertDialog blv;
    private String blt = "recommend_new_friend" + TbadkCoreApplication.getCurrentAccount();
    private aj blw = new al(this);
    final CustomMessageListener blx = new aq(this, 2001178);
    final com.baidu.adp.framework.listener.e bly = new ar(this, 304101);
    private final com.baidu.adp.widget.ListView.g aTA = new as(this);
    private final ba blz = new ba(this, new at(this));

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(NewFriendsActivityConfig.class, NewFriendsActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RU() {
        com.baidu.tieba.im.i.a(new au(this), new av(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.new_friend_activity);
        this.blu = new az(this);
        this.blu.a(this.aTA);
        this.blu.a(this.blw);
        registerListener(this.blx);
        registerListener(this.bly);
        if (TbadkSettings.getInst().loadBoolean(this.blt, false)) {
            RV();
            this.blu.jC();
            return;
        }
        this.blz.setUniqueId(getUniqueId());
        this.blz.registerListener();
        this.blz.Bs();
        this.blu.jC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.blu.changeSkinType(getLayoutMode(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RV() {
        com.baidu.tieba.im.i.a(new aw(this), new ax(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RW() {
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
        com.baidu.tieba.im.data.b item = this.blu.RZ().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.b)) {
            com.baidu.tieba.im.data.b bVar = item;
            if (i == j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(bVar.getId()), bVar.getName())));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.b item = this.blu.RZ().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.b)) {
            com.baidu.tieba.im.data.b bVar = item;
            if (this.blv == null) {
                this.blv = RX();
            }
            ay ayVar = new ay(this, bVar);
            this.blv.setButton(-1, getPageContext().getString(com.baidu.tieba.z.confirm), ayVar);
            this.blv.setButton(-2, getPageContext().getString(com.baidu.tieba.z.cancel), ayVar);
            com.baidu.adp.lib.g.k.a(this.blv, getPageContext());
            return true;
        }
        return true;
    }

    private AlertDialog RX() {
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
        com.baidu.tbadk.newFriends.a.yM().c(bVar.getId(), AddFriendActivityConfig.TYPE_NEW_FRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tieba.im.data.b bVar) {
        com.baidu.tieba.im.i.a(new ao(this, bVar), new ap(this, bVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.blv != null) {
            com.baidu.adp.lib.g.k.b(this.blv, getPageContext());
        }
    }
}

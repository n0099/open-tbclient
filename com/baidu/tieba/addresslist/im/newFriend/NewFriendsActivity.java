package com.baidu.tieba.addresslist.im.newFriend;

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
/* loaded from: classes.dex */
public class NewFriendsActivity extends BaseActivity<NewFriendsActivity> {
    private bb ays;
    private com.baidu.tbadk.core.dialog.e ayt;
    private String ayr = "recommend_new_friend" + TbadkCoreApplication.getCurrentAccount();
    private ak ayu = new am(this);
    final CustomMessageListener ayv = new ar(this, 2001178);
    final com.baidu.adp.framework.listener.e ayw = new as(this, 304101);
    private final com.baidu.tbadk.core.view.ae ayx = new at(this);
    private final bc ayy = new bc(this, new au(this));

    /* JADX INFO: Access modifiers changed from: private */
    public void ET() {
        com.baidu.tieba.im.l.a(new av(this), new aw(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.new_friend_activity);
        this.ays = new bb(this);
        this.ays.a(this.ayx);
        this.ays.a(this.ayu);
        registerListener(this.ayv);
        registerListener(this.ayw);
        if (TbadkSettings.getInst().loadBoolean(this.ayr, false)) {
            EU();
            this.ays.mX();
            return;
        }
        this.ayy.setUniqueId(getUniqueId());
        this.ayy.registerListener();
        this.ayy.Fd();
        this.ays.mX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.ays.changeSkinType(getLayoutMode(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EU() {
        com.baidu.tieba.im.l.a(new ax(this), new ay(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EV() {
        com.baidu.tieba.im.l.a(new an(this), new ao(this));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.new_friend_textview_container) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.b item = this.ays.Fc().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.b)) {
            com.baidu.tieba.im.data.b bVar = item;
            if (i == j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(bVar.getId()), bVar.getName())));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.b item = this.ays.Fc().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.b)) {
            this.ayt = a(new az(this, item));
            this.ayt.d(getPageContext());
            this.ayt.rg();
            return true;
        }
        return true;
    }

    private com.baidu.tbadk.core.dialog.e a(az azVar) {
        com.baidu.tbadk.core.dialog.e eVar = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        eVar.by(com.baidu.tieba.y.operation);
        eVar.a(new String[]{getPageContext().getString(com.baidu.tieba.y.delete)}, azVar);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), String.valueOf(bVar.getId()), bVar.getName(), bVar.getPortrait(), "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.im.data.b bVar) {
        com.baidu.tbadk.newFriends.a.Ca().a(bVar.getId(), AddFriendActivityConfig.TYPE_NEW_FRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.im.data.b bVar) {
        com.baidu.tieba.im.l.a(new ap(this, bVar), new aq(this, bVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ayt != null) {
            this.ayt.dismiss();
        }
    }
}

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
    private bb ayA;
    private com.baidu.tbadk.core.dialog.e ayB;
    private String ayz = "recommend_new_friend" + TbadkCoreApplication.getCurrentAccount();
    private ak ayC = new am(this);
    final CustomMessageListener ayD = new ar(this, 2001178);
    final com.baidu.adp.framework.listener.e ayE = new as(this, 304101);
    private final com.baidu.tbadk.core.view.ae ayF = new at(this);
    private final bc ayG = new bc(this, new au(this));

    /* JADX INFO: Access modifiers changed from: private */
    public void EZ() {
        com.baidu.tieba.im.l.a(new av(this), new aw(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.new_friend_activity);
        this.ayA = new bb(this);
        this.ayA.a(this.ayF);
        this.ayA.a(this.ayC);
        registerListener(this.ayD);
        registerListener(this.ayE);
        if (TbadkSettings.getInst().loadBoolean(this.ayz, false)) {
            Fa();
            this.ayA.mX();
            return;
        }
        this.ayG.setUniqueId(getUniqueId());
        this.ayG.registerListener();
        this.ayG.Fj();
        this.ayA.mX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.ayA.changeSkinType(getLayoutMode(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fa() {
        com.baidu.tieba.im.l.a(new ax(this), new ay(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fb() {
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
        com.baidu.tieba.im.data.b item = this.ayA.Fi().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.b)) {
            com.baidu.tieba.im.data.b bVar = item;
            if (i == j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(bVar.getId()), bVar.getName())));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.b item = this.ayA.Fi().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.b)) {
            this.ayB = a(new az(this, item));
            this.ayB.d(getPageContext());
            this.ayB.rg();
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
        com.baidu.tbadk.newFriends.a.Cg().a(bVar.getId(), AddFriendActivityConfig.TYPE_NEW_FRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.im.data.b bVar) {
        com.baidu.tieba.im.l.a(new ap(this, bVar), new aq(this, bVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ayB != null) {
            this.ayB.dismiss();
        }
    }
}

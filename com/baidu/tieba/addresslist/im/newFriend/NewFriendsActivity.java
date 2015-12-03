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
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.addresslist.im.newFriend.ai;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class NewFriendsActivity extends BaseActivity<NewFriendsActivity> {
    private ax aIQ;
    private com.baidu.tbadk.core.dialog.c aIR;
    private String aIP = "recommend_new_friend" + TbadkCoreApplication.getCurrentAccount();
    private ai.b aIS = new aj(this);
    final CustomMessageListener aIT = new ao(this, CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL);
    final com.baidu.adp.framework.listener.e aIU = new ap(this, 304101);
    private final q.a aIV = new aq(this);
    private final ay aIW = new ay(this, new ar(this));

    /* JADX INFO: Access modifiers changed from: private */
    public void Hn() {
        com.baidu.tbadk.util.n.b(new as(this), new at(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.new_friend_activity);
        this.aIQ = new ax(this);
        this.aIQ.a(this.aIV);
        this.aIQ.a(this.aIS);
        registerListener(this.aIT);
        registerListener(this.aIU);
        if (TbadkSettings.getInst().loadBoolean(this.aIP, false)) {
            Ho();
            this.aIQ.nD();
            return;
        }
        this.aIW.setUniqueId(getUniqueId());
        this.aIW.registerListener();
        this.aIW.Hx();
        this.aIQ.nD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.aIQ.changeSkinType(getLayoutMode(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ho() {
        com.baidu.tbadk.util.n.b(new au(this), new av(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hp() {
        com.baidu.tbadk.util.n.b(new ak(this), new al(this));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == n.f.new_friend_textview_container) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.b item = this.aIQ.Hw().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.b)) {
            com.baidu.tieba.im.data.b bVar = item;
            if (i == j) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(bVar.getId()), bVar.getName())));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.b item = this.aIQ.Hw().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.b)) {
            this.aIR = a(new a(item));
            this.aIR.d(getPageContext());
            this.aIR.tz();
            return true;
        }
        return true;
    }

    /* loaded from: classes.dex */
    private class a implements c.b {
        private com.baidu.tieba.im.data.b aIY;

        public a(com.baidu.tieba.im.data.b bVar) {
            this.aIY = bVar;
        }

        @Override // com.baidu.tbadk.core.dialog.c.b
        public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
            cVar.dismiss();
            if (this.aIY == null) {
                return;
            }
            NewFriendsActivity.this.f(this.aIY);
        }
    }

    private com.baidu.tbadk.core.dialog.c a(a aVar) {
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bQ(n.i.operation);
        cVar.a(new String[]{getPageContext().getString(n.i.delete)}, aVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), String.valueOf(bVar.getId()), bVar.getName(), bVar.getPortrait(), "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.im.data.b bVar) {
        com.baidu.tbadk.newFriends.a.Ei().b(bVar.getId(), AddFriendActivityConfig.TYPE_NEW_FRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.im.data.b bVar) {
        com.baidu.tbadk.util.n.b(new am(this, bVar), new an(this, bVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.aIR != null) {
            this.aIR.dismiss();
        }
    }
}

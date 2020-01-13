package com.baidu.tieba.addresslist.im.newFriend;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel;
import com.baidu.tieba.addresslist.im.newFriend.a;
import java.util.List;
/* loaded from: classes6.dex */
public class NewFriendsActivity extends BaseActivity<NewFriendsActivity> {
    private c dXs;
    private com.baidu.tbadk.core.dialog.b dXt;
    private String dXr = "recommend_new_friend" + TbadkCoreApplication.getCurrentAccount();
    private a.b dXu = new a.b() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.1
        @Override // com.baidu.tieba.addresslist.im.newFriend.a.b
        public void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar) {
            if (aVar.getStatus() == 0) {
                NewFriendsActivity.this.d(aVar);
            } else if (aVar.getStatus() == 1) {
                NewFriendsActivity.this.e(aVar);
            }
        }
    };
    final CustomMessageListener dXv = new CustomMessageListener(CmdConfigCustom.CMD_NEW_FRIEND_ACTION_TO_UPDATE_UI_LOCAL) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                if (((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 1) {
                    NewFriendsActivity.this.aWs();
                } else {
                    NewFriendsActivity.this.aWu();
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c dXw = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_PASS_NEW_FRIEND) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponsePassFriendMessage responsePassFriendMessage;
            int error;
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof SocketResponsedMessage)) {
                NewFriendsActivity.this.showToast(R.string.neterror);
            } else if ((socketResponsedMessage instanceof ResponsePassFriendMessage) && (error = (responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage).getError()) != 0 && error != 3100098) {
                NewFriendsActivity.this.showToast(StringUtils.isNull(responsePassFriendMessage.getErrorString()) ? NewFriendsActivity.this.getResources().getString(R.string.neterror) : responsePassFriendMessage.getErrorString());
            }
        }
    };
    private final g.c dXx = new g.c() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.4
        @Override // com.baidu.tbadk.core.view.g.c
        public void onListPullRefresh(boolean z) {
            if (!z) {
                NewFriendsActivity.this.aWt();
            }
        }
    };
    private final RecommendFriendModel dXy = new RecommendFriendModel(this, new RecommendFriendModel.a() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.5
        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.a
        public void wW(String str) {
            NewFriendsActivity.this.aWt();
            TbadkSettings.getInst().saveBoolean(NewFriendsActivity.this.dXr, true);
        }

        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.a
        public void br(String str) {
            NewFriendsActivity.this.dXs.completePullRefresh();
            NewFriendsActivity.this.dXs.setData(null);
            BdToast.b(NewFriendsActivity.this.getPageContext().getPageActivity(), str);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public void aWs() {
        ac.b(new ab<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: aWv */
            public List<com.baidu.tieba.im.data.a> doInBackground() {
                return b.aWw().aWz();
            }
        }, new l<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: ba */
            public void onReturnDataInUI(List<com.baidu.tieba.im.data.a> list) {
                NewFriendsActivity.this.dXs.aWB().setData(list);
                NewFriendsActivity.this.dXs.aWB().notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_friend_activity);
        this.dXs = new c(this);
        this.dXs.setListPullRefreshListener(this.dXx);
        this.dXs.a(this.dXu);
        registerListener(this.dXv);
        registerListener(this.dXw);
        if (TbadkSettings.getInst().loadBoolean(this.dXr, false)) {
            aWt();
            this.dXs.startPullRefresh();
            return;
        }
        this.dXy.setUniqueId(getUniqueId());
        this.dXy.registerListener();
        this.dXy.aWC();
        this.dXs.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.dXs.a(getLayoutMode(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWt() {
        ac.b(new ab<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: aWv */
            public List<com.baidu.tieba.im.data.a> doInBackground() {
                b.aWw().aWy();
                return b.aWw().aWz();
            }
        }, new l<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: ba */
            public void onReturnDataInUI(List<com.baidu.tieba.im.data.a> list) {
                NewFriendsActivity.this.dXs.completePullRefresh();
                NewFriendsActivity.this.dXs.setData(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWu() {
        ac.b(new ab<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.ab
            /* renamed from: aWv */
            public List<com.baidu.tieba.im.data.a> doInBackground() {
                return b.aWw().aWA();
            }
        }, new l<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            /* renamed from: ba */
            public void onReturnDataInUI(List<com.baidu.tieba.im.data.a> list) {
                NewFriendsActivity.this.dXs.aZ(list);
            }
        });
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.new_friend_textview_container) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchFriendActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.a item = this.dXs.aWB().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.a)) {
            com.baidu.tieba.im.data.a aVar = item;
            if (i == j) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(aVar.getId()), aVar.getName())));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.a item = this.dXs.aWB().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.a)) {
            this.dXt = a(new a(item));
            this.dXt.d(getPageContext());
            this.dXt.aCq();
            return true;
        }
        return true;
    }

    /* loaded from: classes6.dex */
    private class a implements b.a {
        private com.baidu.tieba.im.data.a dXA;

        public a(com.baidu.tieba.im.data.a aVar) {
            this.dXA = aVar;
        }

        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (this.dXA != null) {
                NewFriendsActivity.this.f(this.dXA);
            }
        }
    }

    private com.baidu.tbadk.core.dialog.b a(a aVar) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.jJ(R.string.operation);
        bVar.a(new String[]{getPageContext().getString(R.string.delete)}, aVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.im.data.a aVar) {
        if (aVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getPageContext().getPageActivity(), String.valueOf(aVar.getId()), aVar.getName(), aVar.getPortrait(), "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.im.data.a aVar) {
        com.baidu.tbadk.newFriends.a.c(aVar.getId(), AddFriendActivityConfig.TYPE_NEW_FRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final com.baidu.tieba.im.data.a aVar) {
        ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ab
            public Boolean doInBackground() {
                return Boolean.valueOf(b.aWw().cp(aVar.getId()));
            }
        }, new l<Boolean>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
            public void onReturnDataInUI(Boolean bool) {
                if (bool.booleanValue()) {
                    NewFriendsActivity.this.dXs.a(aVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dXt != null) {
            this.dXt.dismiss();
        }
    }
}

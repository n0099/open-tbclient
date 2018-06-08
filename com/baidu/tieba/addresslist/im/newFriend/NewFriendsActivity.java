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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SearchFriendActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel;
import com.baidu.tieba.addresslist.im.newFriend.a;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes3.dex */
public class NewFriendsActivity extends BaseActivity<NewFriendsActivity> {
    private c bnm;
    private com.baidu.tbadk.core.dialog.b bnn;
    private String bnl = "recommend_new_friend" + TbadkCoreApplication.getCurrentAccount();
    private a.b bno = new a.b() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.1
        @Override // com.baidu.tieba.addresslist.im.newFriend.a.b
        public void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar) {
            if (aVar.getStatus() == 0) {
                NewFriendsActivity.this.d(aVar);
            } else if (aVar.getStatus() == 1) {
                NewFriendsActivity.this.e(aVar);
            }
        }
    };
    final CustomMessageListener bnp = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                if (((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 1) {
                    NewFriendsActivity.this.QP();
                } else {
                    NewFriendsActivity.this.QR();
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c bnq = new com.baidu.adp.framework.listener.c(304101) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponsePassFriendMessage responsePassFriendMessage;
            int error;
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof SocketResponsedMessage)) {
                NewFriendsActivity.this.showToast(d.k.neterror);
            } else if ((socketResponsedMessage instanceof ResponsePassFriendMessage) && (error = (responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage).getError()) != 0 && error != 3100098) {
                NewFriendsActivity.this.showToast(StringUtils.isNull(responsePassFriendMessage.getErrorString()) ? NewFriendsActivity.this.getResources().getString(d.k.neterror) : responsePassFriendMessage.getErrorString());
            }
        }
    };
    private final f.b bnr = new f.b() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void aS(boolean z) {
            if (!z) {
                NewFriendsActivity.this.QQ();
            }
        }
    };
    private final RecommendFriendModel bns = new RecommendFriendModel(this, new RecommendFriendModel.a() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.5
        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.a
        public void iQ(String str) {
            NewFriendsActivity.this.QQ();
            TbadkSettings.getInst().saveBoolean(NewFriendsActivity.this.bnl, true);
        }

        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.a
        public void onLoadFailed(String str) {
            NewFriendsActivity.this.bnm.completePullRefresh();
            NewFriendsActivity.this.bnm.setData(null);
            BdToast.a(NewFriendsActivity.this.getPageContext().getPageActivity(), str);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public void QP() {
        w.b(new v<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            public List<com.baidu.tieba.im.data.a> doInBackground() {
                return b.QS().QV();
            }
        }, new h<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(List<com.baidu.tieba.im.data.a> list) {
                NewFriendsActivity.this.bnm.QX().setData(list);
                NewFriendsActivity.this.bnm.QX().notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.new_friend_activity);
        this.bnm = new c(this);
        this.bnm.a(this.bnr);
        this.bnm.a(this.bno);
        registerListener(this.bnp);
        registerListener(this.bnq);
        if (TbadkSettings.getInst().loadBoolean(this.bnl, false)) {
            QQ();
            this.bnm.startPullRefresh();
            return;
        }
        this.bns.setUniqueId(getUniqueId());
        this.bns.registerListener();
        this.bns.QY();
        this.bnm.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bnm.a(getLayoutMode(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QQ() {
        w.b(new v<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            public List<com.baidu.tieba.im.data.a> doInBackground() {
                b.QS().QU();
                return b.QS().QV();
            }
        }, new h<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(List<com.baidu.tieba.im.data.a> list) {
                NewFriendsActivity.this.bnm.completePullRefresh();
                NewFriendsActivity.this.bnm.setData(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QR() {
        w.b(new v<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.v
            public List<com.baidu.tieba.im.data.a> doInBackground() {
                return b.QS().QW();
            }
        }, new h<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(List<com.baidu.tieba.im.data.a> list) {
                NewFriendsActivity.this.bnm.X(list);
            }
        });
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d.g.new_friend_textview_container) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.a item = this.bnm.QX().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.a)) {
            com.baidu.tieba.im.data.a aVar = item;
            if (i == j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(aVar.getId()), aVar.getName())));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.a item = this.bnm.QX().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.a)) {
            this.bnn = a(new a(item));
            this.bnn.d(getPageContext());
            this.bnn.xd();
            return true;
        }
        return true;
    }

    /* loaded from: classes3.dex */
    private class a implements b.InterfaceC0103b {
        private com.baidu.tieba.im.data.a bnu;

        public a(com.baidu.tieba.im.data.a aVar) {
            this.bnu = aVar;
        }

        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (this.bnu != null) {
                NewFriendsActivity.this.f(this.bnu);
            }
        }
    }

    private com.baidu.tbadk.core.dialog.b a(a aVar) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.cf(d.k.operation);
        bVar.a(new String[]{getPageContext().getString(d.k.delete)}, aVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.im.data.a aVar) {
        if (aVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), String.valueOf(aVar.getId()), aVar.getName(), aVar.getPortrait(), "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.im.data.a aVar) {
        com.baidu.tbadk.newFriends.a.c(aVar.getId(), AddFriendActivityConfig.TYPE_NEW_FRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final com.baidu.tieba.im.data.a aVar) {
        w.b(new v<Boolean>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.v
            public Boolean doInBackground() {
                return Boolean.valueOf(b.QS().aF(aVar.getId()));
            }
        }, new h<Boolean>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool.booleanValue()) {
                    NewFriendsActivity.this.bnm.a(aVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bnn != null) {
            this.bnn.dismiss();
        }
    }
}

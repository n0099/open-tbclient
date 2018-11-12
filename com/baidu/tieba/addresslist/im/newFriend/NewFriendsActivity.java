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
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel;
import com.baidu.tieba.addresslist.im.newFriend.a;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes3.dex */
public class NewFriendsActivity extends BaseActivity<NewFriendsActivity> {
    private c bzX;
    private com.baidu.tbadk.core.dialog.b bzY;
    private String bzW = "recommend_new_friend" + TbadkCoreApplication.getCurrentAccount();
    private a.b bzZ = new a.b() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.1
        @Override // com.baidu.tieba.addresslist.im.newFriend.a.b
        public void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar) {
            if (aVar.getStatus() == 0) {
                NewFriendsActivity.this.d(aVar);
            } else if (aVar.getStatus() == 1) {
                NewFriendsActivity.this.e(aVar);
            }
        }
    };
    final CustomMessageListener bAa = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                if (((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 1) {
                    NewFriendsActivity.this.Vr();
                } else {
                    NewFriendsActivity.this.Vt();
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c bAb = new com.baidu.adp.framework.listener.c(304101) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponsePassFriendMessage responsePassFriendMessage;
            int error;
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof SocketResponsedMessage)) {
                NewFriendsActivity.this.showToast(e.j.neterror);
            } else if ((socketResponsedMessage instanceof ResponsePassFriendMessage) && (error = (responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage).getError()) != 0 && error != 3100098) {
                NewFriendsActivity.this.showToast(StringUtils.isNull(responsePassFriendMessage.getErrorString()) ? NewFriendsActivity.this.getResources().getString(e.j.neterror) : responsePassFriendMessage.getErrorString());
            }
        }
    };
    private final j.b bAc = new j.b() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.4
        @Override // com.baidu.tbadk.core.view.j.b
        public void bG(boolean z) {
            if (!z) {
                NewFriendsActivity.this.Vs();
            }
        }
    };
    private final RecommendFriendModel bAd = new RecommendFriendModel(this, new RecommendFriendModel.a() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.5
        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.a
        public void jK(String str) {
            NewFriendsActivity.this.Vs();
            TbadkSettings.getInst().saveBoolean(NewFriendsActivity.this.bzW, true);
        }

        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.a
        public void onLoadFailed(String str) {
            NewFriendsActivity.this.bzX.completePullRefresh();
            NewFriendsActivity.this.bzX.setData(null);
            BdToast.a(NewFriendsActivity.this.getPageContext().getPageActivity(), str);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public void Vr() {
        x.b(new w<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            public List<com.baidu.tieba.im.data.a> doInBackground() {
                return b.Vu().Vx();
            }
        }, new h<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(List<com.baidu.tieba.im.data.a> list) {
                NewFriendsActivity.this.bzX.Vz().setData(list);
                NewFriendsActivity.this.bzX.Vz().notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.new_friend_activity);
        this.bzX = new c(this);
        this.bzX.a(this.bAc);
        this.bzX.a(this.bzZ);
        registerListener(this.bAa);
        registerListener(this.bAb);
        if (TbadkSettings.getInst().loadBoolean(this.bzW, false)) {
            Vs();
            this.bzX.startPullRefresh();
            return;
        }
        this.bAd.setUniqueId(getUniqueId());
        this.bAd.registerListener();
        this.bAd.VA();
        this.bzX.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bzX.a(getLayoutMode(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vs() {
        x.b(new w<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            public List<com.baidu.tieba.im.data.a> doInBackground() {
                b.Vu().Vw();
                return b.Vu().Vx();
            }
        }, new h<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(List<com.baidu.tieba.im.data.a> list) {
                NewFriendsActivity.this.bzX.completePullRefresh();
                NewFriendsActivity.this.bzX.setData(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vt() {
        x.b(new w<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.w
            public List<com.baidu.tieba.im.data.a> doInBackground() {
                return b.Vu().Vy();
            }
        }, new h<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(List<com.baidu.tieba.im.data.a> list) {
                NewFriendsActivity.this.bzX.ag(list);
            }
        });
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == e.g.new_friend_textview_container) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.a item = this.bzX.Vz().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.a)) {
            com.baidu.tieba.im.data.a aVar = item;
            if (i == j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(aVar.getId()), aVar.getName())));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.a item = this.bzX.Vz().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.a)) {
            this.bzY = a(new a(item));
            this.bzY.d(getPageContext());
            this.bzY.AE();
            return true;
        }
        return true;
    }

    /* loaded from: classes3.dex */
    private class a implements b.InterfaceC0148b {
        private com.baidu.tieba.im.data.a bAf;

        public a(com.baidu.tieba.im.data.a aVar) {
            this.bAf = aVar;
        }

        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (this.bAf != null) {
                NewFriendsActivity.this.f(this.bAf);
            }
        }
    }

    private com.baidu.tbadk.core.dialog.b a(a aVar) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.cQ(e.j.operation);
        bVar.a(new String[]{getPageContext().getString(e.j.delete)}, aVar);
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
        com.baidu.tbadk.newFriends.a.e(aVar.getId(), AddFriendActivityConfig.TYPE_NEW_FRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final com.baidu.tieba.im.data.a aVar) {
        x.b(new w<Boolean>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.w
            public Boolean doInBackground() {
                return Boolean.valueOf(b.Vu().aR(aVar.getId()));
            }
        }, new h<Boolean>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool.booleanValue()) {
                    NewFriendsActivity.this.bzX.a(aVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bzY != null) {
            this.bzY.dismiss();
        }
    }
}

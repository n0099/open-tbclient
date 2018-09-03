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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel;
import com.baidu.tieba.addresslist.im.newFriend.a;
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes3.dex */
public class NewFriendsActivity extends BaseActivity<NewFriendsActivity> {
    private c bpu;
    private com.baidu.tbadk.core.dialog.b bpv;
    private String bpt = "recommend_new_friend" + TbadkCoreApplication.getCurrentAccount();
    private a.b bpw = new a.b() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.1
        @Override // com.baidu.tieba.addresslist.im.newFriend.a.b
        public void a(int i, int i2, View view, com.baidu.tieba.im.data.a aVar) {
            if (aVar.getStatus() == 0) {
                NewFriendsActivity.this.d(aVar);
            } else if (aVar.getStatus() == 1) {
                NewFriendsActivity.this.e(aVar);
            }
        }
    };
    final CustomMessageListener bpx = new CustomMessageListener(2001174) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                if (((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 1) {
                    NewFriendsActivity.this.Ry();
                } else {
                    NewFriendsActivity.this.RA();
                }
            }
        }
    };
    final com.baidu.adp.framework.listener.c bpy = new com.baidu.adp.framework.listener.c(304101) { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponsePassFriendMessage responsePassFriendMessage;
            int error;
            if (socketResponsedMessage == null || !(socketResponsedMessage instanceof SocketResponsedMessage)) {
                NewFriendsActivity.this.showToast(f.j.neterror);
            } else if ((socketResponsedMessage instanceof ResponsePassFriendMessage) && (error = (responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage).getError()) != 0 && error != 3100098) {
                NewFriendsActivity.this.showToast(StringUtils.isNull(responsePassFriendMessage.getErrorString()) ? NewFriendsActivity.this.getResources().getString(f.j.neterror) : responsePassFriendMessage.getErrorString());
            }
        }
    };
    private final g.b bpz = new g.b() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.4
        @Override // com.baidu.tbadk.core.view.g.b
        public void aT(boolean z) {
            if (!z) {
                NewFriendsActivity.this.Rz();
            }
        }
    };
    private final RecommendFriendModel bpA = new RecommendFriendModel(this, new RecommendFriendModel.a() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.5
        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.a
        public void iT(String str) {
            NewFriendsActivity.this.Rz();
            TbadkSettings.getInst().saveBoolean(NewFriendsActivity.this.bpt, true);
        }

        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.a
        public void onLoadFailed(String str) {
            NewFriendsActivity.this.bpu.completePullRefresh();
            NewFriendsActivity.this.bpu.setData(null);
            BdToast.a(NewFriendsActivity.this.getPageContext().getPageActivity(), str);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public void Ry() {
        v.b(new u<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            public List<com.baidu.tieba.im.data.a> doInBackground() {
                return b.RB().RE();
            }
        }, new com.baidu.tbadk.util.g<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            public void onReturnDataInUI(List<com.baidu.tieba.im.data.a> list) {
                NewFriendsActivity.this.bpu.RG().setData(list);
                NewFriendsActivity.this.bpu.RG().notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.h.new_friend_activity);
        this.bpu = new c(this);
        this.bpu.a(this.bpz);
        this.bpu.a(this.bpw);
        registerListener(this.bpx);
        registerListener(this.bpy);
        if (TbadkSettings.getInst().loadBoolean(this.bpt, false)) {
            Rz();
            this.bpu.startPullRefresh();
            return;
        }
        this.bpA.setUniqueId(getUniqueId());
        this.bpA.registerListener();
        this.bpA.RH();
        this.bpu.startPullRefresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bpu.a(getLayoutMode(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rz() {
        v.b(new u<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            public List<com.baidu.tieba.im.data.a> doInBackground() {
                b.RB().RD();
                return b.RB().RE();
            }
        }, new com.baidu.tbadk.util.g<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            public void onReturnDataInUI(List<com.baidu.tieba.im.data.a> list) {
                NewFriendsActivity.this.bpu.completePullRefresh();
                NewFriendsActivity.this.bpu.setData(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RA() {
        v.b(new u<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.u
            public List<com.baidu.tieba.im.data.a> doInBackground() {
                return b.RB().RF();
            }
        }, new com.baidu.tbadk.util.g<List<com.baidu.tieba.im.data.a>>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.13
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            public void onReturnDataInUI(List<com.baidu.tieba.im.data.a> list) {
                NewFriendsActivity.this.bpu.X(list);
            }
        });
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == f.g.new_friend_textview_container) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.a item = this.bpu.RG().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.a)) {
            com.baidu.tieba.im.data.a aVar = item;
            if (i == j) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(aVar.getId()), aVar.getName())));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.im.data.a item = this.bpu.RG().getItem(i);
        if (item != null && (item instanceof com.baidu.tieba.im.data.a)) {
            this.bpv = a(new a(item));
            this.bpv.d(getPageContext());
            this.bpv.xh();
            return true;
        }
        return true;
    }

    /* loaded from: classes3.dex */
    private class a implements b.InterfaceC0101b {
        private com.baidu.tieba.im.data.a bpC;

        public a(com.baidu.tieba.im.data.a aVar) {
            this.bpC = aVar;
        }

        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (this.bpC != null) {
                NewFriendsActivity.this.f(this.bpC);
            }
        }
    }

    private com.baidu.tbadk.core.dialog.b a(a aVar) {
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.ci(f.j.operation);
        bVar.a(new String[]{getPageContext().getString(f.j.delete)}, aVar);
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
        com.baidu.tbadk.newFriends.a.b(aVar.getId(), AddFriendActivityConfig.TYPE_NEW_FRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final com.baidu.tieba.im.data.a aVar) {
        v.b(new u<Boolean>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                return Boolean.valueOf(b.RB().aJ(aVar.getId()));
            }
        }, new com.baidu.tbadk.util.g<Boolean>() { // from class: com.baidu.tieba.addresslist.im.newFriend.NewFriendsActivity.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
            public void onReturnDataInUI(Boolean bool) {
                if (bool.booleanValue()) {
                    NewFriendsActivity.this.bpu.a(aVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bpv != null) {
            this.bpv.dismiss();
        }
    }
}

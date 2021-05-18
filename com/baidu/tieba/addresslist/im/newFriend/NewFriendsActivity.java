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
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tieba.R;
import com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel;
import d.a.j0.r.f0.f;
import d.a.j0.r.s.b;
import d.a.j0.z0.f0;
import d.a.j0.z0.h0;
import d.a.k0.q.e.a.a;
import java.util.List;
/* loaded from: classes4.dex */
public class NewFriendsActivity extends BaseActivity<NewFriendsActivity> {
    public d.a.j0.r.s.b mDeleteNewFriendDialog;
    public d.a.k0.q.e.a.c mView;
    public String SHARE_ID = "recommend_new_friend" + TbadkCoreApplication.getCurrentAccount();
    public a.c mNewFriendItemListener = new e();
    public final CustomMessageListener mNewFriendAction = new f(2001174);
    public final d.a.c.c.g.c mPassListener = new i(304101);
    public final f.g mOnPullRefreshLisner = new c();
    public final RecommendFriendModel praiseYModel = new RecommendFriendModel(this, new d());

    /* loaded from: classes4.dex */
    public class a extends f0<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.e1.g.a f13683a;

        public a(d.a.k0.e1.g.a aVar) {
            this.f13683a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.a.j0.z0.f0
        public Boolean doInBackground() {
            return Boolean.valueOf(d.a.k0.q.e.a.b.f().b(this.f13683a.b()));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.j0.z0.n<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.e1.g.a f13685a;

        public b(d.a.k0.e1.g.a aVar) {
            this.f13685a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            if (bool.booleanValue()) {
                NewFriendsActivity.this.mView.g(this.f13685a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f.g {
        public c() {
        }

        @Override // d.a.j0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (z) {
                return;
            }
            NewFriendsActivity.this.loadNewFriendList();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements RecommendFriendModel.b {
        public d() {
        }

        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.b
        public void a(String str) {
            NewFriendsActivity.this.loadNewFriendList();
            TbadkSettings.getInst().saveBoolean(NewFriendsActivity.this.SHARE_ID, true);
        }

        @Override // com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel.b
        public void onLoadFailed(String str) {
            NewFriendsActivity.this.mView.e();
            NewFriendsActivity.this.mView.h(null);
            BdToast.c(NewFriendsActivity.this.getPageContext().getPageActivity(), str);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.c {
        public e() {
        }

        @Override // d.a.k0.q.e.a.a.c
        public void a(int i2, int i3, View view, d.a.k0.e1.g.a aVar) {
            if (aVar.f() == 0) {
                NewFriendsActivity.this.addtNewFriend(aVar);
            } else if (aVar.f() == 1) {
                NewFriendsActivity.this.passNewFriend(aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001174 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
                if (((ResponseNewFriendUpdateUiMsg) customResponsedMessage).getAction() == 1) {
                    NewFriendsActivity.this.notifyData();
                } else {
                    NewFriendsActivity.this.updateNewFriendList();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends f0<List<d.a.k0.e1.g.a>> {
        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public List<d.a.k0.e1.g.a> doInBackground() {
            return d.a.k0.q.e.a.b.f().j();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements d.a.j0.z0.n<List<d.a.k0.e1.g.a>> {
        public h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(List<d.a.k0.e1.g.a> list) {
            NewFriendsActivity.this.mView.f().e(list);
            NewFriendsActivity.this.mView.f().notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class i extends d.a.c.c.g.c {
        public i(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponsePassFriendMessage responsePassFriendMessage;
            int error;
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof SocketResponsedMessage)) {
                if (!(socketResponsedMessage instanceof ResponsePassFriendMessage) || (error = (responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage).getError()) == 0 || error == 3100098) {
                    return;
                }
                NewFriendsActivity.this.showToast(StringUtils.isNull(responsePassFriendMessage.getErrorString()) ? NewFriendsActivity.this.getResources().getString(R.string.neterror) : responsePassFriendMessage.getErrorString());
                return;
            }
            NewFriendsActivity.this.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes4.dex */
    public class j extends f0<List<d.a.k0.e1.g.a>> {
        public j() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public List<d.a.k0.e1.g.a> doInBackground() {
            d.a.k0.q.e.a.b.f().p();
            return d.a.k0.q.e.a.b.f().j();
        }
    }

    /* loaded from: classes4.dex */
    public class k implements d.a.j0.z0.n<List<d.a.k0.e1.g.a>> {
        public k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(List<d.a.k0.e1.g.a> list) {
            NewFriendsActivity.this.mView.e();
            NewFriendsActivity.this.mView.h(list);
        }
    }

    /* loaded from: classes4.dex */
    public class l extends f0<List<d.a.k0.e1.g.a>> {
        public l() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public List<d.a.k0.e1.g.a> doInBackground() {
            return d.a.k0.q.e.a.b.f().g();
        }
    }

    /* loaded from: classes4.dex */
    public class m implements d.a.j0.z0.n<List<d.a.k0.e1.g.a>> {
        public m() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(List<d.a.k0.e1.g.a> list) {
            NewFriendsActivity.this.mView.m(list);
        }
    }

    /* loaded from: classes4.dex */
    public class n implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public d.a.k0.e1.g.a f13698a;

        public n(d.a.k0.e1.g.a aVar) {
            this.f13698a = aVar;
        }

        @Override // d.a.j0.r.s.b.c
        public void a(d.a.j0.r.s.b bVar, int i2, View view) {
            bVar.e();
            d.a.k0.e1.g.a aVar = this.f13698a;
            if (aVar != null) {
                NewFriendsActivity.this.deleteNewFriend(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addtNewFriend(d.a.k0.e1.g.a aVar) {
        if (aVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddFriendActivityConfig(getPageContext().getPageActivity(), String.valueOf(aVar.b()), aVar.d(), aVar.e(), "", false, AddFriendActivityConfig.TYPE_NEW_FRD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteNewFriend(d.a.k0.e1.g.a aVar) {
        h0.c(new a(aVar), new b(aVar));
    }

    private d.a.j0.r.s.b getDeleteNewFriendDialog(n nVar) {
        d.a.j0.r.s.b bVar = new d.a.j0.r.s.b(getPageContext().getPageActivity());
        bVar.k(R.string.operation);
        bVar.j(new String[]{getPageContext().getString(R.string.delete)}, nVar);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNewFriendList() {
        h0.c(new j(), new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyData() {
        h0.c(new g(), new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void passNewFriend(d.a.k0.e1.g.a aVar) {
        d.a.j0.h0.a.a(aVar.b(), AddFriendActivityConfig.TYPE_NEW_FRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNewFriendList() {
        h0.c(new l(), new m());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        this.mView.d(getLayoutMode(), i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.new_friend_textview_container) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SearchFriendActivityConfig(getPageContext().getPageActivity())));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_friend_activity);
        d.a.k0.q.e.a.c cVar = new d.a.k0.q.e.a.c(this);
        this.mView = cVar;
        cVar.j(this.mOnPullRefreshLisner);
        this.mView.k(this.mNewFriendItemListener);
        registerListener(this.mNewFriendAction);
        registerListener(this.mPassListener);
        if (TbadkSettings.getInst().loadBoolean(this.SHARE_ID, false)) {
            loadNewFriendList();
            this.mView.l();
            return;
        }
        this.praiseYModel.setUniqueId(getUniqueId());
        this.praiseYModel.registerListener();
        this.praiseYModel.t();
        this.mView.l();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.a.j0.r.s.b bVar = this.mDeleteNewFriendDialog;
        if (bVar != null) {
            bVar.e();
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        d.a.k0.e1.g.a item = this.mView.f().getItem(i2);
        if (item != null && (item instanceof d.a.k0.e1.g.a) && i2 == j2) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), String.valueOf(item.b()), item.d())));
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        d.a.k0.e1.g.a item = this.mView.f().getItem(i2);
        if (item == null || !(item instanceof d.a.k0.e1.g.a)) {
            return true;
        }
        d.a.j0.r.s.b deleteNewFriendDialog = getDeleteNewFriendDialog(new n(item));
        this.mDeleteNewFriendDialog = deleteNewFriendDialog;
        deleteNewFriendDialog.c(getPageContext());
        this.mDeleteNewFriendDialog.m();
        return true;
    }
}

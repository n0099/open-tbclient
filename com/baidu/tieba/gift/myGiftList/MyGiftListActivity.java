package com.baidu.tieba.gift.myGiftList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListModel;
import d.a.c.e.p.l;
import d.a.n0.r.f0.f;
/* loaded from: classes4.dex */
public class MyGiftListActivity extends BaseActivity<MyGiftListActivity> {
    public boolean mIsHost;
    public MyGiftListModel mModel;
    public d.a.o0.v0.c.c mMyGiftListView;
    public String nameShow;
    public String st_type;
    public int userType;
    public String username;
    public String suid = null;
    public int sex = 0;
    public long mUserId = 0;
    public MyGiftListModel.b mLoadDataCallback = new a();
    public NoNetworkView.b mNetworkChangeListener = new d();
    public final CustomMessageListener mSendGiftSucceedListener = new e(2001232);
    public BdListView.p scrollToBottomListener = new f();

    /* loaded from: classes4.dex */
    public class a implements MyGiftListModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.gift.myGiftList.MyGiftListModel.b
        public void a(int i2, String str, boolean z, d.a.o0.v0.c.a aVar) {
            MyGiftListActivity.this.closeLoadingDialog();
            MyGiftListActivity.this.mMyGiftListView.n().setVisibility(8);
            MyGiftListActivity.this.mMyGiftListView.m();
            if (i2 == 0) {
                MyGiftListActivity.this.mMyGiftListView.t(aVar);
                return;
            }
            MyGiftListActivity.this.showToast(str);
            if (z) {
                MyGiftListActivity.this.mMyGiftListView.t(aVar);
            } else {
                MyGiftListActivity.this.mMyGiftListView.v(str, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.g {
        public b() {
        }

        @Override // d.a.n0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (!l.D()) {
                MyGiftListActivity.this.mMyGiftListView.m();
                MyGiftListActivity.this.mMyGiftListView.v(MyGiftListActivity.this.getString(R.string.neterror), true);
                return;
            }
            d.a.n0.s.d.b.g0().n();
            MyGiftListActivity.this.mModel.I(false);
            MyGiftListActivity.this.mModel.LoadData();
            d.a.n0.s.d.b.g0().d0(0);
            MyGiftListActivity.this.mMyGiftListView.o();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MyGiftListActivity.this.mIsHost) {
                return;
            }
            if (l.D()) {
                long uid = MyGiftListActivity.this.mModel.getUid();
                if (uid == 0) {
                    return;
                }
                TiebaStatic.log("gift_list_btn");
                GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(MyGiftListActivity.this.getPageContext().getPageActivity(), uid, MyGiftListActivity.this.username, MyGiftListActivity.this.nameShow);
                giftTabActivityConfig.getIntent().putExtra("account_type", MyGiftListActivity.this.userType);
                giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_GIFT_WALLS, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                MyGiftListActivity.this.sendMessage(new CustomMessage(2002001, giftTabActivityConfig));
                return;
            }
            MyGiftListActivity.this.showToast(R.string.neterror);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements NoNetworkView.b {
        public d() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            if (z) {
                MyGiftListActivity.this.mModel.I(false);
                MyGiftListActivity.this.mModel.LoadData();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage == null || (l = (Long) customResponsedMessage.getData()) == null || MyGiftListActivity.this.mIsHost || MyGiftListActivity.this.mUserId != l.longValue()) {
                return;
            }
            MyGiftListActivity.this.mModel.I(false);
            MyGiftListActivity.this.mModel.LoadData();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements BdListView.p {
        public f() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (MyGiftListActivity.this.mModel.E()) {
                MyGiftListActivity.this.mModel.I(true);
                MyGiftListActivity.this.mModel.LoadData();
                MyGiftListActivity.this.mMyGiftListView.n().setVisibility(0);
                return;
            }
            MyGiftListActivity.this.mMyGiftListView.n().setVisibility(8);
        }
    }

    private void addNetWorkChangeListener() {
        this.mMyGiftListView.k(this.mNetworkChangeListener);
    }

    private void initUI() {
        d.a.o0.v0.c.c cVar = new d.a.o0.v0.c.c(this, this.scrollToBottomListener, this.mIsHost);
        this.mMyGiftListView = cVar;
        cVar.u(new b());
        addNetWorkChangeListener();
    }

    public View.OnClickListener getSendGiftClickListener() {
        return new c();
    }

    public String getUserSex() {
        return this.sex == 2 ? getPageContext().getString(R.string.she) : getPageContext().getString(R.string.he);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mMyGiftListView.onChangeSkinType(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.a.n0.s.d.b.g0().n();
        Intent intent = getIntent();
        if (intent != null) {
            this.suid = intent.getStringExtra("id");
            this.st_type = intent.getStringExtra("st_type");
            this.sex = intent.getIntExtra("sex", 0);
            this.username = intent.getStringExtra("user_name");
            this.nameShow = intent.getStringExtra("name_show");
            this.userType = intent.getIntExtra("user_type", 0);
        }
        String str = this.suid;
        if (str != null) {
            this.mUserId = d.a.c.e.m.b.f(str, 0L);
        }
        MyGiftListModel myGiftListModel = new MyGiftListModel(getPageContext(), this.st_type);
        this.mModel = myGiftListModel;
        myGiftListModel.mUserType = this.userType;
        myGiftListModel.setUid(this.mUserId);
        this.mIsHost = this.mModel.C();
        this.mModel.G(this.mLoadDataCallback);
        initUI();
        registerListener(this.mSendGiftSucceedListener);
        this.mModel.I(false);
        if (l.D()) {
            this.mMyGiftListView.w();
        } else {
            this.mMyGiftListView.v(getString(R.string.neterror), true);
        }
        d.a.n0.s.d.b.g0().d0(0);
    }
}

package com.baidu.tieba.gift.myGiftList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListModel;
/* loaded from: classes9.dex */
public class MyGiftListActivity extends BaseActivity<MyGiftListActivity> {
    private MyGiftListModel jTj;
    private c jTk;
    private boolean mIsHost;
    private String nameShow;
    private String st_type;
    public int userType;
    private String username;
    private String jTl = null;
    private int sex = 0;
    private long mUserId = 0;
    private MyGiftListModel.a jTm = new MyGiftListModel.a() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.1
        @Override // com.baidu.tieba.gift.myGiftList.MyGiftListModel.a
        public void a(int i, String str, boolean z, a aVar) {
            MyGiftListActivity.this.closeLoadingDialog();
            MyGiftListActivity.this.jTk.cPZ().setVisibility(8);
            MyGiftListActivity.this.jTk.cQa();
            if (i == 0) {
                MyGiftListActivity.this.jTk.b(aVar);
                return;
            }
            MyGiftListActivity.this.showToast(str);
            if (z) {
                MyGiftListActivity.this.jTk.b(aVar);
            } else {
                MyGiftListActivity.this.jTk.aR(str, true);
            }
        }
    };
    private NoNetworkView.a gzW = new NoNetworkView.a() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                MyGiftListActivity.this.jTj.rM(false);
                MyGiftListActivity.this.jTj.LoadData();
            }
        }
    };
    private final CustomMessageListener jTn = new CustomMessageListener(CmdConfigCustom.CMD_GET_GIFT_SUCCEED) { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && !MyGiftListActivity.this.mIsHost && MyGiftListActivity.this.mUserId == l.longValue()) {
                MyGiftListActivity.this.jTj.rM(false);
                MyGiftListActivity.this.jTj.LoadData();
            }
        }
    };
    private BdListView.e gXN = new BdListView.e() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (MyGiftListActivity.this.jTj.isHasMore()) {
                MyGiftListActivity.this.jTj.rM(true);
                MyGiftListActivity.this.jTj.LoadData();
                MyGiftListActivity.this.jTk.cPZ().setVisibility(0);
                return;
            }
            MyGiftListActivity.this.jTk.cPZ().setVisibility(8);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBu();
        Intent intent = getIntent();
        if (intent != null) {
            this.jTl = intent.getStringExtra("id");
            this.st_type = intent.getStringExtra("st_type");
            this.sex = intent.getIntExtra("sex", 0);
            this.username = intent.getStringExtra("user_name");
            this.nameShow = intent.getStringExtra("name_show");
            this.userType = intent.getIntExtra("user_type", 0);
        }
        if (this.jTl != null) {
            this.mUserId = com.baidu.adp.lib.f.b.toLong(this.jTl, 0L);
        }
        this.jTj = new MyGiftListModel(getPageContext(), this.st_type);
        this.jTj.mUserType = this.userType;
        this.jTj.setUid(this.mUserId);
        this.mIsHost = this.jTj.getIsSelf();
        this.jTj.a(this.jTm);
        initUI();
        registerListener(this.jTn);
        this.jTj.rM(false);
        if (l.isNetOk()) {
            this.jTk.startPullRefresh();
        } else {
            this.jTk.aR(getString(R.string.neterror), true);
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bBd().setMsgGiftNum(0);
    }

    private void initUI() {
        this.jTk = new c(this, this.gXN, this.mIsHost);
        this.jTk.a(new f.c() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!l.isNetOk()) {
                    MyGiftListActivity.this.jTk.cQa();
                    MyGiftListActivity.this.jTk.aR(MyGiftListActivity.this.getString(R.string.neterror), true);
                    return;
                }
                com.baidu.tbadk.coreExtra.messageCenter.b.bBd().bBu();
                MyGiftListActivity.this.jTj.rM(false);
                MyGiftListActivity.this.jTj.LoadData();
                com.baidu.tbadk.coreExtra.messageCenter.b.bBd().setMsgGiftNum(0);
                MyGiftListActivity.this.jTk.Zj();
            }
        });
        cPV();
    }

    public View.OnClickListener cPU() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!MyGiftListActivity.this.mIsHost) {
                    if (l.isNetOk()) {
                        long uid = MyGiftListActivity.this.jTj.getUid();
                        if (uid != 0) {
                            TiebaStatic.log("gift_list_btn");
                            GiftTabActivityConfig giftTabActivityConfig = new GiftTabActivityConfig(MyGiftListActivity.this.getPageContext().getPageActivity(), uid, MyGiftListActivity.this.username, MyGiftListActivity.this.nameShow);
                            giftTabActivityConfig.getIntent().putExtra("account_type", MyGiftListActivity.this.userType);
                            giftTabActivityConfig.setReferPageAndClickZone(MemberPayStatistic.REFER_PAGE_GIFT_WALLS, MemberPayStatistic.CLICK_ZONE_T_RECHARGE);
                            MyGiftListActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, giftTabActivityConfig));
                            return;
                        }
                        return;
                    }
                    MyGiftListActivity.this.showToast(R.string.neterror);
                }
            }
        };
    }

    private void cPV() {
        this.jTk.h(this.gzW);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jTk.onChangeSkinType(i);
    }

    public String cPW() {
        String string = getPageContext().getString(R.string.he);
        if (this.sex == 2) {
            return getPageContext().getString(R.string.she);
        }
        return string;
    }
}

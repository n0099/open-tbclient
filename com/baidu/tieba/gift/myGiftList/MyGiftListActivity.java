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
/* loaded from: classes8.dex */
public class MyGiftListActivity extends BaseActivity<MyGiftListActivity> {
    private MyGiftListModel jOE;
    private c jOF;
    private boolean mIsHost;
    private String nameShow;
    private String st_type;
    public int userType;
    private String username;
    private String jOG = null;
    private int sex = 0;
    private long mUserId = 0;
    private MyGiftListModel.a jOH = new MyGiftListModel.a() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.1
        @Override // com.baidu.tieba.gift.myGiftList.MyGiftListModel.a
        public void a(int i, String str, boolean z, a aVar) {
            MyGiftListActivity.this.closeLoadingDialog();
            MyGiftListActivity.this.jOF.cMh().setVisibility(8);
            MyGiftListActivity.this.jOF.cMi();
            if (i == 0) {
                MyGiftListActivity.this.jOF.b(aVar);
                return;
            }
            MyGiftListActivity.this.showToast(str);
            if (z) {
                MyGiftListActivity.this.jOF.b(aVar);
            } else {
                MyGiftListActivity.this.jOF.aR(str, true);
            }
        }
    };
    private NoNetworkView.a gvp = new NoNetworkView.a() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                MyGiftListActivity.this.jOE.rI(false);
                MyGiftListActivity.this.jOE.LoadData();
            }
        }
    };
    private final CustomMessageListener jOI = new CustomMessageListener(CmdConfigCustom.CMD_GET_GIFT_SUCCEED) { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && !MyGiftListActivity.this.mIsHost && MyGiftListActivity.this.mUserId == l.longValue()) {
                MyGiftListActivity.this.jOE.rI(false);
                MyGiftListActivity.this.jOE.LoadData();
            }
        }
    };
    private BdListView.e gTh = new BdListView.e() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (MyGiftListActivity.this.jOE.isHasMore()) {
                MyGiftListActivity.this.jOE.rI(true);
                MyGiftListActivity.this.jOE.LoadData();
                MyGiftListActivity.this.jOF.cMh().setVisibility(0);
                return;
            }
            MyGiftListActivity.this.jOF.cMh().setVisibility(8);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tbadk.coreExtra.messageCenter.b.bxj().bxA();
        Intent intent = getIntent();
        if (intent != null) {
            this.jOG = intent.getStringExtra("id");
            this.st_type = intent.getStringExtra("st_type");
            this.sex = intent.getIntExtra("sex", 0);
            this.username = intent.getStringExtra("user_name");
            this.nameShow = intent.getStringExtra("name_show");
            this.userType = intent.getIntExtra("user_type", 0);
        }
        if (this.jOG != null) {
            this.mUserId = com.baidu.adp.lib.f.b.toLong(this.jOG, 0L);
        }
        this.jOE = new MyGiftListModel(getPageContext(), this.st_type);
        this.jOE.mUserType = this.userType;
        this.jOE.setUid(this.mUserId);
        this.mIsHost = this.jOE.getIsSelf();
        this.jOE.a(this.jOH);
        initUI();
        registerListener(this.jOI);
        this.jOE.rI(false);
        if (l.isNetOk()) {
            this.jOF.startPullRefresh();
        } else {
            this.jOF.aR(getString(R.string.neterror), true);
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bxj().setMsgGiftNum(0);
    }

    private void initUI() {
        this.jOF = new c(this, this.gTh, this.mIsHost);
        this.jOF.a(new f.c() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!l.isNetOk()) {
                    MyGiftListActivity.this.jOF.cMi();
                    MyGiftListActivity.this.jOF.aR(MyGiftListActivity.this.getString(R.string.neterror), true);
                    return;
                }
                com.baidu.tbadk.coreExtra.messageCenter.b.bxj().bxA();
                MyGiftListActivity.this.jOE.rI(false);
                MyGiftListActivity.this.jOE.LoadData();
                com.baidu.tbadk.coreExtra.messageCenter.b.bxj().setMsgGiftNum(0);
                MyGiftListActivity.this.jOF.Vq();
            }
        });
        cMd();
    }

    public View.OnClickListener cMc() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!MyGiftListActivity.this.mIsHost) {
                    if (l.isNetOk()) {
                        long uid = MyGiftListActivity.this.jOE.getUid();
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

    private void cMd() {
        this.jOF.h(this.gvp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jOF.onChangeSkinType(i);
    }

    public String cMe() {
        String string = getPageContext().getString(R.string.he);
        if (this.sex == 2) {
            return getPageContext().getString(R.string.she);
        }
        return string;
    }
}

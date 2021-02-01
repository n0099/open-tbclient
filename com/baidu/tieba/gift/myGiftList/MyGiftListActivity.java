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
    private MyGiftListModel jWg;
    private c jWh;
    private boolean mIsHost;
    private String nameShow;
    private String st_type;
    public int userType;
    private String username;
    private String jWi = null;
    private int sex = 0;
    private long mUserId = 0;
    private MyGiftListModel.a jWj = new MyGiftListModel.a() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.1
        @Override // com.baidu.tieba.gift.myGiftList.MyGiftListModel.a
        public void a(int i, String str, boolean z, a aVar) {
            MyGiftListActivity.this.closeLoadingDialog();
            MyGiftListActivity.this.jWh.cOe().setVisibility(8);
            MyGiftListActivity.this.jWh.cOf();
            if (i == 0) {
                MyGiftListActivity.this.jWh.b(aVar);
                return;
            }
            MyGiftListActivity.this.showToast(str);
            if (z) {
                MyGiftListActivity.this.jWh.b(aVar);
            } else {
                MyGiftListActivity.this.jWh.aQ(str, true);
            }
        }
    };
    private NoNetworkView.a gxZ = new NoNetworkView.a() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.4
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                MyGiftListActivity.this.jWg.rT(false);
                MyGiftListActivity.this.jWg.LoadData();
            }
        }
    };
    private final CustomMessageListener jWk = new CustomMessageListener(CmdConfigCustom.CMD_GET_GIFT_SUCCEED) { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Long l;
            if (customResponsedMessage != null && (l = (Long) customResponsedMessage.getData()) != null && !MyGiftListActivity.this.mIsHost && MyGiftListActivity.this.mUserId == l.longValue()) {
                MyGiftListActivity.this.jWg.rT(false);
                MyGiftListActivity.this.jWg.LoadData();
            }
        }
    };
    private BdListView.e gVR = new BdListView.e() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.6
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (MyGiftListActivity.this.jWg.isHasMore()) {
                MyGiftListActivity.this.jWg.rT(true);
                MyGiftListActivity.this.jWg.LoadData();
                MyGiftListActivity.this.jWh.cOe().setVisibility(0);
                return;
            }
            MyGiftListActivity.this.jWh.cOe().setVisibility(8);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxS();
        Intent intent = getIntent();
        if (intent != null) {
            this.jWi = intent.getStringExtra("id");
            this.st_type = intent.getStringExtra("st_type");
            this.sex = intent.getIntExtra("sex", 0);
            this.username = intent.getStringExtra("user_name");
            this.nameShow = intent.getStringExtra("name_show");
            this.userType = intent.getIntExtra("user_type", 0);
        }
        if (this.jWi != null) {
            this.mUserId = com.baidu.adp.lib.f.b.toLong(this.jWi, 0L);
        }
        this.jWg = new MyGiftListModel(getPageContext(), this.st_type);
        this.jWg.mUserType = this.userType;
        this.jWg.setUid(this.mUserId);
        this.mIsHost = this.jWg.getIsSelf();
        this.jWg.a(this.jWj);
        initUI();
        registerListener(this.jWk);
        this.jWg.rT(false);
        if (l.isNetOk()) {
            this.jWh.startPullRefresh();
        } else {
            this.jWh.aQ(getString(R.string.neterror), true);
        }
        com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgGiftNum(0);
    }

    private void initUI() {
        this.jWh = new c(this, this.gVR, this.mIsHost);
        this.jWh.a(new f.c() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.2
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (!l.isNetOk()) {
                    MyGiftListActivity.this.jWh.cOf();
                    MyGiftListActivity.this.jWh.aQ(MyGiftListActivity.this.getString(R.string.neterror), true);
                    return;
                }
                com.baidu.tbadk.coreExtra.messageCenter.b.bxB().bxS();
                MyGiftListActivity.this.jWg.rT(false);
                MyGiftListActivity.this.jWg.LoadData();
                com.baidu.tbadk.coreExtra.messageCenter.b.bxB().setMsgGiftNum(0);
                MyGiftListActivity.this.jWh.WZ();
            }
        });
        cOa();
    }

    public View.OnClickListener cNZ() {
        return new View.OnClickListener() { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!MyGiftListActivity.this.mIsHost) {
                    if (l.isNetOk()) {
                        long uid = MyGiftListActivity.this.jWg.getUid();
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

    private void cOa() {
        this.jWh.h(this.gxZ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jWh.onChangeSkinType(i);
    }

    public String cOb() {
        String string = getPageContext().getString(R.string.he);
        if (this.sex == 2) {
            return getPageContext().getString(R.string.she);
        }
        return string;
    }
}

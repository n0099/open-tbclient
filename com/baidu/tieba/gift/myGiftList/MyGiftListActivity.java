package com.baidu.tieba.gift.myGiftList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.gift.myGiftList.j;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class MyGiftListActivity extends BaseActivity<MyGiftListActivity> {
    private j bwr;
    private l bws;
    private boolean mIsHost;
    private String st_type;
    private String username;
    private String bwt = null;
    private int sex = 0;
    private long mUserId = 0;
    MyGiftNotifyMessage bwu = new MyGiftNotifyMessage();
    private j.a bwv = new b(this);
    private NoNetworkView.a aUj = new c(this);
    private final CustomMessageListener bww = new d(this, CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    private BdListView.e bwx = new e(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tbadk.coreExtra.messageCenter.a.xJ().ya();
        Intent intent = getIntent();
        if (intent != null) {
            this.bwt = intent.getStringExtra("id");
            this.st_type = intent.getStringExtra("st_type");
            this.sex = intent.getIntExtra(MyGiftListActivityConfig.USER_SEX, 0);
            this.username = intent.getStringExtra("user_name");
        }
        if (this.bwt != null) {
            this.mUserId = com.baidu.adp.lib.h.b.c(this.bwt, 0L);
        }
        this.bwr = new j(getPageContext(), this.st_type);
        this.bwr.setUid(this.mUserId);
        this.mIsHost = this.bwr.getIsSelf();
        this.bwr.a(this.bwv);
        initUI();
        registerListener(this.bww);
        this.bwr.cV(false);
        this.bws.nD();
        com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgGiftNum(0);
        MessageManager.getInstance().dispatchResponsedMessage(this.bwu);
    }

    private void initUI() {
        this.bws = new l(this, this.bwx, this.mIsHost);
        this.bws.b(new f(this));
        Tu();
    }

    public View.OnClickListener Tt() {
        return new g(this);
    }

    private void Tu() {
        this.bws.g(this.aUj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bws.onChangeSkinType(i);
    }

    public String Tv() {
        String string = getPageContext().getString(n.i.he);
        if (this.sex == 2) {
            return getPageContext().getString(n.i.she);
        }
        return string;
    }
}

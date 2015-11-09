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
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class MyGiftListActivity extends BaseActivity<MyGiftListActivity> {
    private l bnw;
    private m bnx;
    private boolean mIsHost;
    private String st_type;
    private String bny = null;
    private int sex = 0;
    private long mUserId = 0;
    MyGiftNotifyMessage bnz = new MyGiftNotifyMessage();
    private NoNetworkView.a aPg = new d(this);
    private final CustomMessageListener bnA = new e(this, CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 308002);
    private BdListView.e bnB = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tbadk.coreExtra.messageCenter.a.wM().xd();
        Intent intent = getIntent();
        if (intent != null) {
            this.bny = intent.getStringExtra("id");
            this.st_type = intent.getStringExtra("st_type");
            this.sex = intent.getIntExtra(MyGiftListActivityConfig.USER_SEX, 0);
        }
        if (this.bny != null) {
            this.mUserId = com.baidu.adp.lib.g.b.c(this.bny, 0L);
        }
        this.bnw = new l(this, this.st_type);
        this.bnw.setUid(this.mUserId);
        this.mIsHost = this.bnw.getIsSelf();
        initUI();
        this.mListener.setSelfListener(true);
        registerListener(this.mListener);
        registerListener(this.bnA);
        this.bnw.cC(false);
        this.bnx.nx();
        com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgGiftNum(0);
        MessageManager.getInstance().dispatchResponsedMessage(this.bnz);
    }

    private void initUI() {
        this.bnx = new m(this, this.bnB, this.mIsHost);
        this.bnx.b(new h(this));
        QO();
    }

    public View.OnClickListener QN() {
        return new i(this);
    }

    private void QO() {
        this.bnx.h(this.aPg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bnx.onChangeSkinType(i);
    }

    public String QP() {
        String string = getPageContext().getString(i.h.he);
        if (this.sex == 2) {
            return getPageContext().getString(i.h.she);
        }
        return string;
    }
}

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
    private l bmS;
    private m bmT;
    private boolean mIsHost;
    private String st_type;
    private String bmU = null;
    private int sex = 0;
    private long mUserId = 0;
    MyGiftNotifyMessage bmV = new MyGiftNotifyMessage();
    private NoNetworkView.a aOY = new d(this);
    private final CustomMessageListener bmW = new e(this, CmdConfigCustom.CMD_GET_GIFT_SUCCEED);
    private final com.baidu.adp.framework.listener.e mListener = new f(this, 308002);
    private BdListView.e bmX = new g(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tbadk.coreExtra.messageCenter.a.wK().xb();
        Intent intent = getIntent();
        if (intent != null) {
            this.bmU = intent.getStringExtra("id");
            this.st_type = intent.getStringExtra("st_type");
            this.sex = intent.getIntExtra(MyGiftListActivityConfig.USER_SEX, 0);
        }
        if (this.bmU != null) {
            this.mUserId = com.baidu.adp.lib.g.b.c(this.bmU, 0L);
        }
        this.bmS = new l(this, this.st_type);
        this.bmS.setUid(this.mUserId);
        this.mIsHost = this.bmS.getIsSelf();
        initUI();
        this.mListener.setSelfListener(true);
        registerListener(this.mListener);
        registerListener(this.bmW);
        this.bmS.cA(false);
        this.bmT.nw();
        com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgGiftNum(0);
        MessageManager.getInstance().dispatchResponsedMessage(this.bmV);
    }

    private void initUI() {
        this.bmT = new m(this, this.bmX, this.mIsHost);
        this.bmT.b(new h(this));
        Qw();
    }

    public View.OnClickListener Qv() {
        return new i(this);
    }

    private void Qw() {
        this.bmT.h(this.aOY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bmT.onChangeSkinType(i);
    }

    public String Qx() {
        String string = getPageContext().getString(i.h.he);
        if (this.sex == 2) {
            return getPageContext().getString(i.h.she);
        }
        return string;
    }
}

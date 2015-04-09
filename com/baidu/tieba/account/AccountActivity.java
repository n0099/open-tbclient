package com.baidu.tieba.account;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private NavigationBar mNavigationBar;
    private ArrayList<AccountData> auv = null;
    private m auw = null;
    private ListView mList = null;
    private RelativeLayout aux = null;
    private TextView auy = null;
    private View.OnClickListener auz = null;
    private j auA = null;
    private h auB = null;
    private Handler mHandler = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.account_activity);
        Ej();
        Ek();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.aux);
        this.auw.notifyDataSetChanged();
    }

    private void Ej() {
        this.auv = com.baidu.tbadk.core.a.d.pH();
    }

    private void Ek() {
        this.aux = (RelativeLayout) findViewById(com.baidu.tieba.v.account_container);
        this.auz = new b(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.y.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.navigation_right_button_layout, (View.OnClickListener) null);
        this.auy = (TextView) addCustomView.findViewById(com.baidu.tieba.v.right_textview);
        this.auy.setText(getPageContext().getString(com.baidu.tieba.y.edit));
        ba.b(this.auy, com.baidu.tieba.s.navi_op_text, 1);
        addCustomView.setOnClickListener(new d(this));
        this.auw = new m(this, this.auz);
        this.auw.p(this.auv);
        this.mList = (ListView) findViewById(com.baidu.tieba.v.list);
        this.mList.setAdapter((ListAdapter) this.auw);
        this.mList.setOnItemClickListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        if (this.auA == null) {
            eS("account changed");
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.y.account_logining), new f(this));
            this.auA = new j(this, accountData);
            this.auA.setPriority(3);
            El();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void El() {
        if (this.auA != null) {
            if (En()) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 200L);
                return;
            }
            this.auA.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.auB == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                eS("account delete");
            }
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.y.deleting), new g(this, z2));
            this.auB = new h(this, z, accountData);
            this.auB.setPriority(3);
            Em();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Em() {
        if (this.auB != null) {
            if (En()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.auB.execute(new Object[0]);
        }
    }

    private void eS(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().es();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eT(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    private boolean En() {
        return MessageManager.getInstance().getSocketClient().ev() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }
}

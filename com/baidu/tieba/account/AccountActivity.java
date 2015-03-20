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
    private ArrayList<AccountData> aun = null;
    private m auo = null;
    private ListView mList = null;
    private RelativeLayout aup = null;
    private TextView auq = null;
    private View.OnClickListener aur = null;
    private j aus = null;
    private h aut = null;
    private Handler mHandler = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.account_activity);
        Ed();
        Ee();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.aup);
        this.auo.notifyDataSetChanged();
    }

    private void Ed() {
        this.aun = com.baidu.tbadk.core.a.d.pH();
    }

    private void Ee() {
        this.aup = (RelativeLayout) findViewById(com.baidu.tieba.v.account_container);
        this.aur = new b(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.y.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.navigation_right_button_layout, (View.OnClickListener) null);
        this.auq = (TextView) addCustomView.findViewById(com.baidu.tieba.v.right_textview);
        this.auq.setText(getPageContext().getString(com.baidu.tieba.y.edit));
        ba.b(this.auq, com.baidu.tieba.s.navi_op_text, 1);
        addCustomView.setOnClickListener(new d(this));
        this.auo = new m(this, this.aur);
        this.auo.p(this.aun);
        this.mList = (ListView) findViewById(com.baidu.tieba.v.list);
        this.mList.setAdapter((ListAdapter) this.auo);
        this.mList.setOnItemClickListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        if (this.aus == null) {
            eP("account changed");
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.y.account_logining), new f(this));
            this.aus = new j(this, accountData);
            this.aus.setPriority(3);
            Ef();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ef() {
        if (this.aus != null) {
            if (Eh()) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 200L);
                return;
            }
            this.aus.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.aut == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                eP("account delete");
            }
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.y.deleting), new g(this, z2));
            this.aut = new h(this, z, accountData);
            this.aut.setPriority(3);
            Eg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Eg() {
        if (this.aut != null) {
            if (Eh()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.aut.execute(new Object[0]);
        }
    }

    private void eP(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().es();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    private boolean Eh() {
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

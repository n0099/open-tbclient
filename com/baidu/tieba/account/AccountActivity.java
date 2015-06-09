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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private NavigationBar mNavigationBar;
    private ArrayList<AccountData> avZ = null;
    private m awa = null;
    private ListView mList = null;
    private RelativeLayout awb = null;
    private TextView awc = null;
    private View.OnClickListener awd = null;
    private k awe = null;
    private i awf = null;
    private final com.baidu.tbadk.core.a.b SV = new a(this);
    private Handler mHandler = new b(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.account_activity);
        EX();
        EY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.awb);
        this.awa.notifyDataSetChanged();
    }

    private void EX() {
        this.avZ = com.baidu.tbadk.core.a.d.qn();
    }

    private void EY() {
        this.awb = (RelativeLayout) findViewById(com.baidu.tieba.q.account_container);
        this.awd = new c(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.account_manager));
        View addCustomView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.navigation_right_button_layout, (View.OnClickListener) null);
        this.awc = (TextView) addCustomView.findViewById(com.baidu.tieba.q.right_textview);
        this.awc.setText(getPageContext().getString(com.baidu.tieba.t.edit));
        ay.b(this.awc, com.baidu.tieba.n.navi_op_text, 1);
        addCustomView.setOnClickListener(new e(this));
        this.awa = new m(this, this.awd);
        this.awa.setData(this.avZ);
        this.mList = (ListView) findViewById(com.baidu.tieba.q.list);
        this.mList.setAdapter((ListAdapter) this.awa);
        this.mList.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(AccountData accountData) {
        if (this.awe == null) {
            fn("account changed");
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.t.account_logining), new g(this));
            this.awe = new k(this, accountData);
            this.awe.setPriority(3);
            EZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EZ() {
        if (this.awe != null) {
            if (Fb()) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 200L);
                return;
            }
            this.awe.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.awf == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                fn("account delete");
            }
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.t.deleting), new h(this, z2));
            this.awf = new i(this, z, accountData);
            this.awf.setPriority(3);
            Fa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fa() {
        if (this.awf != null) {
            if (Fb()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.awf.execute(new Object[0]);
        }
    }

    private void fn(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().ev();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    private boolean Fb() {
        return MessageManager.getInstance().getSocketClient().ey() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }
}

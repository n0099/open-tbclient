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
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity<AccountActivity> {
    private NavigationBar mNavigationBar;
    private ArrayList<AccountData> amz = null;
    private m amA = null;
    private ListView mList = null;
    private RelativeLayout Qx = null;
    private TextView amB = null;
    private View.OnClickListener amC = null;
    private k amD = null;
    private i amE = null;
    private Handler mHandler = new b(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015006, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.account_activity);
        AP();
        InitUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.Qx);
        this.amA.notifyDataSetChanged();
    }

    private void AP() {
        this.amz = com.baidu.tbadk.core.account.a.me();
    }

    private void InitUI() {
        this.Qx = (RelativeLayout) findViewById(com.baidu.tieba.w.account_container);
        this.amC = new c(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.account_manager));
        this.amB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.edit));
        this.amB.setOnClickListener(new e(this));
        this.amA = new m(this, this.amC);
        this.amA.s(this.amz);
        this.mList = (ListView) findViewById(com.baidu.tieba.w.list);
        this.mList.setAdapter((ListAdapter) this.amA);
        this.mList.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(AccountData accountData) {
        if (this.amD == null) {
            eK("account changed");
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.z.account_logining), new g(this));
            this.amD = new k(this, accountData);
            this.amD.setPriority(3);
            AQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AQ() {
        if (this.amD != null) {
            if (AS()) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 200L);
                return;
            }
            this.amD.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.amE == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                eK("account delete");
            }
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.z.deleting), new h(this, z2));
            this.amE = new i(this, z, accountData);
            this.amE.setPriority(3);
            AR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AR() {
        if (this.amE != null) {
            if (AS()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.amE.execute(new Object[0]);
        }
    }

    private void eK(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().aV();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    private boolean AS() {
        return MessageManager.getInstance().getSocketClient().aY() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }
}

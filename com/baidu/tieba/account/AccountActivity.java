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
    private ArrayList<AccountData> amC = null;
    private m amD = null;
    private ListView mList = null;
    private RelativeLayout QB = null;
    private TextView amE = null;
    private View.OnClickListener amF = null;
    private k amG = null;
    private i amH = null;
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
        AV();
        InitUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.QB);
        this.amD.notifyDataSetChanged();
    }

    private void AV() {
        this.amC = com.baidu.tbadk.core.account.a.ml();
    }

    private void InitUI() {
        this.QB = (RelativeLayout) findViewById(com.baidu.tieba.w.account_container);
        this.amF = new c(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.account_manager));
        this.amE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.edit));
        this.amE.setOnClickListener(new e(this));
        this.amD = new m(this, this.amF);
        this.amD.s(this.amC);
        this.mList = (ListView) findViewById(com.baidu.tieba.w.list);
        this.mList.setAdapter((ListAdapter) this.amD);
        this.mList.setOnItemClickListener(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(AccountData accountData) {
        if (this.amG == null) {
            eN("account changed");
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.z.account_logining), new g(this));
            this.amG = new k(this, accountData);
            this.amG.setPriority(3);
            AW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AW() {
        if (this.amG != null) {
            if (AY()) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(2), 200L);
                return;
            }
            this.amG.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, AccountData accountData) {
        if (this.amH == null) {
            boolean z2 = (accountData == null || accountData.getID() == null || !accountData.getID().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (z2) {
                eN("account delete");
            }
            showLoadingDialog(getPageContext().getString(com.baidu.tieba.z.deleting), new h(this, z2));
            this.amH = new i(this, z, accountData);
            this.amH.setPriority(3);
            AX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AX() {
        if (this.amH != null) {
            if (AY()) {
                this.mHandler.removeMessages(1);
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 200L);
                return;
            }
            this.amH.execute(new Object[0]);
        }
    }

    private void eN(String str) {
        BdSocketLinkService.setHasAbsoluteClose(true);
        MessageManager.getInstance().getSocketClient().aV();
        BdSocketLinkService.setAvailable(false);
        BdSocketLinkService.close(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eO(String str) {
        BdSocketLinkService.setHasAbsoluteClose(false);
        BdSocketLinkService.setAvailable(true);
        BdSocketLinkService.startService(true, str);
    }

    private boolean AY() {
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

package com.baidu.tieba.account;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AccountActivity extends BaseActivity {
    private NavigationBar mNavigationBar;
    private ArrayList<AccountData> aeq = null;
    private l aer = null;
    private ListView mList = null;
    private RelativeLayout KP = null;
    private TextView aes = null;
    private View.OnClickListener aet = null;
    private i aeu = null;
    private f aev = null;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015006, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.account_activity);
        xd();
        iT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.KP);
        this.aer.notifyDataSetChanged();
    }

    private void xd() {
        this.aeq = com.baidu.tbadk.core.account.a.jB();
    }

    private void iT() {
        this.KP = (RelativeLayout) findViewById(com.baidu.tieba.v.account_container);
        this.aet = new b(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.account_manager));
        this.aes = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.edit));
        this.aes.setOnClickListener(new d(this));
        this.aer = new l(this, this.aet);
        this.aer.setData(this.aeq);
        this.mList = (ListView) findViewById(com.baidu.tieba.v.list);
        this.mList.setAdapter((ListAdapter) this.aer);
        this.mList.setOnItemClickListener(new e(this));
    }
}

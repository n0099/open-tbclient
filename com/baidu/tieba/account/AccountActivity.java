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
    private ArrayList<AccountData> aei = null;
    private l aej = null;
    private ListView mList = null;
    private RelativeLayout KO = null;
    private TextView aek = null;
    private View.OnClickListener ael = null;
    private i aem = null;
    private f aen = null;

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
        xb();
        iT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.KO);
        this.aej.notifyDataSetChanged();
    }

    private void xb() {
        this.aei = com.baidu.tbadk.core.account.a.jB();
    }

    private void iT() {
        this.KO = (RelativeLayout) findViewById(com.baidu.tieba.v.account_container);
        this.ael = new b(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.account_manager));
        this.aek = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.edit));
        this.aek.setOnClickListener(new d(this));
        this.aej = new l(this, this.ael);
        this.aej.setData(this.aei);
        this.mList = (ListView) findViewById(com.baidu.tieba.v.list);
        this.mList.setAdapter((ListAdapter) this.aej);
        this.mList.setOnItemClickListener(new e(this));
    }
}

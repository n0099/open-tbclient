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
public class AccountActivity extends BaseActivity<AccountActivity> {
    private NavigationBar mNavigationBar;
    private ArrayList<AccountData> alI = null;
    private l alJ = null;
    private ListView mList = null;
    private RelativeLayout Qa = null;
    private TextView alK = null;
    private View.OnClickListener alL = null;
    private i alM = null;
    private f alN = null;

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
        Ax();
        InitUI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.Qa);
        this.alJ.notifyDataSetChanged();
    }

    private void Ax() {
        this.alI = com.baidu.tbadk.core.account.a.ml();
    }

    private void InitUI() {
        this.Qa = (RelativeLayout) findViewById(com.baidu.tieba.w.account_container);
        this.alL = new b(this);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.account_manager));
        this.alK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.edit));
        this.alK.setOnClickListener(new d(this));
        this.alJ = new l(this, this.alL);
        this.alJ.r(this.alI);
        this.mList = (ListView) findViewById(com.baidu.tieba.w.list);
        this.mList.setAdapter((ListAdapter) this.alJ);
        this.mList.setOnItemClickListener(new e(this));
    }
}

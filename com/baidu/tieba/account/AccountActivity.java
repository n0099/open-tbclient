package com.baidu.tieba.account;

import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AccountActivity extends com.baidu.tbadk.a {
    private NavigationBar e;
    private ArrayList<AccountData> a = null;
    private l b = null;
    private ListView c = null;
    private RelativeLayout d = null;
    private TextView f = null;
    private View.OnClickListener g = null;
    private i h = null;
    private f i = null;

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015006, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.account_activity);
        this.a = com.baidu.tbadk.core.a.o.d();
        this.d = (RelativeLayout) findViewById(com.baidu.tieba.a.h.account_container);
        this.g = new b(this);
        this.e = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e.a(getString(com.baidu.tieba.a.k.account_manager));
        this.f = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.a.k.edit));
        this.f.setOnClickListener(new d(this));
        this.b = new l(this, this.g);
        this.b.a(this.a);
        this.c = (ListView) findViewById(com.baidu.tieba.a.h.list);
        this.c.setAdapter((ListAdapter) this.b);
        this.c.setOnItemClickListener(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.e.b(i);
        getLayoutMode().a(i == 1);
        getLayoutMode().a(this.d);
        this.b.notifyDataSetChanged();
    }
}

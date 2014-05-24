package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarHistoryActivity extends BaseActivity implements com.baidu.adp.widget.ListView.x {
    private ag b;
    private ab c;
    private ad d;
    private List<ba> e;
    private int a = 0;
    private boolean f = false;

    public static void a(Context context, int i) {
        Intent intent = new Intent(context, OfficialBarHistoryActivity.class);
        intent.putExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, i);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b();
        d();
        a(bundle);
    }

    private void b() {
        this.c = new ab(this);
        this.d = new ad(this);
        MessageManager.getInstance().registerListener(this.c);
        MessageManager.getInstance().registerListener(this.d);
    }

    private void c() {
        MessageManager.getInstance().unRegisterListener(this.c);
        MessageManager.getInstance().unRegisterListener(this.d);
    }

    private void d() {
        this.b = new ag(this);
        this.b.a(this);
    }

    private void a(Bundle bundle) {
        this.a = getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.FORUM_ID, 0);
        MessageManager.getInstance().sendMessage(new RequestLocalHistoryMessage(String.valueOf(this.a)));
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i = (this.e == null || this.e.isEmpty()) ? 0 : this.e.get(this.e.size() - 1).d;
        this.f = true;
        showProgressBar();
        MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.a, com.baidu.adp.lib.f.b.a(TbadkApplication.getCurrentAccount(), 0), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void f_() {
        if (!this.f) {
            e();
        }
    }
}

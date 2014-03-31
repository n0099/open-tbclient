package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarHistoryActivity extends com.baidu.tbadk.a implements com.baidu.adp.widget.ListView.t {
    private ai b;
    private ab c;
    private ad d;
    private List<bf> e;
    private int a = 0;
    private boolean f = false;

    public static void a(Context context, int i) {
        Intent intent = new Intent(context, OfficialBarHistoryActivity.class);
        intent.putExtra("forum_id", i);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = new ab(this);
        this.d = new ad(this);
        com.baidu.adp.framework.c.a().a(this.c);
        com.baidu.adp.framework.c.a().a(this.d);
        this.b = new ai(this);
        this.b.a(this);
        this.a = getIntent().getIntExtra("forum_id", 0);
        com.baidu.adp.framework.c.a().a(new bd(String.valueOf(this.a)));
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int i = (this.e == null || this.e.isEmpty()) ? 0 : this.e.get(this.e.size() - 1).d;
        this.f = true;
        showProgressBar();
        com.baidu.adp.framework.c.a().a(new bc(this.a, com.baidu.adp.lib.f.b.a(TbadkApplication.E(), 0), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.framework.c.a().b(this.c);
        com.baidu.adp.framework.c.a().b(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.a(i);
    }

    @Override // com.baidu.adp.widget.ListView.t
    public final void b() {
        if (!this.f) {
            a();
        }
    }
}

package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarHistoryActivity extends BaseActivity implements com.baidu.adp.widget.ListView.aa {
    private af aRh;
    private aa aRi;
    private ac aRj;
    private List<az> aRk;
    private int aRg = 0;
    private boolean aRl = false;

    public static void j(Context context, int i) {
        Intent intent = new Intent(context, OfficialBarHistoryActivity.class);
        intent.putExtra("forum_id", i);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HJ();
        initUI();
        d(bundle);
    }

    private void HJ() {
        this.aRi = new aa(this);
        this.aRj = new ac(this);
        registerListener(this.aRi);
        registerListener(this.aRj);
    }

    private void initUI() {
        this.aRh = new af(this);
        this.aRh.b(this);
    }

    private void d(Bundle bundle) {
        this.aRg = getIntent().getIntExtra("forum_id", 0);
        MessageManager.getInstance().sendMessage(new RequestLocalHistoryMessage(String.valueOf(this.aRg)));
        Kq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kq() {
        int i = (this.aRk == null || this.aRk.isEmpty()) ? 0 : this.aRk.get(this.aRk.size() - 1).id;
        this.aRl = true;
        MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.aRg, com.baidu.adp.lib.g.c.f(TbadkApplication.getCurrentAccount(), 0), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aRh.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        if (!this.aRl) {
            Kq();
        }
    }
}

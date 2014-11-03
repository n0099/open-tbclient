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
    private af aRv;
    private aa aRw;
    private ac aRx;
    private List<az> aRy;
    private int aRu = 0;
    private boolean aRz = false;

    public static void j(Context context, int i) {
        Intent intent = new Intent(context, OfficialBarHistoryActivity.class);
        intent.putExtra("forum_id", i);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HN();
        initUI();
        d(bundle);
    }

    private void HN() {
        this.aRw = new aa(this);
        this.aRx = new ac(this);
        registerListener(this.aRw);
        registerListener(this.aRx);
    }

    private void initUI() {
        this.aRv = new af(this);
        this.aRv.b(this);
    }

    private void d(Bundle bundle) {
        this.aRu = getIntent().getIntExtra("forum_id", 0);
        MessageManager.getInstance().sendMessage(new RequestLocalHistoryMessage(String.valueOf(this.aRu)));
        Ku();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ku() {
        int i = (this.aRy == null || this.aRy.isEmpty()) ? 0 : this.aRy.get(this.aRy.size() - 1).id;
        this.aRz = true;
        MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.aRu, com.baidu.adp.lib.g.c.f(TbadkApplication.getCurrentAccount(), 0), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aRv.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.ListView.aa
    public void hQ() {
        if (!this.aRz) {
            Ku();
        }
    }
}

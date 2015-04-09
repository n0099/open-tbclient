package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarHistoryActivity extends BaseActivity<OfficialBarHistoryActivity> implements com.baidu.adp.widget.ListView.x {
    private List<au> aEJ;
    private ag aZr;
    private ab aZs;
    private ad aZt;
    private int aZq = 0;
    private boolean aZu = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HH();
        initUI();
        initData(bundle);
    }

    private void HH() {
        this.aZs = new ab(this);
        this.aZt = new ad(this);
        registerListener(this.aZs);
        registerListener(this.aZt);
    }

    private void initUI() {
        this.aZr = new ag(this);
        this.aZr.b(this);
    }

    private void initData(Bundle bundle) {
        this.aZq = getIntent().getIntExtra("forum_id", 0);
        MessageManager.getInstance().sendMessage(new RequestLocalHistoryMessage(String.valueOf(this.aZq)));
        Om();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Om() {
        int i = (this.aEJ == null || this.aEJ.isEmpty()) ? 0 : this.aEJ.get(this.aEJ.size() - 1).id;
        this.aZu = true;
        MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.aZq, com.baidu.adp.lib.g.c.toInt(TbadkApplication.getCurrentAccount(), 0), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aZr.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (!this.aZu) {
            Om();
        }
    }
}

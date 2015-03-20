package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarHistoryActivity extends BaseActivity<OfficialBarHistoryActivity> implements com.baidu.adp.widget.ListView.x {
    private List<au> aEB;
    private ag aZb;
    private ab aZc;
    private ad aZd;
    private int aZa = 0;
    private boolean aZe = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HB();
        initUI();
        initData(bundle);
    }

    private void HB() {
        this.aZc = new ab(this);
        this.aZd = new ad(this);
        registerListener(this.aZc);
        registerListener(this.aZd);
    }

    private void initUI() {
        this.aZb = new ag(this);
        this.aZb.b(this);
    }

    private void initData(Bundle bundle) {
        this.aZa = getIntent().getIntExtra("forum_id", 0);
        MessageManager.getInstance().sendMessage(new RequestLocalHistoryMessage(String.valueOf(this.aZa)));
        NZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NZ() {
        int i = (this.aEB == null || this.aEB.isEmpty()) ? 0 : this.aEB.get(this.aEB.size() - 1).id;
        this.aZe = true;
        MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.aZa, com.baidu.adp.lib.g.c.toInt(TbadkApplication.getCurrentAccount(), 0), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aZb.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        if (!this.aZe) {
            NZ();
        }
    }
}

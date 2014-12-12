package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.OfficialBarHistoryActivityConfig;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarHistoryActivity extends BaseActivity<OfficialBarHistoryActivity> implements com.baidu.adp.widget.ListView.ab {
    private af aTb;
    private aa aTc;
    private ac aTd;
    private List<aq> aTe;
    private int aTa = 0;
    private boolean aTf = false;

    static {
        TbadkApplication.getInst().RegisterIntent(OfficialBarHistoryActivityConfig.class, OfficialBarHistoryActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        JJ();
        initUI();
        initData(bundle);
    }

    private void JJ() {
        this.aTc = new aa(this);
        this.aTd = new ac(this);
        registerListener(this.aTc);
        registerListener(this.aTd);
    }

    private void initUI() {
        this.aTb = new af(this);
        this.aTb.b(this);
    }

    private void initData(Bundle bundle) {
        this.aTa = getIntent().getIntExtra("forum_id", 0);
        MessageManager.getInstance().sendMessage(new RequestLocalHistoryMessage(String.valueOf(this.aTa)));
        KD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KD() {
        int i = (this.aTe == null || this.aTe.isEmpty()) ? 0 : this.aTe.get(this.aTe.size() - 1).id;
        this.aTf = true;
        MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.aTa, com.baidu.adp.lib.g.c.toInt(TbadkApplication.getCurrentAccount(), 0), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aTb.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        if (!this.aTf) {
            KD();
        }
    }
}

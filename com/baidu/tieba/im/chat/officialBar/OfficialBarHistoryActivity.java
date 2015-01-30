package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.OfficialBarHistoryActivityConfig;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarHistoryActivity extends BaseActivity<OfficialBarHistoryActivity> implements com.baidu.adp.widget.ListView.ab {
    private af aUr;
    private aa aUs;
    private ac aUt;
    private List<aq> aUu;
    private int aUq = 0;
    private boolean aUv = false;

    static {
        TbadkApplication.getInst().RegisterIntent(OfficialBarHistoryActivityConfig.class, OfficialBarHistoryActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Ke();
        initUI();
        initData(bundle);
    }

    private void Ke() {
        this.aUs = new aa(this);
        this.aUt = new ac(this);
        registerListener(this.aUs);
        registerListener(this.aUt);
    }

    private void initUI() {
        this.aUr = new af(this);
        this.aUr.b(this);
    }

    private void initData(Bundle bundle) {
        this.aUq = getIntent().getIntExtra("forum_id", 0);
        MessageManager.getInstance().sendMessage(new RequestLocalHistoryMessage(String.valueOf(this.aUq)));
        KY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KY() {
        int i = (this.aUu == null || this.aUu.isEmpty()) ? 0 : this.aUu.get(this.aUu.size() - 1).id;
        this.aUv = true;
        MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.aUq, com.baidu.adp.lib.g.c.toInt(TbadkApplication.getCurrentAccount(), 0), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aUr.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        if (!this.aUv) {
            KY();
        }
    }
}

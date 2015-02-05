package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.OfficialBarHistoryActivityConfig;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarHistoryActivity extends BaseActivity<OfficialBarHistoryActivity> implements com.baidu.adp.widget.ListView.ab {
    private af aUq;
    private aa aUr;
    private ac aUs;
    private List<aq> aUt;
    private int aUp = 0;
    private boolean aUu = false;

    static {
        TbadkApplication.getInst().RegisterIntent(OfficialBarHistoryActivityConfig.class, OfficialBarHistoryActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        JZ();
        initUI();
        initData(bundle);
    }

    private void JZ() {
        this.aUr = new aa(this);
        this.aUs = new ac(this);
        registerListener(this.aUr);
        registerListener(this.aUs);
    }

    private void initUI() {
        this.aUq = new af(this);
        this.aUq.b(this);
    }

    private void initData(Bundle bundle) {
        this.aUp = getIntent().getIntExtra("forum_id", 0);
        MessageManager.getInstance().sendMessage(new RequestLocalHistoryMessage(String.valueOf(this.aUp)));
        KT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KT() {
        int i = (this.aUt == null || this.aUt.isEmpty()) ? 0 : this.aUt.get(this.aUt.size() - 1).id;
        this.aUu = true;
        MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.aUp, com.baidu.adp.lib.g.c.toInt(TbadkApplication.getCurrentAccount(), 0), i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aUq.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        if (!this.aUu) {
            KT();
        }
    }
}

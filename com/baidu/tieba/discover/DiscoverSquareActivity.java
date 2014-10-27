package com.baidu.tieba.discover;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.DailyRecommendActivityConfig;
import com.baidu.tbadk.core.atomData.DiscoverSquareActivityConfig;
import com.baidu.tbadk.core.atomData.SingleForumFeedActivityConfig;
import com.baidu.tbadk.core.atomData.SingleSquareActivityConfig;
/* loaded from: classes.dex */
public class DiscoverSquareActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private v aoa;

    static {
        TbadkApplication.m251getInst().RegisterIntent(DiscoverSquareActivityConfig.class, DiscoverSquareActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initUI();
    }

    private void initUI() {
        this.aoa = new v(this);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (i) {
            case 0:
                sendMessage(new CustomMessage(2010010, new SingleSquareActivityConfig(this)));
                return;
            case 1:
                sendMessage(new CustomMessage(2010020, new DailyRecommendActivityConfig(this, "faxian")));
                return;
            case 2:
                sendMessage(new CustomMessage(2010011, new SingleForumFeedActivityConfig(this)));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.aoa.onChangeSkinType(i);
    }
}

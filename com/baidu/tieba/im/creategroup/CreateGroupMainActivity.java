package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.CreateGroupMainActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class CreateGroupMainActivity extends BaseActivity<CreateGroupMainActivity> {
    f eDA = null;
    private int eDB;
    private int eDC;
    private int eDD;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eDA = new f(this);
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(CreateGroupMainActivityConfig.CANCRRATEOFFICIALGROUP, false);
        boolean booleanExtra2 = intent.getBooleanExtra(CreateGroupMainActivityConfig.CANCREATECOMMONGROUP, false);
        String stringExtra = intent.getStringExtra(CreateGroupMainActivityConfig.CREATEGROUPOFFICIALTIP);
        String stringExtra2 = intent.getStringExtra(CreateGroupMainActivityConfig.CREATECOMMONGROUPTIP);
        int intExtra = intent.getIntExtra("forumid", 0);
        this.eDB = intent.getIntExtra("num_create_group_normal", 0);
        this.eDC = intent.getIntExtra("num_create_group_offical", 0);
        this.eDD = intent.getIntExtra("num_create_group_private", 0);
        this.eDA.a(booleanExtra, booleanExtra2, stringExtra, stringExtra2, intExtra);
        TiebaStatic.eventStat(getPageContext().getContext(), "create_g_bz_pv", "pv", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eDA.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eDA.aNQ()) {
            sendMessage(new CustomMessage(2002001, new CreateGroupStepActivityConfig(getPageContext().getContext(), 3, this.eDA.getForumId(), 1013, this.eDB, this.eDC, this.eDD)));
            TiebaStatic.eventStat(getPageContext().getContext(), "create_g_common", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
        } else if (view == this.eDA.aNR()) {
            sendMessage(new CustomMessage(2002001, new CreateGroupStepActivityConfig(getPageContext().getContext(), 4, this.eDA.getForumId(), 1013, this.eDB, this.eDC, this.eDD)));
            TiebaStatic.eventStat(getPageContext().getContext(), "create_g_official", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
        }
        finish();
    }
}

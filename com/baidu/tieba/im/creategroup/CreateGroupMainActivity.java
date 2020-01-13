package com.baidu.tieba.im.creategroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.CreateGroupMainActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes8.dex */
public class CreateGroupMainActivity extends BaseActivity<CreateGroupMainActivity> {
    f hud = null;
    private int hue;
    private int huf;
    private int hug;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hud = new f(this);
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(CreateGroupMainActivityConfig.CANCRRATEOFFICIALGROUP, false);
        boolean booleanExtra2 = intent.getBooleanExtra(CreateGroupMainActivityConfig.CANCREATECOMMONGROUP, false);
        String stringExtra = intent.getStringExtra(CreateGroupMainActivityConfig.CREATEGROUPOFFICIALTIP);
        String stringExtra2 = intent.getStringExtra(CreateGroupMainActivityConfig.CREATECOMMONGROUPTIP);
        int intExtra = intent.getIntExtra("forumid", 0);
        this.hue = intent.getIntExtra("num_create_group_normal", 0);
        this.huf = intent.getIntExtra("num_create_group_offical", 0);
        this.hug = intent.getIntExtra("num_create_group_private", 0);
        this.hud.a(booleanExtra, booleanExtra2, stringExtra, stringExtra2, intExtra);
        TiebaStatic.eventStat(getPageContext().getContext(), "create_g_bz_pv", "pv", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hud.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hud.bRA()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateGroupStepActivityConfig(getPageContext().getContext(), 3, this.hud.getForumId(), 1013, this.hue, this.huf, this.hug)));
            TiebaStatic.eventStat(getPageContext().getContext(), "create_g_common", "click", 1, new Object[0]);
        } else if (view == this.hud.bRB()) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateGroupStepActivityConfig(getPageContext().getContext(), 4, this.hud.getForumId(), 1013, this.hue, this.huf, this.hug)));
            TiebaStatic.eventStat(getPageContext().getContext(), "create_g_official", "click", 1, new Object[0]);
        }
        finish();
    }
}

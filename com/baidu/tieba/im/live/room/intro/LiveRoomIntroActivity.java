package com.baidu.tieba.im.live.room.intro;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ag;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
/* loaded from: classes.dex */
public class LiveRoomIntroActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private e a = null;
    private d b = null;
    private final com.baidu.adp.framework.listener.b c = new a(this, 0);

    static {
        TbadkApplication.m252getInst().RegisterIntent(ag.class, LiveRoomIntroActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.b = new d(bundle.getInt(com.baidu.tbadk.core.frameworkData.a.GROUP_ID), bundle.getInt(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_ID), bundle.getString(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_NAME));
        } else if (getIntent() != null) {
            this.b = new d(getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.GROUP_ID, 0), getIntent().getIntExtra(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_ID, 0), getIntent().getStringExtra(com.baidu.tbadk.core.frameworkData.a.PUBLISHER_NAME));
        }
        this.a = new e(this);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_QUERY_LIVE_ROOM_INTRO, this.c);
        this.b.a(this);
        this.a.a(true);
        this.a.a(this.b.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.c);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.b.a(bundle, com.baidu.tbadk.core.frameworkData.a.GROUP_ID);
        this.b.b(bundle, com.baidu.tbadk.core.frameworkData.a.PUBLISHER_ID);
        this.b.c(bundle, com.baidu.tbadk.core.frameworkData.a.PUBLISHER_NAME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.a.a(getLayoutMode(), i);
    }

    public void changSkinType(View view) {
        getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        getLayoutMode().a(view);
    }
}

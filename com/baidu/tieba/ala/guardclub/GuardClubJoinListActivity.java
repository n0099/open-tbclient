package com.baidu.tieba.ala.guardclub;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
import com.baidu.live.view.BackBar;
/* loaded from: classes3.dex */
public class GuardClubJoinListActivity extends BaseActivity<GuardClubJoinListActivity> {
    private TextView aGj;
    private HttpMessageListener axG = new HttpMessageListener(1021132) { // from class: com.baidu.tieba.ala.guardclub.GuardClubJoinListActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021132 && (httpResponsedMessage instanceof LiveSyncHttpResponseMessage)) {
                if ((httpResponsedMessage.getError() == 0) && ((LiveSyncHttpResponseMessage) httpResponsedMessage).yX() != null && GuardClubJoinListActivity.this.eFe != null) {
                    GuardClubJoinListActivity.this.eFe.notifyDataSetInvalidated();
                }
            }
        }
    };
    private g eFe;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (BdBaseApplication.getInst() == null) {
            if (TbConfig.sdkInitCallback == null) {
                super.finish();
                return;
            }
            TbConfig.sdkInitCallback.initSdk();
        }
        setContentView(a.h.activity_guard_club_join_list);
        View findViewById = findViewById(a.g.view_status_bar);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = UtilHelper.getStatusBarHeight();
            findViewById.setLayoutParams(layoutParams);
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(a.g.container_guard_club_join_list);
        this.aGj = (TextView) findViewById(a.g.tv_guard_club_list_title);
        View findViewById2 = findViewById(a.g.img_guard_club_list_back);
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubJoinListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuardClubJoinListActivity.this.finish();
            }
        });
        BackBar backBar = (BackBar) findViewById(a.g.backbar);
        backBar.setCallback(new BackBar.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubJoinListActivity.2
            @Override // com.baidu.live.view.BackBar.a
            public void onBack() {
                GuardClubJoinListActivity.this.finish();
            }
        });
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            findViewById2.setVisibility(8);
            backBar.setVisibility(0);
        } else {
            findViewById2.setVisibility(0);
            backBar.setVisibility(8);
        }
        this.eFe = new g(this, getIntent().getStringExtra(IntentConfig.OTHER_PARAMS), getUniqueId());
        View view = this.eFe.getView();
        if (view != null) {
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
        MessageManager.getInstance().registerListener(this.axG);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eFe != null) {
            this.eFe.aqx();
        }
    }
}

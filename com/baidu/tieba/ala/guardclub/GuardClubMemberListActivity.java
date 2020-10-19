package com.baidu.tieba.ala.guardclub;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.view.BackBar;
import com.baidu.tieba.ala.guardclub.model.g;
/* loaded from: classes4.dex */
public class GuardClubMemberListActivity extends BaseActivity<GuardClubMemberListActivity> {
    private TextView bEQ;
    private j gpT;
    private g.a gqD = new g.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubMemberListActivity.3
        @Override // com.baidu.tieba.ala.guardclub.model.g.a
        public void uh(int i) {
            if (GuardClubMemberListActivity.this.bEQ != null) {
                GuardClubMemberListActivity.this.bEQ.setText(String.format(GuardClubMemberListActivity.this.getString(a.i.guard_member_number), Integer.valueOf(i)));
            }
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.GuardClubMemberListActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                GuardClubMemberListActivity.this.closeActivity();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        if (!isFinishing()) {
            setContentView(a.h.activity_guard_club_menber_list);
            View findViewById = findViewById(a.g.view_status_bar);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                findViewById.setLayoutParams(layoutParams);
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(a.g.container_guard_club_member_list);
            this.bEQ = (TextView) findViewById(a.g.tv_guard_club_list_title);
            View findViewById2 = findViewById(a.g.img_guard_club_list_back);
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.GuardClubMemberListActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GuardClubMemberListActivity.this.finish();
                }
            });
            BackBar backBar = (BackBar) findViewById(a.g.backbar);
            backBar.setCallback(new BackBar.a() { // from class: com.baidu.tieba.ala.guardclub.GuardClubMemberListActivity.2
                @Override // com.baidu.live.view.BackBar.a
                public void onBack() {
                    GuardClubMemberListActivity.this.finish();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                findViewById2.setVisibility(8);
                backBar.setVisibility(0);
            } else {
                findViewById2.setVisibility(0);
                backBar.setVisibility(8);
            }
            this.gpT = new j(this, getIntent().getLongExtra("live_id", 0L), getIntent().getLongExtra("room_id", 0L), getIntent().getLongExtra("anchor_id", 0L), getIntent().getStringExtra("feed_id"), getIntent().getBooleanExtra("is_live_owner", false), true, true, true, getIntent().getStringExtra(IntentConfig.OTHER_PARAMS), getUniqueId(), this.gqD);
            View view = this.gpT.getView();
            if (view != null) {
                frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                LogManager.getGuardClubLogger().doAccessLiveGuardMemberLog(null, null, null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        setResult(-1);
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gpT != null) {
            this.gpT.aTM();
        }
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
    }
}

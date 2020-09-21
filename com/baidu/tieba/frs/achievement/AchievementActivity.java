package com.baidu.tieba.frs.achievement;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class AchievementActivity extends BaseActivity {
    private c ift;
    private a ifu;
    private View.OnClickListener ifv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.AchievementActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AchievementActivity.this.ift.setDisplay(false);
            AchievementActivity.this.ifu.setDisplay(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_achievement);
        this.ift = new c(getPageContext(), findViewById(R.id.layout_thanks_letter));
        this.ift.setDisplay(true);
        this.ift.z(this.ifv);
        this.ifu = new a(getPageContext(), findViewById(R.id.layout_invite_letter));
        this.ifu.setDisplay(false);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ift.onChangeSkinType(i);
        this.ifu.onChangeSkinType(i);
    }
}

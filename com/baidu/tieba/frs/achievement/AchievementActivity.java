package com.baidu.tieba.frs.achievement;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class AchievementActivity extends BaseActivity {
    private c hYj;
    private a hYk;
    private View.OnClickListener hYl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.AchievementActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AchievementActivity.this.hYj.setDisplay(false);
            AchievementActivity.this.hYk.setDisplay(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_achievement);
        this.hYj = new c(getPageContext(), findViewById(R.id.layout_thanks_letter));
        this.hYj.setDisplay(true);
        this.hYj.z(this.hYl);
        this.hYk = new a(getPageContext(), findViewById(R.id.layout_invite_letter));
        this.hYk.setDisplay(false);
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
        this.hYj.onChangeSkinType(i);
        this.hYk.onChangeSkinType(i);
    }
}

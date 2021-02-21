package com.baidu.tieba.frs.achievement;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class AchievementActivity extends BaseActivity {
    private c jlQ;
    private a jlR;
    private View.OnClickListener jlS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.achievement.AchievementActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AchievementActivity.this.jlQ.setDisplay(false);
            AchievementActivity.this.jlR.setDisplay(true);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_achievement);
        this.jlQ = new c(getPageContext(), findViewById(R.id.layout_thanks_letter));
        this.jlQ.setDisplay(true);
        this.jlQ.B(this.jlS);
        this.jlR = new a(getPageContext(), findViewById(R.id.layout_invite_letter));
        this.jlR.setDisplay(false);
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
        this.jlQ.onChangeSkinType(i);
        this.jlR.onChangeSkinType(i);
    }
}

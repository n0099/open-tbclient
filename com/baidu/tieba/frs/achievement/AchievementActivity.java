package com.baidu.tieba.frs.achievement;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.R;
import d.b.i0.p0.g1.c;
/* loaded from: classes4.dex */
public class AchievementActivity extends BaseActivity {
    public d.b.i0.p0.g1.a inviteLetter;
    public View.OnClickListener onShareClickListener = new a();
    public c thanksLetter;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AchievementActivity.this.thanksLetter.h(false);
            AchievementActivity.this.inviteLetter.h(true);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.thanksLetter.g(i);
        this.inviteLetter.g(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.activity_achievement);
        c cVar = new c(getPageContext(), findViewById(R.id.layout_thanks_letter));
        this.thanksLetter = cVar;
        cVar.h(true);
        this.thanksLetter.j(this.onShareClickListener);
        d.b.i0.p0.g1.a aVar = new d.b.i0.p0.g1.a(getPageContext(), findViewById(R.id.layout_invite_letter));
        this.inviteLetter = aVar;
        aVar.h(false);
    }
}

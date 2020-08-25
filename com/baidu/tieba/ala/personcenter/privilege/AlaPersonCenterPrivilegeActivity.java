package com.baidu.tieba.ala.personcenter.privilege;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.ala.widget.multicolumn.absView.AbsTabActivity;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.AlaAchievementMarkFragment;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaPrivilegeFragmentAdapter;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class AlaPersonCenterPrivilegeActivity extends AbsTabActivity {
    private LinkedList<AbsFragment> gUb = new LinkedList<>();
    private AlaPrivilegeFragmentAdapter gUc;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    public void onPreInit() {
        super.onPreInit();
        if (!y.isEmpty(this.gUb)) {
            this.gUb.clear();
        }
        this.gUb.add(new AlaAchievementMarkFragment());
        this.gUb.add(new AlaEnterEffectFragment());
        this.gUc = new AlaPrivilegeFragmentAdapter(getSupportFragmentManager(), this.gUb);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    protected void setNavigationBar(NavigationBar navigationBar) {
        navigationBar.setCenterTextTitle(getResources().getString(R.string.ala_person_live_privilege));
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.ala.personcenter.privilege.AlaPersonCenterPrivilegeActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaPersonCenterPrivilegeActivity.this.finish();
            }
        });
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    protected AbsTabPagerAdapter getAdapter() {
        return this.gUc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!y.isEmpty(this.gUb)) {
            Iterator<AbsFragment> it = this.gUb.iterator();
            while (it.hasNext()) {
                AbsFragment next = it.next();
                if (next != null) {
                    next.onActivityResult(i, i2, intent);
                }
            }
        }
    }
}

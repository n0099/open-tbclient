package com.baidu.tieba.ala.personcenter.privilege;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.ala.widget.multicolumn.absView.AbsTabActivity;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.privilege.achievementmark.AlaAchievementMarkFragment;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaEnterEffectFragment;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.AlaPrivilegeFragmentAdapter;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class AlaPersonCenterPrivilegeActivity extends AbsTabActivity {
    public AlaPrivilegeFragmentAdapter mFragmentAdapter;
    public LinkedList<AbsFragment> mFragmentList = new LinkedList<>();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AlaPersonCenterPrivilegeActivity.this.finish();
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    public AbsTabPagerAdapter getAdapter() {
        return this.mFragmentAdapter;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (ListUtils.isEmpty(this.mFragmentList)) {
            return;
        }
        Iterator<AbsFragment> it = this.mFragmentList.iterator();
        while (it.hasNext()) {
            AbsFragment next = it.next();
            if (next != null) {
                next.onActivityResult(i2, i3, intent);
            }
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity, com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    public void onPreInit() {
        super.onPreInit();
        if (!ListUtils.isEmpty(this.mFragmentList)) {
            this.mFragmentList.clear();
        }
        this.mFragmentList.add(new AlaAchievementMarkFragment());
        this.mFragmentList.add(new AlaEnterEffectFragment());
        this.mFragmentAdapter = new AlaPrivilegeFragmentAdapter(getSupportFragmentManager(), this.mFragmentList);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabActivity
    public void setNavigationBar(NavigationBar navigationBar) {
        navigationBar.setCenterTextTitle(getResources().getString(R.string.ala_person_live_privilege));
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
    }
}

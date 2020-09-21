package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class AlaPrivilegeFragmentAdapter extends AbsTabPagerAdapter {
    private LinkedList<AbsFragment> gXM;

    public AlaPrivilegeFragmentAdapter(FragmentManager fragmentManager, LinkedList<AbsFragment> linkedList) {
        super(fragmentManager);
        this.gXM = new LinkedList<>();
        if (!y.isEmpty(linkedList)) {
            if (!y.isEmpty(this.gXM)) {
                this.gXM.clear();
            }
            this.gXM.addAll(linkedList);
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i) {
        return i;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i) {
        return (i < 0 || i >= this.gXM.size()) ? "" : this.gXM.get(i).getTabTitle();
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return (AbsFragment) y.getItem(this.gXM, i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.gXM);
    }
}

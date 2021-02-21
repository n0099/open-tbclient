package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
/* loaded from: classes10.dex */
public class AlaPrivilegeFragmentAdapter extends AbsTabPagerAdapter {
    private LinkedList<AbsFragment> ias;

    public AlaPrivilegeFragmentAdapter(FragmentManager fragmentManager, LinkedList<AbsFragment> linkedList) {
        super(fragmentManager);
        this.ias = new LinkedList<>();
        if (!y.isEmpty(linkedList)) {
            if (!y.isEmpty(this.ias)) {
                this.ias.clear();
            }
            this.ias.addAll(linkedList);
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i) {
        return i;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i) {
        return (i < 0 || i >= this.ias.size()) ? "" : this.ias.get(i).getTabTitle();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return (AbsFragment) y.getItem(this.ias, i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return y.getCount(this.ias);
    }
}

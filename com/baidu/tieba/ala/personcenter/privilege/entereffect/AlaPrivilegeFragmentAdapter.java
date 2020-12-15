package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.util.y;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public class AlaPrivilegeFragmentAdapter extends AbsTabPagerAdapter {
    private LinkedList<AbsFragment> hNV;

    public AlaPrivilegeFragmentAdapter(FragmentManager fragmentManager, LinkedList<AbsFragment> linkedList) {
        super(fragmentManager);
        this.hNV = new LinkedList<>();
        if (!y.isEmpty(linkedList)) {
            if (!y.isEmpty(this.hNV)) {
                this.hNV.clear();
            }
            this.hNV.addAll(linkedList);
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i) {
        return i;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i) {
        return (i < 0 || i >= this.hNV.size()) ? "" : this.hNV.get(i).getTabTitle();
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return (AbsFragment) y.getItem(this.hNV, i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return y.getCount(this.hNV);
    }
}

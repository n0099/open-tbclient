package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.util.v;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class AlaPrivilegeFragmentAdapter extends AbsTabPagerAdapter {
    private LinkedList<AbsFragment> fsf;

    public AlaPrivilegeFragmentAdapter(FragmentManager fragmentManager, LinkedList<AbsFragment> linkedList) {
        super(fragmentManager);
        this.fsf = new LinkedList<>();
        if (!v.isEmpty(linkedList)) {
            if (!v.isEmpty(this.fsf)) {
                this.fsf.clear();
            }
            this.fsf.addAll(linkedList);
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i) {
        return i;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i) {
        return (i < 0 || i >= this.fsf.size()) ? "" : this.fsf.get(i).getTabTitle();
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return (AbsFragment) v.getItem(this.fsf, i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return v.getCount(this.fsf);
    }
}

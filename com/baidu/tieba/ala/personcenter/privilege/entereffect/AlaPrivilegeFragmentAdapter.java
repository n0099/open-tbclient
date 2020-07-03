package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.util.w;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class AlaPrivilegeFragmentAdapter extends AbsTabPagerAdapter {
    private LinkedList<AbsFragment> gCb;

    public AlaPrivilegeFragmentAdapter(FragmentManager fragmentManager, LinkedList<AbsFragment> linkedList) {
        super(fragmentManager);
        this.gCb = new LinkedList<>();
        if (!w.isEmpty(linkedList)) {
            if (!w.isEmpty(this.gCb)) {
                this.gCb.clear();
            }
            this.gCb.addAll(linkedList);
        }
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i) {
        return i;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i) {
        return (i < 0 || i >= this.gCb.size()) ? "" : this.gCb.get(i).getTabTitle();
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return (AbsFragment) w.getItem(this.gCb, i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return w.getCount(this.gCb);
    }
}

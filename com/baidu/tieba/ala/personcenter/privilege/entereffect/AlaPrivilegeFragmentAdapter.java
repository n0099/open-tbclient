package com.baidu.tieba.ala.personcenter.privilege.entereffect;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.ala.widget.multicolumn.absView.AbsFragment;
import com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class AlaPrivilegeFragmentAdapter extends AbsTabPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<AbsFragment> f14754a;

    public AlaPrivilegeFragmentAdapter(FragmentManager fragmentManager, LinkedList<AbsFragment> linkedList) {
        super(fragmentManager);
        this.f14754a = new LinkedList<>();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f14754a)) {
            this.f14754a.clear();
        }
        this.f14754a.addAll(linkedList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f14754a);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return (AbsFragment) ListUtils.getItem(this.f14754a, i);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i) {
        return i;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i) {
        return (i < 0 || i >= this.f14754a.size()) ? "" : this.f14754a.get(i).getTabTitle();
    }
}

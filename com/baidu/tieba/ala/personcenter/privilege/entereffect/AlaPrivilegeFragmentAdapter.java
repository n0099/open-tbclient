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
    public LinkedList<AbsFragment> f14838a;

    public AlaPrivilegeFragmentAdapter(FragmentManager fragmentManager, LinkedList<AbsFragment> linkedList) {
        super(fragmentManager);
        this.f14838a = new LinkedList<>();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f14838a)) {
            this.f14838a.clear();
        }
        this.f14838a.addAll(linkedList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f14838a);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        return (AbsFragment) ListUtils.getItem(this.f14838a, i2);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i2) {
        return i2;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i2) {
        return (i2 < 0 || i2 >= this.f14838a.size()) ? "" : this.f14838a.get(i2).getTabTitle();
    }
}

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
    public LinkedList<AbsFragment> f14113a;

    public AlaPrivilegeFragmentAdapter(FragmentManager fragmentManager, LinkedList<AbsFragment> linkedList) {
        super(fragmentManager);
        this.f14113a = new LinkedList<>();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f14113a)) {
            this.f14113a.clear();
        }
        this.f14113a.addAll(linkedList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f14113a);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i2) {
        return (AbsFragment) ListUtils.getItem(this.f14113a, i2);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i2) {
        return i2;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i2) {
        return (i2 < 0 || i2 >= this.f14113a.size()) ? "" : this.f14113a.get(i2).getTabTitle();
    }
}

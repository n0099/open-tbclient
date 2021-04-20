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
    public LinkedList<AbsFragment> f14746a;

    public AlaPrivilegeFragmentAdapter(FragmentManager fragmentManager, LinkedList<AbsFragment> linkedList) {
        super(fragmentManager);
        this.f14746a = new LinkedList<>();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        if (!ListUtils.isEmpty(this.f14746a)) {
            this.f14746a.clear();
        }
        this.f14746a.addAll(linkedList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return ListUtils.getCount(this.f14746a);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return (AbsFragment) ListUtils.getItem(this.f14746a, i);
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public int getPageType(int i) {
        return i;
    }

    @Override // com.baidu.ala.widget.multicolumn.absView.AbsTabPagerAdapter
    public String getTabTitle(int i) {
        return (i < 0 || i >= this.f14746a.size()) ? "" : this.f14746a.get(i).getTabTitle();
    }
}

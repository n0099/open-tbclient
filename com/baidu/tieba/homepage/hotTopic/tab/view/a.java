package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.b;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.List;
/* loaded from: classes21.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private TabLayout.OnTabSelectedListener iTV;
    private TabLayout iUC;
    private int iuC;
    private Context mContext;

    public TabLayout cBo() {
        return this.iUC;
    }

    public Context getContext() {
        return this.mContext;
    }

    public a(Context context) {
        this.mContext = context;
        cBp();
    }

    private void cBp() {
        this.iUC = (TabLayout) LayoutInflater.from(getContext()).inflate(R.layout.default_tab_layout, (ViewGroup) null);
        this.iUC.setOnTabSelectedListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.iTV = onTabSelectedListener;
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.iUC, R.color.cp_bg_line_e);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.iUC.getTabCount()) {
                TabLayout.Tab tabAt = this.iUC.getTabAt(i3);
                if (tabAt != null) {
                    if (tabAt.isSelected()) {
                        setTabColorSelected(tabAt);
                    } else {
                        setTabColorUnSelected(tabAt);
                    }
                    if (tabAt.getCustomView() instanceof TBSpecificationBtn) {
                        ((TBSpecificationBtn) tabAt.getCustomView()).changeSkinType(i);
                    }
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    private void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            ((b) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).pp(R.color.cp_link_tip_a);
        }
    }

    private void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            ((b) ((TBSpecificationBtn) tab.getCustomView()).getStyleConfig()).pr(R.color.cp_cont_c);
        }
    }

    public void a(FrsTabInfoData frsTabInfoData) {
        a(this.iuC, frsTabInfoData.tabList, this.iUC);
    }

    private void a(int i, List<FrsTabItemData> list, TabLayout tabLayout) {
        int min = Math.min(list.size(), 9);
        if (tabLayout.getTabCount() > min) {
            int tabCount = tabLayout.getTabCount() - min;
            for (int i2 = 0; i2 < tabCount; i2++) {
                tabLayout.removeTabAt(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        if (linearLayout != null) {
            int dimens = l.getDimens(getContext(), R.dimen.tbds12);
            int dimens2 = l.getDimens(getContext(), R.dimen.tbds25);
            int dimens3 = l.getDimens(getContext(), R.dimen.tbds32);
            int dimens4 = l.getDimens(getContext(), R.dimen.tbds14);
            for (int i3 = 0; i3 < min; i3++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
                if (tabAt == null) {
                    tabAt = tabLayout.newTab();
                    tabLayout.addTab(tabAt, false);
                    View childAt = linearLayout.getChildAt(i3);
                    if (childAt != null) {
                        childAt.setPadding(0, 0, 0, 0);
                    }
                }
                TabLayout.Tab tab = tabAt;
                FrsTabItemData frsTabItemData = list.get(i3);
                tab.setTag(frsTabItemData);
                if (!(tab.getCustomView() instanceof TBSpecificationBtn)) {
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
                    b bVar = new b();
                    bVar.pl(dimens3);
                    bVar.pm(dimens4);
                    bVar.pr(R.color.cp_cont_c);
                    tBSpecificationBtn.setConfig(bVar);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(dimens, dimens2, dimens, dimens2);
                    tBSpecificationBtn.setLayoutParams(layoutParams);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(at.cutForumNameWithSuffix(frsTabItemData.name, 10, StringHelper.STRING_MORE));
                if (!tab.isSelected() && i == frsTabItemData.tabId) {
                    tab.select();
                }
            }
            int dimens5 = l.getDimens(getContext(), R.dimen.tbds32);
            linearLayout.setPadding(dimens5, 0, dimens5, 0);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
            this.iuC = ((FrsTabItemData) tab.getTag()).tabId;
        }
        setTabColorSelected(tab);
        if (this.iTV != null) {
            this.iTV.onTabSelected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        setTabColorUnSelected(tab);
        if (this.iTV != null) {
            this.iTV.onTabUnselected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        setTabColorSelected(tab);
        if (this.iTV != null) {
            this.iTV.onTabReselected(tab);
        }
    }
}

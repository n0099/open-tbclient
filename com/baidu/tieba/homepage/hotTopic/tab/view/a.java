package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private int jCC;
    private TabLayout kdJ;
    private TabLayout.OnTabSelectedListener kdc;
    private Context mContext;

    public TabLayout cSF() {
        return this.kdJ;
    }

    public Context getContext() {
        return this.mContext;
    }

    public a(Context context) {
        this.mContext = context;
        cSG();
    }

    private void cSG() {
        this.kdJ = (TabLayout) LayoutInflater.from(getContext()).inflate(R.layout.default_tab_layout, (ViewGroup) null);
        this.kdJ.setOnTabSelectedListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.kdc = onTabSelectedListener;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.kdJ.getTabCount()) {
                TabLayout.Tab tabAt = this.kdJ.getTabAt(i3);
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
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tab.getCustomView();
            if (tBSpecificationBtn.getStyleConfig() instanceof c) {
                ((c) tBSpecificationBtn.getStyleConfig()).rs(R.color.CAM_X0304);
            }
        }
    }

    private void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tab.getCustomView();
            if (tBSpecificationBtn.getStyleConfig() instanceof c) {
                ((c) tBSpecificationBtn.getStyleConfig()).ru(R.color.CAM_X0108);
            }
        }
    }

    public void a(FrsTabInfoData frsTabInfoData) {
        a(this.jCC, frsTabInfoData.tabList, this.kdJ);
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
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            linearLayout.requestLayout();
            int dimens = l.getDimens(getContext(), R.dimen.M_W_X006) / 2;
            int dimens2 = l.getDimens(getContext(), R.dimen.M_H_X003);
            int dimens3 = l.getDimens(getContext(), R.dimen.M_H_X001);
            for (int i3 = 0; i3 < min; i3++) {
                TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
                if (tabAt == null) {
                    tabAt = tabLayout.newTab();
                    tabLayout.addTab(tabAt, false);
                    View childAt = linearLayout.getChildAt(i3);
                    ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                    layoutParams2.width = -2;
                    layoutParams2.height = -2;
                    childAt.requestLayout();
                    if (childAt != null) {
                        childAt.setPadding(0, 0, 0, 0);
                    }
                }
                TabLayout.Tab tab = tabAt;
                FrsTabItemData frsTabItemData = list.get(i3);
                tab.setTag(frsTabItemData);
                if (!(tab.getCustomView() instanceof TBSpecificationBtn)) {
                    TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(getContext());
                    c cVar = new c();
                    cVar.ru(R.color.CAM_X0108);
                    tBSpecificationBtn.setConfig(cVar);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds177), UtilHelper.getDimenPixelSize(R.dimen.tbds75));
                    layoutParams3.setMargins(dimens, dimens2, dimens, dimens3);
                    tBSpecificationBtn.setLayoutParams(layoutParams3);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(at.cutForumNameWithSuffix(frsTabItemData.name, 10, StringHelper.STRING_MORE));
                if (!tab.isSelected() && i == frsTabItemData.tabId) {
                    tab.select();
                }
            }
            linearLayout.setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
            this.jCC = ((FrsTabItemData) tab.getTag()).tabId;
        }
        setTabColorSelected(tab);
        if (this.kdc != null) {
            this.kdc.onTabSelected(tab);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        setTabColorUnSelected(tab);
        if (this.kdc != null) {
            this.kdc.onTabUnselected(tab);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        setTabColorSelected(tab);
        if (this.kdc != null) {
            this.kdc.onTabReselected(tab);
        }
    }
}

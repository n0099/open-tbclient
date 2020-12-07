package com.baidu.tieba.homepage.hotTopic.tab.view;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import java.util.List;
/* loaded from: classes22.dex */
public class a implements TabLayout.OnTabSelectedListener {
    private TabLayout.OnTabSelectedListener jPM;
    private TabLayout jQt;
    private int jqd;
    private Context mContext;

    public TabLayout cPx() {
        return this.jQt;
    }

    public Context getContext() {
        return this.mContext;
    }

    public a(Context context) {
        this.mContext = context;
        cPy();
    }

    private void cPy() {
        this.jQt = (TabLayout) LayoutInflater.from(getContext()).inflate(R.layout.default_tab_layout, (ViewGroup) null);
        this.jQt.setOnTabSelectedListener(this);
    }

    public void setOnTabSelectedListener(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.jPM = onTabSelectedListener;
    }

    public void onChangeSkinType(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.jQt.getTabCount()) {
                break;
            }
            TabLayout.Tab tabAt = this.jQt.getTabAt(i3);
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
        }
        if (d.bkA()) {
            c.bm(this.jQt).setBackGroundColor(R.color.CAM_X0205);
        }
    }

    private void setTabColorSelected(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tab.getCustomView();
            if (tBSpecificationBtn.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) tBSpecificationBtn.getStyleConfig()).rh(R.color.CAM_X0304);
            }
        }
    }

    private void setTabColorUnSelected(TabLayout.Tab tab) {
        if (tab != null && tab.getCustomView() != null) {
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tab.getCustomView();
            if (tBSpecificationBtn.getStyleConfig() instanceof com.baidu.tbadk.core.view.commonBtn.c) {
                ((com.baidu.tbadk.core.view.commonBtn.c) tBSpecificationBtn.getStyleConfig()).rj(R.color.CAM_X0108);
            }
        }
    }

    public void a(FrsTabInfoData frsTabInfoData) {
        a(this.jqd, frsTabInfoData.tabList, this.jQt);
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
                    com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
                    cVar.rj(R.color.CAM_X0108);
                    tBSpecificationBtn.setConfig(cVar);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds177), UtilHelper.getDimenPixelSize(R.dimen.tbds75));
                    layoutParams3.setMargins(dimens, dimens2, dimens, dimens3);
                    tBSpecificationBtn.setLayoutParams(layoutParams3);
                    tab.setCustomView(tBSpecificationBtn);
                }
                ((TBSpecificationBtn) tab.getCustomView()).setText(au.cutForumNameWithSuffix(frsTabItemData.name, 10, StringHelper.STRING_MORE));
                if (!tab.isSelected() && i == frsTabItemData.tabId) {
                    tab.select();
                }
            }
            linearLayout.setPadding(d.bkA() ? l.getDimens(getContext(), R.dimen.tbds19) : 0, 0, 0, 0);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
            this.jqd = ((FrsTabItemData) tab.getTag()).tabId;
        }
        setTabColorSelected(tab);
        if (this.jPM != null) {
            this.jPM.onTabSelected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        setTabColorUnSelected(tab);
        if (this.jPM != null) {
            this.jPM.onTabUnselected(tab);
        }
    }

    @Override // android.support.design.widget.TabLayout.OnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        setTabColorSelected(tab);
        if (this.jPM != null) {
            this.jPM.onTabReselected(tab);
        }
    }
}

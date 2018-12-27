package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.frs.game.strategy.view.g;
import java.util.List;
/* loaded from: classes3.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private int bNp;
    private List<e> dVV;
    private int dVX;
    private a dWf;
    private c dWg;
    private ScrollHorizontalTabView dWl;
    private FoldedGridView dWm;
    private d dWn;
    private FrsGameTabPagerAdapter dWo;
    private View dWp;
    private View dWq;
    private boolean dWr;
    private g dWs;
    private a dWt;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bNp = 0;
        this.dVX = 0;
        this.dWr = false;
        this.dWf = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i, int i2) {
                if (ScrollLabelTabHost.this.dWt != null) {
                    ScrollLabelTabHost.this.dWt.aO(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aP(int i, int i2) {
                if (ScrollLabelTabHost.this.dWt != null) {
                    ScrollLabelTabHost.this.dWt.aP(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aQ(int i, int i2) {
                if (ScrollLabelTabHost.this.dWt != null) {
                    return ScrollLabelTabHost.this.dWt.aQ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dWt != null) {
                    return ScrollLabelTabHost.this.dWt.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mR(int i) {
                if (ScrollLabelTabHost.this.dWt != null) {
                    return ScrollLabelTabHost.this.dWt.mR(i);
                }
                return null;
            }
        };
        this.dWg = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mU(int i) {
                return (e) v.d(ScrollLabelTabHost.this.dVV, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bNp = 0;
        this.dVX = 0;
        this.dWr = false;
        this.dWf = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i, int i2) {
                if (ScrollLabelTabHost.this.dWt != null) {
                    ScrollLabelTabHost.this.dWt.aO(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aP(int i, int i2) {
                if (ScrollLabelTabHost.this.dWt != null) {
                    ScrollLabelTabHost.this.dWt.aP(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aQ(int i, int i2) {
                if (ScrollLabelTabHost.this.dWt != null) {
                    return ScrollLabelTabHost.this.dWt.aQ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dWt != null) {
                    return ScrollLabelTabHost.this.dWt.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mR(int i) {
                if (ScrollLabelTabHost.this.dWt != null) {
                    return ScrollLabelTabHost.this.dWt.mR(i);
                }
                return null;
            }
        };
        this.dWg = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mU(int i) {
                return (e) v.d(ScrollLabelTabHost.this.dVV, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bNp = 0;
        this.dVX = 0;
        this.dWr = false;
        this.dWf = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i2, int i22) {
                if (ScrollLabelTabHost.this.dWt != null) {
                    ScrollLabelTabHost.this.dWt.aO(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aP(int i2, int i22) {
                if (ScrollLabelTabHost.this.dWt != null) {
                    ScrollLabelTabHost.this.dWt.aP(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aQ(int i2, int i22) {
                if (ScrollLabelTabHost.this.dWt != null) {
                    return ScrollLabelTabHost.this.dWt.aQ(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dWt != null) {
                    return ScrollLabelTabHost.this.dWt.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mR(int i2) {
                if (ScrollLabelTabHost.this.dWt != null) {
                    return ScrollLabelTabHost.this.dWt.mR(i2);
                }
                return null;
            }
        };
        this.dWg = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mU(int i2) {
                return (e) v.d(ScrollLabelTabHost.this.dVV, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_game_strategy_tab_host_layout, this);
        this.dWo = new FrsGameTabPagerAdapter(context, this.dWf, this.dWg);
        this.mPager = (CustomViewPager) findViewById(e.g.frs_game_pager);
        this.mPager.setAdapter(this.dWo);
        this.dWl = (ScrollHorizontalTabView) findViewById(e.g.frs_game_tab_widget);
        this.dWl.setViewPager(this.mPager);
        this.dWl.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.bNp = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dVX = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.dWm.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dWm.setVisibility(8);
                    }
                }
            }
        });
        this.dWn = new d(getContext());
        this.dWm = (FoldedGridView) findViewById(e.g.frs_game_label_widget);
        this.dWm.setArrowResouceId(e.f.icon_arrow_gray_down, e.f.icon_arrow_gray_up);
        this.dWm.setNumColumns(5);
        this.dWm.setFoldAdapter(this.dWn);
        this.dWm.setExpandedBottomShadeResourceId(e.f.shape_frs_game_lable_bottom_shade);
        this.dWm.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void c(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dVX = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView aFp = ScrollLabelTabHost.this.dWo.aFp();
                    aFp.aU(ScrollLabelTabHost.this.bNp, ScrollLabelTabHost.this.dVX);
                    if (ScrollLabelTabHost.this.dWf != null && !ScrollLabelTabHost.this.dWf.aQ(ScrollLabelTabHost.this.bNp, ScrollLabelTabHost.this.dVX)) {
                        aFp.pullToRefresh();
                    }
                }
            }
        });
        this.dWp = findViewById(e.g.frs_game_tab_line);
        this.dWq = findViewById(e.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dWo != null) {
            this.dWo.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.I(list)) {
            if (this.dWr || this.dVV == null) {
                this.dWr = z;
                this.dVV = list;
                this.dWo.setCount(this.dVV == null ? 0 : this.dVV.size());
                this.dWl.setData(list);
                if (v.I(list)) {
                    this.dWl.setVisibility(8);
                    this.dWp.setVisibility(8);
                    return;
                }
                this.dWl.setVisibility(0);
                this.dWp.setVisibility(0);
                this.dWl.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dWm.setVisibility(0);
                    this.dWq.setVisibility(0);
                    return;
                }
                this.dWm.setVisibility(8);
                this.dWq.setVisibility(8);
            }
        }
    }

    public boolean a(e eVar) {
        if (eVar == null || !(eVar.extra instanceof LabelDataList)) {
            return false;
        }
        LabelDataList labelDataList = (LabelDataList) eVar.extra;
        if (labelDataList.isEmpty()) {
            return false;
        }
        this.dWn.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<h> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView aT = this.dWo.aT(i, i2);
        if (aT != null) {
            aT.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                mV(i3);
            }
        }
    }

    public void mV(int i) {
        if (this.dWs != null && this.dWs.isShowing()) {
            this.dWs.aDu();
        }
        this.dWs = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0210e.ds60));
        layoutParams.addRule(10);
        TextView aFy = this.dWs.aFy();
        if (i == 0) {
            aFy.setText(getResources().getString(e.j.recommend_frs_refresh_nodata));
        } else {
            aFy.setText(String.format(getResources().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(aFy, layoutParams);
        this.dWs.aFz();
    }

    public void d(int i, int i2, String str) {
        FrsGameStrategyItemListView aT = this.dWo.aT(i, i2);
        if (aT != null) {
            aT.c(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.dWt = aVar;
    }

    public void onChangeSkinType(int i) {
        this.dWl.onChangeSkinType(i);
        this.dWm.onChangeSkinType(i);
        this.dWo.onChangeSkinType(i);
        al.j(this.dWp, e.d.cp_bg_line_b);
        al.j(this.dWq, e.d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.dWs != null) {
            this.dWs.aDu();
        }
        this.dWo.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.dWo.aFp();
    }

    public void aaY() {
        FrsGameStrategyItemListView aFp = this.dWo.aFp();
        if (aFp != null) {
            aFp.pullToRefresh();
        }
    }
}

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
    private int bOc;
    private List<e> dWC;
    private int dWE;
    private a dWM;
    private c dWN;
    private ScrollHorizontalTabView dWS;
    private FoldedGridView dWT;
    private d dWU;
    private FrsGameTabPagerAdapter dWV;
    private View dWW;
    private View dWX;
    private boolean dWY;
    private g dWZ;
    private a dXa;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bOc = 0;
        this.dWE = 0;
        this.dWY = false;
        this.dWM = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i, int i2) {
                if (ScrollLabelTabHost.this.dXa != null) {
                    ScrollLabelTabHost.this.dXa.aO(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aP(int i, int i2) {
                if (ScrollLabelTabHost.this.dXa != null) {
                    ScrollLabelTabHost.this.dXa.aP(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aQ(int i, int i2) {
                if (ScrollLabelTabHost.this.dXa != null) {
                    return ScrollLabelTabHost.this.dXa.aQ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dXa != null) {
                    return ScrollLabelTabHost.this.dXa.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mS(int i) {
                if (ScrollLabelTabHost.this.dXa != null) {
                    return ScrollLabelTabHost.this.dXa.mS(i);
                }
                return null;
            }
        };
        this.dWN = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mV(int i) {
                return (e) v.d(ScrollLabelTabHost.this.dWC, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOc = 0;
        this.dWE = 0;
        this.dWY = false;
        this.dWM = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i, int i2) {
                if (ScrollLabelTabHost.this.dXa != null) {
                    ScrollLabelTabHost.this.dXa.aO(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aP(int i, int i2) {
                if (ScrollLabelTabHost.this.dXa != null) {
                    ScrollLabelTabHost.this.dXa.aP(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aQ(int i, int i2) {
                if (ScrollLabelTabHost.this.dXa != null) {
                    return ScrollLabelTabHost.this.dXa.aQ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dXa != null) {
                    return ScrollLabelTabHost.this.dXa.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mS(int i) {
                if (ScrollLabelTabHost.this.dXa != null) {
                    return ScrollLabelTabHost.this.dXa.mS(i);
                }
                return null;
            }
        };
        this.dWN = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mV(int i) {
                return (e) v.d(ScrollLabelTabHost.this.dWC, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOc = 0;
        this.dWE = 0;
        this.dWY = false;
        this.dWM = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i2, int i22) {
                if (ScrollLabelTabHost.this.dXa != null) {
                    ScrollLabelTabHost.this.dXa.aO(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aP(int i2, int i22) {
                if (ScrollLabelTabHost.this.dXa != null) {
                    ScrollLabelTabHost.this.dXa.aP(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aQ(int i2, int i22) {
                if (ScrollLabelTabHost.this.dXa != null) {
                    return ScrollLabelTabHost.this.dXa.aQ(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dXa != null) {
                    return ScrollLabelTabHost.this.dXa.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mS(int i2) {
                if (ScrollLabelTabHost.this.dXa != null) {
                    return ScrollLabelTabHost.this.dXa.mS(i2);
                }
                return null;
            }
        };
        this.dWN = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mV(int i2) {
                return (e) v.d(ScrollLabelTabHost.this.dWC, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_game_strategy_tab_host_layout, this);
        this.dWV = new FrsGameTabPagerAdapter(context, this.dWM, this.dWN);
        this.mPager = (CustomViewPager) findViewById(e.g.frs_game_pager);
        this.mPager.setAdapter(this.dWV);
        this.dWS = (ScrollHorizontalTabView) findViewById(e.g.frs_game_tab_widget);
        this.dWS.setViewPager(this.mPager);
        this.dWS.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.bOc = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dWE = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.dWT.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dWT.setVisibility(8);
                    }
                }
            }
        });
        this.dWU = new d(getContext());
        this.dWT = (FoldedGridView) findViewById(e.g.frs_game_label_widget);
        this.dWT.setArrowResouceId(e.f.icon_arrow_gray_down, e.f.icon_arrow_gray_up);
        this.dWT.setNumColumns(5);
        this.dWT.setFoldAdapter(this.dWU);
        this.dWT.setExpandedBottomShadeResourceId(e.f.shape_frs_game_lable_bottom_shade);
        this.dWT.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void c(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dWE = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView aFM = ScrollLabelTabHost.this.dWV.aFM();
                    aFM.aU(ScrollLabelTabHost.this.bOc, ScrollLabelTabHost.this.dWE);
                    if (ScrollLabelTabHost.this.dWM != null && !ScrollLabelTabHost.this.dWM.aQ(ScrollLabelTabHost.this.bOc, ScrollLabelTabHost.this.dWE)) {
                        aFM.pullToRefresh();
                    }
                }
            }
        });
        this.dWW = findViewById(e.g.frs_game_tab_line);
        this.dWX = findViewById(e.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dWV != null) {
            this.dWV.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.I(list)) {
            if (this.dWY || this.dWC == null) {
                this.dWY = z;
                this.dWC = list;
                this.dWV.setCount(this.dWC == null ? 0 : this.dWC.size());
                this.dWS.setData(list);
                if (v.I(list)) {
                    this.dWS.setVisibility(8);
                    this.dWW.setVisibility(8);
                    return;
                }
                this.dWS.setVisibility(0);
                this.dWW.setVisibility(0);
                this.dWS.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dWT.setVisibility(0);
                    this.dWX.setVisibility(0);
                    return;
                }
                this.dWT.setVisibility(8);
                this.dWX.setVisibility(8);
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
        this.dWU.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<h> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView aT = this.dWV.aT(i, i2);
        if (aT != null) {
            aT.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                mW(i3);
            }
        }
    }

    public void mW(int i) {
        if (this.dWZ != null && this.dWZ.isShowing()) {
            this.dWZ.aDR();
        }
        this.dWZ = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0210e.ds60));
        layoutParams.addRule(10);
        TextView aFV = this.dWZ.aFV();
        if (i == 0) {
            aFV.setText(getResources().getString(e.j.recommend_frs_refresh_nodata));
        } else {
            aFV.setText(String.format(getResources().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(aFV, layoutParams);
        this.dWZ.aFW();
    }

    public void d(int i, int i2, String str) {
        FrsGameStrategyItemListView aT = this.dWV.aT(i, i2);
        if (aT != null) {
            aT.c(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.dXa = aVar;
    }

    public void onChangeSkinType(int i) {
        this.dWS.onChangeSkinType(i);
        this.dWT.onChangeSkinType(i);
        this.dWV.onChangeSkinType(i);
        al.j(this.dWW, e.d.cp_bg_line_b);
        al.j(this.dWX, e.d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.dWZ != null) {
            this.dWZ.aDR();
        }
        this.dWV.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.dWV.aFM();
    }

    public void abv() {
        FrsGameStrategyItemListView aFM = this.dWV.aFM();
        if (aFM != null) {
            aFM.pullToRefresh();
        }
    }
}

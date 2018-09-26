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
    private int bAe;
    private a dDI;
    private c dDJ;
    private ScrollHorizontalTabView dDO;
    private FoldedGridView dDP;
    private d dDQ;
    private FrsGameTabPagerAdapter dDR;
    private View dDS;
    private View dDT;
    private boolean dDU;
    private g dDV;
    private a dDW;
    private List<e> dDx;
    private int dDz;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bAe = 0;
        this.dDz = 0;
        this.dDU = false;
        this.dDI = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aJ(int i, int i2) {
                if (ScrollLabelTabHost.this.dDW != null) {
                    ScrollLabelTabHost.this.dDW.aJ(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aK(int i, int i2) {
                if (ScrollLabelTabHost.this.dDW != null) {
                    ScrollLabelTabHost.this.dDW.aK(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aL(int i, int i2) {
                if (ScrollLabelTabHost.this.dDW != null) {
                    return ScrollLabelTabHost.this.dDW.aL(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dDW != null) {
                    return ScrollLabelTabHost.this.dDW.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e lz(int i) {
                if (ScrollLabelTabHost.this.dDW != null) {
                    return ScrollLabelTabHost.this.dDW.lz(i);
                }
                return null;
            }
        };
        this.dDJ = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e lC(int i) {
                return (e) v.d(ScrollLabelTabHost.this.dDx, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bAe = 0;
        this.dDz = 0;
        this.dDU = false;
        this.dDI = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aJ(int i, int i2) {
                if (ScrollLabelTabHost.this.dDW != null) {
                    ScrollLabelTabHost.this.dDW.aJ(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aK(int i, int i2) {
                if (ScrollLabelTabHost.this.dDW != null) {
                    ScrollLabelTabHost.this.dDW.aK(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aL(int i, int i2) {
                if (ScrollLabelTabHost.this.dDW != null) {
                    return ScrollLabelTabHost.this.dDW.aL(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dDW != null) {
                    return ScrollLabelTabHost.this.dDW.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e lz(int i) {
                if (ScrollLabelTabHost.this.dDW != null) {
                    return ScrollLabelTabHost.this.dDW.lz(i);
                }
                return null;
            }
        };
        this.dDJ = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e lC(int i) {
                return (e) v.d(ScrollLabelTabHost.this.dDx, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bAe = 0;
        this.dDz = 0;
        this.dDU = false;
        this.dDI = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aJ(int i2, int i22) {
                if (ScrollLabelTabHost.this.dDW != null) {
                    ScrollLabelTabHost.this.dDW.aJ(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aK(int i2, int i22) {
                if (ScrollLabelTabHost.this.dDW != null) {
                    ScrollLabelTabHost.this.dDW.aK(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aL(int i2, int i22) {
                if (ScrollLabelTabHost.this.dDW != null) {
                    return ScrollLabelTabHost.this.dDW.aL(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dDW != null) {
                    return ScrollLabelTabHost.this.dDW.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e lz(int i2) {
                if (ScrollLabelTabHost.this.dDW != null) {
                    return ScrollLabelTabHost.this.dDW.lz(i2);
                }
                return null;
            }
        };
        this.dDJ = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e lC(int i2) {
                return (e) v.d(ScrollLabelTabHost.this.dDx, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_game_strategy_tab_host_layout, this);
        this.dDR = new FrsGameTabPagerAdapter(context, this.dDI, this.dDJ);
        this.mPager = (CustomViewPager) findViewById(e.g.frs_game_pager);
        this.mPager.setAdapter(this.dDR);
        this.dDO = (ScrollHorizontalTabView) findViewById(e.g.frs_game_tab_widget);
        this.dDO.setViewPager(this.mPager);
        this.dDO.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.bAe = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dDz = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.dDP.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dDP.setVisibility(8);
                    }
                }
            }
        });
        this.dDQ = new d(getContext());
        this.dDP = (FoldedGridView) findViewById(e.g.frs_game_label_widget);
        this.dDP.setArrowResouceId(e.f.icon_arrow_gray_down, e.f.icon_arrow_gray_up);
        this.dDP.setNumColumns(5);
        this.dDP.setFoldAdapter(this.dDQ);
        this.dDP.setExpandedBottomShadeResourceId(e.f.shape_frs_game_lable_bottom_shade);
        this.dDP.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void c(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dDz = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView aAa = ScrollLabelTabHost.this.dDR.aAa();
                    aAa.aP(ScrollLabelTabHost.this.bAe, ScrollLabelTabHost.this.dDz);
                    if (ScrollLabelTabHost.this.dDI != null && !ScrollLabelTabHost.this.dDI.aL(ScrollLabelTabHost.this.bAe, ScrollLabelTabHost.this.dDz)) {
                        aAa.pullToRefresh();
                    }
                }
            }
        });
        this.dDS = findViewById(e.g.frs_game_tab_line);
        this.dDT = findViewById(e.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dDR != null) {
            this.dDR.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.z(list)) {
            if (this.dDU || this.dDx == null) {
                this.dDU = z;
                this.dDx = list;
                this.dDR.setCount(this.dDx == null ? 0 : this.dDx.size());
                this.dDO.setData(list);
                if (v.z(list)) {
                    this.dDO.setVisibility(8);
                    this.dDS.setVisibility(8);
                    return;
                }
                this.dDO.setVisibility(0);
                this.dDS.setVisibility(0);
                this.dDO.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dDP.setVisibility(0);
                    this.dDT.setVisibility(0);
                    return;
                }
                this.dDP.setVisibility(8);
                this.dDT.setVisibility(8);
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
        this.dDQ.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<h> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView aO = this.dDR.aO(i, i2);
        if (aO != null) {
            aO.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                lD(i3);
            }
        }
    }

    public void lD(int i) {
        if (this.dDV != null && this.dDV.isShowing()) {
            this.dDV.ayc();
        }
        this.dDV = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0141e.ds60));
        layoutParams.addRule(10);
        TextView aAj = this.dDV.aAj();
        if (i == 0) {
            aAj.setText(getResources().getString(e.j.recommend_frs_refresh_nodata));
        } else {
            aAj.setText(String.format(getResources().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(aAj, layoutParams);
        this.dDV.aAk();
    }

    public void d(int i, int i2, String str) {
        FrsGameStrategyItemListView aO = this.dDR.aO(i, i2);
        if (aO != null) {
            aO.c(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.dDW = aVar;
    }

    public void onChangeSkinType(int i) {
        this.dDO.onChangeSkinType(i);
        this.dDP.onChangeSkinType(i);
        this.dDR.onChangeSkinType(i);
        al.j(this.dDS, e.d.cp_bg_line_b);
        al.j(this.dDT, e.d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.dDV != null) {
            this.dDV.ayc();
        }
        this.dDR.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.dDR.aAa();
    }

    public void VY() {
        FrsGameStrategyItemListView aAa = this.dDR.aAa();
        if (aAa != null) {
            aAa.pullToRefresh();
        }
    }
}

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
    private int bOb;
    private List<e> dWB;
    private int dWD;
    private a dWL;
    private c dWM;
    private ScrollHorizontalTabView dWR;
    private FoldedGridView dWS;
    private d dWT;
    private FrsGameTabPagerAdapter dWU;
    private View dWV;
    private View dWW;
    private boolean dWX;
    private g dWY;
    private a dWZ;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bOb = 0;
        this.dWD = 0;
        this.dWX = false;
        this.dWL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i, int i2) {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    ScrollLabelTabHost.this.dWZ.aO(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aP(int i, int i2) {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    ScrollLabelTabHost.this.dWZ.aP(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aQ(int i, int i2) {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    return ScrollLabelTabHost.this.dWZ.aQ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    return ScrollLabelTabHost.this.dWZ.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mS(int i) {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    return ScrollLabelTabHost.this.dWZ.mS(i);
                }
                return null;
            }
        };
        this.dWM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mV(int i) {
                return (e) v.d(ScrollLabelTabHost.this.dWB, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOb = 0;
        this.dWD = 0;
        this.dWX = false;
        this.dWL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i, int i2) {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    ScrollLabelTabHost.this.dWZ.aO(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aP(int i, int i2) {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    ScrollLabelTabHost.this.dWZ.aP(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aQ(int i, int i2) {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    return ScrollLabelTabHost.this.dWZ.aQ(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    return ScrollLabelTabHost.this.dWZ.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mS(int i) {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    return ScrollLabelTabHost.this.dWZ.mS(i);
                }
                return null;
            }
        };
        this.dWM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mV(int i) {
                return (e) v.d(ScrollLabelTabHost.this.dWB, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bOb = 0;
        this.dWD = 0;
        this.dWX = false;
        this.dWL = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i2, int i22) {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    ScrollLabelTabHost.this.dWZ.aO(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aP(int i2, int i22) {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    ScrollLabelTabHost.this.dWZ.aP(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aQ(int i2, int i22) {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    return ScrollLabelTabHost.this.dWZ.aQ(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    return ScrollLabelTabHost.this.dWZ.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mS(int i2) {
                if (ScrollLabelTabHost.this.dWZ != null) {
                    return ScrollLabelTabHost.this.dWZ.mS(i2);
                }
                return null;
            }
        };
        this.dWM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mV(int i2) {
                return (e) v.d(ScrollLabelTabHost.this.dWB, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_game_strategy_tab_host_layout, this);
        this.dWU = new FrsGameTabPagerAdapter(context, this.dWL, this.dWM);
        this.mPager = (CustomViewPager) findViewById(e.g.frs_game_pager);
        this.mPager.setAdapter(this.dWU);
        this.dWR = (ScrollHorizontalTabView) findViewById(e.g.frs_game_tab_widget);
        this.dWR.setViewPager(this.mPager);
        this.dWR.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.bOb = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dWD = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.dWS.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dWS.setVisibility(8);
                    }
                }
            }
        });
        this.dWT = new d(getContext());
        this.dWS = (FoldedGridView) findViewById(e.g.frs_game_label_widget);
        this.dWS.setArrowResouceId(e.f.icon_arrow_gray_down, e.f.icon_arrow_gray_up);
        this.dWS.setNumColumns(5);
        this.dWS.setFoldAdapter(this.dWT);
        this.dWS.setExpandedBottomShadeResourceId(e.f.shape_frs_game_lable_bottom_shade);
        this.dWS.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void c(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dWD = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView aFM = ScrollLabelTabHost.this.dWU.aFM();
                    aFM.aU(ScrollLabelTabHost.this.bOb, ScrollLabelTabHost.this.dWD);
                    if (ScrollLabelTabHost.this.dWL != null && !ScrollLabelTabHost.this.dWL.aQ(ScrollLabelTabHost.this.bOb, ScrollLabelTabHost.this.dWD)) {
                        aFM.pullToRefresh();
                    }
                }
            }
        });
        this.dWV = findViewById(e.g.frs_game_tab_line);
        this.dWW = findViewById(e.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dWU != null) {
            this.dWU.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.I(list)) {
            if (this.dWX || this.dWB == null) {
                this.dWX = z;
                this.dWB = list;
                this.dWU.setCount(this.dWB == null ? 0 : this.dWB.size());
                this.dWR.setData(list);
                if (v.I(list)) {
                    this.dWR.setVisibility(8);
                    this.dWV.setVisibility(8);
                    return;
                }
                this.dWR.setVisibility(0);
                this.dWV.setVisibility(0);
                this.dWR.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dWS.setVisibility(0);
                    this.dWW.setVisibility(0);
                    return;
                }
                this.dWS.setVisibility(8);
                this.dWW.setVisibility(8);
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
        this.dWT.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<h> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView aT = this.dWU.aT(i, i2);
        if (aT != null) {
            aT.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                mW(i3);
            }
        }
    }

    public void mW(int i) {
        if (this.dWY != null && this.dWY.isShowing()) {
            this.dWY.aDR();
        }
        this.dWY = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0210e.ds60));
        layoutParams.addRule(10);
        TextView aFV = this.dWY.aFV();
        if (i == 0) {
            aFV.setText(getResources().getString(e.j.recommend_frs_refresh_nodata));
        } else {
            aFV.setText(String.format(getResources().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(aFV, layoutParams);
        this.dWY.aFW();
    }

    public void d(int i, int i2, String str) {
        FrsGameStrategyItemListView aT = this.dWU.aT(i, i2);
        if (aT != null) {
            aT.c(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.dWZ = aVar;
    }

    public void onChangeSkinType(int i) {
        this.dWR.onChangeSkinType(i);
        this.dWS.onChangeSkinType(i);
        this.dWU.onChangeSkinType(i);
        al.j(this.dWV, e.d.cp_bg_line_b);
        al.j(this.dWW, e.d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.dWY != null) {
            this.dWY.aDR();
        }
        this.dWU.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.dWU.aFM();
    }

    public void abv() {
        FrsGameStrategyItemListView aFM = this.dWU.aFM();
        if (aFM != null) {
            aFM.pullToRefresh();
        }
    }
}

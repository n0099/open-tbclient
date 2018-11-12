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
    private int bJx;
    private List<e> dMB;
    private int dMD;
    private a dML;
    private c dMM;
    private ScrollHorizontalTabView dMR;
    private FoldedGridView dMS;
    private d dMT;
    private FrsGameTabPagerAdapter dMU;
    private View dMV;
    private View dMW;
    private boolean dMX;
    private g dMY;
    private a dMZ;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bJx = 0;
        this.dMD = 0;
        this.dMX = false;
        this.dML = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aN(int i, int i2) {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    ScrollLabelTabHost.this.dMZ.aN(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i, int i2) {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    ScrollLabelTabHost.this.dMZ.aO(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aP(int i, int i2) {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    return ScrollLabelTabHost.this.dMZ.aP(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    return ScrollLabelTabHost.this.dMZ.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mo(int i) {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    return ScrollLabelTabHost.this.dMZ.mo(i);
                }
                return null;
            }
        };
        this.dMM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mr(int i) {
                return (e) v.d(ScrollLabelTabHost.this.dMB, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJx = 0;
        this.dMD = 0;
        this.dMX = false;
        this.dML = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aN(int i, int i2) {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    ScrollLabelTabHost.this.dMZ.aN(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i, int i2) {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    ScrollLabelTabHost.this.dMZ.aO(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aP(int i, int i2) {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    return ScrollLabelTabHost.this.dMZ.aP(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    return ScrollLabelTabHost.this.dMZ.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mo(int i) {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    return ScrollLabelTabHost.this.dMZ.mo(i);
                }
                return null;
            }
        };
        this.dMM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mr(int i) {
                return (e) v.d(ScrollLabelTabHost.this.dMB, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJx = 0;
        this.dMD = 0;
        this.dMX = false;
        this.dML = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aN(int i2, int i22) {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    ScrollLabelTabHost.this.dMZ.aN(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i2, int i22) {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    ScrollLabelTabHost.this.dMZ.aO(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aP(int i2, int i22) {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    return ScrollLabelTabHost.this.dMZ.aP(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    return ScrollLabelTabHost.this.dMZ.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mo(int i2) {
                if (ScrollLabelTabHost.this.dMZ != null) {
                    return ScrollLabelTabHost.this.dMZ.mo(i2);
                }
                return null;
            }
        };
        this.dMM = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mr(int i2) {
                return (e) v.d(ScrollLabelTabHost.this.dMB, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_game_strategy_tab_host_layout, this);
        this.dMU = new FrsGameTabPagerAdapter(context, this.dML, this.dMM);
        this.mPager = (CustomViewPager) findViewById(e.g.frs_game_pager);
        this.mPager.setAdapter(this.dMU);
        this.dMR = (ScrollHorizontalTabView) findViewById(e.g.frs_game_tab_widget);
        this.dMR.setViewPager(this.mPager);
        this.dMR.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.bJx = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dMD = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.dMS.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dMS.setVisibility(8);
                    }
                }
            }
        });
        this.dMT = new d(getContext());
        this.dMS = (FoldedGridView) findViewById(e.g.frs_game_label_widget);
        this.dMS.setArrowResouceId(e.f.icon_arrow_gray_down, e.f.icon_arrow_gray_up);
        this.dMS.setNumColumns(5);
        this.dMS.setFoldAdapter(this.dMT);
        this.dMS.setExpandedBottomShadeResourceId(e.f.shape_frs_game_lable_bottom_shade);
        this.dMS.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void c(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dMD = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView aCO = ScrollLabelTabHost.this.dMU.aCO();
                    aCO.aT(ScrollLabelTabHost.this.bJx, ScrollLabelTabHost.this.dMD);
                    if (ScrollLabelTabHost.this.dML != null && !ScrollLabelTabHost.this.dML.aP(ScrollLabelTabHost.this.bJx, ScrollLabelTabHost.this.dMD)) {
                        aCO.pullToRefresh();
                    }
                }
            }
        });
        this.dMV = findViewById(e.g.frs_game_tab_line);
        this.dMW = findViewById(e.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dMU != null) {
            this.dMU.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.I(list)) {
            if (this.dMX || this.dMB == null) {
                this.dMX = z;
                this.dMB = list;
                this.dMU.setCount(this.dMB == null ? 0 : this.dMB.size());
                this.dMR.setData(list);
                if (v.I(list)) {
                    this.dMR.setVisibility(8);
                    this.dMV.setVisibility(8);
                    return;
                }
                this.dMR.setVisibility(0);
                this.dMV.setVisibility(0);
                this.dMR.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dMS.setVisibility(0);
                    this.dMW.setVisibility(0);
                    return;
                }
                this.dMS.setVisibility(8);
                this.dMW.setVisibility(8);
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
        this.dMT.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<h> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView aS = this.dMU.aS(i, i2);
        if (aS != null) {
            aS.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                ms(i3);
            }
        }
    }

    public void ms(int i) {
        if (this.dMY != null && this.dMY.isShowing()) {
            this.dMY.aAV();
        }
        this.dMY = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0200e.ds60));
        layoutParams.addRule(10);
        TextView aCX = this.dMY.aCX();
        if (i == 0) {
            aCX.setText(getResources().getString(e.j.recommend_frs_refresh_nodata));
        } else {
            aCX.setText(String.format(getResources().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(aCX, layoutParams);
        this.dMY.aCY();
    }

    public void d(int i, int i2, String str) {
        FrsGameStrategyItemListView aS = this.dMU.aS(i, i2);
        if (aS != null) {
            aS.c(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.dMZ = aVar;
    }

    public void onChangeSkinType(int i) {
        this.dMR.onChangeSkinType(i);
        this.dMS.onChangeSkinType(i);
        this.dMU.onChangeSkinType(i);
        al.j(this.dMV, e.d.cp_bg_line_b);
        al.j(this.dMW, e.d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.dMY != null) {
            this.dMY.aAV();
        }
        this.dMU.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.dMU.aCO();
    }

    public void ZQ() {
        FrsGameStrategyItemListView aCO = this.dMU.aCO();
        if (aCO != null) {
            aCO.pullToRefresh();
        }
    }
}

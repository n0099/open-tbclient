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
    private int bNm;
    private boolean dTA;
    private g dTB;
    private a dTC;
    private List<e> dTe;
    private int dTg;
    private a dTo;
    private c dTp;
    private ScrollHorizontalTabView dTu;
    private FoldedGridView dTv;
    private d dTw;
    private FrsGameTabPagerAdapter dTx;
    private View dTy;
    private View dTz;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bNm = 0;
        this.dTg = 0;
        this.dTA = false;
        this.dTo = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aN(int i, int i2) {
                if (ScrollLabelTabHost.this.dTC != null) {
                    ScrollLabelTabHost.this.dTC.aN(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i, int i2) {
                if (ScrollLabelTabHost.this.dTC != null) {
                    ScrollLabelTabHost.this.dTC.aO(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aP(int i, int i2) {
                if (ScrollLabelTabHost.this.dTC != null) {
                    return ScrollLabelTabHost.this.dTC.aP(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dTC != null) {
                    return ScrollLabelTabHost.this.dTC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mE(int i) {
                if (ScrollLabelTabHost.this.dTC != null) {
                    return ScrollLabelTabHost.this.dTC.mE(i);
                }
                return null;
            }
        };
        this.dTp = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mH(int i) {
                return (e) v.d(ScrollLabelTabHost.this.dTe, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bNm = 0;
        this.dTg = 0;
        this.dTA = false;
        this.dTo = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aN(int i, int i2) {
                if (ScrollLabelTabHost.this.dTC != null) {
                    ScrollLabelTabHost.this.dTC.aN(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i, int i2) {
                if (ScrollLabelTabHost.this.dTC != null) {
                    ScrollLabelTabHost.this.dTC.aO(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aP(int i, int i2) {
                if (ScrollLabelTabHost.this.dTC != null) {
                    return ScrollLabelTabHost.this.dTC.aP(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dTC != null) {
                    return ScrollLabelTabHost.this.dTC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mE(int i) {
                if (ScrollLabelTabHost.this.dTC != null) {
                    return ScrollLabelTabHost.this.dTC.mE(i);
                }
                return null;
            }
        };
        this.dTp = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mH(int i) {
                return (e) v.d(ScrollLabelTabHost.this.dTe, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bNm = 0;
        this.dTg = 0;
        this.dTA = false;
        this.dTo = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aN(int i2, int i22) {
                if (ScrollLabelTabHost.this.dTC != null) {
                    ScrollLabelTabHost.this.dTC.aN(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aO(int i2, int i22) {
                if (ScrollLabelTabHost.this.dTC != null) {
                    ScrollLabelTabHost.this.dTC.aO(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aP(int i2, int i22) {
                if (ScrollLabelTabHost.this.dTC != null) {
                    return ScrollLabelTabHost.this.dTC.aP(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dTC != null) {
                    return ScrollLabelTabHost.this.dTC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e mE(int i2) {
                if (ScrollLabelTabHost.this.dTC != null) {
                    return ScrollLabelTabHost.this.dTC.mE(i2);
                }
                return null;
            }
        };
        this.dTp = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e mH(int i2) {
                return (e) v.d(ScrollLabelTabHost.this.dTe, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(e.h.frs_game_strategy_tab_host_layout, this);
        this.dTx = new FrsGameTabPagerAdapter(context, this.dTo, this.dTp);
        this.mPager = (CustomViewPager) findViewById(e.g.frs_game_pager);
        this.mPager.setAdapter(this.dTx);
        this.dTu = (ScrollHorizontalTabView) findViewById(e.g.frs_game_tab_widget);
        this.dTu.setViewPager(this.mPager);
        this.dTu.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.bNm = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dTg = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.dTv.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dTv.setVisibility(8);
                    }
                }
            }
        });
        this.dTw = new d(getContext());
        this.dTv = (FoldedGridView) findViewById(e.g.frs_game_label_widget);
        this.dTv.setArrowResouceId(e.f.icon_arrow_gray_down, e.f.icon_arrow_gray_up);
        this.dTv.setNumColumns(5);
        this.dTv.setFoldAdapter(this.dTw);
        this.dTv.setExpandedBottomShadeResourceId(e.f.shape_frs_game_lable_bottom_shade);
        this.dTv.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void c(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dTg = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView aEA = ScrollLabelTabHost.this.dTx.aEA();
                    aEA.aT(ScrollLabelTabHost.this.bNm, ScrollLabelTabHost.this.dTg);
                    if (ScrollLabelTabHost.this.dTo != null && !ScrollLabelTabHost.this.dTo.aP(ScrollLabelTabHost.this.bNm, ScrollLabelTabHost.this.dTg)) {
                        aEA.pullToRefresh();
                    }
                }
            }
        });
        this.dTy = findViewById(e.g.frs_game_tab_line);
        this.dTz = findViewById(e.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dTx != null) {
            this.dTx.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.I(list)) {
            if (this.dTA || this.dTe == null) {
                this.dTA = z;
                this.dTe = list;
                this.dTx.setCount(this.dTe == null ? 0 : this.dTe.size());
                this.dTu.setData(list);
                if (v.I(list)) {
                    this.dTu.setVisibility(8);
                    this.dTy.setVisibility(8);
                    return;
                }
                this.dTu.setVisibility(0);
                this.dTy.setVisibility(0);
                this.dTu.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dTv.setVisibility(0);
                    this.dTz.setVisibility(0);
                    return;
                }
                this.dTv.setVisibility(8);
                this.dTz.setVisibility(8);
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
        this.dTw.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<h> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView aS = this.dTx.aS(i, i2);
        if (aS != null) {
            aS.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                mI(i3);
            }
        }
    }

    public void mI(int i) {
        if (this.dTB != null && this.dTB.isShowing()) {
            this.dTB.aCF();
        }
        this.dTB = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0210e.ds60));
        layoutParams.addRule(10);
        TextView aEJ = this.dTB.aEJ();
        if (i == 0) {
            aEJ.setText(getResources().getString(e.j.recommend_frs_refresh_nodata));
        } else {
            aEJ.setText(String.format(getResources().getString(e.j.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(aEJ, layoutParams);
        this.dTB.aEK();
    }

    public void d(int i, int i2, String str) {
        FrsGameStrategyItemListView aS = this.dTx.aS(i, i2);
        if (aS != null) {
            aS.c(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.dTC = aVar;
    }

    public void onChangeSkinType(int i) {
        this.dTu.onChangeSkinType(i);
        this.dTv.onChangeSkinType(i);
        this.dTx.onChangeSkinType(i);
        al.j(this.dTy, e.d.cp_bg_line_b);
        al.j(this.dTz, e.d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.dTB != null) {
            this.dTB.aCF();
        }
        this.dTx.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.dTx.aEA();
    }

    public void aaW() {
        FrsGameStrategyItemListView aEA = this.dTx.aEA();
        if (aEA != null) {
            aEA.pullToRefresh();
        }
    }
}

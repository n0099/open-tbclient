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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.frs.game.strategy.view.g;
import java.util.List;
/* loaded from: classes3.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private int bsf;
    private List<e> dqU;
    private int dqW;
    private a drf;
    private c drg;
    private ScrollHorizontalTabView drl;
    private FoldedGridView drm;
    private d drn;
    private FrsGameTabPagerAdapter dro;
    private View drp;
    private View drq;
    private boolean drr;
    private g drs;
    private a drt;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bsf = 0;
        this.dqW = 0;
        this.drr = false;
        this.drf = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aD(int i, int i2) {
                if (ScrollLabelTabHost.this.drt != null) {
                    ScrollLabelTabHost.this.drt.aD(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aE(int i, int i2) {
                if (ScrollLabelTabHost.this.drt != null) {
                    ScrollLabelTabHost.this.drt.aE(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aF(int i, int i2) {
                if (ScrollLabelTabHost.this.drt != null) {
                    return ScrollLabelTabHost.this.drt.aF(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.drt != null) {
                    return ScrollLabelTabHost.this.drt.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kF(int i) {
                if (ScrollLabelTabHost.this.drt != null) {
                    return ScrollLabelTabHost.this.drt.kF(i);
                }
                return null;
            }
        };
        this.drg = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kI(int i) {
                return (e) w.c(ScrollLabelTabHost.this.dqU, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bsf = 0;
        this.dqW = 0;
        this.drr = false;
        this.drf = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aD(int i, int i2) {
                if (ScrollLabelTabHost.this.drt != null) {
                    ScrollLabelTabHost.this.drt.aD(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aE(int i, int i2) {
                if (ScrollLabelTabHost.this.drt != null) {
                    ScrollLabelTabHost.this.drt.aE(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aF(int i, int i2) {
                if (ScrollLabelTabHost.this.drt != null) {
                    return ScrollLabelTabHost.this.drt.aF(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.drt != null) {
                    return ScrollLabelTabHost.this.drt.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kF(int i) {
                if (ScrollLabelTabHost.this.drt != null) {
                    return ScrollLabelTabHost.this.drt.kF(i);
                }
                return null;
            }
        };
        this.drg = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kI(int i) {
                return (e) w.c(ScrollLabelTabHost.this.dqU, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bsf = 0;
        this.dqW = 0;
        this.drr = false;
        this.drf = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aD(int i2, int i22) {
                if (ScrollLabelTabHost.this.drt != null) {
                    ScrollLabelTabHost.this.drt.aD(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aE(int i2, int i22) {
                if (ScrollLabelTabHost.this.drt != null) {
                    ScrollLabelTabHost.this.drt.aE(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aF(int i2, int i22) {
                if (ScrollLabelTabHost.this.drt != null) {
                    return ScrollLabelTabHost.this.drt.aF(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.drt != null) {
                    return ScrollLabelTabHost.this.drt.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kF(int i2) {
                if (ScrollLabelTabHost.this.drt != null) {
                    return ScrollLabelTabHost.this.drt.kF(i2);
                }
                return null;
            }
        };
        this.drg = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kI(int i2) {
                return (e) w.c(ScrollLabelTabHost.this.dqU, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.frs_game_strategy_tab_host_layout, this);
        this.dro = new FrsGameTabPagerAdapter(context, this.drf, this.drg);
        this.mPager = (CustomViewPager) findViewById(d.g.frs_game_pager);
        this.mPager.setAdapter(this.dro);
        this.drl = (ScrollHorizontalTabView) findViewById(d.g.frs_game_tab_widget);
        this.drl.setViewPager(this.mPager);
        this.drl.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.bsf = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dqW = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.drm.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.drm.setVisibility(8);
                    }
                }
            }
        });
        this.drn = new d(getContext());
        this.drm = (FoldedGridView) findViewById(d.g.frs_game_label_widget);
        this.drm.setArrowResouceId(d.f.icon_arrow_gray_down, d.f.icon_arrow_gray_up);
        this.drm.setNumColumns(5);
        this.drm.setFoldAdapter(this.drn);
        this.drm.setExpandedBottomShadeResourceId(d.f.shape_frs_game_lable_bottom_shade);
        this.drm.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void c(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dqW = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView awE = ScrollLabelTabHost.this.dro.awE();
                    awE.aJ(ScrollLabelTabHost.this.bsf, ScrollLabelTabHost.this.dqW);
                    if (ScrollLabelTabHost.this.drf != null && !ScrollLabelTabHost.this.drf.aF(ScrollLabelTabHost.this.bsf, ScrollLabelTabHost.this.dqW)) {
                        awE.nV();
                    }
                }
            }
        });
        this.drp = findViewById(d.g.frs_game_tab_line);
        this.drq = findViewById(d.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dro != null) {
            this.dro.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!w.z(list)) {
            if (this.drr || this.dqU == null) {
                this.drr = z;
                this.dqU = list;
                this.dro.setCount(this.dqU == null ? 0 : this.dqU.size());
                this.drl.setData(list);
                if (w.z(list)) {
                    this.drl.setVisibility(8);
                    this.drp.setVisibility(8);
                    return;
                }
                this.drl.setVisibility(0);
                this.drp.setVisibility(0);
                this.drl.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.drm.setVisibility(0);
                    this.drq.setVisibility(0);
                    return;
                }
                this.drm.setVisibility(8);
                this.drq.setVisibility(8);
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
        this.drn.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<h> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView aI = this.dro.aI(i, i2);
        if (aI != null) {
            aI.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                kJ(i3);
            }
        }
    }

    public void kJ(int i) {
        if (this.drs != null && this.drs.isShowing()) {
            this.drs.auT();
        }
        this.drs = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds60));
        layoutParams.addRule(10);
        TextView awN = this.drs.awN();
        if (i == 0) {
            awN.setText(getResources().getString(d.k.recommend_frs_refresh_nodata));
        } else {
            awN.setText(String.format(getResources().getString(d.k.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(awN, layoutParams);
        this.drs.awO();
    }

    public void d(int i, int i2, String str) {
        FrsGameStrategyItemListView aI = this.dro.aI(i, i2);
        if (aI != null) {
            aI.c(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.drt = aVar;
    }

    public void onChangeSkinType(int i) {
        this.drl.onChangeSkinType(i);
        this.drm.onChangeSkinType(i);
        this.dro.onChangeSkinType(i);
        al.j(this.drp, d.C0141d.cp_bg_line_b);
        al.j(this.drq, d.C0141d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.drs != null) {
            this.drs.auT();
        }
        this.dro.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.dro.awE();
    }

    public void TG() {
        FrsGameStrategyItemListView awE = this.dro.awE();
        if (awE != null) {
            awE.nV();
        }
    }
}

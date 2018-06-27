package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.am;
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
    private int btG;
    private boolean duA;
    private g duB;
    private a duC;
    private List<e> dud;
    private int duf;
    private a duo;
    private c dup;
    private ScrollHorizontalTabView duu;
    private FoldedGridView duv;
    private d duw;
    private FrsGameTabPagerAdapter dux;
    private View duy;
    private View duz;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.btG = 0;
        this.duf = 0;
        this.duA = false;
        this.duo = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aC(int i, int i2) {
                if (ScrollLabelTabHost.this.duC != null) {
                    ScrollLabelTabHost.this.duC.aC(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aD(int i, int i2) {
                if (ScrollLabelTabHost.this.duC != null) {
                    ScrollLabelTabHost.this.duC.aD(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aE(int i, int i2) {
                if (ScrollLabelTabHost.this.duC != null) {
                    return ScrollLabelTabHost.this.duC.aE(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.duC != null) {
                    return ScrollLabelTabHost.this.duC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kM(int i) {
                if (ScrollLabelTabHost.this.duC != null) {
                    return ScrollLabelTabHost.this.duC.kM(i);
                }
                return null;
            }
        };
        this.dup = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kP(int i) {
                return (e) w.d(ScrollLabelTabHost.this.dud, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btG = 0;
        this.duf = 0;
        this.duA = false;
        this.duo = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aC(int i, int i2) {
                if (ScrollLabelTabHost.this.duC != null) {
                    ScrollLabelTabHost.this.duC.aC(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aD(int i, int i2) {
                if (ScrollLabelTabHost.this.duC != null) {
                    ScrollLabelTabHost.this.duC.aD(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aE(int i, int i2) {
                if (ScrollLabelTabHost.this.duC != null) {
                    return ScrollLabelTabHost.this.duC.aE(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.duC != null) {
                    return ScrollLabelTabHost.this.duC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kM(int i) {
                if (ScrollLabelTabHost.this.duC != null) {
                    return ScrollLabelTabHost.this.duC.kM(i);
                }
                return null;
            }
        };
        this.dup = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kP(int i) {
                return (e) w.d(ScrollLabelTabHost.this.dud, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btG = 0;
        this.duf = 0;
        this.duA = false;
        this.duo = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aC(int i2, int i22) {
                if (ScrollLabelTabHost.this.duC != null) {
                    ScrollLabelTabHost.this.duC.aC(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aD(int i2, int i22) {
                if (ScrollLabelTabHost.this.duC != null) {
                    ScrollLabelTabHost.this.duC.aD(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aE(int i2, int i22) {
                if (ScrollLabelTabHost.this.duC != null) {
                    return ScrollLabelTabHost.this.duC.aE(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.duC != null) {
                    return ScrollLabelTabHost.this.duC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kM(int i2) {
                if (ScrollLabelTabHost.this.duC != null) {
                    return ScrollLabelTabHost.this.duC.kM(i2);
                }
                return null;
            }
        };
        this.dup = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kP(int i2) {
                return (e) w.d(ScrollLabelTabHost.this.dud, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.frs_game_strategy_tab_host_layout, this);
        this.dux = new FrsGameTabPagerAdapter(context, this.duo, this.dup);
        this.mPager = (CustomViewPager) findViewById(d.g.frs_game_pager);
        this.mPager.setAdapter(this.dux);
        this.duu = (ScrollHorizontalTabView) findViewById(d.g.frs_game_tab_widget);
        this.duu.setViewPager(this.mPager);
        this.duu.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.btG = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.duf = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.duv.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.duv.setVisibility(8);
                    }
                }
            }
        });
        this.duw = new d(getContext());
        this.duv = (FoldedGridView) findViewById(d.g.frs_game_label_widget);
        this.duv.setArrowResouceId(d.f.icon_arrow_gray_down, d.f.icon_arrow_gray_up);
        this.duv.setNumColumns(5);
        this.duv.setFoldAdapter(this.duw);
        this.duv.setExpandedBottomShadeResourceId(d.f.shape_frs_game_lable_bottom_shade);
        this.duv.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void c(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.duf = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView axi = ScrollLabelTabHost.this.dux.axi();
                    axi.aI(ScrollLabelTabHost.this.btG, ScrollLabelTabHost.this.duf);
                    if (ScrollLabelTabHost.this.duo != null && !ScrollLabelTabHost.this.duo.aE(ScrollLabelTabHost.this.btG, ScrollLabelTabHost.this.duf)) {
                        axi.nV();
                    }
                }
            }
        });
        this.duy = findViewById(d.g.frs_game_tab_line);
        this.duz = findViewById(d.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dux != null) {
            this.dux.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!w.A(list)) {
            if (this.duA || this.dud == null) {
                this.duA = z;
                this.dud = list;
                this.dux.setCount(this.dud == null ? 0 : this.dud.size());
                this.duu.setData(list);
                if (w.A(list)) {
                    this.duu.setVisibility(8);
                    this.duy.setVisibility(8);
                    return;
                }
                this.duu.setVisibility(0);
                this.duy.setVisibility(0);
                this.duu.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.duv.setVisibility(0);
                    this.duz.setVisibility(0);
                    return;
                }
                this.duv.setVisibility(8);
                this.duz.setVisibility(8);
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
        this.duw.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<h> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView aH = this.dux.aH(i, i2);
        if (aH != null) {
            aH.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                kQ(i3);
            }
        }
    }

    public void kQ(int i) {
        if (this.duB != null && this.duB.isShowing()) {
            this.duB.avn();
        }
        this.duB = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds60));
        layoutParams.addRule(10);
        TextView axr = this.duB.axr();
        if (i == 0) {
            axr.setText(getResources().getString(d.k.recommend_frs_refresh_nodata));
        } else {
            axr.setText(String.format(getResources().getString(d.k.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(axr, layoutParams);
        this.duB.axs();
    }

    public void d(int i, int i2, String str) {
        FrsGameStrategyItemListView aH = this.dux.aH(i, i2);
        if (aH != null) {
            aH.c(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.duC = aVar;
    }

    public void onChangeSkinType(int i) {
        this.duu.onChangeSkinType(i);
        this.duv.onChangeSkinType(i);
        this.dux.onChangeSkinType(i);
        am.j(this.duy, d.C0142d.cp_bg_line_b);
        am.j(this.duz, d.C0142d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.duB != null) {
            this.duB.avn();
        }
        this.dux.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.dux.axi();
    }

    public void Ua() {
        FrsGameStrategyItemListView axi = this.dux.axi();
        if (axi != null) {
            axi.nV();
        }
    }
}

package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.frs.game.strategy.view.g;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private int dad;
    private boolean fkA;
    private g fkB;
    private a fkC;
    private List<e> fke;
    private int fkg;
    private a fko;
    private c fkp;
    private ScrollHorizontalTabView fku;
    private FoldedGridView fkv;
    private d fkw;
    private FrsGameTabPagerAdapter fkx;
    private View fky;
    private View fkz;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.dad = 0;
        this.fkg = 0;
        this.fkA = false;
        this.fko = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bj(int i, int i2) {
                if (ScrollLabelTabHost.this.fkC != null) {
                    ScrollLabelTabHost.this.fkC.bj(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bk(int i, int i2) {
                if (ScrollLabelTabHost.this.fkC != null) {
                    ScrollLabelTabHost.this.fkC.bk(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bl(int i, int i2) {
                if (ScrollLabelTabHost.this.fkC != null) {
                    return ScrollLabelTabHost.this.fkC.bl(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fkC != null) {
                    return ScrollLabelTabHost.this.fkC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e qF(int i) {
                if (ScrollLabelTabHost.this.fkC != null) {
                    return ScrollLabelTabHost.this.fkC.qF(i);
                }
                return null;
            }
        };
        this.fkp = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e qI(int i) {
                return (e) v.c(ScrollLabelTabHost.this.fke, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dad = 0;
        this.fkg = 0;
        this.fkA = false;
        this.fko = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bj(int i, int i2) {
                if (ScrollLabelTabHost.this.fkC != null) {
                    ScrollLabelTabHost.this.fkC.bj(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bk(int i, int i2) {
                if (ScrollLabelTabHost.this.fkC != null) {
                    ScrollLabelTabHost.this.fkC.bk(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bl(int i, int i2) {
                if (ScrollLabelTabHost.this.fkC != null) {
                    return ScrollLabelTabHost.this.fkC.bl(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fkC != null) {
                    return ScrollLabelTabHost.this.fkC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e qF(int i) {
                if (ScrollLabelTabHost.this.fkC != null) {
                    return ScrollLabelTabHost.this.fkC.qF(i);
                }
                return null;
            }
        };
        this.fkp = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e qI(int i) {
                return (e) v.c(ScrollLabelTabHost.this.fke, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dad = 0;
        this.fkg = 0;
        this.fkA = false;
        this.fko = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bj(int i2, int i22) {
                if (ScrollLabelTabHost.this.fkC != null) {
                    ScrollLabelTabHost.this.fkC.bj(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bk(int i2, int i22) {
                if (ScrollLabelTabHost.this.fkC != null) {
                    ScrollLabelTabHost.this.fkC.bk(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bl(int i2, int i22) {
                if (ScrollLabelTabHost.this.fkC != null) {
                    return ScrollLabelTabHost.this.fkC.bl(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fkC != null) {
                    return ScrollLabelTabHost.this.fkC.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e qF(int i2) {
                if (ScrollLabelTabHost.this.fkC != null) {
                    return ScrollLabelTabHost.this.fkC.qF(i2);
                }
                return null;
            }
        };
        this.fkp = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e qI(int i2) {
                return (e) v.c(ScrollLabelTabHost.this.fke, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_game_strategy_tab_host_layout, this);
        this.fkx = new FrsGameTabPagerAdapter(context, this.fko, this.fkp);
        this.mPager = (CustomViewPager) findViewById(d.g.frs_game_pager);
        this.mPager.setAdapter(this.fkx);
        this.fku = (ScrollHorizontalTabView) findViewById(d.g.frs_game_tab_widget);
        this.fku.setViewPager(this.mPager);
        this.fku.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.dad = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.fkg = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.fkv.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.fkv.setVisibility(8);
                    }
                }
            }
        });
        this.fkw = new d(getContext());
        this.fkv = (FoldedGridView) findViewById(d.g.frs_game_label_widget);
        this.fkv.setArrowResouceId(d.f.icon_arrow_gray_down, d.f.icon_arrow_gray_up);
        this.fkv.setNumColumns(5);
        this.fkv.setFoldAdapter(this.fkw);
        this.fkv.setExpandedBottomShadeResourceId(d.f.shape_frs_game_lable_bottom_shade);
        this.fkv.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void f(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.fkg = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bge = ScrollLabelTabHost.this.fkx.bge();
                    bge.bp(ScrollLabelTabHost.this.dad, ScrollLabelTabHost.this.fkg);
                    if (ScrollLabelTabHost.this.fko != null && !ScrollLabelTabHost.this.fko.bl(ScrollLabelTabHost.this.dad, ScrollLabelTabHost.this.fkg)) {
                        bge.pullToRefresh();
                    }
                }
            }
        });
        this.fky = findViewById(d.g.frs_game_tab_line);
        this.fkz = findViewById(d.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fkx != null) {
            this.fkx.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.T(list)) {
            if (this.fkA || this.fke == null) {
                this.fkA = z;
                this.fke = list;
                this.fkx.setCount(this.fke == null ? 0 : this.fke.size());
                this.fku.setData(list);
                if (v.T(list)) {
                    this.fku.setVisibility(8);
                    this.fky.setVisibility(8);
                    return;
                }
                this.fku.setVisibility(0);
                this.fky.setVisibility(0);
                this.fku.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.fkv.setVisibility(0);
                    this.fkz.setVisibility(0);
                    return;
                }
                this.fkv.setVisibility(8);
                this.fkz.setVisibility(8);
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
        this.fkw.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bo = this.fkx.bo(i, i2);
        if (bo != null) {
            bo.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                qJ(i3);
            }
        }
    }

    public void qJ(int i) {
        if (this.fkB != null && this.fkB.isShowing()) {
            this.fkB.bez();
        }
        this.fkB = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds60));
        layoutParams.addRule(10);
        TextView bgn = this.fkB.bgn();
        if (i == 0) {
            bgn.setText(getResources().getString(d.j.recommend_frs_refresh_nodata));
        } else {
            bgn.setText(String.format(getResources().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bgn, layoutParams);
        this.fkB.bgo();
    }

    public void f(int i, int i2, String str) {
        FrsGameStrategyItemListView bo = this.fkx.bo(i, i2);
        if (bo != null) {
            bo.e(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.fkC = aVar;
    }

    public void onChangeSkinType(int i) {
        this.fku.onChangeSkinType(i);
        this.fkv.onChangeSkinType(i);
        this.fkx.onChangeSkinType(i);
        al.l(this.fky, d.C0277d.cp_bg_line_b);
        al.l(this.fkz, d.C0277d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.fkB != null) {
            this.fkB.bez();
        }
        this.fkx.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.fkx.bge();
    }

    public void aCt() {
        FrsGameStrategyItemListView bge = this.fkx.bge();
        if (bge != null) {
            bge.pullToRefresh();
        }
    }
}

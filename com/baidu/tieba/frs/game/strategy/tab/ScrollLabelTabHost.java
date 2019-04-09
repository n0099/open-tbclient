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
    private int dah;
    private List<e> fjQ;
    private int fjS;
    private a fka;
    private c fkb;
    private ScrollHorizontalTabView fkg;
    private FoldedGridView fkh;
    private d fki;
    private FrsGameTabPagerAdapter fkj;
    private View fkk;
    private View fkl;
    private boolean fkm;
    private g fkn;
    private a fko;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.dah = 0;
        this.fjS = 0;
        this.fkm = false;
        this.fka = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bj(int i, int i2) {
                if (ScrollLabelTabHost.this.fko != null) {
                    ScrollLabelTabHost.this.fko.bj(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bk(int i, int i2) {
                if (ScrollLabelTabHost.this.fko != null) {
                    ScrollLabelTabHost.this.fko.bk(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bl(int i, int i2) {
                if (ScrollLabelTabHost.this.fko != null) {
                    return ScrollLabelTabHost.this.fko.bl(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fko != null) {
                    return ScrollLabelTabHost.this.fko.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e qB(int i) {
                if (ScrollLabelTabHost.this.fko != null) {
                    return ScrollLabelTabHost.this.fko.qB(i);
                }
                return null;
            }
        };
        this.fkb = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e qE(int i) {
                return (e) v.c(ScrollLabelTabHost.this.fjQ, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dah = 0;
        this.fjS = 0;
        this.fkm = false;
        this.fka = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bj(int i, int i2) {
                if (ScrollLabelTabHost.this.fko != null) {
                    ScrollLabelTabHost.this.fko.bj(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bk(int i, int i2) {
                if (ScrollLabelTabHost.this.fko != null) {
                    ScrollLabelTabHost.this.fko.bk(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bl(int i, int i2) {
                if (ScrollLabelTabHost.this.fko != null) {
                    return ScrollLabelTabHost.this.fko.bl(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fko != null) {
                    return ScrollLabelTabHost.this.fko.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e qB(int i) {
                if (ScrollLabelTabHost.this.fko != null) {
                    return ScrollLabelTabHost.this.fko.qB(i);
                }
                return null;
            }
        };
        this.fkb = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e qE(int i) {
                return (e) v.c(ScrollLabelTabHost.this.fjQ, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dah = 0;
        this.fjS = 0;
        this.fkm = false;
        this.fka = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bj(int i2, int i22) {
                if (ScrollLabelTabHost.this.fko != null) {
                    ScrollLabelTabHost.this.fko.bj(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bk(int i2, int i22) {
                if (ScrollLabelTabHost.this.fko != null) {
                    ScrollLabelTabHost.this.fko.bk(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bl(int i2, int i22) {
                if (ScrollLabelTabHost.this.fko != null) {
                    return ScrollLabelTabHost.this.fko.bl(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fko != null) {
                    return ScrollLabelTabHost.this.fko.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e qB(int i2) {
                if (ScrollLabelTabHost.this.fko != null) {
                    return ScrollLabelTabHost.this.fko.qB(i2);
                }
                return null;
            }
        };
        this.fkb = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e qE(int i2) {
                return (e) v.c(ScrollLabelTabHost.this.fjQ, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_game_strategy_tab_host_layout, this);
        this.fkj = new FrsGameTabPagerAdapter(context, this.fka, this.fkb);
        this.mPager = (CustomViewPager) findViewById(d.g.frs_game_pager);
        this.mPager.setAdapter(this.fkj);
        this.fkg = (ScrollHorizontalTabView) findViewById(d.g.frs_game_tab_widget);
        this.fkg.setViewPager(this.mPager);
        this.fkg.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.dah = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.fjS = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.fkh.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.fkh.setVisibility(8);
                    }
                }
            }
        });
        this.fki = new d(getContext());
        this.fkh = (FoldedGridView) findViewById(d.g.frs_game_label_widget);
        this.fkh.setArrowResouceId(d.f.icon_arrow_gray_down, d.f.icon_arrow_gray_up);
        this.fkh.setNumColumns(5);
        this.fkh.setFoldAdapter(this.fki);
        this.fkh.setExpandedBottomShadeResourceId(d.f.shape_frs_game_lable_bottom_shade);
        this.fkh.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void f(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.fjS = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bgc = ScrollLabelTabHost.this.fkj.bgc();
                    bgc.bp(ScrollLabelTabHost.this.dah, ScrollLabelTabHost.this.fjS);
                    if (ScrollLabelTabHost.this.fka != null && !ScrollLabelTabHost.this.fka.bl(ScrollLabelTabHost.this.dah, ScrollLabelTabHost.this.fjS)) {
                        bgc.pullToRefresh();
                    }
                }
            }
        });
        this.fkk = findViewById(d.g.frs_game_tab_line);
        this.fkl = findViewById(d.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fkj != null) {
            this.fkj.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.T(list)) {
            if (this.fkm || this.fjQ == null) {
                this.fkm = z;
                this.fjQ = list;
                this.fkj.setCount(this.fjQ == null ? 0 : this.fjQ.size());
                this.fkg.setData(list);
                if (v.T(list)) {
                    this.fkg.setVisibility(8);
                    this.fkk.setVisibility(8);
                    return;
                }
                this.fkg.setVisibility(0);
                this.fkk.setVisibility(0);
                this.fkg.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.fkh.setVisibility(0);
                    this.fkl.setVisibility(0);
                    return;
                }
                this.fkh.setVisibility(8);
                this.fkl.setVisibility(8);
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
        this.fki.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bo = this.fkj.bo(i, i2);
        if (bo != null) {
            bo.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                qF(i3);
            }
        }
    }

    public void qF(int i) {
        if (this.fkn != null && this.fkn.isShowing()) {
            this.fkn.bex();
        }
        this.fkn = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds60));
        layoutParams.addRule(10);
        TextView bgl = this.fkn.bgl();
        if (i == 0) {
            bgl.setText(getResources().getString(d.j.recommend_frs_refresh_nodata));
        } else {
            bgl.setText(String.format(getResources().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bgl, layoutParams);
        this.fkn.bgm();
    }

    public void f(int i, int i2, String str) {
        FrsGameStrategyItemListView bo = this.fkj.bo(i, i2);
        if (bo != null) {
            bo.e(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.fko = aVar;
    }

    public void onChangeSkinType(int i) {
        this.fkg.onChangeSkinType(i);
        this.fkh.onChangeSkinType(i);
        this.fkj.onChangeSkinType(i);
        al.l(this.fkk, d.C0277d.cp_bg_line_b);
        al.l(this.fkl, d.C0277d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.fkn != null) {
            this.fkn.bex();
        }
        this.fkj.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.fkj.bgc();
    }

    public void aCq() {
        FrsGameStrategyItemListView bgc = this.fkj.bgc();
        if (bgc != null) {
            bgc.pullToRefresh();
        }
    }
}

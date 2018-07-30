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
    private int bun;
    private List<e> dwQ;
    private int dwS;
    private a dxb;
    private c dxc;
    private ScrollHorizontalTabView dxh;
    private FoldedGridView dxi;
    private d dxj;
    private FrsGameTabPagerAdapter dxk;
    private View dxl;
    private View dxm;
    private boolean dxn;
    private g dxo;
    private a dxp;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bun = 0;
        this.dwS = 0;
        this.dxn = false;
        this.dxb = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aF(int i, int i2) {
                if (ScrollLabelTabHost.this.dxp != null) {
                    ScrollLabelTabHost.this.dxp.aF(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aG(int i, int i2) {
                if (ScrollLabelTabHost.this.dxp != null) {
                    ScrollLabelTabHost.this.dxp.aG(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aH(int i, int i2) {
                if (ScrollLabelTabHost.this.dxp != null) {
                    return ScrollLabelTabHost.this.dxp.aH(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dxp != null) {
                    return ScrollLabelTabHost.this.dxp.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kX(int i) {
                if (ScrollLabelTabHost.this.dxp != null) {
                    return ScrollLabelTabHost.this.dxp.kX(i);
                }
                return null;
            }
        };
        this.dxc = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e la(int i) {
                return (e) w.d(ScrollLabelTabHost.this.dwQ, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bun = 0;
        this.dwS = 0;
        this.dxn = false;
        this.dxb = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aF(int i, int i2) {
                if (ScrollLabelTabHost.this.dxp != null) {
                    ScrollLabelTabHost.this.dxp.aF(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aG(int i, int i2) {
                if (ScrollLabelTabHost.this.dxp != null) {
                    ScrollLabelTabHost.this.dxp.aG(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aH(int i, int i2) {
                if (ScrollLabelTabHost.this.dxp != null) {
                    return ScrollLabelTabHost.this.dxp.aH(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dxp != null) {
                    return ScrollLabelTabHost.this.dxp.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kX(int i) {
                if (ScrollLabelTabHost.this.dxp != null) {
                    return ScrollLabelTabHost.this.dxp.kX(i);
                }
                return null;
            }
        };
        this.dxc = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e la(int i) {
                return (e) w.d(ScrollLabelTabHost.this.dwQ, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bun = 0;
        this.dwS = 0;
        this.dxn = false;
        this.dxb = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aF(int i2, int i22) {
                if (ScrollLabelTabHost.this.dxp != null) {
                    ScrollLabelTabHost.this.dxp.aF(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aG(int i2, int i22) {
                if (ScrollLabelTabHost.this.dxp != null) {
                    ScrollLabelTabHost.this.dxp.aG(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aH(int i2, int i22) {
                if (ScrollLabelTabHost.this.dxp != null) {
                    return ScrollLabelTabHost.this.dxp.aH(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dxp != null) {
                    return ScrollLabelTabHost.this.dxp.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kX(int i2) {
                if (ScrollLabelTabHost.this.dxp != null) {
                    return ScrollLabelTabHost.this.dxp.kX(i2);
                }
                return null;
            }
        };
        this.dxc = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e la(int i2) {
                return (e) w.d(ScrollLabelTabHost.this.dwQ, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_game_strategy_tab_host_layout, this);
        this.dxk = new FrsGameTabPagerAdapter(context, this.dxb, this.dxc);
        this.mPager = (CustomViewPager) findViewById(d.g.frs_game_pager);
        this.mPager.setAdapter(this.dxk);
        this.dxh = (ScrollHorizontalTabView) findViewById(d.g.frs_game_tab_widget);
        this.dxh.setViewPager(this.mPager);
        this.dxh.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.bun = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dwS = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.dxi.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dxi.setVisibility(8);
                    }
                }
            }
        });
        this.dxj = new d(getContext());
        this.dxi = (FoldedGridView) findViewById(d.g.frs_game_label_widget);
        this.dxi.setArrowResouceId(d.f.icon_arrow_gray_down, d.f.icon_arrow_gray_up);
        this.dxi.setNumColumns(5);
        this.dxi.setFoldAdapter(this.dxj);
        this.dxi.setExpandedBottomShadeResourceId(d.f.shape_frs_game_lable_bottom_shade);
        this.dxi.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void c(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dwS = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView axN = ScrollLabelTabHost.this.dxk.axN();
                    axN.aL(ScrollLabelTabHost.this.bun, ScrollLabelTabHost.this.dwS);
                    if (ScrollLabelTabHost.this.dxb != null && !ScrollLabelTabHost.this.dxb.aH(ScrollLabelTabHost.this.bun, ScrollLabelTabHost.this.dwS)) {
                        axN.nX();
                    }
                }
            }
        });
        this.dxl = findViewById(d.g.frs_game_tab_line);
        this.dxm = findViewById(d.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dxk != null) {
            this.dxk.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!w.z(list)) {
            if (this.dxn || this.dwQ == null) {
                this.dxn = z;
                this.dwQ = list;
                this.dxk.setCount(this.dwQ == null ? 0 : this.dwQ.size());
                this.dxh.setData(list);
                if (w.z(list)) {
                    this.dxh.setVisibility(8);
                    this.dxl.setVisibility(8);
                    return;
                }
                this.dxh.setVisibility(0);
                this.dxl.setVisibility(0);
                this.dxh.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dxi.setVisibility(0);
                    this.dxm.setVisibility(0);
                    return;
                }
                this.dxi.setVisibility(8);
                this.dxm.setVisibility(8);
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
        this.dxj.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<h> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView aK = this.dxk.aK(i, i2);
        if (aK != null) {
            aK.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                lb(i3);
            }
        }
    }

    public void lb(int i) {
        if (this.dxo != null && this.dxo.isShowing()) {
            this.dxo.avS();
        }
        this.dxo = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds60));
        layoutParams.addRule(10);
        TextView axW = this.dxo.axW();
        if (i == 0) {
            axW.setText(getResources().getString(d.j.recommend_frs_refresh_nodata));
        } else {
            axW.setText(String.format(getResources().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(axW, layoutParams);
        this.dxo.axX();
    }

    public void d(int i, int i2, String str) {
        FrsGameStrategyItemListView aK = this.dxk.aK(i, i2);
        if (aK != null) {
            aK.c(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.dxp = aVar;
    }

    public void onChangeSkinType(int i) {
        this.dxh.onChangeSkinType(i);
        this.dxi.onChangeSkinType(i);
        this.dxk.onChangeSkinType(i);
        am.j(this.dxl, d.C0140d.cp_bg_line_b);
        am.j(this.dxm, d.C0140d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.dxo != null) {
            this.dxo.avS();
        }
        this.dxk.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.dxk.axN();
    }

    public void Ui() {
        FrsGameStrategyItemListView axN = this.dxk.axN();
        if (axN != null) {
            axN.nX();
        }
    }
}

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
import com.baidu.tieba.f;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.frs.game.strategy.view.g;
import java.util.List;
/* loaded from: classes3.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private int bup;
    private List<e> dwN;
    private int dwP;
    private a dwY;
    private c dwZ;
    private ScrollHorizontalTabView dxe;
    private FoldedGridView dxf;
    private d dxg;
    private FrsGameTabPagerAdapter dxh;
    private View dxi;
    private View dxj;
    private boolean dxk;
    private g dxl;
    private a dxm;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bup = 0;
        this.dwP = 0;
        this.dxk = false;
        this.dwY = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aF(int i, int i2) {
                if (ScrollLabelTabHost.this.dxm != null) {
                    ScrollLabelTabHost.this.dxm.aF(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aG(int i, int i2) {
                if (ScrollLabelTabHost.this.dxm != null) {
                    ScrollLabelTabHost.this.dxm.aG(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aH(int i, int i2) {
                if (ScrollLabelTabHost.this.dxm != null) {
                    return ScrollLabelTabHost.this.dxm.aH(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dxm != null) {
                    return ScrollLabelTabHost.this.dxm.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kW(int i) {
                if (ScrollLabelTabHost.this.dxm != null) {
                    return ScrollLabelTabHost.this.dxm.kW(i);
                }
                return null;
            }
        };
        this.dwZ = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kZ(int i) {
                return (e) w.d(ScrollLabelTabHost.this.dwN, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bup = 0;
        this.dwP = 0;
        this.dxk = false;
        this.dwY = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aF(int i, int i2) {
                if (ScrollLabelTabHost.this.dxm != null) {
                    ScrollLabelTabHost.this.dxm.aF(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aG(int i, int i2) {
                if (ScrollLabelTabHost.this.dxm != null) {
                    ScrollLabelTabHost.this.dxm.aG(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aH(int i, int i2) {
                if (ScrollLabelTabHost.this.dxm != null) {
                    return ScrollLabelTabHost.this.dxm.aH(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dxm != null) {
                    return ScrollLabelTabHost.this.dxm.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kW(int i) {
                if (ScrollLabelTabHost.this.dxm != null) {
                    return ScrollLabelTabHost.this.dxm.kW(i);
                }
                return null;
            }
        };
        this.dwZ = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kZ(int i) {
                return (e) w.d(ScrollLabelTabHost.this.dwN, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bup = 0;
        this.dwP = 0;
        this.dxk = false;
        this.dwY = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aF(int i2, int i22) {
                if (ScrollLabelTabHost.this.dxm != null) {
                    ScrollLabelTabHost.this.dxm.aF(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aG(int i2, int i22) {
                if (ScrollLabelTabHost.this.dxm != null) {
                    ScrollLabelTabHost.this.dxm.aG(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aH(int i2, int i22) {
                if (ScrollLabelTabHost.this.dxm != null) {
                    return ScrollLabelTabHost.this.dxm.aH(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dxm != null) {
                    return ScrollLabelTabHost.this.dxm.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kW(int i2) {
                if (ScrollLabelTabHost.this.dxm != null) {
                    return ScrollLabelTabHost.this.dxm.kW(i2);
                }
                return null;
            }
        };
        this.dwZ = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kZ(int i2) {
                return (e) w.d(ScrollLabelTabHost.this.dwN, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(f.h.frs_game_strategy_tab_host_layout, this);
        this.dxh = new FrsGameTabPagerAdapter(context, this.dwY, this.dwZ);
        this.mPager = (CustomViewPager) findViewById(f.g.frs_game_pager);
        this.mPager.setAdapter(this.dxh);
        this.dxe = (ScrollHorizontalTabView) findViewById(f.g.frs_game_tab_widget);
        this.dxe.setViewPager(this.mPager);
        this.dxe.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.bup = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dwP = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.dxf.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dxf.setVisibility(8);
                    }
                }
            }
        });
        this.dxg = new d(getContext());
        this.dxf = (FoldedGridView) findViewById(f.g.frs_game_label_widget);
        this.dxf.setArrowResouceId(f.C0146f.icon_arrow_gray_down, f.C0146f.icon_arrow_gray_up);
        this.dxf.setNumColumns(5);
        this.dxf.setFoldAdapter(this.dxg);
        this.dxf.setExpandedBottomShadeResourceId(f.C0146f.shape_frs_game_lable_bottom_shade);
        this.dxf.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void c(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dwP = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView axL = ScrollLabelTabHost.this.dxh.axL();
                    axL.aL(ScrollLabelTabHost.this.bup, ScrollLabelTabHost.this.dwP);
                    if (ScrollLabelTabHost.this.dwY != null && !ScrollLabelTabHost.this.dwY.aH(ScrollLabelTabHost.this.bup, ScrollLabelTabHost.this.dwP)) {
                        axL.pullToRefresh();
                    }
                }
            }
        });
        this.dxi = findViewById(f.g.frs_game_tab_line);
        this.dxj = findViewById(f.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dxh != null) {
            this.dxh.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!w.z(list)) {
            if (this.dxk || this.dwN == null) {
                this.dxk = z;
                this.dwN = list;
                this.dxh.setCount(this.dwN == null ? 0 : this.dwN.size());
                this.dxe.setData(list);
                if (w.z(list)) {
                    this.dxe.setVisibility(8);
                    this.dxi.setVisibility(8);
                    return;
                }
                this.dxe.setVisibility(0);
                this.dxi.setVisibility(0);
                this.dxe.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dxf.setVisibility(0);
                    this.dxj.setVisibility(0);
                    return;
                }
                this.dxf.setVisibility(8);
                this.dxj.setVisibility(8);
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
        this.dxg.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<h> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView aK = this.dxh.aK(i, i2);
        if (aK != null) {
            aK.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                la(i3);
            }
        }
    }

    public void la(int i) {
        if (this.dxl != null && this.dxl.isShowing()) {
            this.dxl.avR();
        }
        this.dxl = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(f.e.ds60));
        layoutParams.addRule(10);
        TextView axU = this.dxl.axU();
        if (i == 0) {
            axU.setText(getResources().getString(f.j.recommend_frs_refresh_nodata));
        } else {
            axU.setText(String.format(getResources().getString(f.j.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(axU, layoutParams);
        this.dxl.axV();
    }

    public void d(int i, int i2, String str) {
        FrsGameStrategyItemListView aK = this.dxh.aK(i, i2);
        if (aK != null) {
            aK.c(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.dxm = aVar;
    }

    public void onChangeSkinType(int i) {
        this.dxe.onChangeSkinType(i);
        this.dxf.onChangeSkinType(i);
        this.dxh.onChangeSkinType(i);
        am.j(this.dxi, f.d.cp_bg_line_b);
        am.j(this.dxj, f.d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.dxl != null) {
            this.dxl.avR();
        }
        this.dxh.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.dxh.axL();
    }

    public void Ul() {
        FrsGameStrategyItemListView axL = this.dxh.axL();
        if (axL != null) {
            axL.pullToRefresh();
        }
    }
}

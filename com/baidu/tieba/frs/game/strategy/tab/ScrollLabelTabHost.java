package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
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
    private int bjL;
    private int dgA;
    private a dgJ;
    private c dgK;
    private ScrollHorizontalTabView dgP;
    private FoldedGridView dgQ;
    private d dgR;
    private FrsGameTabPagerAdapter dgS;
    private View dgT;
    private View dgU;
    private boolean dgV;
    private g dgW;
    private a dgX;
    private List<e> dgy;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bjL = 0;
        this.dgA = 0;
        this.dgV = false;
        this.dgJ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aB(int i, int i2) {
                if (ScrollLabelTabHost.this.dgX != null) {
                    ScrollLabelTabHost.this.dgX.aB(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aC(int i, int i2) {
                if (ScrollLabelTabHost.this.dgX != null) {
                    ScrollLabelTabHost.this.dgX.aC(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aD(int i, int i2) {
                if (ScrollLabelTabHost.this.dgX != null) {
                    return ScrollLabelTabHost.this.dgX.aD(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dgX != null) {
                    return ScrollLabelTabHost.this.dgX.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kB(int i) {
                if (ScrollLabelTabHost.this.dgX != null) {
                    return ScrollLabelTabHost.this.dgX.kB(i);
                }
                return null;
            }
        };
        this.dgK = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kE(int i) {
                return (e) v.c(ScrollLabelTabHost.this.dgy, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjL = 0;
        this.dgA = 0;
        this.dgV = false;
        this.dgJ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aB(int i, int i2) {
                if (ScrollLabelTabHost.this.dgX != null) {
                    ScrollLabelTabHost.this.dgX.aB(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aC(int i, int i2) {
                if (ScrollLabelTabHost.this.dgX != null) {
                    ScrollLabelTabHost.this.dgX.aC(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aD(int i, int i2) {
                if (ScrollLabelTabHost.this.dgX != null) {
                    return ScrollLabelTabHost.this.dgX.aD(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dgX != null) {
                    return ScrollLabelTabHost.this.dgX.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kB(int i) {
                if (ScrollLabelTabHost.this.dgX != null) {
                    return ScrollLabelTabHost.this.dgX.kB(i);
                }
                return null;
            }
        };
        this.dgK = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kE(int i) {
                return (e) v.c(ScrollLabelTabHost.this.dgy, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bjL = 0;
        this.dgA = 0;
        this.dgV = false;
        this.dgJ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aB(int i2, int i22) {
                if (ScrollLabelTabHost.this.dgX != null) {
                    ScrollLabelTabHost.this.dgX.aB(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aC(int i2, int i22) {
                if (ScrollLabelTabHost.this.dgX != null) {
                    ScrollLabelTabHost.this.dgX.aC(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aD(int i2, int i22) {
                if (ScrollLabelTabHost.this.dgX != null) {
                    return ScrollLabelTabHost.this.dgX.aD(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dgX != null) {
                    return ScrollLabelTabHost.this.dgX.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kB(int i2) {
                if (ScrollLabelTabHost.this.dgX != null) {
                    return ScrollLabelTabHost.this.dgX.kB(i2);
                }
                return null;
            }
        };
        this.dgK = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kE(int i2) {
                return (e) v.c(ScrollLabelTabHost.this.dgy, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.frs_game_strategy_tab_host_layout, this);
        this.dgS = new FrsGameTabPagerAdapter(context, this.dgJ, this.dgK);
        this.mPager = (CustomViewPager) findViewById(d.g.frs_game_pager);
        this.mPager.setAdapter(this.dgS);
        this.dgP = (ScrollHorizontalTabView) findViewById(d.g.frs_game_tab_widget);
        this.dgP.setViewPager(this.mPager);
        this.dgP.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.bjL = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dgA = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.dgQ.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dgQ.setVisibility(8);
                    }
                }
            }
        });
        this.dgR = new d(getContext());
        this.dgQ = (FoldedGridView) findViewById(d.g.frs_game_label_widget);
        this.dgQ.setArrowResouceId(d.f.icon_arrow_gray_down, d.f.icon_arrow_gray_up);
        this.dgQ.setNumColumns(5);
        this.dgQ.setFoldAdapter(this.dgR);
        this.dgQ.setExpandedBottomShadeResourceId(d.f.shape_frs_game_lable_bottom_shade);
        this.dgQ.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void c(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dgA = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView asz = ScrollLabelTabHost.this.dgS.asz();
                    asz.aH(ScrollLabelTabHost.this.bjL, ScrollLabelTabHost.this.dgA);
                    if (ScrollLabelTabHost.this.dgJ != null && !ScrollLabelTabHost.this.dgJ.aD(ScrollLabelTabHost.this.bjL, ScrollLabelTabHost.this.dgA)) {
                        asz.lg();
                    }
                }
            }
        });
        this.dgT = findViewById(d.g.frs_game_tab_line);
        this.dgU = findViewById(d.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dgS != null) {
            this.dgS.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.w(list)) {
            if (this.dgV || this.dgy == null) {
                this.dgV = z;
                this.dgy = list;
                this.dgS.setCount(this.dgy == null ? 0 : this.dgy.size());
                this.dgP.setData(list);
                if (v.w(list)) {
                    this.dgP.setVisibility(8);
                    this.dgT.setVisibility(8);
                    return;
                }
                this.dgP.setVisibility(0);
                this.dgT.setVisibility(0);
                this.dgP.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dgQ.setVisibility(0);
                    this.dgU.setVisibility(0);
                    return;
                }
                this.dgQ.setVisibility(8);
                this.dgU.setVisibility(8);
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
        this.dgR.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<h> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView aG = this.dgS.aG(i, i2);
        if (aG != null) {
            aG.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                kF(i3);
            }
        }
    }

    public void kF(int i) {
        if (this.dgW != null && this.dgW.isShowing()) {
            this.dgW.aqP();
        }
        this.dgW = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds60));
        layoutParams.addRule(10);
        TextView asI = this.dgW.asI();
        if (i == 0) {
            asI.setText(getResources().getString(d.k.recommend_frs_refresh_nodata));
        } else {
            asI.setText(String.format(getResources().getString(d.k.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(asI, layoutParams);
        this.dgW.asJ();
    }

    public void d(int i, int i2, String str) {
        FrsGameStrategyItemListView aG = this.dgS.aG(i, i2);
        if (aG != null) {
            aG.c(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.dgX = aVar;
    }

    public void onChangeSkinType(int i) {
        this.dgP.onChangeSkinType(i);
        this.dgQ.onChangeSkinType(i);
        this.dgS.onChangeSkinType(i);
        ak.j(this.dgT, d.C0126d.cp_bg_line_b);
        ak.j(this.dgU, d.C0126d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.dgW != null) {
            this.dgW.aqP();
        }
        this.dgS.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.dgS.asz();
    }

    public void Ql() {
        FrsGameStrategyItemListView asz = this.dgS.asz();
        if (asz != null) {
            asz.lg();
        }
    }
}

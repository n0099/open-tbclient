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
    private List<e> dgB;
    private int dgD;
    private a dgM;
    private c dgN;
    private ScrollHorizontalTabView dgS;
    private FoldedGridView dgT;
    private d dgU;
    private FrsGameTabPagerAdapter dgV;
    private View dgW;
    private View dgX;
    private boolean dgY;
    private g dgZ;
    private a dha;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bjL = 0;
        this.dgD = 0;
        this.dgY = false;
        this.dgM = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aC(int i, int i2) {
                if (ScrollLabelTabHost.this.dha != null) {
                    ScrollLabelTabHost.this.dha.aC(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aD(int i, int i2) {
                if (ScrollLabelTabHost.this.dha != null) {
                    ScrollLabelTabHost.this.dha.aD(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aE(int i, int i2) {
                if (ScrollLabelTabHost.this.dha != null) {
                    return ScrollLabelTabHost.this.dha.aE(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dha != null) {
                    return ScrollLabelTabHost.this.dha.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kC(int i) {
                if (ScrollLabelTabHost.this.dha != null) {
                    return ScrollLabelTabHost.this.dha.kC(i);
                }
                return null;
            }
        };
        this.dgN = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kF(int i) {
                return (e) v.c(ScrollLabelTabHost.this.dgB, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bjL = 0;
        this.dgD = 0;
        this.dgY = false;
        this.dgM = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aC(int i, int i2) {
                if (ScrollLabelTabHost.this.dha != null) {
                    ScrollLabelTabHost.this.dha.aC(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aD(int i, int i2) {
                if (ScrollLabelTabHost.this.dha != null) {
                    ScrollLabelTabHost.this.dha.aD(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aE(int i, int i2) {
                if (ScrollLabelTabHost.this.dha != null) {
                    return ScrollLabelTabHost.this.dha.aE(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dha != null) {
                    return ScrollLabelTabHost.this.dha.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kC(int i) {
                if (ScrollLabelTabHost.this.dha != null) {
                    return ScrollLabelTabHost.this.dha.kC(i);
                }
                return null;
            }
        };
        this.dgN = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kF(int i) {
                return (e) v.c(ScrollLabelTabHost.this.dgB, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bjL = 0;
        this.dgD = 0;
        this.dgY = false;
        this.dgM = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aC(int i2, int i22) {
                if (ScrollLabelTabHost.this.dha != null) {
                    ScrollLabelTabHost.this.dha.aC(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aD(int i2, int i22) {
                if (ScrollLabelTabHost.this.dha != null) {
                    ScrollLabelTabHost.this.dha.aD(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aE(int i2, int i22) {
                if (ScrollLabelTabHost.this.dha != null) {
                    return ScrollLabelTabHost.this.dha.aE(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.dha != null) {
                    return ScrollLabelTabHost.this.dha.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kC(int i2) {
                if (ScrollLabelTabHost.this.dha != null) {
                    return ScrollLabelTabHost.this.dha.kC(i2);
                }
                return null;
            }
        };
        this.dgN = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kF(int i2) {
                return (e) v.c(ScrollLabelTabHost.this.dgB, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.frs_game_strategy_tab_host_layout, this);
        this.dgV = new FrsGameTabPagerAdapter(context, this.dgM, this.dgN);
        this.mPager = (CustomViewPager) findViewById(d.g.frs_game_pager);
        this.mPager.setAdapter(this.dgV);
        this.dgS = (ScrollHorizontalTabView) findViewById(d.g.frs_game_tab_widget);
        this.dgS.setViewPager(this.mPager);
        this.dgS.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
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
                            ScrollLabelTabHost.this.dgD = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.dgT.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dgT.setVisibility(8);
                    }
                }
            }
        });
        this.dgU = new d(getContext());
        this.dgT = (FoldedGridView) findViewById(d.g.frs_game_label_widget);
        this.dgT.setArrowResouceId(d.f.icon_arrow_gray_down, d.f.icon_arrow_gray_up);
        this.dgT.setNumColumns(5);
        this.dgT.setFoldAdapter(this.dgU);
        this.dgT.setExpandedBottomShadeResourceId(d.f.shape_frs_game_lable_bottom_shade);
        this.dgT.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void c(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dgD = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView asz = ScrollLabelTabHost.this.dgV.asz();
                    asz.aI(ScrollLabelTabHost.this.bjL, ScrollLabelTabHost.this.dgD);
                    if (ScrollLabelTabHost.this.dgM != null && !ScrollLabelTabHost.this.dgM.aE(ScrollLabelTabHost.this.bjL, ScrollLabelTabHost.this.dgD)) {
                        asz.lg();
                    }
                }
            }
        });
        this.dgW = findViewById(d.g.frs_game_tab_line);
        this.dgX = findViewById(d.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dgV != null) {
            this.dgV.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.w(list)) {
            if (this.dgY || this.dgB == null) {
                this.dgY = z;
                this.dgB = list;
                this.dgV.setCount(this.dgB == null ? 0 : this.dgB.size());
                this.dgS.setData(list);
                if (v.w(list)) {
                    this.dgS.setVisibility(8);
                    this.dgW.setVisibility(8);
                    return;
                }
                this.dgS.setVisibility(0);
                this.dgW.setVisibility(0);
                this.dgS.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dgT.setVisibility(0);
                    this.dgX.setVisibility(0);
                    return;
                }
                this.dgT.setVisibility(8);
                this.dgX.setVisibility(8);
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
        this.dgU.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<h> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView aH = this.dgV.aH(i, i2);
        if (aH != null) {
            aH.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                kG(i3);
            }
        }
    }

    public void kG(int i) {
        if (this.dgZ != null && this.dgZ.isShowing()) {
            this.dgZ.aqP();
        }
        this.dgZ = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds60));
        layoutParams.addRule(10);
        TextView asI = this.dgZ.asI();
        if (i == 0) {
            asI.setText(getResources().getString(d.k.recommend_frs_refresh_nodata));
        } else {
            asI.setText(String.format(getResources().getString(d.k.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(asI, layoutParams);
        this.dgZ.asJ();
    }

    public void d(int i, int i2, String str) {
        FrsGameStrategyItemListView aH = this.dgV.aH(i, i2);
        if (aH != null) {
            aH.c(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.dha = aVar;
    }

    public void onChangeSkinType(int i) {
        this.dgS.onChangeSkinType(i);
        this.dgT.onChangeSkinType(i);
        this.dgV.onChangeSkinType(i);
        ak.j(this.dgW, d.C0126d.cp_bg_line_b);
        ak.j(this.dgX, d.C0126d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.dgZ != null) {
            this.dgZ.aqP();
        }
        this.dgV.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.dgV.asz();
    }

    public void Ql() {
        FrsGameStrategyItemListView asz = this.dgV.asz();
        if (asz != null) {
            asz.lg();
        }
    }
}

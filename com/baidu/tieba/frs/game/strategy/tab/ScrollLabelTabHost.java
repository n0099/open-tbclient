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
    private int bkb;
    private List<e> dhF;
    private int dhH;
    private a dhQ;
    private c dhR;
    private ScrollHorizontalTabView dhW;
    private FoldedGridView dhX;
    private d dhY;
    private FrsGameTabPagerAdapter dhZ;
    private View dia;
    private View dib;
    private boolean dic;
    private g did;
    private a die;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bkb = 0;
        this.dhH = 0;
        this.dic = false;
        this.dhQ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aB(int i, int i2) {
                if (ScrollLabelTabHost.this.die != null) {
                    ScrollLabelTabHost.this.die.aB(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aC(int i, int i2) {
                if (ScrollLabelTabHost.this.die != null) {
                    ScrollLabelTabHost.this.die.aC(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aD(int i, int i2) {
                if (ScrollLabelTabHost.this.die != null) {
                    return ScrollLabelTabHost.this.die.aD(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.die != null) {
                    return ScrollLabelTabHost.this.die.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kA(int i) {
                if (ScrollLabelTabHost.this.die != null) {
                    return ScrollLabelTabHost.this.die.kA(i);
                }
                return null;
            }
        };
        this.dhR = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kD(int i) {
                return (e) v.c(ScrollLabelTabHost.this.dhF, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bkb = 0;
        this.dhH = 0;
        this.dic = false;
        this.dhQ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aB(int i, int i2) {
                if (ScrollLabelTabHost.this.die != null) {
                    ScrollLabelTabHost.this.die.aB(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aC(int i, int i2) {
                if (ScrollLabelTabHost.this.die != null) {
                    ScrollLabelTabHost.this.die.aC(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aD(int i, int i2) {
                if (ScrollLabelTabHost.this.die != null) {
                    return ScrollLabelTabHost.this.die.aD(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.die != null) {
                    return ScrollLabelTabHost.this.die.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kA(int i) {
                if (ScrollLabelTabHost.this.die != null) {
                    return ScrollLabelTabHost.this.die.kA(i);
                }
                return null;
            }
        };
        this.dhR = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kD(int i) {
                return (e) v.c(ScrollLabelTabHost.this.dhF, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bkb = 0;
        this.dhH = 0;
        this.dic = false;
        this.dhQ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aB(int i2, int i22) {
                if (ScrollLabelTabHost.this.die != null) {
                    ScrollLabelTabHost.this.die.aB(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void aC(int i2, int i22) {
                if (ScrollLabelTabHost.this.die != null) {
                    ScrollLabelTabHost.this.die.aC(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean aD(int i2, int i22) {
                if (ScrollLabelTabHost.this.die != null) {
                    return ScrollLabelTabHost.this.die.aD(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.die != null) {
                    return ScrollLabelTabHost.this.die.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e kA(int i2) {
                if (ScrollLabelTabHost.this.die != null) {
                    return ScrollLabelTabHost.this.die.kA(i2);
                }
                return null;
            }
        };
        this.dhR = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e kD(int i2) {
                return (e) v.c(ScrollLabelTabHost.this.dhF, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.i.frs_game_strategy_tab_host_layout, this);
        this.dhZ = new FrsGameTabPagerAdapter(context, this.dhQ, this.dhR);
        this.mPager = (CustomViewPager) findViewById(d.g.frs_game_pager);
        this.mPager.setAdapter(this.dhZ);
        this.dhW = (ScrollHorizontalTabView) findViewById(d.g.frs_game_tab_widget);
        this.dhW.setViewPager(this.mPager);
        this.dhW.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.bkb = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dhH = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.dhX.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dhX.setVisibility(8);
                    }
                }
            }
        });
        this.dhY = new d(getContext());
        this.dhX = (FoldedGridView) findViewById(d.g.frs_game_label_widget);
        this.dhX.setArrowResouceId(d.f.icon_arrow_gray_down, d.f.icon_arrow_gray_up);
        this.dhX.setNumColumns(5);
        this.dhX.setFoldAdapter(this.dhY);
        this.dhX.setExpandedBottomShadeResourceId(d.f.shape_frs_game_lable_bottom_shade);
        this.dhX.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void c(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dhH = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView asy = ScrollLabelTabHost.this.dhZ.asy();
                    asy.aH(ScrollLabelTabHost.this.bkb, ScrollLabelTabHost.this.dhH);
                    if (ScrollLabelTabHost.this.dhQ != null && !ScrollLabelTabHost.this.dhQ.aD(ScrollLabelTabHost.this.bkb, ScrollLabelTabHost.this.dhH)) {
                        asy.lf();
                    }
                }
            }
        });
        this.dia = findViewById(d.g.frs_game_tab_line);
        this.dib = findViewById(d.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dhZ != null) {
            this.dhZ.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.w(list)) {
            if (this.dic || this.dhF == null) {
                this.dic = z;
                this.dhF = list;
                this.dhZ.setCount(this.dhF == null ? 0 : this.dhF.size());
                this.dhW.setData(list);
                if (v.w(list)) {
                    this.dhW.setVisibility(8);
                    this.dia.setVisibility(8);
                    return;
                }
                this.dhW.setVisibility(0);
                this.dia.setVisibility(0);
                this.dhW.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dhX.setVisibility(0);
                    this.dib.setVisibility(0);
                    return;
                }
                this.dhX.setVisibility(8);
                this.dib.setVisibility(8);
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
        this.dhY.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<h> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView aG = this.dhZ.aG(i, i2);
        if (aG != null) {
            aG.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                kE(i3);
            }
        }
    }

    public void kE(int i) {
        if (this.did != null && this.did.isShowing()) {
            this.did.aqO();
        }
        this.did = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds60));
        layoutParams.addRule(10);
        TextView asH = this.did.asH();
        if (i == 0) {
            asH.setText(getResources().getString(d.k.recommend_frs_refresh_nodata));
        } else {
            asH.setText(String.format(getResources().getString(d.k.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(asH, layoutParams);
        this.did.asI();
    }

    public void d(int i, int i2, String str) {
        FrsGameStrategyItemListView aG = this.dhZ.aG(i, i2);
        if (aG != null) {
            aG.c(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.die = aVar;
    }

    public void onChangeSkinType(int i) {
        this.dhW.onChangeSkinType(i);
        this.dhX.onChangeSkinType(i);
        this.dhZ.onChangeSkinType(i);
        ak.j(this.dia, d.C0126d.cp_bg_line_b);
        ak.j(this.dib, d.C0126d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.did != null) {
            this.did.aqO();
        }
        this.dhZ.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.dhZ.asy();
    }

    public void Qi() {
        FrsGameStrategyItemListView asy = this.dhZ.asy();
        if (asy != null) {
            asy.lf();
        }
    }
}

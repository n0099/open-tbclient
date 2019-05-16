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
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.frs.game.strategy.view.g;
import java.util.List;
/* loaded from: classes4.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private int dkO;
    private ScrollHorizontalTabView fAB;
    private FoldedGridView fAC;
    private d fAD;
    private FrsGameTabPagerAdapter fAE;
    private View fAF;
    private View fAG;
    private boolean fAH;
    private g fAI;
    private a fAJ;
    private List<e> fAl;
    private int fAn;
    private a fAv;
    private c fAw;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.dkO = 0;
        this.fAn = 0;
        this.fAH = false;
        this.fAv = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bq(int i, int i2) {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    ScrollLabelTabHost.this.fAJ.bq(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void br(int i, int i2) {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    ScrollLabelTabHost.this.fAJ.br(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bs(int i, int i2) {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    return ScrollLabelTabHost.this.fAJ.bs(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    return ScrollLabelTabHost.this.fAJ.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e rJ(int i) {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    return ScrollLabelTabHost.this.fAJ.rJ(i);
                }
                return null;
            }
        };
        this.fAw = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e rM(int i) {
                return (e) v.c(ScrollLabelTabHost.this.fAl, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dkO = 0;
        this.fAn = 0;
        this.fAH = false;
        this.fAv = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bq(int i, int i2) {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    ScrollLabelTabHost.this.fAJ.bq(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void br(int i, int i2) {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    ScrollLabelTabHost.this.fAJ.br(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bs(int i, int i2) {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    return ScrollLabelTabHost.this.fAJ.bs(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    return ScrollLabelTabHost.this.fAJ.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e rJ(int i) {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    return ScrollLabelTabHost.this.fAJ.rJ(i);
                }
                return null;
            }
        };
        this.fAw = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e rM(int i) {
                return (e) v.c(ScrollLabelTabHost.this.fAl, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dkO = 0;
        this.fAn = 0;
        this.fAH = false;
        this.fAv = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bq(int i2, int i22) {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    ScrollLabelTabHost.this.fAJ.bq(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void br(int i2, int i22) {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    ScrollLabelTabHost.this.fAJ.br(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bs(int i2, int i22) {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    return ScrollLabelTabHost.this.fAJ.bs(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    return ScrollLabelTabHost.this.fAJ.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e rJ(int i2) {
                if (ScrollLabelTabHost.this.fAJ != null) {
                    return ScrollLabelTabHost.this.fAJ.rJ(i2);
                }
                return null;
            }
        };
        this.fAw = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e rM(int i2) {
                return (e) v.c(ScrollLabelTabHost.this.fAl, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.fAE = new FrsGameTabPagerAdapter(context, this.fAv, this.fAw);
        this.mPager = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.mPager.setAdapter(this.fAE);
        this.fAB = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.fAB.setViewPager(this.mPager);
        this.fAB.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.dkO = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.fAn = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.fAC.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.fAC.setVisibility(8);
                    }
                }
            }
        });
        this.fAD = new d(getContext());
        this.fAC = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.fAC.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.fAC.setNumColumns(5);
        this.fAC.setFoldAdapter(this.fAD);
        this.fAC.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.fAC.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void f(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.fAn = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bnt = ScrollLabelTabHost.this.fAE.bnt();
                    bnt.bw(ScrollLabelTabHost.this.dkO, ScrollLabelTabHost.this.fAn);
                    if (ScrollLabelTabHost.this.fAv != null && !ScrollLabelTabHost.this.fAv.bs(ScrollLabelTabHost.this.dkO, ScrollLabelTabHost.this.fAn)) {
                        bnt.pullToRefresh();
                    }
                }
            }
        });
        this.fAF = findViewById(R.id.frs_game_tab_line);
        this.fAG = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fAE != null) {
            this.fAE.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.aa(list)) {
            if (this.fAH || this.fAl == null) {
                this.fAH = z;
                this.fAl = list;
                this.fAE.setCount(this.fAl == null ? 0 : this.fAl.size());
                this.fAB.setData(list);
                if (v.aa(list)) {
                    this.fAB.setVisibility(8);
                    this.fAF.setVisibility(8);
                    return;
                }
                this.fAB.setVisibility(0);
                this.fAF.setVisibility(0);
                this.fAB.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.fAC.setVisibility(0);
                    this.fAG.setVisibility(0);
                    return;
                }
                this.fAC.setVisibility(8);
                this.fAG.setVisibility(8);
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
        this.fAD.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bv = this.fAE.bv(i, i2);
        if (bv != null) {
            bv.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                rN(i3);
            }
        }
    }

    public void rN(int i) {
        if (this.fAI != null && this.fAI.isShowing()) {
            this.fAI.blP();
        }
        this.fAI = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bnC = this.fAI.bnC();
        if (i == 0) {
            bnC.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bnC.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bnC, layoutParams);
        this.fAI.bnD();
    }

    public void g(int i, int i2, String str) {
        FrsGameStrategyItemListView bv = this.fAE.bv(i, i2);
        if (bv != null) {
            bv.f(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.fAJ = aVar;
    }

    public void onChangeSkinType(int i) {
        this.fAB.onChangeSkinType(i);
        this.fAC.onChangeSkinType(i);
        this.fAE.onChangeSkinType(i);
        al.l(this.fAF, R.color.cp_bg_line_b);
        al.l(this.fAG, R.color.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.fAI != null) {
            this.fAI.blP();
        }
        this.fAE.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.fAE.bnt();
    }

    public void aID() {
        FrsGameStrategyItemListView bnt = this.fAE.bnt();
        if (bnt != null) {
            bnt.pullToRefresh();
        }
    }
}

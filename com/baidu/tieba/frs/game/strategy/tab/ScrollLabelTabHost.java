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
    private int dkP;
    private ScrollHorizontalTabView fAC;
    private FoldedGridView fAD;
    private d fAE;
    private FrsGameTabPagerAdapter fAF;
    private View fAG;
    private View fAH;
    private boolean fAI;
    private g fAJ;
    private a fAK;
    private List<e> fAm;
    private int fAo;
    private a fAw;
    private c fAx;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.dkP = 0;
        this.fAo = 0;
        this.fAI = false;
        this.fAw = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bq(int i, int i2) {
                if (ScrollLabelTabHost.this.fAK != null) {
                    ScrollLabelTabHost.this.fAK.bq(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void br(int i, int i2) {
                if (ScrollLabelTabHost.this.fAK != null) {
                    ScrollLabelTabHost.this.fAK.br(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bs(int i, int i2) {
                if (ScrollLabelTabHost.this.fAK != null) {
                    return ScrollLabelTabHost.this.fAK.bs(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fAK != null) {
                    return ScrollLabelTabHost.this.fAK.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e rJ(int i) {
                if (ScrollLabelTabHost.this.fAK != null) {
                    return ScrollLabelTabHost.this.fAK.rJ(i);
                }
                return null;
            }
        };
        this.fAx = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e rM(int i) {
                return (e) v.c(ScrollLabelTabHost.this.fAm, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dkP = 0;
        this.fAo = 0;
        this.fAI = false;
        this.fAw = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bq(int i, int i2) {
                if (ScrollLabelTabHost.this.fAK != null) {
                    ScrollLabelTabHost.this.fAK.bq(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void br(int i, int i2) {
                if (ScrollLabelTabHost.this.fAK != null) {
                    ScrollLabelTabHost.this.fAK.br(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bs(int i, int i2) {
                if (ScrollLabelTabHost.this.fAK != null) {
                    return ScrollLabelTabHost.this.fAK.bs(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fAK != null) {
                    return ScrollLabelTabHost.this.fAK.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e rJ(int i) {
                if (ScrollLabelTabHost.this.fAK != null) {
                    return ScrollLabelTabHost.this.fAK.rJ(i);
                }
                return null;
            }
        };
        this.fAx = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e rM(int i) {
                return (e) v.c(ScrollLabelTabHost.this.fAm, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dkP = 0;
        this.fAo = 0;
        this.fAI = false;
        this.fAw = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bq(int i2, int i22) {
                if (ScrollLabelTabHost.this.fAK != null) {
                    ScrollLabelTabHost.this.fAK.bq(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void br(int i2, int i22) {
                if (ScrollLabelTabHost.this.fAK != null) {
                    ScrollLabelTabHost.this.fAK.br(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bs(int i2, int i22) {
                if (ScrollLabelTabHost.this.fAK != null) {
                    return ScrollLabelTabHost.this.fAK.bs(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fAK != null) {
                    return ScrollLabelTabHost.this.fAK.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e rJ(int i2) {
                if (ScrollLabelTabHost.this.fAK != null) {
                    return ScrollLabelTabHost.this.fAK.rJ(i2);
                }
                return null;
            }
        };
        this.fAx = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e rM(int i2) {
                return (e) v.c(ScrollLabelTabHost.this.fAm, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.fAF = new FrsGameTabPagerAdapter(context, this.fAw, this.fAx);
        this.mPager = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.mPager.setAdapter(this.fAF);
        this.fAC = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.fAC.setViewPager(this.mPager);
        this.fAC.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.dkP = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.fAo = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.fAD.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.fAD.setVisibility(8);
                    }
                }
            }
        });
        this.fAE = new d(getContext());
        this.fAD = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.fAD.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.fAD.setNumColumns(5);
        this.fAD.setFoldAdapter(this.fAE);
        this.fAD.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.fAD.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void f(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.fAo = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bnw = ScrollLabelTabHost.this.fAF.bnw();
                    bnw.bw(ScrollLabelTabHost.this.dkP, ScrollLabelTabHost.this.fAo);
                    if (ScrollLabelTabHost.this.fAw != null && !ScrollLabelTabHost.this.fAw.bs(ScrollLabelTabHost.this.dkP, ScrollLabelTabHost.this.fAo)) {
                        bnw.pullToRefresh();
                    }
                }
            }
        });
        this.fAG = findViewById(R.id.frs_game_tab_line);
        this.fAH = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fAF != null) {
            this.fAF.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.aa(list)) {
            if (this.fAI || this.fAm == null) {
                this.fAI = z;
                this.fAm = list;
                this.fAF.setCount(this.fAm == null ? 0 : this.fAm.size());
                this.fAC.setData(list);
                if (v.aa(list)) {
                    this.fAC.setVisibility(8);
                    this.fAG.setVisibility(8);
                    return;
                }
                this.fAC.setVisibility(0);
                this.fAG.setVisibility(0);
                this.fAC.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.fAD.setVisibility(0);
                    this.fAH.setVisibility(0);
                    return;
                }
                this.fAD.setVisibility(8);
                this.fAH.setVisibility(8);
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
        this.fAE.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bv = this.fAF.bv(i, i2);
        if (bv != null) {
            bv.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                rN(i3);
            }
        }
    }

    public void rN(int i) {
        if (this.fAJ != null && this.fAJ.isShowing()) {
            this.fAJ.blS();
        }
        this.fAJ = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bnF = this.fAJ.bnF();
        if (i == 0) {
            bnF.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bnF.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bnF, layoutParams);
        this.fAJ.bnG();
    }

    public void g(int i, int i2, String str) {
        FrsGameStrategyItemListView bv = this.fAF.bv(i, i2);
        if (bv != null) {
            bv.f(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.fAK = aVar;
    }

    public void onChangeSkinType(int i) {
        this.fAC.onChangeSkinType(i);
        this.fAD.onChangeSkinType(i);
        this.fAF.onChangeSkinType(i);
        al.l(this.fAG, R.color.cp_bg_line_b);
        al.l(this.fAH, R.color.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.fAJ != null) {
            this.fAJ.blS();
        }
        this.fAF.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.fAF.bnw();
    }

    public void aIG() {
        FrsGameStrategyItemListView bnw = this.fAF.bnw();
        if (bnw != null) {
            bnw.pullToRefresh();
        }
    }
}

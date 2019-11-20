package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.am;
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
    private ScrollHorizontalTabView fGC;
    private FoldedGridView fGD;
    private d fGE;
    private CustomViewPager fGF;
    private FrsGameTabPagerAdapter fGG;
    private View fGH;
    private View fGI;
    private boolean fGJ;
    private g fGK;
    private a fGL;
    private List<e> fGl;
    private int fGn;
    private int fGo;
    private a fGw;
    private c fGx;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.fGn = 0;
        this.fGo = 0;
        this.fGJ = false;
        this.fGw = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bp(int i, int i2) {
                if (ScrollLabelTabHost.this.fGL != null) {
                    ScrollLabelTabHost.this.fGL.bp(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bq(int i, int i2) {
                if (ScrollLabelTabHost.this.fGL != null) {
                    ScrollLabelTabHost.this.fGL.bq(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean br(int i, int i2) {
                if (ScrollLabelTabHost.this.fGL != null) {
                    return ScrollLabelTabHost.this.fGL.br(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fGL != null) {
                    return ScrollLabelTabHost.this.fGL.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e qZ(int i) {
                if (ScrollLabelTabHost.this.fGL != null) {
                    return ScrollLabelTabHost.this.fGL.qZ(i);
                }
                return null;
            }
        };
        this.fGx = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e rc(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.fGl, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fGn = 0;
        this.fGo = 0;
        this.fGJ = false;
        this.fGw = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bp(int i, int i2) {
                if (ScrollLabelTabHost.this.fGL != null) {
                    ScrollLabelTabHost.this.fGL.bp(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bq(int i, int i2) {
                if (ScrollLabelTabHost.this.fGL != null) {
                    ScrollLabelTabHost.this.fGL.bq(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean br(int i, int i2) {
                if (ScrollLabelTabHost.this.fGL != null) {
                    return ScrollLabelTabHost.this.fGL.br(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fGL != null) {
                    return ScrollLabelTabHost.this.fGL.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e qZ(int i) {
                if (ScrollLabelTabHost.this.fGL != null) {
                    return ScrollLabelTabHost.this.fGL.qZ(i);
                }
                return null;
            }
        };
        this.fGx = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e rc(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.fGl, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fGn = 0;
        this.fGo = 0;
        this.fGJ = false;
        this.fGw = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bp(int i2, int i22) {
                if (ScrollLabelTabHost.this.fGL != null) {
                    ScrollLabelTabHost.this.fGL.bp(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bq(int i2, int i22) {
                if (ScrollLabelTabHost.this.fGL != null) {
                    ScrollLabelTabHost.this.fGL.bq(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean br(int i2, int i22) {
                if (ScrollLabelTabHost.this.fGL != null) {
                    return ScrollLabelTabHost.this.fGL.br(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fGL != null) {
                    return ScrollLabelTabHost.this.fGL.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e qZ(int i2) {
                if (ScrollLabelTabHost.this.fGL != null) {
                    return ScrollLabelTabHost.this.fGL.qZ(i2);
                }
                return null;
            }
        };
        this.fGx = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e rc(int i2) {
                return (e) v.getItem(ScrollLabelTabHost.this.fGl, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.fGG = new FrsGameTabPagerAdapter(context, this.fGw, this.fGx);
        this.fGF = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.fGF.setAdapter(this.fGG);
        this.fGC = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.fGC.setViewPager(this.fGF);
        this.fGC.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.fGn = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.fGo = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.fGD.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.fGD.setVisibility(8);
                    }
                }
            }
        });
        this.fGE = new d(getContext());
        this.fGD = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.fGD.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.fGD.setNumColumns(5);
        this.fGD.setFoldAdapter(this.fGE);
        this.fGD.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.fGD.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.fGo = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bnz = ScrollLabelTabHost.this.fGG.bnz();
                    bnz.bv(ScrollLabelTabHost.this.fGn, ScrollLabelTabHost.this.fGo);
                    if (ScrollLabelTabHost.this.fGw != null && !ScrollLabelTabHost.this.fGw.br(ScrollLabelTabHost.this.fGn, ScrollLabelTabHost.this.fGo)) {
                        bnz.pullToRefresh();
                    }
                }
            }
        });
        this.fGH = findViewById(R.id.frs_game_tab_line);
        this.fGI = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fGG != null) {
            this.fGG.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (this.fGJ || this.fGl == null) {
                this.fGJ = z;
                this.fGl = list;
                this.fGG.setCount(this.fGl == null ? 0 : this.fGl.size());
                this.fGC.setData(list);
                if (v.isEmpty(list)) {
                    this.fGC.setVisibility(8);
                    this.fGH.setVisibility(8);
                    return;
                }
                this.fGC.setVisibility(0);
                this.fGH.setVisibility(0);
                this.fGC.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.fGD.setVisibility(0);
                    this.fGI.setVisibility(0);
                    return;
                }
                this.fGD.setVisibility(8);
                this.fGI.setVisibility(8);
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
        this.fGE.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bu = this.fGG.bu(i, i2);
        if (bu != null) {
            bu.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                rd(i3);
            }
        }
    }

    public void rd(int i) {
        if (this.fGK != null && this.fGK.isShowing()) {
            this.fGK.blQ();
        }
        this.fGK = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bnI = this.fGK.bnI();
        if (i == 0) {
            bnI.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bnI.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bnI, layoutParams);
        this.fGK.bnJ();
    }

    public void g(int i, int i2, String str) {
        FrsGameStrategyItemListView bu = this.fGG.bu(i, i2);
        if (bu != null) {
            bu.f(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.fGL = aVar;
    }

    public void onChangeSkinType(int i) {
        this.fGC.onChangeSkinType(i);
        this.fGD.onChangeSkinType(i);
        this.fGG.onChangeSkinType(i);
        am.setBackgroundColor(this.fGH, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.fGI, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.fGK != null) {
            this.fGK.blQ();
        }
        this.fGG.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.fGG.bnz();
    }

    public void aKf() {
        FrsGameStrategyItemListView bnz = this.fGG.bnz();
        if (bnz != null) {
            bnz.pullToRefresh();
        }
    }
}

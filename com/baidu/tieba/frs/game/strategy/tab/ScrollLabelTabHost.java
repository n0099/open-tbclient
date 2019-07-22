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
    private int dmx;
    private ScrollHorizontalTabView fFA;
    private FoldedGridView fFB;
    private d fFC;
    private FrsGameTabPagerAdapter fFD;
    private View fFE;
    private View fFF;
    private boolean fFG;
    private g fFH;
    private a fFI;
    private List<e> fFk;
    private int fFm;
    private a fFu;
    private c fFv;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.dmx = 0;
        this.fFm = 0;
        this.fFG = false;
        this.fFu = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bv(int i, int i2) {
                if (ScrollLabelTabHost.this.fFI != null) {
                    ScrollLabelTabHost.this.fFI.bv(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bw(int i, int i2) {
                if (ScrollLabelTabHost.this.fFI != null) {
                    ScrollLabelTabHost.this.fFI.bw(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bx(int i, int i2) {
                if (ScrollLabelTabHost.this.fFI != null) {
                    return ScrollLabelTabHost.this.fFI.bx(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fFI != null) {
                    return ScrollLabelTabHost.this.fFI.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e sb(int i) {
                if (ScrollLabelTabHost.this.fFI != null) {
                    return ScrollLabelTabHost.this.fFI.sb(i);
                }
                return null;
            }
        };
        this.fFv = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e se(int i) {
                return (e) v.c(ScrollLabelTabHost.this.fFk, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dmx = 0;
        this.fFm = 0;
        this.fFG = false;
        this.fFu = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bv(int i, int i2) {
                if (ScrollLabelTabHost.this.fFI != null) {
                    ScrollLabelTabHost.this.fFI.bv(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bw(int i, int i2) {
                if (ScrollLabelTabHost.this.fFI != null) {
                    ScrollLabelTabHost.this.fFI.bw(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bx(int i, int i2) {
                if (ScrollLabelTabHost.this.fFI != null) {
                    return ScrollLabelTabHost.this.fFI.bx(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fFI != null) {
                    return ScrollLabelTabHost.this.fFI.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e sb(int i) {
                if (ScrollLabelTabHost.this.fFI != null) {
                    return ScrollLabelTabHost.this.fFI.sb(i);
                }
                return null;
            }
        };
        this.fFv = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e se(int i) {
                return (e) v.c(ScrollLabelTabHost.this.fFk, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dmx = 0;
        this.fFm = 0;
        this.fFG = false;
        this.fFu = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bv(int i2, int i22) {
                if (ScrollLabelTabHost.this.fFI != null) {
                    ScrollLabelTabHost.this.fFI.bv(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bw(int i2, int i22) {
                if (ScrollLabelTabHost.this.fFI != null) {
                    ScrollLabelTabHost.this.fFI.bw(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bx(int i2, int i22) {
                if (ScrollLabelTabHost.this.fFI != null) {
                    return ScrollLabelTabHost.this.fFI.bx(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fFI != null) {
                    return ScrollLabelTabHost.this.fFI.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e sb(int i2) {
                if (ScrollLabelTabHost.this.fFI != null) {
                    return ScrollLabelTabHost.this.fFI.sb(i2);
                }
                return null;
            }
        };
        this.fFv = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e se(int i2) {
                return (e) v.c(ScrollLabelTabHost.this.fFk, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.fFD = new FrsGameTabPagerAdapter(context, this.fFu, this.fFv);
        this.mPager = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.mPager.setAdapter(this.fFD);
        this.fFA = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.fFA.setViewPager(this.mPager);
        this.fFA.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.dmx = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.fFm = aVar.bFL;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.fFB.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.fFB.setVisibility(8);
                    }
                }
            }
        });
        this.fFC = new d(getContext());
        this.fFB = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.fFB.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.fFB.setNumColumns(5);
        this.fFB.setFoldAdapter(this.fFC);
        this.fFB.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.fFB.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void f(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.fFm = ((com.baidu.tieba.frs.game.strategy.data.a) obj).bFL;
                    FrsGameStrategyItemListView bpx = ScrollLabelTabHost.this.fFD.bpx();
                    bpx.bB(ScrollLabelTabHost.this.dmx, ScrollLabelTabHost.this.fFm);
                    if (ScrollLabelTabHost.this.fFu != null && !ScrollLabelTabHost.this.fFu.bx(ScrollLabelTabHost.this.dmx, ScrollLabelTabHost.this.fFm)) {
                        bpx.pullToRefresh();
                    }
                }
            }
        });
        this.fFE = findViewById(R.id.frs_game_tab_line);
        this.fFF = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fFD != null) {
            this.fFD.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.aa(list)) {
            if (this.fFG || this.fFk == null) {
                this.fFG = z;
                this.fFk = list;
                this.fFD.setCount(this.fFk == null ? 0 : this.fFk.size());
                this.fFA.setData(list);
                if (v.aa(list)) {
                    this.fFA.setVisibility(8);
                    this.fFE.setVisibility(8);
                    return;
                }
                this.fFA.setVisibility(0);
                this.fFE.setVisibility(0);
                this.fFA.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.fFB.setVisibility(0);
                    this.fFF.setVisibility(0);
                    return;
                }
                this.fFB.setVisibility(8);
                this.fFF.setVisibility(8);
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
        this.fFC.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bA = this.fFD.bA(i, i2);
        if (bA != null) {
            bA.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                sf(i3);
            }
        }
    }

    public void sf(int i) {
        if (this.fFH != null && this.fFH.isShowing()) {
            this.fFH.bnT();
        }
        this.fFH = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bpG = this.fFH.bpG();
        if (i == 0) {
            bpG.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bpG.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bpG, layoutParams);
        this.fFH.bpH();
    }

    public void g(int i, int i2, String str) {
        FrsGameStrategyItemListView bA = this.fFD.bA(i, i2);
        if (bA != null) {
            bA.f(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.fFI = aVar;
    }

    public void onChangeSkinType(int i) {
        this.fFA.onChangeSkinType(i);
        this.fFB.onChangeSkinType(i);
        this.fFD.onChangeSkinType(i);
        am.l(this.fFE, R.color.cp_bg_line_b);
        am.l(this.fFF, R.color.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.fFH != null) {
            this.fFH.bnT();
        }
        this.fFD.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.fFD.bpx();
    }

    public void aKh() {
        FrsGameStrategyItemListView bpx = this.fFD.bpx();
        if (bpx != null) {
            bpx.pullToRefresh();
        }
    }
}

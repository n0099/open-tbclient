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
    private int dor;
    private List<e> fHN;
    private int fHP;
    private a fHX;
    private c fHY;
    private ScrollHorizontalTabView fId;
    private FoldedGridView fIe;
    private d fIf;
    private FrsGameTabPagerAdapter fIg;
    private View fIh;
    private View fIi;
    private boolean fIj;
    private g fIk;
    private a fIl;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.dor = 0;
        this.fHP = 0;
        this.fIj = false;
        this.fHX = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bv(int i, int i2) {
                if (ScrollLabelTabHost.this.fIl != null) {
                    ScrollLabelTabHost.this.fIl.bv(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bw(int i, int i2) {
                if (ScrollLabelTabHost.this.fIl != null) {
                    ScrollLabelTabHost.this.fIl.bw(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bx(int i, int i2) {
                if (ScrollLabelTabHost.this.fIl != null) {
                    return ScrollLabelTabHost.this.fIl.bx(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fIl != null) {
                    return ScrollLabelTabHost.this.fIl.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e sh(int i) {
                if (ScrollLabelTabHost.this.fIl != null) {
                    return ScrollLabelTabHost.this.fIl.sh(i);
                }
                return null;
            }
        };
        this.fHY = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e sk(int i) {
                return (e) v.c(ScrollLabelTabHost.this.fHN, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dor = 0;
        this.fHP = 0;
        this.fIj = false;
        this.fHX = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bv(int i, int i2) {
                if (ScrollLabelTabHost.this.fIl != null) {
                    ScrollLabelTabHost.this.fIl.bv(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bw(int i, int i2) {
                if (ScrollLabelTabHost.this.fIl != null) {
                    ScrollLabelTabHost.this.fIl.bw(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bx(int i, int i2) {
                if (ScrollLabelTabHost.this.fIl != null) {
                    return ScrollLabelTabHost.this.fIl.bx(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fIl != null) {
                    return ScrollLabelTabHost.this.fIl.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e sh(int i) {
                if (ScrollLabelTabHost.this.fIl != null) {
                    return ScrollLabelTabHost.this.fIl.sh(i);
                }
                return null;
            }
        };
        this.fHY = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e sk(int i) {
                return (e) v.c(ScrollLabelTabHost.this.fHN, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dor = 0;
        this.fHP = 0;
        this.fIj = false;
        this.fHX = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bv(int i2, int i22) {
                if (ScrollLabelTabHost.this.fIl != null) {
                    ScrollLabelTabHost.this.fIl.bv(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bw(int i2, int i22) {
                if (ScrollLabelTabHost.this.fIl != null) {
                    ScrollLabelTabHost.this.fIl.bw(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bx(int i2, int i22) {
                if (ScrollLabelTabHost.this.fIl != null) {
                    return ScrollLabelTabHost.this.fIl.bx(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.fIl != null) {
                    return ScrollLabelTabHost.this.fIl.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e sh(int i2) {
                if (ScrollLabelTabHost.this.fIl != null) {
                    return ScrollLabelTabHost.this.fIl.sh(i2);
                }
                return null;
            }
        };
        this.fHY = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e sk(int i2) {
                return (e) v.c(ScrollLabelTabHost.this.fHN, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.fIg = new FrsGameTabPagerAdapter(context, this.fHX, this.fHY);
        this.mPager = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.mPager.setAdapter(this.fIg);
        this.fId = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.fId.setViewPager(this.mPager);
        this.fId.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.dor = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.fHP = aVar.bGk;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.fIe.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.fIe.setVisibility(8);
                    }
                }
            }
        });
        this.fIf = new d(getContext());
        this.fIe = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.fIe.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.fIe.setNumColumns(5);
        this.fIe.setFoldAdapter(this.fIf);
        this.fIe.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.fIe.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void f(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.fHP = ((com.baidu.tieba.frs.game.strategy.data.a) obj).bGk;
                    FrsGameStrategyItemListView bqw = ScrollLabelTabHost.this.fIg.bqw();
                    bqw.bB(ScrollLabelTabHost.this.dor, ScrollLabelTabHost.this.fHP);
                    if (ScrollLabelTabHost.this.fHX != null && !ScrollLabelTabHost.this.fHX.bx(ScrollLabelTabHost.this.dor, ScrollLabelTabHost.this.fHP)) {
                        bqw.pullToRefresh();
                    }
                }
            }
        });
        this.fIh = findViewById(R.id.frs_game_tab_line);
        this.fIi = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.fIg != null) {
            this.fIg.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.aa(list)) {
            if (this.fIj || this.fHN == null) {
                this.fIj = z;
                this.fHN = list;
                this.fIg.setCount(this.fHN == null ? 0 : this.fHN.size());
                this.fId.setData(list);
                if (v.aa(list)) {
                    this.fId.setVisibility(8);
                    this.fIh.setVisibility(8);
                    return;
                }
                this.fId.setVisibility(0);
                this.fIh.setVisibility(0);
                this.fId.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.fIe.setVisibility(0);
                    this.fIi.setVisibility(0);
                    return;
                }
                this.fIe.setVisibility(8);
                this.fIi.setVisibility(8);
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
        this.fIf.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bA = this.fIg.bA(i, i2);
        if (bA != null) {
            bA.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                sl(i3);
            }
        }
    }

    public void sl(int i) {
        if (this.fIk != null && this.fIk.isShowing()) {
            this.fIk.boO();
        }
        this.fIk = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bqF = this.fIk.bqF();
        if (i == 0) {
            bqF.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bqF.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bqF, layoutParams);
        this.fIk.bqG();
    }

    public void g(int i, int i2, String str) {
        FrsGameStrategyItemListView bA = this.fIg.bA(i, i2);
        if (bA != null) {
            bA.f(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.fIl = aVar;
    }

    public void onChangeSkinType(int i) {
        this.fId.onChangeSkinType(i);
        this.fIe.onChangeSkinType(i);
        this.fIg.onChangeSkinType(i);
        am.l(this.fIh, R.color.cp_bg_line_c);
        am.l(this.fIi, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.fIk != null) {
            this.fIk.boO();
        }
        this.fIg.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.fIg.bqw();
    }

    public void aKN() {
        FrsGameStrategyItemListView bqw = this.fIg.bqw();
        if (bqw != null) {
            bqw.pullToRefresh();
        }
    }
}

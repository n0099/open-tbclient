package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.frs.game.strategy.view.f;
import java.util.List;
/* loaded from: classes2.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private List<e> jxO;
    private int jxQ;
    private int jxR;
    private a jxZ;
    private c jya;
    private ScrollHorizontalTabView jyf;
    private FoldedGridView jyg;
    private d jyh;
    private CustomViewPager jyi;
    private FrsGameTabPagerAdapter jyj;
    private View jyk;
    private View jyl;
    private boolean jym;
    private f jyn;
    private a jyo;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.jxQ = 0;
        this.jxR = 0;
        this.jym = false;
        this.jxZ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i, int i2) {
                if (ScrollLabelTabHost.this.jyo != null) {
                    ScrollLabelTabHost.this.jyo.cr(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cs(int i, int i2) {
                if (ScrollLabelTabHost.this.jyo != null) {
                    ScrollLabelTabHost.this.jyo.cs(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ct(int i, int i2) {
                if (ScrollLabelTabHost.this.jyo != null) {
                    return ScrollLabelTabHost.this.jyo.ct(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jyo != null) {
                    return ScrollLabelTabHost.this.jyo.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zE(int i) {
                if (ScrollLabelTabHost.this.jyo != null) {
                    return ScrollLabelTabHost.this.jyo.zE(i);
                }
                return null;
            }
        };
        this.jya = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zH(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.jxO, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jxQ = 0;
        this.jxR = 0;
        this.jym = false;
        this.jxZ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i, int i2) {
                if (ScrollLabelTabHost.this.jyo != null) {
                    ScrollLabelTabHost.this.jyo.cr(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cs(int i, int i2) {
                if (ScrollLabelTabHost.this.jyo != null) {
                    ScrollLabelTabHost.this.jyo.cs(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ct(int i, int i2) {
                if (ScrollLabelTabHost.this.jyo != null) {
                    return ScrollLabelTabHost.this.jyo.ct(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jyo != null) {
                    return ScrollLabelTabHost.this.jyo.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zE(int i) {
                if (ScrollLabelTabHost.this.jyo != null) {
                    return ScrollLabelTabHost.this.jyo.zE(i);
                }
                return null;
            }
        };
        this.jya = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zH(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.jxO, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jxQ = 0;
        this.jxR = 0;
        this.jym = false;
        this.jxZ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cr(int i2, int i22) {
                if (ScrollLabelTabHost.this.jyo != null) {
                    ScrollLabelTabHost.this.jyo.cr(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cs(int i2, int i22) {
                if (ScrollLabelTabHost.this.jyo != null) {
                    ScrollLabelTabHost.this.jyo.cs(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean ct(int i2, int i22) {
                if (ScrollLabelTabHost.this.jyo != null) {
                    return ScrollLabelTabHost.this.jyo.ct(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jyo != null) {
                    return ScrollLabelTabHost.this.jyo.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e zE(int i2) {
                if (ScrollLabelTabHost.this.jyo != null) {
                    return ScrollLabelTabHost.this.jyo.zE(i2);
                }
                return null;
            }
        };
        this.jya = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e zH(int i2) {
                return (e) y.getItem(ScrollLabelTabHost.this.jxO, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.jyj = new FrsGameTabPagerAdapter(context, this.jxZ, this.jya);
        this.jyi = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.jyi.setAdapter(this.jyj);
        this.jyf = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.jyf.setViewPager(this.jyi);
        this.jyf.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.jxQ = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.jxR = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.jyg.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.jyg.setVisibility(8);
                    }
                }
            }
        });
        this.jyh = new d(getContext());
        this.jyg = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.jyg.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.jyg.setNumColumns(5);
        this.jyg.setFoldAdapter(this.jyh);
        this.jyg.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.jyg.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void l(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.jxR = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cHW = ScrollLabelTabHost.this.jyj.cHW();
                    cHW.cx(ScrollLabelTabHost.this.jxQ, ScrollLabelTabHost.this.jxR);
                    if (ScrollLabelTabHost.this.jxZ != null && !ScrollLabelTabHost.this.jxZ.ct(ScrollLabelTabHost.this.jxQ, ScrollLabelTabHost.this.jxR)) {
                        cHW.pullToRefresh();
                    }
                }
            }
        });
        this.jyk = findViewById(R.id.frs_game_tab_line);
        this.jyl = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jyj != null) {
            this.jyj.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (this.jym || this.jxO == null) {
                this.jym = z;
                this.jxO = list;
                this.jyj.setCount(this.jxO == null ? 0 : this.jxO.size());
                this.jyf.setData(list);
                if (y.isEmpty(list)) {
                    this.jyf.setVisibility(8);
                    this.jyk.setVisibility(8);
                    return;
                }
                this.jyf.setVisibility(0);
                this.jyk.setVisibility(0);
                this.jyf.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.jyg.setVisibility(0);
                    this.jyl.setVisibility(0);
                    return;
                }
                this.jyg.setVisibility(8);
                this.jyl.setVisibility(8);
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
        this.jyh.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<n> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView cw = this.jyj.cw(i, i2);
        if (cw != null) {
            cw.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                zI(i3);
            }
        }
    }

    public void zI(int i) {
        if (this.jyn != null && this.jyn.isShowing()) {
            this.jyn.cEX();
        }
        this.jyn = new f(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cIf = this.jyn.cIf();
        if (i == 0) {
            cIf.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cIf.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cIf, layoutParams);
        this.jyn.cIg();
    }

    public void n(int i, int i2, String str) {
        FrsGameStrategyItemListView cw = this.jyj.cw(i, i2);
        if (cw != null) {
            cw.m(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.jyo = aVar;
    }

    public void onChangeSkinType(int i) {
        this.jyf.onChangeSkinType(i);
        this.jyg.onChangeSkinType(i);
        this.jyj.onChangeSkinType(i);
        ap.setBackgroundColor(this.jyk, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jyl, R.color.CAM_X0204);
    }

    public void onDestory() {
        if (this.jyn != null) {
            this.jyn.cEX();
        }
        this.jyj.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.jyj.cHW();
    }

    public void bSx() {
        FrsGameStrategyItemListView cHW = this.jyj.cHW();
        if (cHW != null) {
            cHW.pullToRefresh();
        }
    }
}

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
/* loaded from: classes7.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private List<e> gxO;
    private int gxQ;
    private int gxR;
    private a gxZ;
    private c gya;
    private ScrollHorizontalTabView gyf;
    private FoldedGridView gyg;
    private d gyh;
    private CustomViewPager gyi;
    private FrsGameTabPagerAdapter gyj;
    private View gyk;
    private View gyl;
    private boolean gym;
    private g gyn;
    private a gyo;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.gxQ = 0;
        this.gxR = 0;
        this.gym = false;
        this.gxZ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bG(int i, int i2) {
                if (ScrollLabelTabHost.this.gyo != null) {
                    ScrollLabelTabHost.this.gyo.bG(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i, int i2) {
                if (ScrollLabelTabHost.this.gyo != null) {
                    ScrollLabelTabHost.this.gyo.bH(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bI(int i, int i2) {
                if (ScrollLabelTabHost.this.gyo != null) {
                    return ScrollLabelTabHost.this.gyo.bI(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gyo != null) {
                    return ScrollLabelTabHost.this.gyo.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tk(int i) {
                if (ScrollLabelTabHost.this.gyo != null) {
                    return ScrollLabelTabHost.this.gyo.tk(i);
                }
                return null;
            }
        };
        this.gya = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tn(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.gxO, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gxQ = 0;
        this.gxR = 0;
        this.gym = false;
        this.gxZ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bG(int i, int i2) {
                if (ScrollLabelTabHost.this.gyo != null) {
                    ScrollLabelTabHost.this.gyo.bG(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i, int i2) {
                if (ScrollLabelTabHost.this.gyo != null) {
                    ScrollLabelTabHost.this.gyo.bH(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bI(int i, int i2) {
                if (ScrollLabelTabHost.this.gyo != null) {
                    return ScrollLabelTabHost.this.gyo.bI(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gyo != null) {
                    return ScrollLabelTabHost.this.gyo.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tk(int i) {
                if (ScrollLabelTabHost.this.gyo != null) {
                    return ScrollLabelTabHost.this.gyo.tk(i);
                }
                return null;
            }
        };
        this.gya = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tn(int i) {
                return (e) v.getItem(ScrollLabelTabHost.this.gxO, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gxQ = 0;
        this.gxR = 0;
        this.gym = false;
        this.gxZ = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bG(int i2, int i22) {
                if (ScrollLabelTabHost.this.gyo != null) {
                    ScrollLabelTabHost.this.gyo.bG(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void bH(int i2, int i22) {
                if (ScrollLabelTabHost.this.gyo != null) {
                    ScrollLabelTabHost.this.gyo.bH(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean bI(int i2, int i22) {
                if (ScrollLabelTabHost.this.gyo != null) {
                    return ScrollLabelTabHost.this.gyo.bI(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.gyo != null) {
                    return ScrollLabelTabHost.this.gyo.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e tk(int i2) {
                if (ScrollLabelTabHost.this.gyo != null) {
                    return ScrollLabelTabHost.this.gyo.tk(i2);
                }
                return null;
            }
        };
        this.gya = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e tn(int i2) {
                return (e) v.getItem(ScrollLabelTabHost.this.gxO, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.gyj = new FrsGameTabPagerAdapter(context, this.gxZ, this.gya);
        this.gyi = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.gyi.setAdapter(this.gyj);
        this.gyf = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.gyf.setViewPager(this.gyi);
        this.gyf.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.gxQ = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.gxR = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.gyg.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.gyg.setVisibility(8);
                    }
                }
            }
        });
        this.gyh = new d(getContext());
        this.gyg = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.gyg.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.gyg.setNumColumns(5);
        this.gyg.setFoldAdapter(this.gyh);
        this.gyg.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.gyg.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.gxR = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView bFY = ScrollLabelTabHost.this.gyj.bFY();
                    bFY.bM(ScrollLabelTabHost.this.gxQ, ScrollLabelTabHost.this.gxR);
                    if (ScrollLabelTabHost.this.gxZ != null && !ScrollLabelTabHost.this.gxZ.bI(ScrollLabelTabHost.this.gxQ, ScrollLabelTabHost.this.gxR)) {
                        bFY.pullToRefresh();
                    }
                }
            }
        });
        this.gyk = findViewById(R.id.frs_game_tab_line);
        this.gyl = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.gyj != null) {
            this.gyj.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!v.isEmpty(list)) {
            if (this.gym || this.gxO == null) {
                this.gym = z;
                this.gxO = list;
                this.gyj.setCount(this.gxO == null ? 0 : this.gxO.size());
                this.gyf.setData(list);
                if (v.isEmpty(list)) {
                    this.gyf.setVisibility(8);
                    this.gyk.setVisibility(8);
                    return;
                }
                this.gyf.setVisibility(0);
                this.gyk.setVisibility(0);
                this.gyf.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.gyg.setVisibility(0);
                    this.gyl.setVisibility(0);
                    return;
                }
                this.gyg.setVisibility(8);
                this.gyl.setVisibility(8);
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
        this.gyh.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<m> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView bL = this.gyj.bL(i, i2);
        if (bL != null) {
            bL.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                to(i3);
            }
        }
    }

    public void to(int i) {
        if (this.gyn != null && this.gyn.isShowing()) {
            this.gyn.bEo();
        }
        this.gyn = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView bGh = this.gyn.bGh();
        if (i == 0) {
            bGh.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            bGh.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(bGh, layoutParams);
        this.gyn.bGi();
    }

    public void k(int i, int i2, String str) {
        FrsGameStrategyItemListView bL = this.gyj.bL(i, i2);
        if (bL != null) {
            bL.j(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.gyo = aVar;
    }

    public void onChangeSkinType(int i) {
        this.gyf.onChangeSkinType(i);
        this.gyg.onChangeSkinType(i);
        this.gyj.onChangeSkinType(i);
        am.setBackgroundColor(this.gyk, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.gyl, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.gyn != null) {
            this.gyn.bEo();
        }
        this.gyj.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.gyj.bFY();
    }

    public void baZ() {
        FrsGameStrategyItemListView bFY = this.gyj.bFY();
        if (bFY != null) {
            bFY.pullToRefresh();
        }
    }
}

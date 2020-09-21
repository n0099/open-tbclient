package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.FrsGameStrategyItemListView;
import com.baidu.tieba.frs.game.strategy.view.g;
import java.util.List;
/* loaded from: classes21.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private List<e> ioC;
    private int ioE;
    private int ioF;
    private a ioN;
    private c ioO;
    private ScrollHorizontalTabView ioT;
    private FoldedGridView ioU;
    private d ioV;
    private CustomViewPager ioW;
    private FrsGameTabPagerAdapter ioX;
    private View ioY;
    private View ioZ;
    private boolean ipa;
    private g ipb;
    private a ipc;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.ioE = 0;
        this.ioF = 0;
        this.ipa = false;
        this.ioN = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cn(int i, int i2) {
                if (ScrollLabelTabHost.this.ipc != null) {
                    ScrollLabelTabHost.this.ipc.cn(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void co(int i, int i2) {
                if (ScrollLabelTabHost.this.ipc != null) {
                    ScrollLabelTabHost.this.ipc.co(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cp(int i, int i2) {
                if (ScrollLabelTabHost.this.ipc != null) {
                    return ScrollLabelTabHost.this.ipc.cp(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.ipc != null) {
                    return ScrollLabelTabHost.this.ipc.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e yq(int i) {
                if (ScrollLabelTabHost.this.ipc != null) {
                    return ScrollLabelTabHost.this.ipc.yq(i);
                }
                return null;
            }
        };
        this.ioO = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e yt(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.ioC, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ioE = 0;
        this.ioF = 0;
        this.ipa = false;
        this.ioN = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cn(int i, int i2) {
                if (ScrollLabelTabHost.this.ipc != null) {
                    ScrollLabelTabHost.this.ipc.cn(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void co(int i, int i2) {
                if (ScrollLabelTabHost.this.ipc != null) {
                    ScrollLabelTabHost.this.ipc.co(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cp(int i, int i2) {
                if (ScrollLabelTabHost.this.ipc != null) {
                    return ScrollLabelTabHost.this.ipc.cp(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.ipc != null) {
                    return ScrollLabelTabHost.this.ipc.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e yq(int i) {
                if (ScrollLabelTabHost.this.ipc != null) {
                    return ScrollLabelTabHost.this.ipc.yq(i);
                }
                return null;
            }
        };
        this.ioO = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e yt(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.ioC, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ioE = 0;
        this.ioF = 0;
        this.ipa = false;
        this.ioN = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cn(int i2, int i22) {
                if (ScrollLabelTabHost.this.ipc != null) {
                    ScrollLabelTabHost.this.ipc.cn(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void co(int i2, int i22) {
                if (ScrollLabelTabHost.this.ipc != null) {
                    ScrollLabelTabHost.this.ipc.co(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cp(int i2, int i22) {
                if (ScrollLabelTabHost.this.ipc != null) {
                    return ScrollLabelTabHost.this.ipc.cp(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.ipc != null) {
                    return ScrollLabelTabHost.this.ipc.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e yq(int i2) {
                if (ScrollLabelTabHost.this.ipc != null) {
                    return ScrollLabelTabHost.this.ipc.yq(i2);
                }
                return null;
            }
        };
        this.ioO = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e yt(int i2) {
                return (e) y.getItem(ScrollLabelTabHost.this.ioC, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.ioX = new FrsGameTabPagerAdapter(context, this.ioN, this.ioO);
        this.ioW = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.ioW.setAdapter(this.ioX);
        this.ioT = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.ioT.setViewPager(this.ioW);
        this.ioT.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.ioE = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.ioF = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.ioU.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.ioU.setVisibility(8);
                    }
                }
            }
        });
        this.ioV = new d(getContext());
        this.ioU = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.ioU.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.ioU.setNumColumns(5);
        this.ioU.setFoldAdapter(this.ioV);
        this.ioU.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.ioU.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void i(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.ioF = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cty = ScrollLabelTabHost.this.ioX.cty();
                    cty.ct(ScrollLabelTabHost.this.ioE, ScrollLabelTabHost.this.ioF);
                    if (ScrollLabelTabHost.this.ioN != null && !ScrollLabelTabHost.this.ioN.cp(ScrollLabelTabHost.this.ioE, ScrollLabelTabHost.this.ioF)) {
                        cty.pullToRefresh();
                    }
                }
            }
        });
        this.ioY = findViewById(R.id.frs_game_tab_line);
        this.ioZ = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.ioX != null) {
            this.ioX.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (this.ipa || this.ioC == null) {
                this.ipa = z;
                this.ioC = list;
                this.ioX.setCount(this.ioC == null ? 0 : this.ioC.size());
                this.ioT.setData(list);
                if (y.isEmpty(list)) {
                    this.ioT.setVisibility(8);
                    this.ioY.setVisibility(8);
                    return;
                }
                this.ioT.setVisibility(0);
                this.ioY.setVisibility(0);
                this.ioT.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.ioU.setVisibility(0);
                    this.ioZ.setVisibility(0);
                    return;
                }
                this.ioU.setVisibility(8);
                this.ioZ.setVisibility(8);
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
        this.ioV.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<q> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView cs = this.ioX.cs(i, i2);
        if (cs != null) {
            cs.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                yu(i3);
            }
        }
    }

    public void yu(int i) {
        if (this.ipb != null && this.ipb.isShowing()) {
            this.ipb.crA();
        }
        this.ipb = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView ctH = this.ipb.ctH();
        if (i == 0) {
            ctH.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            ctH.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(ctH, layoutParams);
        this.ipb.ctI();
    }

    public void l(int i, int i2, String str) {
        FrsGameStrategyItemListView cs = this.ioX.cs(i, i2);
        if (cs != null) {
            cs.k(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.ipc = aVar;
    }

    public void onChangeSkinType(int i) {
        this.ioT.onChangeSkinType(i);
        this.ioU.onChangeSkinType(i);
        this.ioX.onChangeSkinType(i);
        ap.setBackgroundColor(this.ioY, R.color.cp_bg_line_c);
        ap.setBackgroundColor(this.ioZ, R.color.cp_bg_line_c);
    }

    public void onDestory() {
        if (this.ipb != null) {
            this.ipb.crA();
        }
        this.ioX.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.ioX.cty();
    }

    public void bIh() {
        FrsGameStrategyItemListView cty = this.ioX.cty();
        if (cty != null) {
            cty.pullToRefresh();
        }
    }
}

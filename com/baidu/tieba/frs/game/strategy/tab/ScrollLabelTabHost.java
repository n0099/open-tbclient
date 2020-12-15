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
/* loaded from: classes22.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private g jkA;
    private a jkB;
    private List<e> jkb;
    private int jkd;
    private int jke;
    private a jkm;
    private c jkn;
    private ScrollHorizontalTabView jks;
    private FoldedGridView jkt;
    private d jku;
    private CustomViewPager jkv;
    private FrsGameTabPagerAdapter jkw;
    private View jkx;
    private View jky;
    private boolean jkz;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.jkd = 0;
        this.jke = 0;
        this.jkz = false;
        this.jkm = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cw(int i, int i2) {
                if (ScrollLabelTabHost.this.jkB != null) {
                    ScrollLabelTabHost.this.jkB.cw(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cx(int i, int i2) {
                if (ScrollLabelTabHost.this.jkB != null) {
                    ScrollLabelTabHost.this.jkB.cx(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cy(int i, int i2) {
                if (ScrollLabelTabHost.this.jkB != null) {
                    return ScrollLabelTabHost.this.jkB.cy(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jkB != null) {
                    return ScrollLabelTabHost.this.jkB.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e AO(int i) {
                if (ScrollLabelTabHost.this.jkB != null) {
                    return ScrollLabelTabHost.this.jkB.AO(i);
                }
                return null;
            }
        };
        this.jkn = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e AR(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.jkb, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jkd = 0;
        this.jke = 0;
        this.jkz = false;
        this.jkm = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cw(int i, int i2) {
                if (ScrollLabelTabHost.this.jkB != null) {
                    ScrollLabelTabHost.this.jkB.cw(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cx(int i, int i2) {
                if (ScrollLabelTabHost.this.jkB != null) {
                    ScrollLabelTabHost.this.jkB.cx(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cy(int i, int i2) {
                if (ScrollLabelTabHost.this.jkB != null) {
                    return ScrollLabelTabHost.this.jkB.cy(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jkB != null) {
                    return ScrollLabelTabHost.this.jkB.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e AO(int i) {
                if (ScrollLabelTabHost.this.jkB != null) {
                    return ScrollLabelTabHost.this.jkB.AO(i);
                }
                return null;
            }
        };
        this.jkn = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e AR(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.jkb, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jkd = 0;
        this.jke = 0;
        this.jkz = false;
        this.jkm = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cw(int i2, int i22) {
                if (ScrollLabelTabHost.this.jkB != null) {
                    ScrollLabelTabHost.this.jkB.cw(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cx(int i2, int i22) {
                if (ScrollLabelTabHost.this.jkB != null) {
                    ScrollLabelTabHost.this.jkB.cx(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cy(int i2, int i22) {
                if (ScrollLabelTabHost.this.jkB != null) {
                    return ScrollLabelTabHost.this.jkB.cy(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jkB != null) {
                    return ScrollLabelTabHost.this.jkB.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e AO(int i2) {
                if (ScrollLabelTabHost.this.jkB != null) {
                    return ScrollLabelTabHost.this.jkB.AO(i2);
                }
                return null;
            }
        };
        this.jkn = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e AR(int i2) {
                return (e) y.getItem(ScrollLabelTabHost.this.jkb, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.jkw = new FrsGameTabPagerAdapter(context, this.jkm, this.jkn);
        this.jkv = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.jkv.setAdapter(this.jkw);
        this.jks = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.jks.setViewPager(this.jkv);
        this.jks.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.jkd = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.jke = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.jkt.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.jkt.setVisibility(8);
                    }
                }
            }
        });
        this.jku = new d(getContext());
        this.jkt = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.jkt.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.jkt.setNumColumns(5);
        this.jkt.setFoldAdapter(this.jku);
        this.jkt.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.jkt.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void l(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.jke = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cHt = ScrollLabelTabHost.this.jkw.cHt();
                    cHt.cC(ScrollLabelTabHost.this.jkd, ScrollLabelTabHost.this.jke);
                    if (ScrollLabelTabHost.this.jkm != null && !ScrollLabelTabHost.this.jkm.cy(ScrollLabelTabHost.this.jkd, ScrollLabelTabHost.this.jke)) {
                        cHt.pullToRefresh();
                    }
                }
            }
        });
        this.jkx = findViewById(R.id.frs_game_tab_line);
        this.jky = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jkw != null) {
            this.jkw.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (this.jkz || this.jkb == null) {
                this.jkz = z;
                this.jkb = list;
                this.jkw.setCount(this.jkb == null ? 0 : this.jkb.size());
                this.jks.setData(list);
                if (y.isEmpty(list)) {
                    this.jks.setVisibility(8);
                    this.jkx.setVisibility(8);
                    return;
                }
                this.jks.setVisibility(0);
                this.jkx.setVisibility(0);
                this.jks.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.jkt.setVisibility(0);
                    this.jky.setVisibility(0);
                    return;
                }
                this.jkt.setVisibility(8);
                this.jky.setVisibility(8);
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
        this.jku.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<q> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView cB = this.jkw.cB(i, i2);
        if (cB != null) {
            cB.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                AS(i3);
            }
        }
    }

    public void AS(int i) {
        if (this.jkA != null && this.jkA.isShowing()) {
            this.jkA.cEA();
        }
        this.jkA = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cHC = this.jkA.cHC();
        if (i == 0) {
            cHC.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cHC.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cHC, layoutParams);
        this.jkA.cHD();
    }

    public void n(int i, int i2, String str) {
        FrsGameStrategyItemListView cB = this.jkw.cB(i, i2);
        if (cB != null) {
            cB.m(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.jkB = aVar;
    }

    public void onChangeSkinType(int i) {
        this.jks.onChangeSkinType(i);
        this.jkt.onChangeSkinType(i);
        this.jkw.onChangeSkinType(i);
        ap.setBackgroundColor(this.jkx, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jky, R.color.CAM_X0204);
    }

    public void onDestory() {
        if (this.jkA != null) {
            this.jkA.cEA();
        }
        this.jkw.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.jkw.cHt();
    }

    public void bTa() {
        FrsGameStrategyItemListView cHt = this.jkw.cHt();
        if (cHt != null) {
            cHt.pullToRefresh();
        }
    }
}

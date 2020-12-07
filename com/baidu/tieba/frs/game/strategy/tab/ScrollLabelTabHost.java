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
    private List<e> jjZ;
    private int jkb;
    private int jkc;
    private a jkk;
    private c jkl;
    private ScrollHorizontalTabView jkq;
    private FoldedGridView jkr;
    private d jks;
    private CustomViewPager jkt;
    private FrsGameTabPagerAdapter jku;
    private View jkv;
    private View jkw;
    private boolean jkx;
    private g jky;
    private a jkz;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.jkb = 0;
        this.jkc = 0;
        this.jkx = false;
        this.jkk = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cw(int i, int i2) {
                if (ScrollLabelTabHost.this.jkz != null) {
                    ScrollLabelTabHost.this.jkz.cw(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cx(int i, int i2) {
                if (ScrollLabelTabHost.this.jkz != null) {
                    ScrollLabelTabHost.this.jkz.cx(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cy(int i, int i2) {
                if (ScrollLabelTabHost.this.jkz != null) {
                    return ScrollLabelTabHost.this.jkz.cy(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jkz != null) {
                    return ScrollLabelTabHost.this.jkz.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e AO(int i) {
                if (ScrollLabelTabHost.this.jkz != null) {
                    return ScrollLabelTabHost.this.jkz.AO(i);
                }
                return null;
            }
        };
        this.jkl = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e AR(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.jjZ, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jkb = 0;
        this.jkc = 0;
        this.jkx = false;
        this.jkk = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cw(int i, int i2) {
                if (ScrollLabelTabHost.this.jkz != null) {
                    ScrollLabelTabHost.this.jkz.cw(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cx(int i, int i2) {
                if (ScrollLabelTabHost.this.jkz != null) {
                    ScrollLabelTabHost.this.jkz.cx(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cy(int i, int i2) {
                if (ScrollLabelTabHost.this.jkz != null) {
                    return ScrollLabelTabHost.this.jkz.cy(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jkz != null) {
                    return ScrollLabelTabHost.this.jkz.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e AO(int i) {
                if (ScrollLabelTabHost.this.jkz != null) {
                    return ScrollLabelTabHost.this.jkz.AO(i);
                }
                return null;
            }
        };
        this.jkl = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e AR(int i) {
                return (e) y.getItem(ScrollLabelTabHost.this.jjZ, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jkb = 0;
        this.jkc = 0;
        this.jkx = false;
        this.jkk = new a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cw(int i2, int i22) {
                if (ScrollLabelTabHost.this.jkz != null) {
                    ScrollLabelTabHost.this.jkz.cw(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public void cx(int i2, int i22) {
                if (ScrollLabelTabHost.this.jkz != null) {
                    ScrollLabelTabHost.this.jkz.cx(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public boolean cy(int i2, int i22) {
                if (ScrollLabelTabHost.this.jkz != null) {
                    return ScrollLabelTabHost.this.jkz.cy(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public String getForumId() {
                if (ScrollLabelTabHost.this.jkz != null) {
                    return ScrollLabelTabHost.this.jkz.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.a
            public e AO(int i2) {
                if (ScrollLabelTabHost.this.jkz != null) {
                    return ScrollLabelTabHost.this.jkz.AO(i2);
                }
                return null;
            }
        };
        this.jkl = new c() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.c
            public e AR(int i2) {
                return (e) y.getItem(ScrollLabelTabHost.this.jjZ, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_game_strategy_tab_host_layout, this);
        this.jku = new FrsGameTabPagerAdapter(context, this.jkk, this.jkl);
        this.jkt = (CustomViewPager) findViewById(R.id.frs_game_pager);
        this.jkt.setAdapter(this.jku);
        this.jkq = (ScrollHorizontalTabView) findViewById(R.id.frs_game_tab_widget);
        this.jkq.setViewPager(this.jkt);
        this.jkq.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, e eVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, e eVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (eVar != null) {
                    ScrollLabelTabHost.this.jkb = eVar.tabId;
                    if (eVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) eVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.jkc = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(eVar)) {
                        ScrollLabelTabHost.this.jkr.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.jkr.setVisibility(8);
                    }
                }
            }
        });
        this.jks = new d(getContext());
        this.jkr = (FoldedGridView) findViewById(R.id.frs_game_label_widget);
        this.jkr.setArrowResouceId(R.drawable.icon_arrow_gray_down, R.drawable.icon_arrow_gray_up);
        this.jkr.setNumColumns(5);
        this.jkr.setFoldAdapter(this.jks);
        this.jkr.setExpandedBottomShadeResourceId(R.drawable.shape_frs_game_lable_bottom_shade);
        this.jkr.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void l(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.jkc = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    FrsGameStrategyItemListView cHs = ScrollLabelTabHost.this.jku.cHs();
                    cHs.cC(ScrollLabelTabHost.this.jkb, ScrollLabelTabHost.this.jkc);
                    if (ScrollLabelTabHost.this.jkk != null && !ScrollLabelTabHost.this.jkk.cy(ScrollLabelTabHost.this.jkb, ScrollLabelTabHost.this.jkc)) {
                        cHs.pullToRefresh();
                    }
                }
            }
        });
        this.jkv = findViewById(R.id.frs_game_tab_line);
        this.jkw = findViewById(R.id.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.jku != null) {
            this.jku.setPageId(bdUniqueId);
        }
    }

    public void setTabData(List<e> list, boolean z) {
        if (!y.isEmpty(list)) {
            if (this.jkx || this.jjZ == null) {
                this.jkx = z;
                this.jjZ = list;
                this.jku.setCount(this.jjZ == null ? 0 : this.jjZ.size());
                this.jkq.setData(list);
                if (y.isEmpty(list)) {
                    this.jkq.setVisibility(8);
                    this.jkv.setVisibility(8);
                    return;
                }
                this.jkq.setVisibility(0);
                this.jkv.setVisibility(0);
                this.jkq.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.jkr.setVisibility(0);
                    this.jkw.setVisibility(0);
                    return;
                }
                this.jkr.setVisibility(8);
                this.jkw.setVisibility(8);
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
        this.jks.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<q> list, List<e> list2, boolean z, boolean z2, int i3) {
        FrsGameStrategyItemListView cB = this.jku.cB(i, i2);
        if (cB != null) {
            cB.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                AS(i3);
            }
        }
    }

    public void AS(int i) {
        if (this.jky != null && this.jky.isShowing()) {
            this.jky.cEz();
        }
        this.jky = new g(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds60));
        layoutParams.addRule(10);
        TextView cHB = this.jky.cHB();
        if (i == 0) {
            cHB.setText(getResources().getString(R.string.recommend_frs_refresh_nodata));
        } else {
            cHB.setText(String.format(getResources().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(cHB, layoutParams);
        this.jky.cHC();
    }

    public void n(int i, int i2, String str) {
        FrsGameStrategyItemListView cB = this.jku.cB(i, i2);
        if (cB != null) {
            cB.m(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(a aVar) {
        this.jkz = aVar;
    }

    public void onChangeSkinType(int i) {
        this.jkq.onChangeSkinType(i);
        this.jkr.onChangeSkinType(i);
        this.jku.onChangeSkinType(i);
        ap.setBackgroundColor(this.jkv, R.color.CAM_X0204);
        ap.setBackgroundColor(this.jkw, R.color.CAM_X0204);
    }

    public void onDestory() {
        if (this.jky != null) {
            this.jky.cEz();
        }
        this.jku.onDestory();
    }

    public FrsGameStrategyItemListView getCurrentPageView() {
        return this.jku.cHs();
    }

    public void bSZ() {
        FrsGameStrategyItemListView cHs = this.jku.cHs();
        if (cHs != null) {
            cHs.pullToRefresh();
        }
    }
}

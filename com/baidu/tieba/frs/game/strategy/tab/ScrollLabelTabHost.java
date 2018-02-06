package com.baidu.tieba.frs.game.strategy.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.game.strategy.data.LabelDataList;
import com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView;
import com.baidu.tieba.frs.game.strategy.view.FoldedGridView;
import com.baidu.tieba.frs.game.strategy.view.h;
import java.util.List;
/* loaded from: classes3.dex */
public class ScrollLabelTabHost extends RelativeLayout {
    private int bZU;
    private h dOA;
    private b dOB;
    private List<f> dOc;
    private int dOe;
    private b dOn;
    private d dOo;
    private ScrollHorizontalTabView dOt;
    private FoldedGridView dOu;
    private e dOv;
    private a dOw;
    private View dOx;
    private View dOy;
    private boolean dOz;
    private CustomViewPager mPager;

    public ScrollLabelTabHost(Context context) {
        super(context);
        this.bZU = 0;
        this.dOe = 0;
        this.dOz = false;
        this.dOn = new b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void bx(int i, int i2) {
                if (ScrollLabelTabHost.this.dOB != null) {
                    ScrollLabelTabHost.this.dOB.bx(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void by(int i, int i2) {
                if (ScrollLabelTabHost.this.dOB != null) {
                    ScrollLabelTabHost.this.dOB.by(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public boolean bz(int i, int i2) {
                if (ScrollLabelTabHost.this.dOB != null) {
                    return ScrollLabelTabHost.this.dOB.bz(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public String getForumId() {
                if (ScrollLabelTabHost.this.dOB != null) {
                    return ScrollLabelTabHost.this.dOB.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public f no(int i) {
                if (ScrollLabelTabHost.this.dOB != null) {
                    return ScrollLabelTabHost.this.dOB.no(i);
                }
                return null;
            }
        };
        this.dOo = new d() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.d
            public f nr(int i) {
                return (f) v.f(ScrollLabelTabHost.this.dOc, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZU = 0;
        this.dOe = 0;
        this.dOz = false;
        this.dOn = new b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void bx(int i, int i2) {
                if (ScrollLabelTabHost.this.dOB != null) {
                    ScrollLabelTabHost.this.dOB.bx(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void by(int i, int i2) {
                if (ScrollLabelTabHost.this.dOB != null) {
                    ScrollLabelTabHost.this.dOB.by(i, i2);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public boolean bz(int i, int i2) {
                if (ScrollLabelTabHost.this.dOB != null) {
                    return ScrollLabelTabHost.this.dOB.bz(i, i2);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public String getForumId() {
                if (ScrollLabelTabHost.this.dOB != null) {
                    return ScrollLabelTabHost.this.dOB.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public f no(int i) {
                if (ScrollLabelTabHost.this.dOB != null) {
                    return ScrollLabelTabHost.this.dOB.no(i);
                }
                return null;
            }
        };
        this.dOo = new d() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.d
            public f nr(int i) {
                return (f) v.f(ScrollLabelTabHost.this.dOc, i);
            }
        };
        init(context);
    }

    public ScrollLabelTabHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bZU = 0;
        this.dOe = 0;
        this.dOz = false;
        this.dOn = new b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.1
            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void bx(int i2, int i22) {
                if (ScrollLabelTabHost.this.dOB != null) {
                    ScrollLabelTabHost.this.dOB.bx(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public void by(int i2, int i22) {
                if (ScrollLabelTabHost.this.dOB != null) {
                    ScrollLabelTabHost.this.dOB.by(i2, i22);
                }
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public boolean bz(int i2, int i22) {
                if (ScrollLabelTabHost.this.dOB != null) {
                    return ScrollLabelTabHost.this.dOB.bz(i2, i22);
                }
                return false;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public String getForumId() {
                if (ScrollLabelTabHost.this.dOB != null) {
                    return ScrollLabelTabHost.this.dOB.getForumId();
                }
                return null;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.b
            public f no(int i2) {
                if (ScrollLabelTabHost.this.dOB != null) {
                    return ScrollLabelTabHost.this.dOB.no(i2);
                }
                return null;
            }
        };
        this.dOo = new d() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.2
            @Override // com.baidu.tieba.frs.game.strategy.tab.d
            public f nr(int i2) {
                return (f) v.f(ScrollLabelTabHost.this.dOc, i2);
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_game_strategy_tab_host_layout, this);
        this.dOw = new a(context, this.dOn, this.dOo);
        this.mPager = (CustomViewPager) findViewById(d.g.frs_game_pager);
        this.mPager.setAdapter(this.dOw);
        this.dOt = (ScrollHorizontalTabView) findViewById(d.g.frs_game_tab_widget);
        this.dOt.setViewPager(this.mPager);
        this.dOt.setScrollTabPageListener(new ScrollHorizontalTabView.b() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.3
            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public boolean a(int i, f fVar) {
                return true;
            }

            @Override // com.baidu.tieba.frs.game.strategy.tab.ScrollHorizontalTabView.b
            public void b(int i, f fVar) {
                com.baidu.tieba.frs.game.strategy.data.a aVar;
                if (fVar != null) {
                    ScrollLabelTabHost.this.bZU = fVar.tabId;
                    if (fVar.extra instanceof LabelDataList) {
                        LabelDataList labelDataList = (LabelDataList) fVar.extra;
                        if (!labelDataList.isEmpty() && (aVar = labelDataList.get(0)) != null) {
                            ScrollLabelTabHost.this.dOe = aVar.labelId;
                        }
                    }
                    if (ScrollLabelTabHost.this.a(fVar)) {
                        ScrollLabelTabHost.this.dOu.setVisibility(0);
                    } else {
                        ScrollLabelTabHost.this.dOu.setVisibility(8);
                    }
                }
            }
        });
        this.dOv = new e(getContext());
        this.dOu = (FoldedGridView) findViewById(d.g.frs_game_label_widget);
        this.dOu.bD(d.f.icon_arrow_gray_down, d.f.icon_arrow_gray_up);
        this.dOu.setNumColumns(5);
        this.dOu.setFoldAdapter(this.dOv);
        this.dOu.setExpandedBottomShadeResourceId(d.f.shape_frs_game_lable_bottom_shade);
        this.dOu.setFoldGridViewOnItemClickListener(new FoldedGridView.a() { // from class: com.baidu.tieba.frs.game.strategy.tab.ScrollLabelTabHost.4
            @Override // com.baidu.tieba.frs.game.strategy.view.FoldedGridView.a
            public void e(int i, Object obj) {
                if (obj instanceof com.baidu.tieba.frs.game.strategy.data.a) {
                    ScrollLabelTabHost.this.dOe = ((com.baidu.tieba.frs.game.strategy.data.a) obj).labelId;
                    com.baidu.tieba.frs.game.strategy.view.d axT = ScrollLabelTabHost.this.dOw.axT();
                    axT.bE(ScrollLabelTabHost.this.bZU, ScrollLabelTabHost.this.dOe);
                    if (ScrollLabelTabHost.this.dOn != null && !ScrollLabelTabHost.this.dOn.bz(ScrollLabelTabHost.this.bZU, ScrollLabelTabHost.this.dOe)) {
                        axT.sU();
                    }
                }
            }
        });
        this.dOx = findViewById(d.g.frs_game_tab_line);
        this.dOy = findViewById(d.g.frs_game_label_line);
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.dOw != null) {
            this.dOw.setPageId(bdUniqueId);
        }
    }

    public void h(List<f> list, boolean z) {
        if (!v.E(list)) {
            if (this.dOz || this.dOc == null) {
                this.dOz = z;
                this.dOc = list;
                this.dOw.setCount(this.dOc == null ? 0 : this.dOc.size());
                this.dOt.setData(list);
                if (v.E(list)) {
                    this.dOt.setVisibility(8);
                    this.dOx.setVisibility(8);
                    return;
                }
                this.dOt.setVisibility(0);
                this.dOx.setVisibility(0);
                this.dOt.setCurrentIndex(0, false);
                if (a(list.get(0))) {
                    this.dOu.setVisibility(0);
                    this.dOy.setVisibility(0);
                    return;
                }
                this.dOu.setVisibility(8);
                this.dOy.setVisibility(8);
            }
        }
    }

    public boolean a(f fVar) {
        if (fVar == null || !(fVar.extra instanceof LabelDataList)) {
            return false;
        }
        LabelDataList labelDataList = (LabelDataList) fVar.extra;
        if (labelDataList.isEmpty()) {
            return false;
        }
        this.dOv.a(labelDataList);
        return true;
    }

    public void b(int i, int i2, List<i> list, List<f> list2, boolean z, boolean z2, int i3) {
        com.baidu.tieba.frs.game.strategy.view.d bC = this.dOw.bC(i, i2);
        if (bC != null) {
            bC.a(i, i2, list, list2, z, z2, i3);
            if (i3 != -1) {
                ns(i3);
            }
        }
    }

    public void ns(int i) {
        if (this.dOA != null && this.dOA.isShowing()) {
            this.dOA.awv();
        }
        this.dOA = new h(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds60));
        layoutParams.addRule(10);
        TextView ayc = this.dOA.ayc();
        if (i == 0) {
            ayc.setText(getResources().getString(d.j.recommend_frs_refresh_nodata));
        } else {
            ayc.setText(String.format(getResources().getString(d.j.recommend_frs_refresh_return), Integer.valueOf(i)));
        }
        addView(ayc, layoutParams);
        this.dOA.ayd();
    }

    public void f(int i, int i2, String str) {
        com.baidu.tieba.frs.game.strategy.view.d bC = this.dOw.bC(i, i2);
        if (bC != null) {
            bC.e(i, i2, str);
        }
    }

    public void setDelegateFrsGameTabDataLoadListener(b bVar) {
        this.dOB = bVar;
    }

    public void onChangeSkinType(int i) {
        this.dOt.onChangeSkinType(i);
        this.dOu.onChangeSkinType(i);
        this.dOw.onChangeSkinType(i);
        aj.t(this.dOx, d.C0140d.cp_bg_line_b);
        aj.t(this.dOy, d.C0140d.cp_bg_line_b);
    }

    public void onDestory() {
        if (this.dOA != null) {
            this.dOA.awv();
        }
        this.dOw.onDestory();
    }

    public com.baidu.tieba.frs.game.strategy.view.d getCurrentPageView() {
        return this.dOw.axT();
    }

    public void XL() {
        com.baidu.tieba.frs.game.strategy.view.d axT = this.dOw.axT();
        if (axT != null) {
            axT.sU();
        }
    }
}

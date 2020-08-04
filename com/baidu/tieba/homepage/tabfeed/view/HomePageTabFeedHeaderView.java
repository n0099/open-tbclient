package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.l;
import com.baidu.card.view.AutoBannerLayout;
import com.baidu.card.view.GridIconLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.b;
import com.baidu.tieba.homepage.tabfeed.data.c;
/* loaded from: classes16.dex */
public class HomePageTabFeedHeaderView extends LinearLayout implements View.OnClickListener {
    private d<j> aha;
    private AutoBannerLayout iDH;
    private GridIconLayout iDI;
    private f iDJ;
    private TbPageContext<?> mPageContext;

    public HomePageTabFeedHeaderView(Context context) {
        super(context);
        this.iDJ = new f<j>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, j jVar, int i, long j) {
                b.b("c13751", jVar, i + 1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, j jVar, int i, long j) {
            }
        };
        this.aha = new d<j>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i, String str) {
                j jVar = new j();
                jVar.wL(str);
                b.b("c13750", jVar, i);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, j jVar) {
                b.c("c13750", jVar, i);
            }
        };
        init();
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iDJ = new f<j>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, j jVar, int i, long j) {
                b.b("c13751", jVar, i + 1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, j jVar, int i, long j) {
            }
        };
        this.aha = new d<j>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i, String str) {
                j jVar = new j();
                jVar.wL(str);
                b.b("c13750", jVar, i);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, j jVar) {
                b.c("c13750", jVar, i);
            }
        };
        init();
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iDJ = new f<j>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, j jVar, int i2, long j) {
                b.b("c13751", jVar, i2 + 1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, j jVar, int i2, long j) {
            }
        };
        this.aha = new d<j>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i2, String str) {
                j jVar = new j();
                jVar.wL(str);
                b.b("c13750", jVar, i2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i2, j jVar) {
                b.c("c13750", jVar, i2);
            }
        };
        init();
    }

    public void init() {
        setOrientation(1);
        setDescendantFocusability(262144);
        this.mPageContext = (TbPageContext) i.G(getContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void onChangeSkinType(int i) {
        if (this.iDH != null) {
            this.iDH.onChangeSkinType(this.mPageContext, i);
        }
        if (this.iDI != null) {
            this.iDI.onChangeSkinType(this.mPageContext, i);
        }
        ao.setBackgroundColor(this, R.color.cp_bg_line_e);
    }

    public void setData(c cVar) {
        if (cVar != null) {
            setPadding(0, l.getDimens(getContext(), R.dimen.tbds44), 0, l.getDimens(getContext(), R.dimen.tbds60));
            if (this.iDH == null) {
                this.iDH = new AutoBannerLayout(getContext());
                this.iDH.setMarqueenTime(3000L);
                this.iDH.setOnCoverViewCallback(this.aha);
                this.iDH.setBannerHeight(l.getDimens(getContext(), R.dimen.tbds328));
                int dimens = l.getDimens(getContext(), R.dimen.tbds44);
                this.iDH.setPadding(dimens, 0, dimens, 0);
                addView(this.iDH);
                this.iDH.setIWindowChangedListener(new com.baidu.tbadk.h.c() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.1
                    @Override // com.baidu.tbadk.h.c
                    public void a(View view, boolean z, Object obj) {
                        if (z && HomePageTabFeedHeaderView.this.iDH != null) {
                            HomePageTabFeedHeaderView.this.iDH.sn();
                        }
                    }
                });
            }
            this.iDH.D(cVar.iDB);
            if (this.iDI == null) {
                this.iDI = new GridIconLayout(getContext());
                this.iDI.setOnItemCoverListener(this.iDJ);
                addView(this.iDI);
                this.iDI.setIWindowChangedListener(new com.baidu.tbadk.h.c() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.2
                    @Override // com.baidu.tbadk.h.c
                    public void a(View view, boolean z, Object obj) {
                        if (z) {
                            b.GT("c13751");
                        }
                    }
                });
                this.iDI.setPadding(0, l.getDimens(getContext(), R.dimen.tbds61), 0, 0);
                this.iDI.setVerticalSpace(l.getDimens(getContext(), R.dimen.tbds61));
                this.iDI.setMaxItem(10);
            }
            this.iDI.D(cVar.iDC);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}

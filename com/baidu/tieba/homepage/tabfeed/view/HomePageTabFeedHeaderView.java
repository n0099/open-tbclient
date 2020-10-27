package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.card.view.AutoBannerLayout;
import com.baidu.card.view.GridIconLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.j;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.b;
import com.baidu.tieba.homepage.tabfeed.data.c;
/* loaded from: classes22.dex */
public class HomePageTabFeedHeaderView extends LinearLayout implements View.OnClickListener {
    private d<j> aiZ;
    private AutoBannerLayout jCQ;
    private GridIconLayout jCR;
    private f jCS;
    private TbPageContext<?> mPageContext;

    public HomePageTabFeedHeaderView(Context context) {
        super(context);
        this.jCS = new f<j>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, j jVar, int i, long j) {
                b.c("c13751", jVar, i + 1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, j jVar, int i, long j) {
            }
        };
        this.aiZ = new d<j>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
                j jVar = new j();
                jVar.AA(str);
                b.c("c13750", jVar, i);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, j jVar) {
                b.b("c13750", jVar, i);
            }
        };
        init();
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCS = new f<j>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, j jVar, int i, long j) {
                b.c("c13751", jVar, i + 1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, j jVar, int i, long j) {
            }
        };
        this.aiZ = new d<j>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
                j jVar = new j();
                jVar.AA(str);
                b.c("c13750", jVar, i);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, j jVar) {
                b.b("c13750", jVar, i);
            }
        };
        init();
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCS = new f<j>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, j jVar, int i2, long j) {
                b.c("c13751", jVar, i2 + 1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, j jVar, int i2, long j) {
            }
        };
        this.aiZ = new d<j>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i2, String str) {
                j jVar = new j();
                jVar.AA(str);
                b.c("c13750", jVar, i2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i2, j jVar) {
                b.b("c13750", jVar, i2);
            }
        };
        init();
    }

    public void init() {
        setOrientation(1);
        setDescendantFocusability(262144);
        this.mPageContext = (TbPageContext) i.I(getContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void onChangeSkinType(int i) {
        if (this.jCQ != null) {
            this.jCQ.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jCR != null) {
            this.jCR.onChangeSkinType(this.mPageContext, i);
        }
        ap.setBackgroundColor(this, R.color.cp_bg_line_e);
    }

    public void setData(c cVar) {
        if (cVar != null) {
            setPadding(0, l.getDimens(getContext(), R.dimen.tbds44), 0, l.getDimens(getContext(), R.dimen.tbds60));
            if (this.jCQ == null) {
                this.jCQ = new AutoBannerLayout(getContext());
                this.jCQ.setMarqueenTime(IMConnection.RETRY_DELAY_TIMES);
                this.jCQ.setOnCoverViewCallback(this.aiZ);
                this.jCQ.setBannerHeight(l.getDimens(getContext(), R.dimen.tbds328));
                int dimens = l.getDimens(getContext(), R.dimen.tbds44);
                this.jCQ.setPadding(dimens, 0, dimens, 0);
                addView(this.jCQ);
                this.jCQ.setIWindowChangedListener(new com.baidu.tbadk.h.c() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.1
                    @Override // com.baidu.tbadk.h.c
                    public void a(View view, boolean z, Object obj) {
                        if (z && HomePageTabFeedHeaderView.this.jCQ != null) {
                            HomePageTabFeedHeaderView.this.jCQ.ue();
                        }
                    }
                });
            }
            this.jCQ.H(cVar.jCK);
            if (this.jCR == null) {
                this.jCR = new GridIconLayout(getContext());
                this.jCR.setOnItemCoverListener(this.jCS);
                addView(this.jCR);
                this.jCR.setIWindowChangedListener(new com.baidu.tbadk.h.c() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.2
                    @Override // com.baidu.tbadk.h.c
                    public void a(View view, boolean z, Object obj) {
                        if (z) {
                            b.LB("c13751");
                        }
                    }
                });
                this.jCR.setPadding(0, l.getDimens(getContext(), R.dimen.tbds61), 0, 0);
                this.jCR.setVerticalSpace(l.getDimens(getContext(), R.dimen.tbds61));
                this.jCR.setMaxItem(10);
            }
            this.jCR.H(cVar.jCL);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}

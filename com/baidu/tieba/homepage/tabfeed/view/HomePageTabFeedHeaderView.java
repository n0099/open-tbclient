package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.adp.base.j;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.card.view.AutoBannerLayout;
import com.baidu.card.view.GridIconLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.l;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.b;
import com.baidu.tieba.homepage.tabfeed.data.c;
/* loaded from: classes2.dex */
public class HomePageTabFeedHeaderView extends LinearLayout implements View.OnClickListener {
    private d<l> ajD;
    private AutoBannerLayout knR;
    private GridIconLayout knS;
    private f knT;
    private TbPageContext<?> mPageContext;

    public HomePageTabFeedHeaderView(Context context) {
        super(context);
        this.knT = new f<l>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, l lVar, int i, long j) {
                b.c("c13751", lVar, i + 1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, l lVar, int i, long j) {
            }
        };
        this.ajD = new d<l>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i, String str) {
                l lVar = new l();
                lVar.zT(str);
                b.c("c13750", lVar, i);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, l lVar) {
                b.b("c13750", lVar, i);
            }
        };
        init();
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.knT = new f<l>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, l lVar, int i, long j) {
                b.c("c13751", lVar, i + 1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, l lVar, int i, long j) {
            }
        };
        this.ajD = new d<l>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i, String str) {
                l lVar = new l();
                lVar.zT(str);
                b.c("c13750", lVar, i);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, l lVar) {
                b.b("c13750", lVar, i);
            }
        };
        init();
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.knT = new f<l>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, l lVar, int i2, long j) {
                b.c("c13751", lVar, i2 + 1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, l lVar, int i2, long j) {
            }
        };
        this.ajD = new d<l>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i2, String str) {
                l lVar = new l();
                lVar.zT(str);
                b.c("c13750", lVar, i2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i2, l lVar) {
                b.b("c13750", lVar, i2);
            }
        };
        init();
    }

    public void init() {
        setOrientation(1);
        setDescendantFocusability(262144);
        this.mPageContext = (TbPageContext) j.K(getContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void onChangeSkinType(int i) {
        if (this.knR != null) {
            this.knR.onChangeSkinType(this.mPageContext, i);
        }
        if (this.knS != null) {
            this.knS.onChangeSkinType(this.mPageContext, i);
        }
        ap.setBackgroundColor(this, R.color.CAM_X0205);
    }

    public void setData(c cVar) {
        if (cVar != null) {
            setPadding(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            if (this.knR == null) {
                this.knR = new AutoBannerLayout(getContext());
                this.knR.setMarqueenTime(IMConnection.RETRY_DELAY_TIMES);
                this.knR.setOnCoverViewCallback(this.ajD);
                this.knR.setBannerHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds328));
                int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44);
                this.knR.setPadding(dimens, 0, dimens, 0);
                addView(this.knR);
                this.knR.setIWindowChangedListener(new com.baidu.tbadk.h.c() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.1
                    @Override // com.baidu.tbadk.h.c
                    public void a(View view, boolean z, Object obj) {
                        if (z && HomePageTabFeedHeaderView.this.knR != null) {
                            HomePageTabFeedHeaderView.this.knR.ts();
                        }
                    }
                });
            }
            this.knR.C(cVar.knL);
            if (this.knS == null) {
                this.knS = new GridIconLayout(getContext());
                this.knS.setOnItemCoverListener(this.knT);
                addView(this.knS);
                this.knS.setIWindowChangedListener(new com.baidu.tbadk.h.c() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.2
                    @Override // com.baidu.tbadk.h.c
                    public void a(View view, boolean z, Object obj) {
                        if (z) {
                            b.Mg("c13751");
                        }
                    }
                });
                this.knS.setPadding(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds61), 0, 0);
                this.knS.setVerticalSpace(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds61));
                this.knS.setMaxItem(10);
            }
            this.knS.C(cVar.knM);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}

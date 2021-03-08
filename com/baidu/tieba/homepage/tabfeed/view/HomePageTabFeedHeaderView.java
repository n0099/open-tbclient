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
    private d<l> akV;
    private AutoBannerLayout kqh;
    private GridIconLayout kqi;
    private f kqj;
    private TbPageContext<?> mPageContext;

    public HomePageTabFeedHeaderView(Context context) {
        super(context);
        this.kqj = new f<l>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
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
        this.akV = new d<l>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i, String str) {
                l lVar = new l();
                lVar.Aa(str);
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
        this.kqj = new f<l>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
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
        this.akV = new d<l>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i, String str) {
                l lVar = new l();
                lVar.Aa(str);
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
        this.kqj = new f<l>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
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
        this.akV = new d<l>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void f(int i2, String str) {
                l lVar = new l();
                lVar.Aa(str);
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
        this.mPageContext = (TbPageContext) j.J(getContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void onChangeSkinType(int i) {
        if (this.kqh != null) {
            this.kqh.onChangeSkinType(this.mPageContext, i);
        }
        if (this.kqi != null) {
            this.kqi.onChangeSkinType(this.mPageContext, i);
        }
        ap.setBackgroundColor(this, R.color.CAM_X0205);
    }

    public void setData(c cVar) {
        if (cVar != null) {
            setPadding(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44), 0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds60));
            if (this.kqh == null) {
                this.kqh = new AutoBannerLayout(getContext());
                this.kqh.setMarqueenTime(IMConnection.RETRY_DELAY_TIMES);
                this.kqh.setOnCoverViewCallback(this.akV);
                this.kqh.setBannerHeight(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds328));
                int dimens = com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds44);
                this.kqh.setPadding(dimens, 0, dimens, 0);
                addView(this.kqh);
                this.kqh.setIWindowChangedListener(new com.baidu.tbadk.h.c() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.1
                    @Override // com.baidu.tbadk.h.c
                    public void a(View view, boolean z, Object obj) {
                        if (z && HomePageTabFeedHeaderView.this.kqh != null) {
                            HomePageTabFeedHeaderView.this.kqh.ts();
                        }
                    }
                });
            }
            this.kqh.E(cVar.kqb);
            if (this.kqi == null) {
                this.kqi = new GridIconLayout(getContext());
                this.kqi.setOnItemCoverListener(this.kqj);
                addView(this.kqi);
                this.kqi.setIWindowChangedListener(new com.baidu.tbadk.h.c() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.2
                    @Override // com.baidu.tbadk.h.c
                    public void a(View view, boolean z, Object obj) {
                        if (z) {
                            b.Mn("c13751");
                        }
                    }
                });
                this.kqi.setPadding(0, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds61), 0, 0);
                this.kqi.setVerticalSpace(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds61));
                this.kqi.setMaxItem(10);
            }
            this.kqi.E(cVar.kqc);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}

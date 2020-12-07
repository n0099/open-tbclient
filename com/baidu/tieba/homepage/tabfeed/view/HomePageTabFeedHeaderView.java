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
import com.baidu.tbadk.core.data.k;
import com.baidu.tbadk.core.flow.a.d;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.h.f;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.tabfeed.b;
import com.baidu.tieba.homepage.tabfeed.data.c;
/* loaded from: classes22.dex */
public class HomePageTabFeedHeaderView extends LinearLayout implements View.OnClickListener {
    private d<k> akd;
    private AutoBannerLayout jXb;
    private GridIconLayout jXc;
    private f jXd;
    private TbPageContext<?> mPageContext;

    public HomePageTabFeedHeaderView(Context context) {
        super(context);
        this.jXd = new f<k>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, k kVar, int i, long j) {
                b.c("c13751", kVar, i + 1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, k kVar, int i, long j) {
            }
        };
        this.akd = new d<k>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
                k kVar = new k();
                kVar.AQ(str);
                b.c("c13750", kVar, i);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, k kVar) {
                b.b("c13750", kVar, i);
            }
        };
        init();
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jXd = new f<k>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, k kVar, int i, long j) {
                b.c("c13751", kVar, i + 1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, k kVar, int i, long j) {
            }
        };
        this.akd = new d<k>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i, String str) {
                k kVar = new k();
                kVar.AQ(str);
                b.c("c13750", kVar, i);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i, k kVar) {
                b.b("c13750", kVar, i);
            }
        };
        init();
    }

    public HomePageTabFeedHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jXd = new f<k>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, k kVar, int i2, long j) {
                b.c("c13751", kVar, i2 + 1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, k kVar, int i2, long j) {
            }
        };
        this.akd = new d<k>() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.4
            @Override // com.baidu.tbadk.core.flow.a.d
            public void e(int i2, String str) {
                k kVar = new k();
                kVar.AQ(str);
                b.c("c13750", kVar, i2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.core.flow.a.d
            public void a(int i2, k kVar) {
                b.b("c13750", kVar, i2);
            }
        };
        init();
    }

    public void init() {
        setOrientation(1);
        setDescendantFocusability(262144);
        this.mPageContext = (TbPageContext) i.J(getContext());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void onChangeSkinType(int i) {
        if (this.jXb != null) {
            this.jXb.onChangeSkinType(this.mPageContext, i);
        }
        if (this.jXc != null) {
            this.jXc.onChangeSkinType(this.mPageContext, i);
        }
        ap.setBackgroundColor(this, R.color.CAM_X0205);
    }

    public void setData(c cVar) {
        if (cVar != null) {
            setPadding(0, l.getDimens(getContext(), R.dimen.tbds44), 0, l.getDimens(getContext(), R.dimen.tbds60));
            if (this.jXb == null) {
                this.jXb = new AutoBannerLayout(getContext());
                this.jXb.setMarqueenTime(IMConnection.RETRY_DELAY_TIMES);
                this.jXb.setOnCoverViewCallback(this.akd);
                this.jXb.setBannerHeight(l.getDimens(getContext(), R.dimen.tbds328));
                int dimens = l.getDimens(getContext(), R.dimen.tbds44);
                this.jXb.setPadding(dimens, 0, dimens, 0);
                addView(this.jXb);
                this.jXb.setIWindowChangedListener(new com.baidu.tbadk.h.c() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.1
                    @Override // com.baidu.tbadk.h.c
                    public void a(View view, boolean z, Object obj) {
                        if (z && HomePageTabFeedHeaderView.this.jXb != null) {
                            HomePageTabFeedHeaderView.this.jXb.uh();
                        }
                    }
                });
            }
            this.jXb.H(cVar.jWV);
            if (this.jXc == null) {
                this.jXc = new GridIconLayout(getContext());
                this.jXc.setOnItemCoverListener(this.jXd);
                addView(this.jXc);
                this.jXc.setIWindowChangedListener(new com.baidu.tbadk.h.c() { // from class: com.baidu.tieba.homepage.tabfeed.view.HomePageTabFeedHeaderView.2
                    @Override // com.baidu.tbadk.h.c
                    public void a(View view, boolean z, Object obj) {
                        if (z) {
                            b.MA("c13751");
                        }
                    }
                });
                this.jXc.setPadding(0, l.getDimens(getContext(), R.dimen.tbds61), 0, 0);
                this.jXc.setVerticalSpace(l.getDimens(getContext(), R.dimen.tbds61));
                this.jXc.setMaxItem(10);
            }
            this.jXc.H(cVar.jWW);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }
}

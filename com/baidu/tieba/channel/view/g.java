package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class g implements e<com.baidu.tieba.channel.data.d> {
    private ImageView eTM;
    private h eUl;
    public TextView eUm;
    private boolean eUn = false;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.eUm = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.eTM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eTM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bVar != null) {
                    bVar.a(4, view, null, -1);
                }
            }
        });
    }

    @Override // com.baidu.tieba.channel.view.e
    public void a(boolean z, com.baidu.tieba.channel.view.b bVar) {
        if (this.eUl == null) {
            this.isHost = z;
            this.eUl = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.eUl != null) {
                this.eUl.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void al(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.bbl() != null) {
            this.eUm.setText(dVar.bbl().getChannelName());
            if (this.eUl != null) {
                this.eUl.al(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.eUl != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
    }

    public void H(int i, int i2, int i3) {
        I(i, i2, i3);
        bbD();
        bbB();
        bbC();
        if (this.eUl != null) {
            this.eUl.b(bbE(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void bbB() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (bbE()) {
            this.eUm.setVisibility(0);
            am.setNavbarTitleColor(this.eUm, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.eUm.setAlpha(alpha);
            return;
        }
        this.eUm.setVisibility(8);
    }

    public void pc(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eUm.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void bbC() {
        if (bbE()) {
            SvgManager.amN().a(this.eTM, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SvgManager.amN().a(this.eTM, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        bH(this.eTM);
    }

    private void I(int i, int i2, int i3) {
        if (i < i2 || i3 > 0) {
            if (this.mNavigationBar.getBarBgView().getAlpha() != 1.0f) {
                this.mNavigationBar.getBarBgView().setAlpha(1.0f);
                this.mNavigationBar.getTopCoverBgView().setAlpha(0.0f);
            }
        } else if (i >= i2 && i <= i2 * 2) {
            float f = 1.0f - (((i - i2) * 1.0f) / i2);
            this.mNavigationBar.getBarBgView().setAlpha(f);
            this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f - f);
        } else if (i > i2 * 2 && this.mNavigationBar.getBarBgView().getAlpha() != 0.0f) {
            this.mNavigationBar.getBarBgView().setAlpha(0.0f);
            this.mNavigationBar.getTopCoverBgView().setAlpha(1.0f);
        }
    }

    private void bbD() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.eUn = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.eUn = false;
        } else {
            this.eUn = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bbE() {
        return this.eUn;
    }

    public void bH(View view) {
        float f;
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            f = 1.0f - (alpha * 2.0f);
        } else {
            f = (alpha * 2.0f) - 1.0f;
        }
        if (f >= 0.0f && f <= 1.0f) {
            view.setAlpha(f);
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements h<com.baidu.tieba.channel.data.d> {
        private g eUp;
        private TextView eUq;
        private boolean eUr = false;
        private ImageView ejF;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.eUp = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.eUq = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(R.id.channel_nav_right_sub_btn);
            this.ejF = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
            this.eUq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.eUr ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.ejF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(12, view, null, -1);
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void al(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.bbl() != null) {
                this.eUr = dVar.bbl().isSubscribe();
                b(this.eUp.bbE(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
            c(z, f);
            this.eUq.setVisibility(8);
            this.eUp.pc(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds60));
        }

        private void c(boolean z, float f) {
            if (this.ejF != null) {
                if (z) {
                    SvgManager.amN().a(this.ejF, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.amN().a(this.ejF, R.drawable.icon_pure_topbar_more_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                this.ejF.setVisibility(0);
                this.eUp.bH(this.ejF);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements h<com.baidu.tieba.channel.data.d> {
        private Context mContext;
        private NavigationBar mNavigationBar;

        public b(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, com.baidu.tieba.channel.view.b bVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void al(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
        }
    }
}

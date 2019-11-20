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
    private ImageView eSV;
    private h eTu;
    public TextView eTv;
    private boolean eTw = false;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.eTv = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.eSV = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eSV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.eTu == null) {
            this.isHost = z;
            this.eTu = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.eTu != null) {
                this.eTu.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void al(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.bbj() != null) {
            this.eTv.setText(dVar.bbj().getChannelName());
            if (this.eTu != null) {
                this.eTu.al(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.eTu != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            am.setBackgroundColor(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_h);
        }
    }

    public void H(int i, int i2, int i3) {
        I(i, i2, i3);
        bbB();
        bbz();
        bbA();
        if (this.eTu != null) {
            this.eTu.b(bbC(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void bbz() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (bbC()) {
            this.eTv.setVisibility(0);
            am.setNavbarTitleColor(this.eTv, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.eTv.setAlpha(alpha);
            return;
        }
        this.eTv.setVisibility(8);
    }

    public void pb(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eTv.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void bbA() {
        if (bbC()) {
            SvgManager.amL().a(this.eSV, R.drawable.icon_pure_topbar_return_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            SvgManager.amL().a(this.eSV, R.drawable.icon_pure_topbar_return_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        bH(this.eSV);
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

    private void bbB() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.eTw = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.eTw = false;
        } else {
            this.eTw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bbC() {
        return this.eTw;
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
        private boolean eTA = false;
        private g eTy;
        private TextView eTz;
        private ImageView eiO;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.eTy = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.eTz = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(R.id.channel_nav_right_sub_btn);
            this.eiO = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
            this.eTz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.eTA ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.eiO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
            if (dVar != null && dVar.bbj() != null) {
                this.eTA = dVar.bbj().isSubscribe();
                b(this.eTy.bbC(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
            c(z, f);
            this.eTz.setVisibility(8);
            this.eTy.pb(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds60));
        }

        private void c(boolean z, float f) {
            if (this.eiO != null) {
                if (z) {
                    SvgManager.amL().a(this.eiO, R.drawable.icon_pure_topbar_more_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                } else {
                    SvgManager.amL().a(this.eiO, R.drawable.icon_pure_topbar_more_n_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                }
                this.eiO.setVisibility(0);
                this.eTy.bH(this.eiO);
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

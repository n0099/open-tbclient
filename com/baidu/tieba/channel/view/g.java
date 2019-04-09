package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class g implements e<com.baidu.tieba.channel.data.d> {
    private ImageView eoM;
    private h epl;
    public TextView epm;
    private boolean epn = false;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.epm = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.eoM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eoM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.epl == null) {
            this.isHost = z;
            this.epl = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.epl != null) {
                this.epl.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void am(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aRq() != null) {
            this.epm.setText(dVar.aRq().getChannelName());
            if (this.epl != null) {
                this.epl.am(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.epl != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            al.l(this.mNavigationBar.getBarBgView(), d.C0277d.cp_bg_line_d);
        }
    }

    public void F(int i, int i2, int i3) {
        G(i, i2, i3);
        aRH();
        aRF();
        aRG();
        if (this.epl != null) {
            this.epl.b(aRI(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void aRF() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (aRI()) {
            this.epm.setVisibility(0);
            al.c(this.epm, d.C0277d.cp_cont_b, d.C0277d.s_navbar_title_color);
            this.epm.setAlpha(alpha);
            return;
        }
        this.epm.setVisibility(8);
    }

    public void oB(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epm.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void aRG() {
        if (aRI()) {
            al.a(this.eoM, d.f.icon_return_bg_s, d.f.icon_return_bg_s);
        } else {
            al.a(this.eoM, d.f.icon_return_bg, d.f.icon_return_bg);
        }
        bB(this.eoM);
    }

    private void G(int i, int i2, int i3) {
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

    private void aRH() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.epn = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.epn = false;
        } else {
            this.epn = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aRI() {
        return this.epn;
    }

    public void bB(View view) {
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
        private ImageView dFK;
        private g epp;
        private TextView epq;
        private boolean epr = false;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.epp = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.epq = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(d.g.channel_nav_right_sub_btn);
            this.dFK = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
            this.epq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.epr ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.dFK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
        public void am(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.aRq() != null) {
                this.epr = dVar.aRq().isSubscribe();
                b(this.epp.aRI(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
            c(z, f);
            this.epq.setVisibility(8);
            this.epp.oB(this.mContext.getResources().getDimensionPixelSize(d.e.ds60));
        }

        private void c(boolean z, float f) {
            if (this.dFK != null) {
                if (z) {
                    al.a(this.dFK, d.f.icon_more_bg_s, d.f.icon_more_bg_s);
                } else {
                    al.a(this.dFK, d.f.icon_more_bg, d.f.icon_more_bg);
                }
                this.dFK.setVisibility(0);
                this.epp.bB(this.dFK);
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
        public void am(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
        }
    }
}

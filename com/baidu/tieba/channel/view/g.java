package com.baidu.tieba.channel.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g implements e<com.baidu.tieba.channel.data.d> {
    private ImageView cFC;
    private h cGb;
    public TextView cGc;
    private boolean cGd = false;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.cGc = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.cFC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cFC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.cGb == null) {
            this.isHost = z;
            this.cGb = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.cGb != null) {
                this.cGb.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void T(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ajJ() != null) {
            this.cGc.setText(dVar.ajJ().getChannelName());
            if (this.cGb != null) {
                this.cGb.T(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.cGb != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(am.cU(d.f.s_navbar_bg)));
        }
    }

    public void x(int i, int i2, int i3) {
        y(i, i2, i3);
        akb();
        ajZ();
        aka();
        if (this.cGb != null) {
            this.cGb.b(akc(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void ajZ() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (akc()) {
            this.cGc.setVisibility(0);
            am.b(this.cGc, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
            this.cGc.setAlpha(alpha);
            return;
        }
        this.cGc.setVisibility(8);
    }

    public void jk(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cGc.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void aka() {
        if (akc()) {
            am.a(this.cFC, d.f.icon_return_bg_s, d.f.icon_return_bg_s);
        } else {
            am.a(this.cFC, d.f.icon_return_bg, d.f.icon_return_bg);
        }
        ao(this.cFC);
    }

    private void y(int i, int i2, int i3) {
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

    private void akb() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.cGd = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.cGd = false;
        } else {
            this.cGd = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akc() {
        return this.cGd;
    }

    public void ao(View view) {
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

    /* loaded from: classes3.dex */
    public static class a implements h<com.baidu.tieba.channel.data.d> {
        private ImageView bXL;
        private g cGf;
        private TextView cGg;
        private boolean cGh = false;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.cGf = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.cGg = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(d.g.channel_nav_right_sub_btn);
            this.bXL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
            this.cGg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.cGh ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.bXL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
        public void T(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.ajJ() != null) {
                this.cGh = dVar.ajJ().isSubscribe();
                b(this.cGf.akc(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
            c(z, f);
            this.cGg.setVisibility(8);
            this.cGf.jk(this.mContext.getResources().getDimensionPixelSize(d.e.ds60));
        }

        private void c(boolean z, float f) {
            if (this.bXL != null) {
                if (z) {
                    am.a(this.bXL, d.f.icon_more_bg_s, d.f.icon_more_bg_s);
                } else {
                    am.a(this.bXL, d.f.icon_more_bg, d.f.icon_more_bg);
                }
                this.bXL.setVisibility(0);
                this.cGf.ao(this.bXL);
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public void T(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
        }
    }
}

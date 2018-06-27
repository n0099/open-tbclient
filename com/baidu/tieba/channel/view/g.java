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
    private ImageView cCW;
    private h cDv;
    public TextView cDw;
    private boolean cDx = false;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.cDw = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.cCW = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cCW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.cDv == null) {
            this.isHost = z;
            this.cDv = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.cDv != null) {
                this.cDv.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void T(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ajl() != null) {
            this.cDw.setText(dVar.ajl().getChannelName());
            if (this.cDv != null) {
                this.cDv.T(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.cDv != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(am.cS(d.f.s_navbar_bg)));
        }
    }

    public void x(int i, int i2, int i3) {
        y(i, i2, i3);
        ajD();
        ajB();
        ajC();
        if (this.cDv != null) {
            this.cDv.b(ajE(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void ajB() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (ajE()) {
            this.cDw.setVisibility(0);
            am.b(this.cDw, d.C0142d.cp_cont_b, d.C0142d.s_navbar_title_color);
            this.cDw.setAlpha(alpha);
            return;
        }
        this.cDw.setVisibility(8);
    }

    public void iY(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cDw.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void ajC() {
        if (ajE()) {
            am.a(this.cCW, d.f.icon_return_bg_s, d.f.icon_return_bg_s);
        } else {
            am.a(this.cCW, d.f.icon_return_bg, d.f.icon_return_bg);
        }
        al(this.cCW);
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

    private void ajD() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.cDx = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.cDx = false;
        } else {
            this.cDx = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ajE() {
        return this.cDx;
    }

    public void al(View view) {
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
        private ImageView bWC;
        private TextView cDA;
        private boolean cDB = false;
        private g cDz;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.cDz = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.cDA = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(d.g.channel_nav_right_sub_btn);
            this.bWC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.channel_home_nav_right_item, (View.OnClickListener) null);
            this.cDA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.cDB ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.bWC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
            if (dVar != null && dVar.ajl() != null) {
                this.cDB = dVar.ajl().isSubscribe();
                b(this.cDz.ajE(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
            c(z, f);
            this.cDA.setVisibility(8);
            this.cDz.iY(this.mContext.getResources().getDimensionPixelSize(d.e.ds60));
        }

        private void c(boolean z, float f) {
            if (this.bWC != null) {
                if (z) {
                    am.a(this.bWC, d.f.icon_more_bg_s, d.f.icon_more_bg_s);
                } else {
                    am.a(this.bWC, d.f.icon_more_bg, d.f.icon_more_bg);
                }
                this.bWC.setVisibility(0);
                this.cDz.al(this.bWC);
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

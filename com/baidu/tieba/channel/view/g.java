package com.baidu.tieba.channel.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g implements e<com.baidu.tieba.channel.data.d> {
    private ImageView ddD;
    private h dec;
    public TextView ded;
    private boolean dee = false;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.ded = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.ddD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.ddD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.dec == null) {
            this.isHost = z;
            this.dec = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.dec != null) {
                this.dec.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void aT(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.amj() != null) {
            this.ded.setText(dVar.amj().getChannelName());
            if (this.dec != null) {
                this.dec.aT(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.dec != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(aj.fP(d.f.s_navbar_bg)));
        }
    }

    public void J(int i, int i2, int i3) {
        K(i, i2, i3);
        amB();
        amz();
        amA();
        if (this.dec != null) {
            this.dec.a(amC(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void amz() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (amC()) {
            this.ded.setVisibility(0);
            aj.d(this.ded, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
            this.ded.setAlpha(alpha);
            return;
        }
        this.ded.setVisibility(8);
    }

    public void lP(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ded.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void amA() {
        if (amC()) {
            aj.a(this.ddD, d.f.icon_return_bg_s, d.f.icon_return_bg_s);
        } else {
            aj.a(this.ddD, d.f.icon_return_bg, d.f.icon_return_bg);
        }
        bE(this.ddD);
    }

    private void K(int i, int i2, int i3) {
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

    private void amB() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.dee = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.dee = false;
        } else {
            this.dee = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean amC() {
        return this.dee;
    }

    public void bE(View view) {
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
        private ImageView cvv;
        private g deg;
        private TextView deh;
        private boolean dei = false;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.deg = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.deh = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(d.g.channel_nav_right_sub_btn);
            this.cvv = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
            this.deh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.dei ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.cvv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
        public void aT(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.amj() != null) {
                this.dei = dVar.amj().isSubscribe();
                a(this.deg.amC(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void a(boolean z, float f) {
            b(z, f);
            this.deh.setVisibility(8);
            this.deg.lP(this.mContext.getResources().getDimensionPixelSize(d.e.ds60));
        }

        private void b(boolean z, float f) {
            if (this.cvv != null) {
                if (z) {
                    aj.a(this.cvv, d.f.icon_more_bg_s, d.f.icon_more_bg_s);
                } else {
                    aj.a(this.cvv, d.f.icon_more_bg, d.f.icon_more_bg);
                }
                this.cvv.setVisibility(0);
                this.deg.bE(this.cvv);
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
        public void aT(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void a(boolean z, float f) {
        }
    }
}

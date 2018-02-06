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
    private ImageView ddM;
    private h del;
    public TextView dem;
    private boolean den = false;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.dem = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.ddM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.ddM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.del == null) {
            this.isHost = z;
            this.del = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.del != null) {
                this.del.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void aT(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.amj() != null) {
            this.dem.setText(dVar.amj().getChannelName());
            if (this.del != null) {
                this.del.aT(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.del != null) {
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
        if (this.del != null) {
            this.del.a(amC(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void amz() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (amC()) {
            this.dem.setVisibility(0);
            aj.d(this.dem, d.C0140d.cp_cont_b, d.C0140d.s_navbar_title_color);
            this.dem.setAlpha(alpha);
            return;
        }
        this.dem.setVisibility(8);
    }

    public void lP(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dem.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void amA() {
        if (amC()) {
            aj.a(this.ddM, d.f.icon_return_bg_s, d.f.icon_return_bg_s);
        } else {
            aj.a(this.ddM, d.f.icon_return_bg, d.f.icon_return_bg);
        }
        bE(this.ddM);
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
            this.den = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.den = false;
        } else {
            this.den = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean amC() {
        return this.den;
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
        private ImageView cvE;
        private g dep;
        private TextView deq;
        private boolean der = false;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.dep = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.deq = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(d.g.channel_nav_right_sub_btn);
            this.cvE = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.channel_home_nav_right_item, (View.OnClickListener) null);
            this.deq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.der ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.cvE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
                this.der = dVar.amj().isSubscribe();
                a(this.dep.amC(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void a(boolean z, float f) {
            b(z, f);
            this.deq.setVisibility(8);
            this.dep.lP(this.mContext.getResources().getDimensionPixelSize(d.e.ds60));
        }

        private void b(boolean z, float f) {
            if (this.cvE != null) {
                if (z) {
                    aj.a(this.cvE, d.f.icon_more_bg_s, d.f.icon_more_bg_s);
                } else {
                    aj.a(this.cvE, d.f.icon_more_bg, d.f.icon_more_bg);
                }
                this.cvE.setVisibility(0);
                this.dep.bE(this.cvE);
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

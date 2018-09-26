package com.baidu.tieba.channel.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class g implements e<com.baidu.tieba.channel.data.d> {
    private h cLP;
    public TextView cLQ;
    private boolean cLR = false;
    private ImageView cLq;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.cLQ = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.cLq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cLq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.cLP == null) {
            this.isHost = z;
            this.cLP = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.cLP != null) {
                this.cLP.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void W(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.alx() != null) {
            this.cLQ.setText(dVar.alx().getChannelName());
            if (this.cLP != null) {
                this.cLP.W(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.cLP != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dd(e.f.s_navbar_bg)));
        }
    }

    public void C(int i, int i2, int i3) {
        D(i, i2, i3);
        alO();
        alM();
        alN();
        if (this.cLP != null) {
            this.cLP.b(alP(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void alM() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (alP()) {
            this.cLQ.setVisibility(0);
            al.b(this.cLQ, e.d.cp_cont_b, e.d.s_navbar_title_color);
            this.cLQ.setAlpha(alpha);
            return;
        }
        this.cLQ.setVisibility(8);
    }

    public void jI(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cLQ.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void alN() {
        if (alP()) {
            al.a(this.cLq, e.f.icon_return_bg_s, e.f.icon_return_bg_s);
        } else {
            al.a(this.cLq, e.f.icon_return_bg, e.f.icon_return_bg);
        }
        aC(this.cLq);
    }

    private void D(int i, int i2, int i3) {
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

    private void alO() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.cLR = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.cLR = false;
        } else {
            this.cLR = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean alP() {
        return this.cLR;
    }

    public void aC(View view) {
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
        private g cLT;
        private TextView cLU;
        private boolean cLV = false;
        private ImageView cdz;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.cLT = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.cLU = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(e.g.channel_nav_right_sub_btn);
            this.cdz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.channel_home_nav_right_item, (View.OnClickListener) null);
            this.cLU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.cLV ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.cdz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
        public void W(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.alx() != null) {
                this.cLV = dVar.alx().isSubscribe();
                b(this.cLT.alP(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
            c(z, f);
            this.cLU.setVisibility(8);
            this.cLT.jI(this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds60));
        }

        private void c(boolean z, float f) {
            if (this.cdz != null) {
                if (z) {
                    al.a(this.cdz, e.f.icon_more_bg_s, e.f.icon_more_bg_s);
                } else {
                    al.a(this.cdz, e.f.icon_more_bg, e.f.icon_more_bg);
                }
                this.cdz.setVisibility(0);
                this.cLT.aC(this.cdz);
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
        public void W(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
        }
    }
}

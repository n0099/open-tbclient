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
    private h dfD;
    public TextView dfE;
    private boolean dfF = false;
    private ImageView dfe;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.dfE = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.dfe = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.dfe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.dfD == null) {
            this.isHost = z;
            this.dfD = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.dfD != null) {
                this.dfD.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void Z(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.arB() != null) {
            this.dfE.setText(dVar.arB().getChannelName());
            if (this.dfD != null) {
                this.dfD.Z(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.dfD != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)));
        }
    }

    public void C(int i, int i2, int i3) {
        D(i, i2, i3);
        arS();
        arQ();
        arR();
        if (this.dfD != null) {
            this.dfD.b(arT(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void arQ() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (arT()) {
            this.dfE.setVisibility(0);
            al.b(this.dfE, e.d.cp_cont_b, e.d.s_navbar_title_color);
            this.dfE.setAlpha(alpha);
            return;
        }
        this.dfE.setVisibility(8);
    }

    public void ld(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfE.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void arR() {
        if (arT()) {
            al.a(this.dfe, e.f.icon_return_bg_s, e.f.icon_return_bg_s);
        } else {
            al.a(this.dfe, e.f.icon_return_bg, e.f.icon_return_bg);
        }
        aH(this.dfe);
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

    private void arS() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.dfF = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.dfF = false;
        } else {
            this.dfF = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean arT() {
        return this.dfF;
    }

    public void aH(View view) {
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
        private ImageView crB;
        private g dfH;
        private TextView dfI;
        private boolean dfJ = false;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.dfH = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.dfI = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(e.g.channel_nav_right_sub_btn);
            this.crB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.channel_home_nav_right_item, (View.OnClickListener) null);
            this.dfI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.dfJ ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.crB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
        public void Z(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.arB() != null) {
                this.dfJ = dVar.arB().isSubscribe();
                b(this.dfH.arT(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
            c(z, f);
            this.dfI.setVisibility(8);
            this.dfH.ld(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds60));
        }

        private void c(boolean z, float f) {
            if (this.crB != null) {
                if (z) {
                    al.a(this.crB, e.f.icon_more_bg_s, e.f.icon_more_bg_s);
                } else {
                    al.a(this.crB, e.f.icon_more_bg, e.f.icon_more_bg);
                }
                this.crB.setVisibility(0);
                this.dfH.aH(this.crB);
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
        public void Z(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
        }
    }
}

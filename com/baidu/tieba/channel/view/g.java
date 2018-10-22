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
    private ImageView cTJ;
    private h cUi;
    public TextView cUj;
    private boolean cUk = false;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.cUj = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.cTJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cTJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.cUi == null) {
            this.isHost = z;
            this.cUi = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.cUi != null) {
                this.cUi.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void aa(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.apa() != null) {
            this.cUj.setText(dVar.apa().getChannelName());
            if (this.cUi != null) {
                this.cUi.aa(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.cUi != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dn(e.f.s_navbar_bg)));
        }
    }

    public void C(int i, int i2, int i3) {
        D(i, i2, i3);
        aps();
        apq();
        apr();
        if (this.cUi != null) {
            this.cUi.b(apt(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void apq() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (apt()) {
            this.cUj.setVisibility(0);
            al.b(this.cUj, e.d.cp_cont_b, e.d.s_navbar_title_color);
            this.cUj.setAlpha(alpha);
            return;
        }
        this.cUj.setVisibility(8);
    }

    public void kg(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cUj.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void apr() {
        if (apt()) {
            al.a(this.cTJ, e.f.icon_return_bg_s, e.f.icon_return_bg_s);
        } else {
            al.a(this.cTJ, e.f.icon_return_bg, e.f.icon_return_bg);
        }
        aC(this.cTJ);
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

    private void aps() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.cUk = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.cUk = false;
        } else {
            this.cUk = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean apt() {
        return this.cUk;
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
        private g cUm;
        private TextView cUn;
        private boolean cUo = false;
        private ImageView clZ;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.cUm = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.cUn = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(e.g.channel_nav_right_sub_btn);
            this.clZ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.channel_home_nav_right_item, (View.OnClickListener) null);
            this.cUn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.cUo ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.clZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
        public void aa(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.apa() != null) {
                this.cUo = dVar.apa().isSubscribe();
                b(this.cUm.apt(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
            c(z, f);
            this.cUn.setVisibility(8);
            this.cUm.kg(this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds60));
        }

        private void c(boolean z, float f) {
            if (this.clZ != null) {
                if (z) {
                    al.a(this.clZ, e.f.icon_more_bg_s, e.f.icon_more_bg_s);
                } else {
                    al.a(this.clZ, e.f.icon_more_bg, e.f.icon_more_bg);
                }
                this.clZ.setVisibility(0);
                this.cUm.aC(this.clZ);
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
        public void aa(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
        }
    }
}

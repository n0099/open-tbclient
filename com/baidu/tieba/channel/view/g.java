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
    private h dbX;
    public TextView dbY;
    private boolean dbZ = false;
    private ImageView dby;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.dbY = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.dby = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.dby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.dbX == null) {
            this.isHost = z;
            this.dbX = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.dbX != null) {
                this.dbX.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void Z(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aqo() != null) {
            this.dbY.setText(dVar.aqo().getChannelName());
            if (this.dbX != null) {
                this.dbX.Z(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.dbX != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.dP(e.f.s_navbar_bg)));
        }
    }

    public void C(int i, int i2, int i3) {
        D(i, i2, i3);
        aqF();
        aqD();
        aqE();
        if (this.dbX != null) {
            this.dbX.b(aqG(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void aqD() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (aqG()) {
            this.dbY.setVisibility(0);
            al.b(this.dbY, e.d.cp_cont_b, e.d.s_navbar_title_color);
            this.dbY.setAlpha(alpha);
            return;
        }
        this.dbY.setVisibility(8);
    }

    public void kP(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dbY.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void aqE() {
        if (aqG()) {
            al.a(this.dby, e.f.icon_return_bg_s, e.f.icon_return_bg_s);
        } else {
            al.a(this.dby, e.f.icon_return_bg, e.f.icon_return_bg);
        }
        aE(this.dby);
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

    private void aqF() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.dbZ = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.dbZ = false;
        } else {
            this.dbZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqG() {
        return this.dbZ;
    }

    public void aE(View view) {
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
        private ImageView cqk;
        private g dcb;
        private TextView dcc;
        private boolean dcd = false;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.dcb = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.dcc = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(e.g.channel_nav_right_sub_btn);
            this.cqk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.channel_home_nav_right_item, (View.OnClickListener) null);
            this.dcc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.dcd ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.cqk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
            if (dVar != null && dVar.aqo() != null) {
                this.dcd = dVar.aqo().isSubscribe();
                b(this.dcb.aqG(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
            c(z, f);
            this.dcc.setVisibility(8);
            this.dcb.kP(this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds60));
        }

        private void c(boolean z, float f) {
            if (this.cqk != null) {
                if (z) {
                    al.a(this.cqk, e.f.icon_more_bg_s, e.f.icon_more_bg_s);
                } else {
                    al.a(this.cqk, e.f.icon_more_bg, e.f.icon_more_bg);
                }
                this.cqk.setVisibility(0);
                this.dcb.aE(this.cqk);
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

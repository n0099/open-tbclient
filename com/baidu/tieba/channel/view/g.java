package com.baidu.tieba.channel.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g implements e<com.baidu.tieba.channel.data.d> {
    private h cvT;
    public TextView cvU;
    private boolean cvV = false;
    private ImageView cvu;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.cvU = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.cvu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cvu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bVar != null) {
                    bVar.a(4, view2, null, -1);
                }
            }
        });
    }

    @Override // com.baidu.tieba.channel.view.e
    public void a(boolean z, com.baidu.tieba.channel.view.b bVar) {
        if (this.cvT == null) {
            this.isHost = z;
            this.cvT = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.cvT != null) {
                this.cvT.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void O(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.agj() != null) {
            this.cvU.setText(dVar.agj().getChannelName());
            if (this.cvT != null) {
                this.cvT.O(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.cvT != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(ak.cP(d.f.s_navbar_bg)));
        }
    }

    public void x(int i, int i2, int i3) {
        y(i, i2, i3);
        agB();
        agz();
        agA();
        if (this.cvT != null) {
            this.cvT.a(agC(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void agz() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (agC()) {
            this.cvU.setVisibility(0);
            ak.b(this.cvU, d.C0126d.cp_cont_b, d.C0126d.s_navbar_title_color);
            this.cvU.setAlpha(alpha);
            return;
        }
        this.cvU.setVisibility(8);
    }

    public void ja(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cvU.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void agA() {
        if (agC()) {
            ak.a(this.cvu, d.f.icon_return_bg_s, d.f.icon_return_bg_s);
        } else {
            ak.a(this.cvu, d.f.icon_return_bg, d.f.icon_return_bg);
        }
        aj(this.cvu);
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

    private void agB() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.cvV = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.cvV = false;
        } else {
            this.cvV = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean agC() {
        return this.cvV;
    }

    public void aj(View view2) {
        float f;
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (alpha < 0.5f) {
            f = 1.0f - (alpha * 2.0f);
        } else {
            f = (alpha * 2.0f) - 1.0f;
        }
        if (f >= 0.0f && f <= 1.0f) {
            view2.setAlpha(f);
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements h<com.baidu.tieba.channel.data.d> {
        private ImageView bLD;
        private g cvX;
        private TextView cvY;
        private boolean cvZ = false;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.cvX = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.cvY = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(d.g.channel_nav_right_sub_btn);
            this.bLD = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.channel_home_nav_right_item, (View.OnClickListener) null);
            this.cvY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (bVar != null) {
                        bVar.a(a.this.cvZ ? 17 : 5, view2, null, -1);
                    }
                }
            });
            this.bLD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (bVar != null) {
                        bVar.a(12, view2, null, -1);
                    }
                }
            });
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.channel.view.e
        /* renamed from: c */
        public void O(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.agj() != null) {
                this.cvZ = dVar.agj().isSubscribe();
                a(this.cvX.agC(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void a(boolean z, float f) {
            b(z, f);
            this.cvY.setVisibility(8);
            this.cvX.ja(this.mContext.getResources().getDimensionPixelSize(d.e.ds60));
        }

        private void b(boolean z, float f) {
            if (this.bLD != null) {
                if (z) {
                    ak.a(this.bLD, d.f.icon_more_bg_s, d.f.icon_more_bg_s);
                } else {
                    ak.a(this.bLD, d.f.icon_more_bg, d.f.icon_more_bg);
                }
                this.bLD.setVisibility(0);
                this.cvX.aj(this.bLD);
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
        public void O(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void a(boolean z, float f) {
        }
    }
}

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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class g implements e<com.baidu.tieba.channel.data.d> {
    private h cFY;
    public TextView cFZ;
    private ImageView cFz;
    private boolean cGa = false;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.cFZ = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.cFz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, f.h.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cFz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.cFY == null) {
            this.isHost = z;
            this.cFY = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.cFY != null) {
                this.cFY.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void T(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ajM() != null) {
            this.cFZ.setText(dVar.ajM().getChannelName());
            if (this.cFY != null) {
                this.cFY.T(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.cFY != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(am.cU(f.C0146f.s_navbar_bg)));
        }
    }

    public void x(int i, int i2, int i3) {
        y(i, i2, i3);
        akd();
        akb();
        akc();
        if (this.cFY != null) {
            this.cFY.b(ake(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void akb() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (ake()) {
            this.cFZ.setVisibility(0);
            am.b(this.cFZ, f.d.cp_cont_b, f.d.s_navbar_title_color);
            this.cFZ.setAlpha(alpha);
            return;
        }
        this.cFZ.setVisibility(8);
    }

    public void jj(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cFZ.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void akc() {
        if (ake()) {
            am.a(this.cFz, f.C0146f.icon_return_bg_s, f.C0146f.icon_return_bg_s);
        } else {
            am.a(this.cFz, f.C0146f.icon_return_bg, f.C0146f.icon_return_bg);
        }
        ao(this.cFz);
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

    private void akd() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.cGa = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.cGa = false;
        } else {
            this.cGa = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ake() {
        return this.cGa;
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
        private ImageView bXJ;
        private g cGc;
        private TextView cGd;
        private boolean cGe = false;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.cGc = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.cGd = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(f.g.channel_nav_right_sub_btn);
            this.bXJ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.channel_home_nav_right_item, (View.OnClickListener) null);
            this.cGd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.cGe ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.bXJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
            if (dVar != null && dVar.ajM() != null) {
                this.cGe = dVar.ajM().isSubscribe();
                b(this.cGc.ake(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
            c(z, f);
            this.cGd.setVisibility(8);
            this.cGc.jj(this.mContext.getResources().getDimensionPixelSize(f.e.ds60));
        }

        private void c(boolean z, float f) {
            if (this.bXJ != null) {
                if (z) {
                    am.a(this.bXJ, f.C0146f.icon_more_bg_s, f.C0146f.icon_more_bg_s);
                } else {
                    am.a(this.bXJ, f.C0146f.icon_more_bg, f.C0146f.icon_more_bg);
                }
                this.bXJ.setVisibility(0);
                this.cGc.ao(this.bXJ);
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

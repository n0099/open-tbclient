package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class g implements e<com.baidu.tieba.channel.data.d> {
    private h eJW;
    public TextView eJX;
    private boolean eJY = false;
    private ImageView eJx;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.eJX = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.eJx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eJx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.eJW == null) {
            this.isHost = z;
            this.eJW = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.eJW != null) {
                this.eJW.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void ao(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.baD() != null) {
            this.eJX.setText(dVar.baD().getChannelName());
            if (this.eJW != null) {
                this.eJW.ao(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.eJW != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            am.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
        }
    }

    public void H(int i, int i2, int i3) {
        I(i, i2, i3);
        baU();
        baS();
        baT();
        if (this.eJW != null) {
            this.eJW.b(baV(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void baS() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (baV()) {
            this.eJX.setVisibility(0);
            am.e(this.eJX, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.eJX.setAlpha(alpha);
            return;
        }
        this.eJX.setVisibility(8);
    }

    public void pW(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJX.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void baT() {
        if (baV()) {
            am.a(this.eJx, (int) R.drawable.icon_return_bg_s, (int) R.drawable.icon_return_bg_s);
        } else {
            am.a(this.eJx, (int) R.drawable.icon_return_bg, (int) R.drawable.icon_return_bg);
        }
        bK(this.eJx);
    }

    private void I(int i, int i2, int i3) {
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

    private void baU() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.eJY = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.eJY = false;
        } else {
            this.eJY = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean baV() {
        return this.eJY;
    }

    public void bK(View view) {
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

    /* loaded from: classes6.dex */
    public static class a implements h<com.baidu.tieba.channel.data.d> {
        private ImageView dUf;
        private g eKa;
        private TextView eKb;
        private boolean eKc = false;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.eKa = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.eKb = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(R.id.channel_nav_right_sub_btn);
            this.dUf = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
            this.eKb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.eKc ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.dUf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
        public void ao(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.baD() != null) {
                this.eKc = dVar.baD().isSubscribe();
                b(this.eKa.baV(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
            c(z, f);
            this.eKb.setVisibility(8);
            this.eKa.pW(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds60));
        }

        private void c(boolean z, float f) {
            if (this.dUf != null) {
                if (z) {
                    am.a(this.dUf, (int) R.drawable.icon_more_bg_s, (int) R.drawable.icon_more_bg_s);
                } else {
                    am.a(this.dUf, (int) R.drawable.icon_more_bg, (int) R.drawable.icon_more_bg);
                }
                this.dUf.setVisibility(0);
                this.eKa.bK(this.dUf);
            }
        }
    }

    /* loaded from: classes6.dex */
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
        public void ao(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
        }
    }
}

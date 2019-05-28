package com.baidu.tieba.channel.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class g implements e<com.baidu.tieba.channel.data.d> {
    private h eET;
    public TextView eEU;
    private boolean eEV = false;
    private ImageView eEu;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.eEU = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.eEu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eEu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.eET == null) {
            this.isHost = z;
            this.eET = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.eET != null) {
                this.eET.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void ao(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.aYC() != null) {
            this.eEU.setText(dVar.aYC().getChannelName());
            if (this.eET != null) {
                this.eET.ao(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.eET != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            al.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
        }
    }

    public void G(int i, int i2, int i3) {
        H(i, i2, i3);
        aYT();
        aYR();
        aYS();
        if (this.eET != null) {
            this.eET.b(aYU(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void aYR() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (aYU()) {
            this.eEU.setVisibility(0);
            al.e(this.eEU, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.eEU.setAlpha(alpha);
            return;
        }
        this.eEU.setVisibility(8);
    }

    public void pF(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eEU.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void aYS() {
        if (aYU()) {
            al.a(this.eEu, (int) R.drawable.icon_return_bg_s, (int) R.drawable.icon_return_bg_s);
        } else {
            al.a(this.eEu, (int) R.drawable.icon_return_bg, (int) R.drawable.icon_return_bg);
        }
        bI(this.eEu);
    }

    private void H(int i, int i2, int i3) {
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

    private void aYT() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.eEV = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.eEV = false;
        } else {
            this.eEV = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aYU() {
        return this.eEV;
    }

    public void bI(View view) {
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
        private ImageView dQk;
        private g eEX;
        private TextView eEY;
        private boolean eEZ = false;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.eEX = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.eEY = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(R.id.channel_nav_right_sub_btn);
            this.dQk = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
            this.eEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.eEZ ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.dQk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
            if (dVar != null && dVar.aYC() != null) {
                this.eEZ = dVar.aYC().isSubscribe();
                b(this.eEX.aYU(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
            c(z, f);
            this.eEY.setVisibility(8);
            this.eEX.pF(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds60));
        }

        private void c(boolean z, float f) {
            if (this.dQk != null) {
                if (z) {
                    al.a(this.dQk, (int) R.drawable.icon_more_bg_s, (int) R.drawable.icon_more_bg_s);
                } else {
                    al.a(this.dQk, (int) R.drawable.icon_more_bg, (int) R.drawable.icon_more_bg);
                }
                this.dQk.setVisibility(0);
                this.eEX.bI(this.dQk);
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

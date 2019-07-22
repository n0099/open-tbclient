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
    private h eJP;
    public TextView eJQ;
    private boolean eJR = false;
    private ImageView eJq;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.eJQ = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.eJq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
        this.eJq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.eJP == null) {
            this.isHost = z;
            this.eJP = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.eJP != null) {
                this.eJP.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void ao(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.baB() != null) {
            this.eJQ.setText(dVar.baB().getChannelName());
            if (this.eJP != null) {
                this.eJP.ao(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.eJP != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            am.l(this.mNavigationBar.getBarBgView(), R.color.cp_bg_line_d);
        }
    }

    public void H(int i, int i2, int i3) {
        I(i, i2, i3);
        baS();
        baQ();
        baR();
        if (this.eJP != null) {
            this.eJP.b(baT(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void baQ() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (baT()) {
            this.eJQ.setVisibility(0);
            am.e(this.eJQ, R.color.cp_cont_b, R.color.s_navbar_title_color);
            this.eJQ.setAlpha(alpha);
            return;
        }
        this.eJQ.setVisibility(8);
    }

    public void pV(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eJQ.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void baR() {
        if (baT()) {
            am.a(this.eJq, (int) R.drawable.icon_return_bg_s, (int) R.drawable.icon_return_bg_s);
        } else {
            am.a(this.eJq, (int) R.drawable.icon_return_bg, (int) R.drawable.icon_return_bg);
        }
        bK(this.eJq);
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

    private void baS() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.eJR = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.eJR = false;
        } else {
            this.eJR = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean baT() {
        return this.eJR;
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
        private ImageView dTY;
        private g eJT;
        private TextView eJU;
        private boolean eJV = false;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.eJT = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.eJU = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(R.id.channel_nav_right_sub_btn);
            this.dTY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.channel_home_nav_right_item, (View.OnClickListener) null);
            this.eJU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.eJV ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.dTY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
            if (dVar != null && dVar.baB() != null) {
                this.eJV = dVar.baB().isSubscribe();
                b(this.eJT.baT(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
            c(z, f);
            this.eJU.setVisibility(8);
            this.eJT.pV(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds60));
        }

        private void c(boolean z, float f) {
            if (this.dTY != null) {
                if (z) {
                    am.a(this.dTY, (int) R.drawable.icon_more_bg_s, (int) R.drawable.icon_more_bg_s);
                } else {
                    am.a(this.dTY, (int) R.drawable.icon_more_bg, (int) R.drawable.icon_more_bg);
                }
                this.dTY.setVisibility(0);
                this.eJT.bK(this.dTY);
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

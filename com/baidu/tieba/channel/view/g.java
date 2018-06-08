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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class g implements e<com.baidu.tieba.channel.data.d> {
    private h cFC;
    public TextView cFD;
    private boolean cFE = false;
    private ImageView cFd;
    private boolean isHost;
    private Context mContext;
    private NavigationBar mNavigationBar;

    public g(Context context, NavigationBar navigationBar, final com.baidu.tieba.channel.view.b bVar) {
        this.mContext = context;
        this.mNavigationBar = navigationBar;
        this.cFD = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.showBottomLine(false);
        this.cFd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.channel_home_nav_right_item, (View.OnClickListener) null);
        this.cFd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.1
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
        if (this.cFC == null) {
            this.isHost = z;
            this.cFC = z ? new b(this, this.mContext, this.mNavigationBar) : new a(this, this.mContext, this.mNavigationBar);
            if (this.cFC != null) {
                this.cFC.a(z, bVar);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.channel.view.e
    /* renamed from: c */
    public void R(com.baidu.tieba.channel.data.d dVar) {
        if (dVar != null && dVar.ajR() != null) {
            this.cFD.setText(dVar.ajR().getChannelName());
            if (this.cFC != null) {
                this.cFC.R(dVar);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.channel.view.e
    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(null, i);
        if (this.cFC != null) {
            this.mNavigationBar.getTopCoverBgView().setVisibility(0);
            this.mNavigationBar.getBackground().mutate().setAlpha(0);
            this.mNavigationBar.getBarBgView().setBackgroundDrawable(new BitmapDrawable(al.cR(d.f.s_navbar_bg)));
        }
    }

    public void x(int i, int i2, int i3) {
        y(i, i2, i3);
        akj();
        akh();
        aki();
        if (this.cFC != null) {
            this.cFC.b(akk(), this.mNavigationBar.getBarBgView().getAlpha());
        }
    }

    private void akh() {
        float alpha = this.mNavigationBar.getBarBgView().getAlpha();
        if (akk()) {
            this.cFD.setVisibility(0);
            al.b(this.cFD, d.C0141d.cp_cont_b, d.C0141d.s_navbar_title_color);
            this.cFD.setAlpha(alpha);
            return;
        }
        this.cFD.setVisibility(8);
    }

    public void ja(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cFD.getLayoutParams();
        if (layoutParams.leftMargin != i) {
            layoutParams.leftMargin = i;
            layoutParams.rightMargin = i;
        }
    }

    private void aki() {
        if (akk()) {
            al.a(this.cFd, d.f.icon_return_bg_s, d.f.icon_return_bg_s);
        } else {
            al.a(this.cFd, d.f.icon_return_bg, d.f.icon_return_bg);
        }
        aj(this.cFd);
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

    private void akj() {
        if (2 == TbadkCoreApplication.getInst().getSkinType()) {
            this.cFE = false;
        } else if (this.mNavigationBar.getBarBgView().getAlpha() < 0.5f) {
            this.cFE = false;
        } else {
            this.cFE = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean akk() {
        return this.cFE;
    }

    public void aj(View view) {
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
        private ImageView bUt;
        private g cFG;
        private TextView cFH;
        private boolean cFI = false;
        private Context mContext;
        private NavigationBar mNavigationBar;

        public a(g gVar, Context context, NavigationBar navigationBar) {
            this.mContext = context;
            this.mNavigationBar = navigationBar;
            this.cFG = gVar;
        }

        @Override // com.baidu.tieba.channel.view.e
        public void a(boolean z, final com.baidu.tieba.channel.view.b bVar) {
            this.cFH = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.channel_home_nav_subscriber_btn, (View.OnClickListener) null).findViewById(d.g.channel_nav_right_sub_btn);
            this.bUt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.channel_home_nav_right_item, (View.OnClickListener) null);
            this.cFH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar != null) {
                        bVar.a(a.this.cFI ? 17 : 5, view, null, -1);
                    }
                }
            });
            this.bUt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.channel.view.g.a.2
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
        public void R(com.baidu.tieba.channel.data.d dVar) {
            if (dVar != null && dVar.ajR() != null) {
                this.cFI = dVar.ajR().isSubscribe();
                b(this.cFG.akk(), this.mNavigationBar.getBarBgView().getAlpha());
            }
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
            c(z, f);
            this.cFH.setVisibility(8);
            this.cFG.ja(this.mContext.getResources().getDimensionPixelSize(d.e.ds60));
        }

        private void c(boolean z, float f) {
            if (this.bUt != null) {
                if (z) {
                    al.a(this.bUt, d.f.icon_more_bg_s, d.f.icon_more_bg_s);
                } else {
                    al.a(this.bUt, d.f.icon_more_bg, d.f.icon_more_bg);
                }
                this.bUt.setVisibility(0);
                this.cFG.aj(this.bUt);
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
        public void R(com.baidu.tieba.channel.data.d dVar) {
        }

        @Override // com.baidu.tieba.channel.view.e
        public void onChangeSkinType(int i) {
        }

        @Override // com.baidu.tieba.channel.view.h
        public void b(boolean z, float f) {
        }
    }
}

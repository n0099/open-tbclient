package com.baidu.tieba.frs.gameshare;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.d;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public class a {
    private TextView aqm;
    private LinearLayout bXl;
    private FrameLayout blc;
    private LinearLayout bxL;
    private RadioButton dkA;
    private RadioButton dkB;
    private RadioButton dkC;
    private RadioButton dkD;
    private RadioButton[] dkE;
    private TextView dkF;
    private TbImageView dkG;
    private TextView dkH;
    private TextView dkI;
    private TextView dkJ;
    private TextView dkK;
    private TextView dkL;
    private InterfaceC0139a dkM;
    private BlurDrawable dkN;
    private ImageView dkj;
    private FrameLayout dkk;
    private ColumnLayout dkl;
    private TbImageView dkm;
    private TbImageView dkn;
    private TextView dko;
    private TextView dkp;
    private TextView dkq;
    private RadioButton dkr;
    private RadioButton dks;
    private RadioButton dkt;
    private RadioButton dku;
    private RadioButton dkv;
    private RadioButton[] dkw;
    private TextView dkx;
    private TbImageView dky;
    private RadioButton dkz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0139a {
        void o(Bitmap bitmap);

        void onCancel();

        void p(Bitmap bitmap);

        void q(Bitmap bitmap);

        void r(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0139a interfaceC0139a) {
        this.dkM = interfaceC0139a;
        this.blc = (FrameLayout) LayoutInflater.from(context).inflate(d.i.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.blc.findViewById(d.g.game_share_content_layout);
        this.dkj = (ImageView) this.blc.findViewById(d.g.game_share_content_bg_view);
        this.bxL = (LinearLayout) this.blc.findViewById(d.g.game_share_card_layout);
        this.dkk = (FrameLayout) this.blc.findViewById(d.g.game_share_header_root);
        this.dkl = (ColumnLayout) this.blc.findViewById(d.g.game_share_header_layout);
        this.dkm = (TbImageView) this.blc.findViewById(d.g.game_share_header_bg_view);
        this.dkm.setVisibility(4);
        this.dkm.setDefaultBg(new ColorDrawable(this.blc.getResources().getColor(d.C0126d.transparent)));
        this.dkm.setDrawerType(1);
        this.dkm.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.dkm.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z) {
                    a.this.dkm.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dkn = (TbImageView) this.blc.findViewById(d.g.game_share_game_icon);
        this.dkn.setDrawerType(1);
        this.dkn.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.dko = (TextView) this.blc.findViewById(d.g.game_share_game_name);
        this.dkp = (TextView) this.blc.findViewById(d.g.game_share_game_description);
        this.dkq = (TextView) this.blc.findViewById(d.g.game_share_game_score);
        this.dkr = (RadioButton) this.blc.findViewById(d.g.game_share_score_grade_1);
        this.dks = (RadioButton) this.blc.findViewById(d.g.game_share_score_grade_2);
        this.dkt = (RadioButton) this.blc.findViewById(d.g.game_share_score_grade_3);
        this.dku = (RadioButton) this.blc.findViewById(d.g.game_share_score_grade_4);
        this.dkv = (RadioButton) this.blc.findViewById(d.g.game_share_score_grade_5);
        this.dkw = new RadioButton[]{this.dkr, this.dks, this.dkt, this.dku, this.dkv};
        this.dkx = (TextView) this.blc.findViewById(d.g.game_share_comment);
        this.dky = (TbImageView) this.blc.findViewById(d.g.game_share_user_protrait);
        this.dky.setDrawerType(1);
        this.dky.setIsRound(true);
        this.aqm = (TextView) this.blc.findViewById(d.g.game_share_user_name);
        this.dkz = (RadioButton) this.blc.findViewById(d.g.game_share_user_score_grade_1);
        this.dkA = (RadioButton) this.blc.findViewById(d.g.game_share_user_score_grade_2);
        this.dkB = (RadioButton) this.blc.findViewById(d.g.game_share_user_score_grade_3);
        this.dkC = (RadioButton) this.blc.findViewById(d.g.game_share_user_score_grade_4);
        this.dkD = (RadioButton) this.blc.findViewById(d.g.game_share_user_score_grade_5);
        this.dkE = new RadioButton[]{this.dkz, this.dkA, this.dkB, this.dkC, this.dkD};
        this.dkF = (TextView) this.blc.findViewById(d.g.game_share_qr_txt);
        this.dkG = (TbImageView) this.blc.findViewById(d.g.game_share_qr_img);
        this.bXl = (LinearLayout) this.blc.findViewById(d.g.game_share_entry_layout);
        this.dkH = (TextView) this.blc.findViewById(d.g.game_share_entry_weixin);
        this.dkH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Bitmap asS = a.this.asS();
                if (asS != null && a.this.dkM != null) {
                    a.this.dkM.o(asS);
                }
            }
        });
        this.dkI = (TextView) this.blc.findViewById(d.g.game_share_entry_wxfriends);
        this.dkI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Bitmap asS = a.this.asS();
                if (asS != null && a.this.dkM != null) {
                    a.this.dkM.p(asS);
                }
            }
        });
        this.dkJ = (TextView) this.blc.findViewById(d.g.game_share_entry_qq);
        this.dkJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Bitmap asS = a.this.asS();
                if (asS != null && a.this.dkM != null) {
                    a.this.dkM.q(asS);
                }
            }
        });
        this.dkK = (TextView) this.blc.findViewById(d.g.game_share_entry_sina);
        this.dkK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Bitmap asS = a.this.asS();
                if (asS != null && a.this.dkM != null) {
                    a.this.dkM.r(asS);
                }
            }
        });
        this.dkL = (TextView) this.blc.findViewById(d.g.game_share_cancel);
        this.dkL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.dkM != null) {
                    a.this.dkM.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.blc;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.Yd);
        sb.append(" ”");
        this.dkx.setText(sb);
        if (this.dkN == null) {
            c.fp().a(gameShareData.XZ, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.kl() == null) {
                        UtilHelper.showToast(a.this.blc.getContext(), d.k.share_failed);
                        if (a.this.dkM != null) {
                            a.this.dkM.onCancel();
                        }
                    }
                    a.this.dkN = new BlurDrawable(a.this.blc.getContext());
                    a.this.dkN.init(2, 4, aVar.kl());
                    a.this.dkN.drawBlur();
                    a.this.dkj.setImageBitmap(a.this.dkN.getBlurredBitmap());
                }
            }, null);
        }
        this.dkm.startLoad(gameShareData.Yf, 10, false);
        this.dkG.startLoad(gameShareData.Ye, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dkn.startLoad(gameShareData.XZ, 10, false);
            this.dko.setText(gameShareData.gameName);
            this.dkp.setText(gameShareData.Ya);
            this.dkq.setText(new DecimalFormat(".0").format(gameShareData.Yb));
            a((int) gameShareData.Yb, this.dkw);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dky.startLoad(gameShareData.userPortrait, 12, false);
            this.aqm.setText(gameShareData.userName);
            a((int) gameShareData.Yc, this.dkE);
        }
    }

    private void a(int i, RadioButton[] radioButtonArr) {
        if (radioButtonArr != null && radioButtonArr.length == 5) {
            if (i < 0) {
                i = 0;
            } else if (i > 10) {
                i = 10;
            }
            int i2 = i / 2;
            for (int i3 = 0; i3 < radioButtonArr.length; i3++) {
                if (radioButtonArr[i3] != null) {
                    if (i3 < i2) {
                        radioButtonArr[i3].setChecked(true);
                    } else {
                        radioButtonArr[i3].setChecked(false);
                    }
                }
            }
        }
    }

    public Bitmap asS() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int asT() {
        return this.bxL.getBottom();
    }

    public void onDestroy() {
        if (this.dkN != null) {
            this.dkN.onDestroy();
            this.dkN = null;
        }
    }
}

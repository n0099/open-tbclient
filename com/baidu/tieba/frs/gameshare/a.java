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
    private TextView ayY;
    private LinearLayout bIy;
    private FrameLayout bvn;
    private LinearLayout cji;
    private RadioButton dzA;
    private RadioButton dzB;
    private RadioButton dzC;
    private RadioButton dzD;
    private RadioButton dzE;
    private RadioButton[] dzF;
    private TextView dzG;
    private TbImageView dzH;
    private RadioButton dzI;
    private RadioButton dzJ;
    private RadioButton dzK;
    private RadioButton dzL;
    private RadioButton dzM;
    private RadioButton[] dzN;
    private TextView dzO;
    private TbImageView dzP;
    private TextView dzQ;
    private TextView dzR;
    private TextView dzS;
    private TextView dzT;
    private TextView dzU;
    private InterfaceC0154a dzV;
    private BlurDrawable dzW;
    private ImageView dzs;
    private FrameLayout dzt;
    private ColumnLayout dzu;
    private TbImageView dzv;
    private TbImageView dzw;
    private TextView dzx;
    private TextView dzy;
    private TextView dzz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0154a {
        void m(Bitmap bitmap);

        void n(Bitmap bitmap);

        void o(Bitmap bitmap);

        void onCancel();

        void p(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0154a interfaceC0154a) {
        this.dzV = interfaceC0154a;
        this.bvn = (FrameLayout) LayoutInflater.from(context).inflate(d.h.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.bvn.findViewById(d.g.game_share_content_layout);
        this.dzs = (ImageView) this.bvn.findViewById(d.g.game_share_content_bg_view);
        this.bIy = (LinearLayout) this.bvn.findViewById(d.g.game_share_card_layout);
        this.dzt = (FrameLayout) this.bvn.findViewById(d.g.game_share_header_root);
        this.dzu = (ColumnLayout) this.bvn.findViewById(d.g.game_share_header_layout);
        this.dzv = (TbImageView) this.bvn.findViewById(d.g.game_share_header_bg_view);
        this.dzv.setVisibility(4);
        this.dzv.setDefaultBg(new ColorDrawable(this.bvn.getResources().getColor(d.C0140d.transparent)));
        this.dzv.setDrawerType(1);
        this.dzv.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.dzv.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z) {
                    a.this.dzv.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dzw = (TbImageView) this.bvn.findViewById(d.g.game_share_game_icon);
        this.dzw.setDrawerType(1);
        this.dzw.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.dzx = (TextView) this.bvn.findViewById(d.g.game_share_game_name);
        this.dzy = (TextView) this.bvn.findViewById(d.g.game_share_game_description);
        this.dzz = (TextView) this.bvn.findViewById(d.g.game_share_game_score);
        this.dzA = (RadioButton) this.bvn.findViewById(d.g.game_share_score_grade_1);
        this.dzB = (RadioButton) this.bvn.findViewById(d.g.game_share_score_grade_2);
        this.dzC = (RadioButton) this.bvn.findViewById(d.g.game_share_score_grade_3);
        this.dzD = (RadioButton) this.bvn.findViewById(d.g.game_share_score_grade_4);
        this.dzE = (RadioButton) this.bvn.findViewById(d.g.game_share_score_grade_5);
        this.dzF = new RadioButton[]{this.dzA, this.dzB, this.dzC, this.dzD, this.dzE};
        this.dzG = (TextView) this.bvn.findViewById(d.g.game_share_comment);
        this.dzH = (TbImageView) this.bvn.findViewById(d.g.game_share_user_protrait);
        this.dzH.setDrawerType(1);
        this.dzH.setIsRound(true);
        this.ayY = (TextView) this.bvn.findViewById(d.g.game_share_user_name);
        this.dzI = (RadioButton) this.bvn.findViewById(d.g.game_share_user_score_grade_1);
        this.dzJ = (RadioButton) this.bvn.findViewById(d.g.game_share_user_score_grade_2);
        this.dzK = (RadioButton) this.bvn.findViewById(d.g.game_share_user_score_grade_3);
        this.dzL = (RadioButton) this.bvn.findViewById(d.g.game_share_user_score_grade_4);
        this.dzM = (RadioButton) this.bvn.findViewById(d.g.game_share_user_score_grade_5);
        this.dzN = new RadioButton[]{this.dzI, this.dzJ, this.dzK, this.dzL, this.dzM};
        this.dzO = (TextView) this.bvn.findViewById(d.g.game_share_qr_txt);
        this.dzP = (TbImageView) this.bvn.findViewById(d.g.game_share_qr_img);
        this.cji = (LinearLayout) this.bvn.findViewById(d.g.game_share_entry_layout);
        this.dzQ = (TextView) this.bvn.findViewById(d.g.game_share_entry_weixin);
        this.dzQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap ayh = a.this.ayh();
                if (ayh != null && a.this.dzV != null) {
                    a.this.dzV.m(ayh);
                }
            }
        });
        this.dzR = (TextView) this.bvn.findViewById(d.g.game_share_entry_wxfriends);
        this.dzR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap ayh = a.this.ayh();
                if (ayh != null && a.this.dzV != null) {
                    a.this.dzV.n(ayh);
                }
            }
        });
        this.dzS = (TextView) this.bvn.findViewById(d.g.game_share_entry_qq);
        this.dzS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap ayh = a.this.ayh();
                if (ayh != null && a.this.dzV != null) {
                    a.this.dzV.o(ayh);
                }
            }
        });
        this.dzT = (TextView) this.bvn.findViewById(d.g.game_share_entry_sina);
        this.dzT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap ayh = a.this.ayh();
                if (ayh != null && a.this.dzV != null) {
                    a.this.dzV.p(ayh);
                }
            }
        });
        this.dzU = (TextView) this.bvn.findViewById(d.g.game_share_cancel);
        this.dzU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dzV != null) {
                    a.this.dzV.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.bvn;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.afN);
        sb.append(" ”");
        this.dzG.setText(sb);
        if (this.dzW == null) {
            c.ih().a(gameShareData.afJ, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.nb() == null) {
                        UtilHelper.showToast(a.this.bvn.getContext(), d.j.share_failed);
                        if (a.this.dzV != null) {
                            a.this.dzV.onCancel();
                        }
                    }
                    a.this.dzW = new BlurDrawable(a.this.bvn.getContext());
                    a.this.dzW.init(2, 4, aVar.nb());
                    a.this.dzW.drawBlur();
                    a.this.dzs.setImageBitmap(a.this.dzW.getBlurredBitmap());
                }
            }, null);
        }
        this.dzv.startLoad(gameShareData.afP, 10, false);
        this.dzP.startLoad(gameShareData.afO, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dzw.startLoad(gameShareData.afJ, 10, false);
            this.dzx.setText(gameShareData.gameName);
            this.dzy.setText(gameShareData.afK);
            this.dzz.setText(new DecimalFormat(".0").format(gameShareData.afL));
            a((int) gameShareData.afL, this.dzF);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dzH.startLoad(gameShareData.userPortrait, 12, false);
            this.ayY.setText(gameShareData.userName);
            a((int) gameShareData.afM, this.dzN);
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

    public Bitmap ayh() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int ayi() {
        return this.bIy.getBottom();
    }

    public void onDestroy() {
        if (this.dzW != null) {
            this.dzW.onDestroy();
            this.dzW = null;
        }
    }
}

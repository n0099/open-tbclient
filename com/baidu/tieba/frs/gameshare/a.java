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
import com.baidu.tieba.f;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public class a {
    private TextView ayV;
    private LinearLayout bIy;
    private FrameLayout bvp;
    private LinearLayout cjf;
    private RadioButton dzA;
    private RadioButton dzB;
    private RadioButton[] dzC;
    private TextView dzD;
    private TbImageView dzE;
    private RadioButton dzF;
    private RadioButton dzG;
    private RadioButton dzH;
    private RadioButton dzI;
    private RadioButton dzJ;
    private RadioButton[] dzK;
    private TextView dzL;
    private TbImageView dzM;
    private TextView dzN;
    private TextView dzO;
    private TextView dzP;
    private TextView dzQ;
    private TextView dzR;
    private InterfaceC0154a dzS;
    private BlurDrawable dzT;
    private ImageView dzp;
    private FrameLayout dzq;
    private ColumnLayout dzr;
    private TbImageView dzs;
    private TbImageView dzt;
    private TextView dzu;
    private TextView dzv;
    private TextView dzw;
    private RadioButton dzx;
    private RadioButton dzy;
    private RadioButton dzz;
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
        this.dzS = interfaceC0154a;
        this.bvp = (FrameLayout) LayoutInflater.from(context).inflate(f.h.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.bvp.findViewById(f.g.game_share_content_layout);
        this.dzp = (ImageView) this.bvp.findViewById(f.g.game_share_content_bg_view);
        this.bIy = (LinearLayout) this.bvp.findViewById(f.g.game_share_card_layout);
        this.dzq = (FrameLayout) this.bvp.findViewById(f.g.game_share_header_root);
        this.dzr = (ColumnLayout) this.bvp.findViewById(f.g.game_share_header_layout);
        this.dzs = (TbImageView) this.bvp.findViewById(f.g.game_share_header_bg_view);
        this.dzs.setVisibility(4);
        this.dzs.setDefaultBg(new ColorDrawable(this.bvp.getResources().getColor(f.d.transparent)));
        this.dzs.setDrawerType(1);
        this.dzs.setRadius(context.getResources().getDimensionPixelSize(f.e.ds20));
        this.dzs.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void m(String str, boolean z) {
                if (z) {
                    a.this.dzs.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dzt = (TbImageView) this.bvp.findViewById(f.g.game_share_game_icon);
        this.dzt.setDrawerType(1);
        this.dzt.setRadius(context.getResources().getDimensionPixelSize(f.e.ds20));
        this.dzu = (TextView) this.bvp.findViewById(f.g.game_share_game_name);
        this.dzv = (TextView) this.bvp.findViewById(f.g.game_share_game_description);
        this.dzw = (TextView) this.bvp.findViewById(f.g.game_share_game_score);
        this.dzx = (RadioButton) this.bvp.findViewById(f.g.game_share_score_grade_1);
        this.dzy = (RadioButton) this.bvp.findViewById(f.g.game_share_score_grade_2);
        this.dzz = (RadioButton) this.bvp.findViewById(f.g.game_share_score_grade_3);
        this.dzA = (RadioButton) this.bvp.findViewById(f.g.game_share_score_grade_4);
        this.dzB = (RadioButton) this.bvp.findViewById(f.g.game_share_score_grade_5);
        this.dzC = new RadioButton[]{this.dzx, this.dzy, this.dzz, this.dzA, this.dzB};
        this.dzD = (TextView) this.bvp.findViewById(f.g.game_share_comment);
        this.dzE = (TbImageView) this.bvp.findViewById(f.g.game_share_user_protrait);
        this.dzE.setDrawerType(1);
        this.dzE.setIsRound(true);
        this.ayV = (TextView) this.bvp.findViewById(f.g.game_share_user_name);
        this.dzF = (RadioButton) this.bvp.findViewById(f.g.game_share_user_score_grade_1);
        this.dzG = (RadioButton) this.bvp.findViewById(f.g.game_share_user_score_grade_2);
        this.dzH = (RadioButton) this.bvp.findViewById(f.g.game_share_user_score_grade_3);
        this.dzI = (RadioButton) this.bvp.findViewById(f.g.game_share_user_score_grade_4);
        this.dzJ = (RadioButton) this.bvp.findViewById(f.g.game_share_user_score_grade_5);
        this.dzK = new RadioButton[]{this.dzF, this.dzG, this.dzH, this.dzI, this.dzJ};
        this.dzL = (TextView) this.bvp.findViewById(f.g.game_share_qr_txt);
        this.dzM = (TbImageView) this.bvp.findViewById(f.g.game_share_qr_img);
        this.cjf = (LinearLayout) this.bvp.findViewById(f.g.game_share_entry_layout);
        this.dzN = (TextView) this.bvp.findViewById(f.g.game_share_entry_weixin);
        this.dzN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap ayf = a.this.ayf();
                if (ayf != null && a.this.dzS != null) {
                    a.this.dzS.m(ayf);
                }
            }
        });
        this.dzO = (TextView) this.bvp.findViewById(f.g.game_share_entry_wxfriends);
        this.dzO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap ayf = a.this.ayf();
                if (ayf != null && a.this.dzS != null) {
                    a.this.dzS.n(ayf);
                }
            }
        });
        this.dzP = (TextView) this.bvp.findViewById(f.g.game_share_entry_qq);
        this.dzP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap ayf = a.this.ayf();
                if (ayf != null && a.this.dzS != null) {
                    a.this.dzS.o(ayf);
                }
            }
        });
        this.dzQ = (TextView) this.bvp.findViewById(f.g.game_share_entry_sina);
        this.dzQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap ayf = a.this.ayf();
                if (ayf != null && a.this.dzS != null) {
                    a.this.dzS.p(ayf);
                }
            }
        });
        this.dzR = (TextView) this.bvp.findViewById(f.g.game_share_cancel);
        this.dzR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dzS != null) {
                    a.this.dzS.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.bvp;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.afN);
        sb.append(" ”");
        this.dzD.setText(sb);
        if (this.dzT == null) {
            c.ih().a(gameShareData.afJ, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.nb() == null) {
                        UtilHelper.showToast(a.this.bvp.getContext(), f.j.share_failed);
                        if (a.this.dzS != null) {
                            a.this.dzS.onCancel();
                        }
                    }
                    a.this.dzT = new BlurDrawable(a.this.bvp.getContext());
                    a.this.dzT.init(2, 4, aVar.nb());
                    a.this.dzT.drawBlur();
                    a.this.dzp.setImageBitmap(a.this.dzT.getBlurredBitmap());
                }
            }, null);
        }
        this.dzs.startLoad(gameShareData.afP, 10, false);
        this.dzM.startLoad(gameShareData.afO, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dzt.startLoad(gameShareData.afJ, 10, false);
            this.dzu.setText(gameShareData.gameName);
            this.dzv.setText(gameShareData.afK);
            this.dzw.setText(new DecimalFormat(".0").format(gameShareData.afL));
            a((int) gameShareData.afL, this.dzC);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dzE.startLoad(gameShareData.userPortrait, 12, false);
            this.ayV.setText(gameShareData.userName);
            a((int) gameShareData.afM, this.dzK);
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

    public Bitmap ayf() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int ayg() {
        return this.bIy.getBottom();
    }

    public void onDestroy() {
        if (this.dzT != null) {
            this.dzT.onDestroy();
            this.dzT = null;
        }
    }
}

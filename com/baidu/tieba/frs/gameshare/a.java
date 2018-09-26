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
import com.baidu.tieba.e;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public class a {
    private TextView aBX;
    private FrameLayout bBe;
    private LinearLayout bOn;
    private LinearLayout coW;
    private ImageView dFZ;
    private TextView dGA;
    private TextView dGB;
    private InterfaceC0154a dGC;
    private BlurDrawable dGD;
    private FrameLayout dGa;
    private ColumnLayout dGb;
    private TbImageView dGc;
    private TbImageView dGd;
    private TextView dGe;
    private TextView dGf;
    private TextView dGg;
    private RadioButton dGh;
    private RadioButton dGi;
    private RadioButton dGj;
    private RadioButton dGk;
    private RadioButton dGl;
    private RadioButton[] dGm;
    private TextView dGn;
    private TbImageView dGo;
    private RadioButton dGp;
    private RadioButton dGq;
    private RadioButton dGr;
    private RadioButton dGs;
    private RadioButton dGt;
    private RadioButton[] dGu;
    private TextView dGv;
    private TbImageView dGw;
    private TextView dGx;
    private TextView dGy;
    private TextView dGz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0154a {
        void n(Bitmap bitmap);

        void o(Bitmap bitmap);

        void onCancel();

        void p(Bitmap bitmap);

        void q(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0154a interfaceC0154a) {
        this.dGC = interfaceC0154a;
        this.bBe = (FrameLayout) LayoutInflater.from(context).inflate(e.h.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.bBe.findViewById(e.g.game_share_content_layout);
        this.dFZ = (ImageView) this.bBe.findViewById(e.g.game_share_content_bg_view);
        this.bOn = (LinearLayout) this.bBe.findViewById(e.g.game_share_card_layout);
        this.dGa = (FrameLayout) this.bBe.findViewById(e.g.game_share_header_root);
        this.dGb = (ColumnLayout) this.bBe.findViewById(e.g.game_share_header_layout);
        this.dGc = (TbImageView) this.bBe.findViewById(e.g.game_share_header_bg_view);
        this.dGc.setVisibility(4);
        this.dGc.setDefaultBg(new ColorDrawable(this.bBe.getResources().getColor(e.d.transparent)));
        this.dGc.setDrawerType(1);
        this.dGc.setRadius(context.getResources().getDimensionPixelSize(e.C0141e.ds20));
        this.dGc.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void k(String str, boolean z) {
                if (z) {
                    a.this.dGc.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dGd = (TbImageView) this.bBe.findViewById(e.g.game_share_game_icon);
        this.dGd.setDrawerType(1);
        this.dGd.setRadius(context.getResources().getDimensionPixelSize(e.C0141e.ds20));
        this.dGe = (TextView) this.bBe.findViewById(e.g.game_share_game_name);
        this.dGf = (TextView) this.bBe.findViewById(e.g.game_share_game_description);
        this.dGg = (TextView) this.bBe.findViewById(e.g.game_share_game_score);
        this.dGh = (RadioButton) this.bBe.findViewById(e.g.game_share_score_grade_1);
        this.dGi = (RadioButton) this.bBe.findViewById(e.g.game_share_score_grade_2);
        this.dGj = (RadioButton) this.bBe.findViewById(e.g.game_share_score_grade_3);
        this.dGk = (RadioButton) this.bBe.findViewById(e.g.game_share_score_grade_4);
        this.dGl = (RadioButton) this.bBe.findViewById(e.g.game_share_score_grade_5);
        this.dGm = new RadioButton[]{this.dGh, this.dGi, this.dGj, this.dGk, this.dGl};
        this.dGn = (TextView) this.bBe.findViewById(e.g.game_share_comment);
        this.dGo = (TbImageView) this.bBe.findViewById(e.g.game_share_user_protrait);
        this.dGo.setDrawerType(1);
        this.dGo.setIsRound(true);
        this.aBX = (TextView) this.bBe.findViewById(e.g.game_share_user_name);
        this.dGp = (RadioButton) this.bBe.findViewById(e.g.game_share_user_score_grade_1);
        this.dGq = (RadioButton) this.bBe.findViewById(e.g.game_share_user_score_grade_2);
        this.dGr = (RadioButton) this.bBe.findViewById(e.g.game_share_user_score_grade_3);
        this.dGs = (RadioButton) this.bBe.findViewById(e.g.game_share_user_score_grade_4);
        this.dGt = (RadioButton) this.bBe.findViewById(e.g.game_share_user_score_grade_5);
        this.dGu = new RadioButton[]{this.dGp, this.dGq, this.dGr, this.dGs, this.dGt};
        this.dGv = (TextView) this.bBe.findViewById(e.g.game_share_qr_txt);
        this.dGw = (TbImageView) this.bBe.findViewById(e.g.game_share_qr_img);
        this.coW = (LinearLayout) this.bBe.findViewById(e.g.game_share_entry_layout);
        this.dGx = (TextView) this.bBe.findViewById(e.g.game_share_entry_weixin);
        this.dGx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aAu = a.this.aAu();
                if (aAu != null && a.this.dGC != null) {
                    a.this.dGC.n(aAu);
                }
            }
        });
        this.dGy = (TextView) this.bBe.findViewById(e.g.game_share_entry_wxfriends);
        this.dGy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aAu = a.this.aAu();
                if (aAu != null && a.this.dGC != null) {
                    a.this.dGC.o(aAu);
                }
            }
        });
        this.dGz = (TextView) this.bBe.findViewById(e.g.game_share_entry_qq);
        this.dGz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aAu = a.this.aAu();
                if (aAu != null && a.this.dGC != null) {
                    a.this.dGC.p(aAu);
                }
            }
        });
        this.dGA = (TextView) this.bBe.findViewById(e.g.game_share_entry_sina);
        this.dGA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aAu = a.this.aAu();
                if (aAu != null && a.this.dGC != null) {
                    a.this.dGC.q(aAu);
                }
            }
        });
        this.dGB = (TextView) this.bBe.findViewById(e.g.game_share_cancel);
        this.dGB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dGC != null) {
                    a.this.dGC.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.bBe;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.aio);
        sb.append(" ”");
        this.dGn.setText(sb);
        if (this.dGD == null) {
            c.jn().a(gameShareData.aik, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.oh() == null) {
                        UtilHelper.showToast(a.this.bBe.getContext(), e.j.share_failed);
                        if (a.this.dGC != null) {
                            a.this.dGC.onCancel();
                        }
                    }
                    a.this.dGD = new BlurDrawable(a.this.bBe.getContext());
                    a.this.dGD.init(2, 4, aVar.oh());
                    a.this.dGD.drawBlur();
                    a.this.dFZ.setImageBitmap(a.this.dGD.getBlurredBitmap());
                }
            }, null);
        }
        this.dGc.startLoad(gameShareData.aiq, 10, false);
        this.dGw.startLoad(gameShareData.aip, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dGd.startLoad(gameShareData.aik, 10, false);
            this.dGe.setText(gameShareData.gameName);
            this.dGf.setText(gameShareData.ail);
            this.dGg.setText(new DecimalFormat(".0").format(gameShareData.aim));
            a((int) gameShareData.aim, this.dGm);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dGo.startLoad(gameShareData.userPortrait, 12, false);
            this.aBX.setText(gameShareData.userName);
            a((int) gameShareData.ain, this.dGu);
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

    public Bitmap aAu() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int aAv() {
        return this.bOn.getBottom();
    }

    public void onDestroy() {
        if (this.dGD != null) {
            this.dGD.onDestroy();
            this.dGD = null;
        }
    }
}

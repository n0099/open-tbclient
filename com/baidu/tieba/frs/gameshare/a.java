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
    private LinearLayout bWy;
    private FrameLayout bkN;
    private LinearLayout bwU;
    private RadioButton[] djA;
    private TextView djB;
    private TbImageView djC;
    private TextView djD;
    private TextView djE;
    private TextView djF;
    private TextView djG;
    private TextView djH;
    private InterfaceC0139a djI;
    private BlurDrawable djJ;
    private ImageView djf;
    private FrameLayout djg;
    private ColumnLayout djh;
    private TbImageView dji;
    private TbImageView djj;
    private TextView djk;
    private TextView djl;
    private TextView djm;
    private RadioButton djn;
    private RadioButton djo;
    private RadioButton djp;
    private RadioButton djq;
    private RadioButton djr;
    private RadioButton[] djs;
    private TextView djt;
    private TbImageView dju;
    private RadioButton djv;
    private RadioButton djw;
    private RadioButton djx;
    private RadioButton djy;
    private RadioButton djz;
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
        this.djI = interfaceC0139a;
        this.bkN = (FrameLayout) LayoutInflater.from(context).inflate(d.i.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.bkN.findViewById(d.g.game_share_content_layout);
        this.djf = (ImageView) this.bkN.findViewById(d.g.game_share_content_bg_view);
        this.bwU = (LinearLayout) this.bkN.findViewById(d.g.game_share_card_layout);
        this.djg = (FrameLayout) this.bkN.findViewById(d.g.game_share_header_root);
        this.djh = (ColumnLayout) this.bkN.findViewById(d.g.game_share_header_layout);
        this.dji = (TbImageView) this.bkN.findViewById(d.g.game_share_header_bg_view);
        this.dji.setVisibility(4);
        this.dji.setDefaultBg(new ColorDrawable(this.bkN.getResources().getColor(d.C0126d.transparent)));
        this.dji.setDrawerType(1);
        this.dji.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.dji.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z) {
                    a.this.dji.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.djj = (TbImageView) this.bkN.findViewById(d.g.game_share_game_icon);
        this.djj.setDrawerType(1);
        this.djj.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.djk = (TextView) this.bkN.findViewById(d.g.game_share_game_name);
        this.djl = (TextView) this.bkN.findViewById(d.g.game_share_game_description);
        this.djm = (TextView) this.bkN.findViewById(d.g.game_share_game_score);
        this.djn = (RadioButton) this.bkN.findViewById(d.g.game_share_score_grade_1);
        this.djo = (RadioButton) this.bkN.findViewById(d.g.game_share_score_grade_2);
        this.djp = (RadioButton) this.bkN.findViewById(d.g.game_share_score_grade_3);
        this.djq = (RadioButton) this.bkN.findViewById(d.g.game_share_score_grade_4);
        this.djr = (RadioButton) this.bkN.findViewById(d.g.game_share_score_grade_5);
        this.djs = new RadioButton[]{this.djn, this.djo, this.djp, this.djq, this.djr};
        this.djt = (TextView) this.bkN.findViewById(d.g.game_share_comment);
        this.dju = (TbImageView) this.bkN.findViewById(d.g.game_share_user_protrait);
        this.dju.setDrawerType(1);
        this.dju.setIsRound(true);
        this.aqm = (TextView) this.bkN.findViewById(d.g.game_share_user_name);
        this.djv = (RadioButton) this.bkN.findViewById(d.g.game_share_user_score_grade_1);
        this.djw = (RadioButton) this.bkN.findViewById(d.g.game_share_user_score_grade_2);
        this.djx = (RadioButton) this.bkN.findViewById(d.g.game_share_user_score_grade_3);
        this.djy = (RadioButton) this.bkN.findViewById(d.g.game_share_user_score_grade_4);
        this.djz = (RadioButton) this.bkN.findViewById(d.g.game_share_user_score_grade_5);
        this.djA = new RadioButton[]{this.djv, this.djw, this.djx, this.djy, this.djz};
        this.djB = (TextView) this.bkN.findViewById(d.g.game_share_qr_txt);
        this.djC = (TbImageView) this.bkN.findViewById(d.g.game_share_qr_img);
        this.bWy = (LinearLayout) this.bkN.findViewById(d.g.game_share_entry_layout);
        this.djD = (TextView) this.bkN.findViewById(d.g.game_share_entry_weixin);
        this.djD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Bitmap asT = a.this.asT();
                if (asT != null && a.this.djI != null) {
                    a.this.djI.o(asT);
                }
            }
        });
        this.djE = (TextView) this.bkN.findViewById(d.g.game_share_entry_wxfriends);
        this.djE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Bitmap asT = a.this.asT();
                if (asT != null && a.this.djI != null) {
                    a.this.djI.p(asT);
                }
            }
        });
        this.djF = (TextView) this.bkN.findViewById(d.g.game_share_entry_qq);
        this.djF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Bitmap asT = a.this.asT();
                if (asT != null && a.this.djI != null) {
                    a.this.djI.q(asT);
                }
            }
        });
        this.djG = (TextView) this.bkN.findViewById(d.g.game_share_entry_sina);
        this.djG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Bitmap asT = a.this.asT();
                if (asT != null && a.this.djI != null) {
                    a.this.djI.r(asT);
                }
            }
        });
        this.djH = (TextView) this.bkN.findViewById(d.g.game_share_cancel);
        this.djH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.djI != null) {
                    a.this.djI.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.bkN;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.Yc);
        sb.append(" ”");
        this.djt.setText(sb);
        if (this.djJ == null) {
            c.fp().a(gameShareData.XY, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.km() == null) {
                        UtilHelper.showToast(a.this.bkN.getContext(), d.k.share_failed);
                        if (a.this.djI != null) {
                            a.this.djI.onCancel();
                        }
                    }
                    a.this.djJ = new BlurDrawable(a.this.bkN.getContext());
                    a.this.djJ.init(2, 4, aVar.km());
                    a.this.djJ.drawBlur();
                    a.this.djf.setImageBitmap(a.this.djJ.getBlurredBitmap());
                }
            }, null);
        }
        this.dji.startLoad(gameShareData.Ye, 10, false);
        this.djC.startLoad(gameShareData.Yd, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.djj.startLoad(gameShareData.XY, 10, false);
            this.djk.setText(gameShareData.gameName);
            this.djl.setText(gameShareData.XZ);
            this.djm.setText(new DecimalFormat(".0").format(gameShareData.Ya));
            a((int) gameShareData.Ya, this.djs);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dju.startLoad(gameShareData.userPortrait, 12, false);
            this.aqm.setText(gameShareData.userName);
            a((int) gameShareData.Yb, this.djA);
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

    public Bitmap asT() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int asU() {
        return this.bwU.getBottom();
    }

    public void onDestroy() {
        if (this.djJ != null) {
            this.djJ.onDestroy();
            this.djJ = null;
        }
    }
}

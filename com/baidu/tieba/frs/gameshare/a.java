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
    private LinearLayout bWv;
    private FrameLayout bkN;
    private LinearLayout bwU;
    private TextView djA;
    private TextView djB;
    private TextView djC;
    private TextView djD;
    private TextView djE;
    private InterfaceC0139a djF;
    private BlurDrawable djG;
    private ImageView djc;
    private FrameLayout djd;
    private ColumnLayout dje;
    private TbImageView djf;
    private TbImageView djg;
    private TextView djh;
    private TextView dji;
    private TextView djj;
    private RadioButton djk;
    private RadioButton djl;
    private RadioButton djm;
    private RadioButton djn;
    private RadioButton djo;
    private RadioButton[] djp;
    private TextView djq;
    private TbImageView djr;
    private RadioButton djs;
    private RadioButton djt;
    private RadioButton dju;
    private RadioButton djv;
    private RadioButton djw;
    private RadioButton[] djx;
    private TextView djy;
    private TbImageView djz;
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
        this.djF = interfaceC0139a;
        this.bkN = (FrameLayout) LayoutInflater.from(context).inflate(d.i.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.bkN.findViewById(d.g.game_share_content_layout);
        this.djc = (ImageView) this.bkN.findViewById(d.g.game_share_content_bg_view);
        this.bwU = (LinearLayout) this.bkN.findViewById(d.g.game_share_card_layout);
        this.djd = (FrameLayout) this.bkN.findViewById(d.g.game_share_header_root);
        this.dje = (ColumnLayout) this.bkN.findViewById(d.g.game_share_header_layout);
        this.djf = (TbImageView) this.bkN.findViewById(d.g.game_share_header_bg_view);
        this.djf.setVisibility(4);
        this.djf.setDefaultBg(new ColorDrawable(this.bkN.getResources().getColor(d.C0126d.transparent)));
        this.djf.setDrawerType(1);
        this.djf.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.djf.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z) {
                    a.this.djf.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.djg = (TbImageView) this.bkN.findViewById(d.g.game_share_game_icon);
        this.djg.setDrawerType(1);
        this.djg.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.djh = (TextView) this.bkN.findViewById(d.g.game_share_game_name);
        this.dji = (TextView) this.bkN.findViewById(d.g.game_share_game_description);
        this.djj = (TextView) this.bkN.findViewById(d.g.game_share_game_score);
        this.djk = (RadioButton) this.bkN.findViewById(d.g.game_share_score_grade_1);
        this.djl = (RadioButton) this.bkN.findViewById(d.g.game_share_score_grade_2);
        this.djm = (RadioButton) this.bkN.findViewById(d.g.game_share_score_grade_3);
        this.djn = (RadioButton) this.bkN.findViewById(d.g.game_share_score_grade_4);
        this.djo = (RadioButton) this.bkN.findViewById(d.g.game_share_score_grade_5);
        this.djp = new RadioButton[]{this.djk, this.djl, this.djm, this.djn, this.djo};
        this.djq = (TextView) this.bkN.findViewById(d.g.game_share_comment);
        this.djr = (TbImageView) this.bkN.findViewById(d.g.game_share_user_protrait);
        this.djr.setDrawerType(1);
        this.djr.setIsRound(true);
        this.aqm = (TextView) this.bkN.findViewById(d.g.game_share_user_name);
        this.djs = (RadioButton) this.bkN.findViewById(d.g.game_share_user_score_grade_1);
        this.djt = (RadioButton) this.bkN.findViewById(d.g.game_share_user_score_grade_2);
        this.dju = (RadioButton) this.bkN.findViewById(d.g.game_share_user_score_grade_3);
        this.djv = (RadioButton) this.bkN.findViewById(d.g.game_share_user_score_grade_4);
        this.djw = (RadioButton) this.bkN.findViewById(d.g.game_share_user_score_grade_5);
        this.djx = new RadioButton[]{this.djs, this.djt, this.dju, this.djv, this.djw};
        this.djy = (TextView) this.bkN.findViewById(d.g.game_share_qr_txt);
        this.djz = (TbImageView) this.bkN.findViewById(d.g.game_share_qr_img);
        this.bWv = (LinearLayout) this.bkN.findViewById(d.g.game_share_entry_layout);
        this.djA = (TextView) this.bkN.findViewById(d.g.game_share_entry_weixin);
        this.djA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Bitmap asT = a.this.asT();
                if (asT != null && a.this.djF != null) {
                    a.this.djF.o(asT);
                }
            }
        });
        this.djB = (TextView) this.bkN.findViewById(d.g.game_share_entry_wxfriends);
        this.djB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Bitmap asT = a.this.asT();
                if (asT != null && a.this.djF != null) {
                    a.this.djF.p(asT);
                }
            }
        });
        this.djC = (TextView) this.bkN.findViewById(d.g.game_share_entry_qq);
        this.djC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Bitmap asT = a.this.asT();
                if (asT != null && a.this.djF != null) {
                    a.this.djF.q(asT);
                }
            }
        });
        this.djD = (TextView) this.bkN.findViewById(d.g.game_share_entry_sina);
        this.djD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Bitmap asT = a.this.asT();
                if (asT != null && a.this.djF != null) {
                    a.this.djF.r(asT);
                }
            }
        });
        this.djE = (TextView) this.bkN.findViewById(d.g.game_share_cancel);
        this.djE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.djF != null) {
                    a.this.djF.onCancel();
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
        this.djq.setText(sb);
        if (this.djG == null) {
            c.fp().a(gameShareData.XY, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.km() == null) {
                        UtilHelper.showToast(a.this.bkN.getContext(), d.k.share_failed);
                        if (a.this.djF != null) {
                            a.this.djF.onCancel();
                        }
                    }
                    a.this.djG = new BlurDrawable(a.this.bkN.getContext());
                    a.this.djG.init(2, 4, aVar.km());
                    a.this.djG.drawBlur();
                    a.this.djc.setImageBitmap(a.this.djG.getBlurredBitmap());
                }
            }, null);
        }
        this.djf.startLoad(gameShareData.Ye, 10, false);
        this.djz.startLoad(gameShareData.Yd, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.djg.startLoad(gameShareData.XY, 10, false);
            this.djh.setText(gameShareData.gameName);
            this.dji.setText(gameShareData.XZ);
            this.djj.setText(new DecimalFormat(".0").format(gameShareData.Ya));
            a((int) gameShareData.Ya, this.djp);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.djr.startLoad(gameShareData.userPortrait, 12, false);
            this.aqm.setText(gameShareData.userName);
            a((int) gameShareData.Yb, this.djx);
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
        if (this.djG != null) {
            this.djG.onDestroy();
            this.djG = null;
        }
    }
}

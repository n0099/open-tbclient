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
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import java.text.DecimalFormat;
/* loaded from: classes2.dex */
public class a {
    private FrameLayout ajf;
    private TextView eGI;
    private LinearLayout hRT;
    private TbImageView hXE;
    private LinearLayout hjB;
    private TextView juA;
    private RadioButton juB;
    private RadioButton juC;
    private RadioButton juD;
    private RadioButton juE;
    private RadioButton juF;
    private RadioButton[] juG;
    private TextView juH;
    private TbImageView juI;
    private RadioButton juJ;
    private RadioButton juK;
    private RadioButton juL;
    private RadioButton juM;
    private RadioButton juN;
    private RadioButton[] juO;
    private TextView juP;
    private TbImageView juQ;
    private TextView juR;
    private TextView juS;
    private TextView juT;
    private TextView juU;
    private TextView juV;
    private InterfaceC0729a juW;
    private BlurDrawable juX;
    private ImageView juu;
    private FrameLayout juv;
    private ColumnLayout juw;
    private TbImageView jux;
    private TextView juy;
    private TextView juz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0729a {
        void A(Bitmap bitmap);

        void B(Bitmap bitmap);

        void C(Bitmap bitmap);

        void D(Bitmap bitmap);

        void onCancel();
    }

    public a(Context context, InterfaceC0729a interfaceC0729a) {
        this.juW = interfaceC0729a;
        this.ajf = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.ajf.findViewById(R.id.game_share_content_layout);
        this.juu = (ImageView) this.ajf.findViewById(R.id.game_share_content_bg_view);
        this.hjB = (LinearLayout) this.ajf.findViewById(R.id.game_share_card_layout);
        this.juv = (FrameLayout) this.ajf.findViewById(R.id.game_share_header_root);
        this.juw = (ColumnLayout) this.ajf.findViewById(R.id.game_share_header_layout);
        this.hXE = (TbImageView) this.ajf.findViewById(R.id.game_share_header_bg_view);
        this.hXE.setVisibility(4);
        this.hXE.setDefaultBg(new ColorDrawable(this.ajf.getResources().getColor(R.color.transparent)));
        this.hXE.setDrawerType(1);
        this.hXE.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.hXE.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.hXE.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.jux = (TbImageView) this.ajf.findViewById(R.id.game_share_game_icon);
        this.jux.setDrawerType(1);
        this.jux.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.juy = (TextView) this.ajf.findViewById(R.id.game_share_game_name);
        this.juz = (TextView) this.ajf.findViewById(R.id.game_share_game_description);
        this.juA = (TextView) this.ajf.findViewById(R.id.game_share_game_score);
        this.juB = (RadioButton) this.ajf.findViewById(R.id.game_share_score_grade_1);
        this.juC = (RadioButton) this.ajf.findViewById(R.id.game_share_score_grade_2);
        this.juD = (RadioButton) this.ajf.findViewById(R.id.game_share_score_grade_3);
        this.juE = (RadioButton) this.ajf.findViewById(R.id.game_share_score_grade_4);
        this.juF = (RadioButton) this.ajf.findViewById(R.id.game_share_score_grade_5);
        this.juG = new RadioButton[]{this.juB, this.juC, this.juD, this.juE, this.juF};
        this.juH = (TextView) this.ajf.findViewById(R.id.game_share_comment);
        this.juI = (TbImageView) this.ajf.findViewById(R.id.game_share_user_protrait);
        this.juI.setDrawerType(1);
        this.juI.setIsRound(true);
        this.eGI = (TextView) this.ajf.findViewById(R.id.game_share_user_name);
        this.juJ = (RadioButton) this.ajf.findViewById(R.id.game_share_user_score_grade_1);
        this.juK = (RadioButton) this.ajf.findViewById(R.id.game_share_user_score_grade_2);
        this.juL = (RadioButton) this.ajf.findViewById(R.id.game_share_user_score_grade_3);
        this.juM = (RadioButton) this.ajf.findViewById(R.id.game_share_user_score_grade_4);
        this.juN = (RadioButton) this.ajf.findViewById(R.id.game_share_user_score_grade_5);
        this.juO = new RadioButton[]{this.juJ, this.juK, this.juL, this.juM, this.juN};
        this.juP = (TextView) this.ajf.findViewById(R.id.game_share_qr_txt);
        this.juQ = (TbImageView) this.ajf.findViewById(R.id.game_share_qr_img);
        this.hRT = (LinearLayout) this.ajf.findViewById(R.id.game_share_entry_layout);
        this.juR = (TextView) this.ajf.findViewById(R.id.game_share_entry_weixin);
        this.juR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bku = a.this.bku();
                if (bku != null && a.this.juW != null) {
                    a.this.juW.A(bku);
                }
            }
        });
        this.juS = (TextView) this.ajf.findViewById(R.id.game_share_entry_wxfriends);
        this.juS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bku = a.this.bku();
                if (bku != null && a.this.juW != null) {
                    a.this.juW.B(bku);
                }
            }
        });
        this.juT = (TextView) this.ajf.findViewById(R.id.game_share_entry_qq);
        this.juT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bku = a.this.bku();
                if (bku != null && a.this.juW != null) {
                    a.this.juW.C(bku);
                }
            }
        });
        this.juU = (TextView) this.ajf.findViewById(R.id.game_share_entry_sina);
        this.juU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bku = a.this.bku();
                if (bku != null && a.this.juW != null) {
                    a.this.juW.D(bku);
                }
            }
        });
        this.juV = (TextView) this.ajf.findViewById(R.id.game_share_cancel);
        this.juV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.juW != null) {
                    a.this.juW.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.ajf;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.juH.setText(sb);
        if (this.juX == null) {
            d.mx().a(gameShareData.gameIconUrl, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.ajf.getContext(), R.string.share_failed);
                        if (a.this.juW != null) {
                            a.this.juW.onCancel();
                        }
                    }
                    a.this.juX = new BlurDrawable(a.this.ajf.getContext());
                    a.this.juX.init(2, 4, aVar.getRawBitmap());
                    a.this.juX.drawBlur();
                    a.this.juu.setImageBitmap(a.this.juX.getBlurredBitmap());
                }
            }, null);
        }
        this.hXE.startLoad(gameShareData.headBgUrl, 10, false);
        this.juQ.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.jux.startLoad(gameShareData.gameIconUrl, 10, false);
            this.juy.setText(gameShareData.gameName);
            this.juz.setText(gameShareData.gameDescription);
            this.juA.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.juG);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.juI.startLoad(gameShareData.userPortrait, 12, false);
            this.eGI.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.juO);
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

    public Bitmap bku() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int cGV() {
        return this.hjB.getBottom();
    }

    public void onDestroy() {
        if (this.juX != null) {
            this.juX.onDestroy();
            this.juX = null;
        }
    }
}

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
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import java.text.DecimalFormat;
/* loaded from: classes7.dex */
public class a {
    private TextView bXF;
    private FrameLayout coW;
    private LinearLayout eKa;
    private LinearLayout foL;
    private TbImageView fub;
    private RadioButton gAA;
    private RadioButton[] gAB;
    private TextView gAC;
    private TbImageView gAD;
    private RadioButton gAE;
    private RadioButton gAF;
    private RadioButton gAG;
    private RadioButton gAH;
    private RadioButton gAI;
    private RadioButton[] gAJ;
    private TextView gAK;
    private TbImageView gAL;
    private TextView gAM;
    private TextView gAN;
    private TextView gAO;
    private TextView gAP;
    private TextView gAQ;
    private InterfaceC0500a gAR;
    private BlurDrawable gAS;
    private ImageView gAp;
    private FrameLayout gAq;
    private ColumnLayout gAr;
    private TbImageView gAs;
    private TextView gAt;
    private TextView gAu;
    private TextView gAv;
    private RadioButton gAw;
    private RadioButton gAx;
    private RadioButton gAy;
    private RadioButton gAz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0500a {
        void onCancel();

        void t(Bitmap bitmap);

        void u(Bitmap bitmap);

        void v(Bitmap bitmap);

        void w(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0500a interfaceC0500a) {
        this.gAR = interfaceC0500a;
        this.coW = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.coW.findViewById(R.id.game_share_content_layout);
        this.gAp = (ImageView) this.coW.findViewById(R.id.game_share_content_bg_view);
        this.eKa = (LinearLayout) this.coW.findViewById(R.id.game_share_card_layout);
        this.gAq = (FrameLayout) this.coW.findViewById(R.id.game_share_header_root);
        this.gAr = (ColumnLayout) this.coW.findViewById(R.id.game_share_header_layout);
        this.fub = (TbImageView) this.coW.findViewById(R.id.game_share_header_bg_view);
        this.fub.setVisibility(4);
        this.fub.setDefaultBg(new ColorDrawable(this.coW.getResources().getColor(R.color.transparent)));
        this.fub.setDrawerType(1);
        this.fub.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.fub.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.fub.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gAs = (TbImageView) this.coW.findViewById(R.id.game_share_game_icon);
        this.gAs.setDrawerType(1);
        this.gAs.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.gAt = (TextView) this.coW.findViewById(R.id.game_share_game_name);
        this.gAu = (TextView) this.coW.findViewById(R.id.game_share_game_description);
        this.gAv = (TextView) this.coW.findViewById(R.id.game_share_game_score);
        this.gAw = (RadioButton) this.coW.findViewById(R.id.game_share_score_grade_1);
        this.gAx = (RadioButton) this.coW.findViewById(R.id.game_share_score_grade_2);
        this.gAy = (RadioButton) this.coW.findViewById(R.id.game_share_score_grade_3);
        this.gAz = (RadioButton) this.coW.findViewById(R.id.game_share_score_grade_4);
        this.gAA = (RadioButton) this.coW.findViewById(R.id.game_share_score_grade_5);
        this.gAB = new RadioButton[]{this.gAw, this.gAx, this.gAy, this.gAz, this.gAA};
        this.gAC = (TextView) this.coW.findViewById(R.id.game_share_comment);
        this.gAD = (TbImageView) this.coW.findViewById(R.id.game_share_user_protrait);
        this.gAD.setDrawerType(1);
        this.gAD.setIsRound(true);
        this.bXF = (TextView) this.coW.findViewById(R.id.game_share_user_name);
        this.gAE = (RadioButton) this.coW.findViewById(R.id.game_share_user_score_grade_1);
        this.gAF = (RadioButton) this.coW.findViewById(R.id.game_share_user_score_grade_2);
        this.gAG = (RadioButton) this.coW.findViewById(R.id.game_share_user_score_grade_3);
        this.gAH = (RadioButton) this.coW.findViewById(R.id.game_share_user_score_grade_4);
        this.gAI = (RadioButton) this.coW.findViewById(R.id.game_share_user_score_grade_5);
        this.gAJ = new RadioButton[]{this.gAE, this.gAF, this.gAG, this.gAH, this.gAI};
        this.gAK = (TextView) this.coW.findViewById(R.id.game_share_qr_txt);
        this.gAL = (TbImageView) this.coW.findViewById(R.id.game_share_qr_img);
        this.foL = (LinearLayout) this.coW.findViewById(R.id.game_share_entry_layout);
        this.gAM = (TextView) this.coW.findViewById(R.id.game_share_entry_weixin);
        this.gAM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bGs = a.this.bGs();
                if (bGs != null && a.this.gAR != null) {
                    a.this.gAR.t(bGs);
                }
            }
        });
        this.gAN = (TextView) this.coW.findViewById(R.id.game_share_entry_wxfriends);
        this.gAN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bGs = a.this.bGs();
                if (bGs != null && a.this.gAR != null) {
                    a.this.gAR.u(bGs);
                }
            }
        });
        this.gAO = (TextView) this.coW.findViewById(R.id.game_share_entry_qq);
        this.gAO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bGs = a.this.bGs();
                if (bGs != null && a.this.gAR != null) {
                    a.this.gAR.v(bGs);
                }
            }
        });
        this.gAP = (TextView) this.coW.findViewById(R.id.game_share_entry_sina);
        this.gAP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bGs = a.this.bGs();
                if (bGs != null && a.this.gAR != null) {
                    a.this.gAR.w(bGs);
                }
            }
        });
        this.gAQ = (TextView) this.coW.findViewById(R.id.game_share_cancel);
        this.gAQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gAR != null) {
                    a.this.gAR.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.coW;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.gAC.setText(sb);
        if (this.gAS == null) {
            c.gr().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.coW.getContext(), (int) R.string.share_failed);
                        if (a.this.gAR != null) {
                            a.this.gAR.onCancel();
                        }
                    }
                    a.this.gAS = new BlurDrawable(a.this.coW.getContext());
                    a.this.gAS.init(2, 4, aVar.getRawBitmap());
                    a.this.gAS.drawBlur();
                    a.this.gAp.setImageBitmap(a.this.gAS.getBlurredBitmap());
                }
            }, null);
        }
        this.fub.startLoad(gameShareData.headBgUrl, 10, false);
        this.gAL.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.gAs.startLoad(gameShareData.gameIconUrl, 10, false);
            this.gAt.setText(gameShareData.gameName);
            this.gAu.setText(gameShareData.gameDescription);
            this.gAv.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.gAB);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.gAD.startLoad(gameShareData.userPortrait, 12, false);
            this.bXF.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.gAJ);
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

    public Bitmap bGs() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bGt() {
        return this.eKa.getBottom();
    }

    public void onDestroy() {
        if (this.gAS != null) {
            this.gAS.onDestroy();
            this.gAS = null;
        }
    }
}

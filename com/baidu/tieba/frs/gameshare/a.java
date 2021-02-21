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
    private FrameLayout aiT;
    private TextView eIO;
    private LinearLayout hWC;
    private LinearLayout hoc;
    private TbImageView icm;
    private RadioButton[] jAA;
    private TextView jAB;
    private TbImageView jAC;
    private RadioButton jAD;
    private RadioButton jAE;
    private RadioButton jAF;
    private RadioButton jAG;
    private RadioButton jAH;
    private RadioButton[] jAI;
    private TextView jAJ;
    private TbImageView jAK;
    private TextView jAL;
    private TextView jAM;
    private TextView jAN;
    private TextView jAO;
    private TextView jAP;
    private InterfaceC0730a jAQ;
    private BlurDrawable jAR;
    private ImageView jAo;
    private FrameLayout jAp;
    private ColumnLayout jAq;
    private TbImageView jAr;
    private TextView jAs;
    private TextView jAt;
    private TextView jAu;
    private RadioButton jAv;
    private RadioButton jAw;
    private RadioButton jAx;
    private RadioButton jAy;
    private RadioButton jAz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0730a {
        void A(Bitmap bitmap);

        void B(Bitmap bitmap);

        void C(Bitmap bitmap);

        void onCancel();

        void z(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0730a interfaceC0730a) {
        this.jAQ = interfaceC0730a;
        this.aiT = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.aiT.findViewById(R.id.game_share_content_layout);
        this.jAo = (ImageView) this.aiT.findViewById(R.id.game_share_content_bg_view);
        this.hoc = (LinearLayout) this.aiT.findViewById(R.id.game_share_card_layout);
        this.jAp = (FrameLayout) this.aiT.findViewById(R.id.game_share_header_root);
        this.jAq = (ColumnLayout) this.aiT.findViewById(R.id.game_share_header_layout);
        this.icm = (TbImageView) this.aiT.findViewById(R.id.game_share_header_bg_view);
        this.icm.setVisibility(4);
        this.icm.setDefaultBg(new ColorDrawable(this.aiT.getResources().getColor(R.color.transparent)));
        this.icm.setDrawerType(1);
        this.icm.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.icm.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.icm.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.jAr = (TbImageView) this.aiT.findViewById(R.id.game_share_game_icon);
        this.jAr.setDrawerType(1);
        this.jAr.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.jAs = (TextView) this.aiT.findViewById(R.id.game_share_game_name);
        this.jAt = (TextView) this.aiT.findViewById(R.id.game_share_game_description);
        this.jAu = (TextView) this.aiT.findViewById(R.id.game_share_game_score);
        this.jAv = (RadioButton) this.aiT.findViewById(R.id.game_share_score_grade_1);
        this.jAw = (RadioButton) this.aiT.findViewById(R.id.game_share_score_grade_2);
        this.jAx = (RadioButton) this.aiT.findViewById(R.id.game_share_score_grade_3);
        this.jAy = (RadioButton) this.aiT.findViewById(R.id.game_share_score_grade_4);
        this.jAz = (RadioButton) this.aiT.findViewById(R.id.game_share_score_grade_5);
        this.jAA = new RadioButton[]{this.jAv, this.jAw, this.jAx, this.jAy, this.jAz};
        this.jAB = (TextView) this.aiT.findViewById(R.id.game_share_comment);
        this.jAC = (TbImageView) this.aiT.findViewById(R.id.game_share_user_protrait);
        this.jAC.setDrawerType(1);
        this.jAC.setIsRound(true);
        this.eIO = (TextView) this.aiT.findViewById(R.id.game_share_user_name);
        this.jAD = (RadioButton) this.aiT.findViewById(R.id.game_share_user_score_grade_1);
        this.jAE = (RadioButton) this.aiT.findViewById(R.id.game_share_user_score_grade_2);
        this.jAF = (RadioButton) this.aiT.findViewById(R.id.game_share_user_score_grade_3);
        this.jAG = (RadioButton) this.aiT.findViewById(R.id.game_share_user_score_grade_4);
        this.jAH = (RadioButton) this.aiT.findViewById(R.id.game_share_user_score_grade_5);
        this.jAI = new RadioButton[]{this.jAD, this.jAE, this.jAF, this.jAG, this.jAH};
        this.jAJ = (TextView) this.aiT.findViewById(R.id.game_share_qr_txt);
        this.jAK = (TbImageView) this.aiT.findViewById(R.id.game_share_qr_img);
        this.hWC = (LinearLayout) this.aiT.findViewById(R.id.game_share_entry_layout);
        this.jAL = (TextView) this.aiT.findViewById(R.id.game_share_entry_weixin);
        this.jAL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bkM = a.this.bkM();
                if (bkM != null && a.this.jAQ != null) {
                    a.this.jAQ.z(bkM);
                }
            }
        });
        this.jAM = (TextView) this.aiT.findViewById(R.id.game_share_entry_wxfriends);
        this.jAM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bkM = a.this.bkM();
                if (bkM != null && a.this.jAQ != null) {
                    a.this.jAQ.A(bkM);
                }
            }
        });
        this.jAN = (TextView) this.aiT.findViewById(R.id.game_share_entry_qq);
        this.jAN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bkM = a.this.bkM();
                if (bkM != null && a.this.jAQ != null) {
                    a.this.jAQ.B(bkM);
                }
            }
        });
        this.jAO = (TextView) this.aiT.findViewById(R.id.game_share_entry_sina);
        this.jAO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bkM = a.this.bkM();
                if (bkM != null && a.this.jAQ != null) {
                    a.this.jAQ.C(bkM);
                }
            }
        });
        this.jAP = (TextView) this.aiT.findViewById(R.id.game_share_cancel);
        this.jAP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jAQ != null) {
                    a.this.jAQ.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.aiT;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.jAB.setText(sb);
        if (this.jAR == null) {
            d.mw().a(gameShareData.gameIconUrl, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.aiT.getContext(), R.string.share_failed);
                        if (a.this.jAQ != null) {
                            a.this.jAQ.onCancel();
                        }
                    }
                    a.this.jAR = new BlurDrawable(a.this.aiT.getContext());
                    a.this.jAR.init(2, 4, aVar.getRawBitmap());
                    a.this.jAR.drawBlur();
                    a.this.jAo.setImageBitmap(a.this.jAR.getBlurredBitmap());
                }
            }, null);
        }
        this.icm.startLoad(gameShareData.headBgUrl, 10, false);
        this.jAK.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.jAr.startLoad(gameShareData.gameIconUrl, 10, false);
            this.jAs.setText(gameShareData.gameName);
            this.jAt.setText(gameShareData.gameDescription);
            this.jAu.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.jAA);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.jAC.startLoad(gameShareData.userPortrait, 12, false);
            this.eIO.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.jAI);
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

    public Bitmap bkM() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int cIp() {
        return this.hoc.getBottom();
    }

    public void onDestroy() {
        if (this.jAR != null) {
            this.jAR.onDestroy();
            this.jAR = null;
        }
    }
}

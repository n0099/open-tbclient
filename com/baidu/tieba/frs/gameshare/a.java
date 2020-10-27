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
/* loaded from: classes22.dex */
public class a {
    private FrameLayout aii;
    private TextView eqE;
    private LinearLayout gNa;
    private TbImageView hAC;
    private LinearLayout hvd;
    private RadioButton iSA;
    private RadioButton iSB;
    private RadioButton iSC;
    private RadioButton[] iSD;
    private TextView iSE;
    private TbImageView iSF;
    private RadioButton iSG;
    private RadioButton iSH;
    private RadioButton iSI;
    private RadioButton iSJ;
    private RadioButton iSK;
    private RadioButton[] iSL;
    private TextView iSM;
    private TbImageView iSN;
    private TextView iSO;
    private TextView iSP;
    private TextView iSQ;
    private TextView iSR;
    private TextView iSS;
    private InterfaceC0715a iST;
    private BlurDrawable iSU;
    private ImageView iSr;
    private FrameLayout iSs;
    private ColumnLayout iSt;
    private TbImageView iSu;
    private TextView iSv;
    private TextView iSw;
    private TextView iSx;
    private RadioButton iSy;
    private RadioButton iSz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0715a {
        void A(Bitmap bitmap);

        void B(Bitmap bitmap);

        void C(Bitmap bitmap);

        void onCancel();

        void z(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0715a interfaceC0715a) {
        this.iST = interfaceC0715a;
        this.aii = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.aii.findViewById(R.id.game_share_content_layout);
        this.iSr = (ImageView) this.aii.findViewById(R.id.game_share_content_bg_view);
        this.gNa = (LinearLayout) this.aii.findViewById(R.id.game_share_card_layout);
        this.iSs = (FrameLayout) this.aii.findViewById(R.id.game_share_header_root);
        this.iSt = (ColumnLayout) this.aii.findViewById(R.id.game_share_header_layout);
        this.hAC = (TbImageView) this.aii.findViewById(R.id.game_share_header_bg_view);
        this.hAC.setVisibility(4);
        this.hAC.setDefaultBg(new ColorDrawable(this.aii.getResources().getColor(R.color.transparent)));
        this.hAC.setDrawerType(1);
        this.hAC.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.hAC.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.hAC.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.iSu = (TbImageView) this.aii.findViewById(R.id.game_share_game_icon);
        this.iSu.setDrawerType(1);
        this.iSu.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iSv = (TextView) this.aii.findViewById(R.id.game_share_game_name);
        this.iSw = (TextView) this.aii.findViewById(R.id.game_share_game_description);
        this.iSx = (TextView) this.aii.findViewById(R.id.game_share_game_score);
        this.iSy = (RadioButton) this.aii.findViewById(R.id.game_share_score_grade_1);
        this.iSz = (RadioButton) this.aii.findViewById(R.id.game_share_score_grade_2);
        this.iSA = (RadioButton) this.aii.findViewById(R.id.game_share_score_grade_3);
        this.iSB = (RadioButton) this.aii.findViewById(R.id.game_share_score_grade_4);
        this.iSC = (RadioButton) this.aii.findViewById(R.id.game_share_score_grade_5);
        this.iSD = new RadioButton[]{this.iSy, this.iSz, this.iSA, this.iSB, this.iSC};
        this.iSE = (TextView) this.aii.findViewById(R.id.game_share_comment);
        this.iSF = (TbImageView) this.aii.findViewById(R.id.game_share_user_protrait);
        this.iSF.setDrawerType(1);
        this.iSF.setIsRound(true);
        this.eqE = (TextView) this.aii.findViewById(R.id.game_share_user_name);
        this.iSG = (RadioButton) this.aii.findViewById(R.id.game_share_user_score_grade_1);
        this.iSH = (RadioButton) this.aii.findViewById(R.id.game_share_user_score_grade_2);
        this.iSI = (RadioButton) this.aii.findViewById(R.id.game_share_user_score_grade_3);
        this.iSJ = (RadioButton) this.aii.findViewById(R.id.game_share_user_score_grade_4);
        this.iSK = (RadioButton) this.aii.findViewById(R.id.game_share_user_score_grade_5);
        this.iSL = new RadioButton[]{this.iSG, this.iSH, this.iSI, this.iSJ, this.iSK};
        this.iSM = (TextView) this.aii.findViewById(R.id.game_share_qr_txt);
        this.iSN = (TbImageView) this.aii.findViewById(R.id.game_share_qr_img);
        this.hvd = (LinearLayout) this.aii.findViewById(R.id.game_share_entry_layout);
        this.iSO = (TextView) this.aii.findViewById(R.id.game_share_entry_weixin);
        this.iSO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bha = a.this.bha();
                if (bha != null && a.this.iST != null) {
                    a.this.iST.z(bha);
                }
            }
        });
        this.iSP = (TextView) this.aii.findViewById(R.id.game_share_entry_wxfriends);
        this.iSP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bha = a.this.bha();
                if (bha != null && a.this.iST != null) {
                    a.this.iST.A(bha);
                }
            }
        });
        this.iSQ = (TextView) this.aii.findViewById(R.id.game_share_entry_qq);
        this.iSQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bha = a.this.bha();
                if (bha != null && a.this.iST != null) {
                    a.this.iST.B(bha);
                }
            }
        });
        this.iSR = (TextView) this.aii.findViewById(R.id.game_share_entry_sina);
        this.iSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bha = a.this.bha();
                if (bha != null && a.this.iST != null) {
                    a.this.iST.C(bha);
                }
            }
        });
        this.iSS = (TextView) this.aii.findViewById(R.id.game_share_cancel);
        this.iSS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iST != null) {
                    a.this.iST.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.aii;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.iSE.setText(sb);
        if (this.iSU == null) {
            c.mS().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.aii.getContext(), (int) R.string.share_failed);
                        if (a.this.iST != null) {
                            a.this.iST.onCancel();
                        }
                    }
                    a.this.iSU = new BlurDrawable(a.this.aii.getContext());
                    a.this.iSU.init(2, 4, aVar.getRawBitmap());
                    a.this.iSU.drawBlur();
                    a.this.iSr.setImageBitmap(a.this.iSU.getBlurredBitmap());
                }
            }, null);
        }
        this.hAC.startLoad(gameShareData.headBgUrl, 10, false);
        this.iSN.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.iSu.startLoad(gameShareData.gameIconUrl, 10, false);
            this.iSv.setText(gameShareData.gameName);
            this.iSw.setText(gameShareData.gameDescription);
            this.iSx.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.iSD);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.iSF.startLoad(gameShareData.userPortrait, 12, false);
            this.eqE.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.iSL);
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

    public Bitmap bha() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int cAv() {
        return this.gNa.getBottom();
    }

    public void onDestroy() {
        if (this.iSU != null) {
            this.iSU.onDestroy();
            this.iSU = null;
        }
    }
}

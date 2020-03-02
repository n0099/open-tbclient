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
/* loaded from: classes9.dex */
public class a {
    private TextView cbK;
    private FrameLayout csY;
    private LinearLayout eNU;
    private LinearLayout frq;
    private TbImageView fwD;
    private RadioButton gCA;
    private RadioButton gCB;
    private RadioButton gCC;
    private RadioButton[] gCD;
    private TextView gCE;
    private TbImageView gCF;
    private RadioButton gCG;
    private RadioButton gCH;
    private RadioButton gCI;
    private RadioButton gCJ;
    private RadioButton gCK;
    private RadioButton[] gCL;
    private TextView gCM;
    private TbImageView gCN;
    private TextView gCO;
    private TextView gCP;
    private TextView gCQ;
    private TextView gCR;
    private TextView gCS;
    private InterfaceC0507a gCT;
    private BlurDrawable gCU;
    private ImageView gCr;
    private FrameLayout gCs;
    private ColumnLayout gCt;
    private TbImageView gCu;
    private TextView gCv;
    private TextView gCw;
    private TextView gCx;
    private RadioButton gCy;
    private RadioButton gCz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0507a {
        void onCancel();

        void t(Bitmap bitmap);

        void u(Bitmap bitmap);

        void v(Bitmap bitmap);

        void w(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0507a interfaceC0507a) {
        this.gCT = interfaceC0507a;
        this.csY = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.csY.findViewById(R.id.game_share_content_layout);
        this.gCr = (ImageView) this.csY.findViewById(R.id.game_share_content_bg_view);
        this.eNU = (LinearLayout) this.csY.findViewById(R.id.game_share_card_layout);
        this.gCs = (FrameLayout) this.csY.findViewById(R.id.game_share_header_root);
        this.gCt = (ColumnLayout) this.csY.findViewById(R.id.game_share_header_layout);
        this.fwD = (TbImageView) this.csY.findViewById(R.id.game_share_header_bg_view);
        this.fwD.setVisibility(4);
        this.fwD.setDefaultBg(new ColorDrawable(this.csY.getResources().getColor(R.color.transparent)));
        this.fwD.setDrawerType(1);
        this.fwD.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.fwD.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.fwD.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gCu = (TbImageView) this.csY.findViewById(R.id.game_share_game_icon);
        this.gCu.setDrawerType(1);
        this.gCu.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.gCv = (TextView) this.csY.findViewById(R.id.game_share_game_name);
        this.gCw = (TextView) this.csY.findViewById(R.id.game_share_game_description);
        this.gCx = (TextView) this.csY.findViewById(R.id.game_share_game_score);
        this.gCy = (RadioButton) this.csY.findViewById(R.id.game_share_score_grade_1);
        this.gCz = (RadioButton) this.csY.findViewById(R.id.game_share_score_grade_2);
        this.gCA = (RadioButton) this.csY.findViewById(R.id.game_share_score_grade_3);
        this.gCB = (RadioButton) this.csY.findViewById(R.id.game_share_score_grade_4);
        this.gCC = (RadioButton) this.csY.findViewById(R.id.game_share_score_grade_5);
        this.gCD = new RadioButton[]{this.gCy, this.gCz, this.gCA, this.gCB, this.gCC};
        this.gCE = (TextView) this.csY.findViewById(R.id.game_share_comment);
        this.gCF = (TbImageView) this.csY.findViewById(R.id.game_share_user_protrait);
        this.gCF.setDrawerType(1);
        this.gCF.setIsRound(true);
        this.cbK = (TextView) this.csY.findViewById(R.id.game_share_user_name);
        this.gCG = (RadioButton) this.csY.findViewById(R.id.game_share_user_score_grade_1);
        this.gCH = (RadioButton) this.csY.findViewById(R.id.game_share_user_score_grade_2);
        this.gCI = (RadioButton) this.csY.findViewById(R.id.game_share_user_score_grade_3);
        this.gCJ = (RadioButton) this.csY.findViewById(R.id.game_share_user_score_grade_4);
        this.gCK = (RadioButton) this.csY.findViewById(R.id.game_share_user_score_grade_5);
        this.gCL = new RadioButton[]{this.gCG, this.gCH, this.gCI, this.gCJ, this.gCK};
        this.gCM = (TextView) this.csY.findViewById(R.id.game_share_qr_txt);
        this.gCN = (TbImageView) this.csY.findViewById(R.id.game_share_qr_img);
        this.frq = (LinearLayout) this.csY.findViewById(R.id.game_share_entry_layout);
        this.gCO = (TextView) this.csY.findViewById(R.id.game_share_entry_weixin);
        this.gCO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bHW = a.this.bHW();
                if (bHW != null && a.this.gCT != null) {
                    a.this.gCT.t(bHW);
                }
            }
        });
        this.gCP = (TextView) this.csY.findViewById(R.id.game_share_entry_wxfriends);
        this.gCP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bHW = a.this.bHW();
                if (bHW != null && a.this.gCT != null) {
                    a.this.gCT.u(bHW);
                }
            }
        });
        this.gCQ = (TextView) this.csY.findViewById(R.id.game_share_entry_qq);
        this.gCQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bHW = a.this.bHW();
                if (bHW != null && a.this.gCT != null) {
                    a.this.gCT.v(bHW);
                }
            }
        });
        this.gCR = (TextView) this.csY.findViewById(R.id.game_share_entry_sina);
        this.gCR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bHW = a.this.bHW();
                if (bHW != null && a.this.gCT != null) {
                    a.this.gCT.w(bHW);
                }
            }
        });
        this.gCS = (TextView) this.csY.findViewById(R.id.game_share_cancel);
        this.gCS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gCT != null) {
                    a.this.gCT.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.csY;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.gCE.setText(sb);
        if (this.gCU == null) {
            c.gr().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.csY.getContext(), (int) R.string.share_failed);
                        if (a.this.gCT != null) {
                            a.this.gCT.onCancel();
                        }
                    }
                    a.this.gCU = new BlurDrawable(a.this.csY.getContext());
                    a.this.gCU.init(2, 4, aVar.getRawBitmap());
                    a.this.gCU.drawBlur();
                    a.this.gCr.setImageBitmap(a.this.gCU.getBlurredBitmap());
                }
            }, null);
        }
        this.fwD.startLoad(gameShareData.headBgUrl, 10, false);
        this.gCN.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.gCu.startLoad(gameShareData.gameIconUrl, 10, false);
            this.gCv.setText(gameShareData.gameName);
            this.gCw.setText(gameShareData.gameDescription);
            this.gCx.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.gCD);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.gCF.startLoad(gameShareData.userPortrait, 12, false);
            this.cbK.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.gCL);
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

    public Bitmap bHW() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bHX() {
        return this.eNU.getBottom();
    }

    public void onDestroy() {
        if (this.gCU != null) {
            this.gCU.onDestroy();
            this.gCU = null;
        }
    }
}

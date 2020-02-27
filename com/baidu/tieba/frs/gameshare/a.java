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
    private TextView cbJ;
    private FrameLayout csX;
    private LinearLayout eNT;
    private LinearLayout frp;
    private TbImageView fwC;
    private RadioButton gCA;
    private RadioButton[] gCB;
    private TextView gCC;
    private TbImageView gCD;
    private RadioButton gCE;
    private RadioButton gCF;
    private RadioButton gCG;
    private RadioButton gCH;
    private RadioButton gCI;
    private RadioButton[] gCJ;
    private TextView gCK;
    private TbImageView gCL;
    private TextView gCM;
    private TextView gCN;
    private TextView gCO;
    private TextView gCP;
    private TextView gCQ;
    private InterfaceC0507a gCR;
    private BlurDrawable gCS;
    private ImageView gCp;
    private FrameLayout gCq;
    private ColumnLayout gCr;
    private TbImageView gCs;
    private TextView gCt;
    private TextView gCu;
    private TextView gCv;
    private RadioButton gCw;
    private RadioButton gCx;
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
        this.gCR = interfaceC0507a;
        this.csX = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.csX.findViewById(R.id.game_share_content_layout);
        this.gCp = (ImageView) this.csX.findViewById(R.id.game_share_content_bg_view);
        this.eNT = (LinearLayout) this.csX.findViewById(R.id.game_share_card_layout);
        this.gCq = (FrameLayout) this.csX.findViewById(R.id.game_share_header_root);
        this.gCr = (ColumnLayout) this.csX.findViewById(R.id.game_share_header_layout);
        this.fwC = (TbImageView) this.csX.findViewById(R.id.game_share_header_bg_view);
        this.fwC.setVisibility(4);
        this.fwC.setDefaultBg(new ColorDrawable(this.csX.getResources().getColor(R.color.transparent)));
        this.fwC.setDrawerType(1);
        this.fwC.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.fwC.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.fwC.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gCs = (TbImageView) this.csX.findViewById(R.id.game_share_game_icon);
        this.gCs.setDrawerType(1);
        this.gCs.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.gCt = (TextView) this.csX.findViewById(R.id.game_share_game_name);
        this.gCu = (TextView) this.csX.findViewById(R.id.game_share_game_description);
        this.gCv = (TextView) this.csX.findViewById(R.id.game_share_game_score);
        this.gCw = (RadioButton) this.csX.findViewById(R.id.game_share_score_grade_1);
        this.gCx = (RadioButton) this.csX.findViewById(R.id.game_share_score_grade_2);
        this.gCy = (RadioButton) this.csX.findViewById(R.id.game_share_score_grade_3);
        this.gCz = (RadioButton) this.csX.findViewById(R.id.game_share_score_grade_4);
        this.gCA = (RadioButton) this.csX.findViewById(R.id.game_share_score_grade_5);
        this.gCB = new RadioButton[]{this.gCw, this.gCx, this.gCy, this.gCz, this.gCA};
        this.gCC = (TextView) this.csX.findViewById(R.id.game_share_comment);
        this.gCD = (TbImageView) this.csX.findViewById(R.id.game_share_user_protrait);
        this.gCD.setDrawerType(1);
        this.gCD.setIsRound(true);
        this.cbJ = (TextView) this.csX.findViewById(R.id.game_share_user_name);
        this.gCE = (RadioButton) this.csX.findViewById(R.id.game_share_user_score_grade_1);
        this.gCF = (RadioButton) this.csX.findViewById(R.id.game_share_user_score_grade_2);
        this.gCG = (RadioButton) this.csX.findViewById(R.id.game_share_user_score_grade_3);
        this.gCH = (RadioButton) this.csX.findViewById(R.id.game_share_user_score_grade_4);
        this.gCI = (RadioButton) this.csX.findViewById(R.id.game_share_user_score_grade_5);
        this.gCJ = new RadioButton[]{this.gCE, this.gCF, this.gCG, this.gCH, this.gCI};
        this.gCK = (TextView) this.csX.findViewById(R.id.game_share_qr_txt);
        this.gCL = (TbImageView) this.csX.findViewById(R.id.game_share_qr_img);
        this.frp = (LinearLayout) this.csX.findViewById(R.id.game_share_entry_layout);
        this.gCM = (TextView) this.csX.findViewById(R.id.game_share_entry_weixin);
        this.gCM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bHU = a.this.bHU();
                if (bHU != null && a.this.gCR != null) {
                    a.this.gCR.t(bHU);
                }
            }
        });
        this.gCN = (TextView) this.csX.findViewById(R.id.game_share_entry_wxfriends);
        this.gCN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bHU = a.this.bHU();
                if (bHU != null && a.this.gCR != null) {
                    a.this.gCR.u(bHU);
                }
            }
        });
        this.gCO = (TextView) this.csX.findViewById(R.id.game_share_entry_qq);
        this.gCO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bHU = a.this.bHU();
                if (bHU != null && a.this.gCR != null) {
                    a.this.gCR.v(bHU);
                }
            }
        });
        this.gCP = (TextView) this.csX.findViewById(R.id.game_share_entry_sina);
        this.gCP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bHU = a.this.bHU();
                if (bHU != null && a.this.gCR != null) {
                    a.this.gCR.w(bHU);
                }
            }
        });
        this.gCQ = (TextView) this.csX.findViewById(R.id.game_share_cancel);
        this.gCQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gCR != null) {
                    a.this.gCR.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.csX;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.gCC.setText(sb);
        if (this.gCS == null) {
            c.gr().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.csX.getContext(), (int) R.string.share_failed);
                        if (a.this.gCR != null) {
                            a.this.gCR.onCancel();
                        }
                    }
                    a.this.gCS = new BlurDrawable(a.this.csX.getContext());
                    a.this.gCS.init(2, 4, aVar.getRawBitmap());
                    a.this.gCS.drawBlur();
                    a.this.gCp.setImageBitmap(a.this.gCS.getBlurredBitmap());
                }
            }, null);
        }
        this.fwC.startLoad(gameShareData.headBgUrl, 10, false);
        this.gCL.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.gCs.startLoad(gameShareData.gameIconUrl, 10, false);
            this.gCt.setText(gameShareData.gameName);
            this.gCu.setText(gameShareData.gameDescription);
            this.gCv.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.gCB);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.gCD.startLoad(gameShareData.userPortrait, 12, false);
            this.cbJ.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.gCJ);
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

    public Bitmap bHU() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bHV() {
        return this.eNT.getBottom();
    }

    public void onDestroy() {
        if (this.gCS != null) {
            this.gCS.onDestroy();
            this.gCS = null;
        }
    }
}

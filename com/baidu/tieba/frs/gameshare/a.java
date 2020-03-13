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
    private TextView cbL;
    private FrameLayout csZ;
    private LinearLayout eOh;
    private LinearLayout frE;
    private TbImageView fwQ;
    private ImageView gCD;
    private FrameLayout gCE;
    private ColumnLayout gCF;
    private TbImageView gCG;
    private TextView gCH;
    private TextView gCI;
    private TextView gCJ;
    private RadioButton gCK;
    private RadioButton gCL;
    private RadioButton gCM;
    private RadioButton gCN;
    private RadioButton gCO;
    private RadioButton[] gCP;
    private TextView gCQ;
    private TbImageView gCR;
    private RadioButton gCS;
    private RadioButton gCT;
    private RadioButton gCU;
    private RadioButton gCV;
    private RadioButton gCW;
    private RadioButton[] gCX;
    private TextView gCY;
    private TbImageView gCZ;
    private TextView gDa;
    private TextView gDb;
    private TextView gDc;
    private TextView gDd;
    private TextView gDe;
    private InterfaceC0507a gDf;
    private BlurDrawable gDg;
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
        this.gDf = interfaceC0507a;
        this.csZ = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.csZ.findViewById(R.id.game_share_content_layout);
        this.gCD = (ImageView) this.csZ.findViewById(R.id.game_share_content_bg_view);
        this.eOh = (LinearLayout) this.csZ.findViewById(R.id.game_share_card_layout);
        this.gCE = (FrameLayout) this.csZ.findViewById(R.id.game_share_header_root);
        this.gCF = (ColumnLayout) this.csZ.findViewById(R.id.game_share_header_layout);
        this.fwQ = (TbImageView) this.csZ.findViewById(R.id.game_share_header_bg_view);
        this.fwQ.setVisibility(4);
        this.fwQ.setDefaultBg(new ColorDrawable(this.csZ.getResources().getColor(R.color.transparent)));
        this.fwQ.setDrawerType(1);
        this.fwQ.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.fwQ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.fwQ.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gCG = (TbImageView) this.csZ.findViewById(R.id.game_share_game_icon);
        this.gCG.setDrawerType(1);
        this.gCG.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.gCH = (TextView) this.csZ.findViewById(R.id.game_share_game_name);
        this.gCI = (TextView) this.csZ.findViewById(R.id.game_share_game_description);
        this.gCJ = (TextView) this.csZ.findViewById(R.id.game_share_game_score);
        this.gCK = (RadioButton) this.csZ.findViewById(R.id.game_share_score_grade_1);
        this.gCL = (RadioButton) this.csZ.findViewById(R.id.game_share_score_grade_2);
        this.gCM = (RadioButton) this.csZ.findViewById(R.id.game_share_score_grade_3);
        this.gCN = (RadioButton) this.csZ.findViewById(R.id.game_share_score_grade_4);
        this.gCO = (RadioButton) this.csZ.findViewById(R.id.game_share_score_grade_5);
        this.gCP = new RadioButton[]{this.gCK, this.gCL, this.gCM, this.gCN, this.gCO};
        this.gCQ = (TextView) this.csZ.findViewById(R.id.game_share_comment);
        this.gCR = (TbImageView) this.csZ.findViewById(R.id.game_share_user_protrait);
        this.gCR.setDrawerType(1);
        this.gCR.setIsRound(true);
        this.cbL = (TextView) this.csZ.findViewById(R.id.game_share_user_name);
        this.gCS = (RadioButton) this.csZ.findViewById(R.id.game_share_user_score_grade_1);
        this.gCT = (RadioButton) this.csZ.findViewById(R.id.game_share_user_score_grade_2);
        this.gCU = (RadioButton) this.csZ.findViewById(R.id.game_share_user_score_grade_3);
        this.gCV = (RadioButton) this.csZ.findViewById(R.id.game_share_user_score_grade_4);
        this.gCW = (RadioButton) this.csZ.findViewById(R.id.game_share_user_score_grade_5);
        this.gCX = new RadioButton[]{this.gCS, this.gCT, this.gCU, this.gCV, this.gCW};
        this.gCY = (TextView) this.csZ.findViewById(R.id.game_share_qr_txt);
        this.gCZ = (TbImageView) this.csZ.findViewById(R.id.game_share_qr_img);
        this.frE = (LinearLayout) this.csZ.findViewById(R.id.game_share_entry_layout);
        this.gDa = (TextView) this.csZ.findViewById(R.id.game_share_entry_weixin);
        this.gDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bHX = a.this.bHX();
                if (bHX != null && a.this.gDf != null) {
                    a.this.gDf.t(bHX);
                }
            }
        });
        this.gDb = (TextView) this.csZ.findViewById(R.id.game_share_entry_wxfriends);
        this.gDb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bHX = a.this.bHX();
                if (bHX != null && a.this.gDf != null) {
                    a.this.gDf.u(bHX);
                }
            }
        });
        this.gDc = (TextView) this.csZ.findViewById(R.id.game_share_entry_qq);
        this.gDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bHX = a.this.bHX();
                if (bHX != null && a.this.gDf != null) {
                    a.this.gDf.v(bHX);
                }
            }
        });
        this.gDd = (TextView) this.csZ.findViewById(R.id.game_share_entry_sina);
        this.gDd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bHX = a.this.bHX();
                if (bHX != null && a.this.gDf != null) {
                    a.this.gDf.w(bHX);
                }
            }
        });
        this.gDe = (TextView) this.csZ.findViewById(R.id.game_share_cancel);
        this.gDe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gDf != null) {
                    a.this.gDf.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.csZ;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.gCQ.setText(sb);
        if (this.gDg == null) {
            c.gr().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.csZ.getContext(), (int) R.string.share_failed);
                        if (a.this.gDf != null) {
                            a.this.gDf.onCancel();
                        }
                    }
                    a.this.gDg = new BlurDrawable(a.this.csZ.getContext());
                    a.this.gDg.init(2, 4, aVar.getRawBitmap());
                    a.this.gDg.drawBlur();
                    a.this.gCD.setImageBitmap(a.this.gDg.getBlurredBitmap());
                }
            }, null);
        }
        this.fwQ.startLoad(gameShareData.headBgUrl, 10, false);
        this.gCZ.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.gCG.startLoad(gameShareData.gameIconUrl, 10, false);
            this.gCH.setText(gameShareData.gameName);
            this.gCI.setText(gameShareData.gameDescription);
            this.gCJ.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.gCP);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.gCR.startLoad(gameShareData.userPortrait, 12, false);
            this.cbL.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.gCX);
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

    public Bitmap bHX() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bHY() {
        return this.eOh.getBottom();
    }

    public void onDestroy() {
        if (this.gDg != null) {
            this.gDg.onDestroy();
            this.gDg = null;
        }
    }
}

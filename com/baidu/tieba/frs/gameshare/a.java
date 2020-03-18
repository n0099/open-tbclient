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
    private TextView cbW;
    private FrameLayout ctk;
    private LinearLayout eOF;
    private LinearLayout fsd;
    private TbImageView fxw;
    private ImageView gDB;
    private FrameLayout gDC;
    private ColumnLayout gDD;
    private TbImageView gDE;
    private TextView gDF;
    private TextView gDG;
    private TextView gDH;
    private RadioButton gDI;
    private RadioButton gDJ;
    private RadioButton gDK;
    private RadioButton gDL;
    private RadioButton gDM;
    private RadioButton[] gDN;
    private TextView gDO;
    private TbImageView gDP;
    private RadioButton gDQ;
    private RadioButton gDR;
    private RadioButton gDS;
    private RadioButton gDT;
    private RadioButton gDU;
    private RadioButton[] gDV;
    private TextView gDW;
    private TbImageView gDX;
    private TextView gDY;
    private TextView gDZ;
    private TextView gEa;
    private TextView gEb;
    private TextView gEc;
    private InterfaceC0507a gEd;
    private BlurDrawable gEe;
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
        this.gEd = interfaceC0507a;
        this.ctk = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.ctk.findViewById(R.id.game_share_content_layout);
        this.gDB = (ImageView) this.ctk.findViewById(R.id.game_share_content_bg_view);
        this.eOF = (LinearLayout) this.ctk.findViewById(R.id.game_share_card_layout);
        this.gDC = (FrameLayout) this.ctk.findViewById(R.id.game_share_header_root);
        this.gDD = (ColumnLayout) this.ctk.findViewById(R.id.game_share_header_layout);
        this.fxw = (TbImageView) this.ctk.findViewById(R.id.game_share_header_bg_view);
        this.fxw.setVisibility(4);
        this.fxw.setDefaultBg(new ColorDrawable(this.ctk.getResources().getColor(R.color.transparent)));
        this.fxw.setDrawerType(1);
        this.fxw.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.fxw.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.fxw.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gDE = (TbImageView) this.ctk.findViewById(R.id.game_share_game_icon);
        this.gDE.setDrawerType(1);
        this.gDE.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.gDF = (TextView) this.ctk.findViewById(R.id.game_share_game_name);
        this.gDG = (TextView) this.ctk.findViewById(R.id.game_share_game_description);
        this.gDH = (TextView) this.ctk.findViewById(R.id.game_share_game_score);
        this.gDI = (RadioButton) this.ctk.findViewById(R.id.game_share_score_grade_1);
        this.gDJ = (RadioButton) this.ctk.findViewById(R.id.game_share_score_grade_2);
        this.gDK = (RadioButton) this.ctk.findViewById(R.id.game_share_score_grade_3);
        this.gDL = (RadioButton) this.ctk.findViewById(R.id.game_share_score_grade_4);
        this.gDM = (RadioButton) this.ctk.findViewById(R.id.game_share_score_grade_5);
        this.gDN = new RadioButton[]{this.gDI, this.gDJ, this.gDK, this.gDL, this.gDM};
        this.gDO = (TextView) this.ctk.findViewById(R.id.game_share_comment);
        this.gDP = (TbImageView) this.ctk.findViewById(R.id.game_share_user_protrait);
        this.gDP.setDrawerType(1);
        this.gDP.setIsRound(true);
        this.cbW = (TextView) this.ctk.findViewById(R.id.game_share_user_name);
        this.gDQ = (RadioButton) this.ctk.findViewById(R.id.game_share_user_score_grade_1);
        this.gDR = (RadioButton) this.ctk.findViewById(R.id.game_share_user_score_grade_2);
        this.gDS = (RadioButton) this.ctk.findViewById(R.id.game_share_user_score_grade_3);
        this.gDT = (RadioButton) this.ctk.findViewById(R.id.game_share_user_score_grade_4);
        this.gDU = (RadioButton) this.ctk.findViewById(R.id.game_share_user_score_grade_5);
        this.gDV = new RadioButton[]{this.gDQ, this.gDR, this.gDS, this.gDT, this.gDU};
        this.gDW = (TextView) this.ctk.findViewById(R.id.game_share_qr_txt);
        this.gDX = (TbImageView) this.ctk.findViewById(R.id.game_share_qr_img);
        this.fsd = (LinearLayout) this.ctk.findViewById(R.id.game_share_entry_layout);
        this.gDY = (TextView) this.ctk.findViewById(R.id.game_share_entry_weixin);
        this.gDY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bIj = a.this.bIj();
                if (bIj != null && a.this.gEd != null) {
                    a.this.gEd.t(bIj);
                }
            }
        });
        this.gDZ = (TextView) this.ctk.findViewById(R.id.game_share_entry_wxfriends);
        this.gDZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bIj = a.this.bIj();
                if (bIj != null && a.this.gEd != null) {
                    a.this.gEd.u(bIj);
                }
            }
        });
        this.gEa = (TextView) this.ctk.findViewById(R.id.game_share_entry_qq);
        this.gEa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bIj = a.this.bIj();
                if (bIj != null && a.this.gEd != null) {
                    a.this.gEd.v(bIj);
                }
            }
        });
        this.gEb = (TextView) this.ctk.findViewById(R.id.game_share_entry_sina);
        this.gEb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bIj = a.this.bIj();
                if (bIj != null && a.this.gEd != null) {
                    a.this.gEd.w(bIj);
                }
            }
        });
        this.gEc = (TextView) this.ctk.findViewById(R.id.game_share_cancel);
        this.gEc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gEd != null) {
                    a.this.gEd.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.ctk;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.gDO.setText(sb);
        if (this.gEe == null) {
            c.gr().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.ctk.getContext(), (int) R.string.share_failed);
                        if (a.this.gEd != null) {
                            a.this.gEd.onCancel();
                        }
                    }
                    a.this.gEe = new BlurDrawable(a.this.ctk.getContext());
                    a.this.gEe.init(2, 4, aVar.getRawBitmap());
                    a.this.gEe.drawBlur();
                    a.this.gDB.setImageBitmap(a.this.gEe.getBlurredBitmap());
                }
            }, null);
        }
        this.fxw.startLoad(gameShareData.headBgUrl, 10, false);
        this.gDX.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.gDE.startLoad(gameShareData.gameIconUrl, 10, false);
            this.gDF.setText(gameShareData.gameName);
            this.gDG.setText(gameShareData.gameDescription);
            this.gDH.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.gDN);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.gDP.startLoad(gameShareData.userPortrait, 12, false);
            this.cbW.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.gDV);
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

    public Bitmap bIj() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bIk() {
        return this.eOF.getBottom();
    }

    public void onDestroy() {
        if (this.gEe != null) {
            this.gEe.onDestroy();
            this.gEe = null;
        }
    }
}

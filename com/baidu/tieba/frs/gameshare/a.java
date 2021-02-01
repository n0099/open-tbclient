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
    private LinearLayout hWo;
    private LinearLayout hnO;
    private TbImageView ibY;
    private TextView jAA;
    private TextView jAB;
    private InterfaceC0729a jAC;
    private BlurDrawable jAD;
    private ImageView jAa;
    private FrameLayout jAb;
    private ColumnLayout jAc;
    private TbImageView jAd;
    private TextView jAe;
    private TextView jAf;
    private TextView jAg;
    private RadioButton jAh;
    private RadioButton jAi;
    private RadioButton jAj;
    private RadioButton jAk;
    private RadioButton jAl;
    private RadioButton[] jAm;
    private TextView jAn;
    private TbImageView jAo;
    private RadioButton jAp;
    private RadioButton jAq;
    private RadioButton jAr;
    private RadioButton jAs;
    private RadioButton jAt;
    private RadioButton[] jAu;
    private TextView jAv;
    private TbImageView jAw;
    private TextView jAx;
    private TextView jAy;
    private TextView jAz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0729a {
        void A(Bitmap bitmap);

        void B(Bitmap bitmap);

        void C(Bitmap bitmap);

        void onCancel();

        void z(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0729a interfaceC0729a) {
        this.jAC = interfaceC0729a;
        this.aiT = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.aiT.findViewById(R.id.game_share_content_layout);
        this.jAa = (ImageView) this.aiT.findViewById(R.id.game_share_content_bg_view);
        this.hnO = (LinearLayout) this.aiT.findViewById(R.id.game_share_card_layout);
        this.jAb = (FrameLayout) this.aiT.findViewById(R.id.game_share_header_root);
        this.jAc = (ColumnLayout) this.aiT.findViewById(R.id.game_share_header_layout);
        this.ibY = (TbImageView) this.aiT.findViewById(R.id.game_share_header_bg_view);
        this.ibY.setVisibility(4);
        this.ibY.setDefaultBg(new ColorDrawable(this.aiT.getResources().getColor(R.color.transparent)));
        this.ibY.setDrawerType(1);
        this.ibY.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.ibY.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.ibY.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.jAd = (TbImageView) this.aiT.findViewById(R.id.game_share_game_icon);
        this.jAd.setDrawerType(1);
        this.jAd.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.jAe = (TextView) this.aiT.findViewById(R.id.game_share_game_name);
        this.jAf = (TextView) this.aiT.findViewById(R.id.game_share_game_description);
        this.jAg = (TextView) this.aiT.findViewById(R.id.game_share_game_score);
        this.jAh = (RadioButton) this.aiT.findViewById(R.id.game_share_score_grade_1);
        this.jAi = (RadioButton) this.aiT.findViewById(R.id.game_share_score_grade_2);
        this.jAj = (RadioButton) this.aiT.findViewById(R.id.game_share_score_grade_3);
        this.jAk = (RadioButton) this.aiT.findViewById(R.id.game_share_score_grade_4);
        this.jAl = (RadioButton) this.aiT.findViewById(R.id.game_share_score_grade_5);
        this.jAm = new RadioButton[]{this.jAh, this.jAi, this.jAj, this.jAk, this.jAl};
        this.jAn = (TextView) this.aiT.findViewById(R.id.game_share_comment);
        this.jAo = (TbImageView) this.aiT.findViewById(R.id.game_share_user_protrait);
        this.jAo.setDrawerType(1);
        this.jAo.setIsRound(true);
        this.eIO = (TextView) this.aiT.findViewById(R.id.game_share_user_name);
        this.jAp = (RadioButton) this.aiT.findViewById(R.id.game_share_user_score_grade_1);
        this.jAq = (RadioButton) this.aiT.findViewById(R.id.game_share_user_score_grade_2);
        this.jAr = (RadioButton) this.aiT.findViewById(R.id.game_share_user_score_grade_3);
        this.jAs = (RadioButton) this.aiT.findViewById(R.id.game_share_user_score_grade_4);
        this.jAt = (RadioButton) this.aiT.findViewById(R.id.game_share_user_score_grade_5);
        this.jAu = new RadioButton[]{this.jAp, this.jAq, this.jAr, this.jAs, this.jAt};
        this.jAv = (TextView) this.aiT.findViewById(R.id.game_share_qr_txt);
        this.jAw = (TbImageView) this.aiT.findViewById(R.id.game_share_qr_img);
        this.hWo = (LinearLayout) this.aiT.findViewById(R.id.game_share_entry_layout);
        this.jAx = (TextView) this.aiT.findViewById(R.id.game_share_entry_weixin);
        this.jAx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bkM = a.this.bkM();
                if (bkM != null && a.this.jAC != null) {
                    a.this.jAC.z(bkM);
                }
            }
        });
        this.jAy = (TextView) this.aiT.findViewById(R.id.game_share_entry_wxfriends);
        this.jAy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bkM = a.this.bkM();
                if (bkM != null && a.this.jAC != null) {
                    a.this.jAC.A(bkM);
                }
            }
        });
        this.jAz = (TextView) this.aiT.findViewById(R.id.game_share_entry_qq);
        this.jAz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bkM = a.this.bkM();
                if (bkM != null && a.this.jAC != null) {
                    a.this.jAC.B(bkM);
                }
            }
        });
        this.jAA = (TextView) this.aiT.findViewById(R.id.game_share_entry_sina);
        this.jAA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bkM = a.this.bkM();
                if (bkM != null && a.this.jAC != null) {
                    a.this.jAC.C(bkM);
                }
            }
        });
        this.jAB = (TextView) this.aiT.findViewById(R.id.game_share_cancel);
        this.jAB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jAC != null) {
                    a.this.jAC.onCancel();
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
        this.jAn.setText(sb);
        if (this.jAD == null) {
            d.mw().a(gameShareData.gameIconUrl, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.aiT.getContext(), R.string.share_failed);
                        if (a.this.jAC != null) {
                            a.this.jAC.onCancel();
                        }
                    }
                    a.this.jAD = new BlurDrawable(a.this.aiT.getContext());
                    a.this.jAD.init(2, 4, aVar.getRawBitmap());
                    a.this.jAD.drawBlur();
                    a.this.jAa.setImageBitmap(a.this.jAD.getBlurredBitmap());
                }
            }, null);
        }
        this.ibY.startLoad(gameShareData.headBgUrl, 10, false);
        this.jAw.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.jAd.startLoad(gameShareData.gameIconUrl, 10, false);
            this.jAe.setText(gameShareData.gameName);
            this.jAf.setText(gameShareData.gameDescription);
            this.jAg.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.jAm);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.jAo.startLoad(gameShareData.userPortrait, 12, false);
            this.eIO.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.jAu);
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

    public int cIi() {
        return this.hnO.getBottom();
    }

    public void onDestroy() {
        if (this.jAD != null) {
            this.jAD.onDestroy();
            this.jAD = null;
        }
    }
}

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
    private TextView ewx;
    private LinearLayout gTz;
    private LinearLayout hBa;
    private TbImageView hGz;
    private RadioButton[] iYA;
    private TextView iYB;
    private TbImageView iYC;
    private RadioButton iYD;
    private RadioButton iYE;
    private RadioButton iYF;
    private RadioButton iYG;
    private RadioButton iYH;
    private RadioButton[] iYI;
    private TextView iYJ;
    private TbImageView iYK;
    private TextView iYL;
    private TextView iYM;
    private TextView iYN;
    private TextView iYO;
    private TextView iYP;
    private InterfaceC0729a iYQ;
    private BlurDrawable iYR;
    private ImageView iYo;
    private FrameLayout iYp;
    private ColumnLayout iYq;
    private TbImageView iYr;
    private TextView iYs;
    private TextView iYt;
    private TextView iYu;
    private RadioButton iYv;
    private RadioButton iYw;
    private RadioButton iYx;
    private RadioButton iYy;
    private RadioButton iYz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0729a {
        void A(Bitmap bitmap);

        void B(Bitmap bitmap);

        void C(Bitmap bitmap);

        void onCancel();

        void z(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0729a interfaceC0729a) {
        this.iYQ = interfaceC0729a;
        this.aii = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.aii.findViewById(R.id.game_share_content_layout);
        this.iYo = (ImageView) this.aii.findViewById(R.id.game_share_content_bg_view);
        this.gTz = (LinearLayout) this.aii.findViewById(R.id.game_share_card_layout);
        this.iYp = (FrameLayout) this.aii.findViewById(R.id.game_share_header_root);
        this.iYq = (ColumnLayout) this.aii.findViewById(R.id.game_share_header_layout);
        this.hGz = (TbImageView) this.aii.findViewById(R.id.game_share_header_bg_view);
        this.hGz.setVisibility(4);
        this.hGz.setDefaultBg(new ColorDrawable(this.aii.getResources().getColor(R.color.transparent)));
        this.hGz.setDrawerType(1);
        this.hGz.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.hGz.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.hGz.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.iYr = (TbImageView) this.aii.findViewById(R.id.game_share_game_icon);
        this.iYr.setDrawerType(1);
        this.iYr.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iYs = (TextView) this.aii.findViewById(R.id.game_share_game_name);
        this.iYt = (TextView) this.aii.findViewById(R.id.game_share_game_description);
        this.iYu = (TextView) this.aii.findViewById(R.id.game_share_game_score);
        this.iYv = (RadioButton) this.aii.findViewById(R.id.game_share_score_grade_1);
        this.iYw = (RadioButton) this.aii.findViewById(R.id.game_share_score_grade_2);
        this.iYx = (RadioButton) this.aii.findViewById(R.id.game_share_score_grade_3);
        this.iYy = (RadioButton) this.aii.findViewById(R.id.game_share_score_grade_4);
        this.iYz = (RadioButton) this.aii.findViewById(R.id.game_share_score_grade_5);
        this.iYA = new RadioButton[]{this.iYv, this.iYw, this.iYx, this.iYy, this.iYz};
        this.iYB = (TextView) this.aii.findViewById(R.id.game_share_comment);
        this.iYC = (TbImageView) this.aii.findViewById(R.id.game_share_user_protrait);
        this.iYC.setDrawerType(1);
        this.iYC.setIsRound(true);
        this.ewx = (TextView) this.aii.findViewById(R.id.game_share_user_name);
        this.iYD = (RadioButton) this.aii.findViewById(R.id.game_share_user_score_grade_1);
        this.iYE = (RadioButton) this.aii.findViewById(R.id.game_share_user_score_grade_2);
        this.iYF = (RadioButton) this.aii.findViewById(R.id.game_share_user_score_grade_3);
        this.iYG = (RadioButton) this.aii.findViewById(R.id.game_share_user_score_grade_4);
        this.iYH = (RadioButton) this.aii.findViewById(R.id.game_share_user_score_grade_5);
        this.iYI = new RadioButton[]{this.iYD, this.iYE, this.iYF, this.iYG, this.iYH};
        this.iYJ = (TextView) this.aii.findViewById(R.id.game_share_qr_txt);
        this.iYK = (TbImageView) this.aii.findViewById(R.id.game_share_qr_img);
        this.hBa = (LinearLayout) this.aii.findViewById(R.id.game_share_entry_layout);
        this.iYL = (TextView) this.aii.findViewById(R.id.game_share_entry_weixin);
        this.iYL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bjA = a.this.bjA();
                if (bjA != null && a.this.iYQ != null) {
                    a.this.iYQ.z(bjA);
                }
            }
        });
        this.iYM = (TextView) this.aii.findViewById(R.id.game_share_entry_wxfriends);
        this.iYM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bjA = a.this.bjA();
                if (bjA != null && a.this.iYQ != null) {
                    a.this.iYQ.A(bjA);
                }
            }
        });
        this.iYN = (TextView) this.aii.findViewById(R.id.game_share_entry_qq);
        this.iYN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bjA = a.this.bjA();
                if (bjA != null && a.this.iYQ != null) {
                    a.this.iYQ.B(bjA);
                }
            }
        });
        this.iYO = (TextView) this.aii.findViewById(R.id.game_share_entry_sina);
        this.iYO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bjA = a.this.bjA();
                if (bjA != null && a.this.iYQ != null) {
                    a.this.iYQ.C(bjA);
                }
            }
        });
        this.iYP = (TextView) this.aii.findViewById(R.id.game_share_cancel);
        this.iYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iYQ != null) {
                    a.this.iYQ.onCancel();
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
        this.iYB.setText(sb);
        if (this.iYR == null) {
            c.mS().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.aii.getContext(), (int) R.string.share_failed);
                        if (a.this.iYQ != null) {
                            a.this.iYQ.onCancel();
                        }
                    }
                    a.this.iYR = new BlurDrawable(a.this.aii.getContext());
                    a.this.iYR.init(2, 4, aVar.getRawBitmap());
                    a.this.iYR.drawBlur();
                    a.this.iYo.setImageBitmap(a.this.iYR.getBlurredBitmap());
                }
            }, null);
        }
        this.hGz.startLoad(gameShareData.headBgUrl, 10, false);
        this.iYK.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.iYr.startLoad(gameShareData.gameIconUrl, 10, false);
            this.iYs.setText(gameShareData.gameName);
            this.iYt.setText(gameShareData.gameDescription);
            this.iYu.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.iYA);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.iYC.startLoad(gameShareData.userPortrait, 12, false);
            this.ewx.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.iYI);
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

    public Bitmap bjA() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int cCW() {
        return this.gTz.getBottom();
    }

    public void onDestroy() {
        if (this.iYR != null) {
            this.iYR.onDestroy();
            this.iYR = null;
        }
    }
}

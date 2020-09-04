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
/* loaded from: classes16.dex */
public class a {
    private FrameLayout ahv;
    private TextView dTU;
    private LinearLayout gQB;
    private TbImageView gVZ;
    private LinearLayout gjM;
    private TextView ikA;
    private TextView ikB;
    private InterfaceC0684a ikC;
    private BlurDrawable ikD;
    private ImageView ika;
    private FrameLayout ikb;
    private ColumnLayout ikc;
    private TbImageView ikd;
    private TextView ike;
    private TextView ikf;
    private TextView ikg;
    private RadioButton ikh;
    private RadioButton iki;
    private RadioButton ikj;
    private RadioButton ikk;
    private RadioButton ikl;
    private RadioButton[] ikm;
    private TextView ikn;
    private TbImageView iko;
    private RadioButton ikp;
    private RadioButton ikq;
    private RadioButton ikr;
    private RadioButton iks;
    private RadioButton ikt;
    private RadioButton[] iku;
    private TextView ikv;
    private TbImageView ikw;
    private TextView ikx;
    private TextView iky;
    private TextView ikz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0684a {
        void A(Bitmap bitmap);

        void B(Bitmap bitmap);

        void C(Bitmap bitmap);

        void onCancel();

        void z(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0684a interfaceC0684a) {
        this.ikC = interfaceC0684a;
        this.ahv = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.ahv.findViewById(R.id.game_share_content_layout);
        this.ika = (ImageView) this.ahv.findViewById(R.id.game_share_content_bg_view);
        this.gjM = (LinearLayout) this.ahv.findViewById(R.id.game_share_card_layout);
        this.ikb = (FrameLayout) this.ahv.findViewById(R.id.game_share_header_root);
        this.ikc = (ColumnLayout) this.ahv.findViewById(R.id.game_share_header_layout);
        this.gVZ = (TbImageView) this.ahv.findViewById(R.id.game_share_header_bg_view);
        this.gVZ.setVisibility(4);
        this.gVZ.setDefaultBg(new ColorDrawable(this.ahv.getResources().getColor(R.color.transparent)));
        this.gVZ.setDrawerType(1);
        this.gVZ.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.gVZ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.gVZ.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.ikd = (TbImageView) this.ahv.findViewById(R.id.game_share_game_icon);
        this.ikd.setDrawerType(1);
        this.ikd.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.ike = (TextView) this.ahv.findViewById(R.id.game_share_game_name);
        this.ikf = (TextView) this.ahv.findViewById(R.id.game_share_game_description);
        this.ikg = (TextView) this.ahv.findViewById(R.id.game_share_game_score);
        this.ikh = (RadioButton) this.ahv.findViewById(R.id.game_share_score_grade_1);
        this.iki = (RadioButton) this.ahv.findViewById(R.id.game_share_score_grade_2);
        this.ikj = (RadioButton) this.ahv.findViewById(R.id.game_share_score_grade_3);
        this.ikk = (RadioButton) this.ahv.findViewById(R.id.game_share_score_grade_4);
        this.ikl = (RadioButton) this.ahv.findViewById(R.id.game_share_score_grade_5);
        this.ikm = new RadioButton[]{this.ikh, this.iki, this.ikj, this.ikk, this.ikl};
        this.ikn = (TextView) this.ahv.findViewById(R.id.game_share_comment);
        this.iko = (TbImageView) this.ahv.findViewById(R.id.game_share_user_protrait);
        this.iko.setDrawerType(1);
        this.iko.setIsRound(true);
        this.dTU = (TextView) this.ahv.findViewById(R.id.game_share_user_name);
        this.ikp = (RadioButton) this.ahv.findViewById(R.id.game_share_user_score_grade_1);
        this.ikq = (RadioButton) this.ahv.findViewById(R.id.game_share_user_score_grade_2);
        this.ikr = (RadioButton) this.ahv.findViewById(R.id.game_share_user_score_grade_3);
        this.iks = (RadioButton) this.ahv.findViewById(R.id.game_share_user_score_grade_4);
        this.ikt = (RadioButton) this.ahv.findViewById(R.id.game_share_user_score_grade_5);
        this.iku = new RadioButton[]{this.ikp, this.ikq, this.ikr, this.iks, this.ikt};
        this.ikv = (TextView) this.ahv.findViewById(R.id.game_share_qr_txt);
        this.ikw = (TbImageView) this.ahv.findViewById(R.id.game_share_qr_img);
        this.gQB = (LinearLayout) this.ahv.findViewById(R.id.game_share_entry_layout);
        this.ikx = (TextView) this.ahv.findViewById(R.id.game_share_entry_weixin);
        this.ikx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bbF = a.this.bbF();
                if (bbF != null && a.this.ikC != null) {
                    a.this.ikC.z(bbF);
                }
            }
        });
        this.iky = (TextView) this.ahv.findViewById(R.id.game_share_entry_wxfriends);
        this.iky.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bbF = a.this.bbF();
                if (bbF != null && a.this.ikC != null) {
                    a.this.ikC.A(bbF);
                }
            }
        });
        this.ikz = (TextView) this.ahv.findViewById(R.id.game_share_entry_qq);
        this.ikz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bbF = a.this.bbF();
                if (bbF != null && a.this.ikC != null) {
                    a.this.ikC.B(bbF);
                }
            }
        });
        this.ikA = (TextView) this.ahv.findViewById(R.id.game_share_entry_sina);
        this.ikA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bbF = a.this.bbF();
                if (bbF != null && a.this.ikC != null) {
                    a.this.ikC.C(bbF);
                }
            }
        });
        this.ikB = (TextView) this.ahv.findViewById(R.id.game_share_cancel);
        this.ikB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ikC != null) {
                    a.this.ikC.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.ahv;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.ikn.setText(sb);
        if (this.ikD == null) {
            c.mM().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.ahv.getContext(), (int) R.string.share_failed);
                        if (a.this.ikC != null) {
                            a.this.ikC.onCancel();
                        }
                    }
                    a.this.ikD = new BlurDrawable(a.this.ahv.getContext());
                    a.this.ikD.init(2, 4, aVar.getRawBitmap());
                    a.this.ikD.drawBlur();
                    a.this.ika.setImageBitmap(a.this.ikD.getBlurredBitmap());
                }
            }, null);
        }
        this.gVZ.startLoad(gameShareData.headBgUrl, 10, false);
        this.ikw.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.ikd.startLoad(gameShareData.gameIconUrl, 10, false);
            this.ike.setText(gameShareData.gameName);
            this.ikf.setText(gameShareData.gameDescription);
            this.ikg.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.ikm);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.iko.startLoad(gameShareData.userPortrait, 12, false);
            this.dTU.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.iku);
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

    public Bitmap bbF() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int cqE() {
        return this.gjM.getBottom();
    }

    public void onDestroy() {
        if (this.ikD != null) {
            this.ikD.onDestroy();
            this.ikD = null;
        }
    }
}

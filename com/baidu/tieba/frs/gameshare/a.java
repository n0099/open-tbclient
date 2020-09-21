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
/* loaded from: classes21.dex */
public class a {
    private FrameLayout ahP;
    private TextView dWe;
    private LinearLayout gUj;
    private TbImageView gZG;
    private LinearLayout gmT;
    private TextView irA;
    private TextView irB;
    private TextView irC;
    private TextView irD;
    private InterfaceC0681a irE;
    private BlurDrawable irF;
    private ImageView irc;
    private FrameLayout ird;
    private ColumnLayout ire;
    private TbImageView irf;
    private TextView irg;
    private TextView irh;
    private TextView iri;
    private RadioButton irj;
    private RadioButton irk;
    private RadioButton irl;
    private RadioButton irm;
    private RadioButton irn;
    private RadioButton[] iro;
    private TextView irp;
    private TbImageView irq;
    private RadioButton irr;
    private RadioButton irs;
    private RadioButton irt;
    private RadioButton iru;
    private RadioButton irv;
    private RadioButton[] irw;
    private TextView irx;
    private TbImageView iry;
    private TextView irz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0681a {
        void A(Bitmap bitmap);

        void B(Bitmap bitmap);

        void C(Bitmap bitmap);

        void onCancel();

        void z(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0681a interfaceC0681a) {
        this.irE = interfaceC0681a;
        this.ahP = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.ahP.findViewById(R.id.game_share_content_layout);
        this.irc = (ImageView) this.ahP.findViewById(R.id.game_share_content_bg_view);
        this.gmT = (LinearLayout) this.ahP.findViewById(R.id.game_share_card_layout);
        this.ird = (FrameLayout) this.ahP.findViewById(R.id.game_share_header_root);
        this.ire = (ColumnLayout) this.ahP.findViewById(R.id.game_share_header_layout);
        this.gZG = (TbImageView) this.ahP.findViewById(R.id.game_share_header_bg_view);
        this.gZG.setVisibility(4);
        this.gZG.setDefaultBg(new ColorDrawable(this.ahP.getResources().getColor(R.color.transparent)));
        this.gZG.setDrawerType(1);
        this.gZG.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.gZG.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.gZG.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.irf = (TbImageView) this.ahP.findViewById(R.id.game_share_game_icon);
        this.irf.setDrawerType(1);
        this.irf.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.irg = (TextView) this.ahP.findViewById(R.id.game_share_game_name);
        this.irh = (TextView) this.ahP.findViewById(R.id.game_share_game_description);
        this.iri = (TextView) this.ahP.findViewById(R.id.game_share_game_score);
        this.irj = (RadioButton) this.ahP.findViewById(R.id.game_share_score_grade_1);
        this.irk = (RadioButton) this.ahP.findViewById(R.id.game_share_score_grade_2);
        this.irl = (RadioButton) this.ahP.findViewById(R.id.game_share_score_grade_3);
        this.irm = (RadioButton) this.ahP.findViewById(R.id.game_share_score_grade_4);
        this.irn = (RadioButton) this.ahP.findViewById(R.id.game_share_score_grade_5);
        this.iro = new RadioButton[]{this.irj, this.irk, this.irl, this.irm, this.irn};
        this.irp = (TextView) this.ahP.findViewById(R.id.game_share_comment);
        this.irq = (TbImageView) this.ahP.findViewById(R.id.game_share_user_protrait);
        this.irq.setDrawerType(1);
        this.irq.setIsRound(true);
        this.dWe = (TextView) this.ahP.findViewById(R.id.game_share_user_name);
        this.irr = (RadioButton) this.ahP.findViewById(R.id.game_share_user_score_grade_1);
        this.irs = (RadioButton) this.ahP.findViewById(R.id.game_share_user_score_grade_2);
        this.irt = (RadioButton) this.ahP.findViewById(R.id.game_share_user_score_grade_3);
        this.iru = (RadioButton) this.ahP.findViewById(R.id.game_share_user_score_grade_4);
        this.irv = (RadioButton) this.ahP.findViewById(R.id.game_share_user_score_grade_5);
        this.irw = new RadioButton[]{this.irr, this.irs, this.irt, this.iru, this.irv};
        this.irx = (TextView) this.ahP.findViewById(R.id.game_share_qr_txt);
        this.iry = (TbImageView) this.ahP.findViewById(R.id.game_share_qr_img);
        this.gUj = (LinearLayout) this.ahP.findViewById(R.id.game_share_entry_layout);
        this.irz = (TextView) this.ahP.findViewById(R.id.game_share_entry_weixin);
        this.irz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bcz = a.this.bcz();
                if (bcz != null && a.this.irE != null) {
                    a.this.irE.z(bcz);
                }
            }
        });
        this.irA = (TextView) this.ahP.findViewById(R.id.game_share_entry_wxfriends);
        this.irA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bcz = a.this.bcz();
                if (bcz != null && a.this.irE != null) {
                    a.this.irE.A(bcz);
                }
            }
        });
        this.irB = (TextView) this.ahP.findViewById(R.id.game_share_entry_qq);
        this.irB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bcz = a.this.bcz();
                if (bcz != null && a.this.irE != null) {
                    a.this.irE.B(bcz);
                }
            }
        });
        this.irC = (TextView) this.ahP.findViewById(R.id.game_share_entry_sina);
        this.irC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bcz = a.this.bcz();
                if (bcz != null && a.this.irE != null) {
                    a.this.irE.C(bcz);
                }
            }
        });
        this.irD = (TextView) this.ahP.findViewById(R.id.game_share_cancel);
        this.irD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.irE != null) {
                    a.this.irE.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.ahP;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.irp.setText(sb);
        if (this.irF == null) {
            c.mR().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.ahP.getContext(), (int) R.string.share_failed);
                        if (a.this.irE != null) {
                            a.this.irE.onCancel();
                        }
                    }
                    a.this.irF = new BlurDrawable(a.this.ahP.getContext());
                    a.this.irF.init(2, 4, aVar.getRawBitmap());
                    a.this.irF.drawBlur();
                    a.this.irc.setImageBitmap(a.this.irF.getBlurredBitmap());
                }
            }, null);
        }
        this.gZG.startLoad(gameShareData.headBgUrl, 10, false);
        this.iry.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.irf.startLoad(gameShareData.gameIconUrl, 10, false);
            this.irg.setText(gameShareData.gameName);
            this.irh.setText(gameShareData.gameDescription);
            this.iri.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.iro);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.irq.startLoad(gameShareData.userPortrait, 12, false);
            this.dWe.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.irw);
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

    public Bitmap bcz() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int ctR() {
        return this.gmT.getBottom();
    }

    public void onDestroy() {
        if (this.irF != null) {
            this.irF.onDestroy();
            this.irF = null;
        }
    }
}

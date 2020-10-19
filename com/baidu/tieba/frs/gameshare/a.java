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
    private FrameLayout aih;
    private TextView eig;
    private LinearLayout gBm;
    private LinearLayout hjh;
    private TbImageView hoH;
    private ImageView iFV;
    private FrameLayout iFW;
    private ColumnLayout iFX;
    private TbImageView iFY;
    private TextView iFZ;
    private TextView iGa;
    private TextView iGb;
    private RadioButton iGc;
    private RadioButton iGd;
    private RadioButton iGe;
    private RadioButton iGf;
    private RadioButton iGg;
    private RadioButton[] iGh;
    private TextView iGi;
    private TbImageView iGj;
    private RadioButton iGk;
    private RadioButton iGl;
    private RadioButton iGm;
    private RadioButton iGn;
    private RadioButton iGo;
    private RadioButton[] iGp;
    private TextView iGq;
    private TbImageView iGr;
    private TextView iGs;
    private TextView iGt;
    private TextView iGu;
    private TextView iGv;
    private TextView iGw;
    private InterfaceC0699a iGx;
    private BlurDrawable iGy;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0699a {
        void A(Bitmap bitmap);

        void B(Bitmap bitmap);

        void C(Bitmap bitmap);

        void onCancel();

        void z(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0699a interfaceC0699a) {
        this.iGx = interfaceC0699a;
        this.aih = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.aih.findViewById(R.id.game_share_content_layout);
        this.iFV = (ImageView) this.aih.findViewById(R.id.game_share_content_bg_view);
        this.gBm = (LinearLayout) this.aih.findViewById(R.id.game_share_card_layout);
        this.iFW = (FrameLayout) this.aih.findViewById(R.id.game_share_header_root);
        this.iFX = (ColumnLayout) this.aih.findViewById(R.id.game_share_header_layout);
        this.hoH = (TbImageView) this.aih.findViewById(R.id.game_share_header_bg_view);
        this.hoH.setVisibility(4);
        this.hoH.setDefaultBg(new ColorDrawable(this.aih.getResources().getColor(R.color.transparent)));
        this.hoH.setDrawerType(1);
        this.hoH.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.hoH.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.hoH.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.iFY = (TbImageView) this.aih.findViewById(R.id.game_share_game_icon);
        this.iFY.setDrawerType(1);
        this.iFY.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iFZ = (TextView) this.aih.findViewById(R.id.game_share_game_name);
        this.iGa = (TextView) this.aih.findViewById(R.id.game_share_game_description);
        this.iGb = (TextView) this.aih.findViewById(R.id.game_share_game_score);
        this.iGc = (RadioButton) this.aih.findViewById(R.id.game_share_score_grade_1);
        this.iGd = (RadioButton) this.aih.findViewById(R.id.game_share_score_grade_2);
        this.iGe = (RadioButton) this.aih.findViewById(R.id.game_share_score_grade_3);
        this.iGf = (RadioButton) this.aih.findViewById(R.id.game_share_score_grade_4);
        this.iGg = (RadioButton) this.aih.findViewById(R.id.game_share_score_grade_5);
        this.iGh = new RadioButton[]{this.iGc, this.iGd, this.iGe, this.iGf, this.iGg};
        this.iGi = (TextView) this.aih.findViewById(R.id.game_share_comment);
        this.iGj = (TbImageView) this.aih.findViewById(R.id.game_share_user_protrait);
        this.iGj.setDrawerType(1);
        this.iGj.setIsRound(true);
        this.eig = (TextView) this.aih.findViewById(R.id.game_share_user_name);
        this.iGk = (RadioButton) this.aih.findViewById(R.id.game_share_user_score_grade_1);
        this.iGl = (RadioButton) this.aih.findViewById(R.id.game_share_user_score_grade_2);
        this.iGm = (RadioButton) this.aih.findViewById(R.id.game_share_user_score_grade_3);
        this.iGn = (RadioButton) this.aih.findViewById(R.id.game_share_user_score_grade_4);
        this.iGo = (RadioButton) this.aih.findViewById(R.id.game_share_user_score_grade_5);
        this.iGp = new RadioButton[]{this.iGk, this.iGl, this.iGm, this.iGn, this.iGo};
        this.iGq = (TextView) this.aih.findViewById(R.id.game_share_qr_txt);
        this.iGr = (TbImageView) this.aih.findViewById(R.id.game_share_qr_img);
        this.hjh = (LinearLayout) this.aih.findViewById(R.id.game_share_entry_layout);
        this.iGs = (TextView) this.aih.findViewById(R.id.game_share_entry_weixin);
        this.iGs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bfh = a.this.bfh();
                if (bfh != null && a.this.iGx != null) {
                    a.this.iGx.z(bfh);
                }
            }
        });
        this.iGt = (TextView) this.aih.findViewById(R.id.game_share_entry_wxfriends);
        this.iGt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bfh = a.this.bfh();
                if (bfh != null && a.this.iGx != null) {
                    a.this.iGx.A(bfh);
                }
            }
        });
        this.iGu = (TextView) this.aih.findViewById(R.id.game_share_entry_qq);
        this.iGu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bfh = a.this.bfh();
                if (bfh != null && a.this.iGx != null) {
                    a.this.iGx.B(bfh);
                }
            }
        });
        this.iGv = (TextView) this.aih.findViewById(R.id.game_share_entry_sina);
        this.iGv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bfh = a.this.bfh();
                if (bfh != null && a.this.iGx != null) {
                    a.this.iGx.C(bfh);
                }
            }
        });
        this.iGw = (TextView) this.aih.findViewById(R.id.game_share_cancel);
        this.iGw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iGx != null) {
                    a.this.iGx.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.aih;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.iGi.setText(sb);
        if (this.iGy == null) {
            c.mS().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.aih.getContext(), (int) R.string.share_failed);
                        if (a.this.iGx != null) {
                            a.this.iGx.onCancel();
                        }
                    }
                    a.this.iGy = new BlurDrawable(a.this.aih.getContext());
                    a.this.iGy.init(2, 4, aVar.getRawBitmap());
                    a.this.iGy.drawBlur();
                    a.this.iFV.setImageBitmap(a.this.iGy.getBlurredBitmap());
                }
            }, null);
        }
        this.hoH.startLoad(gameShareData.headBgUrl, 10, false);
        this.iGr.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.iFY.startLoad(gameShareData.gameIconUrl, 10, false);
            this.iFZ.setText(gameShareData.gameName);
            this.iGa.setText(gameShareData.gameDescription);
            this.iGb.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.iGh);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.iGj.startLoad(gameShareData.userPortrait, 12, false);
            this.eig.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.iGp);
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

    public Bitmap bfh() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int cxo() {
        return this.gBm.getBottom();
    }

    public void onDestroy() {
        if (this.iGy != null) {
            this.iGy.onDestroy();
            this.iGy = null;
        }
    }
}

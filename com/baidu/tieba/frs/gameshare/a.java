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
    private FrameLayout akl;
    private TextView eKp;
    private LinearLayout hYl;
    private LinearLayout hpM;
    private TbImageView idZ;
    private ImageView jBX;
    private FrameLayout jBY;
    private ColumnLayout jBZ;
    private BlurDrawable jCA;
    private TbImageView jCa;
    private TextView jCb;
    private TextView jCc;
    private TextView jCd;
    private RadioButton jCe;
    private RadioButton jCf;
    private RadioButton jCg;
    private RadioButton jCh;
    private RadioButton jCi;
    private RadioButton[] jCj;
    private TextView jCk;
    private TbImageView jCl;
    private RadioButton jCm;
    private RadioButton jCn;
    private RadioButton jCo;
    private RadioButton jCp;
    private RadioButton jCq;
    private RadioButton[] jCr;
    private TextView jCs;
    private TbImageView jCt;
    private TextView jCu;
    private TextView jCv;
    private TextView jCw;
    private TextView jCx;
    private TextView jCy;
    private InterfaceC0736a jCz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0736a {
        void A(Bitmap bitmap);

        void B(Bitmap bitmap);

        void C(Bitmap bitmap);

        void onCancel();

        void z(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0736a interfaceC0736a) {
        this.jCz = interfaceC0736a;
        this.akl = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.akl.findViewById(R.id.game_share_content_layout);
        this.jBX = (ImageView) this.akl.findViewById(R.id.game_share_content_bg_view);
        this.hpM = (LinearLayout) this.akl.findViewById(R.id.game_share_card_layout);
        this.jBY = (FrameLayout) this.akl.findViewById(R.id.game_share_header_root);
        this.jBZ = (ColumnLayout) this.akl.findViewById(R.id.game_share_header_layout);
        this.idZ = (TbImageView) this.akl.findViewById(R.id.game_share_header_bg_view);
        this.idZ.setVisibility(4);
        this.idZ.setDefaultBg(new ColorDrawable(this.akl.getResources().getColor(R.color.transparent)));
        this.idZ.setDrawerType(1);
        this.idZ.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.idZ.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.idZ.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.jCa = (TbImageView) this.akl.findViewById(R.id.game_share_game_icon);
        this.jCa.setDrawerType(1);
        this.jCa.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.jCb = (TextView) this.akl.findViewById(R.id.game_share_game_name);
        this.jCc = (TextView) this.akl.findViewById(R.id.game_share_game_description);
        this.jCd = (TextView) this.akl.findViewById(R.id.game_share_game_score);
        this.jCe = (RadioButton) this.akl.findViewById(R.id.game_share_score_grade_1);
        this.jCf = (RadioButton) this.akl.findViewById(R.id.game_share_score_grade_2);
        this.jCg = (RadioButton) this.akl.findViewById(R.id.game_share_score_grade_3);
        this.jCh = (RadioButton) this.akl.findViewById(R.id.game_share_score_grade_4);
        this.jCi = (RadioButton) this.akl.findViewById(R.id.game_share_score_grade_5);
        this.jCj = new RadioButton[]{this.jCe, this.jCf, this.jCg, this.jCh, this.jCi};
        this.jCk = (TextView) this.akl.findViewById(R.id.game_share_comment);
        this.jCl = (TbImageView) this.akl.findViewById(R.id.game_share_user_protrait);
        this.jCl.setDrawerType(1);
        this.jCl.setIsRound(true);
        this.eKp = (TextView) this.akl.findViewById(R.id.game_share_user_name);
        this.jCm = (RadioButton) this.akl.findViewById(R.id.game_share_user_score_grade_1);
        this.jCn = (RadioButton) this.akl.findViewById(R.id.game_share_user_score_grade_2);
        this.jCo = (RadioButton) this.akl.findViewById(R.id.game_share_user_score_grade_3);
        this.jCp = (RadioButton) this.akl.findViewById(R.id.game_share_user_score_grade_4);
        this.jCq = (RadioButton) this.akl.findViewById(R.id.game_share_user_score_grade_5);
        this.jCr = new RadioButton[]{this.jCm, this.jCn, this.jCo, this.jCp, this.jCq};
        this.jCs = (TextView) this.akl.findViewById(R.id.game_share_qr_txt);
        this.jCt = (TbImageView) this.akl.findViewById(R.id.game_share_qr_img);
        this.hYl = (LinearLayout) this.akl.findViewById(R.id.game_share_entry_layout);
        this.jCu = (TextView) this.akl.findViewById(R.id.game_share_entry_weixin);
        this.jCu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bkO = a.this.bkO();
                if (bkO != null && a.this.jCz != null) {
                    a.this.jCz.z(bkO);
                }
            }
        });
        this.jCv = (TextView) this.akl.findViewById(R.id.game_share_entry_wxfriends);
        this.jCv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bkO = a.this.bkO();
                if (bkO != null && a.this.jCz != null) {
                    a.this.jCz.A(bkO);
                }
            }
        });
        this.jCw = (TextView) this.akl.findViewById(R.id.game_share_entry_qq);
        this.jCw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bkO = a.this.bkO();
                if (bkO != null && a.this.jCz != null) {
                    a.this.jCz.B(bkO);
                }
            }
        });
        this.jCx = (TextView) this.akl.findViewById(R.id.game_share_entry_sina);
        this.jCx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bkO = a.this.bkO();
                if (bkO != null && a.this.jCz != null) {
                    a.this.jCz.C(bkO);
                }
            }
        });
        this.jCy = (TextView) this.akl.findViewById(R.id.game_share_cancel);
        this.jCy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jCz != null) {
                    a.this.jCz.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.akl;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.jCk.setText(sb);
        if (this.jCA == null) {
            d.mw().a(gameShareData.gameIconUrl, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.akl.getContext(), R.string.share_failed);
                        if (a.this.jCz != null) {
                            a.this.jCz.onCancel();
                        }
                    }
                    a.this.jCA = new BlurDrawable(a.this.akl.getContext());
                    a.this.jCA.init(2, 4, aVar.getRawBitmap());
                    a.this.jCA.drawBlur();
                    a.this.jBX.setImageBitmap(a.this.jCA.getBlurredBitmap());
                }
            }, null);
        }
        this.idZ.startLoad(gameShareData.headBgUrl, 10, false);
        this.jCt.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.jCa.startLoad(gameShareData.gameIconUrl, 10, false);
            this.jCb.setText(gameShareData.gameName);
            this.jCc.setText(gameShareData.gameDescription);
            this.jCd.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.jCj);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.jCl.startLoad(gameShareData.userPortrait, 12, false);
            this.eKp.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.jCr);
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

    public Bitmap bkO() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int cIv() {
        return this.hpM.getBottom();
    }

    public void onDestroy() {
        if (this.jCA != null) {
            this.jCA.onDestroy();
            this.jCA = null;
        }
    }
}

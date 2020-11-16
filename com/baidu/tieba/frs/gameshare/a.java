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
    private FrameLayout ail;
    private TextView euO;
    private LinearLayout gTg;
    private LinearLayout hAH;
    private TbImageView hGg;
    private TextView iZA;
    private TextView iZB;
    private InterfaceC0730a iZC;
    private BlurDrawable iZD;
    private ImageView iZa;
    private FrameLayout iZb;
    private ColumnLayout iZc;
    private TbImageView iZd;
    private TextView iZe;
    private TextView iZf;
    private TextView iZg;
    private RadioButton iZh;
    private RadioButton iZi;
    private RadioButton iZj;
    private RadioButton iZk;
    private RadioButton iZl;
    private RadioButton[] iZm;
    private TextView iZn;
    private TbImageView iZo;
    private RadioButton iZp;
    private RadioButton iZq;
    private RadioButton iZr;
    private RadioButton iZs;
    private RadioButton iZt;
    private RadioButton[] iZu;
    private TextView iZv;
    private TbImageView iZw;
    private TextView iZx;
    private TextView iZy;
    private TextView iZz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0730a {
        void A(Bitmap bitmap);

        void B(Bitmap bitmap);

        void C(Bitmap bitmap);

        void onCancel();

        void z(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0730a interfaceC0730a) {
        this.iZC = interfaceC0730a;
        this.ail = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.ail.findViewById(R.id.game_share_content_layout);
        this.iZa = (ImageView) this.ail.findViewById(R.id.game_share_content_bg_view);
        this.gTg = (LinearLayout) this.ail.findViewById(R.id.game_share_card_layout);
        this.iZb = (FrameLayout) this.ail.findViewById(R.id.game_share_header_root);
        this.iZc = (ColumnLayout) this.ail.findViewById(R.id.game_share_header_layout);
        this.hGg = (TbImageView) this.ail.findViewById(R.id.game_share_header_bg_view);
        this.hGg.setVisibility(4);
        this.hGg.setDefaultBg(new ColorDrawable(this.ail.getResources().getColor(R.color.transparent)));
        this.hGg.setDrawerType(1);
        this.hGg.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.hGg.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.hGg.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.iZd = (TbImageView) this.ail.findViewById(R.id.game_share_game_icon);
        this.iZd.setDrawerType(1);
        this.iZd.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.iZe = (TextView) this.ail.findViewById(R.id.game_share_game_name);
        this.iZf = (TextView) this.ail.findViewById(R.id.game_share_game_description);
        this.iZg = (TextView) this.ail.findViewById(R.id.game_share_game_score);
        this.iZh = (RadioButton) this.ail.findViewById(R.id.game_share_score_grade_1);
        this.iZi = (RadioButton) this.ail.findViewById(R.id.game_share_score_grade_2);
        this.iZj = (RadioButton) this.ail.findViewById(R.id.game_share_score_grade_3);
        this.iZk = (RadioButton) this.ail.findViewById(R.id.game_share_score_grade_4);
        this.iZl = (RadioButton) this.ail.findViewById(R.id.game_share_score_grade_5);
        this.iZm = new RadioButton[]{this.iZh, this.iZi, this.iZj, this.iZk, this.iZl};
        this.iZn = (TextView) this.ail.findViewById(R.id.game_share_comment);
        this.iZo = (TbImageView) this.ail.findViewById(R.id.game_share_user_protrait);
        this.iZo.setDrawerType(1);
        this.iZo.setIsRound(true);
        this.euO = (TextView) this.ail.findViewById(R.id.game_share_user_name);
        this.iZp = (RadioButton) this.ail.findViewById(R.id.game_share_user_score_grade_1);
        this.iZq = (RadioButton) this.ail.findViewById(R.id.game_share_user_score_grade_2);
        this.iZr = (RadioButton) this.ail.findViewById(R.id.game_share_user_score_grade_3);
        this.iZs = (RadioButton) this.ail.findViewById(R.id.game_share_user_score_grade_4);
        this.iZt = (RadioButton) this.ail.findViewById(R.id.game_share_user_score_grade_5);
        this.iZu = new RadioButton[]{this.iZp, this.iZq, this.iZr, this.iZs, this.iZt};
        this.iZv = (TextView) this.ail.findViewById(R.id.game_share_qr_txt);
        this.iZw = (TbImageView) this.ail.findViewById(R.id.game_share_qr_img);
        this.hAH = (LinearLayout) this.ail.findViewById(R.id.game_share_entry_layout);
        this.iZx = (TextView) this.ail.findViewById(R.id.game_share_entry_weixin);
        this.iZx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap biE = a.this.biE();
                if (biE != null && a.this.iZC != null) {
                    a.this.iZC.z(biE);
                }
            }
        });
        this.iZy = (TextView) this.ail.findViewById(R.id.game_share_entry_wxfriends);
        this.iZy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap biE = a.this.biE();
                if (biE != null && a.this.iZC != null) {
                    a.this.iZC.A(biE);
                }
            }
        });
        this.iZz = (TextView) this.ail.findViewById(R.id.game_share_entry_qq);
        this.iZz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap biE = a.this.biE();
                if (biE != null && a.this.iZC != null) {
                    a.this.iZC.B(biE);
                }
            }
        });
        this.iZA = (TextView) this.ail.findViewById(R.id.game_share_entry_sina);
        this.iZA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap biE = a.this.biE();
                if (biE != null && a.this.iZC != null) {
                    a.this.iZC.C(biE);
                }
            }
        });
        this.iZB = (TextView) this.ail.findViewById(R.id.game_share_cancel);
        this.iZB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iZC != null) {
                    a.this.iZC.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.ail;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.iZn.setText(sb);
        if (this.iZD == null) {
            c.mS().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.ail.getContext(), (int) R.string.share_failed);
                        if (a.this.iZC != null) {
                            a.this.iZC.onCancel();
                        }
                    }
                    a.this.iZD = new BlurDrawable(a.this.ail.getContext());
                    a.this.iZD.init(2, 4, aVar.getRawBitmap());
                    a.this.iZD.drawBlur();
                    a.this.iZa.setImageBitmap(a.this.iZD.getBlurredBitmap());
                }
            }, null);
        }
        this.hGg.startLoad(gameShareData.headBgUrl, 10, false);
        this.iZw.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.iZd.startLoad(gameShareData.gameIconUrl, 10, false);
            this.iZe.setText(gameShareData.gameName);
            this.iZf.setText(gameShareData.gameDescription);
            this.iZg.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.iZm);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.iZo.startLoad(gameShareData.userPortrait, 12, false);
            this.euO.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.iZu);
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

    public Bitmap biE() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int cCA() {
        return this.gTg.getBottom();
    }

    public void onDestroy() {
        if (this.iZD != null) {
            this.iZD.onDestroy();
            this.iZD = null;
        }
    }
}

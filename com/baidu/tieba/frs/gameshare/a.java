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
    private TextView cAX;
    private FrameLayout cSf;
    private LinearLayout fWy;
    private LinearLayout fsZ;
    private TbImageView gbW;
    private ImageView hmX;
    private FrameLayout hmY;
    private ColumnLayout hmZ;
    private BlurDrawable hnA;
    private TbImageView hna;
    private TextView hnb;
    private TextView hnc;
    private TextView hnd;
    private RadioButton hne;
    private RadioButton hnf;
    private RadioButton hng;
    private RadioButton hnh;
    private RadioButton hni;
    private RadioButton[] hnj;
    private TextView hnk;
    private TbImageView hnl;
    private RadioButton hnm;
    private RadioButton hnn;
    private RadioButton hno;
    private RadioButton hnp;
    private RadioButton hnq;
    private RadioButton[] hnr;
    private TextView hns;
    private TbImageView hnt;
    private TextView hnu;
    private TextView hnv;
    private TextView hnw;
    private TextView hnx;
    private TextView hny;
    private InterfaceC0544a hnz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0544a {
        void onCancel();

        void v(Bitmap bitmap);

        void w(Bitmap bitmap);

        void x(Bitmap bitmap);

        void y(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0544a interfaceC0544a) {
        this.hnz = interfaceC0544a;
        this.cSf = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.cSf.findViewById(R.id.game_share_content_layout);
        this.hmX = (ImageView) this.cSf.findViewById(R.id.game_share_content_bg_view);
        this.fsZ = (LinearLayout) this.cSf.findViewById(R.id.game_share_card_layout);
        this.hmY = (FrameLayout) this.cSf.findViewById(R.id.game_share_header_root);
        this.hmZ = (ColumnLayout) this.cSf.findViewById(R.id.game_share_header_layout);
        this.gbW = (TbImageView) this.cSf.findViewById(R.id.game_share_header_bg_view);
        this.gbW.setVisibility(4);
        this.gbW.setDefaultBg(new ColorDrawable(this.cSf.getResources().getColor(R.color.transparent)));
        this.gbW.setDrawerType(1);
        this.gbW.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.gbW.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.gbW.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hna = (TbImageView) this.cSf.findViewById(R.id.game_share_game_icon);
        this.hna.setDrawerType(1);
        this.hna.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.hnb = (TextView) this.cSf.findViewById(R.id.game_share_game_name);
        this.hnc = (TextView) this.cSf.findViewById(R.id.game_share_game_description);
        this.hnd = (TextView) this.cSf.findViewById(R.id.game_share_game_score);
        this.hne = (RadioButton) this.cSf.findViewById(R.id.game_share_score_grade_1);
        this.hnf = (RadioButton) this.cSf.findViewById(R.id.game_share_score_grade_2);
        this.hng = (RadioButton) this.cSf.findViewById(R.id.game_share_score_grade_3);
        this.hnh = (RadioButton) this.cSf.findViewById(R.id.game_share_score_grade_4);
        this.hni = (RadioButton) this.cSf.findViewById(R.id.game_share_score_grade_5);
        this.hnj = new RadioButton[]{this.hne, this.hnf, this.hng, this.hnh, this.hni};
        this.hnk = (TextView) this.cSf.findViewById(R.id.game_share_comment);
        this.hnl = (TbImageView) this.cSf.findViewById(R.id.game_share_user_protrait);
        this.hnl.setDrawerType(1);
        this.hnl.setIsRound(true);
        this.cAX = (TextView) this.cSf.findViewById(R.id.game_share_user_name);
        this.hnm = (RadioButton) this.cSf.findViewById(R.id.game_share_user_score_grade_1);
        this.hnn = (RadioButton) this.cSf.findViewById(R.id.game_share_user_score_grade_2);
        this.hno = (RadioButton) this.cSf.findViewById(R.id.game_share_user_score_grade_3);
        this.hnp = (RadioButton) this.cSf.findViewById(R.id.game_share_user_score_grade_4);
        this.hnq = (RadioButton) this.cSf.findViewById(R.id.game_share_user_score_grade_5);
        this.hnr = new RadioButton[]{this.hnm, this.hnn, this.hno, this.hnp, this.hnq};
        this.hns = (TextView) this.cSf.findViewById(R.id.game_share_qr_txt);
        this.hnt = (TbImageView) this.cSf.findViewById(R.id.game_share_qr_img);
        this.fWy = (LinearLayout) this.cSf.findViewById(R.id.game_share_entry_layout);
        this.hnu = (TextView) this.cSf.findViewById(R.id.game_share_entry_weixin);
        this.hnu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bSI = a.this.bSI();
                if (bSI != null && a.this.hnz != null) {
                    a.this.hnz.v(bSI);
                }
            }
        });
        this.hnv = (TextView) this.cSf.findViewById(R.id.game_share_entry_wxfriends);
        this.hnv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bSI = a.this.bSI();
                if (bSI != null && a.this.hnz != null) {
                    a.this.hnz.w(bSI);
                }
            }
        });
        this.hnw = (TextView) this.cSf.findViewById(R.id.game_share_entry_qq);
        this.hnw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bSI = a.this.bSI();
                if (bSI != null && a.this.hnz != null) {
                    a.this.hnz.x(bSI);
                }
            }
        });
        this.hnx = (TextView) this.cSf.findViewById(R.id.game_share_entry_sina);
        this.hnx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bSI = a.this.bSI();
                if (bSI != null && a.this.hnz != null) {
                    a.this.hnz.y(bSI);
                }
            }
        });
        this.hny = (TextView) this.cSf.findViewById(R.id.game_share_cancel);
        this.hny.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hnz != null) {
                    a.this.hnz.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.cSf;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.hnk.setText(sb);
        if (this.hnA == null) {
            c.kV().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.cSf.getContext(), (int) R.string.share_failed);
                        if (a.this.hnz != null) {
                            a.this.hnz.onCancel();
                        }
                    }
                    a.this.hnA = new BlurDrawable(a.this.cSf.getContext());
                    a.this.hnA.init(2, 4, aVar.getRawBitmap());
                    a.this.hnA.drawBlur();
                    a.this.hmX.setImageBitmap(a.this.hnA.getBlurredBitmap());
                }
            }, null);
        }
        this.gbW.startLoad(gameShareData.headBgUrl, 10, false);
        this.hnt.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.hna.startLoad(gameShareData.gameIconUrl, 10, false);
            this.hnb.setText(gameShareData.gameName);
            this.hnc.setText(gameShareData.gameDescription);
            this.hnd.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.hnj);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.hnl.startLoad(gameShareData.userPortrait, 12, false);
            this.cAX.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.hnr);
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

    public Bitmap bSI() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bSJ() {
        return this.fsZ.getBottom();
    }

    public void onDestroy() {
        if (this.hnA != null) {
            this.hnA.onDestroy();
            this.hnA = null;
        }
    }
}

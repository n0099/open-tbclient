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
    private TextView cBd;
    private FrameLayout cSk;
    private LinearLayout fWD;
    private LinearLayout fte;
    private TbImageView gcb;
    private TextView hnA;
    private TextView hnB;
    private TextView hnC;
    private TextView hnD;
    private TextView hnE;
    private InterfaceC0565a hnF;
    private BlurDrawable hnG;
    private ImageView hnd;
    private FrameLayout hne;
    private ColumnLayout hnf;
    private TbImageView hng;
    private TextView hnh;
    private TextView hni;
    private TextView hnj;
    private RadioButton hnk;
    private RadioButton hnl;
    private RadioButton hnm;
    private RadioButton hnn;
    private RadioButton hno;
    private RadioButton[] hnp;
    private TextView hnq;
    private TbImageView hnr;
    private RadioButton hns;
    private RadioButton hnt;
    private RadioButton hnu;
    private RadioButton hnv;
    private RadioButton hnw;
    private RadioButton[] hnx;
    private TextView hny;
    private TbImageView hnz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0565a {
        void onCancel();

        void v(Bitmap bitmap);

        void w(Bitmap bitmap);

        void x(Bitmap bitmap);

        void y(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0565a interfaceC0565a) {
        this.hnF = interfaceC0565a;
        this.cSk = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.cSk.findViewById(R.id.game_share_content_layout);
        this.hnd = (ImageView) this.cSk.findViewById(R.id.game_share_content_bg_view);
        this.fte = (LinearLayout) this.cSk.findViewById(R.id.game_share_card_layout);
        this.hne = (FrameLayout) this.cSk.findViewById(R.id.game_share_header_root);
        this.hnf = (ColumnLayout) this.cSk.findViewById(R.id.game_share_header_layout);
        this.gcb = (TbImageView) this.cSk.findViewById(R.id.game_share_header_bg_view);
        this.gcb.setVisibility(4);
        this.gcb.setDefaultBg(new ColorDrawable(this.cSk.getResources().getColor(R.color.transparent)));
        this.gcb.setDrawerType(1);
        this.gcb.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.gcb.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.gcb.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hng = (TbImageView) this.cSk.findViewById(R.id.game_share_game_icon);
        this.hng.setDrawerType(1);
        this.hng.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.hnh = (TextView) this.cSk.findViewById(R.id.game_share_game_name);
        this.hni = (TextView) this.cSk.findViewById(R.id.game_share_game_description);
        this.hnj = (TextView) this.cSk.findViewById(R.id.game_share_game_score);
        this.hnk = (RadioButton) this.cSk.findViewById(R.id.game_share_score_grade_1);
        this.hnl = (RadioButton) this.cSk.findViewById(R.id.game_share_score_grade_2);
        this.hnm = (RadioButton) this.cSk.findViewById(R.id.game_share_score_grade_3);
        this.hnn = (RadioButton) this.cSk.findViewById(R.id.game_share_score_grade_4);
        this.hno = (RadioButton) this.cSk.findViewById(R.id.game_share_score_grade_5);
        this.hnp = new RadioButton[]{this.hnk, this.hnl, this.hnm, this.hnn, this.hno};
        this.hnq = (TextView) this.cSk.findViewById(R.id.game_share_comment);
        this.hnr = (TbImageView) this.cSk.findViewById(R.id.game_share_user_protrait);
        this.hnr.setDrawerType(1);
        this.hnr.setIsRound(true);
        this.cBd = (TextView) this.cSk.findViewById(R.id.game_share_user_name);
        this.hns = (RadioButton) this.cSk.findViewById(R.id.game_share_user_score_grade_1);
        this.hnt = (RadioButton) this.cSk.findViewById(R.id.game_share_user_score_grade_2);
        this.hnu = (RadioButton) this.cSk.findViewById(R.id.game_share_user_score_grade_3);
        this.hnv = (RadioButton) this.cSk.findViewById(R.id.game_share_user_score_grade_4);
        this.hnw = (RadioButton) this.cSk.findViewById(R.id.game_share_user_score_grade_5);
        this.hnx = new RadioButton[]{this.hns, this.hnt, this.hnu, this.hnv, this.hnw};
        this.hny = (TextView) this.cSk.findViewById(R.id.game_share_qr_txt);
        this.hnz = (TbImageView) this.cSk.findViewById(R.id.game_share_qr_img);
        this.fWD = (LinearLayout) this.cSk.findViewById(R.id.game_share_entry_layout);
        this.hnA = (TextView) this.cSk.findViewById(R.id.game_share_entry_weixin);
        this.hnA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bSG = a.this.bSG();
                if (bSG != null && a.this.hnF != null) {
                    a.this.hnF.v(bSG);
                }
            }
        });
        this.hnB = (TextView) this.cSk.findViewById(R.id.game_share_entry_wxfriends);
        this.hnB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bSG = a.this.bSG();
                if (bSG != null && a.this.hnF != null) {
                    a.this.hnF.w(bSG);
                }
            }
        });
        this.hnC = (TextView) this.cSk.findViewById(R.id.game_share_entry_qq);
        this.hnC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bSG = a.this.bSG();
                if (bSG != null && a.this.hnF != null) {
                    a.this.hnF.x(bSG);
                }
            }
        });
        this.hnD = (TextView) this.cSk.findViewById(R.id.game_share_entry_sina);
        this.hnD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bSG = a.this.bSG();
                if (bSG != null && a.this.hnF != null) {
                    a.this.hnF.y(bSG);
                }
            }
        });
        this.hnE = (TextView) this.cSk.findViewById(R.id.game_share_cancel);
        this.hnE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hnF != null) {
                    a.this.hnF.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.cSk;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.hnq.setText(sb);
        if (this.hnG == null) {
            c.kV().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.cSk.getContext(), (int) R.string.share_failed);
                        if (a.this.hnF != null) {
                            a.this.hnF.onCancel();
                        }
                    }
                    a.this.hnG = new BlurDrawable(a.this.cSk.getContext());
                    a.this.hnG.init(2, 4, aVar.getRawBitmap());
                    a.this.hnG.drawBlur();
                    a.this.hnd.setImageBitmap(a.this.hnG.getBlurredBitmap());
                }
            }, null);
        }
        this.gcb.startLoad(gameShareData.headBgUrl, 10, false);
        this.hnz.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.hng.startLoad(gameShareData.gameIconUrl, 10, false);
            this.hnh.setText(gameShareData.gameName);
            this.hni.setText(gameShareData.gameDescription);
            this.hnj.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.hnp);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.hnr.startLoad(gameShareData.userPortrait, 12, false);
            this.cBd.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.hnx);
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

    public Bitmap bSG() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bSH() {
        return this.fte.getBottom();
    }

    public void onDestroy() {
        if (this.hnG != null) {
            this.hnG.onDestroy();
            this.hnG = null;
        }
    }
}

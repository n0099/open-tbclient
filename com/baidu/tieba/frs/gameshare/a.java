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
    private TextView dXU;
    private FrameLayout ddl;
    private LinearLayout fHh;
    private LinearLayout glI;
    private TbImageView grg;
    private ImageView hCE;
    private FrameLayout hCF;
    private ColumnLayout hCG;
    private TbImageView hCH;
    private TextView hCI;
    private TextView hCJ;
    private TextView hCK;
    private RadioButton hCL;
    private RadioButton hCM;
    private RadioButton hCN;
    private RadioButton hCO;
    private RadioButton hCP;
    private RadioButton[] hCQ;
    private TextView hCR;
    private TbImageView hCS;
    private RadioButton hCT;
    private RadioButton hCU;
    private RadioButton hCV;
    private RadioButton hCW;
    private RadioButton hCX;
    private RadioButton[] hCY;
    private TextView hCZ;
    private TbImageView hDa;
    private TextView hDb;
    private TextView hDc;
    private TextView hDd;
    private TextView hDe;
    private TextView hDf;
    private InterfaceC0615a hDg;
    private BlurDrawable hDh;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0615a {
        void onCancel();

        void v(Bitmap bitmap);

        void w(Bitmap bitmap);

        void x(Bitmap bitmap);

        void y(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0615a interfaceC0615a) {
        this.hDg = interfaceC0615a;
        this.ddl = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.ddl.findViewById(R.id.game_share_content_layout);
        this.hCE = (ImageView) this.ddl.findViewById(R.id.game_share_content_bg_view);
        this.fHh = (LinearLayout) this.ddl.findViewById(R.id.game_share_card_layout);
        this.hCF = (FrameLayout) this.ddl.findViewById(R.id.game_share_header_root);
        this.hCG = (ColumnLayout) this.ddl.findViewById(R.id.game_share_header_layout);
        this.grg = (TbImageView) this.ddl.findViewById(R.id.game_share_header_bg_view);
        this.grg.setVisibility(4);
        this.grg.setDefaultBg(new ColorDrawable(this.ddl.getResources().getColor(R.color.transparent)));
        this.grg.setDrawerType(1);
        this.grg.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.grg.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.grg.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hCH = (TbImageView) this.ddl.findViewById(R.id.game_share_game_icon);
        this.hCH.setDrawerType(1);
        this.hCH.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.hCI = (TextView) this.ddl.findViewById(R.id.game_share_game_name);
        this.hCJ = (TextView) this.ddl.findViewById(R.id.game_share_game_description);
        this.hCK = (TextView) this.ddl.findViewById(R.id.game_share_game_score);
        this.hCL = (RadioButton) this.ddl.findViewById(R.id.game_share_score_grade_1);
        this.hCM = (RadioButton) this.ddl.findViewById(R.id.game_share_score_grade_2);
        this.hCN = (RadioButton) this.ddl.findViewById(R.id.game_share_score_grade_3);
        this.hCO = (RadioButton) this.ddl.findViewById(R.id.game_share_score_grade_4);
        this.hCP = (RadioButton) this.ddl.findViewById(R.id.game_share_score_grade_5);
        this.hCQ = new RadioButton[]{this.hCL, this.hCM, this.hCN, this.hCO, this.hCP};
        this.hCR = (TextView) this.ddl.findViewById(R.id.game_share_comment);
        this.hCS = (TbImageView) this.ddl.findViewById(R.id.game_share_user_protrait);
        this.hCS.setDrawerType(1);
        this.hCS.setIsRound(true);
        this.dXU = (TextView) this.ddl.findViewById(R.id.game_share_user_name);
        this.hCT = (RadioButton) this.ddl.findViewById(R.id.game_share_user_score_grade_1);
        this.hCU = (RadioButton) this.ddl.findViewById(R.id.game_share_user_score_grade_2);
        this.hCV = (RadioButton) this.ddl.findViewById(R.id.game_share_user_score_grade_3);
        this.hCW = (RadioButton) this.ddl.findViewById(R.id.game_share_user_score_grade_4);
        this.hCX = (RadioButton) this.ddl.findViewById(R.id.game_share_user_score_grade_5);
        this.hCY = new RadioButton[]{this.hCT, this.hCU, this.hCV, this.hCW, this.hCX};
        this.hCZ = (TextView) this.ddl.findViewById(R.id.game_share_qr_txt);
        this.hDa = (TbImageView) this.ddl.findViewById(R.id.game_share_qr_img);
        this.glI = (LinearLayout) this.ddl.findViewById(R.id.game_share_entry_layout);
        this.hDb = (TextView) this.ddl.findViewById(R.id.game_share_entry_weixin);
        this.hDb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bZk = a.this.bZk();
                if (bZk != null && a.this.hDg != null) {
                    a.this.hDg.v(bZk);
                }
            }
        });
        this.hDc = (TextView) this.ddl.findViewById(R.id.game_share_entry_wxfriends);
        this.hDc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bZk = a.this.bZk();
                if (bZk != null && a.this.hDg != null) {
                    a.this.hDg.w(bZk);
                }
            }
        });
        this.hDd = (TextView) this.ddl.findViewById(R.id.game_share_entry_qq);
        this.hDd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bZk = a.this.bZk();
                if (bZk != null && a.this.hDg != null) {
                    a.this.hDg.x(bZk);
                }
            }
        });
        this.hDe = (TextView) this.ddl.findViewById(R.id.game_share_entry_sina);
        this.hDe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bZk = a.this.bZk();
                if (bZk != null && a.this.hDg != null) {
                    a.this.hDg.y(bZk);
                }
            }
        });
        this.hDf = (TextView) this.ddl.findViewById(R.id.game_share_cancel);
        this.hDf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hDg != null) {
                    a.this.hDg.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.ddl;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.hCR.setText(sb);
        if (this.hDh == null) {
            c.kX().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.ddl.getContext(), (int) R.string.share_failed);
                        if (a.this.hDg != null) {
                            a.this.hDg.onCancel();
                        }
                    }
                    a.this.hDh = new BlurDrawable(a.this.ddl.getContext());
                    a.this.hDh.init(2, 4, aVar.getRawBitmap());
                    a.this.hDh.drawBlur();
                    a.this.hCE.setImageBitmap(a.this.hDh.getBlurredBitmap());
                }
            }, null);
        }
        this.grg.startLoad(gameShareData.headBgUrl, 10, false);
        this.hDa.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.hCH.startLoad(gameShareData.gameIconUrl, 10, false);
            this.hCI.setText(gameShareData.gameName);
            this.hCJ.setText(gameShareData.gameDescription);
            this.hCK.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.hCQ);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.hCS.startLoad(gameShareData.userPortrait, 12, false);
            this.dXU.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.hCY);
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

    public Bitmap bZk() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bZl() {
        return this.fHh.getBottom();
    }

    public void onDestroy() {
        if (this.hDh != null) {
            this.hDh.onDestroy();
            this.hDh = null;
        }
    }
}

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
    private FrameLayout ajk;
    private TextView eBQ;
    private LinearLayout hKm;
    private TbImageView hPN;
    private LinearLayout hct;
    private ImageView jmA;
    private FrameLayout jmB;
    private ColumnLayout jmC;
    private TbImageView jmD;
    private TextView jmE;
    private TextView jmF;
    private TextView jmG;
    private RadioButton jmH;
    private RadioButton jmI;
    private RadioButton jmJ;
    private RadioButton jmK;
    private RadioButton jmL;
    private RadioButton[] jmM;
    private TextView jmN;
    private TbImageView jmO;
    private RadioButton jmP;
    private RadioButton jmQ;
    private RadioButton jmR;
    private RadioButton jmS;
    private RadioButton jmT;
    private RadioButton[] jmU;
    private TextView jmV;
    private TbImageView jmW;
    private TextView jmX;
    private TextView jmY;
    private TextView jmZ;
    private TextView jna;
    private TextView jnb;
    private InterfaceC0746a jnc;
    private BlurDrawable jnd;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0746a {
        void A(Bitmap bitmap);

        void B(Bitmap bitmap);

        void C(Bitmap bitmap);

        void onCancel();

        void z(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0746a interfaceC0746a) {
        this.jnc = interfaceC0746a;
        this.ajk = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.ajk.findViewById(R.id.game_share_content_layout);
        this.jmA = (ImageView) this.ajk.findViewById(R.id.game_share_content_bg_view);
        this.hct = (LinearLayout) this.ajk.findViewById(R.id.game_share_card_layout);
        this.jmB = (FrameLayout) this.ajk.findViewById(R.id.game_share_header_root);
        this.jmC = (ColumnLayout) this.ajk.findViewById(R.id.game_share_header_layout);
        this.hPN = (TbImageView) this.ajk.findViewById(R.id.game_share_header_bg_view);
        this.hPN.setVisibility(4);
        this.hPN.setDefaultBg(new ColorDrawable(this.ajk.getResources().getColor(R.color.transparent)));
        this.hPN.setDrawerType(1);
        this.hPN.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.hPN.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.hPN.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.jmD = (TbImageView) this.ajk.findViewById(R.id.game_share_game_icon);
        this.jmD.setDrawerType(1);
        this.jmD.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.jmE = (TextView) this.ajk.findViewById(R.id.game_share_game_name);
        this.jmF = (TextView) this.ajk.findViewById(R.id.game_share_game_description);
        this.jmG = (TextView) this.ajk.findViewById(R.id.game_share_game_score);
        this.jmH = (RadioButton) this.ajk.findViewById(R.id.game_share_score_grade_1);
        this.jmI = (RadioButton) this.ajk.findViewById(R.id.game_share_score_grade_2);
        this.jmJ = (RadioButton) this.ajk.findViewById(R.id.game_share_score_grade_3);
        this.jmK = (RadioButton) this.ajk.findViewById(R.id.game_share_score_grade_4);
        this.jmL = (RadioButton) this.ajk.findViewById(R.id.game_share_score_grade_5);
        this.jmM = new RadioButton[]{this.jmH, this.jmI, this.jmJ, this.jmK, this.jmL};
        this.jmN = (TextView) this.ajk.findViewById(R.id.game_share_comment);
        this.jmO = (TbImageView) this.ajk.findViewById(R.id.game_share_user_protrait);
        this.jmO.setDrawerType(1);
        this.jmO.setIsRound(true);
        this.eBQ = (TextView) this.ajk.findViewById(R.id.game_share_user_name);
        this.jmP = (RadioButton) this.ajk.findViewById(R.id.game_share_user_score_grade_1);
        this.jmQ = (RadioButton) this.ajk.findViewById(R.id.game_share_user_score_grade_2);
        this.jmR = (RadioButton) this.ajk.findViewById(R.id.game_share_user_score_grade_3);
        this.jmS = (RadioButton) this.ajk.findViewById(R.id.game_share_user_score_grade_4);
        this.jmT = (RadioButton) this.ajk.findViewById(R.id.game_share_user_score_grade_5);
        this.jmU = new RadioButton[]{this.jmP, this.jmQ, this.jmR, this.jmS, this.jmT};
        this.jmV = (TextView) this.ajk.findViewById(R.id.game_share_qr_txt);
        this.jmW = (TbImageView) this.ajk.findViewById(R.id.game_share_qr_img);
        this.hKm = (LinearLayout) this.ajk.findViewById(R.id.game_share_entry_layout);
        this.jmX = (TextView) this.ajk.findViewById(R.id.game_share_entry_weixin);
        this.jmX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap blO = a.this.blO();
                if (blO != null && a.this.jnc != null) {
                    a.this.jnc.z(blO);
                }
            }
        });
        this.jmY = (TextView) this.ajk.findViewById(R.id.game_share_entry_wxfriends);
        this.jmY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap blO = a.this.blO();
                if (blO != null && a.this.jnc != null) {
                    a.this.jnc.A(blO);
                }
            }
        });
        this.jmZ = (TextView) this.ajk.findViewById(R.id.game_share_entry_qq);
        this.jmZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap blO = a.this.blO();
                if (blO != null && a.this.jnc != null) {
                    a.this.jnc.B(blO);
                }
            }
        });
        this.jna = (TextView) this.ajk.findViewById(R.id.game_share_entry_sina);
        this.jna.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap blO = a.this.blO();
                if (blO != null && a.this.jnc != null) {
                    a.this.jnc.C(blO);
                }
            }
        });
        this.jnb = (TextView) this.ajk.findViewById(R.id.game_share_cancel);
        this.jnb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jnc != null) {
                    a.this.jnc.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.ajk;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.jmN.setText(sb);
        if (this.jnd == null) {
            c.mS().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.ajk.getContext(), (int) R.string.share_failed);
                        if (a.this.jnc != null) {
                            a.this.jnc.onCancel();
                        }
                    }
                    a.this.jnd = new BlurDrawable(a.this.ajk.getContext());
                    a.this.jnd.init(2, 4, aVar.getRawBitmap());
                    a.this.jnd.drawBlur();
                    a.this.jmA.setImageBitmap(a.this.jnd.getBlurredBitmap());
                }
            }, null);
        }
        this.hPN.startLoad(gameShareData.headBgUrl, 10, false);
        this.jmW.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.jmD.startLoad(gameShareData.gameIconUrl, 10, false);
            this.jmE.setText(gameShareData.gameName);
            this.jmF.setText(gameShareData.gameDescription);
            this.jmG.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.jmM);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.jmO.startLoad(gameShareData.userPortrait, 12, false);
            this.eBQ.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.jmU);
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

    public Bitmap blO() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int cHL() {
        return this.hct.getBottom();
    }

    public void onDestroy() {
        if (this.jnd != null) {
            this.jnd.onDestroy();
            this.jnd = null;
        }
    }
}

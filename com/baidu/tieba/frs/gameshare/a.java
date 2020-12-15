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
    private LinearLayout hKo;
    private TbImageView hPP;
    private LinearLayout hcv;
    private ImageView jmC;
    private FrameLayout jmD;
    private ColumnLayout jmE;
    private TbImageView jmF;
    private TextView jmG;
    private TextView jmH;
    private TextView jmI;
    private RadioButton jmJ;
    private RadioButton jmK;
    private RadioButton jmL;
    private RadioButton jmM;
    private RadioButton jmN;
    private RadioButton[] jmO;
    private TextView jmP;
    private TbImageView jmQ;
    private RadioButton jmR;
    private RadioButton jmS;
    private RadioButton jmT;
    private RadioButton jmU;
    private RadioButton jmV;
    private RadioButton[] jmW;
    private TextView jmX;
    private TbImageView jmY;
    private TextView jmZ;
    private TextView jna;
    private TextView jnb;
    private TextView jnc;
    private TextView jnd;
    private InterfaceC0746a jne;
    private BlurDrawable jnf;
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
        this.jne = interfaceC0746a;
        this.ajk = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.ajk.findViewById(R.id.game_share_content_layout);
        this.jmC = (ImageView) this.ajk.findViewById(R.id.game_share_content_bg_view);
        this.hcv = (LinearLayout) this.ajk.findViewById(R.id.game_share_card_layout);
        this.jmD = (FrameLayout) this.ajk.findViewById(R.id.game_share_header_root);
        this.jmE = (ColumnLayout) this.ajk.findViewById(R.id.game_share_header_layout);
        this.hPP = (TbImageView) this.ajk.findViewById(R.id.game_share_header_bg_view);
        this.hPP.setVisibility(4);
        this.hPP.setDefaultBg(new ColorDrawable(this.ajk.getResources().getColor(R.color.transparent)));
        this.hPP.setDrawerType(1);
        this.hPP.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.hPP.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.hPP.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.jmF = (TbImageView) this.ajk.findViewById(R.id.game_share_game_icon);
        this.jmF.setDrawerType(1);
        this.jmF.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.jmG = (TextView) this.ajk.findViewById(R.id.game_share_game_name);
        this.jmH = (TextView) this.ajk.findViewById(R.id.game_share_game_description);
        this.jmI = (TextView) this.ajk.findViewById(R.id.game_share_game_score);
        this.jmJ = (RadioButton) this.ajk.findViewById(R.id.game_share_score_grade_1);
        this.jmK = (RadioButton) this.ajk.findViewById(R.id.game_share_score_grade_2);
        this.jmL = (RadioButton) this.ajk.findViewById(R.id.game_share_score_grade_3);
        this.jmM = (RadioButton) this.ajk.findViewById(R.id.game_share_score_grade_4);
        this.jmN = (RadioButton) this.ajk.findViewById(R.id.game_share_score_grade_5);
        this.jmO = new RadioButton[]{this.jmJ, this.jmK, this.jmL, this.jmM, this.jmN};
        this.jmP = (TextView) this.ajk.findViewById(R.id.game_share_comment);
        this.jmQ = (TbImageView) this.ajk.findViewById(R.id.game_share_user_protrait);
        this.jmQ.setDrawerType(1);
        this.jmQ.setIsRound(true);
        this.eBQ = (TextView) this.ajk.findViewById(R.id.game_share_user_name);
        this.jmR = (RadioButton) this.ajk.findViewById(R.id.game_share_user_score_grade_1);
        this.jmS = (RadioButton) this.ajk.findViewById(R.id.game_share_user_score_grade_2);
        this.jmT = (RadioButton) this.ajk.findViewById(R.id.game_share_user_score_grade_3);
        this.jmU = (RadioButton) this.ajk.findViewById(R.id.game_share_user_score_grade_4);
        this.jmV = (RadioButton) this.ajk.findViewById(R.id.game_share_user_score_grade_5);
        this.jmW = new RadioButton[]{this.jmR, this.jmS, this.jmT, this.jmU, this.jmV};
        this.jmX = (TextView) this.ajk.findViewById(R.id.game_share_qr_txt);
        this.jmY = (TbImageView) this.ajk.findViewById(R.id.game_share_qr_img);
        this.hKo = (LinearLayout) this.ajk.findViewById(R.id.game_share_entry_layout);
        this.jmZ = (TextView) this.ajk.findViewById(R.id.game_share_entry_weixin);
        this.jmZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap blO = a.this.blO();
                if (blO != null && a.this.jne != null) {
                    a.this.jne.z(blO);
                }
            }
        });
        this.jna = (TextView) this.ajk.findViewById(R.id.game_share_entry_wxfriends);
        this.jna.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap blO = a.this.blO();
                if (blO != null && a.this.jne != null) {
                    a.this.jne.A(blO);
                }
            }
        });
        this.jnb = (TextView) this.ajk.findViewById(R.id.game_share_entry_qq);
        this.jnb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap blO = a.this.blO();
                if (blO != null && a.this.jne != null) {
                    a.this.jne.B(blO);
                }
            }
        });
        this.jnc = (TextView) this.ajk.findViewById(R.id.game_share_entry_sina);
        this.jnc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap blO = a.this.blO();
                if (blO != null && a.this.jne != null) {
                    a.this.jne.C(blO);
                }
            }
        });
        this.jnd = (TextView) this.ajk.findViewById(R.id.game_share_cancel);
        this.jnd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jne != null) {
                    a.this.jne.onCancel();
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
        this.jmP.setText(sb);
        if (this.jnf == null) {
            c.mS().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.ajk.getContext(), (int) R.string.share_failed);
                        if (a.this.jne != null) {
                            a.this.jne.onCancel();
                        }
                    }
                    a.this.jnf = new BlurDrawable(a.this.ajk.getContext());
                    a.this.jnf.init(2, 4, aVar.getRawBitmap());
                    a.this.jnf.drawBlur();
                    a.this.jmC.setImageBitmap(a.this.jnf.getBlurredBitmap());
                }
            }, null);
        }
        this.hPP.startLoad(gameShareData.headBgUrl, 10, false);
        this.jmY.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.jmF.startLoad(gameShareData.gameIconUrl, 10, false);
            this.jmG.setText(gameShareData.gameName);
            this.jmH.setText(gameShareData.gameDescription);
            this.jmI.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.jmO);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.jmQ.startLoad(gameShareData.userPortrait, 12, false);
            this.eBQ.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.jmW);
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

    public int cHM() {
        return this.hcv.getBottom();
    }

    public void onDestroy() {
        if (this.jnf != null) {
            this.jnf.onDestroy();
            this.jnf = null;
        }
    }
}

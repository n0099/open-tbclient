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
    private FrameLayout agu;
    private TextView dEL;
    private LinearLayout fSq;
    private TbImageView gDV;
    private LinearLayout gyw;
    private ImageView hPM;
    private FrameLayout hPN;
    private ColumnLayout hPO;
    private TbImageView hPP;
    private TextView hPQ;
    private TextView hPR;
    private TextView hPS;
    private RadioButton hPT;
    private RadioButton hPU;
    private RadioButton hPV;
    private RadioButton hPW;
    private RadioButton hPX;
    private RadioButton[] hPY;
    private TextView hPZ;
    private TbImageView hQa;
    private RadioButton hQb;
    private RadioButton hQc;
    private RadioButton hQd;
    private RadioButton hQe;
    private RadioButton hQf;
    private RadioButton[] hQg;
    private TextView hQh;
    private TbImageView hQi;
    private TextView hQj;
    private TextView hQk;
    private TextView hQl;
    private TextView hQm;
    private TextView hQn;
    private InterfaceC0623a hQo;
    private BlurDrawable hQp;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0623a {
        void onCancel();

        void w(Bitmap bitmap);

        void x(Bitmap bitmap);

        void y(Bitmap bitmap);

        void z(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0623a interfaceC0623a) {
        this.hQo = interfaceC0623a;
        this.agu = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.agu.findViewById(R.id.game_share_content_layout);
        this.hPM = (ImageView) this.agu.findViewById(R.id.game_share_content_bg_view);
        this.fSq = (LinearLayout) this.agu.findViewById(R.id.game_share_card_layout);
        this.hPN = (FrameLayout) this.agu.findViewById(R.id.game_share_header_root);
        this.hPO = (ColumnLayout) this.agu.findViewById(R.id.game_share_header_layout);
        this.gDV = (TbImageView) this.agu.findViewById(R.id.game_share_header_bg_view);
        this.gDV.setVisibility(4);
        this.gDV.setDefaultBg(new ColorDrawable(this.agu.getResources().getColor(R.color.transparent)));
        this.gDV.setDrawerType(1);
        this.gDV.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.gDV.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.gDV.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hPP = (TbImageView) this.agu.findViewById(R.id.game_share_game_icon);
        this.hPP.setDrawerType(1);
        this.hPP.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.hPQ = (TextView) this.agu.findViewById(R.id.game_share_game_name);
        this.hPR = (TextView) this.agu.findViewById(R.id.game_share_game_description);
        this.hPS = (TextView) this.agu.findViewById(R.id.game_share_game_score);
        this.hPT = (RadioButton) this.agu.findViewById(R.id.game_share_score_grade_1);
        this.hPU = (RadioButton) this.agu.findViewById(R.id.game_share_score_grade_2);
        this.hPV = (RadioButton) this.agu.findViewById(R.id.game_share_score_grade_3);
        this.hPW = (RadioButton) this.agu.findViewById(R.id.game_share_score_grade_4);
        this.hPX = (RadioButton) this.agu.findViewById(R.id.game_share_score_grade_5);
        this.hPY = new RadioButton[]{this.hPT, this.hPU, this.hPV, this.hPW, this.hPX};
        this.hPZ = (TextView) this.agu.findViewById(R.id.game_share_comment);
        this.hQa = (TbImageView) this.agu.findViewById(R.id.game_share_user_protrait);
        this.hQa.setDrawerType(1);
        this.hQa.setIsRound(true);
        this.dEL = (TextView) this.agu.findViewById(R.id.game_share_user_name);
        this.hQb = (RadioButton) this.agu.findViewById(R.id.game_share_user_score_grade_1);
        this.hQc = (RadioButton) this.agu.findViewById(R.id.game_share_user_score_grade_2);
        this.hQd = (RadioButton) this.agu.findViewById(R.id.game_share_user_score_grade_3);
        this.hQe = (RadioButton) this.agu.findViewById(R.id.game_share_user_score_grade_4);
        this.hQf = (RadioButton) this.agu.findViewById(R.id.game_share_user_score_grade_5);
        this.hQg = new RadioButton[]{this.hQb, this.hQc, this.hQd, this.hQe, this.hQf};
        this.hQh = (TextView) this.agu.findViewById(R.id.game_share_qr_txt);
        this.hQi = (TbImageView) this.agu.findViewById(R.id.game_share_qr_img);
        this.gyw = (LinearLayout) this.agu.findViewById(R.id.game_share_entry_layout);
        this.hQj = (TextView) this.agu.findViewById(R.id.game_share_entry_weixin);
        this.hQj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aPt = a.this.aPt();
                if (aPt != null && a.this.hQo != null) {
                    a.this.hQo.w(aPt);
                }
            }
        });
        this.hQk = (TextView) this.agu.findViewById(R.id.game_share_entry_wxfriends);
        this.hQk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aPt = a.this.aPt();
                if (aPt != null && a.this.hQo != null) {
                    a.this.hQo.x(aPt);
                }
            }
        });
        this.hQl = (TextView) this.agu.findViewById(R.id.game_share_entry_qq);
        this.hQl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aPt = a.this.aPt();
                if (aPt != null && a.this.hQo != null) {
                    a.this.hQo.y(aPt);
                }
            }
        });
        this.hQm = (TextView) this.agu.findViewById(R.id.game_share_entry_sina);
        this.hQm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aPt = a.this.aPt();
                if (aPt != null && a.this.hQo != null) {
                    a.this.hQo.z(aPt);
                }
            }
        });
        this.hQn = (TextView) this.agu.findViewById(R.id.game_share_cancel);
        this.hQn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hQo != null) {
                    a.this.hQo.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.agu;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.hPZ.setText(sb);
        if (this.hQp == null) {
            c.ln().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.agu.getContext(), (int) R.string.share_failed);
                        if (a.this.hQo != null) {
                            a.this.hQo.onCancel();
                        }
                    }
                    a.this.hQp = new BlurDrawable(a.this.agu.getContext());
                    a.this.hQp.init(2, 4, aVar.getRawBitmap());
                    a.this.hQp.drawBlur();
                    a.this.hPM.setImageBitmap(a.this.hQp.getBlurredBitmap());
                }
            }, null);
        }
        this.gDV.startLoad(gameShareData.headBgUrl, 10, false);
        this.hQi.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.hPP.startLoad(gameShareData.gameIconUrl, 10, false);
            this.hPQ.setText(gameShareData.gameName);
            this.hPR.setText(gameShareData.gameDescription);
            this.hPS.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.hPY);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.hQa.startLoad(gameShareData.userPortrait, 12, false);
            this.dEL.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.hQg);
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

    public Bitmap aPt() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int ccA() {
        return this.fSq.getBottom();
    }

    public void onDestroy() {
        if (this.hQp != null) {
            this.hQp.onDestroy();
            this.hQp = null;
        }
    }
}

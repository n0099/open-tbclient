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
/* loaded from: classes16.dex */
public class a {
    private FrameLayout agl;
    private TextView dKI;
    private LinearLayout fXJ;
    private LinearLayout gDX;
    private TbImageView gJs;
    private ImageView hVL;
    private FrameLayout hVM;
    private ColumnLayout hVN;
    private TbImageView hVO;
    private TextView hVP;
    private TextView hVQ;
    private TextView hVR;
    private RadioButton hVS;
    private RadioButton hVT;
    private RadioButton hVU;
    private RadioButton hVV;
    private RadioButton hVW;
    private RadioButton[] hVX;
    private TextView hVY;
    private TbImageView hVZ;
    private RadioButton hWa;
    private RadioButton hWb;
    private RadioButton hWc;
    private RadioButton hWd;
    private RadioButton hWe;
    private RadioButton[] hWf;
    private TextView hWg;
    private TbImageView hWh;
    private TextView hWi;
    private TextView hWj;
    private TextView hWk;
    private TextView hWl;
    private TextView hWm;
    private InterfaceC0633a hWn;
    private BlurDrawable hWo;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0633a {
        void A(Bitmap bitmap);

        void B(Bitmap bitmap);

        void C(Bitmap bitmap);

        void onCancel();

        void z(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0633a interfaceC0633a) {
        this.hWn = interfaceC0633a;
        this.agl = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.agl.findViewById(R.id.game_share_content_layout);
        this.hVL = (ImageView) this.agl.findViewById(R.id.game_share_content_bg_view);
        this.fXJ = (LinearLayout) this.agl.findViewById(R.id.game_share_card_layout);
        this.hVM = (FrameLayout) this.agl.findViewById(R.id.game_share_header_root);
        this.hVN = (ColumnLayout) this.agl.findViewById(R.id.game_share_header_layout);
        this.gJs = (TbImageView) this.agl.findViewById(R.id.game_share_header_bg_view);
        this.gJs.setVisibility(4);
        this.gJs.setDefaultBg(new ColorDrawable(this.agl.getResources().getColor(R.color.transparent)));
        this.gJs.setDrawerType(1);
        this.gJs.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.gJs.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.gJs.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hVO = (TbImageView) this.agl.findViewById(R.id.game_share_game_icon);
        this.hVO.setDrawerType(1);
        this.hVO.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.hVP = (TextView) this.agl.findViewById(R.id.game_share_game_name);
        this.hVQ = (TextView) this.agl.findViewById(R.id.game_share_game_description);
        this.hVR = (TextView) this.agl.findViewById(R.id.game_share_game_score);
        this.hVS = (RadioButton) this.agl.findViewById(R.id.game_share_score_grade_1);
        this.hVT = (RadioButton) this.agl.findViewById(R.id.game_share_score_grade_2);
        this.hVU = (RadioButton) this.agl.findViewById(R.id.game_share_score_grade_3);
        this.hVV = (RadioButton) this.agl.findViewById(R.id.game_share_score_grade_4);
        this.hVW = (RadioButton) this.agl.findViewById(R.id.game_share_score_grade_5);
        this.hVX = new RadioButton[]{this.hVS, this.hVT, this.hVU, this.hVV, this.hVW};
        this.hVY = (TextView) this.agl.findViewById(R.id.game_share_comment);
        this.hVZ = (TbImageView) this.agl.findViewById(R.id.game_share_user_protrait);
        this.hVZ.setDrawerType(1);
        this.hVZ.setIsRound(true);
        this.dKI = (TextView) this.agl.findViewById(R.id.game_share_user_name);
        this.hWa = (RadioButton) this.agl.findViewById(R.id.game_share_user_score_grade_1);
        this.hWb = (RadioButton) this.agl.findViewById(R.id.game_share_user_score_grade_2);
        this.hWc = (RadioButton) this.agl.findViewById(R.id.game_share_user_score_grade_3);
        this.hWd = (RadioButton) this.agl.findViewById(R.id.game_share_user_score_grade_4);
        this.hWe = (RadioButton) this.agl.findViewById(R.id.game_share_user_score_grade_5);
        this.hWf = new RadioButton[]{this.hWa, this.hWb, this.hWc, this.hWd, this.hWe};
        this.hWg = (TextView) this.agl.findViewById(R.id.game_share_qr_txt);
        this.hWh = (TbImageView) this.agl.findViewById(R.id.game_share_qr_img);
        this.gDX = (LinearLayout) this.agl.findViewById(R.id.game_share_entry_layout);
        this.hWi = (TextView) this.agl.findViewById(R.id.game_share_entry_weixin);
        this.hWi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aTo = a.this.aTo();
                if (aTo != null && a.this.hWn != null) {
                    a.this.hWn.z(aTo);
                }
            }
        });
        this.hWj = (TextView) this.agl.findViewById(R.id.game_share_entry_wxfriends);
        this.hWj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aTo = a.this.aTo();
                if (aTo != null && a.this.hWn != null) {
                    a.this.hWn.A(aTo);
                }
            }
        });
        this.hWk = (TextView) this.agl.findViewById(R.id.game_share_entry_qq);
        this.hWk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aTo = a.this.aTo();
                if (aTo != null && a.this.hWn != null) {
                    a.this.hWn.B(aTo);
                }
            }
        });
        this.hWl = (TextView) this.agl.findViewById(R.id.game_share_entry_sina);
        this.hWl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aTo = a.this.aTo();
                if (aTo != null && a.this.hWn != null) {
                    a.this.hWn.C(aTo);
                }
            }
        });
        this.hWm = (TextView) this.agl.findViewById(R.id.game_share_cancel);
        this.hWm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hWn != null) {
                    a.this.hWn.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.agl;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.hVY.setText(sb);
        if (this.hWo == null) {
            c.ln().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.agl.getContext(), R.string.share_failed);
                        if (a.this.hWn != null) {
                            a.this.hWn.onCancel();
                        }
                    }
                    a.this.hWo = new BlurDrawable(a.this.agl.getContext());
                    a.this.hWo.init(2, 4, aVar.getRawBitmap());
                    a.this.hWo.drawBlur();
                    a.this.hVL.setImageBitmap(a.this.hWo.getBlurredBitmap());
                }
            }, null);
        }
        this.gJs.startLoad(gameShareData.headBgUrl, 10, false);
        this.hWh.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.hVO.startLoad(gameShareData.gameIconUrl, 10, false);
            this.hVP.setText(gameShareData.gameName);
            this.hVQ.setText(gameShareData.gameDescription);
            this.hVR.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.hVX);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.hVZ.startLoad(gameShareData.userPortrait, 12, false);
            this.dKI.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.hWf);
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

    public Bitmap aTo() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int cfY() {
        return this.fXJ.getBottom();
    }

    public void onDestroy() {
        if (this.hWo != null) {
            this.hWo.onDestroy();
            this.hWo = null;
        }
    }
}

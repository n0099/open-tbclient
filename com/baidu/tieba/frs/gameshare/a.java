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
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.compatible.BlurDrawable;
import com.baidu.tieba.d;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public class a {
    private TextView ayt;
    private LinearLayout bFO;
    private FrameLayout btg;
    private LinearLayout cfo;
    private TbImageView dtA;
    private TbImageView dtB;
    private TextView dtC;
    private TextView dtD;
    private TextView dtE;
    private RadioButton dtF;
    private RadioButton dtG;
    private RadioButton dtH;
    private RadioButton dtI;
    private RadioButton dtJ;
    private RadioButton[] dtK;
    private TextView dtL;
    private TbImageView dtM;
    private RadioButton dtN;
    private RadioButton dtO;
    private RadioButton dtP;
    private RadioButton dtQ;
    private RadioButton dtR;
    private RadioButton[] dtS;
    private TextView dtT;
    private TbImageView dtU;
    private TextView dtV;
    private TextView dtW;
    private TextView dtX;
    private TextView dtY;
    private TextView dtZ;
    private ImageView dtx;
    private FrameLayout dty;
    private ColumnLayout dtz;
    private InterfaceC0154a dua;
    private BlurDrawable dub;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0154a {
        void n(Bitmap bitmap);

        void o(Bitmap bitmap);

        void onCancel();

        void p(Bitmap bitmap);

        void q(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0154a interfaceC0154a) {
        this.dua = interfaceC0154a;
        this.btg = (FrameLayout) LayoutInflater.from(context).inflate(d.i.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.btg.findViewById(d.g.game_share_content_layout);
        this.dtx = (ImageView) this.btg.findViewById(d.g.game_share_content_bg_view);
        this.bFO = (LinearLayout) this.btg.findViewById(d.g.game_share_card_layout);
        this.dty = (FrameLayout) this.btg.findViewById(d.g.game_share_header_root);
        this.dtz = (ColumnLayout) this.btg.findViewById(d.g.game_share_header_layout);
        this.dtA = (TbImageView) this.btg.findViewById(d.g.game_share_header_bg_view);
        this.dtA.setVisibility(4);
        this.dtA.setDefaultBg(new ColorDrawable(this.btg.getResources().getColor(d.C0141d.transparent)));
        this.dtA.setDrawerType(1);
        this.dtA.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.dtA.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z) {
                    a.this.dtA.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dtB = (TbImageView) this.btg.findViewById(d.g.game_share_game_icon);
        this.dtB.setDrawerType(1);
        this.dtB.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.dtC = (TextView) this.btg.findViewById(d.g.game_share_game_name);
        this.dtD = (TextView) this.btg.findViewById(d.g.game_share_game_description);
        this.dtE = (TextView) this.btg.findViewById(d.g.game_share_game_score);
        this.dtF = (RadioButton) this.btg.findViewById(d.g.game_share_score_grade_1);
        this.dtG = (RadioButton) this.btg.findViewById(d.g.game_share_score_grade_2);
        this.dtH = (RadioButton) this.btg.findViewById(d.g.game_share_score_grade_3);
        this.dtI = (RadioButton) this.btg.findViewById(d.g.game_share_score_grade_4);
        this.dtJ = (RadioButton) this.btg.findViewById(d.g.game_share_score_grade_5);
        this.dtK = new RadioButton[]{this.dtF, this.dtG, this.dtH, this.dtI, this.dtJ};
        this.dtL = (TextView) this.btg.findViewById(d.g.game_share_comment);
        this.dtM = (TbImageView) this.btg.findViewById(d.g.game_share_user_protrait);
        this.dtM.setDrawerType(1);
        this.dtM.setIsRound(true);
        this.ayt = (TextView) this.btg.findViewById(d.g.game_share_user_name);
        this.dtN = (RadioButton) this.btg.findViewById(d.g.game_share_user_score_grade_1);
        this.dtO = (RadioButton) this.btg.findViewById(d.g.game_share_user_score_grade_2);
        this.dtP = (RadioButton) this.btg.findViewById(d.g.game_share_user_score_grade_3);
        this.dtQ = (RadioButton) this.btg.findViewById(d.g.game_share_user_score_grade_4);
        this.dtR = (RadioButton) this.btg.findViewById(d.g.game_share_user_score_grade_5);
        this.dtS = new RadioButton[]{this.dtN, this.dtO, this.dtP, this.dtQ, this.dtR};
        this.dtT = (TextView) this.btg.findViewById(d.g.game_share_qr_txt);
        this.dtU = (TbImageView) this.btg.findViewById(d.g.game_share_qr_img);
        this.cfo = (LinearLayout) this.btg.findViewById(d.g.game_share_entry_layout);
        this.dtV = (TextView) this.btg.findViewById(d.g.game_share_entry_weixin);
        this.dtV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap awY = a.this.awY();
                if (awY != null && a.this.dua != null) {
                    a.this.dua.n(awY);
                }
            }
        });
        this.dtW = (TextView) this.btg.findViewById(d.g.game_share_entry_wxfriends);
        this.dtW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap awY = a.this.awY();
                if (awY != null && a.this.dua != null) {
                    a.this.dua.o(awY);
                }
            }
        });
        this.dtX = (TextView) this.btg.findViewById(d.g.game_share_entry_qq);
        this.dtX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap awY = a.this.awY();
                if (awY != null && a.this.dua != null) {
                    a.this.dua.p(awY);
                }
            }
        });
        this.dtY = (TextView) this.btg.findViewById(d.g.game_share_entry_sina);
        this.dtY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap awY = a.this.awY();
                if (awY != null && a.this.dua != null) {
                    a.this.dua.q(awY);
                }
            }
        });
        this.dtZ = (TextView) this.btg.findViewById(d.g.game_share_cancel);
        this.dtZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dua != null) {
                    a.this.dua.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.btg;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.agf);
        sb.append(" ”");
        this.dtL.setText(sb);
        if (this.dub == null) {
            c.ig().a(gameShareData.aga, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.mZ() == null) {
                        UtilHelper.showToast(a.this.btg.getContext(), d.k.share_failed);
                        if (a.this.dua != null) {
                            a.this.dua.onCancel();
                        }
                    }
                    a.this.dub = new BlurDrawable(a.this.btg.getContext());
                    a.this.dub.init(2, 4, aVar.mZ());
                    a.this.dub.drawBlur();
                    a.this.dtx.setImageBitmap(a.this.dub.getBlurredBitmap());
                }
            }, null);
        }
        this.dtA.startLoad(gameShareData.agh, 10, false);
        this.dtU.startLoad(gameShareData.agg, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dtB.startLoad(gameShareData.aga, 10, false);
            this.dtC.setText(gameShareData.gameName);
            this.dtD.setText(gameShareData.agb);
            this.dtE.setText(new DecimalFormat(".0").format(gameShareData.agc));
            a((int) gameShareData.agc, this.dtK);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dtM.startLoad(gameShareData.userPortrait, 12, false);
            this.ayt.setText(gameShareData.userName);
            a((int) gameShareData.agd, this.dtS);
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

    public Bitmap awY() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int awZ() {
        return this.bFO.getBottom();
    }

    public void onDestroy() {
        if (this.dub != null) {
            this.dub.onDestroy();
            this.dub = null;
        }
    }
}

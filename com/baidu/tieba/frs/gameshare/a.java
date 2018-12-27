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
import com.baidu.tieba.e;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public class a {
    private TextView aKV;
    private LinearLayout cDA;
    private TbImageView cLo;
    private LinearLayout cbv;
    private TextView dYA;
    private TextView dYB;
    private RadioButton dYC;
    private RadioButton dYD;
    private RadioButton dYE;
    private RadioButton dYF;
    private RadioButton dYG;
    private RadioButton[] dYH;
    private TextView dYI;
    private TbImageView dYJ;
    private RadioButton dYK;
    private RadioButton dYL;
    private RadioButton dYM;
    private RadioButton dYN;
    private RadioButton dYO;
    private RadioButton[] dYP;
    private TextView dYQ;
    private TbImageView dYR;
    private TextView dYS;
    private TextView dYT;
    private TextView dYU;
    private TextView dYV;
    private TextView dYW;
    private InterfaceC0224a dYX;
    private BlurDrawable dYY;
    private ImageView dYv;
    private FrameLayout dYw;
    private ColumnLayout dYx;
    private TbImageView dYy;
    private TextView dYz;
    private FrameLayout mContentLayout;
    private FrameLayout mRootView;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0224a {
        void n(Bitmap bitmap);

        void o(Bitmap bitmap);

        void onCancel();

        void p(Bitmap bitmap);

        void q(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0224a interfaceC0224a) {
        this.dYX = interfaceC0224a;
        this.mRootView = (FrameLayout) LayoutInflater.from(context).inflate(e.h.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(e.g.game_share_content_layout);
        this.dYv = (ImageView) this.mRootView.findViewById(e.g.game_share_content_bg_view);
        this.cbv = (LinearLayout) this.mRootView.findViewById(e.g.game_share_card_layout);
        this.dYw = (FrameLayout) this.mRootView.findViewById(e.g.game_share_header_root);
        this.dYx = (ColumnLayout) this.mRootView.findViewById(e.g.game_share_header_layout);
        this.cLo = (TbImageView) this.mRootView.findViewById(e.g.game_share_header_bg_view);
        this.cLo.setVisibility(4);
        this.cLo.setDefaultBg(new ColorDrawable(this.mRootView.getResources().getColor(e.d.transparent)));
        this.cLo.setDrawerType(1);
        this.cLo.setRadius(context.getResources().getDimensionPixelSize(e.C0210e.ds20));
        this.cLo.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z) {
                    a.this.cLo.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dYy = (TbImageView) this.mRootView.findViewById(e.g.game_share_game_icon);
        this.dYy.setDrawerType(1);
        this.dYy.setRadius(context.getResources().getDimensionPixelSize(e.C0210e.ds20));
        this.dYz = (TextView) this.mRootView.findViewById(e.g.game_share_game_name);
        this.dYA = (TextView) this.mRootView.findViewById(e.g.game_share_game_description);
        this.dYB = (TextView) this.mRootView.findViewById(e.g.game_share_game_score);
        this.dYC = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_1);
        this.dYD = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_2);
        this.dYE = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_3);
        this.dYF = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_4);
        this.dYG = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_5);
        this.dYH = new RadioButton[]{this.dYC, this.dYD, this.dYE, this.dYF, this.dYG};
        this.dYI = (TextView) this.mRootView.findViewById(e.g.game_share_comment);
        this.dYJ = (TbImageView) this.mRootView.findViewById(e.g.game_share_user_protrait);
        this.dYJ.setDrawerType(1);
        this.dYJ.setIsRound(true);
        this.aKV = (TextView) this.mRootView.findViewById(e.g.game_share_user_name);
        this.dYK = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_1);
        this.dYL = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_2);
        this.dYM = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_3);
        this.dYN = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_4);
        this.dYO = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_5);
        this.dYP = new RadioButton[]{this.dYK, this.dYL, this.dYM, this.dYN, this.dYO};
        this.dYQ = (TextView) this.mRootView.findViewById(e.g.game_share_qr_txt);
        this.dYR = (TbImageView) this.mRootView.findViewById(e.g.game_share_qr_img);
        this.cDA = (LinearLayout) this.mRootView.findViewById(e.g.game_share_entry_layout);
        this.dYS = (TextView) this.mRootView.findViewById(e.g.game_share_entry_weixin);
        this.dYS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aFJ = a.this.aFJ();
                if (aFJ != null && a.this.dYX != null) {
                    a.this.dYX.n(aFJ);
                }
            }
        });
        this.dYT = (TextView) this.mRootView.findViewById(e.g.game_share_entry_wxfriends);
        this.dYT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aFJ = a.this.aFJ();
                if (aFJ != null && a.this.dYX != null) {
                    a.this.dYX.o(aFJ);
                }
            }
        });
        this.dYU = (TextView) this.mRootView.findViewById(e.g.game_share_entry_qq);
        this.dYU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aFJ = a.this.aFJ();
                if (aFJ != null && a.this.dYX != null) {
                    a.this.dYX.p(aFJ);
                }
            }
        });
        this.dYV = (TextView) this.mRootView.findViewById(e.g.game_share_entry_sina);
        this.dYV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aFJ = a.this.aFJ();
                if (aFJ != null && a.this.dYX != null) {
                    a.this.dYX.q(aFJ);
                }
            }
        });
        this.dYW = (TextView) this.mRootView.findViewById(e.g.game_share_cancel);
        this.dYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dYX != null) {
                    a.this.dYX.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.arx);
        sb.append(" ”");
        this.dYI.setText(sb);
        if (this.dYY == null) {
            c.jA().a(gameShareData.art, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.op() == null) {
                        UtilHelper.showToast(a.this.mRootView.getContext(), e.j.share_failed);
                        if (a.this.dYX != null) {
                            a.this.dYX.onCancel();
                        }
                    }
                    a.this.dYY = new BlurDrawable(a.this.mRootView.getContext());
                    a.this.dYY.init(2, 4, aVar.op());
                    a.this.dYY.drawBlur();
                    a.this.dYv.setImageBitmap(a.this.dYY.getBlurredBitmap());
                }
            }, null);
        }
        this.cLo.startLoad(gameShareData.arz, 10, false);
        this.dYR.startLoad(gameShareData.ary, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dYy.startLoad(gameShareData.art, 10, false);
            this.dYz.setText(gameShareData.gameName);
            this.dYA.setText(gameShareData.aru);
            this.dYB.setText(new DecimalFormat(".0").format(gameShareData.arv));
            a((int) gameShareData.arv, this.dYH);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dYJ.startLoad(gameShareData.userPortrait, 12, false);
            this.aKV.setText(gameShareData.userName);
            a((int) gameShareData.arw, this.dYP);
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

    public Bitmap aFJ() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int aFK() {
        return this.cbv.getBottom();
    }

    public void onDestroy() {
        if (this.dYY != null) {
            this.dYY.onDestroy();
            this.dYY = null;
        }
    }
}

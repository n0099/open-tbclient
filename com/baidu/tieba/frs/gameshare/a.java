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
/* loaded from: classes4.dex */
public class a {
    private TextView bUb;
    private FrameLayout bfK;
    private LinearLayout dRc;
    private TbImageView dYV;
    private LinearLayout dri;
    private RadioButton fmA;
    private RadioButton fmB;
    private RadioButton[] fmC;
    private TextView fmD;
    private TbImageView fmE;
    private RadioButton fmF;
    private RadioButton fmG;
    private RadioButton fmH;
    private RadioButton fmI;
    private RadioButton fmJ;
    private RadioButton[] fmK;
    private TextView fmL;
    private TbImageView fmM;
    private TextView fmN;
    private TextView fmO;
    private TextView fmP;
    private TextView fmQ;
    private TextView fmR;
    private InterfaceC0292a fmS;
    private BlurDrawable fmT;
    private ImageView fmq;
    private FrameLayout fmr;
    private ColumnLayout fms;
    private TbImageView fmt;
    private TextView fmu;
    private TextView fmv;
    private TextView fmw;
    private RadioButton fmx;
    private RadioButton fmy;
    private RadioButton fmz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0292a {
        void onCancel();

        void u(Bitmap bitmap);

        void v(Bitmap bitmap);

        void w(Bitmap bitmap);

        void x(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0292a interfaceC0292a) {
        this.fmS = interfaceC0292a;
        this.bfK = (FrameLayout) LayoutInflater.from(context).inflate(d.h.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.bfK.findViewById(d.g.game_share_content_layout);
        this.fmq = (ImageView) this.bfK.findViewById(d.g.game_share_content_bg_view);
        this.dri = (LinearLayout) this.bfK.findViewById(d.g.game_share_card_layout);
        this.fmr = (FrameLayout) this.bfK.findViewById(d.g.game_share_header_root);
        this.fms = (ColumnLayout) this.bfK.findViewById(d.g.game_share_header_layout);
        this.dYV = (TbImageView) this.bfK.findViewById(d.g.game_share_header_bg_view);
        this.dYV.setVisibility(4);
        this.dYV.setDefaultBg(new ColorDrawable(this.bfK.getResources().getColor(d.C0277d.transparent)));
        this.dYV.setDrawerType(1);
        this.dYV.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.dYV.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z) {
                    a.this.dYV.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fmt = (TbImageView) this.bfK.findViewById(d.g.game_share_game_icon);
        this.fmt.setDrawerType(1);
        this.fmt.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.fmu = (TextView) this.bfK.findViewById(d.g.game_share_game_name);
        this.fmv = (TextView) this.bfK.findViewById(d.g.game_share_game_description);
        this.fmw = (TextView) this.bfK.findViewById(d.g.game_share_game_score);
        this.fmx = (RadioButton) this.bfK.findViewById(d.g.game_share_score_grade_1);
        this.fmy = (RadioButton) this.bfK.findViewById(d.g.game_share_score_grade_2);
        this.fmz = (RadioButton) this.bfK.findViewById(d.g.game_share_score_grade_3);
        this.fmA = (RadioButton) this.bfK.findViewById(d.g.game_share_score_grade_4);
        this.fmB = (RadioButton) this.bfK.findViewById(d.g.game_share_score_grade_5);
        this.fmC = new RadioButton[]{this.fmx, this.fmy, this.fmz, this.fmA, this.fmB};
        this.fmD = (TextView) this.bfK.findViewById(d.g.game_share_comment);
        this.fmE = (TbImageView) this.bfK.findViewById(d.g.game_share_user_protrait);
        this.fmE.setDrawerType(1);
        this.fmE.setIsRound(true);
        this.bUb = (TextView) this.bfK.findViewById(d.g.game_share_user_name);
        this.fmF = (RadioButton) this.bfK.findViewById(d.g.game_share_user_score_grade_1);
        this.fmG = (RadioButton) this.bfK.findViewById(d.g.game_share_user_score_grade_2);
        this.fmH = (RadioButton) this.bfK.findViewById(d.g.game_share_user_score_grade_3);
        this.fmI = (RadioButton) this.bfK.findViewById(d.g.game_share_user_score_grade_4);
        this.fmJ = (RadioButton) this.bfK.findViewById(d.g.game_share_user_score_grade_5);
        this.fmK = new RadioButton[]{this.fmF, this.fmG, this.fmH, this.fmI, this.fmJ};
        this.fmL = (TextView) this.bfK.findViewById(d.g.game_share_qr_txt);
        this.fmM = (TbImageView) this.bfK.findViewById(d.g.game_share_qr_img);
        this.dRc = (LinearLayout) this.bfK.findViewById(d.g.game_share_entry_layout);
        this.fmN = (TextView) this.bfK.findViewById(d.g.game_share_entry_weixin);
        this.fmN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bgw = a.this.bgw();
                if (bgw != null && a.this.fmS != null) {
                    a.this.fmS.u(bgw);
                }
            }
        });
        this.fmO = (TextView) this.bfK.findViewById(d.g.game_share_entry_wxfriends);
        this.fmO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bgw = a.this.bgw();
                if (bgw != null && a.this.fmS != null) {
                    a.this.fmS.v(bgw);
                }
            }
        });
        this.fmP = (TextView) this.bfK.findViewById(d.g.game_share_entry_qq);
        this.fmP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bgw = a.this.bgw();
                if (bgw != null && a.this.fmS != null) {
                    a.this.fmS.w(bgw);
                }
            }
        });
        this.fmQ = (TextView) this.bfK.findViewById(d.g.game_share_entry_sina);
        this.fmQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bgw = a.this.bgw();
                if (bgw != null && a.this.fmS != null) {
                    a.this.fmS.x(bgw);
                }
            }
        });
        this.fmR = (TextView) this.bfK.findViewById(d.g.game_share_cancel);
        this.fmR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fmS != null) {
                    a.this.fmS.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.bfK;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.byU);
        sb.append(" ”");
        this.fmD.setText(sb);
        if (this.fmT == null) {
            c.jB().a(gameShareData.byQ, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.oy() == null) {
                        UtilHelper.showToast(a.this.bfK.getContext(), d.j.share_failed);
                        if (a.this.fmS != null) {
                            a.this.fmS.onCancel();
                        }
                    }
                    a.this.fmT = new BlurDrawable(a.this.bfK.getContext());
                    a.this.fmT.init(2, 4, aVar.oy());
                    a.this.fmT.drawBlur();
                    a.this.fmq.setImageBitmap(a.this.fmT.getBlurredBitmap());
                }
            }, null);
        }
        this.dYV.startLoad(gameShareData.byW, 10, false);
        this.fmM.startLoad(gameShareData.byV, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fmt.startLoad(gameShareData.byQ, 10, false);
            this.fmu.setText(gameShareData.gameName);
            this.fmv.setText(gameShareData.byR);
            this.fmw.setText(new DecimalFormat(".0").format(gameShareData.byS));
            a((int) gameShareData.byS, this.fmC);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fmE.startLoad(gameShareData.userPortrait, 12, false);
            this.bUb.setText(gameShareData.userName);
            a((int) gameShareData.byT, this.fmK);
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

    public Bitmap bgw() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bgx() {
        return this.dri.getBottom();
    }

    public void onDestroy() {
        if (this.fmT != null) {
            this.fmT.onDestroy();
            this.fmT = null;
        }
    }
}

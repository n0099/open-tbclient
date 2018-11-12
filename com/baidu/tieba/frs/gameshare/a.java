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
    private TextView aHt;
    private LinearLayout bXA;
    private LinearLayout cyI;
    private TextView dPA;
    private TextView dPB;
    private TextView dPC;
    private TextView dPD;
    private InterfaceC0213a dPE;
    private BlurDrawable dPF;
    private ImageView dPb;
    private FrameLayout dPc;
    private ColumnLayout dPd;
    private TbImageView dPe;
    private TbImageView dPf;
    private TextView dPg;
    private TextView dPh;
    private TextView dPi;
    private RadioButton dPj;
    private RadioButton dPk;
    private RadioButton dPl;
    private RadioButton dPm;
    private RadioButton dPn;
    private RadioButton[] dPo;
    private TextView dPp;
    private TbImageView dPq;
    private RadioButton dPr;
    private RadioButton dPs;
    private RadioButton dPt;
    private RadioButton dPu;
    private RadioButton dPv;
    private RadioButton[] dPw;
    private TextView dPx;
    private TbImageView dPy;
    private TextView dPz;
    private FrameLayout mContentLayout;
    private FrameLayout mRootView;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0213a {
        void n(Bitmap bitmap);

        void o(Bitmap bitmap);

        void onCancel();

        void p(Bitmap bitmap);

        void q(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0213a interfaceC0213a) {
        this.dPE = interfaceC0213a;
        this.mRootView = (FrameLayout) LayoutInflater.from(context).inflate(e.h.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(e.g.game_share_content_layout);
        this.dPb = (ImageView) this.mRootView.findViewById(e.g.game_share_content_bg_view);
        this.bXA = (LinearLayout) this.mRootView.findViewById(e.g.game_share_card_layout);
        this.dPc = (FrameLayout) this.mRootView.findViewById(e.g.game_share_header_root);
        this.dPd = (ColumnLayout) this.mRootView.findViewById(e.g.game_share_header_layout);
        this.dPe = (TbImageView) this.mRootView.findViewById(e.g.game_share_header_bg_view);
        this.dPe.setVisibility(4);
        this.dPe.setDefaultBg(new ColorDrawable(this.mRootView.getResources().getColor(e.d.transparent)));
        this.dPe.setDrawerType(1);
        this.dPe.setRadius(context.getResources().getDimensionPixelSize(e.C0200e.ds20));
        this.dPe.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z) {
                    a.this.dPe.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dPf = (TbImageView) this.mRootView.findViewById(e.g.game_share_game_icon);
        this.dPf.setDrawerType(1);
        this.dPf.setRadius(context.getResources().getDimensionPixelSize(e.C0200e.ds20));
        this.dPg = (TextView) this.mRootView.findViewById(e.g.game_share_game_name);
        this.dPh = (TextView) this.mRootView.findViewById(e.g.game_share_game_description);
        this.dPi = (TextView) this.mRootView.findViewById(e.g.game_share_game_score);
        this.dPj = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_1);
        this.dPk = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_2);
        this.dPl = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_3);
        this.dPm = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_4);
        this.dPn = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_5);
        this.dPo = new RadioButton[]{this.dPj, this.dPk, this.dPl, this.dPm, this.dPn};
        this.dPp = (TextView) this.mRootView.findViewById(e.g.game_share_comment);
        this.dPq = (TbImageView) this.mRootView.findViewById(e.g.game_share_user_protrait);
        this.dPq.setDrawerType(1);
        this.dPq.setIsRound(true);
        this.aHt = (TextView) this.mRootView.findViewById(e.g.game_share_user_name);
        this.dPr = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_1);
        this.dPs = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_2);
        this.dPt = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_3);
        this.dPu = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_4);
        this.dPv = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_5);
        this.dPw = new RadioButton[]{this.dPr, this.dPs, this.dPt, this.dPu, this.dPv};
        this.dPx = (TextView) this.mRootView.findViewById(e.g.game_share_qr_txt);
        this.dPy = (TbImageView) this.mRootView.findViewById(e.g.game_share_qr_img);
        this.cyI = (LinearLayout) this.mRootView.findViewById(e.g.game_share_entry_layout);
        this.dPz = (TextView) this.mRootView.findViewById(e.g.game_share_entry_weixin);
        this.dPz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aDi = a.this.aDi();
                if (aDi != null && a.this.dPE != null) {
                    a.this.dPE.n(aDi);
                }
            }
        });
        this.dPA = (TextView) this.mRootView.findViewById(e.g.game_share_entry_wxfriends);
        this.dPA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aDi = a.this.aDi();
                if (aDi != null && a.this.dPE != null) {
                    a.this.dPE.o(aDi);
                }
            }
        });
        this.dPB = (TextView) this.mRootView.findViewById(e.g.game_share_entry_qq);
        this.dPB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aDi = a.this.aDi();
                if (aDi != null && a.this.dPE != null) {
                    a.this.dPE.p(aDi);
                }
            }
        });
        this.dPC = (TextView) this.mRootView.findViewById(e.g.game_share_entry_sina);
        this.dPC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aDi = a.this.aDi();
                if (aDi != null && a.this.dPE != null) {
                    a.this.dPE.q(aDi);
                }
            }
        });
        this.dPD = (TextView) this.mRootView.findViewById(e.g.game_share_cancel);
        this.dPD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dPE != null) {
                    a.this.dPE.onCancel();
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
        sb.append(gameShareData.anW);
        sb.append(" ”");
        this.dPp.setText(sb);
        if (this.dPF == null) {
            c.jA().a(gameShareData.anS, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.oq() == null) {
                        UtilHelper.showToast(a.this.mRootView.getContext(), e.j.share_failed);
                        if (a.this.dPE != null) {
                            a.this.dPE.onCancel();
                        }
                    }
                    a.this.dPF = new BlurDrawable(a.this.mRootView.getContext());
                    a.this.dPF.init(2, 4, aVar.oq());
                    a.this.dPF.drawBlur();
                    a.this.dPb.setImageBitmap(a.this.dPF.getBlurredBitmap());
                }
            }, null);
        }
        this.dPe.startLoad(gameShareData.anY, 10, false);
        this.dPy.startLoad(gameShareData.anX, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dPf.startLoad(gameShareData.anS, 10, false);
            this.dPg.setText(gameShareData.gameName);
            this.dPh.setText(gameShareData.anT);
            this.dPi.setText(new DecimalFormat(".0").format(gameShareData.anU));
            a((int) gameShareData.anU, this.dPo);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dPq.startLoad(gameShareData.userPortrait, 12, false);
            this.aHt.setText(gameShareData.userName);
            a((int) gameShareData.anV, this.dPw);
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

    public Bitmap aDi() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int aDj() {
        return this.bXA.getBottom();
    }

    public void onDestroy() {
        if (this.dPF != null) {
            this.dPF.onDestroy();
            this.dPF = null;
        }
    }
}

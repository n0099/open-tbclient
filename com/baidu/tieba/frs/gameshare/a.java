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
    private TextView aGD;
    private LinearLayout bWO;
    private LinearLayout cxA;
    private ImageView dNY;
    private FrameLayout dNZ;
    private TextView dOA;
    private InterfaceC0188a dOB;
    private BlurDrawable dOC;
    private ColumnLayout dOa;
    private TbImageView dOb;
    private TbImageView dOc;
    private TextView dOd;
    private TextView dOe;
    private TextView dOf;
    private RadioButton dOg;
    private RadioButton dOh;
    private RadioButton dOi;
    private RadioButton dOj;
    private RadioButton dOk;
    private RadioButton[] dOl;
    private TextView dOm;
    private TbImageView dOn;
    private RadioButton dOo;
    private RadioButton dOp;
    private RadioButton dOq;
    private RadioButton dOr;
    private RadioButton dOs;
    private RadioButton[] dOt;
    private TextView dOu;
    private TbImageView dOv;
    private TextView dOw;
    private TextView dOx;
    private TextView dOy;
    private TextView dOz;
    private FrameLayout mContentLayout;
    private FrameLayout mRootView;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0188a {
        void n(Bitmap bitmap);

        void o(Bitmap bitmap);

        void onCancel();

        void p(Bitmap bitmap);

        void q(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0188a interfaceC0188a) {
        this.dOB = interfaceC0188a;
        this.mRootView = (FrameLayout) LayoutInflater.from(context).inflate(e.h.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(e.g.game_share_content_layout);
        this.dNY = (ImageView) this.mRootView.findViewById(e.g.game_share_content_bg_view);
        this.bWO = (LinearLayout) this.mRootView.findViewById(e.g.game_share_card_layout);
        this.dNZ = (FrameLayout) this.mRootView.findViewById(e.g.game_share_header_root);
        this.dOa = (ColumnLayout) this.mRootView.findViewById(e.g.game_share_header_layout);
        this.dOb = (TbImageView) this.mRootView.findViewById(e.g.game_share_header_bg_view);
        this.dOb.setVisibility(4);
        this.dOb.setDefaultBg(new ColorDrawable(this.mRootView.getResources().getColor(e.d.transparent)));
        this.dOb.setDrawerType(1);
        this.dOb.setRadius(context.getResources().getDimensionPixelSize(e.C0175e.ds20));
        this.dOb.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z) {
                    a.this.dOb.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dOc = (TbImageView) this.mRootView.findViewById(e.g.game_share_game_icon);
        this.dOc.setDrawerType(1);
        this.dOc.setRadius(context.getResources().getDimensionPixelSize(e.C0175e.ds20));
        this.dOd = (TextView) this.mRootView.findViewById(e.g.game_share_game_name);
        this.dOe = (TextView) this.mRootView.findViewById(e.g.game_share_game_description);
        this.dOf = (TextView) this.mRootView.findViewById(e.g.game_share_game_score);
        this.dOg = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_1);
        this.dOh = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_2);
        this.dOi = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_3);
        this.dOj = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_4);
        this.dOk = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_5);
        this.dOl = new RadioButton[]{this.dOg, this.dOh, this.dOi, this.dOj, this.dOk};
        this.dOm = (TextView) this.mRootView.findViewById(e.g.game_share_comment);
        this.dOn = (TbImageView) this.mRootView.findViewById(e.g.game_share_user_protrait);
        this.dOn.setDrawerType(1);
        this.dOn.setIsRound(true);
        this.aGD = (TextView) this.mRootView.findViewById(e.g.game_share_user_name);
        this.dOo = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_1);
        this.dOp = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_2);
        this.dOq = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_3);
        this.dOr = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_4);
        this.dOs = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_5);
        this.dOt = new RadioButton[]{this.dOo, this.dOp, this.dOq, this.dOr, this.dOs};
        this.dOu = (TextView) this.mRootView.findViewById(e.g.game_share_qr_txt);
        this.dOv = (TbImageView) this.mRootView.findViewById(e.g.game_share_qr_img);
        this.cxA = (LinearLayout) this.mRootView.findViewById(e.g.game_share_entry_layout);
        this.dOw = (TextView) this.mRootView.findViewById(e.g.game_share_entry_weixin);
        this.dOw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aDN = a.this.aDN();
                if (aDN != null && a.this.dOB != null) {
                    a.this.dOB.n(aDN);
                }
            }
        });
        this.dOx = (TextView) this.mRootView.findViewById(e.g.game_share_entry_wxfriends);
        this.dOx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aDN = a.this.aDN();
                if (aDN != null && a.this.dOB != null) {
                    a.this.dOB.o(aDN);
                }
            }
        });
        this.dOy = (TextView) this.mRootView.findViewById(e.g.game_share_entry_qq);
        this.dOy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aDN = a.this.aDN();
                if (aDN != null && a.this.dOB != null) {
                    a.this.dOB.p(aDN);
                }
            }
        });
        this.dOz = (TextView) this.mRootView.findViewById(e.g.game_share_entry_sina);
        this.dOz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aDN = a.this.aDN();
                if (aDN != null && a.this.dOB != null) {
                    a.this.dOB.q(aDN);
                }
            }
        });
        this.dOA = (TextView) this.mRootView.findViewById(e.g.game_share_cancel);
        this.dOA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dOB != null) {
                    a.this.dOB.onCancel();
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
        sb.append(gameShareData.anj);
        sb.append(" ”");
        this.dOm.setText(sb);
        if (this.dOC == null) {
            c.jC().a(gameShareData.anf, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.os() == null) {
                        UtilHelper.showToast(a.this.mRootView.getContext(), e.j.share_failed);
                        if (a.this.dOB != null) {
                            a.this.dOB.onCancel();
                        }
                    }
                    a.this.dOC = new BlurDrawable(a.this.mRootView.getContext());
                    a.this.dOC.init(2, 4, aVar.os());
                    a.this.dOC.drawBlur();
                    a.this.dNY.setImageBitmap(a.this.dOC.getBlurredBitmap());
                }
            }, null);
        }
        this.dOb.startLoad(gameShareData.anl, 10, false);
        this.dOv.startLoad(gameShareData.ank, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dOc.startLoad(gameShareData.anf, 10, false);
            this.dOd.setText(gameShareData.gameName);
            this.dOe.setText(gameShareData.ang);
            this.dOf.setText(new DecimalFormat(".0").format(gameShareData.anh));
            a((int) gameShareData.anh, this.dOl);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dOn.startLoad(gameShareData.userPortrait, 12, false);
            this.aGD.setText(gameShareData.userName);
            a((int) gameShareData.ani, this.dOt);
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

    public Bitmap aDN() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int aDO() {
        return this.bWO.getBottom();
    }

    public void onDestroy() {
        if (this.dOC != null) {
            this.dOC.onDestroy();
            this.dOC = null;
        }
    }
}

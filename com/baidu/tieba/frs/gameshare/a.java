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
    private TextView aLy;
    private LinearLayout cEm;
    private TbImageView cMa;
    private LinearLayout cch;
    private TextView dZA;
    private TextView dZB;
    private TextView dZC;
    private TextView dZD;
    private InterfaceC0224a dZE;
    private BlurDrawable dZF;
    private ImageView dZc;
    private FrameLayout dZd;
    private ColumnLayout dZe;
    private TbImageView dZf;
    private TextView dZg;
    private TextView dZh;
    private TextView dZi;
    private RadioButton dZj;
    private RadioButton dZk;
    private RadioButton dZl;
    private RadioButton dZm;
    private RadioButton dZn;
    private RadioButton[] dZo;
    private TextView dZp;
    private TbImageView dZq;
    private RadioButton dZr;
    private RadioButton dZs;
    private RadioButton dZt;
    private RadioButton dZu;
    private RadioButton dZv;
    private RadioButton[] dZw;
    private TextView dZx;
    private TbImageView dZy;
    private TextView dZz;
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
        this.dZE = interfaceC0224a;
        this.mRootView = (FrameLayout) LayoutInflater.from(context).inflate(e.h.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(e.g.game_share_content_layout);
        this.dZc = (ImageView) this.mRootView.findViewById(e.g.game_share_content_bg_view);
        this.cch = (LinearLayout) this.mRootView.findViewById(e.g.game_share_card_layout);
        this.dZd = (FrameLayout) this.mRootView.findViewById(e.g.game_share_header_root);
        this.dZe = (ColumnLayout) this.mRootView.findViewById(e.g.game_share_header_layout);
        this.cMa = (TbImageView) this.mRootView.findViewById(e.g.game_share_header_bg_view);
        this.cMa.setVisibility(4);
        this.cMa.setDefaultBg(new ColorDrawable(this.mRootView.getResources().getColor(e.d.transparent)));
        this.cMa.setDrawerType(1);
        this.cMa.setRadius(context.getResources().getDimensionPixelSize(e.C0210e.ds20));
        this.cMa.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z) {
                    a.this.cMa.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dZf = (TbImageView) this.mRootView.findViewById(e.g.game_share_game_icon);
        this.dZf.setDrawerType(1);
        this.dZf.setRadius(context.getResources().getDimensionPixelSize(e.C0210e.ds20));
        this.dZg = (TextView) this.mRootView.findViewById(e.g.game_share_game_name);
        this.dZh = (TextView) this.mRootView.findViewById(e.g.game_share_game_description);
        this.dZi = (TextView) this.mRootView.findViewById(e.g.game_share_game_score);
        this.dZj = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_1);
        this.dZk = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_2);
        this.dZl = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_3);
        this.dZm = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_4);
        this.dZn = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_5);
        this.dZo = new RadioButton[]{this.dZj, this.dZk, this.dZl, this.dZm, this.dZn};
        this.dZp = (TextView) this.mRootView.findViewById(e.g.game_share_comment);
        this.dZq = (TbImageView) this.mRootView.findViewById(e.g.game_share_user_protrait);
        this.dZq.setDrawerType(1);
        this.dZq.setIsRound(true);
        this.aLy = (TextView) this.mRootView.findViewById(e.g.game_share_user_name);
        this.dZr = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_1);
        this.dZs = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_2);
        this.dZt = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_3);
        this.dZu = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_4);
        this.dZv = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_5);
        this.dZw = new RadioButton[]{this.dZr, this.dZs, this.dZt, this.dZu, this.dZv};
        this.dZx = (TextView) this.mRootView.findViewById(e.g.game_share_qr_txt);
        this.dZy = (TbImageView) this.mRootView.findViewById(e.g.game_share_qr_img);
        this.cEm = (LinearLayout) this.mRootView.findViewById(e.g.game_share_entry_layout);
        this.dZz = (TextView) this.mRootView.findViewById(e.g.game_share_entry_weixin);
        this.dZz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aGg = a.this.aGg();
                if (aGg != null && a.this.dZE != null) {
                    a.this.dZE.n(aGg);
                }
            }
        });
        this.dZA = (TextView) this.mRootView.findViewById(e.g.game_share_entry_wxfriends);
        this.dZA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aGg = a.this.aGg();
                if (aGg != null && a.this.dZE != null) {
                    a.this.dZE.o(aGg);
                }
            }
        });
        this.dZB = (TextView) this.mRootView.findViewById(e.g.game_share_entry_qq);
        this.dZB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aGg = a.this.aGg();
                if (aGg != null && a.this.dZE != null) {
                    a.this.dZE.p(aGg);
                }
            }
        });
        this.dZC = (TextView) this.mRootView.findViewById(e.g.game_share_entry_sina);
        this.dZC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aGg = a.this.aGg();
                if (aGg != null && a.this.dZE != null) {
                    a.this.dZE.q(aGg);
                }
            }
        });
        this.dZD = (TextView) this.mRootView.findViewById(e.g.game_share_cancel);
        this.dZD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dZE != null) {
                    a.this.dZE.onCancel();
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
        sb.append(gameShareData.asa);
        sb.append(" ”");
        this.dZp.setText(sb);
        if (this.dZF == null) {
            c.jA().a(gameShareData.arW, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.ot() == null) {
                        UtilHelper.showToast(a.this.mRootView.getContext(), e.j.share_failed);
                        if (a.this.dZE != null) {
                            a.this.dZE.onCancel();
                        }
                    }
                    a.this.dZF = new BlurDrawable(a.this.mRootView.getContext());
                    a.this.dZF.init(2, 4, aVar.ot());
                    a.this.dZF.drawBlur();
                    a.this.dZc.setImageBitmap(a.this.dZF.getBlurredBitmap());
                }
            }, null);
        }
        this.cMa.startLoad(gameShareData.asc, 10, false);
        this.dZy.startLoad(gameShareData.asb, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dZf.startLoad(gameShareData.arW, 10, false);
            this.dZg.setText(gameShareData.gameName);
            this.dZh.setText(gameShareData.arX);
            this.dZi.setText(new DecimalFormat(".0").format(gameShareData.arY));
            a((int) gameShareData.arY, this.dZo);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dZq.startLoad(gameShareData.userPortrait, 12, false);
            this.aLy.setText(gameShareData.userName);
            a((int) gameShareData.arZ, this.dZw);
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

    public Bitmap aGg() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int aGh() {
        return this.cch.getBottom();
    }

    public void onDestroy() {
        if (this.dZF != null) {
            this.dZF.onDestroy();
            this.dZF = null;
        }
    }
}

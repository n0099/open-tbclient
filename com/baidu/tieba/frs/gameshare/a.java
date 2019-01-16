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
    private TextView aLx;
    private LinearLayout cEl;
    private TbImageView cLZ;
    private LinearLayout ccg;
    private TextView dZA;
    private TextView dZB;
    private TextView dZC;
    private InterfaceC0224a dZD;
    private BlurDrawable dZE;
    private ImageView dZb;
    private FrameLayout dZc;
    private ColumnLayout dZd;
    private TbImageView dZe;
    private TextView dZf;
    private TextView dZg;
    private TextView dZh;
    private RadioButton dZi;
    private RadioButton dZj;
    private RadioButton dZk;
    private RadioButton dZl;
    private RadioButton dZm;
    private RadioButton[] dZn;
    private TextView dZo;
    private TbImageView dZp;
    private RadioButton dZq;
    private RadioButton dZr;
    private RadioButton dZs;
    private RadioButton dZt;
    private RadioButton dZu;
    private RadioButton[] dZv;
    private TextView dZw;
    private TbImageView dZx;
    private TextView dZy;
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
        this.dZD = interfaceC0224a;
        this.mRootView = (FrameLayout) LayoutInflater.from(context).inflate(e.h.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(e.g.game_share_content_layout);
        this.dZb = (ImageView) this.mRootView.findViewById(e.g.game_share_content_bg_view);
        this.ccg = (LinearLayout) this.mRootView.findViewById(e.g.game_share_card_layout);
        this.dZc = (FrameLayout) this.mRootView.findViewById(e.g.game_share_header_root);
        this.dZd = (ColumnLayout) this.mRootView.findViewById(e.g.game_share_header_layout);
        this.cLZ = (TbImageView) this.mRootView.findViewById(e.g.game_share_header_bg_view);
        this.cLZ.setVisibility(4);
        this.cLZ.setDefaultBg(new ColorDrawable(this.mRootView.getResources().getColor(e.d.transparent)));
        this.cLZ.setDrawerType(1);
        this.cLZ.setRadius(context.getResources().getDimensionPixelSize(e.C0210e.ds20));
        this.cLZ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z) {
                    a.this.cLZ.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dZe = (TbImageView) this.mRootView.findViewById(e.g.game_share_game_icon);
        this.dZe.setDrawerType(1);
        this.dZe.setRadius(context.getResources().getDimensionPixelSize(e.C0210e.ds20));
        this.dZf = (TextView) this.mRootView.findViewById(e.g.game_share_game_name);
        this.dZg = (TextView) this.mRootView.findViewById(e.g.game_share_game_description);
        this.dZh = (TextView) this.mRootView.findViewById(e.g.game_share_game_score);
        this.dZi = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_1);
        this.dZj = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_2);
        this.dZk = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_3);
        this.dZl = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_4);
        this.dZm = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_5);
        this.dZn = new RadioButton[]{this.dZi, this.dZj, this.dZk, this.dZl, this.dZm};
        this.dZo = (TextView) this.mRootView.findViewById(e.g.game_share_comment);
        this.dZp = (TbImageView) this.mRootView.findViewById(e.g.game_share_user_protrait);
        this.dZp.setDrawerType(1);
        this.dZp.setIsRound(true);
        this.aLx = (TextView) this.mRootView.findViewById(e.g.game_share_user_name);
        this.dZq = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_1);
        this.dZr = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_2);
        this.dZs = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_3);
        this.dZt = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_4);
        this.dZu = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_5);
        this.dZv = new RadioButton[]{this.dZq, this.dZr, this.dZs, this.dZt, this.dZu};
        this.dZw = (TextView) this.mRootView.findViewById(e.g.game_share_qr_txt);
        this.dZx = (TbImageView) this.mRootView.findViewById(e.g.game_share_qr_img);
        this.cEl = (LinearLayout) this.mRootView.findViewById(e.g.game_share_entry_layout);
        this.dZy = (TextView) this.mRootView.findViewById(e.g.game_share_entry_weixin);
        this.dZy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aGg = a.this.aGg();
                if (aGg != null && a.this.dZD != null) {
                    a.this.dZD.n(aGg);
                }
            }
        });
        this.dZz = (TextView) this.mRootView.findViewById(e.g.game_share_entry_wxfriends);
        this.dZz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aGg = a.this.aGg();
                if (aGg != null && a.this.dZD != null) {
                    a.this.dZD.o(aGg);
                }
            }
        });
        this.dZA = (TextView) this.mRootView.findViewById(e.g.game_share_entry_qq);
        this.dZA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aGg = a.this.aGg();
                if (aGg != null && a.this.dZD != null) {
                    a.this.dZD.p(aGg);
                }
            }
        });
        this.dZB = (TextView) this.mRootView.findViewById(e.g.game_share_entry_sina);
        this.dZB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aGg = a.this.aGg();
                if (aGg != null && a.this.dZD != null) {
                    a.this.dZD.q(aGg);
                }
            }
        });
        this.dZC = (TextView) this.mRootView.findViewById(e.g.game_share_cancel);
        this.dZC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dZD != null) {
                    a.this.dZD.onCancel();
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
        sb.append(gameShareData.arZ);
        sb.append(" ”");
        this.dZo.setText(sb);
        if (this.dZE == null) {
            c.jA().a(gameShareData.arV, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.ot() == null) {
                        UtilHelper.showToast(a.this.mRootView.getContext(), e.j.share_failed);
                        if (a.this.dZD != null) {
                            a.this.dZD.onCancel();
                        }
                    }
                    a.this.dZE = new BlurDrawable(a.this.mRootView.getContext());
                    a.this.dZE.init(2, 4, aVar.ot());
                    a.this.dZE.drawBlur();
                    a.this.dZb.setImageBitmap(a.this.dZE.getBlurredBitmap());
                }
            }, null);
        }
        this.cLZ.startLoad(gameShareData.asb, 10, false);
        this.dZx.startLoad(gameShareData.asa, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dZe.startLoad(gameShareData.arV, 10, false);
            this.dZf.setText(gameShareData.gameName);
            this.dZg.setText(gameShareData.arW);
            this.dZh.setText(new DecimalFormat(".0").format(gameShareData.arX));
            a((int) gameShareData.arX, this.dZn);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dZp.startLoad(gameShareData.userPortrait, 12, false);
            this.aLx.setText(gameShareData.userName);
            a((int) gameShareData.arY, this.dZv);
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
        return this.ccg.getBottom();
    }

    public void onDestroy() {
        if (this.dZE != null) {
            this.dZE.onDestroy();
            this.dZE = null;
        }
    }
}

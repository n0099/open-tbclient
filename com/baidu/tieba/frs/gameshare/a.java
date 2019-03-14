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
    private TextView bTY;
    private FrameLayout bfG;
    private LinearLayout dRK;
    private TbImageView dZx;
    private LinearLayout dre;
    private ImageView fmE;
    private FrameLayout fmF;
    private ColumnLayout fmG;
    private TbImageView fmH;
    private TextView fmI;
    private TextView fmJ;
    private TextView fmK;
    private RadioButton fmL;
    private RadioButton fmM;
    private RadioButton fmN;
    private RadioButton fmO;
    private RadioButton fmP;
    private RadioButton[] fmQ;
    private TextView fmR;
    private TbImageView fmS;
    private RadioButton fmT;
    private RadioButton fmU;
    private RadioButton fmV;
    private RadioButton fmW;
    private RadioButton fmX;
    private RadioButton[] fmY;
    private TextView fmZ;
    private TbImageView fna;
    private TextView fnb;
    private TextView fnc;
    private TextView fnd;
    private TextView fne;
    private TextView fnf;
    private InterfaceC0292a fng;
    private BlurDrawable fnh;
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
        this.fng = interfaceC0292a;
        this.bfG = (FrameLayout) LayoutInflater.from(context).inflate(d.h.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.bfG.findViewById(d.g.game_share_content_layout);
        this.fmE = (ImageView) this.bfG.findViewById(d.g.game_share_content_bg_view);
        this.dre = (LinearLayout) this.bfG.findViewById(d.g.game_share_card_layout);
        this.fmF = (FrameLayout) this.bfG.findViewById(d.g.game_share_header_root);
        this.fmG = (ColumnLayout) this.bfG.findViewById(d.g.game_share_header_layout);
        this.dZx = (TbImageView) this.bfG.findViewById(d.g.game_share_header_bg_view);
        this.dZx.setVisibility(4);
        this.dZx.setDefaultBg(new ColorDrawable(this.bfG.getResources().getColor(d.C0277d.transparent)));
        this.dZx.setDrawerType(1);
        this.dZx.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.dZx.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void L(String str, boolean z) {
                if (z) {
                    a.this.dZx.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fmH = (TbImageView) this.bfG.findViewById(d.g.game_share_game_icon);
        this.fmH.setDrawerType(1);
        this.fmH.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.fmI = (TextView) this.bfG.findViewById(d.g.game_share_game_name);
        this.fmJ = (TextView) this.bfG.findViewById(d.g.game_share_game_description);
        this.fmK = (TextView) this.bfG.findViewById(d.g.game_share_game_score);
        this.fmL = (RadioButton) this.bfG.findViewById(d.g.game_share_score_grade_1);
        this.fmM = (RadioButton) this.bfG.findViewById(d.g.game_share_score_grade_2);
        this.fmN = (RadioButton) this.bfG.findViewById(d.g.game_share_score_grade_3);
        this.fmO = (RadioButton) this.bfG.findViewById(d.g.game_share_score_grade_4);
        this.fmP = (RadioButton) this.bfG.findViewById(d.g.game_share_score_grade_5);
        this.fmQ = new RadioButton[]{this.fmL, this.fmM, this.fmN, this.fmO, this.fmP};
        this.fmR = (TextView) this.bfG.findViewById(d.g.game_share_comment);
        this.fmS = (TbImageView) this.bfG.findViewById(d.g.game_share_user_protrait);
        this.fmS.setDrawerType(1);
        this.fmS.setIsRound(true);
        this.bTY = (TextView) this.bfG.findViewById(d.g.game_share_user_name);
        this.fmT = (RadioButton) this.bfG.findViewById(d.g.game_share_user_score_grade_1);
        this.fmU = (RadioButton) this.bfG.findViewById(d.g.game_share_user_score_grade_2);
        this.fmV = (RadioButton) this.bfG.findViewById(d.g.game_share_user_score_grade_3);
        this.fmW = (RadioButton) this.bfG.findViewById(d.g.game_share_user_score_grade_4);
        this.fmX = (RadioButton) this.bfG.findViewById(d.g.game_share_user_score_grade_5);
        this.fmY = new RadioButton[]{this.fmT, this.fmU, this.fmV, this.fmW, this.fmX};
        this.fmZ = (TextView) this.bfG.findViewById(d.g.game_share_qr_txt);
        this.fna = (TbImageView) this.bfG.findViewById(d.g.game_share_qr_img);
        this.dRK = (LinearLayout) this.bfG.findViewById(d.g.game_share_entry_layout);
        this.fnb = (TextView) this.bfG.findViewById(d.g.game_share_entry_weixin);
        this.fnb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bgy = a.this.bgy();
                if (bgy != null && a.this.fng != null) {
                    a.this.fng.u(bgy);
                }
            }
        });
        this.fnc = (TextView) this.bfG.findViewById(d.g.game_share_entry_wxfriends);
        this.fnc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bgy = a.this.bgy();
                if (bgy != null && a.this.fng != null) {
                    a.this.fng.v(bgy);
                }
            }
        });
        this.fnd = (TextView) this.bfG.findViewById(d.g.game_share_entry_qq);
        this.fnd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bgy = a.this.bgy();
                if (bgy != null && a.this.fng != null) {
                    a.this.fng.w(bgy);
                }
            }
        });
        this.fne = (TextView) this.bfG.findViewById(d.g.game_share_entry_sina);
        this.fne.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bgy = a.this.bgy();
                if (bgy != null && a.this.fng != null) {
                    a.this.fng.x(bgy);
                }
            }
        });
        this.fnf = (TextView) this.bfG.findViewById(d.g.game_share_cancel);
        this.fnf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fng != null) {
                    a.this.fng.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.bfG;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.byQ);
        sb.append(" ”");
        this.fmR.setText(sb);
        if (this.fnh == null) {
            c.jB().a(gameShareData.byM, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.oy() == null) {
                        UtilHelper.showToast(a.this.bfG.getContext(), d.j.share_failed);
                        if (a.this.fng != null) {
                            a.this.fng.onCancel();
                        }
                    }
                    a.this.fnh = new BlurDrawable(a.this.bfG.getContext());
                    a.this.fnh.init(2, 4, aVar.oy());
                    a.this.fnh.drawBlur();
                    a.this.fmE.setImageBitmap(a.this.fnh.getBlurredBitmap());
                }
            }, null);
        }
        this.dZx.startLoad(gameShareData.byS, 10, false);
        this.fna.startLoad(gameShareData.byR, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fmH.startLoad(gameShareData.byM, 10, false);
            this.fmI.setText(gameShareData.gameName);
            this.fmJ.setText(gameShareData.byN);
            this.fmK.setText(new DecimalFormat(".0").format(gameShareData.byO));
            a((int) gameShareData.byO, this.fmQ);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fmS.startLoad(gameShareData.userPortrait, 12, false);
            this.bTY.setText(gameShareData.userName);
            a((int) gameShareData.byP, this.fmY);
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

    public Bitmap bgy() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bgz() {
        return this.dre.getBottom();
    }

    public void onDestroy() {
        if (this.fnh != null) {
            this.fnh.onDestroy();
            this.fnh = null;
        }
    }
}

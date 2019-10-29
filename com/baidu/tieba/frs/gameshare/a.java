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
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import java.text.DecimalFormat;
/* loaded from: classes4.dex */
public class a {
    private FrameLayout bEW;
    private TextView csn;
    private LinearLayout dUa;
    private TbImageView eAi;
    private LinearLayout euX;
    private ImageView fJH;
    private FrameLayout fJI;
    private ColumnLayout fJJ;
    private TbImageView fJK;
    private TextView fJL;
    private TextView fJM;
    private TextView fJN;
    private RadioButton fJO;
    private RadioButton fJP;
    private RadioButton fJQ;
    private RadioButton fJR;
    private RadioButton fJS;
    private RadioButton[] fJT;
    private TextView fJU;
    private TbImageView fJV;
    private RadioButton fJW;
    private RadioButton fJX;
    private RadioButton fJY;
    private RadioButton fJZ;
    private RadioButton fKa;
    private RadioButton[] fKb;
    private TextView fKc;
    private TbImageView fKd;
    private TextView fKe;
    private TextView fKf;
    private TextView fKg;
    private TextView fKh;
    private TextView fKi;
    private InterfaceC0413a fKj;
    private BlurDrawable fKk;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0413a {
        void onCancel();

        void t(Bitmap bitmap);

        void u(Bitmap bitmap);

        void v(Bitmap bitmap);

        void w(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0413a interfaceC0413a) {
        this.fKj = interfaceC0413a;
        this.bEW = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.bEW.findViewById(R.id.game_share_content_layout);
        this.fJH = (ImageView) this.bEW.findViewById(R.id.game_share_content_bg_view);
        this.dUa = (LinearLayout) this.bEW.findViewById(R.id.game_share_card_layout);
        this.fJI = (FrameLayout) this.bEW.findViewById(R.id.game_share_header_root);
        this.fJJ = (ColumnLayout) this.bEW.findViewById(R.id.game_share_header_layout);
        this.eAi = (TbImageView) this.bEW.findViewById(R.id.game_share_header_bg_view);
        this.eAi.setVisibility(4);
        this.eAi.setDefaultBg(new ColorDrawable(this.bEW.getResources().getColor(R.color.transparent)));
        this.eAi.setDrawerType(1);
        this.eAi.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.eAi.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.eAi.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fJK = (TbImageView) this.bEW.findViewById(R.id.game_share_game_icon);
        this.fJK.setDrawerType(1);
        this.fJK.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.fJL = (TextView) this.bEW.findViewById(R.id.game_share_game_name);
        this.fJM = (TextView) this.bEW.findViewById(R.id.game_share_game_description);
        this.fJN = (TextView) this.bEW.findViewById(R.id.game_share_game_score);
        this.fJO = (RadioButton) this.bEW.findViewById(R.id.game_share_score_grade_1);
        this.fJP = (RadioButton) this.bEW.findViewById(R.id.game_share_score_grade_2);
        this.fJQ = (RadioButton) this.bEW.findViewById(R.id.game_share_score_grade_3);
        this.fJR = (RadioButton) this.bEW.findViewById(R.id.game_share_score_grade_4);
        this.fJS = (RadioButton) this.bEW.findViewById(R.id.game_share_score_grade_5);
        this.fJT = new RadioButton[]{this.fJO, this.fJP, this.fJQ, this.fJR, this.fJS};
        this.fJU = (TextView) this.bEW.findViewById(R.id.game_share_comment);
        this.fJV = (TbImageView) this.bEW.findViewById(R.id.game_share_user_protrait);
        this.fJV.setDrawerType(1);
        this.fJV.setIsRound(true);
        this.csn = (TextView) this.bEW.findViewById(R.id.game_share_user_name);
        this.fJW = (RadioButton) this.bEW.findViewById(R.id.game_share_user_score_grade_1);
        this.fJX = (RadioButton) this.bEW.findViewById(R.id.game_share_user_score_grade_2);
        this.fJY = (RadioButton) this.bEW.findViewById(R.id.game_share_user_score_grade_3);
        this.fJZ = (RadioButton) this.bEW.findViewById(R.id.game_share_user_score_grade_4);
        this.fKa = (RadioButton) this.bEW.findViewById(R.id.game_share_user_score_grade_5);
        this.fKb = new RadioButton[]{this.fJW, this.fJX, this.fJY, this.fJZ, this.fKa};
        this.fKc = (TextView) this.bEW.findViewById(R.id.game_share_qr_txt);
        this.fKd = (TbImageView) this.bEW.findViewById(R.id.game_share_qr_img);
        this.euX = (LinearLayout) this.bEW.findViewById(R.id.game_share_entry_layout);
        this.fKe = (TextView) this.bEW.findViewById(R.id.game_share_entry_weixin);
        this.fKe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnV = a.this.bnV();
                if (bnV != null && a.this.fKj != null) {
                    a.this.fKj.t(bnV);
                }
            }
        });
        this.fKf = (TextView) this.bEW.findViewById(R.id.game_share_entry_wxfriends);
        this.fKf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnV = a.this.bnV();
                if (bnV != null && a.this.fKj != null) {
                    a.this.fKj.u(bnV);
                }
            }
        });
        this.fKg = (TextView) this.bEW.findViewById(R.id.game_share_entry_qq);
        this.fKg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnV = a.this.bnV();
                if (bnV != null && a.this.fKj != null) {
                    a.this.fKj.v(bnV);
                }
            }
        });
        this.fKh = (TextView) this.bEW.findViewById(R.id.game_share_entry_sina);
        this.fKh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnV = a.this.bnV();
                if (bnV != null && a.this.fKj != null) {
                    a.this.fKj.w(bnV);
                }
            }
        });
        this.fKi = (TextView) this.bEW.findViewById(R.id.game_share_cancel);
        this.fKi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fKj != null) {
                    a.this.fKj.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.bEW;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.bZr);
        sb.append(" ”");
        this.fJU.setText(sb);
        if (this.fKk == null) {
            c.fT().a(gameShareData.bZn, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.bEW.getContext(), (int) R.string.share_failed);
                        if (a.this.fKj != null) {
                            a.this.fKj.onCancel();
                        }
                    }
                    a.this.fKk = new BlurDrawable(a.this.bEW.getContext());
                    a.this.fKk.init(2, 4, aVar.getRawBitmap());
                    a.this.fKk.drawBlur();
                    a.this.fJH.setImageBitmap(a.this.fKk.getBlurredBitmap());
                }
            }, null);
        }
        this.eAi.startLoad(gameShareData.bZt, 10, false);
        this.fKd.startLoad(gameShareData.bZs, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fJK.startLoad(gameShareData.bZn, 10, false);
            this.fJL.setText(gameShareData.gameName);
            this.fJM.setText(gameShareData.bZo);
            this.fJN.setText(new DecimalFormat(".0").format(gameShareData.bZp));
            a((int) gameShareData.bZp, this.fJT);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fJV.startLoad(gameShareData.userPortrait, 12, false);
            this.csn.setText(gameShareData.userName);
            a((int) gameShareData.bZq, this.fKb);
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

    public Bitmap bnV() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bnW() {
        return this.dUa.getBottom();
    }

    public void onDestroy() {
        if (this.fKk != null) {
            this.fKk.onDestroy();
            this.fKk = null;
        }
    }
}

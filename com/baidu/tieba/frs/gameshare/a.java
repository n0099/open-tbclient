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
    private FrameLayout bmj;
    private TextView cdZ;
    private LinearLayout dHb;
    private LinearLayout ehP;
    private TbImageView epT;
    private TextView fKA;
    private TbImageView fKB;
    private RadioButton fKC;
    private RadioButton fKD;
    private RadioButton fKE;
    private RadioButton fKF;
    private RadioButton fKG;
    private RadioButton[] fKH;
    private TextView fKI;
    private TbImageView fKJ;
    private TextView fKK;
    private TextView fKL;
    private TextView fKM;
    private TextView fKN;
    private TextView fKO;
    private InterfaceC0324a fKP;
    private BlurDrawable fKQ;
    private ImageView fKn;
    private FrameLayout fKo;
    private ColumnLayout fKp;
    private TbImageView fKq;
    private TextView fKr;
    private TextView fKs;
    private TextView fKt;
    private RadioButton fKu;
    private RadioButton fKv;
    private RadioButton fKw;
    private RadioButton fKx;
    private RadioButton fKy;
    private RadioButton[] fKz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0324a {
        void onCancel();

        void v(Bitmap bitmap);

        void w(Bitmap bitmap);

        void x(Bitmap bitmap);

        void y(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0324a interfaceC0324a) {
        this.fKP = interfaceC0324a;
        this.bmj = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.bmj.findViewById(R.id.game_share_content_layout);
        this.fKn = (ImageView) this.bmj.findViewById(R.id.game_share_content_bg_view);
        this.dHb = (LinearLayout) this.bmj.findViewById(R.id.game_share_card_layout);
        this.fKo = (FrameLayout) this.bmj.findViewById(R.id.game_share_header_root);
        this.fKp = (ColumnLayout) this.bmj.findViewById(R.id.game_share_header_layout);
        this.epT = (TbImageView) this.bmj.findViewById(R.id.game_share_header_bg_view);
        this.epT.setVisibility(4);
        this.epT.setDefaultBg(new ColorDrawable(this.bmj.getResources().getColor(R.color.transparent)));
        this.epT.setDrawerType(1);
        this.epT.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.epT.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z) {
                    a.this.epT.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fKq = (TbImageView) this.bmj.findViewById(R.id.game_share_game_icon);
        this.fKq.setDrawerType(1);
        this.fKq.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.fKr = (TextView) this.bmj.findViewById(R.id.game_share_game_name);
        this.fKs = (TextView) this.bmj.findViewById(R.id.game_share_game_description);
        this.fKt = (TextView) this.bmj.findViewById(R.id.game_share_game_score);
        this.fKu = (RadioButton) this.bmj.findViewById(R.id.game_share_score_grade_1);
        this.fKv = (RadioButton) this.bmj.findViewById(R.id.game_share_score_grade_2);
        this.fKw = (RadioButton) this.bmj.findViewById(R.id.game_share_score_grade_3);
        this.fKx = (RadioButton) this.bmj.findViewById(R.id.game_share_score_grade_4);
        this.fKy = (RadioButton) this.bmj.findViewById(R.id.game_share_score_grade_5);
        this.fKz = new RadioButton[]{this.fKu, this.fKv, this.fKw, this.fKx, this.fKy};
        this.fKA = (TextView) this.bmj.findViewById(R.id.game_share_comment);
        this.fKB = (TbImageView) this.bmj.findViewById(R.id.game_share_user_protrait);
        this.fKB.setDrawerType(1);
        this.fKB.setIsRound(true);
        this.cdZ = (TextView) this.bmj.findViewById(R.id.game_share_user_name);
        this.fKC = (RadioButton) this.bmj.findViewById(R.id.game_share_user_score_grade_1);
        this.fKD = (RadioButton) this.bmj.findViewById(R.id.game_share_user_score_grade_2);
        this.fKE = (RadioButton) this.bmj.findViewById(R.id.game_share_user_score_grade_3);
        this.fKF = (RadioButton) this.bmj.findViewById(R.id.game_share_user_score_grade_4);
        this.fKG = (RadioButton) this.bmj.findViewById(R.id.game_share_user_score_grade_5);
        this.fKH = new RadioButton[]{this.fKC, this.fKD, this.fKE, this.fKF, this.fKG};
        this.fKI = (TextView) this.bmj.findViewById(R.id.game_share_qr_txt);
        this.fKJ = (TbImageView) this.bmj.findViewById(R.id.game_share_qr_img);
        this.ehP = (LinearLayout) this.bmj.findViewById(R.id.game_share_entry_layout);
        this.fKK = (TextView) this.bmj.findViewById(R.id.game_share_entry_weixin);
        this.fKK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bqQ = a.this.bqQ();
                if (bqQ != null && a.this.fKP != null) {
                    a.this.fKP.v(bqQ);
                }
            }
        });
        this.fKL = (TextView) this.bmj.findViewById(R.id.game_share_entry_wxfriends);
        this.fKL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bqQ = a.this.bqQ();
                if (bqQ != null && a.this.fKP != null) {
                    a.this.fKP.w(bqQ);
                }
            }
        });
        this.fKM = (TextView) this.bmj.findViewById(R.id.game_share_entry_qq);
        this.fKM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bqQ = a.this.bqQ();
                if (bqQ != null && a.this.fKP != null) {
                    a.this.fKP.x(bqQ);
                }
            }
        });
        this.fKN = (TextView) this.bmj.findViewById(R.id.game_share_entry_sina);
        this.fKN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bqQ = a.this.bqQ();
                if (bqQ != null && a.this.fKP != null) {
                    a.this.fKP.y(bqQ);
                }
            }
        });
        this.fKO = (TextView) this.bmj.findViewById(R.id.game_share_cancel);
        this.fKO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fKP != null) {
                    a.this.fKP.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.bmj;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.bHG);
        sb.append(" ”");
        this.fKA.setText(sb);
        if (this.fKQ == null) {
            c.iE().a(gameShareData.bHC, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.nK() == null) {
                        UtilHelper.showToast(a.this.bmj.getContext(), (int) R.string.share_failed);
                        if (a.this.fKP != null) {
                            a.this.fKP.onCancel();
                        }
                    }
                    a.this.fKQ = new BlurDrawable(a.this.bmj.getContext());
                    a.this.fKQ.init(2, 4, aVar.nK());
                    a.this.fKQ.drawBlur();
                    a.this.fKn.setImageBitmap(a.this.fKQ.getBlurredBitmap());
                }
            }, null);
        }
        this.epT.startLoad(gameShareData.bHI, 10, false);
        this.fKJ.startLoad(gameShareData.bHH, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fKq.startLoad(gameShareData.bHC, 10, false);
            this.fKr.setText(gameShareData.gameName);
            this.fKs.setText(gameShareData.bHD);
            this.fKt.setText(new DecimalFormat(".0").format(gameShareData.bHE));
            a((int) gameShareData.bHE, this.fKz);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fKB.startLoad(gameShareData.userPortrait, 12, false);
            this.cdZ.setText(gameShareData.userName);
            a((int) gameShareData.bHF, this.fKH);
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

    public Bitmap bqQ() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bqR() {
        return this.dHb.getBottom();
    }

    public void onDestroy() {
        if (this.fKQ != null) {
            this.fKQ.onDestroy();
            this.fKQ = null;
        }
    }
}

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
    private FrameLayout bkY;
    private TextView cbV;
    private LinearLayout dBM;
    private LinearLayout ebB;
    private TbImageView eju;
    private ImageView fCL;
    private FrameLayout fCM;
    private ColumnLayout fCN;
    private TbImageView fCO;
    private TextView fCP;
    private TextView fCQ;
    private TextView fCR;
    private RadioButton fCS;
    private RadioButton fCT;
    private RadioButton fCU;
    private RadioButton fCV;
    private RadioButton fCW;
    private RadioButton[] fCX;
    private TextView fCY;
    private TbImageView fCZ;
    private RadioButton fDa;
    private RadioButton fDb;
    private RadioButton fDc;
    private RadioButton fDd;
    private RadioButton fDe;
    private RadioButton[] fDf;
    private TextView fDg;
    private TbImageView fDh;
    private TextView fDi;
    private TextView fDj;
    private TextView fDk;
    private TextView fDl;
    private TextView fDm;
    private InterfaceC0310a fDn;
    private BlurDrawable fDo;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0310a {
        void onCancel();

        void v(Bitmap bitmap);

        void w(Bitmap bitmap);

        void x(Bitmap bitmap);

        void y(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0310a interfaceC0310a) {
        this.fDn = interfaceC0310a;
        this.bkY = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.bkY.findViewById(R.id.game_share_content_layout);
        this.fCL = (ImageView) this.bkY.findViewById(R.id.game_share_content_bg_view);
        this.dBM = (LinearLayout) this.bkY.findViewById(R.id.game_share_card_layout);
        this.fCM = (FrameLayout) this.bkY.findViewById(R.id.game_share_header_root);
        this.fCN = (ColumnLayout) this.bkY.findViewById(R.id.game_share_header_layout);
        this.eju = (TbImageView) this.bkY.findViewById(R.id.game_share_header_bg_view);
        this.eju.setVisibility(4);
        this.eju.setDefaultBg(new ColorDrawable(this.bkY.getResources().getColor(R.color.transparent)));
        this.eju.setDrawerType(1);
        this.eju.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.eju.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z) {
                    a.this.eju.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fCO = (TbImageView) this.bkY.findViewById(R.id.game_share_game_icon);
        this.fCO.setDrawerType(1);
        this.fCO.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.fCP = (TextView) this.bkY.findViewById(R.id.game_share_game_name);
        this.fCQ = (TextView) this.bkY.findViewById(R.id.game_share_game_description);
        this.fCR = (TextView) this.bkY.findViewById(R.id.game_share_game_score);
        this.fCS = (RadioButton) this.bkY.findViewById(R.id.game_share_score_grade_1);
        this.fCT = (RadioButton) this.bkY.findViewById(R.id.game_share_score_grade_2);
        this.fCU = (RadioButton) this.bkY.findViewById(R.id.game_share_score_grade_3);
        this.fCV = (RadioButton) this.bkY.findViewById(R.id.game_share_score_grade_4);
        this.fCW = (RadioButton) this.bkY.findViewById(R.id.game_share_score_grade_5);
        this.fCX = new RadioButton[]{this.fCS, this.fCT, this.fCU, this.fCV, this.fCW};
        this.fCY = (TextView) this.bkY.findViewById(R.id.game_share_comment);
        this.fCZ = (TbImageView) this.bkY.findViewById(R.id.game_share_user_protrait);
        this.fCZ.setDrawerType(1);
        this.fCZ.setIsRound(true);
        this.cbV = (TextView) this.bkY.findViewById(R.id.game_share_user_name);
        this.fDa = (RadioButton) this.bkY.findViewById(R.id.game_share_user_score_grade_1);
        this.fDb = (RadioButton) this.bkY.findViewById(R.id.game_share_user_score_grade_2);
        this.fDc = (RadioButton) this.bkY.findViewById(R.id.game_share_user_score_grade_3);
        this.fDd = (RadioButton) this.bkY.findViewById(R.id.game_share_user_score_grade_4);
        this.fDe = (RadioButton) this.bkY.findViewById(R.id.game_share_user_score_grade_5);
        this.fDf = new RadioButton[]{this.fDa, this.fDb, this.fDc, this.fDd, this.fDe};
        this.fDg = (TextView) this.bkY.findViewById(R.id.game_share_qr_txt);
        this.fDh = (TbImageView) this.bkY.findViewById(R.id.game_share_qr_img);
        this.ebB = (LinearLayout) this.bkY.findViewById(R.id.game_share_entry_layout);
        this.fDi = (TextView) this.bkY.findViewById(R.id.game_share_entry_weixin);
        this.fDi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnN = a.this.bnN();
                if (bnN != null && a.this.fDn != null) {
                    a.this.fDn.v(bnN);
                }
            }
        });
        this.fDj = (TextView) this.bkY.findViewById(R.id.game_share_entry_wxfriends);
        this.fDj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnN = a.this.bnN();
                if (bnN != null && a.this.fDn != null) {
                    a.this.fDn.w(bnN);
                }
            }
        });
        this.fDk = (TextView) this.bkY.findViewById(R.id.game_share_entry_qq);
        this.fDk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnN = a.this.bnN();
                if (bnN != null && a.this.fDn != null) {
                    a.this.fDn.x(bnN);
                }
            }
        });
        this.fDl = (TextView) this.bkY.findViewById(R.id.game_share_entry_sina);
        this.fDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnN = a.this.bnN();
                if (bnN != null && a.this.fDn != null) {
                    a.this.fDn.y(bnN);
                }
            }
        });
        this.fDm = (TextView) this.bkY.findViewById(R.id.game_share_cancel);
        this.fDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fDn != null) {
                    a.this.fDn.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.bkY;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.bGf);
        sb.append(" ”");
        this.fCY.setText(sb);
        if (this.fDo == null) {
            c.iv().a(gameShareData.bGb, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.ns() == null) {
                        UtilHelper.showToast(a.this.bkY.getContext(), (int) R.string.share_failed);
                        if (a.this.fDn != null) {
                            a.this.fDn.onCancel();
                        }
                    }
                    a.this.fDo = new BlurDrawable(a.this.bkY.getContext());
                    a.this.fDo.init(2, 4, aVar.ns());
                    a.this.fDo.drawBlur();
                    a.this.fCL.setImageBitmap(a.this.fDo.getBlurredBitmap());
                }
            }, null);
        }
        this.eju.startLoad(gameShareData.bGh, 10, false);
        this.fDh.startLoad(gameShareData.bGg, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fCO.startLoad(gameShareData.bGb, 10, false);
            this.fCP.setText(gameShareData.gameName);
            this.fCQ.setText(gameShareData.bGc);
            this.fCR.setText(new DecimalFormat(".0").format(gameShareData.bGd));
            a((int) gameShareData.bGd, this.fCX);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fCZ.startLoad(gameShareData.userPortrait, 12, false);
            this.cbV.setText(gameShareData.userName);
            a((int) gameShareData.bGe, this.fDf);
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

    public Bitmap bnN() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bnO() {
        return this.dBM.getBottom();
    }

    public void onDestroy() {
        if (this.fDo != null) {
            this.fDo.onDestroy();
            this.fDo = null;
        }
    }
}

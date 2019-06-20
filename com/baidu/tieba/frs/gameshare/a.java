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
    private TextView cbW;
    private LinearLayout dBN;
    private LinearLayout ebC;
    private TbImageView ejv;
    private ImageView fCM;
    private FrameLayout fCN;
    private ColumnLayout fCO;
    private TbImageView fCP;
    private TextView fCQ;
    private TextView fCR;
    private TextView fCS;
    private RadioButton fCT;
    private RadioButton fCU;
    private RadioButton fCV;
    private RadioButton fCW;
    private RadioButton fCX;
    private RadioButton[] fCY;
    private TextView fCZ;
    private TbImageView fDa;
    private RadioButton fDb;
    private RadioButton fDc;
    private RadioButton fDd;
    private RadioButton fDe;
    private RadioButton fDf;
    private RadioButton[] fDg;
    private TextView fDh;
    private TbImageView fDi;
    private TextView fDj;
    private TextView fDk;
    private TextView fDl;
    private TextView fDm;
    private TextView fDn;
    private InterfaceC0310a fDo;
    private BlurDrawable fDp;
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
        this.fDo = interfaceC0310a;
        this.bkY = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.bkY.findViewById(R.id.game_share_content_layout);
        this.fCM = (ImageView) this.bkY.findViewById(R.id.game_share_content_bg_view);
        this.dBN = (LinearLayout) this.bkY.findViewById(R.id.game_share_card_layout);
        this.fCN = (FrameLayout) this.bkY.findViewById(R.id.game_share_header_root);
        this.fCO = (ColumnLayout) this.bkY.findViewById(R.id.game_share_header_layout);
        this.ejv = (TbImageView) this.bkY.findViewById(R.id.game_share_header_bg_view);
        this.ejv.setVisibility(4);
        this.ejv.setDefaultBg(new ColorDrawable(this.bkY.getResources().getColor(R.color.transparent)));
        this.ejv.setDrawerType(1);
        this.ejv.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.ejv.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void O(String str, boolean z) {
                if (z) {
                    a.this.ejv.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fCP = (TbImageView) this.bkY.findViewById(R.id.game_share_game_icon);
        this.fCP.setDrawerType(1);
        this.fCP.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.fCQ = (TextView) this.bkY.findViewById(R.id.game_share_game_name);
        this.fCR = (TextView) this.bkY.findViewById(R.id.game_share_game_description);
        this.fCS = (TextView) this.bkY.findViewById(R.id.game_share_game_score);
        this.fCT = (RadioButton) this.bkY.findViewById(R.id.game_share_score_grade_1);
        this.fCU = (RadioButton) this.bkY.findViewById(R.id.game_share_score_grade_2);
        this.fCV = (RadioButton) this.bkY.findViewById(R.id.game_share_score_grade_3);
        this.fCW = (RadioButton) this.bkY.findViewById(R.id.game_share_score_grade_4);
        this.fCX = (RadioButton) this.bkY.findViewById(R.id.game_share_score_grade_5);
        this.fCY = new RadioButton[]{this.fCT, this.fCU, this.fCV, this.fCW, this.fCX};
        this.fCZ = (TextView) this.bkY.findViewById(R.id.game_share_comment);
        this.fDa = (TbImageView) this.bkY.findViewById(R.id.game_share_user_protrait);
        this.fDa.setDrawerType(1);
        this.fDa.setIsRound(true);
        this.cbW = (TextView) this.bkY.findViewById(R.id.game_share_user_name);
        this.fDb = (RadioButton) this.bkY.findViewById(R.id.game_share_user_score_grade_1);
        this.fDc = (RadioButton) this.bkY.findViewById(R.id.game_share_user_score_grade_2);
        this.fDd = (RadioButton) this.bkY.findViewById(R.id.game_share_user_score_grade_3);
        this.fDe = (RadioButton) this.bkY.findViewById(R.id.game_share_user_score_grade_4);
        this.fDf = (RadioButton) this.bkY.findViewById(R.id.game_share_user_score_grade_5);
        this.fDg = new RadioButton[]{this.fDb, this.fDc, this.fDd, this.fDe, this.fDf};
        this.fDh = (TextView) this.bkY.findViewById(R.id.game_share_qr_txt);
        this.fDi = (TbImageView) this.bkY.findViewById(R.id.game_share_qr_img);
        this.ebC = (LinearLayout) this.bkY.findViewById(R.id.game_share_entry_layout);
        this.fDj = (TextView) this.bkY.findViewById(R.id.game_share_entry_weixin);
        this.fDj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnQ = a.this.bnQ();
                if (bnQ != null && a.this.fDo != null) {
                    a.this.fDo.v(bnQ);
                }
            }
        });
        this.fDk = (TextView) this.bkY.findViewById(R.id.game_share_entry_wxfriends);
        this.fDk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnQ = a.this.bnQ();
                if (bnQ != null && a.this.fDo != null) {
                    a.this.fDo.w(bnQ);
                }
            }
        });
        this.fDl = (TextView) this.bkY.findViewById(R.id.game_share_entry_qq);
        this.fDl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnQ = a.this.bnQ();
                if (bnQ != null && a.this.fDo != null) {
                    a.this.fDo.x(bnQ);
                }
            }
        });
        this.fDm = (TextView) this.bkY.findViewById(R.id.game_share_entry_sina);
        this.fDm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnQ = a.this.bnQ();
                if (bnQ != null && a.this.fDo != null) {
                    a.this.fDo.y(bnQ);
                }
            }
        });
        this.fDn = (TextView) this.bkY.findViewById(R.id.game_share_cancel);
        this.fDn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fDo != null) {
                    a.this.fDo.onCancel();
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
        sb.append(gameShareData.bGg);
        sb.append(" ”");
        this.fCZ.setText(sb);
        if (this.fDp == null) {
            c.iv().a(gameShareData.bGc, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.ns() == null) {
                        UtilHelper.showToast(a.this.bkY.getContext(), (int) R.string.share_failed);
                        if (a.this.fDo != null) {
                            a.this.fDo.onCancel();
                        }
                    }
                    a.this.fDp = new BlurDrawable(a.this.bkY.getContext());
                    a.this.fDp.init(2, 4, aVar.ns());
                    a.this.fDp.drawBlur();
                    a.this.fCM.setImageBitmap(a.this.fDp.getBlurredBitmap());
                }
            }, null);
        }
        this.ejv.startLoad(gameShareData.bGi, 10, false);
        this.fDi.startLoad(gameShareData.bGh, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fCP.startLoad(gameShareData.bGc, 10, false);
            this.fCQ.setText(gameShareData.gameName);
            this.fCR.setText(gameShareData.bGd);
            this.fCS.setText(new DecimalFormat(".0").format(gameShareData.bGe));
            a((int) gameShareData.bGe, this.fCY);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fDa.startLoad(gameShareData.userPortrait, 12, false);
            this.cbW.setText(gameShareData.userName);
            a((int) gameShareData.bGf, this.fDg);
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

    public Bitmap bnQ() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bnR() {
        return this.dBN.getBottom();
    }

    public void onDestroy() {
        if (this.fDp != null) {
            this.fDp.onDestroy();
            this.fDp = null;
        }
    }
}

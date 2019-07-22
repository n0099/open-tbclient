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
    private FrameLayout blL;
    private TextView ccZ;
    private LinearLayout dFj;
    private LinearLayout efY;
    private TbImageView eoc;
    private ImageView fHK;
    private FrameLayout fHL;
    private ColumnLayout fHM;
    private TbImageView fHN;
    private TextView fHO;
    private TextView fHP;
    private TextView fHQ;
    private RadioButton fHR;
    private RadioButton fHS;
    private RadioButton fHT;
    private RadioButton fHU;
    private RadioButton fHV;
    private RadioButton[] fHW;
    private TextView fHX;
    private TbImageView fHY;
    private RadioButton fHZ;
    private RadioButton fIa;
    private RadioButton fIb;
    private RadioButton fIc;
    private RadioButton fId;
    private RadioButton[] fIe;
    private TextView fIf;
    private TbImageView fIg;
    private TextView fIh;
    private TextView fIi;
    private TextView fIj;
    private TextView fIk;
    private TextView fIl;
    private InterfaceC0307a fIm;
    private BlurDrawable fIn;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0307a {
        void onCancel();

        void v(Bitmap bitmap);

        void w(Bitmap bitmap);

        void x(Bitmap bitmap);

        void y(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0307a interfaceC0307a) {
        this.fIm = interfaceC0307a;
        this.blL = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.blL.findViewById(R.id.game_share_content_layout);
        this.fHK = (ImageView) this.blL.findViewById(R.id.game_share_content_bg_view);
        this.dFj = (LinearLayout) this.blL.findViewById(R.id.game_share_card_layout);
        this.fHL = (FrameLayout) this.blL.findViewById(R.id.game_share_header_root);
        this.fHM = (ColumnLayout) this.blL.findViewById(R.id.game_share_header_layout);
        this.eoc = (TbImageView) this.blL.findViewById(R.id.game_share_header_bg_view);
        this.eoc.setVisibility(4);
        this.eoc.setDefaultBg(new ColorDrawable(this.blL.getResources().getColor(R.color.transparent)));
        this.eoc.setDrawerType(1);
        this.eoc.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.eoc.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z) {
                    a.this.eoc.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fHN = (TbImageView) this.blL.findViewById(R.id.game_share_game_icon);
        this.fHN.setDrawerType(1);
        this.fHN.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.fHO = (TextView) this.blL.findViewById(R.id.game_share_game_name);
        this.fHP = (TextView) this.blL.findViewById(R.id.game_share_game_description);
        this.fHQ = (TextView) this.blL.findViewById(R.id.game_share_game_score);
        this.fHR = (RadioButton) this.blL.findViewById(R.id.game_share_score_grade_1);
        this.fHS = (RadioButton) this.blL.findViewById(R.id.game_share_score_grade_2);
        this.fHT = (RadioButton) this.blL.findViewById(R.id.game_share_score_grade_3);
        this.fHU = (RadioButton) this.blL.findViewById(R.id.game_share_score_grade_4);
        this.fHV = (RadioButton) this.blL.findViewById(R.id.game_share_score_grade_5);
        this.fHW = new RadioButton[]{this.fHR, this.fHS, this.fHT, this.fHU, this.fHV};
        this.fHX = (TextView) this.blL.findViewById(R.id.game_share_comment);
        this.fHY = (TbImageView) this.blL.findViewById(R.id.game_share_user_protrait);
        this.fHY.setDrawerType(1);
        this.fHY.setIsRound(true);
        this.ccZ = (TextView) this.blL.findViewById(R.id.game_share_user_name);
        this.fHZ = (RadioButton) this.blL.findViewById(R.id.game_share_user_score_grade_1);
        this.fIa = (RadioButton) this.blL.findViewById(R.id.game_share_user_score_grade_2);
        this.fIb = (RadioButton) this.blL.findViewById(R.id.game_share_user_score_grade_3);
        this.fIc = (RadioButton) this.blL.findViewById(R.id.game_share_user_score_grade_4);
        this.fId = (RadioButton) this.blL.findViewById(R.id.game_share_user_score_grade_5);
        this.fIe = new RadioButton[]{this.fHZ, this.fIa, this.fIb, this.fIc, this.fId};
        this.fIf = (TextView) this.blL.findViewById(R.id.game_share_qr_txt);
        this.fIg = (TbImageView) this.blL.findViewById(R.id.game_share_qr_img);
        this.efY = (LinearLayout) this.blL.findViewById(R.id.game_share_entry_layout);
        this.fIh = (TextView) this.blL.findViewById(R.id.game_share_entry_weixin);
        this.fIh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bpR = a.this.bpR();
                if (bpR != null && a.this.fIm != null) {
                    a.this.fIm.v(bpR);
                }
            }
        });
        this.fIi = (TextView) this.blL.findViewById(R.id.game_share_entry_wxfriends);
        this.fIi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bpR = a.this.bpR();
                if (bpR != null && a.this.fIm != null) {
                    a.this.fIm.w(bpR);
                }
            }
        });
        this.fIj = (TextView) this.blL.findViewById(R.id.game_share_entry_qq);
        this.fIj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bpR = a.this.bpR();
                if (bpR != null && a.this.fIm != null) {
                    a.this.fIm.x(bpR);
                }
            }
        });
        this.fIk = (TextView) this.blL.findViewById(R.id.game_share_entry_sina);
        this.fIk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bpR = a.this.bpR();
                if (bpR != null && a.this.fIm != null) {
                    a.this.fIm.y(bpR);
                }
            }
        });
        this.fIl = (TextView) this.blL.findViewById(R.id.game_share_cancel);
        this.fIl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fIm != null) {
                    a.this.fIm.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.blL;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.bHh);
        sb.append(" ”");
        this.fHX.setText(sb);
        if (this.fIn == null) {
            c.iE().a(gameShareData.bHd, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.nK() == null) {
                        UtilHelper.showToast(a.this.blL.getContext(), (int) R.string.share_failed);
                        if (a.this.fIm != null) {
                            a.this.fIm.onCancel();
                        }
                    }
                    a.this.fIn = new BlurDrawable(a.this.blL.getContext());
                    a.this.fIn.init(2, 4, aVar.nK());
                    a.this.fIn.drawBlur();
                    a.this.fHK.setImageBitmap(a.this.fIn.getBlurredBitmap());
                }
            }, null);
        }
        this.eoc.startLoad(gameShareData.bHj, 10, false);
        this.fIg.startLoad(gameShareData.bHi, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fHN.startLoad(gameShareData.bHd, 10, false);
            this.fHO.setText(gameShareData.gameName);
            this.fHP.setText(gameShareData.bHe);
            this.fHQ.setText(new DecimalFormat(".0").format(gameShareData.bHf));
            a((int) gameShareData.bHf, this.fHW);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fHY.startLoad(gameShareData.userPortrait, 12, false);
            this.ccZ.setText(gameShareData.userName);
            a((int) gameShareData.bHg, this.fIe);
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

    public Bitmap bpR() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bpS() {
        return this.dFj.getBottom();
    }

    public void onDestroy() {
        if (this.fIn != null) {
            this.fIn.onDestroy();
            this.fIn = null;
        }
    }
}

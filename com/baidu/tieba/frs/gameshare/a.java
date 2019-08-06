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
    private TextView cdg;
    private LinearLayout dFq;
    private LinearLayout egf;
    private TbImageView eoj;
    private ColumnLayout fIA;
    private TbImageView fIB;
    private TextView fIC;
    private TextView fID;
    private TextView fIE;
    private RadioButton fIF;
    private RadioButton fIG;
    private RadioButton fIH;
    private RadioButton fII;
    private RadioButton fIJ;
    private RadioButton[] fIK;
    private TextView fIL;
    private TbImageView fIM;
    private RadioButton fIN;
    private RadioButton fIO;
    private RadioButton fIP;
    private RadioButton fIQ;
    private RadioButton fIR;
    private RadioButton[] fIS;
    private TextView fIT;
    private TbImageView fIU;
    private TextView fIV;
    private TextView fIW;
    private TextView fIX;
    private TextView fIY;
    private TextView fIZ;
    private ImageView fIy;
    private FrameLayout fIz;
    private InterfaceC0313a fJa;
    private BlurDrawable fJb;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0313a {
        void onCancel();

        void v(Bitmap bitmap);

        void w(Bitmap bitmap);

        void x(Bitmap bitmap);

        void y(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0313a interfaceC0313a) {
        this.fJa = interfaceC0313a;
        this.blL = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.blL.findViewById(R.id.game_share_content_layout);
        this.fIy = (ImageView) this.blL.findViewById(R.id.game_share_content_bg_view);
        this.dFq = (LinearLayout) this.blL.findViewById(R.id.game_share_card_layout);
        this.fIz = (FrameLayout) this.blL.findViewById(R.id.game_share_header_root);
        this.fIA = (ColumnLayout) this.blL.findViewById(R.id.game_share_header_layout);
        this.eoj = (TbImageView) this.blL.findViewById(R.id.game_share_header_bg_view);
        this.eoj.setVisibility(4);
        this.eoj.setDefaultBg(new ColorDrawable(this.blL.getResources().getColor(R.color.transparent)));
        this.eoj.setDrawerType(1);
        this.eoj.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.eoj.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void P(String str, boolean z) {
                if (z) {
                    a.this.eoj.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fIB = (TbImageView) this.blL.findViewById(R.id.game_share_game_icon);
        this.fIB.setDrawerType(1);
        this.fIB.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.fIC = (TextView) this.blL.findViewById(R.id.game_share_game_name);
        this.fID = (TextView) this.blL.findViewById(R.id.game_share_game_description);
        this.fIE = (TextView) this.blL.findViewById(R.id.game_share_game_score);
        this.fIF = (RadioButton) this.blL.findViewById(R.id.game_share_score_grade_1);
        this.fIG = (RadioButton) this.blL.findViewById(R.id.game_share_score_grade_2);
        this.fIH = (RadioButton) this.blL.findViewById(R.id.game_share_score_grade_3);
        this.fII = (RadioButton) this.blL.findViewById(R.id.game_share_score_grade_4);
        this.fIJ = (RadioButton) this.blL.findViewById(R.id.game_share_score_grade_5);
        this.fIK = new RadioButton[]{this.fIF, this.fIG, this.fIH, this.fII, this.fIJ};
        this.fIL = (TextView) this.blL.findViewById(R.id.game_share_comment);
        this.fIM = (TbImageView) this.blL.findViewById(R.id.game_share_user_protrait);
        this.fIM.setDrawerType(1);
        this.fIM.setIsRound(true);
        this.cdg = (TextView) this.blL.findViewById(R.id.game_share_user_name);
        this.fIN = (RadioButton) this.blL.findViewById(R.id.game_share_user_score_grade_1);
        this.fIO = (RadioButton) this.blL.findViewById(R.id.game_share_user_score_grade_2);
        this.fIP = (RadioButton) this.blL.findViewById(R.id.game_share_user_score_grade_3);
        this.fIQ = (RadioButton) this.blL.findViewById(R.id.game_share_user_score_grade_4);
        this.fIR = (RadioButton) this.blL.findViewById(R.id.game_share_user_score_grade_5);
        this.fIS = new RadioButton[]{this.fIN, this.fIO, this.fIP, this.fIQ, this.fIR};
        this.fIT = (TextView) this.blL.findViewById(R.id.game_share_qr_txt);
        this.fIU = (TbImageView) this.blL.findViewById(R.id.game_share_qr_img);
        this.egf = (LinearLayout) this.blL.findViewById(R.id.game_share_entry_layout);
        this.fIV = (TextView) this.blL.findViewById(R.id.game_share_entry_weixin);
        this.fIV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bqe = a.this.bqe();
                if (bqe != null && a.this.fJa != null) {
                    a.this.fJa.v(bqe);
                }
            }
        });
        this.fIW = (TextView) this.blL.findViewById(R.id.game_share_entry_wxfriends);
        this.fIW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bqe = a.this.bqe();
                if (bqe != null && a.this.fJa != null) {
                    a.this.fJa.w(bqe);
                }
            }
        });
        this.fIX = (TextView) this.blL.findViewById(R.id.game_share_entry_qq);
        this.fIX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bqe = a.this.bqe();
                if (bqe != null && a.this.fJa != null) {
                    a.this.fJa.x(bqe);
                }
            }
        });
        this.fIY = (TextView) this.blL.findViewById(R.id.game_share_entry_sina);
        this.fIY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bqe = a.this.bqe();
                if (bqe != null && a.this.fJa != null) {
                    a.this.fJa.y(bqe);
                }
            }
        });
        this.fIZ = (TextView) this.blL.findViewById(R.id.game_share_cancel);
        this.fIZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fJa != null) {
                    a.this.fJa.onCancel();
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
        sb.append(gameShareData.bHi);
        sb.append(" ”");
        this.fIL.setText(sb);
        if (this.fJb == null) {
            c.iE().a(gameShareData.bHe, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.nK() == null) {
                        UtilHelper.showToast(a.this.blL.getContext(), (int) R.string.share_failed);
                        if (a.this.fJa != null) {
                            a.this.fJa.onCancel();
                        }
                    }
                    a.this.fJb = new BlurDrawable(a.this.blL.getContext());
                    a.this.fJb.init(2, 4, aVar.nK());
                    a.this.fJb.drawBlur();
                    a.this.fIy.setImageBitmap(a.this.fJb.getBlurredBitmap());
                }
            }, null);
        }
        this.eoj.startLoad(gameShareData.bHk, 10, false);
        this.fIU.startLoad(gameShareData.bHj, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fIB.startLoad(gameShareData.bHe, 10, false);
            this.fIC.setText(gameShareData.gameName);
            this.fID.setText(gameShareData.bHf);
            this.fIE.setText(new DecimalFormat(".0").format(gameShareData.bHg));
            a((int) gameShareData.bHg, this.fIK);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fIM.startLoad(gameShareData.userPortrait, 12, false);
            this.cdg.setText(gameShareData.userName);
            a((int) gameShareData.bHh, this.fIS);
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

    public Bitmap bqe() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bqf() {
        return this.dFq.getBottom();
    }

    public void onDestroy() {
        if (this.fJb != null) {
            this.fJb.onDestroy();
            this.fJb = null;
        }
    }
}

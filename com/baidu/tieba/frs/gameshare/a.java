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
import com.baidu.adp.lib.e.b;
import com.baidu.adp.lib.e.c;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import java.text.DecimalFormat;
/* loaded from: classes6.dex */
public class a {
    private TextView bXt;
    private FrameLayout coJ;
    private LinearLayout eIQ;
    private LinearLayout flC;
    private TbImageView fqR;
    private TextView gxA;
    private TbImageView gxB;
    private TextView gxC;
    private TextView gxD;
    private TextView gxE;
    private TextView gxF;
    private TextView gxG;
    private InterfaceC0496a gxH;
    private BlurDrawable gxI;
    private ImageView gxf;
    private FrameLayout gxg;
    private ColumnLayout gxh;
    private TbImageView gxi;
    private TextView gxj;
    private TextView gxk;
    private TextView gxl;
    private RadioButton gxm;
    private RadioButton gxn;
    private RadioButton gxo;
    private RadioButton gxp;
    private RadioButton gxq;
    private RadioButton[] gxr;
    private TextView gxs;
    private TbImageView gxt;
    private RadioButton gxu;
    private RadioButton gxv;
    private RadioButton gxw;
    private RadioButton gxx;
    private RadioButton gxy;
    private RadioButton[] gxz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0496a {
        void onCancel();

        void t(Bitmap bitmap);

        void u(Bitmap bitmap);

        void v(Bitmap bitmap);

        void w(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0496a interfaceC0496a) {
        this.gxH = interfaceC0496a;
        this.coJ = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.coJ.findViewById(R.id.game_share_content_layout);
        this.gxf = (ImageView) this.coJ.findViewById(R.id.game_share_content_bg_view);
        this.eIQ = (LinearLayout) this.coJ.findViewById(R.id.game_share_card_layout);
        this.gxg = (FrameLayout) this.coJ.findViewById(R.id.game_share_header_root);
        this.gxh = (ColumnLayout) this.coJ.findViewById(R.id.game_share_header_layout);
        this.fqR = (TbImageView) this.coJ.findViewById(R.id.game_share_header_bg_view);
        this.fqR.setVisibility(4);
        this.fqR.setDefaultBg(new ColorDrawable(this.coJ.getResources().getColor(R.color.transparent)));
        this.fqR.setDrawerType(1);
        this.fqR.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.fqR.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.fqR.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gxi = (TbImageView) this.coJ.findViewById(R.id.game_share_game_icon);
        this.gxi.setDrawerType(1);
        this.gxi.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.gxj = (TextView) this.coJ.findViewById(R.id.game_share_game_name);
        this.gxk = (TextView) this.coJ.findViewById(R.id.game_share_game_description);
        this.gxl = (TextView) this.coJ.findViewById(R.id.game_share_game_score);
        this.gxm = (RadioButton) this.coJ.findViewById(R.id.game_share_score_grade_1);
        this.gxn = (RadioButton) this.coJ.findViewById(R.id.game_share_score_grade_2);
        this.gxo = (RadioButton) this.coJ.findViewById(R.id.game_share_score_grade_3);
        this.gxp = (RadioButton) this.coJ.findViewById(R.id.game_share_score_grade_4);
        this.gxq = (RadioButton) this.coJ.findViewById(R.id.game_share_score_grade_5);
        this.gxr = new RadioButton[]{this.gxm, this.gxn, this.gxo, this.gxp, this.gxq};
        this.gxs = (TextView) this.coJ.findViewById(R.id.game_share_comment);
        this.gxt = (TbImageView) this.coJ.findViewById(R.id.game_share_user_protrait);
        this.gxt.setDrawerType(1);
        this.gxt.setIsRound(true);
        this.bXt = (TextView) this.coJ.findViewById(R.id.game_share_user_name);
        this.gxu = (RadioButton) this.coJ.findViewById(R.id.game_share_user_score_grade_1);
        this.gxv = (RadioButton) this.coJ.findViewById(R.id.game_share_user_score_grade_2);
        this.gxw = (RadioButton) this.coJ.findViewById(R.id.game_share_user_score_grade_3);
        this.gxx = (RadioButton) this.coJ.findViewById(R.id.game_share_user_score_grade_4);
        this.gxy = (RadioButton) this.coJ.findViewById(R.id.game_share_user_score_grade_5);
        this.gxz = new RadioButton[]{this.gxu, this.gxv, this.gxw, this.gxx, this.gxy};
        this.gxA = (TextView) this.coJ.findViewById(R.id.game_share_qr_txt);
        this.gxB = (TbImageView) this.coJ.findViewById(R.id.game_share_qr_img);
        this.flC = (LinearLayout) this.coJ.findViewById(R.id.game_share_entry_layout);
        this.gxC = (TextView) this.coJ.findViewById(R.id.game_share_entry_weixin);
        this.gxC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bFq = a.this.bFq();
                if (bFq != null && a.this.gxH != null) {
                    a.this.gxH.t(bFq);
                }
            }
        });
        this.gxD = (TextView) this.coJ.findViewById(R.id.game_share_entry_wxfriends);
        this.gxD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bFq = a.this.bFq();
                if (bFq != null && a.this.gxH != null) {
                    a.this.gxH.u(bFq);
                }
            }
        });
        this.gxE = (TextView) this.coJ.findViewById(R.id.game_share_entry_qq);
        this.gxE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bFq = a.this.bFq();
                if (bFq != null && a.this.gxH != null) {
                    a.this.gxH.v(bFq);
                }
            }
        });
        this.gxF = (TextView) this.coJ.findViewById(R.id.game_share_entry_sina);
        this.gxF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bFq = a.this.bFq();
                if (bFq != null && a.this.gxH != null) {
                    a.this.gxH.w(bFq);
                }
            }
        });
        this.gxG = (TextView) this.coJ.findViewById(R.id.game_share_cancel);
        this.gxG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.gxH != null) {
                    a.this.gxH.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.coJ;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.gxs.setText(sb);
        if (this.gxI == null) {
            c.gs().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.coJ.getContext(), (int) R.string.share_failed);
                        if (a.this.gxH != null) {
                            a.this.gxH.onCancel();
                        }
                    }
                    a.this.gxI = new BlurDrawable(a.this.coJ.getContext());
                    a.this.gxI.init(2, 4, aVar.getRawBitmap());
                    a.this.gxI.drawBlur();
                    a.this.gxf.setImageBitmap(a.this.gxI.getBlurredBitmap());
                }
            }, null);
        }
        this.fqR.startLoad(gameShareData.headBgUrl, 10, false);
        this.gxB.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.gxi.startLoad(gameShareData.gameIconUrl, 10, false);
            this.gxj.setText(gameShareData.gameName);
            this.gxk.setText(gameShareData.gameDescription);
            this.gxl.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.gxr);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.gxt.startLoad(gameShareData.userPortrait, 12, false);
            this.bXt.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.gxz);
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

    public Bitmap bFq() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bFr() {
        return this.eIQ.getBottom();
    }

    public void onDestroy() {
        if (this.gxI != null) {
            this.gxI.onDestroy();
            this.gxI = null;
        }
    }
}

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
/* loaded from: classes9.dex */
public class a {
    private TextView dXU;
    private FrameLayout ddl;
    private LinearLayout fGW;
    private LinearLayout glx;
    private TbImageView gqV;
    private ImageView hBR;
    private FrameLayout hBS;
    private ColumnLayout hBT;
    private TbImageView hBU;
    private TextView hBV;
    private TextView hBW;
    private TextView hBX;
    private RadioButton hBY;
    private RadioButton hBZ;
    private RadioButton hCa;
    private RadioButton hCb;
    private RadioButton hCc;
    private RadioButton[] hCd;
    private TextView hCe;
    private TbImageView hCf;
    private RadioButton hCg;
    private RadioButton hCh;
    private RadioButton hCi;
    private RadioButton hCj;
    private RadioButton hCk;
    private RadioButton[] hCl;
    private TextView hCm;
    private TbImageView hCn;
    private TextView hCo;
    private TextView hCp;
    private TextView hCq;
    private TextView hCr;
    private TextView hCs;
    private InterfaceC0615a hCt;
    private BlurDrawable hCu;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0615a {
        void onCancel();

        void v(Bitmap bitmap);

        void w(Bitmap bitmap);

        void x(Bitmap bitmap);

        void y(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0615a interfaceC0615a) {
        this.hCt = interfaceC0615a;
        this.ddl = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.ddl.findViewById(R.id.game_share_content_layout);
        this.hBR = (ImageView) this.ddl.findViewById(R.id.game_share_content_bg_view);
        this.fGW = (LinearLayout) this.ddl.findViewById(R.id.game_share_card_layout);
        this.hBS = (FrameLayout) this.ddl.findViewById(R.id.game_share_header_root);
        this.hBT = (ColumnLayout) this.ddl.findViewById(R.id.game_share_header_layout);
        this.gqV = (TbImageView) this.ddl.findViewById(R.id.game_share_header_bg_view);
        this.gqV.setVisibility(4);
        this.gqV.setDefaultBg(new ColorDrawable(this.ddl.getResources().getColor(R.color.transparent)));
        this.gqV.setDrawerType(1);
        this.gqV.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.gqV.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.gqV.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.hBU = (TbImageView) this.ddl.findViewById(R.id.game_share_game_icon);
        this.hBU.setDrawerType(1);
        this.hBU.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.hBV = (TextView) this.ddl.findViewById(R.id.game_share_game_name);
        this.hBW = (TextView) this.ddl.findViewById(R.id.game_share_game_description);
        this.hBX = (TextView) this.ddl.findViewById(R.id.game_share_game_score);
        this.hBY = (RadioButton) this.ddl.findViewById(R.id.game_share_score_grade_1);
        this.hBZ = (RadioButton) this.ddl.findViewById(R.id.game_share_score_grade_2);
        this.hCa = (RadioButton) this.ddl.findViewById(R.id.game_share_score_grade_3);
        this.hCb = (RadioButton) this.ddl.findViewById(R.id.game_share_score_grade_4);
        this.hCc = (RadioButton) this.ddl.findViewById(R.id.game_share_score_grade_5);
        this.hCd = new RadioButton[]{this.hBY, this.hBZ, this.hCa, this.hCb, this.hCc};
        this.hCe = (TextView) this.ddl.findViewById(R.id.game_share_comment);
        this.hCf = (TbImageView) this.ddl.findViewById(R.id.game_share_user_protrait);
        this.hCf.setDrawerType(1);
        this.hCf.setIsRound(true);
        this.dXU = (TextView) this.ddl.findViewById(R.id.game_share_user_name);
        this.hCg = (RadioButton) this.ddl.findViewById(R.id.game_share_user_score_grade_1);
        this.hCh = (RadioButton) this.ddl.findViewById(R.id.game_share_user_score_grade_2);
        this.hCi = (RadioButton) this.ddl.findViewById(R.id.game_share_user_score_grade_3);
        this.hCj = (RadioButton) this.ddl.findViewById(R.id.game_share_user_score_grade_4);
        this.hCk = (RadioButton) this.ddl.findViewById(R.id.game_share_user_score_grade_5);
        this.hCl = new RadioButton[]{this.hCg, this.hCh, this.hCi, this.hCj, this.hCk};
        this.hCm = (TextView) this.ddl.findViewById(R.id.game_share_qr_txt);
        this.hCn = (TbImageView) this.ddl.findViewById(R.id.game_share_qr_img);
        this.glx = (LinearLayout) this.ddl.findViewById(R.id.game_share_entry_layout);
        this.hCo = (TextView) this.ddl.findViewById(R.id.game_share_entry_weixin);
        this.hCo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bZc = a.this.bZc();
                if (bZc != null && a.this.hCt != null) {
                    a.this.hCt.v(bZc);
                }
            }
        });
        this.hCp = (TextView) this.ddl.findViewById(R.id.game_share_entry_wxfriends);
        this.hCp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bZc = a.this.bZc();
                if (bZc != null && a.this.hCt != null) {
                    a.this.hCt.w(bZc);
                }
            }
        });
        this.hCq = (TextView) this.ddl.findViewById(R.id.game_share_entry_qq);
        this.hCq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bZc = a.this.bZc();
                if (bZc != null && a.this.hCt != null) {
                    a.this.hCt.x(bZc);
                }
            }
        });
        this.hCr = (TextView) this.ddl.findViewById(R.id.game_share_entry_sina);
        this.hCr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bZc = a.this.bZc();
                if (bZc != null && a.this.hCt != null) {
                    a.this.hCt.y(bZc);
                }
            }
        });
        this.hCs = (TextView) this.ddl.findViewById(R.id.game_share_cancel);
        this.hCs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.hCt != null) {
                    a.this.hCt.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.ddl;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.hCe.setText(sb);
        if (this.hCu == null) {
            c.kX().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.ddl.getContext(), (int) R.string.share_failed);
                        if (a.this.hCt != null) {
                            a.this.hCt.onCancel();
                        }
                    }
                    a.this.hCu = new BlurDrawable(a.this.ddl.getContext());
                    a.this.hCu.init(2, 4, aVar.getRawBitmap());
                    a.this.hCu.drawBlur();
                    a.this.hBR.setImageBitmap(a.this.hCu.getBlurredBitmap());
                }
            }, null);
        }
        this.gqV.startLoad(gameShareData.headBgUrl, 10, false);
        this.hCn.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.hBU.startLoad(gameShareData.gameIconUrl, 10, false);
            this.hBV.setText(gameShareData.gameName);
            this.hBW.setText(gameShareData.gameDescription);
            this.hBX.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.hCd);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.hCf.startLoad(gameShareData.userPortrait, 12, false);
            this.dXU.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.hCl);
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

    public Bitmap bZc() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bZd() {
        return this.fGW.getBottom();
    }

    public void onDestroy() {
        if (this.hCu != null) {
            this.hCu.onDestroy();
            this.hCu = null;
        }
    }
}

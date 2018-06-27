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
/* loaded from: classes3.dex */
public class a {
    private TextView azm;
    private LinearLayout bHJ;
    private FrameLayout buH;
    private LinearLayout chy;
    private ImageView dwG;
    private FrameLayout dwH;
    private ColumnLayout dwI;
    private TbImageView dwJ;
    private TbImageView dwK;
    private TextView dwL;
    private TextView dwM;
    private TextView dwN;
    private RadioButton dwO;
    private RadioButton dwP;
    private RadioButton dwQ;
    private RadioButton dwR;
    private RadioButton dwS;
    private RadioButton[] dwT;
    private TextView dwU;
    private TbImageView dwV;
    private RadioButton dwW;
    private RadioButton dwX;
    private RadioButton dwY;
    private RadioButton dwZ;
    private RadioButton dxa;
    private RadioButton[] dxb;
    private TextView dxc;
    private TbImageView dxd;
    private TextView dxe;
    private TextView dxf;
    private TextView dxg;
    private TextView dxh;
    private TextView dxi;
    private InterfaceC0156a dxj;
    private BlurDrawable dxk;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0156a {
        void n(Bitmap bitmap);

        void o(Bitmap bitmap);

        void onCancel();

        void p(Bitmap bitmap);

        void q(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0156a interfaceC0156a) {
        this.dxj = interfaceC0156a;
        this.buH = (FrameLayout) LayoutInflater.from(context).inflate(d.i.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.buH.findViewById(d.g.game_share_content_layout);
        this.dwG = (ImageView) this.buH.findViewById(d.g.game_share_content_bg_view);
        this.bHJ = (LinearLayout) this.buH.findViewById(d.g.game_share_card_layout);
        this.dwH = (FrameLayout) this.buH.findViewById(d.g.game_share_header_root);
        this.dwI = (ColumnLayout) this.buH.findViewById(d.g.game_share_header_layout);
        this.dwJ = (TbImageView) this.buH.findViewById(d.g.game_share_header_bg_view);
        this.dwJ.setVisibility(4);
        this.dwJ.setDefaultBg(new ColorDrawable(this.buH.getResources().getColor(d.C0142d.transparent)));
        this.dwJ.setDrawerType(1);
        this.dwJ.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.dwJ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void n(String str, boolean z) {
                if (z) {
                    a.this.dwJ.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dwK = (TbImageView) this.buH.findViewById(d.g.game_share_game_icon);
        this.dwK.setDrawerType(1);
        this.dwK.setRadius(context.getResources().getDimensionPixelSize(d.e.ds20));
        this.dwL = (TextView) this.buH.findViewById(d.g.game_share_game_name);
        this.dwM = (TextView) this.buH.findViewById(d.g.game_share_game_description);
        this.dwN = (TextView) this.buH.findViewById(d.g.game_share_game_score);
        this.dwO = (RadioButton) this.buH.findViewById(d.g.game_share_score_grade_1);
        this.dwP = (RadioButton) this.buH.findViewById(d.g.game_share_score_grade_2);
        this.dwQ = (RadioButton) this.buH.findViewById(d.g.game_share_score_grade_3);
        this.dwR = (RadioButton) this.buH.findViewById(d.g.game_share_score_grade_4);
        this.dwS = (RadioButton) this.buH.findViewById(d.g.game_share_score_grade_5);
        this.dwT = new RadioButton[]{this.dwO, this.dwP, this.dwQ, this.dwR, this.dwS};
        this.dwU = (TextView) this.buH.findViewById(d.g.game_share_comment);
        this.dwV = (TbImageView) this.buH.findViewById(d.g.game_share_user_protrait);
        this.dwV.setDrawerType(1);
        this.dwV.setIsRound(true);
        this.azm = (TextView) this.buH.findViewById(d.g.game_share_user_name);
        this.dwW = (RadioButton) this.buH.findViewById(d.g.game_share_user_score_grade_1);
        this.dwX = (RadioButton) this.buH.findViewById(d.g.game_share_user_score_grade_2);
        this.dwY = (RadioButton) this.buH.findViewById(d.g.game_share_user_score_grade_3);
        this.dwZ = (RadioButton) this.buH.findViewById(d.g.game_share_user_score_grade_4);
        this.dxa = (RadioButton) this.buH.findViewById(d.g.game_share_user_score_grade_5);
        this.dxb = new RadioButton[]{this.dwW, this.dwX, this.dwY, this.dwZ, this.dxa};
        this.dxc = (TextView) this.buH.findViewById(d.g.game_share_qr_txt);
        this.dxd = (TbImageView) this.buH.findViewById(d.g.game_share_qr_img);
        this.chy = (LinearLayout) this.buH.findViewById(d.g.game_share_entry_layout);
        this.dxe = (TextView) this.buH.findViewById(d.g.game_share_entry_weixin);
        this.dxe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap axC = a.this.axC();
                if (axC != null && a.this.dxj != null) {
                    a.this.dxj.n(axC);
                }
            }
        });
        this.dxf = (TextView) this.buH.findViewById(d.g.game_share_entry_wxfriends);
        this.dxf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap axC = a.this.axC();
                if (axC != null && a.this.dxj != null) {
                    a.this.dxj.o(axC);
                }
            }
        });
        this.dxg = (TextView) this.buH.findViewById(d.g.game_share_entry_qq);
        this.dxg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap axC = a.this.axC();
                if (axC != null && a.this.dxj != null) {
                    a.this.dxj.p(axC);
                }
            }
        });
        this.dxh = (TextView) this.buH.findViewById(d.g.game_share_entry_sina);
        this.dxh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap axC = a.this.axC();
                if (axC != null && a.this.dxj != null) {
                    a.this.dxj.q(axC);
                }
            }
        });
        this.dxi = (TextView) this.buH.findViewById(d.g.game_share_cancel);
        this.dxi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dxj != null) {
                    a.this.dxj.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.buH;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.agu);
        sb.append(" ”");
        this.dwU.setText(sb);
        if (this.dxk == null) {
            c.ig().a(gameShareData.agq, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.mZ() == null) {
                        UtilHelper.showToast(a.this.buH.getContext(), d.k.share_failed);
                        if (a.this.dxj != null) {
                            a.this.dxj.onCancel();
                        }
                    }
                    a.this.dxk = new BlurDrawable(a.this.buH.getContext());
                    a.this.dxk.init(2, 4, aVar.mZ());
                    a.this.dxk.drawBlur();
                    a.this.dwG.setImageBitmap(a.this.dxk.getBlurredBitmap());
                }
            }, null);
        }
        this.dwJ.startLoad(gameShareData.agw, 10, false);
        this.dxd.startLoad(gameShareData.agv, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dwK.startLoad(gameShareData.agq, 10, false);
            this.dwL.setText(gameShareData.gameName);
            this.dwM.setText(gameShareData.agr);
            this.dwN.setText(new DecimalFormat(".0").format(gameShareData.ags));
            a((int) gameShareData.ags, this.dwT);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dwV.startLoad(gameShareData.userPortrait, 12, false);
            this.azm.setText(gameShareData.userName);
            a((int) gameShareData.agt, this.dxb);
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

    public Bitmap axC() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int axD() {
        return this.bHJ.getBottom();
    }

    public void onDestroy() {
        if (this.dxk != null) {
            this.dxk.onDestroy();
            this.dxk = null;
        }
    }
}

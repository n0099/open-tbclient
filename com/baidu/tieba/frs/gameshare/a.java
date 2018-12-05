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
import com.baidu.tieba.e;
import java.text.DecimalFormat;
/* loaded from: classes3.dex */
public class a {
    private TextView aKT;
    private LinearLayout cCA;
    private TbImageView cKo;
    private LinearLayout cbs;
    private ImageView dVE;
    private FrameLayout dVF;
    private ColumnLayout dVG;
    private TbImageView dVH;
    private TextView dVI;
    private TextView dVJ;
    private TextView dVK;
    private RadioButton dVL;
    private RadioButton dVM;
    private RadioButton dVN;
    private RadioButton dVO;
    private RadioButton dVP;
    private RadioButton[] dVQ;
    private TextView dVR;
    private TbImageView dVS;
    private RadioButton dVT;
    private RadioButton dVU;
    private RadioButton dVV;
    private RadioButton dVW;
    private RadioButton dVX;
    private RadioButton[] dVY;
    private TextView dVZ;
    private TbImageView dWa;
    private TextView dWb;
    private TextView dWc;
    private TextView dWd;
    private TextView dWe;
    private TextView dWf;
    private InterfaceC0224a dWg;
    private BlurDrawable dWh;
    private FrameLayout mContentLayout;
    private FrameLayout mRootView;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0224a {
        void n(Bitmap bitmap);

        void o(Bitmap bitmap);

        void onCancel();

        void p(Bitmap bitmap);

        void q(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0224a interfaceC0224a) {
        this.dWg = interfaceC0224a;
        this.mRootView = (FrameLayout) LayoutInflater.from(context).inflate(e.h.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(e.g.game_share_content_layout);
        this.dVE = (ImageView) this.mRootView.findViewById(e.g.game_share_content_bg_view);
        this.cbs = (LinearLayout) this.mRootView.findViewById(e.g.game_share_card_layout);
        this.dVF = (FrameLayout) this.mRootView.findViewById(e.g.game_share_header_root);
        this.dVG = (ColumnLayout) this.mRootView.findViewById(e.g.game_share_header_layout);
        this.cKo = (TbImageView) this.mRootView.findViewById(e.g.game_share_header_bg_view);
        this.cKo.setVisibility(4);
        this.cKo.setDefaultBg(new ColorDrawable(this.mRootView.getResources().getColor(e.d.transparent)));
        this.cKo.setDrawerType(1);
        this.cKo.setRadius(context.getResources().getDimensionPixelSize(e.C0210e.ds20));
        this.cKo.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void s(String str, boolean z) {
                if (z) {
                    a.this.cKo.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dVH = (TbImageView) this.mRootView.findViewById(e.g.game_share_game_icon);
        this.dVH.setDrawerType(1);
        this.dVH.setRadius(context.getResources().getDimensionPixelSize(e.C0210e.ds20));
        this.dVI = (TextView) this.mRootView.findViewById(e.g.game_share_game_name);
        this.dVJ = (TextView) this.mRootView.findViewById(e.g.game_share_game_description);
        this.dVK = (TextView) this.mRootView.findViewById(e.g.game_share_game_score);
        this.dVL = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_1);
        this.dVM = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_2);
        this.dVN = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_3);
        this.dVO = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_4);
        this.dVP = (RadioButton) this.mRootView.findViewById(e.g.game_share_score_grade_5);
        this.dVQ = new RadioButton[]{this.dVL, this.dVM, this.dVN, this.dVO, this.dVP};
        this.dVR = (TextView) this.mRootView.findViewById(e.g.game_share_comment);
        this.dVS = (TbImageView) this.mRootView.findViewById(e.g.game_share_user_protrait);
        this.dVS.setDrawerType(1);
        this.dVS.setIsRound(true);
        this.aKT = (TextView) this.mRootView.findViewById(e.g.game_share_user_name);
        this.dVT = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_1);
        this.dVU = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_2);
        this.dVV = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_3);
        this.dVW = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_4);
        this.dVX = (RadioButton) this.mRootView.findViewById(e.g.game_share_user_score_grade_5);
        this.dVY = new RadioButton[]{this.dVT, this.dVU, this.dVV, this.dVW, this.dVX};
        this.dVZ = (TextView) this.mRootView.findViewById(e.g.game_share_qr_txt);
        this.dWa = (TbImageView) this.mRootView.findViewById(e.g.game_share_qr_img);
        this.cCA = (LinearLayout) this.mRootView.findViewById(e.g.game_share_entry_layout);
        this.dWb = (TextView) this.mRootView.findViewById(e.g.game_share_entry_weixin);
        this.dWb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aEU = a.this.aEU();
                if (aEU != null && a.this.dWg != null) {
                    a.this.dWg.n(aEU);
                }
            }
        });
        this.dWc = (TextView) this.mRootView.findViewById(e.g.game_share_entry_wxfriends);
        this.dWc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aEU = a.this.aEU();
                if (aEU != null && a.this.dWg != null) {
                    a.this.dWg.o(aEU);
                }
            }
        });
        this.dWd = (TextView) this.mRootView.findViewById(e.g.game_share_entry_qq);
        this.dWd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aEU = a.this.aEU();
                if (aEU != null && a.this.dWg != null) {
                    a.this.dWg.p(aEU);
                }
            }
        });
        this.dWe = (TextView) this.mRootView.findViewById(e.g.game_share_entry_sina);
        this.dWe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap aEU = a.this.aEU();
                if (aEU != null && a.this.dWg != null) {
                    a.this.dWg.q(aEU);
                }
            }
        });
        this.dWf = (TextView) this.mRootView.findViewById(e.g.game_share_cancel);
        this.dWf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.dWg != null) {
                    a.this.dWg.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.arx);
        sb.append(" ”");
        this.dVR.setText(sb);
        if (this.dWh == null) {
            c.jA().a(gameShareData.art, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.op() == null) {
                        UtilHelper.showToast(a.this.mRootView.getContext(), e.j.share_failed);
                        if (a.this.dWg != null) {
                            a.this.dWg.onCancel();
                        }
                    }
                    a.this.dWh = new BlurDrawable(a.this.mRootView.getContext());
                    a.this.dWh.init(2, 4, aVar.op());
                    a.this.dWh.drawBlur();
                    a.this.dVE.setImageBitmap(a.this.dWh.getBlurredBitmap());
                }
            }, null);
        }
        this.cKo.startLoad(gameShareData.arz, 10, false);
        this.dWa.startLoad(gameShareData.ary, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dVH.startLoad(gameShareData.art, 10, false);
            this.dVI.setText(gameShareData.gameName);
            this.dVJ.setText(gameShareData.aru);
            this.dVK.setText(new DecimalFormat(".0").format(gameShareData.arv));
            a((int) gameShareData.arv, this.dVQ);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.dVS.startLoad(gameShareData.userPortrait, 12, false);
            this.aKT.setText(gameShareData.userName);
            a((int) gameShareData.arw, this.dVY);
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

    public Bitmap aEU() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int aEV() {
        return this.cbs.getBottom();
    }

    public void onDestroy() {
        if (this.dWh != null) {
            this.dWh.onDestroy();
            this.dWh = null;
        }
    }
}

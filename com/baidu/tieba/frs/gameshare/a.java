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
/* loaded from: classes16.dex */
public class a {
    private FrameLayout aht;
    private TextView dTQ;
    private LinearLayout gQx;
    private TbImageView gVV;
    private LinearLayout gjI;
    private ImageView ijU;
    private FrameLayout ijV;
    private ColumnLayout ijW;
    private TbImageView ijX;
    private TextView ijY;
    private TextView ijZ;
    private TextView ika;
    private RadioButton ikb;
    private RadioButton ikc;
    private RadioButton ikd;
    private RadioButton ike;
    private RadioButton ikf;
    private RadioButton[] ikg;
    private TextView ikh;
    private TbImageView iki;
    private RadioButton ikj;
    private RadioButton ikk;
    private RadioButton ikl;
    private RadioButton ikm;
    private RadioButton ikn;
    private RadioButton[] iko;
    private TextView ikp;
    private TbImageView ikq;
    private TextView ikr;
    private TextView iks;
    private TextView ikt;
    private TextView iku;
    private TextView ikv;
    private InterfaceC0684a ikw;
    private BlurDrawable ikx;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC0684a {
        void A(Bitmap bitmap);

        void B(Bitmap bitmap);

        void C(Bitmap bitmap);

        void onCancel();

        void z(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0684a interfaceC0684a) {
        this.ikw = interfaceC0684a;
        this.aht = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.aht.findViewById(R.id.game_share_content_layout);
        this.ijU = (ImageView) this.aht.findViewById(R.id.game_share_content_bg_view);
        this.gjI = (LinearLayout) this.aht.findViewById(R.id.game_share_card_layout);
        this.ijV = (FrameLayout) this.aht.findViewById(R.id.game_share_header_root);
        this.ijW = (ColumnLayout) this.aht.findViewById(R.id.game_share_header_layout);
        this.gVV = (TbImageView) this.aht.findViewById(R.id.game_share_header_bg_view);
        this.gVV.setVisibility(4);
        this.gVV.setDefaultBg(new ColorDrawable(this.aht.getResources().getColor(R.color.transparent)));
        this.gVV.setDrawerType(1);
        this.gVV.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.gVV.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.gVV.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.ijX = (TbImageView) this.aht.findViewById(R.id.game_share_game_icon);
        this.ijX.setDrawerType(1);
        this.ijX.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.ijY = (TextView) this.aht.findViewById(R.id.game_share_game_name);
        this.ijZ = (TextView) this.aht.findViewById(R.id.game_share_game_description);
        this.ika = (TextView) this.aht.findViewById(R.id.game_share_game_score);
        this.ikb = (RadioButton) this.aht.findViewById(R.id.game_share_score_grade_1);
        this.ikc = (RadioButton) this.aht.findViewById(R.id.game_share_score_grade_2);
        this.ikd = (RadioButton) this.aht.findViewById(R.id.game_share_score_grade_3);
        this.ike = (RadioButton) this.aht.findViewById(R.id.game_share_score_grade_4);
        this.ikf = (RadioButton) this.aht.findViewById(R.id.game_share_score_grade_5);
        this.ikg = new RadioButton[]{this.ikb, this.ikc, this.ikd, this.ike, this.ikf};
        this.ikh = (TextView) this.aht.findViewById(R.id.game_share_comment);
        this.iki = (TbImageView) this.aht.findViewById(R.id.game_share_user_protrait);
        this.iki.setDrawerType(1);
        this.iki.setIsRound(true);
        this.dTQ = (TextView) this.aht.findViewById(R.id.game_share_user_name);
        this.ikj = (RadioButton) this.aht.findViewById(R.id.game_share_user_score_grade_1);
        this.ikk = (RadioButton) this.aht.findViewById(R.id.game_share_user_score_grade_2);
        this.ikl = (RadioButton) this.aht.findViewById(R.id.game_share_user_score_grade_3);
        this.ikm = (RadioButton) this.aht.findViewById(R.id.game_share_user_score_grade_4);
        this.ikn = (RadioButton) this.aht.findViewById(R.id.game_share_user_score_grade_5);
        this.iko = new RadioButton[]{this.ikj, this.ikk, this.ikl, this.ikm, this.ikn};
        this.ikp = (TextView) this.aht.findViewById(R.id.game_share_qr_txt);
        this.ikq = (TbImageView) this.aht.findViewById(R.id.game_share_qr_img);
        this.gQx = (LinearLayout) this.aht.findViewById(R.id.game_share_entry_layout);
        this.ikr = (TextView) this.aht.findViewById(R.id.game_share_entry_weixin);
        this.ikr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bbF = a.this.bbF();
                if (bbF != null && a.this.ikw != null) {
                    a.this.ikw.z(bbF);
                }
            }
        });
        this.iks = (TextView) this.aht.findViewById(R.id.game_share_entry_wxfriends);
        this.iks.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bbF = a.this.bbF();
                if (bbF != null && a.this.ikw != null) {
                    a.this.ikw.A(bbF);
                }
            }
        });
        this.ikt = (TextView) this.aht.findViewById(R.id.game_share_entry_qq);
        this.ikt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bbF = a.this.bbF();
                if (bbF != null && a.this.ikw != null) {
                    a.this.ikw.B(bbF);
                }
            }
        });
        this.iku = (TextView) this.aht.findViewById(R.id.game_share_entry_sina);
        this.iku.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bbF = a.this.bbF();
                if (bbF != null && a.this.ikw != null) {
                    a.this.ikw.C(bbF);
                }
            }
        });
        this.ikv = (TextView) this.aht.findViewById(R.id.game_share_cancel);
        this.ikv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.ikw != null) {
                    a.this.ikw.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.aht;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.ikh.setText(sb);
        if (this.ikx == null) {
            c.mM().a(gameShareData.gameIconUrl, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.aht.getContext(), (int) R.string.share_failed);
                        if (a.this.ikw != null) {
                            a.this.ikw.onCancel();
                        }
                    }
                    a.this.ikx = new BlurDrawable(a.this.aht.getContext());
                    a.this.ikx.init(2, 4, aVar.getRawBitmap());
                    a.this.ikx.drawBlur();
                    a.this.ijU.setImageBitmap(a.this.ikx.getBlurredBitmap());
                }
            }, null);
        }
        this.gVV.startLoad(gameShareData.headBgUrl, 10, false);
        this.ikq.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.ijX.startLoad(gameShareData.gameIconUrl, 10, false);
            this.ijY.setText(gameShareData.gameName);
            this.ijZ.setText(gameShareData.gameDescription);
            this.ika.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.ikg);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.iki.startLoad(gameShareData.userPortrait, 12, false);
            this.dTQ.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.iko);
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

    public Bitmap bbF() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int cqD() {
        return this.gjI.getBottom();
    }

    public void onDestroy() {
        if (this.ikx != null) {
            this.ikx.onDestroy();
            this.ikx = null;
        }
    }
}

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
import com.baidu.adp.lib.e.c;
import com.baidu.adp.lib.e.d;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.tbadk.core.data.GameShareData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.BlurDrawable;
import java.text.DecimalFormat;
/* loaded from: classes2.dex */
public class a {
    private FrameLayout ajW;
    private TextView eLt;
    private LinearLayout hWA;
    private LinearLayout hoh;
    private TbImageView icl;
    private TextView jzA;
    private TextView jzB;
    private InterfaceC0746a jzC;
    private BlurDrawable jzD;
    private ImageView jza;
    private FrameLayout jzb;
    private ColumnLayout jzc;
    private TbImageView jzd;
    private TextView jze;
    private TextView jzf;
    private TextView jzg;
    private RadioButton jzh;
    private RadioButton jzi;
    private RadioButton jzj;
    private RadioButton jzk;
    private RadioButton jzl;
    private RadioButton[] jzm;
    private TextView jzn;
    private TbImageView jzo;
    private RadioButton jzp;
    private RadioButton jzq;
    private RadioButton jzr;
    private RadioButton jzs;
    private RadioButton jzt;
    private RadioButton[] jzu;
    private TextView jzv;
    private TbImageView jzw;
    private TextView jzx;
    private TextView jzy;
    private TextView jzz;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0746a {
        void A(Bitmap bitmap);

        void B(Bitmap bitmap);

        void C(Bitmap bitmap);

        void D(Bitmap bitmap);

        void onCancel();
    }

    public a(Context context, InterfaceC0746a interfaceC0746a) {
        this.jzC = interfaceC0746a;
        this.ajW = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.ajW.findViewById(R.id.game_share_content_layout);
        this.jza = (ImageView) this.ajW.findViewById(R.id.game_share_content_bg_view);
        this.hoh = (LinearLayout) this.ajW.findViewById(R.id.game_share_card_layout);
        this.jzb = (FrameLayout) this.ajW.findViewById(R.id.game_share_header_root);
        this.jzc = (ColumnLayout) this.ajW.findViewById(R.id.game_share_header_layout);
        this.icl = (TbImageView) this.ajW.findViewById(R.id.game_share_header_bg_view);
        this.icl.setVisibility(4);
        this.icl.setDefaultBg(new ColorDrawable(this.ajW.getResources().getColor(R.color.transparent)));
        this.icl.setDrawerType(1);
        this.icl.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.icl.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.icl.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.jzd = (TbImageView) this.ajW.findViewById(R.id.game_share_game_icon);
        this.jzd.setDrawerType(1);
        this.jzd.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.jze = (TextView) this.ajW.findViewById(R.id.game_share_game_name);
        this.jzf = (TextView) this.ajW.findViewById(R.id.game_share_game_description);
        this.jzg = (TextView) this.ajW.findViewById(R.id.game_share_game_score);
        this.jzh = (RadioButton) this.ajW.findViewById(R.id.game_share_score_grade_1);
        this.jzi = (RadioButton) this.ajW.findViewById(R.id.game_share_score_grade_2);
        this.jzj = (RadioButton) this.ajW.findViewById(R.id.game_share_score_grade_3);
        this.jzk = (RadioButton) this.ajW.findViewById(R.id.game_share_score_grade_4);
        this.jzl = (RadioButton) this.ajW.findViewById(R.id.game_share_score_grade_5);
        this.jzm = new RadioButton[]{this.jzh, this.jzi, this.jzj, this.jzk, this.jzl};
        this.jzn = (TextView) this.ajW.findViewById(R.id.game_share_comment);
        this.jzo = (TbImageView) this.ajW.findViewById(R.id.game_share_user_protrait);
        this.jzo.setDrawerType(1);
        this.jzo.setIsRound(true);
        this.eLt = (TextView) this.ajW.findViewById(R.id.game_share_user_name);
        this.jzp = (RadioButton) this.ajW.findViewById(R.id.game_share_user_score_grade_1);
        this.jzq = (RadioButton) this.ajW.findViewById(R.id.game_share_user_score_grade_2);
        this.jzr = (RadioButton) this.ajW.findViewById(R.id.game_share_user_score_grade_3);
        this.jzs = (RadioButton) this.ajW.findViewById(R.id.game_share_user_score_grade_4);
        this.jzt = (RadioButton) this.ajW.findViewById(R.id.game_share_user_score_grade_5);
        this.jzu = new RadioButton[]{this.jzp, this.jzq, this.jzr, this.jzs, this.jzt};
        this.jzv = (TextView) this.ajW.findViewById(R.id.game_share_qr_txt);
        this.jzw = (TbImageView) this.ajW.findViewById(R.id.game_share_qr_img);
        this.hWA = (LinearLayout) this.ajW.findViewById(R.id.game_share_entry_layout);
        this.jzx = (TextView) this.ajW.findViewById(R.id.game_share_entry_weixin);
        this.jzx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap boo = a.this.boo();
                if (boo != null && a.this.jzC != null) {
                    a.this.jzC.A(boo);
                }
            }
        });
        this.jzy = (TextView) this.ajW.findViewById(R.id.game_share_entry_wxfriends);
        this.jzy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap boo = a.this.boo();
                if (boo != null && a.this.jzC != null) {
                    a.this.jzC.B(boo);
                }
            }
        });
        this.jzz = (TextView) this.ajW.findViewById(R.id.game_share_entry_qq);
        this.jzz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap boo = a.this.boo();
                if (boo != null && a.this.jzC != null) {
                    a.this.jzC.C(boo);
                }
            }
        });
        this.jzA = (TextView) this.ajW.findViewById(R.id.game_share_entry_sina);
        this.jzA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap boo = a.this.boo();
                if (boo != null && a.this.jzC != null) {
                    a.this.jzC.D(boo);
                }
            }
        });
        this.jzB = (TextView) this.ajW.findViewById(R.id.game_share_cancel);
        this.jzB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jzC != null) {
                    a.this.jzC.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.ajW;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.gameComment);
        sb.append(" ”");
        this.jzn.setText(sb);
        if (this.jzD == null) {
            d.mx().a(gameShareData.gameIconUrl, 10, new c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.e.c
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.ajW.getContext(), R.string.share_failed);
                        if (a.this.jzC != null) {
                            a.this.jzC.onCancel();
                        }
                    }
                    a.this.jzD = new BlurDrawable(a.this.ajW.getContext());
                    a.this.jzD.init(2, 4, aVar.getRawBitmap());
                    a.this.jzD.drawBlur();
                    a.this.jza.setImageBitmap(a.this.jzD.getBlurredBitmap());
                }
            }, null);
        }
        this.icl.startLoad(gameShareData.headBgUrl, 10, false);
        this.jzw.startLoad(gameShareData.shareQRCodeUrl, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.jzd.startLoad(gameShareData.gameIconUrl, 10, false);
            this.jze.setText(gameShareData.gameName);
            this.jzf.setText(gameShareData.gameDescription);
            this.jzg.setText(new DecimalFormat(".0").format(gameShareData.gameScore));
            a((int) gameShareData.gameScore, this.jzm);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.jzo.startLoad(gameShareData.userPortrait, 12, false);
            this.eLt.setText(gameShareData.userName);
            a((int) gameShareData.userScore, this.jzu);
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

    public Bitmap boo() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int cKN() {
        return this.hoh.getBottom();
    }

    public void onDestroy() {
        if (this.jzD != null) {
            this.jzD.onDestroy();
            this.jzD = null;
        }
    }
}

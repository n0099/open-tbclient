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
    private FrameLayout bEf;
    private TextView crw;
    private LinearLayout dTj;
    private LinearLayout eug;
    private TbImageView ezr;
    private ImageView fIQ;
    private FrameLayout fIR;
    private ColumnLayout fIS;
    private TbImageView fIT;
    private TextView fIU;
    private TextView fIV;
    private TextView fIW;
    private RadioButton fIX;
    private RadioButton fIY;
    private RadioButton fIZ;
    private RadioButton fJa;
    private RadioButton fJb;
    private RadioButton[] fJc;
    private TextView fJd;
    private TbImageView fJe;
    private RadioButton fJf;
    private RadioButton fJg;
    private RadioButton fJh;
    private RadioButton fJi;
    private RadioButton fJj;
    private RadioButton[] fJk;
    private TextView fJl;
    private TbImageView fJm;
    private TextView fJn;
    private TextView fJo;
    private TextView fJp;
    private TextView fJq;
    private TextView fJr;
    private InterfaceC0413a fJs;
    private BlurDrawable fJt;
    private FrameLayout mContentLayout;

    /* renamed from: com.baidu.tieba.frs.gameshare.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0413a {
        void onCancel();

        void t(Bitmap bitmap);

        void u(Bitmap bitmap);

        void v(Bitmap bitmap);

        void w(Bitmap bitmap);
    }

    public a(Context context, InterfaceC0413a interfaceC0413a) {
        this.fJs = interfaceC0413a;
        this.bEf = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.activity_game_share_layout, (ViewGroup) null);
        this.mContentLayout = (FrameLayout) this.bEf.findViewById(R.id.game_share_content_layout);
        this.fIQ = (ImageView) this.bEf.findViewById(R.id.game_share_content_bg_view);
        this.dTj = (LinearLayout) this.bEf.findViewById(R.id.game_share_card_layout);
        this.fIR = (FrameLayout) this.bEf.findViewById(R.id.game_share_header_root);
        this.fIS = (ColumnLayout) this.bEf.findViewById(R.id.game_share_header_layout);
        this.ezr = (TbImageView) this.bEf.findViewById(R.id.game_share_header_bg_view);
        this.ezr.setVisibility(4);
        this.ezr.setDefaultBg(new ColorDrawable(this.bEf.getResources().getColor(R.color.transparent)));
        this.ezr.setDrawerType(1);
        this.ezr.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.ezr.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.frs.gameshare.a.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z) {
                    a.this.ezr.setVisibility(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fIT = (TbImageView) this.bEf.findViewById(R.id.game_share_game_icon);
        this.fIT.setDrawerType(1);
        this.fIT.setRadius(context.getResources().getDimensionPixelSize(R.dimen.ds20));
        this.fIU = (TextView) this.bEf.findViewById(R.id.game_share_game_name);
        this.fIV = (TextView) this.bEf.findViewById(R.id.game_share_game_description);
        this.fIW = (TextView) this.bEf.findViewById(R.id.game_share_game_score);
        this.fIX = (RadioButton) this.bEf.findViewById(R.id.game_share_score_grade_1);
        this.fIY = (RadioButton) this.bEf.findViewById(R.id.game_share_score_grade_2);
        this.fIZ = (RadioButton) this.bEf.findViewById(R.id.game_share_score_grade_3);
        this.fJa = (RadioButton) this.bEf.findViewById(R.id.game_share_score_grade_4);
        this.fJb = (RadioButton) this.bEf.findViewById(R.id.game_share_score_grade_5);
        this.fJc = new RadioButton[]{this.fIX, this.fIY, this.fIZ, this.fJa, this.fJb};
        this.fJd = (TextView) this.bEf.findViewById(R.id.game_share_comment);
        this.fJe = (TbImageView) this.bEf.findViewById(R.id.game_share_user_protrait);
        this.fJe.setDrawerType(1);
        this.fJe.setIsRound(true);
        this.crw = (TextView) this.bEf.findViewById(R.id.game_share_user_name);
        this.fJf = (RadioButton) this.bEf.findViewById(R.id.game_share_user_score_grade_1);
        this.fJg = (RadioButton) this.bEf.findViewById(R.id.game_share_user_score_grade_2);
        this.fJh = (RadioButton) this.bEf.findViewById(R.id.game_share_user_score_grade_3);
        this.fJi = (RadioButton) this.bEf.findViewById(R.id.game_share_user_score_grade_4);
        this.fJj = (RadioButton) this.bEf.findViewById(R.id.game_share_user_score_grade_5);
        this.fJk = new RadioButton[]{this.fJf, this.fJg, this.fJh, this.fJi, this.fJj};
        this.fJl = (TextView) this.bEf.findViewById(R.id.game_share_qr_txt);
        this.fJm = (TbImageView) this.bEf.findViewById(R.id.game_share_qr_img);
        this.eug = (LinearLayout) this.bEf.findViewById(R.id.game_share_entry_layout);
        this.fJn = (TextView) this.bEf.findViewById(R.id.game_share_entry_weixin);
        this.fJn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnT = a.this.bnT();
                if (bnT != null && a.this.fJs != null) {
                    a.this.fJs.t(bnT);
                }
            }
        });
        this.fJo = (TextView) this.bEf.findViewById(R.id.game_share_entry_wxfriends);
        this.fJo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnT = a.this.bnT();
                if (bnT != null && a.this.fJs != null) {
                    a.this.fJs.u(bnT);
                }
            }
        });
        this.fJp = (TextView) this.bEf.findViewById(R.id.game_share_entry_qq);
        this.fJp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnT = a.this.bnT();
                if (bnT != null && a.this.fJs != null) {
                    a.this.fJs.v(bnT);
                }
            }
        });
        this.fJq = (TextView) this.bEf.findViewById(R.id.game_share_entry_sina);
        this.fJq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Bitmap bnT = a.this.bnT();
                if (bnT != null && a.this.fJs != null) {
                    a.this.fJs.w(bnT);
                }
            }
        });
        this.fJr = (TextView) this.bEf.findViewById(R.id.game_share_cancel);
        this.fJr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gameshare.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.fJs != null) {
                    a.this.fJs.onCancel();
                }
            }
        });
    }

    public View getRootView() {
        return this.bEf;
    }

    public void a(GameShareData gameShareData) {
        b(gameShareData);
        c(gameShareData);
        StringBuilder sb = new StringBuilder();
        sb.append("“ ");
        sb.append(gameShareData.bYA);
        sb.append(" ”");
        this.fJd.setText(sb);
        if (this.fJt == null) {
            c.fT().a(gameShareData.bYw, 10, new b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.gameshare.a.7
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass7) aVar, str, i);
                    if (aVar == null || aVar.getRawBitmap() == null) {
                        UtilHelper.showToast(a.this.bEf.getContext(), (int) R.string.share_failed);
                        if (a.this.fJs != null) {
                            a.this.fJs.onCancel();
                        }
                    }
                    a.this.fJt = new BlurDrawable(a.this.bEf.getContext());
                    a.this.fJt.init(2, 4, aVar.getRawBitmap());
                    a.this.fJt.drawBlur();
                    a.this.fIQ.setImageBitmap(a.this.fJt.getBlurredBitmap());
                }
            }, null);
        }
        this.ezr.startLoad(gameShareData.bYC, 10, false);
        this.fJm.startLoad(gameShareData.bYB, 10, false);
    }

    private void b(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fIT.startLoad(gameShareData.bYw, 10, false);
            this.fIU.setText(gameShareData.gameName);
            this.fIV.setText(gameShareData.bYx);
            this.fIW.setText(new DecimalFormat(".0").format(gameShareData.bYy));
            a((int) gameShareData.bYy, this.fJc);
        }
    }

    private void c(GameShareData gameShareData) {
        if (gameShareData != null) {
            this.fJe.startLoad(gameShareData.userPortrait, 12, false);
            this.crw.setText(gameShareData.userName);
            a((int) gameShareData.bYz, this.fJk);
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

    public Bitmap bnT() {
        this.mContentLayout.buildDrawingCache();
        return this.mContentLayout.getDrawingCache();
    }

    public int bnU() {
        return this.dTj.getBottom();
    }

    public void onDestroy() {
        if (this.fJt != null) {
            this.fJt.onDestroy();
            this.fJt = null;
        }
    }
}

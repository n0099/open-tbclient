package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import tbclient.FrsPage.PrivateForumShareinfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    private LinearLayout bFy;
    private Context context;
    private TbImageView eBi;
    private TextView eXA;
    private LinearGradientView fuk;
    private FrsViewData fvY;
    private TextView fzA;
    private TextView fzB;
    private TextView fzC;
    private ImageView fzD;
    private RelativeLayout fzE;
    private au fzF;
    private Bitmap fzG;
    private PrivateForumShareinfo fzH;
    private TextView fzt;
    private TextView fzu;
    private HeadImageView fzv;
    private TextView fzw;
    private TextView fzx;
    private TextView fzy;
    private TextView fzz;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean d(FrsViewData frsViewData, TbPageContext tbPageContext) {
        this.fvY = frsViewData;
        this.mPageContext = tbPageContext;
        if (frsViewData.getPrivateForumTotalInfo() == null || frsViewData.getPrivateForumTotalInfo().XO() == null) {
            return false;
        }
        this.fzH = frsViewData.getPrivateForumTotalInfo().XO();
        aX(this.context);
        return true;
    }

    private void aX(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_private_share, this);
        this.bFy = (LinearLayout) findViewById(d.g.frs_private_share);
        al.k(this.bFy, d.f.bg_frs_private_dialog);
        this.fzE = (RelativeLayout) this.bFy.findViewById(d.g.frs_private_share_view);
        al.k(this.fzE, d.f.bg_frs_private_dialog);
        this.fuk = (LinearGradientView) this.bFy.findViewById(d.g.frs_private_top_gradient_bg);
        this.fuk.setCornerRadius(l.h(context, d.e.tbds30));
        this.fuk.setRoundMode(3);
        this.eBi = (TbImageView) this.bFy.findViewById(d.g.frs_private_top_bg_mask);
        this.eBi.setDefaultBgResource(d.C0277d.transparent);
        this.eBi.setDefaultResource(d.f.pic_frs_head_default);
        this.eBi.setRadius(l.h(this.mPageContext.getPageActivity(), d.e.tbds30));
        this.eBi.setConrers(3);
        bkd();
        this.eXA = (TextView) this.bFy.findViewById(d.g.frs_private_share_name);
        this.eXA.setText(this.fvY.getForum().getName() + "吧");
        al.j(this.eXA, d.C0277d.cp_btn_a);
        this.fzt = (TextView) this.bFy.findViewById(d.g.frs_private_share_brief);
        al.j(this.fzt, d.C0277d.cp_btn_a);
        this.fzD = (ImageView) this.bFy.findViewById(d.g.frs_private_share_qrcode);
        if (this.fzH.share_url != null) {
            vQ(this.fzH.share_url);
        }
        this.fzu = (TextView) this.bFy.findViewById(d.g.frs_private_share_creator);
        if (this.fzH.manager_user_name != null) {
            this.fzu.setText(this.fzH.manager_user_name);
        }
        al.j(this.fzu, d.C0277d.cp_cont_b);
        this.fzv = (HeadImageView) this.bFy.findViewById(d.g.frs_private_share_portrait);
        this.fzv.setIsRound(true);
        this.fzv.setDefaultResource(d.f.icon_default_avatar100);
        if (this.fzH.manager_portrait != null) {
            this.fzv.startLoad(this.fzH.manager_portrait, 25, false);
        }
        this.fzw = (TextView) this.bFy.findViewById(d.g.frs_private_share_time);
        if (this.fzH.create_time != null) {
            this.fzw.setText(e(Long.valueOf(this.fzH.create_time.longValue() * 1000)));
        }
        al.j(this.fzw, d.C0277d.cp_cont_b);
        this.fzx = (TextView) this.bFy.findViewById(d.g.frs_private_share_download);
        l(this.fzx, d.f.icon_share_download);
        this.fzx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.z(FrsPrivateShareDialogView.this.bgw());
            }
        });
        this.fzy = (TextView) this.bFy.findViewById(d.g.frs_private_share_wechat);
        l(this.fzy, d.f.icon_weixin_n);
        this.fzy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bgw(), 3);
            }
        });
        this.fzz = (TextView) this.bFy.findViewById(d.g.frs_private_share_moment);
        l(this.fzz, d.f.icon_weixin_q_n);
        this.fzz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bgw(), 2);
            }
        });
        this.fzA = (TextView) this.bFy.findViewById(d.g.frs_private_share_qzone);
        l(this.fzA, d.f.icon_qq_zone_n);
        this.fzA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bgw(), 4);
            }
        });
        this.fzB = (TextView) this.bFy.findViewById(d.g.frs_private_share_qq);
        l(this.fzB, d.f.icon_qq_share_n);
        this.fzB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bgw(), 8);
            }
        });
        this.fzC = (TextView) this.bFy.findViewById(d.g.frs_private_share_weibo);
        l(this.fzC, d.f.icon_sina_n);
        this.fzC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bgw(), 6);
            }
        });
    }

    private void vQ(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.fzD.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private String e(Long l) {
        if (l == null) {
            return "";
        }
        return "于" + new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault()).format(new Date(l.longValue())) + "创建";
    }

    private void l(TextView textView, int i) {
        Drawable drawable = al.getDrawable(i);
        int h = l.h(getContext(), d.e.tbds78);
        drawable.setBounds(0, 0, h, h);
        textView.setCompoundDrawables(null, drawable, null, null);
        al.j(textView, d.C0277d.cp_cont_f);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = getTextViewWidth();
        textView.setLayoutParams(layoutParams);
    }

    private void bkd() {
        ThemeElement themeElement;
        if (this.fvY != null && this.fvY.getForum() != null) {
            ThemeColorInfo themeColorInfo = this.fvY.getForum().getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                this.eBi.setVisibility(8);
                this.fuk.setDefaultGradientColor();
                return;
            }
            this.eBi.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            this.fuk.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.eBi.startLoad(themeElement.pattern_image, 10, false);
        }
    }

    private int getTextViewWidth() {
        int aO;
        int h = l.h(this.context, d.e.tbds44);
        if (UtilHelper.getRealScreenOrientation(this.context) == 2) {
            aO = l.aQ(this.context) - (h * 3);
        } else {
            aO = l.aO(this.context) - (h * 3);
        }
        return aO / 6;
    }

    public Bitmap bgw() {
        if (this.fzG == null) {
            this.fzE.buildDrawingCache();
            this.fzG = this.fzE.getDrawingCache();
        }
        return this.fzG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Bitmap bitmap) {
        if (!bke()) {
            rP(1);
            if (this.fzF == null) {
                this.fzF = new au(this.mPageContext);
            }
            this.fzF.h(ap.isEmpty(this.fzH.share_url) ? "http://tieba.baidu.com" : this.fzH.share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
    }

    private boolean bke() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.adN();
        this.mPermissionJudgement.e(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.Y(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Bitmap bitmap, final int i) {
        int i2 = 2;
        if (bitmap != null && !bke()) {
            if (i != 3) {
                if (i == 2) {
                    i2 = 3;
                } else if (i == 4) {
                    i2 = 4;
                } else if (i == 8) {
                    i2 = 5;
                } else {
                    i2 = i == 6 ? 6 : 1;
                }
            }
            rP(i2);
            aa.a(new z<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bgv */
                public com.baidu.tbadk.coreExtra.c.d doInBackground() {
                    return FrsPrivateShareDialogView.this.t(bitmap);
                }
            }, new k<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.d dVar) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(FrsPrivateShareDialogView.this.context, i, dVar, false));
                }
            });
        }
    }

    private void rP(int i) {
        TiebaStatic.log(new am("c13385").bJ(ImageViewerConfig.FORUM_ID, this.fvY.getForum().getId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).T("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.coreExtra.c.d t(Bitmap bitmap) {
        com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
        dVar.cbP = false;
        dVar.cbO = false;
        dVar.shareType = 1;
        dVar.title = this.context.getString(d.j.app_name);
        dVar.content = "";
        dVar.n(bitmap);
        dVar.ajS();
        return dVar;
    }
}

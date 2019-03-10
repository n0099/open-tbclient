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
    private LinearLayout bFu;
    private Context context;
    private TbImageView eBB;
    private TextView eXP;
    private LinearGradientView fuz;
    private FrsViewData fwn;
    private TextView fzG;
    private TextView fzH;
    private HeadImageView fzI;
    private TextView fzJ;
    private TextView fzK;
    private TextView fzL;
    private TextView fzM;
    private TextView fzN;
    private TextView fzO;
    private TextView fzP;
    private ImageView fzQ;
    private RelativeLayout fzR;
    private au fzS;
    private Bitmap fzT;
    private PrivateForumShareinfo fzU;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean d(FrsViewData frsViewData, TbPageContext tbPageContext) {
        this.fwn = frsViewData;
        this.mPageContext = tbPageContext;
        if (frsViewData.getPrivateForumTotalInfo() == null || frsViewData.getPrivateForumTotalInfo().XR() == null) {
            return false;
        }
        this.fzU = frsViewData.getPrivateForumTotalInfo().XR();
        aX(this.context);
        return true;
    }

    private void aX(Context context) {
        LayoutInflater.from(context).inflate(d.h.frs_private_share, this);
        this.bFu = (LinearLayout) findViewById(d.g.frs_private_share);
        al.k(this.bFu, d.f.bg_frs_private_dialog);
        this.fzR = (RelativeLayout) this.bFu.findViewById(d.g.frs_private_share_view);
        al.k(this.fzR, d.f.bg_frs_private_dialog);
        this.fuz = (LinearGradientView) this.bFu.findViewById(d.g.frs_private_top_gradient_bg);
        this.fuz.setCornerRadius(l.h(context, d.e.tbds30));
        this.fuz.setRoundMode(3);
        this.eBB = (TbImageView) this.bFu.findViewById(d.g.frs_private_top_bg_mask);
        this.eBB.setDefaultBgResource(d.C0236d.transparent);
        this.eBB.setDefaultResource(d.f.pic_frs_head_default);
        this.eBB.setRadius(l.h(this.mPageContext.getPageActivity(), d.e.tbds30));
        this.eBB.setConrers(3);
        bkg();
        this.eXP = (TextView) this.bFu.findViewById(d.g.frs_private_share_name);
        this.eXP.setText(this.fwn.getForum().getName() + "吧");
        al.j(this.eXP, d.C0236d.cp_btn_a);
        this.fzG = (TextView) this.bFu.findViewById(d.g.frs_private_share_brief);
        al.j(this.fzG, d.C0236d.cp_btn_a);
        this.fzQ = (ImageView) this.bFu.findViewById(d.g.frs_private_share_qrcode);
        if (this.fzU.share_url != null) {
            vT(this.fzU.share_url);
        }
        this.fzH = (TextView) this.bFu.findViewById(d.g.frs_private_share_creator);
        if (this.fzU.manager_user_name != null) {
            this.fzH.setText(this.fzU.manager_user_name);
        }
        al.j(this.fzH, d.C0236d.cp_cont_b);
        this.fzI = (HeadImageView) this.bFu.findViewById(d.g.frs_private_share_portrait);
        this.fzI.setIsRound(true);
        this.fzI.setDefaultResource(d.f.icon_default_avatar100);
        if (this.fzU.manager_portrait != null) {
            this.fzI.startLoad(this.fzU.manager_portrait, 25, false);
        }
        this.fzJ = (TextView) this.bFu.findViewById(d.g.frs_private_share_time);
        if (this.fzU.create_time != null) {
            this.fzJ.setText(e(Long.valueOf(this.fzU.create_time.longValue() * 1000)));
        }
        al.j(this.fzJ, d.C0236d.cp_cont_b);
        this.fzK = (TextView) this.bFu.findViewById(d.g.frs_private_share_download);
        l(this.fzK, d.f.icon_share_download);
        this.fzK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.z(FrsPrivateShareDialogView.this.bgz());
            }
        });
        this.fzL = (TextView) this.bFu.findViewById(d.g.frs_private_share_wechat);
        l(this.fzL, d.f.icon_weixin_n);
        this.fzL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bgz(), 3);
            }
        });
        this.fzM = (TextView) this.bFu.findViewById(d.g.frs_private_share_moment);
        l(this.fzM, d.f.icon_weixin_q_n);
        this.fzM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bgz(), 2);
            }
        });
        this.fzN = (TextView) this.bFu.findViewById(d.g.frs_private_share_qzone);
        l(this.fzN, d.f.icon_qq_zone_n);
        this.fzN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bgz(), 4);
            }
        });
        this.fzO = (TextView) this.bFu.findViewById(d.g.frs_private_share_qq);
        l(this.fzO, d.f.icon_qq_share_n);
        this.fzO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bgz(), 8);
            }
        });
        this.fzP = (TextView) this.bFu.findViewById(d.g.frs_private_share_weibo);
        l(this.fzP, d.f.icon_sina_n);
        this.fzP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bgz(), 6);
            }
        });
    }

    private void vT(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.fzQ.setImageBitmap((Bitmap) runTask.getData());
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
        al.j(textView, d.C0236d.cp_cont_f);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = getTextViewWidth();
        textView.setLayoutParams(layoutParams);
    }

    private void bkg() {
        ThemeElement themeElement;
        if (this.fwn != null && this.fwn.getForum() != null) {
            ThemeColorInfo themeColorInfo = this.fwn.getForum().getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                this.eBB.setVisibility(8);
                this.fuz.setDefaultGradientColor();
                return;
            }
            this.eBB.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            this.fuz.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.eBB.startLoad(themeElement.pattern_image, 10, false);
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

    public Bitmap bgz() {
        if (this.fzT == null) {
            this.fzR.buildDrawingCache();
            this.fzT = this.fzR.getDrawingCache();
        }
        return this.fzT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Bitmap bitmap) {
        if (!bkh()) {
            rT(1);
            if (this.fzS == null) {
                this.fzS = new au(this.mPageContext);
            }
            this.fzS.h(ap.isEmpty(this.fzU.share_url) ? "http://tieba.baidu.com" : this.fzU.share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
        }
    }

    private boolean bkh() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.adQ();
        this.mPermissionJudgement.e(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.Y(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Bitmap bitmap, final int i) {
        int i2 = 2;
        if (bitmap != null && !bkh()) {
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
            rT(i2);
            aa.a(new z<com.baidu.tbadk.coreExtra.c.d>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bgy */
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

    private void rT(int i) {
        TiebaStatic.log(new am("c13385").bJ(ImageViewerConfig.FORUM_ID, this.fwn.getForum().getId()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).T("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.coreExtra.c.d t(Bitmap bitmap) {
        com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
        dVar.cbN = false;
        dVar.cbM = false;
        dVar.shareType = 1;
        dVar.title = this.context.getString(d.j.app_name);
        dVar.content = "";
        dVar.n(bitmap);
        dVar.ajW();
        return dVar;
    }
}

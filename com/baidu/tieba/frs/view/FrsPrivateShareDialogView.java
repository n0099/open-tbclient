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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    private LinearLayout bNa;
    private Context context;
    private TbImageView eQP;
    private HeadImageView eqG;
    private LinearGradientView fLe;
    private ImageOverlayView fMM;
    private FrsViewData fMR;
    private RelativeLayout fQA;
    private HeadImageView fQB;
    private TextView fQC;
    private TextView fQD;
    private au fQE;
    private Bitmap fQF;
    private ForumActiveInfo fQG;
    private TextView fQq;
    private TextView fQr;
    private TextView fQs;
    private TextView fQt;
    private TextView fQu;
    private TextView fQv;
    private TextView fQw;
    private TextView fQx;
    private TextView fQy;
    private ImageView fQz;
    private TextView fnI;
    private BarImageView fzS;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean d(FrsViewData frsViewData, TbPageContext tbPageContext) {
        this.fMR = frsViewData;
        this.mPageContext = tbPageContext;
        this.fQG = frsViewData.getForumActiveInfo();
        ap(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.fnI.setVisibility(0);
                this.fnI.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.fnI.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.fzS.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.eqG.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.eqG.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.fQC.setText(frsViewData.getUserData().getName_show());
                this.fQC.setVisibility(0);
            } else {
                this.fQC.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.fQq.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.fQq.setText(frsViewData.getForum().getSlogan());
            } else {
                this.fQq.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.fQD.setVisibility(0);
                this.fQD.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.fQD.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                xh(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                xh("https://tieba.baidu.com/f?kw=" + frsViewData.getForum().getName() + "&fr=frsshare");
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.fQs.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.fQs.setText(getResources().getString(R.string.wait_for_you_join));
            }
            ArrayList arrayList = new ArrayList();
            if (frsViewData.userList != null) {
                for (int i = 0; i < frsViewData.userList.size() && !StringUtils.isNull(frsViewData.userList.get(i).portrait); i++) {
                    arrayList.add(frsViewData.userList.get(i).portrait);
                    if (arrayList.size() >= 5) {
                        break;
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.fMM.setData(arrayList);
                this.fMM.setVisibility(0);
                this.fQB.setVisibility(8);
                return;
            }
            this.fMM.setVisibility(8);
            this.fQB.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.fQB.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.fQB.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.bNa = (LinearLayout) findViewById(R.id.frs_private_share);
        al.k(this.bNa, R.drawable.bg_frs_private_dialog);
        this.fQA = (RelativeLayout) this.bNa.findViewById(R.id.frs_private_share_view);
        al.k(this.fQA, R.drawable.bg_frs_private_dialog);
        this.fLe = (LinearGradientView) this.bNa.findViewById(R.id.frs_private_top_gradient_bg);
        this.fLe.setCornerRadius(l.g(context, R.dimen.tbds30));
        this.fLe.setRoundMode(3);
        this.eQP = (TbImageView) this.bNa.findViewById(R.id.frs_private_top_bg_mask);
        this.eQP.setDefaultBgResource(R.color.transparent);
        this.eQP.setDefaultResource(R.drawable.pic_frs_head_default);
        this.eQP.setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.eQP.setConrers(3);
        brA();
        this.fnI = (TextView) this.bNa.findViewById(R.id.frs_private_share_name);
        al.j(this.fnI, R.color.cp_btn_a);
        this.fQq = (TextView) this.bNa.findViewById(R.id.frs_private_share_brief);
        al.j(this.fQq, R.color.cp_cont_f);
        this.fQz = (ImageView) this.bNa.findViewById(R.id.frs_private_share_qrcode);
        this.fzS = (BarImageView) this.bNa.findViewById(R.id.frs_private_share_portrait);
        this.fzS.setShowOval(true);
        this.fzS.setStrokeWith(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.fzS.setStrokeColorResId(R.color.cp_bg_line_d);
        this.eqG = (HeadImageView) this.bNa.findViewById(R.id.photo);
        this.fQr = (TextView) this.bNa.findViewById(R.id.frs_user_name_identify);
        this.eqG.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eqG.setIsRound(true);
        this.eqG.setTag(null);
        al.k(this.fQr, R.drawable.username_text_bg);
        this.fQs = (TextView) this.bNa.findViewById(R.id.frs_private_share_time);
        al.j(this.fQs, R.color.cp_cont_f);
        this.fQt = (TextView) this.bNa.findViewById(R.id.frs_private_share_download);
        l(this.fQt, R.drawable.icon_share_photoalbum);
        this.fQt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.A(FrsPrivateShareDialogView.this.bnQ());
            }
        });
        this.fQu = (TextView) this.bNa.findViewById(R.id.frs_private_share_wechat);
        l(this.fQu, R.drawable.icon_share_wechat_n);
        this.fQu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bnQ(), 3);
            }
        });
        this.fQv = (TextView) this.bNa.findViewById(R.id.frs_private_share_moment);
        l(this.fQv, R.drawable.icon_share_circle_n);
        this.fQv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bnQ(), 2);
            }
        });
        this.fQw = (TextView) this.bNa.findViewById(R.id.frs_private_share_qzone);
        l(this.fQw, R.drawable.icon_share_qqzone_n);
        this.fQw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bnQ(), 4);
            }
        });
        this.fQx = (TextView) this.bNa.findViewById(R.id.frs_private_share_qq);
        l(this.fQx, R.drawable.icon_share_qq_n);
        this.fQx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bnQ(), 8);
            }
        });
        this.fQy = (TextView) this.bNa.findViewById(R.id.frs_private_share_weibo);
        l(this.fQy, R.drawable.icon_share_weibo_n);
        this.fQy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bnQ(), 6);
            }
        });
        this.fMM = (ImageOverlayView) this.bNa.findViewById(R.id.frs_private_overlayview);
        int g = l.g(getContext(), R.dimen.tbds68);
        this.fMM.i(5, g, g, 0, 0, l.g(getContext(), R.dimen.tbds16));
        this.fMM.setOrientation(true);
        this.fMM.setLoadImageType(12);
        this.fMM.onChangeSkinType();
        this.fQB = (HeadImageView) this.bNa.findViewById(R.id.bar_friend_icon);
        this.fQB.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fQB.setIsRound(true);
        this.fQC = (TextView) this.bNa.findViewById(R.id.frs_user_name);
        al.j(this.fQC, R.color.cp_cont_b);
        this.fQD = (TextView) this.bNa.findViewById(R.id.frs_user_name_identify);
        al.j(this.fQD, R.color.cp_btn_a);
    }

    private void xh(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.fQz.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void l(TextView textView, int i) {
        Drawable drawable = al.getDrawable(i);
        int g = l.g(getContext(), R.dimen.tbds88);
        drawable.setBounds(0, 0, g, g);
        textView.setCompoundDrawables(null, drawable, null, null);
        al.j(textView, R.color.cp_cont_f);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = getTextViewWidth();
        textView.setLayoutParams(layoutParams);
    }

    private void brA() {
        ThemeElement themeElement;
        if (this.fMR != null && this.fMR.getForum() != null) {
            ThemeColorInfo themeColorInfo = this.fMR.getForum().getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                this.eQP.setVisibility(8);
                this.fLe.setDefaultGradientColor();
                return;
            }
            this.eQP.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            this.fLe.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.eQP.startLoad(themeElement.pattern_image, 10, false);
        }
    }

    private int getTextViewWidth() {
        int af;
        int g = l.g(this.context, R.dimen.tbds44);
        int g2 = l.g(this.context, R.dimen.tbds54);
        if (UtilHelper.getRealScreenOrientation(this.context) == 2) {
            af = (l.ah(this.context) - (g * 2)) - g2;
        } else {
            af = (l.af(this.context) - (g * 2)) - g2;
        }
        return af / 6;
    }

    public Bitmap bnQ() {
        if (this.fQF == null) {
            this.fQA.buildDrawingCache();
            this.fQF = this.fQA.getDrawingCache();
        }
        return this.fQF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Bitmap bitmap) {
        if (!brB()) {
            sX(1);
            if (this.fQE == null) {
                this.fQE = new au(this.mPageContext);
            }
            if (this.fQG != null) {
                this.fQE.h(ap.isEmpty(this.fQG.forum_share_url) ? "http://tieba.baidu.com" : this.fQG.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.fQE.h("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean brB() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.aiM();
        this.mPermissionJudgement.e(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.aa(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Bitmap bitmap, final int i) {
        int i2 = 2;
        if (bitmap != null && !brB()) {
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
            sX(i2);
            aa.a(new z<com.baidu.tbadk.coreExtra.c.e>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bnP */
                public com.baidu.tbadk.coreExtra.c.e doInBackground() {
                    return FrsPrivateShareDialogView.this.d(bitmap, i);
                }
            }, new k<com.baidu.tbadk.coreExtra.c.e>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: o */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.e eVar) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(FrsPrivateShareDialogView.this.context, i, eVar, false));
                }
            });
        }
    }

    private void sX(int i) {
        TiebaStatic.log(new am("c13385").bT("fid", this.fMR.getForum().getId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.coreExtra.c.e d(Bitmap bitmap, int i) {
        com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
        eVar.cjS = false;
        eVar.cjR = false;
        eVar.shareType = 1;
        if (i == 6) {
            eVar.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]@" + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + com.baidu.adp.lib.util.k.bh(this.mForumName) + "&fr=frsshare";
        } else {
            eVar.title = this.context.getString(R.string.app_name);
        }
        eVar.content = "";
        eVar.n(bitmap);
        eVar.aoT();
        return eVar;
    }
}

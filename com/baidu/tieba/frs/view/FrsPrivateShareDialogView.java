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
    private LinearLayout bMZ;
    private Context context;
    private TbImageView eQO;
    private HeadImageView eqF;
    private LinearGradientView fLb;
    private ImageOverlayView fMJ;
    private FrsViewData fMO;
    private TextView fQA;
    private au fQB;
    private Bitmap fQC;
    private ForumActiveInfo fQD;
    private TextView fQn;
    private TextView fQo;
    private TextView fQp;
    private TextView fQq;
    private TextView fQr;
    private TextView fQs;
    private TextView fQt;
    private TextView fQu;
    private TextView fQv;
    private ImageView fQw;
    private RelativeLayout fQx;
    private HeadImageView fQy;
    private TextView fQz;
    private TextView fnH;
    private BarImageView fzR;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean d(FrsViewData frsViewData, TbPageContext tbPageContext) {
        this.fMO = frsViewData;
        this.mPageContext = tbPageContext;
        this.fQD = frsViewData.getForumActiveInfo();
        ap(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.fnH.setVisibility(0);
                this.fnH.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.fnH.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.fzR.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.eqF.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.eqF.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.fQz.setText(frsViewData.getUserData().getName_show());
                this.fQz.setVisibility(0);
            } else {
                this.fQz.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.fQn.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.fQn.setText(frsViewData.getForum().getSlogan());
            } else {
                this.fQn.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.fQA.setVisibility(0);
                this.fQA.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.fQA.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                xf(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                xf("https://tieba.baidu.com/f?kw=" + frsViewData.getForum().getName() + "&fr=frsshare");
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.fQp.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.fQp.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.fMJ.setData(arrayList);
                this.fMJ.setVisibility(0);
                this.fQy.setVisibility(8);
                return;
            }
            this.fMJ.setVisibility(8);
            this.fQy.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.fQy.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.fQy.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.bMZ = (LinearLayout) findViewById(R.id.frs_private_share);
        al.k(this.bMZ, R.drawable.bg_frs_private_dialog);
        this.fQx = (RelativeLayout) this.bMZ.findViewById(R.id.frs_private_share_view);
        al.k(this.fQx, R.drawable.bg_frs_private_dialog);
        this.fLb = (LinearGradientView) this.bMZ.findViewById(R.id.frs_private_top_gradient_bg);
        this.fLb.setCornerRadius(l.g(context, R.dimen.tbds30));
        this.fLb.setRoundMode(3);
        this.eQO = (TbImageView) this.bMZ.findViewById(R.id.frs_private_top_bg_mask);
        this.eQO.setDefaultBgResource(R.color.transparent);
        this.eQO.setDefaultResource(R.drawable.pic_frs_head_default);
        this.eQO.setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.eQO.setConrers(3);
        brv();
        this.fnH = (TextView) this.bMZ.findViewById(R.id.frs_private_share_name);
        al.j(this.fnH, R.color.cp_btn_a);
        this.fQn = (TextView) this.bMZ.findViewById(R.id.frs_private_share_brief);
        al.j(this.fQn, R.color.cp_cont_f);
        this.fQw = (ImageView) this.bMZ.findViewById(R.id.frs_private_share_qrcode);
        this.fzR = (BarImageView) this.bMZ.findViewById(R.id.frs_private_share_portrait);
        this.fzR.setShowOval(true);
        this.fzR.setStrokeWith(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.fzR.setStrokeColorResId(R.color.cp_bg_line_d);
        this.eqF = (HeadImageView) this.bMZ.findViewById(R.id.photo);
        this.fQo = (TextView) this.bMZ.findViewById(R.id.frs_user_name_identify);
        this.eqF.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eqF.setIsRound(true);
        this.eqF.setTag(null);
        al.k(this.fQo, R.drawable.username_text_bg);
        this.fQp = (TextView) this.bMZ.findViewById(R.id.frs_private_share_time);
        al.j(this.fQp, R.color.cp_cont_f);
        this.fQq = (TextView) this.bMZ.findViewById(R.id.frs_private_share_download);
        l(this.fQq, R.drawable.icon_share_photoalbum);
        this.fQq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.A(FrsPrivateShareDialogView.this.bnN());
            }
        });
        this.fQr = (TextView) this.bMZ.findViewById(R.id.frs_private_share_wechat);
        l(this.fQr, R.drawable.icon_share_wechat_n);
        this.fQr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bnN(), 3);
            }
        });
        this.fQs = (TextView) this.bMZ.findViewById(R.id.frs_private_share_moment);
        l(this.fQs, R.drawable.icon_share_circle_n);
        this.fQs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bnN(), 2);
            }
        });
        this.fQt = (TextView) this.bMZ.findViewById(R.id.frs_private_share_qzone);
        l(this.fQt, R.drawable.icon_share_qqzone_n);
        this.fQt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bnN(), 4);
            }
        });
        this.fQu = (TextView) this.bMZ.findViewById(R.id.frs_private_share_qq);
        l(this.fQu, R.drawable.icon_share_qq_n);
        this.fQu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bnN(), 8);
            }
        });
        this.fQv = (TextView) this.bMZ.findViewById(R.id.frs_private_share_weibo);
        l(this.fQv, R.drawable.icon_share_weibo_n);
        this.fQv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bnN(), 6);
            }
        });
        this.fMJ = (ImageOverlayView) this.bMZ.findViewById(R.id.frs_private_overlayview);
        int g = l.g(getContext(), R.dimen.tbds68);
        this.fMJ.i(5, g, g, 0, 0, l.g(getContext(), R.dimen.tbds16));
        this.fMJ.setOrientation(true);
        this.fMJ.setLoadImageType(12);
        this.fMJ.onChangeSkinType();
        this.fQy = (HeadImageView) this.bMZ.findViewById(R.id.bar_friend_icon);
        this.fQy.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fQy.setIsRound(true);
        this.fQz = (TextView) this.bMZ.findViewById(R.id.frs_user_name);
        al.j(this.fQz, R.color.cp_cont_b);
        this.fQA = (TextView) this.bMZ.findViewById(R.id.frs_user_name_identify);
        al.j(this.fQA, R.color.cp_btn_a);
    }

    private void xf(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.fQw.setImageBitmap((Bitmap) runTask.getData());
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

    private void brv() {
        ThemeElement themeElement;
        if (this.fMO != null && this.fMO.getForum() != null) {
            ThemeColorInfo themeColorInfo = this.fMO.getForum().getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                this.eQO.setVisibility(8);
                this.fLb.setDefaultGradientColor();
                return;
            }
            this.eQO.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            this.fLb.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.eQO.startLoad(themeElement.pattern_image, 10, false);
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

    public Bitmap bnN() {
        if (this.fQC == null) {
            this.fQx.buildDrawingCache();
            this.fQC = this.fQx.getDrawingCache();
        }
        return this.fQC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Bitmap bitmap) {
        if (!brw()) {
            sX(1);
            if (this.fQB == null) {
                this.fQB = new au(this.mPageContext);
            }
            if (this.fQD != null) {
                this.fQB.h(ap.isEmpty(this.fQD.forum_share_url) ? "http://tieba.baidu.com" : this.fQD.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.fQB.h("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean brw() {
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
        if (bitmap != null && !brw()) {
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
                /* renamed from: bnM */
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
        TiebaStatic.log(new am("c13385").bT("fid", this.fMO.getForum().getId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.coreExtra.c.e d(Bitmap bitmap, int i) {
        com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
        eVar.cjR = false;
        eVar.cjQ = false;
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

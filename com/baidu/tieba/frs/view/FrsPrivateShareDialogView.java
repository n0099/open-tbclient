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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
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
    private LinearLayout bOg;
    private Context context;
    private TbImageView eVX;
    private HeadImageView evL;
    private BarImageView fFE;
    private LinearGradientView fQQ;
    private FrsViewData fSC;
    private ImageOverlayView fSx;
    private TextView fWd;
    private TextView fWe;
    private TextView fWf;
    private TextView fWg;
    private TextView fWh;
    private TextView fWi;
    private TextView fWj;
    private TextView fWk;
    private TextView fWl;
    private ImageView fWm;
    private RelativeLayout fWn;
    private HeadImageView fWo;
    private TextView fWp;
    private TextView fWq;
    private au fWr;
    private Bitmap fWs;
    private ForumActiveInfo fWt;
    private TextView ftg;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean d(FrsViewData frsViewData, TbPageContext tbPageContext) {
        this.fSC = frsViewData;
        this.mPageContext = tbPageContext;
        this.fWt = frsViewData.getForumActiveInfo();
        ap(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.ftg.setVisibility(0);
                this.ftg.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.ftg.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.fFE.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.evL.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.evL.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.fWp.setText(frsViewData.getUserData().getName_show());
                this.fWp.setVisibility(0);
            } else {
                this.fWp.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.fWd.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.fWd.setText(frsViewData.getForum().getSlogan());
            } else {
                this.fWd.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.fWq.setVisibility(0);
                this.fWq.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.fWq.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                xN(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                xN("https://tieba.baidu.com/f?kw=" + frsViewData.getForum().getName() + "&fr=frsshare");
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.fWf.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.fWf.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.fSx.setData(arrayList);
                this.fSx.setVisibility(0);
                this.fWo.setVisibility(8);
                return;
            }
            this.fSx.setVisibility(8);
            this.fWo.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.fWo.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.fWo.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.bOg = (LinearLayout) findViewById(R.id.frs_private_share);
        am.k(this.bOg, R.drawable.bg_frs_private_dialog);
        this.fWn = (RelativeLayout) this.bOg.findViewById(R.id.frs_private_share_view);
        am.k(this.fWn, R.drawable.bg_frs_private_dialog);
        this.fQQ = (LinearGradientView) this.bOg.findViewById(R.id.frs_private_top_gradient_bg);
        this.fQQ.setCornerRadius(l.g(context, R.dimen.tbds30));
        this.fQQ.setRoundMode(3);
        this.eVX = (TbImageView) this.bOg.findViewById(R.id.frs_private_top_bg_mask);
        this.eVX.setDefaultBgResource(R.color.transparent);
        this.eVX.setDefaultResource(R.drawable.pic_frs_head_default);
        this.eVX.setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.eVX.setConrers(3);
        btO();
        this.ftg = (TextView) this.bOg.findViewById(R.id.frs_private_share_name);
        am.j(this.ftg, R.color.cp_btn_a);
        this.fWd = (TextView) this.bOg.findViewById(R.id.frs_private_share_brief);
        am.j(this.fWd, R.color.cp_cont_f);
        this.fWm = (ImageView) this.bOg.findViewById(R.id.frs_private_share_qrcode);
        this.fFE = (BarImageView) this.bOg.findViewById(R.id.frs_private_share_portrait);
        this.fFE.setShowOval(true);
        this.fFE.setStrokeWith(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.fFE.setStrokeColorResId(R.color.cp_bg_line_d);
        this.evL = (HeadImageView) this.bOg.findViewById(R.id.photo);
        this.fWe = (TextView) this.bOg.findViewById(R.id.frs_user_name_identify);
        this.evL.setDefaultBgResource(R.color.cp_bg_line_e);
        this.evL.setIsRound(true);
        this.evL.setTag(null);
        am.k(this.fWe, R.drawable.username_text_bg);
        this.fWf = (TextView) this.bOg.findViewById(R.id.frs_private_share_time);
        am.j(this.fWf, R.color.cp_cont_f);
        this.fWg = (TextView) this.bOg.findViewById(R.id.frs_private_share_download);
        l(this.fWg, R.drawable.icon_share_photoalbum);
        this.fWg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.A(FrsPrivateShareDialogView.this.bqe());
            }
        });
        this.fWh = (TextView) this.bOg.findViewById(R.id.frs_private_share_wechat);
        l(this.fWh, R.drawable.icon_share_wechat_n);
        this.fWh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bqe(), 3);
            }
        });
        this.fWi = (TextView) this.bOg.findViewById(R.id.frs_private_share_moment);
        l(this.fWi, R.drawable.icon_share_circle_n);
        this.fWi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bqe(), 2);
            }
        });
        this.fWj = (TextView) this.bOg.findViewById(R.id.frs_private_share_qzone);
        l(this.fWj, R.drawable.icon_share_qqzone_n);
        this.fWj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bqe(), 4);
            }
        });
        this.fWk = (TextView) this.bOg.findViewById(R.id.frs_private_share_qq);
        l(this.fWk, R.drawable.icon_share_qq_n);
        this.fWk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bqe(), 8);
            }
        });
        this.fWl = (TextView) this.bOg.findViewById(R.id.frs_private_share_weibo);
        l(this.fWl, R.drawable.icon_share_weibo_n);
        this.fWl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bqe(), 6);
            }
        });
        this.fSx = (ImageOverlayView) this.bOg.findViewById(R.id.frs_private_overlayview);
        int g = l.g(getContext(), R.dimen.tbds68);
        this.fSx.j(5, g, g, 0, 0, l.g(getContext(), R.dimen.tbds16));
        this.fSx.setOrientation(true);
        this.fSx.setLoadImageType(12);
        this.fSx.onChangeSkinType();
        this.fWo = (HeadImageView) this.bOg.findViewById(R.id.bar_friend_icon);
        this.fWo.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fWo.setIsRound(true);
        this.fWp = (TextView) this.bOg.findViewById(R.id.frs_user_name);
        am.j(this.fWp, R.color.cp_cont_b);
        this.fWq = (TextView) this.bOg.findViewById(R.id.frs_user_name_identify);
        am.j(this.fWq, R.color.cp_btn_a);
    }

    private void xN(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.fWm.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void l(TextView textView, int i) {
        Drawable drawable = am.getDrawable(i);
        int g = l.g(getContext(), R.dimen.tbds88);
        drawable.setBounds(0, 0, g, g);
        textView.setCompoundDrawables(null, drawable, null, null);
        am.j(textView, R.color.cp_cont_f);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = getTextViewWidth();
        textView.setLayoutParams(layoutParams);
    }

    private void btO() {
        ThemeElement themeElement;
        if (this.fSC != null && this.fSC.getForum() != null) {
            ThemeColorInfo themeColorInfo = this.fSC.getForum().getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                this.eVX.setVisibility(8);
                this.fQQ.setDefaultGradientColor();
                return;
            }
            this.eVX.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            this.fQQ.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.eVX.startLoad(themeElement.pattern_image, 10, false);
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

    public Bitmap bqe() {
        if (this.fWs == null) {
            this.fWn.buildDrawingCache();
            this.fWs = this.fWn.getDrawingCache();
        }
        return this.fWs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Bitmap bitmap) {
        if (!btP()) {
            tr(1);
            if (this.fWr == null) {
                this.fWr = new au(this.mPageContext);
            }
            if (this.fWt != null) {
                this.fWr.h(aq.isEmpty(this.fWt.forum_share_url) ? "http://tieba.baidu.com" : this.fWt.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.fWr.h("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean btP() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.ajS();
        this.mPermissionJudgement.e(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.ad(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Bitmap bitmap, final int i) {
        int i2 = 2;
        if (bitmap != null && !btP()) {
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
            tr(i2);
            aa.a(new z<com.baidu.tbadk.coreExtra.c.e>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bqd */
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

    private void tr(int i) {
        TiebaStatic.log(new an("c13385").bT("fid", this.fSC.getForum().getId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.coreExtra.c.e d(Bitmap bitmap, int i) {
        com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
        eVar.cle = false;
        eVar.cld = false;
        eVar.shareType = 1;
        if (i == 6) {
            eVar.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]@" + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + com.baidu.adp.lib.util.k.bi(this.mForumName) + "&fr=frsshare";
        } else {
            eVar.title = this.context.getString(R.string.app_name);
        }
        eVar.content = "";
        eVar.n(bitmap);
        eVar.aqb();
        return eVar;
    }
}

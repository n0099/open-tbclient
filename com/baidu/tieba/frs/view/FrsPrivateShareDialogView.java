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
    private LinearLayout bOb;
    private Context context;
    private TbImageView eVP;
    private HeadImageView evE;
    private BarImageView fEQ;
    private LinearGradientView fQc;
    private ImageOverlayView fRJ;
    private FrsViewData fRO;
    private TextView fVA;
    private au fVB;
    private Bitmap fVC;
    private ForumActiveInfo fVD;
    private TextView fVn;
    private TextView fVo;
    private TextView fVp;
    private TextView fVq;
    private TextView fVr;
    private TextView fVs;
    private TextView fVt;
    private TextView fVu;
    private TextView fVv;
    private ImageView fVw;
    private RelativeLayout fVx;
    private HeadImageView fVy;
    private TextView fVz;
    private TextView fsH;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean d(FrsViewData frsViewData, TbPageContext tbPageContext) {
        this.fRO = frsViewData;
        this.mPageContext = tbPageContext;
        this.fVD = frsViewData.getForumActiveInfo();
        ap(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.fsH.setVisibility(0);
                this.fsH.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.fsH.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.fEQ.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.evE.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.evE.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.fVz.setText(frsViewData.getUserData().getName_show());
                this.fVz.setVisibility(0);
            } else {
                this.fVz.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.fVn.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.fVn.setText(frsViewData.getForum().getSlogan());
            } else {
                this.fVn.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.fVA.setVisibility(0);
                this.fVA.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.fVA.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                xM(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                xM("https://tieba.baidu.com/f?kw=" + frsViewData.getForum().getName() + "&fr=frsshare");
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.fVp.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.fVp.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.fRJ.setData(arrayList);
                this.fRJ.setVisibility(0);
                this.fVy.setVisibility(8);
                return;
            }
            this.fRJ.setVisibility(8);
            this.fVy.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.fVy.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.fVy.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void ap(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.bOb = (LinearLayout) findViewById(R.id.frs_private_share);
        am.k(this.bOb, R.drawable.bg_frs_private_dialog);
        this.fVx = (RelativeLayout) this.bOb.findViewById(R.id.frs_private_share_view);
        am.k(this.fVx, R.drawable.bg_frs_private_dialog);
        this.fQc = (LinearGradientView) this.bOb.findViewById(R.id.frs_private_top_gradient_bg);
        this.fQc.setCornerRadius(l.g(context, R.dimen.tbds30));
        this.fQc.setRoundMode(3);
        this.eVP = (TbImageView) this.bOb.findViewById(R.id.frs_private_top_bg_mask);
        this.eVP.setDefaultBgResource(R.color.transparent);
        this.eVP.setDefaultResource(R.drawable.pic_frs_head_default);
        this.eVP.setRadius(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.eVP.setConrers(3);
        btB();
        this.fsH = (TextView) this.bOb.findViewById(R.id.frs_private_share_name);
        am.j(this.fsH, R.color.cp_btn_a);
        this.fVn = (TextView) this.bOb.findViewById(R.id.frs_private_share_brief);
        am.j(this.fVn, R.color.cp_cont_f);
        this.fVw = (ImageView) this.bOb.findViewById(R.id.frs_private_share_qrcode);
        this.fEQ = (BarImageView) this.bOb.findViewById(R.id.frs_private_share_portrait);
        this.fEQ.setShowOval(true);
        this.fEQ.setStrokeWith(l.g(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.fEQ.setStrokeColorResId(R.color.cp_bg_line_d);
        this.evE = (HeadImageView) this.bOb.findViewById(R.id.photo);
        this.fVo = (TextView) this.bOb.findViewById(R.id.frs_user_name_identify);
        this.evE.setDefaultBgResource(R.color.cp_bg_line_e);
        this.evE.setIsRound(true);
        this.evE.setTag(null);
        am.k(this.fVo, R.drawable.username_text_bg);
        this.fVp = (TextView) this.bOb.findViewById(R.id.frs_private_share_time);
        am.j(this.fVp, R.color.cp_cont_f);
        this.fVq = (TextView) this.bOb.findViewById(R.id.frs_private_share_download);
        l(this.fVq, R.drawable.icon_share_photoalbum);
        this.fVq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.A(FrsPrivateShareDialogView.this.bpR());
            }
        });
        this.fVr = (TextView) this.bOb.findViewById(R.id.frs_private_share_wechat);
        l(this.fVr, R.drawable.icon_share_wechat_n);
        this.fVr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bpR(), 3);
            }
        });
        this.fVs = (TextView) this.bOb.findViewById(R.id.frs_private_share_moment);
        l(this.fVs, R.drawable.icon_share_circle_n);
        this.fVs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bpR(), 2);
            }
        });
        this.fVt = (TextView) this.bOb.findViewById(R.id.frs_private_share_qzone);
        l(this.fVt, R.drawable.icon_share_qqzone_n);
        this.fVt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bpR(), 4);
            }
        });
        this.fVu = (TextView) this.bOb.findViewById(R.id.frs_private_share_qq);
        l(this.fVu, R.drawable.icon_share_qq_n);
        this.fVu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bpR(), 8);
            }
        });
        this.fVv = (TextView) this.bOb.findViewById(R.id.frs_private_share_weibo);
        l(this.fVv, R.drawable.icon_share_weibo_n);
        this.fVv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bpR(), 6);
            }
        });
        this.fRJ = (ImageOverlayView) this.bOb.findViewById(R.id.frs_private_overlayview);
        int g = l.g(getContext(), R.dimen.tbds68);
        this.fRJ.j(5, g, g, 0, 0, l.g(getContext(), R.dimen.tbds16));
        this.fRJ.setOrientation(true);
        this.fRJ.setLoadImageType(12);
        this.fRJ.onChangeSkinType();
        this.fVy = (HeadImageView) this.bOb.findViewById(R.id.bar_friend_icon);
        this.fVy.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fVy.setIsRound(true);
        this.fVz = (TextView) this.bOb.findViewById(R.id.frs_user_name);
        am.j(this.fVz, R.color.cp_cont_b);
        this.fVA = (TextView) this.bOb.findViewById(R.id.frs_user_name_identify);
        am.j(this.fVA, R.color.cp_btn_a);
    }

    private void xM(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.fVw.setImageBitmap((Bitmap) runTask.getData());
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

    private void btB() {
        ThemeElement themeElement;
        if (this.fRO != null && this.fRO.getForum() != null) {
            ThemeColorInfo themeColorInfo = this.fRO.getForum().getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                this.eVP.setVisibility(8);
                this.fQc.setDefaultGradientColor();
                return;
            }
            this.eVP.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            this.fQc.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.eVP.startLoad(themeElement.pattern_image, 10, false);
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

    public Bitmap bpR() {
        if (this.fVC == null) {
            this.fVx.buildDrawingCache();
            this.fVC = this.fVx.getDrawingCache();
        }
        return this.fVC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Bitmap bitmap) {
        if (!btC()) {
            tp(1);
            if (this.fVB == null) {
                this.fVB = new au(this.mPageContext);
            }
            if (this.fVD != null) {
                this.fVB.h(aq.isEmpty(this.fVD.forum_share_url) ? "http://tieba.baidu.com" : this.fVD.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.fVB.h("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean btC() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.ajQ();
        this.mPermissionJudgement.e(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.ad(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Bitmap bitmap, final int i) {
        int i2 = 2;
        if (bitmap != null && !btC()) {
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
            tp(i2);
            aa.a(new z<com.baidu.tbadk.coreExtra.c.e>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bpQ */
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

    private void tp(int i) {
        TiebaStatic.log(new an("c13385").bT("fid", this.fRO.getForum().getId()).bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.coreExtra.c.e d(Bitmap bitmap, int i) {
        com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
        eVar.ckX = false;
        eVar.ckW = false;
        eVar.shareType = 1;
        if (i == 6) {
            eVar.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]@" + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + com.baidu.adp.lib.util.k.bi(this.mForumName) + "&fr=frsshare";
        } else {
            eVar.title = this.context.getString(R.string.app_name);
        }
        eVar.content = "";
        eVar.n(bitmap);
        eVar.apZ();
        return eVar;
    }
}

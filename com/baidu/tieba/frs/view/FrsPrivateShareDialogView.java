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
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
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
    private Context context;
    private HeadImageView eFo;
    private TbImageView eZy;
    private BarImageView fFR;
    private LinearGradientView fRj;
    private ImageOverlayView fSR;
    private FrsViewData fSW;
    private TextView fWA;
    private TextView fWB;
    private TextView fWC;
    private TextView fWD;
    private TextView fWE;
    private TextView fWF;
    private TextView fWG;
    private ImageView fWH;
    private RelativeLayout fWI;
    private HeadImageView fWJ;
    private TextView fWK;
    private TextView fWL;
    private au fWM;
    private Bitmap fWN;
    private ForumActiveInfo fWO;
    private TextView fWy;
    private TextView fWz;
    private TextView ftp;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean d(FrsViewData frsViewData, TbPageContext tbPageContext) {
        this.fSW = frsViewData;
        this.mPageContext = tbPageContext;
        this.fWO = frsViewData.getForumActiveInfo();
        initUI(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.ftp.setVisibility(0);
                this.ftp.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.ftp.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.fFR.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.eFo.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.eFo.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.fWK.setText(frsViewData.getUserData().getName_show());
                this.fWK.setVisibility(0);
            } else {
                this.fWK.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.fWy.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.fWy.setText(frsViewData.getForum().getSlogan());
            } else {
                this.fWy.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.fWL.setVisibility(0);
                this.fWL.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.fWL.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                wE(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                wE("https://tieba.baidu.com/f?kw=" + frsViewData.getForum().getName() + "&fr=frsshare");
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.fWA.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.fWA.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.fSR.setData(arrayList);
                this.fSR.setVisibility(0);
                this.fWJ.setVisibility(8);
                return;
            }
            this.fSR.setVisibility(8);
            this.fWJ.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.fWJ.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.fWJ.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.fWI = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        am.setBackgroundResource(this.fWI, R.drawable.bg_frs_private_dialog);
        this.fRj = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.fRj.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.fRj.setRoundMode(3);
        this.eZy = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.eZy.setDefaultBgResource(R.color.transparent);
        this.eZy.setDefaultResource(R.drawable.pic_frs_head_default);
        this.eZy.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.eZy.setConrers(3);
        brC();
        this.ftp = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        am.setViewTextColor(this.ftp, (int) R.color.cp_cont_a);
        this.fWy = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        am.setViewTextColor(this.fWy, (int) R.color.cp_cont_f);
        this.fWH = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.fFR = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.fFR.setShowOval(true);
        this.fFR.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.fFR.setStrokeColorResId(R.color.cp_bg_line_d);
        this.eFo = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.fWz = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.eFo.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eFo.setIsRound(true);
        this.eFo.setTag(null);
        am.setBackgroundResource(this.fWz, R.drawable.username_text_bg);
        this.fWA = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        am.setViewTextColor(this.fWA, (int) R.color.cp_cont_f);
        this.fWB = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.fWB, new com.baidu.tbadk.core.util.f.c(R.drawable.icon_share_download_n_svg));
        this.fWB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.y(FrsPrivateShareDialogView.this.bnT());
            }
        });
        this.fWC = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.fWC, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_wechat_n_svg));
        this.fWC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.b(FrsPrivateShareDialogView.this.bnT(), 3);
            }
        });
        this.fWD = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.fWD, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_circle_n_svg));
        this.fWD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.b(FrsPrivateShareDialogView.this.bnT(), 2);
            }
        });
        this.fWE = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.fWE, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qqzone_n_svg));
        this.fWE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.b(FrsPrivateShareDialogView.this.bnT(), 4);
            }
        });
        this.fWF = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.fWF, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qq_n_svg));
        this.fWF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.b(FrsPrivateShareDialogView.this.bnT(), 8);
            }
        });
        this.fWG = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.fWG, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_weibo_n_svg));
        this.fWG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.b(FrsPrivateShareDialogView.this.bnT(), 6);
            }
        });
        this.fSR = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.fSR.j(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.fSR.setOrientation(true);
        this.fSR.setLoadImageType(12);
        this.fSR.onChangeSkinType();
        this.fWJ = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.fWJ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fWJ.setIsRound(true);
        this.fWK = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        am.setViewTextColor(this.fWK, (int) R.color.cp_cont_b);
        this.fWL = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        am.setViewTextColor(this.fWL, (int) R.color.cp_cont_a);
    }

    private void wE(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.fWH.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.f.a aVar) {
        if (aVar != null) {
            Drawable drawable = aVar.getDrawable();
            int dimens = l.getDimens(getContext(), R.dimen.tbds88);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = getTextViewWidth();
            textView.setLayoutParams(layoutParams);
        }
    }

    private void brC() {
        ThemeElement themeElement;
        if (this.fSW != null && this.fSW.getForum() != null) {
            ThemeColorInfo themeColorInfo = this.fSW.getForum().getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                this.eZy.setVisibility(8);
                this.fRj.setDefaultGradientColor();
                return;
            }
            this.eZy.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            this.fRj.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.eZy.startLoad(themeElement.pattern_image, 10, false);
        }
    }

    private int getTextViewWidth() {
        int equipmentWidth;
        int dimens = l.getDimens(this.context, R.dimen.tbds44);
        int dimens2 = l.getDimens(this.context, R.dimen.tbds54);
        if (UtilHelper.getRealScreenOrientation(this.context) == 2) {
            equipmentWidth = (l.getEquipmentHeight(this.context) - (dimens * 2)) - dimens2;
        } else {
            equipmentWidth = (l.getEquipmentWidth(this.context) - (dimens * 2)) - dimens2;
        }
        return equipmentWidth / 6;
    }

    public Bitmap bnT() {
        if (this.fWN == null) {
            this.fWI.buildDrawingCache();
            this.fWN = this.fWI.getDrawingCache();
        }
        return this.fWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Bitmap bitmap) {
        if (!brD()) {
            so(1);
            if (this.fWM == null) {
                this.fWM = new au(this.mPageContext);
            }
            if (this.fWO != null) {
                this.fWM.g(aq.isEmpty(this.fWO.forum_share_url) ? "http://tieba.baidu.com" : this.fWO.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.fWM.g("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean brD() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Bitmap bitmap, final int i) {
        int i2 = 2;
        if (bitmap != null && !brD()) {
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
            so(i2);
            z.a(new y<com.baidu.tbadk.coreExtra.c.e>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.y
                /* renamed from: bnS */
                public com.baidu.tbadk.coreExtra.c.e doInBackground() {
                    return FrsPrivateShareDialogView.this.c(bitmap, i);
                }
            }, new j<com.baidu.tbadk.coreExtra.c.e>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.j
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.e eVar) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(FrsPrivateShareDialogView.this.context, i, eVar, false));
                }
            });
        }
    }

    private void so(int i) {
        TiebaStatic.log(new an("c13385").bS("fid", this.fSW.getForum().getId()).bS("uid", TbadkCoreApplication.getCurrentAccount()).O("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.coreExtra.c.e c(Bitmap bitmap, int i) {
        com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
        eVar.cyi = false;
        eVar.cyh = false;
        eVar.shareType = 1;
        if (i == 6) {
            eVar.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]@" + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + k.getUrlEncode(this.mForumName) + "&fr=frsshare";
        } else {
            eVar.title = this.context.getString(R.string.app_name);
        }
        eVar.content = "";
        eVar.p(bitmap);
        eVar.asf();
        return eVar;
    }
}

package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
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
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import java.net.URLEncoder;
import java.util.ArrayList;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes9.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a Zg;
    private Context context;
    private TextView gXi;
    private HeadImageView giC;
    private TbImageView hAU;
    private TextView hBL;
    private TextView hBM;
    private ImageView hBN;
    private TextView hBO;
    private TextView hBP;
    private TextView hBQ;
    private TextView hBR;
    private TextView hBS;
    private TextView hBT;
    private TextView hBU;
    private ImageView hBV;
    private RelativeLayout hBW;
    private ImageOverlayView hBX;
    private HeadImageView hBY;
    private TextView hBZ;
    private TextView hCa;
    private ar hCb;
    private Bitmap hCc;
    private ForumActiveInfo hCd;
    private BarImageView hkj;
    private LinearGradientView hvz;
    private FrsViewData hyh;
    private String mForumName;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.hyh = frsViewData;
        this.mPageContext = tbPageContext;
        this.Zg = aVar;
        this.hCd = frsViewData.getForumActiveInfo();
        initUI(this.context);
        m(frsViewData);
        return true;
    }

    private void m(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.gXi.setVisibility(0);
                this.gXi.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.gXi.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.hkj.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.giC.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.giC.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.hBZ.setText(frsViewData.getUserData().getName_show());
                this.hBZ.setVisibility(0);
            } else {
                this.hBZ.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.hBL.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.hBL.setText(frsViewData.getForum().getSlogan());
            } else {
                this.hBL.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.hCa.setVisibility(0);
                this.hCa.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.hCa.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                DF(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.hyh.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                DF(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.hBO.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.hBO.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.hBX.setData(arrayList);
                this.hBX.setVisibility(0);
                this.hBY.setVisibility(8);
                return;
            }
            this.hBX.setVisibility(8);
            this.hBY.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.hBY.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.hBY.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.hBW = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        am.setBackgroundResource(this.hBW, R.drawable.bg_frs_private_dialog);
        this.hvz = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.hvz.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.hvz.setRoundMode(3);
        this.hAU = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.hAU.setDefaultBgResource(R.color.transparent);
        this.hAU.setDefaultResource(R.drawable.pic_frs_head_default);
        this.hAU.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.hAU.setConrers(3);
        bWE();
        this.gXi = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        am.setViewTextColor(this.gXi, (int) R.color.cp_cont_a);
        this.hBL = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        am.setViewTextColor(this.hBL, (int) R.color.cp_cont_f);
        this.hBN = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.hBN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.Zg != null && FrsPrivateShareDialogView.this.Zg.isShowing()) {
                    FrsPrivateShareDialogView.this.Zg.dismiss();
                }
            }
        });
        am.setImageResource(this.hBN, R.drawable.icon_popup_shut_n);
        this.hBV = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.hkj = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.hkj.setShowOval(true);
        this.hkj.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.hkj.setStrokeColorResId(R.color.cp_bg_line_d);
        this.giC = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.hBM = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.giC.setDefaultBgResource(R.color.cp_bg_line_e);
        this.giC.setIsRound(true);
        this.giC.setTag(null);
        am.setBackgroundResource(this.hBM, R.drawable.username_text_bg);
        this.hBO = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        am.setViewTextColor(this.hBO, (int) R.color.cp_cont_f);
        this.hBP = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.hBP, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.hBP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.A(FrsPrivateShareDialogView.this.bSH());
            }
        });
        this.hBQ = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.hBQ, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.hBQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bSH(), 3);
            }
        });
        this.hBR = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.hBR, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.hBR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bSH(), 2);
            }
        });
        this.hBS = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.hBS, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.hBS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bSH(), 4);
            }
        });
        this.hBT = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.hBT, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.hBT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bSH(), 8);
            }
        });
        this.hBU = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.hBU, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.hBU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bSH(), 6);
            }
        });
        this.hBX = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.hBX.k(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.hBX.setOrientation(true);
        this.hBX.setLoadImageType(12);
        this.hBX.onChangeSkinType();
        this.hBY = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.hBY.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hBY.setIsRound(true);
        this.hBZ = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        am.setViewTextColor(this.hBZ, (int) R.color.cp_cont_b);
        this.hCa = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        am.setViewTextColor(this.hCa, (int) R.color.cp_cont_a);
    }

    private void DF(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.hBV.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.d.a aVar) {
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

    private void bWE() {
        ForumData forum;
        ThemeElement themeElement;
        if (this.hyh != null && (forum = this.hyh.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.hAU.setVisibility(8);
                this.hvz.setDefaultGradientColor();
                return;
            }
            this.hvz.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.hAU.setVisibility(0);
            this.hAU.startLoad(themeElement.pattern_image, 10, false);
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

    public Bitmap bSH() {
        if (this.hCc == null) {
            this.hBW.buildDrawingCache();
            this.hCc = this.hBW.getDrawingCache();
        }
        return this.hCc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Bitmap bitmap) {
        if (!bWF()) {
            vm(1);
            if (this.hCb == null) {
                this.hCb = new ar(this.mPageContext);
            }
            if (this.hCd != null) {
                this.hCb.j(aq.isEmpty(this.hCd.forum_share_url) ? "http://tieba.baidu.com" : this.hCd.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.hCb.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean bWF() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Bitmap bitmap, final int i) {
        int i2 = 2;
        if (bitmap != null && !bWF()) {
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
            vm(i2);
            ac.a(new ab<ShareItem>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ab
                /* renamed from: bSG */
                public ShareItem doInBackground() {
                    return FrsPrivateShareDialogView.this.d(bitmap, i);
                }
            }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: l */
                public void onReturnDataInUI(ShareItem shareItem) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(FrsPrivateShareDialogView.this.context, i, shareItem, false));
                }
            });
        }
    }

    private void vm(int i) {
        TiebaStatic.log(new an("c13385").cI("fid", this.hyh.getForum().getId()).cI("uid", TbadkCoreApplication.getCurrentAccount()).af("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem d(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.dQP = false;
        shareItem.dQO = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]" + UgcConstant.AT_RULE_TAG + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + k.getUrlEncode(this.mForumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.r(bitmap);
        shareItem.aUU();
        return shareItem;
    }
}

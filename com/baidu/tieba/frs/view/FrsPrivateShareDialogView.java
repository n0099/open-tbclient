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
    private com.baidu.tbadk.core.dialog.a Zd;
    private Context context;
    private TextView gXc;
    private HeadImageView giw;
    private TbImageView hAO;
    private TextView hBF;
    private TextView hBG;
    private ImageView hBH;
    private TextView hBI;
    private TextView hBJ;
    private TextView hBK;
    private TextView hBL;
    private TextView hBM;
    private TextView hBN;
    private TextView hBO;
    private ImageView hBP;
    private RelativeLayout hBQ;
    private ImageOverlayView hBR;
    private HeadImageView hBS;
    private TextView hBT;
    private TextView hBU;
    private ar hBV;
    private Bitmap hBW;
    private ForumActiveInfo hBX;
    private BarImageView hkd;
    private LinearGradientView hvt;
    private FrsViewData hyb;
    private String mForumName;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.hyb = frsViewData;
        this.mPageContext = tbPageContext;
        this.Zd = aVar;
        this.hBX = frsViewData.getForumActiveInfo();
        initUI(this.context);
        m(frsViewData);
        return true;
    }

    private void m(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.gXc.setVisibility(0);
                this.gXc.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.gXc.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.hkd.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.giw.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.giw.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.hBT.setText(frsViewData.getUserData().getName_show());
                this.hBT.setVisibility(0);
            } else {
                this.hBT.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.hBF.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.hBF.setText(frsViewData.getForum().getSlogan());
            } else {
                this.hBF.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.hBU.setVisibility(0);
                this.hBU.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.hBU.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                DC(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.hyb.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                DC(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.hBI.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.hBI.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.hBR.setData(arrayList);
                this.hBR.setVisibility(0);
                this.hBS.setVisibility(8);
                return;
            }
            this.hBR.setVisibility(8);
            this.hBS.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.hBS.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.hBS.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.hBQ = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        am.setBackgroundResource(this.hBQ, R.drawable.bg_frs_private_dialog);
        this.hvt = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.hvt.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.hvt.setRoundMode(3);
        this.hAO = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.hAO.setDefaultBgResource(R.color.transparent);
        this.hAO.setDefaultResource(R.drawable.pic_frs_head_default);
        this.hAO.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.hAO.setConrers(3);
        bWF();
        this.gXc = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        am.setViewTextColor(this.gXc, (int) R.color.cp_cont_a);
        this.hBF = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        am.setViewTextColor(this.hBF, (int) R.color.cp_cont_f);
        this.hBH = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.hBH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.Zd != null && FrsPrivateShareDialogView.this.Zd.isShowing()) {
                    FrsPrivateShareDialogView.this.Zd.dismiss();
                }
            }
        });
        am.setImageResource(this.hBH, R.drawable.icon_popup_shut_n);
        this.hBP = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.hkd = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.hkd.setShowOval(true);
        this.hkd.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.hkd.setStrokeColorResId(R.color.cp_bg_line_d);
        this.giw = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.hBG = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.giw.setDefaultBgResource(R.color.cp_bg_line_e);
        this.giw.setIsRound(true);
        this.giw.setTag(null);
        am.setBackgroundResource(this.hBG, R.drawable.username_text_bg);
        this.hBI = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        am.setViewTextColor(this.hBI, (int) R.color.cp_cont_f);
        this.hBJ = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.hBJ, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.hBJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.A(FrsPrivateShareDialogView.this.bSI());
            }
        });
        this.hBK = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.hBK, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.hBK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bSI(), 3);
            }
        });
        this.hBL = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.hBL, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.hBL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bSI(), 2);
            }
        });
        this.hBM = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.hBM, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.hBM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bSI(), 4);
            }
        });
        this.hBN = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.hBN, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.hBN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bSI(), 8);
            }
        });
        this.hBO = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.hBO, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.hBO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bSI(), 6);
            }
        });
        this.hBR = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.hBR.k(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.hBR.setOrientation(true);
        this.hBR.setLoadImageType(12);
        this.hBR.onChangeSkinType();
        this.hBS = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.hBS.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hBS.setIsRound(true);
        this.hBT = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        am.setViewTextColor(this.hBT, (int) R.color.cp_cont_b);
        this.hBU = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        am.setViewTextColor(this.hBU, (int) R.color.cp_cont_a);
    }

    private void DC(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.hBP.setImageBitmap((Bitmap) runTask.getData());
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

    private void bWF() {
        ForumData forum;
        ThemeElement themeElement;
        if (this.hyb != null && (forum = this.hyb.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.hAO.setVisibility(8);
                this.hvt.setDefaultGradientColor();
                return;
            }
            this.hvt.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.hAO.setVisibility(0);
            this.hAO.startLoad(themeElement.pattern_image, 10, false);
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

    public Bitmap bSI() {
        if (this.hBW == null) {
            this.hBQ.buildDrawingCache();
            this.hBW = this.hBQ.getDrawingCache();
        }
        return this.hBW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Bitmap bitmap) {
        if (!bWG()) {
            vm(1);
            if (this.hBV == null) {
                this.hBV = new ar(this.mPageContext);
            }
            if (this.hBX != null) {
                this.hBV.j(aq.isEmpty(this.hBX.forum_share_url) ? "http://tieba.baidu.com" : this.hBX.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.hBV.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean bWG() {
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
        if (bitmap != null && !bWG()) {
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
                /* renamed from: bSH */
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
        TiebaStatic.log(new an("c13385").cI("fid", this.hyb.getForum().getId()).cI("uid", TbadkCoreApplication.getCurrentAccount()).af("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem d(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.dQK = false;
        shareItem.dQJ = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]" + UgcConstant.AT_RULE_TAG + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + k.getUrlEncode(this.mForumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.r(bitmap);
        shareItem.aUW();
        return shareItem;
    }
}

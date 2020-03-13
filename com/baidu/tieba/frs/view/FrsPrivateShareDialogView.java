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
import java.net.URLEncoder;
import java.util.ArrayList;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes9.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a FR;
    private Context context;
    private HeadImageView fDk;
    private LinearGradientView gKW;
    private FrsViewData gMV;
    private TbImageView gPJ;
    private TextView gQA;
    private TextView gQB;
    private TextView gQC;
    private TextView gQD;
    private TextView gQE;
    private TextView gQF;
    private TextView gQG;
    private ImageView gQH;
    private RelativeLayout gQI;
    private ImageOverlayView gQJ;
    private HeadImageView gQK;
    private TextView gQL;
    private TextView gQM;
    private ar gQN;
    private Bitmap gQO;
    private ForumActiveInfo gQP;
    private TextView gQx;
    private TextView gQy;
    private ImageView gQz;
    private TextView gnn;
    private BarImageView gzJ;
    private String mForumName;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.gMV = frsViewData;
        this.mPageContext = tbPageContext;
        this.FR = aVar;
        this.gQP = frsViewData.getForumActiveInfo();
        initUI(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.gnn.setVisibility(0);
                this.gnn.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.gnn.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.gzJ.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.fDk.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.fDk.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.gQL.setText(frsViewData.getUserData().getName_show());
                this.gQL.setVisibility(0);
            } else {
                this.gQL.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.gQx.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.gQx.setText(frsViewData.getForum().getSlogan());
            } else {
                this.gQx.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.gQM.setVisibility(0);
                this.gQM.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.gQM.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                BU(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.gMV.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                BU(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.gQA.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.gQA.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.gQJ.setData(arrayList);
                this.gQJ.setVisibility(0);
                this.gQK.setVisibility(8);
                return;
            }
            this.gQJ.setVisibility(8);
            this.gQK.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.gQK.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.gQK.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.gQI = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        am.setBackgroundResource(this.gQI, R.drawable.bg_frs_private_dialog);
        this.gKW = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.gKW.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.gKW.setRoundMode(3);
        this.gPJ = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.gPJ.setDefaultBgResource(R.color.transparent);
        this.gPJ.setDefaultResource(R.drawable.pic_frs_head_default);
        this.gPJ.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.gPJ.setConrers(3);
        bLL();
        this.gnn = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        am.setViewTextColor(this.gnn, (int) R.color.cp_cont_a);
        this.gQx = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        am.setViewTextColor(this.gQx, (int) R.color.cp_cont_f);
        this.gQz = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.gQz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.FR != null && FrsPrivateShareDialogView.this.FR.isShowing()) {
                    FrsPrivateShareDialogView.this.FR.dismiss();
                }
            }
        });
        am.setImageResource(this.gQz, R.drawable.icon_popup_shut_n);
        this.gQH = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.gzJ = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.gzJ.setShowOval(true);
        this.gzJ.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.gzJ.setStrokeColorResId(R.color.cp_bg_line_d);
        this.fDk = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.gQy = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.fDk.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fDk.setIsRound(true);
        this.fDk.setTag(null);
        am.setBackgroundResource(this.gQy, R.drawable.username_text_bg);
        this.gQA = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        am.setViewTextColor(this.gQA, (int) R.color.cp_cont_f);
        this.gQB = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.gQB, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.gQB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.y(FrsPrivateShareDialogView.this.bHX());
            }
        });
        this.gQC = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.gQC, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.gQC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bHX(), 3);
            }
        });
        this.gQD = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.gQD, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.gQD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bHX(), 2);
            }
        });
        this.gQE = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.gQE, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.gQE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bHX(), 4);
            }
        });
        this.gQF = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.gQF, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.gQF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bHX(), 8);
            }
        });
        this.gQG = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.gQG, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.gQG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bHX(), 6);
            }
        });
        this.gQJ = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.gQJ.k(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.gQJ.setOrientation(true);
        this.gQJ.setLoadImageType(12);
        this.gQJ.onChangeSkinType();
        this.gQK = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.gQK.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gQK.setIsRound(true);
        this.gQL = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        am.setViewTextColor(this.gQL, (int) R.color.cp_cont_b);
        this.gQM = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        am.setViewTextColor(this.gQM, (int) R.color.cp_cont_a);
    }

    private void BU(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.gQH.setImageBitmap((Bitmap) runTask.getData());
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

    private void bLL() {
        ForumData forum;
        ThemeElement themeElement;
        if (this.gMV != null && (forum = this.gMV.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.gPJ.setVisibility(8);
                this.gKW.setDefaultGradientColor();
                return;
            }
            this.gKW.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.gPJ.setVisibility(0);
            this.gPJ.startLoad(themeElement.pattern_image, 10, false);
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

    public Bitmap bHX() {
        if (this.gQO == null) {
            this.gQI.buildDrawingCache();
            this.gQO = this.gQI.getDrawingCache();
        }
        return this.gQO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Bitmap bitmap) {
        if (!bLM()) {
            uH(1);
            if (this.gQN == null) {
                this.gQN = new ar(this.mPageContext);
            }
            if (this.gQP != null) {
                this.gQN.j(aq.isEmpty(this.gQP.forum_share_url) ? "http://tieba.baidu.com" : this.gQP.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.gQN.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean bLM() {
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
        if (bitmap != null && !bLM()) {
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
            uH(i2);
            ac.a(new ab<ShareItem>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ab
                /* renamed from: bHW */
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

    private void uH(int i) {
        TiebaStatic.log(new an("c13385").cy("fid", this.gMV.getForum().getId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).X("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem d(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.dqE = false;
        shareItem.dqD = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]@" + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + k.getUrlEncode(this.mForumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.p(bitmap);
        shareItem.aMv();
        return shareItem;
    }
}

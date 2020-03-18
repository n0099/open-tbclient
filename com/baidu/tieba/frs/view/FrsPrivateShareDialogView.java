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
    private HeadImageView fDS;
    private BarImageView gAH;
    private LinearGradientView gMb;
    private FrsViewData gOa;
    private TbImageView gQQ;
    private TextView gRE;
    private TextView gRF;
    private ImageView gRG;
    private TextView gRH;
    private TextView gRI;
    private TextView gRJ;
    private TextView gRK;
    private TextView gRL;
    private TextView gRM;
    private TextView gRN;
    private ImageView gRO;
    private RelativeLayout gRP;
    private ImageOverlayView gRQ;
    private HeadImageView gRR;
    private TextView gRS;
    private TextView gRT;
    private ar gRU;
    private Bitmap gRV;
    private ForumActiveInfo gRW;
    private TextView gnW;
    private String mForumName;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.gOa = frsViewData;
        this.mPageContext = tbPageContext;
        this.FR = aVar;
        this.gRW = frsViewData.getForumActiveInfo();
        initUI(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.gnW.setVisibility(0);
                this.gnW.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.gnW.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.gAH.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.fDS.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.fDS.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.gRS.setText(frsViewData.getUserData().getName_show());
                this.gRS.setVisibility(0);
            } else {
                this.gRS.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.gRE.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.gRE.setText(frsViewData.getForum().getSlogan());
            } else {
                this.gRE.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.gRT.setVisibility(0);
                this.gRT.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.gRT.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                BT(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.gOa.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                BT(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.gRH.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.gRH.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.gRQ.setData(arrayList);
                this.gRQ.setVisibility(0);
                this.gRR.setVisibility(8);
                return;
            }
            this.gRQ.setVisibility(8);
            this.gRR.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.gRR.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.gRR.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.gRP = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        am.setBackgroundResource(this.gRP, R.drawable.bg_frs_private_dialog);
        this.gMb = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.gMb.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.gMb.setRoundMode(3);
        this.gQQ = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.gQQ.setDefaultBgResource(R.color.transparent);
        this.gQQ.setDefaultResource(R.drawable.pic_frs_head_default);
        this.gQQ.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.gQQ.setConrers(3);
        bLZ();
        this.gnW = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        am.setViewTextColor(this.gnW, (int) R.color.cp_cont_a);
        this.gRE = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        am.setViewTextColor(this.gRE, (int) R.color.cp_cont_f);
        this.gRG = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.gRG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.FR != null && FrsPrivateShareDialogView.this.FR.isShowing()) {
                    FrsPrivateShareDialogView.this.FR.dismiss();
                }
            }
        });
        am.setImageResource(this.gRG, R.drawable.icon_popup_shut_n);
        this.gRO = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.gAH = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.gAH.setShowOval(true);
        this.gAH.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.gAH.setStrokeColorResId(R.color.cp_bg_line_d);
        this.fDS = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.gRF = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.fDS.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fDS.setIsRound(true);
        this.fDS.setTag(null);
        am.setBackgroundResource(this.gRF, R.drawable.username_text_bg);
        this.gRH = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        am.setViewTextColor(this.gRH, (int) R.color.cp_cont_f);
        this.gRI = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.gRI, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.gRI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.y(FrsPrivateShareDialogView.this.bIj());
            }
        });
        this.gRJ = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.gRJ, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.gRJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bIj(), 3);
            }
        });
        this.gRK = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.gRK, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.gRK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bIj(), 2);
            }
        });
        this.gRL = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.gRL, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.gRL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bIj(), 4);
            }
        });
        this.gRM = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.gRM, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.gRM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bIj(), 8);
            }
        });
        this.gRN = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.gRN, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.gRN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bIj(), 6);
            }
        });
        this.gRQ = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.gRQ.k(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.gRQ.setOrientation(true);
        this.gRQ.setLoadImageType(12);
        this.gRQ.onChangeSkinType();
        this.gRR = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.gRR.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gRR.setIsRound(true);
        this.gRS = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        am.setViewTextColor(this.gRS, (int) R.color.cp_cont_b);
        this.gRT = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        am.setViewTextColor(this.gRT, (int) R.color.cp_cont_a);
    }

    private void BT(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.gRO.setImageBitmap((Bitmap) runTask.getData());
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

    private void bLZ() {
        ForumData forum;
        ThemeElement themeElement;
        if (this.gOa != null && (forum = this.gOa.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.gQQ.setVisibility(8);
                this.gMb.setDefaultGradientColor();
                return;
            }
            this.gMb.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.gQQ.setVisibility(0);
            this.gQQ.startLoad(themeElement.pattern_image, 10, false);
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

    public Bitmap bIj() {
        if (this.gRV == null) {
            this.gRP.buildDrawingCache();
            this.gRV = this.gRP.getDrawingCache();
        }
        return this.gRV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Bitmap bitmap) {
        if (!bMa()) {
            uO(1);
            if (this.gRU == null) {
                this.gRU = new ar(this.mPageContext);
            }
            if (this.gRW != null) {
                this.gRU.j(aq.isEmpty(this.gRW.forum_share_url) ? "http://tieba.baidu.com" : this.gRW.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.gRU.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean bMa() {
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
        if (bitmap != null && !bMa()) {
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
            uO(i2);
            ac.a(new ab<ShareItem>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ab
                /* renamed from: bIi */
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

    private void uO(int i) {
        TiebaStatic.log(new an("c13385").cx("fid", this.gOa.getForum().getId()).cx("uid", TbadkCoreApplication.getCurrentAccount()).X("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem d(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.dqR = false;
        shareItem.dqQ = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]@" + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + k.getUrlEncode(this.mForumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.p(bitmap);
        shareItem.aMz();
        return shareItem;
    }
}

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
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.az;
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
    private com.baidu.tbadk.core.dialog.a Zw;
    private Context context;
    private HeadImageView gxs;
    private LinearGradientView hKm;
    private FrsViewData hMU;
    private TbImageView hPH;
    private ImageView hQA;
    private TextView hQB;
    private TextView hQC;
    private TextView hQD;
    private TextView hQE;
    private TextView hQF;
    private TextView hQG;
    private TextView hQH;
    private ImageView hQI;
    private RelativeLayout hQJ;
    private ImageOverlayView hQK;
    private HeadImageView hQL;
    private TextView hQM;
    private TextView hQN;
    private az hQO;
    private Bitmap hQP;
    private ForumActiveInfo hQQ;
    private TextView hQy;
    private TextView hQz;
    private TextView hlU;
    private BarImageView hyX;
    private String mForumName;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.hMU = frsViewData;
        this.mPageContext = tbPageContext;
        this.Zw = aVar;
        this.hQQ = frsViewData.getForumActiveInfo();
        initUI(this.context);
        m(frsViewData);
        return true;
    }

    private void m(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.hlU.setVisibility(0);
                this.hlU.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.hlU.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.hyX.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.gxs.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.gxs.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.hQM.setText(frsViewData.getUserData().getName_show());
                this.hQM.setVisibility(0);
            } else {
                this.hQM.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.hQy.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.hQy.setText(frsViewData.getForum().getSlogan());
            } else {
                this.hQy.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.hQN.setVisibility(0);
                this.hQN.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.hQN.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                Fo(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.hMU.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                Fo(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.hQB.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.hQB.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.hQK.setData(arrayList);
                this.hQK.setVisibility(0);
                this.hQL.setVisibility(8);
                return;
            }
            this.hQK.setVisibility(8);
            this.hQL.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.hQL.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.hQL.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.hQJ = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        am.setBackgroundResource(this.hQJ, R.drawable.bg_frs_private_dialog);
        this.hKm = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.hKm.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.hKm.setRoundMode(3);
        this.hPH = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.hPH.setDefaultBgResource(R.color.transparent);
        this.hPH.setDefaultResource(R.drawable.pic_frs_head_default);
        this.hPH.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.hPH.setConrers(3);
        cdc();
        this.hlU = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        am.setViewTextColor(this.hlU, (int) R.color.cp_cont_a);
        this.hQy = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        am.setViewTextColor(this.hQy, (int) R.color.cp_cont_f);
        this.hQA = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.hQA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.Zw != null && FrsPrivateShareDialogView.this.Zw.isShowing()) {
                    FrsPrivateShareDialogView.this.Zw.dismiss();
                }
            }
        });
        am.setImageResource(this.hQA, R.drawable.icon_popup_shut_n);
        this.hQI = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.hyX = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.hyX.setShowOval(true);
        this.hyX.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.hyX.setStrokeColorResId(R.color.cp_bg_line_d);
        this.gxs = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.hQz = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.gxs.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gxs.setIsRound(true);
        this.gxs.setTag(null);
        am.setBackgroundResource(this.hQz, R.drawable.username_text_bg);
        this.hQB = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        am.setViewTextColor(this.hQB, (int) R.color.cp_cont_f);
        this.hQC = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.hQC, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.hQC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.A(FrsPrivateShareDialogView.this.bZc());
            }
        });
        this.hQD = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.hQD, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.hQD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bZc(), 3);
            }
        });
        this.hQE = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.hQE, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.hQE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bZc(), 2);
            }
        });
        this.hQF = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.hQF, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.hQF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bZc(), 4);
            }
        });
        this.hQG = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.hQG, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.hQG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bZc(), 8);
            }
        });
        this.hQH = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.hQH, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.hQH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bZc(), 6);
            }
        });
        this.hQK = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.hQK.k(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.hQK.setOrientation(true);
        this.hQK.setLoadImageType(12);
        this.hQK.onChangeSkinType();
        this.hQL = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.hQL.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hQL.setIsRound(true);
        this.hQM = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        am.setViewTextColor(this.hQM, (int) R.color.cp_cont_b);
        this.hQN = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        am.setViewTextColor(this.hQN, (int) R.color.cp_cont_a);
    }

    private void Fo(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.hQI.setImageBitmap((Bitmap) runTask.getData());
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

    private void cdc() {
        ForumData forum;
        ThemeElement themeElement;
        if (this.hMU != null && (forum = this.hMU.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.hPH.setVisibility(8);
                this.hKm.setDefaultGradientColor();
                return;
            }
            this.hKm.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.hPH.setVisibility(0);
            this.hPH.startLoad(themeElement.pattern_image, 10, false);
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

    public Bitmap bZc() {
        if (this.hQP == null) {
            this.hQJ.buildDrawingCache();
            this.hQP = this.hQJ.getDrawingCache();
        }
        return this.hQP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Bitmap bitmap) {
        if (!cdd()) {
            vS(1);
            if (this.hQO == null) {
                this.hQO = new az(this.mPageContext);
            }
            if (this.hQQ != null) {
                this.hQO.j(aq.isEmpty(this.hQQ.forum_share_url) ? "http://tieba.baidu.com" : this.hQQ.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.hQO.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean cdd() {
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
        if (bitmap != null && !cdd()) {
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
            vS(i2);
            ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: bZb */
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

    private void vS(int i) {
        TiebaStatic.log(new an("c13385").dh("fid", this.hMU.getForum().getId()).dh("uid", TbadkCoreApplication.getCurrentAccount()).ag("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem d(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.efi = false;
        shareItem.efh = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]" + UgcConstant.AT_RULE_TAG + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + k.getUrlEncode(this.mForumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.s(bitmap);
        shareItem.bbe();
        return shareItem;
    }
}

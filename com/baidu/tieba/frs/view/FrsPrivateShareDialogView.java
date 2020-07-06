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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
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
    private com.baidu.tbadk.core.dialog.a aaa;
    private Context context;
    private TextView dEF;
    private TextView dEG;
    private TextView dEH;
    private TextView dEI;
    private TextView dEJ;
    private TextView dEK;
    private az dEN;
    private Bitmap dEO;
    private ImageView dEQ;
    private ImageView dEY;
    private HeadImageView gKr;
    private BarImageView hMS;
    private LinearGradientView hYl;
    private TextView hym;
    private FrsViewData iaT;
    private TbImageView idP;
    private TextView ieV;
    private TextView ieW;
    private TextView ieX;
    private RelativeLayout ieY;
    private ImageOverlayView ieZ;
    private HeadImageView ifa;
    private TextView ifb;
    private TextView ifc;
    private ForumActiveInfo ifd;
    private String mForumName;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.iaT = frsViewData;
        this.mPageContext = tbPageContext;
        this.aaa = aVar;
        this.ifd = frsViewData.getForumActiveInfo();
        initUI(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.hym.setVisibility(0);
                this.hym.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.hym.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.hMS.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.gKr.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.gKr.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.ifb.setText(frsViewData.getUserData().getName_show());
                this.ifb.setVisibility(0);
            } else {
                this.ifb.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.ieV.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.ieV.setText(frsViewData.getForum().getSlogan());
            } else {
                this.ieV.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.ifc.setVisibility(0);
                this.ifc.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.ifc.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                vx(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.iaT.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                vx(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.ieX.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.ieX.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.ieZ.setData(arrayList);
                this.ieZ.setVisibility(0);
                this.ifa.setVisibility(8);
                return;
            }
            this.ieZ.setVisibility(8);
            this.ifa.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.ifa.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.ifa.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        an.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.ieY = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        an.setBackgroundResource(this.ieY, R.drawable.bg_frs_private_dialog);
        this.hYl = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.hYl.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.hYl.setRoundMode(3);
        this.idP = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.idP.setDefaultBgResource(R.color.transparent);
        this.idP.setDefaultResource(R.drawable.pic_frs_head_default);
        this.idP.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.idP.setConrers(3);
        cgJ();
        this.hym = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        an.setViewTextColor(this.hym, (int) R.color.cp_cont_a);
        this.ieV = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        an.setViewTextColor(this.ieV, (int) R.color.cp_cont_f);
        this.dEY = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.dEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.aaa != null && FrsPrivateShareDialogView.this.aaa.isShowing()) {
                    FrsPrivateShareDialogView.this.aaa.dismiss();
                }
            }
        });
        an.setImageResource(this.dEY, R.drawable.icon_popup_shut_n);
        this.dEQ = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.hMS = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.hMS.setShowOval(true);
        this.hMS.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.hMS.setStrokeColorResId(R.color.cp_bg_line_d);
        this.gKr = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.ieW = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.gKr.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gKr.setIsRound(true);
        this.gKr.setTag(null);
        an.setBackgroundResource(this.ieW, R.drawable.username_text_bg);
        this.ieX = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        an.setViewTextColor(this.ieX, (int) R.color.cp_cont_f);
        this.dEF = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.dEF, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.dEF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.q(FrsPrivateShareDialogView.this.aPt());
            }
        });
        this.dEG = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.dEG, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.dEG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.aPt(), 3);
            }
        });
        this.dEH = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.dEH, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.dEH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.aPt(), 2);
            }
        });
        this.dEI = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.dEI, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.dEI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.aPt(), 4);
            }
        });
        this.dEJ = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.dEJ, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.dEJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.aPt(), 8);
            }
        });
        this.dEK = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.dEK, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.dEK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.aPt(), 6);
            }
        });
        this.ieZ = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.ieZ.k(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.ieZ.setOrientation(true);
        this.ieZ.setLoadImageType(12);
        this.ieZ.onChangeSkinType();
        this.ifa = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.ifa.setDefaultBgResource(R.color.cp_bg_line_e);
        this.ifa.setIsRound(true);
        this.ifb = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        an.setViewTextColor(this.ifb, (int) R.color.cp_cont_b);
        this.ifc = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        an.setViewTextColor(this.ifc, (int) R.color.cp_cont_a);
    }

    private void vx(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.dEQ.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            Drawable drawable = aVar.getDrawable();
            int dimens = l.getDimens(getContext(), R.dimen.tbds88);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            an.setViewTextColor(textView, (int) R.color.cp_cont_f);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = getTextViewWidth();
            textView.setLayoutParams(layoutParams);
        }
    }

    private void cgJ() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.iaT != null && (forum = this.iaT.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.idP.setVisibility(8);
                this.hYl.setDefaultGradientColor();
                return;
            }
            this.hYl.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.iaT.getStar() != null && !StringUtils.isNull(this.iaT.getStar().dhn())) {
                str = this.iaT.getStar().dhn();
            } else {
                str = themeElement.pattern_image;
            }
            this.idP.setVisibility(0);
            this.idP.startLoad(str, 10, false);
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

    public Bitmap aPt() {
        if (this.dEO == null) {
            this.ieY.buildDrawingCache();
            this.dEO = this.ieY.getDrawingCache();
        }
        return this.dEO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Bitmap bitmap) {
        if (!aPu()) {
            wA(1);
            ao aoVar = new ao("c13724");
            aoVar.ag("obj_type", 1);
            aoVar.ag("obj_source", 1);
            TiebaStatic.log(aoVar);
            if (this.dEN == null) {
                this.dEN = new az(this.mPageContext);
            }
            if (this.ifd != null) {
                this.dEN.j(ar.isEmpty(this.ifd.forum_share_url) ? "http://tieba.baidu.com" : this.ifd.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.dEN.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean aPu() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Bitmap bitmap, final int i) {
        int i2;
        if (bitmap != null && !aPu()) {
            if (i == 3) {
                i2 = 2;
            } else if (i == 2) {
                i2 = 3;
            } else if (i == 4) {
                i2 = 4;
            } else if (i == 8) {
                i2 = 5;
            } else {
                i2 = i == 6 ? 6 : 1;
            }
            wA(i2);
            ao aoVar = new ao("c13724");
            if (i == 3) {
                aoVar.ag("obj_type", 2);
            } else if (i == 2) {
                aoVar.ag("obj_type", 3);
            } else if (i == 8) {
                aoVar.ag("obj_type", 4);
            } else if (i == 4) {
                aoVar.ag("obj_type", 5);
            } else if (i == 6) {
                aoVar.ag("obj_type", 6);
            }
            aoVar.ag("obj_source", 1);
            TiebaStatic.log(aoVar);
            ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: aPv */
                public ShareItem doInBackground() {
                    return FrsPrivateShareDialogView.this.d(bitmap, i);
                }
            }, new com.baidu.tbadk.util.l<ShareItem>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: b */
                public void onReturnDataInUI(ShareItem shareItem) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(FrsPrivateShareDialogView.this.context, i, shareItem, false));
                }
            });
        }
    }

    private void wA(int i) {
        TiebaStatic.log(new ao("c13385").dk("fid", this.iaT.getForum().getId()).dk("uid", TbadkCoreApplication.getCurrentAccount()).ag("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem d(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.enT = false;
        shareItem.enS = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]" + UgcConstant.AT_RULE_TAG + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + k.getUrlEncode(this.mForumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.t(bitmap);
        shareItem.bdh();
        return shareItem;
    }
}

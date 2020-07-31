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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.bd;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import java.net.URLEncoder;
import java.util.ArrayList;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes16.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a ZV;
    private Context context;
    private TextView dKC;
    private TextView dKD;
    private TextView dKE;
    private TextView dKF;
    private TextView dKG;
    private TextView dKH;
    private bd dKK;
    private Bitmap dKL;
    private ImageView dKN;
    private ImageView dKV;
    private HeadImageView gPX;
    private TextView hEa;
    private BarImageView hSR;
    private LinearGradientView ien;
    private FrsViewData igV;
    private TbImageView ijN;
    private TextView ikV;
    private TextView ikW;
    private TextView ikX;
    private RelativeLayout ikY;
    private ImageOverlayView ikZ;
    private HeadImageView ila;
    private TextView ilb;
    private TextView ilc;
    private ForumActiveInfo ild;
    private String mForumName;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.igV = frsViewData;
        this.mPageContext = tbPageContext;
        this.ZV = aVar;
        this.ild = frsViewData.getForumActiveInfo();
        initUI(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.hEa.setVisibility(0);
                this.hEa.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.hEa.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.hSR.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.gPX.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.gPX.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.ilb.setText(frsViewData.getUserData().getName_show());
                this.ilb.setVisibility(0);
            } else {
                this.ilb.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.ikV.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.ikV.setText(frsViewData.getForum().getSlogan());
            } else {
                this.ikV.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.ilc.setVisibility(0);
                this.ilc.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.ilc.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                wz(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.igV.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                wz(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.ikX.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.ikX.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.ikZ.setData(arrayList);
                this.ikZ.setVisibility(0);
                this.ila.setVisibility(8);
                return;
            }
            this.ikZ.setVisibility(8);
            this.ila.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.ila.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.ila.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.ikY = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        ao.setBackgroundResource(this.ikY, R.drawable.bg_frs_private_dialog);
        this.ien = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.ien.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.ien.setRoundMode(3);
        this.ijN = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.ijN.setDefaultBgResource(R.color.transparent);
        this.ijN.setDefaultResource(R.drawable.pic_frs_head_default);
        this.ijN.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.ijN.setConrers(3);
        cki();
        this.hEa = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        ao.setViewTextColor(this.hEa, R.color.cp_cont_a);
        this.ikV = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        ao.setViewTextColor(this.ikV, R.color.cp_cont_f);
        this.dKV = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.dKV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.ZV != null && FrsPrivateShareDialogView.this.ZV.isShowing()) {
                    FrsPrivateShareDialogView.this.ZV.dismiss();
                }
            }
        });
        ao.setImageResource(this.dKV, R.drawable.icon_popup_shut_n);
        this.dKN = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.hSR = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.hSR.setShowOval(true);
        this.hSR.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.hSR.setStrokeColorResId(R.color.cp_bg_line_d);
        this.gPX = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.ikW = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.gPX.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gPX.setIsRound(true);
        this.gPX.setTag(null);
        ao.setBackgroundResource(this.ikW, R.drawable.username_text_bg);
        this.ikX = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        ao.setViewTextColor(this.ikX, R.color.cp_cont_f);
        this.dKC = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.dKC, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.dKC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.t(FrsPrivateShareDialogView.this.aTo());
            }
        });
        this.dKD = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.dKD, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.dKD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.aTo(), 3);
            }
        });
        this.dKE = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.dKE, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.dKE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.aTo(), 2);
            }
        });
        this.dKF = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.dKF, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.dKF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.aTo(), 4);
            }
        });
        this.dKG = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.dKG, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.dKG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.aTo(), 8);
            }
        });
        this.dKH = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.dKH, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.dKH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.aTo(), 6);
            }
        });
        this.ikZ = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.ikZ.k(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.ikZ.setOrientation(true);
        this.ikZ.setLoadImageType(12);
        this.ikZ.onChangeSkinType();
        this.ila = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.ila.setDefaultBgResource(R.color.cp_bg_line_e);
        this.ila.setIsRound(true);
        this.ilb = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        ao.setViewTextColor(this.ilb, R.color.cp_cont_b);
        this.ilc = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        ao.setViewTextColor(this.ilc, R.color.cp_cont_a);
    }

    private void wz(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.dKN.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            Drawable drawable = aVar.getDrawable();
            int dimens = l.getDimens(getContext(), R.dimen.tbds88);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            ao.setViewTextColor(textView, R.color.cp_cont_f);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = getTextViewWidth();
            textView.setLayoutParams(layoutParams);
        }
    }

    private void cki() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.igV != null && (forum = this.igV.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.ijN.setVisibility(8);
                this.ien.setDefaultGradientColor();
                return;
            }
            this.ien.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.igV.getStar() != null && !StringUtils.isNull(this.igV.getStar().dkv())) {
                str = this.igV.getStar().dkv();
            } else {
                str = themeElement.pattern_image;
            }
            this.ijN.setVisibility(0);
            this.ijN.startLoad(str, 10, false);
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

    public Bitmap aTo() {
        if (this.dKL == null) {
            this.ikY.buildDrawingCache();
            this.dKL = this.ikY.getDrawingCache();
        }
        return this.dKL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Bitmap bitmap) {
        if (!aTp()) {
            wS(1);
            ap apVar = new ap("c13724");
            apVar.ah("obj_type", 1);
            apVar.ah("obj_source", 1);
            TiebaStatic.log(apVar);
            if (this.dKK == null) {
                this.dKK = new bd(this.mPageContext);
            }
            if (this.ild != null) {
                this.dKK.j(as.isEmpty(this.ild.forum_share_url) ? "http://tieba.baidu.com" : this.ild.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.dKK.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean aTp() {
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
        if (bitmap != null && !aTp()) {
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
            wS(i2);
            ap apVar = new ap("c13724");
            if (i == 3) {
                apVar.ah("obj_type", 2);
            } else if (i == 2) {
                apVar.ah("obj_type", 3);
            } else if (i == 8) {
                apVar.ah("obj_type", 4);
            } else if (i == 4) {
                apVar.ah("obj_type", 5);
            } else if (i == 6) {
                apVar.ah("obj_type", 6);
            }
            apVar.ah("obj_source", 1);
            TiebaStatic.log(apVar);
            ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: aTq */
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

    private void wS(int i) {
        TiebaStatic.log(new ap("c13385").dn("fid", this.igV.getForum().getId()).dn("uid", TbadkCoreApplication.getCurrentAccount()).ah("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem d(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.euf = false;
        shareItem.eue = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]" + UgcConstant.AT_RULE_TAG + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + k.getUrlEncode(this.mForumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bgO();
        return shareItem;
    }
}

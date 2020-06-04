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
    private HeadImageView gxD;
    private LinearGradientView hKZ;
    private FrsViewData hNH;
    private TbImageView hQu;
    private TextView hRA;
    private az hRB;
    private Bitmap hRC;
    private ForumActiveInfo hRD;
    private TextView hRl;
    private TextView hRm;
    private ImageView hRn;
    private TextView hRo;
    private TextView hRp;
    private TextView hRq;
    private TextView hRr;
    private TextView hRs;
    private TextView hRt;
    private TextView hRu;
    private ImageView hRv;
    private RelativeLayout hRw;
    private ImageOverlayView hRx;
    private HeadImageView hRy;
    private TextView hRz;
    private TextView hmf;
    private BarImageView hzK;
    private String mForumName;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.hNH = frsViewData;
        this.mPageContext = tbPageContext;
        this.Zw = aVar;
        this.hRD = frsViewData.getForumActiveInfo();
        initUI(this.context);
        m(frsViewData);
        return true;
    }

    private void m(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.hmf.setVisibility(0);
                this.hmf.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.hmf.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.hzK.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.gxD.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.gxD.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.hRz.setText(frsViewData.getUserData().getName_show());
                this.hRz.setVisibility(0);
            } else {
                this.hRz.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.hRl.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.hRl.setText(frsViewData.getForum().getSlogan());
            } else {
                this.hRl.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.hRA.setVisibility(0);
                this.hRA.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.hRA.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                Fo(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.hNH.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                Fo(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.hRo.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.hRo.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.hRx.setData(arrayList);
                this.hRx.setVisibility(0);
                this.hRy.setVisibility(8);
                return;
            }
            this.hRx.setVisibility(8);
            this.hRy.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.hRy.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.hRy.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.hRw = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        am.setBackgroundResource(this.hRw, R.drawable.bg_frs_private_dialog);
        this.hKZ = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.hKZ.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.hKZ.setRoundMode(3);
        this.hQu = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.hQu.setDefaultBgResource(R.color.transparent);
        this.hQu.setDefaultResource(R.drawable.pic_frs_head_default);
        this.hQu.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.hQu.setConrers(3);
        cdk();
        this.hmf = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        am.setViewTextColor(this.hmf, (int) R.color.cp_cont_a);
        this.hRl = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        am.setViewTextColor(this.hRl, (int) R.color.cp_cont_f);
        this.hRn = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.hRn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.Zw != null && FrsPrivateShareDialogView.this.Zw.isShowing()) {
                    FrsPrivateShareDialogView.this.Zw.dismiss();
                }
            }
        });
        am.setImageResource(this.hRn, R.drawable.icon_popup_shut_n);
        this.hRv = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.hzK = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.hzK.setShowOval(true);
        this.hzK.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.hzK.setStrokeColorResId(R.color.cp_bg_line_d);
        this.gxD = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.hRm = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.gxD.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gxD.setIsRound(true);
        this.gxD.setTag(null);
        am.setBackgroundResource(this.hRm, R.drawable.username_text_bg);
        this.hRo = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        am.setViewTextColor(this.hRo, (int) R.color.cp_cont_f);
        this.hRp = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.hRp, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.hRp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.A(FrsPrivateShareDialogView.this.bZk());
            }
        });
        this.hRq = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.hRq, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.hRq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bZk(), 3);
            }
        });
        this.hRr = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.hRr, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.hRr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bZk(), 2);
            }
        });
        this.hRs = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.hRs, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.hRs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bZk(), 4);
            }
        });
        this.hRt = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.hRt, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.hRt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bZk(), 8);
            }
        });
        this.hRu = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.hRu, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.hRu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bZk(), 6);
            }
        });
        this.hRx = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.hRx.k(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.hRx.setOrientation(true);
        this.hRx.setLoadImageType(12);
        this.hRx.onChangeSkinType();
        this.hRy = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.hRy.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hRy.setIsRound(true);
        this.hRz = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        am.setViewTextColor(this.hRz, (int) R.color.cp_cont_b);
        this.hRA = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        am.setViewTextColor(this.hRA, (int) R.color.cp_cont_a);
    }

    private void Fo(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.hRv.setImageBitmap((Bitmap) runTask.getData());
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

    private void cdk() {
        ForumData forum;
        ThemeElement themeElement;
        if (this.hNH != null && (forum = this.hNH.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.hQu.setVisibility(8);
                this.hKZ.setDefaultGradientColor();
                return;
            }
            this.hKZ.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.hQu.setVisibility(0);
            this.hQu.startLoad(themeElement.pattern_image, 10, false);
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

    public Bitmap bZk() {
        if (this.hRC == null) {
            this.hRw.buildDrawingCache();
            this.hRC = this.hRw.getDrawingCache();
        }
        return this.hRC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(Bitmap bitmap) {
        if (!cdl()) {
            vU(1);
            if (this.hRB == null) {
                this.hRB = new az(this.mPageContext);
            }
            if (this.hRD != null) {
                this.hRB.j(aq.isEmpty(this.hRD.forum_share_url) ? "http://tieba.baidu.com" : this.hRD.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.hRB.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean cdl() {
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
        if (bitmap != null && !cdl()) {
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
            vU(i2);
            ad.a(new ac<ShareItem>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: bZj */
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

    private void vU(int i) {
        TiebaStatic.log(new an("c13385").dh("fid", this.hNH.getForum().getId()).dh("uid", TbadkCoreApplication.getCurrentAccount()).ag("obj_type", i));
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
        shareItem.bbf();
        return shareItem;
    }
}

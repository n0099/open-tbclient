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
    private HeadImageView fCX;
    private LinearGradientView gKK;
    private FrsViewData gMJ;
    private TbImageView gPx;
    private TextView gQA;
    private ar gQB;
    private Bitmap gQC;
    private ForumActiveInfo gQD;
    private TextView gQl;
    private TextView gQm;
    private ImageView gQn;
    private TextView gQo;
    private TextView gQp;
    private TextView gQq;
    private TextView gQr;
    private TextView gQs;
    private TextView gQt;
    private TextView gQu;
    private ImageView gQv;
    private RelativeLayout gQw;
    private ImageOverlayView gQx;
    private HeadImageView gQy;
    private TextView gQz;
    private TextView gna;
    private BarImageView gzx;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.gMJ = frsViewData;
        this.mPageContext = tbPageContext;
        this.FR = aVar;
        this.gQD = frsViewData.getForumActiveInfo();
        initUI(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.gna.setVisibility(0);
                this.gna.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.gna.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.gzx.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.fCX.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.fCX.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.gQz.setText(frsViewData.getUserData().getName_show());
                this.gQz.setVisibility(0);
            } else {
                this.gQz.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.gQl.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.gQl.setText(frsViewData.getForum().getSlogan());
            } else {
                this.gQl.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.gQA.setVisibility(0);
                this.gQA.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.gQA.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                BT(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.gMJ.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                BT(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.gQo.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.gQo.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.gQx.setData(arrayList);
                this.gQx.setVisibility(0);
                this.gQy.setVisibility(8);
                return;
            }
            this.gQx.setVisibility(8);
            this.gQy.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.gQy.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.gQy.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.gQw = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        am.setBackgroundResource(this.gQw, R.drawable.bg_frs_private_dialog);
        this.gKK = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.gKK.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.gKK.setRoundMode(3);
        this.gPx = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.gPx.setDefaultBgResource(R.color.transparent);
        this.gPx.setDefaultResource(R.drawable.pic_frs_head_default);
        this.gPx.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.gPx.setConrers(3);
        bLK();
        this.gna = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        am.setViewTextColor(this.gna, (int) R.color.cp_cont_a);
        this.gQl = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        am.setViewTextColor(this.gQl, (int) R.color.cp_cont_f);
        this.gQn = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.gQn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.FR != null && FrsPrivateShareDialogView.this.FR.isShowing()) {
                    FrsPrivateShareDialogView.this.FR.dismiss();
                }
            }
        });
        am.setImageResource(this.gQn, R.drawable.icon_popup_shut_n);
        this.gQv = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.gzx = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.gzx.setShowOval(true);
        this.gzx.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.gzx.setStrokeColorResId(R.color.cp_bg_line_d);
        this.fCX = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.gQm = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.fCX.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fCX.setIsRound(true);
        this.fCX.setTag(null);
        am.setBackgroundResource(this.gQm, R.drawable.username_text_bg);
        this.gQo = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        am.setViewTextColor(this.gQo, (int) R.color.cp_cont_f);
        this.gQp = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.gQp, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.gQp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.y(FrsPrivateShareDialogView.this.bHW());
            }
        });
        this.gQq = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.gQq, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        this.gQq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bHW(), 3);
            }
        });
        this.gQr = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.gQr, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        this.gQr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bHW(), 2);
            }
        });
        this.gQs = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.gQs, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.gQs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bHW(), 4);
            }
        });
        this.gQt = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.gQt, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        this.gQt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bHW(), 8);
            }
        });
        this.gQu = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.gQu, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        this.gQu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bHW(), 6);
            }
        });
        this.gQx = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.gQx.k(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.gQx.setOrientation(true);
        this.gQx.setLoadImageType(12);
        this.gQx.onChangeSkinType();
        this.gQy = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.gQy.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gQy.setIsRound(true);
        this.gQz = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        am.setViewTextColor(this.gQz, (int) R.color.cp_cont_b);
        this.gQA = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        am.setViewTextColor(this.gQA, (int) R.color.cp_cont_a);
    }

    private void BT(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.gQv.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.e.a aVar) {
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

    private void bLK() {
        ForumData forum;
        ThemeElement themeElement;
        if (this.gMJ != null && (forum = this.gMJ.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.gPx.setVisibility(8);
                this.gKK.setDefaultGradientColor();
                return;
            }
            this.gKK.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.gPx.setVisibility(0);
            this.gPx.startLoad(themeElement.pattern_image, 10, false);
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

    public Bitmap bHW() {
        if (this.gQC == null) {
            this.gQw.buildDrawingCache();
            this.gQC = this.gQw.getDrawingCache();
        }
        return this.gQC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Bitmap bitmap) {
        if (!bLL()) {
            uH(1);
            if (this.gQB == null) {
                this.gQB = new ar(this.mPageContext);
            }
            if (this.gQD != null) {
                this.gQB.j(aq.isEmpty(this.gQD.forum_share_url) ? "http://tieba.baidu.com" : this.gQD.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.gQB.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean bLL() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Bitmap bitmap, final int i) {
        int i2 = 2;
        if (bitmap != null && !bLL()) {
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
                /* renamed from: bHV */
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
        TiebaStatic.log(new an("c13385").cy("fid", this.gMJ.getForum().getId()).cy("uid", TbadkCoreApplication.getCurrentAccount()).X("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem d(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.dqr = false;
        shareItem.dqq = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]@" + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + k.getUrlEncode(this.mForumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.p(bitmap);
        shareItem.aMu();
        return shareItem;
    }
}

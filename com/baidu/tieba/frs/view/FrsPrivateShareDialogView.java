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
import com.baidu.tieba.pb.pb.main.au;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import java.util.ArrayList;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes7.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a Fy;
    private Context context;
    private HeadImageView fAx;
    private LinearGradientView gIJ;
    private FrsViewData gKI;
    private TbImageView gNv;
    private Bitmap gOA;
    private ForumActiveInfo gOB;
    private TextView gOj;
    private TextView gOk;
    private ImageView gOl;
    private TextView gOm;
    private TextView gOn;
    private TextView gOo;
    private TextView gOp;
    private TextView gOq;
    private TextView gOr;
    private TextView gOs;
    private ImageView gOt;
    private RelativeLayout gOu;
    private ImageOverlayView gOv;
    private HeadImageView gOw;
    private TextView gOx;
    private TextView gOy;
    private au gOz;
    private TextView gkX;
    private BarImageView gxu;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.gKI = frsViewData;
        this.mPageContext = tbPageContext;
        this.Fy = aVar;
        this.gOB = frsViewData.getForumActiveInfo();
        initUI(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.gkX.setVisibility(0);
                this.gkX.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.gkX.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.gxu.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.fAx.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.fAx.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.gOx.setText(frsViewData.getUserData().getName_show());
                this.gOx.setVisibility(0);
            } else {
                this.gOx.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.gOj.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.gOj.setText(frsViewData.getForum().getSlogan());
            } else {
                this.gOj.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.gOy.setVisibility(0);
                this.gOy.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.gOy.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                BD(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                BD("https://tieba.baidu.com/f?kw=" + frsViewData.getForum().getName() + "&fr=frsshare");
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.gOm.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.gOm.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.gOv.setData(arrayList);
                this.gOv.setVisibility(0);
                this.gOw.setVisibility(8);
                return;
            }
            this.gOv.setVisibility(8);
            this.gOw.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.gOw.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.gOw.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.gOu = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        am.setBackgroundResource(this.gOu, R.drawable.bg_frs_private_dialog);
        this.gIJ = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.gIJ.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.gIJ.setRoundMode(3);
        this.gNv = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.gNv.setDefaultBgResource(R.color.transparent);
        this.gNv.setDefaultResource(R.drawable.pic_frs_head_default);
        this.gNv.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.gNv.setConrers(3);
        bKg();
        this.gkX = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        am.setViewTextColor(this.gkX, (int) R.color.cp_cont_a);
        this.gOj = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        am.setViewTextColor(this.gOj, (int) R.color.cp_cont_f);
        this.gOl = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.gOl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.Fy != null && FrsPrivateShareDialogView.this.Fy.isShowing()) {
                    FrsPrivateShareDialogView.this.Fy.dismiss();
                }
            }
        });
        am.setImageResource(this.gOl, R.drawable.icon_popup_shut_n);
        this.gOt = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.gxu = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.gxu.setShowOval(true);
        this.gxu.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.gxu.setStrokeColorResId(R.color.cp_bg_line_d);
        this.fAx = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.gOk = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.fAx.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fAx.setIsRound(true);
        this.fAx.setTag(null);
        am.setBackgroundResource(this.gOk, R.drawable.username_text_bg);
        this.gOm = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        am.setViewTextColor(this.gOm, (int) R.color.cp_cont_f);
        this.gOn = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.gOn, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.gOn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.y(FrsPrivateShareDialogView.this.bGs());
            }
        });
        this.gOo = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.gOo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        this.gOo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bGs(), 3);
            }
        });
        this.gOp = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.gOp, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        this.gOp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bGs(), 2);
            }
        });
        this.gOq = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.gOq, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.gOq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bGs(), 4);
            }
        });
        this.gOr = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.gOr, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        this.gOr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bGs(), 8);
            }
        });
        this.gOs = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.gOs, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        this.gOs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.c(FrsPrivateShareDialogView.this.bGs(), 6);
            }
        });
        this.gOv = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.gOv.k(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.gOv.setOrientation(true);
        this.gOv.setLoadImageType(12);
        this.gOv.onChangeSkinType();
        this.gOw = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.gOw.setDefaultBgResource(R.color.cp_bg_line_e);
        this.gOw.setIsRound(true);
        this.gOx = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        am.setViewTextColor(this.gOx, (int) R.color.cp_cont_b);
        this.gOy = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        am.setViewTextColor(this.gOy, (int) R.color.cp_cont_a);
    }

    private void BD(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.gOt.setImageBitmap((Bitmap) runTask.getData());
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

    private void bKg() {
        ForumData forum;
        ThemeElement themeElement;
        if (this.gKI != null && (forum = this.gKI.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.gNv.setVisibility(8);
                this.gIJ.setDefaultGradientColor();
                return;
            }
            this.gIJ.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.gNv.setVisibility(0);
            this.gNv.startLoad(themeElement.pattern_image, 10, false);
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

    public Bitmap bGs() {
        if (this.gOA == null) {
            this.gOu.buildDrawingCache();
            this.gOA = this.gOu.getDrawingCache();
        }
        return this.gOA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Bitmap bitmap) {
        if (!bKh()) {
            uB(1);
            if (this.gOz == null) {
                this.gOz = new au(this.mPageContext);
            }
            if (this.gOB != null) {
                this.gOz.j(aq.isEmpty(this.gOB.forum_share_url) ? "http://tieba.baidu.com" : this.gOB.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.gOz.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean bKh() {
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
        if (bitmap != null && !bKh()) {
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
            uB(i2);
            ac.a(new ab<ShareItem>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ab
                /* renamed from: bGr */
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

    private void uB(int i) {
        TiebaStatic.log(new an("c13385").cp("fid", this.gKI.getForum().getId()).cp("uid", TbadkCoreApplication.getCurrentAccount()).Z("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem d(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.dmh = false;
        shareItem.dmg = false;
        shareItem.shareType = 1;
        if (i == 6) {
            shareItem.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]@" + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + k.getUrlEncode(this.mForumName) + "&fr=frsshare";
        } else {
            shareItem.title = this.context.getString(R.string.app_name);
        }
        shareItem.content = "";
        shareItem.p(bitmap);
        shareItem.aJY();
        return shareItem;
    }
}

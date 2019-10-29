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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
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
/* loaded from: classes4.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    private Context context;
    private HeadImageView eGf;
    private BarImageView fGI;
    private LinearGradientView fSa;
    private ImageOverlayView fTI;
    private FrsViewData fTN;
    private HeadImageView fXA;
    private TextView fXB;
    private TextView fXC;
    private au fXD;
    private Bitmap fXE;
    private ForumActiveInfo fXF;
    private TextView fXp;
    private TextView fXq;
    private TextView fXr;
    private TextView fXs;
    private TextView fXt;
    private TextView fXu;
    private TextView fXv;
    private TextView fXw;
    private TextView fXx;
    private ImageView fXy;
    private RelativeLayout fXz;
    private TbImageView fap;
    private TextView fug;
    private String mForumName;
    private TbPageContext mPageContext;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.context = context;
    }

    public boolean d(FrsViewData frsViewData, TbPageContext tbPageContext) {
        this.fTN = frsViewData;
        this.mPageContext = tbPageContext;
        this.fXF = frsViewData.getForumActiveInfo();
        initUI(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.fug.setVisibility(0);
                this.fug.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.fug.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.fGI.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.eGf.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.eGf.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.fXB.setText(frsViewData.getUserData().getName_show());
                this.fXB.setVisibility(0);
            } else {
                this.fXB.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.fXp.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.fXp.setText(frsViewData.getForum().getSlogan());
            } else {
                this.fXp.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.fXC.setVisibility(0);
                this.fXC.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.fXC.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                wE(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                wE("https://tieba.baidu.com/f?kw=" + frsViewData.getForum().getName() + "&fr=frsshare");
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.fXr.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.fXr.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.fTI.setData(arrayList);
                this.fTI.setVisibility(0);
                this.fXA.setVisibility(8);
                return;
            }
            this.fTI.setVisibility(8);
            this.fXA.setVisibility(0);
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                this.fXA.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.fXA.startLoad(String.valueOf((int) R.drawable.icon_default_avatar100), 12, false);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        am.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.fXz = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        am.setBackgroundResource(this.fXz, R.drawable.bg_frs_private_dialog);
        this.fSa = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.fSa.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.fSa.setRoundMode(3);
        this.fap = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.fap.setDefaultBgResource(R.color.transparent);
        this.fap.setDefaultResource(R.drawable.pic_frs_head_default);
        this.fap.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.fap.setConrers(3);
        brE();
        this.fug = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        am.setViewTextColor(this.fug, (int) R.color.cp_cont_a);
        this.fXp = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        am.setViewTextColor(this.fXp, (int) R.color.cp_cont_f);
        this.fXy = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.fGI = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.fGI.setShowOval(true);
        this.fGI.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.fGI.setStrokeColorResId(R.color.cp_bg_line_d);
        this.eGf = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.fXq = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.eGf.setDefaultBgResource(R.color.cp_bg_line_e);
        this.eGf.setIsRound(true);
        this.eGf.setTag(null);
        am.setBackgroundResource(this.fXq, R.drawable.username_text_bg);
        this.fXr = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        am.setViewTextColor(this.fXr, (int) R.color.cp_cont_f);
        this.fXs = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.fXs, new com.baidu.tbadk.core.util.f.c(R.drawable.icon_share_download_n_svg));
        this.fXs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.y(FrsPrivateShareDialogView.this.bnV());
            }
        });
        this.fXt = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.fXt, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_wechat_n_svg));
        this.fXt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.b(FrsPrivateShareDialogView.this.bnV(), 3);
            }
        });
        this.fXu = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.fXu, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_circle_n_svg));
        this.fXu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.b(FrsPrivateShareDialogView.this.bnV(), 2);
            }
        });
        this.fXv = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.fXv, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qqzone_n_svg));
        this.fXv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.b(FrsPrivateShareDialogView.this.bnV(), 4);
            }
        });
        this.fXw = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.fXw, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_qq_n_svg));
        this.fXw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.b(FrsPrivateShareDialogView.this.bnV(), 8);
            }
        });
        this.fXx = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.fXx, new com.baidu.tbadk.core.util.f.b(R.drawable.icon_mask_share_weibo_n_svg));
        this.fXx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsPrivateShareDialogView.this.b(FrsPrivateShareDialogView.this.bnV(), 6);
            }
        });
        this.fTI = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.fTI.j(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.fTI.setOrientation(true);
        this.fTI.setLoadImageType(12);
        this.fTI.onChangeSkinType();
        this.fXA = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.fXA.setDefaultBgResource(R.color.cp_bg_line_e);
        this.fXA.setIsRound(true);
        this.fXB = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        am.setViewTextColor(this.fXB, (int) R.color.cp_cont_b);
        this.fXC = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        am.setViewTextColor(this.fXC, (int) R.color.cp_cont_a);
    }

    private void wE(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.fXy.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.f.a aVar) {
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

    private void brE() {
        ThemeElement themeElement;
        if (this.fTN != null && this.fTN.getForum() != null) {
            ThemeColorInfo themeColorInfo = this.fTN.getForum().getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.night == null || themeColorInfo.day == null) {
                this.fap.setVisibility(8);
                this.fSa.setDefaultGradientColor();
                return;
            }
            this.fap.setVisibility(0);
            ThemeElement themeElement2 = themeColorInfo.night;
            ThemeElement themeElement3 = themeColorInfo.day;
            this.fSa.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            this.fap.startLoad(themeElement.pattern_image, 10, false);
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

    public Bitmap bnV() {
        if (this.fXE == null) {
            this.fXz.buildDrawingCache();
            this.fXE = this.fXz.getDrawingCache();
        }
        return this.fXE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(Bitmap bitmap) {
        if (!brF()) {
            sp(1);
            if (this.fXD == null) {
                this.fXD = new au(this.mPageContext);
            }
            if (this.fXF != null) {
                this.fXD.g(aq.isEmpty(this.fXF.forum_share_url) ? "http://tieba.baidu.com" : this.fXF.forum_share_url, BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.fXD.g("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
        }
    }

    private boolean brF() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Bitmap bitmap, final int i) {
        int i2 = 2;
        if (bitmap != null && !brF()) {
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
            sp(i2);
            z.a(new y<com.baidu.tbadk.coreExtra.c.e>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.y
                /* renamed from: bnU */
                public com.baidu.tbadk.coreExtra.c.e doInBackground() {
                    return FrsPrivateShareDialogView.this.c(bitmap, i);
                }
            }, new j<com.baidu.tbadk.coreExtra.c.e>() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.j
                /* renamed from: l */
                public void onReturnDataInUI(com.baidu.tbadk.coreExtra.c.e eVar) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(FrsPrivateShareDialogView.this.context, i, eVar, false));
                }
            });
        }
    }

    private void sp(int i) {
        TiebaStatic.log(new an("c13385").bS("fid", this.fTN.getForum().getId()).bS("uid", TbadkCoreApplication.getCurrentAccount()).O("obj_type", i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.coreExtra.c.e c(Bitmap bitmap, int i) {
        com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
        eVar.cyZ = false;
        eVar.cyY = false;
        eVar.shareType = 1;
        if (i == 6) {
            eVar.title = this.context.getString(R.string.come_on_look_forum) + "[" + this.mForumName + this.context.getString(R.string.core_bar) + "]@" + this.context.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + k.getUrlEncode(this.mForumName) + "&fr=frsshare";
        } else {
            eVar.title = this.context.getString(R.string.app_name);
        }
        eVar.content = "";
        eVar.p(bitmap);
        eVar.ash();
        return eVar;
    }
}

package com.baidu.tieba.frs.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import java.net.URLEncoder;
import java.util.ArrayList;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes21.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a aaV;
    private Context context;
    private ImageView dWj;
    private ImageView dWr;
    private TextView hYu;
    private HeadImageView hjQ;
    private FrsViewData iCD;
    private TbImageView iFv;
    private TextView iGB;
    private TextView iGC;
    private TextView iGD;
    private RelativeLayout iGE;
    private ImageOverlayView iGF;
    private HeadImageView iGG;
    private TextView iGH;
    private TextView iGI;
    private ForumActiveInfo iGJ;
    private ac.b ieh;
    private ac ifB;
    private BarImageView ioj;
    private LinearGradientView izP;
    private String mForumName;
    private TbPageContext mPageContext;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.ieh = new ac.b() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // com.baidu.tieba.frs.ac.b
            public void xM(int i) {
                FrsPrivateShareDialogView.this.zK(i);
            }
        };
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.iCD = frsViewData;
        this.mPageContext = tbPageContext;
        this.aaV = aVar;
        this.iGJ = frsViewData.getForumActiveInfo();
        initUI(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.hYu.setVisibility(0);
                this.hYu.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.hYu.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.ioj.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.hjQ.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.hjQ.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.iGH.setText(frsViewData.getUserData().getName_show());
                this.iGH.setVisibility(0);
            } else {
                this.iGH.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.iGB.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.iGB.setText(frsViewData.getForum().getSlogan());
            } else {
                this.iGB.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.iGI.setVisibility(0);
                this.iGI.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.iGI.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                zg(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.iCD.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                zg(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.iGD.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.iGD.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.iGF.setData(arrayList);
                this.iGF.setVisibility(0);
                this.iGG.setVisibility(8);
            } else {
                this.iGF.setVisibility(8);
                this.iGG.setVisibility(0);
                if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                    this.iGG.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
                } else {
                    this.iGG.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
                }
            }
            if (this.ifB != null && this.iGJ != null) {
                this.ifB.setData(at.isEmpty(this.iGJ.forum_share_url) ? "http://tieba.baidu.com" : this.iGJ.forum_share_url, this.mForumName);
                this.ifB.setFrom(1);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.iGE = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        ap.setBackgroundResource(this.iGE, R.drawable.bg_frs_private_dialog);
        this.izP = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.izP.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.izP.setRoundMode(3);
        this.iFv = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.iFv.setDefaultBgResource(R.color.transparent);
        this.iFv.setDefaultResource(R.drawable.pic_frs_head_default);
        this.iFv.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.iFv.setConrers(3);
        cyg();
        this.hYu = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        ap.setViewTextColor(this.hYu, R.color.cp_cont_a);
        this.iGB = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        ap.setViewTextColor(this.iGB, R.color.cp_cont_f);
        this.dWr = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.dWr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.aaV != null && FrsPrivateShareDialogView.this.aaV.isShowing()) {
                    FrsPrivateShareDialogView.this.aaV.dismiss();
                }
            }
        });
        ap.setImageResource(this.dWr, R.drawable.icon_popup_shut_n);
        this.dWj = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.ioj = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.ioj.setShowOval(true);
        this.ioj.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.ioj.setStrokeColorResId(R.color.cp_bg_line_d);
        this.hjQ = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.iGC = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.hjQ.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hjQ.setIsRound(true);
        this.hjQ.setTag(null);
        ap.setBackgroundResource(this.iGC, R.drawable.username_text_bg);
        this.iGD = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        ap.setViewTextColor(this.iGD, R.color.cp_cont_f);
        if (this.ifB == null) {
            this.ifB = new ac(this.mPageContext);
            this.ifB.a(this.mRootView, this.iGE, (ac.a) null);
            this.ifB.a(this.ieh);
        }
        this.iGF = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.iGF.j(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.iGF.setOrientation(true);
        this.iGF.setLoadImageType(12);
        this.iGF.onChangeSkinType();
        this.iGG = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.iGG.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iGG.setIsRound(true);
        this.iGH = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        ap.setViewTextColor(this.iGH, R.color.cp_cont_b);
        this.iGI = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        ap.setViewTextColor(this.iGI, R.color.cp_cont_a);
    }

    private void zg(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.dWj.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void cyg() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.iCD != null && (forum = this.iCD.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.iFv.setVisibility(8);
                this.izP.setDefaultGradientColor();
                return;
            }
            this.izP.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.iCD.getStar() != null && !StringUtils.isNull(this.iCD.getStar().dzR())) {
                str = this.iCD.getStar().dzR();
            } else {
                str = themeElement.pattern_image;
            }
            this.iFv.setVisibility(0);
            this.iFv.startLoad(str, 10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zK(int i) {
        TiebaStatic.log(new aq("c13385").dF("fid", this.iCD.getForum().getId()).dF("uid", TbadkCoreApplication.getCurrentAccount()).ai("obj_type", i));
    }
}

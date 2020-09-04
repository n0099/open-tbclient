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
/* loaded from: classes16.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a aaD;
    private Context context;
    private ImageView dTZ;
    private ImageView dUh;
    private TextView hRu;
    private ac.b hXd;
    private ac hYx;
    private HeadImageView hcR;
    private BarImageView ihh;
    private LinearGradientView isz;
    private FrsViewData ivh;
    private TbImageView ixZ;
    private TextView izg;
    private TextView izh;
    private TextView izi;
    private RelativeLayout izj;
    private ImageOverlayView izk;
    private HeadImageView izl;
    private TextView izm;
    private TextView izn;
    private ForumActiveInfo izo;
    private String mForumName;
    private TbPageContext mPageContext;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.hXd = new ac.b() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // com.baidu.tieba.frs.ac.b
            public void xn(int i) {
                FrsPrivateShareDialogView.this.zm(i);
            }
        };
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.ivh = frsViewData;
        this.mPageContext = tbPageContext;
        this.aaD = aVar;
        this.izo = frsViewData.getForumActiveInfo();
        initUI(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.hRu.setVisibility(0);
                this.hRu.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.hRu.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.ihh.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.hcR.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.hcR.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.izm.setText(frsViewData.getUserData().getName_show());
                this.izm.setVisibility(0);
            } else {
                this.izm.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.izg.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.izg.setText(frsViewData.getForum().getSlogan());
            } else {
                this.izg.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.izn.setVisibility(0);
                this.izn.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.izn.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                yL(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.ivh.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                yL(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.izi.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.izi.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.izk.setData(arrayList);
                this.izk.setVisibility(0);
                this.izl.setVisibility(8);
            } else {
                this.izk.setVisibility(8);
                this.izl.setVisibility(0);
                if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                    this.izl.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
                } else {
                    this.izl.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
                }
            }
            if (this.hYx != null && this.izo != null) {
                this.hYx.setData(at.isEmpty(this.izo.forum_share_url) ? "http://tieba.baidu.com" : this.izo.forum_share_url, this.mForumName);
                this.hYx.setFrom(1);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.izj = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        ap.setBackgroundResource(this.izj, R.drawable.bg_frs_private_dialog);
        this.isz = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.isz.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.isz.setRoundMode(3);
        this.ixZ = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.ixZ.setDefaultBgResource(R.color.transparent);
        this.ixZ.setDefaultResource(R.drawable.pic_frs_head_default);
        this.ixZ.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.ixZ.setConrers(3);
        cuN();
        this.hRu = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        ap.setViewTextColor(this.hRu, R.color.cp_cont_a);
        this.izg = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        ap.setViewTextColor(this.izg, R.color.cp_cont_f);
        this.dUh = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.dUh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.aaD != null && FrsPrivateShareDialogView.this.aaD.isShowing()) {
                    FrsPrivateShareDialogView.this.aaD.dismiss();
                }
            }
        });
        ap.setImageResource(this.dUh, R.drawable.icon_popup_shut_n);
        this.dTZ = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.ihh = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.ihh.setShowOval(true);
        this.ihh.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.ihh.setStrokeColorResId(R.color.cp_bg_line_d);
        this.hcR = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.izh = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.hcR.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hcR.setIsRound(true);
        this.hcR.setTag(null);
        ap.setBackgroundResource(this.izh, R.drawable.username_text_bg);
        this.izi = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        ap.setViewTextColor(this.izi, R.color.cp_cont_f);
        if (this.hYx == null) {
            this.hYx = new ac(this.mPageContext);
            this.hYx.a(this.mRootView, this.izj, (ac.a) null);
            this.hYx.a(this.hXd);
        }
        this.izk = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.izk.j(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.izk.setOrientation(true);
        this.izk.setLoadImageType(12);
        this.izk.onChangeSkinType();
        this.izl = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.izl.setDefaultBgResource(R.color.cp_bg_line_e);
        this.izl.setIsRound(true);
        this.izm = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        ap.setViewTextColor(this.izm, R.color.cp_cont_b);
        this.izn = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        ap.setViewTextColor(this.izn, R.color.cp_cont_a);
    }

    private void yL(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.dTZ.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void cuN() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.ivh != null && (forum = this.ivh.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.ixZ.setVisibility(8);
                this.isz.setDefaultGradientColor();
                return;
            }
            this.isz.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.ivh.getStar() != null && !StringUtils.isNull(this.ivh.getStar().dvY())) {
                str = this.ivh.getStar().dvY();
            } else {
                str = themeElement.pattern_image;
            }
            this.ixZ.setVisibility(0);
            this.ixZ.startLoad(str, 10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zm(int i) {
        TiebaStatic.log(new aq("c13385").dD("fid", this.ivh.getForum().getId()).dD("uid", TbadkCoreApplication.getCurrentAccount()).ai("obj_type", i));
    }
}

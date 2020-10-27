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
/* loaded from: classes22.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a abn;
    private Context context;
    private ImageView eqJ;
    private ImageView eqR;
    private HeadImageView hLh;
    private ac.b iFA;
    private ac iGU;
    private BarImageView iPy;
    private TextView izR;
    private LinearGradientView jbe;
    private FrsViewData jdP;
    private TbImageView jgH;
    private TextView jhN;
    private TextView jhO;
    private TextView jhP;
    private RelativeLayout jhQ;
    private ImageOverlayView jhR;
    private HeadImageView jhS;
    private TextView jhT;
    private TextView jhU;
    private ForumActiveInfo jhV;
    private String mForumName;
    private TbPageContext mPageContext;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.iFA = new ac.b() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // com.baidu.tieba.frs.ac.b
            public void yL(int i) {
                FrsPrivateShareDialogView.this.AJ(i);
            }
        };
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.jdP = frsViewData;
        this.mPageContext = tbPageContext;
        this.abn = aVar;
        this.jhV = frsViewData.getForumActiveInfo();
        initUI(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.izR.setVisibility(0);
                this.izR.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.izR.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.iPy.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.hLh.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.hLh.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.jhT.setText(frsViewData.getUserData().getName_show());
                this.jhT.setVisibility(0);
            } else {
                this.jhT.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.jhN.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.jhN.setText(frsViewData.getForum().getSlogan());
            } else {
                this.jhN.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.jhU.setVisibility(0);
                this.jhU.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.jhU.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                Al(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.jdP.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                Al(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.jhP.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.jhP.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.jhR.setData(arrayList);
                this.jhR.setVisibility(0);
                this.jhS.setVisibility(8);
            } else {
                this.jhR.setVisibility(8);
                this.jhS.setVisibility(0);
                if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                    this.jhS.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
                } else {
                    this.jhS.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
                }
            }
            if (this.iGU != null && this.jhV != null) {
                this.iGU.setData(at.isEmpty(this.jhV.forum_share_url) ? "http://tieba.baidu.com" : this.jhV.forum_share_url, this.mForumName);
                this.iGU.setFrom(1);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.jhQ = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        ap.setBackgroundResource(this.jhQ, R.drawable.bg_frs_private_dialog);
        this.jbe = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.jbe.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.jbe.setRoundMode(3);
        this.jgH = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.jgH.setDefaultBgResource(R.color.transparent);
        this.jgH.setDefaultResource(R.drawable.pic_frs_head_default);
        this.jgH.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.jgH.setConrers(3);
        cEK();
        this.izR = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        ap.setViewTextColor(this.izR, R.color.cp_cont_a);
        this.jhN = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        ap.setViewTextColor(this.jhN, R.color.cp_cont_f);
        this.eqR = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.eqR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.abn != null && FrsPrivateShareDialogView.this.abn.isShowing()) {
                    FrsPrivateShareDialogView.this.abn.dismiss();
                }
            }
        });
        ap.setImageResource(this.eqR, R.drawable.icon_popup_shut_n);
        this.eqJ = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.iPy = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.iPy.setShowOval(true);
        this.iPy.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.iPy.setStrokeColorResId(R.color.cp_bg_line_d);
        this.hLh = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.jhO = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.hLh.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hLh.setIsRound(true);
        this.hLh.setTag(null);
        ap.setBackgroundResource(this.jhO, R.drawable.username_text_bg);
        this.jhP = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        ap.setViewTextColor(this.jhP, R.color.cp_cont_f);
        if (this.iGU == null) {
            this.iGU = new ac(this.mPageContext);
            this.iGU.a(this.mRootView, this.jhQ, (ac.a) null);
            this.iGU.a(this.iFA);
        }
        this.jhR = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.jhR.j(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.jhR.setOrientation(true);
        this.jhR.setLoadImageType(12);
        this.jhR.onChangeSkinType();
        this.jhS = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.jhS.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jhS.setIsRound(true);
        this.jhT = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        ap.setViewTextColor(this.jhT, R.color.cp_cont_b);
        this.jhU = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        ap.setViewTextColor(this.jhU, R.color.cp_cont_a);
    }

    private void Al(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eqJ.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void cEK() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.jdP != null && (forum = this.jdP.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.jgH.setVisibility(8);
                this.jbe.setDefaultGradientColor();
                return;
            }
            this.jbe.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.jdP.getStar() != null && !StringUtils.isNull(this.jdP.getStar().dGK())) {
                str = this.jdP.getStar().dGK();
            } else {
                str = themeElement.pattern_image;
            }
            this.jgH.setVisibility(0);
            this.jgH.startLoad(str, 10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AJ(int i) {
        TiebaStatic.log(new aq("c13385").dR("fid", this.jdP.getForum().getId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).aj("obj_type", i));
    }
}

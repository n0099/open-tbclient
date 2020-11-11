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
    private ImageView ewC;
    private ImageView ewK;
    private HeadImageView hRe;
    private TextView iFO;
    private ac.b iLx;
    private ac iMR;
    private BarImageView iVv;
    private LinearGradientView jhb;
    private FrsViewData jjN;
    private TbImageView jmG;
    private TextView jnM;
    private TextView jnN;
    private TextView jnO;
    private RelativeLayout jnP;
    private ImageOverlayView jnQ;
    private HeadImageView jnR;
    private TextView jnS;
    private TextView jnT;
    private ForumActiveInfo jnU;
    private String mForumName;
    private TbPageContext mPageContext;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.iLx = new ac.b() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // com.baidu.tieba.frs.ac.b
            public void yY(int i) {
                FrsPrivateShareDialogView.this.AW(i);
            }
        };
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.jjN = frsViewData;
        this.mPageContext = tbPageContext;
        this.abn = aVar;
        this.jnU = frsViewData.getForumActiveInfo();
        initUI(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.iFO.setVisibility(0);
                this.iFO.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.iFO.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.iVv.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.hRe.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.hRe.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.jnS.setText(frsViewData.getUserData().getName_show());
                this.jnS.setVisibility(0);
            } else {
                this.jnS.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.jnM.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.jnM.setText(frsViewData.getForum().getSlogan());
            } else {
                this.jnM.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.jnT.setVisibility(0);
                this.jnT.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.jnT.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                Az(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.jjN.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                Az(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.jnO.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.jnO.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.jnQ.setData(arrayList);
                this.jnQ.setVisibility(0);
                this.jnR.setVisibility(8);
            } else {
                this.jnQ.setVisibility(8);
                this.jnR.setVisibility(0);
                if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                    this.jnR.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
                } else {
                    this.jnR.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
                }
            }
            if (this.iMR != null && this.jnU != null) {
                this.iMR.setData(at.isEmpty(this.jnU.forum_share_url) ? "http://tieba.baidu.com" : this.jnU.forum_share_url, this.mForumName);
                this.iMR.setFrom(1);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.jnP = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        ap.setBackgroundResource(this.jnP, R.drawable.bg_frs_private_dialog);
        this.jhb = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.jhb.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.jhb.setRoundMode(3);
        this.jmG = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.jmG.setDefaultBgResource(R.color.transparent);
        this.jmG.setDefaultResource(R.drawable.pic_frs_head_default);
        this.jmG.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.jmG.setConrers(3);
        cHl();
        this.iFO = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        ap.setViewTextColor(this.iFO, R.color.cp_cont_a);
        this.jnM = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        ap.setViewTextColor(this.jnM, R.color.cp_cont_f);
        this.ewK = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.ewK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.abn != null && FrsPrivateShareDialogView.this.abn.isShowing()) {
                    FrsPrivateShareDialogView.this.abn.dismiss();
                }
            }
        });
        ap.setImageResource(this.ewK, R.drawable.icon_popup_shut_n);
        this.ewC = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.iVv = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.iVv.setShowOval(true);
        this.iVv.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.iVv.setStrokeColorResId(R.color.cp_bg_line_d);
        this.hRe = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.jnN = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.hRe.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hRe.setIsRound(true);
        this.hRe.setTag(null);
        ap.setBackgroundResource(this.jnN, R.drawable.username_text_bg);
        this.jnO = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        ap.setViewTextColor(this.jnO, R.color.cp_cont_f);
        if (this.iMR == null) {
            this.iMR = new ac(this.mPageContext);
            this.iMR.a(this.mRootView, this.jnP, (ac.a) null);
            this.iMR.a(this.iLx);
        }
        this.jnQ = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.jnQ.j(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.jnQ.setOrientation(true);
        this.jnQ.setLoadImageType(12);
        this.jnQ.onChangeSkinType();
        this.jnR = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.jnR.setDefaultBgResource(R.color.cp_bg_line_e);
        this.jnR.setIsRound(true);
        this.jnS = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        ap.setViewTextColor(this.jnS, R.color.cp_cont_b);
        this.jnT = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        ap.setViewTextColor(this.jnT, R.color.cp_cont_a);
    }

    private void Az(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.ewC.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void cHl() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.jjN != null && (forum = this.jjN.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.jmG.setVisibility(8);
                this.jhb.setDefaultGradientColor();
                return;
            }
            this.jhb.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.jjN.getStar() != null && !StringUtils.isNull(this.jjN.getStar().dJm())) {
                str = this.jjN.getStar().dJm();
            } else {
                str = themeElement.pattern_image;
            }
            this.jmG.setVisibility(0);
            this.jmG.startLoad(str, 10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AW(int i) {
        TiebaStatic.log(new aq("c13385").dR("fid", this.jjN.getForum().getId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_type", i));
    }
}

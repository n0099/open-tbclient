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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import java.net.URLEncoder;
import java.util.ArrayList;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes2.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a aeo;
    private Context context;
    private ImageView eKC;
    private ImageView eKu;
    private HeadImageView irV;
    private FrsViewData jIs;
    private LinearGradientView jKH;
    private TbImageView jRH;
    private TextView jSS;
    private TextView jST;
    private TextView jSU;
    private RelativeLayout jSV;
    private ImageOverlayView jSW;
    private HeadImageView jSX;
    private TextView jSY;
    private TextView jSZ;
    private ForumActiveInfo jTa;
    private TextView jgF;
    private y.b jmm;
    private y jnI;
    private BarImageView jze;
    private String mForumName;
    private TbPageContext mPageContext;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.jmm = new y.b() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // com.baidu.tieba.frs.y.b
            public void yS(int i) {
                FrsPrivateShareDialogView.this.Bf(i);
            }
        };
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.jIs = frsViewData;
        this.mPageContext = tbPageContext;
        this.aeo = aVar;
        this.jTa = frsViewData.getForumActiveInfo();
        initUI(this.context);
        o(frsViewData);
        return true;
    }

    private void o(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.jgF.setVisibility(0);
                this.jgF.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.jgF.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.jze.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.irV.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.irV.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.jSY.setText(frsViewData.getUserData().getName_show());
                this.jSY.setVisibility(0);
            } else {
                this.jSY.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.jSS.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.jSS.setText(frsViewData.getForum().getSlogan());
            } else {
                this.jSS.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.jSZ.setVisibility(0);
                this.jSZ.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.jSZ.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                zM(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.jIs.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                zM(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.jSU.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.jSU.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.jSW.setData(arrayList);
                this.jSW.setVisibility(0);
                this.jSX.setVisibility(8);
            } else {
                this.jSW.setVisibility(8);
                this.jSX.setVisibility(0);
                if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                    this.jSX.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
                } else {
                    this.jSX.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
                }
            }
            if (this.jnI != null && this.jTa != null) {
                this.jnI.setData(au.isEmpty(this.jTa.forum_share_url) ? "http://tieba.baidu.com" : this.jTa.forum_share_url, this.mForumName);
                this.jnI.setFrom(1);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.jSV = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        ap.setBackgroundResource(this.jSV, R.drawable.bg_frs_private_dialog);
        this.jKH = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.jKH.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.jKH.setRoundMode(3);
        this.jRH = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.jRH.setDefaultBgResource(R.color.transparent);
        this.jRH.setDefaultResource(R.drawable.pic_frs_head_default);
        this.jRH.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.jRH.setConrers(3);
        cNt();
        this.jgF = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        ap.setViewTextColor(this.jgF, R.color.CAM_X0101);
        this.jSS = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        ap.setViewTextColor(this.jSS, R.color.CAM_X0106);
        this.eKC = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.eKC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.aeo != null && FrsPrivateShareDialogView.this.aeo.isShowing()) {
                    FrsPrivateShareDialogView.this.aeo.dismiss();
                }
            }
        });
        ap.setImageResource(this.eKC, R.drawable.icon_popup_shut_n);
        this.eKu = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.jze = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.jze.setShowOval(true);
        this.jze.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.jze.setStrokeColorResId(R.color.CAM_X0201);
        this.irV = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.jST = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.irV.setDefaultBgResource(R.color.CAM_X0205);
        this.irV.setIsRound(true);
        this.irV.setTag(null);
        ap.setBackgroundResource(this.jST, R.drawable.username_text_bg);
        this.jSU = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        ap.setViewTextColor(this.jSU, R.color.CAM_X0106);
        if (this.jnI == null) {
            this.jnI = new y(this.mPageContext);
            this.jnI.a(this.mRootView, this.jSV, (y.a) null);
            this.jnI.a(this.jmm);
        }
        this.jSW = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.jSW.l(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.jSW.setOrientation(true);
        this.jSW.setLoadImageType(12);
        this.jSW.onChangeSkinType();
        this.jSX = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.jSX.setDefaultBgResource(R.color.CAM_X0205);
        this.jSX.setIsRound(true);
        this.jSY = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        ap.setViewTextColor(this.jSY, R.color.CAM_X0105);
        this.jSZ = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        ap.setViewTextColor(this.jSZ, R.color.CAM_X0101);
    }

    private void zM(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eKu.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void cNt() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.jIs != null && (forum = this.jIs.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.jRH.setVisibility(8);
                this.jKH.setDefaultGradientColor();
                return;
            }
            this.jKH.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.jIs.getStar() != null && !StringUtils.isNull(this.jIs.getStar().dMW())) {
                str = this.jIs.getStar().dMW();
            } else {
                str = themeElement.pattern_image;
            }
            this.jRH.setVisibility(0);
            this.jRH.startLoad(str, 10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bf(int i) {
        TiebaStatic.log(new ar("c13385").dR("fid", this.jIs.getForum().getId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).aq("obj_type", i));
    }
}

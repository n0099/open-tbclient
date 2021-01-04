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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
    private com.baidu.tbadk.core.dialog.a adc;
    private Context context;
    private ImageView eLG;
    private ImageView eLy;
    private HeadImageView ioZ;
    private FrsViewData jFx;
    private LinearGradientView jHM;
    private TbImageView jNt;
    private TextView jOE;
    private TextView jOF;
    private TextView jOG;
    private RelativeLayout jOH;
    private ImageOverlayView jOI;
    private HeadImageView jOJ;
    private TextView jOK;
    private TextView jOL;
    private ForumActiveInfo jOM;
    private TextView jdI;
    private y.b jjq;
    private y jkK;
    private BarImageView jwh;
    private String mForumName;
    private TbPageContext mPageContext;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.jjq = new y.b() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // com.baidu.tieba.frs.y.b
            public void An(int i) {
                FrsPrivateShareDialogView.this.Cv(i);
            }
        };
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.jFx = frsViewData;
        this.mPageContext = tbPageContext;
        this.adc = aVar;
        this.jOM = frsViewData.getForumActiveInfo();
        initUI(this.context);
        o(frsViewData);
        return true;
    }

    private void o(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.jdI.setVisibility(0);
                this.jdI.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.jdI.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.jwh.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.ioZ.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.ioZ.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.jOK.setText(frsViewData.getUserData().getName_show());
                this.jOK.setVisibility(0);
            } else {
                this.jOK.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.jOE.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.jOE.setText(frsViewData.getForum().getSlogan());
            } else {
                this.jOE.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.jOL.setVisibility(0);
                this.jOL.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.jOL.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                Az(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.jFx.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                Az(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.jOG.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.jOG.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.jOI.setData(arrayList);
                this.jOI.setVisibility(0);
                this.jOJ.setVisibility(8);
            } else {
                this.jOI.setVisibility(8);
                this.jOJ.setVisibility(0);
                if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                    this.jOJ.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
                } else {
                    this.jOJ.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
                }
            }
            if (this.jkK != null && this.jOM != null) {
                this.jkK.setData(at.isEmpty(this.jOM.forum_share_url) ? "http://tieba.baidu.com" : this.jOM.forum_share_url, this.mForumName);
                this.jkK.setFrom(1);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.jOH = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        ao.setBackgroundResource(this.jOH, R.drawable.bg_frs_private_dialog);
        this.jHM = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.jHM.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.jHM.setRoundMode(3);
        this.jNt = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.jNt.setDefaultBgResource(R.color.transparent);
        this.jNt.setDefaultResource(R.drawable.pic_frs_head_default);
        this.jNt.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.jNt.setConrers(3);
        cPj();
        this.jdI = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        ao.setViewTextColor(this.jdI, R.color.CAM_X0101);
        this.jOE = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        ao.setViewTextColor(this.jOE, R.color.CAM_X0106);
        this.eLG = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.eLG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.adc != null && FrsPrivateShareDialogView.this.adc.isShowing()) {
                    FrsPrivateShareDialogView.this.adc.dismiss();
                }
            }
        });
        ao.setImageResource(this.eLG, R.drawable.icon_popup_shut_n);
        this.eLy = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.jwh = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.jwh.setShowOval(true);
        this.jwh.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.jwh.setStrokeColorResId(R.color.CAM_X0201);
        this.ioZ = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.jOF = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.ioZ.setDefaultBgResource(R.color.CAM_X0205);
        this.ioZ.setIsRound(true);
        this.ioZ.setTag(null);
        ao.setBackgroundResource(this.jOF, R.drawable.username_text_bg);
        this.jOG = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        ao.setViewTextColor(this.jOG, R.color.CAM_X0106);
        if (this.jkK == null) {
            this.jkK = new y(this.mPageContext);
            this.jkK.a(this.mRootView, this.jOH, (y.a) null);
            this.jkK.a(this.jjq);
        }
        this.jOI = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.jOI.k(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.jOI.setOrientation(true);
        this.jOI.setLoadImageType(12);
        this.jOI.onChangeSkinType();
        this.jOJ = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.jOJ.setDefaultBgResource(R.color.CAM_X0205);
        this.jOJ.setIsRound(true);
        this.jOK = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        ao.setViewTextColor(this.jOK, R.color.CAM_X0105);
        this.jOL = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        ao.setViewTextColor(this.jOL, R.color.CAM_X0101);
    }

    private void Az(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eLy.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void cPj() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.jFx != null && (forum = this.jFx.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.jNt.setVisibility(8);
                this.jHM.setDefaultGradientColor();
                return;
            }
            this.jHM.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.jFx.getStar() != null && !StringUtils.isNull(this.jFx.getStar().dOm())) {
                str = this.jFx.getStar().dOm();
            } else {
                str = themeElement.pattern_image;
            }
            this.jNt.setVisibility(0);
            this.jNt.startLoad(str, 10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cv(int i) {
        TiebaStatic.log(new aq("c13385").dX("fid", this.jFx.getForum().getId()).dX("uid", TbadkCoreApplication.getCurrentAccount()).an("obj_type", i));
    }
}

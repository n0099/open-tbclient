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
    private com.baidu.tbadk.core.dialog.a acU;
    private Context context;
    private ImageView eIT;
    private ImageView eJb;
    private HeadImageView ipY;
    private FrsViewData jGv;
    private LinearGradientView jIK;
    private TbImageView jPK;
    private TextView jQV;
    private TextView jQW;
    private TextView jQX;
    private RelativeLayout jQY;
    private ImageOverlayView jQZ;
    private HeadImageView jRa;
    private TextView jRb;
    private TextView jRc;
    private ForumActiveInfo jRd;
    private TextView jeI;
    private y.b jkp;
    private y jlK;
    private BarImageView jxh;
    private String mForumName;
    private TbPageContext mPageContext;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.jkp = new y.b() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // com.baidu.tieba.frs.y.b
            public void yR(int i) {
                FrsPrivateShareDialogView.this.Be(i);
            }
        };
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.jGv = frsViewData;
        this.mPageContext = tbPageContext;
        this.acU = aVar;
        this.jRd = frsViewData.getForumActiveInfo();
        initUI(this.context);
        o(frsViewData);
        return true;
    }

    private void o(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.jeI.setVisibility(0);
                this.jeI.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.jeI.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.jxh.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.ipY.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.ipY.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.jRb.setText(frsViewData.getUserData().getName_show());
                this.jRb.setVisibility(0);
            } else {
                this.jRb.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.jQV.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.jQV.setText(frsViewData.getForum().getSlogan());
            } else {
                this.jQV.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.jRc.setVisibility(0);
                this.jRc.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.jRc.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                zF(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.jGv.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                zF(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.jQX.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.jQX.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.jQZ.setData(arrayList);
                this.jQZ.setVisibility(0);
                this.jRa.setVisibility(8);
            } else {
                this.jQZ.setVisibility(8);
                this.jRa.setVisibility(0);
                if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                    this.jRa.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
                } else {
                    this.jRa.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
                }
            }
            if (this.jlK != null && this.jRd != null) {
                this.jlK.setData(au.isEmpty(this.jRd.forum_share_url) ? "http://tieba.baidu.com" : this.jRd.forum_share_url, this.mForumName);
                this.jlK.setFrom(1);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.jQY = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        ap.setBackgroundResource(this.jQY, R.drawable.bg_frs_private_dialog);
        this.jIK = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.jIK.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.jIK.setRoundMode(3);
        this.jPK = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.jPK.setDefaultBgResource(R.color.transparent);
        this.jPK.setDefaultResource(R.drawable.pic_frs_head_default);
        this.jPK.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.jPK.setConrers(3);
        cNg();
        this.jeI = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        ap.setViewTextColor(this.jeI, R.color.CAM_X0101);
        this.jQV = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        ap.setViewTextColor(this.jQV, R.color.CAM_X0106);
        this.eJb = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.eJb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.acU != null && FrsPrivateShareDialogView.this.acU.isShowing()) {
                    FrsPrivateShareDialogView.this.acU.dismiss();
                }
            }
        });
        ap.setImageResource(this.eJb, R.drawable.icon_popup_shut_n);
        this.eIT = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.jxh = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.jxh.setShowOval(true);
        this.jxh.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.jxh.setStrokeColorResId(R.color.CAM_X0201);
        this.ipY = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.jQW = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.ipY.setDefaultBgResource(R.color.CAM_X0205);
        this.ipY.setIsRound(true);
        this.ipY.setTag(null);
        ap.setBackgroundResource(this.jQW, R.drawable.username_text_bg);
        this.jQX = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        ap.setViewTextColor(this.jQX, R.color.CAM_X0106);
        if (this.jlK == null) {
            this.jlK = new y(this.mPageContext);
            this.jlK.a(this.mRootView, this.jQY, (y.a) null);
            this.jlK.a(this.jkp);
        }
        this.jQZ = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.jQZ.l(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.jQZ.setOrientation(true);
        this.jQZ.setLoadImageType(12);
        this.jQZ.onChangeSkinType();
        this.jRa = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.jRa.setDefaultBgResource(R.color.CAM_X0205);
        this.jRa.setIsRound(true);
        this.jRb = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        ap.setViewTextColor(this.jRb, R.color.CAM_X0105);
        this.jRc = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        ap.setViewTextColor(this.jRc, R.color.CAM_X0101);
    }

    private void zF(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eIT.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void cNg() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.jGv != null && (forum = this.jGv.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.jPK.setVisibility(8);
                this.jIK.setDefaultGradientColor();
                return;
            }
            this.jIK.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.jGv.getStar() != null && !StringUtils.isNull(this.jGv.getStar().dMG())) {
                str = this.jGv.getStar().dMG();
            } else {
                str = themeElement.pattern_image;
            }
            this.jPK.setVisibility(0);
            this.jPK.startLoad(str, 10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Be(int i) {
        TiebaStatic.log(new ar("c13385").dR("fid", this.jGv.getForum().getId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).ap("obj_type", i));
    }
}

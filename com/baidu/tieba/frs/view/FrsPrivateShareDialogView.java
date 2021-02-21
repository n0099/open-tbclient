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
    private HeadImageView iqm;
    private FrsViewData jGJ;
    private LinearGradientView jIY;
    private TbImageView jPY;
    private TextView jRj;
    private TextView jRk;
    private TextView jRl;
    private RelativeLayout jRm;
    private ImageOverlayView jRn;
    private HeadImageView jRo;
    private TextView jRp;
    private TextView jRq;
    private ForumActiveInfo jRr;
    private TextView jeW;
    private y.b jkD;
    private y jlY;
    private BarImageView jxv;
    private String mForumName;
    private TbPageContext mPageContext;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.jkD = new y.b() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // com.baidu.tieba.frs.y.b
            public void yR(int i) {
                FrsPrivateShareDialogView.this.Be(i);
            }
        };
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.jGJ = frsViewData;
        this.mPageContext = tbPageContext;
        this.acU = aVar;
        this.jRr = frsViewData.getForumActiveInfo();
        initUI(this.context);
        o(frsViewData);
        return true;
    }

    private void o(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.jeW.setVisibility(0);
                this.jeW.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.jeW.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.jxv.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.iqm.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.iqm.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.jRp.setText(frsViewData.getUserData().getName_show());
                this.jRp.setVisibility(0);
            } else {
                this.jRp.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.jRj.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.jRj.setText(frsViewData.getForum().getSlogan());
            } else {
                this.jRj.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.jRq.setVisibility(0);
                this.jRq.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.jRq.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                zF(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.jGJ.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                zF(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.jRl.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.jRl.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.jRn.setData(arrayList);
                this.jRn.setVisibility(0);
                this.jRo.setVisibility(8);
            } else {
                this.jRn.setVisibility(8);
                this.jRo.setVisibility(0);
                if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                    this.jRo.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
                } else {
                    this.jRo.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
                }
            }
            if (this.jlY != null && this.jRr != null) {
                this.jlY.setData(au.isEmpty(this.jRr.forum_share_url) ? "http://tieba.baidu.com" : this.jRr.forum_share_url, this.mForumName);
                this.jlY.setFrom(1);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.jRm = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        ap.setBackgroundResource(this.jRm, R.drawable.bg_frs_private_dialog);
        this.jIY = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.jIY.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.jIY.setRoundMode(3);
        this.jPY = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.jPY.setDefaultBgResource(R.color.transparent);
        this.jPY.setDefaultResource(R.drawable.pic_frs_head_default);
        this.jPY.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.jPY.setConrers(3);
        cNn();
        this.jeW = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        ap.setViewTextColor(this.jeW, R.color.CAM_X0101);
        this.jRj = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        ap.setViewTextColor(this.jRj, R.color.CAM_X0106);
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
        this.jxv = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.jxv.setShowOval(true);
        this.jxv.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.jxv.setStrokeColorResId(R.color.CAM_X0201);
        this.iqm = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.jRk = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.iqm.setDefaultBgResource(R.color.CAM_X0205);
        this.iqm.setIsRound(true);
        this.iqm.setTag(null);
        ap.setBackgroundResource(this.jRk, R.drawable.username_text_bg);
        this.jRl = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        ap.setViewTextColor(this.jRl, R.color.CAM_X0106);
        if (this.jlY == null) {
            this.jlY = new y(this.mPageContext);
            this.jlY.a(this.mRootView, this.jRm, (y.a) null);
            this.jlY.a(this.jkD);
        }
        this.jRn = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.jRn.l(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.jRn.setOrientation(true);
        this.jRn.setLoadImageType(12);
        this.jRn.onChangeSkinType();
        this.jRo = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.jRo.setDefaultBgResource(R.color.CAM_X0205);
        this.jRo.setIsRound(true);
        this.jRp = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        ap.setViewTextColor(this.jRp, R.color.CAM_X0105);
        this.jRq = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        ap.setViewTextColor(this.jRq, R.color.CAM_X0101);
    }

    private void zF(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eIT.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void cNn() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.jGJ != null && (forum = this.jGJ.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.jPY.setVisibility(8);
                this.jIY.setDefaultGradientColor();
                return;
            }
            this.jIY.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.jGJ.getStar() != null && !StringUtils.isNull(this.jGJ.getStar().dMO())) {
                str = this.jGJ.getStar().dMO();
            } else {
                str = themeElement.pattern_image;
            }
            this.jPY.setVisibility(0);
            this.jPY.startLoad(str, 10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Be(int i) {
        TiebaStatic.log(new ar("c13385").dR("fid", this.jGJ.getForum().getId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).ap("obj_type", i));
    }
}

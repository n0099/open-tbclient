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
    private com.baidu.tbadk.core.dialog.a aaB;
    private Context context;
    private ImageView dTV;
    private ImageView dUd;
    private TextView hRo;
    private ac.b hWX;
    private ac hYr;
    private HeadImageView hcN;
    private BarImageView ihb;
    private LinearGradientView ist;
    private FrsViewData ivb;
    private TbImageView ixT;
    private TextView iza;
    private TextView izb;
    private TextView izc;
    private RelativeLayout izd;
    private ImageOverlayView ize;
    private HeadImageView izf;
    private TextView izg;
    private TextView izh;
    private ForumActiveInfo izi;
    private String mForumName;
    private TbPageContext mPageContext;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.hWX = new ac.b() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // com.baidu.tieba.frs.ac.b
            public void xn(int i) {
                FrsPrivateShareDialogView.this.zm(i);
            }
        };
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.ivb = frsViewData;
        this.mPageContext = tbPageContext;
        this.aaB = aVar;
        this.izi = frsViewData.getForumActiveInfo();
        initUI(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.hRo.setVisibility(0);
                this.hRo.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.hRo.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.ihb.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.hcN.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.hcN.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.izg.setText(frsViewData.getUserData().getName_show());
                this.izg.setVisibility(0);
            } else {
                this.izg.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.iza.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.iza.setText(frsViewData.getForum().getSlogan());
            } else {
                this.iza.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.izh.setVisibility(0);
                this.izh.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.izh.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                yK(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.ivb.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                yK(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.izc.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.izc.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.ize.setData(arrayList);
                this.ize.setVisibility(0);
                this.izf.setVisibility(8);
            } else {
                this.ize.setVisibility(8);
                this.izf.setVisibility(0);
                if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                    this.izf.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
                } else {
                    this.izf.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
                }
            }
            if (this.hYr != null && this.izi != null) {
                this.hYr.setData(at.isEmpty(this.izi.forum_share_url) ? "http://tieba.baidu.com" : this.izi.forum_share_url, this.mForumName);
                this.hYr.setFrom(1);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.izd = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        ap.setBackgroundResource(this.izd, R.drawable.bg_frs_private_dialog);
        this.ist = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.ist.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.ist.setRoundMode(3);
        this.ixT = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.ixT.setDefaultBgResource(R.color.transparent);
        this.ixT.setDefaultResource(R.drawable.pic_frs_head_default);
        this.ixT.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.ixT.setConrers(3);
        cuM();
        this.hRo = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        ap.setViewTextColor(this.hRo, R.color.cp_cont_a);
        this.iza = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        ap.setViewTextColor(this.iza, R.color.cp_cont_f);
        this.dUd = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.dUd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.aaB != null && FrsPrivateShareDialogView.this.aaB.isShowing()) {
                    FrsPrivateShareDialogView.this.aaB.dismiss();
                }
            }
        });
        ap.setImageResource(this.dUd, R.drawable.icon_popup_shut_n);
        this.dTV = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.ihb = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.ihb.setShowOval(true);
        this.ihb.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.ihb.setStrokeColorResId(R.color.cp_bg_line_d);
        this.hcN = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.izb = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.hcN.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hcN.setIsRound(true);
        this.hcN.setTag(null);
        ap.setBackgroundResource(this.izb, R.drawable.username_text_bg);
        this.izc = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        ap.setViewTextColor(this.izc, R.color.cp_cont_f);
        if (this.hYr == null) {
            this.hYr = new ac(this.mPageContext);
            this.hYr.a(this.mRootView, this.izd, (ac.a) null);
            this.hYr.a(this.hWX);
        }
        this.ize = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.ize.j(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.ize.setOrientation(true);
        this.ize.setLoadImageType(12);
        this.ize.onChangeSkinType();
        this.izf = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.izf.setDefaultBgResource(R.color.cp_bg_line_e);
        this.izf.setIsRound(true);
        this.izg = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        ap.setViewTextColor(this.izg, R.color.cp_cont_b);
        this.izh = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        ap.setViewTextColor(this.izh, R.color.cp_cont_a);
    }

    private void yK(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.dTV.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void cuM() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.ivb != null && (forum = this.ivb.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.ixT.setVisibility(8);
                this.ist.setDefaultGradientColor();
                return;
            }
            this.ist.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.ivb.getStar() != null && !StringUtils.isNull(this.ivb.getStar().dvT())) {
                str = this.ivb.getStar().dvT();
            } else {
                str = themeElement.pattern_image;
            }
            this.ixT.setVisibility(0);
            this.ixT.startLoad(str, 10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zm(int i) {
        TiebaStatic.log(new aq("c13385").dD("fid", this.ivb.getForum().getId()).dD("uid", TbadkCoreApplication.getCurrentAccount()).ai("obj_type", i));
    }
}

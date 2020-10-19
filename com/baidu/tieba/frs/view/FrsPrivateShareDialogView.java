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
    private com.baidu.tbadk.core.dialog.a abm;
    private Context context;
    private ImageView eil;
    private ImageView eit;
    private HeadImageView hyL;
    private BarImageView iDc;
    private LinearGradientView iOI;
    private FrsViewData iRt;
    private TbImageView iUl;
    private TextView iVr;
    private TextView iVs;
    private TextView iVt;
    private RelativeLayout iVu;
    private ImageOverlayView iVv;
    private HeadImageView iVw;
    private TextView iVx;
    private TextView iVy;
    private ForumActiveInfo iVz;
    private TextView inv;
    private ac.b ite;
    private ac iuy;
    private String mForumName;
    private TbPageContext mPageContext;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.ite = new ac.b() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // com.baidu.tieba.frs.ac.b
            public void ys(int i) {
                FrsPrivateShareDialogView.this.Aq(i);
            }
        };
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.iRt = frsViewData;
        this.mPageContext = tbPageContext;
        this.abm = aVar;
        this.iVz = frsViewData.getForumActiveInfo();
        initUI(this.context);
        n(frsViewData);
        return true;
    }

    private void n(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.inv.setVisibility(0);
                this.inv.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.inv.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.iDc.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.hyL.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.hyL.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.iVx.setText(frsViewData.getUserData().getName_show());
                this.iVx.setVisibility(0);
            } else {
                this.iVx.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.iVr.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.iVr.setText(frsViewData.getForum().getSlogan());
            } else {
                this.iVr.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.iVy.setVisibility(0);
                this.iVy.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.iVy.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                zS(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.iRt.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                zS(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.iVt.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.iVt.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.iVv.setData(arrayList);
                this.iVv.setVisibility(0);
                this.iVw.setVisibility(8);
            } else {
                this.iVv.setVisibility(8);
                this.iVw.setVisibility(0);
                if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                    this.iVw.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
                } else {
                    this.iVw.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
                }
            }
            if (this.iuy != null && this.iVz != null) {
                this.iuy.setData(at.isEmpty(this.iVz.forum_share_url) ? "http://tieba.baidu.com" : this.iVz.forum_share_url, this.mForumName);
                this.iuy.setFrom(1);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.iVu = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        ap.setBackgroundResource(this.iVu, R.drawable.bg_frs_private_dialog);
        this.iOI = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.iOI.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.iOI.setRoundMode(3);
        this.iUl = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.iUl.setDefaultBgResource(R.color.transparent);
        this.iUl.setDefaultResource(R.drawable.pic_frs_head_default);
        this.iUl.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.iUl.setConrers(3);
        cBD();
        this.inv = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        ap.setViewTextColor(this.inv, R.color.cp_cont_a);
        this.iVr = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        ap.setViewTextColor(this.iVr, R.color.cp_cont_f);
        this.eit = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.eit.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.abm != null && FrsPrivateShareDialogView.this.abm.isShowing()) {
                    FrsPrivateShareDialogView.this.abm.dismiss();
                }
            }
        });
        ap.setImageResource(this.eit, R.drawable.icon_popup_shut_n);
        this.eil = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.iDc = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.iDc.setShowOval(true);
        this.iDc.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.iDc.setStrokeColorResId(R.color.cp_bg_line_d);
        this.hyL = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.iVs = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.hyL.setDefaultBgResource(R.color.cp_bg_line_e);
        this.hyL.setIsRound(true);
        this.hyL.setTag(null);
        ap.setBackgroundResource(this.iVs, R.drawable.username_text_bg);
        this.iVt = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        ap.setViewTextColor(this.iVt, R.color.cp_cont_f);
        if (this.iuy == null) {
            this.iuy = new ac(this.mPageContext);
            this.iuy.a(this.mRootView, this.iVu, (ac.a) null);
            this.iuy.a(this.ite);
        }
        this.iVv = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.iVv.j(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.iVv.setOrientation(true);
        this.iVv.setLoadImageType(12);
        this.iVv.onChangeSkinType();
        this.iVw = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.iVw.setDefaultBgResource(R.color.cp_bg_line_e);
        this.iVw.setIsRound(true);
        this.iVx = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        ap.setViewTextColor(this.iVx, R.color.cp_cont_b);
        this.iVy = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        ap.setViewTextColor(this.iVy, R.color.cp_cont_a);
    }

    private void zS(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eil.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void cBD() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.iRt != null && (forum = this.iRt.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.iUl.setVisibility(8);
                this.iOI.setDefaultGradientColor();
                return;
            }
            this.iOI.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.iRt.getStar() != null && !StringUtils.isNull(this.iRt.getStar().dDC())) {
                str = this.iRt.getStar().dDC();
            } else {
                str = themeElement.pattern_image;
            }
            this.iUl.setVisibility(0);
            this.iUl.startLoad(str, 10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aq(int i) {
        TiebaStatic.log(new aq("c13385").dK("fid", this.iRt.getForum().getId()).dK("uid", TbadkCoreApplication.getCurrentAccount()).aj("obj_type", i));
    }
}

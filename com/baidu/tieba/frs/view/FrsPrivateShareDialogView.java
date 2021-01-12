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
    private com.baidu.tbadk.core.dialog.a ada;
    private Context context;
    private ImageView eGN;
    private ImageView eGV;
    private TextView iZb;
    private HeadImageView ikq;
    private FrsViewData jAR;
    private LinearGradientView jDg;
    private TbImageView jIN;
    private TextView jJY;
    private TextView jJZ;
    private TextView jKa;
    private RelativeLayout jKb;
    private ImageOverlayView jKc;
    private HeadImageView jKd;
    private TextView jKe;
    private TextView jKf;
    private ForumActiveInfo jKg;
    private y.b jeI;
    private y jgd;
    private BarImageView jrB;
    private String mForumName;
    private TbPageContext mPageContext;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.jeI = new y.b() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // com.baidu.tieba.frs.y.b
            public void yH(int i) {
                FrsPrivateShareDialogView.this.AP(i);
            }
        };
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.jAR = frsViewData;
        this.mPageContext = tbPageContext;
        this.ada = aVar;
        this.jKg = frsViewData.getForumActiveInfo();
        initUI(this.context);
        o(frsViewData);
        return true;
    }

    private void o(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.iZb.setVisibility(0);
                this.iZb.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.iZb.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.jrB.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.ikq.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.ikq.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.jKe.setText(frsViewData.getUserData().getName_show());
                this.jKe.setVisibility(0);
            } else {
                this.jKe.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.jJY.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.jJY.setText(frsViewData.getForum().getSlogan());
            } else {
                this.jJY.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.jKf.setVisibility(0);
                this.jKf.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.jKf.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                zo(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.jAR.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                zo(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.jKa.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.jKa.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.jKc.setData(arrayList);
                this.jKc.setVisibility(0);
                this.jKd.setVisibility(8);
            } else {
                this.jKc.setVisibility(8);
                this.jKd.setVisibility(0);
                if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                    this.jKd.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
                } else {
                    this.jKd.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
                }
            }
            if (this.jgd != null && this.jKg != null) {
                this.jgd.setData(at.isEmpty(this.jKg.forum_share_url) ? "http://tieba.baidu.com" : this.jKg.forum_share_url, this.mForumName);
                this.jgd.setFrom(1);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        ao.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.jKb = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        ao.setBackgroundResource(this.jKb, R.drawable.bg_frs_private_dialog);
        this.jDg = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.jDg.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.jDg.setRoundMode(3);
        this.jIN = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.jIN.setDefaultBgResource(R.color.transparent);
        this.jIN.setDefaultResource(R.drawable.pic_frs_head_default);
        this.jIN.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.jIN.setConrers(3);
        cLs();
        this.iZb = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        ao.setViewTextColor(this.iZb, R.color.CAM_X0101);
        this.jJY = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        ao.setViewTextColor(this.jJY, R.color.CAM_X0106);
        this.eGV = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.eGV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.ada != null && FrsPrivateShareDialogView.this.ada.isShowing()) {
                    FrsPrivateShareDialogView.this.ada.dismiss();
                }
            }
        });
        ao.setImageResource(this.eGV, R.drawable.icon_popup_shut_n);
        this.eGN = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.jrB = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.jrB.setShowOval(true);
        this.jrB.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.jrB.setStrokeColorResId(R.color.CAM_X0201);
        this.ikq = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.jJZ = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.ikq.setDefaultBgResource(R.color.CAM_X0205);
        this.ikq.setIsRound(true);
        this.ikq.setTag(null);
        ao.setBackgroundResource(this.jJZ, R.drawable.username_text_bg);
        this.jKa = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        ao.setViewTextColor(this.jKa, R.color.CAM_X0106);
        if (this.jgd == null) {
            this.jgd = new y(this.mPageContext);
            this.jgd.a(this.mRootView, this.jKb, (y.a) null);
            this.jgd.a(this.jeI);
        }
        this.jKc = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.jKc.l(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.jKc.setOrientation(true);
        this.jKc.setLoadImageType(12);
        this.jKc.onChangeSkinType();
        this.jKd = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.jKd.setDefaultBgResource(R.color.CAM_X0205);
        this.jKd.setIsRound(true);
        this.jKe = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        ao.setViewTextColor(this.jKe, R.color.CAM_X0105);
        this.jKf = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        ao.setViewTextColor(this.jKf, R.color.CAM_X0101);
    }

    private void zo(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eGN.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void cLs() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.jAR != null && (forum = this.jAR.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.jIN.setVisibility(8);
                this.jDg.setDefaultGradientColor();
                return;
            }
            this.jDg.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.jAR.getStar() != null && !StringUtils.isNull(this.jAR.getStar().dKv())) {
                str = this.jAR.getStar().dKv();
            } else {
                str = themeElement.pattern_image;
            }
            this.jIN.setVisibility(0);
            this.jIN.startLoad(str, 10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AP(int i) {
        TiebaStatic.log(new aq("c13385").dW("fid", this.jAR.getForum().getId()).dW("uid", TbadkCoreApplication.getCurrentAccount()).an("obj_type", i));
    }
}

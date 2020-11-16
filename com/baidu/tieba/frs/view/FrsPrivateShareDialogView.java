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
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import java.net.URLEncoder;
import java.util.ArrayList;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes21.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a abt;
    private Context context;
    private ImageView euT;
    private ImageView evb;
    private HeadImageView hRE;
    private TextView iGC;
    private ac.b iMk;
    private ac iNE;
    private BarImageView iWh;
    private FrsViewData jfx;
    private LinearGradientView jhM;
    private TbImageView jnq;
    private TextView joA;
    private RelativeLayout joB;
    private ImageOverlayView joC;
    private HeadImageView joD;
    private TextView joE;
    private TextView joF;
    private ForumActiveInfo joG;
    private TextView joy;
    private TextView joz;
    private String mForumName;
    private TbPageContext mPageContext;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.iMk = new ac.b() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // com.baidu.tieba.frs.ac.b
            public void zw(int i) {
                FrsPrivateShareDialogView.this.Bu(i);
            }
        };
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.jfx = frsViewData;
        this.mPageContext = tbPageContext;
        this.abt = aVar;
        this.joG = frsViewData.getForumActiveInfo();
        initUI(this.context);
        o(frsViewData);
        return true;
    }

    private void o(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.iGC.setVisibility(0);
                this.iGC.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.iGC.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.iWh.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.hRE.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.hRE.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.joE.setText(frsViewData.getUserData().getName_show());
                this.joE.setVisibility(0);
            } else {
                this.joE.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.joy.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.joy.setText(frsViewData.getForum().getSlogan());
            } else {
                this.joy.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.joF.setVisibility(0);
                this.joF.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.joF.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                zU(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.jfx.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                zU(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.joA.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.joA.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.joC.setData(arrayList);
                this.joC.setVisibility(0);
                this.joD.setVisibility(8);
            } else {
                this.joC.setVisibility(8);
                this.joD.setVisibility(0);
                if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                    this.joD.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
                } else {
                    this.joD.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
                }
            }
            if (this.iNE != null && this.joG != null) {
                this.iNE.setData(au.isEmpty(this.joG.forum_share_url) ? "http://tieba.baidu.com" : this.joG.forum_share_url, this.mForumName);
                this.iNE.setFrom(1);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.joB = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        ap.setBackgroundResource(this.joB, R.drawable.bg_frs_private_dialog);
        this.jhM = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.jhM.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.jhM.setRoundMode(3);
        this.jnq = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.jnq.setDefaultBgResource(R.color.transparent);
        this.jnq.setDefaultResource(R.drawable.pic_frs_head_default);
        this.jnq.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.jnq.setConrers(3);
        cGQ();
        this.iGC = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        ap.setViewTextColor(this.iGC, R.color.CAM_X0101);
        this.joy = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        ap.setViewTextColor(this.joy, R.color.CAM_X0106);
        this.evb = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.evb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.abt != null && FrsPrivateShareDialogView.this.abt.isShowing()) {
                    FrsPrivateShareDialogView.this.abt.dismiss();
                }
            }
        });
        ap.setImageResource(this.evb, R.drawable.icon_popup_shut_n);
        this.euT = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.iWh = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.iWh.setShowOval(true);
        this.iWh.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.iWh.setStrokeColorResId(R.color.CAM_X0201);
        this.hRE = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.joz = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.hRE.setDefaultBgResource(R.color.CAM_X0205);
        this.hRE.setIsRound(true);
        this.hRE.setTag(null);
        ap.setBackgroundResource(this.joz, R.drawable.username_text_bg);
        this.joA = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        ap.setViewTextColor(this.joA, R.color.CAM_X0106);
        if (this.iNE == null) {
            this.iNE = new ac(this.mPageContext);
            this.iNE.a(this.mRootView, this.joB, (ac.a) null);
            this.iNE.a(this.iMk);
        }
        this.joC = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.joC.j(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.joC.setOrientation(true);
        this.joC.setLoadImageType(12);
        this.joC.onChangeSkinType();
        this.joD = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.joD.setDefaultBgResource(R.color.CAM_X0205);
        this.joD.setIsRound(true);
        this.joE = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        ap.setViewTextColor(this.joE, R.color.CAM_X0105);
        this.joF = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        ap.setViewTextColor(this.joF, R.color.CAM_X0101);
    }

    private void zU(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.euT.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void cGQ() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.jfx != null && (forum = this.jfx.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.jnq.setVisibility(8);
                this.jhM.setDefaultGradientColor();
                return;
            }
            this.jhM.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.jfx.getStar() != null && !StringUtils.isNull(this.jfx.getStar().dJd())) {
                str = this.jfx.getStar().dJd();
            } else {
                str = themeElement.pattern_image;
            }
            this.jnq.setVisibility(0);
            this.jnq.startLoad(str, 10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bu(int i) {
        TiebaStatic.log(new ar("c13385").dR("fid", this.jfx.getForum().getId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).ak("obj_type", i));
    }
}

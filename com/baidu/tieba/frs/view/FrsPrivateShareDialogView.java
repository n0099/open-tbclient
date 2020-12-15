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
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.ImageOverlayView;
import java.net.URLEncoder;
import java.util.ArrayList;
import tbclient.FrsPage.ForumActiveInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes22.dex */
public class FrsPrivateShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a acq;
    private Context context;
    private ImageView eBV;
    private ImageView eCd;
    private TextView iRw;
    private ab.b iXd;
    private ab iYx;
    private HeadImageView icz;
    private TbImageView jAU;
    private TextView jCc;
    private TextView jCd;
    private TextView jCe;
    private RelativeLayout jCf;
    private ImageOverlayView jCg;
    private HeadImageView jCh;
    private TextView jCi;
    private TextView jCj;
    private ForumActiveInfo jCk;
    private BarImageView jjI;
    private FrsViewData jtc;
    private LinearGradientView jvr;
    private String mForumName;
    private TbPageContext mPageContext;
    private LinearLayout mRootView;

    public FrsPrivateShareDialogView(Context context) {
        super(context);
        this.iXd = new ab.b() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.2
            @Override // com.baidu.tieba.frs.ab.b
            public void Ab(int i) {
                FrsPrivateShareDialogView.this.Cj(i);
            }
        };
        this.context = context;
    }

    public boolean a(FrsViewData frsViewData, TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.jtc = frsViewData;
        this.mPageContext = tbPageContext;
        this.acq = aVar;
        this.jCk = frsViewData.getForumActiveInfo();
        initUI(this.context);
        o(frsViewData);
        return true;
    }

    private void o(FrsViewData frsViewData) {
        String str;
        if (frsViewData != null) {
            if (frsViewData.getForum() != null) {
                this.iRw.setVisibility(0);
                this.iRw.setText(frsViewData.getForum().getName() + this.context.getResources().getString(R.string.core_bar));
                this.mForumName = frsViewData.getForum().getName();
            } else {
                this.iRw.setVisibility(8);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getImage_url() != null) {
                this.jjI.startLoad(frsViewData.getForum().getImage_url(), 10, false);
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getPortrait() != null) {
                this.icz.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
            } else {
                this.icz.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
            }
            if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getName_show()) && !"0".equals(frsViewData.getUserData().getName_show())) {
                this.jCi.setText(frsViewData.getUserData().getName_show());
                this.jCi.setVisibility(0);
            } else {
                this.jCi.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_brief)) {
                this.jCc.setText(frsViewData.getForumActiveInfo().forum_brief);
            } else if (!StringUtils.isNull(frsViewData.getForum().getSlogan())) {
                this.jCc.setText(frsViewData.getForum().getSlogan());
            } else {
                this.jCc.setText(getResources().getString(R.string.frs_private_share_hint));
            }
            if (frsViewData.getUserData() != null && frsViewData.getUserData().getIs_manager() == 1) {
                this.jCj.setVisibility(0);
                this.jCj.setText(R.string.bawu_member_bazhu_tip);
            } else {
                this.jCj.setVisibility(8);
            }
            if (frsViewData.getForumActiveInfo() != null && !StringUtils.isNull(frsViewData.getForumActiveInfo().forum_share_url)) {
                AB(frsViewData.getForumActiveInfo().forum_share_url);
            } else if (frsViewData.getForum() != null) {
                ForumData forum = this.jtc.getForum();
                String encode = URLEncoder.encode(frsViewData.getForum().getName());
                if (!TextUtils.isEmpty(forum.forum_share_link)) {
                    str = forum.forum_share_link + "?kw=" + encode + "&fr=frsshare";
                } else {
                    str = TbConfig.HTTPS_FRS_PREFIX + encode + "&fr=frsshare";
                }
                AB(str);
            }
            if (frsViewData.getForum() != null && frsViewData.getForum().getMember_num() > 3) {
                this.jCe.setText(frsViewData.getForum().getMember_num() + getResources().getString(R.string.bar_friends_join));
            } else {
                this.jCe.setText(getResources().getString(R.string.wait_for_you_join));
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
                this.jCg.setData(arrayList);
                this.jCg.setVisibility(0);
                this.jCh.setVisibility(8);
            } else {
                this.jCg.setVisibility(8);
                this.jCh.setVisibility(0);
                if (frsViewData.getUserData() != null && !StringUtils.isNull(frsViewData.getUserData().getPortrait())) {
                    this.jCh.startLoad(frsViewData.getUserData().getPortrait(), 12, false);
                } else {
                    this.jCh.startLoad(String.valueOf(R.drawable.icon_default_avatar100), 12, false);
                }
            }
            if (this.iYx != null && this.jCk != null) {
                this.iYx.setData(au.isEmpty(this.jCk.forum_share_url) ? "http://tieba.baidu.com" : this.jCk.forum_share_url, this.mForumName);
                this.iYx.setFrom(1);
            }
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.frs_private_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        this.jCf = (RelativeLayout) this.mRootView.findViewById(R.id.frs_private_share_view);
        ap.setBackgroundResource(this.jCf, R.drawable.bg_frs_private_dialog);
        this.jvr = (LinearGradientView) this.mRootView.findViewById(R.id.frs_private_top_gradient_bg);
        this.jvr.setCornerRadius(l.getDimens(context, R.dimen.tbds30));
        this.jvr.setRoundMode(3);
        this.jAU = (TbImageView) this.mRootView.findViewById(R.id.frs_private_top_bg_mask);
        this.jAU.setDefaultBgResource(R.color.transparent);
        this.jAU.setDefaultResource(R.drawable.pic_frs_head_default);
        this.jAU.setRadius(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds30));
        this.jAU.setConrers(3);
        cMg();
        this.iRw = (TextView) this.mRootView.findViewById(R.id.frs_private_share_name);
        ap.setViewTextColor(this.iRw, R.color.CAM_X0101);
        this.jCc = (TextView) this.mRootView.findViewById(R.id.frs_private_share_brief);
        ap.setViewTextColor(this.jCc, R.color.CAM_X0106);
        this.eCd = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.eCd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsPrivateShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsPrivateShareDialogView.this.acq != null && FrsPrivateShareDialogView.this.acq.isShowing()) {
                    FrsPrivateShareDialogView.this.acq.dismiss();
                }
            }
        });
        ap.setImageResource(this.eCd, R.drawable.icon_popup_shut_n);
        this.eBV = (ImageView) this.mRootView.findViewById(R.id.frs_private_share_qrcode);
        this.jjI = (BarImageView) this.mRootView.findViewById(R.id.frs_private_share_portrait);
        this.jjI.setShowOval(true);
        this.jjI.setStrokeWith(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds3));
        this.jjI.setStrokeColorResId(R.color.CAM_X0201);
        this.icz = (HeadImageView) this.mRootView.findViewById(R.id.photo);
        this.jCd = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        this.icz.setDefaultBgResource(R.color.CAM_X0205);
        this.icz.setIsRound(true);
        this.icz.setTag(null);
        ap.setBackgroundResource(this.jCd, R.drawable.username_text_bg);
        this.jCe = (TextView) this.mRootView.findViewById(R.id.frs_private_share_time);
        ap.setViewTextColor(this.jCe, R.color.CAM_X0106);
        if (this.iYx == null) {
            this.iYx = new ab(this.mPageContext);
            this.iYx.a(this.mRootView, this.jCf, (ab.a) null);
            this.iYx.a(this.iXd);
        }
        this.jCg = (ImageOverlayView) this.mRootView.findViewById(R.id.frs_private_overlayview);
        int dimens = l.getDimens(getContext(), R.dimen.tbds68);
        this.jCg.k(5, dimens, dimens, 0, 0, l.getDimens(getContext(), R.dimen.tbds16));
        this.jCg.setOrientation(true);
        this.jCg.setLoadImageType(12);
        this.jCg.onChangeSkinType();
        this.jCh = (HeadImageView) this.mRootView.findViewById(R.id.bar_friend_icon);
        this.jCh.setDefaultBgResource(R.color.CAM_X0205);
        this.jCh.setIsRound(true);
        this.jCi = (TextView) this.mRootView.findViewById(R.id.frs_user_name);
        ap.setViewTextColor(this.jCi, R.color.CAM_X0105);
        this.jCj = (TextView) this.mRootView.findViewById(R.id.frs_user_name_identify);
        ap.setViewTextColor(this.jCj, R.color.CAM_X0101);
    }

    private void AB(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eBV.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void cMg() {
        ForumData forum;
        ThemeElement themeElement;
        String str;
        if (this.jtc != null && (forum = this.jtc.getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo == null || themeColorInfo.day == null || themeColorInfo.night == null || themeColorInfo.dark == null) {
                this.jAU.setVisibility(8);
                this.jvr.setDefaultGradientColor();
                return;
            }
            this.jvr.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (this.jtc.getStar() != null && !StringUtils.isNull(this.jtc.getStar().dOu())) {
                str = this.jtc.getStar().dOu();
            } else {
                str = themeElement.pattern_image;
            }
            this.jAU.setVisibility(0);
            this.jAU.startLoad(str, 10, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cj(int i) {
        TiebaStatic.log(new ar("c13385").dY("fid", this.jtc.getForum().getId()).dY("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_type", i));
    }
}

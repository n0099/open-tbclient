package com.baidu.tieba.frs.forumRule.view;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.base.d;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.l.h;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.forumRule.ForumRulesShowActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends d<ForumRulesShowActivity> implements View.OnClickListener {
    private BdTypeRecyclerView XW;
    private ImageView ahC;
    public View fLW;
    private h gBT;
    private ForumRulesShowActivity juU;
    private int jwN;
    public View jwO;
    private com.baidu.tieba.frs.forumRule.adapter.a jwP;
    private com.baidu.tieba.frs.forumRule.c.b jwQ;
    private com.baidu.tieba.frs.forumRule.c.a jwR;
    private View jwS;
    private int jwT;
    private int jwU;
    private ImageView mBackImageView;
    public List<n> mData;
    private com.baidu.tieba.frs.forumRule.b.b mForumRuleDetailData;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public c(ForumRulesShowActivity forumRulesShowActivity, String str) {
        super(forumRulesShowActivity.getPageContext());
        this.jwN = 3;
        this.mData = new ArrayList();
        this.jwT = 0;
        this.jwU = 0;
        this.juU = forumRulesShowActivity;
        this.mFrom = str;
        forumRulesShowActivity.setContentView(R.layout.activity_forum_rules_show);
        this.jwQ = new com.baidu.tieba.frs.forumRule.c.b(forumRulesShowActivity);
        this.jwR = new com.baidu.tieba.frs.forumRule.c.a(forumRulesShowActivity);
        this.jwT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds88);
        this.jwU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        b(forumRulesShowActivity);
    }

    private void b(ForumRulesShowActivity forumRulesShowActivity) {
        this.mRootView = (ViewGroup) forumRulesShowActivity.findViewById(R.id.forum_rule_rootview);
        this.mNavigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.navigationbar);
        a(this.mNavigationBar);
        this.XW = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.forum_rules_list_info);
        this.XW.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
        this.jwP = new com.baidu.tieba.frs.forumRule.adapter.a(forumRulesShowActivity, this.XW);
        this.jwS = forumRulesShowActivity.findViewById(R.id.forum_rules_net_refresh_layout);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View cHE() {
        return this.jwS;
    }

    public void cHF() {
        if (this.jwS != null) {
            this.jwS.setVisibility(0);
        }
    }

    public void cHG() {
        if (this.jwS != null) {
            this.jwS.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jwP != null) {
            this.jwP.setFrom(str);
        }
    }

    public void cHH() {
        if (this.jwP != null) {
            this.jwP.setData(this.mData);
        }
    }

    public void cHI() {
        if (this.XW != null) {
            this.XW.setVisibility(0);
        }
    }

    public void cHJ() {
        if (this.XW != null) {
            this.XW.setVisibility(8);
        }
    }

    public void a(h hVar) {
        this.gBT = hVar;
        hVar.bCT().setOnClickListener(this);
    }

    private void a(NavigationBar navigationBar) {
        this.fLW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.mBackImageView = (ImageView) this.fLW.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.setCenterTextTitle(this.juU.getResources().getString(R.string.forum_rules_local));
        this.jwO = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this);
        this.ahC = (ImageView) this.jwO.findViewById(R.id.navigationBarBtnMore);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jwT, this.jwT);
        layoutParams.rightMargin = this.jwU;
        this.jwO.setLayoutParams(layoutParams);
        SvgManager.bsR().a(this.ahC, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        cHK();
    }

    private void cHK() {
        int i = -1;
        HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
        if (baseSwitchs != null && baseSwitchs.containsKey("is_disable_forumrule_share")) {
            i = baseSwitchs.get("is_disable_forumrule_share").intValue();
        }
        if (i == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
            this.jwO.setVisibility(0);
        } else {
            this.jwO.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.juU.getPageContext(), i);
        if (this.jwN == i) {
            this.mNavigationBar.getCenterText().setTextSize(R.dimen.L_X06);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0611, R.color.CAM_X0611);
            WebPManager.a(this.mBackImageView, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.a(this.ahC, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.jwQ.onChangeSkinType(i);
            this.jwR.onChangeSkinType(i);
            this.jwP.onChangeSkinType(i);
            this.jwN = i;
        }
    }

    public void destory() {
        this.juU = null;
    }

    public void KF(String str) {
        if (this.jwQ != null && !StringUtils.isNull(str)) {
            this.jwQ.d(this.XW);
            this.jwQ.setTitle(str);
        }
    }

    public void hideTitle() {
        if (this.jwQ != null) {
            this.jwQ.e(this.XW);
        }
    }

    public void KG(String str) {
        if (this.jwR != null) {
            this.jwR.b(this.XW);
            this.jwR.KA(str);
        }
    }

    public void cHL() {
        if (this.jwR != null) {
            this.jwR.c(this.XW);
        }
    }

    public void addTitle(String str) {
        KF(str);
    }

    public void c(com.baidu.tieba.frs.forumRule.b.b bVar) {
        this.mForumRuleDetailData = bVar;
        this.mData.add(bVar);
    }

    public void dt(List<com.baidu.tieba.frs.forumRule.b.c> list) {
        this.mData.addAll(list);
    }

    public void b(com.baidu.tieba.frs.forumRule.b.a aVar) {
        this.mData.add(aVar);
    }

    public void remove() {
        cHL();
        hideTitle();
    }

    public ViewGroup getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.juU != null) {
            if (view.getId() == R.id.root_pb_more) {
                int i = -1;
                String str = "";
                String str2 = "";
                if (this.mForumRuleDetailData != null && this.mForumRuleDetailData.cGY() != null) {
                    i = this.mForumRuleDetailData.cGY().forum_id.intValue();
                    str2 = this.mForumRuleDetailData.cGY().forum_name;
                }
                if (this.mForumRuleDetailData != null) {
                    str = this.mForumRuleDetailData.getTitle();
                }
                String str3 = "http://tieba.baidu.com/mo/q/wise-bawu-core/forumRuleShare?fid=" + i;
                final ShareItem shareItem = new ShareItem();
                shareItem.title = str;
                shareItem.content = String.format(this.juU.getResources().getString(R.string.forum_rules_share_text), str2);
                shareItem.linkUrl = str3;
                shareItem.fvj = false;
                if (this.mForumRuleDetailData != null && !StringUtils.isNull(this.mForumRuleDetailData.cGY().avatar)) {
                    shareItem.imageUri = Uri.parse(this.mForumRuleDetailData.cGY().avatar);
                    shareItem.bzf();
                }
                shareItem.fvd = str;
                shareItem.fve = str3;
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.juU, shareItem, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(c.this.juU, c.this.juU.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                this.juU.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            } else if (view.getId() == R.id.navigationBarGoBack) {
                this.juU.finish();
            } else if (this.gBT != null && view.getId() == this.gBT.bCT().getId()) {
                this.juU.cGU();
            }
        }
    }
}

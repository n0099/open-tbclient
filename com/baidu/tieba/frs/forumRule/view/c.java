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
import com.baidu.tbadk.core.util.ao;
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
    private BdTypeRecyclerView Yc;
    private ImageView aiG;
    public View fOs;
    private h gDQ;
    private ForumRulesShowActivity jtU;
    private int jvN;
    public View jvO;
    private com.baidu.tieba.frs.forumRule.adapter.a jvP;
    private com.baidu.tieba.frs.forumRule.c.b jvQ;
    private com.baidu.tieba.frs.forumRule.c.a jvR;
    private View jvS;
    private int jvT;
    private int jvU;
    private ImageView mBackImageView;
    public List<n> mData;
    private com.baidu.tieba.frs.forumRule.b.b mForumRuleDetailData;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public c(ForumRulesShowActivity forumRulesShowActivity, String str) {
        super(forumRulesShowActivity.getPageContext());
        this.jvN = 3;
        this.mData = new ArrayList();
        this.jvT = 0;
        this.jvU = 0;
        this.jtU = forumRulesShowActivity;
        this.mFrom = str;
        forumRulesShowActivity.setContentView(R.layout.activity_forum_rules_show);
        this.jvQ = new com.baidu.tieba.frs.forumRule.c.b(forumRulesShowActivity);
        this.jvR = new com.baidu.tieba.frs.forumRule.c.a(forumRulesShowActivity);
        this.jvT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds88);
        this.jvU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        b(forumRulesShowActivity);
    }

    private void b(ForumRulesShowActivity forumRulesShowActivity) {
        this.mRootView = (ViewGroup) forumRulesShowActivity.findViewById(R.id.forum_rule_rootview);
        this.mNavigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.navigationbar);
        a(this.mNavigationBar);
        this.Yc = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.forum_rules_list_info);
        this.Yc.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
        this.jvP = new com.baidu.tieba.frs.forumRule.adapter.a(forumRulesShowActivity, this.Yc);
        this.jvS = forumRulesShowActivity.findViewById(R.id.forum_rules_net_refresh_layout);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View cKj() {
        return this.jvS;
    }

    public void cKk() {
        if (this.jvS != null) {
            this.jvS.setVisibility(0);
        }
    }

    public void cKl() {
        if (this.jvS != null) {
            this.jvS.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jvP != null) {
            this.jvP.setFrom(str);
        }
    }

    public void cKm() {
        if (this.jvP != null) {
            this.jvP.setData(this.mData);
        }
    }

    public void cKn() {
        if (this.Yc != null) {
            this.Yc.setVisibility(0);
        }
    }

    public void cKo() {
        if (this.Yc != null) {
            this.Yc.setVisibility(8);
        }
    }

    public void a(h hVar) {
        this.gDQ = hVar;
        hVar.bGu().setOnClickListener(this);
    }

    private void a(NavigationBar navigationBar) {
        this.fOs = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.mBackImageView = (ImageView) this.fOs.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.setCenterTextTitle(this.jtU.getResources().getString(R.string.forum_rules_local));
        this.jvO = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this);
        this.aiG = (ImageView) this.jvO.findViewById(R.id.navigationBarBtnMore);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jvT, this.jvT);
        layoutParams.rightMargin = this.jvU;
        this.jvO.setLayoutParams(layoutParams);
        SvgManager.bwr().a(this.aiG, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        cKp();
    }

    private void cKp() {
        int i = -1;
        HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
        if (baseSwitchs != null && baseSwitchs.containsKey("is_disable_forumrule_share")) {
            i = baseSwitchs.get("is_disable_forumrule_share").intValue();
        }
        if (i == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
            this.jvO.setVisibility(0);
        } else {
            this.jvO.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jtU.getPageContext(), i);
        if (this.jvN == i) {
            this.mNavigationBar.getCenterText().setTextSize(R.dimen.L_X06);
            ao.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0611, R.color.CAM_X0611);
            WebPManager.a(this.mBackImageView, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.a(this.aiG, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.jvQ.onChangeSkinType(i);
            this.jvR.onChangeSkinType(i);
            this.jvP.onChangeSkinType(i);
            this.jvN = i;
        }
    }

    public void destory() {
        this.jtU = null;
    }

    public void Le(String str) {
        if (this.jvQ != null && !StringUtils.isNull(str)) {
            this.jvQ.d(this.Yc);
            this.jvQ.setTitle(str);
        }
    }

    public void hideTitle() {
        if (this.jvQ != null) {
            this.jvQ.e(this.Yc);
        }
    }

    public void Lf(String str) {
        if (this.jvR != null) {
            this.jvR.b(this.Yc);
            this.jvR.KZ(str);
        }
    }

    public void cKq() {
        if (this.jvR != null) {
            this.jvR.c(this.Yc);
        }
    }

    public void addTitle(String str) {
        Le(str);
    }

    public void c(com.baidu.tieba.frs.forumRule.b.b bVar) {
        this.mForumRuleDetailData = bVar;
        this.mData.add(bVar);
    }

    public void dy(List<com.baidu.tieba.frs.forumRule.b.c> list) {
        this.mData.addAll(list);
    }

    public void b(com.baidu.tieba.frs.forumRule.b.a aVar) {
        this.mData.add(aVar);
    }

    public void remove() {
        cKq();
        hideTitle();
    }

    public ViewGroup getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jtU != null) {
            if (view.getId() == R.id.root_pb_more) {
                int i = -1;
                String str = "";
                String str2 = "";
                if (this.mForumRuleDetailData != null && this.mForumRuleDetailData.cJD() != null) {
                    i = this.mForumRuleDetailData.cJD().forum_id.intValue();
                    str2 = this.mForumRuleDetailData.cJD().forum_name;
                }
                if (this.mForumRuleDetailData != null) {
                    str = this.mForumRuleDetailData.getTitle();
                }
                String str3 = "http://tieba.baidu.com/mo/q/wise-bawu-core/forumRuleShare?fid=" + i;
                final ShareItem shareItem = new ShareItem();
                shareItem.title = str;
                shareItem.content = String.format(this.jtU.getResources().getString(R.string.forum_rules_share_text), str2);
                shareItem.linkUrl = str3;
                shareItem.fxA = false;
                if (this.mForumRuleDetailData != null && !StringUtils.isNull(this.mForumRuleDetailData.cJD().avatar)) {
                    shareItem.imageUri = Uri.parse(this.mForumRuleDetailData.cJD().avatar);
                    shareItem.bCH();
                }
                shareItem.fxu = str;
                shareItem.fxv = str3;
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.jtU, shareItem, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(c.this.jtU, c.this.jtU.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                this.jtU.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            } else if (view.getId() == R.id.navigationBarGoBack) {
                this.jtU.finish();
            } else if (this.gDQ != null && view.getId() == this.gDQ.bGu().getId()) {
                this.jtU.cJz();
            }
        }
    }
}

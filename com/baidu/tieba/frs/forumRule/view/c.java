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
    private BdTypeRecyclerView Ya;
    private ImageView ahO;
    public View fJL;
    private h gzj;
    private ForumRulesShowActivity jpo;
    private int jrh;
    public View jri;
    private com.baidu.tieba.frs.forumRule.adapter.a jrj;
    private com.baidu.tieba.frs.forumRule.c.b jrk;
    private com.baidu.tieba.frs.forumRule.c.a jrl;
    private View jrm;
    private int jrn;
    private int jro;
    private ImageView mBackImageView;
    public List<n> mData;
    private com.baidu.tieba.frs.forumRule.b.b mForumRuleDetailData;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public c(ForumRulesShowActivity forumRulesShowActivity, String str) {
        super(forumRulesShowActivity.getPageContext());
        this.jrh = 3;
        this.mData = new ArrayList();
        this.jrn = 0;
        this.jro = 0;
        this.jpo = forumRulesShowActivity;
        this.mFrom = str;
        forumRulesShowActivity.setContentView(R.layout.activity_forum_rules_show);
        this.jrk = new com.baidu.tieba.frs.forumRule.c.b(forumRulesShowActivity);
        this.jrl = new com.baidu.tieba.frs.forumRule.c.a(forumRulesShowActivity);
        this.jrn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds88);
        this.jro = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        b(forumRulesShowActivity);
    }

    private void b(ForumRulesShowActivity forumRulesShowActivity) {
        this.mRootView = (ViewGroup) forumRulesShowActivity.findViewById(R.id.forum_rule_rootview);
        this.mNavigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.navigationbar);
        a(this.mNavigationBar);
        this.Ya = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.forum_rules_list_info);
        this.Ya.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
        this.jrj = new com.baidu.tieba.frs.forumRule.adapter.a(forumRulesShowActivity, this.Ya);
        this.jrm = forumRulesShowActivity.findViewById(R.id.forum_rules_net_refresh_layout);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View cGr() {
        return this.jrm;
    }

    public void cGs() {
        if (this.jrm != null) {
            this.jrm.setVisibility(0);
        }
    }

    public void cGt() {
        if (this.jrm != null) {
            this.jrm.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jrj != null) {
            this.jrj.setFrom(str);
        }
    }

    public void cGu() {
        if (this.jrj != null) {
            this.jrj.setData(this.mData);
        }
    }

    public void cGv() {
        if (this.Ya != null) {
            this.Ya.setVisibility(0);
        }
    }

    public void cGw() {
        if (this.Ya != null) {
            this.Ya.setVisibility(8);
        }
    }

    public void a(h hVar) {
        this.gzj = hVar;
        hVar.bCB().setOnClickListener(this);
    }

    private void a(NavigationBar navigationBar) {
        this.fJL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.mBackImageView = (ImageView) this.fJL.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.setCenterTextTitle(this.jpo.getResources().getString(R.string.forum_rules_local));
        this.jri = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this);
        this.ahO = (ImageView) this.jri.findViewById(R.id.navigationBarBtnMore);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jrn, this.jrn);
        layoutParams.rightMargin = this.jro;
        this.jri.setLayoutParams(layoutParams);
        SvgManager.bsx().a(this.ahO, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        cGx();
    }

    private void cGx() {
        int i = -1;
        HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
        if (baseSwitchs != null && baseSwitchs.containsKey("is_disable_forumrule_share")) {
            i = baseSwitchs.get("is_disable_forumrule_share").intValue();
        }
        if (i == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
            this.jri.setVisibility(0);
        } else {
            this.jri.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jpo.getPageContext(), i);
        if (this.jrh == i) {
            this.mNavigationBar.getCenterText().setTextSize(R.dimen.L_X06);
            ao.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0611, R.color.CAM_X0611);
            WebPManager.a(this.mBackImageView, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.a(this.ahO, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.jrk.onChangeSkinType(i);
            this.jrl.onChangeSkinType(i);
            this.jrj.onChangeSkinType(i);
            this.jrh = i;
        }
    }

    public void destory() {
        this.jpo = null;
    }

    public void JU(String str) {
        if (this.jrk != null && !StringUtils.isNull(str)) {
            this.jrk.d(this.Ya);
            this.jrk.setTitle(str);
        }
    }

    public void hideTitle() {
        if (this.jrk != null) {
            this.jrk.e(this.Ya);
        }
    }

    public void JV(String str) {
        if (this.jrl != null) {
            this.jrl.b(this.Ya);
            this.jrl.JP(str);
        }
    }

    public void cGy() {
        if (this.jrl != null) {
            this.jrl.c(this.Ya);
        }
    }

    public void addTitle(String str) {
        JU(str);
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
        cGy();
        hideTitle();
    }

    public ViewGroup getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jpo != null) {
            if (view.getId() == R.id.root_pb_more) {
                int i = -1;
                String str = "";
                String str2 = "";
                if (this.mForumRuleDetailData != null && this.mForumRuleDetailData.cFL() != null) {
                    i = this.mForumRuleDetailData.cFL().forum_id.intValue();
                    str2 = this.mForumRuleDetailData.cFL().forum_name;
                }
                if (this.mForumRuleDetailData != null) {
                    str = this.mForumRuleDetailData.getTitle();
                }
                String str3 = "http://tieba.baidu.com/mo/q/wise-bawu-core/forumRuleShare?fid=" + i;
                final ShareItem shareItem = new ShareItem();
                shareItem.title = str;
                shareItem.content = String.format(this.jpo.getResources().getString(R.string.forum_rules_share_text), str2);
                shareItem.linkUrl = str3;
                shareItem.fsR = false;
                if (this.mForumRuleDetailData != null && !StringUtils.isNull(this.mForumRuleDetailData.cFL().avatar)) {
                    shareItem.imageUri = Uri.parse(this.mForumRuleDetailData.cFL().avatar);
                    shareItem.byN();
                }
                shareItem.fsL = str;
                shareItem.fsM = str3;
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.jpo, shareItem, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(c.this.jpo, c.this.jpo.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                this.jpo.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            } else if (view.getId() == R.id.navigationBarGoBack) {
                this.jpo.finish();
            } else if (this.gzj != null && view.getId() == this.gzj.bCB().getId()) {
                this.jpo.cFH();
            }
        }
    }
}

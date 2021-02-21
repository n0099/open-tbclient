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
    private h gCh;
    private ForumRulesShowActivity jvi;
    private int jxb;
    public View jxc;
    private com.baidu.tieba.frs.forumRule.adapter.a jxd;
    private com.baidu.tieba.frs.forumRule.c.b jxe;
    private com.baidu.tieba.frs.forumRule.c.a jxf;
    private View jxg;
    private int jxh;
    private int jxi;
    private ImageView mBackImageView;
    public List<n> mData;
    private com.baidu.tieba.frs.forumRule.b.b mForumRuleDetailData;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public c(ForumRulesShowActivity forumRulesShowActivity, String str) {
        super(forumRulesShowActivity.getPageContext());
        this.jxb = 3;
        this.mData = new ArrayList();
        this.jxh = 0;
        this.jxi = 0;
        this.jvi = forumRulesShowActivity;
        this.mFrom = str;
        forumRulesShowActivity.setContentView(R.layout.activity_forum_rules_show);
        this.jxe = new com.baidu.tieba.frs.forumRule.c.b(forumRulesShowActivity);
        this.jxf = new com.baidu.tieba.frs.forumRule.c.a(forumRulesShowActivity);
        this.jxh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds88);
        this.jxi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        b(forumRulesShowActivity);
    }

    private void b(ForumRulesShowActivity forumRulesShowActivity) {
        this.mRootView = (ViewGroup) forumRulesShowActivity.findViewById(R.id.forum_rule_rootview);
        this.mNavigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.navigationbar);
        a(this.mNavigationBar);
        this.XW = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.forum_rules_list_info);
        this.XW.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
        this.jxd = new com.baidu.tieba.frs.forumRule.adapter.a(forumRulesShowActivity, this.XW);
        this.jxg = forumRulesShowActivity.findViewById(R.id.forum_rules_net_refresh_layout);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View cHL() {
        return this.jxg;
    }

    public void cHM() {
        if (this.jxg != null) {
            this.jxg.setVisibility(0);
        }
    }

    public void cHN() {
        if (this.jxg != null) {
            this.jxg.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jxd != null) {
            this.jxd.setFrom(str);
        }
    }

    public void cHO() {
        if (this.jxd != null) {
            this.jxd.setData(this.mData);
        }
    }

    public void cHP() {
        if (this.XW != null) {
            this.XW.setVisibility(0);
        }
    }

    public void cHQ() {
        if (this.XW != null) {
            this.XW.setVisibility(8);
        }
    }

    public void a(h hVar) {
        this.gCh = hVar;
        hVar.bCT().setOnClickListener(this);
    }

    private void a(NavigationBar navigationBar) {
        this.fLW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.mBackImageView = (ImageView) this.fLW.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.setCenterTextTitle(this.jvi.getResources().getString(R.string.forum_rules_local));
        this.jxc = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this);
        this.ahC = (ImageView) this.jxc.findViewById(R.id.navigationBarBtnMore);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jxh, this.jxh);
        layoutParams.rightMargin = this.jxi;
        this.jxc.setLayoutParams(layoutParams);
        SvgManager.bsR().a(this.ahC, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        cHR();
    }

    private void cHR() {
        int i = -1;
        HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
        if (baseSwitchs != null && baseSwitchs.containsKey("is_disable_forumrule_share")) {
            i = baseSwitchs.get("is_disable_forumrule_share").intValue();
        }
        if (i == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
            this.jxc.setVisibility(0);
        } else {
            this.jxc.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jvi.getPageContext(), i);
        if (this.jxb == i) {
            this.mNavigationBar.getCenterText().setTextSize(R.dimen.L_X06);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0611, R.color.CAM_X0611);
            WebPManager.a(this.mBackImageView, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.a(this.ahC, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.jxe.onChangeSkinType(i);
            this.jxf.onChangeSkinType(i);
            this.jxd.onChangeSkinType(i);
            this.jxb = i;
        }
    }

    public void destory() {
        this.jvi = null;
    }

    public void KG(String str) {
        if (this.jxe != null && !StringUtils.isNull(str)) {
            this.jxe.d(this.XW);
            this.jxe.setTitle(str);
        }
    }

    public void hideTitle() {
        if (this.jxe != null) {
            this.jxe.e(this.XW);
        }
    }

    public void KH(String str) {
        if (this.jxf != null) {
            this.jxf.b(this.XW);
            this.jxf.KB(str);
        }
    }

    public void cHS() {
        if (this.jxf != null) {
            this.jxf.c(this.XW);
        }
    }

    public void addTitle(String str) {
        KG(str);
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
        cHS();
        hideTitle();
    }

    public ViewGroup getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jvi != null) {
            if (view.getId() == R.id.root_pb_more) {
                int i = -1;
                String str = "";
                String str2 = "";
                if (this.mForumRuleDetailData != null && this.mForumRuleDetailData.cHf() != null) {
                    i = this.mForumRuleDetailData.cHf().forum_id.intValue();
                    str2 = this.mForumRuleDetailData.cHf().forum_name;
                }
                if (this.mForumRuleDetailData != null) {
                    str = this.mForumRuleDetailData.getTitle();
                }
                String str3 = "http://tieba.baidu.com/mo/q/wise-bawu-core/forumRuleShare?fid=" + i;
                final ShareItem shareItem = new ShareItem();
                shareItem.title = str;
                shareItem.content = String.format(this.jvi.getResources().getString(R.string.forum_rules_share_text), str2);
                shareItem.linkUrl = str3;
                shareItem.fvj = false;
                if (this.mForumRuleDetailData != null && !StringUtils.isNull(this.mForumRuleDetailData.cHf().avatar)) {
                    shareItem.imageUri = Uri.parse(this.mForumRuleDetailData.cHf().avatar);
                    shareItem.bzf();
                }
                shareItem.fvd = str;
                shareItem.fve = str3;
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.jvi, shareItem, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(c.this.jvi, c.this.jvi.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                this.jvi.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            } else if (view.getId() == R.id.navigationBarGoBack) {
                this.jvi.finish();
            } else if (this.gCh != null && view.getId() == this.gCh.bCT().getId()) {
                this.jvi.cHb();
            }
        }
    }
}

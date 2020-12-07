package com.baidu.tieba.frs.forumRule.view;

import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.q;
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
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.base.c<ForumRulesShowActivity> implements View.OnClickListener {
    private BdTypeRecyclerView Yf;
    private ImageView ahT;
    public View fEN;
    private h gsP;
    private ForumRulesShowActivity jhs;
    private int jjm;
    public View jjn;
    private com.baidu.tieba.frs.forumRule.a.a jjo;
    private com.baidu.tieba.frs.forumRule.d.b jjp;
    private com.baidu.tieba.frs.forumRule.d.a jjq;
    private View jjr;
    private int jjs;
    private int jjt;
    private ImageView mBackImageView;
    public List<q> mData;
    private com.baidu.tieba.frs.forumRule.c.b mForumRuleDetailData;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public c(ForumRulesShowActivity forumRulesShowActivity, String str) {
        super(forumRulesShowActivity.getPageContext());
        this.jjm = 3;
        this.mData = new ArrayList();
        this.jjs = 0;
        this.jjt = 0;
        this.jhs = forumRulesShowActivity;
        this.mFrom = str;
        forumRulesShowActivity.setContentView(R.layout.activity_forum_rules_show);
        this.jjp = new com.baidu.tieba.frs.forumRule.d.b(forumRulesShowActivity);
        this.jjq = new com.baidu.tieba.frs.forumRule.d.a(forumRulesShowActivity);
        this.jjs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds88);
        this.jjt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        b(forumRulesShowActivity);
    }

    private void b(ForumRulesShowActivity forumRulesShowActivity) {
        this.mRootView = (ViewGroup) forumRulesShowActivity.findViewById(R.id.forum_rule_rootview);
        this.mNavigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.navigationbar);
        a(this.mNavigationBar);
        this.Yf = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.forum_rules_list_info);
        this.Yf.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
        this.jjo = new com.baidu.tieba.frs.forumRule.a.a(forumRulesShowActivity, this.Yf);
        this.jjr = forumRulesShowActivity.findViewById(R.id.forum_rules_net_refresh_layout);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View cHi() {
        return this.jjr;
    }

    public void cHj() {
        if (this.jjr != null) {
            this.jjr.setVisibility(0);
        }
    }

    public void cHk() {
        if (this.jjr != null) {
            this.jjr.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jjo != null) {
            this.jjo.setFrom(str);
        }
    }

    public void setData() {
        if (this.jjo != null) {
            this.jjo.setData(this.mData);
        }
    }

    public void cHl() {
        if (this.Yf != null) {
            this.Yf.setVisibility(0);
        }
    }

    public void cHm() {
        if (this.Yf != null) {
            this.Yf.setVisibility(8);
        }
    }

    public void a(h hVar) {
        this.gsP = hVar;
        hVar.bDZ().setOnClickListener(this);
    }

    private void a(NavigationBar navigationBar) {
        this.fEN = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.mBackImageView = (ImageView) this.fEN.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.setCenterTextTitle(this.jhs.getResources().getString(R.string.forum_rules_local));
        this.jjn = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this);
        this.ahT = (ImageView) this.jjn.findViewById(R.id.navigationBarBtnMore);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jjs, this.jjs);
        layoutParams.rightMargin = this.jjt;
        this.jjn.setLayoutParams(layoutParams);
        SvgManager.btW().a(this.ahT, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        cHn();
    }

    private void cHn() {
        int i = -1;
        HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
        if (baseSwitchs != null && baseSwitchs.containsKey("is_disable_forumrule_share")) {
            i = baseSwitchs.get("is_disable_forumrule_share").intValue();
        }
        if (i == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
            this.jjn.setVisibility(0);
        } else {
            this.jjn.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jhs.getPageContext(), i);
        if (this.jjm == i) {
            this.mNavigationBar.getCenterText().setTextSize(R.dimen.L_X06);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0611, R.color.CAM_X0611);
            WebPManager.a(this.mBackImageView, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.a(this.ahT, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.jjp.onChangeSkinType(i);
            this.jjq.onChangeSkinType(i);
            this.jjo.onChangeSkinType(i);
            this.jjm = i;
        }
    }

    public void destory() {
        this.jhs = null;
    }

    public void Lf(String str) {
        if (this.jjp != null && !StringUtils.isNull(str)) {
            this.jjp.d(this.Yf);
            this.jjp.setTitle(str);
        }
    }

    public void hideTitle() {
        if (this.jjp != null) {
            this.jjp.e(this.Yf);
        }
    }

    public void Lg(String str) {
        if (this.jjq != null) {
            this.jjq.b(this.Yf);
            this.jjq.La(str);
        }
    }

    public void cHo() {
        if (this.jjq != null) {
            this.jjq.c(this.Yf);
        }
    }

    public void addTitle(String str) {
        Lf(str);
    }

    public void c(com.baidu.tieba.frs.forumRule.c.b bVar) {
        this.mForumRuleDetailData = bVar;
        this.mData.add(bVar);
    }

    public void dq(List<com.baidu.tieba.frs.forumRule.c.c> list) {
        this.mData.addAll(list);
    }

    public void b(com.baidu.tieba.frs.forumRule.c.a aVar) {
        this.mData.add(aVar);
    }

    public void remove() {
        cHo();
        hideTitle();
    }

    public ViewGroup getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jhs != null) {
            if (view.getId() == R.id.root_pb_more) {
                int i = -1;
                String str = "";
                String str2 = "";
                if (this.mForumRuleDetailData != null && this.mForumRuleDetailData.cGC() != null) {
                    i = this.mForumRuleDetailData.cGC().forum_id.intValue();
                    str2 = this.mForumRuleDetailData.cGC().forum_name;
                }
                if (this.mForumRuleDetailData != null) {
                    str = this.mForumRuleDetailData.getTitle();
                }
                String str3 = "http://tieba.baidu.com/mo/q/wise-bawu-core/forumRuleShare?fid=" + i;
                final ShareItem shareItem = new ShareItem();
                shareItem.title = str;
                shareItem.content = String.format(this.jhs.getResources().getString(R.string.forum_rules_share_text), str2);
                shareItem.linkUrl = str3;
                shareItem.fnQ = false;
                if (this.mForumRuleDetailData != null && !StringUtils.isNull(this.mForumRuleDetailData.cGC().avatar)) {
                    shareItem.imageUri = Uri.parse(this.mForumRuleDetailData.cGC().avatar);
                }
                shareItem.fnK = str;
                shareItem.fnL = str3;
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.jhs, shareItem, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(c.this.jhs, c.this.jhs.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                this.jhs.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            } else if (view.getId() == R.id.navigationBarGoBack) {
                this.jhs.finish();
            } else if (this.gsP != null && view.getId() == this.gsP.bDZ().getId()) {
                this.jhs.cGy();
            }
        }
    }
}

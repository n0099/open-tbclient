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
    private BdTypeRecyclerView Zq;
    private ImageView aiV;
    public View fNw;
    private h gDQ;
    private ForumRulesShowActivity jwR;
    private int jyK;
    public View jyL;
    private com.baidu.tieba.frs.forumRule.adapter.a jyM;
    private com.baidu.tieba.frs.forumRule.c.b jyN;
    private com.baidu.tieba.frs.forumRule.c.a jyO;
    private View jyP;
    private int jyQ;
    private int jyR;
    private ImageView mBackImageView;
    public List<n> mData;
    private com.baidu.tieba.frs.forumRule.b.b mForumRuleDetailData;
    private String mFrom;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public c(ForumRulesShowActivity forumRulesShowActivity, String str) {
        super(forumRulesShowActivity.getPageContext());
        this.jyK = 3;
        this.mData = new ArrayList();
        this.jyQ = 0;
        this.jyR = 0;
        this.jwR = forumRulesShowActivity;
        this.mFrom = str;
        forumRulesShowActivity.setContentView(R.layout.activity_forum_rules_show);
        this.jyN = new com.baidu.tieba.frs.forumRule.c.b(forumRulesShowActivity);
        this.jyO = new com.baidu.tieba.frs.forumRule.c.a(forumRulesShowActivity);
        this.jyQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds88);
        this.jyR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds14);
        b(forumRulesShowActivity);
    }

    private void b(ForumRulesShowActivity forumRulesShowActivity) {
        this.mRootView = (ViewGroup) forumRulesShowActivity.findViewById(R.id.forum_rule_rootview);
        this.mNavigationBar = (NavigationBar) forumRulesShowActivity.findViewById(R.id.navigationbar);
        a(this.mNavigationBar);
        this.Zq = (BdTypeRecyclerView) forumRulesShowActivity.findViewById(R.id.forum_rules_list_info);
        this.Zq.setLayoutManager(new LinearLayoutManager(forumRulesShowActivity));
        this.jyM = new com.baidu.tieba.frs.forumRule.adapter.a(forumRulesShowActivity, this.Zq);
        this.jyP = forumRulesShowActivity.findViewById(R.id.forum_rules_net_refresh_layout);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public View cHR() {
        return this.jyP;
    }

    public void cHS() {
        if (this.jyP != null) {
            this.jyP.setVisibility(0);
        }
    }

    public void cHT() {
        if (this.jyP != null) {
            this.jyP.setVisibility(8);
        }
    }

    public void setFrom(String str) {
        this.mFrom = str;
        if (this.jyM != null) {
            this.jyM.setFrom(str);
        }
    }

    public void cHU() {
        if (this.jyM != null) {
            this.jyM.setData(this.mData);
        }
    }

    public void cHV() {
        if (this.Zq != null) {
            this.Zq.setVisibility(0);
        }
    }

    public void cHW() {
        if (this.Zq != null) {
            this.Zq.setVisibility(8);
        }
    }

    public void a(h hVar) {
        this.gDQ = hVar;
        hVar.bCW().setOnClickListener(this);
    }

    private void a(NavigationBar navigationBar) {
        this.fNw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this);
        this.mBackImageView = (ImageView) this.fNw.findViewById(R.id.widget_navi_back_button);
        this.mNavigationBar.setCenterTextTitle(this.jwR.getResources().getString(R.string.forum_rules_local));
        this.jyL = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this);
        this.aiV = (ImageView) this.jyL.findViewById(R.id.navigationBarBtnMore);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.jyQ, this.jyQ);
        layoutParams.rightMargin = this.jyR;
        this.jyL.setLayoutParams(layoutParams);
        SvgManager.bsU().a(this.aiV, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        cHX();
    }

    private void cHX() {
        int i = -1;
        HashMap<String, Integer> baseSwitchs = SwitchManager.getInstance().getBaseSwitchs();
        if (baseSwitchs != null && baseSwitchs.containsKey("is_disable_forumrule_share")) {
            i = baseSwitchs.get("is_disable_forumrule_share").intValue();
        }
        if (i == 0 && !ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW.equals(this.mFrom)) {
            this.jyL.setVisibility(0);
        } else {
            this.jyL.setVisibility(8);
        }
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.jwR.getPageContext(), i);
        if (this.jyK == i) {
            this.mNavigationBar.getCenterText().setTextSize(R.dimen.L_X06);
            ap.setNavbarTitleColor(this.mNavigationBar.getCenterText(), R.color.CAM_X0611, R.color.CAM_X0611);
            WebPManager.a(this.mBackImageView, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.a(this.aiV, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            this.jyN.onChangeSkinType(i);
            this.jyO.onChangeSkinType(i);
            this.jyM.onChangeSkinType(i);
            this.jyK = i;
        }
    }

    public void destory() {
        this.jwR = null;
    }

    public void KP(String str) {
        if (this.jyN != null && !StringUtils.isNull(str)) {
            this.jyN.d(this.Zq);
            this.jyN.setTitle(str);
        }
    }

    public void hideTitle() {
        if (this.jyN != null) {
            this.jyN.e(this.Zq);
        }
    }

    public void KQ(String str) {
        if (this.jyO != null) {
            this.jyO.b(this.Zq);
            this.jyO.KK(str);
        }
    }

    public void cHY() {
        if (this.jyO != null) {
            this.jyO.c(this.Zq);
        }
    }

    public void addTitle(String str) {
        KP(str);
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
        cHY();
        hideTitle();
    }

    public ViewGroup getRootView() {
        return this.mRootView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jwR != null) {
            if (view.getId() == R.id.root_pb_more) {
                int i = -1;
                String str = "";
                String str2 = "";
                if (this.mForumRuleDetailData != null && this.mForumRuleDetailData.cHl() != null) {
                    i = this.mForumRuleDetailData.cHl().forum_id.intValue();
                    str2 = this.mForumRuleDetailData.cHl().forum_name;
                }
                if (this.mForumRuleDetailData != null) {
                    str = this.mForumRuleDetailData.getTitle();
                }
                String str3 = "http://tieba.baidu.com/mo/q/wise-bawu-core/forumRuleShare?fid=" + i;
                final ShareItem shareItem = new ShareItem();
                shareItem.title = str;
                shareItem.content = String.format(this.jwR.getResources().getString(R.string.forum_rules_share_text), str2);
                shareItem.linkUrl = str3;
                shareItem.fwI = false;
                if (this.mForumRuleDetailData != null && !StringUtils.isNull(this.mForumRuleDetailData.cHl().avatar)) {
                    shareItem.imageUri = Uri.parse(this.mForumRuleDetailData.cHl().avatar);
                    shareItem.bzi();
                }
                shareItem.fwC = str;
                shareItem.fwD = str3;
                ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.jwR, shareItem, true);
                shareDialogConfig.setIsCopyLink(true);
                shareDialogConfig.setCopyLinkListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        com.baidu.adp.lib.util.a.copyToClipboard(shareItem.linkUrl);
                        l.showToast(c.this.jwR, c.this.jwR.getResources().getString(R.string.copy_pb_url_success));
                    }
                });
                this.jwR.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
            } else if (view.getId() == R.id.navigationBarGoBack) {
                this.jwR.finish();
            } else if (this.gDQ != null && view.getId() == this.gDQ.bCW().getId()) {
                this.jwR.cHh();
            }
        }
    }
}

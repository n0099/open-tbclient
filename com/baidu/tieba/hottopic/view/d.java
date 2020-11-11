package com.baidu.tieba.hottopic.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.adapter.l;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.data.k;
import java.util.List;
/* loaded from: classes21.dex */
public class d extends com.baidu.adp.base.c<RelateTopicForumActivity> {
    private BdListView VY;
    private NoNetworkView ghD;
    private PbListView gjo;
    private RelateTopicForumActivity jSN;
    private l jSO;
    private List<RelateForumItemData> jSP;
    private AdapterView.OnItemClickListener jSQ;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.VY = null;
        this.jSP = null;
        this.jSQ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.jSP.get(i)) != null && at.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new aq("c10371").dR("fid", String.valueOf(relateForumItemData.forumId)).al("obj_type", k.jPV).dR("topic_id", d.this.jSN.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.jSN.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.jSN = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.jSP = list.subList(0, 20);
            } else {
                this.jSP = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.jSN.getLayoutMode().setNightMode(i == 1);
        this.jSN.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jSN.getPageContext(), i);
        this.ghD.onChangeSkinType(this.jSN.getPageContext(), i);
        this.gjo.changeSkin(i);
    }

    private void initView() {
        if (this.jSN != null) {
            this.jSN.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.jSN.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.ghD = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.VY = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.jSN.getActivity(), this.VY, BdListViewHelper.HeadType.DEFAULT);
            this.jSO = new l(this.jSN);
            this.gjo = new PbListView(this.jSN.getPageContext().getPageActivity());
            this.gjo.createView();
            this.gjo.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.VY.setAdapter((ListAdapter) this.jSO);
            this.jSO.c(this.jSP, this.jSN.getTopicId());
            this.VY.setOnItemClickListener(this.jSQ);
        }
    }

    public void Wj() {
        if (this.VY != null && this.gjo != null) {
            this.VY.setNextPage(this.gjo);
            this.gjo.endLoadData();
            this.gjo.setText(this.jSN.getResources().getString(R.string.list_no_more));
        }
    }

    public void bPW() {
        if (this.VY != null && this.gjo != null) {
            this.VY.setNextPage(null);
            this.gjo.hideEmptyView();
        }
    }

    public l cNE() {
        return this.jSO;
    }
}

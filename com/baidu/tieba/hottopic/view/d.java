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
import com.baidu.tieba.hottopic.adapter.j;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.data.k;
import java.util.List;
/* loaded from: classes7.dex */
public class d extends com.baidu.adp.base.d<RelateTopicForumActivity> {
    private BdListView WT;
    private NoNetworkView gvm;
    private PbListView gxy;
    private RelateTopicForumActivity kpK;
    private j kpL;
    private List<RelateForumItemData> kpM;
    private AdapterView.OnItemClickListener kpN;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.WT = null;
        this.kpM = null;
        this.kpN = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.kpM.get(i)) != null && at.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new aq("c10371").dW("fid", String.valueOf(relateForumItemData.forumId)).an("obj_type", k.kmS).dW("topic_id", d.this.kpK.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.kpK.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.kpK = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.kpM = list.subList(0, 20);
            } else {
                this.kpM = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.kpK.getLayoutMode().setNightMode(i == 1);
        this.kpK.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kpK.getPageContext(), i);
        this.gvm.onChangeSkinType(this.kpK.getPageContext(), i);
        this.gxy.changeSkin(i);
    }

    private void initView() {
        if (this.kpK != null) {
            this.kpK.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.kpK.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.gvm = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.WT = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.kpK.getActivity(), this.WT, BdListViewHelper.HeadType.DEFAULT);
            this.kpL = new j(this.kpK);
            this.gxy = new PbListView(this.kpK.getPageContext().getPageActivity());
            this.gxy.createView();
            this.gxy.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.WT.setAdapter((ListAdapter) this.kpL);
            this.kpL.c(this.kpM, this.kpK.getTopicId());
            this.WT.setOnItemClickListener(this.kpN);
        }
    }

    public void Vp() {
        if (this.WT != null && this.gxy != null) {
            this.WT.setNextPage(this.gxy);
            this.gxy.endLoadData();
            this.gxy.setText(this.kpK.getResources().getString(R.string.list_no_more));
        }
    }

    public void bRO() {
        if (this.WT != null && this.gxy != null) {
            this.WT.setNextPage(null);
            this.gxy.hideEmptyView();
        }
    }

    public j cRO() {
        return this.kpL;
    }
}

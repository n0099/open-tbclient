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
    private NoNetworkView gbO;
    private PbListView gdy;
    private RelateTopicForumActivity jMQ;
    private l jMR;
    private List<RelateForumItemData> jMS;
    private AdapterView.OnItemClickListener jMT;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.VY = null;
        this.jMS = null;
        this.jMT = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.jMS.get(i)) != null && at.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new aq("c10371").dR("fid", String.valueOf(relateForumItemData.forumId)).aj("obj_type", k.jJX).dR("topic_id", d.this.jMQ.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.jMQ.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.jMQ = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.jMS = list.subList(0, 20);
            } else {
                this.jMS = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.jMQ.getLayoutMode().setNightMode(i == 1);
        this.jMQ.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jMQ.getPageContext(), i);
        this.gbO.onChangeSkinType(this.jMQ.getPageContext(), i);
        this.gdy.changeSkin(i);
    }

    private void initView() {
        if (this.jMQ != null) {
            this.jMQ.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.jMQ.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.gbO = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.VY = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.jMQ.getActivity(), this.VY, BdListViewHelper.HeadType.DEFAULT);
            this.jMR = new l(this.jMQ);
            this.gdy = new PbListView(this.jMQ.getPageContext().getPageActivity());
            this.gdy.createView();
            this.gdy.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.VY.setAdapter((ListAdapter) this.jMR);
            this.jMR.c(this.jMS, this.jMQ.getTopicId());
            this.VY.setOnItemClickListener(this.jMT);
        }
    }

    public void TJ() {
        if (this.VY != null && this.gdy != null) {
            this.VY.setNextPage(this.gdy);
            this.gdy.endLoadData();
            this.gdy.setText(this.jMQ.getResources().getString(R.string.list_no_more));
        }
    }

    public void bNw() {
        if (this.VY != null && this.gdy != null) {
            this.VY.setNextPage(null);
            this.gdy.hideEmptyView();
        }
    }

    public l cLd() {
        return this.jMR;
    }
}

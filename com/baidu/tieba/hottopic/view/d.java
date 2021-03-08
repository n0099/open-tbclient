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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
    private BdListView Yj;
    private PbListView gCf;
    private NoNetworkView gzT;
    private RelateTopicForumActivity kAh;
    private j kAi;
    private List<RelateForumItemData> kAj;
    private AdapterView.OnItemClickListener kAk;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.Yj = null;
        this.kAj = null;
        this.kAk = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.kAj.get(i)) != null && au.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new ar("c10371").dR("fid", String.valueOf(relateForumItemData.forumId)).aq("obj_type", k.kxp).dR("topic_id", d.this.kAh.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.kAh.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.kAh = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.kAj = list.subList(0, 20);
            } else {
                this.kAj = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.kAh.getLayoutMode().setNightMode(i == 1);
        this.kAh.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kAh.getPageContext(), i);
        this.gzT.onChangeSkinType(this.kAh.getPageContext(), i);
        this.gCf.changeSkin(i);
    }

    private void initView() {
        if (this.kAh != null) {
            this.kAh.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.kAh.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.gzT = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.Yj = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.kAh.getActivity(), this.Yj, BdListViewHelper.HeadType.DEFAULT);
            this.kAi = new j(this.kAh);
            this.gCf = new PbListView(this.kAh.getPageContext().getPageActivity());
            this.gCf.createView();
            this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.Yj.setAdapter((ListAdapter) this.kAi);
            this.kAi.setData(this.kAj, this.kAh.getTopicId());
            this.Yj.setOnItemClickListener(this.kAk);
        }
    }

    public void Xb() {
        if (this.Yj != null && this.gCf != null) {
            this.Yj.setNextPage(this.gCf);
            this.gCf.endLoadData();
            this.gCf.setText(this.kAh.getResources().getString(R.string.list_no_more));
        }
    }

    public void bSE() {
        if (this.Yj != null && this.gCf != null) {
            this.Yj.setNextPage(null);
            this.gCf.hideEmptyView();
        }
    }

    public j cUb() {
        return this.kAi;
    }
}

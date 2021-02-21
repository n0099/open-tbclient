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
/* loaded from: classes8.dex */
public class d extends com.baidu.adp.base.d<RelateTopicForumActivity> {
    private BdListView WO;
    private PbListView gAw;
    private NoNetworkView gyk;
    private RelateTopicForumActivity kyf;
    private j kyg;
    private List<RelateForumItemData> kyh;
    private AdapterView.OnItemClickListener kyi;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.WO = null;
        this.kyh = null;
        this.kyi = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.kyh.get(i)) != null && au.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new ar("c10371").dR("fid", String.valueOf(relateForumItemData.forumId)).ap("obj_type", k.kvn).dR("topic_id", d.this.kyf.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.kyf.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.kyf = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.kyh = list.subList(0, 20);
            } else {
                this.kyh = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.kyf.getLayoutMode().setNightMode(i == 1);
        this.kyf.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kyf.getPageContext(), i);
        this.gyk.onChangeSkinType(this.kyf.getPageContext(), i);
        this.gAw.changeSkin(i);
    }

    private void initView() {
        if (this.kyf != null) {
            this.kyf.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.kyf.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.gyk = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.WO = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.kyf.getActivity(), this.WO, BdListViewHelper.HeadType.DEFAULT);
            this.kyg = new j(this.kyf);
            this.gAw = new PbListView(this.kyf.getPageContext().getPageActivity());
            this.gAw.createView();
            this.gAw.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.WO.setAdapter((ListAdapter) this.kyg);
            this.kyg.setData(this.kyh, this.kyf.getTopicId());
            this.WO.setOnItemClickListener(this.kyi);
        }
    }

    public void WY() {
        if (this.WO != null && this.gAw != null) {
            this.WO.setNextPage(this.gAw);
            this.gAw.endLoadData();
            this.gAw.setText(this.kyf.getResources().getString(R.string.list_no_more));
        }
    }

    public void bSy() {
        if (this.WO != null && this.gAw != null) {
            this.WO.setNextPage(null);
            this.gAw.hideEmptyView();
        }
    }

    public j cTU() {
        return this.kyg;
    }
}

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
/* loaded from: classes8.dex */
public class d extends com.baidu.adp.base.d<RelateTopicForumActivity> {
    private BdListView WV;
    private PbListView gCf;
    private NoNetworkView gzT;
    private RelateTopicForumActivity kup;
    private j kuq;
    private List<RelateForumItemData> kur;
    private AdapterView.OnItemClickListener kus;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.WV = null;
        this.kur = null;
        this.kus = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.kur.get(i)) != null && at.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new aq("c10371").dX("fid", String.valueOf(relateForumItemData.forumId)).an("obj_type", k.krx).dX("topic_id", d.this.kup.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.kup.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.kup = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.kur = list.subList(0, 20);
            } else {
                this.kur = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.kup.getLayoutMode().setNightMode(i == 1);
        this.kup.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kup.getPageContext(), i);
        this.gzT.onChangeSkinType(this.kup.getPageContext(), i);
        this.gCf.changeSkin(i);
    }

    private void initView() {
        if (this.kup != null) {
            this.kup.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.kup.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.gzT = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.WV = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.kup.getActivity(), this.WV, BdListViewHelper.HeadType.DEFAULT);
            this.kuq = new j(this.kup);
            this.gCf = new PbListView(this.kup.getPageContext().getPageActivity());
            this.gCf.createView();
            this.gCf.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.WV.setAdapter((ListAdapter) this.kuq);
            this.kuq.c(this.kur, this.kup.getTopicId());
            this.WV.setOnItemClickListener(this.kus);
        }
    }

    public void Zi() {
        if (this.WV != null && this.gCf != null) {
            this.WV.setNextPage(this.gCf);
            this.gCf.endLoadData();
            this.gCf.setText(this.kup.getResources().getString(R.string.list_no_more));
        }
    }

    public void bVG() {
        if (this.WV != null && this.gCf != null) {
            this.WV.setNextPage(null);
            this.gCf.hideEmptyView();
        }
    }

    public j cVG() {
        return this.kuq;
    }
}

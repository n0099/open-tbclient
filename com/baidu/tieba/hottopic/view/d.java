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
    private PbListView gAi;
    private NoNetworkView gxW;
    private RelateTopicForumActivity kxR;
    private j kxS;
    private List<RelateForumItemData> kxT;
    private AdapterView.OnItemClickListener kxU;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.WO = null;
        this.kxT = null;
        this.kxU = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.kxT.get(i)) != null && au.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new ar("c10371").dR("fid", String.valueOf(relateForumItemData.forumId)).ap("obj_type", k.kuZ).dR("topic_id", d.this.kxR.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.kxR.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.kxR = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.kxT = list.subList(0, 20);
            } else {
                this.kxT = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.kxR.getLayoutMode().setNightMode(i == 1);
        this.kxR.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kxR.getPageContext(), i);
        this.gxW.onChangeSkinType(this.kxR.getPageContext(), i);
        this.gAi.changeSkin(i);
    }

    private void initView() {
        if (this.kxR != null) {
            this.kxR.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.kxR.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.gxW = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.WO = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.kxR.getActivity(), this.WO, BdListViewHelper.HeadType.DEFAULT);
            this.kxS = new j(this.kxR);
            this.gAi = new PbListView(this.kxR.getPageContext().getPageActivity());
            this.gAi.createView();
            this.gAi.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.WO.setAdapter((ListAdapter) this.kxS);
            this.kxS.setData(this.kxT, this.kxR.getTopicId());
            this.WO.setOnItemClickListener(this.kxU);
        }
    }

    public void WY() {
        if (this.WO != null && this.gAi != null) {
            this.WO.setNextPage(this.gAi);
            this.gAi.endLoadData();
            this.gAi.setText(this.kxR.getResources().getString(R.string.list_no_more));
        }
    }

    public void bSr() {
        if (this.WO != null && this.gAi != null) {
            this.WO.setNextPage(null);
            this.gAi.hideEmptyView();
        }
    }

    public j cTN() {
        return this.kxS;
    }
}

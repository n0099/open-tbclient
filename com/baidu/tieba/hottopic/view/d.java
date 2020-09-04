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
/* loaded from: classes15.dex */
public class d extends com.baidu.adp.base.c<RelateTopicForumActivity> {
    private BdListView Vo;
    private NoNetworkView fCq;
    private PbListView fEa;
    private RelateTopicForumActivity jcN;
    private l jcO;
    private List<RelateForumItemData> jcP;
    private AdapterView.OnItemClickListener jcQ;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.Vo = null;
        this.jcP = null;
        this.jcQ = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.jcP.get(i)) != null && at.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new aq("c10371").dD("fid", String.valueOf(relateForumItemData.forumId)).ai("obj_type", k.iZU).dD("topic_id", d.this.jcN.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.jcN.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.jcN = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.jcP = list.subList(0, 20);
            } else {
                this.jcP = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.jcN.getLayoutMode().setNightMode(i == 1);
        this.jcN.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jcN.getPageContext(), i);
        this.fCq.onChangeSkinType(this.jcN.getPageContext(), i);
        this.fEa.changeSkin(i);
    }

    private void initView() {
        if (this.jcN != null) {
            this.jcN.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.jcN.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.fCq = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.Vo = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.jcN.getActivity(), this.Vo, BdListViewHelper.HeadType.DEFAULT);
            this.jcO = new l(this.jcN);
            this.fEa = new PbListView(this.jcN.getPageContext().getPageActivity());
            this.fEa.createView();
            this.fEa.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.Vo.setAdapter((ListAdapter) this.jcO);
            this.jcO.b(this.jcP, this.jcN.getTopicId());
            this.Vo.setOnItemClickListener(this.jcQ);
        }
    }

    public void bGT() {
        if (this.Vo != null && this.fEa != null) {
            this.Vo.setNextPage(this.fEa);
            this.fEa.endLoadData();
            this.fEa.setText(this.jcN.getResources().getString(R.string.list_no_more));
        }
    }

    public void bGU() {
        if (this.Vo != null && this.fEa != null) {
            this.Vo.setNextPage(null);
            this.fEa.hideEmptyView();
        }
    }

    public l cAG() {
        return this.jcO;
    }
}

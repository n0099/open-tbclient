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
import com.baidu.tieba.hottopic.adapter.l;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.data.k;
import java.util.List;
/* loaded from: classes20.dex */
public class d extends com.baidu.adp.base.c<RelateTopicForumActivity> {
    private BdListView Wa;
    private NoNetworkView ghk;
    private PbListView giV;
    private AdapterView.OnItemClickListener jTA;
    private RelateTopicForumActivity jTx;
    private l jTy;
    private List<RelateForumItemData> jTz;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.Wa = null;
        this.jTz = null;
        this.jTA = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.jTz.get(i)) != null && au.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new ar("c10371").dR("fid", String.valueOf(relateForumItemData.forumId)).ak("obj_type", k.jQF).dR("topic_id", d.this.jTx.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.jTx.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.jTx = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.jTz = list.subList(0, 20);
            } else {
                this.jTz = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.jTx.getLayoutMode().setNightMode(i == 1);
        this.jTx.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jTx.getPageContext(), i);
        this.ghk.onChangeSkinType(this.jTx.getPageContext(), i);
        this.giV.changeSkin(i);
    }

    private void initView() {
        if (this.jTx != null) {
            this.jTx.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.jTx.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.ghk = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.Wa = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.jTx.getActivity(), this.Wa, BdListViewHelper.HeadType.DEFAULT);
            this.jTy = new l(this.jTx);
            this.giV = new PbListView(this.jTx.getPageContext().getPageActivity());
            this.giV.createView();
            this.giV.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.Wa.setAdapter((ListAdapter) this.jTy);
            this.jTy.c(this.jTz, this.jTx.getTopicId());
            this.Wa.setOnItemClickListener(this.jTA);
        }
    }

    public void VA() {
        if (this.Wa != null && this.giV != null) {
            this.Wa.setNextPage(this.giV);
            this.giV.endLoadData();
            this.giV.setText(this.jTx.getResources().getString(R.string.list_no_more));
        }
    }

    public void bPp() {
        if (this.Wa != null && this.giV != null) {
            this.Wa.setNextPage(null);
            this.giV.hideEmptyView();
        }
    }

    public l cNk() {
        return this.jTy;
    }
}

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
/* loaded from: classes21.dex */
public class d extends com.baidu.adp.base.c<RelateTopicForumActivity> {
    private BdListView WX;
    private NoNetworkView gpw;
    private PbListView grg;
    private RelateTopicForumActivity khd;
    private l khe;
    private List<RelateForumItemData> khf;
    private AdapterView.OnItemClickListener khg;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.WX = null;
        this.khf = null;
        this.khg = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.khf.get(i)) != null && au.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new ar("c10371").dY("fid", String.valueOf(relateForumItemData.forumId)).al("obj_type", k.kek).dY("topic_id", d.this.khd.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.khd.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.khd = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.khf = list.subList(0, 20);
            } else {
                this.khf = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.khd.getLayoutMode().setNightMode(i == 1);
        this.khd.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.khd.getPageContext(), i);
        this.gpw.onChangeSkinType(this.khd.getPageContext(), i);
        this.grg.changeSkin(i);
    }

    private void initView() {
        if (this.khd != null) {
            this.khd.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.khd.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.gpw = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.WX = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.khd.getActivity(), this.WX, BdListViewHelper.HeadType.DEFAULT);
            this.khe = new l(this.khd);
            this.grg = new PbListView(this.khd.getPageContext().getPageActivity());
            this.grg.createView();
            this.grg.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.WX.setAdapter((ListAdapter) this.khe);
            this.khe.c(this.khf, this.khd.getTopicId());
            this.WX.setOnItemClickListener(this.khg);
        }
    }

    public void Ya() {
        if (this.WX != null && this.grg != null) {
            this.WX.setNextPage(this.grg);
            this.grg.endLoadData();
            this.grg.setText(this.khd.getResources().getString(R.string.list_no_more));
        }
    }

    public void bTb() {
        if (this.WX != null && this.grg != null) {
            this.WX.setNextPage(null);
            this.grg.hideEmptyView();
        }
    }

    public l cSz() {
        return this.khe;
    }
}

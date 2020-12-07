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
    private NoNetworkView gpu;
    private PbListView gre;
    private RelateTopicForumActivity khb;
    private l khc;
    private List<RelateForumItemData> khd;
    private AdapterView.OnItemClickListener khe;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.WX = null;
        this.khd = null;
        this.khe = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.khd.get(i)) != null && au.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new ar("c10371").dY("fid", String.valueOf(relateForumItemData.forumId)).al("obj_type", k.kei).dY("topic_id", d.this.khb.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.khb.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.khb = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.khd = list.subList(0, 20);
            } else {
                this.khd = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.khb.getLayoutMode().setNightMode(i == 1);
        this.khb.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.khb.getPageContext(), i);
        this.gpu.onChangeSkinType(this.khb.getPageContext(), i);
        this.gre.changeSkin(i);
    }

    private void initView() {
        if (this.khb != null) {
            this.khb.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.khb.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.gpu = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.WX = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.khb.getActivity(), this.WX, BdListViewHelper.HeadType.DEFAULT);
            this.khc = new l(this.khb);
            this.gre = new PbListView(this.khb.getPageContext().getPageActivity());
            this.gre.createView();
            this.gre.setContainerBackgroundColorResId(R.color.CAM_X0201);
            this.WX.setAdapter((ListAdapter) this.khc);
            this.khc.c(this.khd, this.khb.getTopicId());
            this.WX.setOnItemClickListener(this.khe);
        }
    }

    public void Ya() {
        if (this.WX != null && this.gre != null) {
            this.WX.setNextPage(this.gre);
            this.gre.endLoadData();
            this.gre.setText(this.khb.getResources().getString(R.string.list_no_more));
        }
    }

    public void bTa() {
        if (this.WX != null && this.gre != null) {
            this.WX.setNextPage(null);
            this.gre.hideEmptyView();
        }
    }

    public l cSy() {
        return this.khc;
    }
}

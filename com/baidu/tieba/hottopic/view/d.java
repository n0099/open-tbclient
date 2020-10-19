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
    private BdListView VX;
    private NoNetworkView fRL;
    private PbListView fTv;
    private RelateTopicForumActivity jAr;
    private l jAs;
    private List<RelateForumItemData> jAt;
    private AdapterView.OnItemClickListener jAu;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.VX = null;
        this.jAt = null;
        this.jAu = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.jAt.get(i)) != null && at.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new aq("c10371").dK("fid", String.valueOf(relateForumItemData.forumId)).aj("obj_type", k.jxy).dK("topic_id", d.this.jAr.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.jAr.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.jAr = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.jAt = list.subList(0, 20);
            } else {
                this.jAt = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.jAr.getLayoutMode().setNightMode(i == 1);
        this.jAr.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jAr.getPageContext(), i);
        this.fRL.onChangeSkinType(this.jAr.getPageContext(), i);
        this.fTv.changeSkin(i);
    }

    private void initView() {
        if (this.jAr != null) {
            this.jAr.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.jAr.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.fRL = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.VX = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.jAr.getActivity(), this.VX, BdListViewHelper.HeadType.DEFAULT);
            this.jAs = new l(this.jAr);
            this.fTv = new PbListView(this.jAr.getPageContext().getPageActivity());
            this.fTv.createView();
            this.fTv.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.VX.setAdapter((ListAdapter) this.jAs);
            this.jAs.b(this.jAt, this.jAr.getTopicId());
            this.VX.setOnItemClickListener(this.jAu);
        }
    }

    public void SJ() {
        if (this.VX != null && this.fTv != null) {
            this.VX.setNextPage(this.fTv);
            this.fTv.endLoadData();
            this.fTv.setText(this.jAr.getResources().getString(R.string.list_no_more));
        }
    }

    public void bKU() {
        if (this.VX != null && this.fTv != null) {
            this.VX.setNextPage(null);
            this.fTv.hideEmptyView();
        }
    }

    public l cHW() {
        return this.jAs;
    }
}

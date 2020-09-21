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
/* loaded from: classes20.dex */
public class d extends com.baidu.adp.base.c<RelateTopicForumActivity> {
    private BdListView VG;
    private NoNetworkView fFC;
    private PbListView fHm;
    private RelateTopicForumActivity jlt;
    private l jlu;
    private List<RelateForumItemData> jlv;
    private AdapterView.OnItemClickListener jlw;
    private NavigationBar mNavigationBar;
    private View mRootView;

    public d(RelateTopicForumActivity relateTopicForumActivity, List<RelateForumItemData> list) {
        super(relateTopicForumActivity.getPageContext());
        this.mNavigationBar = null;
        this.mRootView = null;
        this.VG = null;
        this.jlv = null;
        this.jlw = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.hottopic.view.d.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                RelateForumItemData relateForumItemData;
                if (i >= 0 && (relateForumItemData = (RelateForumItemData) d.this.jlv.get(i)) != null && at.isForumName(relateForumItemData.forumName)) {
                    if (relateForumItemData.forumId != 0) {
                        TiebaStatic.log(new aq("c10371").dF("fid", String.valueOf(relateForumItemData.forumId)).ai("obj_type", k.jiA).dF("topic_id", d.this.jlt.getTopicId()));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(d.this.jlt.getActivity()).createNormalCfg(relateForumItemData.forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND)));
                }
            }
        };
        this.jlt = relateTopicForumActivity;
        if (list != null) {
            if (list.size() > 20) {
                this.jlv = list.subList(0, 20);
            } else {
                this.jlv = list;
            }
        }
        initView();
    }

    public void onChangeSkinType(int i) {
        this.jlt.getLayoutMode().setNightMode(i == 1);
        this.jlt.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jlt.getPageContext(), i);
        this.fFC.onChangeSkinType(this.jlt.getPageContext(), i);
        this.fHm.changeSkin(i);
    }

    private void initView() {
        if (this.jlt != null) {
            this.jlt.setContentView(R.layout.hot_topic_more_activity);
            this.mRootView = this.jlt.findViewById(R.id.topic_list_root_view);
            this.mNavigationBar = (NavigationBar) this.mRootView.findViewById(R.id.view_navigation_bar);
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText(R.string.hot_topic_list_navigationbar_title);
            this.fFC = (NoNetworkView) this.mRootView.findViewById(R.id.view_no_network);
            this.VG = (BdListView) this.mRootView.findViewById(R.id.hot_topic_more_list);
            BdListViewHelper.a(this.jlt.getActivity(), this.VG, BdListViewHelper.HeadType.DEFAULT);
            this.jlu = new l(this.jlt);
            this.fHm = new PbListView(this.jlt.getPageContext().getPageActivity());
            this.fHm.createView();
            this.fHm.setContainerBackgroundColorResId(R.color.cp_bg_line_d);
            this.VG.setAdapter((ListAdapter) this.jlu);
            this.jlu.b(this.jlv, this.jlt.getTopicId());
            this.VG.setOnItemClickListener(this.jlw);
        }
    }

    public void bIj() {
        if (this.VG != null && this.fHm != null) {
            this.VG.setNextPage(this.fHm);
            this.fHm.endLoadData();
            this.fHm.setText(this.jlt.getResources().getString(R.string.list_no_more));
        }
    }

    public void bIk() {
        if (this.VG != null && this.fHm != null) {
            this.VG.setNextPage(null);
            this.fHm.hideEmptyView();
        }
    }

    public l cEn() {
        return this.jlu;
    }
}
